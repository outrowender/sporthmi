/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.gui;

import de.audi.atip.hmi.model.IntegerListCell;
import de.audi.atip.hmi.model.ListCell;
import de.audi.atip.hmi.model.ListRow;
import de.audi.tghu.navi.app.map.gui.RouteBriefingOptionRowBuilder;
import de.audi.tghu.navi.app.setup.IRouteCriteria;

class RouteBriefingOptionRowBuilder$RouteBriefingOptionRow
extends ListRow {
    private int index;
    private final /* synthetic */ RouteBriefingOptionRowBuilder this$0;

    public RouteBriefingOptionRowBuilder$RouteBriefingOptionRow(RouteBriefingOptionRowBuilder routeBriefingOptionRowBuilder, IRouteCriteria iRouteCriteria, int n) {
        this.this$0 = routeBriefingOptionRowBuilder;
        this.index = n;
        ListCell[] listCellArray = new ListCell[11];
        int n2 = 2;
        if (iRouteCriteria.getTrafficRerouting() == 3) {
            n2 = 0;
        } else if (iRouteCriteria.getTrafficRerouting() == 4) {
            n2 = 1;
        } else if (iRouteCriteria.getTrafficRerouting() == 6) {
            n2 = 2;
        }
        listCellArray[1] = IntegerListCell.create(n2);
        n2 = 0;
        if (iRouteCriteria.getFerries() == 1) {
            n2 = 1;
        }
        listCellArray[3] = IntegerListCell.create(n2);
        n2 = 0;
        if (iRouteCriteria.getMotorrail() == 1) {
            n2 = 1;
        }
        listCellArray[4] = IntegerListCell.create(n2);
        n2 = 0;
        if (iRouteCriteria.getFreeways() == 2) {
            n2 = 1;
        }
        listCellArray[8] = IntegerListCell.create(n2);
        n2 = 0;
        if (iRouteCriteria.getVignettes() == 2) {
            n2 = 1;
        }
        listCellArray[6] = IntegerListCell.create(n2);
        n2 = 0;
        if (iRouteCriteria.getTollRoads() == 2) {
            n2 = 1;
        }
        listCellArray[5] = IntegerListCell.create(n2);
        n2 = 0;
        if (iRouteCriteria.getTimeRestrictedRoads() == 2) {
            n2 = 1;
        }
        listCellArray[9] = IntegerListCell.create(n2);
        n2 = 0;
        if (iRouteCriteria.getSeasonRestricted() == 2) {
            n2 = 1;
        }
        listCellArray[7] = IntegerListCell.create(n2);
        n2 = 0;
        listCellArray[10] = IntegerListCell.create(n2);
        n2 = iRouteCriteria.getHovLanes() == 2 ? 0 : 1;
        listCellArray[0] = IntegerListCell.create(n2);
        this.setCells(listCellArray);
    }

    @Override
    public boolean equals(Object object) {
        if (object == null) {
            return false;
        }
        if (!(object instanceof RouteBriefingOptionRowBuilder$RouteBriefingOptionRow)) {
            return false;
        }
        int n = ((RouteBriefingOptionRowBuilder$RouteBriefingOptionRow)object).index;
        return n == this.index;
    }

    @Override
    public int hashCode() {
        return this.index;
    }
}

