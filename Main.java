//This is just the class I use to check the other classes for funtionality and search for bugs
//The old bug checks and binary tree checks where removed to make it clearer
//Please not i am dislexic so do not mind the spelling mistakes in the variables and methos

public class Main
{
   public static void main(String[] args)
   {
      
     
        Brain brain = new Brain();
        brain.add("a");
        brain.add("b");
        brain.add("c");
        brain.add("d");
        brain.add("e");
        

        brain.printMap();
        System.out.println("--------------");
        System.out.println("Testing think function");
        
        System.out.println("Expected output: ababa");
        brain.think("a",5);
        System.out.println("Expected output: babab");
        brain.think("b",5);
        System.out.println("Expected output: cbaba");
        brain.think("c",5);
        System.out.println("Expected output: dabab");
        brain.think("d",5);
        System.out.println("Expected output: eabab");
        brain.think("e",5);
        
        System.out.println("Expected output: a");
        brain.think("a",1);
        System.out.println("Expected output: ab");
        brain.think("a",2);
        System.out.println("Expected output: aba");
        brain.think("a",3);


        
        System.out.println("--------------");
        System.out.println("Testing effect cause");
        
        System.out.println("Expected output: b");
        System.out.println(brain.cause("a"));
        System.out.println("Expected output: a");
        System.out.println(brain.cause("b"));
        System.out.println("Expected output: b");
        System.out.println(brain.cause("c"));
        System.out.println("Expected output: a");
        System.out.println(brain.cause("d"));
        System.out.println("Expected output: a");
        System.out.println(brain.cause("e"));
        
        System.out.println("--------------");
        System.out.println("Testing effect function");
        
        System.out.println("Expected output: b");
        System.out.println(brain.effect("a"));
        System.out.println("Expected output: a");
        System.out.println(brain.effect("b"));
        System.out.println("Expected output: b");
        System.out.println(brain.effect("c"));
        System.out.println("Expected output: c");
        System.out.println(brain.effect("d"));
        System.out.println("Expected output: e");
        System.out.println(brain.effect("e"));
        
        

        
   }
}
