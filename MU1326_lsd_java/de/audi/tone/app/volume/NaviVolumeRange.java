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
import de.audi.tone.app.volume.samples.NaviSamplePlayer;

public class NaviVolumeRange
extends AbstractVolumeRange {
    private static final int CONNECTION = 83;
    private final ISamplePlayer samplePlayer;
    private final int[] volumeConnections = NaviVolumeRange.merge(AudioConnection.NAVI, 83);
    private final int[] greyOutConnections = AudioConnection.GREY_OUT_NAVI;
    private final String name;

    NaviVolumeRange(VolumeRangeManager volumeRangeManager) {
        this(volumeRangeManager, 1000022);
    }

    NaviVolumeRange(VolumeRangeManager volumeRangeManager, int n) {
        super(volumeRangeManager, n, 1000063, 83);
        this.name = "NaviVolumeRange";
        ChoiceModelApp choiceModelApp = this.env.getChoiceModel(1000085);
        this.greyOutHandler = new DefaultGreyOutAndPopupHandler(choiceModelApp, this.greyOutConnections, this.env.lcHMI, "NaviVolumeRange");
        this.samplePlayer = new NaviSamplePlayer(this.env.lcMain);
    }

    protected String getName() {
        return "NaviVolumeRange";
    }

    protected int getID() {
        return 0;
    }

    protected ISamplePlayer getSamplePlayer() {
        return this.samplePlayer;
    }

    protected int[] getVolumeConnections() {
        return this.volumeConnections;
    }

    protected void left() {
        super.left();
        this.samplePlayer.stop();
    }
}

