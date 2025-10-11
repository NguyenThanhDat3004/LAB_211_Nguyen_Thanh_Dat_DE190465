package tuan_1.tuan_1_dem_tu.model;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class CountManagement {
    private Map<String, Integer> wordInfor = new LinkedHashMap<>();
    private Map<Character, Integer> characterInfor = new LinkedHashMap<>();
    // constructor
    public CountManagement() {
    }
    // getter
    public Map<Character, Integer> getCharacterInfor() {
        return characterInfor;
    }
    public Map<String, Integer> getWordInfor() {
        return wordInfor;
    }
    // xu li tu
    public void splitWords(String content) {
        StringTokenizer st = new StringTokenizer(content, " \t\n\r\f,.;:!?\"'()[]{}<>-");
        
        while (st.hasMoreTokens()) {
            String word = st.nextToken();
            wordInfor.put(word, wordInfor.getOrDefault(word, 0) + 1);
        }
    }
    // xu li ky tu
    public void splitCharacter(String content) {
        for (char c : content.toCharArray()) { // chuyen chuoi thanh mang ki tu
            c = Character.toLowerCase(c); 
            if(Character.isLetter(c)){                   
                characterInfor.put(c, characterInfor.getOrDefault(c,0) + 1);
            }
        }
    }
}
