package Utilisateurs;
import java.io.*;
import java.nio.file.*;
import java.util.*;
import ConsoCarbone.*;
/**
 * Utilisateur est une classe caracterisant l'utilisateur du programme.
 * @author Yannis & Mounirou
 *
 */
public class Utilisateur {
    private ArrayList<Transport> transports = new ArrayList<Transport>();
    private ArrayList<Logement> logements = new ArrayList<Logement>();
    private String numeroSociale;
    private Alimentation alimentation;
    private BienConso bienConso;
    private ServicesPublics servicesPublics = ServicesPublics.getInstance();
    private ArrayList<ConsoCarbone> consosCarbones = new ArrayList<ConsoCarbone>();

    /**
     * Constructeur par défault permettant d'initialiser un Utilisateur.
     * On initialise deux objets Alimentation et BienConso qu'on stocke dans les attributs de l'instance courante.
     * On crée un Scanner "scan" permettant de stocker les valeurs indiquées par l'utilisateur.rice.
     * On demande successivement via la console le nombre de postes de consommation carbone concernant les Transports et de Logements de l'utilisateur.rice.
     * On crée et on ajoute des postes de consommation carbone concernant le transport dans l'attribut transports en fonction du nombre de transports indiqué par l'uilisateur.
     * On crée et on ajoute des postes de consommation carbone concernant le logement dans l'attribut logements en fonction du nombre de logements indiqué par l'uilisateur.
     * On ajoute à l'attribut consosCarbones les postes de consommation carbone concernant l'alimentation, les biens de consommation, les logements, les transports et les services publiques de l'instance courante.
     * @author Yannis & Mounirou
     */


    
    public Utilisateur(){
        this.numeroSociale = "";
        this.alimentation = new Alimentation();
        this.bienConso = new BienConso();
        Scanner scan = new Scanner(System.in);
        int i = 0, j = 0;
        System.out.print("Combien de transports avez-vous: ");
        int trs = scan.nextInt();
        System.out.print("Combien de logements avez-vous: ");        
        int lgs = scan.nextInt();
        while(i < trs ){
            this.transports.add(new Transport());
            i++;
        }
        while(j < lgs){
            this.logements.add(new Logement());
            j++;
        }        
        this.consosCarbones.add(this.alimentation);
        this.consosCarbones.add(this.bienConso);
        int x = 0, y = 0;
        while(x < this.transports.size()){
            this.consosCarbones.add(this.transports.get(x));
            x++;
        }
        while(y < this.logements.size()){
            this.consosCarbones.add(this.logements.get(y));
            y++;
        }
        this.consosCarbones.add(this.servicesPublics);
    }
    
    /**
     * Constructeur paramétré permettant d'initialiser un objet de la Classe Utilisateur à partir d'un fichier Texte.
     * On lit les lignes de notre fichier en faisant appel à la métode readline() du BufferedReader br précédemment crée.
     * On stock successivement ces lignes dans la variable ligne qui va permettre de creer les postes de consommation carbone de l'utilisateur et de les stocker ensuite dans les attributs de l'instance courante.
     * On utilise les méthodes Double.parseDouble() et Integer.parseInt() pour transformer les chaînes de caracteres lues en nombre entier ou décimale.e 
     * @param nomFichier  Chaîne de caractere correspondant au nom du fichier.
     * @author Yannis & Mounirou
     * @throws Exception 
     * @throws NumberFormatException 
     */
    
    
    
