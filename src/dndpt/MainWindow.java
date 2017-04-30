/*
 * This class includes all MainWindow components, and is launched by Login
 * Holds global variables for user identification, permissions
 */
package dndpt;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
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
        currentPlayerLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        charTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        updateCharName = new javax.swing.JButton();
        quickButton = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
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
        jLabel9 = new javax.swing.JLabel();
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
        currentPlayerLabel.setBounds(10, 10, 120, 14);

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
        charTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                charTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(charTable);
        charTable.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (charTable.getColumnModel().getColumnCount() > 0) {
            charTable.getColumnModel().getColumn(0).setMinWidth(22);
            charTable.getColumnModel().getColumn(0).setPreferredWidth(22);
            charTable.getColumnModel().getColumn(0).setMaxWidth(35);
            charTable.getColumnModel().getColumn(1).setResizable(false);
        }

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(10, 50, 230, 190);

        jLabel1.setText("Your characters:");
        jLabel1.setMaximumSize(new java.awt.Dimension(110, 16));
        jLabel1.setMinimumSize(new java.awt.Dimension(110, 16));
        jPanel1.add(jLabel1);
        jLabel1.setBounds(10, 30, 80, 14);

        jButton2.setText("Change Password");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);
        jButton2.setBounds(10, 580, 150, 23);

        updateCharName.setText("Rename");
        updateCharName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateCharNameActionPerformed(evt);
            }
        });
        jPanel1.add(updateCharName);
        updateCharName.setBounds(10, 240, 80, 23);

        quickButton.setText("Quick Build");
        jPanel1.add(quickButton);
        quickButton.setBounds(250, 50, 110, 23);

        jButton1.setText("Create Character");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(250, 80, 117, 23);

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
        createPlayer.setOpaque(false);
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
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 605, Short.MAX_VALUE)
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

        tableCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "character", "class", "class_table", "domain", "equipment", "feat", "item", "monster", "player", "power", "skill", "spell" }));
        adminPanel.add(tableCombo);
        tableCombo.setBounds(10, 80, 140, 20);

        jLabel2.setForeground(new java.awt.Color(250, 250, 250));
        jLabel2.setText("Search:");
        adminPanel.add(jLabel2);
        jLabel2.setBounds(10, 60, 50, 14);

        queryField.setText("query");
        queryField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                queryFieldActionPerformed(evt);
            }
        });
        adminPanel.add(queryField);
        queryField.setBounds(160, 80, 170, 20);

        updateButton.setText("Update Entry");
        updateButton.setOpaque(false);
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });
        adminPanel.add(updateButton);
        updateButton.setBounds(10, 260, 140, 23);

        deleteButton.setText("Delete Entry");
        deleteButton.setOpaque(false);
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });
        adminPanel.add(deleteButton);
        deleteButton.setBounds(150, 260, 140, 23);

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
        new Create_Char().setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void updateCharNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateCharNameActionPerformed

        try{
            String value1 = newCharName.getText();
            String value2 = charID.getText();
            String sql ="update character set name = '"+value1+"' where cid = '"+value2+"'";
            pst = conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null,"Character Name Updated!");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }finally {
            try{
                rs.close();
                pst.close();
            } catch(Exception e) {}
        }
        getChars(pid, charTable);
    }//GEN-LAST:event_updateCharNameActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void charTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_charTableMouseClicked
        try{
            int row = charTable.getSelectedRow();
            String Table_Click =  (charTable.getModel().getValueAt(row,0).toString());
            String sql = "select * from character where cid = '"+Table_Click+"'  ";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }finally {
            try{
                rs.close();
                pst.close();
            } catch(Exception e) {}
        }
    }//GEN-LAST:event_charTableMouseClicked

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        new NewPassword(conn, this.pid).setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void tabbedPaneFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tabbedPaneFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_tabbedPaneFocusLost

    private void tabbedPaneFocusGained(java.awt.event.FocusEvent evt) {
        String sql = "SELECT * FROM player";
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
    private javax.swing.JTable adminCTable;
    private javax.swing.JTable adminPTable;
    private javax.swing.JPanel adminPanel;
    private javax.swing.JTable charTable;
    private javax.swing.JButton createPlayer;
    public javax.swing.JLabel currentPlayerLabel;
    private javax.swing.JButton deleteButton;
    private javax.swing.JMenu editMenu;
    private javax.swing.JMenuItem exitItem;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JMenuItem logoutMenu;
    private javax.swing.JTabbedPane playerPane;
    private javax.swing.JTextField queryField;
    private javax.swing.JButton quickButton;
    private javax.swing.JMenuItem remoteItem;
    private javax.swing.JTable searchTable;
    private javax.swing.JTabbedPane tabbedPane;
    private javax.swing.JComboBox<String> tableCombo;
    private javax.swing.JButton updateButton;
    private javax.swing.JButton updateCharName;
    // End of variables declaration//GEN-END:variables
}
