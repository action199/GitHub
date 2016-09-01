package conumer;

import jade.core.Agent;
import jade.core.behaviours.TickerBehaviour;
import jade.domain.DFService;
import jade.domain.FIPAException;
import jade.domain.FIPANames;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.ServiceDescription;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;

public class House extends Agent {
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
		sd.setType("Consumer");
		sd.setName(getLocalName());
	    register( sd );
		ACLMessage msg = new ACLMessage( ACLMessage.CFP ); 
        msg.setProtocol(FIPANames.InteractionProtocol.ITERATED_FIPA_REQUEST);
        
        
        
    //	dataBase = new ConsProp(MyH.getLocalName());
    addBehaviour(new House_Responder_test(MyH));
        
    	//dataBase.CreateDB(MyH.getLocalName());
        

//	    this.addBehaviour(new TickerBehaviour(this, 400) {

	/*    this.addBehaviour(new TickerBehaviour(this, 100) {
>>>>>>> .r69

			private static final long serialVersionUID = 1L;

			@Override 
			protected void onTick() 
			{	


				clock=auxtools.Clock.getTime();
				//------------------Checks the negotiation window if the clock as moved forward is time to start a new nwgotiation--------
				if(!currentTime.equals(clock)){ 
					currentTime=clock;
					Date=auxtools.Clock.Date_time();
					System.out.println(Date +"   TICK " + MyH.getLocalName());
					addBehaviour(new CONS_PV_ContratnetInitiator(MyH,msg,dataBase));

				}
			}
		});*/


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