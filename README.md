# infoprojectgame

Jeu d’Otrio
Description du programme:
D’abord on demande à l'utilisateur combien de joueurs y a-t-il, et on le stocke dans un int. Les nom, couleur et nom de pions restants des joueurs seront stockés dans un tableau monodimensionnel de type de class Player. Cette class est stocké dans un fichier apart, appelé Player.java et il stock deux chaînes de caractères, un tableau pour le nombre de pions restants et leurs identificateurs, et la constructeur de la class, qui prends un valeur int, qui sera utilisé comme identificateur pour les pions de joueurs dans le tableau du jeu. Ici on n’as pas besoin de s’occuper de la vérification que tous les joueurs aient un nombre différent, car ceci est assuré par le boucle for. Notre tableau du jeu est un tableau 3 dimensionnel ou les deux premières dimensions représentent les “coordonnées” XY (plutôt X et -Y) des places et la troisième les tailles. On commence par initialiser le tableau du jeu en mettant des 0 partout. Le jeu se déroule dans une boucle while. Tant que personne n’a gagné le jeu roule. Dans toutes les boucles on affiche le tableau du jeu actuel, et on demande au joueur de placer un pion. On indique également le nombre de pions restants pour le joueur actuel. Pour placer le pion l’utilisateur doit mettre les coordonnées XY de la position dans laquelle il veut placer son pion. Les positions sont indexées du gauche vers la droite et du haut vers le bas. Les coordonnées de la position du haut à gauche est 1 1. Pour que le programme comprenne ces coordonnées il faut mettre un espace entre les deux nombres. Apres les deux coordonnées il faut indiquer la taille du pion á être placé avec p m ou g pour petit, moyen, ou grand.

Description de tous les fonctions:
Dans la class aff
clearOutputStream() est une fonction qui efface tout ce qui est dans le console en utilisant différentes techniques pour différents systèmes d’exploitations (Jamais testé sur Mac OS). Cette fonction est une void car elle ne fait que l’affichage.

printGameTable(int[][][] gameTable) est la fonction qui va afficher notre tableau du jeu avec 3 boucles for imbriquées les unes dans les autres. Cette fonction est une void car elle ne fait que l’affichage.

writePlayerNamesWithColors(int num, Player[] p) Cette fonction affiche les joueurs avec leurs propres couleurs. Cette fonction est une void car elle ne fait que l’affichage.

writePlayerTab(Player p) est la fonction qui écrit tout les information sur un joueur. Cette fonction est une void car elle ne fait que l’affichage.

Dans la class gest
askNumPlayers() cette fonction demande à l'utilisateur combien de joueur y a t il, elle contrôle ce nombre (il faut qu’il soit entre 2 et 4) et puis elle le renvoie.

createPlayers() cette fonction reçoit un nombre (le nombre de joueurs), crée et renvoie un tableau de type Player apres avoir demandé le nom et couleur des joueurs.

initialiseGameTable()

placeElement(int[][][]m ,Player[] Players, int n, char t, int[] coords)
