/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.picturestore.commands;

import de.audi.tghu.picturestore.PictureStoreProxy;
import de.audi.tghu.picturestore.commands.AbstractPictureStoreCommand;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.picturestore.DSIPictureStore;

public class DecreaseRefCounterCommand
extends AbstractPictureStoreCommand {
    private PictureStoreProxy psp = null;
    private ResourceLocator resourceLocator = null;
    private int contextID = 0;

    public DecreaseRefCounterCommand(PictureStoreProxy pictureStoreProxy, ResourceLocator resourceLocator, int n) {
        super(pictureStoreProxy);
        this.psp = pictureStoreProxy;
        this.resourceLocator = resourceLocator;
        this.contextID = n;
    }

    @Override
    public void execute() {
        DSIPictureStore dSIPictureStore = this.psp.getDSIPictureStore();
        if (dSIPictureStore != null) {
            dSIPictureStore.decreaseRefCounter(this.resourceLocator, this.contextID);
        }
        this.commandList.commandFinished();
    }

    @Override
    public void invalidData(int[] nArray, int n) {
    }
}

