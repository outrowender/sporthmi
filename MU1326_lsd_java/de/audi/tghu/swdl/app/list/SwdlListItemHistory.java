/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.swdl.app.list;

import de.audi.atip.hmi.model.BaseListRow;
import de.audi.tghu.swdl.app.AbstractSwdlTextFactory;
import de.audi.tghu.swdl.app.hmiswitcher.manager.ILoggingManager;
import de.audi.tghu.swdl.app.list.AbstractSwdlListItemText;
import de.audi.tghu.swdl.app.list.ISwdlListItem;

public class SwdlListItemHistory
extends AbstractSwdlListItemText {
    private static final String SWDL_CLASS_NAME = "[SwdlHistory]";
    String date;
    int summary;
    int subUpdates;
    private ILoggingManager loggingManager;

    public SwdlListItemHistory(ILoggingManager iLoggingManager, ISwdlListItem iSwdlListItem, int n, String string, String string2, int n2, AbstractSwdlTextFactory abstractSwdlTextFactory) {
        super(iSwdlListItem, n, string, abstractSwdlTextFactory);
        this.loggingManager = iLoggingManager;
        this.setDate(string2);
        this.setSummary(n2);
        this.setSubUpdates(0);
    }

    ILoggingManager getLoggingManager() {
        return this.loggingManager;
    }

    public int getSummary() {
        return this.summary;
    }

    public final void setSummary(int n) {
        this.summary = n;
    }

    public int getSubUpdates() {
        return this.subUpdates;
    }

    public final void setSubUpdates(int n) {
        this.subUpdates = n;
    }

    public String getDate() {
        return this.date;
    }

    public final void setDate(String string) {
        this.date = string;
    }

    public void select(int n) {
        this.getLoggingManager().selectHistory(n);
    }

    public void updateListRow(BaseListRow baseListRow) {
        baseListRow.setInteger(0, this.getId());
        baseListRow.setText(1, this.getDate());
        baseListRow.setInteger(2, this.getSummary());
        baseListRow.setInteger(3, 0);
        baseListRow.setText(4, this.getName());
    }

    public String getSwdlClassName() {
        return SWDL_CLASS_NAME;
    }
}

