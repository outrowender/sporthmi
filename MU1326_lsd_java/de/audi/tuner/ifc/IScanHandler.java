/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.ifc;

public interface IScanHandler {
    public void abortScan();

    public boolean isScanActive();

    public boolean handleHkPrevHkNext(boolean var1);
}

