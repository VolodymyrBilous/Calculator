
class ParsePost
   {
   private StackX theStack;
   private String input;
//--------------------------------------------------------------
   public ParsePost(String s)
      { input = s; }
//--------------------------------------------------------------
   public double doParse()
      {
      theStack = new StackX(20);             // make new stack
      char ch;
      int j;
      double num1, num2;
      double interAns;

      for(j=0; j<input.length(); j++)       // for each char,
         {
         ch = input.charAt(j);              // read from input
         theStack.displayStack(""+ch+" ");  // *diagnostic*
         if(ch >= '0' && ch <= '9')         // if it's a number
            theStack.push( (int)(ch-'0') ); //   push it
         else                               // it's an operator
            {
            num2 = theStack.pop();          // pop operands
            num1 = theStack.pop();
            switch(ch)                      // do arithmetic
               {
               case '+':
                  interAns = num1 + num2;
                  break;
               case '-':
                  interAns = num1 - num2;
                  break;
               case '*':
                  interAns = num1 * num2;
                  break;
               case '/':
                  interAns = num1 / num2;
                  break;
               default:
                  interAns = 0;
               }  // end switch
            theStack.push(interAns);        // push result
            }  // end else
         }  // end for
      interAns = theStack.pop();            // get answer
      return interAns;
      }  // end doParse()
   
   class StackX
   {
   private int maxSize;
   private double[] stackArray;
   private int top;
//--------------------------------------------------------------
   public StackX(int size)      // constructor
      {
      maxSize = size;
      stackArray = new double[maxSize];
      top = -1;
      }
//--------------------------------------------------------------
   public void push(double j)     // put item on top of stack
      { stackArray[++top] = j; }
//--------------------------------------------------------------
   public double pop()            // take item from top of stack
      { return stackArray[top--]; }
//--------------------------------------------------------------
   public double peek()           // peek at top of stack
      { return stackArray[top]; }
//--------------------------------------------------------------
   public boolean isEmpty()    // true if stack is empty
      { return (top == -1); }
//--------------------------------------------------------------
   public boolean isFull()     // true if stack is full
      { return (top == maxSize-1); }
//--------------------------------------------------------------
   public int size()           // return size
      { return top+1; }
//--------------------------------------------------------------
   public double peekN(int n)     // peek at index n
      { return stackArray[n]; }
//--------------------------------------------------------------
   public void displayStack(String s)
      {
      /*System.out.print(s);
      System.out.print("Stack (bottom-->top): ");
      for(int j=0; j<size(); j++)
         {
         System.out.print( peekN(j) );
         System.out.print(' ');
         }
      System.out.println("");*/
      }
//--------------------------------------------------------------
   }  // end class StackX
   }  // end class ParsePost
