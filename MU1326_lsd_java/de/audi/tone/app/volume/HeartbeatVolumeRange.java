/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tone.app.volume;

import de.audi.atip.audio.AudioConnection;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.tone.app.volume.AbstractVolumeRange;
import de.audi.tone.app.volume.VolumeRangeManager;
import de.audi.tone.app.volume.greyout.DefaultGreyOutAndPopupHandler;
import de.audi.tone.app.volume.samples.HeartbeatPlayer;
import de.audi.tone.app.volume.samples.ISamplePlayer;

public class HeartbeatVolumeRange
extends AbstractVolumeRange {
    private static final int CONNECTION;
    private final int[] volumeConnections = new int[]{48, 82};
    private final int[] greyOutConnections = AudioConnection.GREY_OUT_ALL;
    private final HeartbeatPlayer player;
    private final String name;

    HeartbeatVolumeRange(VolumeRangeManager volumeRangeManager) {
        super(volumeRangeManager, 1531055872, -2126377216, 82);
        this.name = "HeartbeatVolumeRange";
        this.player = new HeartbeatPlayer(volumeRangeManager.env.lcMain, 1);
        ChoiceModelApp choiceModelApp = volumeRangeManager.env.getChoiceModel(-1807610112);
        this.greyOutHandler = new DefaultGreyOutAndPopupHandler(choiceModelApp, this.greyOutConnections, volumeRangeManager.env.lcHMI, "HeartbeatVolumeRange");
    }

    @Override
    protected ISamplePlayer getSamplePlayer() {
        return this.player;
    }

    @Override
    protected int[] getVolumeConnections() {
        return this.volumeConnections;
    }

    @Override
    protected String getName() {
        return "HeartbeatVolumeRange";
    }

    @Override
    protected int getID() {
        return 8;
    }
}

