/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.cmd.sdars;

import de.audi.atip.log.LogChannel;
import de.audi.tuner.app.cmd.IRadioCmdManager;
import org.dsi.ifc.global.DateTime;
import org.dsi.ifc.sdars.CategoryInfo;
import org.dsi.ifc.sdars.DSISDARSTunerListener;
import org.dsi.ifc.sdars.EPGDescription;
import org.dsi.ifc.sdars.EPGShortInfo;
import org.dsi.ifc.sdars.ImageInformation;
import org.dsi.ifc.sdars.RadioText;
import org.dsi.ifc.sdars.ServiceStatus3;
import org.dsi.ifc.sdars.SignalQuality;
import org.dsi.ifc.sdars.StationDescription;
import org.dsi.ifc.sdars.StationInfo;
import org.dsi.ifc.sdars.SubscriptionStatus;

public class DSISDARSTunerCmdListener
implements DSISDARSTunerListener {
    private final IRadioCmdManager cmdListManager;
    private final LogChannel lc;

    public DSISDARSTunerCmdListener(LogChannel logChannel, IRadioCmdManager iRadioCmdManager) {
        this.lc = logChannel;
        this.cmdListManager = iRadioCmdManager;
    }

    public void asyncException(int n, String string, int n2) {
        this.lc.log(10000, "[DSISDARSTunerCmdListener.asyncException]", (Object)string, (long)n, (long)n2);
    }

    public void updateElectronicSerialCode(String string, int n) {
        this.lc.log(10000000, "[DSISDARSTunerCmdListener.updateElectronicSerialCode] #code:%1 valid:%2", (Object)string, (long)n);
        if (string != null && n == 1) {
            try {
                this.cmdListManager.getActiveSDARSCmd().updateElectronicSerialCode(string);
            }
            catch (Exception exception) {
                this.lc.log(10000, "[DSISDARSTunerCmdListener.updateElectronicSerialCode]", (Throwable)exception);
            }
        }
    }

    public void updateServiceStatus3(ServiceStatus3 serviceStatus3, int n) {
        this.lc.log(10000000, "[DSISDARSTunerCmdListener.updateServiceStatus3] #status:%1 valid:%2", (Object)serviceStatus3, (long)n);
        if (serviceStatus3 != null && n == 1) {
            try {
                this.cmdListManager.getActiveSDARSCmd().updateServiceStatus3(serviceStatus3);
            }
            catch (Exception exception) {
                this.lc.log(10000, "[DSISDARSTunerCmdListener.updateServiceStatus3]", (Throwable)exception);
            }
        }
    }

    public void updateSignalQuality(SignalQuality signalQuality, int n) {
        this.lc.log(10000000, "[DSISDARSTunerCmdListener.updateSignalQuality] #quality:%1 valid:%2", (Object)signalQuality, (long)n);
        if (signalQuality != null && n == 1) {
            try {
                this.cmdListManager.getActiveSDARSCmd().updateSignalQuality(signalQuality);
            }
            catch (Exception exception) {
                this.lc.log(10000, "[DSISDARSTunerCmdListener.updateSignalQuality]", (Throwable)exception);
            }
        }
    }

    public void updateSelectedStation(StationInfo stationInfo, int n) {
        this.lc.log(10000000, "[DSISDARSTunerCmdListener.updateSelectedStation] #station:%1 valid:%2", (Object)stationInfo, (long)n);
        if (stationInfo != null && n == 1) {
            try {
                this.cmdListManager.getActiveSDARSCmd().updateSelectedStation(stationInfo);
            }
            catch (Exception exception) {
                this.lc.log(10000, "[DSISDARSTunerCmdListener.updateSelectedStation]", (Throwable)exception);
            }
        }
    }

    public void updateStationList(StationInfo[] stationInfoArray, int n) {
        this.lc.log(10000000, "[DSISDARSTunerCmdListener.updateStationList] #list:%1 valid:%2", (long)this.size(stationInfoArray), (long)n);
        if (stationInfoArray != null && n == 1) {
            try {
                this.cmdListManager.getActiveSDARSCmd().updateStationList(stationInfoArray);
            }
            catch (Exception exception) {
                this.lc.log(10000, "[DSISDARSTunerCmdListener.updateStationList]", (Throwable)exception);
            }
        }
    }

    public void updateCategoryList(CategoryInfo[] categoryInfoArray, int n) {
        this.lc.log(10000000, "[DSISDARSTunerCmdListener.updateCategoryList] #list:%1 valid:%2", (long)this.size(categoryInfoArray), (long)n);
        if (categoryInfoArray != null && n == 1) {
            try {
                this.cmdListManager.getActiveSDARSCmd().updateCategoryList(categoryInfoArray);
            }
            catch (Exception exception) {
                this.lc.log(10000, "[DSISDARSTunerCmdListener.updateCategoryList]", (Throwable)exception);
            }
        }
    }

    public void updateStaticTaggingInfo(String string, String string2, int n) {
        this.lc.log(10000000, "[DSISDARSTunerCmdListener.updateStaticTaggingInfo] #iTunes:%1 valid:%2", (Object)string, (long)n);
        this.lc.log(10000000, "[DSISDARSTunerCmdListener.updateStaticTaggingInfo] #affiliateID:%1 valid:%2", (Object)string2, (long)n);
        if (string != null && string2 != null && n == 1) {
            try {
                this.cmdListManager.getActiveSDARSCmd().updateStaticTaggingInfo(string, string2);
            }
            catch (Exception exception) {
                this.lc.log(10000, "[DSISDARSTunerCmdListener.iTunesSXMURL != null && ]", (Throwable)exception);
            }
        }
    }

    public void updateDetectedDevice(int n, int n2) {
        this.lc.log(10000000, "[DSISDARSTunerCmdListener.updateDetectedDevice] #device:%1 valid:%2", (long)n, (long)n2);
        if (n2 == 1) {
            try {
                this.cmdListManager.getActiveSDARSCmd().updateDetectedDevice(n);
            }
            catch (Exception exception) {
                this.lc.log(10000, "[DSISDARSTunerCmdListener.updateDetectedDevice]", (Throwable)exception);
            }
        }
    }

    public void selectStationStatus(int n) {
        this.lc.log(10000000, "[DSISDARSTunerCmdListener.selectStationStatus] #status:%1", (long)n);
        try {
            this.cmdListManager.getActiveSDARSCmd().selectStationStatus(n);
        }
        catch (Exception exception) {
            this.lc.log(10000, "[DSISDARSTunerCmdListener.selectStationStatus]", (Throwable)exception);
        }
    }

    public void updateAvailability(int n, int n2) {
        this.lc.log(10000000, "[DSISDARSTunerCmdListener.updateAvailability] #availability:%1 valid:%2", (long)n, (long)n2);
        if (n2 == 1) {
            try {
                this.cmdListManager.getActiveSDARSCmd().updateAvailability(n);
            }
            catch (Exception exception) {
                this.lc.log(10000, "[DSISDARSTunerCmdListener.updateAvailability]", (Throwable)exception);
            }
        }
    }

    public void updateStationDescription(StationDescription[] stationDescriptionArray, int n) {
        this.lc.log(10000000, "[DSISDARSTunerCmdListener.updateStationDescription] #list:%1 valid:%2", (long)this.size(stationDescriptionArray), (long)n);
        if (stationDescriptionArray != null && n == 1) {
            try {
                this.cmdListManager.getActiveSDARSCmd().updateStationDescription(stationDescriptionArray);
            }
            catch (Exception exception) {
                this.lc.log(10000, "[DSISDARSTunerCmdListener.updateStationDescription]", (Throwable)exception);
            }
        }
    }

    private int size(Object[] objectArray) {
        return objectArray != null ? objectArray.length : -1;
    }

    public void responseTime(DateTime dateTime) {
        this.lc.log(10000000, "[DSISDARSTunerCmdListener.responseTime] time:%1 ", (Object)dateTime);
        if (dateTime != null) {
            try {
                this.cmdListManager.getActiveSDARSCmd().responseTime(dateTime);
            }
            catch (Exception exception) {
                this.lc.log(10000, "[DSISDARSTunerCmdListener.responseTime]", (Throwable)exception);
            }
        }
    }

    public void updateSubscriptionStatus(SubscriptionStatus subscriptionStatus, int n) {
        this.lc.log(10000000, "[DSISDARSTunerCmdListener.updateSubscriptionStatus]:%1 valid:%2", (Object)subscriptionStatus, (long)n);
        if (subscriptionStatus != null && n == 1) {
            try {
                this.cmdListManager.getActiveSDARSCmd().updateSubscriptionStatus(subscriptionStatus);
            }
            catch (Exception exception) {
                this.lc.log(10000, "[DSISDARSTunerCmdListener.updateSubscriptionStatus]", (Throwable)exception);
            }
        }
    }

    public void informationRadioText(RadioText radioText) {
        this.lc.log(10000000, "[DSISDARSTunerCmdListener.informationRadioText]: %1", (Object)radioText);
        if (radioText != null) {
            try {
                this.cmdListManager.getActiveSDARSCmd().informationRadioText(radioText);
            }
            catch (Exception exception) {
                this.lc.log(10000, "[DSISDARSTunerCmdListener.informationRadioText]", (Throwable)exception);
            }
        }
    }

    public void informationRadioText2(RadioText[] radioTextArray) {
        this.lc.log(10000000, "[DSISDARSTunerCmdListener.informationRadioText2] list:%1", (long)this.size(radioTextArray));
        if (radioTextArray != null) {
            try {
                this.cmdListManager.getActiveSDARSCmd().informationRadioText2(radioTextArray);
            }
            catch (Exception exception) {
                this.lc.log(10000, "[DSISDARSTunerCmdListener.informationRadioText2]", (Throwable)exception);
            }
        }
    }

    public void responseEPG24Hour(EPGShortInfo ePGShortInfo) {
        this.lc.log(10000000, "[DSISDARSTunerCmdListener.responseEPG24Hour] short info:%1", (Object)ePGShortInfo);
        if (ePGShortInfo != null) {
            try {
                this.cmdListManager.getActiveSDARSCmd().responseEPG24Hour(ePGShortInfo);
            }
            catch (Exception exception) {
                this.lc.log(10000, "[DSISDARSTunerCmdListener.responseEPG24Hour]", (Throwable)exception);
            }
        }
    }

    public void responseEPGDescription(EPGDescription ePGDescription) {
        this.lc.log(10000000, "[DSISDARSTunerCmdListener.responseEPGDescription] description:%1", (Object)ePGDescription);
        if (ePGDescription != null) {
            try {
                this.cmdListManager.getActiveSDARSCmd().responseEPGDescription(ePGDescription);
            }
            catch (Exception exception) {
                this.lc.log(10000, "[DSISDARSTunerCmdListener.responseEPGDescription]", (Throwable)exception);
            }
        }
    }

    public void informationEPGChannelList(EPGShortInfo[] ePGShortInfoArray) {
        this.lc.log(10000000, "[DSISDARSTunerCmdListener.informationEPGChannelList] list:%1", (long)this.size(ePGShortInfoArray));
        if (ePGShortInfoArray != null) {
            try {
                this.cmdListManager.getActiveSDARSCmd().informationEPGChannelList(ePGShortInfoArray);
            }
            catch (Exception exception) {
                this.lc.log(10000, "[DSISDARSTunerCmdListener.informationEPGChannelList]", (Throwable)exception);
            }
        }
    }

    public void informationChannelArt(ImageInformation[] imageInformationArray) {
        this.lc.log(10000000, "[DSISDARSTunerCmdListener.informationChannelArt] list:%1", (long)this.size(imageInformationArray));
        if (imageInformationArray != null) {
            try {
                this.cmdListManager.getActiveSDARSCmd().informationChannelArt(imageInformationArray);
            }
            catch (Exception exception) {
                this.lc.log(10000, "[DSISDARSTunerCmdListener.informationChannelArt]", (Throwable)exception);
            }
        }
    }

    public void informationBackgroundArt(ImageInformation[] imageInformationArray) {
    }

    public void informationAlbumArt(ImageInformation[] imageInformationArray) {
    }

    public void informationGenreArt(ImageInformation[] imageInformationArray) {
    }

    public void informationStudioArt(ImageInformation[] imageInformationArray) {
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

