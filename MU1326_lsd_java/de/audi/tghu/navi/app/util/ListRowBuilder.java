/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.util;

import de.audi.atip.hmi.model.ListCell;
import org.dsi.ifc.navigation.LIValueListElement;

public interface ListRowBuilder {
    public ListCell[] buildListRow(LIValueListElement var1, int var2);

    public int getMaxColumns();

    public int getElementIndex();
}

