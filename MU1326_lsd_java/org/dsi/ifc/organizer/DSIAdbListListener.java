/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.organizer;

import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.organizer.AdbViewSize;
import org.dsi.ifc.organizer.DataSet;
import org.dsi.ifc.organizer.IndexInformation;

public interface DSIAdbListListener
extends DSIListener {
    public void updateViewSize(AdbViewSize var1, int var2);

    public void invalidData(int var1);

    public void stopSpellerResult(int var1, int var2);

    public void spellerResult(int var1, int var2, DataSet[] var3, int var4, String var5, String var6);

    public void validateSpellerCharsResult(int var1, int var2, String var3, String var4);

    public void getViewWindowResult(int var1, DataSet[] var2, int var3);

    public void getSpellerViewWindowResult(int var1, int var2, DataSet[] var3, int var4);

    public void getValidHanziCharsWindowResult(int var1, int var2, int var3, String var4, int var5);

    public void setListStyleResult(int var1);

    public void updateAlphabeticalIndex(IndexInformation[] var1, int var2);
}

