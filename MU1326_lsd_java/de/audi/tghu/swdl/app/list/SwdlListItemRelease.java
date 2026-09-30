/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.swdl.app.list;

import de.audi.atip.hmi.model.BaseListRow;
import de.audi.tghu.swdl.app.hmiswitcher.manager.ISelectionManager;
import de.audi.tghu.swdl.app.list.AbstractSwdlListItem;
import de.audi.tghu.swdl.app.list.ISwdlListItem;

public class SwdlListItemRelease
extends AbstractSwdlListItem {
    private static final String SWDL_CLASS_NAME = "[SwdlRelease]";
    private ISelectionManager selectionManager;

    public SwdlListItemRelease(ISelectionManager iSelectionManager, ISwdlListItem iSwdlListItem, int n, String string) {
        super(iSwdlListItem, n, string);
        this.selectionManager = iSelectionManager;
    }

    ISelectionManager getSelectionManager() {
        return this.selectionManager;
    }

    public void select(int n) {
        this.getSelectionManager().doSelectRelease(n);
    }

    public void updateListRow(BaseListRow baseListRow) {
        baseListRow.setInteger(0, this.getId());
        baseListRow.setText(1, this.getName());
    }

    public String getSwdlClassName() {
        return SWDL_CLASS_NAME;
    }
}

