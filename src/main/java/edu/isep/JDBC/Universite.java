package edu.isep.JDBC;

public class Universite {
	private long id;
	private String nomuniv;
	private String lienuniv;

	public Universite(){	
	}

	public Universite(int id, String nomuniv, String lienuniv){
		super();
		this.id=id;
		this.nomuniv=nomuniv;
		this.lienuniv=lienuniv;
	}

	public Universite(String nomuniv, String lienuniv){
		super();
		this.nomuniv=nomuniv;
		this.lienuniv=lienuniv;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNomuniv() {
		return nomuniv;
	}

	public void setNomuniv(String nomuniv) {
		this.nomuniv = nomuniv;
	}

	public String getLienuniv() {
		return lienuniv;
	}

	public void setLienuniv(String lienuniv) {
		this.lienuniv = lienuniv;
	}

}
