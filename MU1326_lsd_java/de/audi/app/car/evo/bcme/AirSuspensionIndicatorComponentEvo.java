/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.evo.bcme;

import de.audi.app.car.common.app.ICarApplication;
import de.audi.app.car.core.bcme.AbstractAirSuspensionIndicatorComponent;
import org.dsi.ifc.cardrivingcharacteristics.SuspensionControlAdditionalFunctions;
import org.dsi.ifc.cardrivingcharacteristics.SuspensionControlConfiguration;
import org.dsi.ifc.cardrivingcharacteristics.SuspensionControlViewOptions;

public class AirSuspensionIndicatorComponentEvo
extends AbstractAirSuspensionIndicatorComponent {
    private static final int CHARISMA_INDIV_AIRSUSPENSION_DAMPER = 0;
    private static final int CHARISMA_INDIV_AIRSUSPENSION_NORMAL = 1;
    private static final int CHARISMA_INDIV_AIRSUSPENSION_SPORT = 2;

    public AirSuspensionIndicatorComponentEvo(ICarApplication iCarApplication) {
        super(iCarApplication);
    }

    protected void updateMenuEntryVisibility(SuspensionControlViewOptions suspensionControlViewOptions) {
        this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(260, this.getAirSuspensionLvlIconVisibilityState(suspensionControlViewOptions));
        int n = this.getMenuEntryVisibilityState(suspensionControlViewOptions.getCarJackMode());
        this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(600246, n);
        this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(600212, this.getMenuEntryVisibilityState(suspensionControlViewOptions.getTrailerMode()));
        SuspensionControlConfiguration suspensionControlConfiguration = suspensionControlViewOptions.getConfiguration();
        int n2 = 0;
        if (suspensionControlConfiguration != null) {
            n2 = suspensionControlConfiguration.getModelType() == 1 || suspensionControlConfiguration.getModelType() == 4 || suspensionControlConfiguration.getModelType() == 5 ? 2 : 1;
        }
        this.getChoiceModel(601130).setValue(n2);
    }

    protected boolean isAirSuspensionActiveByVehicleState(int n) {
        return true;
    }

    private int getAirSuspensionLvlIconVisibilityState(SuspensionControlViewOptions suspensionControlViewOptions) {
        if (this.isAirSuspensionLvlIconVisible(suspensionControlViewOptions)) {
            return 0;
        }
        return 1;
    }

    private boolean isAirSuspensionLvlIconVisible(SuspensionControlViewOptions suspensionControlViewOptions) {
        if (suspensionControlViewOptions.getConfiguration() != null && suspensionControlViewOptions.getConfiguration().getAdditionalFunctionsAvailability() != null) {
            SuspensionControlAdditionalFunctions suspensionControlAdditionalFunctions = suspensionControlViewOptions.getConfiguration().getAdditionalFunctionsAvailability();
            return suspensionControlAdditionalFunctions.isActualNiveau();
        }
        return false;
    }

    protected void initVisibility() {
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(260, (short)21);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(600246, (short)21);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(600212, (short)21);
    }

    protected void deinitVisibility() {
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(260);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(600246);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(600212);
    }

    public int getID() {
        return 25;
    }
}

