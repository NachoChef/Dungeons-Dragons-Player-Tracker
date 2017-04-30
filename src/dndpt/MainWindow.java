/*
 * This class includes all MainWindow components, and is launched by Login
 * Holds global variables for user identification, permissions
 */
package dndpt;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import net.proteanit.sql.DbUtils;

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
        icount.setText(String.valueOf("Total items in database: " + getStats("equipment")));
        pcount.setText(String.valueOf("Total player count: " + getStats("player")));
        ccount.setText(String.valueOf("Total character count: " + getStats("character")));
        this.setVisible(true);
        //disable admin pane if not admin
        //test to add entries to JTable:
        if (!this.isAdmin)
            this.tabbedPane.setEnabledAt(1, false);
        this.conn = conn;
        this.getChars(pid, charTable);
        hat.setVisible(false);
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
        currentPlayerLabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        pcount = new javax.swing.JLabel();
        ccount = new javax.swing.JLabel();
        icount = new javax.swing.JLabel();
        hat = new javax.swing.JLabel();
        img = new javax.swing.JLabel();
        deleteButton1 = new javax.swing.JButton();
        updateButton1 = new javax.swing.JButton();
        panething = new javax.swing.JScrollPane();
        charTable = new javax.swing.JTable();
        burrisbutton = new javax.swing.JButton();
        bg = new javax.swing.JLabel();
        adminPanel = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        createPlayer = new javax.swing.JButton();
        playerPane = new javax.swing.JTabbedPane();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        adminPTable = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        adminCTable = new javax.swing.JTable();
        tableCombo = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        queryField = new javax.swing.JTextField();
        updateButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        searchTable = new javax.swing.JTable();
        bg2 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        logoutMenu = new javax.swing.JMenuItem();
        exitItem = new javax.swing.JMenuItem();
        editMenu = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        remoteItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Dungeons & Dragons Player Tracker");
        setResizable(false);
        setSize(new java.awt.Dimension(763, 659));

        tabbedPane.setBackground(new java.awt.Color(204, 204, 204));
        tabbedPane.setOpaque(true);
        tabbedPane.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tabbedPaneFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                tabbedPaneFocusLost(evt);
            }
        });

        jPanel1.setRequestFocusEnabled(false);
        jPanel1.setLayout(null);

        currentPlayerLabel.setText("Active login:");
        jPanel1.add(currentPlayerLabel);
        currentPlayerLabel.setBounds(10, 10, 120, 16);

        jLabel1.setText("Your characters:");
        jLabel1.setMaximumSize(new java.awt.Dimension(110, 16));
        jLabel1.setMinimumSize(new java.awt.Dimension(110, 16));
        jPanel1.add(jLabel1);
        jLabel1.setBounds(10, 30, 130, 16);

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jButton1.setText("Create Character");
        jButton1.setMaximumSize(new java.awt.Dimension(130, 23));
        jButton1.setPreferredSize(new java.awt.Dimension(120, 23));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(280, 200, 130, 30);

        pcount.setText("Total player count:");
        jPanel1.add(pcount);
        pcount.setBounds(350, 350, 180, 16);

        ccount.setText("Total character count:");
        jPanel1.add(ccount);
        ccount.setBounds(350, 370, 150, 16);

        icount.setText("Total items in database:");
        jPanel1.add(icount);
        icount.setBounds(350, 390, 130, 16);

        hat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/hat.png"))); // NOI18N
        jPanel1.add(hat);
        hat.setBounds(80, 200, 180, 230);

        img.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/drizzt.png"))); // NOI18N
        jPanel1.add(img);
        img.setBounds(-20, 280, 520, 390);

        deleteButton1.setText("Delete Entry");
        deleteButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(deleteButton1);
        deleteButton1.setBounds(140, 200, 140, 29);

        updateButton1.setText("Update Entry");
        updateButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(updateButton1);
        updateButton1.setBounds(0, 200, 140, 29);

        charTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        panething.setViewportView(charTable);

        jPanel1.add(panething);
        panething.setBounds(0, 50, 610, 150);

        burrisbutton.setBackground(new java.awt.Color(0, 0, 0));
        burrisbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                burrisbuttonActionPerformed(evt);
            }
        });
        jPanel1.add(burrisbutton);
        burrisbutton.setBounds(597, 579, 10, 10);

        bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/winter_mountain_painting-wallpaper-2560x1600.jpg"))); // NOI18N
        bg.setText("jLabel3");
        jPanel1.add(bg);
        bg.setBounds(0, -10, 660, 630);

        tabbedPane.addTab("Overview", jPanel1);

        adminPanel.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                adminPanelFocusGained(evt);
            }
        });
        adminPanel.setLayout(null);
        adminPanel.add(jSeparator1);
        jSeparator1.setBounds(10, 300, 610, 10);

        createPlayer.setText("New Player");
        createPlayer.setPreferredSize(new java.awt.Dimension(100, 23));
        createPlayer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createPlayerActionPerformed(evt);
            }
        });
        adminPanel.add(createPlayer);
        createPlayer.setBounds(10, 20, 100, 23);

        playerPane.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                playerPaneFocusGained(evt);
            }
        });

        jPanel6.setOpaque(false);

        jScrollPane2.setOpaque(false);

        adminPTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        adminPTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(adminPTable);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 569, Short.MAX_VALUE)
                .addGap(14, 14, 14))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 262, Short.MAX_VALUE)
        );

        playerPane.addTab("Players", jPanel6);

        adminCTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        adminCTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane4.setViewportView(adminCTable);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 605, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 262, Short.MAX_VALUE)
        );

        playerPane.addTab("Characters", jPanel4);

        adminPanel.add(playerPane);
        playerPane.setBounds(10, 310, 610, 290);

        tableCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "character", "character_stats", "class", "class_table", "equipment", "item", "player", "skill", "spell" }));
        tableCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tableComboActionPerformed(evt);
            }
        });
        adminPanel.add(tableCombo);
        tableCombo.setBounds(10, 80, 140, 27);

        jLabel2.setForeground(new java.awt.Color(250, 250, 250));
        jLabel2.setText("Search:");
        adminPanel.add(jLabel2);
        jLabel2.setBounds(10, 60, 50, 16);

        queryField.setText("query");
        queryField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                queryFieldActionPerformed(evt);
            }
        });
        adminPanel.add(queryField);
        queryField.setBounds(160, 80, 170, 26);

        updateButton.setText("Update Entry");
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });
        adminPanel.add(updateButton);
        updateButton.setBounds(10, 260, 140, 29);

        deleteButton.setText("Delete Entry");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });
        adminPanel.add(deleteButton);
        deleteButton.setBounds(150, 260, 140, 29);

        jScrollPane3.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane3.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        searchTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        searchTable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        searchTable.setColumnSelectionAllowed(true);
        searchTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                searchTableMouseClicked(evt);
            }
        });
        searchTable.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                searchTableKeyTyped(evt);
            }
        });
        jScrollPane3.setViewportView(searchTable);
        searchTable.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        adminPanel.add(jScrollPane3);
        jScrollPane3.setBounds(10, 110, 610, 150);

        bg2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/8bee769501b95f549f994ec494187f50.png"))); // NOI18N
        bg2.setText("jLabel9");
        adminPanel.add(bg2);
        bg2.setBounds(0, -60, 910, 730);

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

        jMenuItem1.setText("Change Password");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        editMenu.add(jMenuItem1);

        jMenuBar1.add(editMenu);

        jMenu1.setText("Connect");
        jMenu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu1ActionPerformed(evt);
            }
        });

        remoteItem.setText("Remote database");
        remoteItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                remoteItemActionPerformed(evt);
            }
        });
        jMenu1.add(remoteItem);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabbedPane, javax.swing.GroupLayout.DEFAULT_SIZE, 635, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabbedPane, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 638, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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

    private void remoteItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_remoteItemActionPerformed
        try{
            this.conn.close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        new Remote().setVisible(true);
    }//GEN-LAST:event_remoteItemActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        try{
            int row = searchTable.getSelectedRow();
            int col = searchTable.getSelectedColumn();
            String sql = "DELETE FROM " +tableCombo.getSelectedItem() + " WHERE " +  searchTable.getColumnName(0) + " = " + searchTable.getModel().getValueAt(row,0).toString();
            DefaultTableModel model = (DefaultTableModel)searchTable.getModel();
            int modelRow = searchTable.convertRowIndexToModel(row);
            model.removeRow(modelRow);
            pst = conn.prepareStatement(sql);
            pst.executeUpdate();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }finally {
            try{
                rs.close();
                pst.close();
            } catch(Exception e) {}
        }
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
        try{
            int row = searchTable.getSelectedRow();
            int col = searchTable.getSelectedColumn();
            String newVal = (String)searchTable.getModel().getValueAt(row,col);
            String sql = "UPDATE " +tableCombo.getSelectedItem() + " SET " + searchTable.getColumnName(col) + " = ? WHERE " +  searchTable.getColumnName(0) + " = " + searchTable.getModel().getValueAt(row,0).toString();
            pst = conn.prepareStatement(sql);
            pst.setString(1, newVal);
            pst.executeUpdate();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }finally {
            try{
                rs.close();
                pst.close();
            } catch(Exception e) {}
        }
    }//GEN-LAST:event_updateButtonActionPerformed

    private void queryFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_queryFieldActionPerformed
        this.search(this.queryField.getText(), this.tableCombo.getSelectedItem().toString(), this.searchTable);
    }//GEN-LAST:event_queryFieldActionPerformed

    private void createPlayerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createPlayerActionPerformed
        new New_Player(conn).setVisible(true);
    }//GEN-LAST:event_createPlayerActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        new Create_Char(pid, conn).setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        new NewPassword(conn, this.pid).setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void tabbedPaneFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tabbedPaneFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_tabbedPaneFocusLost

    private void tableComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tableComboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tableComboActionPerformed

    private void deleteButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_deleteButton1ActionPerformed

    private void updateButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButton1ActionPerformed
        try{
            int row = charTable.getSelectedRow();
            int col = charTable.getSelectedColumn();
            String newVal = (String)charTable.getModel().getValueAt(row,col);
            String sql = "UPDATE character SET " + charTable.getColumnName(col) + " = ? WHERE " +  charTable.getColumnName(0) + " = " + charTable.getModel().getValueAt(row,0).toString();
            pst = conn.prepareStatement(sql);
            pst.setString(1, newVal);
            pst.executeUpdate();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }finally {
            try{
                rs.close();
                pst.close();
            } catch(Exception e) {}
        }
    }//GEN-LAST:event_updateButton1ActionPerformed

    private void burrisbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_burrisbuttonActionPerformed
        hat.setVisible(true);
    }//GEN-LAST:event_burrisbuttonActionPerformed

    private void tabbedPaneFocusGained(java.awt.event.FocusEvent evt) {
        String sql = "SELECT pid, name, username, isAdmin FROM player";
        try{
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            adminPTable.setModel(DbUtils.resultSetToTableModel(rs));
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }finally {
            try{
                rs.close();
                pst.close();
            } catch(Exception e) {}
        }
        sql = "SELECT * FROM character";
        try{
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            adminCTable.setModel(DbUtils.resultSetToTableModel(rs));
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }finally {
            try{
                rs.close();
                pst.close();
            } catch(Exception e) {}
        }
    }

    private String getStats(String table){
        String sql = "SELECT * FROM " + table;
        String result = "ERROR";
        try{
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            rs.last();
            result = Integer.toString(rs.getRow());
        }catch(Exception e){}
        return result;
    }
    
    
    /**
     *
     * @param pid id of the user we want to retrieve characters for
     * @param table the name of the table we will write the results to
     */
    public void getChars (int pid, JTable table) {
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        String sql = "SELECT * FROM character where character.pid = ?";
        try{
            pst = conn.prepareStatement(sql);
            pst.setString(1, Integer.toString(pid));
            rs = pst.executeQuery();
            charTable.setModel(DbUtils.resultSetToTableModel(rs));
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }finally {
            try{
                rs.close();
                pst.close();
            } catch(Exception e) {}
        }
        
    }

    public void search(String query, String toTable, JTable table){
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        String sql = "select * from " + toTable + " where name like ?";
        try{
            pst = conn.prepareStatement(sql);
            pst.setString(1, "%" + query + "%");
            rs = pst.executeQuery();
            table.setModel(DbUtils.resultSetToTableModel(rs));
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
        String sql ="select player.pid, player.name, count(character.id) from player, character where character.pid = player.pid group by player.pid";
        try{
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            if(rs.next()){
                DefaultTableModel model = (DefaultTableModel) table.getModel();
                //looping through a ResultSet should be done with a do/while loop
                //otherwise you miss the first result
                do {
                    model.addRow(new String[]{Integer.toString(rs.getInt("id")), rs.getString("name"), Integer.toString(rs.getInt("count(cid)"))});
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
    private javax.swing.JTable adminCTable;
    private javax.swing.JTable adminPTable;
    private javax.swing.JPanel adminPanel;
    private javax.swing.JLabel bg;
    private javax.swing.JLabel bg2;
    private javax.swing.JButton burrisbutton;
    private javax.swing.JLabel ccount;
    private javax.swing.JTable charTable;
    private javax.swing.JButton createPlayer;
    public javax.swing.JLabel currentPlayerLabel;
    private javax.swing.JButton deleteButton;
    private javax.swing.JButton deleteButton1;
    private javax.swing.JMenu editMenu;
    private javax.swing.JMenuItem exitItem;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JLabel hat;
    private javax.swing.JLabel icount;
    private javax.swing.JLabel img;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JMenuItem logoutMenu;
    private javax.swing.JScrollPane panething;
    private javax.swing.JLabel pcount;
    private javax.swing.JTabbedPane playerPane;
    private javax.swing.JTextField queryField;
    private javax.swing.JMenuItem remoteItem;
    private javax.swing.JTable searchTable;
    private javax.swing.JTabbedPane tabbedPane;
    private javax.swing.JComboBox<String> tableCombo;
    private javax.swing.JButton updateButton;
    private javax.swing.JButton updateButton1;
    // End of variables declaration//GEN-END:variables
}
