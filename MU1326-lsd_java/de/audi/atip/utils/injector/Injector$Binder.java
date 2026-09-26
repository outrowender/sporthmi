/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.utils.injector;

import de.audi.atip.utils.injector.Injector$Binding;
import java.util.ArrayList;
import java.util.List;

public class Injector$Binder {
    private final List bindings = new ArrayList();

    public Injector$Binding bind(Class clazz) {
        Injector$Binding injector$Binding = new Injector$Binding().bind(clazz);
        this.bindings.add(injector$Binding);
        return injector$Binding;
    }

    public Injector$Binding forScope(Object object) {
        Injector$Binding injector$Binding = new Injector$Binding().forScope(object);
        this.bindings.add(injector$Binding);
        return injector$Binding;
    }

    List getBindings() {
        return this.bindings;
    }
}

