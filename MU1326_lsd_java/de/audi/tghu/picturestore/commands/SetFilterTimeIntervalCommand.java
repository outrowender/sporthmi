/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.picturestore.commands;

import de.audi.tghu.picturestore.PictureStoreProxy;
import de.audi.tghu.picturestore.commands.AbstractPictureStoreCommand;
import org.dsi.ifc.picturestore.DSIPictureStore;

public class SetFilterTimeIntervalCommand
extends AbstractPictureStoreCommand {
    private PictureStoreProxy psp = null;
    private int filterSetID = 0;
    private int timeIntervalFilterType = 0;
    private long minUTCTimestampSeconds = 0L;
    private long maxUTCTimestampSeconds = 0L;

    public SetFilterTimeIntervalCommand(PictureStoreProxy pictureStoreProxy, int n, int n2, long l, long l2) {
        super(pictureStoreProxy);
        this.psp = pictureStoreProxy;
        this.filterSetID = n;
        this.timeIntervalFilterType = n2;
        this.minUTCTimestampSeconds = l;
        this.maxUTCTimestampSeconds = l2;
    }

    public void execute() {
        DSIPictureStore dSIPictureStore = this.psp.getDSIPictureStore();
        if (dSIPictureStore != null) {
            dSIPictureStore.setFilterTimeInterval(this.filterSetID, this.timeIntervalFilterType, this.minUTCTimestampSeconds, this.maxUTCTimestampSeconds);
        }
        this.commandList.commandFinished();
    }

    public void invalidData(int[] nArray, int n) {
    }
}

