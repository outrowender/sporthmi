/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.picturestore.commands;

import de.audi.atip.interapp.picturestore.PictureStoreProviderListener;
import de.audi.tghu.picturestore.PictureStoreProxy;
import de.audi.tghu.picturestore.commands.AbstractPictureStoreCommand;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.picturestore.DSIPictureStore;

public class ListInContextWithFilterCommand
extends AbstractPictureStoreCommand {
    private PictureStoreProxy psp = null;
    private int contextID = 0;
    private int filterSetID = 0;
    private int index = 0;
    private int count = 0;
    private PictureStoreProviderListener callBack = null;

    public ListInContextWithFilterCommand(PictureStoreProxy pictureStoreProxy, int n, int n2, int n3, int n4, PictureStoreProviderListener pictureStoreProviderListener) {
        super(pictureStoreProxy);
        this.psp = pictureStoreProxy;
        this.contextID = n;
        this.index = n3;
        this.filterSetID = n2;
        this.count = n4;
        this.callBack = pictureStoreProviderListener;
    }

    public void execute() {
        DSIPictureStore dSIPictureStore = this.psp.getDSIPictureStore();
        if (dSIPictureStore != null) {
            dSIPictureStore.listInContextWithFilter(this.contextID, this.filterSetID, this.index, this.count);
        }
    }

    public void listForContextWithFilterResult(int n, ResourceLocator[] resourceLocatorArray, int n2) {
        this.callBack.listForContextWithFilterResult(n, resourceLocatorArray, n2);
        this.commandList.commandFinished();
    }

    public void invalidData(int[] nArray, int n) {
    }
}

