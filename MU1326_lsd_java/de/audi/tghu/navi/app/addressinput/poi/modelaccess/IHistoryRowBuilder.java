/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.poi.modelaccess;

import de.audi.atip.hmi.model.ListCell;
import org.dsi.ifc.navigation.LICityHistoryEntry;

public interface IHistoryRowBuilder {
    public ListCell[] buildListRow(LICityHistoryEntry var1);

    public int getColumnCount();
}

