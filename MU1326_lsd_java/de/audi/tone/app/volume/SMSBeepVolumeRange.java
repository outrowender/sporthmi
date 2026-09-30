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
import de.audi.tone.app.volume.samples.SMSBeepPlayer;

public class SMSBeepVolumeRange
extends AbstractVolumeRange {
    private static final int CONNECTION = 92;
    private final int[] volumeConnections = new int[]{123, 92};
    private final int[] greyOutConnections = AudioConnection.GREY_OUT_ALL;
    private final SMSBeepPlayer player;
    private final String name;

    SMSBeepVolumeRange(VolumeRangeManager volumeRangeManager) {
        super(volumeRangeManager, 1000011, 1000074, 92);
        this.name = "SMSBeepVolumeRange";
        this.player = new SMSBeepPlayer(volumeRangeManager.env);
        ChoiceModelApp choiceModelApp = volumeRangeManager.env.getChoiceModel(1000096);
        this.greyOutHandler = new DefaultGreyOutAndPopupHandler(choiceModelApp, this.greyOutConnections, volumeRangeManager.env.lcHMI, "SMSBeepVolumeRange");
    }

    protected ISamplePlayer getSamplePlayer() {
        return this.player;
    }

    protected int[] getVolumeConnections() {
        return this.volumeConnections;
    }

    protected String getName() {
        return "SMSBeepVolumeRange";
    }

    protected int getID() {
        return 7;
    }
}

