/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.lang;

import de.audi.app.phone.core.lang.ILanguageUpdateListener;

public interface ILanguageUpdateDispatcher {
    default public void init() {
    }

    default public void deinit() {
    }

    default public void addLanguageUpdateListener(ILanguageUpdateListener iLanguageUpdateListener) {
    }

    default public void removeLanguageUpdateListener(ILanguageUpdateListener iLanguageUpdateListener) {
    }
}

