package br.ufmt.ic.sd.soap.client;

import br.ufmt.ic.sd.soap.client.wsdl.GetEstudanteRequest;
import br.ufmt.ic.sd.soap.client.wsdl.GetEstudanteResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

public class EstudanteClient extends WebServiceGatewaySupport {
	
	public static final String NAMESPACE_URI = "br.ufmt.ic.sd.soap/estudantes";
	private static final Logger log = LoggerFactory.getLogger(EstudanteClient.class);
	
	public GetEstudanteResponse getEstudante(String rga) {
		GetEstudanteRequest request = new GetEstudanteRequest();
		request.setRga(rga);
		
		log.info("Requisitando informações do RGA: " + rga);
		
		GetEstudanteResponse response = (GetEstudanteResponse) getWebServiceTemplate().marshalSendAndReceive("http://localhost:8080/ws/estudantes", request, new SoapActionCallback(NAMESPACE_URI + "/GetEstudanteRequest"));
		
		return response;
	}
}
