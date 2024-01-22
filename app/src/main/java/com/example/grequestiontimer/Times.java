package com.example.grequestiontimer;

import java.util.ArrayList;

public class Times {

    private static ArrayList<Times> secondsArrayList;

    private int id;
    private String Seconds_Interval;

    public Times(int id, String seconds_Interval) {
        this.id = id;
        this.Seconds_Interval = seconds_Interval;
    }

    public static void initSeconds()
    {
        secondsArrayList = new ArrayList<>();

        Times ten = new Times(0, "10");
        secondsArrayList.add(ten);

        Times twenty = new Times(1, "20");
        secondsArrayList.add(twenty);

        Times thirty = new Times(2, "30");
        secondsArrayList.add(thirty);

        Times forty = new Times(3, "40");
        secondsArrayList.add(forty);

        Times fifty = new Times(4, "50");
        secondsArrayList.add(fifty);

        Times sixty = new Times(5, "60");
        secondsArrayList.add(sixty);

        Times seventy = new Times(6, "70");
        secondsArrayList.add(seventy);

        Times eighty = new Times(7, "80");
        secondsArrayList.add(eighty);

        Times ninety = new Times(8, "90");
        secondsArrayList.add(ninety);

        Times hundred = new Times(9, "100");
        secondsArrayList.add(hundred);

        Times hundred_ten = new Times(10, "110");
        secondsArrayList.add(hundred_ten);

        Times hundred_twenty = new Times(11, "120");
        secondsArrayList.add(hundred_twenty);

    }

    public static ArrayList<Times> getSecondsArrayList() {
        return secondsArrayList;
    }

    public static String[] TImeSeconds()
    {
        String[] seconds = new String[secondsArrayList.size()];
        for(int i=0; i<secondsArrayList.size(); i++)
        {
            seconds[i] = secondsArrayList.get(i).Seconds_Interval;
        }
        return seconds;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSeconds_Interval() {
        return Seconds_Interval;
    }

    public void setSeconds_Interval(String seconds_Interval) {
        Seconds_Interval = seconds_Interval;
    }
}
