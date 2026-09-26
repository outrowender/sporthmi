/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.earlyfunc.core.hybrid;

import de.audi.app.earlyfunc.core.hybrid.AbstractAuxACComponent;
import de.audi.app.earlyfunc.core.hybrid.AbstractAuxACComponent$1;
import de.audi.atip.hmi.model.listener.DefaultChoiceListener;
import org.dsi.ifc.carhybrid.BatteryControlProgrammedTimer;

final class AbstractAuxACComponent$AuxCoolerChoiceListener
extends DefaultChoiceListener {
    private final /* synthetic */ AbstractAuxACComponent this$0;

    private AbstractAuxACComponent$AuxCoolerChoiceListener(AbstractAuxACComponent abstractAuxACComponent) {
        this.this$0 = abstractAuxACComponent;
    }

    @Override
    public void itemSelected(int n, int n2, int n3, int n4) {
        AbstractAuxACComponent.access$600(this.this$0, "itemSelected:", n, n2, true);
        switch (n) {
            case 2100369: {
                this.this$0.getLogChannel().log(1078071040, "%1 timer1 ", (Object)(n2 == 1 ? "activate" : "deactivate"));
                this.switchTimerActivation(n2 == 1, false);
                break;
            }
            case 2100362: {
                this.this$0.getLogChannel().log(1078071040, "%1 timer2 ", (Object)(n2 == 1 ? "activate" : "deactivate"));
                this.switchTimerActivation(false, n2 == 1);
                break;
            }
            case 2100403: {
                AbstractAuxACComponent.access$700(this.this$0).getService().setAuxAcClimateSystem(6, n2);
                break;
            }
            case 2100372: {
                AbstractAuxACComponent.access$700(this.this$0).getService().setAuxAcClimateSystem(3, n2);
                break;
            }
            case 2100402: {
                AbstractAuxACComponent.access$700(this.this$0).getService().setAuxAcClimateSystem(4, n2);
                break;
            }
            default: {
                AbstractAuxACComponent.access$800(this.this$0, "itemSelected:", n, n2, false);
            }
        }
    }

    private void switchTimerActivation(boolean bl, boolean bl2) {
        BatteryControlProgrammedTimer batteryControlProgrammedTimer = new BatteryControlProgrammedTimer(AbstractAuxACComponent.access$900((AbstractAuxACComponent)this.this$0).programmedTimer.timer1, AbstractAuxACComponent.access$900((AbstractAuxACComponent)this.this$0).programmedTimer.timer2, bl, bl2);
        this.this$0.getLogChannel().log(1078071040, "switchTimerActivation: dsi.setBatteryControlTimerState(timer=%1)", (Object)batteryControlProgrammedTimer);
        this.this$0.getDSI().setBatteryControlTimerState(batteryControlProgrammedTimer);
    }

    /* synthetic */ AbstractAuxACComponent$AuxCoolerChoiceListener(AbstractAuxACComponent abstractAuxACComponent, AbstractAuxACComponent$1 abstractAuxACComponent$1) {
        this(abstractAuxACComponent);
    }
}

