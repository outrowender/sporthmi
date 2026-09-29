/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.picturestore.commands;

import de.audi.atip.interapp.picturestore.PictureStoreProviderListener;
import de.audi.tghu.picturestore.PictureStoreProxy;
import de.audi.tghu.picturestore.commands.AbstractPictureStoreCommand;
import org.dsi.ifc.picturestore.DSIPictureStore;
import org.dsi.ifc.picturestore.GeoPicture;

public class GetRectanglePictureGridCommand
extends AbstractPictureStoreCommand {
    private PictureStoreProxy psp = null;
    private int contextID = 0;
    private int filterSetID = 0;
    private float minLatitudeDecimalDegrees = 0.0f;
    private float maxLatitudeDecimalDegrees = 0.0f;
    private float minLongitudeDecimalDegrees = 0.0f;
    private float maxLongitudeDecimalDegrees = 0.0f;
    private int numberOfGridCellsInLatitude = 0;
    private int numberOfGridCellsInLongitude = 0;
    private int maxNumberOfPicturesPerGridCell = 0;
    private PictureStoreProviderListener callBack = null;

    public GetRectanglePictureGridCommand(PictureStoreProxy pictureStoreProxy, int n, int n2, float f2, float f3, float f4, float f5, int n3, int n4, int n5, PictureStoreProviderListener pictureStoreProviderListener) {
        super(pictureStoreProxy);
        this.psp = pictureStoreProxy;
        this.contextID = n;
        this.filterSetID = n2;
        this.minLatitudeDecimalDegrees = f2;
        this.maxLatitudeDecimalDegrees = f3;
        this.minLongitudeDecimalDegrees = f4;
        this.maxLongitudeDecimalDegrees = f5;
        this.numberOfGridCellsInLatitude = n3;
        this.numberOfGridCellsInLongitude = n4;
        this.maxNumberOfPicturesPerGridCell = n5;
        this.callBack = pictureStoreProviderListener;
    }

    @Override
    public void execute() {
        DSIPictureStore dSIPictureStore = this.psp.getDSIPictureStore();
        if (dSIPictureStore != null) {
            dSIPictureStore.getRectanglePicturesGrid(this.contextID, this.filterSetID, this.minLatitudeDecimalDegrees, this.maxLatitudeDecimalDegrees, this.minLongitudeDecimalDegrees, this.maxLongitudeDecimalDegrees, this.numberOfGridCellsInLatitude, this.numberOfGridCellsInLongitude, this.maxNumberOfPicturesPerGridCell);
        }
    }

    @Override
    public void getRectanglePicturesGridResult(GeoPicture[] geoPictureArray) {
        this.callBack.getRectanglePicturesGridResult(geoPictureArray);
        this.commandList.commandFinished();
    }

    @Override
    public void invalidData(int[] nArray, int n) {
    }
}

