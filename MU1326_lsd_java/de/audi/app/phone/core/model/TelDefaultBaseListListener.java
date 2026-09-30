/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.model;

import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.model.TelDefaultModelListenerBase;
import de.audi.atip.hmi.model.list.BaseListModelApp;
import de.audi.atip.hmi.model.list.BaseListModelListener;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.esolutions.fw.util.commons.Buffer;

public class TelDefaultBaseListListener
extends TelDefaultModelListenerBase
implements BaseListModelListener {
    private final BaseListModelApp baseListModel;

    private static Buffer getLogMessage(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
        Buffer buffer = new Buffer();
        buffer.append("row=");
        buffer.append(evoListRow);
        buffer.append(", ");
        buffer.append("modelID=");
        buffer.append(n);
        buffer.append(", ");
        buffer.append("index=");
        buffer.append(n2);
        buffer.append(", ");
        buffer.append("col=");
        buffer.append(n3);
        buffer.append(", ");
        buffer.append("terminal=");
        buffer.append(n4);
        return buffer;
    }

    public TelDefaultBaseListListener(ITelApplication iTelApplication, String string, int n) {
        super(iTelApplication, string, n);
        this.baseListModel = this.getBaseListModel(n);
    }

    public TelDefaultBaseListListener(ITelApplication iTelApplication, int n) {
        super(iTelApplication, n);
        this.baseListModel = this.getBaseListModel(n);
    }

    public void init() {
        super.init();
        this.baseListModel.setListener(this);
    }

    public void deinit() {
        super.deinit();
        this.baseListModel.resetListener();
    }

    protected BaseListModelApp getBaseListModel() {
        return this.baseListModel;
    }

    public void itemReleased(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
        if (this.log.isDebug()) {
            this.log.log(10000000, "[TelDefaultBaseListListener#itemReleased] %1", (Object)TelDefaultBaseListListener.getLogMessage(evoListRow, n, n2, n3, n4));
        }
    }

    public void itemSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
        if (this.log.isInfo()) {
            this.log.log(1000000, "[TelDefaultBaseListListener#itemSelected] %1", (Object)TelDefaultBaseListListener.getLogMessage(evoListRow, n, n2, n3, n4));
        }
    }

    public void itemLongSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
        if (this.log.isDebug()) {
            this.log.log(10000000, "[TelDefaultBaseListListener#itemLongSelected] %1", (Object)TelDefaultBaseListListener.getLogMessage(evoListRow, n, n2, n3, n4));
        }
    }

    public void itemFocused(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
        if (this.log.isDebug()) {
            this.log.log(10000000, "[TelDefaultBaseListListener#itemFocused] %1", (Object)TelDefaultBaseListListener.getLogMessage(evoListRow, n, n2, n3, n4));
        }
    }
}

