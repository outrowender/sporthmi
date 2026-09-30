/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.swdl.app.list;

import de.audi.atip.hmi.model.BaseListRow;
import de.audi.atip.hmi.model.IntegerListCell;
import de.audi.atip.hmi.model.ListCell;
import de.audi.atip.hmi.model.ModelException;
import de.audi.atip.hmi.model.TextListCell;
import de.audi.atip.hmi.modelaccess.ListModelApp;
import de.audi.tghu.swdl.app.SwdlEnv;
import de.audi.tghu.swdl.app.hmiswitcher.manager.IProgressManager;
import de.audi.tghu.swdl.app.list.AbstractSwdlListHandler;
import de.audi.tghu.swdl.app.list.ISwdlListItem;
import de.audi.tghu.swdl.app.list.SwdlListItemProgress;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import org.dsi.ifc.swdlprogress.DeviceOverviewProgress;

public class SwdlListHandlerProgress
extends AbstractSwdlListHandler {
    private IProgressManager progressManager = null;
    private BaseListRow focusProgressRow = null;

    public SwdlListHandlerProgress(SwdlEnv swdlEnv, IProgressManager iProgressManager, ListModelApp listModelApp) {
        super(swdlEnv, listModelApp, listModelApp.getID(), 7);
        this.progressManager = iProgressManager;
    }

    final IProgressManager getProgressManager() {
        return this.progressManager;
    }

    public ListCell[] getNewRow() {
        ListCell[] listCellArray = new ListCell[this.getNrCol()];
        listCellArray[0] = new IntegerListCell(-1, 99);
        listCellArray[1] = new TextListCell("");
        listCellArray[2] = new TextListCell("");
        listCellArray[3] = new IntegerListCell(0, 0);
        listCellArray[4] = new TextListCell("");
        listCellArray[5] = new IntegerListCell(0, 0);
        listCellArray[6] = new IntegerListCell(0, 2);
        return listCellArray;
    }

    void logList(String string, DeviceOverviewProgress[] deviceOverviewProgressArray) {
        this.getLogHMI().log(10000000, "[SwdlListHandlerProgress] New %1 list received. ", (Object)string);
        if (this.getLogHMI().getCurrentLogThreshold() == 100000000) {
            for (int i2 = 0; i2 < deviceOverviewProgressArray.length; ++i2) {
                this.getLogHMI().log(100000000, "[SwdlListHandlerProgress] %1 %2 %3", (Object)deviceOverviewProgressArray[i2].fileName, (Object)new Integer(deviceOverviewProgressArray[i2].type), (long)deviceOverviewProgressArray[i2].value);
            }
        }
    }

    private DeviceOverviewProgress[] checkRemovedDevices(DeviceOverviewProgress[] deviceOverviewProgressArray) {
        ArrayList arrayList = new ArrayList(deviceOverviewProgressArray.length);
        Iterator iterator = Arrays.asList(deviceOverviewProgressArray).iterator();
        while (iterator.hasNext()) {
            DeviceOverviewProgress deviceOverviewProgress = (DeviceOverviewProgress)iterator.next();
            if (deviceOverviewProgress.getValue() <= -1) continue;
            arrayList.add(deviceOverviewProgress);
        }
        return (DeviceOverviewProgress[])arrayList.toArray(new DeviceOverviewProgress[arrayList.size()]);
    }

    public void updateList(DeviceOverviewProgress[] deviceOverviewProgressArray) {
        this.logList("Progress", deviceOverviewProgressArray);
        if (deviceOverviewProgressArray == null || deviceOverviewProgressArray.length == 0) {
            this.reset();
            return;
        }
        DeviceOverviewProgress[] deviceOverviewProgressArray2 = this.checkRemovedDevices(deviceOverviewProgressArray);
        this.adjustListLength(deviceOverviewProgressArray2.length);
        if (this.checkBase()) {
            ISwdlListItem[] iSwdlListItemArray = new SwdlListItemProgress[deviceOverviewProgressArray2.length];
            for (int i2 = 0; i2 < deviceOverviewProgressArray2.length; ++i2) {
                iSwdlListItemArray[i2] = new SwdlListItemProgress(this.progressManager, this.getBase(), i2, this.checkOverviewProgress(deviceOverviewProgressArray2[i2]));
            }
            this.setEntries(iSwdlListItemArray);
            this.updateList();
        }
    }

    private DeviceOverviewProgress checkOverviewProgress(DeviceOverviewProgress deviceOverviewProgress) {
        if (deviceOverviewProgress.value < 0) {
            this.getLogHMI().log(10000, "[SwdlListHandlerProgress] checkOverviewProgress(%1): negative progress!", (Object)deviceOverviewProgress);
            deviceOverviewProgress.value = 0;
        } else if (deviceOverviewProgress.value > 100 && deviceOverviewProgress.type == 1) {
            this.getLogHMI().log(10000, "[SwdlListHandlerProgress] checkOverviewProgress(%1): progress > 100%!!!", (Object)deviceOverviewProgress);
            deviceOverviewProgress.value = 100;
        }
        return deviceOverviewProgress;
    }

    public void itemFocused(int n, int n2, int n3, int n4) {
        if (this.getListId() != n) {
            this.getLogHMI().log(100000, "[SwdlListHandlerProgress] itemFocused called at wrong handler! modelID %1 expected ModelID %2 ", (long)n, (long)this.getListId());
        } else {
            this.getLogHMI().log(10000000, "[SwdlListHandlerProgress] itemFocused(): rowId=%1", (long)n2);
            try {
                this.focusProgressRow = this.getList().getRow(n2);
            }
            catch (ModelException modelException) {
                this.focusProgressRow = null;
            }
        }
    }

    public String getSelectedDevice() {
        String string = "";
        BaseListRow baseListRow = this.focusProgressRow;
        try {
            if (baseListRow == null) {
                baseListRow = this.getList().getRow(0);
            }
        }
        catch (ModelException modelException) {
            // empty catch block
        }
        if (baseListRow != null) {
            int n;
            ListCell[] listCellArray = baseListRow.getCells();
            String string2 = ((TextListCell)listCellArray[1]).getText();
            int n2 = string2.indexOf(47);
            if (n2 > 0) {
                string2 = string2.substring(0, n2);
            }
            if ((n = string2.indexOf(58)) < 0) {
                string2 = string2 + ":0";
            }
            string = string2;
        }
        return string;
    }
}

