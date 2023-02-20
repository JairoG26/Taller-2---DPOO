package Procesamiento;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import modelo.Combo;
import modelo.Ingrediente;
import modelo.ProductoMenu;

public class Restaurante 
{
	private HashMap<String, Ingrediente> ingredientes;
	private ArrayList<Ingrediente> lingredientes;
	
	private HashMap<String, ProductoMenu> menuBase;
	private ArrayList<ProductoMenu> lmenuBase;
	
	private HashMap<String, Combo> combos;
	private ArrayList<Combo> lcombos;
	
	private Pedido pedido;
	
	public Restaurante() 
	{
		
	}
	
	public void CargarInformacionRestaurante(String archIngredientes, String archCombos, String archMenu) throws IOException
	{
		cargarIngredientes(archIngredientes);
		cargarMenu(archMenu);
		cargarCombos(archCombos);
	}

	private void cargarCombos(String archCombos) throws IOException 
	{	
		HashMap<String, Combo> combos1 = new HashMap<>();
		ArrayList<Combo> lcombos1 = new ArrayList<>();
		BufferedReader br = new BufferedReader(new FileReader(archCombos));
		String linea = br.readLine();
		
		linea = br.readLine();
		while (linea != null)
		{
			String[] partes = linea.split(";");
			String nombreCombo = partes[0];
			String sdescuento = (partes[1].replace("%", ""));
			Double descuento = Double.parseDouble(sdescuento);
			String sProducto1 = partes[2];
			ProductoMenu producto1 = menuBase.get(sProducto1);
			String sProducto2 = partes[3];
			ProductoMenu producto2 = menuBase.get(sProducto2);
			String sProducto3 = partes[4];
			ProductoMenu producto3 = menuBase.get(sProducto3);
			
			Combo combo = combos.get(nombreCombo);
			if (combo == null)
			{
				combo = new Combo(nombreCombo, descuento);
				if (producto1 != null)
				{
					combo.AgregarItemACombo(producto1);
				}
				if (producto2 != null)
				{
					combo.AgregarItemACombo(producto2);
				}
				if (producto3 != null)
				{
					combo.AgregarItemACombo(producto3);
				}
				combos1.put(nombreCombo, combo);
				this.combos = combos1;
				lcombos1.add(combo);
				this.lcombos = lcombos1;
			}
			linea = br.readLine();
		}
		br.close();
	}

	private void cargarMenu(String archMenu) throws IOException 
	{
		HashMap<String, ProductoMenu> menubase1 = new HashMap<>();
		ArrayList<ProductoMenu> lmenubase1 = new ArrayList<>();
		BufferedReader br = new BufferedReader(new FileReader(archMenu));
		String linea = br.readLine();
		
		linea = br.readLine();
		while (linea != null)
		{
			String[] partes = linea.split(";");
			String nombreProducto = partes[0];
			int precio = Integer.parseInt(partes[1]);
			
			ProductoMenu producto = menubase1.get(nombreProducto);
			if (producto == null)
			{
				producto = new ProductoMenu(nombreProducto, precio);
				menubase1.put(nombreProducto, producto);
				this.menuBase = menubase1;
				lmenubase1.add(producto);
				this.lmenuBase = lmenubase1;
			}
			linea = br.readLine();
		}
		br.close();
	}

	private void cargarIngredientes(String archIngredientes) throws IOException 
	{
		HashMap<String, Ingrediente> ingredientes1 = new HashMap<>();
		ArrayList<Ingrediente> lingredientes1 = new ArrayList<>();
		
		BufferedReader br = new BufferedReader(new FileReader(archIngredientes));
		String linea = br.readLine();
		
		linea = br.readLine();
		while (linea != null)
		{
			String[] partes = linea.split(";");
			String nombreIngrediente = partes[0];
			int precio = Integer.parseInt(partes[1]);
			
			Ingrediente ingrediente = ingredientes1.get(nombreIngrediente);
			if (ingrediente == null)
			{
				ingrediente = new Ingrediente(nombreIngrediente, precio);
				ingredientes1.put(nombreIngrediente, ingrediente);
				this.ingredientes = ingredientes1;
				lingredientes1.add(ingrediente);
				this.lingredientes = lingredientes1;
			}
			linea = br.readLine();
		}
		br.close();
		
	}
	
	public ArrayList<ProductoMenu> getMenuBase()
	{
		return lmenuBase;
	}
	
	public ArrayList<Ingrediente> getIngredientes()
	{
		return lingredientes;
	}
	
	public void iniciarPedido(String nombreCliente, String direccionCliente)
	{
		Pedido pedido1 = new Pedido(nombreCliente, direccionCliente);
		this.pedido = pedido1;
	}
	
	public Pedido getPedidoEnCurso()
	{
		return pedido;
	}
	
	
	public void cerrarYGuardarPedido() throws IOException
	{
		pedido.guardarFactura("data/facturas");
	}
	
	
}
