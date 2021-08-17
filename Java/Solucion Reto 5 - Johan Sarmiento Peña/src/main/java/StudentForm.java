import java.awt.HeadlessException;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public final class StudentForm extends javax.swing.JFrame
{
    ConnectionSQLite connectionSQLite = new ConnectionSQLite();
    StudentDAO studentDAO = new  StudentDAO();
    Student student = new Student();
    
    private String names = "";
    private String lastNames = "";
    private String birthDate ="";
    private String institutionalEmail = "";
    private String personalEmail = "";
    private String academicProgram = "";


    private long cellphoneNumber = 0;
    private long phoneNumber = 0;
    
    public StudentForm()
    {
        initComponents();
        connectionSQLite.openConnection();
        ShowJTableStudents();
    }
    
    public void ShowJTableStudents()
    {
        try
        {
            DefaultTableModel tableModel = new DefaultTableModel();
            
            jTableStudents.setModel(tableModel);
            
            PreparedStatement preparedStatement = connectionSQLite.connection.prepareStatement("Select * from estudiantes");
            ResultSet resultSet = preparedStatement.executeQuery();
            
            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
            
            int cantComumns =  resultSetMetaData.getColumnCount();
            
            tableModel.addColumn("Nombre");
            tableModel.addColumn("Apellido");
            tableModel.addColumn("Fecha de nacimiento");
            tableModel.addColumn("Correo institucional");
            tableModel.addColumn("Correo Personal");
            tableModel.addColumn("Programa academico");
            tableModel.addColumn("Numero de celular");
            tableModel.addColumn("Numero de telefono fijo");
            
            while( resultSet.next() )
            {
                Object[] filas = new Object[cantComumns];
                
                for (int i = 0; i < cantComumns; i++)
                {
                    filas[i] = resultSet.getObject(i + 1);
                }
                
                tableModel.addRow(filas);
            }
            
            preparedStatement.close();
        }
        
        catch (SQLException e)
        {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    public void CleanFormStudents()
    {
        jName.setText("");
        jLastNames.setText("");
        jBirthDate.setText("");
        jInstitutionalEmail.setText("");
        jPersonalEmail.setText("");
        jAcademicProgram.setText("");
        jCellphoneNumber.setText("");
        jPhoneNumber.setText("");
    }
    
    public void SearchStudent( String institutionalEmail )
    {
        try
        {
            PreparedStatement preparedStatement = connectionSQLite.connection.prepareStatement("Select * from estudiantes where institutionalEmail like ?");

            preparedStatement.setString(1, institutionalEmail);

            ResultSet resultSet = preparedStatement.executeQuery();

            if ( resultSet.next() )
            {
                jName.setText(resultSet.getString("name"));
                jLastNames.setText(resultSet.getString("lastName"));
                jBirthDate.setText(resultSet.getString("birthDate"));
                jInstitutionalEmail.setText(resultSet.getString("institutionalEmail"));
                jPersonalEmail.setText(resultSet.getString("personalEmail"));
                jAcademicProgram.setText(resultSet.getString("academicProgram"));
                jCellphoneNumber.setText(resultSet.getString("cellphoneNumber"));
                jPhoneNumber.setText(resultSet.getString("phoneNumber"));
            }

            preparedStatement.close();
        }

        catch (SQLException e)
        {
                System.out.println("Error: " + e.getMessage());
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        jRegister = new javax.swing.JButton();
        jModify = new javax.swing.JButton();
        jDelete = new javax.swing.JButton();
        jExit = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableStudents = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jBirthDate = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jInstitutionalEmail = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jPersonalEmail = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jAcademicProgram = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jCellphoneNumber = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jPhoneNumber = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jName = new javax.swing.JTextField();
        jLastNames = new javax.swing.JTextField();
        jCancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jRegister.setFont(new java.awt.Font("Ubuntu Nerd Font", 0, 10)); // NOI18N
        jRegister.setText("Registrar");
        jRegister.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jRegisterActionPerformed(evt);
            }
        });

        jModify.setFont(new java.awt.Font("Ubuntu Nerd Font", 0, 10)); // NOI18N
        jModify.setText("Modificar");
        jModify.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jModifyActionPerformed(evt);
            }
        });

        jDelete.setFont(new java.awt.Font("Ubuntu Nerd Font", 0, 10)); // NOI18N
        jDelete.setText("Eliminar");
        jDelete.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jDeleteActionPerformed(evt);
            }
        });

        jExit.setFont(new java.awt.Font("Ubuntu Nerd Font", 0, 10)); // NOI18N
        jExit.setText("Salir");
        jExit.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jExitActionPerformed(evt);
            }
        });

        jTableStudents.setFont(new java.awt.Font("Ubuntu Nerd Font", 0, 10)); // NOI18N
        jTableStudents.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][]
            {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String []
            {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "Title 7", "Title 8"
            }
        )
        {
            Class[] types = new Class []
            {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Long.class, java.lang.Long.class
            };
            boolean[] canEdit = new boolean []
            {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex)
            {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex)
            {
                return canEdit [columnIndex];
            }
        });
        jTableStudents.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                jTableStudentsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableStudents);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(""), "Datos de Estudiantes", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Ubuntu Nerd Font", 1, 12))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Ubuntu Nerd Font", 0, 10)); // NOI18N
        jLabel1.setText("Nombre");

        jLabel2.setFont(new java.awt.Font("Ubuntu Nerd Font", 0, 10)); // NOI18N
        jLabel2.setText("Apellido");

        jLabel3.setFont(new java.awt.Font("Ubuntu Nerd Font", 0, 10)); // NOI18N
        jLabel3.setText("Fecha de nacimiento");

        jLabel4.setFont(new java.awt.Font("Ubuntu Nerd Font", 0, 10)); // NOI18N
        jLabel4.setText("Correo institucional");

        jLabel5.setFont(new java.awt.Font("Ubuntu Nerd Font", 0, 10)); // NOI18N
        jLabel5.setText("Correo personal");

        jLabel6.setFont(new java.awt.Font("Ubuntu Nerd Font", 0, 10)); // NOI18N
        jLabel6.setText("Programa academico");

        jLabel7.setFont(new java.awt.Font("Ubuntu Nerd Font", 0, 10)); // NOI18N
        jLabel7.setText("Numero de celular");

        jLabel8.setFont(new java.awt.Font("Ubuntu Nerd Font", 0, 10)); // NOI18N
        jLabel8.setText("Numero de telefono fijo");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel1)
                        .addComponent(jName, javax.swing.GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE)
                        .addComponent(jInstitutionalEmail)
                        .addComponent(jBirthDate)
                        .addComponent(jLastNames))
                    .addComponent(jLabel3)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel7)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPersonalEmail, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jAcademicProgram, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jCellphoneNumber, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jPhoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel6))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPersonalEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLastNames, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jAcademicProgram, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBirthDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCellphoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jInstitutionalEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPhoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jCancel.setFont(new java.awt.Font("Ubuntu Nerd Font", 0, 10)); // NOI18N
        jCancel.setText("Cancelar");
        jCancel.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jCancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jRegister)
                        .addGap(90, 90, 90)
                        .addComponent(jModify)
                        .addGap(90, 90, 90)
                        .addComponent(jDelete)
                        .addGap(90, 90, 90)
                        .addComponent(jCancel)
                        .addGap(90, 90, 90)
                        .addComponent(jExit))
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(25, 25, 25))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jDelete)
                    .addComponent(jExit)
                    .addComponent(jModify)
                    .addComponent(jCancel)
                    .addComponent(jRegister, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jRegisterActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jRegisterActionPerformed
    {//GEN-HEADEREND:event_jRegisterActionPerformed
        if (jName.getText().isEmpty() || jLastNames.getText().isEmpty() || jBirthDate.getText().isEmpty() ||jInstitutionalEmail.getText().isEmpty() || jPersonalEmail.getText().isEmpty() || jAcademicProgram.getText().isEmpty() || jCellphoneNumber.getText().isEmpty() || jPhoneNumber.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(null, "Faltan datos por llenar", "Registro Estudiantes", JOptionPane.ERROR_MESSAGE);
        }
        
        else
        {
            try
            {
                names = jName.getText();
                lastNames = jLastNames.getText();
                birthDate = jBirthDate.getText();
                institutionalEmail = jInstitutionalEmail.getText();
                personalEmail = jPersonalEmail.getText();
                academicProgram = jAcademicProgram.getText();
                cellphoneNumber = Long.parseLong(jCellphoneNumber.getText());
                phoneNumber = Long.parseLong(jPhoneNumber.getText());
                
                SQLException studentCreate = studentDAO.CreateStudent(names, lastNames, birthDate, institutionalEmail, personalEmail, academicProgram, cellphoneNumber, phoneNumber);

                if (studentCreate == null)
                {
                    JOptionPane.showMessageDialog(null, "El registro fue grabado satisfactoriamente", "Registro de estudiantes",JOptionPane.INFORMATION_MESSAGE);
                }

                ShowJTableStudents();
                CleanFormStudents();
            }
            
            catch (HeadlessException | NumberFormatException e)
            {
                System.out.println("Error: " + e.getMessage());
                JOptionPane.showMessageDialog(null, "Error: Tipo de dato incorrecto en " + e.getMessage(), "Registro Estudiantes", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_jRegisterActionPerformed

    private void jModifyActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jModifyActionPerformed
    {//GEN-HEADEREND:event_jModifyActionPerformed
        if (jInstitutionalEmail.getText().isEmpty() || jPersonalEmail.getText().isEmpty() || jAcademicProgram.getText().isEmpty() || jCellphoneNumber.getText().isEmpty() || jPhoneNumber.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(null, "Faltan datos por llenar", "Registro Estudiantes", JOptionPane.ERROR_MESSAGE);
        }
        
        else
        {
            institutionalEmail = jInstitutionalEmail.getText();
            personalEmail = jPersonalEmail.getText();
            academicProgram = jAcademicProgram.getText();
            cellphoneNumber = Long.parseLong(jCellphoneNumber.getText());
            phoneNumber = Long.parseLong(jPhoneNumber.getText());

            studentDAO.UpdateStudent(institutionalEmail, personalEmail, academicProgram, cellphoneNumber, phoneNumber);

            JOptionPane.showMessageDialog(null, "El registro fue actualizado satisfactoriamente", "Registro de estudiantes",JOptionPane.INFORMATION_MESSAGE);

            ShowJTableStudents();
            CleanFormStudents();
        }
    }//GEN-LAST:event_jModifyActionPerformed

    private void jDeleteActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jDeleteActionPerformed
    {//GEN-HEADEREND:event_jDeleteActionPerformed
        if (jInstitutionalEmail.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(null, "Faltan datos por llenar", "Registro Estudiantes", JOptionPane.ERROR_MESSAGE);
        }
        
        else
        {
            institutionalEmail = jInstitutionalEmail.getText();
        
            studentDAO.DeleteStudent(institutionalEmail);
            JOptionPane.showMessageDialog(null, "El registro fue eliminado satisfactoriamente", "Registro de estudiantes",JOptionPane.INFORMATION_MESSAGE);

            ShowJTableStudents();
            CleanFormStudents();
        }
    }//GEN-LAST:event_jDeleteActionPerformed

    private void jCancelActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jCancelActionPerformed
    {//GEN-HEADEREND:event_jCancelActionPerformed
        CleanFormStudents();
    }//GEN-LAST:event_jCancelActionPerformed

    private void jExitActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jExitActionPerformed
    {//GEN-HEADEREND:event_jExitActionPerformed
        connectionSQLite.closeConnection();
        System.exit(0);
    }//GEN-LAST:event_jExitActionPerformed

    private void jTableStudentsMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_jTableStudentsMouseClicked
    {//GEN-HEADEREND:event_jTableStudentsMouseClicked
        if (jTableStudents.getSelectedRow() != -1)
        {
            String searchValue;

            searchValue = (String) jTableStudents.getValueAt(jTableStudents.getSelectedRow(), 3);
            
            SearchStudent(searchValue);
        }
    }//GEN-LAST:event_jTableStudentsMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[])
    {
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
            java.util.logging.Logger.getLogger(StudentForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StudentForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StudentForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StudentForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StudentForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JTextField jAcademicProgram;
    public javax.swing.JTextField jBirthDate;
    public javax.swing.JButton jCancel;
    public javax.swing.JTextField jCellphoneNumber;
    public javax.swing.JButton jDelete;
    public javax.swing.JButton jExit;
    public javax.swing.JTextField jInstitutionalEmail;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    public javax.swing.JTextField jLastNames;
    public javax.swing.JButton jModify;
    public javax.swing.JTextField jName;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JTextField jPersonalEmail;
    public javax.swing.JTextField jPhoneNumber;
    public javax.swing.JButton jRegister;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable jTableStudents;
    // End of variables declaration//GEN-END:variables
}
