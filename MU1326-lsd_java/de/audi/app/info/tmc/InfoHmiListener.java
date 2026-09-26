/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.info.tmc;

import de.audi.app.info.tmc.InfoHmiListener$1;
import de.audi.app.info.tmc.InfoHmiListener$EvoTmcButtonListener;
import de.audi.app.info.tmc.InfoHmiListener$EvoTmcOptionModelListener;
import de.audi.app.info.tmc.InfoOverviewListManager;
import de.audi.atip.hmi.model.menu.MenuModelApp;
import de.audi.atip.hmi.model.menu.MenuModelListener;
import de.audi.atip.hmi.modelaccess.ButtonModelApp;
import de.audi.atip.hmi.modelaccess.OptionModelApp;
import de.audi.atip.hmi.modelaccess.VirtualButtonModelApp;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.CommandListManager;
import de.audi.tghu.info.app.InfoEnv;
import de.audi.tghu.info.app.tmc.AppTMC;

public class InfoHmiListener
implements MenuModelListener {
    private final InfoEnv env;
    private final InfoOverviewListManager listManager;
    private final LogChannel logger;
    private final ButtonModelApp nextMsgButton;
    private final ButtonModelApp reroutingHintButton;
    private final OptionModelApp showInMapOption;
    private final AppTMC infoApp;
    private final MenuModelApp tmcMenuModel;
    private final VirtualButtonModelApp backHandlingVButtonModel;

    public InfoHmiListener(InfoEnv infoEnv, InfoOverviewListManager infoOverviewListManager, AppTMC appTMC) {
        this.env = infoEnv;
        this.listManager = infoOverviewListManager;
        this.infoApp = appTMC;
        this.logger = infoEnv.getLogChannel();
        InfoHmiListener$EvoTmcButtonListener infoHmiListener$EvoTmcButtonListener = new InfoHmiListener$EvoTmcButtonListener(this, null);
        this.nextMsgButton = infoEnv.getButtonModel(-794753280);
        this.reroutingHintButton = infoEnv.getButtonModel(-1314846976);
        this.tmcMenuModel = infoEnv.getMenuModel(-1381955840);
        this.backHandlingVButtonModel = infoEnv.getVirtualButtonModel(-694089984);
        this.showInMapOption = infoEnv.getHMIService().getOptionModel(-341768448);
        InfoHmiListener$EvoTmcOptionModelListener infoHmiListener$EvoTmcOptionModelListener = new InfoHmiListener$EvoTmcOptionModelListener(this, null);
        this.showInMapOption.setListener(infoHmiListener$EvoTmcOptionModelListener, -1583282432);
        this.showInMapOption.setListener(infoHmiListener$EvoTmcOptionModelListener, -811530496);
        this.nextMsgButton.setButtonListener(infoHmiListener$EvoTmcButtonListener);
        this.reroutingHintButton.setButtonListener(infoHmiListener$EvoTmcButtonListener);
        this.backHandlingVButtonModel.setButtonListener(infoHmiListener$EvoTmcButtonListener);
        this.tmcMenuModel.setListener(this);
    }

    @Override
    public void itemFocused(int n, int n2, long l, int n3) {
        this.logger.log(1078071040, "InfoHmiListener#itemFocused menuItemID: %1, uniqueListRowID: %2", (long)n, l);
        if (n != this.listManager.getListModel().getID()) {
            CommandListManager commandListManager = this.infoApp.getCmdListManager();
            CommandList commandList = new CommandList(commandListManager);
            commandList.add(new InfoHmiListener$1(this, this.infoApp, this.logger, "InfoHmiListener#itemFocused"));
            commandListManager.execute(commandList);
        }
    }

    static /* synthetic */ AppTMC access$200(InfoHmiListener infoHmiListener) {
        return infoHmiListener.infoApp;
    }

    static /* synthetic */ InfoOverviewListManager access$300(InfoHmiListener infoHmiListener) {
        return infoHmiListener.listManager;
    }

    static /* synthetic */ InfoEnv access$400(InfoHmiListener infoHmiListener) {
        return infoHmiListener.env;
    }

    static /* synthetic */ LogChannel access$500(InfoHmiListener infoHmiListener) {
        return infoHmiListener.logger;
    }

    static /* synthetic */ ButtonModelApp access$600(InfoHmiListener infoHmiListener) {
        return infoHmiListener.nextMsgButton;
    }

    static /* synthetic */ ButtonModelApp access$700(InfoHmiListener infoHmiListener) {
        return infoHmiListener.reroutingHintButton;
    }

    static /* synthetic */ VirtualButtonModelApp access$800(InfoHmiListener infoHmiListener) {
        return infoHmiListener.backHandlingVButtonModel;
    }
}

