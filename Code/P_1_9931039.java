import java.util.Scanner;

public class P_1_9931039 {
    /**
     * The iterator node that will move right and left according to the current state and the read data
     */
    public static Node iterator = new Node('q');

    /**
     * moves the iterator to the right, and create a blank node if needed
     */
    public static void moveIteratorRight() {
        if (iterator.getRight() == null)
            iterator.setRight(new Node('B'));

        iterator.setData(iterator.getRight().getData());
        iterator.getRight().setData('q');
        iterator = iterator.getRight();
    }

    /**
     * moves the iterator to the left, and create a blank node if needed
     */
    public static void moveIteratorLeft() {
        if (iterator.getLeft() == null) {
            Node newNode = new Node('B');
            newNode.setRight(iterator);
            iterator.setLeft(newNode);
        }

        iterator.setData(iterator.getLeft().getData());
        iterator.getLeft().setData('q');
        iterator = iterator.getLeft();
    }

    /**
     * reads the next character, which is in the right side of the iterator
     * @return the read character
     */
    public static char read() {
        if (iterator.getRight() == null)
            return 'B';

        return iterator.getRight().getData();
    }

    /**
     * writes the appropriate character to the right side of the iterator
     * @param c the character that will be written
     */
    public static void write(char c) {
        if (iterator.getRight() == null) {
            Node newNode = new Node(c);
            iterator.setRight(newNode);
            newNode.setLeft(iterator);
        } else
            iterator.getRight().setData(c);
    }

