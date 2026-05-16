package frontend;

import backend.controller.AccountController;
import backend.controller.DepartmentController;
import backend.controller.PositionController;

public class Prg {

    public static void main(String[] args) {
        new DepartmentController().printAll();
        System.out.println();
        new PositionController().printAll();
        System.out.println();
        new AccountController().printAll();
    }
}

