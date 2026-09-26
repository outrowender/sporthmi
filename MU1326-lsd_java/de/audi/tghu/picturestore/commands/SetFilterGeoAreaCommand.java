/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.picturestore.commands;

import de.audi.tghu.picturestore.PictureStoreProxy;
import de.audi.tghu.picturestore.commands.AbstractPictureStoreCommand;
import org.dsi.ifc.picturestore.DSIPictureStore;

public class SetFilterGeoAreaCommand
extends AbstractPictureStoreCommand {
    private PictureStoreProxy psp = null;
    private int filterSetID = 0;
    private float minLatitudeDecimalDegrees = 0.0f;
    private float maxLatitudeDecimalDegrees = 0.0f;
    private float minLongitudeDecimalDegrees = 0.0f;
    private float maxLongitudeDecimalDegrees = 0.0f;

    public SetFilterGeoAreaCommand(PictureStoreProxy pictureStoreProxy, int n, float f2, float f3, float f4, float f5) {
        super(pictureStoreProxy);
        this.psp = pictureStoreProxy;
        this.filterSetID = n;
        this.minLatitudeDecimalDegrees = f2;
        this.maxLatitudeDecimalDegrees = f3;
        this.minLongitudeDecimalDegrees = f4;
        this.maxLongitudeDecimalDegrees = f5;
    }

    @Override
    public void execute() {
        DSIPictureStore dSIPictureStore = this.psp.getDSIPictureStore();
        if (dSIPictureStore != null) {
            dSIPictureStore.setFilterGeoArea(this.filterSetID, this.minLatitudeDecimalDegrees, this.maxLatitudeDecimalDegrees, this.minLongitudeDecimalDegrees, this.maxLongitudeDecimalDegrees);
        }
        this.commandList.commandFinished();
    }

    @Override
    public void invalidData(int[] nArray, int n) {
    }
}

