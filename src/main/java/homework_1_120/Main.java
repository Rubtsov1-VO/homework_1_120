package homework_1_120;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Number number1 = new Number(13,666445);
        Number number2 = new Number(815,9922341);
        Number number3 = new Number(800,9323124);
        Number number4 = new Number(456,3345132);


        Set<Number> phonebook = new LinkedHashSet<>();

        phonebook.add(new Number(4232,884342));
        phonebook.add(new Number(815,9922341));
        phonebook.add(new Number(800,9323124));
        phonebook.add(new Number(456,3345132));
        phonebook.add(new Number(456,3345132));

        System.out.println(phonebook);

        Map<Number,String> phonebook2 = new HashMap<>();

        phonebook2.put(number1,"Vlad");
        phonebook2.put(number2,"Elena");
        phonebook2.put(number3,"Bruce");
        phonebook2.put(number1,"Will");
        phonebook2.put(number4,"Peter");

        System.out.println(phonebook2);
    }
}
