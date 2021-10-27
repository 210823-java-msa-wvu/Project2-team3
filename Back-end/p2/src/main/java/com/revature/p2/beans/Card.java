package com.revature.p2.beans;

import javax.persistence.*;


@Entity
@Table(name="\"RevatureP2\".cards")
public class Card {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    private String cardname;
    private String description;

    public Card() {}

    public Card(String cardname, String description) {
        this.cardname = cardname;
        this.description = description;
    }

    public Card(Integer id, String cardname, String description) {
        this.id = id;
        this.cardname = cardname;
        this.description = description;
    }
    //random comment
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCardname() {
        return cardname;
    }

    public void setCardname(String cardname) {
        this.cardname = cardname;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Card{" +
                "id=" + id +
                ", cardname='" + cardname + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
