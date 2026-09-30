/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.picturestore.commands;

import de.audi.tghu.command.Command;
import de.audi.tghu.picturestore.PictureStoreDSIDefaultListener;
import de.audi.tghu.picturestore.PictureStoreProxy;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.picturestore.DSIPictureStore;
import org.dsi.ifc.picturestore.DSIPictureStoreListener;
import org.dsi.ifc.picturestore.GeoPicture;
import org.dsi.ifc.picturestore.PictureAttribute;

public abstract class AbstractPictureStoreCommand
extends Command
implements DSIPictureStoreListener {
    protected DSIPictureStore dsiPictureStore;
    protected PictureStoreDSIDefaultListener pictureStoreDefaultListener;

    protected AbstractPictureStoreCommand(PictureStoreProxy pictureStoreProxy) {
        super(pictureStoreProxy.getLogChannel());
        this.dsiPictureStore = pictureStoreProxy.getDSIPictureStore();
        this.pictureStoreDefaultListener = pictureStoreProxy.getPictureStoreDSIDefaultListener();
    }

    public void importPictureResult(int n, ResourceLocator resourceLocator, ResourceLocator resourceLocator2, int n2) {
    }

    public void pictureExists(ResourceLocator resourceLocator, boolean bl) {
    }

    public void freeSlots(int n, int n2) {
    }

    public void getReferencesResult(ResourceLocator resourceLocator, int[] nArray) {
    }

    public void deletedPictures(ResourceLocator[] resourceLocatorArray) {
    }

    public void responseLRUPictures(int n, ResourceLocator[] resourceLocatorArray) {
    }

    public void listResult(ResourceLocator[] resourceLocatorArray, int n) {
    }

    public void listForContextResult(int n, ResourceLocator[] resourceLocatorArray, int n2) {
    }

    public void getPictureAttributesResult(ResourceLocator resourceLocator, PictureAttribute[] pictureAttributeArray, int n) {
    }

    public void execute() {
    }

    public void importPictureFromSourceResult(int n, ResourceLocator resourceLocator, ResourceLocator resourceLocator2, int n2) {
    }

    public void listForContextWithFilterResult(int n, ResourceLocator[] resourceLocatorArray, int n2) {
    }

    public void getRectanglePicturesGridResult(GeoPicture[] geoPictureArray) {
    }

    public void getAvailableYearsResult(int[] nArray) {
    }

    public void getAvailableMonthsResult(int[] nArray) {
    }

    public void createFilterSetResult(int n) {
    }

    public void cloneFilterSetResult(int n, int n2) {
    }

    public void resetToFactorySettingsResult(int n) {
    }

    public void invalidData() {
    }

    public void getAvailableFoldersResult(int n, String[] stringArray) {
    }

    public void countPicturesInContextResult(int n, int n2, int n3) {
    }

    public void listForContextWithFilterSortDistResult(int n, ResourceLocator[] resourceLocatorArray, int n2, float f2, float f3) {
    }
}

