/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.picturestore;

import de.esolutions.fw.comm.core.method.MethodException;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.picturestore.PictureEntryInfo;

public interface DSIPictureViewerReply {
    public static final String IPL_COMM_UUID = "b0372b7e-61ec-51fc-95c5-9262597c39d8";
    public static final String IPL_COMM_INTERFACE_KEY = "eb80de47-8f4f-5dfa-adf6-4f2ff55d4a1b";
    public static final String IPL_COMM_INTERFACE_VERSION = "2.11.11";
    public static final String IPL_COMM_MODULE_VERSION = "2.11.11";

    public void updateViewerState(int var1, int var2) throws MethodException;

    public void updateScrollMode(int var1, int var2) throws MethodException;

    public void updateListPosition(long var1, int var3, int var4) throws MethodException;

    public void updateNumEntries(long var1, int var3) throws MethodException;

    public void updateNumSelectedEntries(long var1, int var3) throws MethodException;

    public void getPictureInfoResult(long var1, PictureEntryInfo var3, int var4) throws MethodException;

    public void selectionResult(int var1) throws MethodException;

    public void createFilterSetResult(int var1, int var2) throws MethodException;

    public void deleteFilterSetResult(int var1, int var2) throws MethodException;

    public void changedFilterSetResult(int var1, int var2) throws MethodException;

    public void getAvailableYearsResult(int[] var1, int var2) throws MethodException;

    public void getAvailableMonthsResult(int[] var1, int var2) throws MethodException;

    public void listForContextWithFilterResult(int var1, ResourceLocator[] var2, int var3, int var4) throws MethodException;

    public void deletePicturesWithFilterSetResult(int var1, int var2) throws MethodException;

    public void asyncException(int var1, String var2, int var3) throws MethodException;

    public void yyIndication(String var1, String var2) throws MethodException;
}

