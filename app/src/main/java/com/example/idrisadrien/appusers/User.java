package com.example.idrisadrien.appusers;

/**
 * Created by idrisadrien on 19/10/2017.
 */

public class User {

    private Integer id;
    private String nom;
    private String prenom;
    private String sexe;
    private String metier;
    private String service;
    private String mail;
    private String tel;
    private String resume;

    public User(Integer id, String nom, String prenom, String sexe, String metier, String service, String mail,String tel,String resume){
        this.id =id;
        this.nom=nom;
        this.prenom=prenom;
        this.sexe=sexe;
        this.metier=metier;
        this.service=service;
        this.mail=mail;
        this.tel=tel;
        this.resume=resume;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public String getMetier() {
        return metier;
    }

    public void setMetier(String metier) {
        this.metier = metier;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }


}
