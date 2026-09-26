/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.core.light;

import de.audi.app.car.core.light.AbstractIntLightComponent;

class AbstractIntLightComponent$AllSetSyncHandler {
    private final /* synthetic */ AbstractIntLightComponent this$0;

    AbstractIntLightComponent$AllSetSyncHandler(AbstractIntLightComponent abstractIntLightComponent) {
        this.this$0 = abstractIntLightComponent;
    }

    protected void triggerAllSetSync(boolean bl) {
        if (this.this$0.intLightSetEvaluator.hasAllSetsSyncSet() && this.this$0.inOneBrightnessScreen && !bl) {
            int n = AbstractIntLightComponent.access$000(this.this$0).getRangeModel().getValue();
            if (this.this$0.getIntLightSetEvaluator() != null) {
                int n2 = this.this$0.getIntLightSetEvaluator().getAllSetsSyncSetNumber();
                this.this$0.getLogChannel().log(1078071040, "[IntLightSingleRotaryBusiness: sync: dsi.setIntLightIlluminationSet(%1, %2)]", (long)n2, (long)n);
                this.this$0.getDSI().setIntLightIlluminationSet(n2, n);
            }
        }
    }
}

