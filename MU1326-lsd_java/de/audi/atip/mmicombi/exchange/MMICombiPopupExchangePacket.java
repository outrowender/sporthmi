/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.mmicombi.exchange;

import de.audi.atip.mmicombi.exchange.IMMICombiPopupExchangePacket;

public abstract class MMICombiPopupExchangePacket
implements IMMICombiPopupExchangePacket {
    private int exchangeDirection;
    private int sessionID;
    private int popupID;
    private int prio;
    private int slotID;
    private int screenFormat;
    private int focus;

    public MMICombiPopupExchangePacket(int n, int n2, int n3, int n4, int n5, int n6) {
        this.sessionID = n;
        this.popupID = n2;
        this.prio = n3;
        this.slotID = n4;
        this.screenFormat = n5;
        this.focus = n6;
    }

    @Override
    public void setSessionID(int n) {
        this.sessionID = n;
    }

    @Override
    public int getSessionID() {
        return this.sessionID;
    }

    @Override
    public void setExchangeDirection(int n) {
        this.exchangeDirection = n;
    }

    @Override
    public int getExchangeDirection() {
        return this.exchangeDirection;
    }

    @Override
    public void setPopupID(int n) {
        this.popupID = n;
    }

    @Override
    public int getPopupID() {
        return this.popupID;
    }

    public int getPrio() {
        return this.prio;
    }

    public int getSlotID() {
        return this.slotID;
    }

    public int getScreenFormat() {
        return this.screenFormat;
    }

    public int getFocus() {
        return this.focus;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(79);
        stringBuffer.append("sessionID=");
        stringBuffer.append(this.sessionID);
        stringBuffer.append(", exchangeDirection=");
        stringBuffer.append(this.exchangeDirection);
        stringBuffer.append(", popupID=");
        stringBuffer.append(this.popupID);
        stringBuffer.append(", prio=");
        stringBuffer.append(this.prio);
        stringBuffer.append(", slotID=");
        stringBuffer.append(this.slotID);
        stringBuffer.append(", screenFormat=");
        stringBuffer.append(this.screenFormat);
        stringBuffer.append(", focus=");
        stringBuffer.append(this.focus);
        return stringBuffer.toString();
    }
}

