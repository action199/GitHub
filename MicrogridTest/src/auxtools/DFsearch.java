package auxtools;

import jade.core.Agent;

import jade.domain.DFService;
import jade.domain.FIPAException;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.ServiceDescription;

public class DFsearch {
	
	
	public  DFAgentDescription[] busca(Agent myAgent, ServiceDescription sd) {

		DFAgentDescription dfd = new DFAgentDescription();
		dfd.addServices(sd);
		//System.out.println("agente" + myAgent.getLocalName().toString());
	//	System.out.println("SERVIÇO" + sd.getName());
		DFAgentDescription[] resultado = null;
		try {

			resultado = DFService.search(myAgent, dfd);

		} catch (FIPAException e) {
			e.printStackTrace();
		}

		return resultado;

	}
}
