/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wofieballdraftkit.data;

/**
 *
 * @author MiChAeL
 */
public class Pitcher extends Player {
   int w;
   int k;
   int sv;

 
   int h;
   double IP;


   double ERA;
   double WHIP;
   
    String lastName;
    String firstName; 
   
   
   
   public Pitcher(String ln, String fn){
   super();
   lastName = ln;
   firstName = fn;
   }
   
    public double getIP() {
        return IP;
    }

    public void setIP(double IP) {
        this.IP = IP;
    }
   
   
   
    public int getW() {
        return w;
    }

    public void setW(int w) {
        this.w = w;
    }

    public int getK() {
        return k;
    }

    public void setK(int k) {
        this.k = k;
    }

    public int getSv() {
        return sv;
    }

    public void setSv(int sv) {
        this.sv = sv;
    }

    public double getERA() {
        return ERA;
    }

    public void setERA(double ERA) {
        this.ERA = ERA;
    }

    public double getWHIP() {
        return WHIP;
    }

    public void setWHIP(double WHIP) {
        this.WHIP = WHIP;
    }
   public int getH() {
        return h;
    }

    public void setH(int h) {
        this.h = h;
    }
   
   
}
