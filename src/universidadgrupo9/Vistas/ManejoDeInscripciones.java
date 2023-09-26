/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package universidadgrupo9.Vistas;

import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import universidadgrupo9.AccesoADatos.AlumnoData;
import universidadgrupo9.AccesoADatos.InscripcionData;
import universidadgrupo9.AccesoADatos.MateriaData;
import universidadgrupo9.Entidades.Alumnos;
import universidadgrupo9.Entidades.Inscripcion;
import universidadgrupo9.Entidades.Materia;

/**
 *
 * @author charl
 */
public class ManejoDeInscripciones extends javax.swing.JInternalFrame {
//Se declara un objeto DefaultTableModel "modelo" para modelar y cargar la cabecera y tabla.
    private DefaultTableModel modelo = new DefaultTableModel();

    public ManejoDeInscripciones() {
        
        //Se cargan al inicio del JInternalFrame todos los componentes, la cabecera de Tabla, Combobox,
        //se Setean las filas de la tabla y se anula la utilizacion de los Buttons "Anular" e "Inscribir"
        //hasta ser requeridos
        initComponents();
        CargarCabecera();
        CargarComboBox();
        limpiarFilas();
        BotonAnular.setEnabled(false);
        BotonInscribir.setEnabled(false);

    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        CBSelecAlum = new javax.swing.JComboBox<>();
        MateriasNoInscriptas = new javax.swing.JRadioButton();
        MateriasInscriptas = new javax.swing.JRadioButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableAlum = new javax.swing.JTable();
        BotonInscribir = new javax.swing.JButton();
        BotonAnular = new javax.swing.JButton();
        jBSalir = new javax.swing.JButton();

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

        MateriasNoInscriptas.setText("materias no inscriptas");
        MateriasNoInscriptas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MateriasNoInscriptasActionPerformed(evt);
            }
        });

        MateriasInscriptas.setText("materias inscriptas");
        MateriasInscriptas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MateriasInscriptasActionPerformed(evt);
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

        BotonInscribir.setText("Inscribir");
        BotonInscribir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonInscribirActionPerformed(evt);
            }
        });

        BotonAnular.setText("Anular Inscripcion");
        BotonAnular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonAnularActionPerformed(evt);
            }
        });

        jBSalir.setText("Salir");
        jBSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(BotonInscribir)
                .addGap(69, 69, 69)
                .addComponent(BotonAnular)
                .addGap(23, 23, 23)
                .addComponent(jBSalir)
                .addGap(17, 17, 17))
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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(CBSelecAlum, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(MateriasInscriptas)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(MateriasNoInscriptas)
                                .addGap(25, 25, 25)))))
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
                    .addComponent(MateriasNoInscriptas)
                    .addComponent(MateriasInscriptas))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BotonInscribir)
                    .addComponent(BotonAnular)
                    .addComponent(jBSalir))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BotonInscribirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonInscribirActionPerformed
//En la accion, se instancia una InscripcionData para la utilizacion de sus metodos
        InscripcionData insAl = new InscripcionData();
        int numNota = 0;
        //Se toma la fila seleccionada en la tabla de materias.
        int filaselec = jTableAlum.getSelectedRow();

        if (filaselec < 0) {
            JOptionPane.showMessageDialog(null, "seleccione una materia antes de continuar.");
        } else {
            //Se utiliza el try-catch para verificar los datos ingresados por el usuario en busca de posibles 
            //errores en la carga de los mismos.
            try {
                //Se toma el primer valor de la fila seleccionada (idMateria) y se Parsea a INT.
                int idMat = Integer.parseInt(modelo.getValueAt(filaselec, 0).toString());
                //Se toman los datos del alumno seleccionado en el ComboBox, para luego, seleccionar el
                //Primer caracter (idAlumno) y Parsear a INT.
                String alum = CBSelecAlum.getSelectedItem().toString();
                String alum2 = alum.substring(0, 1);
                int a = Integer.parseInt(alum2);
                //Se ultiliza un JOptionPane.showInputDialog() para permitir el ingreso por medio de una ventana
                //emergente de la nota del alumno en formato String, que luego se Parsea a Double.
                double nota = Double.parseDouble(JOptionPane.showInputDialog("ingrese la nota numerica decimal", numNota));
                Alumnos alu = new Alumnos();
                Materia mater = new Materia();
                mater.setIdMateria(idMat);
                alu.setIdAlumno(a);
                //Se crea un objeto Inscripcion "ins" con los parametros requeridos ya cargados en la inscripcion
                //Que luego se pasa por parametro al metodo "guardarInscripcion().
                Inscripcion ins = new Inscripcion(nota, alu, mater);
                insAl.guardarInscripcion(ins);
            } catch (NumberFormatException | NullPointerException ex) {
                JOptionPane.showMessageDialog(null, "Error, verifique los datos ingresados ");
            }

        }
        //Si la accion es exitosa, se limpia la tabla, se anula la seleccion del RadioButton, se anula la
        //utilizacion del Button Inscribir y se ubica el ComboBox en la primera posicion (0).
        limpiarFilas();
        MateriasNoInscriptas.setSelected(false);
        BotonInscribir.setEnabled(false);
        CBSelecAlum.setSelectedIndex(0);

    }//GEN-LAST:event_BotonInscribirActionPerformed

    private void MateriasNoInscriptasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MateriasNoInscriptasActionPerformed
        //Se anula la seleccion del RadioButton "materias inscriptas", se anula la edicion del Button "Anular"
        //Se habilita la edicion del Button Inscribir y se limpian filas de tabla al seleccionar el RadioButton
        //"Materias No Inscriptas".
        MateriasInscriptas.setSelected(false);
        BotonAnular.setEnabled(false);
        BotonInscribir.setEnabled(true);
        limpiarFilas();
        InscripcionData alu = new InscripcionData();

        String alum = CBSelecAlum.getSelectedItem().toString();
        String alum2 = alum.substring(0, 1);
        int a = Integer.parseInt(alum2);
        //Se crea un ArrayList de Materia y se carga en el metodo "NoInscripcionPorAlum()" del objeto 
        //InscripcionData "alu" para luego cargar ese ArrayList en el metodo "cargarTablaLista()" para efectivamente
        //Cargar la tabla con los datos del ArrayList.
        ArrayList<Materia> aray = new ArrayList<>(alu.NoInscripcionPorAlum(a));
        cargarTablaLista(aray);

    }//GEN-LAST:event_MateriasNoInscriptasActionPerformed

    private void MateriasInscriptasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MateriasInscriptasActionPerformed
        //Idem a la accion "MateriasNoInscriptas"
        BotonInscribir.setEnabled(false);
        MateriasNoInscriptas.setSelected(false);
        BotonAnular.setEnabled(true);
        limpiarFilas();
        InscripcionData alu = new InscripcionData();

        String alum = CBSelecAlum.getSelectedItem().toString();
        String alum2 = alum.substring(0, 1);
        int a = Integer.parseInt(alum2);

        ArrayList<Materia> aray = new ArrayList<>(alu.InscripcionPorAlum(a));
        cargarTablaLista(aray);


    }//GEN-LAST:event_MateriasInscriptasActionPerformed

    private void CBSelecAlumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CBSelecAlumActionPerformed
        //Al estar sin seleccion el ComboBox, se Setean en "False" todas las acciones del JInternalFrame y  
        //limpia las filas de la tabla hasta la seleccion de un objeto del ComboBox.
        BotonInscribir.setEnabled(false);
        MateriasNoInscriptas.setSelected(false);
        BotonAnular.setEnabled(false);
        MateriasInscriptas.setSelected(false);
        limpiarFilas();
    }//GEN-LAST:event_CBSelecAlumActionPerformed

    private void jBSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSalirActionPerformed
        //Accion del Button "Salir", (cierra el JInternalFrame).
        dispose();
    }//GEN-LAST:event_jBSalirActionPerformed

    private void BotonAnularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonAnularActionPerformed
