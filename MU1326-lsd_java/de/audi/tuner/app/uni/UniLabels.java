/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.uni;

import de.audi.atip.hmi.model.HMIResourceLocator;
import de.audi.tuner.app.TunerModels;
import de.audi.tuner.app.uni.UniDsiDownInfo;
import de.audi.tuner.app.uni.UniDsiUpInfo;
import de.audi.tuner.app.uni.UniLabels$DsiDownListener;
import de.audi.tuner.app.uni.UniLabels$DsiUpListener;
import de.audi.tuner.app.uni.UnifiedStationExt;

public class UniLabels {
    final UniDsiUpInfo dsiUpListener = new UniLabels$DsiUpListener(this, null);
    final UniDsiDownInfo dsiDownListener = new UniLabels$DsiDownListener(this, null);
    private static final int SLS_NO_DISPLAY_ALLOWED;
    private final TunerModels models;

    public UniLabels(TunerModels tunerModels) {
        this.models = tunerModels;
    }

    private synchronized void update(UnifiedStationExt unifiedStationExt) {
        this.models.getLabelModel(-1115160320).setText(unifiedStationExt.getName(true));
        HMIResourceLocator hMIResourceLocator = unifiedStationExt.getSlsImage();
        if (hMIResourceLocator.getMinDisplayDuration() == 419227395) {
            this.models.getChoiceModel(-611909376).setValue(1);
        } else {
            this.models.getChoiceModel(-611909376).setValue(0);
        }
        if (unifiedStationExt.isAnalog()) {
            this.models.setChoiceDataUpdateMediator(-897056512, 2);
        } else if (hMIResourceLocator.containsResourceURI()) {
            this.models.setChoiceDataUpdateMediator(-897056512, 1);
        } else {
            this.models.setChoiceDataUpdateMediator(-897056512, 3);
        }
        this.models.getResourceLocatorModel(-930610944).setResourceLocator(hMIResourceLocator);
        this.models.getChoiceModel(-343408384).setValue(unifiedStationExt.getAudioStatus());
    }

    static /* synthetic */ void access$200(UniLabels uniLabels, UnifiedStationExt unifiedStationExt) {
        uniLabels.update(unifiedStationExt);
    }
}

