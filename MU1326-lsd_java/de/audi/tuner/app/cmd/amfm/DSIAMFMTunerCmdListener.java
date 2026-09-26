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

    @Override
    public void asyncException(int n, String string, int n2) {
        this.lc.log(10000, "[DSIAMFMTunerCmdListener.asyncException]", (Object)string, (long)n, (long)n2);
    }

    @Override
    public void updateStationList(Station[] stationArray, int n) {
        this.lc.log(-2137614336, "[DSIAMFMTunerCmdListener.updateStationList] #list:%1 valid:%2", (long)this.size(stationArray), (long)n);
        if (stationArray != null && n == 1) {
            try {
                this.cmdListManager.getActiveAMFMCommand().updateStationList(stationArray);
            }
            catch (Exception exception) {
                this.lc.log(10000, "[DSIAMFMTunerCmdListener.updateStationList]", (Throwable)exception);
            }
        }
    }

    @Override
    public void updateStationListMW(Station[] stationArray, int n) {
        this.lc.log(-2137614336, "[DSIAMFMTunerCmdListener.updateStationListMW] #list:%1 valid:%2", (long)this.size(stationArray), (long)n);
        if (stationArray != null && n == 1) {
            try {
                this.cmdListManager.getActiveAMFMCommand().updateStationListMW(stationArray);
            }
            catch (Exception exception) {
                this.lc.log(10000, "[DSIAMFMTunerCmdListener.updateStationListMW]", (Throwable)exception);
            }
        }
    }

    @Override
    public void updateStationListLW(Station[] stationArray, int n) {
        this.lc.log(-2137614336, "[DSIAMFMTunerCmdListener.updateStationListLW] #list:%1 valid:%2", (long)this.size(stationArray), (long)n);
        if (stationArray != null && n == 1) {
            try {
                this.cmdListManager.getActiveAMFMCommand().updateStationListLW(stationArray);
            }
            catch (Exception exception) {
                this.lc.log(10000, "[DSIAMFMTunerCmdListener.updateStationListLW]", (Throwable)exception);
            }
        }
    }

    @Override
    public void updateWavebandInfoList(WavebandInfo[] wavebandInfoArray, int n) {
        this.lc.log(-2137614336, "[DSIAMFMTunerCmdListener.updateWavebandInfoList] #wavebandInfosSize:%1 valid:%2", (long)this.size(wavebandInfoArray), (long)n);
        if (wavebandInfoArray != null && n == 1) {
            if (this.lc.isDebug2()) {
                for (int i2 = 0; i2 < wavebandInfoArray.length; ++i2) {
                    this.lc.log(14808325, "[DSIAMFMTunerCmdListener.updateWavebandInfoList] [%2] %1", (Object)wavebandInfoArray[i2], (long)i2);
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

    @Override
    public void updateRadioText(AMFMRadioText aMFMRadioText, int n) {
        this.lc.log(-2137614336, "[DSIAMFMTunerCmdListener.updateRadioText] %1 valid:%2", (Object)aMFMRadioText, (long)n);
        if (aMFMRadioText != null && n == 1) {
            try {
                this.cmdListManager.getActiveAMFMCommand().updateRadioText(aMFMRadioText);
            }
            catch (Exception exception) {
                this.lc.log(10000, "[DSIAMFMTunerCmdListener.updateRadioText]", (Throwable)exception);
            }
        }
    }

    @Override
    public void updateAFSwitchStatus(boolean bl, int n) {
        this.lc.log(-2137614336, "[DSIAMFMTunerCmdListener.updateAFSwitchStatus] status:%1 valid:%2", bl, (long)n);
        if (n == 1) {
            try {
                this.cmdListManager.getActiveAMFMCommand().updateAFSwitchStatus(bl);
            }
            catch (Exception exception) {
                this.lc.log(10000, "[DSIAMFMTunerCmdListener.updateAFSwitchStatus]", (Throwable)exception);
            }
        }
    }

    @Override
    public void updateREGSwitchStatus(int n, int n2) {
        this.lc.log(-2137614336, "[DSIAMFMTunerCmdListener.updateREGSwitchStatus] status:%1 valid:%2", (long)n, (long)n2);
        if (n2 == 1) {
            try {
                this.cmdListManager.getActiveAMFMCommand().updateREGSwitchStatus(n);
            }
            catch (Exception exception) {
                this.lc.log(10000, "[DSIAMFMTunerCmdListener.updateREGSwitchStatus]", (Throwable)exception);
            }
        }
    }

    @Override
    public void updateLinkingUsageStatus(int n, int n2) {
        this.lc.log(-2137614336, "[DSIAMFMTunerCmdListener.updateLinkingUsageStatus] status:%1 valid:%2", (long)n, (long)n2);
        if (n2 == 1) {
            try {
                this.cmdListManager.getActiveAMFMCommand().updateLinkingUsageStatus(n);
            }
            catch (Exception exception) {
                this.lc.log(10000, "[DSIAMFMTunerCmdListener.updateLinkingUsageStatus]", (Throwable)exception);
            }
        }
    }

    @Override
    public void updateDetectedDevice(int n, int n2) {
        this.lc.log(-2137614336, "[DSIAMFMTunerCmdListener.updateDetectedDevice] device:%1 valid:%2", (long)n, (long)n2);
        if (n2 == 1) {
            try {
                this.cmdListManager.getActiveAMFMCommand().updateDetectedDevice(n);
            }
            catch (Exception exception) {
                this.lc.log(10000, "[DSIAMFMTunerCmdListener.updateDetectedDevice]", (Throwable)exception);
            }
        }
    }

    @Override
    public void tuneFrequencyStepsStatus(int n) {
        this.lc.log(-2137614336, "[DSIAMFMTunerCmdListener.tuneFrequencyStepsStatus] status:%1", (long)n);
        try {
            this.cmdListManager.getActiveAMFMCommand().tuneFrequencyStepsStatus(n);
        }
        catch (Exception exception) {
            this.lc.log(10000, "[DSIAMFMTunerCmdListener.tuneFrequencyStepsStatus]", (Throwable)exception);
        }
    }

    @Override
    public void selectStationStatus(int n) {
        this.lc.log(-2137614336, "[DSIAMFMTunerCmdListener.selectStationStatus] status:%1", (long)n);
        try {
            this.cmdListManager.getActiveAMFMCommand().selectStationStatus(n);
        }
        catch (Exception exception) {
            this.lc.log(10000, "[DSIAMFMTunerCmdListener.selectStationStatus]", (Throwable)exception);
        }
    }

    @Override
    public void seekStationStatus(int n) {
        this.lc.log(-2137614336, "[DSIAMFMTunerCmdListener.seekStationStatus] status:%1", (long)n);
        try {
            this.cmdListManager.getActiveAMFMCommand().seekStationStatus(n);
        }
        catch (Exception exception) {
            this.lc.log(10000, "[DSIAMFMTunerCmdListener.seekStationStatus]", (Throwable)exception);
        }
    }

    @Override
    public void updateRadioTextPlus(int[] nArray, String[] stringArray, int n) {
        this.lc.log(-2137614336, "[DSIAMFMTunerCmdListener.updateRadioTextPlus] #tags:%1 #content:%2 valid:%3", (long)this.size(nArray), (long)this.size(stringArray), (long)n);
        if (nArray != null && stringArray != null && n == 1) {
            try {
                this.cmdListManager.getActiveAMFMCommand().updateRadioTextPlus(nArray, stringArray);
            }
            catch (Exception exception) {
                this.lc.log(10000, "[DSIAMFMTunerCmdListener.updateRadioTextPlus]", (Throwable)exception);
            }
        }
    }

    @Override
    public void updateSelectedStation(Station station, int n) {
        this.lc.log(-2137614336, "[DSIAMFMTunerCmdListener.updateSelectedStation] %1 valid:%2", (Object)station, (long)n);
        if (station != null && n == 1) {
            try {
                this.cmdListManager.getActiveAMFMCommand().updateSelectedStation(station);
            }
            catch (Exception exception) {
                this.lc.log(10000, "[DSIAMFMTunerCmdListener.updateSelectedStation]", (Throwable)exception);
            }
        }
    }

    @Override
    public void updateSelectedStationHD(Station station, int n, int n2) {
        this.lc.log(-2137614336, "[DSIAMFMTunerCmdListener.updateSelectedStationHD] %1, hdStructure %2  valid:%3", (Object)station, (long)n, (long)n2);
        if (station != null && n2 == 1) {
            try {
                this.cmdListManager.getActiveAMFMCommand().updateSelectedStationHD(station, n);
            }
            catch (Exception exception) {
                this.lc.log(10000, "[DSIAMFMTunerCmdListener.updateSelectedStationHD]", (Throwable)exception);
            }
        }
    }

    @Override
    public void prepareTuningStatus(int n) {
        this.lc.log(-2137614336, "[DSIAMFMTunerCmdListener.prepareTuningStatus] status:%1", (long)n);
        try {
            this.cmdListManager.getActiveAMFMCommand().prepareTuningStatus(n);
        }
        catch (Exception exception) {
            this.lc.log(10000, "[DSIAMFMTunerCmdListener.prepareTuningStatus]", (Throwable)exception);
        }
    }

    @Override
    public void selectFrequencyStatus(int n) {
        this.lc.log(-2137614336, "[DSIAMFMTunerCmdListener.selectFrequencyStatus] status:%1", (long)n);
        try {
            this.cmdListManager.getActiveAMFMCommand().selectFrequencyStatus(n);
        }
        catch (Exception exception) {
            this.lc.log(10000, "[DSIAMFMTunerCmdListener.selectFrequencyStatus]", (Throwable)exception);
        }
    }

    @Override
    public void setAMBandRangeStatus(int n) {
        this.lc.log(-2137614336, "[DSIAMFMTunerCmdListener.setAMBandRangeStatus] status:%1", (long)n);
        try {
            this.cmdListManager.getActiveAMFMCommand().setAMBandRangeStatus(n);
        }
        catch (Exception exception) {
            this.lc.log(10000, "[DSIAMFMTunerCmdListener.setAMBandRangeStatus]", (Throwable)exception);
        }
    }

    @Override
    public void forceFMUpdateStatus(int n) {
        this.lc.log(-2137614336, "[DSIAMFMTunerCmdListener.forceFMUpdateStatus] status:%1", (long)n);
        try {
            this.cmdListManager.getActiveAMFMCommand().forceFMUpdateStatus(n);
        }
        catch (Exception exception) {
            this.lc.log(10000, "[DSIAMFMTunerCmdListener.forceFMUpdateStatus]", (Throwable)exception);
        }
    }

    @Override
    public void updatePiIgnoreSwitchStatus(boolean bl, int n) {
        this.lc.log(-2137614336, "[DSIAMFMTunerCmdListener.updatePiIgnoreSwitchStatus] status:%1 valid:%2", bl, (long)n);
        if (n == 1) {
            try {
                this.cmdListManager.getActiveAMFMCommand().updatePiIgnoreSwitchStatus(bl);
            }
            catch (Exception exception) {
                this.lc.log(10000, "[DSIAMFMTunerCmdListener.updatePiIgnoreSwitchStatus]", (Throwable)exception);
            }
        }
    }

    @Override
    public void forceAMUpdateStatus(int n) {
        this.lc.log(-2137614336, "[DSIAMFMTunerCmdListener.forceAMUpdateStatus] status:%1", (long)n);
        try {
            this.cmdListManager.getActiveAMFMCommand().forceAMUpdateStatus(n);
        }
        catch (Exception exception) {
            this.lc.log(10000, "[DSIAMFMTunerCmdListener.forceAMUpdateStatus]", (Throwable)exception);
        }
    }

    @Override
    public void updateRDSIgnoreSwitchStatus(boolean bl, int n) {
        this.lc.log(-2137614336, "[DSIAMFMTunerCmdListener.updateRDSIgnoreSwitchStatus] status:%1 valid:%2", bl, (long)n);
        if (n == 1) {
            try {
                this.cmdListManager.getActiveAMFMCommand().updateRDSIgnoreSwitchStatus(bl);
            }
            catch (Exception exception) {
                this.lc.log(10000, "[DSIAMFMTunerCmdListener.updateRDSIgnoreSwitchStatus]", (Throwable)exception);
            }
        }
    }

    @Override
    public void updateMESwitchStatus(boolean bl, int n) {
        this.lc.log(-2137614336, "[DSIAMFMTunerCmdListener.updateMESwitchStatus] status:%1 valid:%2", bl, (long)n);
        if (n == 1) {
            try {
                this.cmdListManager.getActiveAMFMCommand().updateMESwitchStatus(bl);
            }
            catch (Exception exception) {
                this.lc.log(10000, "[DSIAMFMTunerCmdListener.updateMESwitchStatus]", (Throwable)exception);
            }
        }
    }

    @Override
    public void updateHdStatus(int n, int n2) {
        this.lc.log(-2137614336, "[DSIAMFMTunerCmdListener.updateHdStatus] status:%1 valid:%2", (long)n, (long)n2);
        if (n2 == 1) {
            try {
                this.cmdListManager.getActiveAMFMCommand().updateHdStatus(n);
            }
            catch (Exception exception) {
                this.lc.log(10000, "[DSIAMFMTunerCmdListener.updateHdStatus]", (Throwable)exception);
            }
        }
    }

    @Override
    public void updateHdMode(int n, int n2) {
        this.lc.log(-2137614336, "[DSIAMFMTunerCmdListener.updateHdMode] mode:%1 valid:%2", (long)n, (long)n2);
        if (n2 == 1) {
            try {
                this.cmdListManager.getActiveAMFMCommand().updateHdMode(n);
            }
            catch (Exception exception) {
                this.lc.log(10000, "[DSIAMFMTunerCmdListener.updateHdMode]", (Throwable)exception);
            }
        }
    }

    @Override
    public void updateHdStationInfo(HdStationInfo hdStationInfo, int n) {
        this.lc.log(-2137614336, "[DSIAMFMTunerCmdListener.updateHdStationInfo] %1 valid:%2", (Object)hdStationInfo, (long)n);
        if (hdStationInfo != null && n == 1) {
            try {
                this.cmdListManager.getActiveAMFMCommand().updateHdStationInfo(hdStationInfo);
            }
            catch (Exception exception) {
                this.lc.log(10000, "[DSIAMFMTunerCmdListener.updateHdStationInfo]", (Throwable)exception);
            }
        }
    }

    @Override
    public void updateAvailability(int n, int n2) {
        this.lc.log(-2137614336, "[DSIAMFMTunerCmdListener.updateAvailability] availability:%1 valid:%2", (long)n, (long)n2);
        if (n2 == 1) {
            try {
                this.cmdListManager.getActiveAMFMCommand().updateAvailability(n);
            }
            catch (Exception exception) {
                this.lc.log(10000, "[DSIAMFMTunerCmdListener.updateAvailability]", (Throwable)exception);
            }
        }
    }

    @Override
    public void updateElectronicSerialCode(String string, int n) {
        this.lc.log(-2137614336, "[DSIAMFMTunerCmdListener.updateElectronicSerialCode] code:%1 valid:%2", (Object)string, (long)n);
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

