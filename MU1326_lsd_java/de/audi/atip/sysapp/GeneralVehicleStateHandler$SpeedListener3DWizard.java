/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.sysapp;

import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.sysapp.GeneralVehicleStateHandler;
import de.audi.atip.sysapp.GeneralVehicleStateHandler$1;
import de.audi.atip.sysapp.SpeedThresholdListener;

final class GeneralVehicleStateHandler$SpeedListener3DWizard
implements SpeedThresholdListener {
    private final ChoiceModelApp Wizard3DThresholdChoice;
    private final /* synthetic */ GeneralVehicleStateHandler this$0;

    private GeneralVehicleStateHandler$SpeedListener3DWizard(GeneralVehicleStateHandler generalVehicleStateHandler) {
        this.this$0 = generalVehicleStateHandler;
        this.Wizard3DThresholdChoice = GeneralVehicleStateHandler.access$500(this.this$0).getFramework().getHMIService().getChoiceModel(139);
    }

    @Override
    public void exceedsUpperThreshold(int n) {
        GeneralVehicleStateHandler.access$600(this.this$0).log(-2137614336, "SpeedListener3DWizard.exceedsUpperLimit()");
        this.Wizard3DThresholdChoice.setValue(1);
    }

    @Override
    public void belowLowerThreshold(int n) {
        GeneralVehicleStateHandler.access$600(this.this$0).log(-2137614336, "SpeedListener3DWizard.belowLowerThreshold()");
        this.Wizard3DThresholdChoice.setValue(0);
    }

    /* synthetic */ GeneralVehicleStateHandler$SpeedListener3DWizard(GeneralVehicleStateHandler generalVehicleStateHandler, GeneralVehicleStateHandler$1 generalVehicleStateHandler$1) {
        this(generalVehicleStateHandler);
    }
}

