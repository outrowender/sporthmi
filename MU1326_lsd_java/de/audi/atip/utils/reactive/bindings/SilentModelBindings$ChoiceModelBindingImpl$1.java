/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.audi.atip.utils.reactive.bindings.SilentModelBindings$ChoiceModelBindingImpl
 */
package de.audi.atip.utils.reactive.bindings;

import de.audi.atip.utils.generics.Function;
import de.audi.atip.utils.reactive.bindings.SilentModelBindings;

class SilentModelBindings$ChoiceModelBindingImpl$1
implements Function {
    private final /* synthetic */ SilentModelBindings.ChoiceModelBindingImpl this$0;

    SilentModelBindings$ChoiceModelBindingImpl$1(SilentModelBindings.ChoiceModelBindingImpl choiceModelBindingImpl) {
        this.this$0 = choiceModelBindingImpl;
    }

    public Boolean apply(Integer n) {
        return new Boolean(n != 0);
    }

    @Override
    public /* synthetic */ Object apply(Object object) {
        return this.apply((Integer)object);
    }
}

