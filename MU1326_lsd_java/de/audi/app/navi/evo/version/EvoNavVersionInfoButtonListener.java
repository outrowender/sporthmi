/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.version;

import de.audi.app.navi.evo.version.EvoNavVersionInfoButtonListener$1;
import de.audi.atip.hmi.model.ButtonListener;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.NavigationEnv;
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

    @Override
    public void keyPressed(int n, int n2, int n3) {
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new EvoNavVersionInfoButtonListener$1(this, "NavVersionButtonPressed", n, n3));
        commandList.execute("NavVersionInfoHandler#keyPressed");
    }

    @Override
    public void keyReleased(int n, int n2, int n3) {
    }

    @Override
    public void keyTyped(int n, int n2, int n3) {
    }

    @Override
    public void keyLongTyped(int n, int n2, int n3) {
    }

    static /* synthetic */ LogChannel access$000(EvoNavVersionInfoButtonListener evoNavVersionInfoButtonListener) {
        return evoNavVersionInfoButtonListener.logChannel;
    }

    static /* synthetic */ NavVersionInfoHandler access$100(EvoNavVersionInfoButtonListener evoNavVersionInfoButtonListener) {
        return evoNavVersionInfoButtonListener.navVersionInfoHandler;
    }

    static /* synthetic */ int access$200(EvoNavVersionInfoButtonListener evoNavVersionInfoButtonListener) {
        return evoNavVersionInfoButtonListener.navVersionButton;
    }
}

