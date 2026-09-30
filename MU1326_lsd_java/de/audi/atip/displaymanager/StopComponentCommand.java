/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.displaymanager;

import de.audi.atip.displaymanager.AbstractComponentCommand;
import de.audi.atip.displaymanager.DisplayManagerServiceImpl;
import de.audi.atip.displaymanager.DisplayManagerState;
import de.audi.atip.displaymanager.IDSIDisplayManagerController;
import de.audi.atip.interapp.displaymanager.IDisplayManagerServiceListener;
import de.audi.atip.log.LogChannel;

public class StopComponentCommand
extends AbstractComponentCommand {
    private static final String LOGCLASS = "StopComponentCommand";
    private final DisplayManagerServiceImpl displayManagerServiceImpl;
    private final IDSIDisplayManagerController displayManagerController;
    private final IDisplayManagerServiceListener listener;
    private final int displayableId;

    public StopComponentCommand(DisplayManagerServiceImpl displayManagerServiceImpl, LogChannel logChannel, IDSIDisplayManagerController iDSIDisplayManagerController, int n, IDisplayManagerServiceListener iDisplayManagerServiceListener) {
        super(logChannel, LOGCLASS);
        this.displayManagerController = iDSIDisplayManagerController;
        this.displayManagerServiceImpl = displayManagerServiceImpl;
        this.displayableId = n;
        this.listener = iDisplayManagerServiceListener;
    }

    public void execute() {
        if (this.displayableId != this.displayManagerServiceImpl.getDisplayManagerState().getDisplayableId()) {
            this.logger.log(1000000, "[%1.execute] %2 not active, ignore.", (Object)LOGCLASS, (long)this.displayableId);
            this.commandList.commandFinished();
            return;
        }
        this.logger.log(100000000, "[%1.execute] %2", (Object)LOGCLASS, (long)this.displayableId);
        this.displayManagerController.stopComponent(this.displayableId, 0, 0);
    }

    public void stopComponentResult(int n, int n2, int n3, int n4) {
        this.logger.log(100000000, "[%1.stopComponentResult]", (Object)LOGCLASS);
        this.notifyListener(-1);
        this.displayManagerServiceImpl.setDisplayManagerState(new DisplayManagerState());
        this.commandList.commandFinished();
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

