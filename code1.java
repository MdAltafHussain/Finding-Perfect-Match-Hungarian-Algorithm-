import java.util.*;
import java.lang.*;
import java.io.*;

public class code1
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
        System.out.print("Enter the number of job applicants : ");
        int n=sc.nextInt();
        System.out.println("\n...................");
        System.out.println("\nThese are the list of some companies and their requirements : ");
        System.out.println("1.Google :\n     Skills Required - Programming, Web development, Machine Learning");
        System.out.println("2.Microsoft :\n     Skills Required - Software Development, Web development, Artificial intelligence");
        System.out.println("3.CISCO :\n     Skills Required - Networking, Programming, Database Management");
        System.out.println("4.HP :\n     Skills Required - Networking, Software Development, Web Development");
        System.out.println("5.Xiaomi :\n     Skills Required - Android Development, Software Development, Database Management");
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

       int c[][]=new int[5][n];                               //cost of each comp-applicant matrix
       for(int i=0;i<n;i++)
       {
           c[0][i]=a[i][0]+a[i][1]+a[i][2];                  //matching of google
       }
       for(int i=0;i<n;i++)
       {
           c[1][i]=a[i][1]+a[i][3]+a[i][4];                  //matching of microsoft
       }
       for(int i=0;i<n;i++)
       {
           c[2][i]=a[i][0]+a[i][5]+a[i][6];                  //matching of CISCO
       }
       for(int i=0;i<n;i++)
       {
           c[3][i]=a[i][1]+a[i][3]+a[i][5];                  //matching of hp
       }
       for(int i=0;i<n;i++)
       {
           c[4][i]=a[i][3]+a[i][6]+a[i][7];                  //matching of Xiaomi
       }


       for(int i=0;i<5;i++)
       {
           for(int j=0;j<n;j++)                         //debug
           System.out.print(c[i][j]+" ");
           System.out.print("\n");

       }

      //long startTime=System.nanoTime();

       int p=n;                          //% candidates are shortlisted
       int companyShortList[][]=new int[5][p];
       int index[]=new int[5];
       int temp[]=new int[5];

       System.out.println("......................................\nApplicant's best matches based on their skills : ");

       for(int i=0;i<n;i++)                     //Applicant's preference order
       {
           for(int j=0;j<5;j++)
           {
               index[j]=j;
               temp[j]=c[j][i];
           }
          // int p=n<5?n:5;
           sort(temp,index,p);
          System.out.println("Applicant "+(i+1)+" Based on your skills your best matches are : \n");
           for(int k=0;k<5;k++)                                                        
           {
               switch(index[k])
               {
                   case 0: System.out.println("                         "+(k+1)+". Google");
                           break;
                   case 1: System.out.println("                         "+(k+1)+". Microsoft");
                           break;
                   case 2: System.out.println("                         "+(k+1)+". CISCO");
                           break;
                   case 3: System.out.println("                         "+(k+1)+". HP");
                           break;
                   case 4: System.out.println("                         "+(k+1)+". Xiaomi");
                           break;
               }
               }
               System.out.println("\n");
           }
           System.out.println("......................................");
           System.out.println("\nFor Companies best sorted list of Applicants are : \n");

           temp=new int[n];
           index=new int[n];

    for(int i=0;i<5;i++)                              //Company shortlisting
       {
           for(int j=0;j<n;j++)
           {
               index[j]=j;
               temp[j]=c[i][j];
           }
           
           sort(temp,index,p);
         
           switch(i)
               {
                   case 0: System.out.println("1. Google : ");
                           break;
                   case 1: System.out.println("2. Microsoft : ");
                           break;
                   case 2: System.out.println("3. CISCO : ");
                           break;
                   case 3: System.out.println("4. HP : ");
                           break;
                   case 4: System.out.println("5. Xiaomi : ");
                           break;
               }

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
               
               System.out.println("     "+(k+1)+". Applicant "+(companyShortList[i][k]+1));}
               System.out.println("\n");
           }
           System.out.println("......................................");

           System.out.println("Final Assignment : \n");

           HashSet <Integer>hs=new HashSet<Integer>();
          // int size=0;
           
              
               for(int i=0;i<5;i++)
               {  int tempSize=hs.size();
               for(int j=0;j<p;j++)
               {
                   hs.add(companyShortList[i][j]);
                   if(hs.size()>tempSize) {
                    switch(i)
                    {
                        case 0: System.out.print("1. Google : ");
                                break;
                        case 1: System.out.print("2. Microsoft : ");
                                break;
                        case 2: System.out.print("3. CISCO : ");
                                break;
                        case 3: System.out.print("4. HP : ");
                                break;
                        case 4: System.out.print("5. Xiaomi : ");
                                break;
                    }
                    System.out.println("Applicant "+(companyShortList[i][j]+1));

                     break;}
                     else if(j==p-1)
                     {
                        switch(i)
                        {
                            case 0: System.out.print("1. Google : ");
                                    break;
                            case 1: System.out.print("2. Microsoft : ");
                                    break;
                            case 2: System.out.print("3. CISCO : ");
                                    break;
                            case 3: System.out.print("4. HP : ");
                                    break;
                            case 4: System.out.print("5. Xiaomi : ");
                                    break;
                        }
                        System.out.println("No match found ");

                     }
               }
            }
            System.out.println("\n......................................");
           
         /*   for(int i=0;i<5;i++)
            {
                for(int j=0;j<n;j++)                         //debug
                System.out.print(companyShortList[i][j]+" ");
                System.out.print("\n");
     
            }*/
        
       }
         
        }



       


    
 