/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.audi.atip.utils.reactive.bindings.SilentModelBindings$LabelModelBindingImpl
 */
package de.audi.atip.utils.reactive.bindings;

import de.audi.atip.utils.generics.Consumer;
import de.audi.atip.utils.reactive.bindings.SilentModelBindings;

class SilentModelBindings$LabelModelBindingImpl$2
implements Consumer {
    private final /* synthetic */ SilentModelBindings.LabelModelBindingImpl this$0;

    SilentModelBindings$LabelModelBindingImpl$2(SilentModelBindings.LabelModelBindingImpl labelModelBindingImpl) {
        this.this$0 = labelModelBindingImpl;
    }

    public void accept(String string) {
        SilentModelBindings.LabelModelBindingImpl.access$200((SilentModelBindings.LabelModelBindingImpl)this.this$0).setText(string);
    }

    @Override
    public /* synthetic */ void accept(Object object) {
        this.accept((String)object);
    }
}

