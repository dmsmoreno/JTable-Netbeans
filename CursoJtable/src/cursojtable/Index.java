/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cursojtable;

import JcheckBox.CheckBoxColumn;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author CHAPARRO
 */
public class Index extends javax.swing.JFrame {

    double contador;
    int intentos = 0;
    
    /**
     * Creates new form Index
     */
    public Index() {
        initComponents();
        mostrarPersonas();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
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
        tabla = new javax.swing.JTable();
        btn_eliminar = new javax.swing.JButton();
        txt_buscar = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tabla.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"", "", null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tabla.setRowHeight(25);
        jScrollPane1.setViewportView(tabla);

        btn_eliminar.setText("Eliminar");
        btn_eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_eliminarActionPerformed(evt);
            }
        });

        txt_buscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_buscarKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 764, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txt_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_eliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_eliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 438, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_eliminarActionPerformed

        Logica logica = new Logica();

        long tiempo_inicial = System.currentTimeMillis();

        System.out.println("inicio"+tiempo_inicial);

        for (int i = 0; i < tabla.getRowCount(); i++)
        {
            if  ( CheckBoxColumn.IsSelected(i, 4, tabla))
            {
                logica.eliminarRegistro(Integer.parseInt(tabla.getValueAt(i, 1).toString()));
            }
        }

        mostrarPersonas();

        long tiempo_final = System.currentTimeMillis();
        System.out.println("consumido total seguntos = "+((double)(tiempo_final-tiempo_inicial)/1000));

        contador += ((double)(tiempo_final-tiempo_inicial)/1000);
        intentos ++;

        System.out.println(contador+"  "+intentos);

    }//GEN-LAST:event_btn_eliminarActionPerformed

    private void txt_buscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_buscarKeyReleased

        buscarPersona(txt_buscar.getText());

    }//GEN-LAST:event_txt_buscarKeyReleased

    public void mostrarPersonas()
    {
        Logica logica = new Logica();
        
        CheckBoxColumn checkBoxColumn = new CheckBoxColumn();
        
        DefaultTableModel modelo = logica.mostrarPersonas();
        
        tabla.setModel(modelo);    
        
        tabla.getColumnModel().getColumn(0).setMaxWidth(70);//define el tamaño fijo de la primera columna
        
        tabla.getColumnModel().getColumn(0).setMinWidth(70);//define el tamaño fijo de la primera columnca
        
        tabla.getColumnModel().getColumn(2).setMaxWidth(333);//define el tamaño fijo de la primera columna
        
        tabla.getColumnModel().getColumn(2).setMinWidth(333);//define el tamaño fijo de la primera columnca
        
        checkBoxColumn.addCheckBox(4, tabla);       
            
    }
    
    public void buscarPersona(String buscar)
    {
        Logica logica = new Logica();
        
        DefaultTableModel modelo = logica.buscarPersonas(buscar);
        
        tabla.setModel(modelo);
        
        CheckBoxColumn checkBoxColumn = new CheckBoxColumn();
        
        checkBoxColumn.addCheckBox(4, tabla);
    }
    
      

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_eliminar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabla;
    private javax.swing.JTextField txt_buscar;
    // End of variables declaration//GEN-END:variables
}
