/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.audiodrawer;

import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.interapp.audio.drawer.AudioDrawerContext;
import de.audi.atip.interapp.audio.drawer.AudioDrawerContextListener;
import de.audi.tuner.app.Logger;
import de.audi.tuner.app.TunerBasics;
import de.esolutions.fw.util.commons.SimpleIntIntMap;

public class AudioDrawerStateTracker
implements AudioDrawerContextListener {
    private static final SimpleIntIntMap DRAWER_STATE_CONVERSION = new SimpleIntIntMap(4);
    private static final int NO_CONVERSION_AVAILABLE = -1;
    private final ChoiceModelApp audioDrawerStateChoice;
    private final ChoiceModelApp audioDrawerOpenedDuringSdarsAlertChoice;
    private final ChoiceModelApp sdarsAlertChoice;
    private volatile boolean entertainmentDrawerOpened;
    private final Logger logger;

    public AudioDrawerStateTracker(TunerBasics tunerBasics) {
        this.audioDrawerStateChoice = tunerBasics.getModels().getChoiceModel(100708);
        this.audioDrawerOpenedDuringSdarsAlertChoice = tunerBasics.getModels().getChoiceModel(100711);
        this.sdarsAlertChoice = tunerBasics.getModels().getChoiceModel(100655);
        this.logger = tunerBasics.getLogger();
    }

    public void updateActiveContext(AudioDrawerContext.Source source, int n) {
        boolean bl;
        this.logger.hmi.log(10000000, "[AudioDrawerStateTracker.updateActiveContext] source: %1, drawerState: %2", (Object)source, (long)n);
        boolean bl2 = bl = source != null && source.getColumn() == AudioDrawerContext.SOURCE_RADIO.getColumn();
        if (bl) {
            int n2 = DRAWER_STATE_CONVERSION.get(n);
            if (n2 != -1) {
                this.audioDrawerStateChoice.setValue(n2);
            }
            boolean bl3 = this.sdarsAlertChoice.getValue() != 0;
            boolean bl4 = n == 0;
            int n3 = bl3 && bl4 ? 1 : 0;
            this.audioDrawerOpenedDuringSdarsAlertChoice.setValue(n3);
        }
    }

    public void entertainmentDrawerOpened() {
        this.entertainmentDrawerOpened = true;
    }

    public void entertainmentDrawerClosed() {
        this.entertainmentDrawerOpened = false;
    }

    public boolean isEntertainmentDrawerOpened() {
        return this.entertainmentDrawerOpened;
    }

    static {
        DRAWER_STATE_CONVERSION.add(0, 0);
        DRAWER_STATE_CONVERSION.add(1, 1);
        DRAWER_STATE_CONVERSION.add(2, 2);
        DRAWER_STATE_CONVERSION.add(6, 3);
    }
}

