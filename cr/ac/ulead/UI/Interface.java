package cr.ac.ulead.UI;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import cr.ac.ulead.Logic.Persona;
import cr.ac.ulead.Principal.Tree;

public class Interface {
	Scanner input = new Scanner(System.in);
	Tree arbol = new Tree();
	ArrayList<Persona> lista = new ArrayList<>();

	public void Options() throws IOException {
		switch (input.nextInt()) {
		case 1:
			CreatePerson();
			Options();
			break;
		case 2:
			CargarDatos();
			arbol.displayTree();
			ShowMenu();
			break;
		default:
			System.out.println("Gracias por participar!!");
		}

	}

	public void Menu() throws IOException {
		System.out.println("BIENVENIDO AL ARBOL DE PERSONAS!");
		System.out.println("Para empezar el programa debe agregar una nueva persona");
		System.out.println("**Cada persona se guardara en un archivo TXT");
		System.out.println("------------------------------------------------------------");
		System.out.println("1. Para agregar una nueva persona");
		System.out.println("3. SALIR ");
		Options();
	}

	public void ShowMenu() throws IOException {

		System.out.println("3. Imprimir un árbol en IN-ORDER");
		System.out.println("4. Imprimir un árbol en PRE-ORDER ");
		System.out.println("5. Imprimir un árbol en POST-ORDER ");
		System.out.println("6. VOLVER AL MENU ANTERIOR ");
		System.out.println("7. SALIR");
		arbol.traverse(input.nextInt());

	}

	private void CreatePerson() throws IOException {
		System.out.println(
				"Por favor Ingrese en el siguiente formato: NOMBRE,APELLIDO,FECHA DE NACIMIENTO(DD/MM/YYYY),CEDULA(9DIGITOS)");
		String texto = input.next();
		File file = new File("C:\\Users\\SolanllyBarkerVargas\\eclipse-workspace\\BinaryTree1\\src\\information.txt");
		FileWriter fw = new FileWriter(file, true);
		BufferedWriter bw = new BufferedWriter(fw);

		for (int i = 0; i < 1; i++) {
			bw.write(texto);
			bw.newLine();
		}
		bw.close();
		fw.close();
		System.out.println("PERSONA CREADA");
		System.out.println("****************************************");
		System.out.print("\n");
		System.out.println("Crear una nueva persona?");
		System.out.println("1. Agregar una nueva persona");
		System.out.println("2. Cargar datos en el arbol");
		
	}

	private void CargarDatos() throws IOException {
		try {
			Scanner lector = new Scanner(
					new File("C:\\Users\\SolanllyBarkerVargas\\eclipse-workspace\\BinaryTree1\\src\\information.txt"));
			while (lector.hasNextLine()) {
				Persona person = new Persona();
				String currentLine = lector.nextLine();
				String[] datos = currentLine.split(",");
				person.setName(datos[0]);
				person.setLastname(datos[1]);
				person.setDateOfBirst(new Date(datos[2]));
				person.setID(datos[3]);
				arbol.insert(person);
				lista.add(person);
			}
			lector.close();
			System.out.println("Datos Cargados en el archivo TXT.");
		} catch (Exception e) {
			System.out.print("\n");
			System.out.println("NO se encontraron personas por cargar");
			System.out.print("\n");
			Menu();

		}

	}

}
