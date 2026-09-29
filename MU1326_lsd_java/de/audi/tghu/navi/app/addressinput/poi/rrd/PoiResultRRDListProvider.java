/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.poi.rrd;

import de.audi.atip.hmi.model.list.BaseListModelApp;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.addressinput.poi.rrd.IRRDListProvider;
import de.audi.tghu.navi.app.guidance.IVehicle;
import de.audi.tghu.navi.app.slidinglist.poi.DistanceDifferentiationRow;
import de.audi.tghu.navi.app.slidinglist.poi.DistanceUtil;
import de.esolutions.fw.util.commons.Buffer;
import java.util.ArrayList;
import org.dsi.ifc.global.NavLocationWgs84;
import org.dsi.ifc.navigation.PosPosition;
import org.dsi.ifc.navigation.RrdCalculationInfo;

public class PoiResultRRDListProvider
implements IRRDListProvider {
    public static final int CALCULATION_LIMIT_POI_RESULT;
    private final LogChannel poiLogChannel;
    private final BaseListModelApp listModel;
    private final int modelId;
    private final IVehicle vehicle;

    public PoiResultRRDListProvider(NavigationEnv navigationEnv, int n, IVehicle iVehicle) {
        this.listModel = navigationEnv.getBaseListModel(n);
        this.modelId = n;
        this.vehicle = iVehicle;
        this.poiLogChannel = navigationEnv.getPOILogChannel();
    }

    @Override
    public NavLocationWgs84[] getRRDCalculationList() {
        this.poiLogChannel.log(-2137614336, "PoiResultRRDListProvider#getRRDCalculationList()");
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < 10; ++i2) {
            EvoListRow evoListRow = this.listModel.getRow(i2);
            if (evoListRow == null) continue;
            if (!(evoListRow instanceof DistanceDifferentiationRow)) {
                this.poiLogChannel.log(-2137614336, "PoiResultRRDListProvider#getAllVisibleRowsFromListModel() Row is not null. But its not an instance of DistanceDifferentiationRow");
                continue;
            }
            DistanceDifferentiationRow distanceDifferentiationRow = (DistanceDifferentiationRow)((Object)evoListRow);
            arrayList.add(new NavLocationWgs84(distanceDifferentiationRow.getLongitude(), distanceDifferentiationRow.getLatitude()));
        }
        return (NavLocationWgs84[])arrayList.toArray(new NavLocationWgs84[arrayList.size()]);
    }

    @Override
    public void updateDirectionAndAirDistance(PosPosition posPosition) {
        if (this.listModel == null || this.listModel.getLength() == 0) {
            if (this.listModel == null) {
                this.poiLogChannel.log(-1601830656, "PoiResultRRDListProvider#updateDirectionAndAirDistance listModel with ID = %1 is null", (long)this.modelId);
            } else {
                this.poiLogChannel.log(-1601830656, "PoiResultRRDListProvider#updateDirectionAndAirDistance List is empty");
            }
            return;
        }
        BaseListModelApp baseListModelApp = this.listModel.getCopy();
        for (int i2 = 0; i2 < baseListModelApp.getLength(); ++i2) {
            if (baseListModelApp.getRow(i2) == null) continue;
            ((DistanceDifferentiationRow)((Object)baseListModelApp.getRow(i2))).updateDirection(posPosition);
            ((DistanceDifferentiationRow)((Object)baseListModelApp.getRow(i2))).updateAirDistance(posPosition);
        }
        this.listModel.update(baseListModelApp);
    }

    @Override
    public int getRRDListCalculationLimit() {
        this.poiLogChannel.log(-2137614336, "PoiResultRRDListProvider#getRRDListCalculationLimit()");
        return 10;
    }

    @Override
    public void updateRRDDistances(RrdCalculationInfo[] rrdCalculationInfoArray) {
        int n;
        Buffer buffer = new Buffer();
        for (n = 0; n < rrdCalculationInfoArray.length; ++n) {
            if (rrdCalculationInfoArray[n] == null) {
                buffer.append("[null]; ");
                continue;
            }
            buffer.append(new StringBuffer().append(rrdCalculationInfoArray[n].toString()).append("; ").toString());
        }
        this.poiLogChannel.log(-2137614336, "PoiResultRRDListProvider#updateRRDDistances(%1)", (Object)buffer.toString());
        for (n = 0; n < rrdCalculationInfoArray.length; ++n) {
            EvoListRow evoListRow;
            RrdCalculationInfo rrdCalculationInfo = rrdCalculationInfoArray[n];
            if (rrdCalculationInfo == null || !((evoListRow = this.listModel.getRow(n)) instanceof DistanceDifferentiationRow)) continue;
            DistanceUtil.updateRRDfor(this.poiLogChannel, (DistanceDifferentiationRow)((Object)evoListRow), rrdCalculationInfoArray[n].getRrdInfo(), this.vehicle);
            this.listModel.setRow(n, evoListRow);
        }
    }

    @Override
    public void unitsChanged() {
        this.poiLogChannel.log(-2137614336, "PoiResultRRDListProvider#unitsChanged()");
    }
}

