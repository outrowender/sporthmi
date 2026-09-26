/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp;

public interface AbstractSDSApplicationService {
    public static final byte FREEZE_RESULT_OK;
    public static final byte FREEZE_RESULT_NOK;

    default public byte freezeDynamicLists() {
    }

    default public byte unfreezeDynamicLists() {
    }
}

