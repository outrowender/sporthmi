/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bap.fw.functiontypes;

public interface BAPFunctionDataListener {
    public void notifyDataValidChanged(int var1, boolean var2);

    public void notifyDataChanged(int var1);

    public void notifyDataUpdatedNoChange(int var1);
}

