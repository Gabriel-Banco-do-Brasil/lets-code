import java.util.Scanner;

/**
 * A implementação desta calculadora é semelhante à calculadora default do windows
 * Para sair da calculadora digite "close"
 * 
 * Exemplo de teste:
 * 		5
 * 		+
 * 		7
 * 		=
 * 		*
 * 		4
 * 		=
 * 		12
 * 		/
 * 		3
 * 		=
 * 		10
 * 		20
 * 		-
 *		5
 * 		=
 * 
 */

public class Main {
	public static void main(String[] args) throws Exception {

		Scanner scanner = new Scanner(System.in);
		CalculatorRefactored calculator = new CalculatorRefactored();
		
		while(true) {
			System.out.println("");
			System.out.println("Digite uma operação ou valor:");
			String input = scanner.next();

			if(input.equals("close")){
				scanner.close();
				break;
			} else {
				calculator.pressButtonHandler(input);
			}

		}

	}
}