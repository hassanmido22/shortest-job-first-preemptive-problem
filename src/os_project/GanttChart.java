/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package os_project;

import classs.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Label;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import static os_project.CreateProces.n;

/**
 *
 * @author hassan
 */
public class GanttChart extends javax.swing.JFrame {
 
    CreateProces c = new CreateProces();
    CPU m;
    
    JLabel name1 = new JLabel("Processes");
    JLabel name2 = new JLabel("Arrival Time");
    JLabel name3 = new JLabel("Burst Time");
    JLabel name4 = new JLabel("Waiting Time");
    JLabel name5 = new JLabel("Turn-arround Time");
    
    JPanel bname1 = new JPanel();
    JPanel bname2 = new JPanel();
    JPanel bname3 = new JPanel();
    JPanel bname4 = new JPanel();
    JPanel bname5 = new JPanel();
    
    JLabel headline = new JLabel("GANTT CHART");
  
    JPanel lastpanel = new JPanel();
    JLabel lastnum = new JLabel();

    ArrayList<JLabel> index1 = new ArrayList<JLabel>();
    ArrayList<JPanel> cont1 = new ArrayList<JPanel>();
    
    ArrayList<JLabel> index2 = new ArrayList<JLabel>();
    ArrayList<JPanel> cont2 = new ArrayList<JPanel>();

    ArrayList<JLabel> index3 = new ArrayList<JLabel>();
    ArrayList<JPanel> cont3 = new ArrayList<JPanel>();

    ArrayList<JLabel> index4 = new ArrayList<JLabel>();
    ArrayList<JPanel> cont4 = new ArrayList<JPanel>();

    ArrayList<JLabel> index5 = new ArrayList<JLabel>();
    ArrayList<JPanel> cont5 = new ArrayList<JPanel>();

    
    //JPanel back2 = new JPanel();
            
    ArrayList<JLabel> name = new ArrayList<JLabel>();
    ArrayList<JPanel> process = new ArrayList<JPanel>();
    ArrayList<JLabel> gap = new ArrayList<JLabel>();
    ArrayList<JPanel> gapPanel = new ArrayList<JPanel>();
    JPanel Largepanelprocess = new JPanel();
    JPanel Largepaneltime = new JPanel();
    ArrayList<JLabel> startTime = new ArrayList<JLabel>();
    BorderLayout B = new BorderLayout();
    FlowLayout F = new FlowLayout();
    
    
   
