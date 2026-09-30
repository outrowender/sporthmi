/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.picturestore.commands;

import de.audi.tghu.picturestore.PictureStoreProxy;
import de.audi.tghu.picturestore.commands.AbstractPictureStoreCommand;
import org.dsi.ifc.picturestore.DSIPictureStore;

public class SetConfigWithFileTypeCommand
extends AbstractPictureStoreCommand {
    private PictureStoreProxy psp = null;
    private int contextID = 0;
    private int allowedImagesSlotsInContext = 0;
    private int scaleWidth = 0;
    private int scaleHeight = 0;
    private int storePicturesAsFileType = 0;

    public SetConfigWithFileTypeCommand(PictureStoreProxy pictureStoreProxy, int n, int n2, int n3, int n4, int n5) {
        super(pictureStoreProxy);
        this.psp = pictureStoreProxy;
        this.contextID = n;
        this.allowedImagesSlotsInContext = n2;
        this.scaleWidth = n3;
        this.scaleHeight = n4;
        this.storePicturesAsFileType = n5;
    }

    public void execute() {
        DSIPictureStore dSIPictureStore = this.psp.getDSIPictureStore();
        if (dSIPictureStore != null) {
            dSIPictureStore.setConfigWithFileType(this.contextID, this.allowedImagesSlotsInContext, this.scaleWidth, this.scaleHeight, this.storePicturesAsFileType);
        }
        this.commandList.commandFinished();
    }

    public void invalidData(int[] nArray, int n) {
    }
}

