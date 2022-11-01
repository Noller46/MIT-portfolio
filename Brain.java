//This is the actual brain data structure
//It is supposed to mimic how the human brain realy stores and connects information
//Please not i am dislexic so do not mind the spelling mistakes in the variables and methos

import java.util.*;
import java.lang.*;



public class Brain<T> //implements Iterable<T>
{
   //This class is reresents the link between ideas, or in this cast instences of the nue class
   //It holds which nue its pointing and the strength of the connection between the ideas
   class Link
   {
      Nue target;
      int strength;
      public String toString(T subj)
      {
         return new String(strength +": "+ target.toString());
      }
   }
   
   //This class represents ideas
   //It holds the concept of the idea in name, the power of the idea, and a link to every idea it is connected to
   class Nue
   {
      T name;
      int power;
      binaryTree<Link> links = new binaryTree<Link>();
      public String toString(T subj)
      {
         return new String(power +": "+ name);
      }
   }
   
   binaryTree<Nue> map = new binaryTree<Nue>();

   
   //this method adds new ideas to the brain the reinvoces old ideas to rais thier power
   public void add(T subj)
   {
      Nue check = here(subj);
      for(Nue n: map)
      {
         n.power --;
         if(n.power < 0)
         {
            n.power = 0;
         }
      }
      if(check!=null)
      {
         update(check, 2);
      }
      else
      {
         Nue hold = new Nue();
         hold.name = subj;
         hold.power = 50;
         
         update(hold, 2);
         map.insert(hold);

         
      }
      
   }
   
   //this methods findes the idea this idea is most connected to 
   public T cause(T subj)
   {
      Nue origin  = here(subj);
      Link main = new Link();
      main.strength = 0;
      if(origin != null){
         for(Link l: origin.links)
         {
            if(l.strength > main.strength)
            {
               main = l;
            }
         }
      }
      return main.target.name;
   }
   
   //this method finds the idea that is most connected to this idea
   public T effect(T subj)
   {
      
      Nue origin = here(subj);
      if(origin != null)
      {
         Link connect = new Link();
         connect.strength = 0;
         connect.target = origin;
         for(Nue n: map)
         {
           

            for(Link l: n.links)
            {
               if(l.target.equals(connect.target)&&connect.strength<l.strength)
               {
                  connect = l;
                  origin = n;
               }
            }
            
            
         }
      }
      return origin.name;
   }
   
   //this method run recursevly, goin from idea to the idea it is most closly liked to like a train of thought
   public void think(T subj, int steps)
   {
      if(here(subj) != null && steps > 0)
      {
         System.out.println(steps + ": " + subj);
         think(cause(subj),steps-1);
      }
   }
   
   //this method updates any power place into it
   public int updatePower(int origin, int level)
   {
      int n = origin + ((int) ((((1000.0/origin)-10)/level)+1));
      if(n>100)
      {
         n = 100;
      }
      return n;
   }
   
   //Updates the power and connections of original idea and ideas linked to it
   public void update(Nue subj, int level)
   {
      subj.power = updatePower(subj.power, level);
      for(Nue n: map)
      {
         Link connect = new Link();
         connect.strength = n.power;
         connect.target = n;
         boolean here = false;
         for(Link l: subj.links)
         {
            if(l.target.equals(connect.target))
            {
               here = true;
            }
         }
         if(!n.equals(subj)&&!here&&n.power>0.85)
         {
            subj.links.insert(connect);
         }         
      }
      
      for(Link l: subj.links)
      {
         l.strength = updatePower(l.strength,2);
         if(level < 256)
         {
            update(l.target, level*level);
         }
      }
   }
   
   //finds Nue of the subject provided
   public Nue here(T subj)
   {
      for(Nue i: map)
      {
         if(i.name.equals(subj))
         {
            return i;
         }
      }
      return null;
   }
   
 
   
   //Prints all Nues thier connections and conections
   public void printMap()
   {
      for(Nue i: map)
      {
         System.out.println("Subject" +": "+ "Power");
         System.out.println(i.name +": "+ i.power);
         System.out.println("--------------");
         System.out.println("Link strength" + " " + "Subject");
         
         for(Link l: i.links)
         {
            System.out.println(l.strength + " " + l.target.name);
         }
         System.out.println("--------------");

      }
   }
   
   


}

