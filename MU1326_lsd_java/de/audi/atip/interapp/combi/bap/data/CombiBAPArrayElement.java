/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.combi.bap.data;

public interface CombiBAPArrayElement {
    public int getPosID();

    public boolean hasSameContent(CombiBAPArrayElement var1);

    public int getDiffRecordAddress(CombiBAPArrayElement var1);
}

