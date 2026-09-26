/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tone.app.volume;

import de.audi.tone.app.volume.AbstractVolumeRange;
import de.audi.tone.app.volume.VolumeRangeManager;

public abstract class AbstractPhoneVolumeRange
extends AbstractVolumeRange {
    protected int scenario = 0;

    public AbstractPhoneVolumeRange(VolumeRangeManager volumeRangeManager, int n, int n2, int n3) {
        super(volumeRangeManager, n, n2, n3);
    }

    public AbstractPhoneVolumeRange(VolumeRangeManager volumeRangeManager, int n, int n2) {
        super(volumeRangeManager, n, n2);
    }

    public void setPhoneAudioScenario(int n) {
        int n2;
        if (this.scenario == n) {
            return;
        }
        this.scenario = n;
        this.env.lcMain.log(1078071040, "[RingtoneVolumeRange.setPhoneAudioScenario] %1", (long)n);
        switch (n) {
            case 1: {
                n2 = 88;
                break;
            }
            case 2: {
                n2 = 87;
                break;
            }
            case 3: {
                n2 = 91;
                break;
            }
            default: {
                n2 = 0;
            }
        }
        this.setForegroundConnection(n2);
        this.init();
    }

    protected void setUserDefinedRingtone(String string, String string2) {
    }
}

