/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fitness.tracker.pages;

import fitness.tracker.pages.EditDetails;
import static fitness.tracker.pages.EditDetails.user;
import fitness.tracker.pages.EnterData;
import static fitness.tracker.pages.EnterData.user;
import fitness.tracker.pages.TrackData;
import fitness.tracker.pages.Login;
import fitness.tracker.util.Track;
import fitness.tracker.util.User;
import java.awt.Font;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.util.Pair;
import javax.swing.GroupLayout.Group;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 *
 * @author student
 */
public class TrackData extends javax.swing.JFrame {

    /**
     * Creates new form TrackData
     */
    static User user;

    private static Scene createSceneCalCons() {
        HBox root = new HBox();
        Scene scene = new Scene(root, 500, 300);
        
        CategoryAxis xAxis = new CategoryAxis();
        xAxis.setLabel("Date");
        
        NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("Calories Consumed");
        
        LineChart<String, Number> lineChart = new LineChart<String, Number>(xAxis, yAxis);
        lineChart.setTitle("Consumed");
        
        XYChart.Series<String, Number> data = new XYChart.Series<>();
        ResultSet rs = Track.trackCalCons(user);
        try {
            while(rs.next()){ 
                String date = rs.getString("c_date");
                int cal = rs.getInt("cals");
                data.getData().add(new XYChart.Data<String, Number>(date, cal));
            }
        } catch (SQLException ex) {
            Logger.getLogger(TrackData.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        lineChart.getData().add(data);
        root.getChildren().add(lineChart);
        
        return scene;
    }
    private static Scene createSceneCalBurnt() {
        HBox root = new HBox();
        Scene scene = new Scene(root, 500, 300);
        
        CategoryAxis xAxis = new CategoryAxis();
        xAxis.setLabel("Date");
        
        NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("Calories Burnt");
        
        LineChart<String, Number> lineChart = new LineChart<String, Number>(xAxis, yAxis);
        lineChart.setTitle("Burnt");
        
        XYChart.Series<String, Number> data = new XYChart.Series<>();
        ResultSet rs = Track.trackCalBurnt(user);
        try {
            while(rs.next()){ 
                String date = rs.getString("c_date");
                int cal = rs.getInt("cals");
                data.getData().add(new XYChart.Data<String, Number>(date, cal));
            }
        } catch (SQLException ex) {
            Logger.getLogger(TrackData.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        lineChart.getData().add(data);
        root.getChildren().add(lineChart);
        
        return scene;
    }
    private static Scene createSceneCalBal() {
        HBox root = new HBox();
        Scene scene = new Scene(root, 500, 300);
        
        CategoryAxis xAxis = new CategoryAxis();
        xAxis.setLabel("Date");
        
        NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("Net Calories");
        
        LineChart<String, Number> lineChart = new LineChart<String, Number>(xAxis, yAxis);
        lineChart.setTitle("Net");
        
        XYChart.Series<String, Number> data = new XYChart.Series<>();
        ResultSet rs = Track.trackCalNet(user);
        try {
            while(rs.next()){ 
                String date = rs.getString("c_date");
                int cal = rs.getInt("cals");
                data.getData().add(new XYChart.Data<String, Number>(date, cal));
            }
        } catch (SQLException ex) {
            Logger.getLogger(TrackData.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        lineChart.getData().add(data);
        root.getChildren().add(lineChart);
        
        return scene;
    }
    private static Scene createSceneBMI() {
        HBox root = new HBox();
        Scene scene = new Scene(root, 500, 300);
        
        CategoryAxis xAxis = new CategoryAxis();
        xAxis.setLabel("Date");
        
        NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("BMI");
        
        LineChart<String, Number> lineChart = new LineChart<String, Number>(xAxis, yAxis);
        lineChart.setTitle("BMI");
        
        XYChart.Series<String, Number> data = new XYChart.Series<>();
        ResultSet rs = Track.trackBMI(user);
        ArrayList<Pair> b = new ArrayList<Pair>();
        try {
            while(rs.next()){ 
                String date = rs.getString("date");
                float w = rs.getFloat("weight");
                float h = rs.getFloat("height");
                float bmi = (float) (w*10000/(Math.pow(h, 2)));
                b.add(new Pair(date, bmi));
            }
        } catch (SQLException ex) {
            Logger.getLogger(TrackData.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        for(int i = b.size()-1; i>=0; i--){
            Pair point = b.get(i);
            data.getData().add(new XYChart.Data<String, Number>
                (point.getKey().toString(), Float.parseFloat(point.getValue().toString())));
        }
        lineChart.getData().add(data);
        root.getChildren().add(lineChart);
        
        return scene;
    }
    public TrackData(User user) {
        this.user=user;
        Init();
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                initAndShowGUI();
            }
        });
    }

    JLabel lTest;
    
    private void initAndShowGUI() {
        Platform.setImplicitExit(false);
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                initFXCalCons(jPanel1);
                initFXCalBurnt(jPanel3);
                initFXCalBal(jPanel4);
                initFXBMI(jPanel5);
            }
       });
    }
    
    private static void initFXCalCons(JFXPanel fxPanel) {
        // This method is invoked on the JavaFX thread
        Scene scene = createSceneCalCons();
        fxPanel.setScene(scene);
    }
    
    private static void initFXCalBurnt(JFXPanel fxPanel) {
        // This method is invoked on the JavaFX thread
        Scene scene = createSceneCalBurnt();
        fxPanel.setScene(scene);
    }
    
    private static void initFXCalBal(JFXPanel fxPanel) {
        // This method is invoked on the JavaFX thread
        Scene scene = createSceneCalBal();
        fxPanel.setScene(scene);
    }
    
    private static void initFXBMI(JFXPanel fxPanel) {
        // This method is invoked on the JavaFX thread
        Scene scene = createSceneBMI();
        fxPanel.setScene(scene);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpNav = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lName = new javax.swing.JLabel();
        bLogout = new javax.swing.JButton();
        bEnter = new javax.swing.JButton();
        bTrack = new javax.swing.JButton();
        bEdit = new javax.swing.JButton();
        lBmi = new javax.swing.JLabel();
        lUname = new javax.swing.JLabel();
        lWeight = new javax.swing.JLabel();
        lHeight = new javax.swing.JLabel();
        jpInfo = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jpNav.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel1.setText("Hi");

        lName.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lName.setText("User");

        bLogout.setText("Logout");
        bLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bLogoutActionPerformed(evt);
            }
        });

