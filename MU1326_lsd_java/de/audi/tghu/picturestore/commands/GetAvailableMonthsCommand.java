/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.picturestore.commands;

import de.audi.atip.interapp.picturestore.PictureStoreProviderListener;
import de.audi.tghu.picturestore.PictureStoreProxy;
import de.audi.tghu.picturestore.commands.AbstractPictureStoreCommand;
import org.dsi.ifc.picturestore.DSIPictureStore;

public class GetAvailableMonthsCommand
extends AbstractPictureStoreCommand {
    private PictureStoreProxy psp = null;
    private int contextID = -1;
    private int year = 0;
    private int timeIntervalFilterType = 0;
    private PictureStoreProviderListener callBack = null;

    public GetAvailableMonthsCommand(PictureStoreProxy pictureStoreProxy, int n, int n2, int n3, PictureStoreProviderListener pictureStoreProviderListener) {
        super(pictureStoreProxy);
        this.psp = pictureStoreProxy;
        this.contextID = n;
        this.year = n2;
        this.timeIntervalFilterType = n3;
        this.callBack = pictureStoreProviderListener;
    }

    public void execute() {
        DSIPictureStore dSIPictureStore = this.psp.getDSIPictureStore();
        if (dSIPictureStore != null) {
            dSIPictureStore.getAvailableMonths(this.contextID, this.year, this.timeIntervalFilterType);
        }
    }

    public void getAvailableMonthsResult(int[] nArray) {
        this.callBack.getAvailableMonthsResult(nArray);
        this.commandList.commandFinished();
    }

    public void invalidData(int[] nArray, int n) {
    }
}

