import java.util.Random;

public class GenerateValidCNPJ {
	
	public static String putTogetherCNPJ() {
		
		int[] start = new int[12];
		int[] start2 = new int[13];
		String CNPJ = generateInitials();
		
		start = GenerateValidCPF.convertIntArray(CNPJ);
		CNPJ += calculateFinals(start);
		start2 = GenerateValidCPF.convertIntArray(CNPJ);
		CNPJ += calculateFinals(start2);
		
		return CNPJ;
	}
	
	private static String generateInitials() {
		
		int a;
		String gen = "";
		Random rand = new Random();
		
		for(int i = 0; i < 12; i++) {
			a = rand.nextInt(10);
			gen = gen + String.valueOf(a);
		}
		
		return gen;
	}
	
	public static String calculateFinals(int[] start) {
		int mult = 2;
		int num, soma = 0, calc;
		String dig;
		String calculated = "";
		
		for(int i = start.length - 1; i >= 0; i--) {
			num = start[i] * mult;
			soma = soma + num;
			mult = mult + 1;
			
			if(mult == 10) 
				mult = 2;
		}
		
		calc = soma%11;
		
		if(calc < 2) 
			calc = 0; 
		else
			calc = 11 - (soma%11);
		
		calculated = calculated + String.valueOf(calc);
		
		dig = String.valueOf(calc);
		
		return dig;
	}
}
