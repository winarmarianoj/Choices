package list;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Lists {

    private List<String> incorrectList;
    private HashMap<Integer,String> correctList;
    private HashMap<Integer,String> answersList;

    public Lists() {}

    /** METHODS AND FUNCTION LISTS INCORRECT ANSWERS */

    public List<String> getIncorrectList(){
        if (incorrectList == null){
            incorrectList = new ArrayList<>();
        }
        return incorrectList;
    }
    public void addIncorrectList(String texto){
        if (incorrectList == null){
            incorrectList = new ArrayList<>();
        }
        incorrectList.add(texto);
    }
    public int incorrectListSize(){
        if (incorrectList == null){
            incorrectList = new ArrayList<>();
        }
        return incorrectList.size();
    }
    public String searchIncorrect(int index){
        if (index < 0 || index >= incorrectListSize()){
            return null;
        }
        return incorrectList.get(index);
    }
    public boolean removeIncorrects(int index){
        if (index < 0 || index >= incorrectListSize()){
            return false;
        }
        incorrectList.remove(index);
        return true;
    }

    /** METHODS AND FUNCTION HASH LIST CORRECT ANSWERS */

    public HashMap<Integer, String> getCorrectList() {
        if (correctList == null){
            correctList = new HashMap<Integer, String>();
        }
        return correctList;
    }

    public void addCorrectList(int num, String text) {
        if (correctList == null){
            correctList = new HashMap<Integer, String>();
        }
        correctList.put(num,text);
    }

    public int correctListSize(){
        if (correctList == null){
            correctList = new HashMap<Integer, String>();
        }
        return correctList.size();
    }

    public String searchCorrectList(int index){
        if (index < 0 || index >= correctListSize()){
            return null;
        }
        return correctList.get(index);
    }

    public boolean removeCorrectList(int index){
        if (index < 0 || index >= correctListSize()){
            return false;
        }
        correctList.remove(index);
        return true;
    }

    /** METHODS AND FUNCTION HASH LIST ANSWERS */

    public HashMap<Integer, String> getAnwersList() {
        if (answersList == null){
            answersList = new HashMap<Integer, String>();
        }
        return answersList;
    }

    public void addAnswersList(int num, String text) {
        if (answersList == null){
            answersList = new HashMap<Integer, String>();
        }
        answersList.put(num,text);
    }

    public int answersListSize(){
        if (answersList == null){
            answersList = new HashMap<Integer, String>();
        }
        return answersList.size();
    }

    public String searchAnswersList(int index){
        if (index < 0 || index >= answersListSize()){
            return null;
        }
        return answersList.get(index);
    }

    public boolean removeAnswersList(int index){
        if (index < 0 || index >= answersListSize()){
            return false;
        }
        answersList.remove(index);
        return true;
    }

}
