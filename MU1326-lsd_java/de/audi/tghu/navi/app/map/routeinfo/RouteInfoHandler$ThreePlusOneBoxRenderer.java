/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.routeinfo;

import de.audi.atip.hmi.model.BaseListRow;
import de.audi.atip.hmi.model.IntegerListCell;
import de.audi.atip.hmi.modelaccess.ListModelApp;
import de.audi.tghu.navi.app.map.routeinfo.MixedListItem;
import de.audi.tghu.navi.app.map.routeinfo.MixedListItemPOI;
import de.audi.tghu.navi.app.map.routeinfo.RouteInfoHandler;
import de.audi.tghu.navi.app.map.routeinfo.RouteInfoHandler$IRouteInfoRenderer;
import de.audi.tghu.navi.app.map.routeinfo.RouteInfoHandler$MixedData;
import de.audi.tghu.navi.app.util.Util;

class RouteInfoHandler$ThreePlusOneBoxRenderer
implements RouteInfoHandler$IRouteInfoRenderer {
    public static final int MAX_ROW_NUM;
    protected ListModelApp listModel;
    private final /* synthetic */ RouteInfoHandler this$0;

    public RouteInfoHandler$ThreePlusOneBoxRenderer(RouteInfoHandler routeInfoHandler, RouteInfoHandler routeInfoHandler2) {
        this.this$0 = routeInfoHandler;
        this.listModel = routeInfoHandler.env.getListModel(1562117632);
        this.listModel.setMaxRows(3);
        this.listModel.setMaxColumns(69);
        this.listModel.clear();
        for (int i2 = 0; i2 < 3; ++i2) {
            this.listModel.addRow(RouteInfoHandler.access$700(routeInfoHandler2));
        }
    }

    @Override
    public void render(RouteInfoHandler$MixedData routeInfoHandler$MixedData) {
        int n;
        if (routeInfoHandler$MixedData == null) {
            this.this$0.getLogger().log(-1601830656, "RouteInfoHandler<ThreePlusOneBoxRenderer>#render() - not initialized");
            return;
        }
        this.this$0.getLogger().log(14808325, "RouteInfoHandler<ThreePlusOneBoxRenderer>#render() - list size : %1", (long)routeInfoHandler$MixedData.size());
        Util.beginTransaction(this.listModel);
        if (!routeInfoHandler$MixedData.hasTurnListElement()) {
            int n2;
            int n3 = this.countVisibleRows();
            this.listModel.clear();
            for (n2 = 0; n2 < n3; ++n2) {
                this.listModel.insertRow(0, RouteInfoHandler.access$700(this.this$0));
            }
            for (n2 = 0; n2 < 3 - n3; ++n2) {
                this.listModel.insertRow(0, this.this$0.getInvisibleListRow());
            }
            Util.endTransaction(this.listModel);
            return;
        }
        this.listModel.clear();
        this.checkDataValidity(routeInfoHandler$MixedData);
        int n4 = 0;
        MixedListItem mixedListItem = null;
        for (n = 0; n4 < 3 && n < routeInfoHandler$MixedData.size(); ++n) {
            mixedListItem = routeInfoHandler$MixedData.getItem(n);
            if (!RouteInfoHandler.access$800(this.this$0) && mixedListItem instanceof MixedListItemPOI) continue;
            if (n4 < 2 && mixedListItem.getFormat() == 8) {
                if (mixedListItem.isBorderCrossingSpeedInfoAvailable() && mixedListItem.isWithinHorizon() && !Util.isHURegionNAR()) {
                    BaseListRow baseListRow = mixedListItem.toBaseListRow();
                    baseListRow.setCell(0, IntegerListCell.create(7));
                    this.listModel.insertRow(0, baseListRow);
                    baseListRow = mixedListItem.toBaseListRow();
                    baseListRow.setCell(0, IntegerListCell.create(6));
                    this.listModel.insertRow(0, baseListRow);
                    n4 += 2;
                    continue;
                }
                this.listModel.insertRow(0, mixedListItem.toBaseListRow());
                ++n4;
                continue;
            }
            this.listModel.insertRow(0, mixedListItem.toBaseListRow());
            ++n4;
        }
        this.this$0.getLogger().log(-2137614336, "RouteInfoHandler<ThreePlusOneBoxRenderer>#render() - model size: %1", (long)n4);
        for (n = 0; n < 3 - n4; ++n) {
            this.listModel.insertRow(0, this.this$0.getInvisibleListRow());
        }
        Util.endTransaction(this.listModel);
    }

    private int countVisibleRows() {
        int n = 0;
        int n2 = this.listModel.getLength();
        for (int i2 = 0; i2 < n2; ++i2) {
            BaseListRow baseListRow = this.listModel.getRow(i2);
            int n3 = ((IntegerListCell)baseListRow.getCell(0)).getValue();
            this.this$0.getLogger().log(14808325, "RouteInfoHandler<ThreePlusOneBoxRenderer>#render() %1", (long)n3);
            if (n3 == -1) continue;
            ++n;
        }
        this.this$0.getLogger().log(-2137614336, "RouteInfoHandler<ThreePlusOneBoxRenderer>#render() - visible size: %1", (long)n);
        return n;
    }

    private void checkDataValidity(RouteInfoHandler$MixedData routeInfoHandler$MixedData) {
        if (routeInfoHandler$MixedData == null || routeInfoHandler$MixedData.size() == 0) {
            this.this$0.getLogger().log(-1601830656, "RouteInfoHandler<ThreePlusOneBoxRenderer>#checkDataValidity() - listModel = null");
        } else {
            int n = 50;
            for (int i2 = routeInfoHandler$MixedData.size() - 1; i2 > 0; --i2) {
                int n2 = routeInfoHandler$MixedData.getItem(i2).getMixedListRow().getInteger(48);
                if (n2 == 0 || n2 == -1 || n2 != routeInfoHandler$MixedData.getItem(i2 - 1).getMixedListRow().getInteger(48)) continue;
                this.this$0.getLogger().log(-1601830656, "RouteInfoHandler<ThreePlusOneBoxRenderer>#checkDataValidity() - same UID : %1, change to %2", (long)routeInfoHandler$MixedData.getItem(i2 - 1).getMixedListRow().getInteger(48), (long)(n2 -= ++n));
                routeInfoHandler$MixedData.getItem(i2).getMixedListRow().setInteger(48, n2);
            }
        }
    }
}

