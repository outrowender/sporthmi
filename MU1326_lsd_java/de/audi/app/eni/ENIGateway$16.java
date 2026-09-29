/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.eni;

import de.audi.app.eni.ENIGateway;

class ENIGateway$16
implements Runnable {
    private final /* synthetic */ boolean val$privacyModeIsActive;
    private final /* synthetic */ ENIGateway this$0;

    ENIGateway$16(ENIGateway eNIGateway, boolean bl) {
        this.this$0 = eNIGateway;
        this.val$privacyModeIsActive = bl;
    }

    @Override
    public void run() {
        ENIGateway.access$800(this.this$0).remoteProcessPrivacyMode(this.val$privacyModeIsActive);
    }
}

