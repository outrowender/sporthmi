/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.mmicombi.exchange;

import de.audi.atip.mmicombi.exchange.MMICombiPopupExchangePacket;

public class MMICombiPopupRequest
extends MMICombiPopupExchangePacket {
    public static final int REQUEST_TYPE_SHOW_POPUP = 1;
    public static final int REQUEST_TYPE_REMOVE_POPUP = 2;
    public static final int REQUEST_TYPE_QUIT_POPUP = 3;
    private int requestType;

    public MMICombiPopupRequest(int n, int n2, int n3, int n4, int n5, int n6, int n7) {
        super(n, n2, n3, n4, n6, n7);
        this.requestType = n5;
    }

    public int getRequestType() {
        return this.requestType;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(57);
        stringBuffer.append("MMICombiPopupRequest {");
        stringBuffer.append(super.toString());
        stringBuffer.append(", requestType=");
        stringBuffer.append('}');
        return stringBuffer.toString();
    }
}

