/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.cmd.dab;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.log.LogChannel;
import de.audi.tuner.app.cmd.AbstractRadioCmd;
import de.audi.tuner.ifc.DABTunerListener;
import de.audi.tuner.ifc.IDABTuner;
import org.dsi.ifc.radio.ComponentInfo;
import org.dsi.ifc.radio.DABRadioText;
import org.dsi.ifc.radio.DABRadioTextPlusInfo;
import org.dsi.ifc.radio.DABSlideShowInfo;
import org.dsi.ifc.radio.DataServiceInfo;
import org.dsi.ifc.radio.EPGFullInfo;
import org.dsi.ifc.radio.EPGLogo;
import org.dsi.ifc.radio.EPGShortInfo;
import org.dsi.ifc.radio.EnsembleInfo;
import org.dsi.ifc.radio.FrequencyInfo;
import org.dsi.ifc.radio.ServiceInfo;

public abstract class AbstractDABCmd
extends AbstractRadioCmd
implements DABTunerListener {
    private final DABTunerListener defaultDABListener;
    protected final IDABTuner dabTuner;

    public AbstractDABCmd(Builder builder) {
        super(builder.framework, builder.lc, 2);
        this.defaultDABListener = builder.defaultDABListener;
        this.dabTuner = builder.dabTuner;
    }

    public final void updateLinkingUsageStatus(int n) {
        this.defaultDABListener.updateLinkingUsageStatus(n);
    }

    public void selectServiceStatus(int n) {
        this.defaultDABListener.selectServiceStatus(n);
    }

    public final void updateSelectedEnsemble(EnsembleInfo ensembleInfo) {
        this.defaultDABListener.updateSelectedEnsemble(ensembleInfo);
    }

    public final void updateSelectedService(ServiceInfo serviceInfo) {
        this.defaultDABListener.updateSelectedService(serviceInfo);
    }

    public final void updateSelectedComponent(ComponentInfo componentInfo) {
        this.defaultDABListener.updateSelectedComponent(componentInfo);
    }

    public final void updateSelectedFrequency(FrequencyInfo frequencyInfo) {
        this.defaultDABListener.updateSelectedFrequency(frequencyInfo);
    }

    public final void updateEnsembleList(EnsembleInfo[] ensembleInfoArray) {
        this.defaultDABListener.updateEnsembleList(ensembleInfoArray);
    }

    public final void updateServiceList(ServiceInfo[] serviceInfoArray) {
        this.defaultDABListener.updateServiceList(serviceInfoArray);
    }

    public final void updateComponentList(ComponentInfo[] componentInfoArray) {
        this.defaultDABListener.updateComponentList(componentInfoArray);
    }

    public final void updateDataServiceList(DataServiceInfo[] dataServiceInfoArray) {
        this.defaultDABListener.updateDataServiceList(dataServiceInfoArray);
    }

    public final void updateFrequencyList(FrequencyInfo[] frequencyInfoArray) {
        this.defaultDABListener.updateFrequencyList(frequencyInfoArray);
    }

    public final void updateRadioText(DABRadioText dABRadioText) {
        this.defaultDABListener.updateRadioText(dABRadioText);
    }

    public final void updateSyncStatus(int n) {
        this.defaultDABListener.updateSyncStatus(n);
    }

    public final void updateQuality(short s) {
        this.defaultDABListener.updateQuality(s);
    }

    public final void updateLinkingSwitchStatus(int n) {
        this.defaultDABListener.updateLinkingSwitchStatus(n);
    }

    public final void updateFrequencyTableSwitchStatus(int n) {
        this.defaultDABListener.updateFrequencyTableSwitchStatus(n);
    }

    public final void updateLinkingStatus(int n) {
        this.defaultDABListener.updateLinkingStatus(n);
    }

    public final void updateQualityInfo(String string) {
        this.defaultDABListener.updateQualityInfo(string);
    }

    public final void seekServiceStatus(int n) {
        this.defaultDABListener.seekServiceStatus(n);
    }

    public final void tuneEnsembleStatus(int n) {
        this.defaultDABListener.tuneEnsembleStatus(n);
    }

    public final void selectDataServiceStatus(int n) {
        this.defaultDABListener.selectDataServiceStatus(n);
    }

    public void forceLMUpdateStatus(int n) {
        this.defaultDABListener.forceLMUpdateStatus(n);
    }

    public final void updateEpgLogoList(EPGLogo[] ePGLogoArray) {
        this.defaultDABListener.updateEpgLogoList(ePGLogoArray);
    }

    public final void updateEPGMode(int n) {
        this.defaultDABListener.updateEPGMode(n);
    }

    public final void updateEPGListData(EPGShortInfo[] ePGShortInfoArray) {
        this.defaultDABListener.updateEPGListData(ePGShortInfoArray);
    }

    public final void updateEPGDetailData(EPGFullInfo ePGFullInfo) {
        this.defaultDABListener.updateEPGDetailData(ePGFullInfo);
    }

    public void updateDetectedDevice(int n) {
        this.defaultDABListener.updateDetectedDevice(n);
    }

    public void updateAvailability(int n) {
        this.defaultDABListener.updateAvailability(n);
    }

    public void updateRadioTextPlusInfo(DABRadioTextPlusInfo dABRadioTextPlusInfo) {
        this.defaultDABListener.updateRadioTextPlusInfo(dABRadioTextPlusInfo);
    }

    public void updateSlideShowInfo(DABSlideShowInfo dABSlideShowInfo) {
        this.defaultDABListener.updateSlideShowInfo(dABSlideShowInfo);
    }

    public static class Builder {
        private final LogChannel lc;
        private final IDABTuner dabTuner;
        private final DABTunerListener defaultDABListener;
        private final IFrameworkAccess framework;

        public Builder(IFrameworkAccess iFrameworkAccess, LogChannel logChannel, IDABTuner iDABTuner, DABTunerListener dABTunerListener) {
            this.framework = iFrameworkAccess;
            this.lc = logChannel;
            this.dabTuner = iDABTuner;
            this.defaultDABListener = dABTunerListener;
        }
    }
}

