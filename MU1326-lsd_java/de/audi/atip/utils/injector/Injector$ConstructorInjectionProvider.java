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
import de.audi.atip.utils.injector.Injector$IProvider;

final class Injector$ConstructorInjectionProvider
implements Injector$IProvider {
    private final Injector$Binding binding;

    private Injector$ConstructorInjectionProvider(Injector$Binding injector$Binding) {
        this.binding = injector$Binding;
    }

    @Override
    public Object provide(IInjector iInjector, Object object) {
        try {
            return Injector.access$800((Class)Injector$Binding.access$400(this.binding), (Injector)((Injector)iInjector), (Object)object);
        }
        catch (Exception exception) {
            if (Injector$Binding.access$400(this.binding).equals(Injector$Binding.access$300(this.binding))) {
                throw new Exception(new StringBuffer().append("Cannot provide ").append(Injector$Binding.access$400(this.binding)).toString(), exception);
            }
            throw new Exception(new StringBuffer().append("Cannot provide ").append(Injector$Binding.access$300(this.binding)).append(" bound to ").append(Injector$Binding.access$400(this.binding)).toString(), exception);
        }
    }

    /* synthetic */ Injector$ConstructorInjectionProvider(Injector$Binding injector$Binding, Injector$1 injector$1) {
        this(injector$Binding);
    }
}

