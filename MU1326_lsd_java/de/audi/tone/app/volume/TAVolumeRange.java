/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tone.app.volume;

import de.audi.atip.audio.AudioConnection;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.tone.app.volume.AbstractVolumeRange;
import de.audi.tone.app.volume.VolumeRangeManager;
import de.audi.tone.app.volume.greyout.DefaultGreyOutAndPopupHandler;

public class TAVolumeRange
extends AbstractVolumeRange {
    private static final int CONNECTION = 84;
    private String name = "TAVolumeRange";
    private final int[] volumeConnections = TAVolumeRange.merge(AudioConnection.TA_PTY31, 84);
    private final int[] greyOutConnections = AudioConnection.GREY_OUT_TA;

    TAVolumeRange(VolumeRangeManager volumeRangeManager) {
        super(volumeRangeManager, 1000024, 1000077, 84);
        ChoiceModelApp choiceModelApp = this.env.getChoiceModel(1000092);
        this.greyOutHandler = new DefaultGreyOutAndPopupHandler(choiceModelApp, this.greyOutConnections, this.env.lcHMI, this.name);
    }

    TAVolumeRange(VolumeRangeManager volumeRangeManager, int n) {
        super(volumeRangeManager, n, 1000077, 84);
        ChoiceModelApp choiceModelApp = this.env.getChoiceModel(1000092);
        this.greyOutHandler = new DefaultGreyOutAndPopupHandler(choiceModelApp, this.greyOutConnections, this.env.lcHMI, this.name);
    }

    protected String getName() {
        return this.name;
    }

    protected int getID() {
        return 1;
    }

    protected int[] getVolumeConnections() {
        return this.volumeConnections;
    }
}

