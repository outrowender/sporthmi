/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.nbest;

import de.audi.app.sdsmanager.nbest.IPicklistElement;
import de.audi.app.sdsmanager.nbest.IPicklistSlot;

public interface IPicklist {
    public static final int DUMMY_RULE_ID = -1;

    public IPicklistElement get(int var1);

    public int getPositionForSlotIndex(int var1);

    public int getSize();

    public IPicklistSlot getSlot(int var1, int var2);

    public IPicklistElement[] getElements();

    public int getLastRecogLineNumber();

    public void setLastRecogLine(boolean var1, int var2);

    public boolean isLineSelectedByNumber();

    public int[] getGraphGroupSizes();

    public int[] getGraphGroupIndexes();

    public IPicklist getRearrangedPicklist(int[] var1);
}

