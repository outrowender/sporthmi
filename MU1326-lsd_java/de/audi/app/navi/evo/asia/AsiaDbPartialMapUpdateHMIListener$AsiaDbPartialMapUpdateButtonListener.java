/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.asia;

import de.audi.app.navi.evo.asia.AsiaDbPartialMapUpdateHMIListener;
import de.audi.app.navi.evo.asia.AsiaDbPartialMapUpdateHMIListener$1;
import de.audi.atip.hmi.model.DefaultButtonListener;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.navi.app.command.TriggerNavigationRestartCommand;

class AsiaDbPartialMapUpdateHMIListener$AsiaDbPartialMapUpdateButtonListener
extends DefaultButtonListener {
    private final /* synthetic */ AsiaDbPartialMapUpdateHMIListener this$0;

    private AsiaDbPartialMapUpdateHMIListener$AsiaDbPartialMapUpdateButtonListener(AsiaDbPartialMapUpdateHMIListener asiaDbPartialMapUpdateHMIListener) {
        this.this$0 = asiaDbPartialMapUpdateHMIListener;
    }

    @Override
    public void keyPressed(int n, int n2, int n3) {
        AsiaDbPartialMapUpdateHMIListener.access$100(this.this$0).getLogChannel().log(1078071040, "AsiaDbPartialMapUpdateHMIListener#AsiaDbPartialMapUpdateButtonListener#keyPressed model=%1 key=%2", (long)n, (long)n2);
        switch (n) {
            case 401716: {
                AsiaDbPartialMapUpdateHMIListener.access$100(this.this$0).getButtonModel(n).setStatus(0);
                AsiaDbPartialMapUpdateHMIListener.access$100(this.this$0).getChoiceModel(1025574400).setValue(1);
                CommandList commandList = AsiaDbPartialMapUpdateHMIListener.access$200(this.this$0).createCommandList();
                commandList.add(new TriggerNavigationRestartCommand());
                commandList.execute("AsiaDbPartialMapUpdateButtonListener at RESTART_NAVIGATION_BUNDLE_BUTTON");
                break;
            }
        }
        AsiaDbPartialMapUpdateHMIListener.access$100(this.this$0).getButtonModel(n).fireEvent(n3);
    }

    /* synthetic */ AsiaDbPartialMapUpdateHMIListener$AsiaDbPartialMapUpdateButtonListener(AsiaDbPartialMapUpdateHMIListener asiaDbPartialMapUpdateHMIListener, AsiaDbPartialMapUpdateHMIListener$1 asiaDbPartialMapUpdateHMIListener$1) {
        this(asiaDbPartialMapUpdateHMIListener);
    }
}

