/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.audi.atip.utils.injector.Injector
 */
package de.audi.atip.utils.injector;

import de.audi.atip.utils.injector.IInjector;
import de.audi.atip.utils.injector.Injector;
import de.audi.atip.utils.injector.Injector$1;
import de.audi.atip.utils.injector.Injector$Binding;
import de.audi.atip.utils.injector.Injector$ConstructorInjectionProvider;
import de.audi.atip.utils.injector.Injector$IFactory;
import de.audi.atip.utils.injector.Injector$IProvider;

final class Injector$SingletonFactory
implements Injector$IFactory {
    private final Injector$IProvider provider;
    private Object object;
    private final /* synthetic */ Injector this$0;

    private Injector$SingletonFactory(Injector injector, Injector$Binding injector$Binding) {
        this.this$0 = injector;
        this.provider = Injector$Binding.access$600(injector$Binding) != null ? Injector$Binding.access$600(injector$Binding) : new Injector$ConstructorInjectionProvider(injector$Binding, null);
    }

    @Override
    public Object get(Class clazz, Object object) {
        if (this.object == null) {
            this.object = this.provider.provide((IInjector)this.this$0, object);
        }
        return this.object;
    }

    /* synthetic */ Injector$SingletonFactory(Injector injector, Injector$Binding injector$Binding, Injector$1 injector$1) {
        this(injector, injector$Binding);
    }
}

