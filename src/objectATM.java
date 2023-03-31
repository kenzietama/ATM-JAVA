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
ATM.kembali = true;
} else {
System.out.println("Masukkan nominal minimal Rp20.000");
setor();
}
}

}
