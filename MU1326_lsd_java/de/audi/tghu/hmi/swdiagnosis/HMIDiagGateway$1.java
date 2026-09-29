/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.hmi.swdiagnosis;

import de.audi.tghu.hmi.swdiagnosis.HMIDiagGateway;

class HMIDiagGateway$1
extends Thread {
    private final /* synthetic */ int val$x;
    private final /* synthetic */ int val$y;
    private final /* synthetic */ HMIDiagGateway this$0;

    HMIDiagGateway$1(HMIDiagGateway hMIDiagGateway, int n, int n2) {
        this.this$0 = hMIDiagGateway;
        this.val$x = n;
        this.val$y = n2;
    }

    @Override
    public void run() {
        this.this$0.cmdGestureScreenPressed(this.val$x, this.val$y);
        this.sleep(200);
        this.this$0.cmdGestureScreenReleased(this.val$x, this.val$y);
    }

    private void sleep(int n) {
        try {
            Thread.sleep(n);
        }
        catch (InterruptedException interruptedException) {
            // empty catch block
        }
    }
}

