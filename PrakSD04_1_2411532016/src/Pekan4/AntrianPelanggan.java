package tugeh;


import java.util.Scanner;

class Pelanggan {
    String id;
    int jumlahPesanan;

    Pelanggan(String id, int jumlahPesanan) {
        this.id = id;
        this.jumlahPesanan = jumlahPesanan;
    }
}

public class AntrianPelanggan {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine()); 
        Pelanggan[] queue = new Pelanggan[n];
        int front = 0, rear = 0;

        for (int i = 0; i < n; i++) {
            String[] data = scanner.nextLine().split(" ");
            String id = data[0];
            int jumlahPesanan = Integer.parseInt(data[1]);
            queue[rear++] = new Pelanggan(id, jumlahPesanan);
        }

        int waktu = 0;

        while (front < rear) {
            Pelanggan p = queue[front++];
            waktu += p.jumlahPesanan;
            System.out.println(p.id + " selesai dalam " + waktu + " menit");
        }

        scanner.close();
    }
}


