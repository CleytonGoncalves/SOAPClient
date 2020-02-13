package br.ufmt.ic.sd.soap.client;

import br.ufmt.ic.sd.soap.client.wsdl.GetEstudanteResponse;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClientApplication.class, args);
	}
	
	@Bean
	CommandLineRunner lookup(EstudanteClient quoteClient) {
		return args -> {
			String rga = "201611310023";
			
			if (args.length > 0) {
				rga = args[0];
			}
			GetEstudanteResponse response = quoteClient.getEstudante(rga);
			System.err.println(response.getEstudante().getNome() + " - " + response.getEstudante().getCurso());
		};
	}
	
	
}
