/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.core.auxheater;

import de.audi.app.car.core.auxheater.AbstractAuxheaterComponent;
import de.audi.app.car.core.auxheater.AbstractAuxheaterComponent$1;
import de.audi.atip.hmi.model.DefaultButtonListener;

final class AbstractAuxheaterComponent$AuxHeaterButtonListener
extends DefaultButtonListener {
    private final /* synthetic */ AbstractAuxheaterComponent this$0;

    private AbstractAuxheaterComponent$AuxHeaterButtonListener(AbstractAuxheaterComponent abstractAuxheaterComponent) {
        this.this$0 = abstractAuxheaterComponent;
    }

    @Override
    public void keyPressed(int n, int n2, int n3) {
        AbstractAuxheaterComponent.access$000(this.this$0, "keyPressed", n, n2, true);
        switch (n) {
            case 600721: {
                this.this$0.setAuxHeaterOnOffState(false);
                break;
            }
            case 600977: {
                break;
            }
            default: {
                AbstractAuxheaterComponent.access$100(this.this$0, "keyPressed", n, n2, false);
            }
        }
    }

    @Override
    public void keyReleased(int n, int n2, int n3) {
        switch (n) {
            case 600721: {
                this.this$0.setAuxHeaterOnOffState(false);
                break;
            }
            case 600977: {
                if (AbstractAuxheaterComponent.access$200(this.this$0, 395).getValue() != 1) break;
                this.toggleOnOffByJokerKey();
                break;
            }
        }
    }

    private void toggleOnOffByJokerKey() {
        if (this.this$0.currentAuxHeatError.isBatteryLow()) {
            AbstractAuxheaterComponent.access$300(this.this$0).getFrameworkAccess().getMsgDistrib().sendMessage(76);
        } else if (this.this$0.currentAuxHeatError.isFuelLow()) {
            AbstractAuxheaterComponent.access$400(this.this$0).getFrameworkAccess().getMsgDistrib().sendMessage(75);
        } else if (this.this$0.currentAuxHeatError.isHeaterDefect()) {
            AbstractAuxheaterComponent.access$500(this.this$0).getFrameworkAccess().getMsgDistrib().sendMessage(74);
        } else if (this.this$0.currViewOptions != null && this.this$0.currViewOptions.getAuxHeaterCoolerOnOff().getState() == 2) {
            boolean bl = AbstractAuxheaterComponent.access$600(this.this$0, -1825961728).getValue() == 0;
            this.this$0.setAuxHeaterOnOffState(bl);
            AbstractAuxheaterComponent.access$700(this.this$0).getFrameworkAccess().getMsgDistrib().sendMessage(bl ? 69 : 70);
        }
    }

    /* synthetic */ AbstractAuxheaterComponent$AuxHeaterButtonListener(AbstractAuxheaterComponent abstractAuxheaterComponent, AbstractAuxheaterComponent$1 abstractAuxheaterComponent$1) {
        this(abstractAuxheaterComponent);
    }
}

