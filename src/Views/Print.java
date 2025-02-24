/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Views;

import Models.Purchases;
import Models.PurchasesDao;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.PrintJob;
import java.awt.Toolkit;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author karlaglira
 */
public class Print extends javax.swing.JFrame implements Printable{

    Purchases purchase = new Purchases();
    PurchasesDao purchaseDao = new PurchasesDao();
    DefaultTableModel modelo = new DefaultTableModel();
    /**
     * Creates new form Print
     */
    public Print(int id) {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle("Factura de compra");
        // Para que al cerrar este ventana, la otra se mantenga
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        txt_invoice.setText("" + id);
        listAllPurchasesDetails(id);
        calculatePurchase();
    }

    public void listAllPurchasesDetails(int id){
        List<Purchases> list = purchaseDao.listPurchasesDetailsQuery(id);
        modelo = (DefaultTableModel) purchase_details_table.getModel();
        Object[] roww = new Object[7];
        for(Purchases purchaseIT : list){
            roww[0] = purchaseIT.getName();
            roww[1] = purchaseIT.getPurchase_amount();
            roww[2] = purchaseIT.getPurchase_price();
            roww[3] = purchaseIT.getPurchase_subtotal();
            roww[4] = purchaseIT.getSupplier_name();
            roww[5] = purchaseIT.getPurchaser();
            roww[6] = purchaseIT.getCreated();
            
            modelo.addRow(roww);
        }
        purchase_details_table.setModel(modelo);
    }
    
    
    // Calcular total
    public void calculatePurchase(){
        double total = 0.00;
        int numRow = purchase_details_table.getRowCount();
        
        for (int i=0; i<numRow; i++){
            // Pasar índice de la columna que se sumará
            total = total + Double.parseDouble(String.valueOf( purchase_details_table.getValueAt(i, 3)));
        }
        txt_total.setText(String.valueOf(total));
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        form_print = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txt_invoice = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        purchase_details_table = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        txt_total = new javax.swing.JTextField();
        btn_print_purchase = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        form_print.setBackground(new java.awt.Color(152, 204, 204));
        form_print.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/farmacia.png"))); // NOI18N
        jLabel1.setText("jLabel1");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        form_print.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 100, 70));

        jPanel1.setBackground(new java.awt.Color(18, 45, 61));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("VIDA NATURAL");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 30, -1, -1));

        txt_invoice.setEditable(false);
        jPanel1.add(txt_invoice, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 20, 110, 30));

        form_print.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 620, 70));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Detalles de la compra:");
        form_print.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, -1, -1));

        purchase_details_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Producto", "Cantidad", "Precio", "Subtotal", "Proveedor", "Comprador", "Fecha de compra"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(purchase_details_table);
        if (purchase_details_table.getColumnModel().getColumnCount() > 0) {
            purchase_details_table.getColumnModel().getColumn(6).setMinWidth(80);
        }

        form_print.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 580, 250));

        jLabel4.setFont(new java.awt.Font("Helvetica Neue", 1, 15)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Total:");
        form_print.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 460, -1, -1));
        form_print.add(txt_total, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 450, 140, 30));

        getContentPane().add(form_print, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 620, 520));

        btn_print_purchase.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn_print_purchase.setText("IMPRIMIR");
        btn_print_purchase.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_print_purchaseActionPerformed(evt);
            }
        });
        getContentPane().add(btn_print_purchase, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 550, 160, 50));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_print_purchaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_print_purchaseActionPerformed

        Toolkit tk = form_print.getToolkit();
        PrintJob pj = tk.getPrintJob(this, null, null);
        Graphics graphics = pj.getGraphics();
        form_print.print(graphics);
        graphics.dispose();
        pj.end(); 
  /*
        PrinterJob job = PrinterJob.getPrinterJob();
        job.setPrintable(this);
        if(job.printDialog()){
            try{
                job.print();
            }catch(PrinterException e){
                
            }
        }else{
            JOptionPane.showMessageDialog(null, "Impresión cancelada");
        }*/
    }//GEN-LAST:event_btn_print_purchaseActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_print_purchase;
    private javax.swing.JPanel form_print;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable purchase_details_table;
    private javax.swing.JTextField txt_invoice;
    private javax.swing.JTextField txt_total;
    // End of variables declaration//GEN-END:variables

    @Override
    public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
        Graphics2D graphics2d = (Graphics2D) graphics;
        graphics2d.translate(pageFormat.getImageableX(), pageFormat.getImageableY());
        printAll(graphics2d);
        if(pageIndex == 0){
            return PAGE_EXISTS;
        }else{
            return NO_SUCH_PAGE;
        }
    }
}
