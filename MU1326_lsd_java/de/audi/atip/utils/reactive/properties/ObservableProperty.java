/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.utils.reactive.properties;

import de.audi.atip.utils.reactive.observables.Observable;
import de.audi.atip.utils.reactive.properties.Gettable;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public interface ObservableProperty<T>
extends Observable<T>,
Gettable<T> {
    public Observable<T> observeNonSticky();

    public Observable<T> observe();

    public String getTag();
}

