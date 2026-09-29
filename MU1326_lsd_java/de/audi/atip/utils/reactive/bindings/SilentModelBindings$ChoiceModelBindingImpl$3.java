/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.audi.atip.utils.reactive.bindings.SilentModelBindings$ChoiceModelBindingImpl
 */
package de.audi.atip.utils.reactive.bindings;

import de.audi.atip.utils.generics.Consumer;
import de.audi.atip.utils.reactive.bindings.SilentModelBindings;

class SilentModelBindings$ChoiceModelBindingImpl$3
implements Consumer {
    private final /* synthetic */ SilentModelBindings.ChoiceModelBindingImpl this$0;

    SilentModelBindings$ChoiceModelBindingImpl$3(SilentModelBindings.ChoiceModelBindingImpl choiceModelBindingImpl) {
        this.this$0 = choiceModelBindingImpl;
    }

    public void accept(Integer n) {
        SilentModelBindings.ChoiceModelBindingImpl.access$100((SilentModelBindings.ChoiceModelBindingImpl)this.this$0).setValue(n);
    }

    @Override
    public /* synthetic */ void accept(Object object) {
        this.accept((Integer)object);
    }
}

