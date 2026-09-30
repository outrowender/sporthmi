/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.mmicombi.exchange;

import de.audi.atip.mmicombi.exchange.IMMICombiDisplayExchangePacket;
import de.audi.atip.mmicombi.exchange.MMICombiDisplayExchangePacket;
import de.audi.atip.mmicombi.exchange.MMICombiDisplayStatus;
import de.audi.atip.mmicombi.exchange.MMICombiRequestAnimationInfo;

public class MMICombiRequest
extends MMICombiDisplayExchangePacket {
    private int requestedChanges = 0;
    private boolean popupQuit = false;
    private MMICombiRequestAnimationInfo animationInfo;
    private boolean lastmodeRequest;
    private boolean lvdsLock;

    public MMICombiRequest(int n, int n2, MMICombiDisplayStatus mMICombiDisplayStatus, MMICombiRequestAnimationInfo mMICombiRequestAnimationInfo, boolean bl, boolean bl2) {
        super(n, n2, mMICombiDisplayStatus);
        this.animationInfo = mMICombiRequestAnimationInfo;
        this.lastmodeRequest = bl;
        this.lvdsLock = bl2;
    }

    public MMICombiRequest(int n, int n2, MMICombiDisplayStatus mMICombiDisplayStatus) {
        this(n, n2, mMICombiDisplayStatus, new MMICombiRequestAnimationInfo(), false, false);
    }

    public MMICombiRequest(IMMICombiDisplayExchangePacket iMMICombiDisplayExchangePacket) {
        super(iMMICombiDisplayExchangePacket);
    }

    public void requestFocus(int n) {
        this.displayStatus.setFocus(n);
        this.requestedChanges |= 1;
    }

    public void requestViewSize(int n) {
        this.displayStatus.setViewSize(n);
        this.requestedChanges |= 4;
    }

    public void requestContext(int n) {
        this.displayStatus.setMainContext(n);
        this.requestedChanges |= 2;
    }

    public void requestPopupContext(int n) {
        this.displayStatus.setPopupContext(n);
        this.requestedChanges |= 0x80;
    }

    public void requestLeftDrawerOpen(boolean bl) {
        this.displayStatus.setLeftDrawerOpen(bl);
        this.requestedChanges |= 8;
    }

    public void requestRightDrawerOpen(boolean bl) {
        this.displayStatus.setRightDrawerOpen(bl);
        this.requestedChanges |= 0x10;
    }

    public void requestPartialPopupVisible(boolean bl) {
        this.displayStatus.setPartialPopupVisible(bl);
        this.requestedChanges |= 0x20;
    }

    public void requestSecondStatusLineVisible(boolean bl) {
        this.displayStatus.setSecondStatusLineVisible(bl);
        this.requestedChanges |= 0x40;
    }

    public void requestPopupQuit(boolean bl) {
        this.popupQuit = bl;
        this.requestedChanges |= 0x100;
    }

    public int getRequestedChanges() {
        return this.requestedChanges;
    }

    public boolean isPopupQuit() {
        return this.popupQuit;
    }

    public MMICombiRequestAnimationInfo getAnimationInfo() {
        return this.animationInfo;
    }

    public boolean isLastmodeRequest() {
        return this.lastmodeRequest;
    }

    public boolean isLVDSLock() {
        return this.lvdsLock;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(38);
        stringBuffer.append("MMICombiRequest {");
        stringBuffer.append(super.toString());
        stringBuffer.append("\nrequested changes=");
        stringBuffer.append(this.requestedChanges);
        stringBuffer.append("\nanimationInfo=");
        stringBuffer.append(this.animationInfo);
        stringBuffer.append("\npopupQuit=");
        stringBuffer.append(this.popupQuit);
        stringBuffer.append("\nlastmodeRequest=");
        stringBuffer.append(this.lastmodeRequest);
        stringBuffer.append("\nlvdsLock=");
        stringBuffer.append(this.lvdsLock);
        stringBuffer.append('}');
        return stringBuffer.toString();
    }
}

