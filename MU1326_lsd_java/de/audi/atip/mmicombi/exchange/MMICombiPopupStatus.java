/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.mmicombi.exchange;

import de.audi.atip.mmicombi.exchange.MMICombiPopupExchangePacket;

public class MMICombiPopupStatus
extends MMICombiPopupExchangePacket {
    public static final int POPUP_REGISTERED;
    public static final int POPUP_REMOVED;
    int popupStatus;

    public MMICombiPopupStatus(int n, int n2, int n3, int n4, int n5, int n6, int n7) {
        super(n, n2, n3, n4, n5, n6);
        this.popupStatus = n7;
    }

    public int getPopupStatus() {
        return this.popupStatus;
    }

    public void setPopupStatus(int n) {
        this.popupStatus = n;
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(36);
        stringBuffer.append("MMICombiPopupStatus {");
        stringBuffer.append(super.toString());
        stringBuffer.append(", popupStatus=");
        stringBuffer.append(this.popupStatus);
        stringBuffer.append('}');
        return stringBuffer.toString();
    }
}

