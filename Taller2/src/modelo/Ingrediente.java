package modelo;

public class Ingrediente 
{
	// ATRIBUTOS
	
	private String nombre;
	private Integer costoAdicional;
	
	// CONSTRUCTORES
	
	public Ingrediente(String elNombre, Integer elCosto)
	{
		this.nombre = elNombre;
		this.costoAdicional = elCosto;
	}
	
	// MÉTODOS

	public String getNombre() 
	{
		return nombre;
	}

	public Integer getCostoAdicional() 
	{
		return costoAdicional;
	}
	
	
}
