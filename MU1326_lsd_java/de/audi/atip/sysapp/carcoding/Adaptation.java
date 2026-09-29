/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.sysapp.carcoding;

public interface Adaptation {
    public static final byte RESET_FUNCTION_RADIO;
    public static final byte RESET_FUNCTION_NAVIGATION;
    public static final byte RESET_FUNCTION_AUDIO_MEDIA_OPTICAL;
    public static final byte RESET_FUNCTION_VIDEO_MEDIA_OPTICAL;
    public static final byte RESET_FUNCTION_DATA_MEDIA_OPTICAL;
    public static final byte RESET_FUNCTION_USB_MEDIA;
    public static final byte RESET_FUNCTION_SD_MEDIA;
    public static final byte RESET_FUNCTION_WIRELESS_MEDIA;
    public static final byte RESET_FUNCTION_HDD_MEDIA;
    public static final byte RESET_FUNCTION_TV_MEDIA;
    public static final byte RESET_FUNCTION_PHONE;
    public static final byte RESET_FUNCTION_SOUND;
    public static final byte RESET_FUNCTION_SETUP;
    public static final byte RESET_FUNCTION_CAR_MENU;
    public static final byte RESET_FUNCTION_ADDRESSBOOK;
    public static final byte RESET_FUNCTION_NAVINFO_TRAFFIC;
    public static final byte RESET_FUNCTION_BROWSER;
    public static final int BLUETOOTH_DEACTIVATION_STATE_OFF;
    public static final int BLUETOOTH_DEACTIVATION_STATE_ON;
    public static final int BLUETOOTH_DEACTIVATION_STATE_NOT_AVAILABLE;
    public static final byte BLUETOOTH_VISIBILITY_NOT_VISIBLE;
    public static final byte BLUETOOTH_VISIBILITY_VISIBLE;
    public static final byte BLUETOOTH_VISIBILITY_AUTOMATIC;
    public static final byte BLUETOOTH_VISIBILITY_LIMITED;
    public static final byte SUMMER_TIME_SHIFT_METHOD_NONE;
    public static final byte SUMMER_TIME_SHIFT_METHOD_MANUEL;
    public static final byte SUMMER_TIME_SHIFT_METHOD_CET;
    public static final byte SUMMER_TIME_SHIFT_METHOD_USA;
    public static final int MEDIA_COUNTRY_CODE_HMI_DEFAULT;
    public static final int MEDIA_COUNTRY_CODE_HMI_JP;
    public static final int MEDIA_COUNTRY_CODE_HMI_CN;
    public static final int MEDIA_COUNTRY_CODE_HMI_KR;
    public static final int MEDIA_COUNTRY_CODE_HMI_TW;
    public static final int MEDIA_COUNTRY_CODE_HMI_HK;
    public static final int MEDIA_COUNTRY_CODE_HMI_MO;
    public static final int PAY_TMC_SET_ONLINE_TRAFFIC_FREE_TMC;
    public static final int PAY_TMC_SET_AUDI_ONLINE_TRAFFIC_TMC_PRO;
    public static final int PAY_TMC_SET_AUDI_ONLINE_TRAFFIC;
    public static final int PAY_TMC_SET_VW_ONLINE_TRAFFIC_TMC_PRO;
    public static final int PAY_TMC_SET_VW_ONLINE_TRAFFIC;
    public static final int PAY_TMC_SET_BENTLEY_ONLINE_TRAFFIC_TMC_PRO;
    public static final int PAY_TMC_SET_BENTLEY_ONLINE_TRAFFIC;
    public static final int PAY_TMC_SET_BENTLEY_ONLINE_TRAFFIC_WITHOUT_MEDIA_MOBILE;
    public static final int PAY_TMC_SET_AUDI_ONLINE_TRAFFIC_TMC_PRO_INFO_BLUE;
    public static final int PAY_TMC_SET_AUDI_ONLINE_TRAFFIC_INFO_BLUE;
    public static final int PAY_TMC_SET_VW_ONLINE_TRAFFIC_TMC_PRO_INFO_BLUE;
    public static final int PAY_TMC_SET_VW_ONLINE_TRAFFIC_INFO_BLUE;
    public static final int PAY_TMC_SET_BENTLEY_ONLINE_TRAFFIC_TMC_PRO_INFO_BLUE;
    public static final int PAY_TMC_SET_BENTLEY_ONLINE_TRAFFIC_INFO_BLUE;
    public static final int PAY_TMC_SET_ONLINE_TRAFFIC_TMC_PRO_ITIS_INFO_BLUE_VIA_MICHELIN;
    public static final int PAY_TMC_SET_ONLINE_TRAFFIC_TMC_PRO_TRAFFIC_MASTER_INFO_BLUE_VIA_MICHELIN;
    public static final int PAY_TMC_SET_ONLINE_TRAFFIC_TMC_PRO_TRAFFIC_MASTER_INFO_BLUE_VIA_MICHELIN_RUSSIA_FREE_TMC;
    public static final int PAY_TMC_SET_ONLINE_TRAFFIC_TMC_PRO_TRAFFIC_MASTER_INFO_BLUE_VIA_MICHELIN_RUSSIA_TMC_PRO;
    public static final int PAY_TMC_SET_ONLINE_TRAFFIC_TMC_PRO_TRAFFIC_MASTER_INFO_BLUE_VIA_MICHELIN_FREE_DAB_TPEG;
    public static final int PAY_TMC_SET_ONLINE_TRAFFIC_PAY_TMC_GER;
    public static final int PAY_TMC_SET_ONLINE_TRAFFIC_PAY_TMC_FRANCE;
    public static final int PAY_TMC_SET_ONLINE_TRAFFIC_PAY_TMC_UK;
    public static final int PAY_TMC_SET_ONLINE_TRAFFIC_PAY_TMC_PT;
    public static final int PAY_TMC_SET_ONLINE_TRAFFIC_FREE_TMC_SCALE;
    public static final int PAY_TMC_SET_ONLINE_TRAFFIC_VW_PAY_TMC_ALL;
    public static final int PAY_TMC_SET_ONLINE_TRAFFIC_INTELMATICS;
    public static final int PAY_TMC_SET_ONLINE_TRAFFIC_ALTECH_NETSTAR;
    public static final int PAY_TMC_SET_ONLINE_TRAFFIC_CHINA_CENNAVI;
    public static final int PAY_TMC_SET_ONLINE_TRAFFIC_CHINA_AUTONAVI;
    public static final int PAY_TMC_SET_ONLINE_TRAFFIC_NAR_SIRIUS_FREE_TMC;
    public static final int PAY_TMC_SET_ONLINE_TRAFFIC_NAR_SIRIUS;
    public static final int PAY_TMC_SET_ONLINE_TRAFFIC_NAR_CLEARCHANNEL_HD;
    public static final int PAY_TMC_SET_ONLINE_TRAFFIC_ONLY;
    public static final int EMERGENCY_CALL_PRIVATE_MODE_DEACTIVATED;
    public static final int EMERGENCY_CALL_PRIVATE_MODE_ACTIVATED;
    public static final int EMERGENCY_CALL_PRIVATE_MODE_USER_DEFINED;
    public static final int NAV_MAP_TRANSMISSION_MODE_OFF;
    public static final int NAV_MAP_TRANSMISSION_MODE_MOST_HIGH;
    public static final int NAV_MAP_TRANSMISSION_MODE_MOST_STREAMING;
    public static final int NAV_MAP_TRANSMISSION_MODE_LVDS_FPK;
    public static final int NAV_MAP_TRANSMISSION_MODE_LVDS_MMI_COMBI;
    public static final int NAV_KDK_TRANSMISSION_MODE_OFF;
    public static final int NAV_KDK_TRANSMISSION_MODE_MOST_HIGH;
    public static final int NAV_KDK_TRANSMISSION_MODE_MOST_STREAMING;
    public static final int NAV_KDK_TRANSMISSION_MODE_LVDS_FPK;
    public static final int NAV_KDK_TRANSMISSION_MODE_LVDS_MMI_COMBI;
    public static final int ESIM_SERVICE_DEPENDENT;
    public static final int ESIM_NEVER;
    public static final int ESIM_ALWAYS;
    public static final byte ENGINE_TYPE_NOT_INSTALLED;
    public static final byte ENGINE_TYPE_ELECTRIC;
    public static final byte ENGINE_TYPE_UNKNOWN;
    public static final byte ENGINE_TYPE_PETROL_DIESEL;
    public static final byte ENGINE_TYPE_PETROL_GASOLINE;
    public static final byte ENGINE_TYPE_GAS_CNG;
    public static final byte ENGINE_TYPE_GAS_LPG;
    public static final byte ENGINE_TYPE_VALUE_FROM_BAP;

