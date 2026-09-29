/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.eni;

import de.audi.app.eni.ENIGateway;

class ENIGateway$10
implements Runnable {
    private final /* synthetic */ String val$userLogin;
    private final /* synthetic */ String val$vehiclePin;
    private final /* synthetic */ ENIGateway this$0;

    ENIGateway$10(ENIGateway eNIGateway, String string, String string2) {
        this.this$0 = eNIGateway;
        this.val$userLogin = string;
        this.val$vehiclePin = string2;
    }

    @Override
    public void run() {
        ENIGateway.access$800(this.this$0).remoteProcessPairMainUserUsingVehiclePin(this.val$userLogin, this.val$vehiclePin);
    }
}

