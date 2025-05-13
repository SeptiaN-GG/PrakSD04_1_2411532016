package Practice;


	import java.util.Scanner;
	import java.util.Stack;

	class Buku {
	    String judul;

	    public Buku(String judul) {
	        this.judul = judul;
	    }

	    @Override
	    public String toString() {
	        return judul;
	    }
	}

	class PerpustakaanMini {
	    Stack<Buku> tumpukanBuku = new Stack<>();

	    void tambahBuku(Buku buku) {
	        tumpukanBuku.push(buku);
	        System.out.println("Buku \"" + buku.judul + "\" berhasil ditambahkan ke tumpukan.");
	    }

	    void ambilBuku() {
	        if (!tumpukanBuku.isEmpty()) {
	            Buku buku = tumpukanBuku.pop();
	            System.out.println("Buku diambil: " + buku.judul);
	        } else {
	            System.out.println("Tumpukan kosong, tidak ada buku untuk diambil.");
	        }
	    }

	    void lihatTumpukan() {
	        if (tumpukanBuku.isEmpty()) {
	            System.out.println("Tumpukan buku kosong.");
	        } else {
	            System.out.println("Tumpukan Buku Saat Ini:");
	            for (int i = tumpukanBuku.size() - 1; i >= 0; i--) {
	                System.out.println("- " + tumpukanBuku.get(i).judul);
	            }
	        }
	    }

	    void cariBuku(String judul) {
	        boolean ditemukan = false;
	        for (Buku buku : tumpukanBuku) {
	            if (buku.judul.equalsIgnoreCase(judul)) {
	                ditemukan = true;
	                break;
	            }
	        }
	        if (ditemukan) {
	            System.out.println("Buku \"" + judul + "\" ditemukan dalam tumpukan.");
	        } else {
	            System.out.println("Buku \"" + judul + "\" tidak ditemukan dalam tumpukan.");
	        }
	    }
	}

	public class BukuPerpustakaan {
	    public static void main(String[] args) {
	        PerpustakaanMini p = new PerpustakaanMini();
	        Scanner s = new Scanner(System.in);

	        p.tambahBuku(new Buku("Algoritma Dasar"));
	        p.tambahBuku(new Buku("Struktur Data"));
	        p.tambahBuku(new Buku("Basis Data"));
	        p.tambahBuku(new Buku("Pemrograman Java"));
	        p.tambahBuku(new Buku("Jaringan Komputer"));
	        p.tambahBuku(new Buku("Sistem Operasi"));
	        p.tambahBuku(new Buku("Kecerdasan Buatan"));

	        int pilihan;
	        do {
	            System.out.println("\n=== MENU PERPUSTAKAAN MINI ===");
	            System.out.println("1. Tambah Buku ke Tumpukan");
	            System.out.println("2. Ambil Buku Teratas");
	            System.out.println("3. Lihat Tumpukan Buku");
	            System.out.println("4. Cari Buku");
	            System.out.println("5. Keluar");
	            System.out.print("Pilihan: ");
	            pilihan = s.nextInt();
	            s.nextLine(); 

	            switch (pilihan) {
	                case 1:
	                    System.out.print("Masukkan Judul Buku: ");
	                    String judul = s.nextLine();
	                    p.tambahBuku(new Buku(judul));
	                    break;
	                case 2:
	                    p.ambilBuku();
	                    break;
	                case 3:
	                    p.lihatTumpukan();
	                    break;
	                case 4:
	                    System.out.print("Masukkan Judul Buku yang Dicari: ");
	                    String cari = s.nextLine();
	                    p.cariBuku(cari);
	                    break;
	                case 5:
	                    System.out.println("Keluar dari program...");
	                    break;
	                default:
	                    System.out.println("Pilihan tidak valid.");
	            }

	        } while (pilihan != 5);

	        s.close();
	    }
	}

