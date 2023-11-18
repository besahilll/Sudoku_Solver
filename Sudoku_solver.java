class Sudoku_solver{
    public static boolean isSudoku(int[][] Sudoku, int row, int col){

        //base condition
        if(row==9 && col==0){
            return true;
        }

        int nextRow=row;
        int nextCol=col+1;
        if(col+1==9){
            nextCol=0;
            nextRow=row+1;
        }
        //not placing any digit
        if(Sudoku[row][col]!=0){
            return isSudoku(Sudoku,nextRow,nextCol);
        }
        //placing digit
        for(int digit=1;digit<=9;digit++){
            if(isSafe(Sudoku,row,col,digit)){
                Sudoku[row][col]=digit;
                if(isSudoku(Sudoku,nextRow,nextCol)){
                    return true; //Sol exists
                }
                Sudoku[row][col]=0;
            }
        }
    return false;
    }

    //is it safe to place digit in a cell
    public static boolean isSafe(int[][] Sudoku, int row, int col, int digit){
        //checking column
        for(int i=0;i<=8;i++){
            if(Sudoku[i][col]==digit){
                return false;
            }
        }

        //checking row
        for(int j=0;j<8;j++){
            if(Sudoku[row][j]==digit){
                return false;
            }
        }

        //checking the 3x3 grid
        int sr=(row/3)*3;
        int sc=(col/3)*3;

        for(int i=sr;i<sr+3;i++){
            for(int j=sc;j<sc+3;j++){
                if(Sudoku[i][j]==digit){
                    return false;
                }
            }
        }
        return true;
    }

    public static void PrintSudoku(int Sudoku[][]){
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                System.out.print(Sudoku[i][j] + " ");
            }
            System.out.println();
        }

    }

    public static void main(String[] args){
        int[][] Sudoku = { {0,0,8,0,0,0,0,0,0},
        {4,9,0,1,5,7,0,0,2},
        {0,0,3,0,0,4,1,9,0},
        {1,8,5,0,6,0,0,2,0},
        {0,0,0,0,2,0,0,6,0},
        {9,6,0,4,0,5,3,0,0},
        {0,3,0,0,7,2,0,0,4},
        {0,4,9,0,3,0,0,5,7},
        {8,2,7,0,0,9,0,1,3}};

        if(isSudoku(Sudoku,0,0)){
            System.out.println("Solution exists");
            System.out.println("----------Printing Sudoku--------------");
            PrintSudoku(Sudoku);
        }
        else{
            System.out.println("Solution does not exist");
        }
    }
}
