/*
 * This class includes all MainWindow components, and is launched by Login
 * Holds global variables for user identification, permissions
 */
package dndpt;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;

/**
 *
 * @author Justin Jones
 */
public class MainWindow extends javax.swing.JFrame {
    //global user identifier fields
    String uname;
    boolean isAdmin = false;
    int pid;
    
    //for convenience
    public static Connection conn;
    ResultSet rs = null;
    PreparedStatement pst = null;
    
    /**
     * Initializes the MainWindow and sets global variables
     */
    public MainWindow(String uname, int pid, boolean isAdmin, Connection conn) {
        initComponents();
        this.uname = uname;
        this.isAdmin = isAdmin;
        this.pid = pid;
        currentPlayerLabel.setText(String.valueOf("Logged in as: " + uname));
        this.setVisible(true);
        //disable admin pane if not admin
        //test to add entries to JTable:
        if (!this.isAdmin)
            this.tabbedPane.setEnabledAt(3, false);
        MainWindow.conn = conn;
        this.getChars(pid);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tabbedPane = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        currentPlayerLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        charTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        adminPanel = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        createPlayer = new javax.swing.JButton();
        playerPane = new javax.swing.JTabbedPane();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        playerTable = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        playerNameMenu = new javax.swing.JComboBox<>();
        tableCombo = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        queryField = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        searchTable = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        logoutMenu = new javax.swing.JMenuItem();
        exitItem = new javax.swing.JMenuItem();
        editMenu = new javax.swing.JMenu();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Dungeons & Dragons Player Tracker");
        setPreferredSize(new java.awt.Dimension(685, 614));

        tabbedPane.setBackground(new java.awt.Color(255, 255, 204));
        tabbedPane.setOpaque(true);
        tabbedPane.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tabbedPaneFocusGained(evt);
            }
        });

        jPanel1.setRequestFocusEnabled(false);
        jPanel1.setLayout(null);

        jLabel3.setText("last session");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(361, 195, 55, 14);

        jLabel4.setText("random db stats (item count, player/char count, etc)");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(301, 282, 253, 14);

        currentPlayerLabel.setText("Active login:");
        jPanel1.add(currentPlayerLabel);
        currentPlayerLabel.setBounds(28, 11, 59, 14);

        charTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        charTable.setCellSelectionEnabled(true);
        charTable.setOpaque(false);
        charTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(charTable);
        charTable.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (charTable.getColumnModel().getColumnCount() > 0) {
            charTable.getColumnModel().getColumn(0).setMinWidth(22);
            charTable.getColumnModel().getColumn(0).setPreferredWidth(22);
            charTable.getColumnModel().getColumn(0).setMaxWidth(35);
            charTable.getColumnModel().getColumn(1).setResizable(false);
        }

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(28, 64, 230, 190);

        jLabel1.setText("Your characters:");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(28, 44, 80, 14);

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/winter_mountain_painting-wallpaper-2560x1600.jpg"))); // NOI18N
        jLabel7.setText("jLabel7");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(0, 0, 760, 620);

        tabbedPane.addTab("Overview", jPanel1);

        jPanel3.setLayout(null);

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/215073.png"))); // NOI18N
        jLabel8.setText("jLabel8");
        jPanel3.add(jLabel8);
        jLabel8.setBounds(0, 0, 770, 620);

        tabbedPane.addTab("Quick Build", jPanel3);

        jPanel2.setLayout(null);

        jButton1.setText("Create Character");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1);
        jButton1.setBounds(10, 11, 117, 23);

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/dungeons-and-dragons-wallpaper-HD5-1.jpg"))); // NOI18N
        jLabel10.setText("jLabel10");
        jPanel2.add(jLabel10);
        jLabel10.setBounds(0, 0, 770, 630);

        tabbedPane.addTab("Characters", jPanel2);

        adminPanel.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                adminPanelFocusGained(evt);
            }
        });
        adminPanel.setLayout(null);

        jLabel5.setText("jLabel5");
        adminPanel.add(jLabel5);
        jLabel5.setBounds(363, 62, 34, 14);

        createPlayer.setText("New Player");
        createPlayer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createPlayerActionPerformed(evt);
            }
        });
        adminPanel.add(createPlayer);
        createPlayer.setBounds(289, 11, 87, 23);

        playerPane.setOpaque(true);
        playerPane.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                playerPaneFocusGained(evt);
            }
        });

        playerTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "# Characters"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(playerTable);
        if (playerTable.getColumnModel().getColumnCount() > 0) {
            playerTable.getColumnModel().getColumn(0).setMinWidth(20);
            playerTable.getColumnModel().getColumn(0).setPreferredWidth(22);
            playerTable.getColumnModel().getColumn(0).setMaxWidth(25);
        }

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 564, Short.MAX_VALUE)
                .addContainerGap())
        );

        playerPane.addTab("Players", jPanel6);

        playerNameMenu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(playerNameMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 243, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(playerNameMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 566, Short.MAX_VALUE))
        );

        playerPane.addTab("Characters", jPanel4);

        adminPanel.add(playerPane);
        playerPane.setBounds(458, 0, 304, 614);

        tableCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "character", "class", "class_table", "domain", "equipment", "feat", "item", "monster", "player", "power", "skill", "spell" }));
        adminPanel.add(tableCombo);
        tableCombo.setBounds(28, 150, 78, 20);

        jLabel2.setText("Search:");
        adminPanel.add(jLabel2);
        jLabel2.setBounds(28, 104, 37, 14);

        jLabel6.setText("table:");
        adminPanel.add(jLabel6);
        jLabel6.setBounds(28, 129, 28, 14);

        queryField.setText("query");
        queryField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                queryFieldActionPerformed(evt);
            }
        });
        adminPanel.add(queryField);
        queryField.setBounds(132, 150, 120, 20);

        searchTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        searchTable.setOpaque(false);
        jScrollPane3.setViewportView(searchTable);

        adminPanel.add(jScrollPane3);
        jScrollPane3.setBounds(28, 188, 359, 257);

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/8bee769501b95f549f994ec494187f50.png"))); // NOI18N
        jLabel9.setText("jLabel9");
        adminPanel.add(jLabel9);
        jLabel9.setBounds(0, -60, 910, 730);

        tabbedPane.addTab("Admin", adminPanel);

        fileMenu.setText("File");

        logoutMenu.setText("Logout");
        logoutMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutMenuActionPerformed(evt);
            }
        });
        fileMenu.add(logoutMenu);

        exitItem.setText("Exit");
        exitItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitItemActionPerformed(evt);
            }
        });
        fileMenu.add(exitItem);

        jMenuBar1.add(fileMenu);

        editMenu.setText("Edit");
        jMenuBar1.add(editMenu);

        jMenu1.setText("Connect");
        jMenu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu1ActionPerformed(evt);
            }
        });

        jMenuItem1.setText("Remote database");
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabbedPane, javax.swing.GroupLayout.DEFAULT_SIZE, 763, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabbedPane, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 636, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Create_Char.setVisible();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void exitItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitItemActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitItemActionPerformed

    private void logoutMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutMenuActionPerformed
        this.setVisible(false);
        try {
            conn.close();
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        new Login().setVisible(true);
    }//GEN-LAST:event_logoutMenuActionPerformed

    private void createPlayerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createPlayerActionPerformed
        new New_Player(conn).setVisible(true);
    }//GEN-LAST:event_createPlayerActionPerformed

    private void tabbedPaneFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tabbedPaneFocusGained
        
    }//GEN-LAST:event_tabbedPaneFocusGained

    private void playerPaneFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_playerPaneFocusGained
        
    }//GEN-LAST:event_playerPaneFocusGained

    private void adminPanelFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_adminPanelFocusGained
        getPlayers(this.playerTable);
    }//GEN-LAST:event_adminPanelFocusGained

    private void queryFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_queryFieldActionPerformed
        this.search(this.queryField.getText(), this.tableCombo.getSelectedItem().toString(), this.searchTable);
                
    }//GEN-LAST:event_queryFieldActionPerformed

    private void jMenu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu1ActionPerformed
        new remote_db();
    }//GEN-LAST:event_jMenu1ActionPerformed
    
    /**
     * 
     * @param pid id of the user we want to retrieve characters for
     * @param table the name of the table we will write the results to
     */
    public void getChars (int pid, JTable table) {
        String sql ="select cid, name from character where character.pid = ?";
        try{
            pst = conn.prepareStatement(sql);
            pst.setString(1, Integer.toString(pid));
            rs = pst.executeQuery();
            if(rs.next()){       
                DefaultTableModel model = (DefaultTableModel) table.getModel();
                //looping through a ResultSet should be done with a do/while loop
                //otherwise you miss the first result
                do {
                    model.addRow(new String[]{Integer.toString(rs.getInt("cid")), rs.getString("name")});
                } while(rs.next()); 
                rs.close();
                pst.close();
            }
        }
        catch(Exception e)
        {
           JOptionPane.showMessageDialog(null, e);
        } 
        finally {
            try{
                rs.close();
                pst.close();
            } catch(Exception e) {}
        }
    }
    
    //overload for default charTable
    public void getChars (int pid){
        getChars (pid, charTable);
    }
    
    public void search(String query, String toTable, JTable table){
        String sql = "select name from " + toTable + " where name like ?";
        try{
            pst = conn.prepareStatement(sql);
            pst.setString(1, "%" + query + "%");
            rs = pst.executeQuery();
            if(rs.next()){       
                DefaultTableModel model = (DefaultTableModel) table.getModel();
                //looping through a ResultSet should be done with a do/while loop
                //otherwise you miss the first result
                do {
                    model.addRow(new String[]{rs.getString("name")});
                } while(rs.next()); 
                rs.close();
                pst.close();
            }
        }
        catch(Exception e)
        {
           JOptionPane.showMessageDialog(null, e);
        } 
        finally {
            try{
                rs.close();
                pst.close();
            } catch(Exception e) {}
        }
    }
    
    /**
     * populates overall player stats for admin use
     * @param table the table to write the data to
     */
    public void getPlayers (JTable table) {
        String sql ="select player.pid, player.name, count(character.cid) from player, character where character.pid = player.pid group by player.pid";
        try{
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            if(rs.next()){       
                DefaultTableModel model = (DefaultTableModel) table.getModel();
                //looping through a ResultSet should be done with a do/while loop
                //otherwise you miss the first result
                do {
                    model.addRow(new String[]{Integer.toString(rs.getInt("cid")), rs.getString("name"), Integer.toString(rs.getInt("count(cid)"))});
                } while(rs.next()); 
                rs.close();
                pst.close();
            }
        }
        catch(Exception e)
        {
           JOptionPane.showMessageDialog(null, e);
        } 
        finally {
            try{
                rs.close();
                pst.close();
            } catch(Exception e) {}
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel adminPanel;
    private javax.swing.JTable charTable;
    private javax.swing.JButton createPlayer;
    private javax.swing.JLabel currentPlayerLabel;
    private javax.swing.JMenu editMenu;
    private javax.swing.JMenuItem exitItem;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JMenuItem logoutMenu;
    private javax.swing.JComboBox<String> playerNameMenu;
    private javax.swing.JTabbedPane playerPane;
    private javax.swing.JTable playerTable;
    private javax.swing.JTextField queryField;
    private javax.swing.JTable searchTable;
    private javax.swing.JTabbedPane tabbedPane;
    private javax.swing.JComboBox<String> tableCombo;
    // End of variables declaration//GEN-END:variables
}
