package day01;

import java.util.Random;

public class C01_TCNO {
     /*
            TC kimlik numarasının son rakamı çift olmak zorundadır. 0 rakamı ile başlayamaz.
            ilk 10 rakamın toplamının birler basamağı, 11. rakamı vermektedir.
            Ayrıca; 1, 3, 5, 7 ve 9. rakamın toplamının 7 katı ile 2, 4, 6 ve 8. rakamın toplamının
            9 katının toplamının birler basamağı 10. rakamı; 1, 3, 5, 7 ve 9. rakamın toplamının
            8 katının birler basamağı 11. rakamı vermektedir.
         */

    static Random rnd = new Random();

    public static void main(String[] args) {
        tcNoUret();
    }

    private static void tcNoUret() {

        int tcNo[] = new int[11];
        int tekToplam = 0, ciftToplam = 0, ilkOnToplam = 0;
        boolean kontrol = true;
        while (kontrol) {

            for (int i = 0; i <= 9; i++) {
                tcNo[i] = rnd.nextInt(10);
            }

            for (int i = 0; i <= 8; i += 2) {
                tekToplam += tcNo[i];
            }
            for (int i = 1; i <= 7; i += 2) {
                ciftToplam += tcNo[i];
            }

            //1, 3, 5, 7 ve 9. rakamın toplamının 7 katı ile 2, 4, 6 ve 8. rakamın toplamının 9 katının toplamının birler basamağı 10. rakamı
            tcNo[9] = ((tekToplam * 7) + (ciftToplam * 9)) % 10;

            for (int i = 0; i < 10; i++) {
                ilkOnToplam += tcNo[i];
            }
            //son rakamı çift olmak zorundadır,0 ile baslayamaz,ilk 10 rakamın toplamının birler basamağı,1, 3, 5, 7 ve 9. rakamın toplamının 8 katının birler basamağı 11. rakamı vermektedir.
            if ((ilkOnToplam % 10) == (tekToplam * 8) % 10 && ilkOnToplam % 10 != 0 && ilkOnToplam % 2 == 0) {
                kontrol = false;
            }
        }

        tcNo[10] = ilkOnToplam % 10;
        for (int each : tcNo) {
            System.out.print(each);
        }
    }
}
