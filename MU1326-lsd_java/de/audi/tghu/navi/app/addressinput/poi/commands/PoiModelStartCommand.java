/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.poi.commands;

import de.audi.tghu.navi.app.addressinput.poi.models.IPoiScreenOnStart;
import de.audi.tghu.navi.app.command.NavCommand;

public class PoiModelStartCommand
extends NavCommand {
    private final IPoiScreenOnStart modelAccess;

    public PoiModelStartCommand(IPoiScreenOnStart iPoiScreenOnStart) {
        this.modelAccess = iPoiScreenOnStart;
    }

    @Override
    public void execute() {
        this.modelAccess.onStart();
        this.getCommandList().commandFinished();
    }
}

