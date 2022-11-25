package asg1_2101140030;
import java.io.Serializable;

class Product implements Serializable{
   long id;
   String name;
   double price;
   int quantity;
   
static int nextId = 1;

   Product(String name, double price, int quantity){
       this.id = Product.nextId;
       Product.nextId++;
       this.name = name;
       this.price = price;
       this.quantity = quantity;
   }

   public long getId() {
       return id;
   }

   public double getPrice(){
       return price;
   }

   public String getName() {
       return name;
   }

   public int getQuantity() {
      return quantity;
   }

   public String toString() {
       return id + "\t" + name + "\t\t" + price + "\t\t" + quantity;
   }
}
