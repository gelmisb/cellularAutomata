#include <stdio.h>
#include <math.h>
#include <stdlib.h>

int main (){

  int map[1000][1000]; //1000 by 1000 grid = 1,000,000
  int neighbours[8]; //neighbours
  int total = 0;
  int totalDead = 0;
  int totalRecovered = 0;
  double chance = 20.0;
  int state = 0; //person is healthy

  int i, j, g, inf;
  int k = 0;

  //--------------Seed For Random Numbers-----------
  time_t t;
  /* Inititializes random number generator*/
  srand((unsigned) time(&t));
  //------------------------------------------------



  
  //populating map array with 0's
  for(i = 0; i < 1000; i++){       // Looping through rows in 2d array called map

    for(j = 0; j < 1000; j++){     // Looping through columns in 2d array called map

      map[i][j] = 0;               // Setting the state to be 0 ;
                                   // If state = 0; individual = healthy

    }                              // End of column loop

  }                                // End of row loop


  //infecting 5 random people

  for(inf = 0; inf < 5; inf++){             // Loop for infecting 5 random people

    double rand1 = floor(rand() % 1000);    // Random function is called and the number decided by diving from 1000

    double rand2 = floor(rand() % 1000);    // Random function is called and the number decided by diving from 1000
    
    int randFin1 = (int) rand1;             // Finding the random number

    int randFin2 = (int) rand2;             // Finding the random number
    
    map[randFin1][randFin2] = 1;            // Infecting random number
    
  }                                         // End of infecting 5 random people
  
  total = 5;//total infected




  for(g = 0; g < 400; g++){// Setting the generations to loop 400 = 400 days

    for(i = 0; i < 1000; i++){// Looping rows in 2D map array

      for(j = 0; j < 1000; j++){// Looping columns in 2D map array

	int nextGen = 1;// Boolean logic to prevent changing array in the same generation

	neighbours[0] = map[(i + 1000 - 1) % 1000][j];                          //left neigbour

	neighbours[1] = map[(i + 1000 + 1) % 1000][j];	//right neighbour

	neighbours[2] = map[i][(j + 1000 - 1) % 1000];	//top neighbor

	neighbours[3] = map[i][(j + 1000 + 1) % 1000];	//bottom neigbuor

	neighbours[4] = map[(i + 1000 - 1) % 1000][(j + 1000 + 1) % 1000];	//bottom left neighbour

	neighbours[5] = map[(i + 1000 + 1) % 1000][(j + 1000 + 1) % 1000];//bottom right neighbour

	neighbours[6] = map[(i + 1000 - 1) % 1000][(j + 1000 - 1) % 1000];//top left neighbour

	neighbours[7] = map[(i + 1000 + 1) % 1000][(j + 1000 - 1) % 1000];//top right neigbour

	int infections = 0;
	int dead = 0;
	int p;

	//
	for(p = 0; p < 8; p++ ){
	  if(neighbours[p] == 1){
	    infections++;
	  }
	
	  if(neighbours[p] == 2){
	    dead++;
	  }
	}

	if(infections > 0 && map[i][j] == 0){   // If the person is healthy

	  chance = 20.0;                        // For the person to be infected
	
	  if(floor(rand() % 101) < chance){     // Person is infected

	    total++;                            // Increasing total people infected

	    map[i][j] = 1;                      // Setting state to infected

	    nextGen = 0;                        // generation back to 0

	  }                                     //end of infections if statement

	}                                       //end of chancing life


      
	if(map[i][j] == 1 && nextGen){          // If state is set to 1 (infected) and it's a new generation

	  chance = 10.0;                        // For the person to become susceptible
	
	  if(floor(rand() % 101) < chance){     // A random number is given to see if the individual's chance is higher

	    total--;                            // Lowering the amount of individuals infected

	    totalDead++;                        // Increasing the number of susceptible

	    map[i][j] = 2;                      // Setting the state to dead

      }                                     //end of susceptible if statement

    }                                       //end of chancing life



	if(map[i][j] == 1 && nextGen){          // If state is set to 1 (infected) and it's a new generation

	  chance = 5.0;                         // For the person to become recovered
	
	  if(floor(rand() % 101) < chance){     // A random number is given to see if the individual's chance is higher

	    totalRecovered++;                   // Increasing the number of recovered

	    total--;                            // Lowering the amount of individuals infected

	    map[i][j] = 3;                      // Setting the state to recovered

      }                                     //end of recovered if statement

    }                                       //end of chancing lif

  }

}
  
      FILE *fp;
      int loop1, loop2;
   
      //every 50 generations create file with results
      if(g%50==0){
	//incrementing file name
	char buffer[32];
	snprintf(buffer, sizeof(char) * 32, "file%i.dat", k);
      
	//open the file
	fp = fopen(buffer, "w");
	if (fp == NULL) {
	  printf("I couldn't open file for writing.\n");
	  exit(0);
	}
    
	//outputting the array into the file
	for (loop1=0; loop1<1000; ++loop1){
	  for(loop2 = 0; loop2<1000; ++loop2){
	    fprintf(fp,"%d\t", map[loop1][loop2]);
	  }
	}
    
	//close the file
	fclose(fp);
	
	k++;
      }
  }

   
      return 0;
  
}
