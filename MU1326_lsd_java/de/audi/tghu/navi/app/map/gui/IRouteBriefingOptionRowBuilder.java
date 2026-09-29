/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.gui;

import de.audi.atip.hmi.model.ListCell;
import de.audi.tghu.navi.app.setup.IRouteCriteria;

interface IRouteBriefingOptionRowBuilder {
    default public ListCell[] buildListRow(IRouteCriteria iRouteCriteria, int n) {
    }

    default public int getColumnCount() {
    }
}

