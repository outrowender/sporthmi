/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.utils.reactive.properties;

import de.audi.atip.utils.Preconditions;
import de.audi.atip.utils.generics.Consumer;
import de.audi.atip.utils.reactive.properties.AcceptHook;
import de.audi.atip.utils.reactive.properties.NotifyOnAddProperty;
import de.audi.atip.utils.reactive.properties.Preference;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class NotifyOnAddPreference<T>
extends NotifyOnAddProperty<T>
implements Preference<T> {
    private final T defaultValue;

    public static <T> NotifyOnAddPreference<T> createAndInit(String string, T t, PersistenceStrategy<T> persistenceStrategy, AcceptHook<? super T> acceptHook) {
        T t2 = persistenceStrategy.read();
        NotifyOnAddPreference<T> notifyOnAddPreference = new NotifyOnAddPreference<T>(string, t, acceptHook, t2);
        notifyOnAddPreference.observeNonSticky().distinctUntilChanged().subscribe(persistenceStrategy);
        return notifyOnAddPreference;
    }

    protected NotifyOnAddPreference(String string, T t, AcceptHook<? super T> acceptHook, T t2) {
        super(string, acceptHook);
        this.defaultValue = Preconditions.checkNotNull(t);
        this.data = t2;
    }

    @Override
    public final void store(T t) {
        this.accept(t);
    }

    @Override
    public final void reset() {
        this.accept(this.defaultValue);
    }

    /*
     * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
     */
    public static interface PersistenceStrategy<T>
    extends Consumer<T> {
        public T read();
    }
}

