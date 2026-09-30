/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.hmi.evo;

public interface IPropertyObject {
    public int getVisibleCCID();

    public int getEnabledCCID();

    public int[] getContextIDs();

    public int[] getCategories();

    public int[] getFocusPropertiesToShow();

    public int[] getFocusPropertiesToHide();

    public int[] getFocusPropertiesToDisable();
}

