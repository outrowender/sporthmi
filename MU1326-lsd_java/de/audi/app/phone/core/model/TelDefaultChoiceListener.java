/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.model;

import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.model.TelDefaultModelListenerBase;
import de.audi.atip.hmi.model.ChoiceListener;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.esolutions.fw.util.commons.Buffer;

public class TelDefaultChoiceListener
extends TelDefaultModelListenerBase
implements ChoiceListener {
    private ChoiceModelApp choiceModel;

    private static Buffer getLogMessage(int n, int n2, int n3, int n4) {
        Buffer buffer = new Buffer();
        buffer.append("modelID=");
        buffer.append(n);
        buffer.append(", ");
        buffer.append("itemID=");
        buffer.append(n2);
        buffer.append(", ");
        buffer.append("col=");
        buffer.append(n3);
        buffer.append(", ");
        buffer.append("terminalID=");
        buffer.append(n4);
        return buffer;
    }

    public TelDefaultChoiceListener(ITelApplication iTelApplication, String string, int n) {
        super(iTelApplication, string, n);
        this.choiceModel = this.getChoiceModel(n);
    }

    public TelDefaultChoiceListener(ITelApplication iTelApplication, int n) {
        super(iTelApplication, n);
        this.choiceModel = this.getChoiceModel(n);
    }

    @Override
    public void init() {
        super.init();
        this.choiceModel.setChoiceListener(this);
    }

    @Override
    public void deinit() {
        super.deinit();
        this.choiceModel.resetListener();
    }

    protected ChoiceModelApp getChoiceModel() {
        return this.choiceModel;
    }

    @Override
    public void keyPressed(int n, int n2, int n3) {
        if (this.log.isDebug()) {
            this.log.log(-2137614336, "[TelDefaultButtonListener#keyPressed] %1", (Object)TelDefaultChoiceListener.getLogMessage(n, n2, n3));
        }
    }

    @Override
    public void keyReleased(int n, int n2, int n3) {
        if (this.log.isDebug()) {
            this.log.log(-2137614336, "[TelDefaultButtonListener#keyReleased] %1", (Object)TelDefaultChoiceListener.getLogMessage(n, n2, n3));
        }
    }

    @Override
    public void keyTyped(int n, int n2, int n3) {
        if (this.log.isInfo()) {
            this.log.log(-2137614336, "[TelDefaultButtonListener#keyTyped] %1", (Object)TelDefaultChoiceListener.getLogMessage(n, n2, n3));
        }
    }

    @Override
    public void keyLongTyped(int n, int n2, int n3) {
        if (this.log.isDebug()) {
            this.log.log(-2137614336, "[TelDefaultButtonListener#keyLongTyped] %1", (Object)TelDefaultChoiceListener.getLogMessage(n, n2, n3));
        }
    }

    @Override
    public void itemSelected(int n, int n2, int n3, int n4) {
        if (this.log.isInfo()) {
            this.log.log(1078071040, "[TelDefaultButtonListener#itemSelected] %1", (Object)TelDefaultChoiceListener.getLogMessage(n, n2, n3, n4));
        }
    }

    @Override
    public void itemFocused(int n, int n2, int n3, int n4) {
        if (this.log.isDebug()) {
            this.log.log(-2137614336, "[TelDefaultButtonListener#itemFocused] %1", (Object)TelDefaultChoiceListener.getLogMessage(n, n2, n3, n4));
        }
    }
}

