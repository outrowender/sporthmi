/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tone.app.sound;

import de.audi.tone.app.ToneEnv;
import de.audi.tone.app.intra.AbstractAppListener;

public class SoundSource
extends AbstractAppListener {
    private static final int FM;
    private static final int AM;
    private static final int SDARS;
    private static final int DAB;
    private static final int TV;
    private static final int CD_CDC;
    private static final int DVD_DVDC;
    private static final int MEDIA;
    private static final int AUX;
    private static final int AUX_BT;
    private static final int IPOD;
    private static final int WLAN;
    private static final int SMARTPHONE_INTEGRATION;
    private final ToneEnv env;

    public SoundSource(ToneEnv toneEnv) {
        this.env = toneEnv;
    }

    @Override
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
            this.env.lcHMI.log(-2137614336, "[SoundSource.updateConnectionStatus] AC:%1 source:%2", (long)n, (long)n4);
            this.env.getChoiceModel(1933709056).setValue(n4);
        }
    }
}

