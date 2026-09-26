/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.core.hybrid;

import de.audi.app.car.common.adapter.AbstractDSICarHybridAdapter;
import de.audi.app.car.common.app.ICarApplication;
import de.audi.app.car.common.comp.CarDSIAttributesSet;
import de.audi.app.car.common.service.CarServiceProvider;
import de.audi.app.car.core.hybrid.AbstractAudiEnergyAssistComponent$AudiEnergyAssistServiceHandler;
import org.dsi.ifc.carhybrid.HybridViewOptions;
import org.dsi.ifc.global.CarViewOption;

public abstract class AbstractAudiEnergyAssistComponent
extends AbstractDSICarHybridAdapter {
    private static final String LOGCHANNEL_NAME;
    private volatile CarServiceProvider serviceProvider;
    private final AbstractAudiEnergyAssistComponent$AudiEnergyAssistServiceHandler serviceHandler = new AbstractAudiEnergyAssistComponent$AudiEnergyAssistServiceHandler(this, null);
    private volatile HybridViewOptions currentViewOptions;
    private boolean[] startServiceTrigger = new boolean[]{false, false, false};
    private int oldAvailableState;
    public static final short[] CODING_ID;
    static /* synthetic */ Class class$de$audi$atip$interapp$car$AudiEnergyAssistService;

    public AbstractAudiEnergyAssistComponent(ICarApplication iCarApplication) {
        super(iCarApplication, "App.Car.AEA");
        this.serviceProvider = new CarServiceProvider((class$de$audi$atip$interapp$car$AudiEnergyAssistService == null ? (class$de$audi$atip$interapp$car$AudiEnergyAssistService = AbstractAudiEnergyAssistComponent.class$("de.audi.atip.interapp.car.AudiEnergyAssistService")) : class$de$audi$atip$interapp$car$AudiEnergyAssistService).getName(), this.serviceHandler, null, iCarApplication.getBundleContext(), iCarApplication.getFrameworkAccess().getLogChannel("App.Car.AEA"));
    }

    @Override
    public void init() {
        super.init();
    }

    @Override
    public void deinit() {
        super.deinit();
        this.serviceProvider.stopService();
        this.serviceHandler.reset();
        this.startServiceTrigger = new boolean[]{false, false, false};
    }

    @Override
    protected void initModels() {
    }

    @Override
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

    @Override
    public void updateHybridViewOptions(HybridViewOptions hybridViewOptions, int n) {
        this.getLogChannel().log(1078071040, "updateHybridViewOptions(%1), valid:%2", (Object)hybridViewOptions, (long)n);
        if (n == 1) {
            int n2 = this.getMenuEntryVisibilityState(new CarViewOption[]{hybridViewOptions.hybridEnergyAssistState});
            if (n2 != this.oldAvailableState) {
                this.serviceHandler.updateAvailableState(n2);
                this.oldAvailableState = n2;
            }
            this.primaryAttributeFirstSetReceived();
        }
    }

    @Override
    public void updateHybridEnergyAssistControl(boolean bl, int n) {
        this.getLogChannel().log(1078071040, "updateHybridEnergyAssistControl(%1), valid:%2", bl, (long)n);
        if (n == 1) {
            this.serviceHandler.updateSystemActive(bl);
            this.serviceStarterTriggerRecievied(0);
        }
    }

    @Override
    public void updateHybridEnergyAssistState(int n, int n2) {
        this.getLogChannel().log(1078071040, "updateHybridEnergyAssistState(%1), valid:%2", (long)n, (long)n2);
        if (n2 == 1) {
            this.serviceHandler.updateSystemState(n);
            this.serviceStarterTriggerRecievied(1);
        }
    }

    @Override
    public CarDSIAttributesSet[] getDSIAttributesSets() {
        return new CarDSIAttributesSet[]{new CarDSIAttributesSet(0, new int[]{1}, new int[]{20, 21})};
    }

    @Override
    public String getCurrentViewOptions() {
        if (this.currentViewOptions != null) {
            return this.currentViewOptions.toString();
        }
        return "not yet received";
    }

    @Override
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

    static {
        CODING_ID = new short[]{24, 41};
    }
}

