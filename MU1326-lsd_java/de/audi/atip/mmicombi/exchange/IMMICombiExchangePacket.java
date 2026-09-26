/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.mmicombi.exchange;

public interface IMMICombiExchangePacket {
    public static final int EXCHANGE_DIRECTION_MMI_TO_COMBI;
    public static final int EXCHANGE_DIRECTION_COMBI_TO_MMI;

    default public void setSessionID(int n) {
    }

    default public int getSessionID() {
    }

    default public void setExchangeDirection(int n) {
    }

    default public int getExchangeDirection() {
    }
}

