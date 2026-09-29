/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.dictation.language;

import de.audi.app.sdsmanager.dictation.DictationComponentManager;
import de.audi.app.sdsmanager.dictation.component.AbstractDictationComponent;
import de.audi.app.sdsmanager.dictation.dsiadapter.DsiDictationAdapter;
import de.audi.app.sdsmanager.dictation.language.LanguageManager$DsiDictationAdapterListener;
import de.audi.app.sdsmanager.dictation.osgi.BundleEnvironment;
import de.audi.app.sdsmanager.dictation.osgi.IServiceRegistry;
import de.audi.app.sdsmanager.dictation.osgi.ServiceProperties;
import de.audi.app.sdsmanager.dictation.util.DictationUtil;
import de.audi.atip.i18n.I18NTarget;
import de.audi.atip.i18n.ILanguageManager;
import de.audi.atip.i18n.Language;
import de.audi.atip.log.LogChannel;
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

    @Override
    public void init(DictationComponentManager dictationComponentManager) {
        super.init(dictationComponentManager);
        this.fallBackLanguageCode = this.getFallBackLanguageCode();
        dictationComponentManager.getDsiDictationAdapter().addListener(new LanguageManager$DsiDictationAdapterListener(this, null));
    }

    @Override
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
        this.log.log(-2137614336, "[LanguageManager#setLanguage]");
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

    @Override
    public void setLanguage(Language language) {
        if (this.log.isInfo()) {
            this.log.log(1078071040, "[LanguageManager#setLanguage] language = %1", (Object)String.valueOf(language));
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

    static /* synthetic */ LogChannel access$100(LanguageManager languageManager) {
        return languageManager.log;
    }

    static /* synthetic */ boolean access$202(LanguageManager languageManager, boolean bl) {
        languageManager.dsiAvailable = bl;
        return languageManager.dsiAvailable;
    }

    static /* synthetic */ void access$300(LanguageManager languageManager) {
        languageManager.setLanguage();
    }
}

