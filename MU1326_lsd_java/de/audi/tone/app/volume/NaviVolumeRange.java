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
    private static final int CONNECTION;
    private final ISamplePlayer samplePlayer;
    private final int[] volumeConnections = NaviVolumeRange.merge(AudioConnection.NAVI, 83);
    private final int[] greyOutConnections = AudioConnection.GREY_OUT_NAVI;
    private final String name;

    NaviVolumeRange(VolumeRangeManager volumeRangeManager) {
        this(volumeRangeManager, 1447169792);
    }

    NaviVolumeRange(VolumeRangeManager volumeRangeManager, int n) {
        super(volumeRangeManager, n, 2135035648, 83);
        this.name = "NaviVolumeRange";
        ChoiceModelApp choiceModelApp = this.env.getChoiceModel(-1790832896);
        this.greyOutHandler = new DefaultGreyOutAndPopupHandler(choiceModelApp, this.greyOutConnections, this.env.lcHMI, "NaviVolumeRange");
        this.samplePlayer = new NaviSamplePlayer(this.env.lcMain);
    }

    @Override
    protected String getName() {
        return "NaviVolumeRange";
    }

    @Override
    protected int getID() {
        return 0;
    }

    @Override
    protected ISamplePlayer getSamplePlayer() {
        return this.samplePlayer;
    }

    @Override
    protected int[] getVolumeConnections() {
        return this.volumeConnections;
    }

    @Override
    protected void left() {
        super.left();
        this.samplePlayer.stop();
    }
}

