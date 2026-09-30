/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.sysapp.carcoding;

public interface Adaptation {
    public static final byte RESET_FUNCTION_RADIO = 0;
    public static final byte RESET_FUNCTION_NAVIGATION = 1;
    public static final byte RESET_FUNCTION_AUDIO_MEDIA_OPTICAL = 2;
    public static final byte RESET_FUNCTION_VIDEO_MEDIA_OPTICAL = 3;
    public static final byte RESET_FUNCTION_DATA_MEDIA_OPTICAL = 4;
    public static final byte RESET_FUNCTION_USB_MEDIA = 5;
    public static final byte RESET_FUNCTION_SD_MEDIA = 6;
    public static final byte RESET_FUNCTION_WIRELESS_MEDIA = 7;
    public static final byte RESET_FUNCTION_HDD_MEDIA = 8;
    public static final byte RESET_FUNCTION_TV_MEDIA = 9;
    public static final byte RESET_FUNCTION_PHONE = 10;
    public static final byte RESET_FUNCTION_SOUND = 11;
    public static final byte RESET_FUNCTION_SETUP = 12;
    public static final byte RESET_FUNCTION_CAR_MENU = 13;
    public static final byte RESET_FUNCTION_ADDRESSBOOK = 14;
    public static final byte RESET_FUNCTION_NAVINFO_TRAFFIC = 15;
    public static final byte RESET_FUNCTION_BROWSER = 16;
    public static final int BLUETOOTH_DEACTIVATION_STATE_OFF = 0;
    public static final int BLUETOOTH_DEACTIVATION_STATE_ON = 1;
    public static final int BLUETOOTH_DEACTIVATION_STATE_NOT_AVAILABLE = 255;
    public static final byte BLUETOOTH_VISIBILITY_NOT_VISIBLE = 0;
    public static final byte BLUETOOTH_VISIBILITY_VISIBLE = 1;
    public static final byte BLUETOOTH_VISIBILITY_AUTOMATIC = 2;
    public static final byte BLUETOOTH_VISIBILITY_LIMITED = 3;
    public static final byte SUMMER_TIME_SHIFT_METHOD_NONE = 0;
    public static final byte SUMMER_TIME_SHIFT_METHOD_MANUEL = 1;
    public static final byte SUMMER_TIME_SHIFT_METHOD_CET = 2;
    public static final byte SUMMER_TIME_SHIFT_METHOD_USA = 3;
    public static final int MEDIA_COUNTRY_CODE_HMI_DEFAULT = 11565;
    public static final int MEDIA_COUNTRY_CODE_HMI_JP = 19024;
    public static final int MEDIA_COUNTRY_CODE_HMI_CN = 17230;
    public static final int MEDIA_COUNTRY_CODE_HMI_KR = 19282;
    public static final int MEDIA_COUNTRY_CODE_HMI_TW = 21591;
    public static final int MEDIA_COUNTRY_CODE_HMI_HK = 18507;
    public static final int MEDIA_COUNTRY_CODE_HMI_MO = 19791;
    public static final int PAY_TMC_SET_ONLINE_TRAFFIC_FREE_TMC = 32768;
    public static final int PAY_TMC_SET_AUDI_ONLINE_TRAFFIC_TMC_PRO = 32769;
    public static final int PAY_TMC_SET_AUDI_ONLINE_TRAFFIC = 32770;
    public static final int PAY_TMC_SET_VW_ONLINE_TRAFFIC_TMC_PRO = 32771;
    public static final int PAY_TMC_SET_VW_ONLINE_TRAFFIC = 32772;
    public static final int PAY_TMC_SET_BENTLEY_ONLINE_TRAFFIC_TMC_PRO = 32773;
    public static final int PAY_TMC_SET_BENTLEY_ONLINE_TRAFFIC = 32774;
    public static final int PAY_TMC_SET_BENTLEY_ONLINE_TRAFFIC_WITHOUT_MEDIA_MOBILE = 32775;
    public static final int PAY_TMC_SET_AUDI_ONLINE_TRAFFIC_TMC_PRO_INFO_BLUE = 32776;
    public static final int PAY_TMC_SET_AUDI_ONLINE_TRAFFIC_INFO_BLUE = 32777;
    public static final int PAY_TMC_SET_VW_ONLINE_TRAFFIC_TMC_PRO_INFO_BLUE = 32778;
    public static final int PAY_TMC_SET_VW_ONLINE_TRAFFIC_INFO_BLUE = 32779;
    public static final int PAY_TMC_SET_BENTLEY_ONLINE_TRAFFIC_TMC_PRO_INFO_BLUE = 32780;
    public static final int PAY_TMC_SET_BENTLEY_ONLINE_TRAFFIC_INFO_BLUE = 32781;
    public static final int PAY_TMC_SET_ONLINE_TRAFFIC_TMC_PRO_ITIS_INFO_BLUE_VIA_MICHELIN = 32782;
    public static final int PAY_TMC_SET_ONLINE_TRAFFIC_TMC_PRO_TRAFFIC_MASTER_INFO_BLUE_VIA_MICHELIN = 32783;
    public static final int PAY_TMC_SET_ONLINE_TRAFFIC_TMC_PRO_TRAFFIC_MASTER_INFO_BLUE_VIA_MICHELIN_RUSSIA_FREE_TMC = 32784;
    public static final int PAY_TMC_SET_ONLINE_TRAFFIC_TMC_PRO_TRAFFIC_MASTER_INFO_BLUE_VIA_MICHELIN_RUSSIA_TMC_PRO = 32785;
    public static final int PAY_TMC_SET_ONLINE_TRAFFIC_TMC_PRO_TRAFFIC_MASTER_INFO_BLUE_VIA_MICHELIN_FREE_DAB_TPEG = 32786;
    public static final int PAY_TMC_SET_ONLINE_TRAFFIC_PAY_TMC_GER = 32787;
    public static final int PAY_TMC_SET_ONLINE_TRAFFIC_PAY_TMC_FRANCE = 32788;
    public static final int PAY_TMC_SET_ONLINE_TRAFFIC_PAY_TMC_UK = 32789;
    public static final int PAY_TMC_SET_ONLINE_TRAFFIC_PAY_TMC_PT = 32790;
    public static final int PAY_TMC_SET_ONLINE_TRAFFIC_FREE_TMC_SCALE = 32793;
    public static final int PAY_TMC_SET_ONLINE_TRAFFIC_VW_PAY_TMC_ALL = 33791;
    public static final int PAY_TMC_SET_ONLINE_TRAFFIC_INTELMATICS = 33792;
    public static final int PAY_TMC_SET_ONLINE_TRAFFIC_ALTECH_NETSTAR = 33793;
    public static final int PAY_TMC_SET_ONLINE_TRAFFIC_CHINA_CENNAVI = 34048;
    public static final int PAY_TMC_SET_ONLINE_TRAFFIC_CHINA_AUTONAVI = 34049;
    public static final int PAY_TMC_SET_ONLINE_TRAFFIC_NAR_SIRIUS_FREE_TMC = 34304;
    public static final int PAY_TMC_SET_ONLINE_TRAFFIC_NAR_SIRIUS = 34305;
    public static final int PAY_TMC_SET_ONLINE_TRAFFIC_NAR_CLEARCHANNEL_HD = 34306;
    public static final int PAY_TMC_SET_ONLINE_TRAFFIC_ONLY = 65533;
    public static final int EMERGENCY_CALL_PRIVATE_MODE_DEACTIVATED = 0;
    public static final int EMERGENCY_CALL_PRIVATE_MODE_ACTIVATED = 1;
    public static final int EMERGENCY_CALL_PRIVATE_MODE_USER_DEFINED = 255;
    public static final int NAV_MAP_TRANSMISSION_MODE_OFF = 0;
    public static final int NAV_MAP_TRANSMISSION_MODE_MOST_HIGH = 1;
    public static final int NAV_MAP_TRANSMISSION_MODE_MOST_STREAMING = 2;
    public static final int NAV_MAP_TRANSMISSION_MODE_LVDS_FPK = 3;
    public static final int NAV_MAP_TRANSMISSION_MODE_LVDS_MMI_COMBI = 4;
    public static final int NAV_KDK_TRANSMISSION_MODE_OFF = 0;
    public static final int NAV_KDK_TRANSMISSION_MODE_MOST_HIGH = 1;
    public static final int NAV_KDK_TRANSMISSION_MODE_MOST_STREAMING = 2;
    public static final int NAV_KDK_TRANSMISSION_MODE_LVDS_FPK = 3;
    public static final int NAV_KDK_TRANSMISSION_MODE_LVDS_MMI_COMBI = 4;
    public static final int ESIM_SERVICE_DEPENDENT = 0;
    public static final int ESIM_NEVER = 1;
    public static final int ESIM_ALWAYS = 2;
    public static final byte ENGINE_TYPE_NOT_INSTALLED = 0;
    public static final byte ENGINE_TYPE_ELECTRIC = 1;
    public static final byte ENGINE_TYPE_UNKNOWN = 2;
    public static final byte ENGINE_TYPE_PETROL_DIESEL = 3;
    public static final byte ENGINE_TYPE_PETROL_GASOLINE = 4;
    public static final byte ENGINE_TYPE_GAS_CNG = 5;
    public static final byte ENGINE_TYPE_GAS_LPG = 6;
    public static final byte ENGINE_TYPE_VALUE_FROM_BAP = 15;

