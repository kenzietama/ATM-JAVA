import java.util.Scanner;

public class ATM {
    public static int saldo = 1200000;
    public  static Integer[] nominal = {20000, 50000, 100000};
    public static boolean cancel = false;
    public static boolean reload_1 = false;
    public static boolean reload_2 = false;
    public static boolean reload_3 = false;
/*    public static boolean ulangi = false;*/
    public static boolean kembali = false;
static String terimakasih() {
return "Terimakasih telah menggunakan layanan kami!";
}

    public static void main(String[] args) {
        objectATM method  = new objectATM();

        Scanner input = new Scanner(System.in);

        do {
            System.out.println("ATM Bank ABC");
            System.out.println("1. Setor tunai");
            System.out.println("2. Tarik tunai");
            System.out.println("0. Batal");
            System.out.println("Gunakan angka 1 atau 2 untuk memilih setor atau tarik tunai, 0 untuk batal");
            Integer pilihan = input.nextInt();

            if (pilihan == 1) {
                System.out.println("Masukkan jumlah uang yang ingin anda setor:");
                method.setor();
            } else if (pilihan == 2) {
                method.tariktunai();
                cancel = false;
                do {
                    if (objectATM.id_uang == 0) {

                    } else if (objectATM.id_uang > 0 && objectATM.id_uang <= 3) {
                        System.out.println("Anda memilih pecahan " + nominal[objectATM.id_uang - 1] + ", lanjutkan?");

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
                                    int mod = uang % nominal[objectATM.id_uang - 1];
                                    int jumlahlembar = uang / nominal[objectATM.id_uang - 1];

                                    //saldo cukup atau tidak
                                    if (uang < saldo) {

                                        //saldo cukup
                                        if (mod == 0) {
                                            System.out.println("Silahkan ambil uang anda: ");
                                            for (int i = 1; i <= jumlahlembar; i++) {
                                                System.out.println("Rp" + nominal[objectATM.id_uang - 1]);
                                            }
                                            saldo = saldo - uang;
                                            do {
                                                reload_3 = false;
                                                System.out.println("Transaksi lagi?");
                                                System.out.println("Y/N");
                                                String confirm_2 = input.next();
                                                if (confirm_2.equals("Y") || confirm_2.equals("y")) {
                                                    method.tariktunai();
                                                } else if (confirm_2.equals("N") || confirm_2.equals("n")) {

                                                } else {
                                                    reload_3 = true;
                                                }
                                            } while (reload_3 == true);

                                        } else if (mod != 0) {
                                            System.out.println("Mohon masukkan jumlah uang kelipatan Rp" + nominal[objectATM.id_uang - 1] + " saja.");
                                            reload_2 = true;
                                        }


                                    }

                                    //saldo kurang
                                    else {
                                        System.out.println("Maaf saldo anda tidak cukup");
                                        method.tariktunai();
                                    }
                                } while (reload_2 == true);
                            }

                            //batal
                            else if (confirm_1.equals("N") || confirm_1.equals("n")) {
                                method.tariktunai();
                            } else {
                                reload_1 = true;
                            }
                        } while (reload_1 == true);
                    } else {
                        System.out.println("Pilihan anda tidak terdaftar");
                        method.tariktunai();
                    }
                } while (cancel == true);

            } else if (pilihan == 0) {
                System.out.println("Terimakasih telah menggunakan layanan kami");
                kembali = false;
            } else {
                kembali = true;
            }
        } while (kembali == true);
        
        terimakasih();
    }
}
