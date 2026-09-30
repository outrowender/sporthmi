/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.picturestore;

import de.esolutions.fw.comm.core.method.MethodException;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.picturestore.GeoPicture;
import org.dsi.ifc.picturestore.PictureAttribute;

public interface DSIPictureStoreReply {
    public static final String IPL_COMM_UUID = "cf4b0f19-f102-5a25-9c9a-e20ad310a491";
    public static final String IPL_COMM_INTERFACE_KEY = "1c27b1cd-5f97-5915-aba4-7477cff8c408";
    public static final String IPL_COMM_INTERFACE_VERSION = "2.11.11";
    public static final String IPL_COMM_MODULE_VERSION = "2.11.11";

    public void importPictureResult(int var1, ResourceLocator var2, ResourceLocator var3, int var4) throws MethodException;

    public void pictureExists(ResourceLocator var1, boolean var2) throws MethodException;

    public void freeSlots(int var1, int var2) throws MethodException;

    public void getReferencesResult(ResourceLocator var1, int[] var2) throws MethodException;

    public void deletedPictures(ResourceLocator[] var1) throws MethodException;

    public void responseLRUPictures(int var1, ResourceLocator[] var2) throws MethodException;

    public void listResult(ResourceLocator[] var1, int var2) throws MethodException;

    public void listForContextResult(int var1, ResourceLocator[] var2, int var3) throws MethodException;

    public void getPictureAttributesResult(ResourceLocator var1, PictureAttribute[] var2, int var3) throws MethodException;

    public void importPictureFromSourceResult(int var1, ResourceLocator var2, ResourceLocator var3, int var4) throws MethodException;

    public void listForContextWithFilterResult(int var1, ResourceLocator[] var2, int var3) throws MethodException;

    public void listForContextWithFilterSortDistResult(int var1, ResourceLocator[] var2, int var3, float var4, float var5) throws MethodException;

    public void getRectanglePicturesGridResult(GeoPicture[] var1) throws MethodException;

    public void getAvailableYearsResult(int[] var1) throws MethodException;

    public void getAvailableMonthsResult(int[] var1) throws MethodException;

    public void createFilterSetResult(int var1) throws MethodException;

    public void cloneFilterSetResult(int var1, int var2) throws MethodException;

    public void resetToFactorySettingsResult(int var1) throws MethodException;

    public void invalidData(int[] var1, int var2) throws MethodException;

    public void getAvailableFoldersResult(int var1, String[] var2) throws MethodException;

    public void countPicturesInContextResult(int var1, int var2, int var3) throws MethodException;

    public void asyncException(int var1, String var2, int var3) throws MethodException;

    public void yyIndication(String var1, String var2) throws MethodException;
}

