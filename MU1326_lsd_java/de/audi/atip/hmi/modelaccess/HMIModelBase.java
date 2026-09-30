/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.modelaccess;

public interface HMIModelBase {
    public int getID();

    public String getName();

    public int getStatus();

    public int getHints();

    public String dumpContent();

    public int getTerminalID();
}

