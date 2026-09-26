/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.high;

import de.esolutions.hmi.widgets.audi.base.animation.AbstractAnimationController;
import de.esolutions.hmi.widgets.audi.evo.high.AnimationMIB2High;
import de.esolutions.hmi.widgets.audi.evo.high.AnimationParametersMIB2Std;
import de.esolutions.hmi.widgets.audi.evo.high.IAnimationParametersMIB2;

public class AnimationMIB2Std
extends AnimationMIB2High {
    public AnimationMIB2Std(AbstractAnimationController abstractAnimationController) {
        super(abstractAnimationController);
    }

    @Override
    protected IAnimationParametersMIB2 getAnimationParameters() {
        return AnimationParametersMIB2Std.getAnimationParametersMIB2Std();
    }
}

