/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.sysapp;

import de.audi.atip.audio.DefaultHMIAudioServiceListener;
import de.audi.atip.sysapp.GeneralVehicleStateHandler;
import de.audi.atip.sysapp.GeneralVehicleStateHandler$1;

class GeneralVehicleStateHandler$AudioListener
extends DefaultHMIAudioServiceListener {
    private final /* synthetic */ GeneralVehicleStateHandler this$0;

    private GeneralVehicleStateHandler$AudioListener(GeneralVehicleStateHandler generalVehicleStateHandler) {
        this.this$0 = generalVehicleStateHandler;
    }

    @Override
    public void updateAMAvailable(boolean bl) {
        if (bl) {
            GeneralVehicleStateHandler.access$400(this.this$0);
        }
    }

    /* synthetic */ GeneralVehicleStateHandler$AudioListener(GeneralVehicleStateHandler generalVehicleStateHandler, GeneralVehicleStateHandler$1 generalVehicleStateHandler$1) {
        this(generalVehicleStateHandler);
    }
}

