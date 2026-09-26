/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.picturestore.commands;

import de.audi.atip.interapp.picturestore.PictureStoreProviderListener;
import de.audi.tghu.picturestore.PictureStoreProxy;
import de.audi.tghu.picturestore.commands.AbstractPictureStoreCommand;
import org.dsi.ifc.picturestore.DSIPictureStore;

public class CountPicturesInContextCommand
extends AbstractPictureStoreCommand {
    private PictureStoreProxy psp = null;
    private int contextID = -1;
    private int filterSetID = -1;
    private PictureStoreProviderListener callBack = null;

    public CountPicturesInContextCommand(PictureStoreProxy pictureStoreProxy, int n, int n2, PictureStoreProviderListener pictureStoreProviderListener) {
        super(pictureStoreProxy);
        this.psp = pictureStoreProxy;
        this.contextID = n;
        this.filterSetID = n2;
        this.callBack = pictureStoreProviderListener;
    }

    @Override
    public void execute() {
        DSIPictureStore dSIPictureStore = this.psp.getDSIPictureStore();
        if (dSIPictureStore != null) {
            dSIPictureStore.countPicturesInContext(this.contextID, this.filterSetID);
        }
    }

    @Override
    public void countPicturesInContextResult(int n, int n2, int n3) {
        this.callBack.countPicturesInContextResult(n, n2, n3);
        this.commandList.commandFinished();
    }

    @Override
    public void invalidData(int[] nArray, int n) {
    }
}

