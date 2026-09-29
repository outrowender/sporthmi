/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.presentationmode;

import de.audi.tghu.navi.app.command.NavCommand;

public class RgSetGuidanceMode
extends NavCommand {
    private final int guidanceMode;

    public RgSetGuidanceMode(int n) {
        this.guidanceMode = n;
    }

    @Override
    public void execute() {
        this.getDSINavigation().rgSetRouteGuidanceMode(this.guidanceMode);
    }

    @Override
    public void rgSetRouteGuidanceModeResult() {
        this.getCommandList().commandFinished();
    }
}

