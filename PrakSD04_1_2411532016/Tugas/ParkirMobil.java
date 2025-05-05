package Practice;

import java.util.*;

class Mobil {
    String platNomor;

    Mobil(String platNomor) {
        this.platNomor = platNomor;
    }

    public String getPlatNomor() {
        return platNomor;
    }

    @Override
    public String toString() {
        return platNomor;
    }
}

class Parkiran {
    ArrayList<Mobil> daftarMobil;

    public Parkiran() {
        daftarMobil = new ArrayList<>();
        daftarMobil.add(new Mobil("BA1111AA"));
        daftarMobil.add(new Mobil("BA2222BB"));
        daftarMobil.add(new Mobil("BA3333CC"));
        daftarMobil.add(new Mobil("BA4444DD"));
        daftarMobil.add(new Mobil("BA5555EE"));
        daftarMobil.add(new Mobil("BA6666FF"));
        daftarMobil.add(new Mobil("BA7777GG"));
    }

    public void tambahMobil(String platNomor) {
        daftarMobil.add(new Mobil(platNomor));
        System.out.println("Mobil dengan plat " + platNomor + " berhasil ditambahkan.");
    }

    public void keluarkanMobil(String platNomor) {
        boolean ditemukan = false;
        for (int i = 0; i < daftarMobil.size(); i++) {
            if (daftarMobil.get(i).getPlatNomor().equalsIgnoreCase(platNomor)) {
                daftarMobil.remove(i);
                System.out.println("Mobil dengan plat " + platNomor + " berhasil dikeluarkan.");
                ditemukan = true;
                break;
            }
        }
        if (!ditemukan) {
            System.out.println("Mobil dengan plat nomor " + platNomor + ", tidak ditemukan.");
        }
    }

    public void tampilkanParkiran() {
        if (daftarMobil.isEmpty()) {
            System.out.println("Parkiran kosong.");
        } else {
            System.out.println("Daftar mobil di parkiran:");
            for (Mobil mobil : daftarMobil) {
                System.out.println("- " + mobil);
            }
        }
    }

    public void cariMobil(String platNomor) {
        for (Mobil mobil : daftarMobil) {
            if (mobil.getPlatNomor().equalsIgnoreCase(platNomor)) {
                System.out.println("Mobil dengan plat " + platNomor + " ditemukan di parkiran.");
                return;
            }
        }
        System.out.println("Mobil dengan plat " + platNomor + " tidak ditemukan di parkiran.");
    }
}

public class ParkirMobil {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Parkiran parkiran = new Parkiran();
        int pilihan;

        do {
            System.out.println("\n=== Menu Parkiran Mobil ===");
            System.out.println("1. Tambah mobil ke Parkiran");
            System.out.println("2. Keluarkan mobil dari Parkiran");
            System.out.println("3. Tampilkan isi Parkiran");
            System.out.println("4. Cari mobil di Parkiran");
            System.out.println("5. Keluar");
            System.out.print("Pilih Opsi: ");
            pilihan = scanner.nextInt();
            scanner.nextLine(); 

            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan plat nomor mobil: ");
                    String platTambah = scanner.nextLine();
                    parkiran.tambahMobil(platTambah);
                    break;
                case 2:
                    System.out.print("Masukkan plat nomor mobil yang akan dikeluarkan: ");
                    String platKeluar = scanner.nextLine();
                    parkiran.keluarkanMobil(platKeluar);
                    break;
                case 3:
                    parkiran.tampilkanParkiran();
                    break;
                case 4:
                    System.out.print("Masukkan plat nomor mobil yang dicari: ");
                    String platCari = scanner.nextLine();
                    parkiran.cariMobil(platCari);
                    break;
                case 5:
                    System.out.println("Terima kasih! Program selesai.");
                    break;
                default:
                    System.out.println("Opsi tidak valid. Silakan coba lagi.");
            }
        } while (pilihan != 5);

        scanner.close();
    }
}
