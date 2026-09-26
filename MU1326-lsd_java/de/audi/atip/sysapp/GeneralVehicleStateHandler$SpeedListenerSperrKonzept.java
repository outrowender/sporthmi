/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.sysapp;

import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.sysapp.GeneralVehicleStateHandler;
import de.audi.atip.sysapp.GeneralVehicleStateHandler$1;
import de.audi.atip.sysapp.SpeedThresholdListener;

final class GeneralVehicleStateHandler$SpeedListenerSperrKonzept
implements SpeedThresholdListener {
    private final ChoiceModelApp SperrKonzeptThresholdChoice;
    private final /* synthetic */ GeneralVehicleStateHandler this$0;

    private GeneralVehicleStateHandler$SpeedListenerSperrKonzept(GeneralVehicleStateHandler generalVehicleStateHandler) {
        this.this$0 = generalVehicleStateHandler;
        this.SperrKonzeptThresholdChoice = GeneralVehicleStateHandler.access$500(this.this$0).getFramework().getHMIService().getChoiceModel(5556);
    }

    @Override
    public void exceedsUpperThreshold(int n) {
        GeneralVehicleStateHandler.access$600(this.this$0).log(-2137614336, "SpeedListenerSperrKonzept.exceedsUpperLimit()");
        this.SperrKonzeptThresholdChoice.setValue(1);
    }

    @Override
    public void belowLowerThreshold(int n) {
        GeneralVehicleStateHandler.access$600(this.this$0).log(-2137614336, "SpeedListenerSperrKonzept.belowLowerThreshold()");
        this.SperrKonzeptThresholdChoice.setValue(0);
    }

    /* synthetic */ GeneralVehicleStateHandler$SpeedListenerSperrKonzept(GeneralVehicleStateHandler generalVehicleStateHandler, GeneralVehicleStateHandler$1 generalVehicleStateHandler$1) {
        this(generalVehicleStateHandler);
    }
}

