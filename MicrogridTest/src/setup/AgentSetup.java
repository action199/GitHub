package setup;


import java.io.File;


import jade.core.Agent;
import jade.core.Profile;
import jade.core.ProfileImpl;
import jade.wrapper.AgentController;
import jade.wrapper.ContainerController;
import jade.wrapper.StaleProxyException;
import jade.core.Runtime;

public class AgentSetup  extends Agent {

	private static final long serialVersionUID = 1L;
	private static ContainerController containerController = null;
	// private static Agent myAgent;

	Agent mya = this;

	protected void setup() {  
		// myAgent = this;
	// clock = new Clock();
	//	clock.Start();
		// content.equalsIgnoreCase ( "How" )
		agentlaunch();

	} 

	public void agentlaunch() {
		File dir = new File("Data/Negotiation");
		dir.mkdirs();
		File dir2 = new File("Data/Profiles");
		dir2.mkdirs();
		Runtime runtime = Runtime.instance();
		Profile profile = new ProfileImpl();
		// String[] count = null;
		String[] Identifier = null;
		String[] Type = null;
		String[] Name = null;
		containerController = runtime.createAgentContainer(profile);
		Object parametros[] = { this.getLocalName().toString(), "RFID", "nogui" };

		AgentController agent;


		//System.out.println(Identifier.length);
		try { 
				agent = containerController.createNewAgent(
					"House1", "conumer" + "."
							+ "House", parametros);
			agent.start();
		
			agent = containerController.createNewAgent(
					"House2", "conumer" + "."
							+ "House", parametros);
			agent.start();
			agent = containerController.createNewAgent(
					"House3", "conumer" + "."
							+ "House", parametros);
			agent.start();
			agent = containerController.createNewAgent(
					"House4", "conumer" + "."
							+ "House", parametros);
			agent.start();
					agent = containerController.createNewAgent(
					"House5", "conumer" + "."
							+ "House", parametros);
			agent.start();
			
		/*	agent = containerController.createNewAgent(
					"House6", "conumer" + "."
							+ "House", parametros);
			agent.start();
			agent = containerController.createNewAgent(
					"House7", "conumer" + "."
							+ "House", parametros);
			agent.start();
			agent = containerController.createNewAgent(
					"House8", "conumer" + "."
							+ "House", parametros);
			agent.start();
			agent = containerController.createNewAgent(
					"House9", "conumer" + "."
							+ "House", parametros);
			agent.start();
			agent = containerController.createNewAgent(
					"House10", "conumer" + "."
							+ "House", parametros);
			agent.start();
			agent = containerController.createNewAgent(
					"House11", "conumer" + "."
							+ "House", parametros);
			agent.start();
			agent = containerController.createNewAgent(
					"House12", "conumer" + "."
							+ "House", parametros);
			agent.start();
			agent = containerController.createNewAgent(
					"House13", "conumer" + "."
							+ "House", parametros);
			agent.start();*/
			/*		
					agent = containerController.createNewAgent(
					"House3", "conumer" + "."
							+ "House", parametros);
			agent.start();*/
			agent = containerController.createNewAgent(
					"PV1", "producer" + "."
							+ "PV", parametros);
			agent.start();
	/*	agent = containerController.createNewAgent(
					"PV2", "producer" + "."
							+ "PV", parametros);
			agent.start();
			
			agent = containerController.createNewAgent(
					"PV3", "producer" + "."
							+ "PV", parametros);
			agent.start();
			agent = containerController.createNewAgent(
					"PV4", "producer" + "."
							+ "PV", parametros);
			agent.start();
				agent = containerController.createNewAgent(
					"PV5", "producer" + "."
							+ "PV", parametros);
			agent.start();
				agent = containerController.createNewAgent(
					"PV6", "producer" + "."
							+ "PV", parametros);
			agent.start();
			agent = containerController.createNewAgent(
					"PV7", "producer" + "."
							+ "PV", parametros);
			agent.start();
			agent = containerController.createNewAgent(
					"PV8", "producer" + "."
							+ "PV", parametros);
			agent.start();
			agent = containerController.createNewAgent(
					"PV9", "producer" + "."
							+ "PV", parametros);
			agent.start();
			agent = containerController.createNewAgent(
					"PV10", "producer" + "."
							+ "PV", parametros);
			agent.start();*/
			
//			agent = containerController.createNewAgent(
//					"EDP", "electricity_operator" + "."
//					+ "EDP", parametros);
//			agent.start();
//			
//			
//			agent = containerController.createNewAgent(
//					"EDP_Buyer", "electricity_operator" + "."
//					+ "EDP_Buyer", parametros);
//			agent.start();
			
			agent = containerController.createNewAgent(
					"ZeAgent", "clock_agent" + "."
							+ "Clock_Agent", parametros);
			agent.start();
			
			
			
			
		/*	agent = containerController.createNewAgent(
					"PV4", "producer" + "."
							+ "PV", parametros);
			agent.start();
*/
//	agent = containerController.createNewAgent(
//					"BAT1", "s_agent" + "."
//							+ "Battery", parametros);
//			agent.start();
//			agent = containerController.createNewAgent(
//					"BAT2", "s_agent" + "."
//							+ "Battery", parametros);
//			agent.start();
//			agent = containerController.createNewAgent(
//					"BAT3", "s_agent" + "."
//							+ "Battery", parametros);
//			agent.start();
//			agent = containerController.createNewAgent(
//					"BAT4", "s_agent" + "."
//							+ "Battery", parametros);
//			agent.start();
//			agent = containerController.createNewAgent(
//					"BAT5", "s_agent" + "."
//							+ "Battery", parametros);
//			agent.start();
//			agent = containerController.createNewAgent(
//					"BAT6", "s_agent" + "."
//							+ "Battery", parametros);
//			agent.start();
			//	agent = containerController.createNewAgent(
			//			"Wind1", "agents" + "."
			//					+ "Wind", parametros);
			//	agent.start();
			//agent = containerController.createNewAgent(
			//			"GUI", "gui" + "."
			//					+ "AgentGUI", parametros);
			//agent.start();
		} catch (StaleProxyException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		/*for (int i = 0; i < Identifier.length; i++) {
			//	System.out.println(Type[i].toString() + "." + Name[i].toString());
			try {
				agent = containerController.createNewAgent(
						Identifier[i].toString(), Type[i].toString() + "."
								+ Name[i].toString(), parametros);
				agent.start();

			} catch (StaleProxyException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		 */
	}
}