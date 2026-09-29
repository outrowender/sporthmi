/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets;

import de.audi.atip.i18n.Language;
import de.esolutions.hmi.widgets.audi.evo.widgets.TouchCharSetAndTTSHandler$CharsetListener;
import de.esolutions.hmi.widgets.audi.evo.widgets.TouchCharSetAndTTSHandler$UserCharsetMode;
import java.util.ArrayList;
import java.util.List;

class TouchCharSetAndTTSHandler$StaticUserCharsetMode
implements TouchCharSetAndTTSHandler$UserCharsetMode {
    private static final TouchCharSetAndTTSHandler$UserCharsetMode INSTANCE = new TouchCharSetAndTTSHandler$StaticUserCharsetMode();
    private static int userCharsetMode = -1;
    private static Language userCharsetModeLanguage = null;
    private List eventListeners = new ArrayList();

    private TouchCharSetAndTTSHandler$StaticUserCharsetMode() {
    }

    @Override
    public int getCharset() {
        return userCharsetMode;
    }

    @Override
    public void setCharset(int n) {
        boolean bl = n != userCharsetMode;
        userCharsetMode = n;
        for (int i2 = 0; bl && i2 < this.eventListeners.size(); ++i2) {
            ((TouchCharSetAndTTSHandler$CharsetListener)this.eventListeners.get(i2)).userCharsetChanged(n);
        }
    }

    @Override
    public Language getStoredSystemLanguage() {
        return userCharsetModeLanguage;
    }

    @Override
    public void setStoredSystemLanguage(Language language) {
        userCharsetModeLanguage = language;
    }

    @Override
    public void addCharsetListener(TouchCharSetAndTTSHandler$CharsetListener touchCharSetAndTTSHandler$CharsetListener) {
        this.eventListeners.add(touchCharSetAndTTSHandler$CharsetListener);
    }

    @Override
    public void removeCharsetListener(TouchCharSetAndTTSHandler$CharsetListener touchCharSetAndTTSHandler$CharsetListener) {
        this.eventListeners.remove(touchCharSetAndTTSHandler$CharsetListener);
    }

    static /* synthetic */ TouchCharSetAndTTSHandler$UserCharsetMode access$000() {
        return INSTANCE;
    }
}

