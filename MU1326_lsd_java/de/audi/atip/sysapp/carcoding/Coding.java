/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.sysapp.carcoding;

public interface Coding {
    public static final int COUNTRY_NO_COUNTRY = 0;
    public static final int COUNTRY_EU = 1;
    public static final int COUNTRY_NAR = 2;
    public static final int COUNTRY_MSA = 3;
    public static final int COUNTRY_KOREA = 4;
    public static final int COUNTRY_CHINA = 5;
    public static final int COUNTRY_JAPAN = 6;
    public static final int COUNTRY_ASIA_PACIFIC = 7;
    public static final int COUNTRY_AUSTRALIA = 8;
    public static final int COUNTRY_SOUTH_AFRIKA = 9;
    public static final int COUNTRY_NEAST = 10;
    public static final int COUNTRY_NM_AFRICA = 11;
    public static final int COUNTRY_MEAST = 12;
    public static final int COUNTRY_CENTRAL_ASIA = 13;
    public static final int COUNTRY_INDIA = 14;
    public static final int COUNTRY_ISRAEL = 15;
    public static final int COUNTRY_TAIWAN = 16;
    public static final int COUNTRY_MSA2 = 17;
    public static final int MAX_SPEAKER_CHANNELS = 16;
    public static final int CODING_DATA_LENGTH = 25;
    public static final int CAR_BRAND_NO_BRAND = 0;
    public static final int CAR_BRAND_AUDI = 1;
    public static final int CAR_BRAND_VW = 2;
    public static final int CAR_BRAND_SKODA = 3;
    public static final int CAR_BRAND_SEAT = 4;
    public static final int CAR_BRAND_BENTLEY = 5;
    public static final int CAR_BRAND_VW_NFZ = 6;
    public static final int CAR_CLASS_A000 = 0;
    public static final int CAR_CLASS_A00 = 1;
    public static final int CAR_CLASS_A0 = 2;
    public static final int CAR_CLASS_A = 3;
    public static final int CAR_CLASS_B = 4;
    public static final int CAR_CLASS_C = 5;
    public static final int CAR_CLASS_D = 6;
    public static final int CAR_CLASS_E_MINUS = 7;
    public static final int CAR_CLASS_E_PLUS = 8;
    public static final int CAR_CLASS_SONSTIGE = 9;
    public static final int CAR_DERIVATE_KURZHECK = 0;
    public static final int CAR_DERIVATE_STUFENHECK = 1;
    public static final int CAR_DERIVATE_KOMBI = 2;
    public static final int CAR_DERIVATE_FLIESSHECK_SPORTSBACK = 3;
    public static final int CAR_DERIVATE_COUPE = 4;
    public static final int CAR_DERIVATE_CABRIO_ROADSTER_SPIDER_TARGA = 5;
    public static final int CAR_DERIVATE_SUV = 6;
    public static final int CAR_DERIVATE_PICK_UP = 7;
    public static final int CAR_DERIVATE_RAUMKONZEPT = 8;
    public static final int CAR_DERIVATE_SONSTIGE = 9;
    public static final int CAR_DERIVATE_SUPP_KURZER_RADSTAND = 0;
    public static final int CAR_DERIVATE_SUPP_LANGER_RADSTAND = 1;
    public static final int CAR_DERIVATE_SUPP_GEAENDERT_FRONT_HECK = 2;
    public static final int CAR_DERIVATE_SUPP_AUFBAU_DACHVAR = 3;
    public static final int CAR_DERIVATE_SUPP_CROSS_ALLROAD = 4;
    public static final int CAR_DERIVATE_SUPP_LEISTUNGVARI_1 = 5;
    public static final int CAR_DERIVATE_SUPP_LEISTUNGSVARI_2 = 6;
    public static final int CAR_DERIVATE_SUPP_ALTERN_ANTRIEB = 7;
    public static final int CAR_DERIVATE_SUPP_SONST = 8;
    public static final int CAR_DERIVATE_SUPP_SONSTIGE = 9;
    public static final int MICROPHONE_1 = 0;
    public static final int MICROPHONE_2 = 1;
    public static final int HEADPHONE_OUTPUT_1 = 0;
    public static final int HEADPHONE_OUTPUT_2 = 1;
    public static final int BAND_FM_NO_SETTING = 0;
    public static final int BAND_FM_EU_RDW = 1;
    public static final int BAND_FM_NAR = 2;
    public static final int BAND_FM_JP = 3;
    public static final int BAND_FM_KOR = 4;
    public static final int BAND_FM_CN = 5;
    public static final int BAND_FM_JP_2 = 8;
    public static final int BAND_AM_NO_SETTING = 0;
    public static final int BAND_AM_EU_RDW = 1;
    public static final int BAND_AM_NAR = 2;
    public static final int BAND_AM_JP = 3;
    public static final int BAND_AM_EU = 4;
    public static final int BAND_AM_AUS = 5;
    public static final int BAND_DAB1_OFF = 0;
    public static final int BAND_DAB1_EU_BAND_III_N = 1;
    public static final int BAND_DAB1_EU_BAND_III = 2;
    public static final int BAND_DAB1_CANADA_L_BAND = 3;
    public static final int BAND_DAB1_KOREA_BAND_III = 4;
    public static final int BAND_DAB1_CHINA_BAND_III = 5;
    public static final int BAND_DAB1_NEW_ZEALAND_BAND_III = 7;
    public static final int BAND_DAB1_DOWNLOAD_TABLE_1 = 6;
    public static final int BAND_DAB2_OFF = 0;
    public static final int BAND_DAB2_L_BAND = 1;
    public static final int BAND_DAB2_DOWNLOAD_TABLE_2 = 2;
    public static final int SOUND_NO_ALLOC = 0;
    public static final int SOUND_INTERN = 1;
    public static final int SOUND_EXTERN = 2;
    public static final int SOUND_EXTERN_BAP = 3;
    public static final int ANTENNA_DIAGNOSTICS_1 = 0;
    public static final int ANTENNA_DIAGNOSTICS_2 = 1;
    public static final int AF_PERSISTENT = 0;
    public static final int AF_TEMPORARY = 1;
    public static final int BWS_NO = 0;
    public static final int BWS_RESTRICTED = 1;
    public static final int BWS_UNRESTRICTED = 2;
    public static final int BWS_RESTRICTED_UNRESTRICTED = 3;
    public static final int BT_VISIBILITY_OFF = 0;
    public static final int BT_VISIBILITY_AUTO = 1;
    public static final int BT_VISIBILITY_ON = 2;
    public static final int SKIN_NO_SKIN = 0;
    public static final int SKIN_1 = 1;
    public static final int SKIN_2 = 2;
    public static final int SKIN_3 = 3;
    public static final int SCREEN_NO_SCREEN = 0;
    public static final int SCREEN_1 = 1;
    public static final int SCREEN_2 = 2;
    public static final int SCREEN_3 = 3;
    public static final int SCREEN_4 = 4;
    public static final int SCREEN_5 = 5;
    public static final int SCREEN_6 = 6;
    public static final int SCREEN_7 = 7;
    public static final int SCREEN_8 = 8;
    public static final int SCREEN_N = 9;
    public static final int SAS_LEFT_HAND_DRIVE = 0;
    public static final int SAS_RIGHT_HAND_DRIVE = 1;
    public static final int KTS_INFO_NOT_AVAILABLE = 0;
    public static final int KTS_INFO_LONG_INFO = 1;
    public static final int KTS_INFO_SHORT_INFO = 2;
    public static final int USB_OFF = 0;
    public static final int USB_CHARGE = 1;
    public static final int USB_FULL = 2;
    public static final int USB_IPOD = 3;
    public static final int DGV_MOST = 0;
    public static final int DGV_CAN = 1;

