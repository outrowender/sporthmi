/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.di.kr;

import de.audi.app.navi.evo.di.kr.AddressInputManagerKR;
import de.audi.tghu.navi.app.addressinput.CmdNaviPreviewMapUpdate;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.util.Util;

class AddressInputManagerKR$1
extends NavCommand {
    private final /* synthetic */ String val$province;
    private final /* synthetic */ String val$city;
    private final /* synthetic */ String val$submunicipalTown;
    private final /* synthetic */ String val$street;
    private final /* synthetic */ AddressInputManagerKR this$0;

    AddressInputManagerKR$1(AddressInputManagerKR addressInputManagerKR, String string, String string2, String string3, String string4, String string5) {
        this.this$0 = addressInputManagerKR;
        this.val$province = string2;
        this.val$city = string3;
        this.val$submunicipalTown = string4;
        this.val$street = string5;
        super(string);
    }

    @Override
    public void execute() {
        if (!Util.isEmpty(this.val$province)) {
            boolean bl = false;
            if (!Util.isEmpty(this.val$city) && Util.isEmpty(this.val$submunicipalTown) && Util.isEmpty(this.val$street)) {
                bl = true;
            }
            this.getCommandList().commandFinishedWithPostCommand(new CmdNaviPreviewMapUpdate(AddressInputManagerKR.access$000(this.this$0), bl, 1, null, null));
        } else if (AddressInputManagerKR.access$100(this.this$0).getValue() == 1) {
            AddressInputManagerKR.access$200(this.this$0).setPreviewAreaAroundCCP(1);
            this.getCommandList().commandFinished();
        } else {
            AddressInputManagerKR.access$300(this.this$0).hidePreviewMap();
            this.getCommandList().commandFinished();
        }
    }
}

