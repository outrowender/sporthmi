/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.sysapp.carcoding;

public interface Coding {
    public static final int COUNTRY_NO_COUNTRY;
    public static final int COUNTRY_EU;
    public static final int COUNTRY_NAR;
    public static final int COUNTRY_MSA;
    public static final int COUNTRY_KOREA;
    public static final int COUNTRY_CHINA;
    public static final int COUNTRY_JAPAN;
    public static final int COUNTRY_ASIA_PACIFIC;
    public static final int COUNTRY_AUSTRALIA;
    public static final int COUNTRY_SOUTH_AFRIKA;
    public static final int COUNTRY_NEAST;
    public static final int COUNTRY_NM_AFRICA;
    public static final int COUNTRY_MEAST;
    public static final int COUNTRY_CENTRAL_ASIA;
    public static final int COUNTRY_INDIA;
    public static final int COUNTRY_ISRAEL;
    public static final int COUNTRY_TAIWAN;
    public static final int COUNTRY_MSA2;
    public static final int MAX_SPEAKER_CHANNELS;
    public static final int CODING_DATA_LENGTH;
    public static final int CAR_BRAND_NO_BRAND;
    public static final int CAR_BRAND_AUDI;
    public static final int CAR_BRAND_VW;
    public static final int CAR_BRAND_SKODA;
    public static final int CAR_BRAND_SEAT;
    public static final int CAR_BRAND_BENTLEY;
    public static final int CAR_BRAND_VW_NFZ;
    public static final int CAR_CLASS_A000;
    public static final int CAR_CLASS_A00;
    public static final int CAR_CLASS_A0;
    public static final int CAR_CLASS_A;
    public static final int CAR_CLASS_B;
    public static final int CAR_CLASS_C;
    public static final int CAR_CLASS_D;
    public static final int CAR_CLASS_E_MINUS;
    public static final int CAR_CLASS_E_PLUS;
    public static final int CAR_CLASS_SONSTIGE;
    public static final int CAR_DERIVATE_KURZHECK;
    public static final int CAR_DERIVATE_STUFENHECK;
    public static final int CAR_DERIVATE_KOMBI;
    public static final int CAR_DERIVATE_FLIESSHECK_SPORTSBACK;
    public static final int CAR_DERIVATE_COUPE;
    public static final int CAR_DERIVATE_CABRIO_ROADSTER_SPIDER_TARGA;
    public static final int CAR_DERIVATE_SUV;
    public static final int CAR_DERIVATE_PICK_UP;
    public static final int CAR_DERIVATE_RAUMKONZEPT;
    public static final int CAR_DERIVATE_SONSTIGE;
    public static final int CAR_DERIVATE_SUPP_KURZER_RADSTAND;
    public static final int CAR_DERIVATE_SUPP_LANGER_RADSTAND;
    public static final int CAR_DERIVATE_SUPP_GEAENDERT_FRONT_HECK;
    public static final int CAR_DERIVATE_SUPP_AUFBAU_DACHVAR;
    public static final int CAR_DERIVATE_SUPP_CROSS_ALLROAD;
    public static final int CAR_DERIVATE_SUPP_LEISTUNGVARI_1;
    public static final int CAR_DERIVATE_SUPP_LEISTUNGSVARI_2;
    public static final int CAR_DERIVATE_SUPP_ALTERN_ANTRIEB;
    public static final int CAR_DERIVATE_SUPP_SONST;
    public static final int CAR_DERIVATE_SUPP_SONSTIGE;
    public static final int MICROPHONE_1;
    public static final int MICROPHONE_2;
    public static final int HEADPHONE_OUTPUT_1;
    public static final int HEADPHONE_OUTPUT_2;
    public static final int BAND_FM_NO_SETTING;
    public static final int BAND_FM_EU_RDW;
    public static final int BAND_FM_NAR;
    public static final int BAND_FM_JP;
    public static final int BAND_FM_KOR;
    public static final int BAND_FM_CN;
    public static final int BAND_FM_JP_2;
    public static final int BAND_AM_NO_SETTING;
    public static final int BAND_AM_EU_RDW;
    public static final int BAND_AM_NAR;
    public static final int BAND_AM_JP;
    public static final int BAND_AM_EU;
    public static final int BAND_AM_AUS;
    public static final int BAND_DAB1_OFF;
    public static final int BAND_DAB1_EU_BAND_III_N;
    public static final int BAND_DAB1_EU_BAND_III;
    public static final int BAND_DAB1_CANADA_L_BAND;
    public static final int BAND_DAB1_KOREA_BAND_III;
    public static final int BAND_DAB1_CHINA_BAND_III;
    public static final int BAND_DAB1_NEW_ZEALAND_BAND_III;
    public static final int BAND_DAB1_DOWNLOAD_TABLE_1;
    public static final int BAND_DAB2_OFF;
    public static final int BAND_DAB2_L_BAND;
    public static final int BAND_DAB2_DOWNLOAD_TABLE_2;
    public static final int SOUND_NO_ALLOC;
    public static final int SOUND_INTERN;
    public static final int SOUND_EXTERN;
    public static final int SOUND_EXTERN_BAP;
    public static final int ANTENNA_DIAGNOSTICS_1;
    public static final int ANTENNA_DIAGNOSTICS_2;
    public static final int AF_PERSISTENT;
    public static final int AF_TEMPORARY;
    public static final int BWS_NO;
    public static final int BWS_RESTRICTED;
    public static final int BWS_UNRESTRICTED;
    public static final int BWS_RESTRICTED_UNRESTRICTED;
    public static final int BT_VISIBILITY_OFF;
    public static final int BT_VISIBILITY_AUTO;
    public static final int BT_VISIBILITY_ON;
    public static final int SKIN_NO_SKIN;
    public static final int SKIN_1;
    public static final int SKIN_2;
    public static final int SKIN_3;
    public static final int SCREEN_NO_SCREEN;
    public static final int SCREEN_1;
    public static final int SCREEN_2;
    public static final int SCREEN_3;
    public static final int SCREEN_4;
    public static final int SCREEN_5;
    public static final int SCREEN_6;
    public static final int SCREEN_7;
    public static final int SCREEN_8;
    public static final int SCREEN_N;
    public static final int SAS_LEFT_HAND_DRIVE;
    public static final int SAS_RIGHT_HAND_DRIVE;
    public static final int KTS_INFO_NOT_AVAILABLE;
    public static final int KTS_INFO_LONG_INFO;
    public static final int KTS_INFO_SHORT_INFO;
    public static final int USB_OFF;
    public static final int USB_CHARGE;
    public static final int USB_FULL;
    public static final int USB_IPOD;
    public static final int DGV_MOST;
    public static final int DGV_CAN;

