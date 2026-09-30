/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.cmd.uni;

import de.audi.atip.log.LogChannel;
import de.audi.tuner.app.Utilities;
import de.audi.tuner.app.cmd.IRadioCmdManager;
import org.dsi.ifc.radio.DABSlideShowInfo;
import org.dsi.ifc.radio.DSIUnifiedTunerListener;
import org.dsi.ifc.radio.UnifiedRadioText;
import org.dsi.ifc.radio.UnifiedRadioTextPlus;
import org.dsi.ifc.radio.UnifiedStation;

public class DSIUnifiedTunerCmdListener
implements DSIUnifiedTunerListener {
    private final IRadioCmdManager cmdListManager;
    private final LogChannel lc;

    public DSIUnifiedTunerCmdListener(LogChannel logChannel, IRadioCmdManager iRadioCmdManager) {
        this.lc = logChannel;
        this.cmdListManager = iRadioCmdManager;
    }

    public void asyncException(int n, String string, int n2) {
        this.lc.log(10000, "[DSIUnifiedTunerCmdListener.asyncException]", (Object)string, (long)n, (long)n2);
    }

    public void selectStationStatus(int n) {
        this.lc.log(10000000, "[DSIUnifiedTunerCmdListener.selectStationStatus] status:%1", (long)n);
        try {
            this.cmdListManager.getActiveUnifiedCommand().selectStationStatus(n);
        }
        catch (Exception exception) {
            this.lc.log(10000, "[DSIUnifiedTunerCmdListener.selectStationStatus]", (Throwable)exception);
        }
    }

    public void updateAudioStatus(int n, int n2) {
        this.lc.log(10000000, "[DSIUnifiedTunerCmdListener.updateAudioStatus] status:%1 valid:%2", (long)n, (long)n2);
        if (n2 == 1) {
            try {
                this.cmdListManager.getActiveUnifiedCommand().updateAudioStatus(n);
            }
            catch (Exception exception) {
                this.lc.log(10000, "[DSIUnifiedTunerCmdListener.updateAudioStatus]", (Throwable)exception);
            }
        }
    }

    public void updateDetectedDevice(int n, int n2) {
        this.lc.log(10000000, "[DSIUnifiedTunerCmdListener.updateDetectedDevice] device:%1 valid:%2", (long)n, (long)n2);
        if (n2 == 1) {
            try {
                this.cmdListManager.getActiveUnifiedCommand().updateDetectedDevice(n);
            }
            catch (Exception exception) {
                this.lc.log(10000, "[DSIUnifiedTunerCmdListener.updateDetectedDevice]", (Throwable)exception);
            }
        }
    }

    public void updateSelectedStation(UnifiedStation unifiedStation, int n) {
        this.lc.log(10000000, "[DSIUnifiedTunerCmdListener.updateSelectedStation] status:%1 valid:%2", (Object)unifiedStation, (long)n);
        if (n == 1) {
            try {
                this.cmdListManager.getActiveUnifiedCommand().updateSelectedStation(unifiedStation);
            }
            catch (Exception exception) {
                this.lc.log(10000, "[DSIUnifiedTunerCmdListener.updateSelectedStation]", (Throwable)exception);
            }
        }
    }

    public void updateStationList(UnifiedStation[] unifiedStationArray, int n) {
        this.lc.log(10000000, "[DSIUnifiedTunerCmdListener.updateStationList] #list:%1 valid:%2", (long)this.size(unifiedStationArray), (long)n);
        if (n == 1) {
            try {
                this.cmdListManager.getActiveUnifiedCommand().updateStationList(unifiedStationArray);
            }
            catch (Exception exception) {
                this.lc.log(10000, "[DSIUnifiedTunerCmdListener.updateStationList]", (Throwable)exception);
            }
        }
    }

    public void updateRadioText(UnifiedRadioText unifiedRadioText, int n) {
        this.lc.log(10000000, "[DSIUnifiedTunerCmdListener.updateRadioText]:%1 valid:%2", (Object)unifiedRadioText, (long)n);
        if (n == 1) {
            try {
                this.cmdListManager.getActiveUnifiedCommand().updateRadioText(unifiedRadioText);
            }
            catch (Exception exception) {
                this.lc.log(10000, "[DSIUnifiedTunerCmdListener.updateRadioText]", (Throwable)exception);
            }
        }
    }

    public void updateEnhancedRadioText(UnifiedRadioText unifiedRadioText, int n) {
        this.lc.log(10000000, "[DSIUnifiedTunerCmdListener.updateEnhancedRadioText]:%1 valid:%2", (Object)unifiedRadioText, (long)n);
        if (n == 1) {
            try {
                this.cmdListManager.getActiveUnifiedCommand().updateEnhancedRadioText(unifiedRadioText);
            }
            catch (Exception exception) {
                this.lc.log(10000, "[DSIUnifiedTunerCmdListener.updateEnhancedRadioText]", (Throwable)exception);
            }
        }
    }

    public void updateRadioTextPlus(UnifiedRadioTextPlus unifiedRadioTextPlus, int n) {
        this.lc.log(10000000, "[DSIUnifiedTunerCmdListener.updateRadioTextPlus]:%1 valid:%2", (Object)unifiedRadioTextPlus, (long)n);
        if (n == 1) {
            try {
                this.cmdListManager.getActiveUnifiedCommand().updateRadioTextPlus(unifiedRadioTextPlus);
            }
            catch (Exception exception) {
                this.lc.log(10000, "[DSIUnifiedTunerCmdListener.updateRadioTextPlus]", (Throwable)exception);
            }
        }
    }

    public void updateEnhancedRadioTextPlus(UnifiedRadioTextPlus unifiedRadioTextPlus, int n) {
        this.lc.log(10000000, "[DSIUnifiedTunerCmdListener.updateEnhancedRadioTextPlus]:%1 valid:%2", (Object)unifiedRadioTextPlus, (long)n);
        if (n == 1) {
            try {
                this.cmdListManager.getActiveUnifiedCommand().updateEnhancedRadioTextPlus(unifiedRadioTextPlus);
            }
            catch (Exception exception) {
                this.lc.log(10000, "[DSIUnifiedTunerCmdListener.updateEnhancedRadioTextPlus]", (Throwable)exception);
            }
        }
    }

    public void updateSlideShowInfo(DABSlideShowInfo dABSlideShowInfo, int n) {
        this.lc.log(10000000, "[DSIUnifiedTunerCmdListener.updateSlideShowInfo]:%1 valid:%2", (Object)dABSlideShowInfo, (long)n);
        this.lc.log(10000000, "[DSIUnifiedTunerCmdListener.updateSlideShowInfo]: duration1 0x%1, duration2 0x%2", (long)Utilities.getSlideshowDisplayDuration1(), (long)Utilities.getSlideshowDisplayDuration2());
        if (n == 1) {
            try {
                this.cmdListManager.getActiveUnifiedCommand().updateSlideShowInfo(dABSlideShowInfo);
            }
            catch (Exception exception) {
                this.lc.log(10000, "[DSIUnifiedTunerCmdListener.updateSlideShowInfo]", (Throwable)exception);
            }
        }
    }

    public void listMode(int n) {
        this.lc.log(10000000, "[DSIUnifiedTunerCmdListener.listMode]:%1", (long)n);
        try {
            this.cmdListManager.getActiveUnifiedCommand().listMode(n);
        }
        catch (Exception exception) {
            this.lc.log(10000, "[DSIUnifiedTunerCmdListener.listMode]", (Throwable)exception);
        }
    }

    public void stationFollowingMode(int n) {
        this.lc.log(10000000, "[DSIUnifiedTunerCmdListener.stationFollowingMode]:%1", (long)n);
        try {
            this.cmdListManager.getActiveUnifiedCommand().stationFollowingMode(n);
        }
        catch (Exception exception) {
            this.lc.log(10000, "[DSIUnifiedTunerCmdListener.stationFollowingMode]", (Throwable)exception);
        }
    }

    public void updateSoftLinkSwitchStatus(int n, int n2) {
        this.lc.log(10000000, "[DSIUnifiedTunerCmdListener.updateSoftLinkSwitchStatus]:%1 valid:%2", (long)n, (long)n2);
        try {
            this.cmdListManager.getActiveUnifiedCommand().updateSoftLinkSwitchStatus(n);
        }
        catch (Exception exception) {
            this.lc.log(10000, "[DSIUnifiedTunerCmdListener.updateSoftLinkSwitchStatus]", (Throwable)exception);
        }
    }

    public void updateRegModeStatus(int n, int n2) {
        this.lc.log(10000000, "[DSIUnifiedTunerCmdListener.updateRegModeStatus]:%1 valid:%2", (long)n, (long)n2);
        try {
            this.cmdListManager.getActiveUnifiedCommand().updateRegModeStatus(n);
        }
        catch (Exception exception) {
            this.lc.log(10000, "[DSIUnifiedTunerCmdListener.updateRegModeStatus]", (Throwable)exception);
        }
    }

    public void updateDeviceUsageStatus(int n, int n2) {
        this.lc.log(10000000, "[DSIUnifiedTunerCmdListener.updateDeviceUsageStatus]:%1 valid:%2", (long)n, (long)n2);
        try {
            this.cmdListManager.getActiveUnifiedCommand().updateDeviceUsageStatus(n);
        }
        catch (Exception exception) {
            this.lc.log(10000, "[DSIUnifiedTunerCmdListener.updateDeviceUsageStatus]", (Throwable)exception);
        }
    }

    private int size(Object[] objectArray) {
        return objectArray != null ? objectArray.length : -1;
    }

    public void updateProfileState(int n, int n2, int n3) {
    }

    public void profileChanged(int n, int n2) {
    }

    public void profileCopied(int n, int n2, int n3) {
    }

    public void profileReset(int n, int n2) {
    }

    public void profileResetAll(int n) {
    }
}

