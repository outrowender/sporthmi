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
    private static final int CONNECTION;
    private final int[] volumeConnections = SDSVolumeRange.merge(AudioConnection.SDS, 86);
    private final int[] greyOutConnections = AudioConnection.GREY_OUT_ALL;
    private final SDSSamplePlayer samplePlayer;
    private final String name;

    SDSVolumeRange(VolumeRangeManager volumeRangeManager) {
        super(volumeRangeManager, 1463947008, -2109600000, 86);
        this.name = "SDSVolumeRange";
        this.samplePlayer = new SDSSamplePlayer(this.env.lcMain);
        ChoiceModelApp choiceModelApp = this.env.getChoiceModel(-1774055680);
        this.greyOutHandler = new DefaultGreyOutAndPopupHandler(choiceModelApp, this.greyOutConnections, this.env.lcHMI, "SDSVolumeRange");
    }

    @Override
    protected String getName() {
        return "SDSVolumeRange";
    }

    @Override
    protected int getID() {
        return 2;
    }

    @Override
    protected ISamplePlayer getSamplePlayer() {
        return this.samplePlayer;
    }

    @Override
    protected int[] getVolumeConnections() {
        return this.volumeConnections;
    }
}

