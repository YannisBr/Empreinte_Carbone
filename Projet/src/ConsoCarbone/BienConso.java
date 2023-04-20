package ConsoCarbone;
import java.util.*;
/**
 * BienConso est une classe caracterisant le poste de consommation carbone de l�utilisateur.rice concernant ses d�penses en biens de consommation.
 * Elle h�rite de la Classe ConsoCarbone.
 * @author Yannis & Mounirou
 *
 */

public class BienConso extends ConsoCarbone{
    private double montant;
    private void makeImpact(){
        this.impact = this.montant / 1750;
    }
    
    /**
     * Constructeur par d�fault permettant d'initialiser un objet de la Classe BienConso.
     * @author Yannis & Mounirou
     *
     */

    public BienConso(){
        super();
        this.montant = 0;
    }
    
    /**
     * Constructeur param�tr� permettant d'initialiser un objet de la Classe BienConso.
     * @param m d�crivant le montant des d�penses annuelles de l�utilisateur.rice.
     * @author Yannis & Mounirou
     */
    
    
    public BienConso(double m){
        super();
        this.montant = m;
        this.makeImpact();
    }
    
    /**
     * Constructeur param�tr� permettant d'initialiser un objet de la Classe BienConso.
     * @param bc  Un objet de la classe BienConso.
     * @author Yannis & Mounirou
     */
    
    
    public BienConso(BienConso bc){
        super();
        this.montant = bc.getMontant();
        this.makeImpact();
    }

    
    /**
     * M�thode permettant l'acc�s en lecture � l'attribut montant d�crivant le montant de l'instance courante.
     * @return Le montant de l'instance courante.
     * @author Yannis & Mounirou
     */
    
    public double getMontant(){
        return this.montant;
    }
    
    
    /**
     * M�thode permettant de demander un changement d'�tat de l'attribut montant de l'instance courante par le parametre m.
     * @param m  Le montant des d�penses annuelles de l'utilisateur.rice.
     * @author Yannis & Mounirou
     */
    
    
    public void setMontant(double m){
        this.montant = m;
    }
    
    
    /**
     * M�thode statique d�taillant sur la console l�empreinte carbone moyenne d�un.e fran�ais.e vis-�-vis de de ses d�penses en biens de consommation.. 
     * @author Yannis & Mounirou
     */
    
    public static void empreinteCarbonneMoyenne(){
        String msg = "Empreinte carbonne moyenne d'un français pour le bien conso en Kg eq CO2 / an\n";
        msg+="Achat et usages / Internet et technologies : 1180\nAutres biens et services : 682\nHabillement : 763\nTotal : 2625";
        System.out.println(msg);
    }
    
    /**
     * {@inheritDoc}
     * On demande  via la console le montant des d�penses annuelles de l'utilisateur.rice concernant ses d�penses en biens de consommation.
     * On cr�e un Scanner "scan" permettant de stocker la valeur indiqu�e par l'utilisateur.rice dans l'attribut montant de l'instance courante.
     * On calcule l'impact  des d�penses en biens de consommation de l�utilisateur.rice en termes d��missions de GES en TCO2eq.
     * @author Yannis & Mounirou
     */
    

    @Override
    public void init(){
        System.out.println("************************BIENCONSO*************************");
        Scanner scan = new Scanner(System.in);
        System.out.print("\nMontant de vos dépenses en bien de consommation: ");
        this.montant = scan.nextDouble();
        this.makeImpact();
    }
    
    
    /**
     * {@inheritDoc}
     * Affiche le montant et l'impact de l'instance courante.
     * @return Cha�ne de caractere d�crivant le montant et l'impact de l'instance courante.
     * @author Yannis & Mounirou
     */
    
    @Override
    public String toString(){
        String msg = super.toString();
        msg+=" / type : bien conso / montant : "+this.getMontant()+" / impact : "+this.impact+" ]";
        return msg;
    }
    
}
