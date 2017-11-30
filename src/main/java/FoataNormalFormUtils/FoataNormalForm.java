package FoataNormalFormUtils;

import Language.Dependence;

import java.util.*;


public class FoataNormalForm {
    Map<String, Stack> lettersStacks;
    List<String> word;
    Dependence dependence;
    String foataSteps;
    public FoataNormalForm(List<String> word, Dependence dependence) {
        this.word = word;
        this.dependence = dependence;
        lettersStacks = new HashMap<>();
        foataSteps = new String();
        computeFoataNormalFormSteps();
    }

    private void letterStackInit(){
        for (String letter :
                word) {
            lettersStacks.put(letter, new Stack());
        }
    }

    public String getFoataSteps() {
        return foataSteps;
    }

    private void computeFoataNormalFormSteps(){
        letterStackInit();
        fillLetterStack();
        while (isNotAllEmpty()) {
            List<String> lettersFromTop = new ArrayList<>();
            for (Stack stack : lettersStacks.values()) {
                if (stack.isTopALetter()) lettersFromTop.add(stack.pop());
            }
            addFoataSteps(lettersFromTop);
            for (String letter :
                    lettersFromTop) {
                popAsterisksFromNotCommute(letter);
            }
            if(lettersFromTop.isEmpty()){
                lettersStacks.values().forEach(Stack::pop);
            }
        }
    }

    private Boolean isNotAllEmpty(){
        return lettersStacks.values().stream().anyMatch(stack -> !stack.isEmpty());
    }
    private void addFoataSteps(List<String> letters){
        Collections.sort(letters);
        StringBuilder sb = new StringBuilder(foataSteps);
        sb.append("(");
        for (String letter :
                letters) {
            sb.append(letter);
        }
        sb.append(")");
        foataSteps = sb.toString();
    }

    private void fillLetterStack(){
        Collections.reverse(word);
        for (String letter :
             word) {
            lettersStacks.get(letter).push(letter);
            pushAsterisksToNotCommute(letter);
        }
    }

    private void pushAsterisksToNotCommute(String letter){
        List<String> dependentTo = dependence.retrieveAllDependentTo(letter);
        for (String dependentLetter:
             dependentTo) {
            if(!dependentLetter.equals(letter)) {
                lettersStacks.get(dependentLetter).push("*");
            }
        }
    }

    private void popAsterisksFromNotCommute(String letter){
        List<String> dependentTo = dependence.retrieveAllDependentTo(letter);
        for (String dependentLetter:
                dependentTo) {
            if(!dependentLetter.equals(letter)) {
                lettersStacks.get(dependentLetter).pop();
            }
        }
    }

}
