package com.revature.p2.beans;

//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;


//@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Entity
@Table(name="characters")
public class Character {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String charactername;
    private Integer health;
    private Integer ac;//chance of getting hit


    public Character(){}

    public Character(String charactername, Integer health, Integer ac) {
        this.charactername = charactername;
        this.health = health;
        this.ac = ac;
    }

    public Character(Integer id, String charactername, Integer health, Integer ac) {
        this.id = id;
        this.charactername = charactername;
        this.health = health;
        this.ac = ac;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCharactername() {
        return charactername;
    }

    public void setCharactername(String charactername) {
        this.charactername = charactername;
    }

    public Integer getHealth() {
        return health;
    }

    public void setHealth(Integer health) {
        this.health = health;
    }

    public Integer getAc() {
        return ac;
    }

    public void setAc(Integer ac) {
        this.ac = ac;
    }

    @Override
    public String toString() {
        return "Character{" +
                "id=" + id +
                ", charactername='" + charactername + '\'' +
                ", health=" + health +
                ", ac=" + ac +
                '}';
    }
}