    public byte getCarBrand();

    public byte getCarClass();

    public byte getCarGeneration();

    public byte getCarDerivate();

    public byte getCarDerivateSupplement();

    public int getCountry();

    public boolean isSpeakerChannelInstalledHT(int var1);

    public boolean isSpeakerChannelInstalledTT(int var1);

    public boolean isMicrophoneConnected(int var1);

    public boolean isHeadphoneOutputActive(int var1);

    public boolean isAuxInOn();

    public boolean isAmiOn();

    public boolean isVdaNfInOn();

    public byte getFmBandsetting();

    public byte getAmBandsetting();

    public byte getDab1Bandsetting();

    public byte getDab2Bandsetting();

    public int getSoundSystem();

    public boolean isSecondFmAntennaAvailable();

    public int getExtendedAntennaDiagnosticsFmDab();

    public boolean isRdsOverHmiActivated();

    public int getAfMode();

    public boolean isHdActivated();

    public boolean isRadioTextPlusActivated();

    public boolean isPiActivated();

    public byte getBwsProfile();

    public boolean isDabAlarmAnnouncementActivated();

    public boolean isFmPty31AlarmOn();

    public boolean isAmDisabled();

    public boolean isMultiChannelReception();

    public boolean isMultipleEntry();

    public boolean isRdsDeactivated();

    public boolean isAfDeactivated();

    public boolean isDiagnosticBaseplateInstalled();

    public boolean isAntennaAtBaseplateInstalled();

    public boolean isCradleForce();

    public boolean isHandyCradleForce();

    public boolean isPhoneNadOn();

    public boolean isBluetoothAvailable();

    public boolean isBluetoothMultimediaFuncAvailable();

    public boolean isBluetoothPhoneAvailable();

    public boolean isBluetoothAudioAvailable();

    public byte getBluetoothVisibility();

    public boolean isMessagingAvailable();

    public int getSkin();

    public int getScreen();

    public boolean isLogBookDisplayed();

    public byte getDriverSide();

    public byte getKombiTrackStationInfo();

    public boolean isRearViewLowActive();

    public boolean isMostOn();

    public int getUsbConfiguration();

    public boolean isDisplayConnected(int var1);

    public int getBusHandling();

    public boolean isScrollingActivated();

    public boolean isMessagingViaMapActivated();

    public boolean isPagewiseScrollingActivated();

    public int getDashboardGraphicVariant();

    public boolean isDashboardTextReplacementActivated();

    public boolean isSpellerOn();

    public boolean isInitialDisclaimerOn();

    public boolean isLegalDisclaimerOn();

    public boolean isEmergencyCallOn();

    public boolean isVoiceControlSystemActive();

    public boolean isNavigationActive();

    public boolean isWlanModuleActive();

    public boolean isImportMediaDataActive();

    public boolean isRippingMediaDataActive();

    public boolean isTrafficSignDisplayActive();

    public boolean isPsdActive();

    public boolean isBaseplateErrorFlag();
}

