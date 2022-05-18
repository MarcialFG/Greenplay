package MarcialFernandez.GreenPlay.Utils;

import java.util.Scanner;

import org.springframework.security.crypto.bcrypt.BCrypt;

public class Utils {
	private static Scanner teclado = new Scanner(System.in);

	/**
	 * Metodo para recoger una cadena de caracteres
	 * 
	 * @return string
	 */

	public static String getString() {
		String result = "";
		boolean valid = false;
		do {
			try {
				result = teclado.nextLine();
				valid = true;

			} catch (Exception ex) {
				System.out.println("Error, prueba de nuevo: ");
			}
		} while (!valid);
		return result;
	}

	/**
	 * Metodo para recoger un dni cumpliendo una expresion
	 * 
	 * @param Dni
	 * 
	 * @return string
	 */
	public static boolean getDNI(String Dni) {
		String dni = Dni;
		boolean valid = false;

		do {
			try {
				if (dni.matches("[0-9]{8}[A-Z a-z]")) {
					valid = true;
				} else {
					valid = false;
					System.out.println("Debe tener 8 digitos y un caracter");
				}

			} catch (Exception ex) {
				System.out.println("Error, prueba de nuevo: ");
			}
		} while (!valid);
		return valid;
	}

	/**
	 * validar email
	 * 
	 * @param email
	 * @return
	 */
	public static boolean validateEmail(String email) {
		String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
		return email.matches(regex);
	}
	/**
	 * Encripta la contraseña para la base de datos.
	 * @param password
	 * @return
	 */
	public static String encriptarpassword(String password) {

		return BCrypt.hashpw(password, BCrypt.gensalt());
	}
	
}
