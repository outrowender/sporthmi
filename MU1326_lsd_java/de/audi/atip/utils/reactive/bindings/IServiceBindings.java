/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.utils.reactive.bindings;

import de.audi.atip.utils.collections.Predicate;
import de.audi.atip.utils.reactive.observables.Observable;
import org.osgi.framework.ServiceReference;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public interface IServiceBindings {
    public <T> Observable<T> track(Class var1, T var2, Predicate<ServiceReference> var3);

    public <T> Observable<T> track(Class var1, T var2);
}

