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

    @Override
    public void asyncException(int n, String string, int n2) {
        this.lc.log(10000, "[DSISDARSTunerCmdListener.asyncException]", (Object)string, (long)n, (long)n2);
    }

    @Override
    public void updateElectronicSerialCode(String string, int n) {
        this.lc.log(-2137614336, "[DSISDARSTunerCmdListener.updateElectronicSerialCode] #code:%1 valid:%2", (Object)string, (long)n);
        if (string != null && n == 1) {
            try {
                this.cmdListManager.getActiveSDARSCmd().updateElectronicSerialCode(string);
            }
            catch (Exception exception) {
                this.lc.log(10000, "[DSISDARSTunerCmdListener.updateElectronicSerialCode]", (Throwable)exception);
            }
        }
    }

    @Override
    public void updateServiceStatus3(ServiceStatus3 serviceStatus3, int n) {
        this.lc.log(-2137614336, "[DSISDARSTunerCmdListener.updateServiceStatus3] #status:%1 valid:%2", (Object)serviceStatus3, (long)n);
        if (serviceStatus3 != null && n == 1) {
            try {
                this.cmdListManager.getActiveSDARSCmd().updateServiceStatus3(serviceStatus3);
            }
            catch (Exception exception) {
                this.lc.log(10000, "[DSISDARSTunerCmdListener.updateServiceStatus3]", (Throwable)exception);
            }
        }
    }

    @Override
    public void updateSignalQuality(SignalQuality signalQuality, int n) {
        this.lc.log(-2137614336, "[DSISDARSTunerCmdListener.updateSignalQuality] #quality:%1 valid:%2", (Object)signalQuality, (long)n);
        if (signalQuality != null && n == 1) {
            try {
                this.cmdListManager.getActiveSDARSCmd().updateSignalQuality(signalQuality);
            }
            catch (Exception exception) {
                this.lc.log(10000, "[DSISDARSTunerCmdListener.updateSignalQuality]", (Throwable)exception);
            }
        }
    }

    @Override
    public void updateSelectedStation(StationInfo stationInfo, int n) {
        this.lc.log(-2137614336, "[DSISDARSTunerCmdListener.updateSelectedStation] #station:%1 valid:%2", (Object)stationInfo, (long)n);
        if (stationInfo != null && n == 1) {
            try {
                this.cmdListManager.getActiveSDARSCmd().updateSelectedStation(stationInfo);
            }
            catch (Exception exception) {
                this.lc.log(10000, "[DSISDARSTunerCmdListener.updateSelectedStation]", (Throwable)exception);
            }
        }
    }

    @Override
    public void updateStationList(StationInfo[] stationInfoArray, int n) {
        this.lc.log(-2137614336, "[DSISDARSTunerCmdListener.updateStationList] #list:%1 valid:%2", (long)this.size(stationInfoArray), (long)n);
        if (stationInfoArray != null && n == 1) {
            try {
                this.cmdListManager.getActiveSDARSCmd().updateStationList(stationInfoArray);
            }
            catch (Exception exception) {
                this.lc.log(10000, "[DSISDARSTunerCmdListener.updateStationList]", (Throwable)exception);
            }
        }
    }

    @Override
    public void updateCategoryList(CategoryInfo[] categoryInfoArray, int n) {
        this.lc.log(-2137614336, "[DSISDARSTunerCmdListener.updateCategoryList] #list:%1 valid:%2", (long)this.size(categoryInfoArray), (long)n);
        if (categoryInfoArray != null && n == 1) {
            try {
                this.cmdListManager.getActiveSDARSCmd().updateCategoryList(categoryInfoArray);
            }
            catch (Exception exception) {
                this.lc.log(10000, "[DSISDARSTunerCmdListener.updateCategoryList]", (Throwable)exception);
            }
        }
    }

    @Override
    public void updateStaticTaggingInfo(String string, String string2, int n) {
        this.lc.log(-2137614336, "[DSISDARSTunerCmdListener.updateStaticTaggingInfo] #iTunes:%1 valid:%2", (Object)string, (long)n);
        this.lc.log(-2137614336, "[DSISDARSTunerCmdListener.updateStaticTaggingInfo] #affiliateID:%1 valid:%2", (Object)string2, (long)n);
        if (string != null && string2 != null && n == 1) {
            try {
                this.cmdListManager.getActiveSDARSCmd().updateStaticTaggingInfo(string, string2);
            }
            catch (Exception exception) {
                this.lc.log(10000, "[DSISDARSTunerCmdListener.iTunesSXMURL != null && ]", (Throwable)exception);
            }
        }
    }

    @Override
    public void updateDetectedDevice(int n, int n2) {
        this.lc.log(-2137614336, "[DSISDARSTunerCmdListener.updateDetectedDevice] #device:%1 valid:%2", (long)n, (long)n2);
        if (n2 == 1) {
            try {
                this.cmdListManager.getActiveSDARSCmd().updateDetectedDevice(n);
            }
            catch (Exception exception) {
                this.lc.log(10000, "[DSISDARSTunerCmdListener.updateDetectedDevice]", (Throwable)exception);
            }
        }
    }

    @Override
    public void selectStationStatus(int n) {
        this.lc.log(-2137614336, "[DSISDARSTunerCmdListener.selectStationStatus] #status:%1", (long)n);
        try {
            this.cmdListManager.getActiveSDARSCmd().selectStationStatus(n);
        }
        catch (Exception exception) {
            this.lc.log(10000, "[DSISDARSTunerCmdListener.selectStationStatus]", (Throwable)exception);
        }
    }

    @Override
    public void updateAvailability(int n, int n2) {
        this.lc.log(-2137614336, "[DSISDARSTunerCmdListener.updateAvailability] #availability:%1 valid:%2", (long)n, (long)n2);
        if (n2 == 1) {
            try {
                this.cmdListManager.getActiveSDARSCmd().updateAvailability(n);
            }
            catch (Exception exception) {
                this.lc.log(10000, "[DSISDARSTunerCmdListener.updateAvailability]", (Throwable)exception);
            }
        }
    }

    @Override
    public void updateStationDescription(StationDescription[] stationDescriptionArray, int n) {
        this.lc.log(-2137614336, "[DSISDARSTunerCmdListener.updateStationDescription] #list:%1 valid:%2", (long)this.size(stationDescriptionArray), (long)n);
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

    @Override
    public void responseTime(DateTime dateTime) {
        this.lc.log(-2137614336, "[DSISDARSTunerCmdListener.responseTime] time:%1 ", (Object)dateTime);
        if (dateTime != null) {
            try {
                this.cmdListManager.getActiveSDARSCmd().responseTime(dateTime);
            }
            catch (Exception exception) {
                this.lc.log(10000, "[DSISDARSTunerCmdListener.responseTime]", (Throwable)exception);
            }
        }
    }

    @Override
    public void updateSubscriptionStatus(SubscriptionStatus subscriptionStatus, int n) {
        this.lc.log(-2137614336, "[DSISDARSTunerCmdListener.updateSubscriptionStatus]:%1 valid:%2", (Object)subscriptionStatus, (long)n);
        if (subscriptionStatus != null && n == 1) {
            try {
                this.cmdListManager.getActiveSDARSCmd().updateSubscriptionStatus(subscriptionStatus);
            }
            catch (Exception exception) {
                this.lc.log(10000, "[DSISDARSTunerCmdListener.updateSubscriptionStatus]", (Throwable)exception);
            }
        }
    }

    @Override
    public void informationRadioText(RadioText radioText) {
        this.lc.log(-2137614336, "[DSISDARSTunerCmdListener.informationRadioText]: %1", (Object)radioText);
        if (radioText != null) {
            try {
                this.cmdListManager.getActiveSDARSCmd().informationRadioText(radioText);
            }
            catch (Exception exception) {
                this.lc.log(10000, "[DSISDARSTunerCmdListener.informationRadioText]", (Throwable)exception);
            }
        }
    }

    @Override
    public void informationRadioText2(RadioText[] radioTextArray) {
        this.lc.log(-2137614336, "[DSISDARSTunerCmdListener.informationRadioText2] list:%1", (long)this.size(radioTextArray));
        if (radioTextArray != null) {
            try {
                this.cmdListManager.getActiveSDARSCmd().informationRadioText2(radioTextArray);
            }
            catch (Exception exception) {
                this.lc.log(10000, "[DSISDARSTunerCmdListener.informationRadioText2]", (Throwable)exception);
            }
        }
    }

    @Override
    public void responseEPG24Hour(EPGShortInfo ePGShortInfo) {
        this.lc.log(-2137614336, "[DSISDARSTunerCmdListener.responseEPG24Hour] short info:%1", (Object)ePGShortInfo);
        if (ePGShortInfo != null) {
            try {
                this.cmdListManager.getActiveSDARSCmd().responseEPG24Hour(ePGShortInfo);
            }
            catch (Exception exception) {
                this.lc.log(10000, "[DSISDARSTunerCmdListener.responseEPG24Hour]", (Throwable)exception);
            }
        }
    }

    @Override
    public void responseEPGDescription(EPGDescription ePGDescription) {
        this.lc.log(-2137614336, "[DSISDARSTunerCmdListener.responseEPGDescription] description:%1", (Object)ePGDescription);
        if (ePGDescription != null) {
            try {
                this.cmdListManager.getActiveSDARSCmd().responseEPGDescription(ePGDescription);
            }
            catch (Exception exception) {
                this.lc.log(10000, "[DSISDARSTunerCmdListener.responseEPGDescription]", (Throwable)exception);
            }
        }
    }

    @Override
    public void informationEPGChannelList(EPGShortInfo[] ePGShortInfoArray) {
        this.lc.log(-2137614336, "[DSISDARSTunerCmdListener.informationEPGChannelList] list:%1", (long)this.size(ePGShortInfoArray));
        if (ePGShortInfoArray != null) {
            try {
                this.cmdListManager.getActiveSDARSCmd().informationEPGChannelList(ePGShortInfoArray);
            }
            catch (Exception exception) {
                this.lc.log(10000, "[DSISDARSTunerCmdListener.informationEPGChannelList]", (Throwable)exception);
            }
        }
    }

    @Override
    public void informationChannelArt(ImageInformation[] imageInformationArray) {
        this.lc.log(-2137614336, "[DSISDARSTunerCmdListener.informationChannelArt] list:%1", (long)this.size(imageInformationArray));
        if (imageInformationArray != null) {
            try {
                this.cmdListManager.getActiveSDARSCmd().informationChannelArt(imageInformationArray);
            }
            catch (Exception exception) {
                this.lc.log(10000, "[DSISDARSTunerCmdListener.informationChannelArt]", (Throwable)exception);
            }
        }
    }

    @Override
    public void informationBackgroundArt(ImageInformation[] imageInformationArray) {
    }

    @Override
    public void informationAlbumArt(ImageInformation[] imageInformationArray) {
    }

    @Override
    public void informationGenreArt(ImageInformation[] imageInformationArray) {
    }

    @Override
    public void informationStudioArt(ImageInformation[] imageInformationArray) {
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

