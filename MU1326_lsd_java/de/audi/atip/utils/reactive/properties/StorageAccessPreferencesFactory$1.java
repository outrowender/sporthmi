/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.utils.reactive.properties;

import de.audi.atip.utils.reactive.properties.NotifyOnAddPreference$PersistenceStrategy;
import de.audi.atip.utils.reactive.properties.StorageAccessPreferencesFactory;

class StorageAccessPreferencesFactory$1
implements NotifyOnAddPreference$PersistenceStrategy {
    private final /* synthetic */ int val$namespace;
    private final /* synthetic */ int val$key;
    private final /* synthetic */ boolean val$defaultValue;
    private final /* synthetic */ StorageAccessPreferencesFactory this$0;

    StorageAccessPreferencesFactory$1(StorageAccessPreferencesFactory storageAccessPreferencesFactory, int n, int n2, boolean bl) {
        this.this$0 = storageAccessPreferencesFactory;
        this.val$namespace = n;
        this.val$key = n2;
        this.val$defaultValue = bl;
    }

    public void accept(Boolean bl) {
        StorageAccessPreferencesFactory.access$000(this.this$0).setBoolean(this.val$namespace, this.val$key, bl);
    }

    @Override
    public Boolean read() {
        return new Boolean(StorageAccessPreferencesFactory.access$000(this.this$0).getBoolean(this.val$namespace, this.val$key, this.val$defaultValue));
    }

    @Override
    public /* synthetic */ Object read() {
        return this.read();
    }

    @Override
    public /* synthetic */ void accept(Object object) {
        this.accept((Boolean)object);
    }
}

