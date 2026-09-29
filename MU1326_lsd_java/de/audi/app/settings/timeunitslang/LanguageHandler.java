/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.settings.timeunitslang;

import de.audi.app.settings.SettingsEnv;
import de.audi.app.settings.timeunitslang.LanguageUIHandler;
import de.audi.atip.i18n.I18NTarget;
import de.audi.atip.i18n.Language;
import de.audi.atip.log.LogChannel;
import de.esolutions.fw.util.commons.ObjMapper;
import org.osgi.framework.ServiceRegistration;

public final class LanguageHandler
implements I18NTarget {
    private ObjMapper dsiLanguageCodeMapping;
    private volatile boolean updateMenuLanguageAlreadyReceived;
    private final SettingsEnv env;
    private final LogChannel lc;
    private ServiceRegistration sregUIHandler = null;
    static /* synthetic */ Class class$de$audi$atip$power$PowerEventListener;

    public LanguageHandler(SettingsEnv settingsEnv) {
        this.env = settingsEnv;
        this.lc = this.env.getFw().getLogChannel("App.Settings.Lang");
        this.init();
    }

    private void init() {
        this.dsiLanguageCodeMapping = new ObjMapper("dsiCarTimeUtisLangIdxToLangCode");
        this.fillDsiLanguageCodeMapping();
        LanguageUIHandler languageUIHandler = new LanguageUIHandler(this.env.getFw());
        this.env.getFw().getLanguageMgr().setLanguageUIHandler(languageUIHandler);
        this.sregUIHandler = this.env.getContext().registerService((class$de$audi$atip$power$PowerEventListener == null ? (class$de$audi$atip$power$PowerEventListener = LanguageHandler.class$("de.audi.atip.power.PowerEventListener")) : class$de$audi$atip$power$PowerEventListener).getName(), (Object)languageUIHandler, null);
    }

    public void deinit() {
        if (this.sregUIHandler != null) {
            this.sregUIHandler.unregister();
            this.sregUIHandler = null;
        }
        this.env.getFw().getLanguageMgr().setLanguageUIHandler(null);
    }

    public int[] getDSIAttributes() {
        return new int[]{11};
    }

    public void updateMenuLanguage(int n) {
        this.lc.log(1078071040, "updateMenuLanguage: '%1'", (long)n);
        if (!this.updateMenuLanguageAlreadyReceived) {
            this.updateMenuLanguageAlreadyReceived = true;
            String string = null;
            try {
                string = (String)this.dsiLanguageCodeMapping.getKey(new Integer(n));
            }
            catch (IndexOutOfBoundsException indexOutOfBoundsException) {
                this.lc.log(1078071040, "updateMenuLanguage: mapping to HMI language (%1) not found", (long)n);
            }
            String string2 = this.env.getFw().getLanguageMgr().getCurrentLanguage("LANG_COMPONENT_HMI").getLanguageCode();
            if (string == null || !string.equals(string2)) {
                this.lc.log(1078071040, "updateMenuLanguage: Combi language (%2) differs from HMI language (%1)", (Object)string2, (long)n);
                this.setDSICarTimeUnitsLanguageLanguage(string2);
            }
        }
    }

    private void setDSICarTimeUnitsLanguageLanguage(String string) {
        int n = 1;
        try {
            n = (Integer)this.dsiLanguageCodeMapping.getValue(string);
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            this.lc.log(10000, "setDSICarTimeUnitsLanguageLanguage(%1): set to default language because of missing mapping.", (Object)string);
        }
        this.lc.log(1078071040, "dsi.setMenuLanguage(%1)", (long)n);
        this.env.getDSIManager().getDSI().setMenuLanguage(n);
    }

    @Override
    public void setLanguage(Language language) {
        this.setDSICarTimeUnitsLanguageLanguage(language.getLanguageCode());
    }

    private void fillDsiLanguageCodeMapping() {
        this.dsiLanguageCodeMapping.add("ar_SA", new Integer(25));
        this.dsiLanguageCodeMapping.add("bs_BA", new Integer(37));
        this.dsiLanguageCodeMapping.add("zh_CN", new Integer(23));
        this.dsiLanguageCodeMapping.add("zh_HK", new Integer(24));
        this.dsiLanguageCodeMapping.add("zh_TW", new Integer(14));
        this.dsiLanguageCodeMapping.add("hr_HR", new Integer(30));
        this.dsiLanguageCodeMapping.add("cs_CZ", new Integer(8));
        this.dsiLanguageCodeMapping.add("da_DK", new Integer(10));
        this.dsiLanguageCodeMapping.add("nl_NL", new Integer(13));
        this.dsiLanguageCodeMapping.add("en_GB", new Integer(1));
        this.dsiLanguageCodeMapping.add("en_US", new Integer(2));
        this.dsiLanguageCodeMapping.add("fi_FI", new Integer(12));
        this.dsiLanguageCodeMapping.add("fr_FR", new Integer(3));
        this.dsiLanguageCodeMapping.add("fr_CA", new Integer(19));
        this.dsiLanguageCodeMapping.add("de_DE", new Integer(0));
        this.dsiLanguageCodeMapping.add("el_GR", new Integer(17));
        this.dsiLanguageCodeMapping.add("it_IT", new Integer(4));
        this.dsiLanguageCodeMapping.add("ja_JP", new Integer(15));
        this.dsiLanguageCodeMapping.add("ko_KR", new Integer(18));
        this.dsiLanguageCodeMapping.add("pl_PL", new Integer(7));
        this.dsiLanguageCodeMapping.add("pt_PT", new Integer(6));
        this.dsiLanguageCodeMapping.add("pt_BR", new Integer(26));
        this.dsiLanguageCodeMapping.add("ro_RO", new Integer(33));
        this.dsiLanguageCodeMapping.add("ru_RU", new Integer(16));
        this.dsiLanguageCodeMapping.add("sr_RS", new Integer(31));
        this.dsiLanguageCodeMapping.add("sk_SK", new Integer(32));
        this.dsiLanguageCodeMapping.add("sl_SI", new Integer(38));
        this.dsiLanguageCodeMapping.add("es_ES", new Integer(5));
        this.dsiLanguageCodeMapping.add("es_MX", new Integer(20));
        this.dsiLanguageCodeMapping.add("sv_SE", new Integer(11));
        this.dsiLanguageCodeMapping.add("tr_TR", new Integer(22));
        this.dsiLanguageCodeMapping.add("no_NO", new Integer(29));
        this.dsiLanguageCodeMapping.add("nb_NO", new Integer(29));
        this.dsiLanguageCodeMapping.add("hu_HU", new Integer(9));
        this.dsiLanguageCodeMapping.add("ms_MY", new Integer(27));
        this.dsiLanguageCodeMapping.add("uk_UA", new Integer(43));
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

