/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.high;

import de.esolutions.hmi.widgets.audi.base.animation.AbstractAnimation;
import de.esolutions.hmi.widgets.audi.evo.high.AnimationControllerMIB2High;
import de.esolutions.hmi.widgets.audi.evo.high.AnimationMIB2Std;

public class AnimationControllerMIB2Std
extends AnimationControllerMIB2High {
    public AnimationControllerMIB2Std(int n) {
        super(n);
    }

    protected AbstractAnimation createAnimation(int n) {
        return new AnimationMIB2Std(this);
    }
}

