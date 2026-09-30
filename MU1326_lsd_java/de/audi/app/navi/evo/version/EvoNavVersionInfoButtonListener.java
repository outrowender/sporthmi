/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.version;

import de.audi.atip.hmi.model.ButtonListener;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.version.NavVersionInfoHandler;

public class EvoNavVersionInfoButtonListener
implements ButtonListener {
    private LogChannel logChannel;
    private final ICommandListFactory commandListFactory;
    private final int navVersionButton;
    private final NavVersionInfoHandler navVersionInfoHandler;

    public EvoNavVersionInfoButtonListener(NavigationEnv navigationEnv, NavVersionInfoHandler navVersionInfoHandler, ICommandListFactory iCommandListFactory, LogChannel logChannel) {
        this.commandListFactory = iCommandListFactory;
        this.logChannel = logChannel;
        this.navVersionInfoHandler = navVersionInfoHandler;
        this.navVersionButton = 343;
        navigationEnv.getButtonModel(this.navVersionButton).setButtonListener(this);
    }

    public void keyPressed(final int n, int n2, final int n3) {
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new NavCommand("NavVersionButtonPressed"){

            public void execute() {
                switch (n) {
                    case 343: {
                        EvoNavVersionInfoButtonListener.this.logChannel.log(1000000, "NavVersionInfoHandler#keyPressed( %1 ) - SETTINGS_VERSION_NAVI_DB_BUTTON", (long)n);
                        EvoNavVersionInfoButtonListener.this.navVersionInfoHandler.updateNavVersionInfo();
                        this.env.getButtonModel(EvoNavVersionInfoButtonListener.this.navVersionButton).fireEvent(n3);
                        break;
                    }
                    default: {
                        EvoNavVersionInfoButtonListener.this.logChannel.log(1000000, "NavVersionInfoHandler#keyPressed( %1 ) - unknown modelID", (long)n);
                    }
                }
                this.getCommandList().commandFinished();
            }
        });
        commandList.execute("NavVersionInfoHandler#keyPressed");
    }

    public void keyReleased(int n, int n2, int n3) {
    }

    public void keyTyped(int n, int n2, int n3) {
    }

    public void keyLongTyped(int n, int n2, int n3) {
    }
}

