import java.util.Random;

public class GenerateValidCPF {
	
	public static String putTogetherCPF() {
		
		int[] start = new int[9];
		String primeiro;
		String CPF;
		
		start = generateInitials();
		primeiro = calculateFinals(start);
		start = convertIntArray(primeiro);
		CPF = calculateFinals(start);
		
		return CPF;
	}
	
	private static int[] generateInitials() {
		
		int a;
		int[] start = new int[9];
		Random rand = new Random();
		
		for(int i = 0; i < 9; i++) {
			a = rand.nextInt(10);
			start[i] = a;
		}
		
		return start;
	}
	
	private static String calculateFinals(int[] start) {
		
		int mult = start.length + 1;
		int num, soma = 0, calc;
		String calculated = "";
		
		for(int i = 0; i < start.length; i++, mult--) {
			num = start[i] * mult;
			soma = soma + num;
			calculated = calculated + String.valueOf(start[i]); 
		}
		
		calc = 11 - (soma%11);
		
		if(calc == 11 || calc == 10) {
			calc = 0;
		}
		
		calculated = calculated + String.valueOf(calc);
		
		return calculated;
	}
	
	public static int[] convertIntArray(String str) {
		String[] calculated = str.split("");
		int[] calc = new int[calculated.length];
		
		for(int i = 0; i < calculated.length; i++) {
			
			calc[i] = Integer.parseInt(calculated[i]);
			
		}
		
		return calc;
	}
	
}
