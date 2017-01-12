package edu.isep.JDBC;

import java.io.Serializable;

public class User implements Serializable{

	private static final long serialVersionUID = 1L;
	private long userId;
	private String nom;
	private String nomFamille;
	private String prenom;
	private String employeeType; 
	private String employeeNumber;
	private String login;
	private String password;
	private String mail;
	private long idParcours;

	public User(String login, String password, String nom, String nomFamille, String prenom, String type, String numero, String mail)
	{
		super();
		this.nom = nom;
		this.nomFamille = nomFamille;
		this.prenom = prenom;
		this.employeeType = type;
		this.employeeNumber = numero;
		this.login = login;
		this.password = password;
		this.mail = mail;
	}
	public User(String login, String password, String nom, String nomFamille, String prenom, String type, String numero, String mail,long idParcours)
	{
		super();
		this.nom = nom;
		this.nomFamille = nomFamille;
		this.prenom = prenom;
		this.employeeType = type;
		this.employeeNumber = numero;
		this.login = login;
		this.password = password;
		this.mail = mail;
		this.idParcours = idParcours;
	}

	public User(int userId, String login, String password, String nom, String nomFamille, String prenom, String type, String numero, String mail,long idParcours)
	{
		super();
		this.userId=userId;
		this.nom = nom;
		this.nomFamille = nomFamille;
		this.prenom = prenom;
		this.employeeType = type;
		this.employeeNumber = numero;
		this.login = login;
		this.password = password;
		this.mail = mail;
		this.idParcours = idParcours;
	}

	public long getId() {
		return userId;
	}

	public void setId(long id) {
		this.userId = id;
	}

	public User() {
		super();
	}

	public String getNom()
	{
		return nom;
	}
	public void setNom(String nom)
	{
		this.nom = nom;
	}

	public String getLogin()
	{
		return login;
	}
	public String getType()
	{
		return employeeType;
	}
	public String getNumber()
	{
		return employeeNumber;
	}

	public String getMail() {
		return mail;
	}

	public String getPassword() {
		return password;
	}
	public String toString()
	{
		return "userId = " + userId + " login = " + login + " nom = " + nom + " type = " + employeeType + " id = " + employeeNumber +" idParcours = " + idParcours;
	}

	public String getNomFamille() {
		return nomFamille;
	}

	public void setNomFamille(String nomFamille) {
		this.nomFamille = nomFamille;
	}

	public String getPrenom() {
		return prenom;
	}
	public long getIdParcours() {
		return idParcours;
	}
	public void  setIdParcours(long id) {
		this.idParcours=id;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
}
