/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager;

import de.audi.app.sdsmanager.SDSHMIListener;
import de.audi.app.sdsmanager.SDSManagerBaseActivator;
import de.audi.app.sdsmanager.SDSModelAccess$1;
import de.audi.app.sdsmanager.SDSModelAccess$SDSModelBank;
import de.audi.app.sdsmanager.common.ISDSMapping;
import de.audi.app.sdsmanager.common.Logger;
import de.audi.app.sdsmanager.common.SDSUtils;
import de.audi.app.sdsmanager.testsupport.SDSSettingsEnum;
import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.hmi.IHMIServiceApp;
import de.audi.atip.hmi.model.HMIModel;
import de.audi.atip.hmi.model.list.BaseListModelApp;
import de.audi.atip.hmi.model.sysconst.SysConstModel;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.hmi.modelaccess.HMIModelApp;
import de.audi.atip.interapp.SDSListEntry;
import de.audi.atip.log.LogChannel;

public class SDSModelAccess {
    private static LogChannel lc = Logger.getHMILog();
    private static final int[] mappedButtonModels = new int[]{21, 22, 23};
    private static IHMIServiceApp hmi;
    private final SDSModelAccess$SDSModelBank models;
    private SDSHMIListener hmiListener;
    private static IFrameworkAccess frameworkAccess;

    SDSModelAccess(IFrameworkAccess iFrameworkAccess, SDSHMIListener sDSHMIListener) {
        hmi = iFrameworkAccess.getHmiServiceApp();
        frameworkAccess = iFrameworkAccess;
        this.hmiListener = sDSHMIListener;
        this.models = new SDSModelAccess$SDSModelBank(this);
        hmi.getChoiceModel(335).forceUpdate(true);
        SDSModelAccess.setNLUActiveModelValue(Boolean.getBoolean("enableNLU") && iFrameworkAccess.getSysConst(523) != 0);
        SDSModelAccess.setProgressIconVisible(0);
        SDSModelAccess.setNavVDEMediumState(1);
        SDSSettingsEnum.NLU.registerSDSSettingStateListener(new SDSModelAccess$1(this));
        lc.log(-2137614336, "SDSModelAccess started!");
    }

    void registerModelListeners() {
        hmi.getButtonModel(3984).setButtonListener(this.hmiListener);
        hmi.getButtonModel(3983).setButtonListener(this.hmiListener);
        hmi.getButtonModel(3985).setButtonListener(this.hmiListener);
        hmi.getButtonModel(4139).setButtonListener(this.hmiListener);
        hmi.getButtonModel(4299).setButtonListener(this.hmiListener);
        hmi.getButtonModel(4300).setButtonListener(this.hmiListener);
        hmi.getChoiceModel(3987).setChoiceListener(this.hmiListener);
        hmi.getChoiceModel(3986).setChoiceListener(this.hmiListener);
        hmi.getChoiceModel(3982).setChoiceListener(this.hmiListener);
        hmi.getChoiceModel(337).setChoiceListener(this.hmiListener);
        hmi.getChoiceModel(3981).setChoiceListener(this.hmiListener);
        hmi.getButtonModel(245).setButtonListener(this.hmiListener);
        hmi.getChoiceModel(243).setChoiceListener(this.hmiListener);
        hmi.getChoiceModel(535).setChoiceListener(this.hmiListener);
        hmi.getButtonModel(3993).setButtonListener(this.hmiListener);
        hmi.getButtonModel(3994).setButtonListener(this.hmiListener);
        ISDSMapping iSDSMapping = SDSManagerBaseActivator.getMapping();
        for (int i2 = 0; i2 < mappedButtonModels.length; ++i2) {
            int n = iSDSMapping.getModelID(mappedButtonModels[i2]);
            if (n == -1) {
                lc.log(1078071040, "SDSModelAccess#registerModelListeners: No model mapped to %1 => NOP", (long)mappedButtonModels[i2]);
                return;
            }
            hmi.getButtonModel(n).setButtonListener(this.hmiListener);
        }
    }

    public static void initDialogModels(boolean bl, boolean bl2, boolean bl3, boolean bl4, boolean bl5) {
        SDSModelAccess.setRepeatCommand(bl3 ? 1 : 0);
        SDSModelAccess.setPrompt(bl ? 1 : 0);
        SDSModelAccess.setExpertMode(bl2 ? 1 : 0);
        SDSModelAccess.setCommandScreen(bl4 ? 1 : 0);
        SDSModelAccess.setVoiceBargeIn(bl5 ? 1 : 0);
    }

    SDSModelAccess$SDSModelBank getModels() {
        return this.models;
    }

    HMIModel getModel(int n) {
        return this.models.getModel(n);
    }

    static void fireSettingsEvent(int n, int n2) {
        hmi.getButtonModel(n).fireEvent(n2);
    }

    public static void setSDSDisabledForLanguage(String string, String string2, String[] stringArray) {
        lc.log(-2137614336, "SDSModelAccess#setSDSDisabledForLanguage: sdsLanguage=%1, ttsLanguage=%2, languages=%3", (Object)string, (Object)string2, (Object)SDSUtils.toString(stringArray, false));
        boolean bl = SDSUtils.isSupported(string, stringArray);
        boolean bl2 = SDSUtils.isSupported(string2, stringArray);
        lc.log(-2137614336, "SDSModelAccess#setSDSDisabledForLanguage: sdsSupported=%1, ttsSupported=%2!", bl, bl2);
        ChoiceModelApp choiceModelApp = hmi.getChoiceModel(241);
        if (!bl || !bl2) {
            lc.log(-2137614336, "SDSModelAccess#setSDSDisabledForLanguage: SDS language %1 or TTS language %2 not supported, disabling SDS menu items!", (Object)string, (Object)string2);
            choiceModelApp.setValue(1);
        } else {
            lc.log(-2137614336, "SDSModelAccess#setSDSDisabledForLanguage: SDS language %1 and TTS language %2 supported, enabling SDS menu items!", (Object)string, (Object)string2);
            choiceModelApp.setValue(0);
        }
        lc.log(-2137614336, "SDSModelAccess#setSDSDisabledForLanguage: sdsDisabledForLanguageChoice.value=%1!", (long)choiceModelApp.getValue());
    }

    public static boolean isSDSDisabledForLanguage() {
        return hmi.getChoiceModel(241).getValue() == 1;
    }

    public static int getSDSPageNumber() {
        return hmi.getChoiceModel(550).getValue();
    }

    public static int getSDSReady() {
        return hmi.getChoiceModel(323).getValue();
    }

    public static void setSDSReady(int n) {
        lc.log(-2137614336, "SDSModelAccess#setSDSReady: value=%1", (long)n);
        hmi.getChoiceModel(323).setValue(n);
    }

    public static int getCallsCombinedListID() {
        lc.log(-2137614336, "SDSModelAccess#getCallsCombinedListID: ID=%1", (long)0);
        return 412484608;
    }

