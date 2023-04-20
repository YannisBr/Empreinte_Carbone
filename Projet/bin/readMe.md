**Présentation :

L’objectif de ce projet est de réaliser un calculateur d’empreinte carbone. 

Le programme interagit avec l’individu (ou utilisateur) via la console 
ou via un fichier texte pour obtenir des informations sur son alimentation, 
ses dépenses, ses logements, ses transports …

Grâce ces informations, le programme calcule l’empreinte carbone de l’utilisateur 
en tonnes de CO2 équivalent (TCO2eq) et lui fournit des recommandations 
pour adopter un mode de vie plus durable.


...

** Compilation

•   Pour compiler le projet à partir du terminal, vous vous dirigez sans le dossier src compris dans 
    le projet puis vous executer la commande suivate: javac Test.java

•   Pour compiler le projet à partir d'un IDE, il faut juste exécuter le fichier Test.java 
    (la copilation se dait tout seul)

** Execution

•   Pour exécuter le projet à partir du terminal, vous vous dirigez sans le dossier src compris dans 
    le projet puis vous executer la commande suivate: java Test

•   Pour exécuter le projet à partir d'un IDE, il faut juste exécuter le fichier Test.java 


...

Au niveau de la classe Test, plusieurs méthodes :

•	Méthode 1 : créer un utilisateur et faire appel à la méthode OrdonnerConsoCarbonne() 
        qui permet d’obtenir le détail de l'empreinte carbone et des recommandations 
       pour avoir un mode de vie plus soutenable.

•	Méthode 2 :  créer un utilisateur, faire appel à la méthode init() qui permet de créer 
        un Menu interactif afin d'interagir avec la console pour entrer 
        les informations, puis faire appel à la méthode OrdonnerConsoCarbonne() 
        pour obtenir le détail de l'empreinte carbone et des recommandations 
        pour avoir un mode de vie plus soutenable.

•	Méthode 3 : créer un utilisateur à partir d’un fichier texte, 
        puis faire appel à la méthode OrdonnerConsoCarbonne() 
        pour obtenir le détail de son empreinte carbone et des recommandations 
        pour avoir un mode de vie plus soutenable.