//Idem a la accion del Button Inscribir".
        InscripcionData insAl = new InscripcionData();
        int filaselec = jTableAlum.getSelectedRow();

        if (filaselec <= -1) {
            JOptionPane.showMessageDialog(null, "seleccione una materia antes de continuar.");
        } else {
            try {
                int idMat = Integer.parseInt(modelo.getValueAt(filaselec, 0).toString());
                String alum = CBSelecAlum.getSelectedItem().toString();
                String alum2 = alum.substring(0, 1);
                int a = Integer.parseInt(alum2);
                Materia mater = new Materia();
                mater.setIdMateria(idMat);
                insAl.AnularInscripcionAlum(a, idMat);
            } catch (NumberFormatException | NullPointerException ex) {
                JOptionPane.showMessageDialog(null, "Error, verifique los datos ingresados ");
            }

        }
        BotonAnular.setEnabled(false);
        MateriasInscriptas.setSelected(false);
        CBSelecAlum.setSelectedIndex(0);
        limpiarFilas();
    }//GEN-LAST:event_BotonAnularActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotonAnular;
    private javax.swing.JButton BotonInscribir;
    private javax.swing.JComboBox<String> CBSelecAlum;
    private javax.swing.JRadioButton MateriasInscriptas;
    private javax.swing.JRadioButton MateriasNoInscriptas;
    private javax.swing.JButton jBSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTableAlum;
    // End of variables declaration//GEN-END:variables
public void CargarComboBox() {
    //Se crea un objeto AlumnoData "alD" para la utilizacion de su metodo listarAlumnos() y recorrer en un
    //"forech" un alumno "alum" en el cual, por cada alumno "alum" retornara por medio del metodo "toString()"
    //los datos de esos alumnos, cargandolos en el ComboBox con el metodo addItem().
        AlumnoData alD = new AlumnoData();
        for (Alumnos alum : alD.listarAlumnos()) {

            CBSelecAlum.addItem(alum.toString());
        }
    }

    private void CargarCabecera() {
        //Por medio del objeto DefaultTableModel "modelo" se cargan las cabeceras de la tabla por medio del
        //metodo addColumn() que luego, se cargan a la tabla por medio del metodo setModel().
        modelo.addColumn("ID");
        modelo.addColumn("NOMBRE");
        modelo.addColumn("AÑO");
        jTableAlum.setModel(modelo);

    }

    public void cargarTablaLista(ArrayList<Materia> list) {
//El metodo recibe un ArrayList de Materia "list" que luego se recorre con un forech, el cual, carga cada 
//uno de los elementos en ese ArrayList en la tabla por medio de un instanciacion de "modelo", para despues
//cargar la tabla con esos elementos.
        for (Materia elem : list) {
            modelo.addRow(new Object[]{elem.getIdMateria(), elem.getNombre(), elem.getAñoMateria()});
        }

    }

    public void limpiarFilas() {
        //El metodo trae el numero de filas cargadas en la tabla por medio del metodo getRowCount(), para
        //luego, recorrer en un forech en forma descendente e ir removiendo su contenido en cada posicion
        //de "i" utilizando el metodo removeRow().
        int filTotal = modelo.getRowCount() - 1;
        for (int i = filTotal; i > -1; i--) {
            modelo.removeRow(i);

        }

    }

}
