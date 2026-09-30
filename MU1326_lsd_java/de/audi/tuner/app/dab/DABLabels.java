/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.dab;

import de.audi.atip.hmi.model.HMIResourceLocator;
import de.audi.atip.hmi.model.ModelGroup;
import de.audi.tuner.app.TunerModels;
import de.audi.tuner.app.Utilities;
import de.audi.tuner.app.dab.DABDsiDownInfo;
import de.audi.tuner.app.dab.DABDsiUpInfo;
import de.audi.tuner.app.dab.DabReceptionStatus;
import de.audi.tuner.app.dab.DabStation;
import de.audi.tuner.app.misc.RadioHMIResourceLocator;
import de.audi.tuner.app.storage.TunerStorage;
import org.dsi.ifc.radio.EnsembleInfo;
import org.dsi.ifc.radio.FrequencyInfo;

class DABLabels {
    final DABDsiUpInfo dsiUpListener = new DsiUpListener();
    final DABDsiDownInfo dsiDownListener = new DsiDownListener();
    private final TunerModels models;
    private final ModelGroup cache = new ModelGroup();
    private static final int SLS_NO_DISPLAY_ALLOWED = 65535000;
    private FrequencyInfo[] frequencyList = new FrequencyInfo[0];
    private DabStation curStation = new DabStation();
    private DabReceptionStatus curReceptionStatus = new DabReceptionStatus(0, 0);
    private int preferedImageType;

    DABLabels(TunerModels tunerModels, TunerStorage tunerStorage) {
        this.models = tunerModels;
        this.preferedImageType = tunerStorage.loadPreferredImageType();
        tunerModels.getLabelModel(100930).setText("");
        tunerModels.getLabelModel(100931).setText("");
        tunerModels.getLabelModel(100931).setStatus(1);
        this.cache.add(tunerModels.getLabelModel(100362));
        this.cache.add(tunerModels.getLabelModel(100931));
        this.cache.add(tunerModels.getLabelModel(7, 100931));
        this.cache.add(tunerModels.getLabelModel(100360));
        this.cache.add(tunerModels.getLabelModel(100930));
        this.cache.add(tunerModels.getChoiceModel(100928));
        this.cache.add(tunerModels.getChoiceModel(100738));
        this.cache.add(tunerModels.getResourceLocatorModel(100737));
        this.cache.add(tunerModels.getResourceLocatorModel(100760));
    }

    public void setPrefImgType(int n) {
        this.preferedImageType = n;
        this.doUpdate(this.curStation, this.curReceptionStatus);
    }

    private void update(String string, EnsembleInfo ensembleInfo, int n) {
        this.models.getLabelModel(100930).setText(string);
        this.models.getLabelModel(100931).setText(ensembleInfo.getFullName());
        this.models.getLabelModel(7, 100931).setText(ensembleInfo.getFullName());
        this.models.getLabelModel(100360).setText(ensembleInfo.getShortName());
        this.models.getLabelModel(100362).setText(ensembleInfo.getFrequencyLabel());
        this.models.getChoiceModel(100928).setValue(n);
    }

    private void cleanLabels(String string) {
        this.models.getLabelModel(100930).setText("");
        this.models.getLabelModel(100931).setText("");
        this.models.getLabelModel(7, 100931).setText("");
        this.models.getLabelModel(100360).setText("");
        this.models.getLabelModel(100362).setText(string);
        this.models.getChoiceModel(100928).setValue(0);
        this.models.getChoiceModel(100367).setValue(0);
        this.cache.flush();
    }

    private void update(FrequencyInfo frequencyInfo) {
        this.models.getLabelModel(100362).setText(frequencyInfo.label);
        for (int i2 = 0; i2 < this.frequencyList.length; ++i2) {
            if (this.frequencyList[i2].frequency != frequencyInfo.frequency) continue;
            this.models.getRangeModel(100407).setValue(i2);
            return;
        }
        this.cache.flush();
    }

    void updateServiceFullName(String string) {
        this.models.getLabelModel(100930).setText(string);
        this.cache.flush();
    }

    private synchronized void doUpdate(DabStation dabStation, DabReceptionStatus dabReceptionStatus) {
        String string = dabStation.getFullName();
        this.update(string, dabStation.ensemble, dabStation.getPTY());
        HMIResourceLocator hMIResourceLocator = dabStation.getSlsImage();
        if (hMIResourceLocator.getMinDisplayDuration() == 65535000) {
            this.models.getChoiceModel(100315).setValue(1);
        } else {
            this.models.getChoiceModel(100315).setValue(0);
        }
        if (hMIResourceLocator.containsResourceURI()) {
            this.models.setChoiceDataUpdateMediator(100553, 1);
        } else {
            this.models.setChoiceDataUpdateMediator(100553, 3);
        }
        if (Utilities.isPGen1OrBentley() && !hMIResourceLocator.containsResourceURI()) {
            hMIResourceLocator = dabStation.getStationLogo();
        }
        this.models.getResourceLocatorModel(100936).setResourceLocator(hMIResourceLocator);
        if (dabReceptionStatus.linkStatus == 2) {
            this.models.getChoiceModel(100367).setValue(2);
        } else if (dabReceptionStatus.syncStatus == 4) {
            if (dabStation.getSlsImage().containsResourceURI()) {
                this.models.getChoiceModel(100367).setValue(3);
            } else {
                this.models.getChoiceModel(100367).setValue(0);
            }
        } else {
            this.models.getChoiceModel(100367).setValue(1);
        }
        RadioHMIResourceLocator radioHMIResourceLocator = dabStation.getImage(this.preferedImageType);
        this.models.getChoiceModel(100738).setValue(radioHMIResourceLocator.type);
        this.models.getResourceLocatorModel(100737).setResourceLocator(radioHMIResourceLocator);
        this.models.getResourceLocatorModel(100760).setResourceLocator(dabStation.getStationLogo());
        this.cache.flush();
    }

    static /* synthetic */ FrequencyInfo[] access$602(DABLabels dABLabels, FrequencyInfo[] frequencyInfoArray) {
        dABLabels.frequencyList = frequencyInfoArray;
        return frequencyInfoArray;
    }

    private class DsiUpListener
    extends DABDsiUpInfo {
        FrequencyInfo freq = new FrequencyInfo();

        private DsiUpListener() {
        }

        public void updateCurrentStation(DabStation dabStation, DabReceptionStatus dabReceptionStatus) {
            DABLabels.this.curStation = dabStation;
            DABLabels.this.curReceptionStatus = dabReceptionStatus;
            DABLabels.this.doUpdate(dabStation, dabReceptionStatus);
        }

        public void ensembleSeekIsRunning(String string) {
            DABLabels.this.cleanLabels(string);
        }

        public void updateFrequencyList(FrequencyInfo[] frequencyInfoArray) {
            DABLabels.access$602(DABLabels.this, frequencyInfoArray);
            DABLabels.this.models.getRangeModel(100407).setLimits(0, frequencyInfoArray.length - 1, 1);
            DABLabels.this.update(this.freq);
        }

        public void updateSelectedFrequency(FrequencyInfo frequencyInfo) {
            this.freq = frequencyInfo;
            DABLabels.this.update(frequencyInfo);
        }
    }

    private class DsiDownListener
    extends DABDsiDownInfo {
        private DsiDownListener() {
        }

        public void preTuneAction(DabStation dabStation, DabReceptionStatus dabReceptionStatus, int n) {
            DABLabels.this.curStation = dabStation;
            DABLabels.this.curReceptionStatus = dabReceptionStatus;
            DABLabels.this.doUpdate(dabStation, dabReceptionStatus);
        }
    }
}

