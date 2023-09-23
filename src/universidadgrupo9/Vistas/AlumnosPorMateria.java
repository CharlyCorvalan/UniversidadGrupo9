
package universidadgrupo9.Vistas;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import universidadgrupo9.AccesoADatos.InscripcionData;
import universidadgrupo9.AccesoADatos.MateriaData;
import universidadgrupo9.Entidades.Alumnos;
import universidadgrupo9.Entidades.Materia;

/**
 *
 * @author charl
 */
public class AlumnosPorMateria extends javax.swing.JInternalFrame {
private DefaultTableModel modelo=new DefaultTableModel(){
    public boolean isCellEditable(int fila, int columna){
        return false;
    }
};
    /**
     * Creates new form AlumnosPorMateria
     */
    public AlumnosPorMateria() {
        initComponents();
        cargarCombo();
        cargarCabecera();
        limpiarTabla();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        ComboMateria = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaAlumnos = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        jLabel1.setText("Listado de Alumnos por Materia");

        jLabel2.setText("Seleccione una materia");

        ComboMateria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboMateriaActionPerformed(evt);
            }
        });

        TablaAlumnos.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(TablaAlumnos);

        jButton1.setText("Salir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(45, 45, 45)
                            .addComponent(jLabel2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ComboMateria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGap(91, 91, 91)
                            .addComponent(jLabel1))))
                .addContainerGap(33, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(53, 53, 53))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(ComboMateria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void ComboMateriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboMateriaActionPerformed
        limpiarTabla();
        String num=ComboMateria.getSelectedItem().toString();
        String num1=num.substring(0, 1);
        int idMat=Integer.parseInt(num1);
        InscripcionData ins=new InscripcionData();   
        ArrayList<Alumnos> mate=new ArrayList<>(ins.obtenerAlumnosPorMateria(idMat));
        cargarTabla(mate);
    }//GEN-LAST:event_ComboMateriaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ComboMateria;
    private javax.swing.JTable TablaAlumnos;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

   public void cargarCombo(){
       MateriaData mate=new MateriaData();
       for (Materia elem : mate.listarMAterias()) {
           ComboMateria.addItem(elem.toString());
       }
   } 
   public void cargarCabecera(){
       modelo.addColumn("ID");
       modelo.addColumn("DNI");
       modelo.addColumn("Apellido");
       modelo.addColumn("Nombre");
       TablaAlumnos.setModel(modelo);
   }
    public void limpiarTabla(){
        int fila=modelo.getRowCount();
        for (int i = fila-1; i > -1; i--) {
            modelo.removeRow(i);
        }
    }
    public void cargarTabla(ArrayList<Alumnos> al){
        
        for (Alumnos ele : al) {
            modelo.addRow(new Object[]{ele.getIdAlumno(),ele.getDni(),ele.getApellido(),ele.getNombre()});
        }
    }
}

