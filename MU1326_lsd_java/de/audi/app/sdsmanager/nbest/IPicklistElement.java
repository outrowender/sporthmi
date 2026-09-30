/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.nbest;

import de.audi.app.sdsmanager.nbest.IPicklistSlot;

public interface IPicklistElement {
    public static final int GG_INDEX_NONE = -1;

    public IPicklistSlot[] getSlots();

    public int getGraphGroupSize();

    public int getGraphGroupIndex();

    public int getGraphGroupId();

    public int getRuleID();

    public int getConfidence();

    public long getObjectID();

    public void setSlots(IPicklistSlot[] var1);
}

