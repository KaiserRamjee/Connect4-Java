import java.util.Scanner;

public class MyProgram
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        Connect4 game = new Connect4();
        System.out.println("Hello and welcome to Connect 4");


        System.out.print("\nEnter p1 (red tile) name: ");
        String p1 = input.nextLine();
        System.out.print("Enter p2 (yellow tile) name: ");
        String p2 = input.nextLine();

        int turn = 0;
        
        while(!(game.checkWin() || game.checkTie()))
        {
            game.printGame();
            if(turn % 2 ==0)
            {
                System.out.print("Pick a column (1-7), " + p1 + ": ");
                int column = input.nextInt() -1;
                game.takeTurn(column);
            }
            if(turn %2 ==1)
            {
                System.out.print("Pick a column (1-7), " + p2 + ": ");
                int column = input.nextInt() -1;
                game.takeTurn(column);
            }
            turn++;
        }
        
        if((turn-1) % 2 ==0)
        {
            System.out.println(p1 +" has won!");
        }
        if((turn-1) %2 ==1)
        {
            System.out.println(p2 + " has won!");
        }


    }
}
