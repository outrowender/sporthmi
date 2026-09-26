/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.core.hybrid;

import de.audi.app.car.core.hybrid.AbstractAudiEnergyAssistComponent;
import de.audi.app.car.core.hybrid.AbstractAudiEnergyAssistComponent$1;
import de.audi.atip.interapp.car.AudiEnergyAssistService;
import de.audi.atip.interapp.car.AudiEnergyAssistStateListener;

class AbstractAudiEnergyAssistComponent$AudiEnergyAssistServiceHandler
implements AudiEnergyAssistService {
    private volatile AudiEnergyAssistStateListener listener;
    private int availableState = -1;
    private boolean systemActive = false;
    private int systemState = -1;
    private final /* synthetic */ AbstractAudiEnergyAssistComponent this$0;

    private AbstractAudiEnergyAssistComponent$AudiEnergyAssistServiceHandler(AbstractAudiEnergyAssistComponent abstractAudiEnergyAssistComponent) {
        this.this$0 = abstractAudiEnergyAssistComponent;
    }

    @Override
    public synchronized void registerStateListener(AudiEnergyAssistStateListener audiEnergyAssistStateListener) {
        this.this$0.getLogChannel().log(1078071040, "[AbstractAudiEnergyAssistComponent#registerStateListener] called");
        this.listener = audiEnergyAssistStateListener;
        audiEnergyAssistStateListener.updateAEASystemActive(this.systemActive);
        audiEnergyAssistStateListener.updateAEASystemState(this.systemState);
        audiEnergyAssistStateListener.updateAEAAvailable(this.availableState);
    }

    @Override
    public synchronized void deRegisterStateListener(AudiEnergyAssistStateListener audiEnergyAssistStateListener) {
        this.this$0.getLogChannel().log(1078071040, "[AbstractAudiEnergyAssistComponent#deRegisterStateListener] called");
        this.listener = null;
    }

    synchronized void updateAvailableState(int n) {
        this.availableState = n;
        if (this.listener != null) {
            this.listener.updateAEAAvailable(n);
        }
    }

    synchronized void updateSystemActive(boolean bl) {
        this.systemActive = bl;
        if (this.listener != null) {
            this.listener.updateAEASystemActive(bl);
        }
    }

    synchronized void updateSystemState(int n) {
        this.systemState = n;
        if (this.listener != null) {
            this.listener.updateAEASystemState(n);
        }
    }

    synchronized void reset() {
        this.listener = null;
        this.availableState = -1;
        this.systemActive = false;
        this.systemState = -1;
    }

    @Override
    public void setAEASystemActive(boolean bl) {
        this.this$0.getLogChannel().log(1078071040, "dsi.setHybridEnergyAssistControl(%1)", bl);
        this.this$0.getDSI().setHybridEnergyAssistControl(bl);
    }

    /* synthetic */ AbstractAudiEnergyAssistComponent$AudiEnergyAssistServiceHandler(AbstractAudiEnergyAssistComponent abstractAudiEnergyAssistComponent, AbstractAudiEnergyAssistComponent$1 abstractAudiEnergyAssistComponent$1) {
        this(abstractAudiEnergyAssistComponent);
    }
}

