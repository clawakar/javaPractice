package com.chetan.javaPractice;

import java.io.File;

public class Printer {
    private boolean duplex;
    private Integer tonerLevel;
    private Integer numberOfPagesPrinted;

    public Integer getTonerLevel() {
        return tonerLevel;
    }

    public Integer getNumberOfPagesPrinted() {
        return numberOfPagesPrinted;
    }

    public Printer(boolean duplex, Integer tonerLevel) {
        this.duplex = duplex;
        if(tonerLevel <= 0 || tonerLevel >= 100) {
            tonerLevel = -1;
        }
        else {
            this.tonerLevel = tonerLevel;
        }
    }

    public boolean isDuplex() {
        return duplex;
    }

    public boolean print(File dataToBeprinted, Integer numberOfPagesToBePrinted) {
        System.out.println("Printing data started");
        if((reduceTonerlevel(numberOfPagesToBePrinted)) <= 0) {
            System.out.println("Please add toner");
            return false;
        }
        System.out.println("Printing data completed");
        return true;

    }

    public Integer reduceTonerlevel(Integer numberOfPagesPrinted) {
        tonerLevel -= (numberOfPagesPrinted /10);
        return tonerLevel;
    }

    public void fillToner() {
        System.out.println("Filling toner");
        this.tonerLevel = 100;
    }
}
