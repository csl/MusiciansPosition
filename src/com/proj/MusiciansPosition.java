package com.proj;
import java.util.Scanner;

public class MusiciansPosition
{
	//The maximum number of positions is 8
	static int MAXROWS=10;
	static int MAXPOS=8;
	static int Weigh_MIN=45;
	static int Weigh_MAX=200;
	static int MAXKG=500;
	
    public  MusiciansPosition () 
    {
        super();
    }
    
    public static void allocArray(int rows, int col[], double mp[][])
    {
    	//allocate arrary
    	int row,column;
    	for (row = 0; row < rows; row++) {
    	    mp[row] = new double[col[row]];
    	    for (column = 0; column < col[row]; column++) {
    	    	mp[row][column]  = 0;
    	    }
    	}    	    	
    }
    
    public static void printMP(int rows, int col[], double mp[][])
    {
    	//A:   0.0   0.0   0.0                                [    0.0,     0.0]
    	char alph = 'A';
    	int i = 0, j = 0;
    	int achar = 0;
    	double sum = 0;
    	
    	for (i=0; i<rows; i++)
    	{
	        System.out.printf("%c:   ", alph);    			
    		for (j=0; j<col[i]; j++)
    		{
    	        System.out.printf("%f   ", mp[i][j]);
    		}    		
	        System.out.printf("                                [    %f,     %f]\n", sum, sum/j);
	        
        	//for next
        	achar = (int) alph;
        	achar++;
        	alph = (char) achar;
    	}
    }    
    
    public static void main(String[] args) throws Exception 
    {
    	int rows=0, achar = 0;
    	String menu_item;
    	char alph = 'A';
    	int cols[];
    	double MusiciansPos[][];
    	
    	Scanner scanner = new Scanner(System.in);

    	//get information
        System.out.println("Welcome to the Band of the Hour");
        System.out.println("-------------------------------");

    	//get rows information
        System.out.print("Please enter number of rows               : ");
    	rows = scanner.nextInt();
        while (rows >= MAXROWS || rows<=0)
        {
        	System.out.print("ERROR: Out of range, try again            : ");
        	rows = scanner.nextInt();
        }
        
    	//get cols information
        cols = new int[rows];
        MusiciansPos = new double[rows][];
        for (int i=0; i<rows; i++)
        {
        	System.out.print("Please enter number of positions in row " + alph + ": ");
        	cols[i] = scanner.nextInt();
            while (cols[i] >= MAXPOS || cols[i]<=0)
            {
            	System.out.print("ERROR: Out of range, try again            : ");
            	cols[i] = scanner.nextInt();
            }
            
        	//for next
        	achar = (int) alph;
        	achar++;
        	alph = (char) achar;
        }
        
        //allocate memory
        allocArray(rows, cols, MusiciansPos);

        //Menu function
        System.out.println("");
        while (true)
        {
            System.out.print("(A)dd, (R)emove, (P)rint,          e(X)it : ");
            menu_item = scanner.next();
            switch (menu_item.charAt(0))
            {
            case 'A':
            case 'a':
            	
            	break;
            case 'R':
            case 'r':
            	
            	break;          
            case 'P':
            case 'p':
            	printMP(rows, cols, MusiciansPos);
            	break;          
            case 'E':
            case 'e':
            	System.exit(0);
            	break;
            }
        	        	
        	
        }
        
        
    }
    
    
 }
