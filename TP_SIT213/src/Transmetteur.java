   import java.util.*;

/** 
 * Classe Abstraite d'un composant transmetteur d'informations dont les �l�ments sont de type R en entr�e et de type E en sortie;
 * l'entr�e du transmetteur impl�mente l'interface DestinationInterface, 
 * la sortie du transmetteur impl�mente l'interface SourceInterface
 * @author prou
 */
    public abstract  class Transmetteur <R,E> implements  DestinationInterface <R>, SourceInterface <E> {
   
   
   /** 
   * la liste des composants destination connectes en sortie du transmetteur 
   */
      protected LinkedList <DestinationInterface <E>> destinationsConnectees;
   
   /** 
   * l'information recue en entree du transmetteur     */
      protected Information <R>  informationRecue;
		
   /** 
   * l'information emise en sortie du transmetteur  
   */		
      protected Information <E>  informationEmise;

   
   /** 
   * un constructeur factorisant les initialisations communes aux realisations de la classe abstraite Transmetteur 
   */
       public Transmetteur() {
         destinationsConnectees = new LinkedList <DestinationInterface <E>> ();
         informationRecue = null;
         informationEmise = null;
      }

     
   	
   /**
    * pour obtenir la derniere information recue en entree du transmetteur
    * @return une information   
    */
       public Information <R>  getInformationRecue() {
         return this.informationRecue;
      }

   /**
    * pour obtenir la derniere information emise en sortie du transmetteur
	 * @return une information   
    */
       public Information <E>  getInformationEmise() {
         return this.informationEmise;
      }
 

   /**
    * pour connecter une  destination a la sortie du transmetteur 
    * @param destination  la destination a connecter
	 */
       public void connecter (DestinationInterface <E> destination) {
         destinationsConnectees.add(destination); 
      }

   
   /**
    * pour deconnecter une  destination de la la sortie du transmetteur 
    * @param destination  la destination a connecter
    */
       public void deconnecter (DestinationInterface <E> destination) {
         destinationsConnectees.remove(destination); 
      }

   	    
   /**
    * pour recevoir une information  de la source qui  est connectee a l'entree du transmetteur; 
	 * Cette methode devra, en fin d'execution, appeller la methode emettre.
    * @param information  l'information  a recevoir
    */
       public  abstract void recevoir(Information <R> information) throws InformationNonConforme;
      
   
    /**
    * pour �mettre l'information  contenue dans l'entr�e du transmetteur  
    */
      public  abstract void emettre() throws InformationNonConforme;   
   }