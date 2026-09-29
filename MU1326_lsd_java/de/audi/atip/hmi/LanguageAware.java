/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi;

import de.audi.atip.hmi.event.LanguageChangedEvent;

public interface LanguageAware {
    default public void languageChanged(LanguageChangedEvent languageChangedEvent) {
    }
}

