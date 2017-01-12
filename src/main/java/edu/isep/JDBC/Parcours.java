package edu.isep.JDBC;

public class Parcours {


	private long id;
	private String nomparcours;
	private String description;

	public Parcours(){	
	}

	public Parcours(int id, String nomparcours, String description){
		super();
		this.id=id;
		this.nomparcours=nomparcours;
		this.description=description;
	}

	public Parcours(String nomparcours, String description){
		super();
		this.nomparcours=nomparcours;
		this.description=description;
	}
	
	public String toString()
	{
		return "nomparcours = " + nomparcours + " description = " + description  ;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNomparcours() {
		return nomparcours;
	}

	public void setNomparcours(String nomparcours) {
		this.nomparcours = nomparcours;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
