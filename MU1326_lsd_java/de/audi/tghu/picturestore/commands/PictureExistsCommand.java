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

public class PictureExistsCommand
extends AbstractPictureStoreCommand {
    private PictureStoreProxy psp = null;
    private ResourceLocator rl = null;
    private PictureStoreProviderListener callBack = null;

    public PictureExistsCommand(PictureStoreProxy pictureStoreProxy, LogChannel logChannel, ResourceLocator resourceLocator, PictureStoreProviderListener pictureStoreProviderListener) {
        super(pictureStoreProxy);
        this.psp = pictureStoreProxy;
        this.rl = resourceLocator;
        this.callBack = pictureStoreProviderListener;
    }

    public void execute() {
        DSIPictureStore dSIPictureStore = this.psp.getDSIPictureStore();
        if (dSIPictureStore != null) {
            dSIPictureStore.pictureExists(this.rl);
        }
    }

    public void pictureExists(ResourceLocator resourceLocator, boolean bl) {
        this.callBack.pictureExists(resourceLocator, bl);
        this.commandList.commandFinished();
    }

    public void invalidData(int[] nArray, int n) {
    }
}

