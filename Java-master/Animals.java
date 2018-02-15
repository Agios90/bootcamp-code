package animals;

/**
 *
 * @author agios
 */
public class Animals {

    public static void main(String[] args) {
        
        //ΑΡΧΙΚΟΠΟΙΗΣΗ
        String[] animals = {"cat","dog","pig","bear","bird","parrot","rabbit"};
        
        //ΜΕΘΟΔΟΣ startsWith()
        for (int i=0; i<6; i++) {
            if (!(animals[i].startsWith("p"))) {
		System.out.println(animals[i]);
            }
        }
        
        System.out.println();
        
        //ΜΕΘΟΔΟΣ charAt()
        for (int i=0; i<6; i++) {
           if (!(animals[i].charAt(0) == 'p')) {
               System.out.println(animals[i]);
           }
        }
    }
    
}
