/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.picturestore;

import de.audi.atip.interapp.picturestore.PictureStoreProviderListener;
import org.dsi.ifc.global.ResourceLocator;

public interface PictureStoreProvider {
    default public void setConfig(int n, int n2, int n3, int n4) {
    }

    default public void importPicture(int n, ResourceLocator resourceLocator, boolean bl, PictureStoreProviderListener pictureStoreProviderListener) {
    }

    default public void pictureExists(ResourceLocator resourceLocator, PictureStoreProviderListener pictureStoreProviderListener) {
    }

    default public void increaseRefCounter(ResourceLocator resourceLocator, int n) {
    }

    default public void decreaseRefCounter(ResourceLocator resourceLocator, int n) {
    }

    default public void getFreeSlots(int n, PictureStoreProviderListener pictureStoreProviderListener) {
    }

    default public void getReferences(ResourceLocator resourceLocator, PictureStoreProviderListener pictureStoreProviderListener) {
    }

    default public void deleteAllPictures(int n, boolean bl, PictureStoreProviderListener pictureStoreProviderListener) {
    }

    default public void deletePicturesFromContext(int n, ResourceLocator[] resourceLocatorArray, boolean bl, PictureStoreProviderListener pictureStoreProviderListener) {
    }

    default public void deletePictures(ResourceLocator[] resourceLocatorArray, boolean bl, PictureStoreProviderListener pictureStoreProviderListener) {
    }

    default public void getLRUPictures(int n, boolean bl, int n2, PictureStoreProviderListener pictureStoreProviderListener) {
    }

    default public void listInAllContexts(int n, int n2, PictureStoreProviderListener pictureStoreProviderListener) {
    }

    default public void listInContext(int n, int n2, int n3, PictureStoreProviderListener pictureStoreProviderListener) {
    }

    default public void getPictureAttributes(ResourceLocator resourceLocator, PictureStoreProviderListener pictureStoreProviderListener) {
    }

    default public void setConfigWithFileType(int n, int n2, int n3, int n4, int n5) {
    }

    default public void importPictureFromSource(int n, ResourceLocator resourceLocator, boolean bl, int n2, String string, PictureStoreProviderListener pictureStoreProviderListener) {
    }

    default public void deletePicturesWithFilterSet(int n, int n2, boolean bl, PictureStoreProviderListener pictureStoreProviderListener) {
    }

    default public void listInContextWithFilter(int n, int n2, int n3, int n4, PictureStoreProviderListener pictureStoreProviderListener) {
    }

    default public void getRectanglePicturesGrid(int n, int n2, float f2, float f3, float f4, float f5, int n3, int n4, int n5, PictureStoreProviderListener pictureStoreProviderListener) {
    }

    default public void getAvailableYears(int n, int n2, PictureStoreProviderListener pictureStoreProviderListener) {
    }

    default public void getAvailableMonths(int n, int n2, int n3, PictureStoreProviderListener pictureStoreProviderListener) {
    }

    default public void createFilterSet(PictureStoreProviderListener pictureStoreProviderListener) {
    }

    default public void cloneFilterSet(int n, PictureStoreProviderListener pictureStoreProviderListener) {
    }

    default public void deleteFilterSet(int n) {
    }

    default public void setFilterImportSource(int n, int n2) {
    }

    default public void setFilterTimeInterval(int n, int n2, long l, long l2) {
    }

    default public void setFilterGeoArea(int n, float f2, float f3, float f4, float f5) {
    }

    default public void resetToFactorySettings(PictureStoreProviderListener pictureStoreProviderListener) {
    }

    default public void getAvailableFolders(int n, PictureStoreProviderListener pictureStoreProviderListener) {
    }

    default public void setFilterFolderName(int n, String string) {
    }

    default public void countPicturesInContext(int n, int n2, PictureStoreProviderListener pictureStoreProviderListener) {
    }
}

