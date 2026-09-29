/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.di.sequences.mapcode;

import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.di.sequences.mapcode.MapcodeInputSequence;
import org.dsi.ifc.global.NavLocation;

class MapcodeInputSequence$12
extends NavCommand {
    private final /* synthetic */ MapcodeInputSequence this$0;

    MapcodeInputSequence$12(MapcodeInputSequence mapcodeInputSequence, String string) {
        this.this$0 = mapcodeInputSequence;
        super(string);
    }

    @Override
    public void execute() {
        NavLocation navLocation = this.env.getContainer().getSelectedLocation();
        if (this.this$0.previewMap != null && navLocation != null && navLocation.isPositionValid()) {
            this.this$0.previewMap.setPreviewLocation(navLocation, 1, null, null);
        }
        this.getCommandList().commandFinished();
    }
}

