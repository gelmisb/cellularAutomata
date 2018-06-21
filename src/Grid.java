

public class Grid {

    public Cell map[][];

    public int width;
    public int height;


    public Grid(int x,int y){

        width = y;
        height = x;
        map = new Cell[x][y];

    }

    public void addCellToGrid(Cell cell, int positionX, int positionY){

        map[positionX][positionY] = cell;
    }

    public int returnHeight (){
        return height;
    }

    public int returnWidth (){
        return width;
    }

}
