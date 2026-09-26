/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.high;

import de.esolutions.hmi.widgets.audi.evo.high.HMITerminalImplMIB2High;

class HMITerminalImplMIB2High$12
implements Runnable {
    private final /* synthetic */ HMITerminalImplMIB2High this$0;

    HMITerminalImplMIB2High$12(HMITerminalImplMIB2High hMITerminalImplMIB2High) {
        this.this$0 = hMITerminalImplMIB2High;
    }

    @Override
    public void run() {
        HMITerminalImplMIB2High.access$000(this.this$0).setTransparentImageID(HMITerminalImplMIB2High.TRANSPARENT_IMAGE_ID);
        if (HMITerminalImplMIB2High.access$100(this.this$0).isR8()) {
            HMITerminalImplMIB2High.backgroundImageId = HMITerminalImplMIB2High.BLACK_IMAGE_ID_R8;
            HMITerminalImplMIB2High.access$000(this.this$0).setBackgroundImageID(HMITerminalImplMIB2High.BLACK_IMAGE_ID_R8);
            HMITerminalImplMIB2High.access$000(this.this$0).updateBackgroundImageNode(this);
        }
        HMITerminalImplMIB2High.access$000(this.this$0).setBlackImageID(HMITerminalImplMIB2High.BLACK_IMAGE_ID);
        HMITerminalImplMIB2High.access$000(this.this$0).setBackgroundImageID(HMITerminalImplMIB2High.backgroundImageId);
        HMITerminalImplMIB2High.access$000(this.this$0).createLayers(this);
    }

    public String toString() {
        return "ealManager.createLayers";
    }
}

