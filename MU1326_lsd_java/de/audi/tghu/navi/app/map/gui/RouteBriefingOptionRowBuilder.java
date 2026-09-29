/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.gui;

import de.audi.atip.hmi.model.ListCell;
import de.audi.tghu.navi.app.map.gui.IRouteBriefingOptionRowBuilder;
import de.audi.tghu.navi.app.map.gui.RouteBriefingOptionRowBuilder$RouteBriefingOptionRow;
import de.audi.tghu.navi.app.setup.IRouteCriteria;

class RouteBriefingOptionRowBuilder
implements IRouteBriefingOptionRowBuilder {
    RouteBriefingOptionRowBuilder() {
    }

    @Override
    public ListCell[] buildListRow(IRouteCriteria iRouteCriteria, int n) {
        return new RouteBriefingOptionRowBuilder$RouteBriefingOptionRow(this, iRouteCriteria, n).getCells();
    }

    @Override
    public int getColumnCount() {
        return 11;
    }
}

