/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.utils.reactive.properties;

import de.audi.atip.utils.reactive.properties.NotifyOnAddPreference$PersistenceStrategy;
import de.audi.atip.utils.reactive.properties.StorageAccessPreferencesFactory;

class StorageAccessPreferencesFactory$3
implements NotifyOnAddPreference$PersistenceStrategy {
    private final /* synthetic */ int val$namespace;
    private final /* synthetic */ int val$key;
    private final /* synthetic */ int val$defaultValue;
    private final /* synthetic */ StorageAccessPreferencesFactory this$0;

    StorageAccessPreferencesFactory$3(StorageAccessPreferencesFactory storageAccessPreferencesFactory, int n, int n2, int n3) {
        this.this$0 = storageAccessPreferencesFactory;
        this.val$namespace = n;
        this.val$key = n2;
        this.val$defaultValue = n3;
    }

    public void accept(Integer n) {
        StorageAccessPreferencesFactory.access$000(this.this$0).setInt(this.val$namespace, this.val$key, n);
    }

    @Override
    public Integer read() {
        return new Integer(StorageAccessPreferencesFactory.access$000(this.this$0).getInt(this.val$namespace, this.val$key, this.val$defaultValue));
    }

    @Override
    public /* synthetic */ Object read() {
        return this.read();
    }

    @Override
    public /* synthetic */ void accept(Object object) {
        this.accept((Integer)object);
    }
}

