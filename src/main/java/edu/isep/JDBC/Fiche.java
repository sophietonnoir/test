package edu.isep.JDBC;

public class Fiche {	

	private long id;
	private String numsalle;
	private String photo;
	private String CV;
	private String lettremotiv;
	private String adresse;
	private String actextra;
	private String competences;
	private String notes;
	private String cursus;
	private String apprenti;
	private String etape;
	private String promotion;
	private String statut;
	private long userId;
        public String test;

	public Fiche(){	
	}
	
	public Fiche(int id, String numsalle, String photo, String CV, String lettremotiv, String adresse, String actextra, String competences, String notes,String cursus, String apprenti,String etape,String promotion,String statut, long userId){
		super();
		this.id=id;
		this.numsalle=numsalle;
		this.photo=photo;
		this.CV=CV;
		this.lettremotiv=lettremotiv;
		this.adresse=adresse;
		this.actextra=actextra;
		this.competences=competences;
		this.notes=notes;
		this.cursus=cursus;
		this.apprenti=apprenti;
		this.etape=etape;
		this.promotion=promotion;
		this.statut=statut;
		this.userId=userId;
		
	}

	public Fiche( String numsalle, String photo, String CV, String lettremotiv, String adresse, String actextra, String competences, String notes,String cursus, String apprenti,String etape,String promotion,String statut, long userId){
		super();
		this.numsalle=numsalle;
		this.photo=photo;
		this.CV=CV;
		this.lettremotiv=lettremotiv;
		this.adresse=adresse;
		this.actextra=actextra;
		this.competences=competences;
		this.notes=notes;
		this.cursus=cursus;
		this.apprenti=apprenti;
		this.etape=etape;
		this.promotion=promotion;
		this.statut=statut;
		this.userId=userId;

	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNumsalle() {
		return numsalle;
	}

	public void setNumsalle(String numsalle) {
		this.numsalle = numsalle;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getCV() {
		return CV;
	}

	public void setCV(String cV) {
		CV = cV;
	}

	public String getLettremotiv() {
		return lettremotiv;
	}

	public void setLettremotiv(String lettremotiv) {
		this.lettremotiv = lettremotiv;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getActextra() {
		return actextra;
	}

	public void setActextra(String actextra) {
		this.actextra = actextra;
	}

	public String getCompetences() {
		return competences;
	}

	public void setCompetences(String competences) {
		this.competences = competences;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public String getCursus() {
		return cursus;
	}

	public void setCursus(String cursus) {
		this.cursus = cursus;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getApprenti() {
		return apprenti;
	}

	public void setApprenti(String apprenti) {
		this.apprenti = apprenti;
	}

	public String getEtape() {
		return etape;
	}

	public void setEtape(String etape) {
		this.etape = etape;
	}

	public void setPromotion(String promotion) {
		this.promotion = promotion;
	}

	public String getPromotion() {
		return promotion;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}


	public String getStatut() {
		return statut;
	}



}
