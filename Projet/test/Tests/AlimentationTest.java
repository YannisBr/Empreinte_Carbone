package Tests;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import ConsoCarbone.Alimentation;

/**
 * Alimentation est une classe de tests JUnit pour la classe Alimentation permettant de réaliser des tests unitaires.
 * @author Yannis & Mounirou
 *
 */

public class AlimentationTest {
	
	private Alimentation alimentation1;
	private Alimentation alimentation2;
    private Alimentation alimentation3;
    private final double a = 8;
    private final double b = 1.6; 
    private final double c = 0.9;
    
    /**
     * Méthode qui sera exécutée avant l'ensemble des tests.
     * Initialise trois Objets de la classe Alimentation avec trois constructeurs différents.
     * @author Yannis & Mounirou
     */
    
    
	@Before
	public void initialiser() throws Exception{
		alimentation1 = new Alimentation();
		alimentation2=new Alimentation(0.5,0.5);
        alimentation3=new Alimentation(new Alimentation(0.6, 0.4));
	}
	
	
    /**
     * Méthode qui sera exécutée apres l'ensemble des tests.
     * Permet de rendre null chaque objet crée.
     * @author Yannis & Mounirou
     */
	
	@After
	public void nettoyer() throws Exception {
	alimentation1 = null;
	alimentation2=null;
	alimentation3=null;
	}
	

	
    /**
     * Test permettant de vérifier que l'objet alimentation1 a bien été crée.
     * Sinon le message "L'instance n'est pas créée" est affiché.
     * @author Yannis & Mounirou
     */
	
	
	
	@Test
	public void testAlimentation1 () {
	assertNotNull("L'instance n'est pas créée",
	alimentation1);
	}
	
    /**
     * Test permettant de vérifier que l'objet alimentation2 a bien été crée.
     * Sinon le message "L'instance n'est pas créée" est affiché.
     * @author Yannis & Mounirou
     */
	
	
	@Test
	public void testAlimentation2() {
	assertNotNull("L'instance n'est pas créée",
	alimentation2);
	}
	
    /**
     * Test permettant de vérifier que l'objet alimentation3 a bien été crée.
     * Sinon le message "L'instance n'est pas créée" est affiché.
     * @author Yannis & Mounirou
     */
	
	
	
	@Test
	public void testAlimentation3() {
	assertNotNull("L'instance n'est pas créée",
	alimentation3);
	}

	
    /**
     * Test permettant de verifier si la méthode getTxBoeuf() appelée par l'instance alimentation1 fonctionne bien.
     * On verifie si on a égalité entre la valeur du Taux de repas à base de Boeuf obtenue via l'appel à la méthode getTxBoeuf() de l'instance alimentation1 et la valeur du taux de repas à base de Boeuf ayant permis de construire l'instance alimentation1. 
     * Sinon le message "Le taux de repas à base de Boeuf est incorrect" est affiché.
     * @author Yannis & Mounirou
     */
	
	@Test
	public void testgetTxBoeuf1() {
	assertEquals("Le taux de repas à base de Boeuf est incorrect",0.0,
	alimentation1.getTxBoeuf(),0.0);
	}
	
	
    /**
     * Test permettant de verifier si la méthode getTxBoeuf() appelée par l'instance alimentation2 fonctionne bien.
     * On verifie si on a égalité entre la valeur du Taux de repas à base de Boeuf obtenue via l'appel à la méthode getTxBoeuf() de l'instance alimentation2 et la valeur du taux de repas à base de Boeuf ayant permis de construire l'instance alimentation2. 
     * Sinon le message "Le taux de repas à base de Boeuf est incorrect" est affiché.
     * @author Yannis & Mounirou
     */
	
	@Test
	public void testgetTxBoeuf2() {
	assertEquals("Le taux de repas à base de Boeuf est incorrect",0.5,
	alimentation2.getTxBoeuf(),0.0);
	
	}
	
    /**
     * Test permettant de verifier si la méthode getTxBoeuf() appelée par l'instance alimentation3 fonctionne bien.
     * On verifie si on a égalité entre la valeur du Taux de repas à base de Boeuf obtenue via l'appel à la méthode getTxBoeuf() de l'instance alimentation3 et la valeur du taux de repas à base de Boeuf ayant permis de construire l'instance alimentation3. 
     * Sinon le message "Le taux de repas à base de Boeuf est incorrect" est affiché.
     * @author Yannis & Mounirou
     */
	
	
	@Test
	public void testgetTxBoeuf3() {
	assertEquals("Le taux de repas à base de Boeuf est incorrect",0.6,
	alimentation3.getTxBoeuf(),0.0);
	}

