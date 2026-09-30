/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.picturestore;

import de.audi.atip.interapp.picturestore.PictureStoreProviderListener;
import org.dsi.ifc.global.ResourceLocator;

public interface PictureStoreProvider {
    public void setConfig(int var1, int var2, int var3, int var4);

    public void importPicture(int var1, ResourceLocator var2, boolean var3, PictureStoreProviderListener var4);

    public void pictureExists(ResourceLocator var1, PictureStoreProviderListener var2);

    public void increaseRefCounter(ResourceLocator var1, int var2);

    public void decreaseRefCounter(ResourceLocator var1, int var2);

    public void getFreeSlots(int var1, PictureStoreProviderListener var2);

    public void getReferences(ResourceLocator var1, PictureStoreProviderListener var2);

    public void deleteAllPictures(int var1, boolean var2, PictureStoreProviderListener var3);

    public void deletePicturesFromContext(int var1, ResourceLocator[] var2, boolean var3, PictureStoreProviderListener var4);

    public void deletePictures(ResourceLocator[] var1, boolean var2, PictureStoreProviderListener var3);

    public void getLRUPictures(int var1, boolean var2, int var3, PictureStoreProviderListener var4);

    public void listInAllContexts(int var1, int var2, PictureStoreProviderListener var3);

    public void listInContext(int var1, int var2, int var3, PictureStoreProviderListener var4);

    public void getPictureAttributes(ResourceLocator var1, PictureStoreProviderListener var2);

    public void setConfigWithFileType(int var1, int var2, int var3, int var4, int var5);

    public void importPictureFromSource(int var1, ResourceLocator var2, boolean var3, int var4, String var5, PictureStoreProviderListener var6);

    public void deletePicturesWithFilterSet(int var1, int var2, boolean var3, PictureStoreProviderListener var4);

    public void listInContextWithFilter(int var1, int var2, int var3, int var4, PictureStoreProviderListener var5);

    public void getRectanglePicturesGrid(int var1, int var2, float var3, float var4, float var5, float var6, int var7, int var8, int var9, PictureStoreProviderListener var10);

    public void getAvailableYears(int var1, int var2, PictureStoreProviderListener var3);

    public void getAvailableMonths(int var1, int var2, int var3, PictureStoreProviderListener var4);

    public void createFilterSet(PictureStoreProviderListener var1);

    public void cloneFilterSet(int var1, PictureStoreProviderListener var2);

    public void deleteFilterSet(int var1);

    public void setFilterImportSource(int var1, int var2);

    public void setFilterTimeInterval(int var1, int var2, long var3, long var5);

    public void setFilterGeoArea(int var1, float var2, float var3, float var4, float var5);

    public void resetToFactorySettings(PictureStoreProviderListener var1);

    public void getAvailableFolders(int var1, PictureStoreProviderListener var2);

    public void setFilterFolderName(int var1, String var2);

    public void countPicturesInContext(int var1, int var2, PictureStoreProviderListener var3);
}

