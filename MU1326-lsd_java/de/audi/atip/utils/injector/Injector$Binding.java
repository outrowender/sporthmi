/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.audi.atip.utils.Preconditions
 *  de.audi.atip.utils.injector.Injector
 */
package de.audi.atip.utils.injector;

import de.audi.atip.utils.Preconditions;
import de.audi.atip.utils.injector.Injector;
import de.audi.atip.utils.injector.Injector$IProvider;
import de.esolutions.fw.util.commons.Buffer;

public class Injector$Binding {
    private Class clazz;
    private Class boundToClazz;
    private boolean isSingleton;
    private Object instance = null;
    private Injector$IProvider provider = null;
    private Object scope = Injector.DEFAULT_SCOPE;

    public Injector$Binding bind(Class clazz) {
        this.clazz = clazz;
        this.boundToClazz = clazz;
        return this;
    }

    public Injector$Binding to(Class clazz) {
        this.boundToClazz = clazz;
        return this;
    }

    public Injector$Binding toProvider(Injector$IProvider iProvider) {
        this.provider = iProvider;
        return this;
    }

    public void asSingleton() {
        this.isSingleton = true;
    }

    public void toInstance(Object object) {
        this.instance = Preconditions.checkNotNull((Object)object);
    }

    public Injector$Binding forScope(Object object) {
        this.scope = object;
        return this;
    }

    public String toString() {
        Buffer buffer = new Buffer();
        buffer.append("Binding [clazz=");
        buffer.append(this.clazz);
        buffer.append(", boundToClazz=");
        buffer.append(this.boundToClazz);
        buffer.append(", isSingleton=");
        buffer.append(this.isSingleton);
        buffer.append(", instance=");
        buffer.append(this.instance);
        buffer.append(", provider=");
        buffer.append(this.provider);
        buffer.append(", scope=");
        buffer.append(this.scope);
        buffer.append("]");
        return buffer.toString();
    }

    static /* synthetic */ Object access$000(Injector$Binding injector$Binding) {
        return injector$Binding.instance;
    }

    static /* synthetic */ boolean access$100(Injector$Binding injector$Binding) {
        return injector$Binding.isSingleton;
    }

    static /* synthetic */ Class access$300(Injector$Binding injector$Binding) {
        return injector$Binding.clazz;
    }

    static /* synthetic */ Class access$400(Injector$Binding injector$Binding) {
        return injector$Binding.boundToClazz;
    }

    static /* synthetic */ Object access$500(Injector$Binding injector$Binding) {
        return injector$Binding.scope;
    }

    static /* synthetic */ Injector$IProvider access$600(Injector$Binding injector$Binding) {
        return injector$Binding.provider;
    }
}

