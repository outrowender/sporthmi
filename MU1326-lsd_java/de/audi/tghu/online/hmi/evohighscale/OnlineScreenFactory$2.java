/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.hmi.evohighscale;

import de.audi.atip.hmi.model.ListCell;
import de.audi.tghu.online.hmi.evohighscale.OnlineScreenFactory;
import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.list.ListItemFactory;

class OnlineScreenFactory$2
implements ListItemFactory {
    private final /* synthetic */ OnlineScreenFactory this$0;

    OnlineScreenFactory$2(OnlineScreenFactory onlineScreenFactory) {
        this.this$0 = onlineScreenFactory;
    }

    @Override
    public AbstractWidgetController createListItem(int n, ListCell[] listCellArray) {
        switch (n) {
            default: 
        }
        return null;
    }

    @Override
    public AbstractWidgetController createListItemNoData() {
        return null;
    }

    public AbstractWidgetController createCell(int n) {
        switch (n) {
            default: 
        }
        return null;
    }
}