    /**
     * Test permettant de verifier si la méthode getTxVege() appelée par l'instance alimentation1 fonctionne bien.
     * On verifie si on a égalité entre la valeur du Taux de repas végétariens obtenue via l'appel à la méthode getTxVege() de l'instance alimentation1 et la valeur du taux de repas végétariens ayant permis de construire l'instance alimentation1. 
     * Sinon le message "Le taux de repas végétariens est incorrect" est affiché.
     * @author Yannis & Mounirou
     */
	
	
	@Test
	public void testgetTxVege1() {
	assertEquals("Le taux de repas vegetarien est incorrect", 0.0,
	alimentation1.getTxVege(),0.0);
	}
	

    /**
     * Test permettant de verifier si la méthode getTxVege() appelée par l'instance alimentation2 fonctionne bien.
     * On verifie si on a égalité entre la valeur du Taux de repas végétariens obtenue via l'appel à la méthode getTxVege() de l'instance alimentation2 et la valeur du taux de repas végétariens ayant permis de construire l'instance alimentation2. 
     * Sinon le message "Le taux de repas végétariens est incorrect" est affiché.
     * @author Yannis & Mounirou
     */
	
	
	@Test
	public void testgetTxVege2() {
	assertEquals("Le taux de repas vegetarien est incorrect", 0.5,
	alimentation2.getTxVege(),0.0);
	}
	
    /**
     * Test permettant de verifier si la méthode getTxVege() appelée par l'instance alimentation3 fonctionne bien.
     * On verifie si on a égalité entre la valeur du Taux de repas végétariens obtenue via l'appel à la méthode getTxVege() de l'instance alimentation3 et la valeur du taux de repas végétariens ayant permis de construire l'instance alimentation3. 
     * Sinon le message "Le taux de repas végétariens est incorrect" est affiché.
     * @author Yannis & Mounirou
     */
	
	@Test
	public void testgetTxVege3() {
	assertEquals("Le taux de repas vegetarien est incorrect", 0.4,
	alimentation3.getTxVege(),0.0);
	}
	
    /**
     * Test permettant de verifier si la méthode getId() appelée par l'instance alimentation1 fonctionne bien.
     * On verifie si on a égalité entre la valeur de l'ID obtenue via l'appel à la méthode getId() de l'instance alimentation1 et la valeur de l'ID de l'instance alimentation1 apres son initialisation.
     * Sinon le message "L'ID  est incorrect" est affiché.
     * @author Yannis & Mounirou
     */
	
	
	@Test
    public void testgetId1(){
	assertEquals("L'ID est incorrect",1 ,
	alimentation1.getId(),0.0);
	}
	
    /**
     * Test permettant de verifier si la méthode getId() appelée par l'instance alimentation2 fonctionne bien.
     * On verifie si on a égalité entre la valeur de l'ID obtenue via l'appel à la méthode getId() de l'instance alimentation2 et la valeur de l'ID de l'instance alimentation2 apres son initialisation.
     * Sinon le message "L'ID  est incorrect" est affiché.
     * @author Yannis & Mounirou
     * @return 
     */
	
	
	@Test
    public void testgetId2(){
	assertEquals("L'ID est incorrect",6,
	alimentation2.getId(),0.0);
	}
	
    /**
     * Test permettant de verifier si la méthode getId() appelée par l'instance alimentation3 fonctionne bien.
     * On verifie si on a égalité entre la valeur de l'ID obtenue via l'appel à la méthode getId() de l'instance alimentation3 et la valeur de l'ID de l'instance alimentation3 apres son initialisation.
     * Sinon le message "L'ID  est incorrect" est affiché.
     * @author Yannis & Mounirou
     */
	
	
	@Test
    public void testgetId3(){
	assertEquals("L'ID est incorrect", 12,
	alimentation3.getId(),0.0);
		}
	
    /**
     * Test permettant de verifier si la méthode setTxBoeuf() permet bien de modifier l'etat de l'attribut TxBoeuf de l'instance alimentation1.
     * On modifie l'etat de l'attribut TxBoeuf de l'instance alimentation1 par la méthode setTxBoeuf().
     * On verifie si on a égalité entre la valeur du taux de repas à base de Boeuf obtenue via l'appel à la méthode getTxBoeuf() et la valeur du taux de repas à base de Boeuf introduite en parametre de la méthode setTxBoeuf().
     * Sinon le message Le taux de repas à base de Boeuf est incorrect" est affiché.
     * @author Yannis & Mounirou
     * @throws Exception 
     */
	
	

	@Test
	public void testsetTxBoeuf1() throws Exception {
	alimentation1.setTxBoeuf(0.1);
	assertEquals("Le taux de repas à base de Boeuf est incorrect",
	0.1, alimentation1.getTxBoeuf(),0.0);
	}
	
