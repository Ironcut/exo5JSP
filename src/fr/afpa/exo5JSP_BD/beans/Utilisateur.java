package fr.afpa.exo5JSP_BD.beans;

public class Utilisateur {
	
	String id;
	String prenom;
	String nom;
	String mp;
	
	
	public Utilisateur() {
		super();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getMp() {
		return mp;
	}

	public void setMp(String mp) {
		this.mp = mp;
	}
	
	
	
	
}
