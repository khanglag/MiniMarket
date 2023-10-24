/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.mr.fresh_ministore;

import ConnectDB.ConnectDB;

/**
 *
 * @author pc
 */
public class MrFresh_MiniStore {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        ConnectDB cn = new ConnectDB();
        cn.checkConnect();
    }
}
