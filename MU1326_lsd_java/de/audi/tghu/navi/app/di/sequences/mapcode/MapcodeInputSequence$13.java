/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.di.sequences.mapcode;

import de.audi.atip.interapp.navigation.previewmap.IPreviewMap;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.di.sequences.mapcode.MapcodeInputSequence;

class MapcodeInputSequence$13
extends NavCommand {
    private final /* synthetic */ IPreviewMap val$previewMap;
    private final /* synthetic */ MapcodeInputSequence this$0;

    MapcodeInputSequence$13(MapcodeInputSequence mapcodeInputSequence, String string, IPreviewMap iPreviewMap) {
        this.this$0 = mapcodeInputSequence;
        this.val$previewMap = iPreviewMap;
        super(string);
    }

    @Override
    public void execute() {
        this.val$previewMap.setPreviewAreaAroundCCP(1);
        this.getCommandList().commandFinished();
    }
}

