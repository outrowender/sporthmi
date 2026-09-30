/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.configuration;

import de.audi.app.media.configuration.IMediaConfiguration;
import de.audi.app.media.diagnosis.IDiagnosisDataProvider;
import de.audi.app.media.diagnosis.IDiagnosisManager;
import de.audi.app.media.logger.LogUtil;
import de.audi.atip.base.IFrameworkAccess;
import de.esolutions.fw.util.commons.Buffer;
import java.lang.reflect.Field;

public class MediaConfigurationImpl
implements IMediaConfiguration,
IDiagnosisDataProvider {
    private final boolean[] installedList = new boolean[14];
    private final boolean rippingEnabled;
    private final boolean fileImportEnabled;
    private final int lastModeSource;
    private final boolean audioIndepend;
    private final boolean importOverrideActive;
    private final boolean speedThresholdDisabled;
    private final boolean wlanSynchronizationDisabled;
    private final boolean btListHandlingSupported;
    private final boolean speedThresholdEnabledEver;
    private final boolean gracenoteEnabled;
    private final boolean gracenoteOnlineAvailable;
    private final boolean tvInMedia;
    private final boolean dvdVideoFormatSettingAvailable;
    private boolean iap2Supported;

    public MediaConfigurationImpl(IFrameworkAccess iFrameworkAccess, IDiagnosisManager iDiagnosisManager) {
        this.installedList[0] = true;
        this.installedList[1] = false;
        this.installedList[2] = iFrameworkAccess.getSysConst(501) == 1;
        this.installedList[3] = iFrameworkAccess.getSysConst(502) == 1;
        this.installedList[5] = true;
        this.installedList[10] = iFrameworkAccess.getSysConst(483) == 1;
        this.installedList[6] = iFrameworkAccess.getSysConst(503) == 1;
        this.installedList[9] = iFrameworkAccess.getSysConst(478) == 1;
        this.installedList[11] = iFrameworkAccess.getSysConst(480) == 1;
        this.installedList[12] = iFrameworkAccess.getSysConst(493) == 1;
        this.installedList[4] = iFrameworkAccess.isEvoHigh() || iFrameworkAccess.isPorscheHigh() || iFrameworkAccess.isBentley();
        this.installedList[13] = iFrameworkAccess.getSysConst(3967) == 1;
        this.installedList[7] = true;
        this.installedList[8] = true;
        this.overrideInstalledStateFromProperty(0, "media.config.cd");
        this.overrideInstalledStateFromProperty(1, "media.config.cdc");
        this.overrideInstalledStateFromProperty(2, "media.config.dvd");
        this.overrideInstalledStateFromProperty(3, "media.config.dvdc");
        this.overrideInstalledStateFromProperty(6, "media.config.hdd");
        this.overrideInstalledStateFromProperty(5, "media.config.sd");
        this.overrideInstalledStateFromProperty(9, "media.config.aux");
        this.overrideInstalledStateFromProperty(10, "media.config.usb");
        this.overrideInstalledStateFromProperty(11, "media.config.bt");
        this.overrideInstalledStateFromProperty(12, "media.config.wlan");
        this.overrideInstalledStateFromProperty(7, "media.config.tv");
        this.overrideInstalledStateFromProperty(8, "media.config.avin");
        this.overrideInstalledStateFromProperty(13, "media.config.online");
        this.rippingEnabled = iFrameworkAccess.getSysConst(482) == 1;
        this.fileImportEnabled = iFrameworkAccess.getSysConst(481) == 1;
        this.gracenoteOnlineAvailable = iFrameworkAccess.getSysConst(4042) == 1;
        this.gracenoteEnabled = iFrameworkAccess.getSysConst(4108) == 1 || this.gracenoteOnlineAvailable;
        this.audioIndepend = System.getProperty("media.audio.independ", "false").equals("true");
        this.speedThresholdDisabled = System.getProperty("media.video.disableSpeedthreshold", "false").equals("true");
        this.speedThresholdEnabledEver = System.getProperty("media.video.enableSpeedDisclaimer", "false").equals("true");
        this.importOverrideActive = System.getProperty("media.import.override", "true").equals("false");
        this.wlanSynchronizationDisabled = System.getProperty("media.config.wlan.disableSynchronization", "false").equals("true") || iFrameworkAccess.getSysConst(492) == 0;
        this.btListHandlingSupported = System.getProperty("media.config.bt.supportListHandling", "false").equals("true");
        int n = iFrameworkAccess.getSysConst(4168);
        this.tvInMedia = n == 1 || n == 5;
        this.dvdVideoFormatSettingAvailable = n == 1 || n == 5;
        int n2 = iFrameworkAccess.getSysConst(5572);
        this.iap2Supported = n2 == 2;
        String string = System.getProperty("media.config.lastmode", "");
        this.lastModeSource = string.length() > 0 ? (string.equalsIgnoreCase("TV") ? 7 : (string.equalsIgnoreCase("HDD") ? 6 : (string.equalsIgnoreCase("SD") ? 5 : (string.equalsIgnoreCase("DVD") ? 2 : (string.equalsIgnoreCase("CDC") ? 1 : (string.equalsIgnoreCase("DVDC") ? 3 : (string.equalsIgnoreCase("AUX") ? 9 : (string.equalsIgnoreCase("USB") ? 10 : (string.equalsIgnoreCase("AV") ? 8 : (string.equalsIgnoreCase("BT") ? 11 : (string.equalsIgnoreCase("WLAN") ? 12 : -1))))))))))) : -1;
        iDiagnosisManager.addDataProvider(-1, this);
    }

    private void overrideInstalledStateFromProperty(int n, String string) {
        String string2 = System.getProperty(string, "");
        if (string2.length() == 0) {
            return;
        }
        if (string2.equalsIgnoreCase("installed")) {
            this.installedList[n] = true;
        } else if (string2.equalsIgnoreCase("notinstalled")) {
            this.installedList[n] = false;
        }
    }

    public boolean isSourceInstalled(int n) {
        try {
            return this.installedList[n];
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            return false;
        }
    }

    public int getLastModeSource() {
        return this.lastModeSource;
    }

    public boolean isAudioIndepend() {
        return this.audioIndepend;
    }

    public boolean isRippingEnabled() {
        return this.rippingEnabled;
    }

    public boolean isImportEnabled() {
        return this.fileImportEnabled;
    }

    public boolean isImportOverrideActive() {
        return this.importOverrideActive;
    }

    public boolean isSpeedThresholdDisabled() {
        return this.speedThresholdDisabled;
    }

    public boolean isSpeedThresholdEnabledEver() {
        return this.speedThresholdEnabledEver;
    }

    public boolean isWLANStateSynchronizationDisabled() {
        return this.wlanSynchronizationDisabled;
    }

    public boolean isBluetoothListBrowsing() {
        return this.btListHandlingSupported;
    }

    public boolean isGracenoteEnabled() {
        return this.gracenoteEnabled;
    }

    public boolean isGracenoteOnlineAvailable() {
        return this.gracenoteOnlineAvailable;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public String getDiagValue() {
        Buffer buffer = new Buffer();
        buffer.append("---\n");
        for (int i2 = 0; i2 < 14; ++i2) {
            buffer.append(LogUtil.getSourceTypeStr(i2)).append(": ").append(this.installedList[i2] ? "INSTALLED" : "NOT INSTALLED");
            buffer.append("\n");
        }
        buffer.append("---\n");
        Field[] fieldArray = this.getClass().getDeclaredFields();
        for (int i3 = 0; i3 < fieldArray.length; ++i3) {
            Field field = fieldArray[i3];
            try {
                Class clazz = fieldArray[i3].getType();
                if (clazz != Boolean.TYPE && clazz != Integer.TYPE) continue;
                buffer.append(field.getName());
                buffer.append(": ").append(field.get(this));
                continue;
            }
            catch (Exception exception) {
                exception.printStackTrace();
                continue;
            }
            finally {
                buffer.append("\n");
            }
        }
        return buffer.toString();
    }

    public String getDiagKey() {
        return "Configuration";
    }

    public boolean isTVinMedia() {
        return this.tvInMedia;
    }

    public boolean isDVDVideoFormatSettingAvailable() {
        return this.dvdVideoFormatSettingAvailable;
    }

    public boolean isIAP2Supported() {
        return this.iap2Supported;
    }
}

