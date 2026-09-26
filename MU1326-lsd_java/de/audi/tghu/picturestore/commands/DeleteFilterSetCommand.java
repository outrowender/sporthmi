/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.picturestore.commands;

import de.audi.tghu.picturestore.PictureStoreProxy;
import de.audi.tghu.picturestore.commands.AbstractPictureStoreCommand;
import org.dsi.ifc.picturestore.DSIPictureStore;

public class DeleteFilterSetCommand
extends AbstractPictureStoreCommand {
    private PictureStoreProxy psp = null;
    private int filterSetID = 0;

    public DeleteFilterSetCommand(PictureStoreProxy pictureStoreProxy, int n) {
        super(pictureStoreProxy);
        this.psp = pictureStoreProxy;
        this.filterSetID = n;
    }

    @Override
    public void execute() {
        DSIPictureStore dSIPictureStore = this.psp.getDSIPictureStore();
        if (dSIPictureStore != null) {
            dSIPictureStore.deleteFilterSet(this.filterSetID);
        }
        this.commandList.commandFinished();
    }

    @Override
    public void invalidData(int[] nArray, int n) {
    }
}

