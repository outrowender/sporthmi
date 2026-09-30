/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.config.carcoding;

import de.audi.atip.config.carcoding.AbstractAdaptationImpl;
import de.audi.atip.config.carcoding.BitHelper;

public final class AdaptationImplHigh
extends AbstractAdaptationImpl {
    public AdaptationImplHigh(byte[] byArray, byte[] byArray2) {
        super(byArray, byArray2);
    }

    public boolean isTelephoneActivated() {
        int n = BitHelper.unsignedByteToInt(this.adaptationData[15]);
        if (n >= 0 && n <= 1) {
            return BitHelper.testBit(this.adaptationData[15], 0);
        }
        return false;
    }

    public boolean isVzaProOnAvailable() {
        return this.getBoolean(17, 0, false);
    }

    public boolean isOnlinePoiAvailable() {
        return this.getBoolean(17, 1, false);
    }

    public boolean isOnlinePoiVoiceAvailable() {
        return this.getBoolean(17, 2, false);
    }

    public boolean isOnlinePortalBrowserServicesAvailable() {
        return this.getBoolean(17, 3, false);
    }

    public boolean isOnlineNaviGoogleEarthAvailable() {
        return this.getBoolean(17, 4, false);
    }

    public boolean isOnlineStreetViewAvailable() {
        return this.getBoolean(17, 5, false);
    }

    public boolean isWiFiHotspotAvailable() {
        return this.getBoolean(17, 6, false);
    }

    public boolean isMyAudiAvailable() {
        return this.getBoolean(17, 7, false);
    }

    public boolean isPictureNaviAvailable() {
        return this.getBoolean(18, 0, false);
    }

    public boolean isOnlineDictationAvailable() {
        return this.getBoolean(18, 1, false);
    }

    public boolean isRemoteHmiAvailable() {
        return this.getBoolean(18, 2, false);
    }

    public boolean isAdvancedRangeDisplayAvailable() {
        return this.getBoolean(18, 3, false);
    }

    public boolean isGracenoteOnlineCoverartsAvailable() {
        return this.getBoolean(18, 4, false);
    }

    public boolean isGracenoteOnlineOtherAvailable() {
        return this.getBoolean(18, 5, false);
    }

    public boolean isGracenoteLocalCoverartsAvailable() {
        return this.getBoolean(18, 6, false);
    }

    public boolean isGracenoteLocalOtherAvailable() {
        return this.getBoolean(18, 7, false);
    }

    public boolean isUPnPAvailable() {
        return this.getBoolean(19, 0, false);
    }

    public boolean isOPSinDashboardAvailable() {
        return this.getBoolean(19, 1, false);
    }

    public boolean isSupports2ndPhone() {
        return this.getBoolean(19, 7, false);
    }

    public int getPayTmcSet() {
        int n = this.getByte(20, 0);
        int n2 = this.getByte(21, 0);
        int n3 = (n << 8) + n2;
        return n3;
    }

    public int getEmergencyCallPrivateMode() {
        return this.getByte(22, 255);
    }

    public boolean isSupportOfThreewayCalling() {
        return this.getBoolean(23, 0, false);
    }

    public boolean isDtmfWithoutActiveCall() {
        return this.getBoolean(23, 1, false);
    }

    public boolean isSupportForResponseAndHold() {
        return this.getBoolean(23, 2, false);
    }

    public boolean isSimCardModeSwitch() {
        return this.getBoolean(23, 3, false);
    }

    public boolean isPhoneModuleOperationModeWithVoice() {
        return !this.getBoolean(23, 4, false);
    }

    public boolean isOperatorCallAvailable() {
        return !this.getBoolean(24, 1, false);
    }

    public int getRadioDatabaseRegion() {
        return this.getByte(27, 0);
    }

    public int getNavMapTransmissionMode() {
        return this.getByte(34, 0);
    }

    public int getNavKDKTransmissionMode() {
        return this.getByte(37, 0);
    }

    public boolean isCoverartAvailable() {
        return this.getBoolean(40, 0, false);
    }

    public boolean isStationartAvailable() {
        return this.getBoolean(40, 1, false);
    }

    public boolean isCallPictureAvailable() {
        return this.getBoolean(40, 2, false);
    }

    public boolean isFastMOSTListAvailable() {
        return this.getBoolean(40, 3, false);
    }

    public boolean isTpegAvailable() {
        return this.getBoolean(43, 0, false);
    }

    public boolean isVzoAvailable() {
        return this.getBoolean(43, 1, false);
    }

    public boolean isLGIAvailable() {
        return this.getBoolean(43, 2, false);
    }

    public boolean isProbeCarAvailable() {
        return this.getBoolean(43, 3, false);
    }

    public boolean isProbeCarLGIAvailable() {
        return this.getBoolean(43, 5, false);
    }

    public boolean isOnlineMediaAvailable() {
        return this.getBoolean(43, 4, false);
    }

    public boolean isGoogleGAL() {
        return this.getBoolean(43, 7, false);
    }

    public boolean isTVAvailable() {
        return this.getBoolean(46, 3, false);
    }

    public int getESIMUUsage() {
        return this.getByte(50, 1) & 3;
    }

    public boolean isAppleDIO() {
        return this.getBoolean(51, 0, false);
    }

    public boolean isBaiduCarLife() {
        return this.getBoolean(43, 6, false);
    }

    public boolean isUotAAvailable() {
        return this.getBoolean(51, 1, false);
    }

    public boolean isWLANClient() {
        return this.getBoolean(51, 2, false);
    }

    public boolean isSDISAvailable() {
        return !this.getBoolean(51, 3, false);
    }

    public boolean isBreakdownCallAvailable() {
        return !this.getBoolean(24, 2, false);
    }

    public boolean isPOICallAvailable() {
        return !this.getBoolean(24, 3, false);
    }

    public boolean isVehicleReadinessSoundAvailable() {
        return this.getBoolean(57, 0, false);
    }

    public boolean isVehicleLeavingSoundAvailable() {
        return this.getBoolean(57, 1, false);
    }

    public byte getPrimaryEngineType() {
        if (this.adaptationData.length > 60) {
            return BitHelper.getBitsFromByte(this.adaptationData[60], 0, 3);
        }
        return 15;
    }

    public byte getSecondaryEngineType() {
        if (this.adaptationData.length > 60) {
            return BitHelper.getBitsFromByte(this.adaptationData[60], 4, 7);
        }
        return 15;
    }

    public boolean isServiceDiscoveryAvailable() {
        return this.getBoolean(51, 4, false);
    }

    public int getMediaCountryCodeHmi() {
        int n = this.getByte(44, 45);
        int n2 = this.getByte(45, 45);
        return (n << 8) + n2;
    }

    public boolean isAllowMessageEditing() {
        return this.getBoolean(56, 7, false);
    }

    public boolean isPopupIfGpsIsInUse() {
        return this.getBoolean(68, 0, false);
    }

    public boolean isMobileDeviceKeyProfile() {
        return this.getBoolean2(16, 0, false);
    }
}

