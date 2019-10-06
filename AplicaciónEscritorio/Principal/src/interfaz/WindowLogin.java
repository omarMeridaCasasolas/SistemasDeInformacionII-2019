package interfaz;

import javax.swing.JOptionPane;
import conexion.Conexion;
import java.sql.ResultSet;
import java.sql.SQLException;

public class WindowLogin extends javax.swing.JFrame {

    public WindowLogin() {
        initComponents();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        username = new javax.swing.JTextField();
        pasword = new javax.swing.JPasswordField();
        loginAccept = new javax.swing.JButton();
        textMemberlogin = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        username.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usernameActionPerformed(evt);
            }
        });

        pasword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                paswordActionPerformed(evt);
            }
        });

        loginAccept.setText("Ingresar");
        loginAccept.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginAcceptActionPerformed(evt);
            }
        });

        textMemberlogin.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        textMemberlogin.setText("MEMBER LOGIN");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(117, 117, 117)
                        .addComponent(textMemberlogin))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(160, 160, 160)
                        .addComponent(loginAccept))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(145, 145, 145)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pasword, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(115, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(textMemberlogin, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(75, 75, 75)
                .addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(pasword, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(loginAccept)
                .addContainerGap(69, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void usernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usernameActionPerformed

    private void paswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_paswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_paswordActionPerformed

    //cambia la ventana de acuerdo al usuario que ingresa a la aplicación
    private void loginAcceptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginAcceptActionPerformed
        int windowNumber;
        String inUsername = username.getText();
        char[] in = pasword.getPassword();
        String inPasword = new String(in);
        if(valido(inUsername, 1) && valido(inPasword, 1)){
            windowNumber = login(inUsername, inPasword);
            if(windowNumber == 1){
                WindowPharmacyManager window = new WindowPharmacyManager();
                window.setVisible(true);
                dispose();
            }else{
                if(windowNumber == 2){
                    WindowWarehouseManager window = new WindowWarehouseManager();
                    window.setVisible(true);
                    dispose();
                }else{
                    if(windowNumber == 3){
                        WindowSeller window = new WindowSeller();
                        window.setVisible(true);
                        dispose();
                    }else{
                        JOptionPane.showMessageDialog(null, "Usuario no encontrado\nUsuario y contraseña no coinciden", "Error al iniciar seción", JOptionPane.ERROR_MESSAGE);
                    }
                }        
            }
        }else{
            JOptionPane.showMessageDialog(null, "Ingrese:\nUsuario = {0,..,9}\n Pasword = {0,..,9}", "Error al ingresar datos", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_loginAcceptActionPerformed

    private int login(String username, String pasword){
        int res = 0;
        Conexion cn = new Conexion();
        if(cn.conectar()){
            try{
                ResultSet rs = cn.rs("select * from EmpFarmacia where idEmp = '"+username+"'");
                while(rs.next()){
                    if(rs.getString("ciEmp").equals(pasword)){
                        if(rs.getString("cargoEmp").equals("AdministracionFarmacia"))
                            res = 1;
                        else
                            if(rs.getString("cargoEmp").equals("ControlAlmacen"))
                                    res = 2;
                            else
                                if(rs.getString("cargoEmp").equals("AtencionCliente"))
                                        res = 3;
                    }
                }
                rs.close();
            }catch(SQLException e){
                System.out.println(e.getMessage());
            }
            cn.desconectar();
        }
        return res;
    }
    
    // P = 1 {0,..,9}; p = 0 {a,..,z,A,..,Z,0,..,9}
    private boolean valido(String cad, int p){
        boolean res = true;
        int i = 0;
        if(cad.length() == 0)
            res = false;
        else
            if(p == 0)
                while(i < cad.length() && res != false){
                    if(cad.charAt(i) < 48 || cad.charAt(i) > 122)
                        res = false;
                    else
                        if(cad.charAt(i) > 57 && cad.charAt(i) < 65)
                            res = false;
                        else
                            if(cad.charAt(i) > 90 && cad.charAt(i) < 97)
                                res = false;
                    i++;
                }
            else
                if(p == 1)
                    while(i < cad.length() && res != false){
                        if(cad.charAt(i) < 48 || cad.charAt(i) > 57)
                            res = false;
                        i++;
                    }
        return res;
    }
    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new WindowLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton loginAccept;
    private javax.swing.JPasswordField pasword;
    private javax.swing.JLabel textMemberlogin;
    private javax.swing.JTextField username;
    // End of variables declaration//GEN-END:variables
}
