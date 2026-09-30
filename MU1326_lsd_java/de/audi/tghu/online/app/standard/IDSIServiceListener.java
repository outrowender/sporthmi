/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.standard;

public interface IDSIServiceListener {
    public static final int BITMASK_SERVICE_ACTIVE_GPS = 2048;
    public static final int ATTRVALIDFLAG_VALID = 1;

    public void updateServiceState(int var1, int var2);
}

