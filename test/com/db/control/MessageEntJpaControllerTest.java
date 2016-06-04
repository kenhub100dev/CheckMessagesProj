/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.db.control;

import com.db.MessageEnt;
import java.util.List;
import javax.persistence.EntityManager;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author kenta_000
 */
public class MessageEntJpaControllerTest {
    
    public MessageEntJpaControllerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getEntityManager method, of class MessageEntJpaController.
     */
    //@Test
    public void testGetEntityManager() {
        System.out.println("getEntityManager");
        MessageEntJpaController instance = new MessageEntJpaController();
        EntityManager expResult = null;
        EntityManager result = instance.getEntityManager();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of create method, of class MessageEntJpaController.
     */
    @Test
    public void testCreate() {
        System.out.println("create");
        MessageEnt messageEnt = new MessageEnt();
        messageEnt.setName("client_bedroom");
        messageEnt.setTopic("bedroom/lamp");
        MessageEntJpaController instance = new MessageEntJpaController();
        instance.create(messageEnt);
     }

    /**
     * Test of edit method, of class MessageEntJpaController.
     */
    //@Test
    public void testEdit() throws Exception {
        System.out.println("edit");
        MessageEnt messageEnt = null;
        MessageEntJpaController instance = new MessageEntJpaController();
        instance.edit(messageEnt);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of destroy method, of class MessageEntJpaController.
     */
    //@Test
    public void testDestroy() throws Exception {
        System.out.println("destroy");
        Long id = null;
        MessageEntJpaController instance = new MessageEntJpaController();
        instance.destroy(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findMessageEntEntities method, of class MessageEntJpaController.
     */
    //@Test
    public void testFindMessageEntEntities_0args() {
        System.out.println("findMessageEntEntities");
        MessageEntJpaController instance = new MessageEntJpaController();
        List<MessageEnt> expResult = null;
        List<MessageEnt> result = instance.findMessageEntEntities();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findMessageEntEntities method, of class MessageEntJpaController.
     */
    //@Test
    public void testFindMessageEntEntities_int_int() {
        System.out.println("findMessageEntEntities");
        int maxResults = 0;
        int firstResult = 0;
        MessageEntJpaController instance = new MessageEntJpaController();
        List<MessageEnt> expResult = null;
        List<MessageEnt> result = instance.findMessageEntEntities(maxResults, firstResult);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findMessageEnt method, of class MessageEntJpaController.
     */
    //@Test
    public void testFindMessageEnt() {
        System.out.println("findMessageEnt");
        Long id = null;
        MessageEntJpaController instance = new MessageEntJpaController();
        MessageEnt expResult = null;
        MessageEnt result = instance.findMessageEnt(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMessageEntCount method, of class MessageEntJpaController.
     */
    //@Test
    public void testGetMessageEntCount() {
        System.out.println("getMessageEntCount");
        MessageEntJpaController instance = new MessageEntJpaController();
        int expResult = 0;
        int result = instance.getMessageEntCount();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
