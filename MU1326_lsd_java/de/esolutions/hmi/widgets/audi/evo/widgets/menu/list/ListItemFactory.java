/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets.menu.list;

import de.audi.atip.hmi.model.ListCell;
import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;

public interface ListItemFactory {
    public AbstractWidgetController createListItem(int var1, ListCell[] var2);

    public AbstractWidgetController createListItemNoData();
}

