/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testeverything;

import java.util.Scanner;

/**
 *
 * @author lamit
 */
public class SinhVien {
    private String age;

    public SinhVien() {
        Scanner sc =new Scanner(System.in);
        System.out.print("Nhap tuoi");
        age = sc.nextLine();
    }

    @Override
    public String toString() {
        return "SinhVien{" + "age=" + age + '}';
    }
    
}
