package conumer;

import java.math.BigDecimal;

import jade.core.Agent;
import jade.core.behaviours.OneShotBehaviour;
import jade.core.behaviours.SimpleBehaviour;
import jade.core.behaviours.WakerBehaviour;
import jade.domain.FIPANames;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;

public class House_Responder_test extends SimpleBehaviour {
	/**
	 * 
	 */
	boolean finished = false;
	MessageTemplate template = MessageTemplate.MatchProtocol("time");
	private static final long serialVersionUID = 1L;
	Agent myagent;
	String time, value;
	private static String directory = System.getProperty("user.dir");
	double prodValue = 0, Request = 0;
	// double price=0.1589;
	ACLMessage proposal;
	ACLMessage msg = new ACLMessage(ACLMessage.INFORM);
	private boolean running = false;
	static String Date, currentTime = "125", clock;

	public House_Responder_test(Agent a) {
		super(a);
		myagent = a;

	}

	@Override
	public void action() {
		// TODO Auto-generated method stub

		msg = myagent.receive(template);
		// System.out.println("111111111111111111111111111111111");
		if (msg != null) {
			// System.out.println("ccccccccccccccccccccc
			// "+msg.getConversationId());
			myagent.addBehaviour(new HandleMessages(msg));

		} else {
			block();
		}

	}

	public boolean done() {
		return finished;
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
			// System.out.println("222222222222222222222222222222"+msg_in);
			// TODO Auto-generated method stub
			//System.out.println("222222222222222222222222222222" + msg_in);
			switch (msg_in.getPerformative()) {
			case ACLMessage.PROPAGATE: {

				//System.out.println("222222222222222222222222222222" + msg_in);
				myAgent.addBehaviour(new House_Bheavior(myagent, msg_in));

				break;
			}

			}

		}

	}

}