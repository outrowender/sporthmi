/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.lang;

import de.audi.atip.activator.AbstractHMIActivator;
import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.diag.IDiagnosisApp;
import de.audi.atip.diag.sw.AbstractSwDiagnosis;
import de.audi.atip.hmi.model.sysconst.SysConstModel;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.i18n.I18NTarget;
import de.audi.atip.i18n.ILanguageManager;
import de.audi.atip.i18n.ILanguageUIHandler;
import de.audi.atip.i18n.Language;
import de.audi.atip.log.LogChannel;
import de.audi.atip.msg.MsgListener;
import de.audi.tghu.lang.LangChangeWatchDog;
import de.esolutions.fw.util.commons.Buffer;
import de.esolutions.fw.util.commons.Converter;
import de.esolutions.fw.util.commons.error.DumpInfoProvider;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Locale;
import java.util.StringTokenizer;

public final class LanguageManager
implements ILanguageManager,
IDiagnosisApp,
DumpInfoProvider,
MsgListener {
    private static final String OFF_LANGUAGE_REPLACEMENT_1 = "XXXXX";
    private static final String OFF_LANGUAGE_REPLACEMENT_2 = "00000";
    private static final int STATE_INIT = 0;
    private static final int STATE_IN_PROGRESS = 1;
    private static final int STATE_CHANG_OK = 2;
    private static final int STATE_CHANGE_FAILED = 3;
    private final LogChannel lc;
    private final IFrameworkAccess fw;
    private ILanguageUIHandler langMngrUI;
    private LangChangeWatchDog langChangeWatchdog;
    private final LangComponent hmi;
    private final LangComponent navi;
    private final LangComponent tts;
    private final LangComponent sds;
    private final Object availableLangsLock = new Object();
    private boolean textDirectionLtr = true;
    private byte[] persistedLanguages = null;

    LanguageManager(IFrameworkAccess iFrameworkAccess) {
        this.fw = iFrameworkAccess;
        this.lc = this.fw.getLogChannel("Fw.Language.Manager");
        this.hmi = new LangComponent();
        this.navi = new LangComponent();
        this.tts = new LangComponent();
        this.sds = new LangComponent();
    }

    private synchronized ILanguageUIHandler getLangMngrUI() {
        return this.langMngrUI;
    }

    public synchronized void setLanguageUIHandler(ILanguageUIHandler iLanguageUIHandler) {
        this.lc.log(10000000, "setLanguageUIHandler: %1", (Object)iLanguageUIHandler);
        if (this.langMngrUI != null) {
            this.langMngrUI.setLanguageManager(null);
            if (this.langChangeWatchdog != null) {
                this.langChangeWatchdog.stop();
                this.langChangeWatchdog = null;
            }
        }
        this.langMngrUI = iLanguageUIHandler;
        if (iLanguageUIHandler != null) {
            iLanguageUIHandler.setLanguageManager(this);
            iLanguageUIHandler.initModels();
            this.langChangeWatchdog = new LangChangeWatchDog(iLanguageUIHandler);
        }
    }

    private LangComponent getLangComponent(String string) {
        if ("LANG_COMPONENT_HMI".equals(string)) {
            return this.hmi;
        }
        if ("LANG_COMPONENT_NAVI".equals(string)) {
            return this.navi;
        }
        if ("LANG_COMPONENT_TTS".equals(string)) {
            return this.tts;
        }
        if ("LANG_COMPONENT_SDS".equals(string)) {
            return this.sds;
        }
        throw new IllegalArgumentException(new StringBuffer().append(string).append(" not supported by LanguageManager!").toString());
    }

    private void initAvailableLanguages(boolean bl) {
        Object object;
        Object object2;
        Object object3;
        byte[] byArray = null;
        if (bl) {
            byArray = this.fw.getStorageMgr().getByteArray(261, 201, null);
        }
        if (!bl || null == byArray) {
            byArray = this.fw.getStorageMgr().getByteArray(52166966, 201, new byte[0]);
        }
        if (this.lc.isDebug()) {
            this.lc.log(10000000, "read VISIBLE_LANGUAGES visibleLangsStorage=%1", (Object)Converter.array2String(byArray));
        }
        String string = System.getProperty("languages.hmi.builtin", this.getDefaultLanguageByRegion().getLanguageCode());
        StringTokenizer stringTokenizer = new StringTokenizer(string, ",");
        int n = stringTokenizer.countTokens();
        Buffer buffer = new Buffer();
        while (stringTokenizer.hasMoreTokens()) {
            buffer.append(stringTokenizer.nextToken());
        }
        if (n > 0) {
            try {
                object3 = this.parseLangs(n, buffer.toString(), null);
            }
            catch (Exception exception) {
                object3 = this.parseLangs(1, this.getDefaultLanguageByRegion().getLanguageCode(), null);
            }
        } else {
            object3 = this.parseLangs(1, this.getDefaultLanguageByRegion().getLanguageCode(), null);
        }
        this.lc.log(10000000, "read builtInHMILanguages=%1", object3);
        if (byArray.length == 0) {
            this.removeArabicLanguage((List)object3);
            object2 = object3;
            this.lc.log(10000, "cannot read VISIBLE_LANGUAGES from storage, use default HMI lang=%1", object2);
        } else {
            object = new byte[byArray.length - 1];
            System.arraycopy((Object)byArray, 1, object, 0, ((byte[])object).length);
            object2 = this.parseLangs(byArray[0], new String((byte[])object), (byte[])object);
            if (object2.isEmpty()) {
                this.removeArabicLanguage((List)object3);
                object2 = object3;
                this.lc.log(10000, "wrong format of VISIBLE_LANGUAGES in storage, use default HMI lang=%1", object2);
            }
            this.lc.log(10000000, "read VISIBLE_LANGUAGES lang=%1", object2);
        }
        object = new ArrayList((Collection)object3);
        object3.retainAll((Collection)object2);
        if (object3.isEmpty()) {
            object3 = object;
            this.lc.log(10000, "intersection of VISIBLE_LANGUAGES in storage and HMI built in langs is empty, use all HMI langs=%1", object);
        }
        this.lc.log(10000000, "intersection of visibleSysLangs and builtInHMILanguages=%1", object3);
        String[] stringArray = (String[])object3.toArray(new String[object3.size()]);
        this.propagateAvailableLanguagesToComponents(stringArray);
    }

    private void removeArabicLanguage(List list) {
        list.remove("ar_SA");
    }

    void propagateAvailableLanguagesToComponents(String[] stringArray) {
        this.updateAvailableLanguages("LANG_COMPONENT_HMI", stringArray);
        this.updateAvailableLanguages("LANG_COMPONENT_SDS", stringArray);
        this.updateAvailableLanguages("LANG_COMPONENT_TTS", stringArray);
        this.updateAvailableLanguages("LANG_COMPONENT_NAVI", stringArray);
    }

    private List parseLangs(int n, String string, byte[] byArray) {
        this.lc.log(10000000, "languages=%1, length=%2", (Object)string, (long)n);
        ArrayList arrayList = new ArrayList();
        if (string == null || n < 1 || n > 32) {
            this.lc.log(10000, "invalid lang data, languages=%1", (Object)string);
            return arrayList;
        }
        for (int i2 = 0; i2 < n; ++i2) {
            int n2;
            String string2 = string.substring(i2 * 6, i2 * 6 + 5);
            try {
                n2 = byArray == null ? Integer.parseInt(string.substring(i2 * 6 + 5, i2 * 6 + 6)) : ((n2 = byArray[i2 * 6 + 5] & 3) == 2 ? 1 : 0);
            }
            catch (Exception exception) {
                n2 = 0;
                this.lc.log(10000, "invalid lang data exp=%1", (Object)string);
            }
            if (this.checkLanguage(string2)) {
                for (int i3 = 0; i3 < I18NTarget.LANGUAGES.length; ++i3) {
                    if (!string2.equals(I18NTarget.LANGUAGES[i3].getLanguageCode())) continue;
                    I18NTarget.LANGUAGES[i3].setVoiceId(n2);
                }
                if ("en_SA".equals(string2)) {
                    string2 = "en_GB";
                    I18NTarget.LANGUAGES[1].setVoiceId(1);
                }
                if ("nb_NO".equals(string2)) {
                    string2 = "no_NO";
                }
            } else {
                this.lc.log(10000, "invalid lang data found, data=%1 --> use builtin fallback language list", (Object)string2);
                return new ArrayList();
            }
            arrayList.add(string2);
        }
        return arrayList;
    }

    private boolean checkLanguage(String string) {
        this.lc.log(10000000, "checkLanguage: langCode=%1", (Object)string);
        if (string == null) {
            return false;
        }
        if (string.length() != 5) {
            return false;
        }
        return string.charAt(2) == '_';
    }

    public void checkAndSetNewLanguage(Language language) {
        this.lc.log(10000000, "checkAndSetNewLanguage: language=%1", (Object)language.getLanguageCode());
        try {
            this.hmi.currentLang = language;
            this.updateHMITextDirection();
            ILanguageUIHandler iLanguageUIHandler = this.getLangMngrUI();
            LangChangeWatchDog langChangeWatchDog = this.langChangeWatchdog;
            if (null != iLanguageUIHandler) {
                iLanguageUIHandler.updateFlag();
                iLanguageUIHandler.updateListSelection();
                this.hmi.notifyListeners();
                iLanguageUIHandler.setWaiting();
                if (langChangeWatchDog != null) {
                    langChangeWatchDog.start();
                }
            } else {
                this.lc.log(10000, "checkAndSetNewLanguage: UI adapter not ready!");
            }
            if (this.checkLanguageAvailability(language)) {
                this.navi.currentLang = language;
                if (Arrays.asList(this.tts.availableLangs).contains(language)) {
                    this.tts.currentLang = language;
                } else {
                    this.tts.currentLang = this.getDefaultLanguageByRegion();
                }
                if (this.sds.availableLangs.length == 0 || Arrays.asList(this.sds.availableLangs).contains(language)) {
                    this.sds.currentLang = language;
                } else {
                    this.lc.log(10000, "new language not available for SDS, switch SDS OFF");
                    this.sds.currentLang = new Language(-1, "", "", "", -1, Locale.US);
                }
            } else {
                this.lc.log(10000, "new language not available for TTS or NAVI");
                this.navi.currentLang = this.getDefaultLanguageByRegion();
                this.tts.currentLang = this.getDefaultLanguageByRegion();
                this.lc.log(10000, "HMI and TTS language are different, switch SDS OFF");
                this.sds.currentLang = new Language(-1, "", "", "", -1, Locale.US);
            }
            this.navi.status = 1;
            this.tts.status = 1;
            this.sds.status = 1;
            this.navi.notifyListeners();
            this.tts.notifyListeners();
            this.sds.notifyListeners();
            this.serializeAndStore();
        }
        catch (Exception exception) {
            this.lc.log(10000, "ERROR: ", (Throwable)exception);
        }
    }

    private boolean checkLanguageAvailability(Language language) {
        if (this.fw.isPorsche()) {
            return Arrays.asList(this.navi.availableLangs).contains(language) && Arrays.asList(this.tts.availableLangs).contains(language);
        }
        return Arrays.asList(this.navi.availableLangs).contains(language);
    }

    protected void addI18NTarget(I18NTarget i18NTarget, String string, String string2) {
        this.getLangComponent(string).addI18NTarget(i18NTarget, string2);
    }

    protected void removeI18NTarget(I18NTarget i18NTarget) {
        this.hmi.i18NTargets.remove(i18NTarget);
        this.hmi.i18NTargetsScreens.remove(i18NTarget);
        this.tts.i18NTargets.remove(i18NTarget);
        this.sds.i18NTargets.remove(i18NTarget);
        this.navi.i18NTargets.remove(i18NTarget);
    }

    public boolean isLangChangeCompleted() {
        boolean bl = !(!this.navi.i18NTargets.isEmpty() && this.navi.status == 1 || !this.tts.i18NTargets.isEmpty() && this.tts.status == 1 || !this.sds.i18NTargets.isEmpty() && this.sds.status == 1);
        return bl;
    }

    public Language[] getAvailableLanguages(String string) {
        this.lc.log(10000000, "getAvailableLanguages: langComponent=%1", (Object)string);
        return this.getLangComponent(string).availableLangs;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void updateAvailableLanguages(String string, String[] stringArray) {
        int n;
        String[] stringArray2 = (String[])stringArray.clone();
        if (this.lc.isDebug()) {
            this.lc.log(10000000, "updateAvailableLanguages: langComponent=%1, availableLang=%2", (Object)string, (Object)Converter.array2String(stringArray2));
        }
        if (string == null || stringArray2 == null) {
            this.lc.log(10000, "langComponent or availableLang is NULL");
            return;
        }
        if (this.fw.isAsia()) {
            block9: for (n = 0; n < stringArray2.length; ++n) {
                if (!stringArray2[n].equals("en_US")) continue;
                int n2 = this.fw.getSysConst(442);
                switch (n2) {
                    case 3: {
                        stringArray2[n] = I18NTarget.LANGUAGES[13].getHmiCode();
                        continue block9;
                    }
                    case 2: {
                        stringArray2[n] = I18NTarget.LANGUAGES[15].getHmiCode();
                        continue block9;
                    }
                    case 4: {
                        stringArray2[n] = I18NTarget.LANGUAGES[17].getHmiCode();
                        continue block9;
                    }
                    case 5: {
                        stringArray2[n] = I18NTarget.LANGUAGES[25].getHmiCode();
                        continue block9;
                    }
                }
            }
        } else if ("LANG_COMPONENT_HMI".equals(string)) {
            for (n = 0; n < stringArray2.length; ++n) {
                if (!stringArray2[n].equals("ar_SA")) continue;
                SysConstModel sysConstModel = (SysConstModel)this.fw.getHmiServiceApp().getModelApp(4306);
                if (sysConstModel == null) break;
                sysConstModel.setValue(1);
                SysConstModel sysConstModel2 = (SysConstModel)this.fw.getHmiServiceApp().getModelApp(4062);
                if (sysConstModel2 != null && this.fw.isEvoStd()) {
                    sysConstModel2.setValue(1);
                }
                break;
            }
        }
        Object object = this.availableLangsLock;
        synchronized (object) {
            LangComponent.access$202(this.getLangComponent(string), this.getLanguagesFromCodes(stringArray2));
        }
    }

    public Language getCurrentLanguage(String string) {
        this.lc.log(10000000, "getCurrentLanguage: langComponent=%1", (Object)string);
        return this.getLangComponent(string).currentLang;
    }

    private void serializeAndStore() {
        try {
            byte[] byArray = new byte[22];
            System.arraycopy((Object)this.hmi.currentLang.getHmiCode().getBytes(), 0, (Object)byArray, 0, 5);
            System.arraycopy((Object)this.navi.currentLang.getHmiCode().getBytes(), 0, (Object)byArray, 6, 5);
            String string = this.sds.currentLang.getHmiCode();
            if ("".equals(string)) {
                string = OFF_LANGUAGE_REPLACEMENT_2;
            }
            System.arraycopy((Object)string.getBytes(), 0, (Object)byArray, 12, 5);
            this.fw.getStorageMgr().setString(29229279, 308, this.hmi.currentLang.getHmiCode());
            this.fw.getStorageMgr().setByteArray(1101, 10, byArray);
            this.persistedLanguages = byArray;
        }
        catch (Exception exception) {
            this.lc.log(10000, "", (Throwable)exception);
        }
    }

    private void initHMILanguage(String string) {
        if (this.checkLanguage(string) && Arrays.asList(this.hmi.availableLangs).contains(this.getLanguageFromCode(string))) {
            this.lc.log(10000000, "set HMI_LANGUAGE to language=%1", (Object)string);
            this.hmi.currentLang = this.getLanguageFromCode(string);
        } else {
            Language language = this.getFallbackLanguage();
            this.lc.log(10000000, "set HMI_LANGUAGE to fallback language=%1", (Object)language);
            this.hmi.currentLang = language;
        }
        this.updateHMITextDirection();
    }

    private void initTTSNavLanguage(String string) {
        if (this.checkLanguage(string) && Arrays.asList(this.hmi.availableLangs).contains(this.getLanguageFromCode(string))) {
            this.lc.log(10000000, "set NAVI/TTS_LANGUAGE to language=%1", (Object)string);
            this.navi.currentLang = this.getLanguageFromCode(string);
            this.tts.currentLang = this.getLanguageFromCode(string);
        } else {
            Language language = this.getFallbackLanguage();
            this.lc.log(10000000, "set NAVI/TTS_LANGUAGE to fallback language=%1", (Object)language);
            this.navi.currentLang = language;
            this.tts.currentLang = language;
        }
    }

    private void initSDSLanguage(String string) {
        if (this.checkLanguage(string) && Arrays.asList(this.hmi.availableLangs).contains(this.getLanguageFromCode(string))) {
            this.lc.log(10000000, "set SDS_LANGUAGE to language=%1", (Object)string);
            this.sds.currentLang = this.getLanguageFromCode(string);
        } else if (OFF_LANGUAGE_REPLACEMENT_1.equals(string) || OFF_LANGUAGE_REPLACEMENT_2.equals(string)) {
            this.lc.log(10000000, "switch SDS_LANGUAGE OFF");
            this.sds.currentLang = new Language(-1, "", "", "", -1, Locale.US);
        } else {
            Language language = this.getFallbackLanguage();
            this.lc.log(10000000, "set SDS_LANGUAGE to fallback language=%1", (Object)language);
            this.sds.currentLang = language;
        }
    }

    private void readAndDeserialize(boolean bl) {
        byte[] byArray = this.fw.getStorageMgr().getByteArray(1101, 10, new byte[0]);
        this.persistedLanguages = byArray;
        if (byArray.length == 22) {
            this.initHMILanguage(new String(byArray, 0, 5));
            this.initTTSNavLanguage(new String(byArray, 6, 5));
            this.initSDSLanguage(new String(byArray, 12, 5));
        } else {
            this.lc.log(10000, "HMI persistence problem, use coding data");
            this.readAndDeserializeFromCoding(bl);
        }
    }

    private void readAndDeserializeFromCoding(boolean bl) {
        byte[] byArray = null;
        if (bl) {
            byArray = this.fw.getStorageMgr().getByteArray(261, 202, null);
        }
        if (!bl || null == byArray) {
            byArray = this.fw.getStorageMgr().getByteArray(52166966, 202, new byte[0]);
        }
        this.lc.log(10000000, "readAndDeserializeFromCoding() data[]=%1", (Object)byArray);
        if (byArray.length == 22) {
            this.initHMILanguage(new String(byArray, 0, 5));
            this.initTTSNavLanguage(new String(byArray, 6, 5));
            this.initSDSLanguage(new String(byArray, 12, 5));
        } else {
            String string = this.getFallbackLanguage().getHmiCode();
            this.lc.log(10000, "readAndDeserializeFromCoding() persistence error, data[]=%1; using fallback %2", (Object)byArray, (Object)string);
            this.initHMILanguage(string);
            this.initTTSNavLanguage(string);
            this.initSDSLanguage(string);
        }
        this.serializeAndStore();
    }

    public void init(boolean bl) {
        this.lc.log(10000000, "init()");
        try {
            this.initAvailableLanguages(bl);
            this.readAndDeserialize(bl);
            this.hmi.notifyListeners();
            this.navi.notifyListeners();
            this.tts.notifyListeners();
            this.sds.notifyListeners();
        }
        catch (Exception exception) {
            this.lc.log(10000, "init() Exception:", (Throwable)exception);
        }
    }

    public void responseSetLanguage(String string, boolean bl) {
        this.lc.log(10000000, "responseSetLanguage: languageComponent=%2, ok=%1", bl, (Object)string);
        int n = bl ? 2 : 3;
        LangComponent langComponent = this.getLangComponent(string);
        if (langComponent == null) {
            this.lc.log(10000, "responseSetLanguage: languageComponent %1 is not valid or null!", (Object)string);
            return;
        }
        langComponent.status = n;
        if (this.isLangChangeCompleted()) {
            ILanguageUIHandler iLanguageUIHandler = this.getLangMngrUI();
            LangChangeWatchDog langChangeWatchDog = this.langChangeWatchdog;
            if (null != iLanguageUIHandler) {
                if (langChangeWatchDog != null) {
                    langChangeWatchDog.stop();
                }
                iLanguageUIHandler.langChangeFinished();
            } else {
                this.lc.log(100000, "responseSetLanguage: UI adapter not ready!");
            }
        }
    }

    public void languageLoadFinished() {
        ILanguageUIHandler iLanguageUIHandler = this.getLangMngrUI();
        if (null != iLanguageUIHandler) {
            iLanguageUIHandler.langChangeFinished();
        } else {
            this.lc.log(10000, "languageLoadFinished: UI adapter not ready!");
        }
    }

    public Language getDefaultLanguageByRegion() {
        Language language;
        try {
            int n = this.fw.getSysConst(442);
            switch (n) {
                case 0: {
                    language = I18NTarget.LANGUAGES[1];
                    break;
                }
                case 1: {
                    language = I18NTarget.LANGUAGES[9];
                    break;
                }
                case 3: {
                    language = I18NTarget.LANGUAGES[12];
                    break;
                }
                case 2: {
                    language = I18NTarget.LANGUAGES[14];
                    break;
                }
                case 4: {
                    language = I18NTarget.LANGUAGES[16];
                    break;
                }
                case 5: {
                    language = I18NTarget.LANGUAGES[24];
                    break;
                }
                default: {
                    language = I18NTarget.LANGUAGES[9];
                    break;
                }
            }
        }
        catch (Exception exception) {
            language = I18NTarget.LANGUAGES[9];
        }
        this.lc.log(10000000, "getDefaultLanguageByRegion: language=%1", (Object)language);
        return language;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public Language getFallbackLanguage() {
        Object object;
        Language language = this.getDefaultLanguageByRegion();
        Language language2 = null;
        try {
            object = this.availableLangsLock;
            synchronized (object) {
                int n;
                Language[] languageArray = this.getAvailableLanguages("LANG_COMPONENT_HMI");
                this.lc.log(10000000, "getFallbackLanguage: check region language available");
                for (n = 0; n < languageArray.length; ++n) {
                    if (!language.equals(languageArray[n])) continue;
                    language2 = language;
                }
                if (null == language2) {
                    this.lc.log(10000000, "getFallbackLanguage: search english dialect");
                    for (n = 0; n < languageArray.length; ++n) {
                        Language language3 = languageArray[n];
                        if (null == language3) {
                            this.lc.log(10000000, "getFallbackLanguage: language %2 is null", (long)n);
                            continue;
                        }
                        if (!language3.getLanguageCode().toLowerCase().startsWith("en_")) continue;
                        language2 = languageArray[n];
                        break;
                    }
                }
                if (null == language2) {
                    this.lc.log(10000000, "getFallbackLanguage: take first language");
                    language2 = languageArray[0];
                }
            }
        }
        catch (Exception exception) {
            this.lc.log(10000, "getFallbackLanguage: error during fallback language selection", (Throwable)exception);
            language2 = null;
        }
        if (null == language2) {
            this.lc.log(1000, "getFallbackLanguage: get fallback language failed! using region %1 as last resort", (Object)language);
            this.fw.getErrorMgr().handleError(null, "get fallback language failed!", 0, 0, 0);
            language2 = language;
            object = this.availableLangsLock;
            synchronized (object) {
                this.propagateAvailableLanguagesToComponents(new String[]{language2.getHmiCode()});
            }
        }
        this.lc.log(10000000, "getFallbackLanguage: language=%1", language2);
        return language2;
    }

    private Language getLanguageFromCode(String string) {
        for (int i2 = 0; i2 < I18NTarget.LANGUAGES.length; ++i2) {
            if (I18NTarget.LANGUAGES[i2].getHmiCode().equals(string)) {
                return I18NTarget.LANGUAGES[i2];
            }
            if (!"no_NO".equals(string) || !I18NTarget.LANGUAGES[i2].getLanguageCode().equals(string)) continue;
            return I18NTarget.LANGUAGES[i2];
        }
        return this.getDefaultLanguageByRegion();
    }

    private Language[] getLanguagesFromCodes(String[] stringArray) {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < stringArray.length; ++i2) {
            arrayList.add(this.getLanguageFromCode(stringArray[i2]));
        }
        Object[] objectArray = (Language[])arrayList.toArray(new Language[arrayList.size()]);
        if (!this.fw.isAsia()) {
            Arrays.sort(objectArray);
        }
        return objectArray;
    }

    public void performAction(int n, Object object) {
    }

    public void startDiagSession() {
    }

    public void stopDiagSession() {
    }

    public void switch2OriginSource(int n, int n2) {
    }

    public void updateDiagnosticValueChanged(int n, long l) {
        this.lc.log(10000000, "updateDiagnosticValueChanged: namespace=%1, key=%2", (long)n, l);
        if (n == 52166966 && l == 202L || n == 1101 && l == 10L) {
            try {
                this.initAvailableLanguages(false);
                this.readAndDeserializeFromCoding(false);
            }
            catch (Exception exception) {
                this.lc.log(10000, "init() Exception:", (Throwable)exception);
            }
            ILanguageUIHandler iLanguageUIHandler = this.getLangMngrUI();
            if (null != iLanguageUIHandler) {
                iLanguageUIHandler.executeLanguageChange(this.getCurrentLanguage("LANG_COMPONENT_HMI"));
            } else {
                this.lc.log(10000, "updateDiagnosticValueChanged: UI adapter not ready!");
            }
            this.languageLoadFinished();
        }
    }

    public void dump(PrintStream printStream, String string) {
        printStream.println(new StringBuffer().append("Persistence: ").append(this.persistedLanguages != null ? new String(this.persistedLanguages) : "not read (yet)!").toString());
        printStream.print(AbstractSwDiagnosis.dumpObject(this));
    }

    public String getName() {
        return "LanguageManager";
    }

    public boolean isLeftToRightOrientation() {
        return this.textDirectionLtr;
    }

    private void updateHMITextDirection() {
        this.textDirectionLtr = this.hmi.currentLang.getTextDirection() == 0;
        ChoiceModelApp choiceModelApp = this.fw.getHmiServiceApp().getChoiceModel(4359);
        if (choiceModelApp != null) {
            choiceModelApp.setValue(this.textDirectionLtr ? 0 : 1);
        }
    }

    public static void main(String[] stringArray) {
        for (int i2 = 0; i2 < I18NTarget.LANGUAGES.length; ++i2) {
            if (I18NTarget.LANGUAGES[i2].getHmiCode().equals(I18NTarget.LANGUAGES[i2].getLanguageCode())) continue;
            System.out.println(new StringBuffer().append(I18NTarget.LANGUAGES[i2].getHmiCode()).append(":").append(I18NTarget.LANGUAGES[i2].getLanguageCode()).toString());
        }
    }

    public void processMsg(int n) {
        switch (n) {
            case 97: {
                this.checkAndSetNewLanguage(this.getDefaultLanguageByRegion());
                break;
            }
        }
    }

    private final class LangComponent {
        private int status = 0;
        private Language[] availableLangs = new Language[0];
        private Language currentLang = LanguageManager.this.getDefaultLanguageByRegion();
        private final List i18NTargets = new LinkedList();
        private final List i18NTargetsScreens = new LinkedList();

        private LangComponent() {
        }

        public synchronized void addI18NTarget(I18NTarget i18NTarget, String string) {
            if (i18NTarget instanceof AbstractHMIActivator) {
                if (!this.i18NTargetsScreens.contains(i18NTarget)) {
                    this.i18NTargetsScreens.add(i18NTarget);
                }
            } else if (!this.i18NTargets.contains(i18NTarget)) {
                this.i18NTargets.add(i18NTarget);
                if ("UPDATE_AFTER_REGISTRATION".equals(string)) {
                    try {
                        i18NTarget.setLanguage(this.currentLang);
                    }
                    catch (Exception exception) {
                        LanguageManager.this.lc.log(10000, "setI18NTargetLanguage, i18NTargetsScreens - Error: %1", (Throwable)exception);
                    }
                    catch (Error error) {
                        LanguageManager.this.lc.log(1000, "setI18NTargetLanguage, i18NTargetsScreens - Critical Error!");
                        error.printStackTrace();
                    }
                }
            }
        }

        public synchronized void notifyListeners() {
            ListIterator listIterator = this.i18NTargetsScreens.listIterator();
            while (listIterator.hasNext()) {
                try {
                    ((I18NTarget)listIterator.next()).setLanguage(this.currentLang);
                }
                catch (Exception exception) {
                    LanguageManager.this.lc.log(10000, "setI18NTargetLanguage, i18NTargetsScreens - Error: %1", (Throwable)exception);
                }
                catch (Error error) {
                    LanguageManager.this.lc.log(1000, "setI18NTargetLanguage, i18NTargetsScreens - Critical Error!");
                    error.printStackTrace();
                }
            }
            listIterator = this.i18NTargets.listIterator();
            while (listIterator.hasNext()) {
                try {
                    ((I18NTarget)listIterator.next()).setLanguage(this.currentLang);
                }
                catch (Exception exception) {
                    LanguageManager.this.lc.log(10000, "setI18NTargetLanguage, i18NTargets - Error: %1", (Throwable)exception);
                }
                catch (Error error) {
                    LanguageManager.this.lc.log(1000, "setI18NTargetLanguage, i18NTargets - Criticial Error!");
                    error.printStackTrace();
                }
            }
        }

        public String toString() {
            return AbstractSwDiagnosis.dumpObject(this);
        }

        static /* synthetic */ Language[] access$202(LangComponent langComponent, Language[] languageArray) {
            langComponent.availableLangs = languageArray;
            return languageArray;
        }
    }
}

