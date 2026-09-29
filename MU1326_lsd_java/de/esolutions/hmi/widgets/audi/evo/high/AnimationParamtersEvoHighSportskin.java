/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.high;

import de.esolutions.hmi.widgets.audi.evo.high.AnimationParametersEvoHigh;

public class AnimationParamtersEvoHighSportskin
extends AnimationParametersEvoHigh {
    private static AnimationParamtersEvoHighSportskin singletonSportskin;

    public static synchronized AnimationParametersEvoHigh getAnimationParametersEvoHighSportskin() {
        if (singletonSportskin == null) {
            singletonSportskin = new AnimationParamtersEvoHighSportskin();
        }
        return singletonSportskin;
    }

    private AnimationParamtersEvoHighSportskin() {
        this.adjustParametersForSportskin();
    }

    private void adjustParametersForSportskin() {
        int n = 0;
        int n2 = 1;
        int n3 = 2;
        int n4 = 3;
        int n5 = 4;
        int n6 = 5;
        this.animationParameters[57][n] = 16448;
        this.animationParameters[57][n2] = 61505;
        this.animationParameters[57][n3] = 41024;
        this.animationParameters[57][n4] = 24900;
        this.animationParameters[57][n5] = 24900;
        this.animationParameters[57][n6] = 1.0f;
    }
}

