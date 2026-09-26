/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.picturestore;

import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.picturestore.DSIPictureStoreListener;
import org.dsi.ifc.picturestore.GeoPicture;
import org.dsi.ifc.picturestore.PictureAttribute;

public class PictureStoreDSIDefaultListener
implements DSIPictureStoreListener {
    @Override
    public void asyncException(int n, String string, int n2) {
    }

    @Override
    public void importPictureResult(int n, ResourceLocator resourceLocator, ResourceLocator resourceLocator2, int n2) {
    }

    @Override
    public void pictureExists(ResourceLocator resourceLocator, boolean bl) {
    }

    @Override
    public void freeSlots(int n, int n2) {
    }

    @Override
    public void getReferencesResult(ResourceLocator resourceLocator, int[] nArray) {
    }

    @Override
    public void deletedPictures(ResourceLocator[] resourceLocatorArray) {
    }

    @Override
    public void responseLRUPictures(int n, ResourceLocator[] resourceLocatorArray) {
    }

    @Override
    public void listResult(ResourceLocator[] resourceLocatorArray, int n) {
    }

    @Override
    public void listForContextResult(int n, ResourceLocator[] resourceLocatorArray, int n2) {
    }

    @Override
    public void getPictureAttributesResult(ResourceLocator resourceLocator, PictureAttribute[] pictureAttributeArray, int n) {
    }

    @Override
    public void importPictureFromSourceResult(int n, ResourceLocator resourceLocator, ResourceLocator resourceLocator2, int n2) {
    }

    @Override
    public void listForContextWithFilterResult(int n, ResourceLocator[] resourceLocatorArray, int n2) {
    }

    @Override
    public void getRectanglePicturesGridResult(GeoPicture[] geoPictureArray) {
    }

    @Override
    public void getAvailableYearsResult(int[] nArray) {
    }

    @Override
    public void getAvailableMonthsResult(int[] nArray) {
    }

    @Override
    public void createFilterSetResult(int n) {
    }

    @Override
    public void cloneFilterSetResult(int n, int n2) {
    }

    @Override
    public void resetToFactorySettingsResult(int n) {
    }

    public void invalidData() {
    }

    @Override
    public void getAvailableFoldersResult(int n, String[] stringArray) {
    }

    @Override
    public void countPicturesInContextResult(int n, int n2, int n3) {
    }

    @Override
    public void listForContextWithFilterSortDistResult(int n, ResourceLocator[] resourceLocatorArray, int n2, float f2, float f3) {
    }

    @Override
    public void invalidData(int[] nArray, int n) {
    }
}

