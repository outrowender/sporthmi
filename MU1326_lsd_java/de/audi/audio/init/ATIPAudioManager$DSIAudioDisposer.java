/*
 * Decompiled with CFR 0.152.
 */
package de.audi.audio.init;

import de.audi.atip.util.osgi.NullDSIAudioManagement;
import de.audi.audio.init.ATIPAudioManager;
import de.audi.audio.intra.IAudioListener;
import de.audi.audio.volume.StatusbarMuteIcon;
import org.dsi.ifc.audio.DSIAudioManagement;
import org.dsi.ifc.base.DSIListener;

final class ATIPAudioManager$DSIAudioDisposer {
    private final /* synthetic */ ATIPAudioManager this$0;

    ATIPAudioManager$DSIAudioDisposer(ATIPAudioManager aTIPAudioManager) {
        this.this$0 = aTIPAudioManager;
    }

    void addDSI(DSIAudioManagement dSIAudioManagement) {
        ATIPAudioManager.access$000((ATIPAudioManager)this.this$0).lcMain.log(1078071040, "[DSIAudioDisposer.addDSI] %1", (Object)dSIAudioManagement);
        this.setDSI(dSIAudioManagement);
        ATIPAudioManager.access$200(this.this$0).register(ATIPAudioManager.access$100(this.this$0));
        ATIPAudioManager.access$200(this.this$0).setInternalListeners(new IAudioListener[]{new StatusbarMuteIcon(ATIPAudioManager.access$000(this.this$0)), ATIPAudioManager.access$300(this.this$0), ATIPAudioManager.access$400(this.this$0), ATIPAudioManager.access$100(this.this$0).getRange(0), ATIPAudioManager.access$100(this.this$0).getRange(3), ATIPAudioManager.access$100(this.this$0).getRange(4), ATIPAudioManager.access$500(this.this$0), ATIPAudioManager.access$600(this.this$0).getAudioListener(), ATIPAudioManager.access$700((ATIPAudioManager)this.this$0).audioListener});
    }

    void removeDSI() {
        ATIPAudioManager.access$000((ATIPAudioManager)this.this$0).lcMain.log(1078071040, "[DSIAudioDisposer.removeDSI]");
        this.setDSI(new NullDSIAudioManagement(ATIPAudioManager.access$000((ATIPAudioManager)this.this$0).lcDSI));
    }

    private void setDSI(DSIAudioManagement dSIAudioManagement) {
        ATIPAudioManager.access$000(this.this$0).setDSIAudo(dSIAudioManagement);
        ATIPAudioManager.access$100(this.this$0).getRange(0).setService(dSIAudioManagement);
    }

    void setNotifications(DSIAudioManagement dSIAudioManagement) {
        int[] nArray = new int[]{1, 2, 3};
        ATIPAudioManager.access$000((ATIPAudioManager)this.this$0).lcMain.log(1078071040, "[DSIAudioDisposer.setNotifications] %1: %2", (Object)dSIAudioManagement, (Object)nArray);
        dSIAudioManagement.setNotification(nArray, (DSIListener)ATIPAudioManager.access$200(this.this$0));
    }
}

