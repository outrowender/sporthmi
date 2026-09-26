/*
 * Decompiled with CFR 0.152.
 */
package de.audi.audio.init;

import de.audi.atip.util.osgi.NullDSISound;
import de.audi.audio.init.ATIPAudioManager;
import org.dsi.ifc.audio.DSISound;

final class ATIPAudioManager$DSISoundDisposer {
    private final /* synthetic */ ATIPAudioManager this$0;

    ATIPAudioManager$DSISoundDisposer(ATIPAudioManager aTIPAudioManager) {
        this.this$0 = aTIPAudioManager;
    }

    void addDSI(DSISound dSISound) {
        ATIPAudioManager.access$000((ATIPAudioManager)this.this$0).lcMain.log(1078071040, "[DSISoundDisposer.addDSI] %1", (Object)dSISound);
        this.setDSI(dSISound);
        ATIPAudioManager.access$300(this.this$0).addDSI(dSISound);
        dSISound.getMenuVolumeRange(82, 1);
    }

    void removeDSI() {
        ATIPAudioManager.access$000((ATIPAudioManager)this.this$0).lcMain.log(1078071040, "[DSISoundDisposer.removeDSI]");
        this.setDSI(new NullDSISound(ATIPAudioManager.access$000((ATIPAudioManager)this.this$0).lcDSI));
    }

    private void setDSI(DSISound dSISound) {
        ATIPAudioManager.access$100(this.this$0).getRange(0).setService(dSISound);
    }
}

