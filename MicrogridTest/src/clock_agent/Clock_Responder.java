package clock_agent;


import auxtools.DFsearch;
import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.OneShotBehaviour;

import jade.core.behaviours.SimpleBehaviour;

import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.ServiceDescription;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;


public class Clock_Responder extends SimpleBehaviour {
	ACLMessage msg = new ACLMessage(ACLMessage.INFORM);
	MessageTemplate template = MessageTemplate.MatchProtocol("time");
	int recieved_message_counter=0,send_message_counter=0;
	String ConverSationID,ConverSationID2;
	private static final long serialVersionUID = 1L;
	
	private boolean finished;
	Agent myAAgent;
boolean flag =false;
	public Clock_Responder(Agent a) {
		super(a);
		myAAgent = a;

		///	final Clock_Engine test = new Clock_Engine();
		Clock_Engine.Start();
		//test.doStuff();
			
		try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		SendMessage();
	}
	@Override
	public void action() {
		// TODO Auto-generated method stub
		msg = myAAgent.receive(template);
		//System.out.println("111111111111111111111111111111111");
		if (msg != null)
		{
			//		System.out.println("ccccccccccccccccccccc                   "+msg.getConversationId());
			myAAgent.addBehaviour(new HandleMessages(msg));

		}
		else
		{
			block();
		}
	}

	class HandleMessages extends OneShotBehaviour {


		private static final long serialVersionUID = 1L;
		ACLMessage msg_in;
		public HandleMessages(ACLMessage message) {
			//myAAgent.addBehaviour(new HandleMessages(msg));
			msg_in = (ACLMessage) message.clone();
			// System.out.println("Recebi .." + message);
		}
		@Override
		public void action() {
			// TODO Auto-generated method stub
			switch (msg_in.getPerformative()) {
			case ACLMessage.PROPAGATE: {
			
					recieved_message_counter=recieved_message_counter+1;
				
				
				System.out.println("Recieved Message from  ----------------------------   " + msg_in.getSender().getLocalName());
				System.out.println(recieved_message_counter + "   ----------------------------   " + send_message_counter);
				
				if(recieved_message_counter==send_message_counter){
				//	flag=true;
				//	finished=true;
				
					SendMessage();
					

				}
			}


			}
		}



	}

	@Override
	public boolean done() {
		// TODO Auto-generated method stub
		return false;
	}



	public void SendMessage(){
		
		recieved_message_counter=0;
		send_message_counter=0;
		//final Clock_Engine test = new Clock_Engine();
		Clock_Engine.doStuff();
		String Date= Clock_Engine.Date;
		String Time =Clock_Engine.Time;

	//	System.out.println("YEEEEEEE");
		ServiceDescription sd = new ServiceDescription();
		DFAgentDescription[] result = null;

		sd = new ServiceDescription();
		sd.setType("Consumer");
		DFsearch power = new DFsearch();
		result = power.busca(myAAgent, sd);
		ACLMessage request = new ACLMessage(ACLMessage.PROPAGATE);


		request.setProtocol("time");
		request.setConversationId(myAAgent.getLocalName()+"request" );
		request.setContent(Date+"*"+Time);
		ConverSationID=request.getConversationId();

		for (int i = 0; i < result.length; i++) {
			String ID;

			ID = result[i].getName().getLocalName();
			AID r = new AID(ID, AID.ISLOCALNAME);
			request.addReceiver(r);
			//System.out.println("YEEEEEEE" + ID); 
			send_message_counter=send_message_counter+1;
		}
		myAAgent.send(request);
		
		
		
		
//		ServiceDescription sd2 = new ServiceDescription();
//		DFAgentDescription[] result2 = null;
//		sd2 = new ServiceDescription();
//		sd2.setType("producer");
//		DFsearch power2 = new DFsearch();
//		result2 = power2.busca(myAAgent, sd2);
//		ACLMessage request2 = new ACLMessage(ACLMessage.PROPAGATE);
//
//
//		request2.setProtocol("time");
//		request2.setConversationId(myAAgent.getLocalName()+"request");
//		request2.setContent(Date+"*"+Time);
//		ConverSationID2=request2.getConversationId();
//
//		for (int i = 0; i < result2.length; i++) {
//			String ID;
//
//			ID = result2[i].getName().getLocalName();
//			AID r = new AID(ID, AID.ISLOCALNAME);
//			request2.addReceiver(r);
//			//System.out.println("YEEEEEEE" + ID); 
//			send_message_counter=send_message_counter+1;
//		}
//		
//		myAAgent.send(request2);
		
		
		
		
		
		ServiceDescription sd3 = new ServiceDescription();
		DFAgentDescription[] result3 = null;
		sd3 = new ServiceDescription();
		sd3.setType("storage");
		DFsearch power3 = new DFsearch();
		result3 = power3.busca(myAAgent, sd3);
		ACLMessage request3 = new ACLMessage(ACLMessage.PROPAGATE);


		request3.setProtocol("time");
		request3.setConversationId(myAAgent.getLocalName()+"request");
		request3.setContent(Date+"*"+Time);
		ConverSationID2=request3.getConversationId();

		for (int i = 0; i < result3.length; i++) {
			String ID;

			ID = result3[i].getName().getLocalName();
			AID r = new AID(ID, AID.ISLOCALNAME);
			request3.addReceiver(r);
			//System.out.println("YEEEEEEE" + ID); 
			send_message_counter=send_message_counter+1;
		}
		
		myAAgent.send(request3);
	

		
		
		//myAAgent.addBehaviour(new waketime(myAAgent, new Date(System.currentTimeMillis() +10000)));
		
	}


	

}
