import Utilisateurs.Utilisateur;
import java.util.*;
import ConsoCarbone.*;
/**
 * Test est une classe permettant de cr�er les objets n�cessaires � l'execution du programme et de tester le bon fonctionnement du programme.
 * @author Yannis & Mounirou
 *
 */
public class Test {
	
	/**
	 * La m�thode Main est la premiere fonction execut�e lors du lancement du programme.
	 * @param args tableau de chaines de caract�re.
	 * @author Yannis & Mounirou
	 *
	 */
    public static void main(String[] args) throws Exception{
         BienConso bc = new BienConso(120);
         Logement lo = new Logement(20, CE.A);
         Alimentation a = new Alimentation(0.0,0.6);
         Transport tr = new Transport(true, Taille.G, 2000, 40);
         ArrayList<Transport> t = new ArrayList<Transport>();
         ArrayList<Logement> l = new ArrayList<Logement>();
         t.add(tr);
         l.add(lo); 
         Utilisateur perso1 = new Utilisateur("mon113455",a,bc,t,l);
         Utilisateur perso2 = new Utilisateur();
         Utilisateur perso3 = new Utilisateur(".../test.txt"); // Il faut mettre le bon lien pour le fichier.
         perso2.init();
         System.out.println(perso1);
         System.out.println(perso2);
         System.out.println(perso3);
         perso3.ordonnerConsoCarbonne();
    }    
}



