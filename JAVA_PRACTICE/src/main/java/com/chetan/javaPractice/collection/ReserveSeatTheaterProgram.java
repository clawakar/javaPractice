package com.chetan.javaPractice.collection;

import java.util.ArrayList;
import java.util.List;

public class ReserveSeatTheaterProgram {
    public static void main(String [] args) {
        Theatre th = new Theatre("Tulsi", 12, 20);
        th.reserveSeat("B-12");

        th.reserveSeat("B-12");

        th.reserveSeat("B-12");
    }

}

class Theatre {
    private String theatreName;
    private List<Seat> seatList = new ArrayList<Seat>();

    Theatre(String theatreName, int numOfRows, int numOfseatsPerRow) {
        this.theatreName = theatreName;
        for(char i = 'A' ; i < ('A' + numOfRows - 1); i++) {
            for(int j= 1; j < numOfseatsPerRow ; j++) {
                Seat seat = new Seat(i + "-"+ j);
                seatList.add(seat);
            }
        }
    }

    public String getTheatreName() {
        return theatreName;
    }

    public void setTheatreName(String theatreName) {
        this.theatreName = theatreName;
    }

    boolean reserveSeat(String seatNum) {

        if (seatNum == null) {
            return false;
        }

        for(Seat s : seatList) {
            if(s.getSeatNum().equals(seatNum)) {
                return s.reserveSeat();
            }
        }

        return false;
    }

    boolean calcelSeat(String seatNum) {
        if(seatNum == null) {
            System.out.println("provided null seat name, provide valid seatNum");
            return false;
        }

        for (Seat s : seatList) {
            if (s.getSeatNum().equals(seatNum)) {
                return s.cancelSeat();
            }
        }

        System.out.println("provide valid seatNum");
        return false;
    }

}

class Seat {
    private String seatNum ;
    private boolean reserve = false;

    Seat(String seatNum) {
        this.seatNum = seatNum;
    }

    public String getSeatNum() {
        return seatNum;
    }

    public void setSeatNum(String seatNum) {
        this.seatNum = seatNum;
    }

    boolean reserveSeat() {
        if(!reserve) {
            reserve = true;
            System.out.println(this.seatNum + " is reserved successfuly");
            return true;
        } else {
            System.out.println(this.seatNum + " is not available (already in reserved state) hence cannot be reserved");
            return false;
        }
    }

    boolean cancelSeat() {
        if(reserve) {
            reserve = false;
            System.out.println(this.seatNum + "is canceled successfuly");
            return true;
        } else {
            System.out.println(this.seatNum + "is already in canceled state");
            return false;
        }
    }

}