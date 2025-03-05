public class Connect4 
{
    private String[][] game = new String[6][7];
    private int turnCount = 0;

    public Connect4()
    {
        for(int i = 0; i < game.length; i++)
        {
            for(int j = 0;j<game[i].length;j++)
            {
                game[i][j] = " ";
            }
        }
    }
    
    public void printGame()
    {
        for(int i = 0; i< game.length;i++)
        {
            for(int j = 0; j<game[i].length; j++)
            {
                System.out.print("|"+game[i][j]);
                
            }
            System.out.print("|\n");
        }
        for(int i = 0; i< game.length*3-3; i++)
        {
            System.out.print("-");
        }
        System.out.println();
    }
    
    public boolean checkTie()
    {
        for(int i = 0; i < game.length; i++)
        {
            for(int j = 0; j < game[i].length; j++)
            {
                if(game[i][j].equals(" "))
                {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean checkCol()
    {
        for(int i = 0; i<7;i++)
        {
            for(int j = 0; j< 3;j++)
            {
                if(!(game[j][i].equals(" ") && game[j+1][i].equals(" ") && game[j+2][i].equals(" ") && game[j+3][i].equals(" "))&&game[j][i].equals(game[j+1][i]) && game[j+1][i].equals(game[j+2][i]) && game[j+2][i].equals(game[j+3][i]))
                {
                    return true;
                }
            }
        }
        return false;
        
    }

    public boolean checkRow()
    {
        for(int i = game.length-1; i >=0; i--)
        {
            for(int j = 0; j < 4; j++)
            {
                if(!(game[i][j].equals(" ") && game[i][j+1].equals(" ") && game[i][j+2].equals(" ") && game[i][j+3].equals(" ")) && game[i][j].equals(game[i][j+1]) && game[i][j+1].equals(game[i][j+2]) && game[i][j+2].equals(game[i][j+3]))
                {
                    return true;
                }
            }
        }
        return false;
    }


    public boolean checkDiag()
    {
        
        for(int i = game.length-1; i> 3;i--)
        {
            for(int j = 0; j <4;j++)
            {
                
                if(!(game[i][j].equals(" ")) && game[i][j].equals(game[i-1][j+1]) && game[i-1][j+1].equals(game[i-2][j+2]) && game[i-2][j+2].equals(game[i-3][j+3]))
                {
                    return true;
                }
            }
        }
        for(int i = 0; i<=2;i++)
        {
            for(int j = 0; j <4;j++)
            {
                if(!(game[i][j].equals(" ") && game[i+1][j+1].equals(" ") && game[i+2][j+2].equals(" ") && game[i+3][j+3].equals(" ")) && game[i][j].equals(game[i+1][j+1]) && game[i+1][j+1].equals(game[i+2][j+2]) && game[i+2][j+2].equals(game[i+3][j+3]))
                {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean checkWin()
    {
        
        return checkCol() || checkRow() || checkDiag();
    }

    public void takeTurn(int col)
    {
        for(int i = game.length-1; i >=0; i--)
        {
            if(game[i][col].equals(" "))
            {
                if(turnCount % 2 ==0)
                {
                    game[i][col] = "R";
                }
                if(turnCount %2 ==1)
                {
                    game[i][col] = "Y";
                }
                turnCount++;
                break;
            }
        }
    }

}