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

public class InfoAnnouncementVolumeRange
extends AbstractVolumeRange {
    private static final int CONNECTION = 139;
    private final String DEFAULT_TEXT;
    private final TTSSamplePlayer player;
    private final int[] volumeConnections = new int[]{138, 140, 139};
    private final int[] greyOutConnections = AudioConnection.GREY_OUT_ALL;
    private final String name;

    protected InfoAnnouncementVolumeRange(VolumeRangeManager volumeRangeManager) {
        super(volumeRangeManager, 1000110, 1000109, 139);
        this.DEFAULT_TEXT = "Text not available";
        this.name = "InfoAnnouncementVolumeRange";
        this.player = new TTSSamplePlayer(volumeRangeManager.env, volumeRangeManager.env.getTranslatedText(3, "Text not available"));
        ChoiceModelApp choiceModelApp = volumeRangeManager.env.getChoiceModel(1000111);
        this.greyOutHandler = new DefaultGreyOutAndPopupHandler(choiceModelApp, this.greyOutConnections, volumeRangeManager.env.lcHMI, "InfoAnnouncementVolumeRange");
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
        String string = this.env.getTranslatedText(3, "Text not available");
        this.player.setText(string);
        this.player.startSession();
    }

    protected void releaseMenuConnection() {
        this.player.stopSession();
    }

    protected ISamplePlayer getSamplePlayer() {
        return this.player;
    }

    protected int[] getVolumeConnections() {
        return this.volumeConnections;
    }

    protected String getName() {
        return "InfoAnnouncementVolumeRange";
    }

    protected int getID() {
        return 12;
    }
}

