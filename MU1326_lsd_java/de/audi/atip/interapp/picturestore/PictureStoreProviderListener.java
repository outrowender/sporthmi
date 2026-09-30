/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.picturestore;

import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.picturestore.GeoPicture;
import org.dsi.ifc.picturestore.PictureAttribute;

public interface PictureStoreProviderListener {
    public void importPictureResult(int var1, ResourceLocator var2, ResourceLocator var3, int var4);

    public void pictureExists(ResourceLocator var1, boolean var2);

    public void freeSlots(int var1, int var2);

    public void getReferencesResult(ResourceLocator var1, int[] var2);

    public void deletedPictures(ResourceLocator[] var1);

    public void responseLRUPictures(int var1, ResourceLocator[] var2);

    public void listResult(ResourceLocator[] var1, int var2);

    public void listForContextResult(int var1, ResourceLocator[] var2, int var3);

    public void getPictureAttributesResult(ResourceLocator var1, PictureAttribute[] var2, int var3);

    public void importPictureFromSourceResult(int var1, ResourceLocator var2, ResourceLocator var3, int var4);

    public void listForContextWithFilterResult(int var1, ResourceLocator[] var2, int var3);

    public void getRectanglePicturesGridResult(GeoPicture[] var1);

    public void getAvailableYearsResult(int[] var1);

    public void getAvailableMonthsResult(int[] var1);

    public void createFilterSetResult(int var1);

    public void cloneFilterSetResult(int var1, int var2);

    public void resetToFactorySettingsResult(int var1);

    public void invalidData();

    public void getAvailableFoldersResult(int var1, String[] var2);

    public void countPicturesInContextResult(int var1, int var2, int var3);
}

