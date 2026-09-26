/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.core.hybrid;

import de.audi.app.car.core.hybrid.AbstractHybridStatisticsComponent;
import de.audi.app.car.core.hybrid.AbstractHybridStatisticsComponent$1;
import de.audi.atip.hmi.model.DefaultButtonListener;

final class AbstractHybridStatisticsComponent$HybridStatisticsButtonListener
extends DefaultButtonListener {
    private final /* synthetic */ AbstractHybridStatisticsComponent this$0;

    private AbstractHybridStatisticsComponent$HybridStatisticsButtonListener(AbstractHybridStatisticsComponent abstractHybridStatisticsComponent) {
        this.this$0 = abstractHybridStatisticsComponent;
    }

    @Override
    public void keyPressed(int n, int n2, int n3) {
        this.this$0.getLogChannel().log(-2137614336, "[AbstractHybridStatisticsComponent#keyPressed] modelID='%1', keyID='%2'", (long)n, (long)n2);
        switch (n) {
            case 601705: {
                AbstractHybridStatisticsComponent.access$200(this.this$0, -718403328).setValue(0);
                AbstractHybridStatisticsComponent.access$300(this.this$0, -718403328).setStatus(0);
                AbstractHybridStatisticsComponent.access$400(this.this$0, 1764624640).fireEvent(n3);
                this.this$0.fireLongTermStatisticsReset();
                break;
            }
        }
    }

    /* synthetic */ AbstractHybridStatisticsComponent$HybridStatisticsButtonListener(AbstractHybridStatisticsComponent abstractHybridStatisticsComponent, AbstractHybridStatisticsComponent$1 abstractHybridStatisticsComponent$1) {
        this(abstractHybridStatisticsComponent);
    }
}

