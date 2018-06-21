

public class Cell {

//    Healthy = 0;
//    Infected = 1;
//    Recovered = 2;
//    Dead = 3;

    int state;
    int generation;
    Grid myGrid = new Grid(10, 10);
    public int cellX, cellY;

    public Cell(int cellX, int cellY) {

        this.cellX = cellX;
        this.cellY = cellY;
        state = 0;
        generation = 0;
        System.out.println(cellX + " " + cellY);
//        Infected();

    }

//    public void Infected() {
//        for (int i = 0; i < 10; i++) {
//            if (Math.floor(Math.random() * 101) == i) {
//                state = 1;
//                System.out.println(cellX + " Infected " + cellY);
//            }
//
//        }
//    }



}


//        Grid myCell = new Grid(10, 10);



// If infected, check neighbor cells
// If state = 1, 80% of state being changed from 0 to 1
// if state = 1, visited ++;
// If visited = 20, check recover rate of 20%
// If recovered state changes from 1 = 2,
// If not recovered state changes from 1 = 3

//
//            //new connected component found
//
//            if ((data[i] == 255) && (labels[i] == 0)) {
//
//        if ((data[front - 1] == 255 && labels[front - 1] == 0)) {
//
//            //Enqueue the front with a minus one
//            q1.enqueue(front - 1);
//
//            //Assigning a new colour value
//            labels[front - 1] = currlabel;
//
//
//        }//end of first inner if statement