    public static void main(String[] args) {
        int state = 0;

        // creating the input string
        Scanner scanner = new Scanner(System.in);
        char[] chars = scanner.nextLine().toCharArray();

        Node chain = iterator; //to track the last added node
        for (char c: chars) {
            Node newNode = new Node(c);
            newNode.setLeft(chain);
            chain.setRight(newNode);
            chain = newNode;
        }

        // process the string according to the transition graph in the report
        while (state != 100) {
            char readChar = read();
            switch (state) {
                // from this state to state 4: n -> 2n
                case 0 -> {
                    switch (readChar) {
                        case '1' -> {
                            write('x');
                            moveIteratorRight();
                            state = 1;
                        }
                        case 'y' -> {
                            write('1');
                            moveIteratorRight();
                            state = 3;
                        }
                        default -> {
                            System.out.println("The machine has been stopped.");
                            return;
                        }
                    }
                }
                case 1 -> {
                    switch (readChar) {
                        case '1', 'y' -> {
                            moveIteratorRight();
                        }
                        case 'B' -> {
                            write('y');
                            moveIteratorLeft();
                            state = 2;
                        }
                        default -> {
                            System.out.println("The machine has been stopped.");
                            return;
                        }
                    }
                }
                case 2 -> {
                    switch (readChar) {
                        case '1', 'y' -> {
                            moveIteratorLeft();
                        }
                        case 'x' -> {
                            moveIteratorRight();
                            state = 0;
                        }
                        default -> {
                            System.out.println("The machine has been stopped.");
                            return;
                        }
                    }
                }
                case 3 -> {
                    switch (readChar) {
                        case 'y' -> {
                            write('1');
                            moveIteratorRight();
                        }
                        case 'B' -> {
                            moveIteratorLeft();
                            state = 4;
                        }
                        default -> {
                            System.out.println("The machine has been stopped.");
                            return;
                        }
                    }
                }
                case 4 -> {
                    switch (readChar) {
                        case '1', 'x' -> {
                            write('1');
                            moveIteratorLeft();
                        }
                        case 'B' -> {
                            moveIteratorRight();
                            state = 5;
                        }
                        default -> {
                            System.out.println("The machine has been stopped.");
                            return;
                        }
                    }
                }
                // from this state to state 9: 2n -> 4n
                case 5 -> {
                    switch (readChar) {
                        case '1' -> {
                            write('x');
                            moveIteratorRight();
                            state = 6;
                        }
                        case 'y' -> {
                            write('1');
                            moveIteratorRight();
                            state = 8;
                        }
                        default -> {
                            System.out.println("The machine has been stopped.");
                            return;
                        }
                    }
                }
                case 6 -> {
                    switch (readChar) {
                        case '1', 'y' -> {
                            moveIteratorRight();
                        }
                        case 'B' -> {
                            write('y');
                            moveIteratorLeft();
                            state = 7;
                        }
                        default -> {
                            System.out.println("The machine has been stopped.");
                            return;
                        }
                    }
                }
                case 7 -> {
                    switch (readChar) {
                        case '1', 'y' -> {
                            moveIteratorLeft();
                        }
                        case 'x' -> {
                            moveIteratorRight();
                            state = 5;
                        }
                        default -> {
                            System.out.println("The machine has been stopped.");
                            return;
                        }
                    }
                }
                case 8 -> {
                    switch (readChar) {
                        case 'y' -> {
                            write('1');
                            moveIteratorRight();
                        }
                        case 'B' -> {
                            moveIteratorLeft();
                            state = 9;
                        }
                        default -> {
                            System.out.println("The machine has been stopped.");
                            return;
                        }
                    }
                }
                case 9 -> {
                    switch (readChar) {
                        case '1', 'x' -> {
                            write('1');
                            moveIteratorLeft();
                        }
                        case 'B' -> {
                            moveIteratorRight();
                            state = 10;
                        }
                        default -> {
                            System.out.println("The machine has been stopped.");
                            return;
                        }
                    }
                }
                // from this state to state 12: 4n -> 4n + 2
                case 10 -> {
                    switch (readChar) {
                        case '1' -> {
                            moveIteratorRight();
                        }
                        case 'B' -> {
                            write('1');
                            moveIteratorRight();
                            state = 11;
                        }
                        default -> {
                            System.out.println("The machine has been stopped.");
                            return;
                        }
                    }
                }
                case 11 -> {
                    switch (readChar) {
                        case 'B' -> {
                            write('1');
                            moveIteratorLeft();
                            state = 12;
                        }
                        default -> {
                            System.out.println("The machine has been stopped.");
                            return;
                        }
                    }
                }
                case 12 -> {
                    switch (readChar) {
                        case '1' -> {
                            moveIteratorLeft();
                        }
                        case 'B' -> {
                            moveIteratorRight();
                            state = 13;
                        }
                        default -> {
                            System.out.println("The machine has been stopped.");
                            return;
                        }
                    }
                }
                // from this state to the end: 4n + 2 -> (4n + 2)!
                case 13 -> {
                    switch (readChar) {
                        case '1' -> {
                            moveIteratorRight();
                        }
                        case 'B' -> {
                            write('0');
                            moveIteratorLeft();
                            state = 14;
                        }
                    }
                }
                case 14 -> {
                    switch (readChar) {
                        case '0', 'x' -> {
                            moveIteratorLeft();
                        }
                        case '1' -> {
                            write('x');
                            moveIteratorRight();
                            state = 15;
                        }
                        case 'B' -> {
                            moveIteratorRight();
                            state = 16;
                        }
                    }
                }
                case 15 -> {
                    switch (readChar) {
                        case '0', 'x' -> {
                            moveIteratorRight();
                        }
                        case 'B' -> {
                            write('x');
                            moveIteratorLeft();
                            state = 14;
                        }
                    }
                }
                case 16 -> {
                    switch (readChar) {
                        case '0' -> {
                            moveIteratorRight();
                        }
                        case 'x' -> {
                            write('1');
                            moveIteratorRight();
                        }
                        case 'B' -> {
                            moveIteratorLeft();
                        }
                        case '1' -> {
                            write('0');
                            moveIteratorLeft();
                            state = 17;
                        }
                    }
                }
                case 17 -> {
                    switch (readChar) {
                        case '0', '1' -> {
                            moveIteratorLeft();
                        }
                        case 'B' -> {
                            moveIteratorRight();
                            state = 18;
                        }
                    }
                }
                case 18 -> {
                    switch (readChar) {
                        case '1' -> {
                            write('B');
                            moveIteratorRight();
                            state = 19;
                        }
                        case '0' -> {
                            write('B');
                            moveIteratorRight();
                            state = 24;
                        }
                    }
                }
                case 19 -> {
                    switch (readChar) {
                        case '1' -> {
                            moveIteratorRight();
                        }
                        case '0' -> {
                            moveIteratorRight();
                            state = 20;
                        }
                    }
                }
                case 20 -> {
                    switch (readChar) {
                        case '1' -> {
                            write('x');
                            moveIteratorRight();
                            state = 21;
                        }
                        case '0' -> {
                            moveIteratorLeft();
                            state = 23;
                        }
                    }
                }
                case 21 -> {
                    switch (readChar) {
                        case '0', '1' -> {
                            moveIteratorRight();
                        }
                        case 'B' -> {
                            write('1');
                            moveIteratorLeft();
                            state = 22;
                        }
                    }
                }
                case 22 -> {
                    switch (readChar) {
                        case '0', '1' -> {
                            moveIteratorLeft();
                        }
                        case 'x' -> {
                            moveIteratorRight();
                            state = 20;
                        }
                    }
                }
                case 23 -> {
                    switch (readChar) {
                        case '0', '1' -> {
                            moveIteratorLeft();
                        }
                        case 'x' -> {
                            write('1');
                            moveIteratorLeft();
                        }
                        case 'B' -> {
                            moveIteratorRight();
                            state = 18;
                        }
                    }
                }
                case 24 -> {
                    switch (readChar) {
                        case '1' -> {
                            write('B');
                            moveIteratorRight();
                            state = 29;
                        }
                    }
                }
                case 25 -> {
                    switch (readChar) {
                        case '0', '1' -> {
                            moveIteratorRight();
                        }
                        case 'B' -> {
                            write('0');
                            moveIteratorLeft();
                            state = 26;
                        }
                    }
                }
                case 26 -> {
                    switch (readChar) {
                        case '0', '1' -> {
                            moveIteratorLeft();
                        }
                        case 'B' -> {
                            moveIteratorRight();
                            state = 27;
                        }
                    }
                }
                case 27 -> {
                    switch (readChar) {
                        case '1' -> {
                            write('B');
                            moveIteratorRight();
                            state = 28;
                        }
                        case '0' -> {
                            write('B');
                            moveIteratorRight();
                            state = 33;
                        }
                    }
                }
                case 28 -> {
                    switch (readChar) {
                        case '1', '0' -> {
                            moveIteratorRight();
                        }
                        case 'B' -> {
                            write('1');
                            moveIteratorLeft();
                            state = 26;
                        }
                    }
                }
                case 29 -> {
                    switch (readChar) {
                        case '1' -> {
                            write('B');
                            moveIteratorRight();
                            state = 30;
                        }
                    }
                }
                case 30 -> {
                    switch (readChar) {
                        case '0' -> {
                            write('B');
                            moveIteratorRight();
                            state = 100;
                        }
                        case '1' -> {
                            moveIteratorLeft();
                            state = 31;
                        }
                    }
                }
                case 31 -> {
                    switch (readChar) {
                        case 'B' -> {
                            write('1');
                            moveIteratorLeft();
                            state = 32;
                        }
                    }
                }
                case 32 -> {
                    switch (readChar) {
                        case 'B' -> {
                            moveIteratorRight();
                            state = 25;
                        }
                    }
                }
                case 33 -> {
                    switch (readChar) {
                        case '0', '1' -> {
                            moveIteratorRight();
                        }
                        case 'B' -> {
                            write('0');
                            moveIteratorLeft();
                            state = 34;
                        }
                    }
                }
                case 34 -> {
                    switch (readChar) {
                        case '0', '1' -> {
                            moveIteratorLeft();
                        }
                        case 'B' -> {
                            moveIteratorRight();
                            state = 18;
                        }
                    }
                }
            }
        }

        //returning the output string
        int counter = 0;
        do {
            System.out.print(iterator.getData());
            if (iterator.getData() == '1')
                counter++;
            iterator = iterator.getRight();
        } while (iterator != null);

        System.out.println();
        System.out.println("which is equal to " + counter);
    }
}

class Node {
    private Node left;
    private Node right;
    private char data;

    public Node(char data) {
        this.data = data;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public char getData() {
        return data;
    }

    public void setData(char data) {
        this.data = data;
    }
}
