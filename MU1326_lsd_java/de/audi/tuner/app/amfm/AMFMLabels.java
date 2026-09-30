/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.amfm;

import de.audi.tuner.app.Logger;
import de.audi.tuner.app.TunerBasics;
import de.audi.tuner.app.TunerModels;
import de.audi.tuner.app.Utilities;
import de.audi.tuner.app.amfm.AMFMStation;
import de.audi.tuner.app.amfm.dsi.AMFMDsiDownInfo;
import de.audi.tuner.app.amfm.dsi.AMFMDsiUpInfo;
import de.audi.tuner.app.misc.RadioHMIResourceLocator;
import de.esolutions.fw.util.commons.Buffer;

class AMFMLabels {
    final AMFMDsiUpInfo amfmDsiUpListener = new DsiUpListener();
    final AMFMDsiDownInfo dsiDownListener = new DSIDownListener();
    public static final int PORSCHE_STATIONNAME_MAXLEN = 8;
    private static final int PORSCHE_SLEEPSCREEN_LOGO_MIN_DISPLAY_DURATION = 5000;
    private final Logger logger;
    private final TunerModels models;
    private final String fmUnitLabel;
    private final String amUnitLabel;

    AMFMLabels(TunerBasics tunerBasics) {
        this.logger = tunerBasics.getLogger();
        this.models = tunerBasics.getModels();
        if (Utilities.isShowFreqUnit()) {
            this.fmUnitLabel = "MHz";
            this.amUnitLabel = "kHz";
        } else {
            this.fmUnitLabel = "";
            this.amUnitLabel = "";
        }
    }

    private String getPorscheTuneScreenStationName(AMFMStation aMFMStation) {
        if (aMFMStation != null) {
            if (aMFMStation.getFullNameNoExtension().length() > 8) {
                return aMFMStation.getFrequencyStringAndExt();
            }
            return aMFMStation.getFullNameNoExtension();
        }
        return "";
    }

    private void updateLabels(AMFMStation aMFMStation, boolean bl) {
        this.logger.amfmGUI.log(10000000, "[AMFMLabels.updateLabels] %1", (Object)aMFMStation);
        Buffer buffer = new Buffer(20);
        if (aMFMStation.waveband == 1) {
            this.updateLabelsFM(aMFMStation, buffer);
        } else {
            this.updateLabelsAM(aMFMStation, buffer);
        }
        this.models.getChoiceModel(100605).setValue(aMFMStation.isRds() ? 1 : 0);
        RadioHMIResourceLocator radioHMIResourceLocator = new RadioHMIResourceLocator(aMFMStation.getImage(1));
        radioHMIResourceLocator.setMinDisplayDuration(bl ? 0 : 5000);
        this.models.getChoiceModel(100739).setValue(radioHMIResourceLocator.type);
        this.models.getResourceLocatorModel(100934).setResourceLocator(radioHMIResourceLocator);
        this.models.getResourceLocatorModel(7, 100934).setResourceLocator(radioHMIResourceLocator);
        RadioHMIResourceLocator radioHMIResourceLocator2 = aMFMStation.getImage(0);
        this.models.getResourceLocatorModel(100804).setResourceLocator(radioHMIResourceLocator2);
        this.models.getChoiceModel(100929).setValue(aMFMStation.ptyCode);
        String string = aMFMStation.getFrequencyString();
        Buffer buffer2 = new Buffer(20).append(aMFMStation.getRawFrequencyString());
        if (aMFMStation.isHd()) {
            buffer2.append(' ').append(aMFMStation.getHdExtension());
        }
        string = buffer2.toString();
        this.models.getLabelModel(100932).setText(string);
        if (aMFMStation.isRds() && !aMFMStation.isHd()) {
            this.models.getChoiceModel(100540).setValue(aMFMStation.isPsFreezed() ? 1 : 0);
        } else {
            this.models.getChoiceModel(100540).setValue(2);
        }
        if (aMFMStation.isHd() && aMFMStation.getHdStructure() > 1) {
            this.models.getButtonModel(100603).setStatus(1);
        } else {
            this.models.getButtonModel(100603).setStatus(3);
        }
        int n = aMFMStation.hd ? aMFMStation.getAudioStatus() : 0;
        this.models.getChoiceModel(100425).setValue(n);
        this.models.getLabelModel(100424).setText(aMFMStation.getHdExtension());
        if (aMFMStation.isHd()) {
            buffer.append(' ').append(aMFMStation.getHdExtension());
        }
        this.models.getLabelModel(100914).setText(buffer.toString());
    }

    private void updateLabelsAM(AMFMStation aMFMStation, Buffer buffer) {
        this.models.getLabelModel(100402).setText(String.valueOf(aMFMStation.frequency));
        this.models.getLabelModel(100935).setText(this.amUnitLabel);
        buffer.append(aMFMStation.frequency);
        if (!Utilities.isEmpty(this.amUnitLabel)) {
            buffer.append(' ').append(this.amUnitLabel);
        }
        String string = Utilities.isPGen1OrBentley() ? aMFMStation.getFullNameNoExtension() : aMFMStation.getFullName();
        this.models.getLabelModel(100933).setText(string);
        if (string.length() != 0) {
            this.models.getLabelModel(100182).setText(aMFMStation.getFullName());
        } else {
            this.models.getLabelModel(100182).setText(aMFMStation.getFrequencyString());
        }
    }

    private void updateLabelsFM(AMFMStation aMFMStation, Buffer buffer) {
        String string;
        String string2 = Utilities.kHzToMHz(aMFMStation.frequency);
        this.models.getLabelModel(100402).setText(string2);
        this.models.getLabelModel(100935).setText(this.fmUnitLabel);
        buffer.append(string2);
        if (!Utilities.isEmpty(this.fmUnitLabel)) {
            buffer.append(' ').append(this.fmUnitLabel);
        }
        String string3 = Utilities.isPGen1OrBentley() ? aMFMStation.getFullNameNoExtension() : aMFMStation.getFullName();
        this.models.getLabelModel(100933).setText(string3);
        String string4 = string = Utilities.isPGen1OrBentley() ? this.getPorscheTuneScreenStationName(aMFMStation) : aMFMStation.getFullName();
        if (string.length() != 0) {
            this.models.getLabelModel(100182).setText(string);
        } else {
            this.models.getLabelModel(100182).setText(aMFMStation.getFrequencyString());
        }
        if (aMFMStation.isPsFreezed()) {
            this.models.getButtonModel(100146).setPressed(true);
            this.models.getButtonModel(100146).setStatus(1);
        } else {
            this.models.getButtonModel(100146).setPressed(false);
            if (aMFMStation.isRds()) {
                this.models.getButtonModel(100146).setStatus(1);
            }
        }
    }

    private class DsiUpListener
    extends AMFMDsiUpInfo {
        private DsiUpListener() {
        }

        public void updateSelectedStation(AMFMStation aMFMStation) {
            AMFMLabels.this.updateLabels(aMFMStation, false);
        }

        public void updateSeekStation(AMFMStation aMFMStation) {
            AMFMLabels.this.updateLabels(aMFMStation, false);
        }
    }

    private class DSIDownListener
    extends AMFMDsiDownInfo {
        private DSIDownListener() {
        }

        public void preTuneAction(AMFMStation aMFMStation, boolean bl) {
            AMFMLabels.this.updateLabels(aMFMStation, true);
        }
    }
}

