package clock_agent;


import jade.core.Agent;

import jade.domain.DFService;
import jade.domain.FIPAException;
import jade.domain.FIPANames;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.ServiceDescription;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;

public class Clock_Agent extends Agent {
	/**
	 * 
	 */
	
	public String value = null;
	private static String directory=System.getProperty("user.dir");
	private static final long serialVersionUID = 1L;
	DFAgentDescription[] result = null;
	DFAgentDescription[] AgentList = null;
	MessageTemplate template ;  
	ACLMessage msg;
	String ID, actual;
	int flag=0;
	String Date;
	private String currentTime="125",clock;
	//ConsProp dataBase = null;
	Agent MyH=this;
	protected void setup() {
	//	Historical_Data_Consumers dataBase = null;
		//dataBase = new Historical_Data_Consumers(this.getLocalName());
	//	dataBase = new Historical_Data_Consumers(this.getLocalName());
		//new database.Historical_Data_Consumers().Tables(MyH.getLocalName().toString());
	//	new database.Historical_Data_Consumers_Production().Tables(MyH.getLocalName().toString());
		//new database.ConsProp().Tables(MyH.getLocalName().toString());
	
		
		// criar serviço
		ServiceDescription sd = new ServiceDescription();
		sd.setType("CLOCK");
		sd.setName(getLocalName());
	    register( sd );
	//	ACLMessage msg = new ACLMessage( ACLMessage.PROPAGATE ); 
      //  msg.setProtocol(FIPANames.InteractionProtocol.PROPAGATE);
        
    //	dataBase = new ConsProp(MyH.getLocalName());
        
    	//dataBase.CreateDB(MyH.getLocalName());
        
	
			addBehaviour(new Clock_Responder(this));

		

	}

	 void register( ServiceDescription sd)
	    {
	        DFAgentDescription dfd = new DFAgentDescription();
	        dfd.setName(getAID());
	        dfd.addServices(sd);

	        try {  
	            DFService.register(this, dfd );  
	        }
	        catch (FIPAException fe) { fe.printStackTrace(); }
	    }

}