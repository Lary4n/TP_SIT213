
/** 
 * Classe Abstraite d'un composant destination d'informations dont les elements sont de type T 
 * @author prou
 */
    public  abstract class Destination <T> implements DestinationInterface <T> {
   
   
   
   /** 
   * l'information recue par la destination 
   */
      protected Information <T>  informationRecue;
   	 
   /** 
   * un constructeur factorisant les initialisations communes aux realisations de la classe abstraite Destination 
   */
       public Destination() {
         informationRecue = null;
      }

   /**
    * pour obtenir la derniere information recue par la destination
    * @return une information   
    */
       public Information  <T>  getInformationRecue() {
         return this.informationRecue;
      }
   	    
   /**
    * pour recevoir une information  de la source qui nous est connectee 
    * @param information  l'information  a recevoir
    */
       public  abstract void recevoir(Information <T> information) throws InformationNonConforme;  
   
   
   
   }