        bEnter.setText("Enter Data");
        bEnter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bEnterActionPerformed(evt);
            }
        });

        bTrack.setText("Track Data");
        bTrack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bTrackActionPerformed(evt);
            }
        });

        bEdit.setText("Edit Profile");
        bEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bEditActionPerformed(evt);
            }
        });

        lBmi.setText("BMI:");

        lUname.setText("Username:");

        lWeight.setText("Weight:");

        lHeight.setText("Height:");

        javax.swing.GroupLayout jpNavLayout = new javax.swing.GroupLayout(jpNav);
        jpNav.setLayout(jpNavLayout);
        jpNavLayout.setHorizontalGroup(
            jpNavLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpNavLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpNavLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bLogout, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bEnter, javax.swing.GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)
                    .addComponent(bTrack, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bEdit, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jpNavLayout.createSequentialGroup()
                        .addGroup(jpNavLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(lName)
                            .addComponent(lBmi)
                            .addComponent(lUname)
                            .addComponent(lWeight)
                            .addComponent(lHeight))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jpNavLayout.setVerticalGroup(
            jpNavLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpNavLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lUname)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lBmi)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lWeight)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lHeight)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bEdit)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bTrack)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bEnter)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bLogout)
                .addContainerGap())
        );

        jpInfo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jpInfoLayout = new javax.swing.GroupLayout(jpInfo);
        jpInfo.setLayout(jpInfoLayout);
        jpInfoLayout.setHorizontalGroup(
            jpInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1027, Short.MAX_VALUE)
        );
        jpInfoLayout.setVerticalGroup(
            jpInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 569, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jpNav, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jpInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpNav, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jpInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bEnterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bEnterActionPerformed
        // TODO add your handling code here:
        new EnterData(user).show();
        dispose();
    }//GEN-LAST:event_bEnterActionPerformed

    private void bEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bEditActionPerformed
        // TODO add your handling code here:
        new EditDetails(user).show();
        dispose();
    }//GEN-LAST:event_bEditActionPerformed

    private void bLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bLogoutActionPerformed
        // TODO add your handling code here:
        new Login().show();
        dispose();
    }//GEN-LAST:event_bLogoutActionPerformed

    private void bTrackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bTrackActionPerformed
        // TODO add your handling code here:
        new TrackData(user).show();
        dispose();
    }//GEN-LAST:event_bTrackActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http:    //download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TrackData.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TrackData.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TrackData.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TrackData.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TrackData(user).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bEdit;
    private javax.swing.JButton bEnter;
    private javax.swing.JButton bLogout;
    private javax.swing.JButton bTrack;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jpInfo;
    private javax.swing.JPanel jpNav;
    private javax.swing.JLabel lBmi;
    private javax.swing.JLabel lHeight;
    private javax.swing.JLabel lName;
    private javax.swing.JLabel lUname;
    private javax.swing.JLabel lWeight;
    // End of variables declaration//GEN-END:variables

    //Custom Panels
    private JFXPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private JFXPanel jPanel3;
    private JFXPanel jPanel4;
    private JFXPanel jPanel5;
    
    private void Init() {
        initComponents();
        initCustomComponents();
        float bmi;
        bmi = (float) (Double.parseDouble(user.weight)*10000/(Math.pow(Double.parseDouble(user.height), 2)));
        lBmi.setText("BMI: "+String.format("%.1f", bmi));
        lName.setText(user.name);
        lUname.setText("Username: "+user.uname);
        lHeight.setText("Height: "+user.height);
        lWeight.setText("Weight: "+user.weight);
    }

    private void initCustomComponents() {
        jPanel1 = new JFXPanel();
        jPanel3 = new JFXPanel();
        jPanel4 = new JFXPanel();
        jPanel5 = new JFXPanel();
        
        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 241, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 242, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 169, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        
        javax.swing.GroupLayout jpInfoLayout = new javax.swing.GroupLayout(jpInfo);
        jpInfo.setLayout(jpInfoLayout);
        jpInfoLayout.setHorizontalGroup(
            jpInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//            .addGap(0, 702, Short.MAX_VALUE)
            .addGroup(jpInfoLayout.createSequentialGroup()
            .addContainerGap()
            .addGroup(jpInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addGroup(jpInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addContainerGap())
        );
        jpInfoLayout.setVerticalGroup(
            jpInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//            .addGap(0, 368, Short.MAX_VALUE)
            .addGroup(jpInfoLayout.createSequentialGroup()
            .addContainerGap()
            .addGroup(jpInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addGroup(jpInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jpNav, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jpInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpNav, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jpInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        
    }
}
