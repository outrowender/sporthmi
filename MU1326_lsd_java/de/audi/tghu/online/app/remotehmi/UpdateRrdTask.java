/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.remotehmi;

import de.audi.atip.interapp.NaviOnlineService$RrdData;
import de.audi.atip.log.LogChannel;
import de.audi.atip.util.Util;
import de.audi.remotehmi.ui.mib2.grid.IGrid;
import de.audi.remotehmi.ui.mib2.grid.IGridCell;
import de.audi.remotehmi.ui.mib2.grid.IGridList;
import de.audi.tghu.online.app.remotehmi.AbstractHMIViewListener;
import de.audi.tghu.online.app.remotehmi.AbstractRemoteHMITask;
import de.audi.tghu.online.app.remotehmi.RemoteHMITask;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class UpdateRrdTask
extends AbstractRemoteHMITask {
    private static final int UPDATE_DELAY_MILLISECONDS;
    private List rrdItems;
    private final boolean coalesce;
    private AbstractHMIViewListener abstractHMIViewListener;
    private LogChannel logChannel;
    private boolean updateImmediately;

    public UpdateRrdTask(List list, boolean bl, AbstractHMIViewListener abstractHMIViewListener) {
        this(list, bl, abstractHMIViewListener, false);
    }

    public UpdateRrdTask(List list, boolean bl, AbstractHMIViewListener abstractHMIViewListener, boolean bl2) {
        super("update-rdd-items");
        this.updateImmediately = bl2;
        this.coalesce = bl;
        this.rrdItems = list == null ? new ArrayList() : new ArrayList(list);
        this.abstractHMIViewListener = abstractHMIViewListener;
        this.logChannel = abstractHMIViewListener.logChannel;
    }

    @Override
    public void run() {
        this.updateRrdItemsImmediately(this.rrdItems);
    }

    @Override
    public boolean isCoalescable() {
        return this.coalesce;
    }

    @Override
    public boolean coalesceWith(RemoteHMITask remoteHMITask) {
        if (!this.coalesce) {
            return false;
        }
        if (!(remoteHMITask instanceof UpdateRrdTask)) {
            return false;
        }
        UpdateRrdTask updateRrdTask = (UpdateRrdTask)remoteHMITask;
        Iterator iterator = this.rrdItems.iterator();
        while (iterator.hasNext()) {
            Object object = iterator.next();
            if (!(object instanceof NaviOnlineService$RrdData)) continue;
            NaviOnlineService$RrdData naviOnlineService$RrdData = (NaviOnlineService$RrdData)object;
            List list = updateRrdTask.rrdItems;
            boolean bl = false;
            int n = list.size();
            for (int i2 = 0; i2 < n; ++i2) {
                Object object2 = list.get(i2);
                if (!(object2 instanceof NaviOnlineService$RrdData)) continue;
                NaviOnlineService$RrdData naviOnlineService$RrdData2 = (NaviOnlineService$RrdData)object2;
                Object object3 = naviOnlineService$RrdData2.getModel();
                Object object4 = naviOnlineService$RrdData.getModel();
                if (object4 == null || object4 != object3) continue;
                list.set(i2, naviOnlineService$RrdData);
                bl = true;
            }
            if (bl) continue;
            list.add(naviOnlineService$RrdData);
        }
        this.logChannel.log(1078071040, "UpdateRrdTask$coalesceWith: coalesced %1 rrd items", (long)this.rrdItems.size());
        return true;
    }

    @Override
    public Long getDelayMillis() {
        return this.updateImmediately ? null : new Long(0);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void updateRrdItemsImmediately(List list) {
        IGridList iGridList = this.abstractHMIViewListener.getCurrentGridList();
        if (iGridList == null) {
            this.logChannel.log(-1601830656, "UpdateRrdTask#updateRrdItemsImmediately: current grid list is null");
            return;
        }
        int n = 0;
        int n2 = 0;
        IGridList iGridList2 = iGridList;
        synchronized (iGridList2) {
            ListIterator listIterator = list.listIterator();
            while (listIterator.hasNext()) {
                Object object;
                Object object2;
                Object object3 = listIterator.next();
                Integer n3 = Util.createInteger(listIterator.previousIndex());
                if (!(object3 instanceof NaviOnlineService$RrdData)) {
                    this.logChannel.log(-1601830656, "UpdateRrdTask#updateRrdItemsImmediately: list entry number %1 is not instance of RrdData: entry=%2", (Object)n3, object3);
                    continue;
                }
                NaviOnlineService$RrdData naviOnlineService$RrdData = (NaviOnlineService$RrdData)object3;
                Object object4 = naviOnlineService$RrdData.getModel();
                if (!(object4 instanceof IGrid)) {
                    this.logChannel.log(-1601830656, "UpdateRrdTask#updateRrdItemsImmediately: model not instance of IGrid: entry %1, model=%2", (Object)n3, object4);
                    continue;
                }
                IGrid iGrid = (IGrid)object4;
                String string = iGrid.getId();
                Object object5 = naviOnlineService$RrdData.getModelContainer();
                if (!(object5 instanceof IGridList)) {
                    this.logChannel.log(-1601830656, "UpdateRrdTask#updateRrdItemsImmediately: container not instance of IGridList: entry %1, id=%2, container=%3", (Object)n3, (Object)string, object5);
                    continue;
                }
                IGridList iGridList3 = (IGridList)object5;
                if (iGridList3 != iGridList) {
                    object2 = Util.createInteger(iGridList3.getIdRangeStart());
                    object = Util.createInteger(iGridList.getIdRangeStart());
                    this.logChannel.log(-2137614336, "UpdateRrdTask#updateRrdItemsImmediately: entry grid list != current grid list : entry %1, id=%2, entryGridList.start=%3, currentGridList.start=%4", (Object)n3, (Object)string, object2, object);
                    continue;
                }
                if (naviOnlineService$RrdData.getIdRangeStart() != iGridList.getIdRangeStart()) {
                    this.logChannel.log(-2137614336, "UpdateRrdTask#updateRrdItemsImmediately: ID range start invalid, skip update");
                    continue;
                }
                this.logChannel.log(1078071040, "UpdateRrdTask#updateRrdItemsImmediately: start applying changes for entry %1, id=%2", (Object)n3, (Object)string);
                object2 = naviOnlineService$RrdData.getAirDistance();
                object = naviOnlineService$RrdData.getRrdDistance();
                int n4 = naviOnlineService$RrdData.getAirDirection();
                Object object6 = object == null ? object2 : object;
                int n5 = object == null ? n4 : n4 + 8;
                Integer n6 = Util.createInteger(n5);
                String string2 = object == null ? "AD" : "RRD";
                IGridCell iGridCell = iGrid.getFirstCell(0);
                String string3 = iGridCell == null ? "?" : iGridCell.getStringValue();
                boolean bl = false;
                Iterator iterator = iGrid.iterator();
                while (iterator.hasNext()) {
                    String string4;
                    IGridCell iGridCell2 = (IGridCell)iterator.next();
                    int n7 = iGridCell2.getType();
                    if (n7 == 11) {
                        int n8 = iGridCell2.getIntValue();
                        if (n8 == n5) continue;
                        iGridCell2.setIntValue(n5);
                        this.logChannel.log(1078071040, "UpdateRrdTask#updateRrdItemsImmediately: updating %1 direction to %2 for %3", (Object)string2, (Object)n6, (Object)string3);
                        ++n;
                        bl = true;
                        continue;
                    }
                    if (n7 != 10 || (string4 = iGridCell2.getStringValue()) != null && string4.equals(object6)) continue;
                    iGridCell2.setStringValue((String)object6);
                    iGridCell2.setLabelText((String)object6);
                    this.logChannel.log(1078071040, "UpdateRrdTask#updateRrdItemsImmediately: updating %1 distance to %2 for %3", (Object)string2, object6, (Object)string3);
                    ++n;
                    bl = true;
                }
                if (bl) {
                    ++n2;
                }
                this.logChannel.log(1078071040, "UpdateRrdTask#updateRrdItemsImmediately: stop applying changes for entry %1, id=%2", (Object)n3, (Object)string);
            }
        }
        this.logChannel.log(1078071040, "UpdateRrdTask#updateRrdItemsImmediately: summary: %1 cell changes done. Applied RRD data entries = %2 of %3, grid list size = %4.", (Object)Util.createInteger(n), (Object)Util.createInteger(n2), (Object)Util.createInteger(list.size()), (Object)Util.createInteger(iGridList.size()));
        if (n > 0) {
            this.abstractHMIViewListener.renderGridList(3, 5);
        }
    }
}

