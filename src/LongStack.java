import java.util.EmptyStackException;


class Node
{
   long data;
   Node next;

   public Node(long data) {
      this.data = data;
      this.next = null;
   }
   public Node(long data,Node next) {
      this.data = data;
      this.next = next;
   }
   public Node() {}
}


public class LongStack {

   private Node head;

   public void display(){
      if (this.head == null){
         System.out.println("Stack is empty!");
      }
      Node temp = this.head;
      while (temp != null){
         System.out.println(temp.data);
         temp = temp.next;
      }
   }

   public static void main (String[] argum) {
      LongStack m1 = new LongStack();
      m1.push (5);
      m1.push (4);
      LongStack m2 = null;
      try {
         m2 = (LongStack)m1.clone();
      } catch (CloneNotSupportedException e) {};
      m1.display();
      System.out.println("----------");
      m2.display();
      System.out.println(m1);
      System.out.println(m2);
   }

   LongStack() {
      this.head = null;
   }

   @Override
   public Object clone() throws CloneNotSupportedException {
      LongStack tmp = new LongStack();
      Node ptr = this.head;
      while (ptr != null){
         tmp.head = head;
         ptr = ptr.next;
      }
      return tmp;
   }

   public boolean stEmpty() {
      return head == null;
   }

   public void push (long a) {
      Node node = new Node(a);
      node.next = this.head;
      this.head = node;
   }

   public long pop(){
      // check for stack underflow
      if (head == null)
      {
         throw new EmptyStackException();
      }
      long data = head.data;
      head = head.next;
      return data;
   }

   public void op (String s) {
      // TODO!!!
   }
  
   public long tos() {
      if (!stEmpty()){
         return head.data;
      }
      else throw new RuntimeException();
   }

   @Override
   public boolean equals (Object o) {
      Node ptr = this.head;
      if (head == null && ((LongStack) o).head != null){
         return false;
      }
      while (ptr != null && ((LongStack) o).head != null){
         if (((LongStack) o).head.data != head.data){
            return false;
         }
         if (((LongStack) o).head.next != head.next ){
            return false;
         }

         ptr = ptr.next;

      }
      return true;
   }

   @Override
   public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("-->");

      Node curr = this.head;

      if (curr == null)
      {
         sb.append("<--");
         return sb.toString();
      }

      sb.append(curr.data);
      curr = curr.next;
      while(curr != null) {
         sb.append("<-->");
         sb.append(curr.data);
         curr = curr.next;
      }
      sb.append("<--");

      return sb.toString();
      /* https://stackoverflow.com/questions/37766590/implementing-a-tostring-method-to-print-out-a-linkedlist */
   }

   public static long interpret (String pol) {
      return 0; // TODO!!! Your code here!
   }

}