    /**
     * Test permettant de verifier si la méthode setTxBoeuf() permet bien de modifier l'etat de l'attribut TxBoeuf de l'instance alimentation2.
     * On modifie l'etat de l'attribut TxBoeuf de l'instance alimentation2 par la méthode setTxBoeuf().
     * On verifie si on a égalité entre la valeur du taux de repas à base de Boeuf obtenue via l'appel à la méthode getTxBoeuf() et la valeur du taux de repas à base de Boeuf introduite en parametre de la méthode setTxBoeuf().
     * Sinon le message Le taux de repas à base de Boeuf est incorrect" est affiché.
     * @author Yannis & Mounirou
     * @throws Exception 
     */
	
	
	
	
	@Test
	public void testsetTxBoeuf2() throws Exception {
	alimentation2.setTxBoeuf(0.1);
	assertEquals("Le taux de repas à base de Boeuf est incorrect",
	0.1, alimentation2.getTxBoeuf(),0.0);
	}
	
    /**
     * Test permettant de verifier si la méthode setTxBoeuf() permet bien de modifier l'etat de l'attribut TxBoeuf de l'instance alimentation3.
     * On modifie l'etat de l'attribut TxBoeuf de l'instance alimentation3 par la méthode setTxBoeuf().
     * On verifie si on a égalité entre la valeur du taux de repas à base de Boeuf obtenue via l'appel à la méthode getTxBoeuf() et la valeur du taux de repas à base de Boeufintroduite en parametre de la méthode setTxBoeuf().
     * Sinon le message Le taux de repas à base de Boeuf est incorrect" est affiché.
     * @author Yannis & Mounirou
     * @throws Exception 
     */
	
	
	
	@Test
	public void testsetTxBoeuf3() throws Exception {
	alimentation3.setTxBoeuf(0.1);
	assertEquals("Le taux de repas à base de Boeuf est incorrect",
	0.1, alimentation3.getTxBoeuf(),0.0);
	}

	
    /**
     * Test permettant de verifier si la méthode setTxVege() permet bien de modifier l'etat de l'attribut TxVege de l'instance alimentation1.
     * On modifie l'etat de l'attribut TxVege de l'instance alimentation1 par la méthode setTxVege().
     * On verifie si on a égalité entre la valeur du taux de repas végétariens obtenue via l'appel à la méthode getTxVege() et la valeur du taux de repas végétariens introduite en parametre de la méthode setTxVege().
     * Sinon le message Le taux de repas végétariens est incorrect" est affiché.
     * @author Yannis & Mounirou
     * @throws Exception 
     */
	
	
	
	@Test
	public void testsetTxVege1() throws Exception {
	alimentation1.setTxVege(0.1);
	assertEquals("Le taux de repas vegetariens, est incorrect",
	0.1, alimentation1.getTxVege(),0.0);
	}
	
    /**
     * Test permettant de verifier si la méthode setTxVege() permet bien de modifier l'etat de l'attribut TxVege de l'instance alimentation2.
     * On modifie l'etat de l'attribut TxVege de l'instance alimentation2 par la méthode setTxVege().
     * On verifie si on a égalité entre la valeur du taux de repas végétariens obtenue via l'appel à la méthode getTxVege() et la valeur du taux de repas végétariens introduite en parametre de la méthode setTxVege().
     * Sinon le message Le taux de repas végétariens est incorrect" est affiché.
     * @author Yannis & Mounirou
     * @throws Exception 
     */
	
	
	
	@Test
	public void testsetTxVege2() throws Exception {
    alimentation2.setTxVege(0.1);
	assertEquals("Le taux de repas vegetariens est incorrect",	
	0.1, alimentation2.getTxVege(),0.0);
	}
	
    /**
     * Test permettant de verifier si la méthode setTxVege() permet bien de modifier l'etat de l'attribut TxVege de l'instance alimentation3.
     * On modifie l'etat de l'attribut TxVege de l'instance alimentation3 par la méthode setTxVege().
     * On verifie si on a égalité entre la valeur du taux de repas végétariens obtenue via l'appel à la méthode getTxVege() et la valeur du taux de repas végétariens introduite en parametre de la méthode setTxVege().
     * Sinon le message Le taux de repas végétariens est incorrect" est affiché.
     * @author Yannis & Mounirou
     * @throws Exception 
     */
	
	
	
	@Test
	public void testsetTxVege3() throws Exception {
    alimentation3.setTxVege(0.1);
	assertEquals("Le taux de repas vegetariens est incorrect",
	0.1, alimentation3.getTxVege(),0.0);
	}
	
	
	
