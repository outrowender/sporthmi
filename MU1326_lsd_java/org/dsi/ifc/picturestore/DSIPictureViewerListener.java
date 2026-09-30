/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.picturestore;

import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.picturestore.PictureEntryInfo;

public interface DSIPictureViewerListener
extends DSIListener {
    public void updateViewerState(int var1, int var2);

    public void updateScrollMode(int var1, int var2);

    public void updateListPosition(long var1, int var3, int var4);

    public void updateNumEntries(long var1, int var3);

    public void updateNumSelectedEntries(long var1, int var3);

    public void getPictureInfoResult(long var1, PictureEntryInfo var3, int var4);

    public void selectionResult(int var1);

    public void createFilterSetResult(int var1, int var2);

    public void deleteFilterSetResult(int var1, int var2);

    public void changedFilterSetResult(int var1, int var2);

    public void getAvailableYearsResult(int[] var1, int var2);

    public void getAvailableMonthsResult(int[] var1, int var2);

    public void listForContextWithFilterResult(int var1, ResourceLocator[] var2, int var3, int var4);

    public void deletePicturesWithFilterSetResult(int var1, int var2);
}

