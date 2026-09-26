/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.core.aircondition;

import de.audi.app.car.core.aircondition.AbstractAirconNozzleComponent;
import de.audi.app.car.core.aircondition.AbstractAirconNozzleComponent$1;
import de.audi.app.car.core.aircondition.nozzle.AirconNozzleCtrl;
import de.audi.atip.hmi.model.ChoiceListener;
import de.audi.atip.hmi.model.RangeListener;
import de.audi.atip.hmi.model.RangeListener2D;

class AbstractAirconNozzleComponent$AirconR1CenterNozzleListener
implements ChoiceListener,
RangeListener,
RangeListener2D {
    private final /* synthetic */ AbstractAirconNozzleComponent this$0;

    private AbstractAirconNozzleComponent$AirconR1CenterNozzleListener(AbstractAirconNozzleComponent abstractAirconNozzleComponent) {
        this.this$0 = abstractAirconNozzleComponent;
    }

    @Override
    public void itemSelected(int n, int n2, int n3, int n4) {
        boolean bl = n2 == 1;
        switch (n) {
            case 601893: {
                AbstractAirconNozzleComponent.access$100(this.this$0, 1, this.this$0.isNozzleOnOffStateInverted ? !bl : bl);
                break;
            }
            case 602419: {
                AbstractAirconNozzleComponent.access$200(this.this$0, 1, n2);
                break;
            }
            case 602369: {
                AbstractAirconNozzleComponent.access$200(this.this$0, 2, n2);
                break;
            }
            default: {
                return;
            }
        }
    }

    @Override
    public void itemFocused(int n, int n2, int n3, int n4) {
    }

    @Override
    public void keyPressed(int n, int n2, int n3) {
        switch (n) {
            case 602393: {
                AbstractAirconNozzleComponent.access$300(this.this$0, 1);
                break;
            }
            case 602371: {
                AbstractAirconNozzleComponent.access$300(this.this$0, 2);
                break;
            }
            case 602412: {
                AbstractAirconNozzleComponent.access$400(this.this$0, 1, 100);
                break;
            }
            case 602376: {
                AbstractAirconNozzleComponent.access$500(this.this$0, 1, 100);
                break;
            }
            case 602414: {
                AbstractAirconNozzleComponent.access$400(this.this$0, 2, 100);
                break;
            }
            case 602391: {
                AbstractAirconNozzleComponent.access$500(this.this$0, 2, 100);
                break;
            }
            default: {
                return;
            }
        }
    }

    @Override
    public void keyReleased(int n, int n2, int n3) {
        switch (n) {
            case 602393: {
                AirconNozzleCtrl airconNozzleCtrl = this.this$0.airconR1CenterNozzleController.getNozzleCtrlByID(1);
                if (null != airconNozzleCtrl) {
                    airconNozzleCtrl.setPosition(airconNozzleCtrl.getCurrentHorizontalPosition(), airconNozzleCtrl.getCurrentVerticalPosition(), true, true);
                }
                AbstractAirconNozzleComponent.access$600(this.this$0, 1);
                break;
            }
            case 602371: {
                AirconNozzleCtrl airconNozzleCtrl = this.this$0.airconR1CenterNozzleController.getNozzleCtrlByID(2);
                if (null != airconNozzleCtrl) {
                    airconNozzleCtrl.setPosition(airconNozzleCtrl.getCurrentHorizontalPosition(), airconNozzleCtrl.getCurrentVerticalPosition(), true, true);
                }
                AbstractAirconNozzleComponent.access$600(this.this$0, 2);
                break;
            }
            default: {
                return;
            }
        }
    }

    @Override
    public void keyTyped(int n, int n2, int n3) {
    }

    @Override
    public void keyLongTyped(int n, int n2, int n3) {
    }

    @Override
    public void decrement(int n, int n2, int n3) {
        switch (n) {
            case 601895: {
                AbstractAirconNozzleComponent.access$400(this.this$0, 1, n2);
                break;
            }
            case 602402: {
                AbstractAirconNozzleComponent.access$400(this.this$0, 2, n2);
                break;
            }
            default: {
                return;
            }
        }
    }

    @Override
    public void increment(int n, int n2, int n3) {
        switch (n) {
            case 601895: {
                AbstractAirconNozzleComponent.access$500(this.this$0, 1, n2);
                break;
            }
            case 602402: {
                AbstractAirconNozzleComponent.access$500(this.this$0, 2, n2);
                break;
            }
            default: {
                return;
            }
        }
    }

    @Override
    public void setValueHit(int n, int n2, int n3, int n4) {
        switch (n) {
            case 602393: {
                AbstractAirconNozzleComponent.access$700(this.this$0, 1, n2, n3);
                break;
            }
            case 602371: {
                AbstractAirconNozzleComponent.access$700(this.this$0, 2, n2, n3);
                break;
            }
            default: {
                return;
            }
        }
    }

    /* synthetic */ AbstractAirconNozzleComponent$AirconR1CenterNozzleListener(AbstractAirconNozzleComponent abstractAirconNozzleComponent, AbstractAirconNozzleComponent$1 abstractAirconNozzleComponent$1) {
        this(abstractAirconNozzleComponent);
    }
}

