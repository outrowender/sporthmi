/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.utils.reactive.properties;

import de.audi.atip.log.LogChannel;
import de.audi.atip.storage.IStorageAccess;
import de.audi.atip.util.AbstractEnum;
import de.audi.atip.utils.Preconditions;
import de.audi.atip.utils.generics.GIterator;
import de.audi.atip.utils.generics.GList;
import de.audi.atip.utils.generics.Generics;
import de.audi.atip.utils.reactive.Disposable;
import de.audi.atip.utils.reactive.properties.AcceptHook;
import de.audi.atip.utils.reactive.properties.LoggingPropertyFactory;
import de.audi.atip.utils.reactive.properties.NotifyOnAddPreference;
import de.audi.atip.utils.reactive.properties.Preference;
import de.audi.atip.utils.reactive.properties.PreferencesFactory;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class StorageAccessPreferencesFactory
implements PreferencesFactory,
Disposable {
    private final IStorageAccess storageAccess;
    private final AcceptHook<Object> hook;
    private final GList<Disposable> disposables = Generics.newArrayList();

    public static StorageAccessPreferencesFactory create(LogChannel logChannel, IStorageAccess iStorageAccess) {
        return new StorageAccessPreferencesFactory(iStorageAccess, LoggingPropertyFactory.createDefaultLoggingHook(logChannel, 1000000));
    }

    protected StorageAccessPreferencesFactory(IStorageAccess iStorageAccess, AcceptHook<Object> acceptHook) {
        this.storageAccess = Preconditions.checkNotNull(iStorageAccess);
        this.hook = Preconditions.checkNotNull(acceptHook);
    }

    @Override
    public Preference<Boolean> createBooleanPreference(String string, final int n, final int n2, final boolean bl) {
        NotifyOnAddPreference<Object> notifyOnAddPreference = NotifyOnAddPreference.createAndInit(string, new Boolean(bl), new NotifyOnAddPreference.PersistenceStrategy<Boolean>(){

            @Override
            public void accept(Boolean bl2) {
                StorageAccessPreferencesFactory.this.storageAccess.setBoolean(n, n2, bl2);
            }

            @Override
            public Boolean read() {
                return new Boolean(StorageAccessPreferencesFactory.this.storageAccess.getBoolean(n, n2, bl));
            }

            @Override
            public /* synthetic */ Object read() {
                return this.read();
            }

            @Override
            public /* synthetic */ void accept(Object object) {
                this.accept((Boolean)object);
            }
        }, this.hook);
        this.disposables.add(notifyOnAddPreference);
        return notifyOnAddPreference;
    }

    @Override
    public Preference<String> createStringPreference(String string, final int n, final int n2, final String string2) {
        NotifyOnAddPreference<Object> notifyOnAddPreference = NotifyOnAddPreference.createAndInit(string, string2, new NotifyOnAddPreference.PersistenceStrategy<String>(){

            @Override
            public void accept(String string) {
                StorageAccessPreferencesFactory.this.storageAccess.setString(n, n2, string);
            }

            @Override
            public String read() {
                return StorageAccessPreferencesFactory.this.storageAccess.getString(n, n2, string2);
            }

            @Override
            public /* synthetic */ Object read() {
                return this.read();
            }

            @Override
            public /* synthetic */ void accept(Object object) {
                this.accept((String)object);
            }
        }, this.hook);
        this.disposables.add(notifyOnAddPreference);
        return notifyOnAddPreference;
    }

    @Override
    public Preference<Integer> createIntPreference(String string, final int n, final int n2, final int n3) {
        NotifyOnAddPreference<Object> notifyOnAddPreference = NotifyOnAddPreference.createAndInit(string, new Integer(n3), new NotifyOnAddPreference.PersistenceStrategy<Integer>(){

            @Override
            public void accept(Integer n4) {
                StorageAccessPreferencesFactory.this.storageAccess.setInt(n, n2, n4);
            }

            @Override
            public Integer read() {
                return new Integer(StorageAccessPreferencesFactory.this.storageAccess.getInt(n, n2, n3));
            }

            @Override
            public /* synthetic */ Object read() {
                return this.read();
            }

            @Override
            public /* synthetic */ void accept(Object object) {
                this.accept((Integer)object);
            }
        }, this.hook);
        this.disposables.add(notifyOnAddPreference);
        return notifyOnAddPreference;
    }

    @Override
    public <T extends AbstractEnum> Preference<T> createEnumPreference(String string, final int n, final int n2, final T t) {
        NotifyOnAddPreference<Object> notifyOnAddPreference = NotifyOnAddPreference.createAndInit(string, t, new NotifyOnAddPreference.PersistenceStrategy<T>(){

            @Override
            public void accept(T t2) {
                StorageAccessPreferencesFactory.this.storageAccess.setString(n, n2, ((AbstractEnum)t2).toString());
            }

            @Override
            public T read() {
                try {
                    String string = StorageAccessPreferencesFactory.this.storageAccess.getString(n, n2, t.toString());
                    return AbstractEnum.valueOf(t.getClass(), string);
                }
                catch (Exception exception) {
                    throw new RuntimeException(exception);
                }
            }

            @Override
            public /* synthetic */ Object read() {
                return this.read();
            }

            @Override
            public /* synthetic */ void accept(Object object) {
                this.accept((T)((AbstractEnum)object));
            }
        }, this.hook);
        this.disposables.add(notifyOnAddPreference);
        return notifyOnAddPreference;
    }

    @Override
    public <T> Preference<T> createPreference(String string, NotifyOnAddPreference.PersistenceStrategy<T> persistenceStrategy, T t) {
        NotifyOnAddPreference<Object> notifyOnAddPreference = NotifyOnAddPreference.createAndInit(string, t, persistenceStrategy, this.hook);
        this.disposables.add(notifyOnAddPreference);
        return notifyOnAddPreference;
    }

    @Override
    public void dispose() {
        GIterator<Disposable> gIterator = this.disposables.iterator();
        while (gIterator.hasNext()) {
            gIterator.next().dispose();
        }
        this.disposables.clear();
    }
}

