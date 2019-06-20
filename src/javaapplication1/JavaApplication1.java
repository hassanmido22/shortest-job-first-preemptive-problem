/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;
import classs.*;
import java.util.*;
import java.io.*;

/**
 *
 * @author omarrasmy
 */
public class JavaApplication1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic 
       /* CPU x = new CPU();
        Scanner scan = new Scanner(System.in);
        int arrivaltime , bursttime ,n ;
        
        n = scan.nextInt();
        for(int i =0;i<n ; i++)
        {
            arrivaltime = scan.nextInt();
            bursttime = scan.nextInt();
            x.Create_Process(arrivaltime, bursttime);
        }
        
        x.Calculate_Process();
        
        
        x.waiting_time();
        x.Average();
        x.turnaroundtime();
        
        for(int i=0;i<x.Processes.size();i++){
            for(int l=0;l<x.Processes.get(i).Start_time.size();l++){
                System.out.println("the start time is of P"+i+":" + x.Processes.get(i).Start_time.get(l)+"end time is : "+ x.Processes.get(i).End_time.get(l));
            }
        }
         for(int i=0;i<x.IDL.size();i++){
         System.out.println("the IDL Starttime is  : "+x.IDL.get(i));
         i++;
         System.out.println("the IDL Endtime is  : "+x.IDL.get(i));
         
         }
        */
              CPU m = new CPU();
        Scanner scan = new Scanner(System.in);
        int arrivaltime , bursttime ,n ;
        
        n = scan.nextInt();
        for(int i =0;i<n ; i++)
        {
            arrivaltime = scan.nextInt();
            bursttime = scan.nextInt();
            m.Create_Process(arrivaltime, bursttime);
        }
        
        m.Calculate_Process();  
        m.waiting_time();
//        m.Average();
        m.turnaroundtime();
        
       
        ArrayList<Integer> width=new ArrayList<Integer>();
        int total=m.Arr_calculate();
        int curr=m.Arrival_time_short();
        for(int i=0;i<total;i++){
            for(int z=0;z<m.Processes.size();z++){
                int count=0;
                if(m.Processes.get(z).Start_time.size()!=0 ){
                if(m.Processes.get(z).Start_time.get(count)==curr){
                    width.add((m.Processes.get(z).End_time.get(count)-m.Processes.get(z).Start_time.get(count)));
                    curr=m.Processes.get(z).End_time.get(count);
                    m.Processes.get(z).Start_time.remove(count);
                    m.Processes.get(z).End_time.remove(count);
                    System.out.println("curr is : "+curr);
                    break;
                }
                }
             for(int h=0 ;h< m.IDL.size();h++){
               if(m.IDL.get(h)==curr){
                    width.add((m.IDL.get(count+1)-m.IDL.get(count)));
                    curr=m.IDL.get(count+1);
                    System.out.println("curr is : "+curr);
                    m.IDL.remove(count);
                    m.IDL.remove(count);
                    break;
                }
                }
            }
            }
        for(int i=0;i<width.size();i++){
        System.out.println("the widht is : "+width.get(i));
        }
        }
    }
    

