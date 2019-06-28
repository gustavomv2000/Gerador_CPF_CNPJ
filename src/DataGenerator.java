import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DataGenerator {
	public static void main (String[] args) {
		 
		csvWriter();

	}
	public static void csvWriter() {
		try {
			FileWriter csv = new FileWriter("/Users/Nescara/Desktop/new.csv");

			csv.append("Name");
			csv.append(",");
			csv.append("Tipo__c");
			csv.append(",");
			csv.append("CPF__c");
			csv.append(",");
			csv.append("CNPJ__c");
			csv.append("\n");

			for(List<String> a : csvBody()) {
				csv.append(String.join(",", a));
				csv.append("\n");
			}		

			csv.flush();
			csv.close();
		}
		catch(Exception e) {
			e.printStackTrace(System.out);
		}
	}
	public static List<String> csvHeader(List<String> fields) {
		List<String> header = new ArrayList<>();

		for(String f : fields) {
			header.add(f);
		}

		return header;
	}
	public static List<List<String>> csvBody() {
		List<List<String>> body = new ArrayList<>();
		List<List<String>> c = new ArrayList<>();

		for(int i = 0; i < 1000000; i++) {
			String cpf = GenerateValidCPF.putTogetherCPF();
			c =  Arrays.asList(
				Arrays.asList("Teste Gustavo " + i,"Pessoa Física",cpf,"")
			);
			body.addAll(c);
			System.out.println(c);
		}
		return body;
	}
}
