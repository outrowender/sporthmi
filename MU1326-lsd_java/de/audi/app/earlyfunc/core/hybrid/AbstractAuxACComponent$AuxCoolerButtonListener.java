/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.earlyfunc.core.hybrid;

import de.audi.app.earlyfunc.core.hybrid.AbstractAuxACComponent;
import de.audi.app.earlyfunc.core.hybrid.AbstractAuxACComponent$1;
import de.audi.atip.hmi.model.DefaultButtonListener;

final class AbstractAuxACComponent$AuxCoolerButtonListener
extends DefaultButtonListener {
    private final /* synthetic */ AbstractAuxACComponent this$0;

    private AbstractAuxACComponent$AuxCoolerButtonListener(AbstractAuxACComponent abstractAuxACComponent) {
        this.this$0 = abstractAuxACComponent;
    }

    @Override
    public void keyPressed(int n, int n2, int n3) {
        AbstractAuxACComponent.access$400(this.this$0, "keyPressed", n, n2, true);
        switch (n) {
            case 2100394: {
                this.switchImmediate(1);
                break;
            }
            case 2100395: {
                this.switchImmediate(0);
                break;
            }
        }
    }

    private void switchImmediate(int n) {
        AbstractAuxACComponent.access$500(this.this$0, 6);
        this.this$0.getLogChannel().log(1078071040, "dsi.setBatteryControlImmediately(6,%1)", (long)n);
        this.this$0.getDSI().setBatteryControlImmediately(6, n);
    }

    /* synthetic */ AbstractAuxACComponent$AuxCoolerButtonListener(AbstractAuxACComponent abstractAuxACComponent, AbstractAuxACComponent$1 abstractAuxACComponent$1) {
        this(abstractAuxACComponent);
    }
}