    public int getPopupLanguageSelectionStatus();

    public int getTestmodeVideoSpeedCutoffLimit();

    public boolean isExternalMediumActivated();

    public boolean isOpticalMediumActivated();

    public boolean isResetToZeroValid(short var1);

    public int getBluetoothDeactivationState();

    public boolean isBluetoothSniffModeActivated();

    public int getBluetoothVisibility();

    public int getDvdRegionCode();

    public int getBlueRaySystemRegionCode();

    public boolean isCdEjectButtonBlocked();

    public boolean isDeveloperTestModeActivated();

    public int getEmergencyEstablishLinkAttempts();

    public int getSummerTimeShiftMethod();

    public boolean isTelephoneActivated();

    public boolean isWlanModuleActivated();

    public boolean isVzaProOnAvailable();

    public boolean isOnlinePoiAvailable();

    public boolean isOnlinePoiVoiceAvailable();

    public boolean isOnlinePortalBrowserServicesAvailable();

    public boolean isOnlineNaviGoogleEarthAvailable();

    public boolean isOnlineStreetViewAvailable();

    public boolean isWiFiHotspotAvailable();

    public boolean isMyAudiAvailable();

    public boolean isPictureNaviAvailable();

    public boolean isOnlineDictationAvailable();

    public boolean isRemoteHmiAvailable();

