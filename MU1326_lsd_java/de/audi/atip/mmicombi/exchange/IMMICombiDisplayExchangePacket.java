/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.mmicombi.exchange;

import de.audi.atip.mmicombi.exchange.IMMICombiExchangePacket;
import de.audi.atip.mmicombi.exchange.MMICombiDisplayStatus;

public interface IMMICombiDisplayExchangePacket
extends IMMICombiExchangePacket {
    default public void setDisplayStatus(MMICombiDisplayStatus mMICombiDisplayStatus) {
    }

    default public MMICombiDisplayStatus getDisplayStatus() {
    }
}