    public static int getMsgTemplateListID() {
        lc.log(-2137614336, "SDSModelAccess#getMsgTemplateListID: ID=%1", (long)0);
        return -1248648960;
    }

    public static int getMsgAccountListID() {
        lc.log(-2137614336, "SDSModelAccess#getMsgAccountListID: ID=%1", (long)0);
        return -829218560;
    }

    public static int getADRSDSPopupBaseListID() {
        lc.log(-2137614336, "SDSModelAccess#getADRSDSPopupBaseListID: ID=%1", (long)0);
        return 3867;
    }

    public static BaseListModelApp getADRSDSPopupBaseList() {
        return hmi.getBaseListModel(3867);
    }

    public static BaseListModelApp getADRSDSAddressBaseList() {
        return hmi.getBaseListModel(3856);
    }

    public static BaseListModelApp getSDSNaviPicklistBaseList() {
        return hmi.getBaseListModel(3869);
    }

    public static void setPhoneRedialContentChoice(int n) {
        hmi.getChoiceModel(3927).setValue(n);
    }

    public static int getEnumerationNumberValue() {
        return hmi.getChoiceModel(242).getValue();
    }

    public static int getEnumerationNumberStatus() {
        return hmi.getChoiceModel(242).getStatus();
    }

    public static void setEnumerationNumberValue(int n) {
        hmi.getChoiceModel(242).setValue(n);
    }

    public static void setEnumerationNumberStatus(int n) {
        hmi.getChoiceModel(242).setStatus(n);
    }

    protected static void setCombiSDSSign(int n) {
        lc.log(-2137614336, "setCombiSDSSign: value=%1", (long)n);
        hmi.getChoiceModel(79).setValue(n);
    }

    public static int getSDSStatusValue() {
        return hmi.getChoiceModel(335).getValue();
    }

    public static boolean isCustomerNaviUpdateRunning() {
        return hmi.getChoiceModel(238).getValue() == 1;
    }

    public static void setSDSStatus(int n) {
        lc.log(-2137614336, "SDSModelAccess#setSDSStatus: value=%1", (long)n);
        hmi.getChoiceModel(335).setValue(n);
    }

    public static void setSDSSystemStatus(int n) {
        lc.log(-2137614336, "SDSModelAccess#setSDSSystemStatus: value=%1", (long)n);
        hmi.getChoiceModel(4040).setValue(n);
    }

    public static void setSDSLogicalPopup(int n) {
        lc.log(-2137614336, "SDSModelAccess#setSDSLogicalPopup: value=%1", (long)n);
        hmi.getChoiceModel(4642).setValue(n);
    }

    public static void setSDSAborterType(int n) {
        lc.log(-2137614336, "SDSModelAccess#setSDSAborterType: value=%1", (long)n);
        hmi.getChoiceModel(4275).setValue(n);
    }

    public static int getSDSAborterType() {
        return hmi.getChoiceModel(4275).getValue();
    }

    public static void setSDSNumber(int n) {
        lc.log(-2137614336, "SDSModelAccess#setSDSNumber: value=%1", (long)n);
        hmi.getChoiceModel(310).setValue(n);
    }

    static void setRecognizer(int n) {
        lc.log(-2137614336, "SDSModelAccess#setRecognizer: value=%1", (long)n);
        hmi.getChoiceModel(324).setValue(n);
    }

    public static int getRecognizer() {
        return hmi.getChoiceModel(324).getValue();
    }

    public static void setSDSDisabled(boolean bl) {
        lc.log(-2137614336, "SDSModelAccess#setSDSDisabled: flag=%1", bl);
        hmi.getChoiceModel(4088).setValue(bl ? 1 : 0);
    }

    public static boolean isSDSDisabled() {
        int n = hmi.getChoiceModel(4088).getValue();
        lc.log(-2137614336, "SDSModelAccess#isSDSDisabled: value=%1", (long)n);
        return n == 1;
    }

    public static void setADBCategoryLocationModel(int n) {
        lc.log(-2137614336, "SDSModelAccess#setADBCategoryLocationModel: value=%1", (long)n);
        hmi.getChoiceModel(225).setValue(n);
    }

    public static void setADBCategoryLocationsCountModel(int n, int n2) {
        lc.log(-2137614336, "SDSModelAccess#setADBCategoryLocationsCountModel: privateAdrCount=%1, businessAdrCount=%2", (long)n, (long)n2);
        hmi.getChoiceModel(4069).setValue(n);
        hmi.getChoiceModel(4068).setValue(n2);
    }

    public static int getADBCategoryLocationModel() {
        lc.log(-2137614336, "SDSModelAccess#getADBCategoryLocationModel: called");
        return hmi.getChoiceModel(225).getValue();
    }

    public static void setADBCategoryPhoneCountModel(int n, int n2, int n3, int n4) {
        lc.log(-2137614336, "SDSModelAccess#setADBCategoryPhoneCountModel: privateCount=%1, businessAdrCount=%2", (long)n, (long)n2);
        lc.log(-2137614336, "SDSModelAccess#setADBCategoryPhoneCountModel: mobileCount=%1, landlineCount=%2", (long)n3, (long)n4);
        hmi.getChoiceModel(4069).setValue(n);
        hmi.getChoiceModel(4068).setValue(n2);
        hmi.getChoiceModel(4341).setValue(n3);
        hmi.getChoiceModel(4342).setValue(n4);
    }

    public static void setADBCategoryPhoneModel(int n) {
        lc.log(-2137614336, "SDSModelAccess#setADBCategoryPhoneModel: value=%1", (long)n);
        hmi.getChoiceModel(226).setValue(n);
    }

    public static void setADBSelectedNumberTypeModel(int n) {
        lc.log(-2137614336, "SDSModelAccess#setADBCategoryPhoneModel: value=%1", (long)n);
        hmi.getChoiceModel(4261).setValue(n);
    }

    public static void setMediaXYZAvailableChoice(int n, int n2) {
        lc.log(-2137614336, "SDSModelAccess#setMediaXYZAvailableChoice: modelID=%1, value=%2", (long)n, (long)n2);
        hmi.getChoiceModel(n).setValue(n2);
    }

    public static void setMediaDynamicDeviceType(int n) {
        lc.log(-2137614336, "SDSModelAccess#setMediaDynamicDeviceType: value=%1", (long)n);
        hmi.getChoiceModel(508).setValue(n);
    }

    public static void setPhoneCompleteNumberModel(String string) {
        lc.log(-2137614336, "SDSModelAccess#setPhoneCompleteNumberModel: value=%1", (Object)string);
        hmi.getLabelModel(314).setText(string);
    }

    public static void setPhoneLastSequenceModel(String string) {
        lc.log(-2137614336, "SDSModelAccess#setPhoneLastSequenceModel: value=%1", (Object)string);
        hmi.getLabelModel(315).setText(string);
    }

    public static int getAdrSDSTelNumberListLength() {
        return hmi.getBaseListModel(3857).getLength();
    }

    public static int getAdrSDSMailListLength() {
        return hmi.getBaseListModel(4276).getLength();
    }

