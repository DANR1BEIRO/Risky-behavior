package test.washing_machine;

import test.washing_machine.exception.LingerieException;
import test.washing_machine.exception.PantsException;
import test.washing_machine.model.Laundry;

public class WashingMachine {
    public static void main(String[] args) {
        go();
    }

    public static void go() {
        Laundry laundry = new Laundry();
        try {
            laundry.doLaundry();
            System.out.println();
        } catch (PantsException e) {
            // recovery code
        } catch (LingerieException e) {
            // recovery code
        }
    }
}

