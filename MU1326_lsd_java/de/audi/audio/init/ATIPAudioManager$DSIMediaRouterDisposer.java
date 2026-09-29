/*
 * Decompiled with CFR 0.152.
 */
package de.audi.audio.init;

import de.audi.audio.init.ATIPAudioManager;
import de.audi.audio.services.NullDSIMediaRouter;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.media.DSIMediaRouter;

final class ATIPAudioManager$DSIMediaRouterDisposer {
    private final /* synthetic */ ATIPAudioManager this$0;

    ATIPAudioManager$DSIMediaRouterDisposer(ATIPAudioManager aTIPAudioManager) {
        this.this$0 = aTIPAudioManager;
    }

    void addDSI(DSIMediaRouter dSIMediaRouter) {
        ATIPAudioManager.access$000((ATIPAudioManager)this.this$0).lcDSI.log(1078071040, "[DSIMediaRouterDisposer.addDSI] %1", (Object)dSIMediaRouter);
        int[] nArray = new int[]{2};
        dSIMediaRouter.setNotification(nArray, (DSIListener)ATIPAudioManager.access$800(this.this$0));
        ATIPAudioManager.access$900(this.this$0).setDSIMediaRouter(dSIMediaRouter);
    }

    void removeDSI() {
        ATIPAudioManager.access$900(this.this$0).setDSIMediaRouter(new NullDSIMediaRouter(ATIPAudioManager.access$000((ATIPAudioManager)this.this$0).lcDSI));
    }
}

