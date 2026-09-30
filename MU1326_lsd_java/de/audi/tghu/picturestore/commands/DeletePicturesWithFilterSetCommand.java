/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.picturestore.commands;

import de.audi.atip.interapp.picturestore.PictureStoreProviderListener;
import de.audi.tghu.picturestore.PictureStoreProxy;
import de.audi.tghu.picturestore.commands.AbstractPictureStoreCommand;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.picturestore.DSIPictureStore;

public class DeletePicturesWithFilterSetCommand
extends AbstractPictureStoreCommand {
    private PictureStoreProxy psp = null;
    private int contextID = 0;
    private int filterSetID = 0;
    private boolean force = false;
    private PictureStoreProviderListener callBack = null;

    public DeletePicturesWithFilterSetCommand(PictureStoreProxy pictureStoreProxy, int n, int n2, boolean bl, PictureStoreProviderListener pictureStoreProviderListener) {
        super(pictureStoreProxy);
        this.psp = pictureStoreProxy;
        this.contextID = n;
        this.filterSetID = n2;
        this.force = bl;
        this.callBack = pictureStoreProviderListener;
    }

    public void execute() {
        DSIPictureStore dSIPictureStore = this.psp.getDSIPictureStore();
        if (dSIPictureStore != null) {
            dSIPictureStore.deletePicturesWithFilterSet(this.contextID, this.filterSetID, this.force);
        }
    }

    public void deletedPictures(ResourceLocator[] resourceLocatorArray) {
        this.callBack.deletedPictures(resourceLocatorArray);
        this.commandList.commandFinished();
    }

    public void invalidData(int[] nArray, int n) {
    }
}

