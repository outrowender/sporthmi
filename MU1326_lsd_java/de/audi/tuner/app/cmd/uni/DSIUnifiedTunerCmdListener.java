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

    @Override
    public void asyncException(int n, String string, int n2) {
        this.lc.log(10000, "[DSIUnifiedTunerCmdListener.asyncException]", (Object)string, (long)n, (long)n2);
    }

    @Override
    public void selectStationStatus(int n) {
        this.lc.log(-2137614336, "[DSIUnifiedTunerCmdListener.selectStationStatus] status:%1", (long)n);
        try {
            this.cmdListManager.getActiveUnifiedCommand().selectStationStatus(n);
        }
        catch (Exception exception) {
            this.lc.log(10000, "[DSIUnifiedTunerCmdListener.selectStationStatus]", (Throwable)exception);
        }
    }

    @Override
    public void updateAudioStatus(int n, int n2) {
        this.lc.log(-2137614336, "[DSIUnifiedTunerCmdListener.updateAudioStatus] status:%1 valid:%2", (long)n, (long)n2);
        if (n2 == 1) {
            try {
                this.cmdListManager.getActiveUnifiedCommand().updateAudioStatus(n);
            }
            catch (Exception exception) {
                this.lc.log(10000, "[DSIUnifiedTunerCmdListener.updateAudioStatus]", (Throwable)exception);
            }
        }
    }

    @Override
    public void updateDetectedDevice(int n, int n2) {
        this.lc.log(-2137614336, "[DSIUnifiedTunerCmdListener.updateDetectedDevice] device:%1 valid:%2", (long)n, (long)n2);
        if (n2 == 1) {
            try {
                this.cmdListManager.getActiveUnifiedCommand().updateDetectedDevice(n);
            }
            catch (Exception exception) {
                this.lc.log(10000, "[DSIUnifiedTunerCmdListener.updateDetectedDevice]", (Throwable)exception);
            }
        }
    }

    @Override
    public void updateSelectedStation(UnifiedStation unifiedStation, int n) {
        this.lc.log(-2137614336, "[DSIUnifiedTunerCmdListener.updateSelectedStation] status:%1 valid:%2", (Object)unifiedStation, (long)n);
        if (n == 1) {
            try {
                this.cmdListManager.getActiveUnifiedCommand().updateSelectedStation(unifiedStation);
            }
            catch (Exception exception) {
                this.lc.log(10000, "[DSIUnifiedTunerCmdListener.updateSelectedStation]", (Throwable)exception);
            }
        }
    }

    @Override
    public void updateStationList(UnifiedStation[] unifiedStationArray, int n) {
        this.lc.log(-2137614336, "[DSIUnifiedTunerCmdListener.updateStationList] #list:%1 valid:%2", (long)this.size(unifiedStationArray), (long)n);
        if (n == 1) {
            try {
                this.cmdListManager.getActiveUnifiedCommand().updateStationList(unifiedStationArray);
            }
            catch (Exception exception) {
                this.lc.log(10000, "[DSIUnifiedTunerCmdListener.updateStationList]", (Throwable)exception);
            }
        }
    }

    @Override
    public void updateRadioText(UnifiedRadioText unifiedRadioText, int n) {
        this.lc.log(-2137614336, "[DSIUnifiedTunerCmdListener.updateRadioText]:%1 valid:%2", (Object)unifiedRadioText, (long)n);
        if (n == 1) {
            try {
                this.cmdListManager.getActiveUnifiedCommand().updateRadioText(unifiedRadioText);
            }
            catch (Exception exception) {
                this.lc.log(10000, "[DSIUnifiedTunerCmdListener.updateRadioText]", (Throwable)exception);
            }
        }
    }

    @Override
    public void updateEnhancedRadioText(UnifiedRadioText unifiedRadioText, int n) {
        this.lc.log(-2137614336, "[DSIUnifiedTunerCmdListener.updateEnhancedRadioText]:%1 valid:%2", (Object)unifiedRadioText, (long)n);
        if (n == 1) {
            try {
                this.cmdListManager.getActiveUnifiedCommand().updateEnhancedRadioText(unifiedRadioText);
            }
            catch (Exception exception) {
                this.lc.log(10000, "[DSIUnifiedTunerCmdListener.updateEnhancedRadioText]", (Throwable)exception);
            }
        }
    }

    @Override
    public void updateRadioTextPlus(UnifiedRadioTextPlus unifiedRadioTextPlus, int n) {
        this.lc.log(-2137614336, "[DSIUnifiedTunerCmdListener.updateRadioTextPlus]:%1 valid:%2", (Object)unifiedRadioTextPlus, (long)n);
        if (n == 1) {
            try {
                this.cmdListManager.getActiveUnifiedCommand().updateRadioTextPlus(unifiedRadioTextPlus);
            }
            catch (Exception exception) {
                this.lc.log(10000, "[DSIUnifiedTunerCmdListener.updateRadioTextPlus]", (Throwable)exception);
            }
        }
    }

    @Override
    public void updateEnhancedRadioTextPlus(UnifiedRadioTextPlus unifiedRadioTextPlus, int n) {
        this.lc.log(-2137614336, "[DSIUnifiedTunerCmdListener.updateEnhancedRadioTextPlus]:%1 valid:%2", (Object)unifiedRadioTextPlus, (long)n);
        if (n == 1) {
            try {
                this.cmdListManager.getActiveUnifiedCommand().updateEnhancedRadioTextPlus(unifiedRadioTextPlus);
            }
            catch (Exception exception) {
                this.lc.log(10000, "[DSIUnifiedTunerCmdListener.updateEnhancedRadioTextPlus]", (Throwable)exception);
            }
        }
    }

    @Override
    public void updateSlideShowInfo(DABSlideShowInfo dABSlideShowInfo, int n) {
        this.lc.log(-2137614336, "[DSIUnifiedTunerCmdListener.updateSlideShowInfo]:%1 valid:%2", (Object)dABSlideShowInfo, (long)n);
        this.lc.log(-2137614336, "[DSIUnifiedTunerCmdListener.updateSlideShowInfo]: duration1 0x%1, duration2 0x%2", (long)Utilities.getSlideshowDisplayDuration1(), (long)Utilities.getSlideshowDisplayDuration2());
        if (n == 1) {
            try {
                this.cmdListManager.getActiveUnifiedCommand().updateSlideShowInfo(dABSlideShowInfo);
            }
            catch (Exception exception) {
                this.lc.log(10000, "[DSIUnifiedTunerCmdListener.updateSlideShowInfo]", (Throwable)exception);
            }
        }
    }

    @Override
    public void listMode(int n) {
        this.lc.log(-2137614336, "[DSIUnifiedTunerCmdListener.listMode]:%1", (long)n);
        try {
            this.cmdListManager.getActiveUnifiedCommand().listMode(n);
        }
        catch (Exception exception) {
            this.lc.log(10000, "[DSIUnifiedTunerCmdListener.listMode]", (Throwable)exception);
        }
    }

    @Override
    public void stationFollowingMode(int n) {
        this.lc.log(-2137614336, "[DSIUnifiedTunerCmdListener.stationFollowingMode]:%1", (long)n);
        try {
            this.cmdListManager.getActiveUnifiedCommand().stationFollowingMode(n);
        }
        catch (Exception exception) {
            this.lc.log(10000, "[DSIUnifiedTunerCmdListener.stationFollowingMode]", (Throwable)exception);
        }
    }

    @Override
    public void updateSoftLinkSwitchStatus(int n, int n2) {
        this.lc.log(-2137614336, "[DSIUnifiedTunerCmdListener.updateSoftLinkSwitchStatus]:%1 valid:%2", (long)n, (long)n2);
        try {
            this.cmdListManager.getActiveUnifiedCommand().updateSoftLinkSwitchStatus(n);
        }
        catch (Exception exception) {
            this.lc.log(10000, "[DSIUnifiedTunerCmdListener.updateSoftLinkSwitchStatus]", (Throwable)exception);
        }
    }

    @Override
    public void updateRegModeStatus(int n, int n2) {
        this.lc.log(-2137614336, "[DSIUnifiedTunerCmdListener.updateRegModeStatus]:%1 valid:%2", (long)n, (long)n2);
        try {
            this.cmdListManager.getActiveUnifiedCommand().updateRegModeStatus(n);
        }
        catch (Exception exception) {
            this.lc.log(10000, "[DSIUnifiedTunerCmdListener.updateRegModeStatus]", (Throwable)exception);
        }
    }

    @Override
    public void updateDeviceUsageStatus(int n, int n2) {
        this.lc.log(-2137614336, "[DSIUnifiedTunerCmdListener.updateDeviceUsageStatus]:%1 valid:%2", (long)n, (long)n2);
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

    @Override
    public void updateProfileState(int n, int n2, int n3) {
    }

    @Override
    public void profileChanged(int n, int n2) {
    }

    @Override
    public void profileCopied(int n, int n2, int n3) {
    }

    @Override
    public void profileReset(int n, int n2) {
    }

    @Override
    public void profileResetAll(int n) {
    }
}

