package producer;

import jade.core.Agent;
import jade.lang.acl.MessageTemplate;
import jade.lang.acl.ACLMessage;
import jade.proto.ContractNetResponder;
import jade.domain.FIPAAgentManagement.FailureException;
import jade.domain.FIPAAgentManagement.NotUnderstoodException;
import jade.domain.FIPAAgentManagement.RefuseException;
public class ContratnetResponder_PV extends ContractNetResponder {

	/**
	 * 
	 */
	Agent MYH;
	private static final long serialVersionUID = 1L;
	ACLMessage clock_reply = new ACLMessage(ACLMessage.PROPAGATE);
	public ContratnetResponder_PV(Agent a, MessageTemplate mt) {
		super(a, mt);
		MYH =a;
		//clock_reply=(ACLMessage) propagate.clone();

	}
	@Override
	protected ACLMessage handleCfp(ACLMessage cfp) throws NotUnderstoodException, RefuseException {

		System.out.println("Agent "+": Proposing ");
		ACLMessage propose = cfp.createReply();
		propose.setPerformative(ACLMessage.PROPOSE);

		return propose;
	}
	protected void handleRejectProposal(ACLMessage cfp, ACLMessage propose, ACLMessage reject) {
		System.out.println("Agent "+MYH.getLocalName()+": Proposal rejected");
	}

	@Override
	protected ACLMessage handleAcceptProposal(ACLMessage cfp, ACLMessage propose,ACLMessage accept) throws FailureException {
		System.out.println("Agent  Proposal accepted");
	
		ACLMessage inform = new ACLMessage(ACLMessage.INFORM);
		inform = accept.createReply();
		inform.setPerformative(ACLMessage.INFORM);
		
		return inform;
		
	}
	@Override
	public void onStart() {

		System.out.println(MYH.getLocalName() + " I've started A RECIEVER CNP: " + System.currentTimeMillis());
		super.onStart();

	}
	

//	
//	public int onEnd() {
//
//		System.out.println("***************************" + MYH.getLocalName() + " I've ended a CNP at: "
//				+ System.currentTimeMillis());
//		ACLMessage rep = new ACLMessage(ACLMessage.PROPAGATE);
//		rep = clock_reply.createReply();
//		//		System.out.println("NOOOOOOOOOOOOOO"+reject.toString());
//		rep.setPerformative(ACLMessage.PROPAGATE);
//		//	System.out.println("ESSSSSSTTTTTTTTAAAAA NNNNOOOOO RRRRREEEFFFUUUUSSSSEEEE         222222");
//		MYH.send(rep);
//		return super.onEnd();
//	}

}
