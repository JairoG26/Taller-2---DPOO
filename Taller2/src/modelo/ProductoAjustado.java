package modelo;

public class ProductoAjustado implements Producto
{
	
	private String nombre;
	private Integer precio;
	
	public ProductoAjustado(ProductoMenu Base)
	{
		this.nombre = Base.getNombre();
		this.precio = Base.getPrecio();
		
	}
	
	public String getNombre()
	{
		return nombre;
	}

	public Integer getPrecio() 
	{
		return precio;
	}
	
	public String generarTextoFactura()
	{
		String texto = nombre + "____" + precio;
		
		return texto;
	}
}
