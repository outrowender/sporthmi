/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app;

import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.i18n.I18NTarget;
import de.audi.atip.i18n.Language;
import de.audi.tuner.app.LanguageManager$ILanguageChangeListener;
import de.audi.tuner.app.LanguageManager$MyI18N;
import de.audi.tuner.app.TunerBasics;
import de.audi.tuner.app.TunerProxyManager;
import java.text.Collator;

public class LanguageManager {
    final I18NTarget i18NListener = new LanguageManager$MyI18N(this, null);
    private volatile Collator collator = Collator.getInstance();
    private final ChoiceModelApp arabicLanguageActiveChoice;
    private LanguageManager$ILanguageChangeListener[] languageChangeListeners = new LanguageManager$ILanguageChangeListener[0];
    private Language language = null;
    private final Object mutex = new Object();

    public LanguageManager(TunerBasics tunerBasics) {
        this.arabicLanguageActiveChoice = tunerBasics.getModels().getChoiceModel(1636368640);
    }

    public Collator getCollator() {
        return this.collator;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void addLanguageChangedListener(LanguageManager$ILanguageChangeListener languageManager$ILanguageChangeListener) {
        Language language;
        Object object = this.mutex;
        synchronized (object) {
            LanguageManager$ILanguageChangeListener[] languageManager$ILanguageChangeListenerArray = new LanguageManager$ILanguageChangeListener[this.languageChangeListeners.length + 1];
            System.arraycopy((Object)this.languageChangeListeners, 0, (Object)languageManager$ILanguageChangeListenerArray, 0, this.languageChangeListeners.length);
            languageManager$ILanguageChangeListenerArray[this.languageChangeListeners.length] = languageManager$ILanguageChangeListener;
            this.languageChangeListeners = languageManager$ILanguageChangeListenerArray;
            language = this.language;
        }
        if (language != null) {
            languageManager$ILanguageChangeListener.languageChanged(language);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void onI18NSetLanguage(Language language) {
        LanguageManager$ILanguageChangeListener[] languageManager$ILanguageChangeListenerArray;
        this.collator = Collator.getInstance(language.getLocale());
        this.collator.setStrength(0);
        this.arabicLanguageActiveChoice.setValue(language.getLanguageCode() == "ar_SA" ? 1 : 0);
        TunerProxyManager.getInstance().getAmFmTuner().performLanguageChange();
        TunerProxyManager.getInstance().getDABTuner().performLanguageChange();
        TunerProxyManager.getInstance().getUnifiedTuner().performLanguageChange();
        Object object = this.mutex;
        synchronized (object) {
            this.language = language;
            languageManager$ILanguageChangeListenerArray = this.languageChangeListeners;
        }
        for (int i2 = 0; i2 < languageManager$ILanguageChangeListenerArray.length; ++i2) {
            languageManager$ILanguageChangeListenerArray[i2].languageChanged(language);
        }
    }

    static /* synthetic */ void access$100(LanguageManager languageManager, Language language) {
        languageManager.onI18NSetLanguage(language);
    }
}

