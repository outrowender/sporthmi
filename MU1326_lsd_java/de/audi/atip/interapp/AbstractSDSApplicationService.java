/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp;

public interface AbstractSDSApplicationService {
    public static final byte FREEZE_RESULT_OK = 0;
    public static final byte FREEZE_RESULT_NOK = 1;

    public byte freezeDynamicLists();

    public byte unfreezeDynamicLists();
}