    public static int getAdrSDSMailListID() {
        return hmi.getBaseListModel(4276).getID();
    }

    public static void setNaviDestinationTypeModel(int n) {
        lc.log(-2137614336, "SDSModelAccess#setNaviDestinationTypeModel: value=%1", (long)n);
        hmi.getChoiceModel(293).setValue(n);
    }

    public static int getNaviDestinationTypeModel() {
        return hmi.getChoiceModel(293).getValue();
    }

    public static String getNaviMapCodeModel() {
        return hmi.getLabelModel(4327).getText();
    }

    public static void setNaviCurrentCountryLabel(String string) {
        lc.log(-2137614336, "SDSModelAccess#setNaviCurrentCountryLabel: country=%1", (Object)string);
        hmi.getLabelModel(4418).setText(string);
    }

    public static void setNaviMapCodeModel(String string) {
        lc.log(-2137614336, "SDSModelAccess#setNaviMapCodeModel: value=%1", (Object)string);
        hmi.getLabelModel(4327).setText(string);
    }

    public static String getNaviMapCodeLastSequenceModel() {
        return hmi.getLabelModel(4340).getText();
    }

    public static void setNaviMapCodeLastSequenceModel(String string) {
        lc.log(-2137614336, "SDSModelAccess#setNaviMapCodeLastSequenceModel: value=%1", (Object)string);
        hmi.getLabelModel(4340).setText(string);
    }

    public static String getNaviMapCodeAfterStarModel() {
        return hmi.getLabelModel(4339).getText();
    }

    public static void setNaviMapCodeAfterStarModel(String string) {
        lc.log(-2137614336, "SDSModelAccess#setNaviMapCodeAfterStarModel: value=%1", (Object)string);
        hmi.getLabelModel(4339).setText(string);
    }

    public static void setNaviMapCodeDestTypeModel(int n) {
        lc.log(-2137614336, "SDSModelAccess#setNaviMapCodeDestTypeModel: value=%1", (long)n);
        hmi.getChoiceModel(4562).setValue(n);
    }

    public static void setNaviPhoneNumberChoiceModel(int n) {
        lc.log(-2137614336, "SDSModelAccess#setNaviPhoneNumberChoiceModel: value=%1", (long)n);
        hmi.getChoiceModel(4353).setValue(n);
    }

    public static int getNaviPhoneNumberChoiceModel() {
        return hmi.getChoiceModel(4353).getValue();
    }

    public static void setNaviLastPhoneNumberSequenceLabelModel(String string) {
        lc.log(-2137614336, "SDSModelAccess#setNaviLastPhoneNumberSequenceLabelModel: value=%1", (Object)string);
        hmi.getLabelModel(4352).setText(string);
    }

    public static String getNaviLastPhoneNumberSequenceLabelModel() {
        return hmi.getLabelModel(4352).getText();
    }

    public static void setTagModel(int n) {
        lc.log(-2137614336, "SDSModelAccess#setTagModel: value=%1", (long)n);
        hmi.getChoiceModel(336).setValue(n);
    }

    public static int getTagModel() {
        return hmi.getChoiceModel(336).getValue();
    }

    public static void setSlotModel(int n, String string) {
        lc.log(-2137614336, "SDSModelAccess#setSlotModel: value=%1 at slot %2", (Object)string, (long)n);
        switch (n) {
            case 1: {
                hmi.getLabelModel(325).setText(string);
                break;
            }
            case 2: {
                hmi.getLabelModel(327).setText(string);
                break;
            }
            case 3: {
                hmi.getLabelModel(329).setText(string);
                break;
            }
            case 4: {
                hmi.getLabelModel(331).setText(string);
                break;
            }
            case 5: {
                hmi.getLabelModel(333).setText(string);
                break;
            }
            default: {
                lc.log(-1601830656, "SDSModelAccess#setSlotModel: Unhandled slot %1!", (long)n);
            }
        }
    }

    public static String[] getSlotModelStrings() {
        lc.log(-2137614336, "SDSModelAccess#getSlotModelStrings: called");
        String[] stringArray = new String[]{hmi.getLabelModel(325).getText(), hmi.getLabelModel(327).getText(), hmi.getLabelModel(329).getText(), hmi.getLabelModel(331).getText(), hmi.getLabelModel(333).getText()};
        return stringArray;
    }

    public static void setSlotModelStringID(int n, String string) {
        lc.log(-2137614336, "SDSModelAccess#setSlotModelStringID: value=%1 at slot %2", (Object)string, (long)n);
        switch (n) {
            case 1: {
                hmi.getLabelModel(326).setText(string);
                break;
            }
            case 2: {
                hmi.getLabelModel(328).setText(string);
                break;
            }
            case 3: {
                hmi.getLabelModel(330).setText(string);
                break;
            }
            case 4: {
                hmi.getLabelModel(332).setText(string);
                break;
            }
            case 5: {
                hmi.getLabelModel(334).setText(string);
                break;
            }
            default: {
                lc.log(-1601830656, "SDSModelAccess#setSlotModelStringID: Unhandled slot %1!", (long)n);
            }
        }
    }

    public static void setListLineDataGetModel(String string) {
        lc.log(-2137614336, "SDSModelAccess#setListLineDataGetModel: value=%1 ", (Object)string);
        hmi.getLabelModel(253).setText(string);
    }

    public static void setListLineDataGetAdditionalModel(String string) {
        lc.log(-2137614336, "SDSModelAccess#setListLineDataGetAdditionalModel: value=%1 ", (Object)string);
        hmi.getLabelModel(4602).setText(string);
    }

    public static String getListLineDataGetModel() {
        lc.log(-2137614336, "SDSModelAccess#getListLineDataGetModel called");
        return hmi.getLabelModel(253).getText();
    }

    public static String getListLineDataGetAdditionalModel() {
        lc.log(-2137614336, "SDSModelAccess#getListLineDataGetAdditionalModel called");
        return hmi.getLabelModel(4602).getText();
    }

    public static void setNaviHousenrMatchesNewLabelModel(String string) {
        lc.log(-2137614336, "SDSModelAccess#setNaviHousenrMatchesNewLabelModel: value=%1 ", (Object)string);
        hmi.getLabelModel(3950).setText(string);
    }

    public static String getNaviHousenrMatchesNewLabelModel() {
        lc.log(-2137614336, "SDSModelAccess#getNaviHousenrMatchesNewLabelModel called");
        return hmi.getLabelModel(3950).getText();
    }

    public static BaseListModelApp getDisambiguationListModel() {
        lc.log(-2137614336, "SDSModelAccess#getDisambiguationListModel called");
        return hmi.getBaseListModel(3868);
    }

