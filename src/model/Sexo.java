package model;

public enum Sexo {

	MASCULINO(0, "Masculino"), FEMININO(1, "Feminino");
	
	private int id;
	private String label;

	
	private Sexo(int id, String label) {
		
		this.id = id;
		this.label= label;
		
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getLabel() {
		return label;
	}


	public void setLabel(String label) {
		this.label = label;
	}
	
/*//pega o string(minusculo)
	@Override
	public String toString() {
		
		return label;
	}*/
	
}
