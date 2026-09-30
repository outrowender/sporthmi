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
import de.audi.tone.app.volume.samples.TTSSamplePlayer;

public class TouchpadVolumeRange
extends AbstractVolumeRange {
    private static final int CONNECTION = 132;
    private final int[] volumeConnections = new int[]{129, 132};
    private final int[] greyOutConnections = AudioConnection.GREY_OUT_ALL;
    private final TTSSamplePlayer player = new TTSSamplePlayer(this.env, 1);
    private final String name;

    protected TouchpadVolumeRange(VolumeRangeManager volumeRangeManager) {
        super(volumeRangeManager, 1000026, 1000076, 132);
        this.name = "TouchpadVolumeRange";
        ChoiceModelApp choiceModelApp = volumeRangeManager.env.getChoiceModel(1000095);
        this.greyOutHandler = new DefaultGreyOutAndPopupHandler(choiceModelApp, this.greyOutConnections, volumeRangeManager.env.lcHMI, "TouchpadVolumeRange");
    }

    protected void registerService(Object object) {
        super.registerService(object);
        this.volMenuManager.env.getChoiceModel(1000019).setValue(1);
    }

    protected void deregisterService(Object object) {
        super.deregisterService(object);
        this.volMenuManager.env.getChoiceModel(1000019).setValue(0);
    }

    protected void requestMenuConnection() {
        this.limitVolumeToHmiLimits();
        String string = this.env.getTranslatedText(1, "Text not available");
        this.player.setText(string);
        this.player.startSession();
    }

    protected void releaseMenuConnection() {
        this.player.stopSession();
    }

    protected ISamplePlayer getSamplePlayer() {
        return this.player;
    }

    protected int getID() {
        return 6;
    }

    protected String getName() {
        return "TouchpadVolumeRange";
    }

    protected int[] getVolumeConnections() {
        return this.volumeConnections;
    }
}

