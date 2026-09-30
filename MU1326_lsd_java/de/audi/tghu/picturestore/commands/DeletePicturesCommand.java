/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.picturestore.commands;

import de.audi.atip.interapp.picturestore.PictureStoreProviderListener;
import de.audi.tghu.picturestore.PictureStoreProxy;
import de.audi.tghu.picturestore.commands.AbstractPictureStoreCommand;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.picturestore.DSIPictureStore;

public class DeletePicturesCommand
extends AbstractPictureStoreCommand {
    private PictureStoreProxy psp = null;
    private ResourceLocator[] resourceLocators = null;
    private boolean force = false;
    private PictureStoreProviderListener callBack = null;

    public DeletePicturesCommand(PictureStoreProxy pictureStoreProxy, ResourceLocator[] resourceLocatorArray, boolean bl, PictureStoreProviderListener pictureStoreProviderListener) {
        super(pictureStoreProxy);
        this.psp = pictureStoreProxy;
        this.resourceLocators = resourceLocatorArray;
        this.force = bl;
        this.callBack = pictureStoreProviderListener;
    }

    public void execute() {
        DSIPictureStore dSIPictureStore = this.psp.getDSIPictureStore();
        if (dSIPictureStore != null) {
            dSIPictureStore.deletePictures(this.resourceLocators, this.force);
        }
    }

    public void deletedPictures(ResourceLocator[] resourceLocatorArray) {
        this.callBack.deletedPictures(resourceLocatorArray);
        this.commandList.commandFinished();
    }

    public void invalidData(int[] nArray, int n) {
    }
}

