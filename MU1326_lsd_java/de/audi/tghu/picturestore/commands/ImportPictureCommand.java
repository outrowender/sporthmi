/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.picturestore.commands;

import de.audi.atip.interapp.picturestore.PictureStoreProviderListener;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.picturestore.PictureStoreProxy;
import de.audi.tghu.picturestore.commands.AbstractPictureStoreCommand;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.picturestore.DSIPictureStore;

public class ImportPictureCommand
extends AbstractPictureStoreCommand {
    private PictureStoreProxy psp = null;
    private int contextID = -1;
    private ResourceLocator rl = null;
    private boolean withAutoDelete = false;
    private PictureStoreProviderListener callBack = null;

    public ImportPictureCommand(PictureStoreProxy pictureStoreProxy, LogChannel logChannel, int n, ResourceLocator resourceLocator, boolean bl, PictureStoreProviderListener pictureStoreProviderListener) {
        super(pictureStoreProxy);
        this.psp = pictureStoreProxy;
        this.contextID = n;
        this.rl = resourceLocator;
        this.withAutoDelete = bl;
        this.callBack = pictureStoreProviderListener;
    }

    public void execute() {
        DSIPictureStore dSIPictureStore = this.psp.getDSIPictureStore();
        if (dSIPictureStore != null) {
            dSIPictureStore.importPicture(this.contextID, this.rl, this.withAutoDelete);
        }
    }

    public void importPictureResult(int n, ResourceLocator resourceLocator, ResourceLocator resourceLocator2, int n2) {
        this.callBack.importPictureResult(n, resourceLocator, resourceLocator2, n2);
        this.commandList.commandFinished();
    }

    public void invalidData(int[] nArray, int n) {
    }
}

