package consola;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import Procesamiento.Restaurante;
import modelo.Ingrediente;
import modelo.ProductoMenu;

public class Aplicación 
{
	private Restaurante restaurante;

	public static void main(String[] args) throws IOException 
	{
		Aplicación app = new Aplicación();
		app.MostrarMenu();
	}
	
	public void MostrarMenu() throws IOException
	{
		System.out.println("Bienvenidos al restaurante de hamburguesas de nombre desconocido!!");
		System.out.println("\nOpciones de la aplicación\n");
		System.out.println("1. Comenzar un pedido");
		System.out.println("2. Salir de la aplicación");
		int seleccion1 = Integer.parseInt(input("Ingrese una opción"));
		
		if (seleccion1 == 1)
		{
			String nombre = input("Ingrese su nombre");
			String direccion = input("Ingrese su dirección");
			restaurante.iniciarPedido(nombre, direccion);
			restaurante.CargarInformacionRestaurante("data/ingredientes.txt", "data/menu.txt", "data/combos.txt");
			
			ArrayList<ProductoMenu> menu = restaurante.getMenuBase();
			ArrayList<Ingrediente> ingredientes = restaurante.getIngredientes();
			
			System.out.println("Producto - Precio");
			for (ProductoMenu producto: menu)
			{
				String nombreProducto = producto.getNombre();
				int precio = producto.getPrecio();
				System.out.println(nombreProducto+ "-"+precio);
			}
			
		}
	}
	
	public String input(String mensaje)
	{
		try
		{
			System.out.print(mensaje + ": ");
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			return reader.readLine();
		}
		catch (IOException e)
		{
			System.out.println("Error leyendo de la consola");
			e.printStackTrace();
		}
		return null;
	}
	
}
