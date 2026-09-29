/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.utils.reactive.properties;

import de.audi.atip.utils.reactive.properties.NotifyOnAddPreference$PersistenceStrategy;
import de.audi.atip.utils.reactive.properties.StorageAccessPreferencesFactory;

class StorageAccessPreferencesFactory$2
implements NotifyOnAddPreference$PersistenceStrategy {
    private final /* synthetic */ int val$namespace;
    private final /* synthetic */ int val$key;
    private final /* synthetic */ String val$defaultValue;
    private final /* synthetic */ StorageAccessPreferencesFactory this$0;

    StorageAccessPreferencesFactory$2(StorageAccessPreferencesFactory storageAccessPreferencesFactory, int n, int n2, String string) {
        this.this$0 = storageAccessPreferencesFactory;
        this.val$namespace = n;
        this.val$key = n2;
        this.val$defaultValue = string;
    }

    public void accept(String string) {
        StorageAccessPreferencesFactory.access$000(this.this$0).setString(this.val$namespace, this.val$key, string);
    }

    @Override
    public String read() {
        return StorageAccessPreferencesFactory.access$000(this.this$0).getString(this.val$namespace, this.val$key, this.val$defaultValue);
    }

    @Override
    public /* synthetic */ Object read() {
        return this.read();
    }

    @Override
    public /* synthetic */ void accept(Object object) {
        this.accept((String)object);
    }
}

