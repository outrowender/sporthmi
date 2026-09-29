/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.gui;

import de.audi.atip.hmi.model.BaseListRow;
import de.audi.atip.hmi.model.IntegerListCell;
import de.audi.atip.hmi.model.ListCell;
import de.audi.atip.hmi.model.LongListCell;
import de.audi.atip.hmi.model.MetricsListCell;
import de.audi.atip.hmi.modelaccess.ListModelApp;
import de.audi.atip.metrics.DateMetric;
import de.audi.atip.metrics.Distance;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.map.MapManager;
import de.audi.tghu.navi.app.map.utils.MapUtils;
import java.util.Date;
import org.dsi.ifc.navigation.CalculatedRouteListElement;

public class AlternativeRoutesTooltip {
    public static void fillAlternativeRoutesModel(CalculatedRouteListElement[] calculatedRouteListElementArray, int n, NavigationEnv navigationEnv, MapManager mapManager) {
        if (calculatedRouteListElementArray == null || navigationEnv == null || mapManager == null) {
            return;
        }
        navigationEnv.getLogChannel().log(-2137614336, "GUIMain#setAltRouteParameters() - length : %1", calculatedRouteListElementArray != null ? (long)calculatedRouteListElementArray.length : -1L);
        Distance distance = new Distance(0.0f, 5);
        DateMetric dateMetric = new DateMetric(new Date(), 1);
        DateMetric dateMetric2 = new DateMetric(new Date(), 3);
        ListModelApp listModelApp = navigationEnv.getListModel(mapManager.getSemiDynListID());
        listModelApp.beginTransaction();
        ListCell[] listCellArray = new ListCell[13];
        int n2 = -1;
        long l = -1L;
        long l2 = -1L;
        int n3 = 0;
        long l3 = 0L;
        int n4 = -1;
        boolean bl = true;
        if (MapUtils.isCRLElementCalculated(calculatedRouteListElementArray[0])) {
            long l4;
            n2 = (int)calculatedRouteListElementArray[0].getDistance();
            if (calculatedRouteListElementArray[0].getEtaWithSpeedAndFlowStatus() == 2) {
                l = -1L;
                l2 = -1L;
            } else {
                l = navigationEnv.getFramework().getKombiTime() + calculatedRouteListElementArray[0].getEtaWithSpeedAndFlow();
                l2 = calculatedRouteListElementArray[0].getEtaWithSpeedAndFlow();
            }
            boolean bl2 = calculatedRouteListElementArray[0].etaWithSpeedAndFlowStatus == 1;
            l3 = l4 = calculatedRouteListElementArray[0].getEtaWithSpeedAndFlow() - calculatedRouteListElementArray[0].getEta();
            n3 = l4 > 0L && bl2 ? 1 : 0;
            bl = false;
        } else if (calculatedRouteListElementArray[0].calculationState == 4) {
            bl = false;
        }
        distance.setValue(n2);
        dateMetric2.setDate(l2);
        dateMetric.setDate(l);
        listCellArray[1] = new MetricsListCell(dateMetric);
        listCellArray[0] = new MetricsListCell(distance);
        listCellArray[5] = new IntegerListCell(n3, n3);
        listCellArray[6] = new LongListCell(l3);
        listCellArray[7] = IntegerListCell.create(bl ? 0 : 1);
        listCellArray[8] = IntegerListCell.create(n4);
        listCellArray[9] = new MetricsListCell(dateMetric2);
        listCellArray[10] = IntegerListCell.create(n);
        BaseListRow baseListRow = new BaseListRow(listCellArray);
        listModelApp.setRow(0, baseListRow);
        listModelApp.endTransaction();
    }
}

