/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.picturestore.commands;

import de.audi.atip.interapp.picturestore.PictureStoreProviderListener;
import de.audi.tghu.picturestore.PictureStoreProxy;
import de.audi.tghu.picturestore.commands.AbstractPictureStoreCommand;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.picturestore.DSIPictureStore;
import org.dsi.ifc.picturestore.PictureAttribute;

public class GetPictureAttributesCommand
extends AbstractPictureStoreCommand {
    private PictureStoreProxy psp = null;
    private ResourceLocator resourceLocator = null;
    private PictureStoreProviderListener callBack = null;

    public GetPictureAttributesCommand(PictureStoreProxy pictureStoreProxy, ResourceLocator resourceLocator, PictureStoreProviderListener pictureStoreProviderListener) {
        super(pictureStoreProxy);
        this.psp = pictureStoreProxy;
        this.resourceLocator = resourceLocator;
        this.callBack = pictureStoreProviderListener;
    }

    public void execute() {
        DSIPictureStore dSIPictureStore = this.psp.getDSIPictureStore();
        if (dSIPictureStore != null) {
            dSIPictureStore.getPictureAttributes(this.resourceLocator);
        }
    }

    public void getPictureAttributesResult(ResourceLocator resourceLocator, PictureAttribute[] pictureAttributeArray, int n) {
        this.callBack.getPictureAttributesResult(resourceLocator, pictureAttributeArray, n);
        this.commandList.commandFinished();
    }

    public void invalidData(int[] nArray, int n) {
    }
}

