package Beans;

import java.time.LocalDate;

/**
 *
 * @author Alice
 */
public class Utilisateur {
    private int id_utilisateur;
    private String email;
    private String motDePasse;
    private String nom;
    private String prenom;
    private String num_tel;
    private LocalDate date_inscription;

    public Utilisateur() {
        
    }

    public Utilisateur(int id_utilisateur, String email, String motDePasse, String nom, String prenom, String num_tel, LocalDate date_inscription) {
        this.id_utilisateur = id_utilisateur;
        this.email = email;
        this.motDePasse = motDePasse;
        this.nom = nom;
        this.prenom = prenom;
        this.num_tel = num_tel;
        this.date_inscription = date_inscription;
    }

    public Utilisateur(String email, String motDePasse, String nom, String prenom, String num_tel, LocalDate date_inscription) {
        this.email = email;
        this.motDePasse = motDePasse;
        this.nom = nom;
        this.prenom = prenom;
        this.num_tel = num_tel;
        this.date_inscription = date_inscription;
    }
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getId_utilisateur() {
        return id_utilisateur;
    }

    public void setId_utilisateur(int id_utilisateur) {
        this.id_utilisateur = id_utilisateur;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNum_tel() {
        return num_tel;
    }

    public void setNum_tel(String num_tel) {
        this.num_tel = num_tel;
    }

    public LocalDate getDate_inscription() {
        return date_inscription;
    }

    public void setDate_inscription(LocalDate date_inscription) {
        this.date_inscription = date_inscription;
    }  
    
}
