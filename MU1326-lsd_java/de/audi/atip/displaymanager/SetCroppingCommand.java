/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.displaymanager;

import de.audi.atip.displaymanager.AbstractComponentCommand;
import de.audi.atip.displaymanager.DisplayManagerServiceImpl;
import de.audi.atip.displaymanager.IDSIDisplayManagerController;
import de.audi.atip.interapp.displaymanager.Cropping;
import de.audi.atip.interapp.displaymanager.IDisplayManagerServiceListener;
import de.audi.atip.log.LogChannel;

public class SetCroppingCommand
extends AbstractComponentCommand {
    private static final String LOGCLASS;
    private final DisplayManagerServiceImpl displayManagerServiceImpl;
    private final IDSIDisplayManagerController displayManagerController;
    private final Cropping cropping;
    private final int sourceX;
    private final int sourceY;
    private final int sourceHeight;
    private final int sourceWidth;
    private final IDisplayManagerServiceListener displayerManagerServiceListener;

    public SetCroppingCommand(DisplayManagerServiceImpl displayManagerServiceImpl, LogChannel logChannel, IDSIDisplayManagerController iDSIDisplayManagerController, Cropping cropping, int n, int n2, int n3, int n4, IDisplayManagerServiceListener iDisplayManagerServiceListener) {
        super(logChannel, "SetCroppingCommand");
        this.displayManagerServiceImpl = displayManagerServiceImpl;
        this.displayManagerController = iDSIDisplayManagerController;
        this.cropping = cropping;
        this.sourceX = n;
        this.sourceY = n2;
        this.sourceWidth = n3;
        this.sourceHeight = n4;
        this.displayerManagerServiceListener = iDisplayManagerServiceListener;
    }

    @Override
    public void execute() {
        this.logger.log(14808325, "[%1.execute]", (Object)"SetCroppingCommand");
        this.displayManagerController.setCropping(0, this.displayManagerServiceImpl.getDisplayManagerState().getDisplayableId(), this.sourceX, this.sourceY, this.sourceWidth, this.sourceHeight, this.cropping.tgtX, this.cropping.tgtY, this.cropping.tgtWidth, this.cropping.tgtHeight);
    }

    @Override
    public void setCroppingResult(int n) {
        this.logger.log(14808325, "[%1.setCroppingResult] '%2'", (Object)"SetCroppingCommand", (long)n);
        this.displayerManagerServiceListener.setCroppingResult(n == 0 ? 1 : 2);
        this.commandList.commandFinished();
    }

    @Override
    public void error() {
        this.logger.log(1078071040, "[%1.error]", (Object)"SetCroppingCommand");
        this.displayerManagerServiceListener.setCroppingResult(2);
        this.commandList.commandFinished();
    }
}

