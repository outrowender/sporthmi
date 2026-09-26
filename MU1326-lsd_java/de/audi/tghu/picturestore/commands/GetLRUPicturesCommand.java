/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.picturestore.commands;

import de.audi.atip.interapp.picturestore.PictureStoreProviderListener;
import de.audi.tghu.picturestore.PictureStoreProxy;
import de.audi.tghu.picturestore.commands.AbstractPictureStoreCommand;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.picturestore.DSIPictureStore;

public class GetLRUPicturesCommand
extends AbstractPictureStoreCommand {
    private PictureStoreProxy psp = null;
    private int contextID = 0;
    private boolean onlyUnreferencedPictures = false;
    private int count = 0;
    private PictureStoreProviderListener callBack = null;

    public GetLRUPicturesCommand(PictureStoreProxy pictureStoreProxy, int n, boolean bl, int n2, PictureStoreProviderListener pictureStoreProviderListener) {
        super(pictureStoreProxy);
        this.psp = pictureStoreProxy;
        this.contextID = n;
        this.onlyUnreferencedPictures = bl;
        this.count = n2;
        this.callBack = pictureStoreProviderListener;
    }

    @Override
    public void execute() {
        DSIPictureStore dSIPictureStore = this.psp.getDSIPictureStore();
        if (dSIPictureStore != null) {
            dSIPictureStore.getLRUPictures(this.contextID, this.onlyUnreferencedPictures, this.count);
        }
    }

    @Override
    public void responseLRUPictures(int n, ResourceLocator[] resourceLocatorArray) {
        this.callBack.responseLRUPictures(n, resourceLocatorArray);
        this.commandList.commandFinished();
    }

    @Override
    public void invalidData(int[] nArray, int n) {
    }
}

