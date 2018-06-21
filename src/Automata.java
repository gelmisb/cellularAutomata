public class Automata {
public int newState = 0;

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        int map[][] = new int[1000][1000];// 10 by 10 grid = 100
        int neighbors[];
        int total;
        int totalDead = 0;
        int totalRecovered = 0;
        double chance = 20 ;
        int state = 0; //person is healthy


        for (int i = 0; i <1000; i++) {
            for (int j = 0; j < 1000; j++) {

                map[i][j] = 0; // initialize to 0 = not infected

            }
        }

        map[2][5] = 1;
        map[55][5] = 1;
        map[200][6] = 1;
        map[56][4] = 1;
        map[890][5] = 1;
        total = 5;


       for (int g = 0; g < 1000; g++) {


            for (int i = 0; i < 1000; i++) {

                for (int j = 0; j < 1000; j++) {

                    boolean nextGen = true;

                    //getting 4 neighbors around
                    neighbors = new int[8];

                    neighbors[0] = map[(i + 1000 - 1) % 1000][j];
                    neighbors[1] = map[(i + 1000 + 1) % 1000][j];
                    neighbors[2] = map[i][(j + 1000 - 1) % 1000];
                    neighbors[3] = map[i][(j + 1000 + 1) % 1000];

                    neighbors[4] = map[(i + 1000 - 1) % 10][(j + 1000 + 1) % 1000];
                    neighbors[5] = map[(i + 1000 + 1) % 10][(j + 1000 + 1) % 1000];
                    neighbors[6] = map[(i + 1000 - 1) % 10][(j + 1000 - 1) % 1000];
                    neighbors[7] = map[(i + 1000 + 1) % 10][(j + 1000 - 1) % 1000];

                    int infections = 0;
                    int dead = 0;


                    for(int p = 0;p < neighbors.length;p++){
                        if(neighbors[p] == 1)
                        infections++;

                    }

                    for(int p = 0;p < neighbors.length;p++){
                        if(neighbors[p] == 2)
                            dead++;

                    }

                    //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
                    //First comparison:
                    // - Compiled in: 1.234ms
                    // - Run time: 30minutes
                    // - 18mil
                    //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!


                    if (infections > 0 && map[i][j] == 0) {


                        chance = 12.5 * infections;
                        if (Math.floor(Math.random() * 101) < chance) {
                            // Person is infected

                            total++;
                            System.out.println("INFECTION " + total);

                            map[i][j] = 1;
                            nextGen = false;

                        }//end of infections if statement
                    }// end of chancing life

                    if (map[i][j] == 1 && nextGen) {
                        chance = 25;
                        if (Math.floor(Math.random() * 101) < chance) {
                            // Person is Dead
                            total--;
                            totalDead++;
                            map[i][j] = 2;
                            System.out.println("DEAD " + totalDead);
                        }
                    }

                    if (map[i][j] == 1 && nextGen) {
                        chance = 10;

                        if (Math.floor(Math.random() * 101) < chance) {
                            totalRecovered++;
                            total--;
                            map[i][j] = 3;
                            System.out.println("Recovered ----------------------------------------" + totalRecovered);
                        }
                    }


                }//end of for loop for generations
            }//end of for loop for tasks
        }//end of generation
    }//end of main
}//end of class


// The code has to be finished
// Re-written into C
// A visualization program has to be created
// Program has to be parallelized
// A visual program made for the parallelized vrs
// Documentation written up for not more 10,000 words
// Program to be documented and fully commented
// 10 minute presentation on the project in the lab


// Successful implementation of a serial and parallel program.
//        • Testing of your programs.
//        • Research: demonstrating that you have engaged in a reasonably broad and indepth
//        research of the project subject
//        • Understanding and discussion of topic: demonstrating in your presentation and
//        report that you understand the subject and that you are able to discuss it using
//        appropriate technical language
//        • Originality: showing an interesting an original approach
//        • Professional style in both presentation and report: Use of title page, consistent
//        styles, page numbers, tables of contents, etc.
//        • Inclusion and proper use of references in both report and presentation: You must
//        provide citations within the text of your report and presentation. Please do not use
//        Wikipedia as a reference; instead, if you do use Wikipedia as an information source,
//        please go to the original references cited within those Wikipedia pages