    public GanttChart(CPU x) {
        initComponents();
         m=x;
         
         
        /*addRowsToJTable();*/
        
         /* table */
            /* start columns attributes */
        name1.setFont(new java.awt.Font("Segoe UI Semibold", 0,15));
        name2.setFont(new java.awt.Font("Segoe UI Semibold", 0,15));
        name3.setFont(new java.awt.Font("Segoe UI Semibold", 0,15));
        name4.setFont(new java.awt.Font("Segoe UI Semibold", 0,15));
        name5.setFont(new java.awt.Font("Segoe UI Semibold", 0,15));

        name1.setForeground(new java.awt.Color(204,204,204));
        name2.setForeground(new java.awt.Color(204,204,204));
        name3.setForeground(new java.awt.Color(204,204,204));
        name4.setForeground(new java.awt.Color(204,204,204));
        name5.setForeground(new java.awt.Color(204,204,204));
         
        bname1.setBackground(new java.awt.Color(133,30,62));
        bname2.setBackground(new java.awt.Color(133,30,62));
        bname3.setBackground(new java.awt.Color(133,30,62));
        bname4.setBackground(new java.awt.Color(133,30,62));
        bname5.setBackground(new java.awt.Color(133,30,62));

        bname1.setPreferredSize(new Dimension(182,35));
        bname2.setPreferredSize(new Dimension(182,35));
        bname3.setPreferredSize(new Dimension(182,35));
        bname4.setPreferredSize(new Dimension(182,35));
        bname5.setPreferredSize(new Dimension(182,35));
        
        bname1.add(name1);
        bname2.add(name2);
        bname3.add(name3);
        bname4.add(name4);
        bname5.add(name5);
        
        back.add(bname1);
        back.add(bname2);
        back.add(bname3);
        back.add(bname4);
        back.add(bname5);

        

        /* end columns attributes */
        /* start rows */
        
        m.Calculate_Process();
        m.turnaroundtime();
        m.waiting_time();
        
         for(int j = 0;j<m.Processes.size();j++)
        {  
                index1.add(new JLabel("process"+" "+String.valueOf(j)));
                index1.get(j).setFont(new java.awt.Font("Segoe UI Semibold", 0, 15)); // NOI18N
                index1.get(j).setForeground(new java.awt.Color(204, 204, 204));
                cont1.add(new JPanel());
                cont1.get(j).add(index1.get(j));
                cont1.get(j).setBackground(new java.awt.Color(22,46,79));
                cont1.get(j).setPreferredSize(new Dimension(182,35));
                
                index2.add(new JLabel(String.valueOf(CreateProces.n.arrivalJtext.get(j).getText())));
                index2.get(j).setFont(new java.awt.Font("Segoe UI Semibold", 0, 15)); // NOI18N
                index2.get(j).setForeground(new java.awt.Color(204, 204, 204));
                cont2.add(new JPanel());
                cont2.get(j).add(index2.get(j));
                cont2.get(j).setBackground(new java.awt.Color(22,46,79));
                cont2.get(j).setPreferredSize(new Dimension(182,35));

                index3.add(new JLabel(String.valueOf(CreateProces.n.burstJtext.get(j).getText())));
                index3.get(j).setFont(new java.awt.Font("Segoe UI Semibold", 0, 15)); // NOI18N
                index3.get(j).setForeground(new java.awt.Color(204, 204, 204));
                cont3.add(new JPanel());
                cont3.get(j).add(index3.get(j));
                cont3.get(j).setBackground(new java.awt.Color(22,46,79));
                cont3.get(j).setPreferredSize(new Dimension(182,35));

                index4.add(new JLabel(String.valueOf(m.Processes.get(j).Waiting_Time)));
                index4.get(j).setFont(new java.awt.Font("Segoe UI Semibold", 0, 15)); // NOI18N
                index4.get(j).setForeground(new java.awt.Color(204, 204, 204));
                cont4.add(new JPanel());
                cont4.get(j).add(index4.get(j));
                cont4.get(j).setBackground(new java.awt.Color(22,46,79));
                cont4.get(j).setPreferredSize(new Dimension(182,35));

                index5.add(new JLabel(String.valueOf(m.Processes.get(j).Turn_Time)));
                index5.get(j).setFont(new java.awt.Font("Segoe UI Semibold", 0, 15)); // NOI18N
                index5.get(j).setForeground(new java.awt.Color(204, 204, 204));
                cont5.add(new JPanel());
                cont5.get(j).add(index5.get(j));
                cont5.get(j).setBackground(new java.awt.Color(22,46,79));
                cont5.get(j).setPreferredSize(new Dimension(182,35));

                back.add(cont1.get(j));
                back.add(cont2.get(j));
                back.add(cont3.get(j));
                back.add(cont4.get(j));
                back.add(cont5.get(j));
                
        }
   
        int height = m.Processes.size()*50+60;
        back.setMinimumSize(new Dimension(950, height));
        back.setBackground(new java.awt.Color(193,208,229));
        back.setLayout(new FlowLayout(FlowLayout.CENTER));
        

        
        /* end rows */
       

        /* end */
        
        /* gantt chart */   
        
        headline.setForeground(new java.awt.Color(22,46,79));
        headline.setFont(new java.awt.Font("Segoe UI Semibold", 0, 25));
        head.setLayout(new FlowLayout(FlowLayout.CENTER));
        head.add(headline);
 
        
        
        ArrayList<Integer> width=new ArrayList<Integer>();
        int total=m.Arr_calculate();
        int curr=m.Arrival_time_short();
        for(int i=0;i<total;i++){
            for(int z=0;z<m.Processes.size();z++){
                int count=0;
                if(m.Processes.get(z).Start_time.size()!=0){
                if(m.Processes.get(z).Start_time.get(count)==curr){
                    width.add((m.Processes.get(z).End_time.get(count)-m.Processes.get(z).Start_time.get(count)));
                    curr=m.Processes.get(z).End_time.get(count);
                    name.add(new JLabel("p"+String.valueOf(z+1)));
                    name.get(i).setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
                    name.get(i).setForeground(new java.awt.Color(204, 204, 204));
                    process.add(new JPanel());
                    process.get(i).add(name.get(i));
                    process.get(i).setBackground(new java.awt.Color(133,30,62));
                    process.get(i).setPreferredSize(new Dimension(width.get(i)*30,40));
                    process.get(i).setBorder(BorderFactory.createLineBorder(Color.black));
                    ganttchart.add(process.get(i));
                    //back2.add(process.get(i));
                    
                    /* time */
                    startTime.add(new JLabel(String.valueOf(m.Processes.get(z).Start_time.get(count))));
                    startTime.get(count).setPreferredSize(new Dimension(width.get(i)*30,20));
                    numbers.add(startTime.get(count));
                    startTime.remove(count);
                    /* end */
                    
                    m.Processes.get(z).Start_time.remove(count);
                    m.Processes.get(z).End_time.remove(count);
                    
                    
                    break;
                }
                }
                if(m.IDL.size()!=0){
                if(m.IDL.get(count)==curr){
                    width.add((m.IDL.get(count+1)-m.IDL.get(count)));
                    name.add(new JLabel("gap"));
                    name.get(i).setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
                    name.get(i).setForeground(new java.awt.Color(204, 204, 204));
                    process.add(new JPanel());
                    process.get(i).add(name.get(i));
                    process.get(i).setBackground(Color.BLACK);
                    process.get(i).setPreferredSize(new Dimension(width.get(i)*30,40));
                    ganttchart.add(process.get(i));
                    curr=m.IDL.get(count+1);
                    
                    startTime.add(new JLabel(String.valueOf(m.IDL.get(count))));
                    startTime.get(count).setPreferredSize(new Dimension(width.get(i)*30,20));
                    numbers.add(startTime.get(count));
                    
                    startTime.remove(count);
                    m.IDL.remove(count);
                    m.IDL.remove(count);
                    break;
                }
                }
             
            }
            }
       
        //Largepanelprocess.setBackground(new java.awt.Color(193,208,229));
        //Largepanelprocess.setPreferredSize(new Dimension(950,50));
        //Largepaneltime.setBackground(new java.awt.Color(193,208,229));
        //Largepaneltime.setPreferredSize(new Dimension(950,10));
        
        //Largepanelprocess.setBorder(new EmptyBorder(height+90, 0, 0, 0));
        //Largepaneltime.setBorder(new EmptyBorder(height+100, 0, 0, 0));
        
        //
        //
        ganttchart.setLayout(new FlowLayout(FlowLayout.CENTER));
        //ganttchart.add(Largepanelprocess);
        
        numbers.setLayout(new FlowLayout(FlowLayout.CENTER));
        //numbers.add(Largepaneltime);
        //back2.add(Largepanelprocess);
        //back2.add(Largepaneltime);
       
        //back2.setBackground(new java.awt.Color(193,208,229));
        //back2.setSize(950,600);
        //back2.setLayout(new FlowLayout(FlowLayout.CENTER));

        /*start waiting and turn around avegage */
        
        waitAVG.setText(String.valueOf(m.waitAverage()));
        turnAVG.setText(String.valueOf(m.turnAverage()));
                
        /*end waiting and turn around avegage */
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        scroll = new javax.swing.JPanel();
        back = new javax.swing.JPanel();
        head = new javax.swing.JPanel();
        ganttchart = new javax.swing.JPanel();
        numbers = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        waitAVG = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        turnAVG = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(193, 208, 229));

