import java.io.BufferedReader;
import java.io.IOException;


import java.io.InputStreamReader;

public class CoffeeWithHook extends CaffeineBeverageWithHook {

    public void brew() {
        System.out.println("Dripping coffee through filter");
    }

    public void addCondiments () {
        System.out.println("Adding milk and sugar");
    }

    public boolean customerWantsCondiments () {
        String answer = getUserInput();
        return answer.toLowerCase().startsWith("y");
    }

    private String getUserInput() {
        String answer = null;

        System.out.println("Would you like milk and sugar with your coffee (y/n)? ");

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        try {
            answer = in.readLine();
        } catch (IOException IOE) {
            System.err.println("IO trying to read anser");
        }
        if(answer == null) {
            return "no";
        }
        return answer;
    }


}
