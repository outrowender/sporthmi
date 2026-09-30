/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.explorer.picturestore;

import de.esolutions.fw.comm.core.method.MethodException;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.picturestore.GeoPicture;
import org.dsi.ifc.picturestore.PictureAttribute;

public interface PictureStoreReply {
    public static final String IPL_COMM_UUID = "a4508c38-8b16-4130-967f-f23cb2238fda";
    public static final String IPL_COMM_INTERFACE_KEY = "ca2869dd-3831-51b0-8093-231b81bca2c1";
    public static final String IPL_COMM_INTERFACE_VERSION = "1.1.0";
    public static final String IPL_COMM_MODULE_VERSION = "1.6.0";

    public void beginImportResult(int var1) throws MethodException;

    public void endImportResult(int var1) throws MethodException;

    public void importPictureFromSourceResult(int var1, ResourceLocator var2, ResourceLocator var3, int var4) throws MethodException;

    public void importPictureWithSynchronizationIDResult(int var1, ResourceLocator var2, ResourceLocator var3, int var4, long var5) throws MethodException;

    public void getMaxSynchronizationIDResult(int var1, long var2) throws MethodException;

    public void setSynchronizationIDResult(int var1, long var2) throws MethodException;

    public void renameFolderResult(int var1, String var2, String var3, long var4, int var6) throws MethodException;

    public void countPicturesInContextResult(int var1, int var2, int var3) throws MethodException;

    public void increaseRefCounterResult(ResourceLocator var1, ResourceLocator var2, int var3) throws MethodException;

    public void deletedPictures(ResourceLocator[] var1) throws MethodException;

    public void deleteSynchronizedPictureResult(int var1, long var2, long var4, int var6) throws MethodException;

    public void getPictureAttributesResult(ResourceLocator var1, PictureAttribute[] var2, int var3) throws MethodException;

    public void listWithFilterResult(ResourceLocator[] var1, int var2) throws MethodException;

    public void listForContextResult(int var1, ResourceLocator[] var2, int var3) throws MethodException;

    public void listForContextWithFilterResult(int var1, ResourceLocator[] var2, int var3) throws MethodException;

    public void listForContextWithFilterSortDistResult(int var1, ResourceLocator[] var2, int var3, float var4, float var5) throws MethodException;

    public void getRectanglePicturesGridResult(GeoPicture[] var1) throws MethodException;

    public void getAvailableYearsResult(int[] var1) throws MethodException;

    public void getAvailableMonthsResult(int[] var1) throws MethodException;

    public void createFilterSetResult(int var1) throws MethodException;

    public void cloneFilterSetResult(int var1, int var2) throws MethodException;

    public void invalidData(int[] var1, int var2) throws MethodException;

    public void getAvailableFoldersResult(int var1, String[] var2) throws MethodException;
}

