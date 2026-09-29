/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput;

import de.audi.atip.interapp.NaviADBService$LocationInputHandler;
import de.audi.tghu.navi.app.addressinput.ReturnNavLocationToAddressbookSequence;
import de.audi.tghu.navi.app.command.NavCommand;

class ReturnNavLocationToAddressbookSequence$2
extends NavCommand {
    private final /* synthetic */ ReturnNavLocationToAddressbookSequence this$0;

    ReturnNavLocationToAddressbookSequence$2(ReturnNavLocationToAddressbookSequence returnNavLocationToAddressbookSequence, String string) {
        this.this$0 = returnNavLocationToAddressbookSequence;
        super(string);
    }

    @Override
    public void execute() {
        byte[] byArray = (byte[])this.getCommandList().get("LOCATION_STREAM");
        NaviADBService$LocationInputHandler naviADBService$LocationInputHandler = this.navigation.getAdbInterAppService().getCurrentLocationInputHandler();
        if (naviADBService$LocationInputHandler != null) {
            naviADBService$LocationInputHandler.updateLocation(byArray);
            this.navigation.getAdbInterAppService().removeHandler();
            this.env.getLogChannel().log(-2137614336, "NavLocation was commited via interAppService, locationToStream = %2", (Object)byArray);
            this.getCommandList().commandFinished();
        } else {
            this.env.getLogChannel().log(10000, "%1#start() - LocationInputhandler is null", (Object)this.CLASS_NAME);
            this.getCommandList().commandAborted("No LocationInputhandler available");
        }
    }
}

