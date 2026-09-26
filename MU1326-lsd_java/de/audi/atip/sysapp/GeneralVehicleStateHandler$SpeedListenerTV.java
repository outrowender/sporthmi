/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.sysapp;

import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.sysapp.GeneralVehicleStateHandler;
import de.audi.atip.sysapp.GeneralVehicleStateHandler$1;
import de.audi.atip.sysapp.SpeedThresholdListener;

final class GeneralVehicleStateHandler$SpeedListenerTV
implements SpeedThresholdListener {
    private final ChoiceModelApp TVThresholdChoice;
    private final /* synthetic */ GeneralVehicleStateHandler this$0;

    private GeneralVehicleStateHandler$SpeedListenerTV(GeneralVehicleStateHandler generalVehicleStateHandler) {
        this.this$0 = generalVehicleStateHandler;
        this.TVThresholdChoice = GeneralVehicleStateHandler.access$500(this.this$0).getFramework().getHMIService().getChoiceModel(4594);
    }

    @Override
    public void exceedsUpperThreshold(int n) {
        GeneralVehicleStateHandler.access$600(this.this$0).log(-2137614336, "SpeedListenerTV.exceedsUpperLimit()");
        this.TVThresholdChoice.setValue(1);
    }

    @Override
    public void belowLowerThreshold(int n) {
        GeneralVehicleStateHandler.access$600(this.this$0).log(-2137614336, "SpeedListenerTV.belowLowerThreshold()");
        this.TVThresholdChoice.setValue(0);
    }

    /* synthetic */ GeneralVehicleStateHandler$SpeedListenerTV(GeneralVehicleStateHandler generalVehicleStateHandler, GeneralVehicleStateHandler$1 generalVehicleStateHandler$1) {
        this(generalVehicleStateHandler);
    }
}

