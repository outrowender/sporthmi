/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.core.joker;

import de.audi.app.car.common.service.CarServiceTrackerListener;
import de.audi.app.car.core.joker.AbstractJokerKeyComponent;
import de.audi.app.car.core.joker.AbstractJokerKeyComponent$1;
import de.audi.atip.interapp.ExternalKeyListener;

class AbstractJokerKeyComponent$ExternalKeyServiceTrackerListener
implements CarServiceTrackerListener {
    private volatile ExternalKeyListener externalKeyService;
    private final /* synthetic */ AbstractJokerKeyComponent this$0;

    private AbstractJokerKeyComponent$ExternalKeyServiceTrackerListener(AbstractJokerKeyComponent abstractJokerKeyComponent) {
        this.this$0 = abstractJokerKeyComponent;
    }

    @Override
    public void serviceAvailable(Object object) {
        this.this$0.getLogChannel().log(1078071040, "[AbstractJokerKeyComponent#serviceAvailable] service received");
        try {
            this.externalKeyService = (ExternalKeyListener)object;
        }
        catch (ClassCastException classCastException) {
            this.this$0.getLogChannel().log(1000, "[AbstractJokerKeyComponent#serviceAvailable] ExternalKeyListener: cannot cast service");
        }
    }

    @Override
    public void serviceRemoved() {
        this.externalKeyService = null;
        this.this$0.getLogChannel().log(-2137614336, "[AbstractJokerKeyComponent#serviceRemoved] Service has been removed");
    }

    @Override
    public String[] getTrackedServiceClazzName() {
        return new String[]{(AbstractJokerKeyComponent.class$de$audi$atip$interapp$ExternalKeyListener == null ? (AbstractJokerKeyComponent.class$de$audi$atip$interapp$ExternalKeyListener = AbstractJokerKeyComponent.class$("de.audi.atip.interapp.ExternalKeyListener")) : AbstractJokerKeyComponent.class$de$audi$atip$interapp$ExternalKeyListener).getName()};
    }

    public synchronized boolean sendKey(int n) {
        if (null != this.externalKeyService) {
            this.externalKeyService.supplyExternalKey(100, n, 1, 1);
            this.externalKeyService.supplyExternalKey(100, n, 0, 1);
            return true;
        }
        return false;
    }

    /* synthetic */ AbstractJokerKeyComponent$ExternalKeyServiceTrackerListener(AbstractJokerKeyComponent abstractJokerKeyComponent, AbstractJokerKeyComponent$1 abstractJokerKeyComponent$1) {
        this(abstractJokerKeyComponent);
    }
}

