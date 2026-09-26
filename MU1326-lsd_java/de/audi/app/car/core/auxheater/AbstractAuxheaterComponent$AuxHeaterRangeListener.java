/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.core.auxheater;

import de.audi.app.car.common.comp.AbstractCarComponent;
import de.audi.app.car.core.auxheater.AbstractAuxheaterComponent;
import de.audi.app.car.core.auxheater.AbstractAuxheaterComponent$1;
import de.audi.atip.hmi.model.DefaultRangeListener;

final class AbstractAuxheaterComponent$AuxHeaterRangeListener
extends DefaultRangeListener {
    private final /* synthetic */ AbstractAuxheaterComponent this$0;

    private AbstractAuxheaterComponent$AuxHeaterRangeListener(AbstractAuxheaterComponent abstractAuxheaterComponent) {
        this.this$0 = abstractAuxheaterComponent;
    }

    @Override
    public void keyPressed(int n, int n2, int n3) {
        AbstractAuxheaterComponent.access$800(this.this$0, "keyPressed", n, n2, true);
        switch (n) {
            case 600716: {
                this.this$0.activateInstantAuxHeater(n3);
                break;
            }
            case 600718: {
                this.keyPressedStartModifyRunningTime(n3);
                break;
            }
            default: {
                AbstractAuxheaterComponent.access$900(this.this$0, "keyPressed", n, n2, false);
            }
        }
    }

    private void keyPressedStartModifyRunningTime(int n) {
        AbstractAuxheaterComponent.access$1000(this.this$0, -1909847808).fireEvent(n);
    }

    @Override
    public void decrement(int n, int n2, int n3) {
        AbstractAuxheaterComponent.access$1100(this.this$0, "decrement", n, n2, true);
        if (n == -1943402240) {
            this.decrementRunningTime(n2);
        }
    }

    private void decrementRunningTime(int n) {
        int n2 = AbstractCarComponent.clip(AbstractAuxheaterComponent.access$1200(this.this$0, -1943402240).getValue() - n, 0, 60);
        this.this$0.getLogChannel().log(1078071040, "decrementRunningTime :  steps: %1, newValue: %2", (long)n, (long)n2);
        if (n2 > 0) {
            this.this$0.getLogChannel().log(1078071040, "decrementRunningTime : dsi.setAUXHeaterCoolerRunningTime(%1)", (long)n2);
            AbstractAuxheaterComponent.access$1300(this.this$0, n2);
            this.this$0.getDSI().setAuxHeaterCoolerRunningTime((short)n2);
            AbstractAuxheaterComponent.access$1402(this.this$0, false);
        } else {
            this.this$0.getLogChannel().log(1078071040, "decrementRunningTime: rotary switched from on to off");
            AbstractAuxheaterComponent.access$1300(this.this$0, n2);
            AbstractAuxheaterComponent.access$1500(this.this$0, n2, false);
            AbstractAuxheaterComponent.access$1402(this.this$0, true);
            if (n > 10) {
                this.this$0.getDSI().setAuxHeaterCoolerRunningTime((short)10);
            }
        }
    }

    @Override
    public void increment(int n, int n2, int n3) {
        AbstractAuxheaterComponent.access$1600(this.this$0, "increment", n, n2, true);
        if (n == -1943402240) {
            this.incrementRunningTime(n2);
        }
    }

    private void incrementRunningTime(int n) {
        AbstractAuxheaterComponent.access$1402(this.this$0, false);
        int n2 = AbstractCarComponent.clip(AbstractAuxheaterComponent.access$1700(this.this$0, -1943402240).getValue() + n, 0, 60);
        this.this$0.getLogChannel().log(1078071040, "incrementRunningTime :  steps: %1 newValue: %2", (long)n, (long)n2);
        if (AbstractAuxheaterComponent.access$1800(this.this$0, -1943402240).getValue() == 0 && n == 10) {
            this.this$0.getLogChannel().log(1078071040, "incrementRunningTime: rotary switched from off to on");
            AbstractAuxheaterComponent.access$1300(this.this$0, n2);
            AbstractAuxheaterComponent.access$1500(this.this$0, 10, false);
        } else {
            this.this$0.getLogChannel().log(1078071040, "incrementRunningTime: dsi.setAUXHeaterCoolerRunningTime(%1)", (long)n2);
            AbstractAuxheaterComponent.access$1300(this.this$0, n2);
            this.this$0.getDSI().setAuxHeaterCoolerRunningTime((short)n2);
        }
    }

    /* synthetic */ AbstractAuxheaterComponent$AuxHeaterRangeListener(AbstractAuxheaterComponent abstractAuxheaterComponent, AbstractAuxheaterComponent$1 abstractAuxheaterComponent$1) {
        this(abstractAuxheaterComponent);
    }
}

