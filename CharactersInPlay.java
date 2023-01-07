
/**
 * Write a description of CharactersInPlay here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import java.util.*;

public class CharactersInPlay {
    private ArrayList<String> speakers;
    private ArrayList<Integer> count;
    
    public CharactersInPlay() {
        speakers = new ArrayList<String>();
        count = new ArrayList<Integer>();
    }
    
    private void update(String person) {
        person = person.toLowerCase();
        for (int k=0;k<speakers.size();k++) {
            if (person.equals(speakers.get(k))) {
                int x = count.get(k);
                count.set(k,x+1);
                return; 
            }
        }
        // if not found:
        speakers.add(person);
        count.add(1);
    }
    
    private void findAllCharacters() {
        speakers.clear();
        count.clear();
        FileResource resource = new FileResource();
        
        for (String s : resource.lines()) {
            if((s.indexOf(".") != -1) && (Character.isUpperCase(s.charAt(3)))) {
                //System.out.println(s.charAt(3));
                s = s.substring(0,s.indexOf("."));
                update(s);
            }
        }
    }
        
    public void tester() {
        findAllCharacters();
        for (int k=0;k<speakers.size();k++) {
            if(count.get(k) > 1) {
                if (! speakers.get(k).contains("scene")) {
                    System.out.println("Speaker: "+speakers.get(k)+" | Count: "+count.get(k));
                }
            }
        }
        System.out.println("-------------");
        charactersWithNumParts(10,15);
    }
    
    public void charactersWithNumParts (int num1, int num2) {
        for (int k=0;k<speakers.size();k++) {
            if((count.get(k) >= num1) && (count.get(k) <= num2)) {
                if (! speakers.get(k).contains("scene")) {
                    System.out.println("Speaker: "+speakers.get(k)+" | Count: "+count.get(k));
                }
            }
        }
    }
}
