/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.config.carcoding;

import de.audi.atip.config.carcoding.AbstractAdaptationImpl;

public final class AdaptationImplStandard
extends AbstractAdaptationImpl {
    public AdaptationImplStandard(byte[] byArray, byte[] byArray2) {
        super(byArray, byArray2);
    }

    public boolean isTelephoneActivated() {
        return false;
    }

    public int getPayTmcSet() {
        int n = this.getByte(17, 0);
        int n2 = this.getByte(18, 0);
        int n3 = (n << 8) + n2;
        return n3;
    }

    public boolean isVzaProOnAvailable() {
        return this.getBoolean(19, 0, false);
    }

    public boolean isOnlinePoiAvailable() {
        return this.getBoolean(19, 1, false);
    }

    public boolean isOnlinePoiVoiceAvailable() {
        return this.getBoolean(19, 2, false);
    }

    public boolean isOnlinePortalBrowserServicesAvailable() {
        return this.getBoolean(19, 3, false);
    }

    public boolean isOnlineNaviGoogleEarthAvailable() {
        return this.getBoolean(19, 4, false);
    }

    public boolean isOnlineStreetViewAvailable() {
        return this.getBoolean(19, 5, false);
    }

    public boolean isWiFiHotspotAvailable() {
        return this.getBoolean(19, 6, false);
    }

    public boolean isMyAudiAvailable() {
        return this.getBoolean(19, 7, false);
    }

    public boolean isPictureNaviAvailable() {
        return this.getBoolean(20, 0, false);
    }

    public boolean isOnlineDictationAvailable() {
        return this.getBoolean(20, 1, false);
    }

    public boolean isRemoteHmiAvailable() {
        return this.getBoolean(20, 2, false);
    }

    public boolean isAdvancedRangeDisplayAvailable() {
        return this.getBoolean(20, 3, false);
    }

    public boolean isGracenoteOnlineCoverartsAvailable() {
        return this.getBoolean(20, 4, false);
    }

    public boolean isGracenoteOnlineOtherAvailable() {
        return this.getBoolean(20, 5, false);
    }

    public boolean isGracenoteLocalCoverartsAvailable() {
        return this.getBoolean(20, 6, false);
    }

    public boolean isGracenoteLocalOtherAvailable() {
        return this.getBoolean(20, 7, false);
    }

    public boolean isUPnPAvailable() {
        return this.getBoolean(21, 0, false);
    }

    public boolean isOPSinDashboardAvailable() {
        return this.getBoolean(21, 1, false);
    }

    public boolean isSupports2ndPhone() {
        return this.getBoolean(21, 7, false);
    }

    public int getEmergencyCallPrivateMode() {
        return 255;
    }

    public boolean isSupportOfThreewayCalling() {
        return this.getBoolean(22, 0, false);
    }

    public boolean isDtmfWithoutActiveCall() {
        return this.getBoolean(22, 1, false);
    }

    public boolean isSupportForResponseAndHold() {
        return this.getBoolean(22, 2, false);
    }

    public boolean isSimCardModeSwitch() {
        return this.getBoolean(22, 3, false);
    }

    public boolean isPhoneModuleOperationModeWithVoice() {
        return !this.getBoolean(22, 4, false);
    }

    public int getRadioDatabaseRegion() {
        return this.getByte(26, 0);
    }

    public boolean isGoogleGAL() {
        return this.getBoolean(36, 0, false);
    }

    public boolean isAppleDIO() {
        return this.getBoolean(36, 1, false);
    }

    public boolean isBaiduCarLife() {
        return this.getBoolean(43, 6, false);
    }

    public boolean isSDISAvailable() {
        return false;
    }

    public boolean isOperatorCallAvailable() {
        return false;
    }

    public int getNavMapTransmissionMode() {
        return 0;
    }

    public int getNavKDKTransmissionMode() {
        return 0;
    }

    public boolean isCoverartAvailable() {
        return false;
    }

    public boolean isStationartAvailable() {
        return false;
    }

    public boolean isCallPictureAvailable() {
        return false;
    }

    public boolean isFastMOSTListAvailable() {
        return false;
    }

    public boolean isTpegAvailable() {
        return false;
    }

    public boolean isVzoAvailable() {
        return false;
    }

    public boolean isLGIAvailable() {
        return false;
    }

    public boolean isProbeCarAvailable() {
        return false;
    }

    public boolean isProbeCarLGIAvailable() {
        return false;
    }

    public boolean isOnlineMediaAvailable() {
        return false;
    }

    public boolean isTVAvailable() {
        return false;
    }

    public int getESIMUUsage() {
        return 1;
    }

    public boolean isUotAAvailable() {
        return false;
    }

    public boolean isWLANClient() {
        return false;
    }

    public boolean isBreakdownCallAvailable() {
        return false;
    }

    public boolean isPOICallAvailable() {
        return false;
    }

    public byte getPrimaryEngineType() {
        return 15;
    }

    public byte getSecondaryEngineType() {
        return 15;
    }

    public boolean isServiceDiscoveryAvailable() {
        return false;
    }

    public boolean isVehicleReadinessSoundAvailable() {
        return false;
    }

    public boolean isVehicleLeavingSoundAvailable() {
        return false;
    }

    public int getMediaCountryCodeHmi() {
        int n = this.getByte(33, 45);
        int n2 = this.getByte(34, 45);
        return (n << 8) + n2;
    }

    public boolean isAllowMessageEditing() {
        return false;
    }

    public boolean isPopupIfGpsIsInUse() {
        return this.getBoolean(43, 0, false);
    }

    public boolean isMobileDeviceKeyProfile() {
        return this.getBoolean2(16, 0, false);
    }
}

