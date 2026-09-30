/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.bulkcopy;

public interface IBulkCopyClient {
    public static final int BULKCOPY_TYPE_SWDL = 1;
    public static final int BULKCOPY_TYPE_MEDIA = 2;
    public static final int BULKCOPY_TYPE_SURVEILLANT = -1;
    public static final int BULKCOPY_STATE_UNINITIALIZED = 0;
    public static final int BULKCOPY_STATE_REGISTERED = 1;
    public static final int BULKCOPY_STATE_WAITING = 2;
    public static final int BULKCOPY_STATE_BUSY = 3;
    public static final int BULKCOPY_STATE_IDLE = 4;

    public int getClientType();

    public void onChangeStateBulkCopy(int var1, int var2);
}

