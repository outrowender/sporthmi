/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.model;

import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.model.ITelOptionModelListener;
import de.audi.app.phone.core.model.TelDefaultModelListenerBase;
import de.audi.atip.hmi.model.OptionModelListener;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.hmi.modelaccess.ListModelApp;
import de.audi.atip.hmi.modelaccess.OptionModelApp;
import de.esolutions.fw.util.commons.Buffer;

public abstract class AbstractTelOptionModelHandler
extends TelDefaultModelListenerBase
implements OptionModelListener {
    private final OptionModelApp optionsModel;
    private final int targetModelID;
    private final ITelOptionModelListener listener;
    protected final ListModelApp targetModel;

    private static Buffer getLogMessage(int n, int n2, int n3, int n4, int n5) {
        Buffer buffer = new Buffer();
        buffer.append("modelID=");
        buffer.append(n);
        buffer.append(", ");
        buffer.append("targetModelID=");
        buffer.append(n2);
        buffer.append(", ");
        buffer.append("targetRow=");
        buffer.append(n3);
        buffer.append(", ");
        buffer.append("targetWidgetID=");
        buffer.append(n4);
        buffer.append(", ");
        buffer.append("terminalID=");
        buffer.append(n5);
        return buffer;
    }

    private static Buffer getCustomActionLogMessage(int n, int n2, int n3, int n4, int n5) {
        Buffer buffer = new Buffer();
        buffer.append("modelID=");
        buffer.append(n);
        buffer.append(", ");
        buffer.append("actionID=");
        buffer.append(n2);
        buffer.append(", ");
        buffer.append("targetRow=");
        buffer.append(n3);
        buffer.append(", ");
        buffer.append("targetWidgetID=");
        buffer.append(n4);
        buffer.append(", ");
        buffer.append("terminalID=");
        buffer.append(n5);
        return buffer;
    }

    public AbstractTelOptionModelHandler(ITelApplication iTelApplication, int n, int n2, ITelOptionModelListener iTelOptionModelListener) {
        super(iTelApplication, n);
        this.targetModelID = n2;
        this.targetModel = this.getListModel(n2);
        this.optionsModel = this.getOptionModel(n);
        this.listener = iTelOptionModelListener;
    }

    public AbstractTelOptionModelHandler(ITelApplication iTelApplication, String string, int n, int n2, ITelOptionModelListener iTelOptionModelListener) {
        super(iTelApplication, string, n);
        this.targetModelID = n2;
        this.targetModel = this.getListModel(n2);
        this.optionsModel = this.getOptionModel(n);
        this.listener = iTelOptionModelListener;
    }

    @Override
    public void init() {
        super.init();
        this.optionsModel.setListener(this, this.targetModelID);
    }

    @Override
    public void deinit() {
        super.deinit();
        this.optionsModel.removeListener(this.targetModelID);
    }

    protected abstract void optionSelected(EvoListRow evoListRow, int n) {
    }

    @Override
    public void keyPressed(int n, int n2, int n3, int n4, int n5) {
        if (this.log.isDebug()) {
            this.log.log(-2137614336, "[TelOptionModelHandler#keyPressed] %1", (Object)AbstractTelOptionModelHandler.getLogMessage(n, n2, n3, n4, n5));
        }
    }

    @Override
    public void keyReleased(int n, int n2, int n3, int n4, int n5) {
        if (this.log.isDebug()) {
            this.log.log(-2137614336, "[TelOptionModelHandler#keyReleased] %1", (Object)AbstractTelOptionModelHandler.getLogMessage(n, n2, n3, n4, n5));
        }
    }

    @Override
    public void keyTyped(int n, int n2, int n3, int n4, int n5) {
        if (this.log.isInfo()) {
            this.log.log(1078071040, "[TelOptionModelHandler#keyTyped] %1", (Object)AbstractTelOptionModelHandler.getLogMessage(n, n2, n3, n4, n5));
        }
    }

    @Override
    public void customAction(int n, int n2, int n3, int n4, int n5) {
        if (this.log.isDebug()) {
            this.log.log(-2137614336, "[TelOptionModelHandler#customAction] %1", (Object)AbstractTelOptionModelHandler.getCustomActionLogMessage(n, n2, n3, n4, n5));
        }
    }
}

