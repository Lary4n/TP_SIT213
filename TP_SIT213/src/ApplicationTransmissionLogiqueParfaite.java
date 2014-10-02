/**
   * Classe contenant le main de notre application de transmission logique parfaite	
   * @author Alexis Le Pottier; Jordan Arzel
   * @version 1.0

*/

public class ApplicationTransmissionLogiqueParfaite 
{  
	
	/**
 	* M�thode main de l'application
 	*/

	public static void main (String [] args) 
	{
		/**
     	* Utilisation de la sonde
     	*/
		
		boolean utilisationSonde = false;
		
		/**
     	* D�claration d'une sonde logique
     	*/
		
		Source<Boolean> source = null;
		/**
     	* Parcours des arguments et d�claration d'une source al�atoire
     	* Ou d�claration d'une source fixe (message pass� en param�tre)
     	* "-s" : utilisation de la sonde
     	* "-mess" : message envoy�
     	* 
     	*/
		for (int i = 0; i < args.length; i++) 
		{
			if (args[i].equals("-s"))
				utilisationSonde = true;

			else if (args[i].equals("-mess")) 
			{
				if (i+1 < args.length && !args[i+1].equals("-s")) 
				{
					if (args[i+1].length() <= 6) 
					{
						int size = 0; 
						try
						{
							size  = Integer.parseInt(args[i+1]);
						}
						catch (Exception e) 
						{
							e.printStackTrace();
						}
						try
						{
							source = new SourceAleatoire(size);
						}
						catch (InformationNonConforme e) 
						{
							e.printStackTrace();
						}
					} 
					else 
					{
						try 
						{
							source = new SourceFixe(args[i+1]);
						} 
						catch (InformationNonConforme e) 
						{
							e.printStackTrace();
						}
					}
						
				}
			}
		}

		if (source == null) 
		{
			try
			{
				source = new SourceAleatoire(100);
			}
			catch (InformationNonConforme e) 
			{
				e.printStackTrace();
			}
		}
		
		/**
     	* Canal de transmission parfait
     	*/
		
		TransmetteurParfait<Boolean, Boolean> transmetteur = new TransmetteurParfait<Boolean, Boolean>();

		/**
		 * R�cepteur final
		 */
		DestinationFinale destination = new DestinationFinale();
		
		/**
		 * Sonde logique au niveau de la source 
		 */
		
		SondeLogique sondeSource = new SondeLogique("Sonde Source");
	
		/**
		 * Sonde logique au niveau du transmetteur 
		 */
		
		SondeLogique sondeTransmetteur = new SondeLogique("Sonde Transmetteur");
		
		/**
		 * Connexion de la source au transmetteur
		 */
		source.connecter(transmetteur);
		
		if (utilisationSonde)
			/**
			 * Connexion de la sonde au niveau de la source  
			 */
			source.connecter(sondeSource);
		/**
		 * Connexion du transmetteur au r�cepteur final 
		 */

		transmetteur.connecter(destination);
		
		if (utilisationSonde)
			/**
			 * Connexion de la sonde au niveau du transmetteur 
			 */
			transmetteur.connecter(sondeTransmetteur);
		
		try 
		{	
			/**
			 * Emission du message 
			 */
			source.emettre();
			if (utilisationSonde)
				System.out.println("TEB : " + TEB(sondeSource, sondeTransmetteur) * 100 + "%");
		} 
		catch (InformationNonConforme e) 
		{
			e.printStackTrace();
		}


	}
	
	/**
	 * Pour calculer le Taux d'Erreur Binaire (TEB) 
	 * @param sonde logique source 
	 * @param sonde logique destinataire
	 * @return TEB
	 */

	private static double TEB (Sonde<Boolean> source, Sonde<Boolean> dest) 
	{
		int tailleMessageEmis = source.getInformationRecue().nbElements();
		int tailleMessageRecu = dest.getInformationRecue().nbElements();
		int taille = Math.min(tailleMessageEmis, tailleMessageRecu);

		int nombreErreurs = 0;

		for (int i = 0; i < taille; i++) 
		{
			if (!source.getInformationRecue().iemeElement(i).equals(dest.getInformationRecue().iemeElement(i)))
				nombreErreurs++;
		}

		nombreErreurs += Math.abs(tailleMessageEmis - tailleMessageRecu);

		return nombreErreurs / tailleMessageEmis;
	}
}
