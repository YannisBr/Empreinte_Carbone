package ConsoCarbone;
/**
 * ServicesPublics est une classe caracterisant le poste de consommation Carbone induit par les services publics (justice, police, éducation, santé, ...). 
 * Ce poste de consommation carbone a la particularité que tou.te.s les Français.e.s ont la même empreinte de 1.5TCO2eq pour ce poste de consommation.
 * Elle hérite de la Classe ConsoCarbone.
 * @author Yannis & Mounirou
 *
 */
public final class ServicesPublics extends ConsoCarbone{
    private static ServicesPublics instance = null;
    private void makeImpact(){
        this.impact = 1.5;
    }
    private ServicesPublics(){
        super();
        this.makeImpact();
    }
    
    /**
     * Méthode statique qui pourra éventuellement invoquer le constructeur. 
     * Le design pattern Singleton permettant de s'assurer qu'une classe ne puisse créer qu'une seule unique instance. 
     * @return Objet unique de la classeServicesPublics.
     * @author Yannis & Mounirou
     */

    public static ServicesPublics getInstance(){
        if (instance == null){
            instance = new ServicesPublics();
        }
        return instance;
    }
    
    /**
     * {@inheritDoc}
     * Affiche l'impact de l'instance courante.
     * @return Chaîne de caractere décrivant l'impact de l'instance courante.
     * @author Yannis & Mounirou
     */
    

    public String toString(){
        String msg = super.toString();
        msg += " / type : service public / impact : "+this.getImpact()+" ]";
        return msg;
    }
}
