package producer;

import jade.core.Agent;
import jade.domain.DFService;
import jade.domain.FIPAException;
import jade.domain.FIPANames;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.ServiceDescription;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;


public class PV extends Agent {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//RemainPower dataBase = null;
	Agent MyH=this;
	protected void setup() {

		DFAgentDescription dfd = new DFAgentDescription();
		dfd.setName(getAID());

		// criar serviço
		ServiceDescription sd = new ServiceDescription();
		sd.setType("producer");
		sd.setName(getLocalName());
		dfd.addServices(sd);

		try{
			//registar serviço
			DFService.register(MyH, dfd);


		}catch (FIPAException e){
			e.printStackTrace();
		}
	//	dataBase = new RemainPower(MyH.getLocalName());
	
		//dataBase.CreateDB(MyH.getLocalName());
	//	addBehaviour(new RecievebehavPV(this));
		//		addBehaviour(new SimpleHouse(this));
		// content.equalsIgnoreCase ( "How" )
		// public void action() {
		// System.out.println("Explor recieving");
		 
		ACLMessage cfp = new ACLMessage(ACLMessage.CFP);
		
	//	MessageTemplate template =
				
		//		MessageTemplate.MatchPerformative(ACLMessage.CFP) ;
	///	addBehaviour(new ContratnetResponder_PV(this, template));
		MessageTemplate template =
				
				MessageTemplate.MatchPerformative(ACLMessage.CFP) ;
		addBehaviour(new ContratnetResponder_PV(this, template));
	  //    addBehaviour(new PV_Responder_Syncro(this, dataBase));
		/*ACLMessage aclMessagee = new ACLMessage(ACLMessage.REQUEST);
        String msg="HEEYYYY";
		AID r = new AID("House1", AID.ISLOCALNAME);
		aclMessagee.addReceiver(r);
		// aclMessagee.setSender(new AID(myk.getName(), AID.ISGUID));
		aclMessagee.setContent(msg);
		MyH.send(aclMessagee);
		System.out.println("SENDING HOUSE---------------PROPOSE" + "House1");*/

	}
}

