/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data.mahasiswa;

import java.util.Scanner;
import java.util.Date;
import java.util.ArrayList;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

public class Mahasiswa {
    Scanner input = new Scanner(System.in);
    ArrayList<String> Nama = new ArrayList<>();
    ArrayList<String> Nim = new ArrayList<>();
    ArrayList<Date> Tgllahir = new ArrayList<>();
    ArrayList<Integer> Gender = new ArrayList<>();    
    SimpleDateFormat formatter = new SimpleDateFormat("dd/mm/yyyy");
    
    void tambahData(){
        String nama;
        String nim;
        Integer gender;
        int hari, bulan, tahun;
        
        System.out.println("Masukkan Data Mahasiswa : ");
        System.out.println("Nama    : ");
        nama = input.nextLine();
        System.out.println("NIM     : ");
        nim = input.nextLine();
        System.out.println("Tanggal Lahir (dd/yy/mmmm) : ");
        System.out.println("Tanggal : ");
        hari = input.nextInt();
        System.out.println("Bulan   : ");
        bulan = input.nextInt();
        System.out.println("Tahun   : ");
        tahun = input.nextInt();
        Date tgl = new GregorianCalendar(tahun, bulan - 1, hari).getTime();
        System.out.println("Gender (0:perempuan 1:laki-laki) : ");
        gender = input.nextInt();
        Nama.add(nama);
        Nim.add(nim);
        Tgllahir.add(tgl);
        Gender.add(gender);
        
        System.out.println("Apakah Anda Ingin Menambah Data Lagi ?\n1. Iya \n2. Tidak");
        int jawab = input.nextInt();
        
        if(jawab == 1){
            tambahData();
        }
        else{
            System.out.println("Terima Kasih");
        }
    }
    
    void hapusData(){
        if(Nim.size() > 0){
            System.out.print("Masukkan NIM: ");
            String hapus = input.nextLine();
            int index = Nim.indexOf(hapus);
            if(index < 0){
                System.out.println("Tidak ada Data");
            }else{
                Nim.remove(index);
                Nama.remove(index);
                Tgllahir.remove(index);
                Gender.remove(index);
            }
        }else {
            System.out.println("Tidak ada Data.");
        }  
    }
    
    void cariData(){
        System.out.println("Cari Berdasarkan : ");
        System.out.println("1. NIM");
        System.out.println("2. Gender");
        int pilih = input.nextInt();
        if (pilih == 1){
            for (String n: Nim) {
                System.out.println("Masukan NIM : ");
                String cari = input.nextLine();
                if(Nim.contains(cari)){
                    int index = Nim.indexOf(cari);
                    String tgl = formatter.format(Tgllahir.get(index));
                    String jenis = Gender.get(index)== 0 ? "Perempuan" : "laki-laki";
                    System.out.println("Nama    : " + Nama.get(index));
                    System.out.println("NIM     : " + Nim.get(index));
                    System.out.println("Tanggal lahir   : " + tgl);
                    System.out.println("Gender  : " + jenis);
                    break;
                }else{
                    System.out.println("Maaf Data yang Anda Masukkan Salah");
                    break;
                }
            }
        }else if(pilih == 2){
            System.out.println("Masukan Gender (0:Perempuan 1:laki-laki) : ");
            int cari2 = input.nextInt();
            for (int i=0; i<Gender.size(); i++){
                if(Gender.contains(cari2)){
                    String tgl = formatter.format(Tgllahir.get(i));
                    String jenis = Gender.get(i)== 0 ? "Perempuan" : "laki-laki";
                    System.out.println("Nama    : " + Nama.get(i));
                    System.out.println("NIM     : " + Nim.get(i));
                    System.out.println("Tanggal lahir   : " + tgl);
                    System.out.println("Gender  : " + jenis);
                    break;
                }else{
                    System.out.println("Maaf Data yang Anda Masukkan Salah");
                    break;
                }
            }
        }else{
            System.out.println("Maaf Data yang Anda Masukkan Salah");
        }
    }
    
    void tampilkanData(){
        if (Nim.size() == 0){
            System.out.println("Maaf Tidak Ada Data yang Tersedia");
        }else{
            for(int i=0; i<Nim.size(); i++){
                String tgl = formatter.format(Tgllahir.get(i));
                String jenis = Gender.get(i)== 0 ? "Perempuan" : "laki-laki";
                System.out.println("Mahasiswa " + (i+1));
                System.out.println("Nama    : " + Nama.get(i));
                System.out.println("NIM     : " + Nim.get(i));
                System.out.println("Tanggal Lahir   : " + tgl);
                System.out.println("Gender  : " + jenis);
            }
            System.out.println("Jumlah Mahasiswa : " + Nim.size());
        }
    }
    
    void menu(){
        int menu;
        System.out.println("Menu Program:");
        System.out.println("1. Tambah Data");
        System.out.println("2. Hapus Data");
        System.out.println("3. Cari Data");
        System.out.println("4. Tampilkan Data");
        System.out.println("Pilih Menu : ");
        int pilih1 = input.nextInt();
        if (pilih1 == 1){
            tambahData();
        }
        else if (pilih1 == 2){
            hapusData();
        }
        else if (pilih1 == 3){
            cariData();
        }
        else if (pilih1 == 4){
            tampilkanData();
        }
        else{
            System.out.println("Maaf Menu yang Anda Masukkan Salah");
        }
    }
}
