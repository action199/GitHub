package conumer;

import java.util.Vector;

import auxtools.DFsearch;
import jade.core.AID;
import jade.core.Agent;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.ServiceDescription;
import jade.lang.acl.ACLMessage;
import jade.proto.ContractNetInitiator;

public class House_Bheavior extends ContractNetInitiator {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	Agent myagent;
	ACLMessage clock_reply = new ACLMessage(ACLMessage.PROPAGATE);
	public House_Bheavior(Agent a,  ACLMessage propagate) {
		super(a, propagate);
		clock_reply=(ACLMessage) propagate.clone();
		myagent=a;
		// TODO Auto-generated constructor stub
	}
	@Override
	protected Vector<ACLMessage> prepareCfps(ACLMessage cfp) {
		DFAgentDescription[] result = null;
		// -------------Checks the possible producers to request
		// power----------------
		ServiceDescription sd = new ServiceDescription();
		sd.setType("producer");
		DFsearch power = new DFsearch();
		result = power.busca(myagent, sd);
		String ID;
		ACLMessage request = new ACLMessage(ACLMessage.CFP);
		for (int i = 0; i < result.length; i++) {
			/*
			 * if(!flag){
			 * 
			 * remain_demand=initial_demand; flag=true; }
			 */
			// System.out.println("--------------------------------------------"+value);

			ID = result[i].getName().getLocalName();
			AID r = new AID(ID, AID.ISLOCALNAME);
			System.out.println(myagent.getLocalName()+ "    SEND TO ------------------------>   " +ID);
			request.addReceiver(r);

		}
		
		
		Vector<ACLMessage> v = new Vector<ACLMessage>();
		v.add(request);
		return v;
	}
	
	@Override
	public void onStart() {
		
		System.out.println(myagent.getLocalName() + " I've started a CNP at: " + System.currentTimeMillis());
		super.onStart();

	}
	
	@Override
	public int onEnd() {

		System.out.println("***************************" + myagent.getLocalName() + " I've ended a CNP at: "
				+ System.currentTimeMillis());
		ACLMessage rep = new ACLMessage(ACLMessage.INFORM);
		rep = clock_reply.createReply();
		//		System.out.println("NOOOOOOOOOOOOOO"+reject.toString());
		rep.setPerformative(ACLMessage.PROPAGATE);
		//	System.out.println("ESSSSSSTTTTTTTTAAAAA NNNNOOOOO RRRRREEEFFFUUUUSSSSEEEE         222222");
		myagent.send(rep);
		return super.onEnd();
	}


//	protected void handlePropose(ACLMessage propose, Vector acceptances) {
//		System.out.println(myAgent.getLocalName() + " I've received an Propose in the CNP from: "
//				);
//		super.handlePropose(propose, acceptances);
//		// System.out.println(getLocalName() +
//		// " Recebi esta msg para transportar: " + msg_transporter);
//	}

	protected void handleRefuse(ACLMessage refuse) {
		System.out.println(myAgent.getLocalName() + " I've received an Refuse in the CNP from: "
				+ refuse.getSender().getLocalName());
		super.handleRefuse(refuse);
		// System.out.println(getLocalName() +
		// " Recebi esta msg (REFUSE) para transportar: " +
		// msg_transporter);
	}
	public void handleOutOfSequence(ACLMessage msg) {
		System.out.println("Mensagem OutOfSequence" + msg);
	}
	protected void handleInform(ACLMessage messages) {
		System.out.println("Mensagem Inform" );
		
	}
	protected void handleAllResponses(Vector responses, Vector acceptances) {

	
		ACLMessage msg = (ACLMessage) responses.get(0);
		ACLMessage proposal = new ACLMessage(ACLMessage.ACCEPT_PROPOSAL);
		proposal = msg.createReply();	
		proposal.setPerformative(ACLMessage.ACCEPT_PROPOSAL); 
		
		acceptances.add(proposal);
//		System.out.println(myagent.getLocalName() + " size do responses: " + responses.size());
	}
}
