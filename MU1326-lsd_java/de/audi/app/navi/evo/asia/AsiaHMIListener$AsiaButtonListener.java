/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.asia;

import de.audi.app.navi.evo.asia.AsiaHMIListener;
import de.audi.app.navi.evo.asia.AsiaHMIListener$1;
import de.audi.atip.hmi.model.DefaultButtonListener;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.navi.app.command.asia.AsiaAdjustCCPositionCommand;

class AsiaHMIListener$AsiaButtonListener
extends DefaultButtonListener {
    private final /* synthetic */ AsiaHMIListener this$0;

    private AsiaHMIListener$AsiaButtonListener(AsiaHMIListener asiaHMIListener) {
        this.this$0 = asiaHMIListener;
    }

    @Override
    public void keyPressed(int n, int n2, int n3) {
        AsiaHMIListener.access$100(this.this$0).getLogChannel().log(1078071040, "AsiaHMIListener#AsiaButtonListener#keyPressed model=%1 key=%2 terminal=%3", (long)n, (long)n2, (long)n3);
        switch (n) {
            case 401793: {
                CommandList commandList = AsiaHMIListener.access$200(this.this$0).createCommandList();
                commandList.add(new AsiaAdjustCCPositionCommand(-1709111808, -1725889024));
                commandList.execute("AsiaHMIListener#AsiaButtonListener#keyPressed at MAP_ADJUST_POSITION_BUTTON");
                break;
            }
        }
        AsiaHMIListener.access$100(this.this$0).getButtonModel(n).fireEvent(n3);
    }

    /* synthetic */ AsiaHMIListener$AsiaButtonListener(AsiaHMIListener asiaHMIListener, AsiaHMIListener$1 asiaHMIListener$1) {
        this(asiaHMIListener);
    }
}

