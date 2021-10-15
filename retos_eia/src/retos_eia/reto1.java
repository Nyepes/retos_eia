package retos_eia;
import java.util.ArrayList;
public class reto1 {

	public static void main(String[] args) {
		String word = "AELMNEASNNCAAATORMSEPTOARNAAAÑSSECD";
		System.out.println(mostrarFilas(word));
		int [] ordenFila = {3,4,2,1,0};
		int [] ordenCol = {1,3,2,0,4,6,5};
		//dobleTransposicion(ordenFila,ordenCol);
		perms(0,ordenFila,ordenFila.length);
	} 
	public static void decodificarEscitalo(String palabra) {
		for (int i = 2 ; i < 18 ; i++) { //Se repite por cada numero de Escitalo
			String resultado = i + ". "; 
			int ind = 0; 
			int ciclo = 1;
			while (resultado.length() != palabra.length()) {
				resultado += palabra.charAt(ind);
				ind+=i;
				if (ind >= palabra.length()) {
					ind = ciclo;
					ciclo ++;
				}
				
			}
			System.out.println(resultado);
		}
	}
	//Encuentra las distintas permutaciones de un vector de numeros
	public static void perms (int comienzo, int [] numeros, int longitud) {
		if (longitud == comienzo) {
			int [] ordenCol = {0,1,2,3,4,5,6};
			dobleTransposicion(numeros,ordenCol);
			return;
		}
		for (int i = comienzo ; i < longitud ; i ++) {
			change(numeros, comienzo, i);
			perms(comienzo+1, numeros, longitud);
			change (numeros, i, comienzo);
		}
	}
	//Cambiar dos elementos de un vector de lugar
	public static void change (int[]numeros, int pos1, int pos2) {
		int temp = numeros[pos1];
		numeros[pos1] = numeros[pos2];
		numeros[pos2] = temp;
	}
	
	//Descifrar el texto con la clave
	public static void dobleTransposicion(int[] clvFila, int[] clvColumna, String texto) {
		int [] claveFila = clvFila;
		int [] claveColumna = clvColumna;
		texto = mostrarFilas(texto);
		
		String[] palabras = texto.split(" ");
		for (int i = 0 ; i < palabras.length ; i++) {
			palabras[i] = decodificarFila(claveFila ,palabras[i]);
		}
		
		String decifrado = decodificarColumna (claveColumna, palabras);
		print(convertirMatriz(decifrado));
		
	}
	//Separa el texto en pates de 5 letras cada una
	public static String mostrarFilas(String str) {
		String resultado = "";
		for (int i = 0; i <= str.length()-5 ; i +=5) {
			resultado += str.substring(i,i+5)+ " ";
		}
		return resultado;
	}
	//Muestra la matriz de la letras
	public static char[][] convertirMatriz(String str) {
		char [][] chars = new char[7][5];
		for (int fila = 0 ; fila < 7 ; fila ++) {
			for (int col = 0 ; col < 5 ; col++) {
				chars[fila][col] = str.charAt(5*fila+col);
			}
		}
		return characters;
	}
	//Decodifica una fila de la matriz con una clave
	public static String decodificarFila(int []clave, String palabra) {

		String resultado = "";
		for (int i = 0; i < palabra.length() ;i ++) {
			resultado += palabra.charAt(clave[i]) + "";
		}
		System.out.println(resultado);
		return result;

	}
	//Decodifica una columna de la matriz con una clave
	public static String decodificarColumna (int[] clave, String [] palabras) {
		String resultado = "";
		for (int i = 0; i < 7 ;i ++) {
			int clv = clave[i];
			resultado += palabras[clv] + "";
		}
		return resultado;
	}
	
	//Metodos ayudantes para mostrar las matrices
	public static void print(int[] arr) {
		for (int i = 0 ; i < arr.length ; i++) {
			System.out.print(arr[i]);
		}
	}
	public static void print (char[][] letras) {
		for (int fila = 0 ; fila< 7 ; fila ++) {
			for (int col = 0 ; col < 5 ; col++) {
				System.out.print(letras[fila][col] + " ");
			}
		System.out.println("");
		}
	}
}

