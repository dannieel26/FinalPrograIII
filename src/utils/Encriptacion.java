package utils;

public class Encriptacion {

    // Método para encriptar con César
    public static String encriptarCesar(String texto, int desplazamiento) {
        StringBuilder textoEncriptado = new StringBuilder();

        for (char i : texto.toCharArray()) {
            if (Character.isLetter(i)) {
                char desplazado = (char) (i + desplazamiento);

                // Si pasa de 'z' o 'Z', vuelve a empezar desde 'a' o 'A'
                if (Character.isLowerCase(i) && desplazado > 'z' || 
                    Character.isUpperCase(i) && desplazado > 'Z') {
                    desplazado -= 26;
                }
                textoEncriptado.append(desplazado);
            } else {
                textoEncriptado.append(i);  // Deja los caracteres no alfabéticos tal cual están
            }
        }
        return textoEncriptado.toString();
    }

    // Método para desencriptar con César (invierte el desplazamiento)
    public static String desencriptarCesar(String texto, int desplazamiento) {
        return encriptarCesar(texto, -desplazamiento); // Solo cambia el signo del desplazamiento
    }
}
