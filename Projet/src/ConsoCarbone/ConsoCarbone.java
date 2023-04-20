package ConsoCarbone;

/**
 * ConsoCarbone est une classe implémentant l'interface Comparable et caracterisant un poste de Consommation Carbone générique.
 * @author Yannis & Mounirou
 *
 */
public class ConsoCarbone implements Comparable{
    
    private static int counter;
    private final int id;
    protected double impact;
    
    /**
     * Constructeur par défault permettant d'initialiser un objet de la Classe ConsoCarbone.
     * @author Yannis & Mounirou
     *
     */

    public ConsoCarbone(){
        counter++;
        this.id = counter;
        this.impact = 0.0;
    }
    
    
    /**
     * Méthode permettant l'accès en lecture à l'attribut id décrivant l'ID de l'instance courante.
     * @return L'ID de l'instance courante.
     * @author Yannis & Mounirou
     */
    public int getId(){
        return this.id;
    }
    
    /**
     * Méthode permettant l'accès en lecture à l'attribut impact décrivant l'impact de l'instance courante.
     * @return L'impact de l'instance courante.
     * @author Yannis & Mounirou
     */
    
    public double getImpact(){
        return this.impact;
    }
    
    /**
     * Méthode permettant de comparer l'objet de type ConsoCarbone en parametre avec l'instance courante en fonction de leurs impacts en termes d’émissions de GES.
     * @param cc Une instance de la classe ConsoCarbone.
     * @author Yannis & Mounirou
     */
    
    public void compare(ConsoCarbone cc){
        if(this.impact > cc.getImpact()){
            System.out.println(this+" a un impact supÃ©rieur Ã  "+cc);
        }else{
            System.out.println(cc+" a un impact supÃ©rieur Ã  "+this);            
        }
    }

    /**
     * Méthode qui va permettre de créer un menu intéractif afin d’intéragir dans la console avec l’utlisateur.rice.
     * @author Yannis & Mounirou
     */
    
    public void init(){}
    
    /**
     * Affiche l'ID de l'instance de courante.
     * @return Chaîne de caractere décrivant l'ID de l'instance.
     * @author Yannis & Mounirou
     */
    
    public String toString(){
        return "[ conso carbone ID: "+this.getId();
    }
    
    
    
 
}
