public class ConnectFour implements BoardGame{
    private int[][] board;
    private int currentPlayer;
    private Position[] winningPositions;
    private int winner;


    public ConnectFour()    {
        newGame();
    }

    @Override
    public void newGame() {
        board = new int[6][7];
        //System.out.println("The board should have " + board.length + " rows in it why not now??");
        winningPositions = new Position[4];
        currentPlayer = 1 +(int)(Math.random()*2);
        winner = -1;

        board = new int[6][7];
        for(int r = 0; r < 6; r++)  {
            for(int c = 0; c < 7; c++)  {
                board[r][c] = 0;
            }
        }
    }

    @Override
    public boolean gameOver() {
        //horizontal check
        for(int r = 5; r >= 0; r--) {
            for(int c = 0; c <= 3; c++) {
                if(board[r][c] != 0 && board[r][c] == board[r][c+1] && board[r][c+1] == board[r][c+2] && board[r][c+2] == board[r][c+3])  {
                    //for(int i = 0; i < 4; i ++)
                    winningPositions[0] = new Position(r, c);
                    winningPositions[1] = new Position(r, c+1);
                    winningPositions[2] = new Position(r, c+2);
                    winningPositions[3] = new Position(r, c+3);
                    winner = board[r][c];
                    return true;
                }
            }
        }
        //verticle check
        for(int r = 5; r >= 3; r--) {
            for(int c = 0; c <= 6; c++) {
                if(board[r][c] != 0 && board[r][c] == board[r-1][c] && board[r-1][c] == board[r-2][c] && board[r-2][c] == board[r-3][c] && board[r-3][c] == board[r-4][c])  {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public int getWinner() {
        return winner;
    }

    @Override
    public Position[] getWinningPositions() {
        return winningPositions;
    }

    @Override
    public boolean columnFull(int column) {
        for(int r = 0; r < board.length; r++) {
            if (board[r][column] == 0)
                return false;
        }
        return true;
    }

    public int getCurrentPlayer()   {
        return currentPlayer;
    }

    @Override
    public void play(int column) {
        if(!columnFull(column)) {
            for(int r = 5; r >= 0; r--)   {
                if(board[r][column] == 0) {
                    board[r][column] = currentPlayer;
                    break;
                }
            }
            currentPlayer = (currentPlayer == 1) ? 2 : 1;
        }

    }

    @Override
    public int[][] getBoard() {
        return new int[0][];
    }
}
