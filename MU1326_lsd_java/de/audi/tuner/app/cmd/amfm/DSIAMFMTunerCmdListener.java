/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.cmd.amfm;

import de.audi.atip.log.LogChannel;
import de.audi.tuner.app.cmd.IRadioCmdManager;
import org.dsi.ifc.radio.AMFMRadioText;
import org.dsi.ifc.radio.DSIAMFMTunerListener;
import org.dsi.ifc.radio.HdStationInfo;
import org.dsi.ifc.radio.Station;
import org.dsi.ifc.radio.WavebandInfo;

public class DSIAMFMTunerCmdListener
implements DSIAMFMTunerListener {
    private final IRadioCmdManager cmdListManager;
    private final LogChannel lc;

    public DSIAMFMTunerCmdListener(LogChannel logChannel, IRadioCmdManager iRadioCmdManager) {
        this.lc = logChannel;
        this.cmdListManager = iRadioCmdManager;
    }

    public void asyncException(int n, String string, int n2) {
        this.lc.log(10000, "[DSIAMFMTunerCmdListener.asyncException]", (Object)string, (long)n, (long)n2);
    }

    public void updateStationList(Station[] stationArray, int n) {
        this.lc.log(10000000, "[DSIAMFMTunerCmdListener.updateStationList] #list:%1 valid:%2", (long)this.size(stationArray), (long)n);
        if (stationArray != null && n == 1) {
            try {
                this.cmdListManager.getActiveAMFMCommand().updateStationList(stationArray);
            }
            catch (Exception exception) {
                this.lc.log(10000, "[DSIAMFMTunerCmdListener.updateStationList]", (Throwable)exception);
            }
        }
    }

    public void updateStationListMW(Station[] stationArray, int n) {
        this.lc.log(10000000, "[DSIAMFMTunerCmdListener.updateStationListMW] #list:%1 valid:%2", (long)this.size(stationArray), (long)n);
        if (stationArray != null && n == 1) {
            try {
                this.cmdListManager.getActiveAMFMCommand().updateStationListMW(stationArray);
            }
            catch (Exception exception) {
                this.lc.log(10000, "[DSIAMFMTunerCmdListener.updateStationListMW]", (Throwable)exception);
            }
        }
    }

    public void updateStationListLW(Station[] stationArray, int n) {
        this.lc.log(10000000, "[DSIAMFMTunerCmdListener.updateStationListLW] #list:%1 valid:%2", (long)this.size(stationArray), (long)n);
        if (stationArray != null && n == 1) {
            try {
                this.cmdListManager.getActiveAMFMCommand().updateStationListLW(stationArray);
            }
            catch (Exception exception) {
                this.lc.log(10000, "[DSIAMFMTunerCmdListener.updateStationListLW]", (Throwable)exception);
            }
        }
    }

    public void updateWavebandInfoList(WavebandInfo[] wavebandInfoArray, int n) {
        this.lc.log(10000000, "[DSIAMFMTunerCmdListener.updateWavebandInfoList] #wavebandInfosSize:%1 valid:%2", (long)this.size(wavebandInfoArray), (long)n);
        if (wavebandInfoArray != null && n == 1) {
            if (this.lc.isDebug2()) {
                for (int i2 = 0; i2 < wavebandInfoArray.length; ++i2) {
                    this.lc.log(100000000, "[DSIAMFMTunerCmdListener.updateWavebandInfoList] [%2] %1", (Object)wavebandInfoArray[i2], (long)i2);
                }
            }
            try {
                this.cmdListManager.getActiveAMFMCommand().updateWavebandInfoList(wavebandInfoArray);
            }
            catch (Exception exception) {
                this.lc.log(10000, "[DSIAMFMTunerCmdListener.updateWavebandInfoList]", (Throwable)exception);
            }
        }
    }

    public void updateRadioText(AMFMRadioText aMFMRadioText, int n) {
        this.lc.log(10000000, "[DSIAMFMTunerCmdListener.updateRadioText] %1 valid:%2", (Object)aMFMRadioText, (long)n);
        if (aMFMRadioText != null && n == 1) {
            try {
                this.cmdListManager.getActiveAMFMCommand().updateRadioText(aMFMRadioText);
            }
            catch (Exception exception) {
                this.lc.log(10000, "[DSIAMFMTunerCmdListener.updateRadioText]", (Throwable)exception);
            }
        }
    }

    public void updateAFSwitchStatus(boolean bl, int n) {
        this.lc.log(10000000, "[DSIAMFMTunerCmdListener.updateAFSwitchStatus] status:%1 valid:%2", bl, (long)n);
        if (n == 1) {
            try {
                this.cmdListManager.getActiveAMFMCommand().updateAFSwitchStatus(bl);
            }
            catch (Exception exception) {
                this.lc.log(10000, "[DSIAMFMTunerCmdListener.updateAFSwitchStatus]", (Throwable)exception);
            }
        }
    }

    public void updateREGSwitchStatus(int n, int n2) {
        this.lc.log(10000000, "[DSIAMFMTunerCmdListener.updateREGSwitchStatus] status:%1 valid:%2", (long)n, (long)n2);
        if (n2 == 1) {
            try {
                this.cmdListManager.getActiveAMFMCommand().updateREGSwitchStatus(n);
            }
            catch (Exception exception) {
                this.lc.log(10000, "[DSIAMFMTunerCmdListener.updateREGSwitchStatus]", (Throwable)exception);
            }
        }
    }

    public void updateLinkingUsageStatus(int n, int n2) {
        this.lc.log(10000000, "[DSIAMFMTunerCmdListener.updateLinkingUsageStatus] status:%1 valid:%2", (long)n, (long)n2);
        if (n2 == 1) {
            try {
                this.cmdListManager.getActiveAMFMCommand().updateLinkingUsageStatus(n);
            }
            catch (Exception exception) {
                this.lc.log(10000, "[DSIAMFMTunerCmdListener.updateLinkingUsageStatus]", (Throwable)exception);
            }
        }
    }

    public void updateDetectedDevice(int n, int n2) {
        this.lc.log(10000000, "[DSIAMFMTunerCmdListener.updateDetectedDevice] device:%1 valid:%2", (long)n, (long)n2);
        if (n2 == 1) {
            try {
                this.cmdListManager.getActiveAMFMCommand().updateDetectedDevice(n);
            }
            catch (Exception exception) {
                this.lc.log(10000, "[DSIAMFMTunerCmdListener.updateDetectedDevice]", (Throwable)exception);
            }
        }
    }

    public void tuneFrequencyStepsStatus(int n) {
        this.lc.log(10000000, "[DSIAMFMTunerCmdListener.tuneFrequencyStepsStatus] status:%1", (long)n);
        try {
            this.cmdListManager.getActiveAMFMCommand().tuneFrequencyStepsStatus(n);
        }
        catch (Exception exception) {
            this.lc.log(10000, "[DSIAMFMTunerCmdListener.tuneFrequencyStepsStatus]", (Throwable)exception);
        }
    }

    public void selectStationStatus(int n) {
        this.lc.log(10000000, "[DSIAMFMTunerCmdListener.selectStationStatus] status:%1", (long)n);
        try {
            this.cmdListManager.getActiveAMFMCommand().selectStationStatus(n);
        }
        catch (Exception exception) {
            this.lc.log(10000, "[DSIAMFMTunerCmdListener.selectStationStatus]", (Throwable)exception);
        }
    }

    public void seekStationStatus(int n) {
        this.lc.log(10000000, "[DSIAMFMTunerCmdListener.seekStationStatus] status:%1", (long)n);
        try {
            this.cmdListManager.getActiveAMFMCommand().seekStationStatus(n);
        }
        catch (Exception exception) {
            this.lc.log(10000, "[DSIAMFMTunerCmdListener.seekStationStatus]", (Throwable)exception);
        }
    }

    public void updateRadioTextPlus(int[] nArray, String[] stringArray, int n) {
        this.lc.log(10000000, "[DSIAMFMTunerCmdListener.updateRadioTextPlus] #tags:%1 #content:%2 valid:%3", (long)this.size(nArray), (long)this.size(stringArray), (long)n);
        if (nArray != null && stringArray != null && n == 1) {
            try {
                this.cmdListManager.getActiveAMFMCommand().updateRadioTextPlus(nArray, stringArray);
            }
            catch (Exception exception) {
                this.lc.log(10000, "[DSIAMFMTunerCmdListener.updateRadioTextPlus]", (Throwable)exception);
            }
        }
    }

    public void updateSelectedStation(Station station, int n) {
        this.lc.log(10000000, "[DSIAMFMTunerCmdListener.updateSelectedStation] %1 valid:%2", (Object)station, (long)n);
        if (station != null && n == 1) {
            try {
                this.cmdListManager.getActiveAMFMCommand().updateSelectedStation(station);
            }
            catch (Exception exception) {
                this.lc.log(10000, "[DSIAMFMTunerCmdListener.updateSelectedStation]", (Throwable)exception);
            }
        }
    }

    public void updateSelectedStationHD(Station station, int n, int n2) {
        this.lc.log(10000000, "[DSIAMFMTunerCmdListener.updateSelectedStationHD] %1, hdStructure %2  valid:%3", (Object)station, (long)n, (long)n2);
        if (station != null && n2 == 1) {
            try {
                this.cmdListManager.getActiveAMFMCommand().updateSelectedStationHD(station, n);
            }
            catch (Exception exception) {
                this.lc.log(10000, "[DSIAMFMTunerCmdListener.updateSelectedStationHD]", (Throwable)exception);
            }
        }
    }

    public void prepareTuningStatus(int n) {
        this.lc.log(10000000, "[DSIAMFMTunerCmdListener.prepareTuningStatus] status:%1", (long)n);
        try {
            this.cmdListManager.getActiveAMFMCommand().prepareTuningStatus(n);
        }
        catch (Exception exception) {
            this.lc.log(10000, "[DSIAMFMTunerCmdListener.prepareTuningStatus]", (Throwable)exception);
        }
    }

    public void selectFrequencyStatus(int n) {
        this.lc.log(10000000, "[DSIAMFMTunerCmdListener.selectFrequencyStatus] status:%1", (long)n);
        try {
            this.cmdListManager.getActiveAMFMCommand().selectFrequencyStatus(n);
        }
        catch (Exception exception) {
            this.lc.log(10000, "[DSIAMFMTunerCmdListener.selectFrequencyStatus]", (Throwable)exception);
        }
    }

    public void setAMBandRangeStatus(int n) {
        this.lc.log(10000000, "[DSIAMFMTunerCmdListener.setAMBandRangeStatus] status:%1", (long)n);
        try {
            this.cmdListManager.getActiveAMFMCommand().setAMBandRangeStatus(n);
        }
        catch (Exception exception) {
            this.lc.log(10000, "[DSIAMFMTunerCmdListener.setAMBandRangeStatus]", (Throwable)exception);
        }
    }

    public void forceFMUpdateStatus(int n) {
        this.lc.log(10000000, "[DSIAMFMTunerCmdListener.forceFMUpdateStatus] status:%1", (long)n);
        try {
            this.cmdListManager.getActiveAMFMCommand().forceFMUpdateStatus(n);
        }
        catch (Exception exception) {
            this.lc.log(10000, "[DSIAMFMTunerCmdListener.forceFMUpdateStatus]", (Throwable)exception);
        }
    }

    public void updatePiIgnoreSwitchStatus(boolean bl, int n) {
        this.lc.log(10000000, "[DSIAMFMTunerCmdListener.updatePiIgnoreSwitchStatus] status:%1 valid:%2", bl, (long)n);
        if (n == 1) {
            try {
                this.cmdListManager.getActiveAMFMCommand().updatePiIgnoreSwitchStatus(bl);
            }
            catch (Exception exception) {
                this.lc.log(10000, "[DSIAMFMTunerCmdListener.updatePiIgnoreSwitchStatus]", (Throwable)exception);
            }
        }
    }

    public void forceAMUpdateStatus(int n) {
        this.lc.log(10000000, "[DSIAMFMTunerCmdListener.forceAMUpdateStatus] status:%1", (long)n);
        try {
            this.cmdListManager.getActiveAMFMCommand().forceAMUpdateStatus(n);
        }
        catch (Exception exception) {
            this.lc.log(10000, "[DSIAMFMTunerCmdListener.forceAMUpdateStatus]", (Throwable)exception);
        }
    }

    public void updateRDSIgnoreSwitchStatus(boolean bl, int n) {
        this.lc.log(10000000, "[DSIAMFMTunerCmdListener.updateRDSIgnoreSwitchStatus] status:%1 valid:%2", bl, (long)n);
        if (n == 1) {
            try {
                this.cmdListManager.getActiveAMFMCommand().updateRDSIgnoreSwitchStatus(bl);
            }
            catch (Exception exception) {
                this.lc.log(10000, "[DSIAMFMTunerCmdListener.updateRDSIgnoreSwitchStatus]", (Throwable)exception);
            }
        }
    }

    public void updateMESwitchStatus(boolean bl, int n) {
        this.lc.log(10000000, "[DSIAMFMTunerCmdListener.updateMESwitchStatus] status:%1 valid:%2", bl, (long)n);
        if (n == 1) {
            try {
                this.cmdListManager.getActiveAMFMCommand().updateMESwitchStatus(bl);
            }
            catch (Exception exception) {
                this.lc.log(10000, "[DSIAMFMTunerCmdListener.updateMESwitchStatus]", (Throwable)exception);
            }
        }
    }

    public void updateHdStatus(int n, int n2) {
        this.lc.log(10000000, "[DSIAMFMTunerCmdListener.updateHdStatus] status:%1 valid:%2", (long)n, (long)n2);
        if (n2 == 1) {
            try {
                this.cmdListManager.getActiveAMFMCommand().updateHdStatus(n);
            }
            catch (Exception exception) {
                this.lc.log(10000, "[DSIAMFMTunerCmdListener.updateHdStatus]", (Throwable)exception);
            }
        }
    }

    public void updateHdMode(int n, int n2) {
        this.lc.log(10000000, "[DSIAMFMTunerCmdListener.updateHdMode] mode:%1 valid:%2", (long)n, (long)n2);
        if (n2 == 1) {
            try {
                this.cmdListManager.getActiveAMFMCommand().updateHdMode(n);
            }
            catch (Exception exception) {
                this.lc.log(10000, "[DSIAMFMTunerCmdListener.updateHdMode]", (Throwable)exception);
            }
        }
    }

    public void updateHdStationInfo(HdStationInfo hdStationInfo, int n) {
        this.lc.log(10000000, "[DSIAMFMTunerCmdListener.updateHdStationInfo] %1 valid:%2", (Object)hdStationInfo, (long)n);
        if (hdStationInfo != null && n == 1) {
            try {
                this.cmdListManager.getActiveAMFMCommand().updateHdStationInfo(hdStationInfo);
            }
            catch (Exception exception) {
                this.lc.log(10000, "[DSIAMFMTunerCmdListener.updateHdStationInfo]", (Throwable)exception);
            }
        }
    }

    public void updateAvailability(int n, int n2) {
        this.lc.log(10000000, "[DSIAMFMTunerCmdListener.updateAvailability] availability:%1 valid:%2", (long)n, (long)n2);
        if (n2 == 1) {
            try {
                this.cmdListManager.getActiveAMFMCommand().updateAvailability(n);
            }
            catch (Exception exception) {
                this.lc.log(10000, "[DSIAMFMTunerCmdListener.updateAvailability]", (Throwable)exception);
            }
        }
    }

    public void updateElectronicSerialCode(String string, int n) {
        this.lc.log(10000000, "[DSIAMFMTunerCmdListener.updateElectronicSerialCode] code:%1 valid:%2", (Object)string, (long)n);
        if (string != null && n == 1) {
            try {
                this.cmdListManager.getActiveAMFMCommand().updateElectronicSerialCode(string);
            }
            catch (Exception exception) {
                this.lc.log(10000, "[DSIAMFMTunerCmdListener.updateElectronicSerialCode]", (Throwable)exception);
            }
        }
    }

    private int size(Object[] objectArray) {
        return objectArray != null ? objectArray.length : -1;
    }

    private int size(int[] nArray) {
        return nArray != null ? nArray.length : -1;
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

