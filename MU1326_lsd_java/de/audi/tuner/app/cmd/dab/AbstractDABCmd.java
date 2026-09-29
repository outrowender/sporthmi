/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.cmd.dab;

import de.audi.tuner.app.cmd.AbstractRadioCmd;
import de.audi.tuner.app.cmd.dab.AbstractDABCmd$Builder;
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

    public AbstractDABCmd(AbstractDABCmd$Builder abstractDABCmd$Builder) {
        super(AbstractDABCmd$Builder.access$000(abstractDABCmd$Builder), AbstractDABCmd$Builder.access$100(abstractDABCmd$Builder), 2);
        this.defaultDABListener = AbstractDABCmd$Builder.access$200(abstractDABCmd$Builder);
        this.dabTuner = AbstractDABCmd$Builder.access$300(abstractDABCmd$Builder);
    }

    @Override
    public final void updateLinkingUsageStatus(int n) {
        this.defaultDABListener.updateLinkingUsageStatus(n);
    }

    @Override
    public void selectServiceStatus(int n) {
        this.defaultDABListener.selectServiceStatus(n);
    }

    @Override
    public final void updateSelectedEnsemble(EnsembleInfo ensembleInfo) {
        this.defaultDABListener.updateSelectedEnsemble(ensembleInfo);
    }

    @Override
    public final void updateSelectedService(ServiceInfo serviceInfo) {
        this.defaultDABListener.updateSelectedService(serviceInfo);
    }

    @Override
    public final void updateSelectedComponent(ComponentInfo componentInfo) {
        this.defaultDABListener.updateSelectedComponent(componentInfo);
    }

    @Override
    public final void updateSelectedFrequency(FrequencyInfo frequencyInfo) {
        this.defaultDABListener.updateSelectedFrequency(frequencyInfo);
    }

    @Override
    public final void updateEnsembleList(EnsembleInfo[] ensembleInfoArray) {
        this.defaultDABListener.updateEnsembleList(ensembleInfoArray);
    }

    @Override
    public final void updateServiceList(ServiceInfo[] serviceInfoArray) {
        this.defaultDABListener.updateServiceList(serviceInfoArray);
    }

    @Override
    public final void updateComponentList(ComponentInfo[] componentInfoArray) {
        this.defaultDABListener.updateComponentList(componentInfoArray);
    }

    @Override
    public final void updateDataServiceList(DataServiceInfo[] dataServiceInfoArray) {
        this.defaultDABListener.updateDataServiceList(dataServiceInfoArray);
    }

    @Override
    public final void updateFrequencyList(FrequencyInfo[] frequencyInfoArray) {
        this.defaultDABListener.updateFrequencyList(frequencyInfoArray);
    }

    @Override
    public final void updateRadioText(DABRadioText dABRadioText) {
        this.defaultDABListener.updateRadioText(dABRadioText);
    }

    @Override
    public final void updateSyncStatus(int n) {
        this.defaultDABListener.updateSyncStatus(n);
    }

    @Override
    public final void updateQuality(short s) {
        this.defaultDABListener.updateQuality(s);
    }

    @Override
    public final void updateLinkingSwitchStatus(int n) {
        this.defaultDABListener.updateLinkingSwitchStatus(n);
    }

    @Override
    public final void updateFrequencyTableSwitchStatus(int n) {
        this.defaultDABListener.updateFrequencyTableSwitchStatus(n);
    }

    @Override
    public final void updateLinkingStatus(int n) {
        this.defaultDABListener.updateLinkingStatus(n);
    }

    @Override
    public final void updateQualityInfo(String string) {
        this.defaultDABListener.updateQualityInfo(string);
    }

    @Override
    public final void seekServiceStatus(int n) {
        this.defaultDABListener.seekServiceStatus(n);
    }

    @Override
    public final void tuneEnsembleStatus(int n) {
        this.defaultDABListener.tuneEnsembleStatus(n);
    }

    @Override
    public final void selectDataServiceStatus(int n) {
        this.defaultDABListener.selectDataServiceStatus(n);
    }

    @Override
    public void forceLMUpdateStatus(int n) {
        this.defaultDABListener.forceLMUpdateStatus(n);
    }

    @Override
    public final void updateEpgLogoList(EPGLogo[] ePGLogoArray) {
        this.defaultDABListener.updateEpgLogoList(ePGLogoArray);
    }

    @Override
    public final void updateEPGMode(int n) {
        this.defaultDABListener.updateEPGMode(n);
    }

    @Override
    public final void updateEPGListData(EPGShortInfo[] ePGShortInfoArray) {
        this.defaultDABListener.updateEPGListData(ePGShortInfoArray);
    }

    @Override
    public final void updateEPGDetailData(EPGFullInfo ePGFullInfo) {
        this.defaultDABListener.updateEPGDetailData(ePGFullInfo);
    }

    @Override
    public void updateDetectedDevice(int n) {
        this.defaultDABListener.updateDetectedDevice(n);
    }

    @Override
    public void updateAvailability(int n) {
        this.defaultDABListener.updateAvailability(n);
    }

    @Override
    public void updateRadioTextPlusInfo(DABRadioTextPlusInfo dABRadioTextPlusInfo) {
        this.defaultDABListener.updateRadioTextPlusInfo(dABRadioTextPlusInfo);
    }

    @Override
    public void updateSlideShowInfo(DABSlideShowInfo dABSlideShowInfo) {
        this.defaultDABListener.updateSlideShowInfo(dABSlideShowInfo);
    }
}

