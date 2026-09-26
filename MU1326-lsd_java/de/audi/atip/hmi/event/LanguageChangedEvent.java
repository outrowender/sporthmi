/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.event;

import de.audi.atip.hmi.event.ATIPEvent;
import de.audi.atip.hmi.event.ATIPEventListener;
import de.audi.atip.i18n.Language;

public class LanguageChangedEvent
extends ATIPEvent {
    Language language;

    public LanguageChangedEvent(Language language, ATIPEventListener[] aTIPEventListenerArray) {
        super(aTIPEventListenerArray, 19001);
        this.language = language;
    }

    public Language getLanguage() {
        return this.language;
    }
}

