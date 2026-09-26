/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets.multiline;

import de.esolutions.hmi.widgets.audi.evo.widgets.multiline.DeleteKeyInputHandler;
import de.esolutions.hmi.widgets.audi.evo.widgets.multiline.ITimer;

class DeleteKeyInputHandler$3
implements ITimer {
    private final /* synthetic */ DeleteKeyInputHandler this$0;

    DeleteKeyInputHandler$3(DeleteKeyInputHandler deleteKeyInputHandler) {
        this.this$0 = deleteKeyInputHandler;
    }

    @Override
    public void onTimeout(int n) {
        this.this$0.m_ctrl.repaintWidgetOnHMIThread();
    }

    @Override
    public void onEnqueue(int n) {
    }

    @Override
    public void onCancel(int n) {
    }
}