    default public int getPopupLanguageSelectionStatus() {
    }

    default public int getTestmodeVideoSpeedCutoffLimit() {
    }

    default public boolean isExternalMediumActivated() {
    }

    default public boolean isOpticalMediumActivated() {
    }

    default public boolean isResetToZeroValid(short s) {
    }

    default public int getBluetoothDeactivationState() {
    }

    default public boolean isBluetoothSniffModeActivated() {
    }

    default public int getBluetoothVisibility() {
    }

    default public int getDvdRegionCode() {
    }

    default public int getBlueRaySystemRegionCode() {
    }

    default public boolean isCdEjectButtonBlocked() {
    }

    default public boolean isDeveloperTestModeActivated() {
    }

    default public int getEmergencyEstablishLinkAttempts() {
    }

    default public int getSummerTimeShiftMethod() {
    }

    default public boolean isTelephoneActivated() {
    }

    default public boolean isWlanModuleActivated() {
    }

    default public boolean isVzaProOnAvailable() {
    }

    default public boolean isOnlinePoiAvailable() {
    }

    default public boolean isOnlinePoiVoiceAvailable() {
    }

    default public boolean isOnlinePortalBrowserServicesAvailable() {
    }

    default public boolean isOnlineNaviGoogleEarthAvailable() {
    }

