/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app;

import de.audi.atip.hmi.model.PresetListRow;
import de.audi.atip.preset.DefinitionRequest;
import de.audi.tghu.navi.app.ADBInterAppService;
import de.audi.tghu.navi.app.command.NavCommand;
import java.io.Serializable;

class ADBInterAppService$7
extends NavCommand {
    private final /* synthetic */ DefinitionRequest val$request;
    private final /* synthetic */ ADBInterAppService this$0;

    ADBInterAppService$7(ADBInterAppService aDBInterAppService, String string, DefinitionRequest definitionRequest) {
        this.this$0 = aDBInterAppService;
        this.val$request = definitionRequest;
        super(string);
    }

    @Override
    public void execute() {
        byte[] byArray = (byte[])this.getCommandList().get("LOCATION_STREAM");
        PresetListRow presetListRow = new PresetListRow();
        presetListRow.setText(2, this.name);
        if (byArray == null) {
            ADBInterAppService.access$400(this.this$0).log(10000, "%1#definePreset() byte[] ist null", (Object)this.CLASS_NAME);
            this.val$request.responseDefine(1, null, null, 4);
            this.getCommandList().commandAborted("Could not serialize NavLocation");
        }
        this.val$request.responseDefine(0, (Serializable)byArray, presetListRow, 4);
        this.getCommandList().commandFinished();
    }
}

