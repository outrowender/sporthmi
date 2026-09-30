/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.mmicombi.exchange;

import de.audi.atip.mmicombi.exchange.MMICombiDisplayExchangePacket;
import de.audi.atip.mmicombi.exchange.MMICombiDisplayStatus;

public class MMICombiStatusUpdate
extends MMICombiDisplayExchangePacket {
    public MMICombiStatusUpdate(int n, int n2, int n3, int n4, int n5, int n6, boolean bl, boolean bl2, boolean bl3, boolean bl4) {
        super(n, n2, new MMICombiDisplayStatus(n3, n4, n5, n6, bl, bl2, bl3, bl4));
    }

    public MMICombiStatusUpdate(int n, int n2, MMICombiDisplayStatus mMICombiDisplayStatus) {
        super(n, n2, mMICombiDisplayStatus);
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(23);
        stringBuffer.append("MMICombiStatusUpdate {");
        stringBuffer.append(super.toString());
        stringBuffer.append('}');
        return stringBuffer.toString();
    }
}

