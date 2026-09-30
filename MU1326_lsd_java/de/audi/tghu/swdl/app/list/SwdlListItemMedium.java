/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.swdl.app.list;

import de.audi.atip.hmi.model.BaseListRow;
import de.audi.tghu.swdl.app.AbstractSwdlTextFactory;
import de.audi.tghu.swdl.app.hmiswitcher.manager.ISelectionManager;
import de.audi.tghu.swdl.app.list.AbstractSwdlListItemText;
import de.audi.tghu.swdl.app.list.ISwdlListItem;

public class SwdlListItemMedium
extends AbstractSwdlListItemText {
    private static final String SWDL_CLASS_NAME = "[SwdlMedium]";
    private ISelectionManager selectionManager;

    public SwdlListItemMedium(ISelectionManager iSelectionManager, ISwdlListItem iSwdlListItem, int n, boolean bl, AbstractSwdlTextFactory abstractSwdlTextFactory) {
        super(iSwdlListItem, n, Integer.toString(n), abstractSwdlTextFactory);
        this.selectionManager = iSelectionManager;
        this.setSelectable(bl);
    }

    ISelectionManager getSelectionManager() {
        return this.selectionManager;
    }

    public void updateListRow(BaseListRow baseListRow) {
        baseListRow.setInteger(0, this.getId());
        baseListRow.setInteger(1, this.getSelectable() ? 1 : 0);
    }

    public void select(int n) {
        this.getSelectionManager().doSelectSourceMedium(n);
    }

    public String getSwdlClassName() {
        return SWDL_CLASS_NAME;
    }
}

