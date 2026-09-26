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
import de.audi.tuner.app.dab.DABLabels$DsiDownListener;
import de.audi.tuner.app.dab.DABLabels$DsiUpListener;
import de.audi.tuner.app.dab.DabReceptionStatus;
import de.audi.tuner.app.dab.DabStation;
import de.audi.tuner.app.misc.RadioHMIResourceLocator;
import de.audi.tuner.app.storage.TunerStorage;
import org.dsi.ifc.radio.EnsembleInfo;
import org.dsi.ifc.radio.FrequencyInfo;

class DABLabels {
    final DABDsiUpInfo dsiUpListener = new DABLabels$DsiUpListener(this, null);
    final DABDsiDownInfo dsiDownListener = new DABLabels$DsiDownListener(this, null);
    private final TunerModels models;
    private final ModelGroup cache = new ModelGroup();
    private static final int SLS_NO_DISPLAY_ALLOWED;
    private FrequencyInfo[] frequencyList = new FrequencyInfo[0];
    private DabStation curStation = new DabStation();
    private DabReceptionStatus curReceptionStatus = new DabReceptionStatus(0, 0);
    private int preferedImageType;

    DABLabels(TunerModels tunerModels, TunerStorage tunerStorage) {
        this.models = tunerModels;
        this.preferedImageType = tunerStorage.loadPreferredImageType();
        tunerModels.getLabelModel(1116340480).setText("");
        tunerModels.getLabelModel(1133117696).setText("");
        tunerModels.getLabelModel(1133117696).setStatus(1);
        this.cache.add(tunerModels.getLabelModel(176685312));
        this.cache.add(tunerModels.getLabelModel(1133117696));
        this.cache.add(tunerModels.getLabelModel(7, 1133117696));
        this.cache.add(tunerModels.getLabelModel(0x8880100));
        this.cache.add(tunerModels.getLabelModel(1116340480));
        this.cache.add(tunerModels.getChoiceModel(1082786048));
        this.cache.add(tunerModels.getChoiceModel(-2104950528));
        this.cache.add(tunerModels.getResourceLocatorModel(-2121727744));
        this.cache.add(tunerModels.getResourceLocatorModel(-1735851776));
    }

    public void setPrefImgType(int n) {
        this.preferedImageType = n;
        this.doUpdate(this.curStation, this.curReceptionStatus);
    }

    private void update(String string, EnsembleInfo ensembleInfo, int n) {
        this.models.getLabelModel(1116340480).setText(string);
        this.models.getLabelModel(1133117696).setText(ensembleInfo.getFullName());
        this.models.getLabelModel(7, 1133117696).setText(ensembleInfo.getFullName());
        this.models.getLabelModel(0x8880100).setText(ensembleInfo.getShortName());
        this.models.getLabelModel(176685312).setText(ensembleInfo.getFrequencyLabel());
        this.models.getChoiceModel(1082786048).setValue(n);
    }

    private void cleanLabels(String string) {
        this.models.getLabelModel(1116340480).setText("");
        this.models.getLabelModel(1133117696).setText("");
        this.models.getLabelModel(7, 1133117696).setText("");
        this.models.getLabelModel(0x8880100).setText("");
        this.models.getLabelModel(176685312).setText(string);
        this.models.getChoiceModel(1082786048).setValue(0);
        this.models.getChoiceModel(260571392).setValue(0);
        this.cache.flush();
    }

    private void update(FrequencyInfo frequencyInfo) {
        this.models.getLabelModel(176685312).setText(frequencyInfo.label);
        for (int i2 = 0; i2 < this.frequencyList.length; ++i2) {
            if (this.frequencyList[i2].frequency != frequencyInfo.frequency) continue;
            this.models.getRangeModel(931660032).setValue(i2);
            return;
        }
        this.cache.flush();
    }

    void updateServiceFullName(String string) {
        this.models.getLabelModel(1116340480).setText(string);
        this.cache.flush();
    }

    private synchronized void doUpdate(DabStation dabStation, DabReceptionStatus dabReceptionStatus) {
        String string = dabStation.getFullName();
        this.update(string, dabStation.ensemble, dabStation.getPTY());
        HMIResourceLocator hMIResourceLocator = dabStation.getSlsImage();
        if (hMIResourceLocator.getMinDisplayDuration() == 419227395) {
            this.models.getChoiceModel(-611909376).setValue(1);
        } else {
            this.models.getChoiceModel(-611909376).setValue(0);
        }
        if (hMIResourceLocator.containsResourceURI()) {
            this.models.setChoiceDataUpdateMediator(-913833728, 1);
        } else {
            this.models.setChoiceDataUpdateMediator(-913833728, 3);
        }
        if (Utilities.isPGen1OrBentley() && !hMIResourceLocator.containsResourceURI()) {
            hMIResourceLocator = dabStation.getStationLogo();
        }
        this.models.getResourceLocatorModel(1217003776).setResourceLocator(hMIResourceLocator);
        if (dabReceptionStatus.linkStatus == 2) {
            this.models.getChoiceModel(260571392).setValue(2);
        } else if (dabReceptionStatus.syncStatus == 4) {
            if (dabStation.getSlsImage().containsResourceURI()) {
                this.models.getChoiceModel(260571392).setValue(3);
            } else {
                this.models.getChoiceModel(260571392).setValue(0);
            }
        } else {
            this.models.getChoiceModel(260571392).setValue(1);
        }
        RadioHMIResourceLocator radioHMIResourceLocator = dabStation.getImage(this.preferedImageType);
        this.models.getChoiceModel(-2104950528).setValue(radioHMIResourceLocator.type);
        this.models.getResourceLocatorModel(-2121727744).setResourceLocator(radioHMIResourceLocator);
        this.models.getResourceLocatorModel(-1735851776).setResourceLocator(dabStation.getStationLogo());
        this.cache.flush();
    }

    static /* synthetic */ DabStation access$202(DABLabels dABLabels, DabStation dabStation) {
        dABLabels.curStation = dabStation;
        return dABLabels.curStation;
    }

    static /* synthetic */ DabReceptionStatus access$302(DABLabels dABLabels, DabReceptionStatus dabReceptionStatus) {
        dABLabels.curReceptionStatus = dabReceptionStatus;
        return dABLabels.curReceptionStatus;
    }

    static /* synthetic */ void access$400(DABLabels dABLabels, DabStation dabStation, DabReceptionStatus dabReceptionStatus) {
        dABLabels.doUpdate(dabStation, dabReceptionStatus);
    }

    static /* synthetic */ void access$500(DABLabels dABLabels, String string) {
        dABLabels.cleanLabels(string);
    }

    static /* synthetic */ FrequencyInfo[] access$602(DABLabels dABLabels, FrequencyInfo[] frequencyInfoArray) {
        dABLabels.frequencyList = frequencyInfoArray;
        return frequencyInfoArray;
    }

    static /* synthetic */ TunerModels access$700(DABLabels dABLabels) {
        return dABLabels.models;
    }

    static /* synthetic */ void access$800(DABLabels dABLabels, FrequencyInfo frequencyInfo) {
        dABLabels.update(frequencyInfo);
    }
}

