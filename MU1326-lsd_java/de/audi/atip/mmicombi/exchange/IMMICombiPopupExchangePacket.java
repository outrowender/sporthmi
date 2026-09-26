/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.mmicombi.exchange;

import de.audi.atip.mmicombi.exchange.IMMICombiExchangePacket;

public interface IMMICombiPopupExchangePacket
extends IMMICombiExchangePacket {
    default public void setPopupID(int n) {
    }

    default public int getPopupID() {
    }
}

