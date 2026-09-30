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
        this.animationParameters[57][n] = 3.0f;
        this.animationParameters[57][n2] = 30.0f;
        this.animationParameters[57][n3] = 5.0f;
        this.animationParameters[57][n4] = 900.0f;
        this.animationParameters[57][n5] = 900.0f;
        this.animationParameters[57][n6] = 1.0f;
    }
}

