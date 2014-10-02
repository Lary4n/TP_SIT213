import java.util.LinkedList;


/** 
 * Classe realisant l'affichage de la puissance d'une information composee d'elements de type reel (float)
 * @author arzel lepottier
 */
public class SourceFixe extends Source <Boolean> {
	
			/** 
		 * Constructeur de la classe et génération d'une information logique
		 * @param message de type String
		 * @throws InformationNonConforme
		 */
	
	public SourceFixe(String message) throws InformationNonConforme
	{

		super();
		informationGeneree = new Information <Boolean> ();

		for(int i = 0; i<message.length(); i++)
		{
			char c = message.charAt(i);
			
			switch (c) 
			{
				case '0':
					informationGeneree.add(false);
					break;
				case '1':
					informationGeneree.add(true);
					break;
				default :
					throw new InformationNonConforme();
			}
		}
		System.out.println("Information generee par la source fixe : " + informationGeneree.toString());
	}
	
	@Override
			/** 
		 * Pour emettre l'information générée
		 *@throws InformationNonConforme
		 */
	public void emettre() throws InformationNonConforme 
	{

		if(informationGeneree==null)
			throw new InformationNonConforme();
		
		for(DestinationInterface<Boolean> current : destinationsConnectees)
		{
			current.recevoir(informationGeneree);
		}
	}
}
