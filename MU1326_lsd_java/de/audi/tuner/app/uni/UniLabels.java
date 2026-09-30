/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.uni;

import de.audi.atip.hmi.model.HMIResourceLocator;
import de.audi.tuner.app.TunerModels;
import de.audi.tuner.app.uni.UniDsiDownInfo;
import de.audi.tuner.app.uni.UniDsiUpInfo;
import de.audi.tuner.app.uni.UnifiedStationExt;

public class UniLabels {
    final UniDsiUpInfo dsiUpListener = new DsiUpListener();
    final UniDsiDownInfo dsiDownListener = new DsiDownListener();
    private static final int SLS_NO_DISPLAY_ALLOWED = 65535000;
    private final TunerModels models;

    public UniLabels(TunerModels tunerModels) {
        this.models = tunerModels;
    }

    private synchronized void update(UnifiedStationExt unifiedStationExt) {
        this.models.getLabelModel(100541).setText(unifiedStationExt.getName(true));
        HMIResourceLocator hMIResourceLocator = unifiedStationExt.getSlsImage();
        if (hMIResourceLocator.getMinDisplayDuration() == 65535000) {
            this.models.getChoiceModel(100315).setValue(1);
        } else {
            this.models.getChoiceModel(100315).setValue(0);
        }
        if (unifiedStationExt.isAnalog()) {
            this.models.setChoiceDataUpdateMediator(100554, 2);
        } else if (hMIResourceLocator.containsResourceURI()) {
            this.models.setChoiceDataUpdateMediator(100554, 1);
        } else {
            this.models.setChoiceDataUpdateMediator(100554, 3);
        }
        this.models.getResourceLocatorModel(100552).setResourceLocator(hMIResourceLocator);
        this.models.getChoiceModel(100587).setValue(unifiedStationExt.getAudioStatus());
    }

    private class DsiUpListener
    extends UniDsiUpInfo {
        private DsiUpListener() {
        }

        public void updateSelectedStation(UnifiedStationExt unifiedStationExt) {
            UniLabels.this.update(unifiedStationExt);
        }
    }

    private class DsiDownListener
    extends UniDsiDownInfo {
        private DsiDownListener() {
        }

        public void preTuneCommand(UnifiedStationExt unifiedStationExt) {
            UniLabels.this.update(unifiedStationExt);
        }
    }
}

