/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.core.comfort;

import de.esolutions.fw.util.commons.Buffer;

public class UGDOButtonData {
    private static final String[] LEARNED_STATE_TEXT = new String[]{"UGDOLEARNEDSTATE_IDLE", "UGDOLEARNEDSTATE_LEARNEDWITHPOS", "UGDOLEARNEDSTATE_LEARNEDWITHOUTPOS", "UGDOLEARNEDSTATE_LEARNEDWITHLATERSAVEDPOS", "UGDOLEARNEDSTATE_LEARNEDWITHOUTSYNCDOOR", "UGDOLEARNEDSTATE_FIXKITMODE", "UGDOLEARNEDSTATE_DEFAULTMODE"};
    private static final int NOT_INITIALIZED = -1;
    private int pos;
    private String name;
    private int learnedState;
    private int hardkey;
    private int softkey;

    public UGDOButtonData() {
        this.pos = -1;
        this.name = "";
        this.learnedState = -1;
        this.hardkey = -1;
        this.softkey = -1;
    }

    public UGDOButtonData(int n, String string, int n2, int n3, int n4) {
        this.pos = n;
        this.name = string;
        this.learnedState = n2;
        this.hardkey = n3;
        this.softkey = n4;
    }

    public UGDOButtonData(int n) {
        this.pos = n;
        this.name = "";
        this.learnedState = -1;
        this.hardkey = -1;
        this.softkey = -1;
    }

    public UGDOButtonData(int n, int n2) {
        this.pos = n;
        this.name = "";
        this.learnedState = n2;
        this.hardkey = -1;
        this.softkey = -1;
    }

    public UGDOButtonData(int n, String string) {
        this.pos = n;
        this.name = string;
        this.learnedState = -1;
        this.hardkey = -1;
        this.softkey = -1;
    }

    public int getPos() {
        return this.pos;
    }

    public void setPos(int n) {
        this.pos = n;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String string) {
        this.name = string;
    }

    public int getLearnedState() {
        return this.learnedState;
    }

    public void setLearnedState(int n) {
        this.learnedState = n;
    }

    public int getHardkey() {
        return this.hardkey;
    }

    public void setHardkey(int n) {
        this.hardkey = n;
    }

    public int getSoftkey() {
        return this.softkey;
    }

    public void setSoftkey(int n) {
        this.softkey = n;
    }

    public String toString() {
        Buffer buffer = new Buffer(150);
        buffer.append('\n');
        buffer.append("UGDOButtonListRA_HMI name:");
        buffer.append(this.name);
        buffer.append(" pos:");
        buffer.append(this.pos);
        buffer.append(" hk: ");
        buffer.append(this.hardkey);
        buffer.append(" sk: ");
        buffer.append(this.softkey);
        buffer.append(" learnedState: ");
        if (this.learnedState < LEARNED_STATE_TEXT.length) {
            buffer.append(LEARNED_STATE_TEXT[this.learnedState]);
        } else {
            buffer.append(this.learnedState);
        }
        return buffer.toString();
    }

    public boolean compareContent(Object object) {
        if (object instanceof UGDOButtonData) {
            UGDOButtonData uGDOButtonData = (UGDOButtonData)object;
            if (this.getPos() == uGDOButtonData.getPos() && this.getHardkey() == uGDOButtonData.getHardkey() && this.getSoftkey() == uGDOButtonData.getSoftkey() && this.getLearnedState() == uGDOButtonData.getLearnedState() && this.getName().compareTo(uGDOButtonData.getName()) == 0) {
                return true;
            }
        }
        return false;
    }

    public void changeContent(int n, int n2, int n3, int n4, String string) {
        this.setPos(n);
        this.setHardkey(n2);
        this.setSoftkey(n3);
        this.setLearnedState(n4);
        this.setName(string);
    }
}

