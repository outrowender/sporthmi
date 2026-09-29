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
    private static final int CHARISMA_INDIV_AIRSUSPENSION_DAMPER;
    private static final int CHARISMA_INDIV_AIRSUSPENSION_NORMAL;
    private static final int CHARISMA_INDIV_AIRSUSPENSION_SPORT;

    public AirSuspensionIndicatorComponentEvo(ICarApplication iCarApplication) {
        super(iCarApplication);
    }

    @Override
    protected void updateMenuEntryVisibility(SuspensionControlViewOptions suspensionControlViewOptions) {
        this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(260, this.getAirSuspensionLvlIconVisibilityState(suspensionControlViewOptions));
        int n = this.getMenuEntryVisibilityState(suspensionControlViewOptions.getCarJackMode());
        this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(-1238890240, n);
        this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(-1809315584, this.getMenuEntryVisibilityState(suspensionControlViewOptions.getTrailerMode()));
        SuspensionControlConfiguration suspensionControlConfiguration = suspensionControlViewOptions.getConfiguration();
        int n2 = 0;
        if (suspensionControlConfiguration != null) {
            n2 = suspensionControlConfiguration.getModelType() == 1 || suspensionControlConfiguration.getModelType() == 4 || suspensionControlConfiguration.getModelType() == 5 ? 2 : 1;
        }
        this.getChoiceModel(707528960).setValue(n2);
    }

    @Override
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

    @Override
    protected void initVisibility() {
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(260, (short)21);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(-1238890240, (short)21);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(-1809315584, (short)21);
    }

    @Override
    protected void deinitVisibility() {
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(260);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(-1238890240);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(-1809315584);
    }

    @Override
    public int getID() {
        return 25;
    }
}

