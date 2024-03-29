/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package universidadgrupo9.Vistas;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import universidadgrupo9.AccesoADatos.AlumnoData;
import universidadgrupo9.AccesoADatos.InscripcionData;
import universidadgrupo9.Entidades.Alumnos;
import universidadgrupo9.Entidades.Inscripcion;
import universidadgrupo9.Entidades.Materia;

/**
 *
 * @author charl
 */
public class ManipulacionDeNotas extends javax.swing.JInternalFrame {

    private DefaultTableModel modelo = new DefaultTableModel() {
        //dentro del objeto DefaultTableModel "modelo" se crea un metodo Boolean que recibe un Int de 
        //fila "fila" y columna "colu" para luego setear la posicion recibida por parametro en "true"
        //para hacerla Editable.
        public boolean isCellEditable(int fila, int colu) {
            if (colu == 2) {
                return true;
            }

            return false;
        }

    };

    public ManipulacionDeNotas() {
        initComponents();
        CargarComboBox();
        CargarCabecera();
        limpiarFilas();
        jBGuardar.setEnabled(false);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jCSelecAlum = new javax.swing.JComboBox<>();
        jBGuardar = new javax.swing.JButton();
        jBSalir = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableAlum = new javax.swing.JTable();

        jLabel1.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jLabel1.setText("CARGA DE NOTAS");

        jLabel2.setText("Seleccione un alumno");

        jCSelecAlum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCSelecAlumActionPerformed(evt);
            }
        });

        jBGuardar.setText("Guardar");
        jBGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBGuardarActionPerformed(evt);
            }
        });

        jBSalir.setText("Salir");
        jBSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBSalirActionPerformed(evt);
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jLabel2)
                        .addGap(49, 49, 49)
                        .addComponent(jCSelecAlum, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(109, 109, 109)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jBGuardar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBSalir)
                .addGap(49, 49, 49))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jCSelecAlum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(86, 86, 86)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBGuardar)
                    .addComponent(jBSalir))
                .addContainerGap(55, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSalirActionPerformed
        dispose();
    }//GEN-LAST:event_jBSalirActionPerformed

    private void jCSelecAlumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCSelecAlumActionPerformed
        //Al seleccionar un alumno del ComboBox, se limpian filas y se cargan las mismas con los datos
        //del alumno seleccionado, previamente cargados en un ArrayList de Inscripcion y pasados al metodo
        //cargarTablaLista().
        jBGuardar.setEnabled(true);
        limpiarFilas();
        InscripcionData alu = new InscripcionData();

        String alum = jCSelecAlum.getSelectedItem().toString();
        String alum2 = alum.substring(0, 1);
        int a = Integer.parseInt(alum2);

        ArrayList<Inscripcion> aray = new ArrayList<>(alu.InscripcionPorID(a));
        cargarTablaLista(aray);

        // TODO add your handling code here:
    }//GEN-LAST:event_jCSelecAlumActionPerformed

    private void jBGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBGuardarActionPerformed
        InscripcionData ins = new InscripcionData();
        //Se toma la fila seleccionada
        int filaselec = jTableAlum.getSelectedRow();
        if(filaselec>-1){
        try {
            String alum = jCSelecAlum.getSelectedItem().toString();
            String alum2 = alum.substring(0, 1);
            //Se parsean los valores obtenidos del alumno "idAlum", materia "idMat" y nota "nota"
            int idAlum = Integer.parseInt(alum2);
            //Se toman los valores de la fila seleccionada "filaselec" y la columna seleccionada 
            //(segundo item "0" y "2") para luego parsearlos. 
            int idMat = Integer.parseInt(modelo.getValueAt(filaselec, 0).toString());
            double nota = Double.parseDouble(modelo.getValueAt(filaselec, 2).toString());
            //por medio del metodo ActualizarNota() del objeto "ins", se pasan por parametros los datos
            //requeridos por el metodo.
            ins.ActualizarNota(idAlum, idMat, nota);
            //Se salva por medio del catch, las exceptions que puedan aparecer en los datos ingresados
            //por los usuarios.
        } catch (NumberFormatException | NullPointerException ex) {
            JOptionPane.showMessageDialog(null, "Error, ingrese una nota numerica ");
        }
        }else{
            //si la la accion no detecta una fila seleccionada, da aviso por un JOptionPane e inhabilita
            //el uso del Button "Guardar", ademas de setear en posicion "0" el CombboBox.
            JOptionPane.showMessageDialog(null, "Seleccione una fila para continuar");
            jBGuardar.setEnabled(false);
            jCSelecAlum.setSelectedIndex(0); 
        }
        //Si la accion es exitosa, se limpian filas e inhabilitan el Button "Guardar"
        limpiarFilas();
        jBGuardar.setEnabled(false);
    }//GEN-LAST:event_jBGuardarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBGuardar;
    private javax.swing.JButton jBSalir;
    private javax.swing.JComboBox<String> jCSelecAlum;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableAlum;
    // End of variables declaration//GEN-END:variables

    public void CargarComboBox() {
        AlumnoData alD = new AlumnoData();
        //CBSelecAlum.setModel(new DefaultComboBoxModel<>(alD.listarAlumnos()));
        for (Alumnos alum : alD.listarAlumnos()) {

            jCSelecAlum.addItem(alum.toString());
        }
    }

    private void CargarCabecera() {
        modelo.addColumn("ID");
        modelo.addColumn("NOMBRE");
        modelo.addColumn("NOTA");
        jTableAlum.setModel(modelo);

    }

    public void cargarTablaLista(ArrayList<Inscripcion> list) {

        for (Inscripcion elem : list) {
            modelo.addRow(new Object[]{elem.getMateria().getIdMateria(), elem.getMateria().getNombre(), elem.getNota()});
        }

    }

    public void limpiarFilas() {
        int filTotal = modelo.getRowCount() - 1;
        for (int i = filTotal; i > -1; i--) {
            modelo.removeRow(i);

        }

    }

}
