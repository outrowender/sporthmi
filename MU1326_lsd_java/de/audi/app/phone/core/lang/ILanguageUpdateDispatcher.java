/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.lang;

import de.audi.app.phone.core.lang.ILanguageUpdateListener;

public interface ILanguageUpdateDispatcher {
    public void init();

    public void deinit();

    public void addLanguageUpdateListener(ILanguageUpdateListener var1);

    public void removeLanguageUpdateListener(ILanguageUpdateListener var1);
}