    /**
     * Test permettant de verifier si la méthode getImpact() appelée par l'instance alimentation1 fonctionne bien.
     * On verifie si on a égalité entre la valeur de l'impact obtenue via l'appel à la méthode getImpact() de l'instance alimentation1 et la valeur de l'impact obtenu par calcul via l'appel aux méthodes getTxVege() et getTxBoeuf().
     * Sinon le message "L'impact est incorrect" est affiché.
     * @author Yannis & Mounirou
     */
	
	
	@Test
	public void testgetImpact1() {
	assertEquals("L'impact est incorrect", 0.0,
	alimentation1.getImpact(),0.0);
	}
	
    /**
     * Test permettant de verifier si la méthode getImpact() appelée par l'instance alimentation2 fonctionne bien.
     * On verifie si on a égalité entre la valeur de l'impact obtenue via l'appel à la méthode getImpact() de l'instance alimentation2 et la valeur de l'impact obtenu par calcul via l'appel aux méthodes getTxVege() et getTxBoeuf().
     * Sinon le message "L'impact est incorrect" est affiché.
     * @author Yannis & Mounirou
     */
	
	
	@Test
	public void testgetImpact2() {
	assertEquals("L'impact est incorrect", a * alimentation2.getTxBoeuf() + b * (1 - alimentation2.getTxVege() - alimentation2.getTxBoeuf()) + c * alimentation2.getTxVege(),
	alimentation2.getImpact(),0.0);
	}
	
    /**
     * Test permettant de verifier si la méthode getImpact() appelée par l'instance alimentation3 fonctionne bien.
     * On verifie si on a égalité entre la valeur de l'impact obtenue via l'appel à la méthode getImpact() de l'instance alimentation3 et la valeur de l'impact obtenu par calcul via l'appel aux méthodes getTxVege() et getTxBoeuf().
     * Sinon le message "L'impact est incorrect" est affiché.
     * @author Yannis & Mounirou
     */
	
	
	@Test
	public void testgetImpact3() {
	assertEquals("L'impact est incorrect", a * alimentation3.getTxBoeuf() + b * (1 - alimentation3.getTxVege() - alimentation3.getTxBoeuf()) + c * alimentation3.getTxVege(),
	alimentation3.getImpact(),0.0);
	}
	
	
    /**
     * Test permettant de verifier si la méthode toString() appelée par l'instance alimentation1 fonctionne bien.
     * On verifie si on a égalité entre le message affiché via l'appel à la méthode toString() et le message attendu.
     * Sinon le message "Le message affiché est incorrect" est affiché.
     * @author Yannis & Mounirou
     */
	
	
	@Test
    public void testToString1()
    {
	    String msg1="[ conso carbone ID: "+alimentation1.getId();
		String expected1= msg1+" / type : alimentation / taux de repas à base de Boeuf : "+alimentation1.getTxBoeuf()+" / taux de repas végétariens : "+alimentation1.getTxVege()+" / impact : "+alimentation1.getImpact()+" ]";
		assertEquals("Le message affiché est incorrect",expected1, alimentation1.toString());
    }
	
    /**
     * Test permettant de verifier si la méthode toString() appelée par l'instance alimentation2 fonctionne bien.
     * On verifie si on a égalité entre le message affiché via l'appel à la méthode toString() et le message attendu.
     * Sinon le message "Le message affiché est incorrect" est affiché.
     * @author Yannis & Mounirou
     */
	
	@Test
	public void testToString2()
	{
		String msg2="[ conso carbone ID: "+alimentation2.getId();
		String expected2= msg2+" / type : alimentation / taux de repas à base de Boeuf : "+alimentation2.getTxBoeuf()+" / taux de repas végétariens : "+alimentation2.getTxVege()+" / impact : "+alimentation2.getImpact()+" ]";
		assertEquals("Le messsage affiché est incorrect",expected2, alimentation2.toString());
	}
	
    /**
     * Test permettant de verifier si la méthode toString() appelée par l'instance alimentation3 fonctionne bien.
     * On verifie si on a égalité entre le message affiché via l'appel à la méthode toString() et le message attendu.
     * Sinon le message "Le message affiché est incorrect" est affiché.
     * @author Yannis & Mounirou
     */
	
	@Test
	public void testToString3()
	{
		String msg3="[ conso carbone ID: "+alimentation3.getId();
        String expected3= msg3+" / type : alimentation / taux de repas à base de Boeuf : "+alimentation3.getTxBoeuf()+" / taux de repas végétariens : "+alimentation3.getTxVege()+" / impact : "+alimentation3.getImpact()+" ]";
        assertEquals("Le message affiché est incorrect",expected3, alimentation3.toString());
    }

	}
	


