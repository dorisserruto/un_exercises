
import java.lang.Character;

public class Pregunta5 {
	public static void main (String argv[]){
		String cita= "Esta isla es una de las m�s singulares. Se" +
		"compone �nicamente de arena de mar, y tiene, poco m�s o menos,"+
		"tres millas de largo. Su anchura no excede de un cuarto de"+
		"milla. Est� separada del continente por una ensenada apenas perceptible,"+
		"que fluye a trav�s de un yermo de ca�as y l�gamo, lugar frecuentado por"+
		"patos silvestres. La vegetaci�n, como puede suponerse, es pobre, o, por"+
		"lo menos, enana. No se encuentran all� �rboles de cierta magnitud. Cerca"+
		"de la punta occidental, donde se alza el fuerte Moultrie y algunas"+
		" miserables casuchas de madera habitadas durante el verano por las"+
		"gentes que huyen del polvo y de las fiebres de Charleston, puede"+
		"encontrarse es cierto, el palmito erizado; pero la isla entera";
		System.out.println(cita);
		
		// A mayusculas
		System.out.println("En Mayusculas :" + cita.toUpperCase());
		
		// Cantidad de Letras
		for (int i=(cita.length() - 1);i<=0;i--){
			if (isLetter(cita.charAt(i))) {
			}
		}
		
		// Subcadena "tera" aparece en el texto
		int veces = 0;
		int i = 0;
		while (i != -1){
			if ((cita.indexOf("tera", i)) > -1){
				veces ++;
				i = (cita.indexOf("tera", i))+ 1;
			}
			else {
				break;
			}
		}
		System.out.println("Cantidad de veces de Tera :"+veces);
		
		// Letra 'e' aparece en el texto
		int vec = 0;
		int j = 0;
		while (j != -1){
			if ((cita.indexOf('e', j)) > -1){
				vec ++;
				j = (cita.indexOf('e', j))+ 1;
			}
			else {
				break;
			}
		}
		System.out.println("Cantidad de veces de e :"+vec);
	};
}
