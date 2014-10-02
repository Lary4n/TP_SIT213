import java.util.LinkedList;
import java.util.Random;
/** 
 * Classe realisant l'affichage de la puissance d'une information composee d'elements de type reel (float)
 * @author arzel lepottier
 */
public class SourceAleatoire extends Source <Boolean> 
{
	private Random random;
	/**
	 * Constructeur de la classe SourceAleatoire avec d'une Information logique aléatoire
	 * @param taille : int
	 * @throws InformationNonConforme
	 */
	public SourceAleatoire(int taille) throws InformationNonConforme
	{
		super();
		if(taille<1) throw new InformationNonConforme();
		random = new Random();
		informationGeneree = new Information <Boolean> ();
		
		for(int i = 0; i<taille; i++)
		{
			informationGeneree.add(random.nextBoolean());
		}
		System.out.println("Information generee par la source aleatoire : " + informationGeneree.toString());
	}
	
	/**
	 * Pour emettre l'information générée
	 * @throws InformationNonConforme
	 */
	@Override
	public void emettre() throws InformationNonConforme 
	{
		if (informationGeneree == null)
			throw new InformationNonConforme();
		
		for(DestinationInterface<Boolean> current : destinationsConnectees)
		{
			current.recevoir(informationGeneree);
		}
	}
}