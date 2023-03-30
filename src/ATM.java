import java.util.Scanner;

public class ATM {
    public static int saldo = 1200000;
    public static boolean cancel = false;
    public static boolean reload_1 = false;
    public static boolean reload_2 = false;
    public static boolean reload_3 = false;
    public static boolean ulangi = false;
    public static boolean kembali = false;

    static void setor(){
        Scanner input = new Scanner(System.in);
        Integer setor = input.nextInt();
        if (setor >= 20000) {
            saldo = saldo + setor;
            ulangi = false;
            System.out.println("Saldo anda sekarang Rp" + saldo);
            kembali = true;
        } else {
            System.out.println("Masukkan nominal minimal Rp20.000");
            ulangi = true;
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("ATM Bank ABC");

        do {
            System.out.println("Gunakan angka 1 atau 2 untuk memilih setor atau tarik tunai, 0 untuk batal");
            Integer pilihan = input.nextInt();

            if (pilihan == 1) {
                System.out.println("Masukkan jumlah uang yang ingin anda setor:");
                do {
                    setor();
                } while (ulangi == true);

            } else if (pilihan == 2) {
                do {
                    //jumlah saldo nasabah
                    System.out.println("Saldo : Rp" + saldo);

                    //pecahan mata uang tersedia
                    Integer[] nominal = {20000, 50000, 100000};
                    System.out.println("Pecahan uang yang tersedia :");
                    for (int id = 0; id <= 2; id++) {
                        System.out.println(id + 1 + "." + "Rp" + nominal[id]);
                    }

                    //pilih pecahan uang
                    System.out.println("Gunakan angka (1-3) untuk memilih denominasi uang, 0 untuk membatalkan");
                    int id_nominal = input.nextInt();
                    if (id_nominal == 0) {
                        cancel = false;
                    } else if (id_nominal > 0 && id_nominal <= 3) {
                        System.out.println("Anda memilih pecahan " + nominal[id_nominal - 1] + ", lanjutkan?");

                        //konfirmasi
                        do {
                            reload_1 = false;
                            System.out.println("Y/N");
                            String confirm_1 = input.next();
                            if (confirm_1.equals("Y") || confirm_1.equals("y")) {
                                do {
                                    reload_1 = false;
                                    reload_2 = false;
                                    System.out.println("Berapa jumlah uang yang ingin anda ambil?");
                                    int uang = input.nextInt();
                                    int mod = uang % nominal[id_nominal - 1];
                                    int jumlahlembar = uang / nominal[id_nominal - 1];

                                    //saldo cukup atau tidak
                                    if (uang < saldo) {

                                        //saldo cukup
                                        if (mod == 0) {
                                            System.out.println("Silahkan ambil uang anda: ");
                                            for (int i = 1; i <= jumlahlembar; i++) {
                                                System.out.println("Rp" + nominal[id_nominal - 1]);
                                            }
                                            saldo = saldo - uang;
                                            do {
                                                reload_3 = false;
                                                System.out.println("Transaksi lagi?");
                                                System.out.println("Y/N");
                                                String confirm_2 = input.next();
                                                if (confirm_2.equals("Y") || confirm_2.equals("y")) {
                                                    cancel = true;
                                                } else if (confirm_2.equals("N") || confirm_2.equals("n")) {
                                                    cancel = false;
                                                } else {
                                                    reload_3 = true;
                                                }
                                            } while (reload_3 == true);

                                        } else if (mod != 0) {
                                            System.out.println("Mohon masukkan jumlah uang kelipatan Rp" + nominal[id_nominal - 1] + " saja.");
                                            reload_2 = true;
                                        }


                                    }

                                    //saldo kurang
                                    else {
                                        System.out.println("Maaf saldo anda tidak cukup");
                                        cancel = true;
                                    }
                                } while (reload_2 == true);
                            }

                            //batal
                            else if (confirm_1.equals("N") || confirm_1.equals("n")) {
                                cancel = true;
                            } else {
                                reload_1 = true;
                            }
                        } while (reload_1 == true);
                    } else {
                        System.out.println("Pilihan anda tidak terdaftar");
                        cancel = true;
                    }
                } while (cancel == true);
            } else if (pilihan == 0) {
                System.out.println("Terimakasih telah menggunakan layanan kami");
                kembali = false;
            }
        } while (kembali == true);
    }
}
