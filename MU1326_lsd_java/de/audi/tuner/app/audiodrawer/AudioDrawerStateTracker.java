/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.audiodrawer;

import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.interapp.audio.drawer.AudioDrawerContext;
import de.audi.atip.interapp.audio.drawer.AudioDrawerContext$Source;
import de.audi.atip.interapp.audio.drawer.AudioDrawerContextListener;
import de.audi.tuner.app.Logger;
import de.audi.tuner.app.TunerBasics;
import de.esolutions.fw.util.commons.SimpleIntIntMap;

public class AudioDrawerStateTracker
implements AudioDrawerContextListener {
    private static final SimpleIntIntMap DRAWER_STATE_CONVERSION = new SimpleIntIntMap(4);
    private static final int NO_CONVERSION_AVAILABLE;
    private final ChoiceModelApp audioDrawerStateChoice;
    private final ChoiceModelApp audioDrawerOpenedDuringSdarsAlertChoice;
    private final ChoiceModelApp sdarsAlertChoice;
    private volatile boolean entertainmentDrawerOpened;
    private final Logger logger;

    public AudioDrawerStateTracker(TunerBasics tunerBasics) {
        this.audioDrawerStateChoice = tunerBasics.getModels().getChoiceModel(1686700288);
        this.audioDrawerOpenedDuringSdarsAlertChoice = tunerBasics.getModels().getChoiceModel(1737031936);
        this.sdarsAlertChoice = tunerBasics.getModels().getChoiceModel(797507840);
        this.logger = tunerBasics.getLogger();
    }

    @Override
    public void updateActiveContext(AudioDrawerContext$Source audioDrawerContext$Source, int n) {
        boolean bl;
        this.logger.hmi.log(-2137614336, "[AudioDrawerStateTracker.updateActiveContext] source: %1, drawerState: %2", (Object)audioDrawerContext$Source, (long)n);
        boolean bl2 = bl = audioDrawerContext$Source != null && audioDrawerContext$Source.getColumn() == AudioDrawerContext.SOURCE_RADIO.getColumn();
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

    @Override
    public void entertainmentDrawerOpened() {
        this.entertainmentDrawerOpened = true;
    }

    @Override
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

