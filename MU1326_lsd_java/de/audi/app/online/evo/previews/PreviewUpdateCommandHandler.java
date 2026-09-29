/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.online.evo.previews;

import de.audi.app.online.evo.HMIViewGridListener;
import de.audi.app.online.evo.previews.PreviewUpdateTask;
import de.audi.app.online.evo.previews.ReplacePreviewGridCellAction;
import de.audi.atip.log.LogChannel;
import de.audi.remotehmi.IPreviewInfo;
import de.audi.remotehmi.ui.mib2.Commands$StateUpdatePreviewsPayload;
import de.audi.remotehmi.ui.mib2.grid.GeoPosition;
import de.audi.remotehmi.ui.mib2.grid.IGrid;
import de.audi.remotehmi.ui.mib2.grid.IGridCell;
import de.audi.remotehmi.ui.mib2.grid.IGridList;
import de.audi.tghu.online.app.remotehmi.AbstractCommandHandler;
import de.audi.tghu.online.app.remotehmi.ContextManagerComponent;
import de.audi.tghu.online.app.remotehmi.RemoteHMIContext;
import de.audi.tghu.online.app.remotehmi.RemoteHMIService;
import de.audi.tghu.online.app.remotehmi.RemoteHMITask;
import de.audi.tghu.online.app.remotehmi.RrdCalculationHandler;
import java.util.Iterator;
import java.util.List;

public class PreviewUpdateCommandHandler
extends AbstractCommandHandler {
    private final RemoteHMIService remoteHmiService;
    private final RrdCalculationHandler rrdCalculationHandler;
    private final LogChannel logChannel;

    public PreviewUpdateCommandHandler(String string, RemoteHMIService remoteHMIService, RrdCalculationHandler rrdCalculationHandler, LogChannel logChannel) {
        super(string);
        this.remoteHmiService = remoteHMIService;
        this.rrdCalculationHandler = rrdCalculationHandler;
        this.logChannel = logChannel;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void indicateCommand(int n, Object object) {
        boolean bl;
        this.logChannel.log(-2137614336, "PreviewUpdateCommandHandler#indicateCommand called()");
        Commands$StateUpdatePreviewsPayload commands$StateUpdatePreviewsPayload = (Commands$StateUpdatePreviewsPayload)object;
        List list = commands$StateUpdatePreviewsPayload.getPreviews();
        if (list.isEmpty()) {
            this.logChannel.log(1078071040, "PreviewUpdateCommandHandler#indicateCommand: no previews sent. Do nothing");
            return;
        }
        HMIViewGridListener hMIViewGridListener = (HMIViewGridListener)this.remoteHmiService.getViewListener(13000);
        IGridList iGridList = hMIViewGridListener.getCurrentGridList();
        if (iGridList == null) {
            this.logChannel.log(-1601830656, "PreviewUpdateCommandHandler#indicateCommand: no gridList available. Do nothing");
            return;
        }
        Object object2 = iGridList;
        synchronized (object2) {
            bl = this.replacePreviewGrid(list, iGridList);
            iGridList.setDirty(true);
        }
        object2 = this.remoteHmiService.getContextManagerComponent();
        RemoteHMIContext remoteHMIContext = ((ContextManagerComponent)object2).getContext("top_wizard");
        if (remoteHMIContext != null && ((ContextManagerComponent)object2).isContextActive(remoteHMIContext)) {
            hMIViewGridListener.renderGridList(4, 6);
            if (bl) {
                this.logChannel.log(1078071040, "PreviewUpdateCommandHandler#indicateCommand: re-triggered rrd calculation because geo position(s) changed.");
                this.rrdCalculationHandler.triggerRrdCalculation(iGridList);
            }
        } else {
            this.logChannel.log(1078071040, "PreviewUpdateCommandHandler#indicateCommand: not rendering because root context is null or not active.");
        }
    }

    private boolean replacePreviewGrid(List list, IGridList iGridList) {
        boolean bl = false;
        boolean bl2 = false;
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            IPreviewInfo iPreviewInfo = (IPreviewInfo)iterator.next();
            String string = iPreviewInfo.getPrevId();
            IGrid iGrid = iPreviewInfo.getPreviewGrid();
            IGrid iGrid2 = iGrid;
            IGridCell iGridCell = iGrid2.getFirstCell(0);
            this.logChannel.log(1078071040, "PreviewUpdateCommandHandler#replacePreviewGrid: id: %1, first text cell: %2", (Object)string, (Object)(iGridCell == null ? null : iGridCell.getStringValue()));
            IGrid iGrid3 = iGridList.replaceGridNode(string, iGrid2);
            if (iGrid2.hasRRDItems()) {
                bl2 = true;
            }
            if (iGrid3 != null) {
                iGrid2.setVisible(iGrid3.isVisible());
            }
            if (iGrid3 == null || !iGrid2.hasRRDItems()) continue;
            GeoPosition geoPosition = iGrid3.getGeoPosition();
            GeoPosition geoPosition2 = iGrid2.getGeoPosition();
            boolean bl3 = bl = geoPosition2 != null && !geoPosition2.equals(geoPosition);
            if (bl) {
                this.rrdCalculationHandler.updateGrid(iGridList, iGrid3, iGrid2);
                continue;
            }
            iGrid2.forEachCell(new ReplacePreviewGridCellAction(iGrid3, geoPosition2, this.logChannel), -129);
        }
        return bl2;
    }

    @Override
    public RemoteHMITask createTask(int n, Object object) {
        return new PreviewUpdateTask(this, this.getFullName(), n, (Commands$StateUpdatePreviewsPayload)object, this.logChannel);
    }
}

