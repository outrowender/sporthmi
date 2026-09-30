/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.picturestore.commands;

import de.audi.atip.interapp.picturestore.PictureStoreProviderListener;
import de.audi.tghu.picturestore.PictureStoreProxy;
import de.audi.tghu.picturestore.commands.AbstractPictureStoreCommand;
import org.dsi.ifc.picturestore.DSIPictureStore;

public class CreateFilterSetCommand
extends AbstractPictureStoreCommand {
    private PictureStoreProxy psp = null;
    private PictureStoreProviderListener callBack = null;

    public CreateFilterSetCommand(PictureStoreProxy pictureStoreProxy, PictureStoreProviderListener pictureStoreProviderListener) {
        super(pictureStoreProxy);
        this.psp = pictureStoreProxy;
        this.callBack = pictureStoreProviderListener;
    }

    public void execute() {
        DSIPictureStore dSIPictureStore = this.psp.getDSIPictureStore();
        if (dSIPictureStore != null) {
            dSIPictureStore.createFilterSet();
        }
    }

    public void createFilterSetResult(int n) {
        this.callBack.createFilterSetResult(n);
        this.commandList.commandFinished();
    }

    public void invalidData(int[] nArray, int n) {
    }
}

