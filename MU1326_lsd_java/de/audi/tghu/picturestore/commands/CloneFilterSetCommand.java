/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.picturestore.commands;

import de.audi.atip.interapp.picturestore.PictureStoreProviderListener;
import de.audi.tghu.picturestore.PictureStoreProxy;
import de.audi.tghu.picturestore.commands.AbstractPictureStoreCommand;
import org.dsi.ifc.picturestore.DSIPictureStore;

public class CloneFilterSetCommand
extends AbstractPictureStoreCommand {
    private PictureStoreProxy psp = null;
    private int sourceFilterSetID = 0;
    private PictureStoreProviderListener callBack = null;

    public CloneFilterSetCommand(PictureStoreProxy pictureStoreProxy, int n, PictureStoreProviderListener pictureStoreProviderListener) {
        super(pictureStoreProxy);
        this.psp = pictureStoreProxy;
        this.sourceFilterSetID = n;
        this.callBack = pictureStoreProviderListener;
    }

    public void execute() {
        DSIPictureStore dSIPictureStore = this.psp.getDSIPictureStore();
        if (dSIPictureStore != null) {
            dSIPictureStore.cloneFilterSet(this.sourceFilterSetID);
        }
    }

    public void cloneFilterSetResult(int n, int n2) {
        this.callBack.cloneFilterSetResult(n, n2);
        this.commandList.commandFinished();
    }

    public void invalidData(int[] nArray, int n) {
    }
}

