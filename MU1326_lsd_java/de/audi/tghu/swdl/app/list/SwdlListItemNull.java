/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.swdl.app.list;

import de.audi.atip.hmi.model.BaseListRow;
import de.audi.tghu.swdl.app.list.AbstractSwdlListItem;

public class SwdlListItemNull
extends AbstractSwdlListItem {
    private static final String SWDL_CLASS_NAME;
    private static final int LIST_ITEM_ROOT_ID;

    public SwdlListItemNull(String string) {
        super(null, 0, string);
    }

    @Override
    public void select(int n) {
    }

    @Override
    public void updateListRow(BaseListRow baseListRow) {
    }

    public String getSwdlClassName() {
        return "[SwdlListItemNull]";
    }
}

