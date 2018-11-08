package model;

public enum Meses {

	JANEIRO(0, "Janeiro"), FEVEREIRO(1, "Fevereiro"), MARÇO(2, "Março"), ABRIL(3,"Abril"), MAIO(4,"Maio"), JUNHO(5,"Junho"), JULHO(6,"Julho"),
	AGOSTO(7,"Agosto"),SETEMBRO(8,"Setembro"), OUTUBRO(9,"Outubro"), NOVEMBRO(10,"Novembro"), DEZEMBRO(11,"Dezembro");
	
	private int id;
	private String label;

	
	private Meses(int id, String label) {
		
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

	