    public boolean isAdvancedRangeDisplayAvailable();

    public boolean isGracenoteOnlineCoverartsAvailable();

    public boolean isGracenoteOnlineOtherAvailable();

    public boolean isGracenoteLocalCoverartsAvailable();

    public boolean isGracenoteLocalOtherAvailable();

    public boolean isUPnPAvailable();

    public boolean isOPSinDashboardAvailable();

    public int getMediaCountryCodeHmi();

    public int getPayTmcSet();

    public boolean isPayTmcSetOnlineTrafficAvailable();

    public boolean isPayTmcSetTrafficAvailable();

    public int getEmergencyCallPrivateMode();

    public boolean isSimCardModeSwitch();

    public boolean isPhoneModuleOperationModeWithVoice();

    public boolean isSupportOfThreewayCalling();

    public boolean isDtmfWithoutActiveCall();

    public boolean isSupportForResponseAndHold();

    public int getNavMapTransmissionMode();

    public int getNavKDKTransmissionMode();

    public boolean isCoverartAvailable();

    public boolean isStationartAvailable();

    public boolean isCallPictureAvailable();

    public boolean isFastMOSTListAvailable();

    public boolean isTVAvailable();

    public boolean isTpegAvailable();

    public boolean isVzoAvailable();

    public boolean isLGIAvailable();

    public boolean isProbeCarAvailable();

    public boolean isOnlineMediaAvailable();

    public boolean isProbeCarLGIAvailable();

    public boolean isOperatorCallAvailable();

    public int getRadioDatabaseRegion();

    public boolean isUotAAvailable();

    public boolean isSupports2ndPhone();

    public int getESIMUUsage();

    public boolean isAppleDIO();

    public boolean isBaiduCarLife();

    public boolean isGoogleGAL();

    public boolean isSDISAvailable();

    public boolean isWLANClient();

    public boolean isBreakdownCallAvailable();

    public boolean isPOICallAvailable();

    public byte getPrimaryEngineType();

    public byte getSecondaryEngineType();

    public boolean isServiceDiscoveryAvailable();

    public boolean isVehicleReadinessSoundAvailable();

    public boolean isVehicleLeavingSoundAvailable();

    public boolean isAllowMessageEditing();

    public boolean isPopupIfGpsIsInUse();

    public boolean isMobileDeviceKeyProfile();
}

