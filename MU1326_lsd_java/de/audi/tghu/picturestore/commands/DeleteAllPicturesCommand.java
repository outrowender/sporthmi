/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.picturestore.commands;

import de.audi.atip.interapp.picturestore.PictureStoreProviderListener;
import de.audi.tghu.picturestore.PictureStoreProxy;
import de.audi.tghu.picturestore.commands.AbstractPictureStoreCommand;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.picturestore.DSIPictureStore;

public class DeleteAllPicturesCommand
extends AbstractPictureStoreCommand {
    private PictureStoreProxy psp = null;
    private int contextID = 0;
    private boolean force = false;
    private PictureStoreProviderListener callBack = null;

    public DeleteAllPicturesCommand(PictureStoreProxy pictureStoreProxy, int n, boolean bl, PictureStoreProviderListener pictureStoreProviderListener) {
        super(pictureStoreProxy);
        this.psp = pictureStoreProxy;
        this.contextID = n;
        this.force = bl;
        this.callBack = pictureStoreProviderListener;
    }

    @Override
    public void execute() {
        DSIPictureStore dSIPictureStore = this.psp.getDSIPictureStore();
        if (dSIPictureStore != null) {
            dSIPictureStore.deleteAllPictures(this.contextID, this.force);
        }
    }

    @Override
    public void deletedPictures(ResourceLocator[] resourceLocatorArray) {
        this.callBack.deletedPictures(resourceLocatorArray);
        this.commandList.commandFinished();
    }

    @Override
    public void invalidData(int[] nArray, int n) {
    }
}

