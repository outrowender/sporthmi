/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.common.lang;

import de.audi.app.car.common.lang.ILanguageUpdateListener;

public interface ILanguageUpdateDispatcher {
    public void init();

    public void deinit();

    public void addLanguageUpdateListener(ILanguageUpdateListener var1);

    public void removeLanguageUpdateListener(ILanguageUpdateListener var1);
}

