package edu.isep.JDBC;

public class Module {

	private long id;
	private String nomuniv;
	private String description;
	private long userId;
	private String lien;
	private String statut;
	private String commentaire;
	private long idparcours;

	public String getStatut() {
		return statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}

	public long getUserId() {
		return userId;
	}
	
	public String getNomuniv() {
		return nomuniv;
	}

	public void setNomuniv(String nomuniv) {
		this.nomuniv = nomuniv;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLien() {
		return lien;
	}

	public void setLien(String lien) {
		this.lien = lien;
	}

	public String getCommentaire() {
		return commentaire;
	}

	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}
	
	public long getIdparcours() {
		return idparcours;
	}

	public void setIdparcours(long idparcours) {
		this.idparcours = idparcours;
	}

	public Module(){	
	}

	public Module(long id, String nomuniv, String description, String lien, String statut, String commentaire, long userId, long idparcours){
		super();
		this.id=id;
		this.nomuniv=nomuniv;
		this.description=description;
		this.lien=lien;
		this.statut=statut;
		this.commentaire=commentaire;
		this.userId=userId;
		this.idparcours=idparcours;
	}

	public Module(String nomuniv, String description, String lien, String statut, String commentaire, long userId, long idparcours){
		super();
		this.nomuniv=nomuniv;
		this.description=description;
		this.lien=lien;
		this.statut=statut;
		this.commentaire=commentaire;
		this.userId=userId;
		this.idparcours=idparcours;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public String toString()
	{
		return "id = " + id + " nomuniv = " + nomuniv + " description = " + description + " userId = " + userId + " lien = " + lien +" statut = " + statut +"commentaire = " + commentaire;
	}

}
