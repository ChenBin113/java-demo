package designpattern.iterator;

import java.util.ArrayList;

public class Client {
    public static void main(String[] args) {
        ArrayList<College> colleges = new ArrayList<>();

        ComputerCollege computerCollege = new ComputerCollege();

        colleges.add(computerCollege);

        OutputImpl output = new OutputImpl(colleges);
        output.printCollege();

    }
}
