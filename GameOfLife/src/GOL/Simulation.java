package GOL;

import java.util.Arrays;

public class Simulation {

    int [][] newBoard;
    int width, height;
    int [][] board;


    public Simulation(int width, int height){
        this.height = height;
        this.width = width;
        this.board = new int[width][height];
        this.newBoard = new int[width][height];

    }

    public void setValues(){
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                board[i][j] = (int)Math.round(Math.random());
                newBoard[i][j] = 0;
            }

        }

    }

    public void printBoard(){
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                if(board[i][j] == 0){
                    System.out.print("▒"+" ");

                }
                else{
                    System.out.print("█"+" ");

                }
                //System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }

    }

    public int getStatus(int x, int y){
        if(x<0 || x>=width){
            return 0;

        }
        if(y<0 || y>=height){
            return 0;

        }
        else{
            return board[x][y];

        }
    }

    public int countNeighbors(int x, int y){
        int count = 0;
        count += getStatus(x-1, y-1);
        count += getStatus(x, y-1);
        count += getStatus(x+1, y-1);

        count += getStatus(x-1, y);
        count += getStatus(x+1, y);

        count += getStatus(x-1, y+1);
        count += getStatus(x, y+1);
        count += getStatus(x+1, y+1);

        return count;

    }

    public void newGeneration(){

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                int countNeighbors = countNeighbors(i,j);

                if(board[i][j] == 1){
                    if(countNeighbors < 2){
                        newBoard[i][j] = 0;

                    }
                    else if(countNeighbors > 3){
                        newBoard[i][j] = 0;

                    }
                    else if(countNeighbors == 2 || countNeighbors == 3){
                        newBoard[i][j] = 1;

                    }


                }
                else{
                    if(countNeighbors == 3){
                        newBoard[i][j] = 1;}

                }
            }
        }

        status();

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                board[i][j]=newBoard[i][j];
            }
        }
    }

    public void status(){
        int cnt = 0;
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                if(board[i][j]==newBoard[i][j])cnt++;
            }
        }
        if(cnt==width*height)System.exit(0);
    }

    public void startGame(){
        setValues();
        do{

            printBoard();
            newGeneration();
            System.out.println();



        }while(true);

    }

}
