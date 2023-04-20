package ConsoCarbone;
import java.util.*;

/**
 * Alimentation est une classe caracterisant le poste de consommation Carbone de l'utilisateur concernant son Alimentation.
 * Elle hérite de la Classe ConsoCarbone.
 * @author Yannis & Mounirou
 *
 */
public class Alimentation extends ConsoCarbone{
    private double txBoeuf, txVege;
    private final double a = 8, b = 1.6, c = 0.9;
    private void makeImpact(){
        this.impact = this.a * this.txBoeuf + this.b * (1 - this.txVege - this.txBoeuf) + this.c * this.txVege;
    }

    /**
     * Constructeur par défault permettant d'initialiser un objet de la Classe Alimentation.
     * @author Yannis & Mounirou
     *
     */
    public Alimentation(){
        super();
        this.txBoeuf = 0.0;
        this.txVege = 0.0;
    }
    
    /**
     * Constructeur paramétré permettant d'initialiser un objet de la Classe Alimentation.
     * @param txB décrivant le taux de repas (une valeur entre 0 et 1) à base de boeuf de l'utilisateur.rice.
     * @param  txV décrivant le taux de repas (une valeur entre 0 et 1) végétariens de l'utilisateur.rice.
     * @author Yannis & Mounirou
     * @throws Exception 
     *
     */
    public Alimentation(double txB, double txV) throws Exception  {
    	super();
    	
    	if (txB<0 || txB>1)
    		throw new Exception("La valeur du taux de repas à base de Boeuf doit être comprise entre 0 et 1");
    	
    	if (txV<0 || txV>1)
    		throw new Exception("La valeur du taux de repas vegetariens doit être comprise entre 0 et 1");
    	
        this.txBoeuf = txB;
        this.txVege = txV;
        this.makeImpact();
    }
    
    /**
     * Constructeur paramétré permettant d'initialiser un objet de la Classe Alimentation à partir d'une instance de la classe Alimentation :
     * @param a un poste de consommation carbone concernant l'Alimentation.
     * @author Yannis & Mounirou
     */
    
    public Alimentation(Alimentation a){
        super();
        this.txBoeuf = a.getTxBoeuf();
        this.txVege = a.getTxVege();
        this.makeImpact();
    }

    /**
     * Méthode permettant l'accès en lecture à l'attribut txBoeuf décrivant le taux de repas (une valeur entre 0 et 1) à base de boeuf de l'instance courante.
     * @return le Taux de repas à base de Boeuf de l'instance courante.
     * @author Yannis & Mounirou
     */
    
    public double getTxBoeuf(){
        return this.txBoeuf;
    }
    
    /**
     * Méthode permettant l'accès en lecture à l'attribut txVege décrivant le taux de repas végétariens de l'instance courante.
     * @return le taux de repas vegetariens de l'instance courante.
     * @author Yannis & Mounirou
     */
    public double getTxVege(){
        return this.txVege;
    }
    
    /**
     * Méthode permettant l'accès en lecture à l'attribut ID correspondant à un identifiant unique attribué à l'objet parent.
     * @return l'ID de l'objet parent.
     * @author Yannis & Mounirou
     */
    
    public int getId(){
        return super.getId();
    }
    
    /**
     * Méthode permettant de demander un changement d'état de l'attribut txBoeuf de l'instance courante par le parametre txB.
     * @param txB  Le taux de repas (une valeur entre 0 et 1) à base de boeuf de l'utilisateur.rice.
     * @author Yannis & Mounirou
     * @throws Exception 
     */
    
    public void setTxBoeuf(double txB) throws Exception{
    	
    	if (txB<0 || txB>1)
    		throw new Exception("La valeur du taux de repas à base de Boeuf doit être comprise entre 0 et 1");
    	
        this.txBoeuf = txB;
        
    }
    
    /**
     * Méthode permettant de demander un changement d'état de l'attribut txVege de l'instance courante par le parametre txV.
     * @param txV  Le taux de repas végétariens de l'utilisateur.rice.
     * @author Yannis & Mounirou
     * @throws Exception 
     */
    
    public void setTxVege(double txV) throws Exception{
    	if (txV<0 || txV>1)
    		throw new Exception("La valeur du taux de repas vegetariens  doit être comprise entre 0 et 1");
        this.txVege = txV;
    }
    
    /**
     * Méthode statique détaillant sur la console l’empreinte carbone moyenne d’un.e français.e vis-à-vis de l'Alimentation. 
     * @author Yannis & Mounirou
     */
    
    public static void empreinteCarbonneMoyenne(){
        String msg = "Empreinte carbonne moyenne d'un franÃ§ais pour l'alimentation en Kg eq CO2 / an\n";
        msg+="Viandes et poissons : 1144\nProduit laitiers et oeufs : 408\nAutes : 538\nBoissons : 263\nTotal : 2353";
        System.out.println(msg);
    }
    

    /**
     * {@inheritDoc}
     * On demande successivement via la console les Taux de repas à base de Boeuf et végétariens de l'utilisateur.rice.
     * On crée un Scanner "scan" permettant de stocker les valeurs indiquées par l'utilisateur.rice. dans les attributs de l'instance courante.
     * On calcule l'impact de l’alimentation de l’utilisateur.rice en terme d’émissions de GES en TCO2eq.
     * @author Yannis & Mounirou
     */
    
    
    @Override
    public void init(){
        System.out.println("************************ALIMENTATION*************************");
        Scanner scan = new Scanner(System.in);
        System.out.print("\nTaux de repas Ã  base de boeuf (en pourcentage): ");
        this.txBoeuf = scan.nextDouble()/100;
        System.out.print("\nTaux de repas végétariens (en pourcentage): ");
        this.txVege = scan.nextDouble()/100;
        this.makeImpact();
    }
    
    /**
     * {@inheritDoc}
     * Affiche le Taux de repas à base de Boeuf, le taux de repas végétariens ainsi que l'impact de l'instance courante.
     * @return Chaîne de caractere décrivant le Taux de repas à base de Boeuf, le taux de repas végétariens ainsi que l'impact de l'instance courante.
     * @author Yannis & Mounirou
     */
    
    
    @Override
    public String toString(){
        String msg = super.toString();
        msg+=" / type : alimentation / taux de repas à base de Boeuf : "+this.getTxBoeuf()+" / taux de repas végétariens : "+this.getTxVege()+" / impact : "+this.impact+" ]";
        return msg;
    }
}