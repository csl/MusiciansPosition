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
	
	static int rows=0;
	static int cols[];

	
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
    public static void addMP(int rows, int col[], double mp[][])
    {
    	Scanner scanner = new Scanner(System.in);
    	String row_item;
    	int achar=0, nchar=0;
    	int pos = 0, weight=0;

    	double sum=0;
    	
    	//row letter
       System.out.print("Please enter row letter                   : ");
       row_item = scanner.next();
       achar = (int) row_item.charAt(0);

       nchar = achar;
       if (achar >= 97 && achar <= 123)
    	   nchar = achar - 97;
       else if (achar >= 65 && achar <= 91)
    	   nchar = achar - 65;
       
       while (nchar >= rows || nchar < 0)
        {
        	System.out.print("ERROR: Out of range, try again            : ");
        	row_item = scanner.next();
           achar = (int) row_item.charAt(0);

           if (achar >= 97 && achar <= 106)
         	  nchar = achar - 97;
           else if (achar >= 65 && achar <= 74)
         	  nchar = achar - 65;
        }

      	//get position number information
       System.out.printf("Please enter position number (1 to %d)     : ", col[nchar]);
   	   pos = scanner.nextInt();
       while (pos > col[nchar] || pos <= 0)
       {
       	System.out.print("ERROR: Out of range, try again            : ");
       	pos = scanner.nextInt();
       }
       
       if (mp[nchar][pos-1] != 0 )
       {
           System.out.print("ERROR: There is already a musician there.\n");
           return;
       }

     	//get weight information
       System.out.print("Please enter weight (45.0 to 200.0)       : ");
       weight = scanner.nextInt();
       while (weight > 200 || weight < 45)
       {
       	System.out.print("ERROR: Out of range, try again            : ");
       	weight = scanner.nextInt();
       }

       for (int l=0; l<col[nchar]; l++)
        {
    	   sum = sum + mp[nchar][l];
        }
       
       
       if (sum + weight > MAXKG)
       {
           System.out.print("ERROR: That would exceed the average weight limit.\n");    
           return;
       }      

       //add data for weight
       mp[nchar][pos-1] = weight;
       
       System.out.print("****** Musician added.\n");
    }

    public static void removeMP(int rows, int col[], double mp[][])
    {
    	Scanner scanner = new Scanner(System.in);
    	String row_item;
    	int achar=0, nchar=0;
    	int pos = 0, weight=0;
    	
    	//row letter
       System.out.print("Please enter row letter                   : ");
       row_item = scanner.next();
       achar = (int) row_item.charAt(0);

       if (achar >= 97 && achar <= 123)
    	   nchar = achar - 97;
       else if (achar >= 65 && achar <= 91)
    	   nchar = achar - 65;
       
       while (nchar >= rows || nchar < 0)
        {
        	System.out.print("ERROR: Out of range, try again            : ");
        	row_item = scanner.next();
           achar = (int) row_item.charAt(0);

           if (achar >= 97 && achar <= 106)
         	  nchar = achar - 97;
           else if (achar >= 65 && achar <= 74)
         	  nchar = achar - 65;
        }

      	//get position number information
       System.out.printf("Please enter position number (1 to %d)     : ", col[nchar]);
   	   pos = scanner.nextInt();
       while (pos > col[nchar] || pos <= 0)
       {
       	System.out.print("ERROR: Out of range, try again            : ");
       	pos = scanner.nextInt();
       }
       
       if (mp[nchar][pos-1] == 0.0 )
       {
           System.out.print("ERROR: That position is vacant.\n");
           return;
       }
       
       mp[nchar][pos-1] = 0.0;
       
       System.out.print("****** Musician removed.\n");
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
	       System.out.printf("%c:", alph);    			
    		for (j=0; j<col[i]; j++)
    		{
    			if (mp[i][j] < 10)
    			{
    	        System.out.printf("   %1.1f", mp[i][j]);
    			}
    			else if (mp[i][j] < 100)
    			{
        	        System.out.printf("  %1.1f", mp[i][j]);    				
    			}
    			else
    			{
        	        System.out.printf(" %1.1f", mp[i][j]);    				
    			}   				
    		}    		
    		//format
    		for (int k=0; k<8-j; k++)
    		{
    	        System.out.printf("      ");    	         
    		}    		
    		
	       System.out.printf("[    %1.1f,     %1.1f]\n", sum, sum/j);
	        
        	//for next
        	achar = (int) alph;
        	achar++;
        	alph = (char) achar;
    	}
    }    
    
    public static void main(String[] args) throws Exception 
    {
    	int achar = 0;
    	boolean menu_error = false;
    	String menu_item;
    	char alph = 'A';
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
        	System.out.print("Please enter number of positions in row " + alph + " : ");
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
        
        menu_error=false;
        while (true)
        {
        	if (menu_error == false)
           {
            System.out.print("(A)dd, (R)emove, (P)rint,          e(X)it : ");
           }
          else
           {
            System.out.print("ERROR: Invalid option, try again          : ");
            menu_error = false;
           }

           menu_item = scanner.next();
           switch (menu_item.charAt(0))
            {
            case 'A':
            case 'a':
            	addMP(rows, cols, MusiciansPos);            	
              System.out.println("");
            	break;
            case 'R':
            case 'r':
            	removeMP(rows, cols, MusiciansPos);  
              System.out.println("");
            	break;          
            case 'P':
            case 'p':
              System.out.println("");
            	printMP(rows, cols, MusiciansPos);
              System.out.println("");
            	break;          
            case 'E':
            case 'e':
            	System.exit(0);
            	break;
            default:
            	menu_error = true;
            	break;
            }
        }
    }
 }
