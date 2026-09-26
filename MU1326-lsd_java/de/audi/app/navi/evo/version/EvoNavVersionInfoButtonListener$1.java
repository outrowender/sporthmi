/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.version;

import de.audi.app.navi.evo.version.EvoNavVersionInfoButtonListener;
import de.audi.tghu.navi.app.command.NavCommand;

class EvoNavVersionInfoButtonListener$1
extends NavCommand {
    private final /* synthetic */ int val$modelID;
    private final /* synthetic */ int val$terminalID;
    private final /* synthetic */ EvoNavVersionInfoButtonListener this$0;

    EvoNavVersionInfoButtonListener$1(EvoNavVersionInfoButtonListener evoNavVersionInfoButtonListener, String string, int n, int n2) {
        this.this$0 = evoNavVersionInfoButtonListener;
        this.val$modelID = n;
        this.val$terminalID = n2;
        super(string);
    }

    @Override
    public void execute() {
        switch (this.val$modelID) {
            case 343: {
                EvoNavVersionInfoButtonListener.access$000(this.this$0).log(1078071040, "NavVersionInfoHandler#keyPressed( %1 ) - SETTINGS_VERSION_NAVI_DB_BUTTON", (long)this.val$modelID);
                EvoNavVersionInfoButtonListener.access$100(this.this$0).updateNavVersionInfo();
                this.env.getButtonModel(EvoNavVersionInfoButtonListener.access$200(this.this$0)).fireEvent(this.val$terminalID);
                break;
            }
            default: {
                EvoNavVersionInfoButtonListener.access$000(this.this$0).log(1078071040, "NavVersionInfoHandler#keyPressed( %1 ) - unknown modelID", (long)this.val$modelID);
            }
        }
        this.getCommandList().commandFinished();
    }
}

