/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.info.tmc;

import de.audi.app.info.tmc.InfoOverviewListManager;
import de.audi.atip.hmi.model.DefaultButtonListener;
import de.audi.atip.hmi.model.DefaultOptionListener;
import de.audi.atip.hmi.model.menu.MenuModelApp;
import de.audi.atip.hmi.model.menu.MenuModelListener;
import de.audi.atip.hmi.modelaccess.ButtonModelApp;
import de.audi.atip.hmi.modelaccess.OptionModelApp;
import de.audi.atip.hmi.modelaccess.VirtualButtonModelApp;
import de.audi.atip.interapp.maptmc.MapTmcService;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.CommandListManager;
import de.audi.tghu.info.app.InfoEnv;
import de.audi.tghu.info.app.tmc.AppTMC;
import de.audi.tghu.info.app.tmc.TMCAbstractListRow;
import de.audi.tghu.info.app.tmc.commands.TMCCommand;
import org.dsi.ifc.global.NavRectangle;
import org.dsi.ifc.tmc.TmcListElement;

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
        EvoTmcButtonListener evoTmcButtonListener = new EvoTmcButtonListener();
        this.nextMsgButton = infoEnv.getButtonModel(500176);
        this.reroutingHintButton = infoEnv.getButtonModel(500145);
        this.tmcMenuModel = infoEnv.getMenuModel(500141);
        this.backHandlingVButtonModel = infoEnv.getVirtualButtonModel(500182);
        this.showInMapOption = infoEnv.getHMIService().getOptionModel(500203);
        EvoTmcOptionModelListener evoTmcOptionModelListener = new EvoTmcOptionModelListener();
        this.showInMapOption.setListener(evoTmcOptionModelListener, 500129);
        this.showInMapOption.setListener(evoTmcOptionModelListener, 500175);
        this.nextMsgButton.setButtonListener(evoTmcButtonListener);
        this.reroutingHintButton.setButtonListener(evoTmcButtonListener);
        this.backHandlingVButtonModel.setButtonListener(evoTmcButtonListener);
        this.tmcMenuModel.setListener(this);
    }

    public void itemFocused(int n, int n2, long l, int n3) {
        this.logger.log(1000000, "InfoHmiListener#itemFocused menuItemID: %1, uniqueListRowID: %2", (long)n, l);
        if (n != this.listManager.getListModel().getID()) {
            CommandListManager commandListManager = this.infoApp.getCmdListManager();
            CommandList commandList = new CommandList(commandListManager);
            commandList.add(new TMCCommand(this.infoApp, this.logger, "InfoHmiListener#itemFocused"){

                public void execute() {
                    if (this.logger.isDebug2()) {
                        this.logger.log(100000000, "InfoHmiListener#itemFocused hidePreviewMap");
                    }
                    InfoHmiListener.this.infoApp.getPreviewMap().hidePreviewMap();
                    InfoHmiListener.this.listManager.setFocusedRowIndex(-1);
                    this.getCommandList().commandFinished();
                }
            });
            commandListManager.execute(commandList);
        }
    }

    private class EvoTmcButtonListener
    extends DefaultButtonListener {
        private EvoTmcButtonListener() {
        }

        public void keyPressed(int n, int n2, int n3) {
            InfoHmiListener.this.logger.log(1000000, "InfoHmiListener#keyPressed() modelID=%1, TMC_REROUTING_CHOICE=%2, focusedRowIndex=%3", (long)n, (long)InfoHmiListener.this.env.getChoiceModel(500144).getValue(), (long)InfoHmiListener.this.listManager.getFocusedRowIndex());
            if (n == InfoHmiListener.this.nextMsgButton.getID()) {
                if (InfoHmiListener.this.nextMsgButton.getStatus() == 1) {
                    InfoHmiListener.this.listManager.loadNextDetailsScreen();
                    InfoHmiListener.this.env.getButtonModel(n).fireEvent(n3);
                }
            } else if (n == InfoHmiListener.this.reroutingHintButton.getID()) {
                if (InfoHmiListener.this.env.getChoiceModel(500144).getValue() != 2) {
                    return;
                }
                if (InfoHmiListener.this.infoApp.getNaviService() != null) {
                    InfoHmiListener.this.infoApp.getNaviService().switchToSemidynamicRouteGuidance();
                    InfoHmiListener.this.env.getButtonModel(n).fireEvent(n3);
                } else {
                    InfoHmiListener.this.logger.log(100000, "InfoHmiListener#keyPressed() modelID=%1, NaviService is null", (long)n);
                }
            } else if (n == InfoHmiListener.this.backHandlingVButtonModel.getID()) {
                if (InfoHmiListener.this.listManager.getFocusedRowIndex() != 0) {
                    InfoHmiListener.this.listManager.requestFirstWindowAndFocus();
                }
            } else {
                InfoHmiListener.this.logger.log(100000, "InfoHmiListener#keyPressed() no listener action defined for modelID=%1", (long)n);
            }
        }
    }

    private class EvoTmcOptionModelListener
    extends DefaultOptionListener {
        private EvoTmcOptionModelListener() {
        }

        public void keyPressed(int n, int n2, int n3, int n4, int n5) {
            InfoHmiListener.this.logger.log(1000000, "InfoHmiListener#EvoTmcOptionModelListener.keyPressed() modelID=%1, targetModelID=%2, targetRow=%3", (long)n, (long)n2, (long)n3);
            if (n == 500203) {
                TMCAbstractListRow tMCAbstractListRow = (TMCAbstractListRow)InfoHmiListener.this.env.getBaseListModel(n2).getRow(n3);
                InfoHmiListener.this.listManager.setFocusedRowIndex(-1);
                this.showTmcEventInMap(tMCAbstractListRow);
            } else {
                InfoHmiListener.this.logger.log(10000, "InfoHmiListener#EvoTmcOptionModelListener.keyPressed() unsupported modelID");
            }
            InfoHmiListener.this.env.getHMIService().getOptionModel(n).fireEvent(n5);
        }

        private void showTmcEventInMap(final TMCAbstractListRow tMCAbstractListRow) {
            InfoHmiListener.this.infoApp.getMapService().mapEntered();
            CommandListManager commandListManager = InfoHmiListener.this.infoApp.getCmdListManager();
            CommandList commandList = new CommandList(commandListManager);
            commandList.add(new TMCCommand(InfoHmiListener.this.infoApp, InfoHmiListener.this.logger){

                public void execute() {
                    NavRectangle navRectangle = InfoHmiListener.this.infoApp.getResponseContainer().getRectangle();
                    MapTmcService mapTmcService = InfoHmiListener.this.infoApp.getMapService();
                    TmcListElement tmcListElement = tMCAbstractListRow.getTmcListElement();
                    if (mapTmcService != null) {
                        try {
                            mapTmcService.showInMap(new long[]{tMCAbstractListRow.getTmcListElement().getUID()}, navRectangle, tmcListElement);
                        }
                        catch (Exception exception) {
                            this.logger.log(10000, "InfoHmiListener#showTmcEventInMap ERROR = %1", (Throwable)exception);
                        }
                    } else {
                        this.logger.log(10000, "InfoHmiListener#showTmcEventInMap Map can not be called, map is null. ");
                    }
                    this.getCommandList().commandFinished();
                }
            });
            commandListManager.execute(commandList);
        }
    }
}

