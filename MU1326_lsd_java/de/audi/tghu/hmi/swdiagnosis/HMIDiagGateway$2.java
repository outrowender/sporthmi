/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.hmi.swdiagnosis;

import de.audi.tghu.hmi.swdiagnosis.HMIDiagGateway;

class HMIDiagGateway$2
extends Thread {
    private final /* synthetic */ int val$xStart;
    private final /* synthetic */ int val$yStart;
    private final /* synthetic */ int val$xTarget;
    private final /* synthetic */ int val$yTarget;
    private final /* synthetic */ HMIDiagGateway this$0;

    HMIDiagGateway$2(HMIDiagGateway hMIDiagGateway, int n, int n2, int n3, int n4) {
        this.this$0 = hMIDiagGateway;
        this.val$xStart = n;
        this.val$yStart = n2;
        this.val$xTarget = n3;
        this.val$yTarget = n4;
    }

    @Override
    public void run() {
        this.this$0.cmdGestureScreenPressed(this.val$xStart, this.val$yStart);
        this.sleep(200);
        this.this$0.cmdGestureScreenMoved(this.val$xTarget, this.val$yTarget);
        this.sleep(200);
        this.this$0.cmdGestureScreenReleased(this.val$xTarget, this.val$yTarget);
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

