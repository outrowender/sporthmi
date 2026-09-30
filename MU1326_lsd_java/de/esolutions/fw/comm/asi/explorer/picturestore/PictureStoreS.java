/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.explorer.picturestore;

import de.esolutions.fw.comm.asi.explorer.picturestore.PictureStoreReply;
import de.esolutions.fw.comm.core.method.MethodException;
import org.dsi.ifc.global.ResourceLocator;

public interface PictureStoreS {
    public void setConfig(int var1, int var2, int var3, int var4, PictureStoreReply var5) throws MethodException;

    public void setConfigWithFileType(int var1, int var2, int var3, int var4, int var5, PictureStoreReply var6) throws MethodException;

    public void beginImport(PictureStoreReply var1) throws MethodException;

    public void endImport(PictureStoreReply var1) throws MethodException;

    public void importPictureFromSource(int var1, ResourceLocator var2, boolean var3, int var4, String var5, PictureStoreReply var6) throws MethodException;

    public void importPictureWithSynchronizationID(int var1, ResourceLocator var2, boolean var3, int var4, String var5, long var6, PictureStoreReply var8) throws MethodException;

    public void getMaxSynchronizationID(int var1, PictureStoreReply var2) throws MethodException;

    public void setSynchronizationID(int var1, long var2, PictureStoreReply var4) throws MethodException;

    public void renameFolder(int var1, String var2, String var3, long var4, PictureStoreReply var6) throws MethodException;

    public void countPicturesInContext(int var1, int var2, PictureStoreReply var3) throws MethodException;

    public void increaseRefCounter(ResourceLocator var1, int var2, PictureStoreReply var3) throws MethodException;

    public void decreaseRefCounter(ResourceLocator var1, int var2, PictureStoreReply var3) throws MethodException;

    public void decreaseAllRefCounters(int var1, PictureStoreReply var2) throws MethodException;

    public void deleteAllPictures(int var1, boolean var2, PictureStoreReply var3) throws MethodException;

    public void deletePicturesFromContext(int var1, ResourceLocator[] var2, boolean var3, PictureStoreReply var4) throws MethodException;

    public void deletePicturesWithFilterSet(int var1, int var2, boolean var3, PictureStoreReply var4) throws MethodException;

    public void deleteSynchronizedPicture(int var1, long var2, long var4, PictureStoreReply var6) throws MethodException;

    public void getPictureAttributes(ResourceLocator var1, PictureStoreReply var2) throws MethodException;

    public void listInAllContextsWithFilter(int var1, int var2, int var3, PictureStoreReply var4) throws MethodException;

    public void listInContext(int var1, int var2, int var3, PictureStoreReply var4) throws MethodException;

    public void listInContextWithFilter(int var1, int var2, int var3, int var4, PictureStoreReply var5) throws MethodException;

    public void listInContextWithFilterSortDist(int var1, int var2, int var3, int var4, float var5, float var6, PictureStoreReply var7) throws MethodException;

    public void getRectanglePicturesGrid(int var1, int var2, float var3, float var4, float var5, float var6, int var7, int var8, int var9, PictureStoreReply var10) throws MethodException;

    public void getAvailableYears(int var1, int var2, PictureStoreReply var3) throws MethodException;

    public void getAvailableMonths(int var1, int var2, int var3, PictureStoreReply var4) throws MethodException;

    public void createFilterSet(PictureStoreReply var1) throws MethodException;

    public void cloneFilterSet(int var1, PictureStoreReply var2) throws MethodException;

    public void deleteFilterSet(int var1, PictureStoreReply var2) throws MethodException;

    public void setFilterImportSource(int var1, int var2, PictureStoreReply var3) throws MethodException;

    public void setFilterTimeInterval(int var1, int var2, long var3, long var5, PictureStoreReply var7) throws MethodException;

    public void setFilterGeoArea(int var1, float var2, float var3, float var4, float var5, PictureStoreReply var6) throws MethodException;

    public void getAvailableFolders(int var1, PictureStoreReply var2) throws MethodException;

    public void setFilterFolderName(int var1, String var2, PictureStoreReply var3) throws MethodException;
}

