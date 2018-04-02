package com.intern.mallika.recycle;

import android.util.Log;
import android.widget.Toast;

import java.util.InputMismatchException;
import java.util.Stack;

/**
 * Created by Mallika on 1/25/2018.
 */

public class ShortestPath {
    private int TotalTemples;
    private Stack<Integer> stack;
    public int[] fin = new int[20];//here array will be of size total number of check boxes checked
    int[][] Main_matrix ;

    public ShortestPath() {
        stack = new Stack<Integer>();
    }

    public int[] tsp(int Matrix[][]) {
        TotalTemples = Matrix[1].length -1;
        //Log.d("Total temples", "tsp: "+TotalTemples);
        int[] visited = new int[TotalTemples +1];
        visited[0] = 1;
        stack.push(0);
        int current, desti = 0, i, k = 1;
        int min = Integer.MAX_VALUE;
        boolean minvalue = false;
        //System.out.print(1 + "\t");
        fin[0]=0;
        while (!stack.isEmpty()) {
            current = stack.peek();
            i = 1;
            min = Integer.MAX_VALUE;
            while (i <= TotalTemples) {
                if (Matrix[current][i] > 1 && visited[i] == 0) {
                    if (min > Matrix[current][i]) {
                        min = Matrix[current][i];
                        desti = i;
                        minvalue = true;
                    }
                }
                i++;
            }
            if (minvalue) {
                visited[desti] = 1;
                stack.push(desti);
                fin[k] =desti;
                k++;
                //System.out.print(desti + "\t");
                minvalue = false;
                continue;
            }
            stack.pop();
        }
       return fin;
    }

