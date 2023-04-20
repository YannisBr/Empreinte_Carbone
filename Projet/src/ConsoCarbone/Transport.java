package ConsoCarbone;
import java.util.*;

/**
 * Transport est une classe caracterisant le poste de consommation Carbone de l'utilisateur concernant le Transport.
 * Elle hérite de la Classe ConsoCarbone.
 * @author Yannis & Mounirou
 *
 */
public class Transport extends ConsoCarbone{
    private boolean possede;
    private Taille taille;
    private int killoAnnee;
    private int amortissement;
    private void makeImpact(){
        this.impact = 0;
        if (this.possede){
            this.impact = (this.killoAnnee * 1.93 * Math.pow(10,-4)) + (this.taille.getGes() / this.amortissement);
        }
    }
    
    /**
     * Constructeur par défault permettant d'initialiser un objet de la Classe Transport.
     * @author Yannis & Mounirou
     *
     */

    public Transport(){
        super();
        this.possede = false;
        this.taille = null;
        this.killoAnnee = 0;
        this.amortissement = 0;
    }
    
    /**
     * Constructeur paramétré permettant d'initialiser un objet de la Classe Transport.
     * @param p Indiquant si l'utilisateur.rice. possede une voiture.
     * @param t Décrivant la taille du vehicule de l'utilisateur.rice.
     * @param k Décrivant le nombre de kilometres parcourus par an.
     * @param a Décrivant la durée de conservation du vehicule.
     * @author Yannis & Mounirou
     * @throws Exception 
     *
     */
    public Transport(boolean p, Taille t, int k, int a) throws Exception{
        super();
        
    	if (k<0)
    		throw new Exception("Le nombre de kilometres parcourus doit être une valeur positive.");
    	
    	if (a<0)
    		throw new Exception("La durée de conservation du vehicule doit être une valeur positive.");
    	
        this.possede = p;
        this.taille = t;
        this.killoAnnee = k;
        this.amortissement = a;
        this.makeImpact();
    }
    
    /**
     * Constructeur paramétré permettant d'initialiser un objet de la Classe Transport.
     * @param t Objet de la Classe Transport
     * @author Yannis & Mounirou
     *
     */
    public Transport(Transport t){
        super();
        this.possede = t.getPossede();
        this.taille = t.getTaille();
        this.killoAnnee = t.getKilloAnnee();
        this.amortissement = t.getAmortissement();
        this.makeImpact();
    } 

    
    /**
     * Méthode permettant l'accès en lecture à l'attribut possede indiquant si l'utilisateur.rice possede une voiture.
     * @return Vrai si l'utilisateur.rice possede une voiture, faux sinon.
     * @author Yannis & Mounirou
     */
    
    public boolean getPossede(){
        return this.possede;
    }
    
    /**
     * Méthode permettant l'accès en lecture à l'attribut taille décrivant la taille du vehicule de l'utilisateur.
     * @return La taille du vehicule.
     * @author Yannis & Mounirou
     */
    
    
    public Taille getTaille(){
        return this.taille;
    }
    
    
    /**
     * Méthode permettant l'accès en lecture à l'attribut KilloAnnee indiquant le nombre de kilometres parcourus par an.
     * @return Le nombre de kilometres parcourus par an.
     * @author Yannis & Mounirou
     */
    
    public int getKilloAnnee(){
        return this.killoAnnee;
    }
    
    /**
     * Méthode permettant l'accès en lecture à l'attribut Amortissement indiquant la durée de conservation du vehicule.
     * @return La durée de conservation du vehicule.
     * @author Yannis & Mounirou
     */
    public int getAmortissement(){
        return this.amortissement;
    }
    
    /**
     * Méthode permettant de demander un changement d'état de l'attribut possede de l'instance courante par le parametre p.
     * @param p  Booléen décrivant le fait que l'utilisateur.rice. possede ou non une voiture.
     * @author Yannis & Mounirou
     */
    
    public void setPossede(boolean p){
        this.possede = p;
    }
    
