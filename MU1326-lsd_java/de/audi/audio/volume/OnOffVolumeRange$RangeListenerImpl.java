/*
 * Decompiled with CFR 0.152.
 */
package de.audi.audio.volume;

import de.audi.atip.audio.AudioConnection;
import de.audi.atip.hmi.model.DefaultRangeListener;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.interapp.audio.SDISRangeListener;
import de.audi.audio.store.ConnectionStore;
import de.audi.audio.volume.OnOffVolumeRange;
import de.esolutions.fw.util.commons.Buffer;

public class OnOffVolumeRange$RangeListenerImpl
extends DefaultRangeListener
implements SDISRangeListener {
    private final /* synthetic */ OnOffVolumeRange this$0;

    public OnOffVolumeRange$RangeListenerImpl(OnOffVolumeRange onOffVolumeRange) {
        this.this$0 = onOffVolumeRange;
    }

    @Override
    public void keyTyped(int n, int n2, int n3) {
        OnOffVolumeRange.access$300((OnOffVolumeRange)this.this$0).lcVol.log(-2137614336, "%1.keyTyped] model:%2", (Object)OnOffVolumeRange.access$200(this.this$0), (long)n);
        OnOffVolumeRange.access$600(this.this$0).hide();
        if (OnOffVolumeRange.access$300((OnOffVolumeRange)this.this$0).framework.getSysConst(4490) == 1 && (OnOffVolumeRange.access$700(this.this$0) || OnOffVolumeRange.access$800(this.this$0))) {
            ChoiceModelApp choiceModelApp = OnOffVolumeRange.access$300(this.this$0).getChoiceModel(OnOffVolumeRange.access$900(this.this$0), 4488);
            if (choiceModelApp.getValue() == 1) {
                choiceModelApp.setValue(0);
            } else {
                choiceModelApp.setValue(1);
            }
        } else {
            OnOffVolumeRange.access$1000(this.this$0);
        }
    }

    @Override
    public void decrement(int n, int n2, int n3) {
        if (this.ignoreVolumeChange("decrement")) {
            return;
        }
        if (this.triggerVolumePopup()) {
            OnOffVolumeRange.access$600(this.this$0).show();
        } else {
            OnOffVolumeRange.access$600(this.this$0).hide();
        }
        int n4 = OnOffVolumeRange.access$1100(this.this$0).getMinimum();
        int n5 = OnOffVolumeRange.access$1100(this.this$0).getValue();
        if (OnOffVolumeRange.access$300((OnOffVolumeRange)this.this$0).lcVol.isDebug()) {
            Buffer buffer = new Buffer();
            buffer.append("value:").append(n5);
            buffer.append(" steps:").append(n2);
            buffer.append(" min:").append(n4);
            OnOffVolumeRange.access$300((OnOffVolumeRange)this.this$0).lcVol.log(-2137614336, "%1.decrement] %2", (Object)OnOffVolumeRange.access$200(this.this$0), (Object)buffer);
        }
        if (n5 - n2 < n4) {
            n2 = n5 - n4;
        }
        if (n2 > 0) {
            OnOffVolumeRange.access$1200(this.this$0, 2, n2);
        }
    }

    boolean triggerVolumePopup() {
        OnOffVolumeRange.access$300((OnOffVolumeRange)this.this$0).lcVol.log(14808325, "[%1.triggerVolumePopup] entered", (Object)OnOffVolumeRange.access$200(this.this$0));
        int n = ConnectionStore.INSTANCE.getActiveConnection(OnOffVolumeRange.access$900(this.this$0));
        OnOffVolumeRange.access$300((OnOffVolumeRange)this.this$0).lcVol.log(14808325, "[%1.triggerVolumePopup] activeConnection: %2", (Object)OnOffVolumeRange.access$200(this.this$0), (long)n);
        OnOffVolumeRange.access$300((OnOffVolumeRange)this.this$0).lcVol.log(14808325, "[OnOffVolumeRange.triggerVolumePopup] volumeMenuActive: %1, isMenuConnectionActive: %2, isMenuConnectionRequested: %3", OnOffVolumeRange.access$700(this.this$0), OnOffVolumeRange.access$800(this.this$0));
        if (OnOffVolumeRange.access$700(this.this$0) && (OnOffVolumeRange.access$800(this.this$0) || this.isRelatedAnnouncement(n) || this.isAPS(n) || OnOffVolumeRange.access$300((OnOffVolumeRange)this.this$0).framework.getSysConst(4527) == 1)) {
            OnOffVolumeRange.access$300((OnOffVolumeRange)this.this$0).lcVol.log(14808325, "[%1.triggerVolumePopup] do not show VolumePopup", (long)n);
            return false;
        }
        OnOffVolumeRange.access$300((OnOffVolumeRange)this.this$0).lcVol.log(14808325, "[%1.triggerVolumePopup] activeConnection: %1 show VolumePopup", (long)n);
        return true;
    }

    private boolean isRelatedAnnouncement(int n) {
        int[] nArray;
        if (AudioConnection.contains(AudioConnection.TA_PTY31, n) && OnOffVolumeRange.access$1300(this.this$0, nArray = new int[]{85, 84})) {
            OnOffVolumeRange.access$300((OnOffVolumeRange)this.this$0).lcVol.log(14808325, "[OnOffVolumeRange.isRelatedAnnouncement] true");
            return true;
        }
        return false;
    }

    private boolean isAPS(int n) {
        return n == 4;
    }

    @Override
    public void increment(int n, int n2, int n3) {
        if (this.ignoreVolumeChange("increment")) {
            return;
        }
        if (this.triggerVolumePopup()) {
            OnOffVolumeRange.access$600(this.this$0).show();
        } else {
            OnOffVolumeRange.access$600(this.this$0).hide();
        }
        int n4 = OnOffVolumeRange.access$1100(this.this$0).getMaximum();
        int n5 = OnOffVolumeRange.access$1100(this.this$0).getValue();
        if (OnOffVolumeRange.access$300((OnOffVolumeRange)this.this$0).lcVol.isDebug()) {
            Buffer buffer = new Buffer();
            buffer.append("value:").append(n5);
            buffer.append(" steps:").append(n2);
            buffer.append(" max:").append(n4);
            OnOffVolumeRange.access$300((OnOffVolumeRange)this.this$0).lcVol.log(-2137614336, "%1.increment] %2", (Object)OnOffVolumeRange.access$200(this.this$0), (Object)buffer);
        }
        if (n5 + n2 > n4) {
            n2 = n4 - n5;
        }
        if (n2 > 0) {
            OnOffVolumeRange.access$1400(this.this$0, 2, n2);
        }
    }

    @Override
    public void changeVolume(int n) {
        int n2 = n - OnOffVolumeRange.access$1100(this.this$0).getValue();
        if (n2 < 0) {
            this.decrement(OnOffVolumeRange.access$1100(this.this$0).getID(), -n2, 0);
        } else {
            this.increment(OnOffVolumeRange.access$1100(this.this$0).getID(), n2, 0);
        }
    }

    private int getUsedPhoneConnection() {
        int[] nArray = ConnectionStore.INSTANCE.getConnectionsInUse(OnOffVolumeRange.access$900(this.this$0));
        for (int i2 = 0; i2 < nArray.length; ++i2) {
            if (AudioConnection.contains(AudioConnection.PHONE_RINGING, nArray[i2])) {
                return nArray[i2];
            }
            if (AudioConnection.contains(AudioConnection.PHONE_CALL, nArray[i2]) && nArray[i2] != 100) {
                return nArray[i2];
            }
            if (!AudioConnection.contains(AudioConnection.CONNECTED_GATEWAY_CONNS, nArray[i2])) continue;
            return nArray[i2];
        }
        return 0;
    }

    private boolean ignoreVolumeChange(String string) {
        if (OnOffVolumeRange.access$1500(this.this$0, 3)) {
            if (this.getUsedPhoneConnection() != 0) {
                OnOffVolumeRange.access$300((OnOffVolumeRange)this.this$0).lcVol.log(1078071040, "%1.%2] MMI_ON_TEL", (Object)OnOffVolumeRange.access$200(this.this$0), (Object)string);
                return false;
            }
            OnOffVolumeRange.access$300((OnOffVolumeRange)this.this$0).lcVol.log(1078071040, "%1.%2] IGNORED as mute standby active", (Object)OnOffVolumeRange.access$200(this.this$0), (Object)string);
            return true;
        }
        if (OnOffVolumeRange.access$1500(this.this$0, 48)) {
            OnOffVolumeRange.access$300((OnOffVolumeRange)this.this$0).lcVol.log(1078071040, "%1.%2] IGNORED as welcome sound active", (Object)OnOffVolumeRange.access$200(this.this$0), (Object)string);
            return true;
        }
        return false;
    }
}

