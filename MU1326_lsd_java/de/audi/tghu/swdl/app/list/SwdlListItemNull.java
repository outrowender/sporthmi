/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.swdl.app.list;

import de.audi.atip.hmi.model.BaseListRow;
import de.audi.tghu.swdl.app.list.AbstractSwdlListItem;

public class SwdlListItemNull
extends AbstractSwdlListItem {
    private static final String SWDL_CLASS_NAME = "[SwdlListItemNull]";
    private static final int LIST_ITEM_ROOT_ID = 0;

    public SwdlListItemNull(String string) {
        super(null, 0, string);
    }

    public void select(int n) {
    }

    public void updateListRow(BaseListRow baseListRow) {
    }

    public String getSwdlClassName() {
        return SWDL_CLASS_NAME;
    }
}

