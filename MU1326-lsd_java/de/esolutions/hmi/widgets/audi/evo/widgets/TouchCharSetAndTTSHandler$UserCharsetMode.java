/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets;

import de.audi.atip.i18n.Language;
import de.esolutions.hmi.widgets.audi.evo.widgets.TouchCharSetAndTTSHandler$CharsetListener;

interface TouchCharSetAndTTSHandler$UserCharsetMode {
    default public int getCharset() {
    }

    default public void setCharset(int n) {
    }

    default public Language getStoredSystemLanguage() {
    }

    default public void setStoredSystemLanguage(Language language) {
    }

    default public void addCharsetListener(TouchCharSetAndTTSHandler$CharsetListener touchCharSetAndTTSHandler$CharsetListener) {
    }

    default public void removeCharsetListener(TouchCharSetAndTTSHandler$CharsetListener touchCharSetAndTTSHandler$CharsetListener) {
    }
}

