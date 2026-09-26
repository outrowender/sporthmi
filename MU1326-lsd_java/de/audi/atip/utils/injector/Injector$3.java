/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.audi.atip.utils.injector.Injector
 */
package de.audi.atip.utils.injector;

import de.audi.atip.utils.injector.Injector;
import de.audi.atip.utils.injector.Injector$Binding;
import de.audi.atip.utils.injector.Injector$IFactory;

class Injector$3
implements Injector$IFactory {
    private final /* synthetic */ Injector$Binding val$binding;
    private final /* synthetic */ Injector this$0;

    Injector$3(Injector injector, Injector$Binding binding) {
        this.this$0 = injector;
        this.val$binding = binding;
    }

    @Override
    public Object get(Class clazz, Object object) {
        return Injector$Binding.access$000(this.val$binding);
    }
}