    public static String getSlotModelID(int n) {
        lc.log(-2137614336, "SDSModelAccess#getSlotModelID: slot=%1", (long)n);
        switch (n) {
            case 1: {
                return hmi.getLabelModel(326).getText();
            }
            case 2: {
                return hmi.getLabelModel(328).getText();
            }
            case 3: {
                return hmi.getLabelModel(330).getText();
            }
            case 4: {
                return hmi.getLabelModel(332).getText();
            }
            case 5: {
                return hmi.getLabelModel(334).getText();
            }
        }
        lc.log(-1601830656, "SDSModelAccess#getSlotModelID: Unhandled slot %1!", (long)n);
        return "";
    }

    public static String getADBEntryNameModel() {
        return hmi.getLabelModel(227).getText();
    }

    public static void setADBEntryNameModel(String string) {
        lc.log(-2137614336, "SDSModelAccess#setADBEntryNameModel: text=%1", (Object)string);
        hmi.getLabelModel(227).setText(string);
    }

    public static void setTelSDSNumLabel(String string) {
        lc.log(-2137614336, "SDSModelAccess#setTelSDSNumLabel: text=%1", (Object)string);
        hmi.getLabelModel(4043).setText(string);
    }

    public static String getTelSDSNumLabel() {
        return hmi.getLabelModel(4043).getText();
    }

    public static void setPhoneNumScreenTitle(int n) {
        lc.log(-2137614336, "SDSModelAccess#setPhoneNumScreenTitle: value=%1", (long)n);
        hmi.getChoiceModel(3917).setValue(n);
    }

    public static void setNBestListModel(int n) {
        lc.log(-2137614336, "SDSModelAccess#setNBestListModel: value=%1", (long)n);
        hmi.getChoiceModel(305).setValue(n);
    }

    public static void setNBestListSlotXModel(int n, int n2) {
        lc.log(-2137614336, "SDSModelAccess#setNBestListSlotXModel: value=%1 at slot %2", (long)n, (long)(n2 + 1));
        switch (n2) {
            case 0: {
                hmi.getChoiceModel(306).setValue(n);
                break;
            }
            case 1: {
                hmi.getChoiceModel(307).setValue(n);
                break;
            }
            case 2: {
                hmi.getChoiceModel(308).setValue(n);
                break;
            }
            case 3: {
                hmi.getChoiceModel(309).setValue(n);
                break;
            }
            case 4: {
                hmi.getChoiceModel(4286).setValue(n);
                break;
            }
            default: {
                lc.log(-1601830656, "SDSModelAccess#setNBestListSlotXModel: Illegal slot number %1!", (long)(n2 + 1));
            }
        }
    }

    public static void setTCRPromptModel(String string) {
        hmi.getLabelModel(3990).setText(string);
    }

    public static void setPromptModel(String string) {
        hmi.getLabelModel(322).setText(string);
    }

    public static int getCommandType() {
        return hmi.getChoiceModel(233).getValue();
    }

    public static void setCommandType(int n) {
        lc.log(-2137614336, "SDSModelAccess#setCommandType: value=%1", (long)n);
        hmi.getChoiceModel(233).setValue(n);
    }

    public static int getCommandModeBig() {
        return hmi.getChoiceModel(514).getValue();
    }

    public static void setCommandModeBig(int n) {
        lc.log(-2137614336, "SDSModelAccess#setCommandModeBig: value=%1", (long)n);
        hmi.getChoiceModel(514).setValue(n);
    }

    public static void setCommandModeSmall(int n) {
        lc.log(-2137614336, "SDSModelAccess#setCommandModeSmall: value=%1", (long)n);
        hmi.getChoiceModel(516).setValue(n);
    }

    public static void setSmallCommandDisplayVisible(int n) {
        lc.log(-2137614336, "SDSModelAccess#setSmallCommandDisplayVisible: value=%1", (long)n);
        hmi.getChoiceModel(3929).setValue(n);
    }

    public static int getSmallCommandDisplayVisible() {
        return hmi.getChoiceModel(3929).getValue();
    }

    public static void setCommandModeFurther(int n) {
        lc.log(-2137614336, "SDSModelAccess#setCommandModeFurther: value=%1", (long)n);
        hmi.getChoiceModel(515).setValue(n);
    }

    public static int getPosttrainingShowTextValue() {
        return hmi.getChoiceModel(321).getValue();
    }

    public static void setPosttrainingShowTextValue(int n) {
        lc.log(-2137614336, "SDSModelAccess#setPosttrainingShowTextValue: value=%1", (long)n);
        hmi.getChoiceModel(321).setValue(n);
        hmi.getLabelModel(319).setText(String.valueOf(n + 1));
    }

    public static int getPosttrainingRecogCountValue() {
        return hmi.getChoiceModel(320).getValue();
    }

    public static void setPosttrainingRecordCountValue(int n) {
        lc.log(-2137614336, "SDSModelAccess#setPosttrainingRecordCountValue: value=%1", (long)n);
        hmi.getChoiceModel(320).setValue(n);
    }

    public static void setPosttrainingActiveValue(int n) {
        lc.log(-2137614336, "SDSModelAccess#setPosttrainingActiveValue: value=%1", (long)n);
        hmi.getChoiceModel(318).setValue(n);
    }

    public static int getPosttrainingActiveValue() {
        return hmi.getChoiceModel(318).getValue();
    }

    public static void incrementCounterChoice() {
        int n = hmi.getChoiceModel(236).getValue();
        hmi.getChoiceModel(236).setValue(n + 1);
    }

    public static void resetCounterChoice() {
        hmi.getChoiceModel(236).setValue(0);
    }

    public static int getCounterSecondChoice() {
        return hmi.getChoiceModel(237).getValue();
    }

    public static void incrementCounterSecondChoice() {
        int n = hmi.getChoiceModel(237).getValue();
        hmi.getChoiceModel(237).setValue(n + 1);
    }

    public static void resetCounterSecondChoice() {
        hmi.getChoiceModel(237).setValue(0);
    }

    public static void setHelpMode(int n) {
        lc.log(-2137614336, "SDSModelAccess#setHelpMode: value=%1", (long)n);
        hmi.getChoiceModel(248).setValue(n);
    }

    public static void setContextChoice(int n) {
        lc.log(-2137614336, "SDSModelAccess#setContext: value=%1", (long)n);
        hmi.getChoiceModel(447).setValue(n);
    }

    public static int getContextChoice() {
        return hmi.getChoiceModel(447).getValue();
    }

    public static boolean isPOIOnlineRecogActive() {
        return hmi.getChoiceModel(316).getValue() == 1;
    }

    public static boolean isMsgDictateActive() {
        return hmi.getChoiceModel(268).getValue() > 0;
    }

    public static void setNavInfoForLevel(String string, int n) {
        lc.log(-2137614336, "SDSModelAccess#setNavInfoForLevel: value=%1 level=%2", (Object)string, (long)n);
        switch (n) {
            case 1: {
                hmi.getLabelModel(279).setText(string);
                break;
            }
            case 2: {
                hmi.getLabelModel(286).setText(string);
                break;
            }
            case 3: {
                hmi.getLabelModel(282).setText(string);
                break;
            }
            case 4: {
                hmi.getLabelModel(285).setText(string);
                break;
            }
            default: {
                lc.log(-1601830656, "SDSModelAccess#setNavInfoForLevel: Illegal level %1!", (long)n);
            }
        }
    }

