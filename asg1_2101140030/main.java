package asg1_2101140030;

import java.util.*;
import java.io.*;

class main{
   /**
    * @param args
    * @throws Exception
    */
   public static void main(String[] args) throws Exception{
      int ch = -1;
      Scanner s = new Scanner(System.in);
      Scanner s1 = new Scanner(System.in);
      File file = new File("asg1_2101140030\\game.txt");
      ArrayList<Product> ai = new ArrayList<Product>();
      ObjectOutputStream oos = null;
      ObjectInputStream ois = null;
      ListIterator li = null;
      if(file.isFile()){
         ois = new ObjectInputStream(new FileInputStream(file));
         ai = (ArrayList<Product>)ois.readObject();
         ois.close();
      }
      do{
         System.out.printf("              %s\n", "GAMES MENU");
         System.out.println("*************************************");
         System.out.println("1.Add product");
         System.out.println("2.Display products");
         System.out.println("3.Delete a product");
         System.out.println("4.Edit a product");
         System.out.println("5.Search for products by name");
         System.out.println("6.Sort product by price");
         System.out.println("-------------------------------------");
         System.out.println("0.Exit!!");
         System.out.print("Type your options here: ");
         ch = s.nextInt();

         switch(ch){
            case 1:
               System.out.print("Enter the amount of games: ");
               int n = s.nextInt();
               for(int i=0; i<n ; i++){
                  System.out.print("Enter Name: ");
                  String name = s1.nextLine();
                  System.out.print("Enter Price: ");
                  double price = s.nextDouble();
                  System.out.print("Enter quantity: ");
                  int quantity = s.nextInt();
                  ai.add(new Product(name,price,quantity));                 
               }
               oos = new ObjectOutputStream(new FileOutputStream(file));
               oos.writeObject(ai);
               oos.close();
            break;

            case 2:
               if(file.isFile()){
                  System.out.println("All the products available:");
                  System.out.println("-------------------------------------");
                  System.out.printf("%-10s %-20s %-15s %-20s %n", "ID", "NAME", "PRICE", "QUANTITY");
                  li = ai.listIterator();
                  while(li.hasNext())
                     System.out.println(li.next());
                  System.out.println("-------------------------------------");
               }else{
                  System.out.println("Product does not exist...");
               }
            break;
                     
            case 3:
               if(file.isFile()){
                  boolean found = false;
                  System.out.print("Enter ID to Delete : ");
                  int Id = s.nextInt();
                  System.out.println("-------------------------------------");
                  li = ai.listIterator();
                  while(li.hasNext()){
                     Product e = (Product)li.next();
                     if(e.id == Id){
                        li.remove();
                        found = true;
                     }
                  }
                  if(found){
                     System.out.println("Record Deleted Successfully....!");
                  }
                  else{
                     System.out.println("Product not found!!");                      
                  }
                  System.out.println("-------------------------------------");
               }
            break;   

            case 4:
               if(file.isFile()){
                  boolean found = false;
                  System.out.print("Enter ID to Update: ");
                  int Id = s.nextInt();
                  System.out.println("-------------------------------------");
                  li = ai.listIterator();
                  while(li.hasNext()){
                     Product e = (Product)li.next();
                     if(e.id == Id){
                        System.out.print("Enter new Name: ");
                        String name = s1.nextLine();
                        System.out.print("Enter new Price: ");
                        double price = s.nextDouble();
                        System.out.print("Enter new Quantity: ");
                        int quantity = s.nextInt();
                        li.set(new Product(name, price, quantity));
                        found = true;
                     }
                  }
                  if(found){
                     oos = new ObjectOutputStream(new FileOutputStream(file));
                     oos.writeObject(ai);
                     oos.close();
                     System.out.println("Product has been edited!!!");
                  }
                  else{
                     System.out.println("Edited failed...");                      
                  }
               }else{
                  System.out.println("Product does not exist...");
               }
            break;       
 
            case 5:
               if(file.isFile()){
                  boolean found = false;
                  System.out.print("Enter name to Search : ");
                  String name = s1.nextLine();
                  System.out.println("-----------------------------------");
                  li = ai.listIterator();
                  while(li.hasNext()){
                     Product e = (Product)li.next();
                     if(e.name == name){
                        System.out.println(li.next());
                        found = true;
                     }
                  }
                  if(!found)
                     System.out.println("Searching failed...");
                  System.out.println("-------------------------------------");
               }
            break; 

            case 6:
               if(file.isFile()){
                  Collections.sort(ai, new Comparator<Product>(){
                     public int compare(Product e1, Product e2){
                        return Double.compare(e2.price, e1.price);
                     }  
                  });    
                  System.out.println("-------------------------------------");
                  System.out.printf("%-10s %-20s %-15s %-20s %n", "ID", "NAME", "PRICE", "QUANTITY");
                  li = ai.listIterator();
                  while(li.hasNext())
                     System.out.println(li.next());
                  System.out.println("---------------------------------------");
               }else{
                  System.out.println("Product not Exists....!");
               }
            break; 
         }
      }while(ch!=0); 
   }
}