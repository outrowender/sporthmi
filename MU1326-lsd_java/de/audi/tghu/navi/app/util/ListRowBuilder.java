/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.util;

import de.audi.atip.hmi.model.ListCell;
import org.dsi.ifc.navigation.LIValueListElement;

public interface ListRowBuilder {
    default public ListCell[] buildListRow(LIValueListElement lIValueListElement, int n) {
    }

    default public int getMaxColumns() {
    }

    default public int getElementIndex() {
    }
}

