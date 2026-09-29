/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.mmicombi.exchange;

import de.audi.atip.mmicombi.exchange.IMMICombiDisplayExchangePacket;
import de.audi.atip.mmicombi.exchange.MMICombiDisplayStatus;

public abstract class MMICombiDisplayExchangePacket
implements IMMICombiDisplayExchangePacket {
    public static final int FOCUS_CHANGED;
    public static final int CONTEXT_CHANGED;
    public static final int VIEW_SIZE_CHANGED;
    public static final int LEFT_DRAWER_STATE_CHANGED;
    public static final int RIGHT_DRAWER_STATE_CHANGED;
    public static final int PARTIAL_POPUP_VISIBLE_CHANGED;
    public static final int SECOND_STATUS_LINE_VISIBLE_CHANGED;
    public static final int POPUP_CONTEXT_CHANGED;
    public static final int POPUP_QUIT_CHANGED;
    int sessionID;
    int exchangeDirection;
    MMICombiDisplayStatus displayStatus;

    public MMICombiDisplayExchangePacket(int n, int n2, MMICombiDisplayStatus mMICombiDisplayStatus) {
        this.sessionID = n;
        this.exchangeDirection = n2;
        this.displayStatus = mMICombiDisplayStatus;
    }

    public MMICombiDisplayExchangePacket(IMMICombiDisplayExchangePacket iMMICombiDisplayExchangePacket) {
        this.sessionID = iMMICombiDisplayExchangePacket.getSessionID();
        this.exchangeDirection = iMMICombiDisplayExchangePacket.getExchangeDirection();
        this.displayStatus = iMMICombiDisplayExchangePacket.getDisplayStatus();
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
    public void setDisplayStatus(MMICombiDisplayStatus mMICombiDisplayStatus) {
        this.displayStatus = mMICombiDisplayStatus;
    }

    @Override
    public MMICombiDisplayStatus getDisplayStatus() {
        return this.displayStatus;
    }

    public int getChangesToStatus(MMICombiDisplayStatus mMICombiDisplayStatus) {
        int n = 0;
        if (this.displayStatus.getFocus() != mMICombiDisplayStatus.getFocus()) {
            n |= 1;
        }
        if (this.displayStatus.getMainContext() != mMICombiDisplayStatus.getMainContext()) {
            n |= 2;
        }
        if (this.displayStatus.getPopupContext() != mMICombiDisplayStatus.getPopupContext()) {
            n |= 0x80;
        }
        if (this.displayStatus.getViewSize() != mMICombiDisplayStatus.getViewSize()) {
            n |= 4;
        }
        if (this.displayStatus.isLeftDrawerOpen() != mMICombiDisplayStatus.isLeftDrawerOpen()) {
            n |= 8;
        }
        if (this.displayStatus.isRightDrawerOpen() != mMICombiDisplayStatus.isRightDrawerOpen()) {
            n |= 0x10;
        }
        if (this.displayStatus.isPartialPopupVisible() != mMICombiDisplayStatus.isPartialPopupVisible()) {
            n |= 0x20;
        }
        if (this.displayStatus.isSecondStatusLineVisible() != mMICombiDisplayStatus.isSecondStatusLineVisible()) {
            n |= 0x40;
        }
        return n;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(46);
        stringBuffer.append("sessionID=");
        stringBuffer.append(this.sessionID);
        stringBuffer.append(", exchangeDirection=");
        stringBuffer.append(this.exchangeDirection);
        stringBuffer.append(", displayStatus=");
        stringBuffer.append(this.displayStatus);
        return stringBuffer.toString();
    }
}