    public static void setNavInfoTime(String string) {
        lc.log(-2137614336, "SDSModelAccess#setNavInfoTime: value=%1", (Object)string);
        hmi.getLabelModel(287).setText(string);
    }

    public static void setNavInfoDistance(int n) {
        lc.log(-2137614336, "SDSModelAccess#setNavInfoDistance: value=%1", (long)n);
        hmi.getChoiceModel(281).setValue(n);
    }

    public static void setNavInfoScaleUnit(int n) {
        lc.log(-2137614336, "SDSModelAccess#setNavInfoScaleUnit: value=%1", (long)n);
        hmi.getChoiceModel(284).setValue(n);
    }

    public static void setNavTrafficInfoScaleUnit(int n) {
        lc.log(-2137614336, "SDSModelAccess#setNavTrafficInfoScaleUnit: value=%1", (long)n);
        hmi.getChoiceModel(4520).setValue(n);
    }

    public static int getNavTrafficInfoScaleUnit() {
        return hmi.getChoiceModel(4520).getValue();
    }

    public static void setNaviScaleUnits(int n) {
        lc.log(-2137614336, "SDSModelAccess#setNaviScaleUnits: value=%1", (long)n);
        hmi.getChoiceModel(4070).setValue(n);
    }

    public static void setNavInfoPOIName(String string) {
        lc.log(-2137614336, "SDSModelAccess#sdsNavInfoPOIName: value=%1", (Object)string);
        hmi.getLabelModel(283).setText(string);
    }

    public static void setNavRouteSavingTimeLabel(String string) {
        lc.log(-2137614336, "SDSModelAccess#setNavRouteSavingTimeLabel: value=%1", (Object)string);
        hmi.getLabelModel(4092).setText(string);
    }

    public static void setNavTrafficDelayTime(String string) {
        lc.log(-2137614336, "SDSModelAccess#setNavTrafficDelayTime: value=%1", (Object)string);
        hmi.getLabelModel(3920).setText(string);
    }

    public static void setNavTrafficDistance(int n) {
        lc.log(-2137614336, "SDSModelAccess#setNavTrafficDistance: value=%1", (long)n);
        hmi.getChoiceModel(3921).setValue(n);
    }

    public static void setNavTrafficEventsOnRoute(int n) {
        lc.log(-2137614336, "SDSModelAccess#setNavTrafficEventsOnRoute: value=%1", (long)n);
        hmi.getChoiceModel(3925).setValue(n);
    }

    public static void setSpeedLimitValue(int n) {
        lc.log(-2137614336, "SDSModelAccess#setSpeedLimitValue: value=%1", (long)n);
        hmi.getChoiceModel(533).setValue(n);
    }

    public static void setSpeedLimitUnit(int n) {
        lc.log(-2137614336, "SDSModelAccess#setSpeedLimitUnit: value=%1", (long)n);
        hmi.getChoiceModel(537).setValue(n);
    }

    public static void setPOIOnlineRecogModel(boolean bl) {
        lc.log(-2137614336, "SDSModelAccess#setPOIOnlineRecogModel: value=%1", bl);
        hmi.getChoiceModel(316).setValue(bl ? 1 : 0);
    }

    public static void setNaviPOIOnlineRecognitionStatus(int n, int n2) {
        if (n >= 0) {
            lc.log(-2137614336, "SDSModelAccess#setNaviPOIOnlineRecognitionStatus: value=%1", (long)n);
            hmi.getChoiceModel(299).setValue(n);
        }
        if (n2 >= 0) {
            lc.log(-2137614336, "SDSModelAccess#setNaviPOIOnlineRecognitionStatus: status=%1", (long)n2);
            hmi.getChoiceModel(299).setStatus(n2);
        }
    }

    public static void setPOIOnlineRecogSize(int n) {
        lc.log(-2137614336, "SDSModelAccess#setPOIOnlineRecogSize: value=%1", (long)n);
        hmi.getChoiceModel(317).setValue(n);
    }

    public static void changeJumpPointAction() {
        ChoiceModelApp choiceModelApp = hmi.getChoiceModel(251);
        int n = choiceModelApp.getValue();
        int n2 = n == 0 ? 1 : 0;
        lc.log(-2137614336, "SDSModelAccess#changeJumpPointAction: oldValue=%1, newValue=%2!", (long)n, (long)n2);
        choiceModelApp.setValue(n2);
    }

    public static void setNavSpellingModel(boolean bl) {
        lc.log(-2137614336, "SDSModelAccess#setNavSpellingModel: value=%1", bl);
        hmi.getChoiceModel(302).setValue(bl ? 1 : 0);
    }

    public static void setNavSpellingCityModel(boolean bl) {
        lc.log(-2137614336, "SDSModelAccess#setNavSpellingCityModel: value=%1", bl);
        hmi.getChoiceModel(291).setValue(bl ? 1 : 0);
    }

    public static void setNavSpellingStreetModel(boolean bl) {
        lc.log(-2137614336, "SDSModelAccess#setNavSpellingStreetModel: value=%1", bl);
        hmi.getChoiceModel(303).setValue(bl ? 1 : 0);
    }

    public static void setNavVDECapabilities(int n) {
        lc.log(-2137614336, "SDSModelAccess#setNavVDECapabilities: value=%1", (long)n);
        hmi.getChoiceModel(304).setValue(n);
    }

    public static void setNavVDEMediumState(int n) {
        lc.log(-2137614336, "SDSModelAccess#setNavVDEMediumState: value=%1", (long)n);
        hmi.getChoiceModel(4461).setValue(n);
    }

    public static int getNaviVDEMediumState() {
        return hmi.getChoiceModel(4461).getValue();
    }

    public static void setNaviTrufflesAvailable(boolean bl) {
        lc.log(-2137614336, "SDSModelAccess#setNaviTrufflesAvailable: value=%1", bl);
        hmi.getChoiceModel(4406).setValue(bl ? 1 : 0);
    }

    public static boolean getNaviTrufflesContextActive() {
        return hmi.getChoiceModel(4409).getValue() != 0;
    }

    public static void setDestinationCountrySystemLanguage(boolean bl) {
        lc.log(-2137614336, "SDSModelAccess#setDestinationCountrySystemLanguage: ldcIsSL=%1", bl);
        int n = bl ? 1 : 0;
        hmi.getChoiceModel(527).setValue(n);
    }

    public static int getDestinationCountrySystemLanguageModel() {
        return hmi.getChoiceModel(527).getValue();
    }

    public static void setDisambiguationLineLabel(String string, int n) {
        switch (n) {
            case 0: {
                lc.log(-2137614336, "SDSModelAccess#setDisambiguationLine%2Label to %1", (Object)string, (long)(n + 1));
                hmi.getLabelModel(520).setText(string);
                return;
            }
            case 1: {
                lc.log(-2137614336, "SDSModelAccess#setDisambiguationLine%2Label to %1", (Object)string, (long)(n + 1));
                hmi.getLabelModel(521).setText(string);
                return;
            }
        }
    }

