import java.util.EmptyStackException;


class Node
{
   long data;
   Node next;

   public Node(long data) {
      this.data = data;
      this.next = null;   // redundant?
   }
}


public class LongStack {

   private  Node head;

   private void display(){
      if (head == null){
         System.out.println("Stack is empty!");
      }
      Node temp = head;
      while (temp != null){
         System.out.println(temp.data);
         temp = temp.next;
      }
   }

   public static void main (String[] argum) {
      LongStack m = new LongStack();
      m.push (6);
      m.push (-3);
      m.display();
   }

   public LongStack() {   // redundant?
      head = null;
   }

   @Override
   public Object clone() throws CloneNotSupportedException {
      LongStack tmp = new LongStack();
      Node ptr = head;
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
      node.next = head;
      head = node;

   }

   public long pop(){
      // check for stack underflow
      if (head == null)
      {
         throw new RuntimeException("Stack is empty");
      }
      Node temp = head;
      head = head.next;
      return temp.data;
   }

   public void op (String s) {
      Node ptr = head;
      if (ptr == null)
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
      else throw new RuntimeException("Stack is empty");
   }

   @Override
   public boolean equals (Object o) {
      Node ptr = head;
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

      Node curr = head;

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
      if (head == null){
         return 0;
      }
      Node temp = head;
      long count = 0;
      while (temp != null){
         count++;
         temp = temp.next;
      }
      return count;
   }

   public static long interpret (String pol) {
      if (pol.isEmpty()) {
         throw new RuntimeException("Empty input");
      }
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
                  throw new NumberFormatException("illegal symbol");
               }
            }
         }
      }

      if (ptr.size() > 1) {
         throw new RuntimeException("Too many numbers");
      }
      return ptr.head.data;
      /*https://rosettacode.org/wiki/Parsing/RPN_calculator_algorithm#Java_2 */
   }

}