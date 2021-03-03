import java.util.EmptyStackException;

import static org.junit.Assert.assertEquals;


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

   private  Node head;

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
      String s = "156 154 152 - 3 + -";
      LongStack.interpret (s);
   }

   LongStack() {
      this.head = null;
   }

   @Override
   public Object clone() throws CloneNotSupportedException {
      LongStack tmp = new LongStack();
      Node ptr = this.head;
      while (ptr != null){
         tmp.head = this.head;
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
      Node ptr = this.head;
      if (ptr.data < 1)
         throw new IndexOutOfBoundsException(" too few elements for " + s);
      long num2 = pop();
      long num1 = pop();
      switch (s) {
         case "+" -> push(num1 + num2);
         case "-" -> push(num1 - num2);
         case "*" -> push(num1 * num2);
         case "/" -> push(num1 / num2);
         default -> throw new IllegalArgumentException("Invalid operation: " + s);
      }
      /* https://enos.itcollege.ee/~japoia/algorithms/examples/IntStack.java */
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
   public long size(){
      if (this.head == null){
         return 0;
      }
      Node temp = this.head;
      long count = 0;
      while (temp != null){
         count++;
         temp = temp.next;
      }
      return count;
   }

   public static long interpret (String pol) {
      LongStack ptr = new LongStack();
      for (String token : pol.trim().split("\\s+")){
         switch (token) {
            case "*" -> {
               long secondOperand = ptr.pop();
               long firstOperand = ptr.pop();
               ptr.push(firstOperand * secondOperand);

            }
            case "/" -> {
               long secondOperand = ptr.pop();
               long firstOperand = ptr.pop();
               ptr.push(firstOperand / secondOperand);

            }
            case "-" -> {
               long secondOperand = ptr.pop();
               long firstOperand = ptr.pop();
               ptr.push(firstOperand - secondOperand);

            }
            case "+" -> {
               long secondOperand = ptr.pop();
               long firstOperand = ptr.pop();
               ptr.push(firstOperand + secondOperand);

            }
            default -> {
               try {
                  ptr.push(Long.parseLong(token + ""));
               } catch (NumberFormatException e) {
                  throw new NumberFormatException();
               }
            }
         }
      }
      if (ptr.size() > 1) {
         throw new RuntimeException();
      }
      return ptr.head.data;
      /*https://rosettacode.org/wiki/Parsing/RPN_calculator_algorithm#Java_2 */
   }

}

