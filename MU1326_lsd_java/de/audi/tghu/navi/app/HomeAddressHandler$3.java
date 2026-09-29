/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app;

import de.audi.tghu.navi.app.HomeAddressHandler;
import de.audi.tghu.navi.app.command.NavCommand;

class HomeAddressHandler$3
extends NavCommand {
    private final /* synthetic */ int val$modelID;
    private final /* synthetic */ int val$terminalID;
    private final /* synthetic */ HomeAddressHandler this$0;

    HomeAddressHandler$3(HomeAddressHandler homeAddressHandler, String string, int n, int n2) {
        this.this$0 = homeAddressHandler;
        this.val$modelID = n;
        this.val$terminalID = n2;
        super(string);
    }

    @Override
    public void execute() {
        if (this.val$modelID == this.this$0.homeAddressModel.getID()) {
            this.logger.log(1078071040, "HomeAddressHandler#keyPressed( %1 ) - NAV_FAVORITES_HOME_BUTTON", (long)this.val$modelID);
            this.this$0.onHomeButtonPressed(this.val$terminalID);
            this.this$0.homeAddressModel.fireEvent(this.val$terminalID);
        } else if (this.val$modelID == this.this$0.deleteHomeAddressModel.getID()) {
            this.logger.log(1078071040, "HomeAddressHandler#keyPressed( %1 ) - NAV_FAVORITES_DELETE_HOME_BUTTON", (long)this.val$modelID);
            this.this$0.onDeleteHomeAddress();
            this.this$0.deleteHomeAddressModel.fireEvent(this.val$terminalID);
        } else {
            this.logger.log(1078071040, "HomeAddressHandler#keyPressed( %1 ) - unknown modelID", (long)this.val$modelID);
        }
        this.getCommandList().commandFinished();
    }
}

