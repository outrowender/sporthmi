/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.dictation.language;

import de.audi.app.sdsmanager.dictation.DictationComponentManager;
import de.audi.app.sdsmanager.dictation.component.AbstractDictationComponent;
import de.audi.app.sdsmanager.dictation.dsiadapter.DsiDictationAdapter;
import de.audi.app.sdsmanager.dictation.dsiadapter.DsiDictationAdapterEmptyListener;
import de.audi.app.sdsmanager.dictation.osgi.BundleEnvironment;
import de.audi.app.sdsmanager.dictation.osgi.IServiceRegistry;
import de.audi.app.sdsmanager.dictation.osgi.ServiceProperties;
import de.audi.app.sdsmanager.dictation.util.DictationUtil;
import de.audi.atip.i18n.I18NTarget;
import de.audi.atip.i18n.ILanguageManager;
import de.audi.atip.i18n.Language;
import java.util.Dictionary;

public final class LanguageManager
extends AbstractDictationComponent
implements I18NTarget {
    private volatile String fallBackLanguageCode;
    private volatile boolean dsiAvailable = false;
    static /* synthetic */ Class class$de$audi$atip$i18n$I18NTarget;

    public LanguageManager(BundleEnvironment bundleEnvironment) {
        super(bundleEnvironment, "App.SDS.Dictation");
    }

    public void init(DictationComponentManager dictationComponentManager) {
        super.init(dictationComponentManager);
        this.fallBackLanguageCode = this.getFallBackLanguageCode();
        dictationComponentManager.getDsiDictationAdapter().addListener(new DsiDictationAdapterListener());
    }

    public void connect(IServiceRegistry iServiceRegistry) {
        try {
            super.connect(iServiceRegistry);
            Dictionary dictionary = ServiceProperties.createServiceProperties("SDSManager", 14);
            dictionary.put("LANG_COMPONENT_TYPE", "LANG_COMPONENT_SDS");
            iServiceRegistry.registerService((class$de$audi$atip$i18n$I18NTarget == null ? (class$de$audi$atip$i18n$I18NTarget = LanguageManager.class$("de.audi.atip.i18n.I18NTarget")) : class$de$audi$atip$i18n$I18NTarget).getName(), (Object)this, dictionary);
        }
        catch (Exception exception) {
            this.log.log(10000, "[LanguageManager#connect] An error occurred: ", (Throwable)exception);
        }
    }

    private String getFallBackLanguageCode() {
        int n = this.framework.getSysConst(442);
        String string = "de_DE";
        if (n == 1) {
            string = "en_US";
        }
        return string;
    }

    private void setLanguage() {
        this.log.log(10000000, "[LanguageManager#setLanguage]");
        if (this.dsiAvailable) {
            DsiDictationAdapter dsiDictationAdapter = this.dictationComponentManager.getDsiDictationAdapter();
            ILanguageManager iLanguageManager = this.framework.getLanguageMgr();
            String string = iLanguageManager.getCurrentLanguage("LANG_COMPONENT_SDS").getLanguageCode();
            try {
                dsiDictationAdapter.requestSetLanguage(string);
                dsiDictationAdapter.requestSetFallbackLanguage(this.fallBackLanguageCode);
            }
            catch (Exception exception) {
                DictationUtil.logException(this.log, exception, "[LanguageManager#setLanguage]");
            }
        }
    }

    public void setLanguage(Language language) {
        if (this.log.isInfo()) {
            this.log.log(1000000, "[LanguageManager#setLanguage] language = %1", (Object)String.valueOf(language));
        }
        this.setLanguage();
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    private class DsiDictationAdapterListener
    extends DsiDictationAdapterEmptyListener {
        private DsiDictationAdapterListener() {
        }

        public void updateDsiAvailability(boolean bl) {
            LanguageManager.this.log.log(10000000, "[LanguageManager$DsiDictationAdapterListener#updateDsiAvailability] dsiAvailable = %1", bl);
            LanguageManager.this.dsiAvailable = bl;
            if (bl) {
                LanguageManager.this.setLanguage();
            }
        }
    }
}

