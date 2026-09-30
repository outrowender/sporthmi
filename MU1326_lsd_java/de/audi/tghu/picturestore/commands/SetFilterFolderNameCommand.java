/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.picturestore.commands;

import de.audi.tghu.picturestore.PictureStoreProxy;
import de.audi.tghu.picturestore.commands.AbstractPictureStoreCommand;
import org.dsi.ifc.picturestore.DSIPictureStore;

public class SetFilterFolderNameCommand
extends AbstractPictureStoreCommand {
    private PictureStoreProxy psp = null;
    private int filterSetID = 0;
    private final String folderName;

    public SetFilterFolderNameCommand(PictureStoreProxy pictureStoreProxy, int n, String string) {
        super(pictureStoreProxy);
        this.psp = pictureStoreProxy;
        this.filterSetID = n;
        this.folderName = string;
    }

    public void execute() {
        DSIPictureStore dSIPictureStore = this.psp.getDSIPictureStore();
        if (dSIPictureStore != null) {
            dSIPictureStore.setFilterFolderName(this.filterSetID, this.folderName);
        }
        this.commandList.commandFinished();
    }

    public void invalidData(int[] nArray, int n) {
    }
}

