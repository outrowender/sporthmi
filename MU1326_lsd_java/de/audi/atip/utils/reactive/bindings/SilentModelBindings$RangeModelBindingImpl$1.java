/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.audi.atip.utils.reactive.bindings.SilentModelBindings$RangeModelBindingImpl
 */
package de.audi.atip.utils.reactive.bindings;

import de.audi.atip.utils.generics.Consumer;
import de.audi.atip.utils.reactive.bindings.SilentModelBindings;

class SilentModelBindings$RangeModelBindingImpl$1
implements Consumer {
    private final /* synthetic */ SilentModelBindings.RangeModelBindingImpl this$0;

    SilentModelBindings$RangeModelBindingImpl$1(SilentModelBindings.RangeModelBindingImpl rangeModelBindingImpl) {
        this.this$0 = rangeModelBindingImpl;
    }

    public void accept(Integer n) {
        if (n >= SilentModelBindings.RangeModelBindingImpl.access$300((SilentModelBindings.RangeModelBindingImpl)this.this$0).getMinimum() && n < SilentModelBindings.RangeModelBindingImpl.access$300((SilentModelBindings.RangeModelBindingImpl)this.this$0).getMaximum() && n.intValue() != SilentModelBindings.RangeModelBindingImpl.access$300((SilentModelBindings.RangeModelBindingImpl)this.this$0).getValue()) {
            SilentModelBindings.RangeModelBindingImpl.access$300((SilentModelBindings.RangeModelBindingImpl)this.this$0).setValue(n);
        }
    }

    @Override
    public /* synthetic */ void accept(Object object) {
        this.accept((Integer)object);
    }
}

