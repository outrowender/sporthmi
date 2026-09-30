/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.cc;

public interface IComponentConditionManager {
    public void activateCC(int var1);

    public void deactivateCC(int var1);

    public boolean isTrue(int var1, int var2);
}

