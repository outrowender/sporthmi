/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.cmd;

import de.audi.atip.audio.HMIAudioServiceListener;
import de.audi.atip.log.LogChannel;
import de.audi.tuner.app.TunerBasics;
import de.audi.tuner.app.cmd.uni.IUnifiedTuner;
import de.audi.tuner.ifc.AMFMTunerListener;
import de.audi.tuner.ifc.DABTunerListener;
import de.audi.tuner.ifc.IAMFMTuner;
import de.audi.tuner.ifc.IDABTuner;
import de.audi.tuner.ifc.IRadioAudioService;
import de.audi.tuner.ifc.ISDARSTuner;
import de.audi.tuner.ifc.SDARSTunerListener;
import de.audi.tuner.ifc.UnifiedTunerListener;

public class RadioCmdManager$Builder {
    private final LogChannel lc;
    private final TunerBasics basics;
    private IAMFMTuner amfmTuner;
    private AMFMTunerListener amfmDefaultListener;
    private IDABTuner dabTuner;
    private DABTunerListener dabDefaultListener;
    private ISDARSTuner sdarsTuner;
    private SDARSTunerListener sdarsDefaultListener;
    private IUnifiedTuner unifiedTuner;
    private UnifiedTunerListener unifiedDefaultListener;
    private IRadioAudioService audioService;
    private HMIAudioServiceListener audioDefaultListener;

    public RadioCmdManager$Builder(TunerBasics tunerBasics) {
        this.basics = tunerBasics;
        this.lc = tunerBasics.getLogger().jobs;
    }

    public void setAMFMTuner(IAMFMTuner iAMFMTuner) {
        this.amfmTuner = iAMFMTuner;
    }

    public void setAMFMDefaultListener(AMFMTunerListener aMFMTunerListener) {
        this.amfmDefaultListener = aMFMTunerListener;
    }

    public void setDABTuner(IDABTuner iDABTuner) {
        this.dabTuner = iDABTuner;
    }

    public void setDABDefaultListener(DABTunerListener dABTunerListener) {
        this.dabDefaultListener = dABTunerListener;
    }

    public void setSDARSTuner(ISDARSTuner iSDARSTuner) {
        this.sdarsTuner = iSDARSTuner;
    }

    public void setSDARSDefaultListener(SDARSTunerListener sDARSTunerListener) {
        this.sdarsDefaultListener = sDARSTunerListener;
    }

    public void setUnifiedTuner(IUnifiedTuner iUnifiedTuner) {
        this.unifiedTuner = iUnifiedTuner;
    }

    public void setUnifiedDefaultListener(UnifiedTunerListener unifiedTunerListener) {
        this.unifiedDefaultListener = unifiedTunerListener;
    }

    public void setAudioService(IRadioAudioService iRadioAudioService) {
        this.audioService = iRadioAudioService;
    }

    public void setAudioDefaultListener(HMIAudioServiceListener hMIAudioServiceListener) {
        this.audioDefaultListener = hMIAudioServiceListener;
    }

    static /* synthetic */ LogChannel access$000(RadioCmdManager$Builder radioCmdManager$Builder) {
        return radioCmdManager$Builder.lc;
    }

    static /* synthetic */ TunerBasics access$100(RadioCmdManager$Builder radioCmdManager$Builder) {
        return radioCmdManager$Builder.basics;
    }

    static /* synthetic */ IAMFMTuner access$200(RadioCmdManager$Builder radioCmdManager$Builder) {
        return radioCmdManager$Builder.amfmTuner;
    }

    static /* synthetic */ AMFMTunerListener access$300(RadioCmdManager$Builder radioCmdManager$Builder) {
        return radioCmdManager$Builder.amfmDefaultListener;
    }

    static /* synthetic */ IRadioAudioService access$400(RadioCmdManager$Builder radioCmdManager$Builder) {
        return radioCmdManager$Builder.audioService;
    }

    static /* synthetic */ HMIAudioServiceListener access$500(RadioCmdManager$Builder radioCmdManager$Builder) {
        return radioCmdManager$Builder.audioDefaultListener;
    }

    static /* synthetic */ IDABTuner access$600(RadioCmdManager$Builder radioCmdManager$Builder) {
        return radioCmdManager$Builder.dabTuner;
    }

    static /* synthetic */ DABTunerListener access$700(RadioCmdManager$Builder radioCmdManager$Builder) {
        return radioCmdManager$Builder.dabDefaultListener;
    }

    static /* synthetic */ ISDARSTuner access$800(RadioCmdManager$Builder radioCmdManager$Builder) {
        return radioCmdManager$Builder.sdarsTuner;
    }

    static /* synthetic */ SDARSTunerListener access$900(RadioCmdManager$Builder radioCmdManager$Builder) {
        return radioCmdManager$Builder.sdarsDefaultListener;
    }

    static /* synthetic */ IUnifiedTuner access$1000(RadioCmdManager$Builder radioCmdManager$Builder) {
        return radioCmdManager$Builder.unifiedTuner;
    }

    static /* synthetic */ UnifiedTunerListener access$1100(RadioCmdManager$Builder radioCmdManager$Builder) {
        return radioCmdManager$Builder.unifiedDefaultListener;
    }
}

