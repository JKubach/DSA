package lab6;

import java.util.Scanner;

public class Driver {

    Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        int leftSideSize, rightSideSize, sizeDifference;    /* For comparing sizes of words. */
        boolean isPalindrome = false, isSame = true;        /* isSame initialized to true for the case where
                                                               no characters are entered. */
        Driver ui = new Driver();
        Deq<Character> leftSide = new Deq<>();
        Deq<Character> rightSide = new Deq<>();

        leftSideSize = ui.insertLeftSide(leftSide);

        if (leftSideSize != -1) {
            rightSideSize = ui.insertRightSide(rightSide);
            sizeDifference = ui.compareSides(leftSideSize, rightSideSize);
            while (!leftSide.isEmpty() && !rightSide.isEmpty()) {
                isPalindrome = ui.checkPalindrome(leftSide, rightSide);
                if (isSame) {
                    isSame = ui.checkSame(leftSide, rightSide);
                }
                leftSide.dequeue();
                if (!leftSide.isEmpty()) {
                    leftSide.dequeueLast();
                }
                rightSide.dequeue();
                if (!rightSide.isEmpty()) {
                    rightSide.dequeueLast();
                }
            }

            if (sizeDifference > 0) {
                System.out.println("Left side longer");
            } else if (sizeDifference < 0) {
                System.out.println("Right side longer");
            } else {
                if (isPalindrome && isSame) {
                    System.out.println("Same length, same content, palindrome");
                } else if (isSame && !isPalindrome) {
                    System.out.println("Same length, same content, not palindrome");
                } else {
                    System.out.println("Same length, different content");
                }
            }
        }
    }

    public int insertLeftSide(Deq<Character> charDeq) {
        char userInput;
        int leftSideSize = 0;
        do {
            System.out.print("Enter Character: ");
            userInput = in.nextLine().charAt(0);
            if (userInput != '*') {
                charDeq.enqueue(userInput);
                leftSideSize++;
            }
            if (userInput == '!') {
                System.out.println("No Star");
                return -1;
            }
        }while (userInput != '*');
        return leftSideSize;
    }

    public int insertRightSide(Deq<Character> charDeq) {
        char userInput;
        int rightSideSize = 0;
        do {
            System.out.print("Enter Character: ");
            userInput = in.nextLine().charAt(0);
            if (userInput != '!') {
                charDeq.enqueue(userInput);
                rightSideSize++;
            }
        }while (userInput != '!');
        return rightSideSize;
    }

    public int compareSides(int leftSide, int rightSide) {
        if (leftSide - rightSide == 0) {
            return 0;
        }
        else if (leftSide - rightSide < 0) {
            return -1;
        }
        else {
            return 1;
        }
    }

    public boolean checkPalindrome(Deq<Character> leftSide, Deq<Character> rightSide) {
        if (leftSide.peek() != rightSide.peekLast()) {
            return false;
        }
        else {
            return true;
        }
    }

    public boolean checkSame(Deq<Character> leftSide, Deq<Character> rightSide) {
        if (leftSide.peek() != rightSide.peek() || leftSide.peekLast() != rightSide.peekLast()) {
            return false;
        }
        else {
            return true;
        }
    }

    public void insertItem(Deq myQueue, Object item) {
        System.out.println("Item " + item + " has been added");
        myQueue.enqueue(item);

    }

    public void insertFirst(Deq myQueue, Object item) {
        System.out.println("Item " + item + " has been added");
        myQueue.enqueueFirst(item);
    }

    public void removeItem(Deq myQueue) {
        System.out.println("Item " + myQueue.dequeue() + " has been removed");
    }

    public void removeLast(Deq myQueue) {
        System.out.println("Item " + myQueue.dequeueLast() + " has been removed");
    }

    public void peek(Deq myQueue) {
        System.out.println(myQueue.peek());
    }

    public void peekLast(Deq myQueue) {
        System.out.println(myQueue.peekLast());
    }

    public void clear(Deq myQueue) {
        myQueue.dequeueAll();
    }

    public void display(Deq myQueue) {
        System.out.println(myQueue.toString());
    }

}
