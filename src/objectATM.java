import java.util.Scanner;

public class objectATM {
    public void setor(){
        boolean ulangi;
        Scanner input = new Scanner(System.in);

        System.out.println("Masukkan jumlah uang yang ingin anda setor:");
        do {
            ulangi = false;
            Integer setor = input.nextInt();
            if (setor >= 20000) {
                saldo = saldo + setor;
                ulangisetor = false;
                System.out.println("Saldo anda sekarang Rp" + saldo);
                kembali = true;
            } else {
                System.out.println("Masukkan nominal minimal Rp20.000");
                ulangisetor = true;
            }
        } while (ulangisetor == true);
    }
}
