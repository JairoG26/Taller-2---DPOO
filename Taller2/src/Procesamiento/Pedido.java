package Procesamiento;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import modelo.Producto;

public class Pedido 
{
	// ATRIBUTOS
	private Integer numPedidos;
	
	private Integer IDPedido;
	
	private String nombreCliente;
	
	private String direccionCliente;
	
	private List<Producto> productos;
	
	// CONSTRUCTOR
	
	public Pedido(String Nombre, String Direccion)
	{
		this.nombreCliente = Nombre;
		this.direccionCliente = Direccion;
		this.numPedidos ++;
		this.IDPedido = 20230000+numPedidos;
	}
	
	// MÉTODOS
	
	public void agregarProducto(Producto nuevoItem)
	{
		productos.add(nuevoItem);
	}
	
	private Integer getPrecioNetoPedido()
	{
		int precioNeto = 0;
		
		for(Producto producto: productos)
		{
			int valor = producto.getPrecio();
			precioNeto = precioNeto + valor;
		}
		
		return precioNeto;
	}
	
	private int getPrecioIVAPedido()
	{
		int IVA = (int) (getPrecioNetoPedido()*(0.19));
		
		return IVA;
	}
	
	private int getPrecioTotalPedido()
	{
		int total = getPrecioIVAPedido() + getPrecioNetoPedido();
		
		return total;
	}
	
	private String generarTextoFactura()
	{
		String texto = "Cliente: "+ nombreCliente+"\nDireccion: "+direccionCliente+"\nIDPedido: "+IDPedido+"\n";
		for(Producto producto: productos)
		{
			String valor = producto.generarTextoFactura();
			texto = texto + valor+"\n";
		}
		texto = texto + "Neto___"+getPrecioNetoPedido()+"\nIVA___"+getPrecioIVAPedido()+"\nTotal___"+getPrecioTotalPedido()+"/";
		return texto;
	}
	
	public void guardarFactura(String archivo) throws IOException
	{
		BufferedWriter bw = new BufferedWriter(new FileWriter(archivo));
		
		bw.write(generarTextoFactura());
		
		bw.close();
	}


	
	
}
