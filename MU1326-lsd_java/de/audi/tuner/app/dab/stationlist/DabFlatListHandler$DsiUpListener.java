/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.dab.stationlist;

import de.audi.tuner.app.Utilities;
import de.audi.tuner.app.dab.DABDsiUpInfo;
import de.audi.tuner.app.dab.DabReceptionStatus;
import de.audi.tuner.app.dab.DabStation;
import de.audi.tuner.app.dab.stationlist.DabFlatListHandler;
import de.audi.tuner.app.dab.stationlist.DabFlatListHandler$1;
import de.esolutions.fw.util.commons.SimpleIntObjectMap;
import java.util.List;

class DabFlatListHandler$DsiUpListener
extends DABDsiUpInfo {
    private final /* synthetic */ DabFlatListHandler this$0;

    private DabFlatListHandler$DsiUpListener(DabFlatListHandler dabFlatListHandler) {
        this.this$0 = dabFlatListHandler;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void listUpdate(DabStation[] dabStationArray, DabStation[] dabStationArray2, DabStation[] dabStationArray3) {
        List list = DabFlatListHandler.access$500(this.this$0);
        synchronized (list) {
            DabStation[] dabStationArray4 = Utilities.isPGen1OrBentley() ? dabStationArray2 : this.removeDoubleServices(dabStationArray2);
            DabFlatListHandler.access$602(this.this$0, new DabStation[dabStationArray4.length + dabStationArray3.length]);
            System.arraycopy((Object)dabStationArray4, 0, (Object)DabFlatListHandler.access$600(this.this$0), 0, dabStationArray4.length);
            System.arraycopy((Object)dabStationArray3, 0, (Object)DabFlatListHandler.access$600(this.this$0), dabStationArray4.length, dabStationArray3.length);
            DabFlatListHandler.access$700(this.this$0);
        }
    }

    private DabStation[] removeDoubleServices(DabStation[] dabStationArray) {
        SimpleIntObjectMap simpleIntObjectMap = new SimpleIntObjectMap(dabStationArray.length);
        for (int i2 = 0; i2 < dabStationArray.length; ++i2) {
            simpleIntObjectMap.add((int)dabStationArray[i2].service.sID, dabStationArray[i2]);
        }
        Object[] objectArray = simpleIntObjectMap.getValues();
        DabStation[] dabStationArray2 = new DabStation[objectArray.length];
        for (int i3 = 0; i3 < dabStationArray2.length; ++i3) {
            dabStationArray2[i3] = (DabStation)objectArray[i3];
        }
        return dabStationArray2;
    }

    @Override
    public void updateCurrentStation(DabStation dabStation, DabReceptionStatus dabReceptionStatus) {
        this.this$0.highlightItem(dabStation, dabReceptionStatus);
    }

    /* synthetic */ DabFlatListHandler$DsiUpListener(DabFlatListHandler dabFlatListHandler, DabFlatListHandler$1 dabFlatListHandler$1) {
        this(dabFlatListHandler);
    }
}

