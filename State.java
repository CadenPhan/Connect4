package ConnectFour;

public class State
{ 
    private int gameState = Constants.STANDBY;
    private int whoseMove = Constants.X;
    private String xName = "";
    private String oName = "";
    private int[][] board = new int[Constants.BOARD_HEIGHT][Constants.BOARD_WIDTH];
    UI ui = new UI();

    public boolean isWinner() {
        int total = 0;
        for (int rowCheck = 5; rowCheck >= 0; rowCheck--) {
            for (int colCheck = 0; colCheck < 4; colCheck++) {
                total += 
                getBoardCell(rowCheck, colCheck);
            }
            if (total == -4 || total == 4) {
                return true;
            }
        }
        return false;
    }

    public boolean isTie() {
        for (int row=0; row<Constants.BOARD_HEIGHT; row++) {
            for (int col=0; col<Constants.BOARD_WIDTH; col++) {
                if (getBoardCell(row,col) == Constants.BLANK) {
                    return false;
                }
            }
        }
        return true;
    }

    public int getGameState() {
        return gameState;
    }

    public void setGameState(int gameState) {
        this.gameState = gameState;
    }

    public int getWhoseMove() {
        return whoseMove;
    }

    public void setWhoseMove(int whoseMove) {
        this.whoseMove = whoseMove;
    }

    public String getxName() {
        return xName;
    }

    public void setxName(String xName) {
        this.xName = xName;
    }

    public String getoName() {
        return oName;
    }

    public void setoName(String oName) {
        this.oName = oName;
    }

    public int getBoardCell(int row, int col) {
        return this.board[row][col];
    }

    public void setBoardCell(int row, int col, int value) {
        this.board[row][col] = value;
    }

    public int getMoveRow(int col) {
        for (int row = Constants.BOARD_HEIGHT; row > 0; row--) {
            int gravity = getBoardCell(row - 1, col - 1);
            if (gravity == Constants.BLANK) {
                return row;
            }
        }
        return 6;
    }
}
