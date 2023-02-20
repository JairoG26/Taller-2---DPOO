package modelo;

import java.util.ArrayList;
import java.util.List;

public class Combo implements Producto 
{
	// ATRIBUTOS
	
	private String nombreCombo;
	private List<ProductoMenu> elementos;
	private Double descuento;
	
	// CONSTRUCTORES
	
	public Combo(String nombre, Double elDescuento)
	{
		this.nombreCombo = nombre;
		this.descuento = elDescuento;
		this.elementos = new ArrayList<>();
	}
	
	// MÉTODOS
	
	public void AgregarItemACombo(ProductoMenu ItemCombo)
	{
		elementos.add(ItemCombo);
	}

	public String getNombre() 
	{
		return nombreCombo;
	}

	public Integer getPrecio() 
	{
		Integer precio = 0;
		for(ProductoMenu Item : elementos) 
		{
			Integer valor = Item.getPrecio();
			precio = precio + valor;
		}
		
		precio = (int) (precio - (precio*(descuento/100)));
		
		return precio;
	}
	
	public String generarTextoFactura()
	{
		String texto = nombreCombo + "____" + getPrecio();
		
		return texto;
	}
	
}
