/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tone.app.sound;

import de.audi.tone.app.ToneEnv;
import de.audi.tone.app.intra.AbstractAppListener;

public class SoundSource
extends AbstractAppListener {
    private static final int FM = 0;
    private static final int AM = 1;
    private static final int SDARS = 2;
    private static final int DAB = 3;
    private static final int TV = 4;
    private static final int CD_CDC = 5;
    private static final int DVD_DVDC = 6;
    private static final int MEDIA = 7;
    private static final int AUX = 9;
    private static final int AUX_BT = 10;
    private static final int IPOD = 11;
    private static final int WLAN = 12;
    private static final int SMARTPHONE_INTEGRATION = 13;
    private final ToneEnv env;

    public SoundSource(ToneEnv toneEnv) {
        this.env = toneEnv;
    }

    public void updateConnectionStatus(int n, int n2, int n3) {
        if (n2 == 2 || n2 == 4) {
            int n4;
            switch (n) {
                case 12: {
                    n4 = 0;
                    break;
                }
                case 13: {
                    n4 = 1;
                    break;
                }
                case 28: {
                    n4 = 2;
                    break;
                }
                case 26: {
                    n4 = 3;
                    break;
                }
                case 27: {
                    n4 = 4;
                    break;
                }
                case 18: {
                    n4 = 5;
                    break;
                }
                case 19: 
                case 23: 
                case 24: {
                    n4 = 6;
                    break;
                }
                case 20: {
                    n4 = 7;
                    break;
                }
                case 16: {
                    n4 = 9;
                    break;
                }
                case 21: {
                    n4 = 10;
                    break;
                }
                case 17: {
                    n4 = 11;
                    break;
                }
                case 156: 
                case 162: {
                    n4 = 13;
                    break;
                }
                case 45: {
                    n4 = 12;
                    break;
                }
                default: {
                    return;
                }
            }
            this.env.lcHMI.log(10000000, "[SoundSource.updateConnectionStatus] AC:%1 source:%2", (long)n, (long)n4);
            this.env.getChoiceModel(1000051).setValue(n4);
        }
    }
}