        scroll.setBackground(new java.awt.Color(193, 208, 229));

        back.setPreferredSize(new java.awt.Dimension(948, 263));

        head.setBackground(new java.awt.Color(193, 208, 229));

        ganttchart.setBackground(new java.awt.Color(193, 208, 229));

        numbers.setBackground(new java.awt.Color(193, 208, 229));

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(22, 46, 79)));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI Semibold", 0, 20)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(22, 46, 79));
        jLabel1.setText("Waiting time Average");

        waitAVG.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        waitAVG.setForeground(new java.awt.Color(133, 30, 62));
        waitAVG.setText("jLabel4");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(waitAVG, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(260, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(57, 57, 57)
                .addComponent(waitAVG)
                .addContainerGap(87, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(22, 46, 79)));

        jLabel2.setFont(new java.awt.Font("Segoe UI Semibold", 0, 20)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(22, 46, 79));
        jLabel2.setText("Turn Around Average");

        turnAVG.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        turnAVG.setForeground(new java.awt.Color(133, 30, 62));
        turnAVG.setText("jLabel3");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(turnAVG, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addContainerGap(242, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(57, 57, 57)
                .addComponent(turnAVG)
                .addContainerGap(87, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout scrollLayout = new javax.swing.GroupLayout(scroll);
        scroll.setLayout(scrollLayout);
        scrollLayout.setHorizontalGroup(
            scrollLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, scrollLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(scrollLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(back, javax.swing.GroupLayout.DEFAULT_SIZE, 954, Short.MAX_VALUE)
                    .addGroup(scrollLayout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(head, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ganttchart, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(numbers, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        scrollLayout.setVerticalGroup(
            scrollLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(scrollLayout.createSequentialGroup()
                .addComponent(back, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(head, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(ganttchart, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(numbers, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53)
                .addGroup(scrollLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(58, 58, 58))
        );

        jScrollPane1.setViewportView(scroll);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 983, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 607, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
/*
    public void addRowsToJTable()
    {
        m.Calculate_Process();
        m.turnaroundtime();
        m.waiting_time();
        DefaultTableModel model =  (DefaultTableModel) results.getModel();
        model.setRowCount(0);
        Object rowdata[]= new Object[5];
        
         for(int i = 0;i<m.Processes.size();i++)
        {   
            rowdata[0]="process"+" "+i;
            rowdata[1]=CreateProces.n.arrivalJtext.get(i).getText();
            rowdata[2]=CreateProces.n.burstJtext.get(i).getText();
            rowdata[3]=m.Processes.get(i).Waiting_Time;
            rowdata[4]=m.Processes.get(i).Turn_Time;
            
            model.addRow(rowdata);
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GanttChart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GanttChart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GanttChart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GanttChart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel back;
    private javax.swing.JPanel ganttchart;
    private javax.swing.JPanel head;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel numbers;
    private javax.swing.JPanel scroll;
    private javax.swing.JLabel turnAVG;
    private javax.swing.JLabel waitAVG;
    // End of variables declaration//GEN-END:variables
}
