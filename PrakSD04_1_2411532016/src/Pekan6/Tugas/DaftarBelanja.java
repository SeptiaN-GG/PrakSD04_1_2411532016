package Pekan6;

import java.util.Scanner;

public class DaftarBelanja {
	private Node head;
    private Node tail;

    public void tambahItem(String nama, int kuantitas, String kategori) {
        ItemBelanja item = new ItemBelanja(nama, kuantitas, kategori);
        Node newNode = new Node(item);

        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        System.out.println("Item berhasil ditambahkan!");
    }

    public void hapusItem(String nama) {
        Node current = head;

        while (current != null) {
            if (current.data.nama.equalsIgnoreCase(nama)) {
                if (current == head && current == tail) {
                    head = tail = null;
                } else if (current == head) {
                    head = head.next;
                    head.prev = null;
                } else if (current == tail) {
                    tail = tail.prev;
                    tail.next = null;
                } else {
                    current.prev.next = current.next;
                    current.next.prev = current.prev;
                }

                System.out.println("Item berhasil dihapus.");
                return;
            }
            current = current.next;
        }

        System.out.println("Item tidak ditemukan.");
    }

    public void tampilkanSemuaItem() {
        if (head == null) {
            System.out.println("Daftar belanja kosong.");
            return;
        }

        System.out.println("--- Daftar Belanja ---");
        Node current = head;
        while (current != null) {
            System.out.println("- " + current.data.nama + " (" + current.data.kuantitas + ") [" + current.data.kategori + "]");
            current = current.next;
        }
    }

    public void tampilkanPerKategori(String kategori) {
        boolean ditemukan = false;
        Node current = head;
        System.out.println("--- Item dalam kategori '" + kategori + "' ---");
        while (current != null) {
            if (current.data.kategori.equalsIgnoreCase(kategori)) {
                System.out.println("- " + current.data.nama + " (" + current.data.kuantitas + ")");
                ditemukan = true;
            }
            current = current.next;
        }

        if (!ditemukan) {
            System.out.println("Tidak ada item dalam kategori ini.");
        }
    }

    public void cariItem(String nama) {
        Node current = head;
        while (current != null) {
            if (current.data.nama.equalsIgnoreCase(nama)) {
                System.out.println("Item ditemukan: " + current.data.nama + " (" + current.data.kuantitas + ") [" + current.data.kategori + "]");
                return;
            }
            current = current.next;
        }

        System.out.println("Item tidak ditemukan.");
    }


public static void main(String[] args) {
	
	System.out.println("Nama : Kadai Septian Riyanda Putra");
	System.out.println("Nim : 2411532016");	
	
    Scanner scanner = new Scanner(System.in);
    DaftarBelanja daftar = new DaftarBelanja();
    int pilihan;

    do {
        System.out.println("\n=== MENU DAFTAR BELANJA ===");
        System.out.println("1. Tambah Item");
        System.out.println("2. Hapus Item");
        System.out.println("3. Tampilkan Semua Item");
        System.out.println("4. Tampilkan Item Berdasarkan Kategori");
        System.out.println("5. Cari Item");
        System.out.println("6. Keluar");
        System.out.print("Pilih menu: ");
        pilihan = scanner.nextInt();
        scanner.nextLine();

        switch (pilihan) {
            case 1:
                System.out.print("Masukkan nama item: ");
                String nama = scanner.nextLine();
                System.out.print("Masukkan kuantitas: ");
                int kuantitas = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Masukkan kategori: ");
                String kategori = scanner.nextLine();
                daftar.tambahItem(nama, kuantitas, kategori);
                break;
            case 2:
                System.out.print("Masukkan nama item yang ingin dihapus: ");
                String hapus = scanner.nextLine();
                daftar.hapusItem(hapus);
                break;
            case 3:
                daftar.tampilkanSemuaItem();
                break;
            case 4:
                System.out.print("Masukkan kategori: ");
                String kat = scanner.nextLine();
                daftar.tampilkanPerKategori(kat);
                break;
            case 5:
                System.out.print("Masukkan nama item yang ingin dicari: ");
                String cari = scanner.nextLine();
                daftar.cariItem(cari);
                break;
            case 6:
                System.out.println("Terima kasih!");
                break;
            default:
                System.out.println("Pilihan tidak valid.");
        }

    } while (pilihan != 6);
}
}

