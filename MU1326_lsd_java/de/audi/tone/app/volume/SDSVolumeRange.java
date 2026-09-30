/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tone.app.volume;

import de.audi.atip.audio.AudioConnection;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.tone.app.volume.AbstractVolumeRange;
import de.audi.tone.app.volume.VolumeRangeManager;
import de.audi.tone.app.volume.greyout.DefaultGreyOutAndPopupHandler;
import de.audi.tone.app.volume.samples.ISamplePlayer;
import de.audi.tone.app.volume.samples.SDSSamplePlayer;

public class SDSVolumeRange
extends AbstractVolumeRange {
    private static final int CONNECTION = 86;
    private final int[] volumeConnections = SDSVolumeRange.merge(AudioConnection.SDS, 86);
    private final int[] greyOutConnections = AudioConnection.GREY_OUT_ALL;
    private final SDSSamplePlayer samplePlayer;
    private final String name;

    SDSVolumeRange(VolumeRangeManager volumeRangeManager) {
        super(volumeRangeManager, 1000023, 1000066, 86);
        this.name = "SDSVolumeRange";
        this.samplePlayer = new SDSSamplePlayer(this.env.lcMain);
        ChoiceModelApp choiceModelApp = this.env.getChoiceModel(1000086);
        this.greyOutHandler = new DefaultGreyOutAndPopupHandler(choiceModelApp, this.greyOutConnections, this.env.lcHMI, "SDSVolumeRange");
    }

    protected String getName() {
        return "SDSVolumeRange";
    }

    protected int getID() {
        return 2;
    }

    protected ISamplePlayer getSamplePlayer() {
        return this.samplePlayer;
    }

    protected int[] getVolumeConnections() {
        return this.volumeConnections;
    }
}

