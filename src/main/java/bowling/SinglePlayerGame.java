package bowling;

import java.util.ArrayList;

/**
 * Cette classe a pour but d'enregistrer le nombre de quilles abattues lors des
 * lancés successifs d'<b>un seul et même</b> joueur, et de calculer le score
 * final de ce joueur
 */
public class SinglePlayerGame {

        public ArrayList score;
        public int tours;
	/**
	 * Constructeur
	 */
	public SinglePlayerGame() {
            tours = 20;
            score = new ArrayList<Integer>();
	}

	/**
	 * Cette méthode doit être appelée à chaque lancé de boule
	 *
	 * @param nombreDeQuillesAbattues le nombre de quilles abattues lors de
	 * ce lancé
	 */
	public void lancer(int nombreDeQuillesAbattues) {
            
            //ajout de deux boules si stike et dernier tour
            if (nombreDeQuillesAbattues==10) {
                tours-=1;  
                if ( tours == 1) {
                    tours+=2;
                }
            }    
                
            tours -= 1;
            this.score.add(nombreDeQuillesAbattues);                 
            
	}
        
        public void spare() {
            
        }
        
        /**
         * Verifie si il y a un strike dans l'arrayList score et si il y en a
         * ajoute le score des deux lancés le suivant
         * @param sc l'arrayList score
         */
        public void strike(ArrayList<Integer> sc) {
            int newValue = 0;  
            
            for (int i = 2; i<sc.size(); i++) {
                if (sc.get(i-2)==10) {
                    newValue = (sc.get(i) + (sc.get(i)-1));
                    sc.set(i-2,newValue);
                }
            }
        }
        
        /**
         * 
         * @param sc une arraylist score
         * @return le score total de type int issue de l'arraylist
         */
        public int total(ArrayList<Integer> sc) {
            int total = 0;
            
            strike(score);
            
            for(int i=0; i<sc.size();i++) {
                total += sc.get(i);
            }
            return total;
        }

	/**
	 * Cette méthode donne le score du joueur
	 *
	 * @return Le score du joueur
	 */
	public int score() {
            return total(this.score);
               
	}
}
