/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app;

import de.audi.atip.hmi.model.list.BaseListModelApp;
import de.audi.tuner.app.MemoryListHandler;
import de.audi.tuner.app.MemoryListHandler$1;
import de.audi.tuner.app.memory.AbstractMemoryRow;
import de.audi.tuner.app.memory.SDARSMemoryRow;
import de.audi.tuner.app.sdars.StationInfoExt;
import de.audi.tuner.app.sdars.dsi.SDARSDsiUpInfo;
import org.dsi.ifc.sdars.SeekPossibility;
import org.dsi.ifc.sdars.ServiceStatus3;

class MemoryListHandler$SdarsDsiUpListener
extends SDARSDsiUpInfo {
    ServiceStatus3 serviceStatus = new ServiceStatus3();
    private final /* synthetic */ MemoryListHandler this$0;

    private MemoryListHandler$SdarsDsiUpListener(MemoryListHandler memoryListHandler) {
        this.this$0 = memoryListHandler;
    }

    @Override
    public void updateSignalStatus(boolean bl) {
        MemoryListHandler.access$1902(this.this$0, bl);
    }

    @Override
    public void updateSelectedStation(StationInfoExt stationInfoExt) {
        this.this$0.setCurrentStation(stationInfoExt, 0);
    }

    @Override
    public void updateStationList(StationInfoExt[] stationInfoExtArray) {
        boolean bl = false;
        BaseListModelApp baseListModelApp = MemoryListHandler.access$1700(this.this$0).getCopy();
        for (int i2 = 0; i2 < baseListModelApp.getLength(); ++i2) {
            AbstractMemoryRow abstractMemoryRow = (AbstractMemoryRow)baseListModelApp.getRow(i2);
            if (abstractMemoryRow.getBand() != 7) continue;
            StationInfoExt stationInfoExt = abstractMemoryRow.getTOContainer().getSDARSService();
            StationInfoExt stationInfoExt2 = null;
            for (int i3 = 0; i3 < stationInfoExtArray.length; ++i3) {
                if (stationInfoExt.sID != stationInfoExtArray[i3].sID) continue;
                stationInfoExt2 = stationInfoExtArray[i3];
                break;
            }
            if (!((SDARSMemoryRow)abstractMemoryRow).synchronize(stationInfoExt2)) continue;
            baseListModelApp.setRow(i2, abstractMemoryRow);
            bl = true;
            MemoryListHandler.access$2000(this.this$0).memoryListPresetIndexChanged(i2, abstractMemoryRow.getTOContainer());
        }
        if (bl) {
            MemoryListHandler.access$1700(this.this$0).update(baseListModelApp);
            MemoryListHandler.access$1800(this.this$0);
        }
    }

    @Override
    public void updateServiceStatus3(ServiceStatus3 serviceStatus3) {
        if (this.serviceStatus.antennaStatus != serviceStatus3.antennaStatus) {
            this.serviceStatus = serviceStatus3;
            if (this.serviceStatus.antennaStatus == 1) {
                MemoryListHandler.setSdarsListState(6, MemoryListHandler.access$1700(this.this$0));
            } else {
                MemoryListHandler.setSdarsListState(0, MemoryListHandler.access$1700(this.this$0));
            }
        }
    }

    @Override
    public void updateSeekPossibility(SeekPossibility seekPossibility) {
        MemoryListHandler.access$2100(this.this$0, seekPossibility);
    }

    /* synthetic */ MemoryListHandler$SdarsDsiUpListener(MemoryListHandler memoryListHandler, MemoryListHandler$1 memoryListHandler$1) {
        this(memoryListHandler);
    }
}

