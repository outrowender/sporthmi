/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.displaymanager;

import de.audi.atip.displaymanager.AbstractComponentCommand;
import de.audi.atip.displaymanager.DisplayManagerServiceImpl;
import de.audi.atip.displaymanager.DisplayManagerState;
import de.audi.atip.displaymanager.IDSIDisplayManagerController;
import de.audi.atip.displaymanager.StopComponentCommand;
import de.audi.atip.interapp.displaymanager.IDisplayManagerServiceListener;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.CommandList;

public class StartComponentCommand
extends AbstractComponentCommand {
    private static final String LOGCLASS = "StartComponentCommand";
    private final DisplayManagerServiceImpl displayManagerServiceImpl;
    private final IDSIDisplayManagerController displayManagerController;
    private final int displayableId;
    private final IDisplayManagerServiceListener listener;

    public StartComponentCommand(DisplayManagerServiceImpl displayManagerServiceImpl, LogChannel logChannel, IDSIDisplayManagerController iDSIDisplayManagerController, int n, IDisplayManagerServiceListener iDisplayManagerServiceListener) {
        super(logChannel, LOGCLASS);
        this.displayManagerController = iDSIDisplayManagerController;
        this.displayManagerServiceImpl = displayManagerServiceImpl;
        this.displayableId = n;
        this.listener = iDisplayManagerServiceListener;
    }

    public void execute() {
        DisplayManagerState displayManagerState = this.displayManagerServiceImpl.getDisplayManagerState();
        this.logger.log(100000000, "[%1.execute]", (Object)LOGCLASS);
        if (displayManagerState.isValid()) {
            CommandList commandList = new CommandList(this.commandList.getManager());
            commandList.add(new StopComponentCommand(this.displayManagerServiceImpl, this.logger, this.displayManagerController, displayManagerState.getDisplayableId(), this.listener));
            commandList.add(new StartComponentCommand(this.displayManagerServiceImpl, this.logger, this.displayManagerController, this.displayableId, this.listener));
            this.commandList.commandFinishedWithPostSequence(commandList);
        } else {
            this.displayManagerController.startComponent(this.displayableId, 0, 0);
        }
    }

    public void startComponentResult(int n, int n2, int n3, int n4) {
        this.logger.log(100000000, "[%1.startComponentResult] resultcode %2 displayable id %3", (Object)LOGCLASS, (long)n4, (long)n);
        if (0 == n4) {
            this.displayManagerServiceImpl.setDisplayManagerState(new DisplayManagerState(n));
            this.notifyListener(n);
            this.commandList.commandFinished();
        } else {
            this.error();
        }
    }

    public void error() {
        this.logger.log(1000000, "[%1.error]", (Object)LOGCLASS);
        this.notifyListener(-1);
        this.displayManagerServiceImpl.setDisplayManagerState(new DisplayManagerState());
        this.commandList.commandFinished();
    }

    private void notifyListener(int n) {
        if (this.listener != null) {
            this.listener.activeComponentChanged(n);
        }
    }
}

