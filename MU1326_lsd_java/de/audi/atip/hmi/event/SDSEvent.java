/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.event;

import de.audi.atip.hmi.event.ATIPEvent;
import de.audi.atip.hmi.event.ATIPEventListener;

public class SDSEvent
extends ATIPEvent {
    public static final int SDSEvent_FIRST = 10701;
    public static final int SDS_COMMAND = 10701;
    public static final int SDSEvent_LAST = 10701;
    public static final int FIRST = 1;
    public static final int LAST = 2;
    public static final int UP = 3;
    public static final int DOWN = 4;
    public static final int ROW = 5;
    public static final int ROW_ABSOLUTE = 6;
    public static final int ROW_SDS = 7;
    public static final int READ_LINE_ABSOLUTE = 8;
    public static final int READ_LINE = 9;
    public static final int READ_LINE_BY_ID = 10;
    public static final int VALUE_CLEAR_SELECTION = 11;
    private int responseType;
    private int sdsCommand;
    private int value;
    private int[] answers;

    public SDSEvent(ATIPEventListener aTIPEventListener, int n, int n2, int n3) {
        super(aTIPEventListener, n);
        this.responseType = n2;
        this.sdsCommand = n3;
    }

    public SDSEvent(ATIPEventListener aTIPEventListener, int n, int n2, int n3, int n4, int[] nArray) {
        super(aTIPEventListener, n);
        this.responseType = n2;
        this.sdsCommand = n3;
        this.value = n4;
        this.answers = nArray;
    }

    public int getResponseType() {
        return this.responseType;
    }

    public void setResponseType(int n) {
        this.responseType = n;
    }

    public int getSDSCommand() {
        return this.sdsCommand;
    }

    public void setSDSCommand(int n) {
        this.sdsCommand = n;
    }

    public int getValue() {
        return this.value;
    }

    public void setValue(int n) {
        this.value = n;
    }

    public int[] getAnswers() {
        return this.answers;
    }

    public String toString() {
        return "SDSEvent: ResponseType = " + this.getResponseType() + " SDSCommand = " + this.getSDSCommand();
    }
}

