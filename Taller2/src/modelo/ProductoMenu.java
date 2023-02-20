package modelo;

public class ProductoMenu implements Producto
{
	// ATRIBUTOS
	
	private String nombre;
	private Integer precioBase;
	
	// CONSTRUCTORES
	
	public ProductoMenu(String elNombre, Integer elPrecio)
	{
		this.nombre = elNombre;
		this.precioBase = elPrecio;
	}
	
	// MÉTODOS
	
	public String getNombre() 
	{
		return nombre;
	}

	public Integer getPrecio() 
	{
		return precioBase;
	}
	
	public String generarTextoFactura()
	{
		String texto = nombre + "____" + precioBase;
		
		return texto;
	}
	
}
