/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.event;

import de.audi.atip.hmi.event.ATIPEvent;
import de.audi.atip.hmi.event.ATIPEventListener;

public class SDSEvent
extends ATIPEvent {
    public static final int SDSEvent_FIRST;
    public static final int SDS_COMMAND;
    public static final int SDSEvent_LAST;
    public static final int FIRST;
    public static final int LAST;
    public static final int UP;
    public static final int DOWN;
    public static final int ROW;
    public static final int ROW_ABSOLUTE;
    public static final int ROW_SDS;
    public static final int READ_LINE_ABSOLUTE;
    public static final int READ_LINE;
    public static final int READ_LINE_BY_ID;
    public static final int VALUE_CLEAR_SELECTION;
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
        return new StringBuffer().append("SDSEvent: ResponseType = ").append(this.getResponseType()).append(" SDSCommand = ").append(this.getSDSCommand()).toString();
    }
}

