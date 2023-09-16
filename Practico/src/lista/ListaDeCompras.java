package lista;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import static lista.ListaDeCompras.Opcion.*;
import lista.ListaEnlazadaCompras;
import java.util.Scanner;

public class ListaDeCompras {
	
	public static enum Opcion {
		AGREGAR {
			
			@Override
			public String opcion() {
				return simboloOpcion() + "agregar";
			}
			
			@Override
			public String descripcion() {
				return  opcion() + " <producto>\n" +
					"Agrega un nuevo producto a la lista de compras.";
			}
			
		},
		LISTAR {
			
			@Override
			public String opcion() {
				return simboloOpcion() + "mostrar";
			}
			
			@Override
			public String descripcion() {
				return  opcion() + "\n" +
					"Lista todos los elementos guardados hasta el momento en la lista de compras.";
			}
			
		},
		SALIR {
		
			@Override
			public String opcion() {
				return simboloOpcion() + "salir";
			}
			
			@Override
			public String descripcion() {
				return  opcion() + "\n" +
					"Sale del programa.";
			}
			
		},
		AYUDA {
		
			@Override
			public String opcion() {
				return simboloOpcion() + "ayuda";
			}
			
			@Override
			public String descripcion() {
				return  opcion() + "\n" +
					"Muestra las instrucciones de uso de este programa.";
			}
		
		};
		
		public static String simboloOpcion() {
			return ":";
		}
		
		public abstract String opcion();
		public abstract String descripcion();
	}
	
	public static void main(String[] args) {
		bienvenida();
		try {
			ListaEnlazadaCompras carrito = new ListaEnlazadaCompras();
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			boolean salir = false;
			do {
				String entrada = reader.readLine();
				salir = responderAEntrada(entrada, carrito);
			} while (!salir);
			System.out.println("Se ha salido con éxito del programa.");
			reader.close();

		} catch (IOException e) {
			e.printStackTrace(System.err);
			System.exit(2);
		}
	}
	
	private static boolean responderAEntrada(String entrada, ListaEnlazadaCompras carrito) {
		if (entrada.trim().isEmpty())
			return false;
		String[] args = entrada.split(" ", 2);
		String comando = args[0];
		if (!comando.startsWith(Opcion.simboloOpcion()))
			return false;
		if (comando.compareToIgnoreCase(AGREGAR.opcion()) == 0) {
			if (args.length < 2) {
				System.err.println("El comando " + AGREGAR.opcion() + " espera un argumento especificando el producto a agregar.");
				return false;
			}
			String producto = args[1];
			Scanner entradaCant = new Scanner(System.in);
			System.out.print("Indique la cantidad del producto: ");
			int cantidad = entradaCant.nextInt();
			carrito.agregar(producto, cantidad);
			System.out.println("Se han agregado "+cantidad+" unidades de "+producto+" al carrito.");
			return false;
		} else if (comando.compareToIgnoreCase(LISTAR.opcion()) == 0) {
			System.out.println("Los elementos en el carrito son: "+carrito);
		} else if (comando.compareToIgnoreCase(SALIR.opcion()) == 0) {
			return true;
		} else if (comando.compareToIgnoreCase(AYUDA.opcion()) == 0) {
			System.out.println("ListaDeCompras");
			System.out.println("Una simple aplicación para administrar una lista de compras.\n");
			System.out.println("Modo de uso: ");
			for (Opcion opcion : values()) {
				System.out.println(opcion.descripcion());
			}
			System.out.println();
			return false;
		} else {
			System.err.println("Comando " + comando + " no reconocido.\nUtilice " + AYUDA.opcion() + " para obtener ayuda de como utilizar la aplicación.");
			return false;
		}
		return false;
	}
	
	private static void bienvenida() {
		String mensajeDeInicio = "ListaDeCompras, una simple lista de compras.\n" +
					 "Una simple aplicación para administrar una lista de compras.\n" +
					 "Escriba " + AYUDA.opcion() + " para obtener ayuda de como utilizar la aplicación.\n"
		;
		System.out.println(mensajeDeInicio);
	} 




}
