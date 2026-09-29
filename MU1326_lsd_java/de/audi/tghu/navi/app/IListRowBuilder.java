/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app;

import de.audi.atip.hmi.model.ListCell;
import de.audi.atip.hmi.model.list.EvoListRow;
import org.dsi.ifc.navigation.LIValueListElement;

public interface IListRowBuilder {
    default public ListCell[] buildListRow(LIValueListElement lIValueListElement, int n) {
    }

    default public EvoListRow buildEvoListRow(LIValueListElement lIValueListElement, int n) {
    }

    default public int getColumnCount() {
    }
}

