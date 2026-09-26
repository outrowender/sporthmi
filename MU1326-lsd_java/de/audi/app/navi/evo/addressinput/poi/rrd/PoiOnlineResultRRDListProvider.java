/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.addressinput.poi.rrd;

import de.audi.app.navi.evo.poi.online.PoiOnlineListRow;
import de.audi.atip.hmi.model.BaseListRow;
import de.audi.atip.hmi.modelaccess.ListModelApp;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.addressinput.poi.rrd.IRRDListProvider;
import de.audi.tghu.navi.app.guidance.IVehicle;
import de.audi.tghu.navi.app.slidinglist.poi.DistanceUtil;
import java.util.ArrayList;
import org.dsi.ifc.global.NavLocationWgs84;
import org.dsi.ifc.navigation.PosPosition;
import org.dsi.ifc.navigation.RrdCalculationInfo;

public class PoiOnlineResultRRDListProvider
implements IRRDListProvider {
    private static final int CALCULATION_LIMIT_POI_RESULT;
    private final LogChannel poiLogChannel;
    private final NavigationEnv env;
    private final int modelID;
    private final IVehicle vehicle;

    public PoiOnlineResultRRDListProvider(NavigationEnv navigationEnv, int n, IVehicle iVehicle) {
        this.env = navigationEnv;
        this.modelID = n;
        this.vehicle = iVehicle;
        this.poiLogChannel = navigationEnv.getPOILogChannel();
    }

    @Override
    public NavLocationWgs84[] getRRDCalculationList() {
        this.poiLogChannel.log(-2137614336, "PoiOnlineResultRRDListProvider#getRRDCalculationList()");
        ListModelApp listModelApp = this.env.getListModel(this.modelID);
        ArrayList arrayList = new ArrayList();
        int n = Math.min(10, listModelApp.getLength());
        for (int i2 = 0; i2 < n; ++i2) {
            BaseListRow baseListRow = listModelApp.getRow(i2);
            if (baseListRow == null) continue;
            if (!(baseListRow instanceof PoiOnlineListRow)) {
                this.poiLogChannel.log(-2137614336, "PoiOnlineResultRRDListProvider#getRRDCalculationList() Row is not null. But its not an instance of PoiOnlineListRow %1", (Object)super.getClass().getName());
                continue;
            }
            PoiOnlineListRow poiOnlineListRow = (PoiOnlineListRow)baseListRow;
            arrayList.add(new NavLocationWgs84(poiOnlineListRow.getLongitude(), poiOnlineListRow.getLatitude()));
        }
        return (NavLocationWgs84[])arrayList.toArray(new NavLocationWgs84[arrayList.size()]);
    }

    @Override
    public void updateDirectionAndAirDistance(PosPosition posPosition) {
        this.poiLogChannel.log(-2137614336, "PoiOnlineResultRRDListProvider#updateDirectionAndAirDistance(%1)", (Object)posPosition);
        ListModelApp listModelApp = this.env.getListModel(this.modelID);
        if (listModelApp == null) {
            this.poiLogChannel.log(-1601830656, "PoiOnlineResultRRDListProvider#updateDirectionAndAirDistance tiledListModel with ID = %1 is null", (long)this.modelID);
            return;
        }
        for (int i2 = 0; i2 < listModelApp.getLength(); ++i2) {
            BaseListRow baseListRow = listModelApp.getRow(i2);
            if (baseListRow == null) continue;
            if (!(baseListRow instanceof PoiOnlineListRow)) {
                this.poiLogChannel.log(-2137614336, "PoiOnlineResultRRDListProvider#getAllVisibleRowsFromListModel() Row is not null. But its not an instance of PoiOnlineListRow %1", (Object)super.getClass().getName());
                continue;
            }
            PoiOnlineListRow poiOnlineListRow = (PoiOnlineListRow)baseListRow;
            poiOnlineListRow.updateDirection(posPosition);
            poiOnlineListRow.updateAirDistance(posPosition);
            listModelApp.setRow(i2, poiOnlineListRow);
        }
        this.poiLogChannel.log(-2137614336, "PoiOnlineResultRRDListProvider#updateDirectionAndAirDistance: finished");
    }

    @Override
    public int getRRDListCalculationLimit() {
        this.poiLogChannel.log(-2137614336, "PoiOnlineResultRRDListProvider#getRRDListCalculationLimit()");
        return 10;
    }

    @Override
    public void updateRRDDistances(RrdCalculationInfo[] rrdCalculationInfoArray) {
        this.poiLogChannel.log(-2137614336, "PoiOnlineResultRRDListProvider#updateRRDDistances(%1)", (Object)rrdCalculationInfoArray);
        ListModelApp listModelApp = this.env.getListModel(this.modelID);
        if (listModelApp != null) {
            for (int i2 = 0; i2 < rrdCalculationInfoArray.length; ++i2) {
                BaseListRow baseListRow = listModelApp.getRow(i2);
                if (baseListRow instanceof PoiOnlineListRow) {
                    PoiOnlineListRow poiOnlineListRow = (PoiOnlineListRow)baseListRow;
                    DistanceUtil.updateRRDfor(this.poiLogChannel, poiOnlineListRow, rrdCalculationInfoArray[i2].getRrdInfo(), this.vehicle);
                    listModelApp.setRow(i2, poiOnlineListRow);
                    continue;
                }
                this.poiLogChannel.log(-2137614336, "PoiOnlineResultRRDListProvider#updateRRDDistances() Row is null or its not an instance of PoiOnlineListRow %1", (Object)baseListRow);
            }
            this.poiLogChannel.log(-2137614336, "PoiOnlineResultRRDListProvider#updateRRDDistances - finished");
        } else {
            this.poiLogChannel.log(-1601830656, "PoiOnlineResultRRDListProvider#updateRRDDistances tiledListModel with ID = %1 is null", (long)this.modelID);
        }
    }

    @Override
    public void unitsChanged() {
        this.poiLogChannel.log(-2137614336, "PoiOnlineResultRRDListProvider#unitsChanged()");
    }
}

