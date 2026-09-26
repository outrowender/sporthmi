/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.config.carcoding;

import de.audi.atip.config.carcoding.BitHelper;
import de.audi.atip.sysapp.carcoding.Coding;
import de.esolutions.fw.util.commons.Buffer;

public final class CodingImpl
implements Coding {
    private static byte[] codingData;

    public CodingImpl(byte[] byArray) {
        codingData = byArray;
    }

    @Override
    public byte getCarBrand() {
        return BitHelper.getBitsFromByte(codingData[0], 0, 3);
    }

    @Override
    public byte getCarClass() {
        byte by = BitHelper.getBitsFromByte(codingData[1], 0, 3);
        if (by >= 0 && by <= 9) {
            return by;
        }
        return 0;
    }

    @Override
    public byte getCarGeneration() {
        byte by = BitHelper.getBitsFromByte(codingData[1], 4, 7);
        if (by >= 0 && by <= 9) {
            return by;
        }
        return 0;
    }

    @Override
    public byte getCarDerivate() {
        byte by = BitHelper.getBitsFromByte(codingData[2], 0, 3);
        if (by >= 0 && by <= 9) {
            return by;
        }
        return 0;
    }

    @Override
    public byte getCarDerivateSupplement() {
        byte by = BitHelper.getBitsFromByte(codingData[2], 4, 7);
        if (by >= 0 && by <= 9) {
            return by;
        }
        return 0;
    }

    @Override
    public int getCountry() {
        int n = BitHelper.unsignedByteToInt(codingData[3]);
        if (n >= 0 && n <= 17) {
            return n;
        }
        return 0;
    }

    @Override
    public boolean isSpeakerChannelInstalledHT(int n) {
        switch (n) {
            case 0: {
                return this.getBoolean(4, 0, false);
            }
            case 1: {
                return this.getBoolean(4, 2, false);
            }
            case 2: {
                return this.getBoolean(4, 4, false);
            }
            case 3: {
                return this.getBoolean(4, 6, false);
            }
            case 4: {
                return this.getBoolean(5, 0, false);
            }
            case 5: {
                return this.getBoolean(5, 2, false);
            }
            case 6: {
                return this.getBoolean(5, 4, false);
            }
            case 7: {
                return this.getBoolean(5, 6, false);
            }
            case 8: {
                return this.getBoolean(6, 0, false);
            }
            case 9: {
                return this.getBoolean(6, 2, false);
            }
            case 10: {
                return this.getBoolean(6, 4, false);
            }
            case 11: {
                return this.getBoolean(6, 6, false);
            }
            case 12: {
                return this.getBoolean(7, 0, false);
            }
            case 13: {
                return this.getBoolean(7, 2, false);
            }
            case 14: {
                return this.getBoolean(7, 4, false);
            }
            case 15: {
                return this.getBoolean(7, 6, false);
            }
        }
        return false;
    }

    @Override
    public boolean isSpeakerChannelInstalledTT(int n) {
        switch (n) {
            case 0: {
                return this.getBoolean(4, 1, false);
            }
            case 1: {
                return this.getBoolean(4, 3, false);
            }
            case 2: {
                return this.getBoolean(4, 5, false);
            }
            case 3: {
                return this.getBoolean(4, 7, false);
            }
            case 4: {
                return this.getBoolean(5, 1, false);
            }
            case 5: {
                return this.getBoolean(5, 3, false);
            }
            case 6: {
                return this.getBoolean(5, 5, false);
            }
            case 7: {
                return this.getBoolean(5, 7, false);
            }
            case 8: {
                return this.getBoolean(6, 1, false);
            }
            case 9: {
                return this.getBoolean(6, 3, false);
            }
            case 10: {
                return this.getBoolean(6, 5, false);
            }
            case 11: {
                return this.getBoolean(6, 7, false);
            }
            case 12: {
                return this.getBoolean(7, 1, false);
            }
            case 13: {
                return this.getBoolean(7, 3, false);
            }
            case 14: {
                return this.getBoolean(7, 5, false);
            }
            case 15: {
                return this.getBoolean(7, 7, false);
            }
        }
        return false;
    }

    @Override
    public boolean isMicrophoneConnected(int n) {
        switch (n) {
            case 0: {
                return this.getBoolean(8, 0, false);
            }
            case 1: {
                return this.getBoolean(8, 1, false);
            }
        }
        return false;
    }

    @Override
    public boolean isHeadphoneOutputActive(int n) {
        switch (n) {
            case 0: {
                return this.getBoolean(8, 2, false);
            }
            case 1: {
                return this.getBoolean(8, 3, false);
            }
        }
        return false;
    }

    @Override
    public boolean isAuxInOn() {
        return this.getBoolean(8, 4, false);
    }

    @Override
    public boolean isAmiOn() {
        return this.getBoolean(8, 5, false);
    }

    @Override
    public boolean isVdaNfInOn() {
        return this.getBoolean(8, 6, false);
    }

    @Override
    public byte getFmBandsetting() {
        byte by = BitHelper.getBitsFromByte(codingData[9], 0, 3);
        if (by >= 0 && by <= 5 || by == 8) {
            return by;
        }
        return 0;
    }

    @Override
    public byte getAmBandsetting() {
        byte by = BitHelper.getBitsFromByte(codingData[9], 4, 7);
        if (by >= 0 && by <= 5) {
            return by;
        }
        return 0;
    }

    @Override
    public byte getDab1Bandsetting() {
        byte by = BitHelper.getBitsFromByte(codingData[10], 0, 3);
        if (by >= 0 && by <= 7) {
            return by;
        }
        return 0;
    }

    @Override
    public byte getDab2Bandsetting() {
        byte by = BitHelper.getBitsFromByte(codingData[10], 4, 7);
        if (by >= 0 && by <= 2) {
            return by;
        }
        return 0;
    }

    @Override
    public int getSoundSystem() {
        int n = BitHelper.unsignedByteToInt(codingData[11]);
        if (n >= 0 && n <= 3) {
            return n;
        }
        return 0;
    }

    @Override
    public boolean isSecondFmAntennaAvailable() {
        return this.getBoolean(12, 0, false);
    }

    @Override
    public int getExtendedAntennaDiagnosticsFmDab() {
        byte by = BitHelper.getBitsFromByte(codingData[12], 1, 1);
        if (by >= 0 && by <= 1) {
            return by;
        }
        return 0;
    }

    @Override
    public boolean isRdsOverHmiActivated() {
        return this.getBoolean(13, 0, false);
    }

    @Override
    public int getAfMode() {
        return BitHelper.getBitsFromByte(codingData[13], 1, 1);
    }

    @Override
    public boolean isHdActivated() {
        return this.getBoolean(13, 2, false);
    }

    @Override
    public boolean isRadioTextPlusActivated() {
        return this.getBoolean(13, 3, false);
    }

    @Override
    public boolean isPiActivated() {
        return !this.getBoolean(13, 4, false);
    }

    @Override
    public byte getBwsProfile() {
        byte by = BitHelper.getBitsFromByte(codingData[13], 5, 6);
        if (by >= 0 && by <= 3) {
            return by;
        }
        return 0;
    }

    @Override
    public boolean isDabAlarmAnnouncementActivated() {
        return this.getBoolean(13, 7, false);
    }

    @Override
    public boolean isFmPty31AlarmOn() {
        return this.getBoolean(14, 0, false);
    }

    @Override
    public boolean isAmDisabled() {
        return this.getBoolean(14, 1, false);
    }

    @Override
    public boolean isMultiChannelReception() {
        return this.getBoolean(14, 2, false);
    }

    @Override
    public boolean isMultipleEntry() {
        return this.getBoolean(14, 3, false);
    }

    @Override
    public boolean isRdsDeactivated() {
        return this.getBoolean(14, 4, false);
    }

    @Override
    public boolean isAfDeactivated() {
        return this.getBoolean(14, 5, false);
    }

    @Override
    public boolean isDiagnosticBaseplateInstalled() {
        return this.getBoolean(15, 0, false);
    }

    @Override
    public boolean isAntennaAtBaseplateInstalled() {
        return this.getBoolean(15, 1, false);
    }

    @Override
    public boolean isCradleForce() {
        return this.getBoolean(15, 2, false);
    }

    @Override
    public boolean isHandyCradleForce() {
        return this.getBoolean(15, 3, false);
    }

    @Override
    public boolean isPhoneNadOn() {
        return this.getBoolean(15, 4, false);
    }

    @Override
    public boolean isBaseplateErrorFlag() {
        return this.getBoolean(15, 5, false);
    }

    @Override
    public boolean isBluetoothAvailable() {
        return this.getBoolean(16, 0, false);
    }

    @Override
    public boolean isBluetoothMultimediaFuncAvailable() {
        return this.getBoolean(16, 1, false);
    }

    @Override
    public boolean isBluetoothPhoneAvailable() {
        return this.getBoolean(16, 2, false);
    }

    @Override
    public boolean isBluetoothAudioAvailable() {
        return this.getBoolean(16, 3, false);
    }

    @Override
    public byte getBluetoothVisibility() {
        byte by = BitHelper.getBitsFromByte(codingData[16], 4, 5);
        if (by >= 0 && by <= 2) {
            return by;
        }
        return 0;
    }

    @Override
    public boolean isMessagingAvailable() {
        return this.getBoolean(21, 5, false);
    }

    @Override
    public int getSkin() {
        int n = BitHelper.unsignedByteToInt(codingData[17]);
        if (n >= 0 && n <= 3) {
            return n;
        }
        return 0;
    }

    @Override
    public int getScreen() {
        int n = BitHelper.unsignedByteToInt(codingData[18]);
        if (n >= 0 && n <= 9) {
            return n;
        }
        return 0;
    }

    @Override
    public boolean isLogBookDisplayed() {
        return this.getBoolean(19, 0, false);
    }

    @Override
    public byte getDriverSide() {
        byte by = BitHelper.getBitsFromByte(codingData[19], 1, 1);
        if (by >= 0 && by <= 1) {
            return by;
        }
        return 0;
    }

    @Override
    public byte getKombiTrackStationInfo() {
        byte by = BitHelper.getBitsFromByte(codingData[19], 2, 3);
        if (by >= 0 && by <= 2) {
            return by;
        }
        return 0;
    }

    @Override
    public boolean isRearViewLowActive() {
        return this.getBoolean(19, 4, false);
    }

    @Override
    public boolean isMostOn() {
        return this.getBoolean(19, 5, false);
    }

    @Override
    public int getUsbConfiguration() {
        byte by = BitHelper.getBitsFromByte(codingData[19], 6, 7);
        if (by >= 0 && by <= 3) {
            return by;
        }
        return 0;
    }

    @Override
    public boolean isDisplayConnected(int n) {
        switch (n) {
            case 0: {
                return this.getBoolean(20, 0, false);
            }
            case 1: {
                return this.getBoolean(20, 1, false);
            }
            case 2: {
                return this.getBoolean(20, 2, false);
            }
            case 3: {
                return this.getBoolean(20, 3, false);
            }
        }
        return false;
    }

    @Override
    public int getBusHandling() {
        return BitHelper.getBitsFromByte(codingData[21], 0, 3);
    }

    @Override
    public boolean isScrollingActivated() {
        return this.getBoolean(21, 4, false);
    }

    @Override
    public boolean isMessagingViaMapActivated() {
        return this.getBoolean(21, 5, false);
    }

    @Override
    public boolean isPagewiseScrollingActivated() {
        return this.getBoolean(21, 6, false);
    }

    @Override
    public int getDashboardGraphicVariant() {
        return BitHelper.getBitsFromByte(codingData[22], 0, 0);
    }

    @Override
    public boolean isDashboardTextReplacementActivated() {
        return this.getBoolean(22, 1, false);
    }

    @Override
    public boolean isSpellerOn() {
        return this.getBoolean(23, 0, false);
    }

    @Override
    public boolean isInitialDisclaimerOn() {
        return this.getBoolean(23, 1, false);
    }

    @Override
    public boolean isLegalDisclaimerOn() {
        return this.getBoolean(23, 2, false);
    }

    @Override
    public boolean isEmergencyCallOn() {
        return this.getBoolean(24, 0, false);
    }

    @Override
    public boolean isVoiceControlSystemActive() {
        return this.getBoolean(24, 1, false);
    }

    @Override
    public boolean isNavigationActive() {
        return this.getBoolean(24, 2, false);
    }

    @Override
    public boolean isWlanModuleActive() {
        return this.getBoolean(24, 3, false);
    }

    @Override
    public boolean isImportMediaDataActive() {
        return this.getBoolean(24, 4, false);
    }

    @Override
    public boolean isRippingMediaDataActive() {
        return this.getBoolean(24, 5, false);
    }

    @Override
    public boolean isTrafficSignDisplayActive() {
        return this.getBoolean(24, 6, false);
    }

    @Override
    public boolean isPsdActive() {
        return this.getBoolean(24, 7, false);
    }

    private boolean getBoolean(int n, int n2, boolean bl) {
        return BitHelper.testBit(codingData[n], n2);
    }

    public String toString() {
        Buffer buffer = new Buffer();
        if (codingData != null) {
            String string = "[ 0x";
            buffer.append("\n\nCarCodingData");
            for (int i2 = 0; i2 < codingData.length; ++i2) {
                buffer.append(string);
                buffer.append(Integer.toHexString(codingData[i2]));
                string = ", 0x";
            }
            buffer.append(" ]\n");
        }
        buffer.append("Marke = ").append(this.getCarBrand());
        buffer.append("\nFahrzeugKlasse = ").append(this.getCarClass());
        buffer.append("\nFahrzeugGeneration = ").append(this.getCarGeneration());
        buffer.append("\nFahrzeugDerivat = ").append(this.getCarDerivate());
        buffer.append("\nDriverSide = ").append(this.getDriverSide());
        buffer.append("\nCountry = ").append(this.getCountry());
        buffer.append("\nNavigation = ").append(this.isNavigationActive());
        buffer.append("\nBluetoothAvailable = ").append(this.isBluetoothAvailable());
        buffer.append("\nBluetoothAudioAvailable = ").append(this.isBluetoothAudioAvailable());
        buffer.append("\nBluetoothMultimediaFuncAvailable = ").append(this.isBluetoothMultimediaFuncAvailable());
        buffer.append("\nBluetoothPhoneAvailable = ").append(this.isBluetoothPhoneAvailable());
        buffer.append("\nPhoneNadOn = ").append(this.isPhoneNadOn());
        buffer.append("\nMessaging = ").append(this.isMessagingAvailable());
        buffer.append("\nKombiTrackStationInfo = ").append(this.getKombiTrackStationInfo());
        buffer.append("\n\n\t R A D I O codings");
        buffer.append("\nAM Tuner Band ").append(this.getAmBandsetting());
        buffer.append("\nDAB Tuner Band-1 ").append(this.getDab1Bandsetting());
        buffer.append("\nDAB Tuner Band-2 ").append(this.getDab2Bandsetting());
        buffer.append("\nSecond FM Antenna ").append(this.isSecondFmAntennaAvailable());
        buffer.append("\nRDS switch in HMI deactivated ").append(this.isRdsOverHmiActivated());
        buffer.append("\nAuto AF on ").append(this.getAfMode());
        buffer.append("\nSingle Pi Mode ").append(this.isPiActivated());
        buffer.append("\nRadioText+ ").append(this.isRadioTextPlusActivated());
        buffer.append("\nBWS profile ").append(this.getBwsProfile());
        buffer.append("\nDAB Alarm ").append(this.isDabAlarmAnnouncementActivated());
        buffer.append("\nFM PTY31 ").append(this.isFmPty31AlarmOn());
        buffer.append("\nAM disabled ").append(this.isAmDisabled());
        buffer.append("\nMulti Channes Reception ").append(this.isMultiChannelReception());
        buffer.append("\nMultible entries ").append(this.isMultipleEntry());
        buffer.append("\nRDS deactivated ").append(this.isRdsDeactivated());
        buffer.append("\nAF deactivated ").append(this.isAfDeactivated()).append('\n');
        buffer.append("\nisImportMediaDataActive ").append(this.isImportMediaDataActive());
        buffer.append("\nisRippingMediaDataActive ").append(this.isRippingMediaDataActive());
        buffer.append("\nisWlanModuleActive ").append(this.isWlanModuleActive());
        buffer.append("\nisTrafficSignDisplayActive ").append(this.isTrafficSignDisplayActive());
        buffer.append("\nisPsdActive ").append(this.isPsdActive());
        buffer.append("\nisBaseplateErrorFlag ").append(this.isBaseplateErrorFlag());
        buffer.append("\nisDiagnosticBaseplateInstalled ").append(this.isDiagnosticBaseplateInstalled());
        buffer.append("\nisAntennaAtBaseplateInstalled ").append(this.isAntennaAtBaseplateInstalled());
        return buffer.toString();
    }
}

