public class DataGenerator {
	public static void main (String[] args) {
 		String CPF, CNPJ;
 		
 		System.out.println("Name, Tipo__c, CPF__c, CNPJ__c");
 		
 		for(int i = 1; i <= 25; i++) {
 			System.out.print("Teste Física " + i + " Gustavo, ");
 			System.out.print("Pessoa Física ,");
 			System.out.print("'"+GenerateValidCPF.putTogetherCPF()+",");
 			System.out.println();
 		}
 		
 		for(int i = 1; i <= 25; i++) {
 			System.out.print("Teste Jurídica " + i + " Gustavo, ");
 			System.out.print("Pessoa Jurídica ,,");
 			System.out.print("'"+GenerateValidCNPJ.putTogetherCNPJ()+",");
 			System.out.println();
 		}
 		
 		
 		
	}
}
