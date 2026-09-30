/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.common.util;

public class TimerObject {
    private int year;
    private int month;
    private int day;
    private int hour;
    private int minute;
    private int second;

    public TimerObject(int n, int n2, int n3, int n4, int n5, int n6) {
        this.year = n;
        this.month = n2;
        this.day = n3;
        this.hour = n4;
        this.minute = n5;
        this.second = n6;
    }

    public TimerObject() {
        this.year = 0;
        this.month = 0;
        this.day = 0;
        this.hour = 0;
        this.minute = 0;
        this.second = 0;
    }

    public int getYear() {
        return this.year;
    }

    public void setYear(int n) {
        this.year = n;
    }

    public int getMonth() {
        return this.month;
    }

    public void setMonth(int n) {
        this.month = n;
    }

    public int getDay() {
        return this.day;
    }

    public void setDay(int n) {
        this.day = n;
    }

    public int getHour() {
        return this.hour;
    }

    public void setHour(int n) {
        this.hour = n;
    }

    public int getMinute() {
        return this.minute;
    }

    public void setMinute(int n) {
        this.minute = n;
    }

    public int getSecond() {
        return this.second;
    }

    public void setSecond(int n) {
        this.second = n;
    }

    public String toString() {
        return "TimerObject [year=" + this.year + ", month=" + this.month + ", day=" + this.day + ", hour=" + this.hour + ", minute=" + this.minute + ", second=" + this.second + "]";
    }
}

