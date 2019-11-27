import java.util.*;
import java.lang.*;
import java.io.*;

public class realExample
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
	public static void main (String[] args) throws Exception
	 {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the number of companies : ");
        int m=sc.nextInt();
        System.out.println("\nFor each company , input the skills requirement by entering the number corresponding to the skill list :  \n1.Programming \n2.Web Development \n3.Machine Learning  \n4.Software Development \n5.Artificial Intelligence  \n6.Networking \n7.Database Management \n8.Android development \n0.Done\n");
        
        System.out.println("\nInput Companies requirement data base file name : \n");  
        String fl=sc.next();
                File f1=new File(fl);
                Scanner s1=new Scanner(f1);
        
                int skills[][]=new int[m][8];
        
               while(s1.hasNextLine()) {
                    for (int i=0; i<m; i++) {
                        String sx=s1.nextLine();
                       String[] line = sx.split(" ");
                       for (int j=0; j<8; j++) {
                          skills[i][j] = Integer.parseInt(line[j]);
                       }
                    }
                 }

        System.out.print("Enter the number of job applicants : ");
        int n=sc.nextInt();
        System.out.println("\n...................");
    
        System.out.println("\n...................");

        System.out.println("\nOn a scale of 1-10 rate your skills : \n(Give a series of integer 1-10 separated by a single space denoting the strength in the fields: Programming, Web Development, Machine Learning , Software Development, Artificial Intelligence , Networking, Database Management, Android development) \n");

        System.out.println("Input Applicants skills database file name : ");
        int a[][]=new int[n][8];                                //applicant-experiance matrix
      
        fl=sc.next();
        File f2=new File(fl);
        Scanner s2=new Scanner(f2);
 
 
        while(s2.hasNextLine()) {
            for (int i=0; i<n; i++) {
                String sx=s2.nextLine();
               String[] line = sx.split(" ");
               for (int j=0;j<8; j++) {
                  a[i][j] = Integer.parseInt(line[j]);         //appliccant data entry
               }
            }
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
                if(count!=0) c[i][j]=c[i][j]*8/count;
                else c[i][j]=0;
           }
       }

       int p=n;                        //% candidates are shortlisted
       int companyShortList[][]=new int[m][p];
       int index[]=new int[n];
       int temp[]=new int[n];

    for(int i=0;i<m;i++)                              //Company shortlisting candidates
       {
           for(int j=0;j<n;j++)
           {
               index[j]=j;
               temp[j]=c[i][j];
           }
           
           sort(temp,index,p);
         for(int k=0;k<n;k++)
           {  
                companyShortList[i][k]=index[k];
              
               }
              // System.out.println("\n");
           }
          System.out.println("......................................");


          File ff=new File("Match.txt");
          FileWriter fstream = new FileWriter (ff,true);
               PrintWriter info = new PrintWriter(fstream);


           System.out.println("Final Assignment : Check file Match.txt\n");

           HashSet <Integer>hs=new HashSet<Integer>();
        
               for(int i=0;i<m;i++)
               {  int tempSize=hs.size();
               for(int j=0;j<p;j++)
               {
                   String ftemp;
                   hs.add(companyShortList[i][j]);
                   if(hs.size()>tempSize) 
                   {
                         ftemp="Company "+Integer.toString(i+1)+" : Applicant "+Integer.toString(companyShortList[i][j]+1);
                         info.println(ftemp);
                       //  info.newLine();
                       //System.out.print("Company "+(i+1)+" : ");
                      // System.out.println("Applicant "+(companyShortList[i][j]+1));

                        break;
                    }
                     else if(j==p-1)
                     {
                        //System.out.print("Company "+(i+1)+" : ");
                       // System.out.println("No match found ");
                       ftemp="Company "+Integer.toString(i+1)+" : No match Found";
                       info.println(ftemp);
                        // info.newLine();

                     }
               }
              
            }
            info.close();
            System.out.println("\n......................................");
        
       }
    }



       


    
 