package ConsoCarbone;
import java.util.*;

/**
 * Logement est une classe caracterisant le poste de consommation Carbone de l'utilisateur concernant son Logement.
 * Elle hérite de la Classe ConsoCarbone.
 * @author Yannis & Mounirou
 *
 */

public class Logement extends ConsoCarbone{
    private int superficie;
    private CE e;
    private void makeImpact(){
        this.impact = this.e.getAlpha() * this.superficie;
    }

    /**
     * Constructeur par défault permettant d'initialiser un objet de la Classe Logement.
     * @author Yannis & Mounirou
     *
     */
    
    public Logement(){
        super();
        this.superficie = 0;
        this.e = CE.G;
    }
    
    /**
     * Constructeur paramétré permettant d'initialiser un objet de la Classe Logement.
     * @param s La superficie du Logement.
     * @param z La classe énergetique du logement.
     * @author Yannis & Mounirou
     * @throws Exception 
     *
     */
    public Logement(int s, CE z) throws Exception{
        super();
        
    	if (s<0)
    		throw new Exception("La superficie doit être une valeur positive.");
        this.superficie = s;
        this.e = z;
        this.makeImpact();;
    }
    
    /**
     * Constructeur paramétré permettant d'initialiser un objet de la Classe Logement.
     * @param l un objet de la classe Logement.
     * @author Yannis & Mounirou
     *
     */
    
    public Logement(Logement l){
        super();
        this.superficie = l.getSuperficie();
        this.e = l.getE();
        this.makeImpact();;
    }

    /**
     * Méthode permettant l'accès en lecture à l'attribut superficie décrivant la superficie de l'instance courante.
     * @return La superficie de l'instance courante.
     * @author Yannis & Mounirou
     */
    public int getSuperficie(){
        return this.superficie;
    }
    
    /**
     * Méthode permettant l'accès en lecture à l'attribut e décrivant la classe energetique de l'instance courante.
     * @return La classe energetique de la classe courante.
     * @author Yannis & Mounirou
     */
    public CE getE(){
        return this.e;
    }
    
    /**
     * Méthode permettant l'accès en lecture à l'attribut ID de l'objet parent.
     * @return L'ID de l'objet parent.
     * @author Yannis & Mounirou
     */
    public int getId(){
        return super.getId();
    }
    
    /**
     * Méthode permettant de demander un changement d'état de l'attribut superficie de l'instance courante par le parametre s.
     * @param s  La superficie du logement de  l'utilisateur.rice.
     * @author Yannis & Mounirou
     * @throws Exception 
     */
    public void setSuperficie(int s) throws Exception{     
    	if (s<0)
    		throw new Exception("La superficie doit être une valeur positive.");
    	
        this.superficie = s;
    }
    
    /**
     * Méthode permettant de demander un changement d'état de l'attribut e de l'instance courante par le parametre z.
     * @param z  La classe energetique du logement de  l'utilisateur.rice.
     * @author Yannis & Mounirou
     */
    public void setE(CE z){
        this.e = z;
    }
    
    /**
     * Méthode statique détaillant sur la console l’empreinte carbone moyenne d’un.e français.e vis-à-vis de l'Alimentation. 
     * @author Yannis & Mounirou
     */
    public static void empreinteCarbonneMoyenne(){
        String msg = "Empreinte carbonne moyenne d'un franÃ§ais pour un logement en Kg eq CO2 / an\n";
        msg+="Energie et utilitÃ©s : 1696\nConstruction et gros entretien : 675\nEquipement des logements : 335\nTotal : 2706";
        System.out.println(msg);
    }


    /**
     * {@inheritDoc}
     * On demande successivement via la console la superifice ainsi que la classe énergetique du Logement de l'utilisateur.rice.
     * On crée un Scanner "scan" permettant de stocker les valeurs indiquées par l'utilisateur dans les attributs de l'instance courante.
     * On calcule l'impact du logement de l’utilisateur.rice en termes d’émissions de GES en TCO2eq.
     * @author Yannis & Mounirou
     */
    
    
    @Override
    public void init(){
        System.out.println("************************LOGEMENT*************************");
        Scanner scan = new Scanner(System.in);
        System.out.print("\nSuperficie: ");
        this.superficie = scan.nextInt();
        System.out.print("\nCE (0->A, 1->B, ..., 6->G): ");
        int s = scan.nextInt();
        if (s == 0){
            this.e = CE.A;
        }else if( s == 1){
            this.e = CE.B;
        }else if( s == 2){
            this.e = CE.C;
        }else if( s == 3){
            this.e = CE.D;
        }else if( s == 4){
            this.e = CE.E;
        }else if( s == 5){
            this.e = CE.F;
        }else{
            this.e = CE.G;
        }
        this.makeImpact();
    }
    
    /**
     * {@inheritDoc}
     * Affiche la superficie, la classe énergetique ainsi que l'impact de l'instance courante.
     * @return Chaîne de caractere décrivant la superficie, la classe energetique ainsi que l'impact de l'instance courante.
     * @author Yannis & Mounirou
     */
    
    @Override
    public String toString(){
        String msg = super.toString();
        msg += " / type : logement / superficie : "+this.getSuperficie()+" / classe : "+this.getE().getCe()+" / impact : "+this.impact+" ]";
        return msg;
    }
}