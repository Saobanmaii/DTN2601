package frontend;

import backend.QLAccount;
import backend.QLDepartment;
import backend.QLPosition;

public class Prg {

    public static void main(String[] args) {
        new QLDepartment().printAll();
        System.out.println();
        new QLPosition().printAll();
        System.out.println();
        new QLAccount().printAll();
    }
}

