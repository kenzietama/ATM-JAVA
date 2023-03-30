public class Function {
    // non-return type dengan parameter
    static void cetak(String kelompok){
        System.out.println(kelompok);
    }

    // non-return type tanpa parameter
    static void cetak1(){
        System.out.println("Hello Praktikan DKP 2023 ^^ ");  }

    // return type dengan parameter
    static String cetak2(String text){
        return text;
    }

    // return type tanpa parameter
    static String cetak3(){
        return "Kali ini kita akan belajar mengenai Function";  }

    public static void main(String[] args) {
        //penggunaan function non-return type dengan mengisikan argument untuk parameter kelompok
        cetak("Kelompok XX");

        //penggunaan function non-return type tanpa parameter
        cetak1();

        //penggunaan function return type dengan mengisikan nilai pada parameter text
        System.out.println(cetak2("Function dengan Return"));

        //penggunaan function return type tanpa parameter
        System.out.println(cetak3());

        //pemanggil method
        Pendefinisi objek = new Pendefinisi();

        objek.greeting();
        objek.kelompok("Kelompok xx");
        String print = objek.kenalan("Faqih", "Tidur");
        System.out.println(print);
    }
}
