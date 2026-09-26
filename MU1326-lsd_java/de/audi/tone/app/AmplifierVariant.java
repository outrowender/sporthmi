/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tone.app;

import de.audi.tone.app.ToneEnv;
import de.audi.tone.app.intra.AbstractAppListener;
import de.esolutions.fw.util.commons.Buffer;

public class AmplifierVariant
extends AbstractAppListener {
    private static final int FALLBACK_DEFAULT;
    private static final int BASIC_SOUND;
    private static final int BASIC_PLUS_SOUND;
    private static final int STANDARD_SOUND;
    private static final int PREMIUM_SOUND_BOSE;
    private static final int PREMIUM_SOUND_BO;
    private static final int ADVANCED_SOUND;
    private static final int ADVANCED_BURMESTER_PORSCHE;
    private static final int PREMIUM_BOSE_PORSCHE;
    private static final int PREMIUM_ALPINE_BENTLEY;
    private static final int ADVANCED_B_O_BENTLEY;
    private final ToneEnv env;
    private volatile int amplifierTypeDSI = -1;
    private volatile String amplifierDescription = null;

    public AmplifierVariant(ToneEnv toneEnv) {
        this.env = toneEnv;
        toneEnv.getChoiceModel(1665273600).setValue(0);
    }

    @Override
    public void updateAmplifier(int n) {
        int n2;
        this.amplifierTypeDSI = n;
        switch (n) {
            case 1: {
                n2 = 1;
                this.amplifierDescription = "Basic Sound (0x120)";
                break;
            }
            case 2: {
                n2 = 2;
                this.amplifierDescription = "Basic Plus Sound (0x121)";
                break;
            }
            case 3: 
            case 18: {
                n2 = 3;
                this.amplifierDescription = "Standard Sound (0x122, 0x161)";
                break;
            }
            case 4: {
                n2 = 5;
                this.amplifierDescription = "Premium Sound (B&O, 0x140)";
                break;
            }
            case 17: {
                n2 = 4;
                this.amplifierDescription = "Premium Sound (BOSE, 0x160)";
                break;
            }
            case 21: {
                n2 = 6;
                this.amplifierDescription = "Advanced Sound";
                break;
            }
            case 23: {
                n2 = 7;
                this.amplifierDescription = "Advanced Burmester Porsche";
                break;
            }
            case 19: {
                n2 = 8;
                this.amplifierDescription = "Premium BOSE Porsche";
                break;
            }
            case 5: {
                n2 = 9;
                this.amplifierDescription = "Premium Alpine Bentley";
                break;
            }
            case 22: {
                n2 = 10;
                this.amplifierDescription = "Advanced B&O Bentley";
                break;
            }
            default: {
                this.env.lcHMI.log(1000, "[AmplifierVariant.updateAmplifier] Unknown amplifier type %1!", (long)n);
                n2 = 0;
                this.amplifierDescription = "Default-Screen";
            }
        }
        this.env.lcHMI.log(1078071040, "[AmplifierVariant.updateAmplifier] amplifier:%2 -> %1", (Object)this.amplifierDescription, (long)n);
        this.env.getChoiceModel(1665273600).setValue(n2);
    }

    public boolean isStandardOrBasicSound() {
        switch (this.amplifierTypeDSI) {
            case 1: 
            case 2: 
            case 3: {
                return true;
            }
        }
        return false;
    }

    public boolean isAmplifierPorscheSurround() {
        switch (this.amplifierTypeDSI) {
            case 19: 
            case 23: {
                return true;
            }
        }
        return false;
    }

    public String toString() {
        return new Buffer().append("AmplifierVariant: '").append(this.amplifierDescription).append("' (").append(this.amplifierTypeDSI).append(')').toString();
    }
}

