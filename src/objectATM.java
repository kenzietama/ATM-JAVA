import java.util.Scanner;

public class objectATM {
    public static int id_uang;
    public void setor() {
//method non return tanpa parameter
Scanner input = new Scanner(System.in);
Integer setor = input.nextInt();
if (setor >= 20000) {
ATM.saldo = ATM.saldo + setor;
System.out.println("Saldo anda sekarang Rp" + ATM.saldo);
/*ATM.kembali = true;*/
} else {
System.out.println("Masukkan nominal minimal Rp20000");
setor();
}
}
    public void tariktunai() {
        Scanner masuk = new Scanner(System.in);
        //jumlah saldo nasabah
        System.out.println("Saldo : Rp" + ATM.saldo);

        //pecahan mata uang tersedia
        System.out.println("Pecahan uang yang tersedia :");
        for (int id = 0; id <= 2; id++) {
            System.out.println(id + 1 + ". " + "Rp" + ATM.nominal[id]);
        }

        //pilih pecahan uang
        System.out.println("Gunakan angka (1-3) untuk memilih denominasi uang, 0 untuk membatalkan");
        id_uang = masuk.nextInt();
        ATM.cancel = true;
    }
    public void transaksilagi() {
        do {
            Scanner in = new Scanner(System.in);
            ATM.reload_3 = false;
            System.out.println("Transaksi lagi?");
            System.out.println("Y/N");
            String confirm_2 = in.next();
            if (confirm_2.equals("Y") || confirm_2.equals("y")) {
                /*method.tariktunai();*/
                ATM.kembali = true;
            } else if (confirm_2.equals("N") || confirm_2.equals("n")) {
                System.out.println(ATM.terimakasih());
                ATM.kembali = false;
            } else {
                ATM.reload_3 = true;
            }
        } while (ATM.reload_3 == true);
    }
}
