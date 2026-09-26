/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.model;

import de.audi.atip.hmi.model.AbstractModel;
import de.audi.atip.hmi.model.ButtonModel;
import de.audi.atip.hmi.model.ChoiceListener;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.hmi.modelaccess.ChoiceModelGUI;
import de.esolutions.fw.util.commons.Buffer;

public class ChoiceModel
extends ButtonModel
implements ChoiceModelApp,
ChoiceModelGUI {
    private volatile int value;
    private volatile boolean forceUpdate;

    public ChoiceModel(int n) {
        super(n, 0);
    }

    public ChoiceModel(int n, int n2) {
        super(n, n2);
    }

    @Override
    public String dumpContent() {
        Buffer buffer = new Buffer(100);
        buffer.append(super.dumpContent());
        buffer.append("\nvalue: ");
        buffer.append(this.value);
        buffer.append("\nforceUpdate: ");
        buffer.append(this.forceUpdate);
        return buffer.toString();
    }

    @Override
    protected void copy(AbstractModel abstractModel) {
        try {
            ChoiceModel choiceModel = (ChoiceModel)abstractModel;
            this.value = choiceModel.value;
            super.copy(abstractModel);
        }
        catch (Exception exception) {
            this.lc.log(10000, "(%2) ChoiceModel.copy( %1 ) failed! ", (Object)abstractModel, (long)this.id);
            this.lc.log(10000, "ERROR: ", (Throwable)exception);
        }
    }

    @Override
    public int getModelType() {
        return 2;
    }

    @Override
    public boolean isEmpty() {
        return this.value < 0;
    }

    @Override
    public int getValue() {
        return this.value;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void setValue(int n) {
        boolean bl;
        Object object = this.mutex;
        synchronized (object) {
            boolean bl2 = bl = this.forceUpdate || n != this.value;
            if (bl) {
                this.value = n;
                this.stateChanged();
            }
        }
        this.lc.log(14808325, "(%2) ChoiceModel.setValue( %1 ) forceUpdate:%3", (long)n, (long)this.id, this.forceUpdate);
        if (bl) {
            this.fireModelUpdateEvent(1, n);
        }
    }

    @Override
    public void setChoiceListener(ChoiceListener choiceListener) {
        this.setButtonListener(choiceListener);
    }

    @Override
    public void forceUpdate(boolean bl) {
        this.forceUpdate = bl;
    }

    @Override
    public boolean isForceUpdateEnabled() {
        return this.forceUpdate;
    }

    @Override
    public void itemSelected(int n, int n2) {
        try {
            ((ChoiceListener)this.buttonListener).itemSelected(this.id, n, 0, n2);
        }
        catch (Exception exception) {
            this.handleListenerException(exception);
        }
    }

    @Override
    public void itemFocused(int n, int n2) {
        try {
            ((ChoiceListener)this.buttonListener).itemFocused(this.id, n, 0, n2);
        }
        catch (Exception exception) {
            this.handleListenerException(exception);
        }
    }
}

