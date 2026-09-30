/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app;

import de.audi.atip.hmi.model.ListCell;
import de.audi.atip.hmi.model.list.EvoListRow;
import org.dsi.ifc.navigation.LIValueListElement;

public interface IListRowBuilder {
    public ListCell[] buildListRow(LIValueListElement var1, int var2);

    public EvoListRow buildEvoListRow(LIValueListElement var1, int var2);

    public int getColumnCount();
}

