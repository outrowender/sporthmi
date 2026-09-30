/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.picturestore.commands;

import de.audi.atip.interapp.picturestore.PictureStoreProviderListener;
import de.audi.tghu.picturestore.PictureStoreProxy;
import de.audi.tghu.picturestore.commands.AbstractPictureStoreCommand;
import org.dsi.ifc.picturestore.DSIPictureStore;

public class GetFreeSlotsCommand
extends AbstractPictureStoreCommand {
    private PictureStoreProxy psp = null;
    private int contextID = -1;
    private PictureStoreProviderListener callBack = null;

    public GetFreeSlotsCommand(PictureStoreProxy pictureStoreProxy, int n, PictureStoreProviderListener pictureStoreProviderListener) {
        super(pictureStoreProxy);
        this.psp = pictureStoreProxy;
        this.contextID = n;
        this.callBack = pictureStoreProviderListener;
    }

    public void execute() {
        DSIPictureStore dSIPictureStore = this.psp.getDSIPictureStore();
        if (dSIPictureStore != null) {
            dSIPictureStore.getFreeSlots(this.contextID);
        }
    }

    public void freeSlots(int n, int n2) {
        this.callBack.freeSlots(n, n2);
        this.commandList.commandFinished();
    }

    public void invalidData(int[] nArray, int n) {
    }
}