    public static void setDisambiguationLabel(SDSListEntry[] sDSListEntryArray) {
        if (sDSListEntryArray != null && sDSListEntryArray.length > 1 && sDSListEntryArray[0] != null && sDSListEntryArray[1] != null) {
            lc.log(-2137614336, "SDSModelAccess#setDisambiguationLabels to %1, %2", (Object)sDSListEntryArray[0].getName(), (Object)sDSListEntryArray[1].getName());
            hmi.getLabelModel(520).setText(sDSListEntryArray[0].getName());
            hmi.getLabelModel(521).setText(sDSListEntryArray[1].getName());
        } else {
            lc.log(10000, "SDSModelAccess#setDisambiguationLabels: invalid entries %1", (Object)sDSListEntryArray);
        }
    }

    public static void setDisambiguationLabel(String[] stringArray) {
        if (stringArray != null && stringArray.length > 1) {
            lc.log(-2137614336, "SDSModelAccess#setDisambiguationLabels to %1, %2", (Object)stringArray[0], (Object)stringArray[1]);
            hmi.getLabelModel(520).setText(stringArray[0]);
            hmi.getLabelModel(521).setText(stringArray[1]);
        } else {
            lc.log(10000, "SDSModelAccess#setDisambiguationLabels: invalid entries %1", (Object)stringArray);
        }
    }

    public static void setVDEOneshotPLType(int n) {
        lc.log(-2137614336, "SDSModelAccess#setVDEOneshotPLType: value=%1", (long)n);
        hmi.getChoiceModel(298).setValue(n);
    }

    public static void setFavoritesStatus(int n) {
        lc.log(-2137614336, "SDSModelAccess#setFavoritesStatus: value=%1", (long)n);
        hmi.getChoiceModel(172).setValue(n);
    }

    public static void setMsgDictateModel(int n) {
        lc.log(-2137614336, "SDSModelAccess#setMsgDicateModel: value=%1", (long)n);
        hmi.getChoiceModel(268).setValue(n);
    }

    public static int getMsgDictateModel() {
        return hmi.getChoiceModel(268).getValue();
    }

    public static void setMsgTextStateChoiceModel(int n) {
        lc.log(-2137614336, "SDSModelAccess#setMsgTextStateChoiceModel: value=%1", (long)n);
        hmi.getChoiceModel(4009).setValue(n);
    }

    public static void setMsgSubjectStateChoiceModel(int n) {
        lc.log(-2137614336, "SDSModelAccess#setMsgSubjectStateChoiceModel: value=%1", (long)n);
        hmi.getChoiceModel(4293).setValue(n);
    }

    public static void setMsgTemplatesAvailableModel(int n) {
        lc.log(-2137614336, "SDSModelAccess#setMsgTemplatesAvailableModel: value=%1", (long)n);
        hmi.getChoiceModel(4157).setValue(n);
    }

    public static void setMsgAccountSelectedModel(int n) {
        lc.log(-2137614336, "SDSModelAccess#setMsgAccountSelectedModel: value=%1", (long)n);
        hmi.getChoiceModel(4315).setValue(n);
    }

    public static void setAdbTitlePicklistChoiceModel(int n) {
        lc.log(-2137614336, "SDSModelAccess#setAdbTitlePicklistChoiceModel: value=%1", (long)n);
        hmi.getChoiceModel(4022).setValue(n);
    }

    public static void setMsgTextChangedChoiceModel(int n) {
        lc.log(-2137614336, "SDSModelAccess#setMsgTextChangedChoiceModel: value=%1", (long)n);
        hmi.getChoiceModel(4023).setValue(n);
    }

    public static void setDictationRecognitionStatusChoice(int n) {
        lc.log(-2137614336, "SDSModelAccess#setDictationRecognitionStatusChoice: value=%1", (long)n);
        hmi.getChoiceModel(3884).setValue(n);
    }

    public static void setDictationPromptLabel(String string) {
        lc.log(-2137614336, "SDSModelAccess#setDictationPromptLabel: text=%1", (Object)string);
        hmi.getLabelModel(271).setText(string);
    }

    public static String getDictationPromptLabel() {
        return hmi.getLabelModel(271).getText();
    }

    public static void setMsgReadoutActiveModel(int n) {
        lc.log(-2137614336, "SDSModelAccess#setMsgReadoutActiveModel: value=%1", (long)n);
        hmi.getChoiceModel(276).setValue(n);
    }

    public static int getMsgReadoutActiveModel() {
        return hmi.getChoiceModel(276).getValue();
    }

    public static void setMsgReadoutModel(int n) {
        lc.log(-2137614336, "SDSModelAccess#setMsgReadoutModel: value=%1", (long)n);
        hmi.getChoiceModel(275).setValue(n);
    }

    public static int getMsgReadoutModel() {
        return hmi.getChoiceModel(275).getValue();
    }

    public static void setADBSelectionInterrupt(int n) {
        lc.log(-2137614336, "SDSModelAccess#setADBSelectionInterrupt: value=%1", (long)n);
        hmi.getChoiceModel(228).setValue(n);
    }

    public static boolean isADBSelectionInterrupt() {
        return hmi.getChoiceModel(228).getValue() == 1;
    }

    public static void setADBGrammarAvailableModel(int n) {
        lc.log(-2137614336, "SDSModelAccess#setADBGrammarAvailableModel: value=%1", (long)n);
        hmi.getChoiceModel(229).setValue(n);
    }

    public static void setAllMediaGrammarsAvailable(int n) {
        lc.log(-2137614336, "SDSModelAccess#setAllMediaGrammarsAvailable: value=%1", (long)n);
        hmi.getChoiceModel(262).setValue(n);
        hmi.getChoiceModel(4104).setValue(n);
        hmi.getChoiceModel(4103).setValue(n);
        hmi.getChoiceModel(4102).setValue(n);
    }

    public static void setMediaGrammarAvailableModel(int n) {
        lc.log(-2137614336, "SDSModelAccess#setMediaGrammarAvailableModel: value=%1", (long)n);
        hmi.getChoiceModel(262).setValue(n);
    }

    public static void setMediaTitleGrammarAvailableChoice(int n) {
        lc.log(-2137614336, "SDSModelAccess#setMediaTitleGrammarAvailableChoice: value=%1", (long)n);
        hmi.getChoiceModel(4104).setValue(n);
    }

    public static void setMediaArtistGrammarAvailableChoice(int n) {
        lc.log(-2137614336, "SDSModelAccess#setMediaArtistGrammarAvailableChoice: value=%1", (long)n);
        hmi.getChoiceModel(4103).setValue(n);
    }

    public static void setMediaAlbumGrammarAvailableChoice(int n) {
        lc.log(-2137614336, "SDSModelAccess#setMediaAlbumGrammarAvailableChoice: value=%1", (long)n);
        hmi.getChoiceModel(4102).setValue(n);
    }

