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

    @Override
    public boolean isTelephoneActivated() {
        return false;
    }

    @Override
    public int getPayTmcSet() {
        int n = this.getByte(17, 0);
        int n2 = this.getByte(18, 0);
        int n3 = (n << 8) + n2;
        return n3;
    }

    @Override
    public boolean isVzaProOnAvailable() {
        return this.getBoolean(19, 0, false);
    }

    @Override
    public boolean isOnlinePoiAvailable() {
        return this.getBoolean(19, 1, false);
    }

    @Override
    public boolean isOnlinePoiVoiceAvailable() {
        return this.getBoolean(19, 2, false);
    }

    @Override
    public boolean isOnlinePortalBrowserServicesAvailable() {
        return this.getBoolean(19, 3, false);
    }

    @Override
    public boolean isOnlineNaviGoogleEarthAvailable() {
        return this.getBoolean(19, 4, false);
    }

    @Override
    public boolean isOnlineStreetViewAvailable() {
        return this.getBoolean(19, 5, false);
    }

    @Override
    public boolean isWiFiHotspotAvailable() {
        return this.getBoolean(19, 6, false);
    }

    @Override
    public boolean isMyAudiAvailable() {
        return this.getBoolean(19, 7, false);
    }

    @Override
    public boolean isPictureNaviAvailable() {
        return this.getBoolean(20, 0, false);
    }

    @Override
    public boolean isOnlineDictationAvailable() {
        return this.getBoolean(20, 1, false);
    }

    @Override
    public boolean isRemoteHmiAvailable() {
        return this.getBoolean(20, 2, false);
    }

    @Override
    public boolean isAdvancedRangeDisplayAvailable() {
        return this.getBoolean(20, 3, false);
    }

    @Override
    public boolean isGracenoteOnlineCoverartsAvailable() {
        return this.getBoolean(20, 4, false);
    }

    @Override
    public boolean isGracenoteOnlineOtherAvailable() {
        return this.getBoolean(20, 5, false);
    }

    @Override
    public boolean isGracenoteLocalCoverartsAvailable() {
        return this.getBoolean(20, 6, false);
    }

    @Override
    public boolean isGracenoteLocalOtherAvailable() {
        return this.getBoolean(20, 7, false);
    }

    @Override
    public boolean isUPnPAvailable() {
        return this.getBoolean(21, 0, false);
    }

    @Override
    public boolean isOPSinDashboardAvailable() {
        return this.getBoolean(21, 1, false);
    }

    @Override
    public boolean isSupports2ndPhone() {
        return this.getBoolean(21, 7, false);
    }

    @Override
    public int getEmergencyCallPrivateMode() {
        return 255;
    }

    @Override
    public boolean isSupportOfThreewayCalling() {
        return this.getBoolean(22, 0, false);
    }

    @Override
    public boolean isDtmfWithoutActiveCall() {
        return this.getBoolean(22, 1, false);
    }

    @Override
    public boolean isSupportForResponseAndHold() {
        return this.getBoolean(22, 2, false);
    }

    @Override
    public boolean isSimCardModeSwitch() {
        return this.getBoolean(22, 3, false);
    }

    @Override
    public boolean isPhoneModuleOperationModeWithVoice() {
        return !this.getBoolean(22, 4, false);
    }

    @Override
    public int getRadioDatabaseRegion() {
        return this.getByte(26, 0);
    }

    @Override
    public boolean isGoogleGAL() {
        return this.getBoolean(36, 0, false);
    }

    @Override
    public boolean isAppleDIO() {
        return this.getBoolean(36, 1, false);
    }

    @Override
    public boolean isBaiduCarLife() {
        return this.getBoolean(43, 6, false);
    }

    @Override
    public boolean isSDISAvailable() {
        return false;
    }

    @Override
    public boolean isOperatorCallAvailable() {
        return false;
    }

    @Override
    public int getNavMapTransmissionMode() {
        return 0;
    }

    @Override
    public int getNavKDKTransmissionMode() {
        return 0;
    }

    @Override
    public boolean isCoverartAvailable() {
        return false;
    }

    @Override
    public boolean isStationartAvailable() {
        return false;
    }

    @Override
    public boolean isCallPictureAvailable() {
        return false;
    }

    @Override
    public boolean isFastMOSTListAvailable() {
        return false;
    }

    @Override
    public boolean isTpegAvailable() {
        return false;
    }

    @Override
    public boolean isVzoAvailable() {
        return false;
    }

    @Override
    public boolean isLGIAvailable() {
        return false;
    }

    @Override
    public boolean isProbeCarAvailable() {
        return false;
    }

    @Override
    public boolean isProbeCarLGIAvailable() {
        return false;
    }

    @Override
    public boolean isOnlineMediaAvailable() {
        return false;
    }

    @Override
    public boolean isTVAvailable() {
        return false;
    }

    @Override
    public int getESIMUUsage() {
        return 1;
    }

    @Override
    public boolean isUotAAvailable() {
        return false;
    }

    @Override
    public boolean isWLANClient() {
        return false;
    }

    @Override
    public boolean isBreakdownCallAvailable() {
        return false;
    }

    @Override
    public boolean isPOICallAvailable() {
        return false;
    }

    @Override
    public byte getPrimaryEngineType() {
        return 15;
    }

    @Override
    public byte getSecondaryEngineType() {
        return 15;
    }

    @Override
    public boolean isServiceDiscoveryAvailable() {
        return false;
    }

    @Override
    public boolean isVehicleReadinessSoundAvailable() {
        return false;
    }

    @Override
    public boolean isVehicleLeavingSoundAvailable() {
        return false;
    }

    @Override
    public int getMediaCountryCodeHmi() {
        int n = this.getByte(33, 45);
        int n2 = this.getByte(34, 45);
        return (n << 8) + n2;
    }

    @Override
    public boolean isAllowMessageEditing() {
        return false;
    }

    @Override
    public boolean isPopupIfGpsIsInUse() {
        return this.getBoolean(43, 0, false);
    }

    @Override
    public boolean isMobileDeviceKeyProfile() {
        return this.getBoolean2(16, 0, false);
    }
}

