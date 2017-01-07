/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * FormICAI.java
 *
 * Created on Dec 14, 2011, 4:23:03 PM
 */
package icai;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;

import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.ListIterator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

/**
 *
 * @author admin
 */
public class PaperManager extends javax.swing.JFrame {

    String fileName = "Paper.txt";

    /** Creates new form FormICAI */
    public PaperManager() {

        initComponents();
        this.loadData();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLayeredPane1 = new javax.swing.JLayeredPane();
        panelTop = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        textSearchParameter = new javax.swing.JTextField();
        buttonGo = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        textResult = new javax.swing.JTextArea();
        jPanel1 = new javax.swing.JPanel();
        buttonShowAllPapers = new javax.swing.JButton();
        buttonAddPapers = new javax.swing.JButton();
        buttonDeletePaper = new javax.swing.JButton();
        buttonSaveFile = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBounds(new java.awt.Rectangle(100, 100, 700, 500));
        setMinimumSize(new java.awt.Dimension(700, 500));

        jLayeredPane1.setBorder(javax.swing.BorderFactory.createTitledBorder("ICAI Paper Manager"));
        jLayeredPane1.setPreferredSize(new java.awt.Dimension(680, 480));

        panelTop.setForeground(new java.awt.Color(255, 255, 255));

        jLabel1.setText("Search Paper ");
        panelTop.add(jLabel1);

        textSearchParameter.setMinimumSize(new java.awt.Dimension(6, 120));
        textSearchParameter.setPreferredSize(new java.awt.Dimension(80, 20));
        panelTop.add(textSearchParameter);

        buttonGo.setLabel("Go");
        buttonGo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonGoActionPerformed(evt);
            }
        });
        panelTop.add(buttonGo);

        panelTop.setBounds(380, 20, 270, 40);
        jLayeredPane1.add(panelTop, javax.swing.JLayeredPane.DEFAULT_LAYER);

        textResult.setColumns(20);
        textResult.setEditable(false);
        textResult.setRows(5);
        jScrollPane1.setViewportView(textResult);

        jScrollPane1.setBounds(10, 70, 640, 300);
        jLayeredPane1.add(jScrollPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jPanel1.setLayout(new java.awt.GridLayout(1, 4));

        buttonShowAllPapers.setText("Show All Papers");
        buttonShowAllPapers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonShowAllPapersActionPerformed(evt);
            }
        });
        jPanel1.add(buttonShowAllPapers);

        buttonAddPapers.setText("Add Paper");
        buttonAddPapers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAddPapersActionPerformed(evt);
            }
        });
        jPanel1.add(buttonAddPapers);

        buttonDeletePaper.setText("Delete Paper");
        buttonDeletePaper.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDeletePaperActionPerformed(evt);
            }
        });
        jPanel1.add(buttonDeletePaper);

        buttonSaveFile.setText("Save File");
        buttonSaveFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSaveFileActionPerformed(evt);
            }
        });
        jPanel1.add(buttonSaveFile);

        jPanel1.setBounds(10, 380, 640, 40);
        jLayeredPane1.add(jPanel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLayeredPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 661, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLayeredPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 429, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonShowAllPapersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonShowAllPapersActionPerformed
        loadTextArea("", "Total of " + String.valueOf(this.getCurrentSize()) + " entries");
    }//GEN-LAST:event_buttonShowAllPapersActionPerformed
    private void loadTextArea(String textOnTop, String textOnBottom) {
        LinkedList<Paper> list = this.getCurrentList();
        /*setting header information*/
        String header = "Paper Id\tPaper Topic\t\tCorresponding Author\tDate\tRank\n\n";
        String str = "";
        ListIterator<Paper> iterator = list.listIterator();
        while (iterator.hasNext()) {
            Paper p = iterator.next();
            str += String.valueOf(p.getPaperId()).toString() + "\t" + p.getPaperTopic() + "\t" + p.getAuthor() + "\t\t" + p.getDate() + "\t" + p.getRank() + "\n\n";
        }
        /* bind  list of papers to the text area*/
        this.textResult.setText(textOnTop + "\n" + header + str + "\n" + textOnBottom);
    }

    private void buttonAddPapersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAddPapersActionPerformed
        String strPaperId = "";
        String strPaperTopic = "";
        String strAuthor = "";
        String strDate = "";
        String strRank = "";

        strPaperId = JOptionPane.showInputDialog(null, "Please input paper ID(an integer between 0 to 300) : ",
                "Input", 2);

         if (!((Integer.parseInt(strPaperId) > 0) && (Integer.parseInt(strPaperId) < 300))) {
                strPaperId = JOptionPane.showInputDialog(null, "Please input paper ID(an integer between 0 to 300) : ",
                        "Input", 2);
        }
        while (!(this.isValidNumeric(strPaperId))) {
           
           
                JOptionPane.showMessageDialog(this, "You must enter an integer!");
                strPaperId = JOptionPane.showInputDialog(null, "Please input paper ID(an integer between 0 to 300) : ",
                      "Input", 2);
           
        }
        strPaperTopic = JOptionPane.showInputDialog(null, "Please input paper topic : ",
                "Input", 2);
        strAuthor = JOptionPane.showInputDialog(null, "Please input author name : ",
                "Input", 2);
        strDate = JOptionPane.showInputDialog(null, "Please input date(xx/xx/xx) : ",
                "Input", 2);
        strRank = JOptionPane.showInputDialog(null, "Please paper rank(an integer between 0 to 5):",
                "Input", 2);

        while (!(this.isValidNumeric(strRank))) {
            JOptionPane.showMessageDialog(this, "You must enter an integer!");
            strRank = JOptionPane.showInputDialog(null, "Please input paper ID(an integer between 0 to 300) : ",
                    "Input", 2);
        }
        //}


        /*addin new object to list after check for existance*/
        if (this.isExist(Integer.parseInt(strPaperId))) {
            JOptionPane.showMessageDialog(this, "record Exist!");
        } else {

            Paper p = new Paper(Integer.parseInt(strPaperId), strPaperTopic, strAuthor, strDate, strRank);
            this.addNewPaper(p);
            loadTextArea("", "");
        }


    }//GEN-LAST:event_buttonAddPapersActionPerformed

    private void buttonDeletePaperActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDeletePaperActionPerformed
        String strPaperId = "";
        strPaperId = JOptionPane.showInputDialog(null, "Please input paper ID(an integer between 0 to 300) : ",
                "Input", JOptionPane.INFORMATION_MESSAGE);
        while (!(this.isValidNumeric(strPaperId))) {

            JOptionPane.showMessageDialog(this, "You must enter an integer!");
            strPaperId = JOptionPane.showInputDialog(null, "Please input paper ID(an integer between 0 to 300) : ",
                    "Input", 2);
        }        // TODO add your handling code here:
        if (this.isValidNumeric(strPaperId)) {


            if (this.isExist(Integer.parseInt(strPaperId))) {
                JOptionPane.showMessageDialog(this, "Paper Id " + strPaperId + " has been detected");
                LinkedList<Paper> list = this.deletePaper(Integer.parseInt(strPaperId));
                loadTextArea("", "");
            } else {
                //     JOptionPane.showMessageDialog(this, " Paper ID does not exist. No record is deleted");
                // }
            }


    }//GEN-LAST:event_buttonDeletePaperActionPerformed
    }
    private void buttonSaveFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSaveFileActionPerformed
        /*write data to the file Paper.txt*/

        this.saveToFile();

    }//GEN-LAST:event_buttonSaveFileActionPerformed

    private void buttonGoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonGoActionPerformed
        String input = textSearchParameter.getText();


        LinkedList<Paper> foundList = this.search(input);
        if (foundList.size() == 0) {
            textResult.setText("No results found");
        } else {
            this.loadTextArea(foundList.size() + "results found for " + input, "");

        }



        // TODO add your handling code here:
}//GEN-LAST:event_buttonGoActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        PaperManager f = new PaperManager();
        f.setVisible(true);

    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonAddPapers;
    private javax.swing.JButton buttonDeletePaper;
    private javax.swing.JButton buttonGo;
    private javax.swing.JButton buttonSaveFile;
    private javax.swing.JButton buttonShowAllPapers;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panelTop;
    private javax.swing.JTextArea textResult;
    private javax.swing.JTextField textSearchParameter;
    // End of variables declaration//GEN-END:variables

    /* the following methos validates the string value for an integer */
    public boolean isValidNumeric(String value) {
        try {
            Integer.parseInt(value);
            return true;
        } catch (Exception e) {
            return false;
        }

    }
    public static LinkedList<Paper> currentList;

    public LinkedList<Paper> getCurrentList() {
        return currentList;
    }

    public boolean isExist(int paperId) {
        /*traverse the current list and checked wheather for existance of paper object*/
        boolean result = false;
        for (Paper p : currentList) {
            if (p.getPaperId() == paperId) {
                result = true;
            }

        }
        return result;
    }

    public LinkedList<Paper> search(String searchText) {
        LinkedList<Paper> listFound = new LinkedList<Paper>();
        searchText = searchText.trim();/*removeing leading and triiling white spaces*/
        for (Paper p : currentList) {         /*using regex tofind the matched strings */
            Pattern pattern = Pattern.compile(searchText);
            Matcher matcher = pattern.matcher(String.valueOf(p.getPaperId()) + p.getPaperTopic() + p.getRank() + p.getAuthor());
            if (matcher.find()) {
                listFound.add(p);
            }

        }
        currentList = listFound;
        return listFound;
    }
    /* save data to the file using burffered reader*/

    public boolean saveToFile() {
        boolean result = false;
        /*wriring list to the file*/
        FileWriter fstream;
        String str = "";
        try {
            fstream = new FileWriter(fileName);
            BufferedWriter out = new BufferedWriter(fstream);
            // out.writeLin("Hello Java");
            for (Paper p : currentList) {
                str = str + String.valueOf(p.getPaperId()).toString() + "," + p.getPaperTopic() + "," + p.getAuthor() + "," + p.getDate() + "," + p.getRank() + "\n";


            }
            out.write(str);
            result = true;
            out.close();
        } catch (IOException ex) {
            System.out.print(ex.getMessage());
        }
        return result;
    }

    public LinkedList<Paper> deletePaper(int paperId) {
        /*delete selected item and return the modified list*/
        boolean isDeleted = false;
        LinkedList<Paper> list = currentList;
        Paper selectedPaper = null;
        /*select papaer object if available for deletion*/
        for (Paper p : list) {
            if (p.getPaperId() == paperId) {
                selectedPaper = p;
            }
        }
        list.remove(selectedPaper);
        /*assign the modified list to current list*/
        currentList = list;
        return currentList;
    }

    public LinkedList<Paper> loadData() {
        LinkedList<Paper> list = new LinkedList<Paper>();
        /* reading text file and load data to the linkedlist bufferdreader used for efficiency */
        try {

            FileInputStream fis = new FileInputStream(fileName);
            DataInputStream dis = new DataInputStream(fis);
            BufferedReader reader = new BufferedReader(new InputStreamReader(dis));
            String strLine;
            Paper p;
            while ((strLine = reader.readLine()) != null) {
                String[] strArray = strLine.split(",");/*split string by comma*/
                p = new Paper(Integer.parseInt(strArray[0]), strArray[1], strArray[2], strArray[3], strArray[4]);
                list.add(p);
            }
            dis.close();/*leleasing IO resources*/
        } catch (Exception ex) {
            System.out.println("" + ex.getMessage());
        }
        currentList = list;
        return list;
    }

    /*add new object tothe current list*/
    public void addNewPaper(Paper p) {
        if (p != null) {
            currentList.add(p);
        }


    }
    /*take current length of the linked list*/

    public int getCurrentSize() {
        return currentList.size();
    }
}