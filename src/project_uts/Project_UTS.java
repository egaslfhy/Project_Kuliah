package project_uts;

import java.util.Scanner;

// superclass
class RekeningBank {
    protected String noRek;
    protected String namaUser;
    private int saldo; 

    //constructor
    public RekeningBank(String noRek, String namaUser, int saldoAwal) {
        this.noRek = noRek;
        this.namaUser = namaUser;
        this.saldo = saldoAwal;
    }

    // getter buat akses value saldo yang private 
    public int getSaldo() {
        return this.saldo;
    }

    // Setter buat ubah (nambahin) nilai saldo
    public void setSaldo(int saldoBaru) {
        this.saldo = saldoBaru;
    }
}

// subclass 
class RekeningPribadi extends RekeningBank {

    public RekeningPribadi(String noRek, String namaUser, int saldoAwal) {
        super(noRek, namaUser, saldoAwal); 
    }

    //method untuk tambah data (console poin pertama terpenuhi)
    public void setorTunai(int jumlah) {
        if (jumlah > 0) {
            int saldoBaru = this.getSaldo() + jumlah;
            this.setSaldo(saldoBaru); // Update saldo menggunakan setter
            System.out.println("Setor tunai berhasil! Saldo Anda sekarang: Rp " + this.getSaldo());
        } else {
            System.out.println("Jumlah setor tidak valid.");
        }
    }
    
    //method untuk tampil data (console poin dua terpenuhi)
    public void tampilPemilik() {
        System.out.println("=========BANK SEDERHANA=========");
        System.out.println("No Rekening  : " + this.noRek);
        System.out.println("Nama Nasabah : " + this.namaUser);
        System.out.println("Sisa Saldo   : Rp " + this.getSaldo()); 
        System.out.println("=====================================");
    }

    
    // method status (console poin empat terpenuhi)
    public void cekStatus() {
        if (this.getSaldo() > 5000000) {
            System.out.println("Status: Nasabah Prioritas");
        } else {
            System.out.println("Status: Nasabah Reguler");
        }
    }
}

public class Project_UTS {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // objek 
        RekeningPribadi user1 = new RekeningPribadi("1234-567-8910", "Aruna Telaga Saraswati", 15000000);

        int pilihan = 0;
        
        // menu console
        while (pilihan != 5) {
            System.out.println("\n------- Aplikasi Bank Mini Yang Masih Banyak Kurangnya -------");
            System.out.println("1. Setor Tunai");
            System.out.println("2. Info Rekening");
            System.out.println("3. Ubah Tipe Transfer");
            System.out.println("4. Status Rekening");
            System.out.println("5. Keluar Program");
            System.out.print("Pilihan Anda: ");
            
            // validasi agar tidak error jika user input huruf
            if (scanner.hasNextInt()) {
                pilihan = scanner.nextInt();
            } else {
                System.out.println("Input harus angka!");
                scanner.next();
                continue;
            }

            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan jumlah uang yang ingin disetor: Rp ");
                    int setor = scanner.nextInt();
                    user1.setorTunai(setor); // Memanggil method tambah saldo
                    break;

                case 2:
                    user1.tampilPemilik(); // Memanggil method tampilkan data
                    break;

                    //untuk console poin ke tiga (ubah data)
                case 3:
                    System.out.println("Pilih Rekening Sumber Dana:");
                    System.out.println("a. Rekening Giro");
                    System.out.println("b. Rekening Tabungan");
                    System.out.print("Pilihan (a/b): ");
                    String tipe = scanner.next();
                    
                    if (tipe.equalsIgnoreCase("a")) {
                        System.out.println("Sumber dana diubah ke: Rekening Giro");
                    } else if (tipe.equalsIgnoreCase("b")) {
                        System.out.println("Sumber dana diubah ke: Rekening Tabungan");
                    } else {
                        System.out.println("Pilihan tidak valid.");
                    }
                    break;

                case 4:
                    user1.cekStatus();
                    break;

                    //keluar program
                case 5:
                    System.out.println("Terima kasih Telah Menggunakan Bank Yang Biasa Aja.");
                    break;

                default:
                    System.out.println("Pilihan menu tidak tersedia. Silakan coba lagi.");
            }
        }
        scanner.close();
    }
}