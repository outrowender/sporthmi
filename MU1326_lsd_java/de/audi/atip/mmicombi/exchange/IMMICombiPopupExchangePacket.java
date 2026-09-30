/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.mmicombi.exchange;

import de.audi.atip.mmicombi.exchange.IMMICombiExchangePacket;

public interface IMMICombiPopupExchangePacket
extends IMMICombiExchangePacket {
    public void setPopupID(int var1);

    public int getPopupID();
}

