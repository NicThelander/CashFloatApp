package nic.test;

// An early attempt at a app with a GUI, made for the work PCs at the retails store I work at because
// the app that was previously used kept crashing. I used JSmooth to package it with a portable jre so
// that no installs were required.

public class Main {

    public static void main(String[] args) {
        CashFloatWindow cashFloat = new CashFloatWindow();
        cashFloat.getFrameCaller();
    }
}
