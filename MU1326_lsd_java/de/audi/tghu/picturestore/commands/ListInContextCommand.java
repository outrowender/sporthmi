/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.picturestore.commands;

import de.audi.atip.interapp.picturestore.PictureStoreProviderListener;
import de.audi.tghu.picturestore.PictureStoreProxy;
import de.audi.tghu.picturestore.commands.AbstractPictureStoreCommand;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.picturestore.DSIPictureStore;

public class ListInContextCommand
extends AbstractPictureStoreCommand {
    private PictureStoreProxy psp = null;
    private int contextID = 0;
    private int index = 0;
    private int count = 0;
    private PictureStoreProviderListener callBack = null;

    public ListInContextCommand(PictureStoreProxy pictureStoreProxy, int n, int n2, int n3, PictureStoreProviderListener pictureStoreProviderListener) {
        super(pictureStoreProxy);
        this.psp = pictureStoreProxy;
        this.contextID = n;
        this.index = n2;
        this.count = n3;
        this.callBack = pictureStoreProviderListener;
    }

    @Override
    public void execute() {
        DSIPictureStore dSIPictureStore = this.psp.getDSIPictureStore();
        if (dSIPictureStore != null) {
            dSIPictureStore.listInContext(this.contextID, this.index, this.count);
        }
    }

    @Override
    public void listForContextResult(int n, ResourceLocator[] resourceLocatorArray, int n2) {
        this.callBack.listForContextResult(n, resourceLocatorArray, n2);
        this.commandList.commandFinished();
    }

    @Override
    public void invalidData(int[] nArray, int n) {
    }
}