    public int[] path(int[] initial, int count) {
//        int number_of_Temples;
        int[][] distance = new int[19][19];

//Tirumala-1st place

        distance[0][0]=0;
        distance[0][1]=29;
        distance[0][2]=38;
        distance[0][3]=26;
        distance[0][4]=16;
        distance[0][5]=21;
        distance[0][6]=86;
        distance[0][7]=139;
        distance[0][8]=19;
        distance[0][9]=60;
        distance[0][10]=43;
        distance[0][11]=86;
        distance[0][12]=61;
        distance[0][13]=64;
        distance[0][14]=20;
        distance[0][15]=96;
        distance[0][16]=3;
        distance[0][17]=6;
        distance[0][18]=5;

//Srinivasa Mangapuram 2nd place

        distance[1][0]=29;
        distance[1][1]=0;
        distance[1][2]=26;
        distance[1][3]=14;
        distance[1][4]=12;
        distance[1][5]=10;
        distance[1][6]=58;
        distance[1][7]=111;
        distance[1][8]=12;
        distance[1][9]=50;
        distance[1][10]=34;
        distance[1][11]=73;
        distance[1][12]=48;
        distance[1][13]=57;
        distance[1][14]=10;
        distance[1][15]=67;
        distance[1][16]=31;
        distance[1][17]=34;
        distance[1][18]=33;

//Appalayagunta 3rd place

        distance[2][0]=38;
        distance[2][1]=26;
        distance[2][2]=0;
        distance[2][3]=12;
        distance[2][4]=18;
        distance[2][5]=16;
        distance[2][6]=70;
        distance[2][7]=134;
        distance[2][8]=18;
        distance[2][9]=43;
        distance[2][10]=16;
        distance[2][11]=47;
        distance[2][12]=26;
        distance[2][13]=48;
        distance[2][14]=39;
        distance[2][15]=87;
        distance[2][16]=62;
        distance[2][17]=65;
        distance[2][18]=65;

//Tiruchanur 4th place

        distance[3][0]=26;
        distance[3][1]=14;
        distance[3][2]=12;
        distance[3][3]=0;
        distance[3][4]=7;
        distance[3][5]=5;
        distance[3][6]=70;
        distance[3][7]=123;
        distance[3][8]=7;
        distance[3][9]=36;
        distance[3][10]=21;
        distance[3][11]=59;
        distance[3][12]=34;
        distance[3][13]=40;
        distance[3][14]=6;
        distance[3][15]=79;
        distance[3][16]=29;
        distance[3][17]=32;
        distance[3][18]=31;

//Kapila theertham 5th place

        distance[4][0]=16;
        distance[4][1]=12;
        distance[4][2]=18;
        distance[4][3]=7;
        distance[4][4]=00;
        distance[4][5]=4;
        distance[4][6]=70;
        distance[4][7]=123;
        distance[4][8]=1;
        distance[4][9]=40;
        distance[4][10]=28;
        distance[4][11]=65;
        distance[4][12]=40;
        distance[4][13]=45;
        distance[4][14]=4;
        distance[4][15]=79;
        distance[4][16]=22;
        distance[4][17]=25;
        distance[4][18]=25;

//Govindaraja Swamy Temple 6th place

        distance[5][0]=21;
        distance[5][1]=10;
        distance[5][2]=16;
        distance[5][3]=5;
        distance[5][4]=4;
        distance[5][5]=00;
        distance[5][6]=69;
        distance[5][7]=122;
        distance[5][8]=4;
        distance[5][9]=37;
        distance[5][10]=26;
        distance[5][11]=64;
        distance[5][12]=38;
        distance[5][13]=42;
        distance[5][14]=1;
        distance[5][15]=78;
        distance[5][16]=24;
        distance[5][17]=27;
        distance[5][18]=26;

//Kanipakam 7th place

        distance[6][0]=86;
        distance[6][1]=58;
        distance[6][2]=76;
        distance[6][3]=70;
        distance[6][4]=70;
        distance[6][5]=69;
        distance[6][6]=00;
        distance[6][7]=60;
        distance[6][8]=69;
        distance[6][9]=105;
        distance[6][10]=86;
        distance[6][11]=106;
        distance[6][12]=81;
        distance[6][13]=110;
        distance[6][14]=69;
        distance[6][15]=17;
        distance[6][16]=89;
        distance[6][17]=91;
        distance[6][18]=91;

//Golden Temple 8th place

        distance[7][0]=139;
        distance[7][1]=111;
        distance[7][2]=134;
        distance[7][3]=123;
        distance[7][4]=123;
        distance[7][5]=122;
        distance[7][6]=60;
        distance[7][7]=00;
        distance[7][8]=135;
        distance[7][9]=171;
        distance[7][10]=139;
        distance[7][11]=141;
        distance[7][12]=134;
        distance[7][13]=163;
        distance[7][14]=135;
        distance[7][15]=90;
        distance[7][16]=155;
        distance[7][17]=157;
        distance[7][18]=157;

//Isckon 9th place

        distance[8][0]=19;
        distance[8][1]=12;
        distance[8][2]=18;
        distance[8][3]=7;
        distance[8][4]=1;
        distance[8][5]=4;
        distance[8][6]=69;
        distance[8][7]=135;
        distance[8][8]=00;
        distance[8][9]=28;
        distance[8][10]=66;
        distance[8][11]=41;
        distance[8][12]=45;
        distance[8][13]=2;
        distance[8][14]=78;
        distance[8][15]=22;
        distance[8][16]=24;
        distance[8][17]=24;
        distance[8][18]=65;

//Sri Kalahasthi 10th place

        distance[9][0]=60;
        distance[9][1]=50;
        distance[9][2]=43;
        distance[9][3]=36;
        distance[9][4]=40;
        distance[9][5]=37;
        distance[9][6]=105;
        distance[9][7]=171;
        distance[9][8]=41;
        distance[9][9]=00;
        distance[9][10]=36;
        distance[9][11]=51;
        distance[9][12]=57;
        distance[9][13]=4;
        distance[9][14]=38;
        distance[9][15]=104;
        distance[9][16]=63;
        distance[9][17]=65;
        distance[9][18]=65;

//Gudi Mallavaram 11th place

        distance[10][0]=43;
        distance[10][1]=34;
        distance[10][2]=16;
        distance[10][3]=21;
        distance[10][4]=28;
        distance[10][5]=26;
        distance[10][6]=86;
        distance[10][7]=139;
        distance[10][8]=28;
        distance[10][9]=36;
        distance[10][10]=00;
        distance[10][11]=51;
        distance[10][12]=26;
        distance[10][13]=41;
        distance[10][14]=27;
        distance[10][15]=96;
        distance[10][16]=46;
        distance[10][17]=48;
        distance[10][18]=48;

//Nagalapuram 12th place

        distance[11][0]=86;
        distance[11][1]=73;
        distance[11][2]=47;
        distance[11][3]=59;
        distance[11][4]=65;
        distance[11][5]=64;
        distance[11][6]=106;
        distance[11][7]=141;
        distance[11][8]=66;
        distance[11][9]=51;
        distance[11][10]=51;
        distance[11][11]=00;
        distance[11][12]=26;
        distance[11][13]=56;
        distance[11][14]=67;
        distance[11][15]=138;
        distance[11][16]=88;
        distance[11][17]=90;
        distance[11][18]=90;

//Kalyana Venkateswara Swamy 13th place

        distance[12][0]=61;
        distance[12][1]=48;
        distance[12][2]=26;
        distance[12][3]=39;
        distance[12][4]=40;
        distance[12][5]=38;
        distance[12][6]=81;
        distance[12][7]=134;
        distance[12][8]=41;
        distance[12][9]=57;
        distance[12][10]=26;
        distance[12][11]=26;
        distance[12][12]=00;
        distance[12][13]=61;
        distance[12][14]=42;
        distance[12][15]=112;
        distance[12][16]=63;
        distance[12][17]=65;
        distance[12][18]=65;

//Agastheeshwara Temple 14th place

        distance[13][0]=64;
        distance[13][1]=57;
        distance[13][2]=48;
        distance[13][3]=40;
        distance[13][4]=45;
        distance[13][5]=42;
        distance[13][6]=110;
        distance[13][7]=163;
        distance[13][8]=45;
        distance[13][9]=4;
        distance[13][10]=41;
        distance[13][11]=56;
        distance[13][12]=61;
        distance[13][13]=00;
        distance[13][14]=43;
        distance[13][15]=119;
        distance[13][16]=67;
        distance[13][17]=70;
        distance[13][18]=70;

//Sri Kodanda Rama Swamy Temple 15th place

        distance[14][0]=20;
        distance[14][1]=10;
        distance[14][2]=39;
        distance[14][3]=6;
        distance[14][4]=4;
        distance[14][5]=1;
        distance[14][6]=69;
        distance[14][7]=135;
        distance[14][8]=2;
        distance[14][9]=38;
        distance[14][10]=27;
        distance[14][11]=67;
        distance[14][12]=42;
        distance[14][13]=43;
        distance[14][14]=00;
        distance[14][15]=77;
        distance[14][16]=24;
        distance[14][17]=26;
        distance[14][18]=26;

//Ardhagiri 16th place

        distance[15][0]=96;
        distance[15][1]=67;
        distance[15][2]=87;
        distance[15][3]=79;
        distance[15][4]=79;
        distance[15][5]=78;
        distance[15][6]=17;
        distance[15][7]=90;
        distance[15][8]=78;
        distance[15][9]=114;
        distance[15][10]=96;
        distance[15][11]=138;
        distance[15][12]=112;
        distance[15][13]=119;
        distance[15][14]=77;
        distance[15][15]=00;
        distance[15][16]=98;
        distance[15][17]=100;
        distance[15][18]=100;

//Sila Thoranam 17th place

        distance[16][0]=3;
        distance[16][1]=31;
        distance[16][2]=62;
        distance[16][3]=29;
        distance[16][4]=22;
        distance[16][5]=24;
        distance[16][6]=89;
        distance[16][7]=155;
        distance[16][8]=22;
        distance[16][9]=63;
        distance[16][10]=46;
        distance[16][11]=88;
        distance[16][12]=63;
        distance[16][13]=67;
        distance[16][14]=24;
        distance[16][15]=98;
        distance[16][16]=00;
        distance[16][17]=3;
        distance[16][18]=6;

//Srivari Paadalu,Tirumala 18th place

        distance[17][0]=6;
        distance[17][1]=34;
        distance[17][2]=65;
        distance[17][3]=32;
        distance[17][4]=25;
        distance[17][5]=27;
        distance[17][6]=91;
        distance[17][7]=157;
        distance[17][8]=24;
        distance[17][9]=65;
        distance[17][10]=48;
        distance[17][11]=90;
        distance[17][12]=65;
        distance[17][13]=70;
        distance[17][14]=26;
        distance[17][15]=100;
        distance[17][16]=3;
        distance[17][17]=00;
        distance[17][18]=8;

//Akasaganga 19th place

        distance[18][0]=5;
        distance[18][1]=33;
        distance[18][2]=65;
        distance[18][3]=31;
        distance[18][4]=25;
        distance[18][5]=26;
        distance[18][6]=91;
        distance[18][7]=157;
        distance[18][8]=24;
        distance[18][9]=65;
        distance[18][10]=48;
        distance[18][11]=90;
        distance[18][12]=65;
        distance[18][13]=70;
        distance[18][14]=26;
        distance[18][15]=100;
        distance[18][16]=6;
        distance[18][17]=7;
        distance[18][18]=00;
        // int count = 8;  //the array list length is assigned to count
        //int[] initial = new int[counter];            // The ids which are clicked comes into this array  ie the array list which we get from the card view activity
        // This is the main matrix for which we deal the shortest path
        Main_matrix=new int[count][count];
        for (int r = 0; r < count; r++)
            for (int rq = 0; rq < count; rq++)
                Main_matrix[r][rq] = distance[initial[r]][initial[rq]];
        for (int i = 0; i < count; i++)
        {
            for (int j = 0; j < count; j++)
            {
                if (Main_matrix[i][j] == 1 && Main_matrix[j][i] == 0)
                {
                    Main_matrix[j][i] = 1;
                }
            }
        }
            //System.out.println();
            int[] result=tsp(Main_matrix);
            return result;
    }
}




