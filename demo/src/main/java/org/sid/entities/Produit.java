package org.sid.entities;

import com.sun.istack.NotNull;
import org.hibernate.annotations.BatchSize;
import org.springframework.lang.NonNull;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
@Entity
public class Produit implements Serializable {
    @Id @GeneratedValue
    private Long id;
    @NotNull
    private String designation;

    private double prix;
    private int quantiter;
    public Produit() {
        super();
        // TODO Auto-generated constructor stub
    }
    public Produit(String designation, double prix, int quantiter) {
        this.designation = designation;
        this.prix = prix;
        this.quantiter = quantiter;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getDesignation() {
        return designation;
    }
    public void setDesignation(String designation) {
        this.designation = designation;
    }
    public double getPrix() {
        return prix;
    }
    public void setPrix(double prix) {
        this.prix = prix;
    }
    public int getQuantiter() {
        return quantiter;
    }
    public void setQuantiter(int quantiter) {
        this.quantiter = quantiter;
    }


}
