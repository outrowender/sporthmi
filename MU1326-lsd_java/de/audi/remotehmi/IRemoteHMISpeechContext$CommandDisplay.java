/*
 * Decompiled with CFR 0.152.
 */
package de.audi.remotehmi;

public final class IRemoteHMISpeechContext$CommandDisplay {
    public static final byte TYPE_BIG;
    public static final byte TYPE_SMALL;
    public static final byte TYPE_FURTHERCOMMAND;
    public static final byte TYPE_PTTBIG;
    private byte type;
    private String[] message;
    private String messageZeroLines;
    private String messageOneLine;
    private String messageOneLinePrev;
    private String messageOneLinePrevNext;
    private String messageOneLineNext;
    private String messageXLines;
    private String messageXLinesPrev;
    private String messageXLinesNext;
    private String messageXLinesPrevNext;
    private String context;
    private String[] furtherCommands;

    public IRemoteHMISpeechContext$CommandDisplay(String[] stringArray, byte by) {
        this.message = stringArray;
        this.messageZeroLines = "";
        this.messageOneLine = "";
        this.messageXLines = "";
        this.messageOneLinePrevNext = "";
        this.messageOneLineNext = "";
        this.messageOneLinePrev = "";
        this.messageXLinesPrev = "";
        this.messageXLinesNext = "";
        this.messageXLinesPrevNext = "";
        this.furtherCommands = new String[]{""};
        this.type = by;
    }

    public IRemoteHMISpeechContext$CommandDisplay(String[] stringArray, String string, String string2, byte by) {
        this.message = stringArray;
        this.messageOneLine = string;
        this.messageXLines = string2;
        this.messageZeroLines = "";
        this.messageOneLinePrev = "";
        this.messageOneLinePrevNext = "";
        this.messageOneLineNext = "";
        this.messageXLinesPrev = "";
        this.messageXLinesNext = "";
        this.messageXLinesPrevNext = "";
        this.furtherCommands = new String[]{""};
        this.type = by;
    }

    public IRemoteHMISpeechContext$CommandDisplay() {
        this.type = 0;
    }

    public IRemoteHMISpeechContext$CommandDisplay(byte by) {
        this.type = by;
    }

    public byte getType() {
        return this.type;
    }

    public String[] getMessage() {
        return this.message;
    }

    public String getMessageOneLine() {
        return this.messageOneLine;
    }

    public String getMessageXLines() {
        return this.messageXLines;
    }

    public void setZeroLinesPrevMessage(String string) {
        this.messageZeroLines = string;
    }

    public void setMessageOneLine(String string) {
        this.messageOneLine = string;
    }

    public void setMessageXLines(String string) {
        this.messageXLines = string;
    }

    public void setMessage(String[] stringArray) {
        this.message = stringArray;
    }

    public void setType(byte by) {
        this.type = by;
    }

    public void setFurtherCommands(String[] stringArray) {
        this.furtherCommands = stringArray;
    }

    public String getMessageOneLinePrev() {
        return this.messageOneLinePrev;
    }

    public String getMessageOneLinePrevNext() {
        return this.messageOneLinePrevNext;
    }

    public String getMessageOneLineNext() {
        return this.messageOneLineNext;
    }

    public String getMessageXLinesPrev() {
        return this.messageXLinesPrev;
    }

    public String getMessageXLinesNext() {
        return this.messageXLinesNext;
    }

    public String getMessageXLinesPrevNext() {
        return this.messageXLinesPrevNext;
    }

    public String getMessageZeroLines() {
        return this.messageZeroLines;
    }

    public String[] getFurtherCommands() {
        return this.furtherCommands;
    }

    public void setOneLineMessage(String string) {
        this.messageOneLine = string;
    }

    public void setOneLinePrevMessage(String string) {
        this.messageOneLinePrev = string;
    }

    public void setOneLineNextMessage(String string) {
        this.messageOneLineNext = string;
    }

    public void setOneLinePrevNextMessage(String string) {
        this.messageOneLinePrevNext = string;
    }

    public void setXLinesMessage(String string) {
        this.messageXLines = string;
    }

    public void setXLinesPrevMessage(String string) {
        this.messageXLinesPrev = string;
    }

    public void setXLinesNextMessage(String string) {
        this.messageXLinesNext = string;
    }

    public void setXLinesPrevNextMessage(String string) {
        this.messageXLinesPrevNext = string;
    }

    public void setContext(String string) {
        this.context = string;
    }

    public String getContext() {
        return this.context;
    }
}

