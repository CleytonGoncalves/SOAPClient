package br.ufmt.ic.sd.soap.client;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class EstudanteConfiguration {
	
	@Bean
	public Jaxb2Marshaller marshaller() {
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		// this package must match the package in the <generatePackage> specified in
		// pom.xml
		marshaller.setContextPath("br.ufmt.ic.sd.soap.client.wsdl");
		return marshaller;
	}
	
	@Bean
	public EstudanteClient estudanteClient(Jaxb2Marshaller marshaller) {
		EstudanteClient client = new EstudanteClient();
		client.setDefaultUri("http://localhost:8080/ws");
		client.setMarshaller(marshaller);
		client.setUnmarshaller(marshaller);
		return client;
	}
	
}
