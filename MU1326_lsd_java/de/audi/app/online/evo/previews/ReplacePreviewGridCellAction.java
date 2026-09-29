/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.online.evo.previews;

import de.audi.atip.log.LogChannel;
import de.audi.remotehmi.ui.mib2.grid.GeoPosition;
import de.audi.remotehmi.ui.mib2.grid.IGrid;
import de.audi.remotehmi.ui.mib2.grid.IGridCell;
import de.audi.remotehmi.ui.mib2.grid.IGridCellAction;
import java.util.Iterator;

public class ReplacePreviewGridCellAction
implements IGridCellAction {
    private final IGrid oldGrid;
    private final GeoPosition newPosition;
    private final LogChannel logChannel;

    public ReplacePreviewGridCellAction(IGrid iGrid, GeoPosition geoPosition, LogChannel logChannel) {
        this.oldGrid = iGrid;
        this.newPosition = geoPosition;
        this.logChannel = logChannel;
    }

    @Override
    public boolean modify(IGridCell iGridCell) {
        GeoPosition geoPosition = iGridCell.getGeoPosition();
        if (geoPosition == null) {
            return false;
        }
        int n = iGridCell.getType();
        if (n != 11 && n != 10) {
            return false;
        }
        Iterator iterator = this.oldGrid.iterator();
        while (iterator.hasNext()) {
            GeoPosition geoPosition2;
            IGridCell iGridCell2 = (IGridCell)iterator.next();
            int n2 = iGridCell2.getType();
            if (n2 != iGridCell.getType() || !this.newPosition.equals(geoPosition2 = iGridCell2.getGeoPosition())) continue;
            if (n2 == 11) {
                this.logChannel.log(1078071040, "ReplacePreviewGridCellAction#modify: restored previous rrd image cell arrow direction.");
                iGridCell.setIntValue(iGridCell2.getIntValue());
                break;
            }
            if (n2 != 10) continue;
            this.logChannel.log(1078071040, "ReplacePreviewGridCellAction#modify: restored previous rrd text cell content.");
            iGridCell.setStringValue(iGridCell2.getStringValue());
            break;
        }
        return false;
    }
}