    default public boolean isOnlineStreetViewAvailable() {
    }

    default public boolean isWiFiHotspotAvailable() {
    }

    default public boolean isMyAudiAvailable() {
    }

    default public boolean isPictureNaviAvailable() {
    }

    default public boolean isOnlineDictationAvailable() {
    }

    default public boolean isRemoteHmiAvailable() {
    }

    default public boolean isAdvancedRangeDisplayAvailable() {
    }

    default public boolean isGracenoteOnlineCoverartsAvailable() {
    }

    default public boolean isGracenoteOnlineOtherAvailable() {
    }

    default public boolean isGracenoteLocalCoverartsAvailable() {
    }

    default public boolean isGracenoteLocalOtherAvailable() {
    }

    default public boolean isUPnPAvailable() {
    }

    default public boolean isOPSinDashboardAvailable() {
    }

    default public int getMediaCountryCodeHmi() {
    }

    default public int getPayTmcSet() {
    }

    default public boolean isPayTmcSetOnlineTrafficAvailable() {
    }

    default public boolean isPayTmcSetTrafficAvailable() {
    }

    default public int getEmergencyCallPrivateMode() {
    }

    default public boolean isSimCardModeSwitch() {
    }

    default public boolean isPhoneModuleOperationModeWithVoice() {
    }

    default public boolean isSupportOfThreewayCalling() {
    }

    default public boolean isDtmfWithoutActiveCall() {
    }

    default public boolean isSupportForResponseAndHold() {
    }

    default public int getNavMapTransmissionMode() {
    }

    default public int getNavKDKTransmissionMode() {
    }

    default public boolean isCoverartAvailable() {
    }

    default public boolean isStationartAvailable() {
    }

    default public boolean isCallPictureAvailable() {
    }

    default public boolean isFastMOSTListAvailable() {
    }

    default public boolean isTVAvailable() {
    }

    default public boolean isTpegAvailable() {
    }

    default public boolean isVzoAvailable() {
    }

    default public boolean isLGIAvailable() {
    }

    default public boolean isProbeCarAvailable() {
    }

    default public boolean isOnlineMediaAvailable() {
    }

    default public boolean isProbeCarLGIAvailable() {
    }

    default public boolean isOperatorCallAvailable() {
    }

    default public int getRadioDatabaseRegion() {
    }

    default public boolean isUotAAvailable() {
    }

    default public boolean isSupports2ndPhone() {
    }

    default public int getESIMUUsage() {
    }

    default public boolean isAppleDIO() {
    }

    default public boolean isBaiduCarLife() {
    }

    default public boolean isGoogleGAL() {
    }

    default public boolean isSDISAvailable() {
    }

    default public boolean isWLANClient() {
    }

    default public boolean isBreakdownCallAvailable() {
    }

    default public boolean isPOICallAvailable() {
    }

    default public byte getPrimaryEngineType() {
    }

    default public byte getSecondaryEngineType() {
    }

    default public boolean isServiceDiscoveryAvailable() {
    }

    default public boolean isVehicleReadinessSoundAvailable() {
    }

    default public boolean isVehicleLeavingSoundAvailable() {
    }

    default public boolean isAllowMessageEditing() {
    }

    default public boolean isPopupIfGpsIsInUse() {
    }

    default public boolean isMobileDeviceKeyProfile() {
    }
}

