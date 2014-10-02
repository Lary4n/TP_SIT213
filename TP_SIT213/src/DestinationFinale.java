
public class DestinationFinale extends Destination <Boolean>
{
	@Override
	public void recevoir(Information information) throws InformationNonConforme 
	{
		informationRecue = information;
		
	}
}
