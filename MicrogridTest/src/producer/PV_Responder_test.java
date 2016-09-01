package producer;

import conumer.House_Bheavior;
import jade.core.Agent;
import jade.core.behaviours.OneShotBehaviour;
import jade.core.behaviours.SimpleBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;

public class PV_Responder_test extends SimpleBehaviour {
	/**
	 * 
	 */
	MessageTemplate template = MessageTemplate.MatchProtocol("time");
	private static final long serialVersionUID = 1L;
	Agent MYAgent;
	ACLMessage msg = new ACLMessage(ACLMessage.INFORM);
boolean flag=false;
	public PV_Responder_test(Agent a, ACLMessage cfp) {
		// TODO Auto-generated constructor stub
		super(a);
		MYAgent = a;
	}

	@Override
	public void action() {
		// TODO Auto-generated method stub
		msg = MYAgent.receive(template);

		if (msg != null) {
			// System.out.println("ccccccccccccccccccccc
			// "+msg.getConversationId());
			MYAgent.addBehaviour(new HandleMessages(msg));

		} else {
			block();
		}
	}

	@Override
	public boolean done() {
		// TODO Auto-generated method stub
		return false;
	}

	class HandleMessages extends OneShotBehaviour {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		ACLMessage msg_in;

		public HandleMessages(ACLMessage message) {
			// myAgent.addBehaviour(new HandleMessages(msg));
			msg_in = (ACLMessage) message.clone();
			// System.out.println("Recebi .." + message);
		}

		@Override
		public void action() {
			// TODO Auto-generated method stub
			switch (msg_in.getPerformative()) {

			case ACLMessage.PROPAGATE: {

				// System.out.println("222222222222222222222222222222" +
				// msg_in);
			if(flag==false){
				MessageTemplate template =
						
						MessageTemplate.MatchPerformative(ACLMessage.CFP) ;
				MYAgent.addBehaviour(new ContratnetResponder_PV(MYAgent, template));
				flag=true;
			}
				break;
			}

			}
		}
	}
}
