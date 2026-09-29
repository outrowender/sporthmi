/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.swdl.app.list;

import de.audi.atip.hmi.model.BaseListRow;
import de.audi.tghu.swdl.app.hmiswitcher.manager.ILoggingManager;
import de.audi.tghu.swdl.app.list.AbstractSwdlListItem;
import de.audi.tghu.swdl.app.list.ISwdlListItem;

public class SwdlListItemUnusualEvent
extends AbstractSwdlListItem {
    private static final String SWDL_CLASS_NAME;
    private ILoggingManager loggingManager;
    String unusualEvent;

    public SwdlListItemUnusualEvent(ILoggingManager iLoggingManager, ISwdlListItem iSwdlListItem, int n, String string, String string2) {
        super(iSwdlListItem, n, string);
        this.loggingManager = iLoggingManager;
        this.unusualEvent = string2;
    }

    ILoggingManager getLoggingManager() {
        return this.loggingManager;
    }

    @Override
    public void updateListRow(BaseListRow baseListRow) {
        baseListRow.setInteger(0, this.getId());
        baseListRow.setText(1, this.getName());
        baseListRow.setText(2, this.unusualEvent);
    }

    @Override
    public void select(int n) {
        this.getLoggingManager().selectUnusualEvent(n);
    }

    public String getSwdlClassName() {
        return "SwdlUnusualEvent";
    }
}

