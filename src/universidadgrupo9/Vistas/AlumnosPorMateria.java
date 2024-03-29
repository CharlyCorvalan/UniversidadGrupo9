
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
    //Instanciamos un modelo de tabla a usar
private DefaultTableModel modelo=new DefaultTableModel(){
   //A travez del metodo isCellEditable se elije las filas y columnas que seran editables
    //o no.
    public boolean isCellEditable(int fila, int columna){
        return false;
    }
};
    //Inicializamos los componentes del JIFrame ademas de los metodos necesarios
    //para el correcto desarrollo de la ventana
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
        //Se utiliza el siguiente codigo para cerrar la ventana
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void ComboMateriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboMateriaActionPerformed
        //A travez de la accion de seleccionar un item en el combobox se obtendran los siguientes datos
        //Evita que quede informacion residual en la tabla 
        limpiarTabla();
        //Se obtiene la informacion del item seleccionado del combobox y se toma el toString establecido en la clase Alumnos
        String num=ComboMateria.getSelectedItem().toString();
        //Se toma el primer caracter del toString, a travez de substring
        String num1=num.substring(0, 1);
        //Lo requerido es un int, se debe parsear lo obtenido en el paso anterior
        int idMat=Integer.parseInt(num1);
        //Se instancia un objeto de InscripcionData para poder acceder a sus metodos
        InscripcionData ins=new InscripcionData();   
        //Se instancia una List para poder cargar la tabla mediante el metodo cargartabla();
        //El metodo obtenerAlumnosPorMateria de la clase InscripcionData requiere un id de materia
        //y devuelve una ArrayList de Alumnos
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
    //Se carga el combobox  con el listado de materias vigentes
   public void cargarCombo(){
       //Se utiliza el metodo lsitarMaterias a travez de la clase MateriaData
       MateriaData mate=new MateriaData();
       for (Materia elem : mate.listarMAterias()) {
           ComboMateria.addItem(elem.toString());
       }
   } 
   //Se obtendra un listado de alumnos. La cabecera muestra el tipo de informacion que se cargara en la tabla
   public void cargarCabecera(){
       modelo.addColumn("ID");
       modelo.addColumn("DNI");
       modelo.addColumn("Apellido");
       modelo.addColumn("Nombre");
       TablaAlumnos.setModel(modelo);
   }
   //Metodo utilizado para evitar sobrecargar la tabla, mostrando solo la informacion requerida
    public void limpiarTabla(){
        int fila=modelo.getRowCount();
        for (int i = fila-1; i > -1; i--) {
            modelo.removeRow(i);
        }
    }
    //Metodo por el cual se procede a cargar la tabla
    public void cargarTabla(ArrayList<Alumnos> al){
        //Al recibir una List, el metodo utiliza un for each para poder recorrer la List y agregar filas a la tabla
        for (Alumnos ele : al) {
            modelo.addRow(new Object[]{ele.getIdAlumno(),ele.getDni(),ele.getApellido(),ele.getNombre()});
        }
    }
}