    default public byte getCarBrand() {
    }

    default public byte getCarClass() {
    }

    default public byte getCarGeneration() {
    }

    default public byte getCarDerivate() {
    }

    default public byte getCarDerivateSupplement() {
    }

    default public int getCountry() {
    }

    default public boolean isSpeakerChannelInstalledHT(int n) {
    }

    default public boolean isSpeakerChannelInstalledTT(int n) {
    }

    default public boolean isMicrophoneConnected(int n) {
    }

    default public boolean isHeadphoneOutputActive(int n) {
    }

    default public boolean isAuxInOn() {
    }

    default public boolean isAmiOn() {
    }

    default public boolean isVdaNfInOn() {
    }

    default public byte getFmBandsetting() {
    }

    default public byte getAmBandsetting() {
    }

    default public byte getDab1Bandsetting() {
    }

    default public byte getDab2Bandsetting() {
    }

    default public int getSoundSystem() {
    }

    default public boolean isSecondFmAntennaAvailable() {
    }

    default public int getExtendedAntennaDiagnosticsFmDab() {
    }

    default public boolean isRdsOverHmiActivated() {
    }

    default public int getAfMode() {
    }

    default public boolean isHdActivated() {
    }

    default public boolean isRadioTextPlusActivated() {
    }

    default public boolean isPiActivated() {
    }

    default public byte getBwsProfile() {
    }

    default public boolean isDabAlarmAnnouncementActivated() {
    }

    default public boolean isFmPty31AlarmOn() {
    }

    default public boolean isAmDisabled() {
    }

    default public boolean isMultiChannelReception() {
    }

    default public boolean isMultipleEntry() {
    }

    default public boolean isRdsDeactivated() {
    }

    default public boolean isAfDeactivated() {
    }

    default public boolean isDiagnosticBaseplateInstalled() {
    }

    default public boolean isAntennaAtBaseplateInstalled() {
    }

    default public boolean isCradleForce() {
    }

    default public boolean isHandyCradleForce() {
    }

    default public boolean isPhoneNadOn() {
    }

    default public boolean isBluetoothAvailable() {
    }

    default public boolean isBluetoothMultimediaFuncAvailable() {
    }

    default public boolean isBluetoothPhoneAvailable() {
    }

    default public boolean isBluetoothAudioAvailable() {
    }

    default public byte getBluetoothVisibility() {
    }

    default public boolean isMessagingAvailable() {
    }

    default public int getSkin() {
    }

    default public int getScreen() {
    }

    default public boolean isLogBookDisplayed() {
    }

    default public byte getDriverSide() {
    }

    default public byte getKombiTrackStationInfo() {
    }

    default public boolean isRearViewLowActive() {
    }

    default public boolean isMostOn() {
    }

    default public int getUsbConfiguration() {
    }

    default public boolean isDisplayConnected(int n) {
    }

    default public int getBusHandling() {
    }

    default public boolean isScrollingActivated() {
    }

    default public boolean isMessagingViaMapActivated() {
    }

    default public boolean isPagewiseScrollingActivated() {
    }

    default public int getDashboardGraphicVariant() {
    }

    default public boolean isDashboardTextReplacementActivated() {
    }

    default public boolean isSpellerOn() {
    }

    default public boolean isInitialDisclaimerOn() {
    }

    default public boolean isLegalDisclaimerOn() {
    }

    default public boolean isEmergencyCallOn() {
    }

    default public boolean isVoiceControlSystemActive() {
    }

    default public boolean isNavigationActive() {
    }

    default public boolean isWlanModuleActive() {
    }

    default public boolean isImportMediaDataActive() {
    }

    default public boolean isRippingMediaDataActive() {
    }

    default public boolean isTrafficSignDisplayActive() {
    }

    default public boolean isPsdActive() {
    }

    default public boolean isBaseplateErrorFlag() {
    }
}

