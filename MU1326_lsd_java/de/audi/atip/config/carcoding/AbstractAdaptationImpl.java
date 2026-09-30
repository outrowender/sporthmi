/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.config.carcoding;

import de.audi.atip.config.carcoding.BitHelper;
import de.audi.atip.sysapp.carcoding.Adaptation;
import de.esolutions.fw.util.commons.Buffer;
import java.util.Arrays;

public abstract class AbstractAdaptationImpl
implements Adaptation {
    protected byte[] adaptationData;
    protected byte[] adaptation2Data;

    public AbstractAdaptationImpl(byte[] byArray, byte[] byArray2) {
        if (byArray == null || byArray2 == null) {
            throw new IllegalArgumentException("persisBytes must not be null!");
        }
        this.adaptationData = byArray;
        this.adaptation2Data = byArray2;
    }

    public int getPopupLanguageSelectionStatus() {
        int n = BitHelper.unsignedByteToInt(this.adaptationData[0]);
        if (n >= 0 && n <= 2) {
            return n;
        }
        return 1;
    }

    public int getTestmodeVideoSpeedCutoffLimit() {
        return BitHelper.unsignedByteToInt(this.adaptationData[1]);
    }

    public boolean isExternalMediumActivated() {
        return this.getBoolean(2, 0, false);
    }

    public boolean isOpticalMediumActivated() {
        return this.getBoolean(2, 1, false);
    }

    public boolean isResetToZeroValid(short s) {
        boolean bl = false;
        switch (s) {
            case 0: {
                bl = this.getBoolean(3, 0, false);
                break;
            }
            case 1: {
                bl = this.getBoolean(3, 1, false);
                break;
            }
            case 2: {
                bl = this.getBoolean(3, 2, false);
                break;
            }
            case 3: {
                bl = this.getBoolean(3, 3, false);
                break;
            }
            case 4: {
                bl = this.getBoolean(3, 4, false);
                break;
            }
            case 5: {
                bl = this.getBoolean(3, 5, false);
                break;
            }
            case 6: {
                bl = this.getBoolean(3, 6, false);
                break;
            }
            case 7: {
                bl = this.getBoolean(3, 7, false);
                break;
            }
            case 8: {
                bl = this.getBoolean(4, 0, false);
                break;
            }
            case 9: {
                bl = this.getBoolean(4, 1, false);
                break;
            }
            case 10: {
                bl = this.getBoolean(4, 2, false);
                break;
            }
            case 11: {
                bl = this.getBoolean(4, 3, false);
                break;
            }
            case 12: {
                bl = this.getBoolean(4, 4, false);
                break;
            }
            case 13: {
                bl = this.getBoolean(4, 5, false);
                break;
            }
            case 14: {
                bl = this.getBoolean(4, 6, false);
                break;
            }
            case 15: {
                bl = this.getBoolean(4, 7, false);
                break;
            }
            case 16: {
                bl = this.getBoolean(5, 0, false);
                break;
            }
        }
        return bl;
    }

    public int getBluetoothDeactivationState() {
        int[] nArray = new int[]{0, 1, 255};
        int n = BitHelper.unsignedByteToInt(this.adaptationData[6]);
        if (Arrays.binarySearch(nArray, n) < 0) {
            return 1;
        }
        return n;
    }

    public boolean isBluetoothSniffModeActivated() {
        int n = BitHelper.unsignedByteToInt(this.adaptationData[7]);
        if (n >= 0 && n <= 1) {
            return BitHelper.testBit(this.adaptationData[7], 0);
        }
        return false;
    }

    public int getBluetoothVisibility() {
        int[] nArray = new int[]{0, 1, 2, 3};
        int n = BitHelper.unsignedByteToInt(this.adaptationData[8]);
        if (Arrays.binarySearch(nArray, n) < 0) {
            return 2;
        }
        return n;
    }

    public int getDvdRegionCode() {
        int n = BitHelper.unsignedByteToInt(this.adaptationData[9]);
        if (n >= 0 && n <= 8) {
            return n;
        }
        return 2;
    }

    public int getBlueRaySystemRegionCode() {
        int n = BitHelper.unsignedByteToInt(this.adaptationData[10]);
        if (n >= 0 && n <= 3) {
            return n;
        }
        return 2;
    }

    public boolean isCdEjectButtonBlocked() {
        int n = BitHelper.unsignedByteToInt(this.adaptationData[11]);
        if (n >= 0 && n <= 1) {
            return BitHelper.testBit(this.adaptationData[11], 0);
        }
        return false;
    }

    public boolean isDeveloperTestModeActivated() {
        int n = BitHelper.unsignedByteToInt(this.adaptationData[12]);
        if (n >= 0 && n <= 1) {
            boolean bl = BitHelper.testBit(this.adaptationData[12], 0);
            return bl;
        }
        return false;
    }

    public int getEmergencyEstablishLinkAttempts() {
        return BitHelper.unsignedByteToInt(this.adaptationData[13]);
    }

    public int getSummerTimeShiftMethod() {
        int n = BitHelper.unsignedByteToInt(this.adaptationData[14]);
        if (n >= 0 && n <= 3) {
            return n;
        }
        return 0;
    }

    public boolean isWlanModuleActivated() {
        int n = BitHelper.unsignedByteToInt(this.adaptationData[16]);
        if (n >= 0 && n <= 1) {
            return BitHelper.testBit(this.adaptationData[16], 0);
        }
        return false;
    }

    public boolean isPayTmcSetOnlineTrafficAvailable() {
        int n = this.getPayTmcSet();
        switch (n) {
            case 32768: 
            case 32769: 
            case 32770: 
            case 32771: 
            case 32772: 
            case 32773: 
            case 32774: 
            case 32775: 
            case 32776: 
            case 32777: 
            case 32778: 
            case 32779: 
            case 32780: 
            case 32781: 
            case 32782: 
            case 32783: 
            case 32784: 
            case 32785: 
            case 32786: 
            case 32787: 
            case 32788: 
            case 32789: 
            case 32790: 
            case 32793: 
            case 33791: 
            case 33792: 
            case 33793: 
            case 34048: 
            case 34049: 
            case 34304: 
            case 34305: 
            case 34306: 
            case 65533: {
                return true;
            }
        }
        return false;
    }

    public boolean isPayTmcSetTrafficAvailable() {
        int n = this.getPayTmcSet();
        return n != 65534 && n != 65535;
    }

    protected boolean getBoolean(int n, int n2, boolean bl) {
        if (n < this.adaptationData.length) {
            return BitHelper.testBit(this.adaptationData[n], n2);
        }
        return bl;
    }

    protected boolean getBoolean2(int n, int n2, boolean bl) {
        if (n < this.adaptation2Data.length) {
            return BitHelper.testBit(this.adaptation2Data[n], n2);
        }
        return bl;
    }

    protected int getByte(int n, int n2) {
        if (n < this.adaptationData.length) {
            return BitHelper.unsignedByteToInt(this.adaptationData[n]);
        }
        return n2;
    }

    protected int getByte2(int n, int n2) {
        if (n < this.adaptation2Data.length) {
            return BitHelper.unsignedByteToInt(this.adaptation2Data[n]);
        }
        return n2;
    }

    public String toString() {
        int n;
        Buffer buffer = new Buffer();
        String string = "[ 0x";
        buffer.append("\n\nAdaptationData");
        for (n = 0; n < this.adaptationData.length; ++n) {
            buffer.append(string);
            buffer.append(Integer.toHexString(this.adaptationData[n]));
            string = ", 0x";
        }
        buffer.append(" ]\n");
        buffer.append("\n\nAdaptation2Data");
        for (n = 0; n < this.adaptation2Data.length; ++n) {
            buffer.append(string);
            buffer.append(Integer.toHexString(this.adaptation2Data[n]));
            string = ", 0x";
        }
        buffer.append(" ]\n");
        buffer.append("BlueRay system region code: ").append(this.getBlueRaySystemRegionCode());
        buffer.append("\nBluetooth deactivation state: ").append(this.getBluetoothDeactivationState());
        buffer.append("\nDVD regioncode: ").append(this.getDvdRegionCode());
        buffer.append("\nEmergency linkattempts: ").append(this.getEmergencyEstablishLinkAttempts());
        buffer.append("\nSummer time shift method: ").append(this.getSummerTimeShiftMethod());
        buffer.append("\nTestmode video speedcutoff limit: ").append(this.getTestmodeVideoSpeedCutoffLimit());
        buffer.append("\nBluetooth sniff mode activated: ").append(this.isBluetoothSniffModeActivated());
        buffer.append("\nCD eject button blocked: ").append(this.isCdEjectButtonBlocked());
        buffer.append("\nDeveloper test mode activated: ").append(this.isDeveloperTestModeActivated());
        buffer.append("\nExternal medium activated: ").append(this.isExternalMediumActivated());
        buffer.append("\nOptical medium activated: ").append(this.isOpticalMediumActivated());
        buffer.append("\nisWlanModule: ").append(this.isWlanModuleActivated());
        buffer.append("\nisTelephone: ").append(this.isTelephoneActivated());
        buffer.append("\nisVzaProOn: ").append(this.isVzaProOnAvailable());
        buffer.append("\nisOnlinePoi: ").append(this.isOnlinePoiAvailable());
        buffer.append("\nisOnlinePoiVoice: ").append(this.isOnlinePoiVoiceAvailable());
        buffer.append("\nOnlinePortalBrowserService: ").append(this.isOnlinePortalBrowserServicesAvailable());
        buffer.append("\nOnlineNaviGoogleEarth: ").append(this.isOnlineNaviGoogleEarthAvailable());
        buffer.append("\nOnlineStreetView: ").append(this.isOnlineStreetViewAvailable());
        buffer.append("\nWiFiHotspot: ").append(this.isWiFiHotspotAvailable());
        buffer.append("\nMyAudi: ").append(this.isMyAudiAvailable());
        buffer.append("\nPictureNavi: ").append(this.isPictureNaviAvailable());
        buffer.append("\nOnlineDictation: ").append(this.isOnlineDictationAvailable());
        buffer.append("\nRemoteHmi: ").append(this.isRemoteHmiAvailable());
        buffer.append("\nAdvancedRangeDisplay: ").append(this.isAdvancedRangeDisplayAvailable());
        buffer.append("\nGracenoteOnlineCoverarts: ").append(this.isGracenoteOnlineCoverartsAvailable());
        buffer.append("\nGracenoteOnlineOther: ").append(this.isGracenoteOnlineOtherAvailable());
        buffer.append("\nGracenoteLocalCoverarts: ").append(this.isGracenoteLocalCoverartsAvailable());
        buffer.append("\nGracenoteLocalOther: ").append(this.isGracenoteLocalOtherAvailable());
        buffer.append("\nUPnPAvailable: ").append(this.isUPnPAvailable());
        buffer.append("\nNavMapTransmissionMode: ").append(this.getNavMapTransmissionMode());
        buffer.append("\nNavKDKTransmissionMode: ").append(this.getNavKDKTransmissionMode());
        buffer.append("\nCallCenter Function available: ").append(this.isOperatorCallAvailable());
        buffer.append("\nCoverart available: ").append(this.isCoverartAvailable());
        buffer.append("\nStationart available: ").append(this.isStationartAvailable());
        buffer.append("\nCallPicture available: ").append(this.isCallPictureAvailable());
        buffer.append("\nFastMOSTList available: ").append(this.isFastMOSTListAvailable());
        buffer.append("\nTpeg available: ").append(this.isTpegAvailable());
        buffer.append("\nOnlineMedia available: ").append(this.isOnlineMediaAvailable());
        buffer.append("\nUpdateOverTheAir available: ").append(this.isUotAAvailable());
        buffer.append("\nSupports2ndPhone available: ").append(this.isSupports2ndPhone());
        buffer.append("\nBreakDown Call available: ").append(this.isBreakdownCallAvailable());
        buffer.append("\nPOI Call available: ").append(this.isPOICallAvailable());
        buffer.append("\nPrimary Engine Type: ").append(this.getPrimaryEngineType());
        buffer.append("\nSecondary Engine Type: ").append(this.getSecondaryEngineType());
        buffer.append("\nService Discovery available: ").append(this.isServiceDiscoveryAvailable());
        buffer.append("\nVzo available: ").append(this.isVzoAvailable());
        buffer.append("\nLGI available: ").append(this.isLGIAvailable());
        buffer.append("\nProbe Car available: ").append(this.isProbeCarAvailable());
        buffer.append("\nProbe Car LGI available: ").append(this.isProbeCarLGIAvailable());
        buffer.append("\nVehicle readiness sound available: ").append(this.isVehicleReadinessSoundAvailable());
        buffer.append("\nVehicle leaving sound available: ").append(this.isVehicleLeavingSoundAvailable());
        buffer.append("\nMedia Country Code Hmi: ").append(this.getMediaCountryCodeHmi());
        buffer.append("\nallowMessageEditing: ").append(this.isAllowMessageEditing());
        buffer.append("\nisPopupIfGpsIsInUse: ").append(this.isPopupIfGpsIsInUse());
        buffer.append("\n--------------------");
        buffer.append("\nisMobileDeviceKeyProfile: ").append(this.isMobileDeviceKeyProfile());
        return buffer.toString();
    }

    public abstract boolean isTelephoneActivated();

    public abstract int getPayTmcSet();

    public abstract boolean isVzaProOnAvailable();

    public abstract boolean isOnlinePoiAvailable();

    public abstract boolean isOnlinePoiVoiceAvailable();

    public abstract boolean isOnlinePortalBrowserServicesAvailable();

    public abstract boolean isOnlineNaviGoogleEarthAvailable();

    public abstract boolean isOnlineStreetViewAvailable();

    public abstract boolean isWiFiHotspotAvailable();

    public abstract boolean isMyAudiAvailable();

    public abstract boolean isPictureNaviAvailable();

    public abstract boolean isOnlineDictationAvailable();

    public abstract boolean isRemoteHmiAvailable();

    public abstract boolean isAdvancedRangeDisplayAvailable();

    public abstract boolean isGracenoteOnlineCoverartsAvailable();

    public abstract boolean isGracenoteOnlineOtherAvailable();

    public abstract boolean isGracenoteLocalCoverartsAvailable();

    public abstract boolean isGracenoteLocalOtherAvailable();

    public abstract boolean isUPnPAvailable();

    public abstract boolean isOPSinDashboardAvailable();

    public abstract boolean isSupports2ndPhone();

    public abstract boolean isSupportOfThreewayCalling();

    public abstract boolean isDtmfWithoutActiveCall();

    public abstract boolean isSupportForResponseAndHold();

    public abstract boolean isSimCardModeSwitch();

    public abstract boolean isPhoneModuleOperationModeWithVoice();

    public abstract int getEmergencyCallPrivateMode();

    public abstract boolean isAppleDIO();

    public abstract boolean isSDISAvailable();

    public abstract boolean isGoogleGAL();

    public abstract boolean isOperatorCallAvailable();

    public abstract int getRadioDatabaseRegion();

    public abstract int getNavMapTransmissionMode();

    public abstract boolean isCoverartAvailable();

    public abstract boolean isStationartAvailable();

    public abstract boolean isCallPictureAvailable();

    public abstract boolean isFastMOSTListAvailable();

    public abstract boolean isTpegAvailable();

    public abstract boolean isOnlineMediaAvailable();

    public abstract boolean isTVAvailable();

    public abstract int getESIMUUsage();

    public abstract boolean isUotAAvailable();

    public abstract boolean isWLANClient();

    public abstract int getNavKDKTransmissionMode();

    public abstract boolean isBreakdownCallAvailable();

    public abstract boolean isPOICallAvailable();

    public abstract byte getPrimaryEngineType();

    public abstract byte getSecondaryEngineType();

    public abstract boolean isServiceDiscoveryAvailable();

    public abstract boolean isVzoAvailable();

    public abstract boolean isLGIAvailable();

    public abstract boolean isProbeCarAvailable();

    public abstract boolean isProbeCarLGIAvailable();

    public abstract boolean isVehicleReadinessSoundAvailable();

    public abstract boolean isVehicleLeavingSoundAvailable();

    public abstract int getMediaCountryCodeHmi();

    public abstract boolean isAllowMessageEditing();

    public abstract boolean isPopupIfGpsIsInUse();

    public abstract boolean isMobileDeviceKeyProfile();
}