    public Utilisateur(String nomFichier) throws NumberFormatException, Exception {
		try {
			System.out.println(nomFichier); 
			BufferedReader br = Files.newBufferedReader(Paths.get(nomFichier));
            ArrayList<Transport> ts = new ArrayList<Transport>();
            ArrayList<Logement> ls = new ArrayList<Logement>();
			String ligne; 
			ligne = br.readLine();
            String nS = ligne;
            ligne = br.readLine();
            String[] taux = ligne.split(" / ");
            Alimentation a = new Alimentation(Double.parseDouble(taux[0]), Double.parseDouble(taux[1]));
            ligne = br.readLine();
            String montant = ligne;
            BienConso b = new BienConso(Double.parseDouble(montant));
            ligne = br.readLine();
            int nbLogements = Integer.parseInt(ligne);
            int i = 0;
            while(i < nbLogements){
                ligne = br.readLine();
                String[] lg = ligne.split(" / "); 
                Logement l;
                int lg1 = Integer.parseInt(lg[1]);
                if(lg1 == 0){
                    l = new Logement(Integer.parseInt(lg[0]), CE.A);
                    ls.add(l);
                }else if(lg1 == 1){
                    l = new Logement(Integer.parseInt(lg[0]), CE.B);
                    ls.add(l);
                }else if(lg1 == 2){
                    l = new Logement(Integer.parseInt(lg[0]), CE.C);
                    ls.add(l);
                }else if(lg1 == 3){
                    l = new Logement(Integer.parseInt(lg[0]), CE.D);
                    ls.add(l);
                }else if(lg1 == 4){
                    l = new Logement(Integer.parseInt(lg[0]), CE.E);
                    ls.add(l);
                }else if(lg1 == 5){
                    l = new Logement(Integer.parseInt(lg[0]), CE.F);
                    ls.add(l);
                }else if(lg1 == 6){
                    l = new Logement(Integer.parseInt(lg[0]), CE.G);
                    ls.add(l);
                }
                i++;
            }
            ligne = br.readLine();
            int nbTransports = Integer.parseInt(ligne);
            int j = 0;
            while(j < nbTransports){
                ligne = br.readLine();
                String[] tr = ligne.split(" / "); 
                Transport t;
                int tr0 = Integer.parseInt(tr[0]);
                if(tr0 == 0){
                    t = new Transport(true, Taille.P, Integer.parseInt(tr[1]), Integer.parseInt(tr[2]));
                    ts.add(t);
                }else if(tr0 == 1){
                    t = new Transport(true, Taille.G, Integer.parseInt(tr[1]), Integer.parseInt(tr[2]));
                    ts.add(t);
                }
                j++;
            }
			br.close();
            this.numeroSociale = nS;
            this.alimentation = a;
            this.bienConso = b;
            this.transports = ts;
            this.logements = ls;
            this.consosCarbones.add(this.alimentation);
            this.consosCarbones.add(this.bienConso);
            int x = 0, y = 0;
            while(x < this.transports.size()){
                this.consosCarbones.add(this.transports.get(x));
                x++;
            }
            while(y < this.logements.size()){
                this.consosCarbones.add(this.logements.get(y));
                y++;
            }
            this.consosCarbones.add(this.servicesPublics);
		} catch (IOException e) {
			System.err.println(e);
		}
	}
    
    
    
    /**
     * Constructeur paramétré permettant d'initialiser un Utilisateur.
     * On stocke les parametres dans les attributs de l'instance courante.
     * On ajoute à l'ArrayList consosCarbones de l'instance courante l'alimentation, le bienConso, les transports, les logements et le servicesPublics de l'instance courante.
     * @param nS le numéro de sécurité sociale de l'utilisateur.rice
     * @param a le poste de consommation Carbone de l'utilisateur.rice concernant son Alimentation.
     * @param b le poste de consommation Carbone de l'utilisateur.rice concernant ses dépenses en biens de consommation.
     * @param ts les postes de consommation carbone l'utilisateur.rice.concernant ses transports
     * @param ls les postes de consommation carbone de l'utilisateur.rice. concernant ses logements.
     * @author Yannis & Mounirou
     */

    
    
    
    public Utilisateur(String nS, Alimentation a, BienConso b, ArrayList<Transport> ts, ArrayList<Logement> ls){
        this.numeroSociale = nS;
        this.alimentation = a;
        this.bienConso = b;
        this.transports = ts;
        this.logements = ls;
        this.consosCarbones.add(this.alimentation);
        this.consosCarbones.add(this.bienConso);
        int x = 0, y = 0;
        while(x < this.transports.size()){
            this.consosCarbones.add(this.transports.get(x));
            x++;
        }
        while(y < this.logements.size()){
            this.consosCarbones.add(this.logements.get(y));
            y++;
        }
        this.consosCarbones.add(this.servicesPublics);
    }
    
    
    /**
     * Constructeur paramétré permettant d'initialiser un Utilisateur à partir d'une instance de la classe Utilisateur.
     * On stocke les attributs du parametre u dans les attributs de l'instance courante.
     * On ajoute à l'ArrayList consosCarbones de l'instance courante l'alimentation, le bienConso, les transports, les logements et le servicesPublics de l'instance courante.
     * @param u Un utilisateur.
     * @author Yannis & Mounirou
     */
    