    /**
     * Méthode permettant de demander un changement d'état de l'attribut taille de l'instance courante par le parametre t.
     * @param t  Taille décrivant la taille du vehicule de l'utilisateur.rice.
     * @author Yannis & Mounirou
     */
    
    public void setTaille(Taille t){
        this.taille = t;
    }
    
    /**
     * Méthode permettant de demander un changement d'état de l'attribut killoaAnnee de l'instance courante par le parametre k.
     * @param k Entier décrivant le nombre de kilometres parcourus par an.
     * @author Yannis & Mounirou
     * @throws Exception 
     */
    
    public void setKilloAnnee(int k) throws Exception{
    	
    	if (k<0)
    		throw new Exception("Le nombre de kilometres parcourus doit être une valeur positive.");
    	
        this.killoAnnee = k;
    }
    
    /**
     * Méthode permettant de demander un changement d'état de l'attribut amortissement de l'instance courante par le parametre a.
     * @param  a Entier décrivant la durée de conservation du vehicule.
     * @author Yannis & Mounirou
     * @throws Exception 
     */
    
    
    public void setAmortissement(int a) throws Exception{
    	if (a<0)
    		throw new Exception("La durée de conservation du vehicule doit être une valeur positive.");
    	
        this.amortissement = a;
    }
    
    
    /**
     * Méthode statique détaillant sur la console l’empreinte carbone moyenne d’un.e français.e vis-à-vis des transports. 
     * @author Yannis & Mounirou
     */
    
    public static void empreinteCarbonneMoyenne(){
        String msg = "Empreinte carbonne moyenne d'un franÃ§ais pour le transport en Kg eq CO2 / an\n";
        msg+="Voiture : 1972\nAvion : 480\nFret et messagerie : 383\nTrain et bus : 85\nTotal : 2920";
        System.out.println(msg);
    }

    
    /**
     * {@inheritDoc}
     * On demande successivement via la consoles si l'utilisateur.rice possede ou non une voiture, le nombre de kilometres parcourus par an, la durée de conservation et la taille du vehicule.
     * On crée un Scanner "scan" permettant de stocker les valeurs indiquées par l'utilisateur.rice. dans les attributs de l'instance courante.
     * On calcule l'impact des déplacements de l’utilisateur.rice en termes d’émissions de GES en TCO2eq.
     * @author Yannis & Mounirou
     */
    
    @Override
    public void init(){
        System.out.println("************************TRANSPORT*************************");
        Scanner scan = new Scanner(System.in);
        System.out.print("\nPossÃ©dez vous une voiture ? (0->oui, 1->non): ");
        int p = scan.nextInt();
        System.out.println(p);
        if(p == 0){
            this.possede = true;
        }else{
            this.possede = false;
        }
        System.out.print("\nKillomÃ©trage Ã  l'annÃ©e: ");
        this.killoAnnee = scan.nextInt();
        System.out.print("\nAmortissement: ");
        this.amortissement = scan.nextInt();
        System.out.print("\nTaille (0->petite taille, 1->grande taille): ");
        int t = scan.nextInt();
        if(t == 0){
            this.taille = Taille.P;
        }else if (t == 1){
            this.taille = Taille.G;
        }else{
            this.taille = null;
        }
        this.makeImpact();
    }
    
    
    /**
     * {@inheritDoc}
     * Affiche la taille, le nombre de kilometres parcourus par an, la durée de conservation du vehicule (si l'utilisateur possede une voiture), ainsi que l'impact des déplacements de l'instance courante.
     * @return Chaîne de caractere décrivant la taille, le nombre de kilometres parcourus par an, la durée de conservation du vehicule (si l'utilisateur possede une voiture), ainsi que l'impact des déplacements de l'instance courante..
     * @author Yannis & Mounirou
     */
    
    
    @Override
    public String toString(){
        if(possede){
            String msg = super.toString();
            msg+=" / type : transport / taille : "+this.getTaille().getTaille()+" / killomÃ©trage : "+this.getKilloAnnee()+" / amortissement : "+this.getAmortissement()+" / impact : "+this.impact+" ]";
            return msg;
        }
        return "";
    }
}
