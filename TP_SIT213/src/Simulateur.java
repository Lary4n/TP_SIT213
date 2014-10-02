//Commit test jordan


public class Simulateur {
	public static void main(String[] args){    	
		
		String message=""; //message par defaut
		String sonde=""; // sonde sur false par defaut
		String etape = "1"; //etape par defaut
		
		for (int i=0;i<args.length;i++){
			switch (args[i]){
			case "-mess" : 
				message = args[i+1];
				break;
			case "-e" : 
				etape = args[i+1];
				break;
			case "-s" : 
				sonde = "-s";
				break;
			}
		}
		
		String[] arg4main={"-mess",message,sonde};
		
		switch (etape){
		case "1" :
			System.out.println("test main step 1");
			ApplicationTransmissionLogiqueParfaite.main(arg4main);
			break;
		//case "2":
			//System.out.println("test main step 2");
			//Test_Step_2.main(arg4main);
		//	break;
		default : 
			System.out.println("test main step 1 (par defaut)");
			ApplicationTransmissionLogiqueParfaite.main(arg4main);
			break;
		}
		
	}
}