    public Utilisateur(Utilisateur u){
        this.numeroSociale = u.getNumeroSociale();
        this.alimentation = u.getAlimentation();
        this.bienConso = u.getBienConso();
        this.transports = u.getTransports();
        this.logements = u.getLogements();
        this.consosCarbones.add(this.alimentation);
        this.consosCarbones.add(this.bienConso);
        int x = 0, y = 0;
        while(x < this.transports.size()){
            this.consosCarbones.add(this.transports.get(x));
            x++;
        }
        while(y < this.logements.size()){
            this.consosCarbones.add(this.logements.get(y));
            y++;
        }
        this.consosCarbones.add(this.servicesPublics);
    }

    
    /**
     * Méthode qui va permettre de créer un menu intéractif afin d’intéragir dans la console avec l’utlisateur.rice.
     * On demande  via la console le numéro de securité sociale de l'utilisateur.rice.
     * On crée un Scanner "scan" permettant de stocker la valeur indiquée par l'utilisateur.rice. dans le numeroSociale de l'instance courante.
     * On fait appel à la méthode init() pour chaque consoCarbone stocké dans l'ArrayList consosCarbones de l'instance courante.
     * @author Yannis & Mounirou
     */
    public void init(){
        Scanner scan = new Scanner(System.in);
        System.out.print("Votre numÃ©ro de sÃ©curitÃ© sociale: ");
        this.numeroSociale = scan.nextLine();
        int i = 0;
        while(i < this.consosCarbones.size()){
            this.consosCarbones.get(i).init();
            i++;
        }
    }
    
    
    /**
     * Méthode permettant l'accès en lecture à l'attribut NumeroSociale décrivant le numéro de securité sociale de l'instance courante.
     * @return Le numéro de sécurité sociale de l'instance courante.
     * @author Yannis & Mounirou
     */
    
    public String getNumeroSociale(){
        return this.numeroSociale;
    }
    
    /**
     * Méthode permettant l'accès en lecture à l'attribut Alimentation décrivant le poste de consommation carbone concernant l'Alimentation de l'instance courante.
     * @return Le poste de consommation carbone concernant l'Alimentation de l'instance courante.
     * @author Yannis & Mounirou
     */
    
    public Alimentation getAlimentation(){
        return this.alimentation;
    }
    
    /**
     * Méthode permettant l'accès en lecture à l'attribut BienConso le poste de consommation carbone concernant les biens de consommation de l'instance courante.
     * @returnle Le poste de consommation carbone concernant les biens de consommation de l'instance courante.
     * @author Yannis & Mounirou
     */
    
    
    public BienConso getBienConso(){
        return this.bienConso;
    }
    
    /**
     * Méthode permettant l'accès en lecture à l'attribut Transports décrivant les postes de consommation carbone concernant les Transports de l'instance courante.
     * @return Les postes de consommation carbone concernant les Transports de l'instance courante.
     * @author Yannis & Mounirou
     */
    
    public ArrayList<Transport> getTransports(){
        return this.transports;
    }
    
    /**
     * Méthode permettant l'accès en lecture à l'attribut Logement décrivant les postes de consommation carbone concernant les Logements de l'instance courante.
     * @return Les postes de consommation carbone concernant les Logements de l'instance courante.
     * @author Yannis & Mounirou
     */
    
    public ArrayList<Logement> getLogements(){
        return this.logements;
    }
    
    /**
     * Méthode permettant l'accès en lecture à l'attribut ServicesPublics décrivant le poste de consommation carbone induit par les ervices publics de l'instance courante.
     * @return Le poste de consommation carbone induit par les services publics de l'instance courante.
     * @author Yannis & Mounirou
     */
    
