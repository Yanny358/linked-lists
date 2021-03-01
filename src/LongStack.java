import java.util.EmptyStackException;

// A Linked List Node
class Node
{
   long data;       // integer data
   Node next;      // pointer to the next node
}


public class LongStack {

   private Node top;

   public static void main (String[] argum) {
      // TODO!!! Your tests here!
   }

   LongStack() {
      this.top = null;
   }

   @Override
   public Object clone() throws CloneNotSupportedException {
      return this;
   }

   public boolean stEmpty() {
      return top == null;
   }

   public void push (long a) {
      Node node = new Node();
      node.data = a;
      node.next = top;
      top = node;
   }

   public long pop(){
      // check for stack underflow
      if (top == null)
      {
         throw new EmptyStackException();
      }
      long data = top.data;
      top = top.next;
      return data;
   }

   public void op (String s) {
      // TODO!!!
   }
  
   public long tos() {
      if (!stEmpty()){
         return top.data;
      }
      else throw new RuntimeException();
   }

   @Override
   public boolean equals (Object o) {
      return true; // TODO!!! Your code here!
   }

   @Override
   public String toString() {
      return null; // TODO!!! Your code here!
   }

   public static long interpret (String pol) {
      return 0; // TODO!!! Your code here!
   }

}

