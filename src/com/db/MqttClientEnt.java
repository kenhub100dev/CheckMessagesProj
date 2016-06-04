/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.db;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author kenta_000
 */
@Entity
public class MqttClientEnt implements Serializable {

    private static long serialVersionUID = 1L;

    /**
     * @return the serialVersionUID
     */
    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    /**
     * @param aSerialVersionUID the serialVersionUID to set
     */
    public static void setSerialVersionUID(long aSerialVersionUID) {
        serialVersionUID = aSerialVersionUID;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    
    private String name;
    
    private Integer age;
    
    private String note;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "id")
    private ArrayList<MessageEnt> ments;

    public MqttClientEnt() {
    }

    public MqttClientEnt(Long id, String name, Integer age, String note, ArrayList<MessageEnt> ments) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.note = note;
        this.ments = ments;
    }
    
    
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the age
     */
    public Integer getAge() {
        return age;
    }

    /**
     * @param age the age to set
     */
    public void setAge(Integer age) {
        this.age = age;
    }

    /**
     * @return the note
     */
    public String getNote() {
        return note;
    }

    /**
     * @param note the note to set
     */
    public void setNote(String note) {
        this.note = note;
    }

    /**
     * @return the ments
     */
    public ArrayList<MessageEnt> getMents() {
        return ments;
    }

    /**
     * @param ments the ments to set
     */
    public void setMents(ArrayList<MessageEnt> ments) {
        this.ments = ments;
    }

    @Override
    public String toString() {
        return "MqttClientEnt{" + "id=" + id + ", name=" + name + ", age=" + age + ", note=" + note + ", ments=" + ments + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.id);
        hash = 53 * hash + Objects.hashCode(this.name);
        hash = 53 * hash + Objects.hashCode(this.age);
        hash = 53 * hash + Objects.hashCode(this.note);
        hash = 53 * hash + Objects.hashCode(this.ments);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final MqttClientEnt other = (MqttClientEnt) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.note, other.note)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.age, other.age)) {
            return false;
        }
        if (!Objects.equals(this.ments, other.ments)) {
            return false;
        }
        return true;
    }
    
    
    


    
}