    public static void setMediumSyncState(int n) {
        lc.log(-2137614336, "SDSModelAccess#setMediumSyncState: value=%1", (long)n);
        hmi.getChoiceModel(4301).setValue(n);
    }

    public static boolean checkAllMediaSlotGrammarsAvailable() {
        return hmi.getChoiceModel(4102).getValue() == 1 && hmi.getChoiceModel(4103).getValue() == 1 && hmi.getChoiceModel(4104).getValue() == 1;
    }

    public static void setMyAudiGrammarAvailableModel(int n) {
        lc.log(-2137614336, "SDSModelAccess#setMyAudiGrammarAvailableModel: value=%1", (long)n);
        hmi.getChoiceModel(3961).setValue(n);
    }

    public static void setDebugActionProxyLabel(String string) {
        lc.log(-2137614336, "SDSModelAccess#setDebugActionProxyLabel: value=%1", (Object)string);
        hmi.getLabelModel(239).setText(string);
    }

    public static void setDebugTimeoutLabel(String string) {
        lc.log(-2137614336, "SDSModelAccess#setDebugTimeoutLabel: value=%1", (Object)string);
        hmi.getLabelModel(240).setText(string);
    }

    public static void setDetailedMessageLabel(String string) {
        lc.log(-2137614336, "SDSModelAccess#sdsDebugDetailedMessageLabel: value=%1", (Object)string);
        hmi.getLabelModel(3978).setText(string);
    }

    static ChoiceModelApp getSDSPseudoHapticalChoice() {
        return hmi.getChoiceModel(243);
    }

    public static BaseListModelApp getSDSNaviPOIResultList() {
        return hmi.getBaseListModel(3901);
    }

    public static BaseListModelApp getADRSDSTelNumberBaseList() {
        return hmi.getBaseListModel(3857);
    }

    public static BaseListModelApp getSDSNaviResultBaseList() {
        return hmi.getBaseListModel(3871);
    }

    public static BaseListModelApp getSDSNavPOIResultBaseList() {
        return hmi.getBaseListModel(3901);
    }

    public static void setMsgWordPromptLabel(String string) {
        lc.log(-2137614336, "SDSModelAccess#setMsgWordPromptLabel: value=%1", (Object)string);
        hmi.getLabelModel(277).setText(string);
    }

    public static void setOneShotCountryLabel(String string) {
        lc.log(-2137614336, "SDSModelAccess#setOneShotCountryLabel: value=%1", (Object)string);
        hmi.getLabelModel(4250).setText(string);
    }

    public static void setOneShotStateLabel(String string) {
        lc.log(-2137614336, "SDSModelAccess#setOneShotStateLabel: value=%1", (Object)string);
        hmi.getLabelModel(448).setText(string);
    }

    public static void setOneshotCityLabel(String string) {
        lc.log(-2137614336, "SDSModelAccess#setOneShotCityLabel: value=%1", (Object)string);
        hmi.getLabelModel(295).setText(string);
    }

    public static void setOneshotPoiLabel(String string) {
        lc.log(-2137614336, "SDSModelAccess#setOneShotPoiLabel: value=%1", (Object)string);
        hmi.getLabelModel(3936).setText(string);
    }

    public static void setOneshotStreetLabel(String string) {
        lc.log(-2137614336, "SDSModelAccess#setOneshotStreetLabel: value=%1", (Object)string);
        hmi.getLabelModel(297).setText(string);
    }

    public static void setOneshotHouseNRLabel(String string) {
        lc.log(-2137614336, "SDSModelAccess#setOneShotHouseNRLabel: value=%1", (Object)string);
        hmi.getLabelModel(296).setText(string);
    }

    public static void setMsgOnlineLicenceStatusModel(int n) {
        lc.log(-2137614336, "SDSModelAccess#setMsgOnlineLicenceStatusModel: value=%1", (long)n);
        hmi.getChoiceModel(272).setValue(n);
    }

    public static void setDialogJumpingModel(int n) {
        lc.log(-2137614336, "SDSModelAccess#setDialogJumpingModel: value=%1", (long)n);
        hmi.getChoiceModel(497).setValue(n);
    }

    public static int getDialogJumpingModel() {
        return hmi.getChoiceModel(497).getValue();
    }

    public static void setNLUActiveModelValue(boolean bl) {
        int n = bl ? 1 : 0;
        lc.log(-2137614336, "SDSModelAccess#setNLUActiveModel: active=%1, value=%2", bl, (long)n);
        hmi.getChoiceModel(3832).setValue(n);
    }

    public static boolean getNLUActiveModelValue() {
        return hmi.getChoiceModel(3832).getValue() != 0;
    }

    public static void setVBISysConstModelValue(boolean bl) {
        int n = bl ? 1 : 0;
        lc.log(-2137614336, "SDSModelAccess#setVBISysConstModelValue: active=%1, value=%2", bl, (long)n);
        try {
            ((SysConstModel)hmi.getModelApp(4603)).setValue(n);
        }
        catch (Exception exception) {
            lc.log(10000, "SDSModelAccess#setVBISysConstModelValue: Setting value of ICoreSysConfig.SDS_VOICE_BARGE_IN_ACTIVE failed with exception: %1!", (Throwable)exception);
        }
    }

    public static boolean isVoiceBargeInActive() {
        return frameworkAccess.getSysConst(4603) == 1 && hmi.getChoiceModel(337).getValue() == 1;
    }

    public static void setTunerPicklistTitle(int n) {
        lc.log(-2137614336, "SDSModelAccess#setTunerPicklistTitle: listMode=%1", (long)n);
        hmi.getChoiceModel(551).setValue(n);
    }

    public static void setMediaPicklistTitle(int n) {
        lc.log(-2137614336, "SDSModelAccess#setMediaPicklistTitle: value=%1", (long)n);
        ChoiceModelApp choiceModelApp = hmi.getChoiceModel(554);
        choiceModelApp.setValue(n);
    }

    public static void setPhonePicklistTitle(int n) {
        lc.log(-2137614336, "SDSModelAccess#setPhonePicklistTitle: listMode=%1", (long)n);
        hmi.getChoiceModel(3906).setValue(n);
    }

    public static void setNaviPostcodeChoice(int n) {
        ChoiceModelApp choiceModelApp = hmi.getChoiceModel(546);
        choiceModelApp.setValue(n);
    }

    public static void setPhoneCallStackContentModel(int n) {
        lc.log(-2137614336, "SDSModelAccess#setPhoneCallStackContentModel: value=%1", (long)n);
        hmi.getChoiceModel(553).setValue(n);
    }

    public static void setPhoneFavoritesChoice(int n) {
        lc.log(-2137614336, "SDSModelAccess#setPhoneFavoritesChoice: value=%1", (long)n);
        hmi.getChoiceModel(3909).setValue(n);
    }

