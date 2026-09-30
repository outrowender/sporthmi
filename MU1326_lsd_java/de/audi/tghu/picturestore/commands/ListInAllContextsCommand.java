/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.picturestore.commands;

import de.audi.atip.interapp.picturestore.PictureStoreProviderListener;
import de.audi.tghu.picturestore.PictureStoreProxy;
import de.audi.tghu.picturestore.commands.AbstractPictureStoreCommand;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.picturestore.DSIPictureStore;

public class ListInAllContextsCommand
extends AbstractPictureStoreCommand {
    private PictureStoreProxy psp = null;
    private int index = 0;
    private int count = 0;
    private PictureStoreProviderListener callBack = null;

    public ListInAllContextsCommand(PictureStoreProxy pictureStoreProxy, int n, int n2, PictureStoreProviderListener pictureStoreProviderListener) {
        super(pictureStoreProxy);
        this.psp = pictureStoreProxy;
        this.index = n;
        this.count = n2;
        this.callBack = pictureStoreProviderListener;
    }

    public void execute() {
        DSIPictureStore dSIPictureStore = this.psp.getDSIPictureStore();
        if (dSIPictureStore != null) {
            dSIPictureStore.listInAllContexts(this.index, this.count);
        }
    }

    public void listResult(ResourceLocator[] resourceLocatorArray, int n) {
        this.callBack.listResult(resourceLocatorArray, n);
        this.commandList.commandFinished();
    }

    public void invalidData(int[] nArray, int n) {
    }
}

