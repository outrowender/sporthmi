/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.gui;

import de.audi.atip.hmi.model.IntegerListCell;
import de.audi.atip.hmi.model.ListCell;
import de.audi.atip.hmi.model.ListRow;
import de.audi.tghu.navi.app.map.gui.IRouteBriefingOptionRowBuilder;
import de.audi.tghu.navi.app.setup.IRouteCriteria;

class RouteBriefingOptionRowBuilder
implements IRouteBriefingOptionRowBuilder {
    RouteBriefingOptionRowBuilder() {
    }

    public ListCell[] buildListRow(IRouteCriteria iRouteCriteria, int n) {
        return new RouteBriefingOptionRow(iRouteCriteria, n).getCells();
    }

    public int getColumnCount() {
        return 11;
    }

    private class RouteBriefingOptionRow
    extends ListRow {
        private int index;

        public RouteBriefingOptionRow(IRouteCriteria iRouteCriteria, int n) {
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

        public boolean equals(Object object) {
            if (object == null) {
                return false;
            }
            if (!(object instanceof RouteBriefingOptionRow)) {
                return false;
            }
            int n = ((RouteBriefingOptionRow)object).index;
            return n == this.index;
        }

        public int hashCode() {
            return this.index;
        }
    }
}

