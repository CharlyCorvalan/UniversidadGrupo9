/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package universidadgrupo9.Vistas;

import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import universidadgrupo9.AccesoADatos.AlumnoData;
import universidadgrupo9.AccesoADatos.InscripcionData;
import universidadgrupo9.Entidades.Alumnos;
import universidadgrupo9.Entidades.Materia;

/**
 *
 * @author charl
 */
public class ManejoDeInscripciones extends javax.swing.JInternalFrame {

    private DefaultTableModel modelo=new DefaultTableModel();
    public ManejoDeInscripciones() {
        initComponents();
        CargarCabecera();
        CargarComboBox();
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
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        CBSelecAlum = new javax.swing.JComboBox<>();
        RBMateNoIns = new javax.swing.JRadioButton();
        RBMateIns = new javax.swing.JRadioButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableAlum = new javax.swing.JTable();
        jBIns = new javax.swing.JButton();
        jBAnularIns = new javax.swing.JButton();
        jBSalir = new javax.swing.JButton();
        jBLimpiar = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        jLabel1.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jLabel1.setText("formulario de inscripcion");

        jLabel2.setText("seleccione un alumno");

        jLabel3.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jLabel3.setText("listado de materias");

        CBSelecAlum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CBSelecAlumActionPerformed(evt);
            }
        });

        RBMateNoIns.setText("materias no inscriptas");
        RBMateNoIns.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RBMateNoInsActionPerformed(evt);
            }
        });

        RBMateIns.setText("materias inscriptas");
        RBMateIns.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RBMateInsActionPerformed(evt);
            }
        });

        jTableAlum.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(jTableAlum);

        jBIns.setText("Inscribir");
        jBIns.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBInsActionPerformed(evt);
            }
        });

        jBAnularIns.setText("Anular Inscripcion");

        jBSalir.setText("Salir");
        jBSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBSalirActionPerformed(evt);
            }
        });

        jBLimpiar.setText("Limpiar");
        jBLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBLimpiarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(RBMateIns)
                        .addGap(22, 22, 22)
                        .addComponent(jBLimpiar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(RBMateNoIns)
                        .addGap(14, 14, 14))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jBIns)
                        .addGap(69, 69, 69)
                        .addComponent(jBAnularIns)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jBSalir)
                        .addGap(17, 17, 17))))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(116, 116, 116)
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(CBSelecAlum, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(139, 139, 139)
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(CBSelecAlum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(RBMateNoIns)
                    .addComponent(RBMateIns)
                    .addComponent(jBLimpiar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBIns)
                    .addComponent(jBAnularIns)
                    .addComponent(jBSalir))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBInsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBInsActionPerformed
        
    }//GEN-LAST:event_jBInsActionPerformed

    private void RBMateNoInsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RBMateNoInsActionPerformed
       InscripcionData alu=new InscripcionData();

 String alum=CBSelecAlum.getSelectedItem().toString();
    char a= alum.charAt(0);
        
        int aa=Integer.parseInt(a+"");
        ArrayList<Materia> aray=new ArrayList<>(alu.NoInscripcionPorAlum(aa));
        cargarTablaLista(aray);
    }//GEN-LAST:event_RBMateNoInsActionPerformed

    private void RBMateInsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RBMateInsActionPerformed
InscripcionData alu=new InscripcionData();

 String alum=CBSelecAlum.getSelectedItem().toString();
    char a= alum.charAt(0);
        
        int aa=Integer.parseInt(a+"");
        ArrayList<Materia> aray=new ArrayList<>(alu.InscripcionPorAlum(aa));
        cargarTablaLista(aray);
        
   


    }//GEN-LAST:event_RBMateInsActionPerformed

    private void CBSelecAlumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CBSelecAlumActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CBSelecAlumActionPerformed

    private void jBSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSalirActionPerformed
        dispose();
    }//GEN-LAST:event_jBSalirActionPerformed

    private void jBLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBLimpiarActionPerformed
        CBSelecAlum.setSelectedIndex(0);
        RBMateIns.setSelected(false);
        RBMateNoIns.setSelected(false);
        int numFil=jTableAlum.getRowCount();
        for (int i=numFil-1;i>-1;i--) {
            modelo.removeRow(i);
        }
    }//GEN-LAST:event_jBLimpiarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> CBSelecAlum;
    private javax.swing.JRadioButton RBMateIns;
    private javax.swing.JRadioButton RBMateNoIns;
    private javax.swing.JButton jBAnularIns;
    private javax.swing.JButton jBIns;
    private javax.swing.JButton jBLimpiar;
    private javax.swing.JButton jBSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTableAlum;
    // End of variables declaration//GEN-END:variables
public void CargarComboBox(){
  AlumnoData alD=new AlumnoData();
    //CBSelecAlum.setModel(new DefaultComboBoxModel<>(alD.listarAlumnos()));
for (Alumnos alum : alD.listarAlumnos()) {


        CBSelecAlum.addItem(alum.toString());
    }
}

private void CargarCabecera(){
   modelo.addColumn("ID");
   modelo.addColumn("NOMBRE");
   modelo.addColumn("AÑO");
   jTableAlum.setModel(modelo);
    
}
public void cargarTablaLista(ArrayList<Materia> list){
   
    for (Materia elem : list) {
       modelo.addRow(new Object[]{elem.getIdMateria(),elem.getNombre(),elem.getAñoMateria()});
    }
   
}
}
