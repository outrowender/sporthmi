/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.di.jp;

import de.audi.app.navi.evo.di.jp.AddressInputManagerJP;
import de.audi.tghu.navi.app.addressinput.CmdNaviPreviewMapUpdate;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.util.Util;

class AddressInputManagerJP$1
extends NavCommand {
    private final /* synthetic */ String val$prefecture;
    private final /* synthetic */ String val$city;
    private final /* synthetic */ String val$placeName;
    private final /* synthetic */ AddressInputManagerJP this$0;

    AddressInputManagerJP$1(AddressInputManagerJP addressInputManagerJP, String string, String string2, String string3, String string4) {
        this.this$0 = addressInputManagerJP;
        this.val$prefecture = string2;
        this.val$city = string3;
        this.val$placeName = string4;
        super(string);
    }

    @Override
    public void execute() {
        if (!Util.isEmpty(this.val$prefecture)) {
            boolean bl = false;
            if (!Util.isEmpty(this.val$city) && Util.isEmpty(this.val$placeName)) {
                bl = true;
            }
            this.getCommandList().commandFinishedWithPostCommand(new CmdNaviPreviewMapUpdate(AddressInputManagerJP.access$000(this.this$0), bl, 1, null, null));
        } else if (AddressInputManagerJP.access$100(this.this$0).getValue() == 1) {
            AddressInputManagerJP.access$200(this.this$0).setPreviewAreaAroundCCP(1);
            this.getCommandList().commandFinished();
        } else {
            AddressInputManagerJP.access$300(this.this$0).hidePreviewMap();
            this.getCommandList().commandFinished();
        }
    }
}

