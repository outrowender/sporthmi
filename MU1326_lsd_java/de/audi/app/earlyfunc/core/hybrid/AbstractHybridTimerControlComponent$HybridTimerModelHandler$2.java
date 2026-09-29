/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.earlyfunc.core.hybrid;

import de.audi.app.earlyfunc.core.hybrid.AbstractHybridTimerControlComponent;
import de.audi.app.earlyfunc.core.hybrid.AbstractHybridTimerControlComponent$HybridTimerModelHandler;
import de.audi.atip.hmi.model.listener.DefaultChoiceListener;

class AbstractHybridTimerControlComponent$HybridTimerModelHandler$2
extends DefaultChoiceListener {
    private final /* synthetic */ AbstractHybridTimerControlComponent$HybridTimerModelHandler this$1;

    AbstractHybridTimerControlComponent$HybridTimerModelHandler$2(AbstractHybridTimerControlComponent$HybridTimerModelHandler abstractHybridTimerControlComponent$HybridTimerModelHandler) {
        this.this$1 = abstractHybridTimerControlComponent$HybridTimerModelHandler;
    }

    @Override
    public void itemSelected(int n, int n2, int n3, int n4) {
        boolean bl;
        AbstractHybridTimerControlComponent$HybridTimerModelHandler.access$000(this.this$1).getLogChannel().log(-2137614336, "[HybridTimerModelHandler.DefaultChoiceListener#itemSelected] modelID='%1', itemID='%2'", (long)n, (long)n2);
        boolean bl2 = bl = 1 == n2;
        if (n == AbstractHybridTimerControlComponent$HybridTimerModelHandler.access$700(this.this$1)) {
            this.this$1.dsiSetBatteryControlTimerState(bl);
        } else if (n == AbstractHybridTimerControlComponent$HybridTimerModelHandler.access$800(this.this$1)) {
            int n5 = n2;
            if (0 == n5) {
                AbstractHybridTimerControlComponent$HybridTimerModelHandler.access$000(this.this$1).onTimerFunctionItemSelected(AbstractHybridTimerControlComponent$HybridTimerModelHandler.access$300(this.this$1), n5);
            } else {
                AbstractHybridTimerControlComponent$HybridTimerModelHandler.access$000(this.this$1).dsiSetBatteryControlTimerFunction(AbstractHybridTimerControlComponent$HybridTimerModelHandler.access$300(this.this$1), n5);
            }
        } else if (n == AbstractHybridTimerControlComponent$HybridTimerModelHandler.access$900(this.this$1)) {
            int n6;
            int n7 = n2;
            int n8 = n6 = AbstractHybridTimerControlComponent$HybridTimerModelHandler.access$200(this.this$1) ? 1 : 0;
            if (n6 != n7) {
                AbstractHybridTimerControlComponent$HybridTimerModelHandler.access$000(this.this$1).dsiSetBatteryControlTimerType(AbstractHybridTimerControlComponent$HybridTimerModelHandler.access$300(this.this$1), n7);
            }
        } else if (n == AbstractHybridTimerControlComponent$HybridTimerModelHandler.access$1000(this.this$1)) {
            if (AbstractHybridTimerControlComponent$HybridTimerModelHandler.access$1100(this.this$1)) {
                AbstractHybridTimerControlComponent$HybridTimerModelHandler.access$1200(this.this$1, 2, bl);
            }
        } else if (n == AbstractHybridTimerControlComponent$HybridTimerModelHandler.access$1300(this.this$1)) {
            if (AbstractHybridTimerControlComponent$HybridTimerModelHandler.access$1100(this.this$1)) {
                AbstractHybridTimerControlComponent$HybridTimerModelHandler.access$1200(this.this$1, 3, bl);
            }
        } else if (n == AbstractHybridTimerControlComponent$HybridTimerModelHandler.access$1400(this.this$1)) {
            if (AbstractHybridTimerControlComponent$HybridTimerModelHandler.access$1100(this.this$1)) {
                AbstractHybridTimerControlComponent$HybridTimerModelHandler.access$1200(this.this$1, 4, bl);
            }
        } else if (n == AbstractHybridTimerControlComponent$HybridTimerModelHandler.access$1500(this.this$1)) {
            if (AbstractHybridTimerControlComponent$HybridTimerModelHandler.access$1100(this.this$1)) {
                AbstractHybridTimerControlComponent$HybridTimerModelHandler.access$1200(this.this$1, 5, bl);
            }
        } else if (n == AbstractHybridTimerControlComponent$HybridTimerModelHandler.access$1600(this.this$1)) {
            if (AbstractHybridTimerControlComponent$HybridTimerModelHandler.access$1100(this.this$1)) {
                AbstractHybridTimerControlComponent$HybridTimerModelHandler.access$1200(this.this$1, 6, bl);
            }
        } else if (n == AbstractHybridTimerControlComponent$HybridTimerModelHandler.access$1700(this.this$1)) {
            if (AbstractHybridTimerControlComponent$HybridTimerModelHandler.access$1100(this.this$1)) {
                AbstractHybridTimerControlComponent$HybridTimerModelHandler.access$1200(this.this$1, 7, bl);
            }
        } else if (n == AbstractHybridTimerControlComponent$HybridTimerModelHandler.access$1800(this.this$1)) {
            if (AbstractHybridTimerControlComponent$HybridTimerModelHandler.access$1100(this.this$1)) {
                AbstractHybridTimerControlComponent$HybridTimerModelHandler.access$1200(this.this$1, 1, bl);
            }
        } else if (n == AbstractHybridTimerControlComponent$HybridTimerModelHandler.access$1900(this.this$1)) {
            if (AbstractHybridTimerControlComponent$HybridTimerModelHandler.access$1100(this.this$1)) {
                AbstractHybridTimerControlComponent$HybridTimerModelHandler.access$1200(this.this$1, 2, bl);
            } else {
                AbstractHybridTimerControlComponent.access$2000(AbstractHybridTimerControlComponent$HybridTimerModelHandler.access$000(this.this$1), AbstractHybridTimerControlComponent$HybridTimerModelHandler.access$1900(this.this$1)).setValue(bl ? 1 : 0);
            }
        } else if (n == AbstractHybridTimerControlComponent$HybridTimerModelHandler.access$2100(this.this$1)) {
            if (AbstractHybridTimerControlComponent$HybridTimerModelHandler.access$1100(this.this$1)) {
                AbstractHybridTimerControlComponent$HybridTimerModelHandler.access$1200(this.this$1, 3, bl);
            } else {
                AbstractHybridTimerControlComponent.access$2200(AbstractHybridTimerControlComponent$HybridTimerModelHandler.access$000(this.this$1), AbstractHybridTimerControlComponent$HybridTimerModelHandler.access$2100(this.this$1)).setValue(bl ? 1 : 0);
            }
        } else if (n == AbstractHybridTimerControlComponent$HybridTimerModelHandler.access$2300(this.this$1)) {
            if (AbstractHybridTimerControlComponent$HybridTimerModelHandler.access$1100(this.this$1)) {
                AbstractHybridTimerControlComponent$HybridTimerModelHandler.access$1200(this.this$1, 4, bl);
            } else {
                AbstractHybridTimerControlComponent.access$2400(AbstractHybridTimerControlComponent$HybridTimerModelHandler.access$000(this.this$1), AbstractHybridTimerControlComponent$HybridTimerModelHandler.access$2300(this.this$1)).setValue(bl ? 1 : 0);
            }
        } else if (n == AbstractHybridTimerControlComponent$HybridTimerModelHandler.access$2500(this.this$1)) {
            if (AbstractHybridTimerControlComponent$HybridTimerModelHandler.access$1100(this.this$1)) {
                AbstractHybridTimerControlComponent$HybridTimerModelHandler.access$1200(this.this$1, 5, bl);
            } else {
                AbstractHybridTimerControlComponent.access$2600(AbstractHybridTimerControlComponent$HybridTimerModelHandler.access$000(this.this$1), AbstractHybridTimerControlComponent$HybridTimerModelHandler.access$2500(this.this$1)).setValue(bl ? 1 : 0);
            }
        } else if (n == AbstractHybridTimerControlComponent$HybridTimerModelHandler.access$2700(this.this$1)) {
            if (AbstractHybridTimerControlComponent$HybridTimerModelHandler.access$1100(this.this$1)) {
                AbstractHybridTimerControlComponent$HybridTimerModelHandler.access$1200(this.this$1, 6, bl);
            } else {
                AbstractHybridTimerControlComponent.access$2800(AbstractHybridTimerControlComponent$HybridTimerModelHandler.access$000(this.this$1), AbstractHybridTimerControlComponent$HybridTimerModelHandler.access$2700(this.this$1)).setValue(bl ? 1 : 0);
            }
        } else if (n == AbstractHybridTimerControlComponent$HybridTimerModelHandler.access$2900(this.this$1)) {
            if (AbstractHybridTimerControlComponent$HybridTimerModelHandler.access$1100(this.this$1)) {
                AbstractHybridTimerControlComponent$HybridTimerModelHandler.access$1200(this.this$1, 7, bl);
            } else {
                AbstractHybridTimerControlComponent.access$3000(AbstractHybridTimerControlComponent$HybridTimerModelHandler.access$000(this.this$1), AbstractHybridTimerControlComponent$HybridTimerModelHandler.access$2900(this.this$1)).setValue(bl ? 1 : 0);
            }
        } else if (n == AbstractHybridTimerControlComponent$HybridTimerModelHandler.access$3100(this.this$1)) {
            if (AbstractHybridTimerControlComponent$HybridTimerModelHandler.access$1100(this.this$1)) {
                AbstractHybridTimerControlComponent$HybridTimerModelHandler.access$1200(this.this$1, 1, bl);
            } else {
                AbstractHybridTimerControlComponent.access$3200(AbstractHybridTimerControlComponent$HybridTimerModelHandler.access$000(this.this$1), AbstractHybridTimerControlComponent$HybridTimerModelHandler.access$3100(this.this$1)).setValue(bl ? 1 : 0);
            }
        } else if (n == AbstractHybridTimerControlComponent$HybridTimerModelHandler.access$3300(this.this$1)) {
            if (AbstractHybridTimerControlComponent$HybridTimerModelHandler.access$1100(this.this$1)) {
                AbstractHybridTimerControlComponent$HybridTimerModelHandler.access$3400(this.this$1, bl);
            } else {
                AbstractHybridTimerControlComponent.access$3500(AbstractHybridTimerControlComponent$HybridTimerModelHandler.access$000(this.this$1), AbstractHybridTimerControlComponent$HybridTimerModelHandler.access$3300(this.this$1)).setValue(bl ? 1 : 0);
                AbstractHybridTimerControlComponent.access$3600(AbstractHybridTimerControlComponent$HybridTimerModelHandler.access$000(this.this$1), AbstractHybridTimerControlComponent$HybridTimerModelHandler.access$1900(this.this$1)).setValue(bl ? 1 : 0);
                AbstractHybridTimerControlComponent.access$3700(AbstractHybridTimerControlComponent$HybridTimerModelHandler.access$000(this.this$1), AbstractHybridTimerControlComponent$HybridTimerModelHandler.access$2100(this.this$1)).setValue(bl ? 1 : 0);
                AbstractHybridTimerControlComponent.access$3800(AbstractHybridTimerControlComponent$HybridTimerModelHandler.access$000(this.this$1), AbstractHybridTimerControlComponent$HybridTimerModelHandler.access$2300(this.this$1)).setValue(bl ? 1 : 0);
                AbstractHybridTimerControlComponent.access$3900(AbstractHybridTimerControlComponent$HybridTimerModelHandler.access$000(this.this$1), AbstractHybridTimerControlComponent$HybridTimerModelHandler.access$2500(this.this$1)).setValue(bl ? 1 : 0);
                AbstractHybridTimerControlComponent.access$4000(AbstractHybridTimerControlComponent$HybridTimerModelHandler.access$000(this.this$1), AbstractHybridTimerControlComponent$HybridTimerModelHandler.access$2700(this.this$1)).setValue(bl ? 1 : 0);
                AbstractHybridTimerControlComponent.access$4100(AbstractHybridTimerControlComponent$HybridTimerModelHandler.access$000(this.this$1), AbstractHybridTimerControlComponent$HybridTimerModelHandler.access$2900(this.this$1)).setValue(bl ? 1 : 0);
                AbstractHybridTimerControlComponent.access$4200(AbstractHybridTimerControlComponent$HybridTimerModelHandler.access$000(this.this$1), AbstractHybridTimerControlComponent$HybridTimerModelHandler.access$3100(this.this$1)).setValue(bl ? 1 : 0);
            }
        } else {
            AbstractHybridTimerControlComponent$HybridTimerModelHandler.access$000(this.this$1).getLogChannel().log(-1601830656, "[HybridTimerModelHandler.DefaultChoiceListener#itemSelected] ModelID='%1' not supported.", (long)n);
        }
    }
}

