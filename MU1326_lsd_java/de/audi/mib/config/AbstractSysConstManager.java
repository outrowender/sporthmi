/*
 * Decompiled with CFR 0.152.
 */
package de.audi.mib.config;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.hmi.model.sysconst.SysConstModel;
import de.audi.atip.hmi.modelaccess.HMIModelApp;
import de.audi.atip.log.LogChannel;
import de.audi.atip.sysapp.carcoding.Adaptation;
import de.audi.atip.sysapp.carcoding.CarFuncAdap;
import de.audi.atip.sysapp.carcoding.Coding;
import de.audi.atip.sysapp.carcoding.ICodingReader;
import de.audi.atip.sysapp.carcoding.ISysConstManager;
import de.audi.atip.sysapp.carcoding.IVariantInfo;
import de.audi.atip.sysapp.carcoding.LoadSpeedThreshold;
import de.audi.atip.sysapp.carcoding.SperrFlags;
import de.audi.mib.config.PopupPrioMapper;
import de.esolutions.fw.util.commons.Buffer;
import de.esolutions.fw.util.commons.SimpleIntIntMap;
import java.lang.reflect.Field;

public abstract class AbstractSysConstManager
implements ISysConstManager {
    protected final IFrameworkAccess fw;
    private ICodingReader codingData;
    protected final LogChannel lc;
    protected PopupPrioMapper prioMapper;
    static /* synthetic */ Class class$de$audi$atip$sysconfig$ICoreSysConfig;

    AbstractSysConstManager(IFrameworkAccess iFrameworkAccess) {
        this.fw = iFrameworkAccess;
        this.lc = iFrameworkAccess.getLogChannel("Fw.Config.Mngr");
    }

    public final int getSysConst(int n) {
        HMIModelApp hMIModelApp = this.fw.getHmiServiceApp().getModelApp(n);
        if (hMIModelApp instanceof SysConstModel) {
            int n2 = ((SysConstModel)hMIModelApp).getValue();
            this.lc.log(10000000, "SysConstManager#getSysConst(%1) = %2", (long)n, (long)n2);
            return n2;
        }
        this.lc.log(10000, "SysConstManager#getSysConst(%1) model not found", (long)n);
        return -1;
    }

    public final boolean getSysConstBool(int n) {
        return this.getSysConst(n) == 1;
    }

    protected final void setSysConst(int n, int n2) {
        this.lc.log(10000000, "SysConstManager#setSysConst(%1, %2)", (long)n, (long)n2);
        HMIModelApp hMIModelApp = this.fw.getHmiServiceApp().getModelApp(n);
        if (hMIModelApp instanceof SysConstModel) {
            ((SysConstModel)hMIModelApp).setValue(n2);
        } else {
            this.lc.log(10000, "SysConstManager#setSysConst(%2, %3) model not found or has wrong type: %1", (Object)hMIModelApp, (long)n, (long)n2);
        }
    }

    protected void setSysConstBool(int n, boolean bl) {
        this.setSysConst(n, bl ? 1 : 0);
    }

    protected final void rangeCheck(int n, String string, int n2, int n3) {
        int n4 = this.getSysConst(n);
        if (n4 >= n2 && n4 <= n3) {
            return;
        }
        this.lc.log(100000, "%1 ( = %2 ) out of range, set to %3", (Object)string, (long)n4, (long)n2);
        this.setSysConst(n, n2);
    }

    public CarFuncAdap getCarFuncAdaptation() {
        return this.codingData.getCarFuncAdaptation();
    }

    public Coding getCarCoding() {
        return this.codingData.getCarCoding();
    }

    public IVariantInfo getVariantInfo() {
        return this.codingData.getVariantInfo();
    }

    public Adaptation getAdaptationANP() {
        return this.codingData.getAdaptationANP();
    }

    public LoadSpeedThreshold getSpeedThresholdUPDL() {
        return this.codingData.getSpeedThresholdUPDL();
    }

    public SperrFlags getSperrFlags() {
        return this.codingData.getSperrFlags();
    }

    private int getMessagingTemplateOnly() {
        return !this.getAdaptationANP().isAllowMessageEditing() ? 1 : 0;
    }

    private void setGEMState() {
        int n = 0;
        if (this.fw.isPBuild() || !Boolean.getBoolean("enableGEM")) {
            n = this.getAdaptationANP().isDeveloperTestModeActivated() ? 0 : 1;
        }
        this.lc.log(10000000, "set GEM: state=%1", (long)n);
        this.fw.getHmiServiceApp().getChoiceModel(112).setValue(n);
    }

    private void applyRegionSettings() {
        int n = this.getSysConst(442);
        if (n == 2 && 0 == this.getSysConst(523)) {
            int n2 = this.getAdaptationANP().getMediaCountryCodeHmi();
            switch (n2) {
                case 19024: {
                    this.setSysConst(442, 3);
                    break;
                }
                case 19282: {
                    this.setSysConst(442, 4);
                    break;
                }
                case 21591: {
                    this.setSysConst(442, 5);
                    break;
                }
            }
        }
        this.setSysConstBool(477, n == 1);
        this.setSysConstBool(4357, n == 1);
        if (n == 3) {
            this.setSysConstBool(4153, this.getAdaptationANP().isOperatorCallAvailable());
            this.setSysConstBool(4323, this.getAdaptationANP().isPayTmcSetTrafficAvailable());
            this.setSysConstBool(4325, this.getAdaptationANP().isPayTmcSetTrafficAvailable());
            this.setSysConstBool(4463, false);
            this.setSysConstBool(4467, true);
            this.setSysConstBool(4465, false);
            this.setSysConstBool(4466, true);
            this.setSysConstBool(4511, true);
            this.setSysConst(4464, 1);
            this.setSysConst(4543, 50);
            this.setSysConst(4544, 38);
            this.setSysConstBool(4499, true);
        } else if (n == 2) {
            this.setSysConstBool(4155, this.getAdaptationANP().isBreakdownCallAvailable());
            this.setSysConstBool(4154, this.getAdaptationANP().isPOICallAvailable());
            this.setSysConstBool(479, false);
            this.setSysConstBool(490, false);
            this.setSysConstBool(4463, false);
            this.setSysConstBool(4467, true);
            this.setSysConstBool(4465, false);
            this.setSysConstBool(4466, true);
            this.setSysConst(4464, 1);
            this.setSysConst(4543, 50);
            this.setSysConst(4544, 38);
            this.setSysConstBool(4499, true);
        } else if (n == 4) {
            this.setSysConstBool(4324, this.getAdaptationANP().isTpegAvailable());
            this.setSysConstBool(479, false);
            this.setSysConstBool(490, false);
            this.setSysConstBool(4499, true);
        } else if (n == 5) {
            this.setSysConstBool(479, false);
            this.setSysConstBool(490, false);
            this.setSysConstBool(4499, true);
        }
        if (n == 1) {
            this.setSysConstBool(549, false);
        }
        if (n == 1) {
            this.setSysConst(4255, 2);
        } else if (this.isAsia()) {
            this.setSysConst(4255, 1);
        }
        this.setSysConst(4306, 0);
        this.setSysConstBool(5622, this.getAdaptationANP().isMobileDeviceKeyProfile());
    }

    private void applyPhoneSettings() {
        if (this.getSysConstBool(462) || this.getSysConstBool(463)) {
            this.setSysConstBool(473, true);
            this.setSysConstBool(470, true);
        } else {
            this.setSysConstBool(4177, false);
        }
    }

    private void applyNaviSettings() {
        int n = this.getAdaptationANP().getNavMapTransmissionMode();
        int n2 = this.getAdaptationANP().getNavKDKTransmissionMode();
        if (this.getSysConstBool(459)) {
            this.setSysConstBool(470, true);
        }
        if (n == 3) {
            this.setSysConst(541, 2);
            this.setSysConstBool(4383, true);
            this.setSysConstBool(4388, true);
        } else if (n == 2) {
            this.setSysConst(541, 1);
            this.setSysConstBool(4383, true);
            this.setSysConstBool(4388, true);
        } else if (n2 == 2) {
            this.setSysConst(541, 1);
            this.setSysConstBool(4383, false);
            this.setSysConstBool(4388, true);
        } else {
            this.setSysConst(541, 0);
            this.setSysConstBool(4383, false);
            this.setSysConstBool(4388, false);
        }
        boolean bl = Boolean.getBoolean("navStreetviewOverviewmap");
        this.setSysConstBool(3877, bl);
        this.setSysConstBool(3866, Boolean.getBoolean("navPreferredGasStations"));
        this.setSysConstBool(556, true);
        this.setSysConstBool(4389, false);
        boolean bl2 = this.getSysConst(532) == 12;
        this.setSysConstBool(4396, bl2);
        this.setSysConstBool(4404, !Boolean.getBoolean("disableScrollByCrosshairs"));
        this.setSysConstBool(4422, false);
        this.setSysConstBool(4368, false);
        this.setSysConstBool(4405, false);
        this.setSysConstBool(4417, false);
        this.setSysConstBool(4416, false);
        this.setSysConst(4434, 1);
        this.setSysConst(4433, 0);
        this.setSysConst(4431, 0);
        this.setSysConst(4436, 0);
        if (this.isAsia()) {
            this.setSysConst(4440, 25);
        } else {
            this.setSysConst(4440, 50);
        }
        this.setSysConstBool(4441, this.isHURegionJP());
        this.setSysConstBool(4462, false);
        this.setSysConst(4445, 0);
        this.setSysConstBool(4410, 0 == this.getSysConst(442) || 1 == this.getSysConst(442));
        if (this.isHighTrafficMarket()) {
            this.setSysConst(4537, 16);
        } else {
            this.setSysConst(4537, 7);
        }
        this.setSysConstBool(4456, !this.isAsia());
        this.setSysConstBool(4474, !this.isHURegionKR());
        this.setSysConstBool(4479, this.isAsia());
        this.setSysConstBool(4477, this.getSysConst(442) == 0 && this.getSysConst(532) != 12);
        this.setSysConstBool(4499, false);
        this.setSysConst(4548, 1);
        if (this.isAsia()) {
            this.setSysConst(4575, 1);
        } else {
            this.setSysConst(4575, 0);
        }
        this.setSysConst(5545, 0);
        this.setSysConstBool(5581, false);
        this.setSysConstBool(5616, true);
    }

    private boolean isHighTrafficMarket() {
        return this.isHURegionNAR();
    }

    private void applyOverrides(SimpleIntIntMap simpleIntIntMap) {
        int[] nArray = simpleIntIntMap.getKeys();
        for (int i2 = 0; i2 < nArray.length; ++i2) {
            this.setSysConst(nArray[i2], simpleIntIntMap.get(nArray[i2]));
        }
        if (this.getSysConst(442) == 0 && "RW".equals(this.codingData.getVariantInfo().getRegion())) {
            this.setSysConst(442, 6);
        }
        if (null == System.getProperty("useWordPrediction")) {
            this.setSysConstBool(4518, this.isAsia());
        } else {
            this.setSysConstBool(4518, Boolean.getBoolean("useWordPrediction"));
        }
    }

    public final void initSysConstants(SimpleIntIntMap simpleIntIntMap, ICodingReader iCodingReader) {
        this.codingData = iCodingReader;
        this.initVariant();
        this.readCarCodingOptions();
        this.applyOverrides(simpleIntIntMap);
        this.applyPhoneSettings();
        this.applyNaviSettings();
        this.applyRegionSettings();
        this.setGEMState();
        this.applyInvariantSettings();
        this.rangeCheckVariant();
    }

    public int getHMIInternalPopupPrio(int n, int n2) {
        if (this.prioMapper == null) {
            this.prioMapper = this.createPopupPrioMapper();
        }
        return this.prioMapper.getHMIInternalPopupPrio(n, n2);
    }

    private void readCarCodingOptions() {
        Coding coding = this.getCarCoding();
        this.setSysConstBool(3919, this.codingData.getVariantInfo().isMMIRadio());
        this.setSysConst(523, this.fw.isEvoStd() || this.fw.isPorscheStd() ? 0 : 1);
        this.setSysConst(522, this.fw.getScreenRes());
        this.setSysConst(464, coding.getDriverSide());
        this.setSysConstBool(460, coding.isVoiceControlSystemActive());
        this.setSysConstBool(459, coding.isNavigationActive());
        this.setSysConstBool(465, coding.isTrafficSignDisplayActive());
        this.setSysConst(4168, coding.getCarBrand());
        this.setSysConst(466, coding.getCarClass());
        this.setSysConst(469, coding.getCarGeneration());
        this.setSysConst(467, coding.getCarDerivate());
        this.setSysConst(468, coding.getCarDerivateSupplement());
        this.setSysConst(532, coding.getCountry());
        this.setSysConstBool(3834, this.getAdaptationANP().isAdvancedRangeDisplayAvailable());
        this.setSysConst(471, coding.getKombiTrackStationInfo());
        this.setSysConstBool(474, this.getAdaptationANP().isRemoteHmiAvailable());
        this.setSysConstBool(475, this.getAdaptationANP().isOnlinePoiVoiceAvailable());
        this.setSysConstBool(549, this.getAdaptationANP().isOnlineDictationAvailable());
        this.setSysConstBool(486, this.getAdaptationANP().isOnlinePoiAvailable());
        this.setSysConstBool(4547, coding.isLegalDisclaimerOn());
        this.setSysConstBool(487, this.checkOnlineServicesAvailability());
        this.setSysConstBool(488, this.getAdaptationANP().isPayTmcSetOnlineTrafficAvailable());
        this.setSysConstBool(4011, this.getAdaptationANP().isPayTmcSetTrafficAvailable());
        this.setSysConstBool(479, this.getAdaptationANP().isOnlineNaviGoogleEarthAvailable());
        this.setSysConstBool(490, this.getAdaptationANP().isOnlineStreetViewAvailable());
        this.setSysConstBool(489, this.getAdaptationANP().isPictureNaviAvailable());
        this.setSysConstBool(485, this.getAdaptationANP().isMyAudiAvailable());
        this.setSysConstBool(3967, this.getAdaptationANP().isOnlineMediaAvailable() && !this.getAdaptationANP().isServiceDiscoveryAvailable());
        this.setSysConstBool(4155, false);
        this.setSysConstBool(4153, false);
        this.setSysConstBool(4154, false);
        this.setSysConstBool(478, coding.isAmiOn() || coding.isAuxInOn());
        this.setSysConstBool(483, coding.getUsbConfiguration() == 2 || coding.getUsbConfiguration() == 3);
        this.setSysConstBool(480, coding.isBluetoothAvailable() && coding.isBluetoothAudioAvailable() && coding.isBluetoothMultimediaFuncAvailable());
        this.setSysConstBool(481, this.getCarCoding().isImportMediaDataActive() && this.getAdaptationANP().isExternalMediumActivated());
        this.setSysConstBool(482, this.getCarCoding().isRippingMediaDataActive() && this.getAdaptationANP().isOpticalMediumActivated());
        this.setSysConstBool(491, false);
        this.setSysConst(4283, 64);
        boolean bl = this.getCarCoding().isWlanModuleActive() && this.getAdaptationANP().isWlanModuleActivated();
        this.setSysConstBool(492, bl);
        this.setSysConstBool(4442, bl && this.getAdaptationANP().isWLANClient());
        this.setSysConstBool(493, bl && this.getAdaptationANP().isUPnPAvailable());
        this.setSysConstBool(4042, this.getAdaptationANP().isGracenoteOnlineCoverartsAvailable() || this.getAdaptationANP().isGracenoteOnlineOtherAvailable());
        this.setSysConstBool(4108, this.getAdaptationANP().isGracenoteLocalCoverartsAvailable() || this.getAdaptationANP().isGracenoteLocalOtherAvailable());
        boolean bl2 = this.getAdaptationANP().getBluetoothDeactivationState() == 1;
        this.setSysConstBool(461, this.getCarCoding().isBluetoothAvailable() && bl2);
        this.setSysConstBool(472, this.getCarCoding().isMessagingAvailable());
        boolean bl3 = this.getCarCoding().isPhoneNadOn() && this.getAdaptationANP().isTelephoneActivated();
        this.setSysConstBool(463, bl3);
        boolean bl4 = this.getAdaptationANP().getBluetoothDeactivationState() == 1;
        this.setSysConstBool(462, this.getCarCoding().isBluetoothAvailable() && this.getCarCoding().isBluetoothPhoneAvailable() && bl4);
        this.setSysConstBool(512, this.getAdaptationANP().isSupportOfThreewayCalling());
        this.setSysConstBool(513, this.getAdaptationANP().isDtmfWithoutActiveCall());
        this.setSysConstBool(4177, this.getAdaptationANP().isSupports2ndPhone());
        this.setSysConstBool(4162, this.getCarCoding().isBaseplateErrorFlag() || this.getAdaptationANP().isGoogleGAL() || this.getAdaptationANP().isAppleDIO() || coding.getUsbConfiguration() == 2 || coding.getUsbConfiguration() == 3);
        this.setSysConstBool(4219, this.getAdaptationANP().getESIMUUsage() != 1 && bl3);
        boolean bl5 = this.getCarFuncAdaptation().isMenuDisplayActivated((short)51);
        this.setSysConstBool(4252, bl5);
        this.setSysConstBool(4082, this.getCarFuncAdaptation().isMenuDisplayActivated((short)50) && bl5);
        this.setSysConst(4255, 3);
        this.setSysConst(4256, 4000);
        this.setSysConst(4254, 1000);
        this.setSysConstBool(4258, true);
        this.setSysConst(4259, 100);
        this.setSysConst(4425, 10);
        this.setSysConst(4424, 0);
        this.setSysConstBool(476, this.getCarCoding().getDab1Bandsetting() != 0 || this.getCarCoding().getDab2Bandsetting() != 0);
        this.setSysConstBool(4358, this.getCarCoding().isPiActivated());
        this.setSysConst(4577, this.getAdaptationANP().getRadioDatabaseRegion());
        this.setSysConstBool(3892, this.getAdaptationANP().isSDISAvailable());
        this.setSysConstBool(3969, this.getAdaptationANP().isUotAAvailable());
        this.setSysConst(4120, 2);
        this.setSysConstBool(4463, false);
        this.setSysConstBool(4467, true);
        this.setSysConstBool(4465, false);
        this.setSysConstBool(4466, false);
        this.setSysConstBool(4511, false);
        this.setSysConst(4464, 3);
        this.setSysConst(4543, 80);
        this.setSysConst(4544, 0);
        this.setSysConstBool(5542, false);
        this.setSysConstBool(4159, this.getCarCoding().isLogBookDisplayed());
        this.setSysConst(4175, 0);
        this.setSysConstBool(4237, this.getAdaptationANP().isAppleDIO());
        this.setSysConstBool(5571, this.getAdaptationANP().isBaiduCarLife());
        this.setSysConstBool(4238, this.getAdaptationANP().isGoogleGAL());
        this.setSysConstBool(4325, false);
        this.setSysConstBool(4323, false);
        this.setSysConstBool(4324, false);
        this.setSysConst(4348, 0);
        this.setSysConstBool(4347, false);
        this.setSysConst(4524, this.getAdaptationANP().getPrimaryEngineType());
        this.setSysConst(4525, this.getAdaptationANP().getSecondaryEngineType());
        this.setSysConstBool(4526, this.getAdaptationANP().isServiceDiscoveryAvailable());
        this.setSysConstBool(4589, this.getAdaptationANP().isVzoAvailable());
        this.setSysConstBool(4592, this.getAdaptationANP().isLGIAvailable());
        this.setSysConstBool(4590, this.getAdaptationANP().isProbeCarAvailable());
        this.setSysConstBool(4591, this.getAdaptationANP().isProbeCarLGIAvailable());
        this.setSysConstBool(4596, this.getAdaptationANP().isVehicleReadinessSoundAvailable());
        this.setSysConstBool(4606, this.getAdaptationANP().isVehicleLeavingSoundAvailable());
        this.setSysConst(4614, 0);
        this.setSysConst(4633, 0);
        this.setSysConst(5541, 1);
        this.setSysConst(4062, this.getMessagingTemplateOnly());
        this.setSysConst(5614, this.getAdaptationANP().isPopupIfGpsIsInUse() ? 1 : 0);
    }

    protected final boolean isHURegionEU() {
        return this.getSysConst(442) == 0;
    }

    protected boolean isAsia() {
        int n = this.getSysConst(442);
        return n == 2 || n == 3 || n == 5 || n == 4;
    }

    protected boolean isCN() {
        return this.getSysConst(442) == 2;
    }

    protected final boolean isHURegionTW() {
        return this.getSysConst(442) == 5;
    }

    protected final boolean isHURegionJP() {
        return this.getSysConst(442) == 3;
    }

    protected final boolean isHURegionKR() {
        return this.getSysConst(442) == 4;
    }

    protected final boolean isHURegionNAR() {
        return this.getSysConst(442) == 1;
    }

    protected final boolean isHURegionRDW() {
        return this.getSysConst(442) == 6;
    }

    protected final boolean isG21High() {
        return this.getSysConst(4581) == 1;
    }

    protected final boolean areOnlineServicesAvailable() {
        return this.getSysConst(487) == 1;
    }

    protected PopupPrioMapper createPopupPrioMapper() {
        return new PopupPrioMapper();
    }

    public String dumpCarData() {
        Buffer buffer = new Buffer().append("SysConstModels:\n");
        try {
            Field[] fieldArray = (class$de$audi$atip$sysconfig$ICoreSysConfig == null ? (class$de$audi$atip$sysconfig$ICoreSysConfig = AbstractSysConstManager.class$("de.audi.atip.sysconfig.ICoreSysConfig")) : class$de$audi$atip$sysconfig$ICoreSysConfig).getFields();
            Object object = new Object();
            for (int i2 = 0; i2 < fieldArray.length; ++i2) {
                int n = fieldArray[i2].getInt(object);
                if (n <= 50) continue;
                buffer.append(fieldArray[i2].getName()).append(" = ").append(this.getSysConst(n)).append('\n');
            }
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
        if (this.codingData != null) {
            buffer.append(this.codingData.dumpCarData());
        }
        return buffer.toString();
    }

    public void storeSwdlCopy() {
        this.codingData.storeSwdlCopy();
    }

    public void clearSwdlCopy() {
        this.codingData.clearSwdlCopy();
    }

    protected boolean checkOnlineServicesAvailability() {
        return this.getAdaptationANP().isMyAudiAvailable() || this.getAdaptationANP().isWiFiHotspotAvailable() || this.getAdaptationANP().isOnlineStreetViewAvailable() || this.getAdaptationANP().isOnlineNaviGoogleEarthAvailable() || this.getAdaptationANP().isOnlinePortalBrowserServicesAvailable() || this.getAdaptationANP().isOnlinePoiVoiceAvailable() || this.getAdaptationANP().isOnlinePoiAvailable() || this.getAdaptationANP().isVzaProOnAvailable() || this.getAdaptationANP().isRemoteHmiAvailable() || this.getAdaptationANP().isOnlineDictationAvailable() || this.getAdaptationANP().isUotAAvailable() || this.getAdaptationANP().isOnlineMediaAvailable();
    }

    abstract void initVariant();

    abstract void rangeCheckVariant();

    void initVariantDefault() {
        this.setSysConstBool(503, true);
        this.setSysConstBool(501, true);
        this.setSysConstBool(502, true);
        this.setSysConst(4284, 350);
    }

    private void applyInvariantSettings() {
        this.fw.getUtilThreadPool().execute(new Runnable(){

            public void run() {
                try {
                    Thread.sleep(4500L);
                    SperrFlags sperrFlags = AbstractSysConstManager.this.getSperrFlags();
                    AbstractSysConstManager.this.setSysConstBool(5559, sperrFlags.getNavSperrFlag(0));
                    AbstractSysConstManager.this.setSysConstBool(5560, sperrFlags.getMediaSperrFlag(0));
                    AbstractSysConstManager.this.fw.getStartupMgr().logStartupEvent("SperrFlags loading done");
                }
                catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                    AbstractSysConstManager.this.lc.log(10000, "Speer flags were not loaded because a InterruptedException");
                }
            }
        });
    }

    void rangeCheckVariantDefault() {
        this.setSysConstBool(4004, true);
        this.setSysConstBool(4065, true);
        this.setSysConstBool(4249, true);
        this.setSysConstBool(4248, true);
        this.setSysConstBool(4263, true);
        this.setSysConstBool(4347, 1 == this.getSysConst(442));
        this.setSysConstBool(4368, this.isHURegionNAR());
        this.setSysConstBool(4572, true);
        boolean bl = !this.isAsia() && this.getSysConst(442) != 1;
        this.setSysConstBool(4405, bl);
        this.setSysConstBool(4417, true);
        if (this.getSysConst(4581) == 1) {
            this.setSysConstBool(4416, !this.isAsia());
        } else {
            this.setSysConstBool(4416, !this.isCN() && !this.isHURegionTW());
        }
        this.setSysConstBool(4450, this.isCN());
        this.setSysConstBool(4462, this.areOnlineServicesAvailable() && !this.isAsia());
        this.setSysConstBool(4485, this.getSysConst(488) == 1 && !this.isHURegionNAR() && !this.isAsia());
        this.setSysConstBool(4588, this.getSysConst(488) == 1 && this.isHURegionJP());
        if (this.isG21High()) {
            this.setSysConstBool(556, false);
        }
        this.setSysConstBool(4603, (this.isHURegionEU() || this.isHURegionNAR() || this.isHURegionRDW() || this.isAsia()) && this.getCarCoding().getCarDerivate() != 5);
        this.setSysConstBool(4519, true);
        this.setSysConstBool(5581, this.isAsia());
        this.setSysConstBool(5616, false);
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

