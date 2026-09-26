/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.bulkcopy;

public interface IBulkCopyClient {
    public static final int BULKCOPY_TYPE_SWDL;
    public static final int BULKCOPY_TYPE_MEDIA;
    public static final int BULKCOPY_TYPE_SURVEILLANT;
    public static final int BULKCOPY_STATE_UNINITIALIZED;
    public static final int BULKCOPY_STATE_REGISTERED;
    public static final int BULKCOPY_STATE_WAITING;
    public static final int BULKCOPY_STATE_BUSY;
    public static final int BULKCOPY_STATE_IDLE;

    default public int getClientType() {
    }

    default public void onChangeStateBulkCopy(int n, int n2) {
    }
}

