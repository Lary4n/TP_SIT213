
/** 
 * Classe assurant le relais pour l'information re�ue de la source vers la ou les destination(s) connect�es 
 * @author arzel lepottier
 */
public class TransmetteurParfait<R,T> extends Transmetteur<R,T>
{
	@Override
	/** 
	 * Pour recevoir l'info et l'�mettre � nouveau 
	 * @param information 
	 * @throws InformationNonConforme
	 */
	public void recevoir(Information<R> information) throws InformationNonConforme 
	{
		if(information==null) 
			throw new InformationNonConforme();
		informationRecue=information;
		emettre();
	}
	
	@Override
	/** 
	 * Pour �mettre � ou aux destinations connect�es 
	 * @throws InformationNonConforme
	 */
	public void emettre() throws InformationNonConforme 
	{
		if (informationRecue == null)
			throw new InformationNonConforme();
		
		Information<T> info = (Information<T>) informationRecue;
		for(int i=0;i<destinationsConnectees.size();i++)
		{
			destinationsConnectees.get(i).recevoir(info);
		}
		informationEmise = info;	
	}
}