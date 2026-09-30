/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.picturestore;

import de.esolutions.fw.comm.core.method.MethodException;
import org.dsi.ifc.global.ResourceLocator;

public interface DSIPictureStoreC {
    public void setConfig(int var1, int var2, int var3, int var4) throws MethodException;

    public void importPicture(int var1, ResourceLocator var2, boolean var3) throws MethodException;

    public void pictureExists(ResourceLocator var1) throws MethodException;

    public void increaseRefCounter(ResourceLocator var1, int var2) throws MethodException;

    public void decreaseRefCounter(ResourceLocator var1, int var2) throws MethodException;

    public void getFreeSlots(int var1) throws MethodException;

    public void getReferences(ResourceLocator var1) throws MethodException;

    public void deleteAllPictures(int var1, boolean var2) throws MethodException;

    public void deletePicturesFromContext(int var1, ResourceLocator[] var2, boolean var3) throws MethodException;

    public void deletePictures(ResourceLocator[] var1, boolean var2) throws MethodException;

    public void getLRUPictures(int var1, boolean var2, int var3) throws MethodException;

    public void listInAllContexts(int var1, int var2) throws MethodException;

    public void listInContext(int var1, int var2, int var3) throws MethodException;

    public void getPictureAttributes(ResourceLocator var1) throws MethodException;

    public void setConfigWithFileType(int var1, int var2, int var3, int var4, int var5) throws MethodException;

    public void importPictureFromSource(int var1, ResourceLocator var2, boolean var3, int var4, String var5) throws MethodException;

    public void deletePicturesWithFilterSet(int var1, int var2, boolean var3) throws MethodException;

    public void listInContextWithFilter(int var1, int var2, int var3, int var4) throws MethodException;

    public void listInContextWithFilterSortDist(int var1, int var2, int var3, int var4, float var5, float var6) throws MethodException;

    public void getRectanglePicturesGrid(int var1, int var2, float var3, float var4, float var5, float var6, int var7, int var8, int var9) throws MethodException;

    public void getAvailableYears(int var1, int var2) throws MethodException;

    public void getAvailableMonths(int var1, int var2, int var3) throws MethodException;

    public void createFilterSet() throws MethodException;

    public void cloneFilterSet(int var1) throws MethodException;

    public void deleteFilterSet(int var1) throws MethodException;

    public void setFilterImportSource(int var1, int var2) throws MethodException;

    public void setFilterTimeInterval(int var1, int var2, long var3, long var5) throws MethodException;

    public void setFilterGeoArea(int var1, float var2, float var3, float var4, float var5) throws MethodException;

    public void resetToFactorySettings() throws MethodException;

    public void getAvailableFolders(int var1) throws MethodException;

    public void setFilterFolderName(int var1, String var2) throws MethodException;

    public void countPicturesInContext(int var1, int var2) throws MethodException;

    public void setNotification(int[] var1) throws MethodException;

    public void setNotification(int var1) throws MethodException;

    public void setNotification() throws MethodException;

    public void clearNotification(int[] var1) throws MethodException;

    public void clearNotification(int var1) throws MethodException;

    public void clearNotification() throws MethodException;

    public void yySet(String var1, String var2) throws MethodException;
}

