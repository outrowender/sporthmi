/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.asia;

import de.audi.atip.hmi.model.DefaultButtonListener;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.command.TriggerNavigationRestartCommand;

public class AsiaDbPartialMapUpdateHMIListener {
    private NavigationEnv env;
    private ICommandListFactory commandListFactory;

    public AsiaDbPartialMapUpdateHMIListener(NavigationEnv navigationEnv, ICommandListFactory iCommandListFactory) {
        this.env = navigationEnv;
        this.commandListFactory = iCommandListFactory;
        this.initListeners();
    }

    private final void initListeners() {
        AsiaDbPartialMapUpdateButtonListener asiaDbPartialMapUpdateButtonListener = new AsiaDbPartialMapUpdateButtonListener();
        this.env.getButtonModel(401716).setButtonListener(asiaDbPartialMapUpdateButtonListener);
    }

    private class AsiaDbPartialMapUpdateButtonListener
    extends DefaultButtonListener {
        private AsiaDbPartialMapUpdateButtonListener() {
        }

        public void keyPressed(int n, int n2, int n3) {
            AsiaDbPartialMapUpdateHMIListener.this.env.getLogChannel().log(1000000, "AsiaDbPartialMapUpdateHMIListener#AsiaDbPartialMapUpdateButtonListener#keyPressed model=%1 key=%2", (long)n, (long)n2);
            switch (n) {
                case 401716: {
                    AsiaDbPartialMapUpdateHMIListener.this.env.getButtonModel(n).setStatus(0);
                    AsiaDbPartialMapUpdateHMIListener.this.env.getChoiceModel(401725).setValue(1);
                    CommandList commandList = AsiaDbPartialMapUpdateHMIListener.this.commandListFactory.createCommandList();
                    commandList.add(new TriggerNavigationRestartCommand());
                    commandList.execute("AsiaDbPartialMapUpdateButtonListener at RESTART_NAVIGATION_BUNDLE_BUTTON");
                    break;
                }
            }
            AsiaDbPartialMapUpdateHMIListener.this.env.getButtonModel(n).fireEvent(n3);
        }
    }
}