    public ServicesPublics getServicesPublics(){
        return this.servicesPublics;
    }
    
    
    /**
     * Méthode permettant de calculer l’empreinte carbone del’utilisateur.rice.
     * @return La somme des impacts de tous les postes de consommation carbone de l'Utilisateur.rice. en termes d’émissions de GES en TCO2eq.
     * @author Yannis & Mounirou
     */
    

    public double calculerEmpreinte(){
        double som = 0.0;
        int i = 0;
        while(i < this.consosCarbones.size()){
            som += this.consosCarbones.get(i).getImpact();
            i++;
        }  
        return som;
    }
    
    /**
     * Méthode permettant d'afficher sur la console une description détaillée de l’empreinte carbone de l’utilisateur.rice.
     * @return Description détaillée de l’empreinte carbone de l’utilisateur.rice. sous forme d'une chaîne de caractere.
     * @author Yannis & Mounirou
     */
    
    
    public void detaillerEmpreinte(){
        String msg = "DÃ©tail de l'empreinte carbonne de l'utilisateur "+this.getNumeroSociale()+" : \n";
        int i = 0;
        while(i < this.consosCarbones.size()){
            msg += this.consosCarbones.get(i)+"\n";
            i++;
        }
        System.out.println(msg);
    }
    
    
    /**
     * Méthode permettant d'ordonner les postes de consommation carbone de l’utilisateur.rice dans une liste puis de présenter l’information obtenue à ce.tte dernier.e.
     * et fournir des recommendations pour qu'il / elle puisse adopter un mode de vie plus soutenable.
     * On ordonne par ordre croissant les impacts contenus dans tabImpactBis grâce à la méthode sort() de la classe Collections.
     * On parcourt tabImpactBis et on stocke dans la variable o l'indice dans tabImpact de l'impact correspondant dans tabImpactbis.
     * On ajoute dans nvx le poste de consommation carbone d'indice o dans consoscarbones.
     * On réalise la somme des impacts des logements(transports) qu'on stock dans totalL (totalT).
     * En fonction de si l'empreinte carbone de l'utilisateur est superieure ou non à l'empreinte cible, on determine les postes dont l'impact est superieur à l'empreinte cible, le cas échéant on affiche les recommendations.
     * @author Yannis & Mounirou
     */
    
