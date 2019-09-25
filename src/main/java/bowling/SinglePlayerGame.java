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
            tours = 19;
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
                if (tours == 1) {
                    tours+=2;
                }
            }    
                
            this.score.add(nombreDeQuillesAbattues);
            tours -= 1;
            
	}
        
        public int spare(ArrayList<Integer> sc) {
            int spareValue = 0;
            
            for (int i = 2; i<sc.size(); i++) {
            	if ((sc.get(i-2)+sc.get(i-1))==10 && sc.get(i-1)!=10 && sc.get(i-2)!=10 && this.tours%2!=0) {
            		spareValue += sc.get(i);
            	}	
            }
            return spareValue;
        }
        
        /**
         * Verifie si il y a un strike dans l'arrayList score et si il y en a
         * ajoute le score des deux lancés le suivant
         * @param sc l'arrayList score
         */
        public int strike(ArrayList<Integer> sc) {
            int strikeValue = 0;  
            for (int i = 2; i<sc.size()-1; i++) {
                if (sc.get(i-2)==10 ) {
                    strikeValue += (sc.get(i) + (sc.get(i-1)));
                }
            }
            return strikeValue;
        }
        
        /**
         * 
         * @param sc une arraylist score
         * @return le score total de type int issue de l'arraylist
         */
        public int total(ArrayList<Integer> sc) {
            int total = 0;
            
            total += strike(score);// ajout des points bonus des strikes
            total += spare(score);//ajout des points bonus des spares
            
            for(int i=0; i<sc.size();i++) { // ajout des points de "lancer"
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
