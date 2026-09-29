/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.core.auxheater;

import de.audi.app.car.core.auxheater.AbstractAuxheaterComponent;
import de.audi.atip.hmi.model.listener.DefaultChoiceListener;

public class AbstractAuxheaterComponent$AuxHeaterChoiceListener
extends DefaultChoiceListener {
    private final /* synthetic */ AbstractAuxheaterComponent this$0;

    protected AbstractAuxheaterComponent$AuxHeaterChoiceListener(AbstractAuxheaterComponent abstractAuxheaterComponent) {
        this.this$0 = abstractAuxheaterComponent;
    }

    @Override
    public void itemSelected(int n, int n2, int n3, int n4) {
        AbstractAuxheaterComponent.access$1900(this.this$0, "itemSelected:", n, n2, true);
        switch (n) {
            case 600726: {
                this.switchTimerActivation(1, n2 == 1);
                break;
            }
            case 600730: {
                this.switchTimerActivation(2, n2 == 1);
                break;
            }
            case 600734: {
                this.switchTimerActivation(3, n2 == 1);
                break;
            }
            case 600737: {
                this.itemSelectedHeatEffect(n2);
                break;
            }
            default: {
                AbstractAuxheaterComponent.access$2000(this.this$0, "itemSelected:", n, n2, false);
            }
        }
    }

    protected void switchTimerActivation(int n, boolean bl) {
        int n2 = bl ? n : 0;
        this.this$0.getLogChannel().log(1078071040, "setTimer: dsi.setAuxHeaterCoolerActiveTimer(%1)", (long)n2);
        this.this$0.getDSI().setAuxHeaterCoolerActiveTimer(n2);
    }

    private void itemSelectedHeatEffect(int n) {
        int n2 = n == 0 ? 0 : 2;
        this.this$0.getLogChannel().log(1078071040, "dsi.setAuxHeaterCoolerMode(%1)", (long)n2);
        this.this$0.getDSI().setAuxHeaterCoolerMode(n2);
    }
}

