/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.db.control;

import com.db.MessageEnt;
import com.db.control.exceptions.NonexistentEntityException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author kenta_000
 */
public class MessageEntJpaController implements Serializable {

    public MessageEntJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public MessageEntJpaController() {
        this.emf = Persistence.createEntityManagerFactory("CheckMessagesProjPU");
    }
    
    

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(MessageEnt messageEnt) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(messageEnt);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(MessageEnt messageEnt) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            messageEnt = em.merge(messageEnt);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = messageEnt.getId();
                if (findMessageEnt(id) == null) {
                    throw new NonexistentEntityException("The messageEnt with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Long id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            MessageEnt messageEnt;
            try {
                messageEnt = em.getReference(MessageEnt.class, id);
                messageEnt.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The messageEnt with id " + id + " no longer exists.", enfe);
            }
            em.remove(messageEnt);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<MessageEnt> findMessageEntEntities() {
        return findMessageEntEntities(true, -1, -1);
    }

    public List<MessageEnt> findMessageEntEntities(int maxResults, int firstResult) {
        return findMessageEntEntities(false, maxResults, firstResult);
    }

    private List<MessageEnt> findMessageEntEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(MessageEnt.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public MessageEnt findMessageEnt(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(MessageEnt.class, id);
        } finally {
            em.close();
        }
    }

    public int getMessageEntCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<MessageEnt> rt = cq.from(MessageEnt.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
