package project_uts;

/**
 *
 * @author Ega Silfiha
 */
class rek_giro extends rekening {
    
    private Float limit_saldo;
    public String cek_4digit = "XXXX-XXX-4321" ;
    
    //extends super class
    void display_giro(){
        System.out.println("Rekening Pengirim : " + super.no_rek);
        System.out.println("nama" + super.user);
        System.out.println("Rekening Penerima : " + this.cek_4digit);
    }

    
    rek_giro (Float limit_saldo, String cek_4digit) {

    this.limit_saldo = limit_saldo ;
    this.cek_4digit = cek_4digit;
    
    }
}
