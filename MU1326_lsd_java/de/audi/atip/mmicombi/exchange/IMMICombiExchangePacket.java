/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.mmicombi.exchange;

public interface IMMICombiExchangePacket {
    public static final int EXCHANGE_DIRECTION_MMI_TO_COMBI = 1;
    public static final int EXCHANGE_DIRECTION_COMBI_TO_MMI = 2;

    public void setSessionID(int var1);

    public int getSessionID();

    public void setExchangeDirection(int var1);

    public int getExchangeDirection();
}

