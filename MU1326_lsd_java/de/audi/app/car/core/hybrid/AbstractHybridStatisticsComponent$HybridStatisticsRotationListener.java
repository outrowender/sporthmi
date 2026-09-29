/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.core.hybrid;

import de.audi.app.car.core.hybrid.AbstractHybridStatisticsComponent;
import de.audi.app.car.core.hybrid.AbstractHybridStatisticsComponent$1;
import de.audi.atip.hmi.model.DefaultButtonListener;
import de.audi.atip.hmi.model.RangeListener;

final class AbstractHybridStatisticsComponent$HybridStatisticsRotationListener
extends DefaultButtonListener
implements RangeListener {
    public static final int ROTATION_LEFT;
    public static final int ROTATION_RIGHT;
    private byte lastRotation = (byte)-1;
    private final /* synthetic */ AbstractHybridStatisticsComponent this$0;

    private AbstractHybridStatisticsComponent$HybridStatisticsRotationListener(AbstractHybridStatisticsComponent abstractHybridStatisticsComponent) {
        this.this$0 = abstractHybridStatisticsComponent;
    }

    @Override
    public void decrement(int n, int n2, int n3) {
        if (n == -2010183424 && this.lastRotation != 1) {
            AbstractHybridStatisticsComponent.access$500(this.this$0, -2010183424).setValue(1);
            this.lastRotation = 1;
        }
    }

    @Override
    public void increment(int n, int n2, int n3) {
        if (n == -2010183424 && this.lastRotation != 0) {
            AbstractHybridStatisticsComponent.access$600(this.this$0, -2010183424).setValue(0);
            this.lastRotation = 0;
        }
    }

    /* synthetic */ AbstractHybridStatisticsComponent$HybridStatisticsRotationListener(AbstractHybridStatisticsComponent abstractHybridStatisticsComponent, AbstractHybridStatisticsComponent$1 abstractHybridStatisticsComponent$1) {
        this(abstractHybridStatisticsComponent);
    }
}

