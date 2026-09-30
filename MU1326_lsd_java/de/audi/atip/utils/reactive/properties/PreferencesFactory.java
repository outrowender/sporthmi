/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.utils.reactive.properties;

import de.audi.atip.util.AbstractEnum;
import de.audi.atip.utils.reactive.properties.NotifyOnAddPreference;
import de.audi.atip.utils.reactive.properties.Preference;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public interface PreferencesFactory {
    public Preference<Boolean> createBooleanPreference(String var1, int var2, int var3, boolean var4);

    public Preference<String> createStringPreference(String var1, int var2, int var3, String var4);

    public Preference<Integer> createIntPreference(String var1, int var2, int var3, int var4);

    public <T extends AbstractEnum> Preference<T> createEnumPreference(String var1, int var2, int var3, T var4);

    public <T> Preference<T> createPreference(String var1, NotifyOnAddPreference.PersistenceStrategy<T> var2, T var3);
}

