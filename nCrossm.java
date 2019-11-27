import java.util.*;
import java.lang.*;
import java.io.*;

class nCrossm
 {
    static  void sort(int a[],int index[],int p) 
    { 
        int n = a.length; int temp=0,temp2=0;
        for (int i = 0; i < p; ++i) {                    //greatest p element
            
            for(int j=i+1;j<n;j++)
            {
                if(a[i]<a[j])
              {  temp=a[j]; temp2=index[j];
                a[j]=a[i];  index[j]=index[i];
                a[i]=temp;   index[i]=temp2;}
            }
        }
    }
	public static void main (String[] args)
	 {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the number of companies : ");
        int m=sc.nextInt();
        System.out.println("\nFor each company , input the skills requirement by entering the number corresponding to the skill list :  \n1.Programming \n2.Web Development \n3.Machine Learning  \n4.Software Development \n5.Artificial Intelligence  \n6.Networking \n7.Database Management \n8.Android development \n0.Done\n");
        
        int skills[][]=new int[m][8];

        for(int i=0;i<m;i++)
        {   System.out.print("Company "+(i+1)+" : ");
             int j=sc.nextInt();
            while(j>=1&&j<=8)
            { skills[i][j-1]=1;
                j=sc.nextInt();
                }
            System.out.print("\n");
        }

        System.out.print("Enter the number of job applicants : ");
        int n=sc.nextInt();
        System.out.println("\n...................");
    
        System.out.println("\n...................");

        System.out.println("\nOn a scale of 1-10 rate your skills : \n(Give a series of integer 1-10 separated by a single space denoting the strength in the fields: Programming, Web Development, Machine Learning , Software Development, Artificial Intelligence , Networking, Database Management, Android development) \n");

       int a[][]=new int[n][8];                                //applicant-experiance matrix
       for(int i=0;i<n;i++)
       {   
           System.out.print("Applicant"+(i+1)+" : ");
           for(int j=0;j<8;j++)
           {
               a[i][j]=sc.nextInt();                                       //input work experiance
           }
           System.out.print("\n");

       }

       int c[][]=new int[m][n];                               //cost of each comp-applicant matrix
       
       for(int i=0;i<m;i++)
       {
           for(int j=0;j<n;j++)                           //Cost matrix
           {
               int count=0;
               for(int k=0;k<8;k++)
              { if(skills[i][k]==1)
               {c[i][j]+=a[j][k];
                 count++;}}
                 c[i][j]=c[i][j]*8/count;
           }
       }

       for(int i=0;i<m;i++)
       {
           for(int j=0;j<n;j++)                         //debug
           System.out.print(c[i][j]+" ");
           System.out.print("\n");

       }

      //long startTime=System.nanoTime();

       int p=n;                          //% candidates are shortlisted
       int companyShortList[][]=new int[m][p];
       int index[]=new int[5];
       int temp[]=new int[5];

       System.out.println("......................................\nApplicant's best matches based on their skills : ");

       for(int i=0;i<n;i++)                     //Applicant's preference order
       {
           for(int j=0;j<m;j++)
           {
               index[j]=j;
               temp[j]=c[j][i];
           }
          // int p=n<5?n:5;
           sort(temp,index,p);
          System.out.println("Applicant "+(i+1)+" Based on your skills your best matches are : \n");
           for(int k=0;k<m;k++)                                                        
           {
                System.out.println("                         "+(k+1)+". Company "+(index[k]+1));
                          
               }
               System.out.println("\n");
           }
           System.out.println("......................................");
           System.out.println("\nFor Companies best sorted list of Applicants are : \n");

           temp=new int[n];
           index=new int[n];

    for(int i=0;i<m;i++)                              //Company shortlisting
       {
           for(int j=0;j<n;j++)
           {
               index[j]=j;
               temp[j]=c[i][j];
           }
           
           sort(temp,index,p);
         
                    System.out.println("Company "+(i+1)+" : ");
                       

           //  companyShortList=new int[5][p];
           for(int k=0;k<p;k++)
           {   companyShortList[i][k]=index[k];
              /* switch(index[k])
               {
                   case 0: System.out.println("     "+(k+1)+". Applicant 1");
                           break;
                   case 1: System.out.println("     "+(k+1)+". Applicant 2");
                           break;
                   case 2: System.out.println("     "+(k+1)+". Applicant 3");
                           break;
                   case 3: System.out.println("     "+(k+1)+". Applicant 4");
                           break;
                   case 4: System.out.println("     "+(k+1)+". Applicant 5");
                           break;
               }*/
               System.out.println("     "+(k+1)+". Applicant "+(companyShortList[i][k]+1));
               }
               System.out.println("\n");
           }
           System.out.println("......................................");

           System.out.println("Final Assignment : \n");

           HashSet <Integer>hs=new HashSet<Integer>();
          // int size=0;
           
            if(n!=m)
            {  
               for(int i=0;i<m;i++)
               {  int tempSize=hs.size();
               for(int j=0;j<p;j++)
               {
                   hs.add(companyShortList[i][j]);
                   if(hs.size()>tempSize) 
                   {

                       System.out.print("Company "+(i+1)+" : ");
                       System.out.println("Applicant "+(companyShortList[i][j]+1));
                        break;
                    }
                     else if(j==p-1)
                     {
                        System.out.print("Company "+(i+1)+" : ");
                        System.out.println("No match found ");

                     }
               }
            }
        }
        else{
           
            
           
                /*  for(int i=0;i<5;i++)
                  {
                      for(int j=0;j<n;j++)                         //debug
                      System.out.print(companyShortList[i][j]+" ");
                      System.out.print("\n");
           
                  }*/
      
                  //System.out.println("......");
      
                  for(int i=0;i<m;i++)
                  for(int j=0;j<n;j++)
                  c[i][j]=80-c[i][j];
      
                  HungarianAlgorithm ha = new HungarianAlgorithm(c);
            int[][] assignment = ha.findOptimalAssignment();
      
            for(int i=0;i<assignment.length;i++)
            {
                System.out.print("Company "+(assignment[i][1]+1)+" : ");
                System.out.println("Applicant "+(assignment[i][0]+1));
              }
      
            }
            System.out.println("\n......................................");
      
        }
            //System.out.println("\n......................................");
        
       }
    



       


    
 