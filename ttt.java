import java.util.Scanner;
import java.util.Random;

class tictactoe {
    static char board[][];

    public tictactoe() {
        board = new char[3][3];
        init();
    }

    void init() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = ' ';
            }
        }
    }

    static void display() {
        System.out.println("-------------");
        for (int i = 0; i < board.length; i++) {
            System.out.print("| ");
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println();
            System.out.println("-------------");
        }
    }

    static void placeing(int row, int col, char mark) {
        if (row >= 0 && row <= 2 && col >= 0 && col <= 2) {
            board[row][col] = mark;
        } else {
            System.out.println("Invalid input");
        }
    }

    static boolean checkcolwin() {
        for (int j = 0; j <= 2; j++) {
            if (board[0][j] != ' ' && board[0][j] == board[1][j] && board[1][j] == board[2][j]) {
                return true;
            }
        }
        return false;
    }

    static boolean checkrowwin() {
        for (int i = 0; i <= 2; i++) {
            if (board[i][0] != ' ' && board[i][0] == board[i][1] && board[i][1] == board[i][2]) {
                return true;
            }
        }
        return false;
    }

    static boolean checkdiawin() {
        if (board[0][0] != ' ' && board[0][0] == board[1][1] && board[1][1] == board[2][2]
                || board[0][2] != ' ' && board[0][2] == board[1][1] && board[1][1] == board[2][0]) {
            return true;
        }
        return false;
    }

    static boolean isboardfull() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }
}

abstract class player {
    String name;
    char mark;

    abstract void makemove();

    boolean isvalidmove(int row, int col) {
        if (row < 0 || row > 2 || col < 0 || col > 2) {
            System.out.println("This position is not valid, please select a valid position.");
            return false;
        } else if (tictactoe.board[row][col] != ' ') {
            System.out.println("This position is occupied, please choose a vacant position.");
            return false;
        }
        return true;
    }
}

class humanplayer extends player {
    static Scanner s = new Scanner(System.in);

    humanplayer(String name, char mark) {
        this.name = name;
        this.mark = mark;
    }

    void makemove() {
        int row, col;
        do {
            System.out.println(name + ", enter the Row and Column (0-2): ");
            row = s.nextInt();
            col = s.nextInt();
        } while (!isvalidmove(row, col));
        tictactoe.placeing(row, col, mark);
    }
}

class AIplayer extends player {

    AIplayer(String name, char mark) {
        this.name = name;
        this.mark = mark;
    }

    void makemove() {
        int row, col;
        do {
            Random r = new Random();
            row = r.nextInt(3);
            col = r.nextInt(3);
        } while (!isvalidmove(row, col));
        tictactoe.placeing(row, col, mark);
    }
}

public class ttt {
    public static void main(String args[]) {
        tictactoe t = new tictactoe();
        t.init();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose mode of play:");
        System.out.println("1. Play with a friend");
        System.out.println("2. Play with the computer");
        int choice = scanner.nextInt();

        player p1, p2;

        if (choice == 1) {
            System.out.println("Enter name of Player 1:");
            String player1Name = scanner.next();
            System.out.println("Enter name of Player 2:");
            String player2Name = scanner.next();
            p1 = new humanplayer(player1Name, 'x');
            p2 = new humanplayer(player2Name, 'o');
        } else {
            System.out.println("Enter your name:");
            String playerName = scanner.next();
            p1 = new humanplayer(playerName, 'x');
            p2 = new AIplayer("Computer", 'o');
        }
        
        player cp = p1;

        while (true) {
            System.out.println(cp.name + " Turn to play: ");
            cp.makemove();
            tictactoe.display();

            if (tictactoe.checkcolwin() || tictactoe.checkdiawin() || tictactoe.checkrowwin()) {
                System.out.println(cp.name + " Won the Game.");
                break;
            } else if (tictactoe.isboardfull()) {
                System.out.println("The game is a draw.");
                break;
            } else {
                if (cp == p1) {
                    cp = p2;
                } else {
                    cp = p1;
                }
            }
        }
        scanner.close();
    }
}