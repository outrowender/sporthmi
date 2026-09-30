/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.earlyfunc.core.parking;

public interface IParkingSystemHighProtocol {
    public static final int HIGH_PROTOCOL_REASON_AUDIODRAWERCONTEXT_HIGH_PRIO = 1;

    public void setHighProtocol(boolean var1, int[] var2, boolean var3);

    public boolean isHighProtocol();

    public boolean isHighProtocolReason(int var1);

    public int[] getHighProtocolReasons();
}