    public static void setNaviRangeValue(int n, int n2) {
        lc.log(-2137614336, "SDSModelAccess#setNaviRangeValue: value=%1, status=%2", (long)n, (long)n2);
        hmi.getChoiceModel(3958).setValue(n);
        hmi.getChoiceModel(3958).setStatus(n2);
    }

    public static void setNaviRangeScaleUnit(int n) {
        lc.log(-2137614336, "SDSModelAccess#setNaviRangeScaleUnit: value=%1", (long)n);
        hmi.getChoiceModel(3957).setValue(n);
    }

    public static void setVZEAvailableChoice(boolean bl) {
        lc.log(-2137614336, "SDSModelAccess#setVZEAvailableChoice: value=%1", bl);
        hmi.getChoiceModel(4093).setValue(bl ? 1 : 0);
    }

    public static void setNaviGoogleMapAvailableModel(int n) {
        lc.log(-2137614336, "SDSModelAccess#setNaviGoogleMapAvailableModel: value=%1", (long)n);
        hmi.getChoiceModel(3977).setValue(n);
    }

    public static void setExternalSDSPossible(int n) {
        lc.log(-2137614336, "SDSModelAccess#setExternalSDSPossible: value=%1", (long)n);
        hmi.getChoiceModel(3991).setValue(n);
    }

    public static void setExternalSDSStatus(int n) {
        lc.log(-2137614336, "SDSModelAccess#setExternalSDSStatus: value=%1", (long)n);
        hmi.getChoiceModel(3992).setValue(n);
    }

    public static void setProgressIconVisible(int n) {
        lc.log(-2137614336, "SDSModelAccess#setProgressIconVisible: value=%1", (long)n);
        hmi.getChoiceModel(4007).setValue(n);
        hmi.getChoiceModel(4007).setStatus(n);
    }

    static int getPosttrainingSpeedValue() {
        return hmi.getChoiceModel(4013).getValue();
    }

    static void setPosttrainingSpeed(int n) {
        lc.log(-2137614336, "SDSModelAccess#setPosttrainingSpeed: value=%1", (long)n);
        hmi.getChoiceModel(4013).setValue(n);
    }

    static void setRepeatCommand(int n) {
        lc.log(-2137614336, "SDSModelAccess#setRepeatCommand: value=%1", (long)n);
        hmi.getChoiceModel(3987).setValue(n);
    }

    static void setPrompt(int n) {
        lc.log(-2137614336, "SDSModelAccess#setPrompt: value=%1", (long)n);
        hmi.getChoiceModel(3986).setValue(n);
    }

    static void setExpertMode(int n) {
        lc.log(-2137614336, "SDSModelAccess#setExpertMode: value=%1", (long)n);
        hmi.getChoiceModel(3982).setValue(n);
    }

    static void setCommandScreen(int n) {
        lc.log(-2137614336, "SDSModelAccess#setCommandScreen: value=%1", (long)n);
        hmi.getChoiceModel(3981).setValue(n);
    }

    public static void setVoiceBargeIn(int n) {
        lc.log(-2137614336, "SDSModelAccess#setVoiceBargeIn: value=%1", (long)n);
        hmi.getChoiceModel(337).setValue(n);
    }

    public static int getCommandScreen() {
        return hmi.getChoiceModel(3981).getValue();
    }

    public static void ignoreMediaDeviceUpdates(int n) {
        lc.log(-2137614336, "SDSModelAccess#ignoreMediaDeviceUpdates: ignore=%1", (long)n);
        hmi.getChoiceModel(4041).setValue(n);
    }

    public static int getIgnoreMediaDeviceUpdates() {
        lc.log(-2137614336, "SDSModelAccess#getIgnoreMediaDeviceUpdates");
        return hmi.getChoiceModel(4041).getValue();
    }

    public static void setNBestGGContent(int n) {
        lc.log(-2137614336, "SDSModelAccess#setNBestGGContent: value=%1", (long)n);
        hmi.getChoiceModel(4089).setValue(n);
    }

    public static void setMediaPicklistIsPlayMusic(boolean bl) {
        lc.log(-2137614336, "SDSModelAccess#setMediaPicklistIsPlayMusic: value=%1", bl);
        hmi.getChoiceModel(SDSManagerBaseActivator.getMapping().getModelID(20)).setValue(bl ? 1 : 0);
    }

    public static void setMediaPicklistPlayMusicSelectedType(int n) {
        lc.log(-2137614336, "SDSModelAccess#setMediaPlayMusicSelectedTypeChoice: value=%1", (long)n);
        hmi.getChoiceModel(SDSManagerBaseActivator.getMapping().getModelID(24)).setValue(n);
    }

    public static BaseListModelApp getSDSMediaBaseList() {
        return hmi.getBaseListModel(254);
    }

    public static int getExternalSDSAbortButtonID() {
        return hmi.getButtonModel(3993).getID();
    }

    public static int getExternalSDSContinueButtonID() {
        return hmi.getButtonModel(3994).getID();
    }

    public static int getNavPOIOnlineButtonID() {
        return hmi.getButtonModel(4300).getID();
    }

    public static int getSDSSmsDictateButtonID() {
        return hmi.getButtonModel(4139).getID();
    }

    public static int getSDSMailDictateButtonID() {
        return hmi.getButtonModel(4299).getID();
    }

    public static BaseListModelApp getSDSTunerBaseList() {
        return hmi.getBaseListModel(3865);
    }

    public static BaseListModelApp getNavIntellidestSearchBaseList() {
        return hmi.getBaseListModel(SDSManagerBaseActivator.getMapping().getModelID(26));
    }

    public static void setMediaGrammarCompiling(int n) {
        lc.log(-2137614336, "SDSModelAccess#setMediaGrammarCompiling: value=%1", (long)n);
        int n2 = SDSManagerBaseActivator.getMapping().getModelID(28);
        if (n2 != -1) {
            hmi.getChoiceModel(n2).setValue(n);
        }
    }

    public static int getSDSPromptTypeUnchanging() {
        lc.log(-2137614336, "SDSModelAccess#getSDSPromptTypeUnchanging");
        return hmi.getChoiceModel(SDSManagerBaseActivator.getMapping().getModelID(32)).getValue();
    }

    public static boolean isHelpPTTBargeIn() {
        return hmi.getChoiceModel(4644).getValue() == 1;
    }

    public static void resetHelpPTTBargeIn() {
        hmi.getChoiceModel(4644).setValue(0);
    }

    public static void doHintSubjectTextEditorModel(int n) {
        HMIModelApp hMIModelApp = hmi.getModelApp(-1349312256);
        hMIModelApp.addHint(n);
        hMIModelApp.publishHints();
    }

    public static void doHintBodyTextEditorModel(int n) {
        HMIModelApp hMIModelApp = hmi.getModelApp(-1198317312);
        hMIModelApp.addHint(n);
        hMIModelApp.publishHints();
    }

    static /* synthetic */ SDSHMIListener access$000(SDSModelAccess sDSModelAccess) {
        return sDSModelAccess.hmiListener;
    }

    static /* synthetic */ LogChannel access$100() {
        return lc;
    }
}

