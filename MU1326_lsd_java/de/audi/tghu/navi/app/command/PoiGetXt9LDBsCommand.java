/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.command;

import de.audi.atip.interapp.IWordPredictionCallback;
import de.audi.tghu.navi.app.command.NavCommand;

public class PoiGetXt9LDBsCommand
extends NavCommand {
    private final IWordPredictionCallback wordPrediction;

    public PoiGetXt9LDBsCommand(IWordPredictionCallback iWordPredictionCallback) {
        this.wordPrediction = iWordPredictionCallback;
    }

    public void execute() {
        this.getDSINavigation().poiGetXt9LDBs(this.navigation.getVehicle().getVehicleLocationDescription(), this.wordPrediction.getPoiXt9Mode());
    }

    public void poiGetXt9LDBsResult(String[] stringArray) {
        this.wordPrediction.databaseNamesAvailableCallback(stringArray);
        this.getCommandList().commandFinished();
    }
}

