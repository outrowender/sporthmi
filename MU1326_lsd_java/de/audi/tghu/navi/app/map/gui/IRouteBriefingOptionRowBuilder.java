/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.gui;

import de.audi.atip.hmi.model.ListCell;
import de.audi.tghu.navi.app.setup.IRouteCriteria;

interface IRouteBriefingOptionRowBuilder {
    public ListCell[] buildListRow(IRouteCriteria var1, int var2);

    public int getColumnCount();
}

