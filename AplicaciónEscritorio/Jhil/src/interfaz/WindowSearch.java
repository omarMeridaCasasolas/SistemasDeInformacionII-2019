package interfaz;

import conexion.Conexion;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;

public class WindowSearch extends javax.swing.JFrame {

    public WindowSearch() {
        initComponents();
        searchAll();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        search = new javax.swing.JButton();
        back = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        inSearch = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        list = new javax.swing.JList<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        search.setText("Buscar");
        search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchActionPerformed(evt);
            }
        });

        back.setText("Atras");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });

        jLabel1.setText("Ingrese Nombre de Empleado");

        inSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inSearchActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(list);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(145, 145, 145)
                        .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(back))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(95, 95, 95)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(inSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 38, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(inSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(back)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchActionPerformed
        String nombre = inSearch.getText();
        if(nombre.length() > 0){
            String[] datos = search(nombre);
            if(datos.length > 0){
                WindowUpdate window = new WindowUpdate(datos);
                window.setVisible(true);
                dispose();
            }
        }else{
        
        }
    }//GEN-LAST:event_searchActionPerformed
    
    private String[] search(String nom){
        String res[] = {};
        Conexion cn = new Conexion();
        String url = "select * from empFarmacia where nomEmp = '"+nom+"'";
        cn.conectar();
        ResultSet rs = cn.rs(url);
        try {
            if(rs.next()){
                res = new String[7];
                res[0] = rs.getString("nomEmp");
                res[1] = rs.getString("apeEmp");
                res[2] = rs.getString("ciEmp");
                res[3] = rs.getString("fecNacEmp");
                res[4] = rs.getString("dirEmp");
                res[5] = rs.getString("telEmp");
                res[6] = rs.getString("cargoEmp");
            }
        } catch (SQLException ex) {
            Logger.getLogger(WindowSearch.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }
    
    private boolean searchAll(){
        boolean res = false;
        Conexion cn = new Conexion();
        if(cn.conectar()){
            try{
                DefaultListModel model = new DefaultListModel<>();
                model.addElement("::::::::::::::::::::::::::");
                model.addElement("::::::::::::::::::::::::::");
                model.addElement("Administración de Farmacia");
                ResultSet rs;
                rs = cn.rs("select * from empFarmacia where cargoEmp = 'AdministracionFarmacia'");
                while(rs.next()){
                    model.addElement(rs.getString("nomEmp")+" "+rs.getString("apeEmp"));
                }
                model.addElement("::::::::::::::::::::::::::");
                model.addElement("::::::::::::::::::::::::::");
                model.addElement("Control del Almacén");
                rs = cn.rs("select * from empFarmacia where cargoEmp = 'ControlAlmacen'");
                while(rs.next()){
                    model.addElement(rs.getString("nomEmp")+" "+rs.getString("apeEmp"));
                }
                model.addElement("::::::::::::::::::::::::::");
                model.addElement("::::::::::::::::::::::::::");
                model.addElement("Atención al Cliente");
                rs = cn.rs("select * from empFarmacia where cargoEmp = 'AtencionCliente'");
                while(rs.next()){
                    model.addElement(rs.getString("nomEmp")+" "+rs.getString("apeEmp"));
                }
                list.setModel(model);
                res = true;
            }catch(SQLException e){
                System.out.println(e.getMessage());
            }
            cn.desconectar();
        }
        return res;
    }
    
    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        WindowPharmacyManager window = new WindowPharmacyManager();
        window.setVisible(true);
        dispose();
    }//GEN-LAST:event_backActionPerformed

    private void inSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inSearchActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new WindowSearch().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back;
    private javax.swing.JTextField inSearch;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<String> list;
    private javax.swing.JButton search;
    // End of variables declaration//GEN-END:variables
}
