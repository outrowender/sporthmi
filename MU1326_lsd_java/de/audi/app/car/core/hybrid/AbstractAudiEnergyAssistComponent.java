/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.core.hybrid;

import de.audi.app.car.common.adapter.AbstractDSICarHybridAdapter;
import de.audi.app.car.common.app.ICarApplication;
import de.audi.app.car.common.comp.CarDSIAttributesSet;
import de.audi.app.car.common.service.CarServiceProvider;
import de.audi.atip.interapp.car.AudiEnergyAssistService;
import de.audi.atip.interapp.car.AudiEnergyAssistStateListener;
import org.dsi.ifc.carhybrid.HybridViewOptions;
import org.dsi.ifc.global.CarViewOption;

public abstract class AbstractAudiEnergyAssistComponent
extends AbstractDSICarHybridAdapter {
    private static final String LOGCHANNEL_NAME = "App.Car.AEA";
    private volatile CarServiceProvider serviceProvider;
    private final AudiEnergyAssistServiceHandler serviceHandler = new AudiEnergyAssistServiceHandler();
    private volatile HybridViewOptions currentViewOptions;
    private boolean[] startServiceTrigger = new boolean[]{false, false, false};
    private int oldAvailableState;
    public static final short[] CODING_ID = new short[]{24, 41};
    static /* synthetic */ Class class$de$audi$atip$interapp$car$AudiEnergyAssistService;

    public AbstractAudiEnergyAssistComponent(ICarApplication iCarApplication) {
        super(iCarApplication, LOGCHANNEL_NAME);
        this.serviceProvider = new CarServiceProvider((class$de$audi$atip$interapp$car$AudiEnergyAssistService == null ? (class$de$audi$atip$interapp$car$AudiEnergyAssistService = AbstractAudiEnergyAssistComponent.class$("de.audi.atip.interapp.car.AudiEnergyAssistService")) : class$de$audi$atip$interapp$car$AudiEnergyAssistService).getName(), this.serviceHandler, null, iCarApplication.getBundleContext(), iCarApplication.getFrameworkAccess().getLogChannel(LOGCHANNEL_NAME));
    }

    public void init() {
        super.init();
    }

    public void deinit() {
        super.deinit();
        this.serviceProvider.stopService();
        this.serviceHandler.reset();
        this.startServiceTrigger = new boolean[]{false, false, false};
    }

    protected void initModels() {
    }

    protected void deinitModels() {
    }

    private void serviceStarterTriggerRecievied(int n) {
        if (!this.startServiceTrigger[2]) {
            this.startServiceTrigger[n] = true;
            if (this.startServiceTrigger[0] && this.startServiceTrigger[1]) {
                this.startServiceTrigger[2] = true;
                this.serviceProvider.startService();
            }
        }
    }

    public void updateHybridViewOptions(HybridViewOptions hybridViewOptions, int n) {
        this.getLogChannel().log(1000000, "updateHybridViewOptions(%1), valid:%2", (Object)hybridViewOptions, (long)n);
        if (n == 1) {
            int n2 = this.getMenuEntryVisibilityState(new CarViewOption[]{hybridViewOptions.hybridEnergyAssistState});
            if (n2 != this.oldAvailableState) {
                this.serviceHandler.updateAvailableState(n2);
                this.oldAvailableState = n2;
            }
            this.primaryAttributeFirstSetReceived();
        }
    }

    public void updateHybridEnergyAssistControl(boolean bl, int n) {
        this.getLogChannel().log(1000000, "updateHybridEnergyAssistControl(%1), valid:%2", bl, (long)n);
        if (n == 1) {
            this.serviceHandler.updateSystemActive(bl);
            this.serviceStarterTriggerRecievied(0);
        }
    }

    public void updateHybridEnergyAssistState(int n, int n2) {
        this.getLogChannel().log(1000000, "updateHybridEnergyAssistState(%1), valid:%2", (long)n, (long)n2);
        if (n2 == 1) {
            this.serviceHandler.updateSystemState(n);
            this.serviceStarterTriggerRecievied(1);
        }
    }

    public CarDSIAttributesSet[] getDSIAttributesSets() {
        return new CarDSIAttributesSet[]{new CarDSIAttributesSet(0, new int[]{1}, new int[]{20, 21})};
    }

    public String getCurrentViewOptions() {
        if (this.currentViewOptions != null) {
            return this.currentViewOptions.toString();
        }
        return "not yet received";
    }

    public String getName() {
        return "AudiEnergyAssist (InterApp)";
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    private class AudiEnergyAssistServiceHandler
    implements AudiEnergyAssistService {
        private volatile AudiEnergyAssistStateListener listener;
        private int availableState = -1;
        private boolean systemActive = false;
        private int systemState = -1;

        private AudiEnergyAssistServiceHandler() {
        }

        public synchronized void registerStateListener(AudiEnergyAssistStateListener audiEnergyAssistStateListener) {
            AbstractAudiEnergyAssistComponent.this.getLogChannel().log(1000000, "[AbstractAudiEnergyAssistComponent#registerStateListener] called");
            this.listener = audiEnergyAssistStateListener;
            audiEnergyAssistStateListener.updateAEASystemActive(this.systemActive);
            audiEnergyAssistStateListener.updateAEASystemState(this.systemState);
            audiEnergyAssistStateListener.updateAEAAvailable(this.availableState);
        }

        public synchronized void deRegisterStateListener(AudiEnergyAssistStateListener audiEnergyAssistStateListener) {
            AbstractAudiEnergyAssistComponent.this.getLogChannel().log(1000000, "[AbstractAudiEnergyAssistComponent#deRegisterStateListener] called");
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

        public void setAEASystemActive(boolean bl) {
            AbstractAudiEnergyAssistComponent.this.getLogChannel().log(1000000, "dsi.setHybridEnergyAssistControl(%1)", bl);
            AbstractAudiEnergyAssistComponent.this.getDSI().setHybridEnergyAssistControl(bl);
        }
    }
}

