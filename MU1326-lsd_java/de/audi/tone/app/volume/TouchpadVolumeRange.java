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
    private static final int CONNECTION;
    private final int[] volumeConnections = new int[]{129, 132};
    private final int[] greyOutConnections = AudioConnection.GREY_OUT_ALL;
    private final TTSSamplePlayer player = new TTSSamplePlayer(this.env, 1);
    private final String name;

    protected TouchpadVolumeRange(VolumeRangeManager volumeRangeManager) {
        super(volumeRangeManager, 1514278656, -1941827840, 132);
        this.name = "TouchpadVolumeRange";
        ChoiceModelApp choiceModelApp = volumeRangeManager.env.getChoiceModel(-1623060736);
        this.greyOutHandler = new DefaultGreyOutAndPopupHandler(choiceModelApp, this.greyOutConnections, volumeRangeManager.env.lcHMI, "TouchpadVolumeRange");
    }

    @Override
    protected void registerService(Object object) {
        super.registerService(object);
        this.volMenuManager.env.getChoiceModel(1396838144).setValue(1);
    }

    @Override
    protected void deregisterService(Object object) {
        super.deregisterService(object);
        this.volMenuManager.env.getChoiceModel(1396838144).setValue(0);
    }

    @Override
    protected void requestMenuConnection() {
        this.limitVolumeToHmiLimits();
        String string = this.env.getTranslatedText(1, "Text not available");
        this.player.setText(string);
        this.player.startSession();
    }

    @Override
    protected void releaseMenuConnection() {
        this.player.stopSession();
    }

    @Override
    protected ISamplePlayer getSamplePlayer() {
        return this.player;
    }

    @Override
    protected int getID() {
        return 6;
    }

    @Override
    protected String getName() {
        return "TouchpadVolumeRange";
    }

    @Override
    protected int[] getVolumeConnections() {
        return this.volumeConnections;
    }
}

