/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.asia;

import de.audi.atip.hmi.model.DefaultButtonListener;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.command.asia.AsiaAdjustCCPositionCommand;

public class AsiaHMIListener {
    private NavigationEnv env;
    private ICommandListFactory commandListFactory;

    public AsiaHMIListener(NavigationEnv navigationEnv, ICommandListFactory iCommandListFactory) {
        this.env = navigationEnv;
        this.commandListFactory = iCommandListFactory;
        this.initListeners();
    }

    private final void initListeners() {
        AsiaButtonListener asiaButtonListener = new AsiaButtonListener();
        this.env.getButtonModel(401793).setButtonListener(asiaButtonListener);
    }

    private class AsiaButtonListener
    extends DefaultButtonListener {
        private AsiaButtonListener() {
        }

        public void keyPressed(int n, int n2, int n3) {
            AsiaHMIListener.this.env.getLogChannel().log(1000000, "AsiaHMIListener#AsiaButtonListener#keyPressed model=%1 key=%2 terminal=%3", (long)n, (long)n2, (long)n3);
            switch (n) {
                case 401793: {
                    CommandList commandList = AsiaHMIListener.this.commandListFactory.createCommandList();
                    commandList.add(new AsiaAdjustCCPositionCommand(401818, 401817));
                    commandList.execute("AsiaHMIListener#AsiaButtonListener#keyPressed at MAP_ADJUST_POSITION_BUTTON");
                    break;
                }
            }
            AsiaHMIListener.this.env.getButtonModel(n).fireEvent(n3);
        }
    }
}

