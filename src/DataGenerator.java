import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DataGenerator {

	public static final String SEPARATOR = ",";
	public static final Integer numAcc = 100;
	public static void main(String[] args) {

		csvWriter();

	}
	public static void csvWriter() {
		try {
			FileWriter csv = new FileWriter("/Users/Nescara/Desktop/new.csv");

			List<String> fields = Arrays.asList("Name", "Tipo__c", "CPF__c", "CNPJ__c");

			csv.append(String.join("", csvHeader(fields)));

			for(List<String> a : csvBodyPf()) {
				csv.append(String.join(",", a));
				csv.append("\n");
			}
			for(List<String> a : csvBodyPj()) {
				csv.append(String.join(",", a));
				csv.append("\n");
			}

			csv.flush();
			csv.close();

		} catch (Exception e) {
			e.printStackTrace(System.out);
		}
	}
	public static List<String> csvHeader(List<String> fields) throws IOException {
		List<String> csv = new ArrayList<>();

		for(int i = 0; i < fields.size(); i++) {
			if(i < fields.size() - 1) {
				csv.add(fields.get(i));
				csv.add(SEPARATOR);
			}
			else {
				csv.add(fields.get(i));
				csv.add("\n");
			}
		}

		return csv;
	}
	public static List<List<String>> csvBodyPf() {
		List<List<String>> body = new ArrayList<>();
		List<List<String>> c = new ArrayList<>();

		for(int i = 0; i < numAcc; i++) {
			String cpf = GenerateValidCPF.putTogetherCPF();
			c =  Arrays.asList(
				Arrays.asList("Teste Gustavo Pessoa Física " + i,"Pessoa Física",cpf,"")
			);
			body.addAll(c);
			System.out.println(c);
		}
		return body;
	}
	public static List<List<String>> csvBodyPj() {
		List<List<String>> body = new ArrayList<>();
		List<List<String>> c = new ArrayList<>();

		for(int i = 0; i < numAcc; i++) {
			String cnpj = GenerateValidCNPJ.putTogetherCNPJ();
			c =  Arrays.asList(
				Arrays.asList("Teste Gustavo Pessoa Jurídica " + i,"Pessoa Jurídica","",cnpj)
			);
			body.addAll(c);
			System.out.println(c);
		}
		return body;
	}
}
