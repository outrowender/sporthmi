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

public class ImportPictureFromSourceCommand
extends AbstractPictureStoreCommand {
    private PictureStoreProxy psp = null;
    private LogChannel logChannel = null;
    private int contextID = -1;
    private ResourceLocator rl = null;
    private boolean withAutoDelete = false;
    private int importSource = 0;
    private String folderName = null;
    private PictureStoreProviderListener callBack = null;

    public ImportPictureFromSourceCommand(PictureStoreProxy pictureStoreProxy, LogChannel logChannel, int n, ResourceLocator resourceLocator, boolean bl, int n2, String string, PictureStoreProviderListener pictureStoreProviderListener) {
        super(pictureStoreProxy);
        this.psp = pictureStoreProxy;
        this.logChannel = logChannel;
        this.contextID = n;
        this.rl = resourceLocator;
        this.withAutoDelete = bl;
        this.importSource = n2;
        this.folderName = string;
        this.callBack = pictureStoreProviderListener;
    }

    public void execute() {
        DSIPictureStore dSIPictureStore = this.psp.getDSIPictureStore();
        if (dSIPictureStore != null) {
            dSIPictureStore.importPictureFromSource(this.contextID, this.rl, this.withAutoDelete, this.importSource, this.folderName);
        }
    }

    public void importPictureFromSourceResult(int n, ResourceLocator resourceLocator, ResourceLocator resourceLocator2, int n2) {
        this.callBack.importPictureFromSourceResult(n, resourceLocator, resourceLocator2, n2);
        this.commandList.commandFinished();
    }

    public void invalidData(int[] nArray, int n) {
    }
}

