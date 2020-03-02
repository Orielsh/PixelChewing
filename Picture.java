class Picture {

    private Pixel[][] board;

    Picture (int n){
        board = new Pixel[n][n];
        for(int i = 0; i<n; i++)
            for(int j = 0; j<n; j++)
                board [i][j] = new Pixel(false);
    }

    public Pixel getPixel(int i, int j){
        return this.board[i][j];
    }

    public int getSize(){return this.board.length;}

    public void clear(){
        int n = board.length;
        for(int i = 0; i<n; i++)
            for(int j = 0; j<n; j++)
                board [i][j] = new Pixel(false);
    }

    public void evolve(int i, int j){
        boolean result = true;
        if(this.board[i][j].isAlive()) {
            if (inRange(i - 1, j - 1) && !board[i - 1][j - 1].isAlive())
                result = false;
            if (inRange(i - 1, j) && !board[i - 1][j].isAlive())
                result = false;
            if (inRange(i - 1, j + 1) && !board[i - 1][j + 1].isAlive())
                result = false;
            if (inRange(i, j - 1) && !board[i][j - 1].isAlive())
                result = false;
            if (inRange(i, j + 1) && !board[i][j + 1].isAlive())
                result = false;
            if (inRange(i + 1, j - 1) && !board[i + 1][j - 1].isAlive())
                result = false;
            if (inRange(i + 1, j) && !board[i + 1][j].isAlive())
                result = false;
            if (inRange(i + 1, j + 1) && !board[i + 1][j + 1].isAlive())
                result = false;
            board[i][j].setNextGen(result);
        }
    }

    public void evolve(){
        for(int i=0; i< board.length; i++){
            for (int j=0; j<board.length; j++){
                board[i][j].evolve();
            }
        }
    }

    public boolean inRange(int i, int j){
        return (i>=0 && j >=0 && i < board.length && j < board.length);
    }
}
