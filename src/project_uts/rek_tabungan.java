package project_uts;

/**
 *
 * @author Ega Silfiha
 */
 
public class rek_tabungan extends rekening{
    private Float suku_flower;
    private Float min_saldo;
    private int fee_admin = 5000;

    //extends super class
    void display_tab(){
        System.out.println("Rekening pengirim : " + super.no_rek);
        System.out.println("Nama" + super.user);
    }
    
rek_tabungan (Float suku_flower, Float min_saldo, int fee_admin) {

    this.suku_flower = suku_flower ;
    this.min_saldo = min_saldo;
    this.fee_admin = fee_admin ;
    
}
}