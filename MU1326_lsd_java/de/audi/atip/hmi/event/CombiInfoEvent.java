/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.event;

import de.audi.atip.hmi.event.ATIPEvent;
import de.audi.atip.hmi.event.ATIPEventListener;

public class CombiInfoEvent
extends ATIPEvent {
    public static final int TYPE_TEXT_UPDATE;
    public static final int TYPE_CURSOR_UPDATE;
    public static final int TYPE_FRAME_STATUS;
    public static final int TYPE_APPLICATION_CHANGE;
    private int type;
    private String text;
    private int frameID;
    private int cellNo;
    private int cursorPosition;
    private int cursorStyle;
    private int textStyle;
    private int frameRequest;
    private int activeApplication;

    public CombiInfoEvent(ATIPEventListener aTIPEventListener, int n) {
        super(aTIPEventListener, 19001);
    }

    public String toString() {
        return "CombiInfoEvent: toString not implemented yet";
    }

    public int getType() {
        return this.type;
    }

    public void setType(int n) {
        this.type = n;
    }

    public void setText(String string) {
        this.text = string;
    }

    public String getText() {
        return this.text;
    }

    public void setFrameID(int n) {
        this.frameID = n;
    }

    public int getFrameID() {
        return this.frameID;
    }

    public void setCellNo(int n) {
        this.cellNo = n;
    }

    public int getCellNo() {
        return this.cellNo;
    }

    public void setCursorPosition(int n) {
        this.cursorPosition = n;
    }

    public int getCursorPosition() {
        return this.cursorPosition;
    }

    public void setCursorStyle(int n) {
        this.cursorStyle = n;
    }

    public int getCursorStyle() {
        return this.cursorStyle;
    }

    public void setTextStyle(int n) {
        this.textStyle = n;
    }

    public int getTextStyle() {
        return this.textStyle;
    }

    public void setFrameRequest(int n) {
        this.frameRequest = n;
    }

    public int getFrameRequest() {
        return this.frameRequest;
    }

    public int getActiveApplication() {
        return this.activeApplication;
    }

    public void setActiveApplication(int n) {
        this.activeApplication = n;
    }
}

