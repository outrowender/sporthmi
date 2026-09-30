/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.picturestore.commands;

import de.audi.tghu.picturestore.PictureStoreProxy;
import de.audi.tghu.picturestore.commands.AbstractPictureStoreCommand;
import org.dsi.ifc.picturestore.DSIPictureStore;

public class SetFilterImportSourceCommand
extends AbstractPictureStoreCommand {
    private PictureStoreProxy psp = null;
    private int filterSetID = 0;
    private int importSources = 0;

    public SetFilterImportSourceCommand(PictureStoreProxy pictureStoreProxy, int n, int n2) {
        super(pictureStoreProxy);
        this.psp = pictureStoreProxy;
        this.filterSetID = n;
        this.importSources = n2;
    }

    public void execute() {
        DSIPictureStore dSIPictureStore = this.psp.getDSIPictureStore();
        if (dSIPictureStore != null) {
            dSIPictureStore.setFilterImportSource(this.filterSetID, this.importSources);
        }
        this.commandList.commandFinished();
    }

    public void invalidData(int[] nArray, int n) {
    }
}