    public void ordonnerConsoCarbonne(){
       ArrayList<ConsoCarbone> nvx = new ArrayList<ConsoCarbone>();
       ArrayList<Double> tabImpact = new ArrayList<Double>();
        int i = 0;
        while (i < this.consosCarbones.size()){
            tabImpact.add(this.consosCarbones.get(i).getImpact());
            i++;
        }
        ArrayList<Double> tabImpactBis = (ArrayList<Double>) tabImpact.clone();
        Collections.sort(tabImpactBis);
        int j = 0;
        while(j < tabImpactBis.size()){
            int o = tabImpact.indexOf(tabImpactBis.get(j));
            nvx.add(this.consosCarbones.get(o));
            j++;
        }
        String msg = "DÃ©tail de l'empreinte carbonne de l'utilisateur "+this.getNumeroSociale()+" : \n";
        int x = 0;
        double total=0.0;
        while(x < nvx.size()){
            msg += nvx.get(x)+"\n";
            total+=nvx.get(x).getImpact();
            x++;
        }
        
        System.out.println(msg);   
        
        
        int y=0, z=0;
        double totalL=0.0,totalT=0.0;
        
        while(y < this.logements.size()){
            totalL+=this.logements.get(y).getImpact();
            y++;
        }
         
        while(z < this.transports.size()){
                totalT+=this.transports.get(z).getImpact();
                z++;
         }
        

    	System.out.println("Les services publics à eux-seuls représentent 1.5 tCO2 eq soit l'empreinte carbone maximale par Français " + "\n"
    			+ "Il est donc nécessaire de modifier profondément le fonctionnement de l’État et de toutes les collectivités." + " \n"
    			+ "Leur empreinte carbone dépend moins de votre action personnelle que les autres postes et nécessite logiquement" 
    			+ " des actions collectives d’envergure pour réduire l'impact de ces services à 0.297 tCO2 eq. " + "\n");

    	double TotalTrue = total-this.servicesPublics.getImpact();
        double cible = 1.625-0.297;
        double diff=TotalTrue-cible;
        
    	
    	System.out.println("Pour chaque personne, notre empreinte cible est de 1.625 tCO2 eq /an dont 0.297 tCO2 eq /an pour les services publics." + "\n" +
    	                   "Ainsi notre empreinte cible pour vous personnellement est de " + cible +" tCO2 eq /an." + "\n\n");
    	
        System.out.println("Afin d'obtenir un mode de vie plus durable, nous vous proposons les recommendations suivantes : \n");
        

        if (TotalTrue<=cible) {
        	System.out.println("Votre empreinte carbone est de" + TotalTrue + "tCO2 eq / an " + ", elle est en dessous de notre empreinte cible qui est de " + cible +"tCO2 eq/an" +" : nous vous suggerons de garder les mêmes bonnes habitudes. \n");
        }
        else  {  	
        	System.out.println("Votre empreinte carbone est de " + TotalTrue + " tCO2 eq/an" + ", elle est au dessus de notre empreinte cible qui est de " + cible +" tCO2 eq /an : nous vous proposons de réduire votre impact de "+ diff + " tCO2 eq/an. \n");
        	if(this.alimentation.getImpact()>0.215) {
        		System.out.println("Concernant votre alimentation : seule une alimentation basée essentiellement sur les produits végétaux permet une"
        				+ " empreinte carbone alimentaire compatible avec nos estimations," + "\n" + "nous vous proposons de  manger de la viande au plus une à deux fois par mois, "
        				+ "de s’alimenter de produits bio++ locaux de saison et de réduire votre consommation en produits laitiers.\n");		
        	}
        	
        	if (this.bienConso.getImpact()>0.262) {
        		System.out.println("Concernant vos dépenses en biens de consommation : la dépense de 2 000 € à 5 000 € de « biens neufs standards » entraîne l’émission de 2 t CO2 eq," +"\n" 
        				+ "soit tout le budget carbone soutenable pour une personne pendant un an."
        				+ " Nous vous proposons donc de dépenser peu (moins de "
        				+ "100 € par mois), d’acheter essentiellement d’occasion et de faire durer les objets.\n");
        	}
        	
        	
        	if (totalT>0.500) { 
        		System.out.println("Concernant vos déplacements : la voiture (même petite) dans son utilisation actuelle n’est pas compatible avec les enjeux climatiques. " +"\n"
        				+ "Nous vous recommandons de moins rouler,  partager les véhicules et les faire durer pendant longtemps." + "\n"
        				+ "La seule hypothèse viable pour un monde bas carbone est de rouler 0 à 2000 km par an avec une petite voiture amortie sur 30 ans.\n");
        	}
        	
        	if (totalL>0.141) { 
        		System.out.println("Concernant vos logements : nous vous conseillons de bien les isoler, "
        				+ "d'utiliser de l'énergie deux fois moins carbonée (ENR)," + "\n"
        				+ "de n'utiliser que des materiaux bissourcés locaux" 
        				+ "et de limiter les équipements (électroménager, mobilier) en les faisant durer plus longtemps.");	
        	}
        	

        }
        
    }
    
    
    /**
     * Affiche le numéro de securité sociale de l'utilisateur ainsi que le détail de son empreinte carbone.
     * @return Numéro de sécurité Sociale et description détaillée de l’empreinte carbone de l’utilisateur.rice. sous forme d'une chaîne de caractere.
     * @author Yannis & Mounirou
     */
    
    
    public String toString(){
        String msg = "Je suis l'utilisateur: "+this.getNumeroSociale();
        int i = 0;
        while(i < this.consosCarbones.size()){
            msg+="\n"+this.consosCarbones.get(i);
            i++;
        }
        msg+="\nJ'ai un impact total de: "+this.calculerEmpreinte();
        return msg;
    }

}
