/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.info.tmc;

import de.audi.app.info.tmc.InfoDetailsRow;
import de.audi.app.info.tmc.InfoHmiListener;
import de.audi.app.info.tmc.InfoListRow;
import de.audi.app.info.tmc.InfoOverviewListManager$1;
import de.audi.app.info.tmc.InfoOverviewListManager$2;
import de.audi.atip.hmi.model.list.BaseListModelApp;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.hmi.model.list.TiledListModelApp;
import de.audi.atip.hmi.model.menu.MenuModelApp;
import de.audi.atip.hmi.model.menu.focus.FocusAdvice;
import de.audi.atip.hmi.modelaccess.ButtonModelApp;
import de.audi.atip.log.LogChannel;
import de.audi.atip.metrics.DateMetric;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.CommandListManager;
import de.audi.tghu.info.app.InfoEnv;
import de.audi.tghu.info.app.tmc.AppTMC;
import de.audi.tghu.info.app.tmc.TMCAbstractListManager;
import de.audi.tghu.info.app.tmc.TMCAbstractListRow;
import de.audi.tghu.info.app.tmc.TMCAbstractListRowBuilder;
import de.audi.tghu.info.app.tmc.TMCConst;
import de.audi.tghu.info.app.tmc.commands.TMCDefaultErrorCommand;
import java.util.Date;
import org.dsi.ifc.tmc.TmcListElement;
import org.dsi.ifc.tmc.TmcMessage;

public class InfoOverviewListManager
extends TMCAbstractListManager {
    public static final int FOCUSED_ROW_NONE;
    private InfoHmiListener hmiListener;
    private static String LOGCLASS;
    private final ButtonModelApp nextMessageButton;
    private static final int TMC_EVENTS_NOT_AVAILABLE;
    private static final int TMC_EVENTS_AVAILABLE;
    protected static final int NEXT_BUTTON_GRAYED_OUT;
    protected static final int NEXT_BUTTON_AVAILABLE;
    private static final long SECONDS_TO_MILLISECONDS;

    public InfoOverviewListManager(InfoEnv infoEnv, AppTMC appTMC, TiledListModelApp tiledListModelApp, TMCAbstractListRowBuilder tMCAbstractListRowBuilder) {
        super(infoEnv, appTMC, tiledListModelApp, tMCAbstractListRowBuilder);
        this.hmiListener = new InfoHmiListener(infoEnv, this, appTMC);
        this.listModelDetails = infoEnv.getBaseListModel(-811530496);
        this.nextMessageButton = infoEnv.getButtonModel(-794753280);
    }

    @Override
    public void itemSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
        this.lc.log(1078071040, "%1#itemSelected - index=%2, listModel.getLength(): %3", (Object)LOGCLASS, (long)n2, (long)this.listModel.getLength());
        InfoListRow infoListRow = (InfoListRow)evoListRow;
        this.lastSelectedNodeId = infoListRow.getTmcListElement().uID;
        this.lastFocusedMessage = infoListRow.getTmcListElement().getMessage();
        if (infoListRow.getTmcListElement().hasChild) {
            this.parentNodeSelected(infoListRow);
        } else {
            EvoListRow[] evoListRowArray = (InfoDetailsRow[])this.rowBuilder.buildDetailsList(infoListRow.getTmcListElement());
            this.listModelDetails.removeAll();
            this.listModelDetails.setLength(evoListRowArray.length);
            this.listModelDetails.setRows(-1, 0, evoListRowArray);
            this.setStatusOfNextButton();
            this.setProviderAndTime(infoListRow.getTmcListElement().getMessage());
            this.setPreviewTrafficInfoTmcEvent(infoListRow.getTmcListElement().getMessage());
            this.env.getMenuModel(-1381955840).setFocusedItem(this.listModel.getID(), FocusAdvice.KEEP_POSITION, infoListRow.getUniqueID());
            this.listModel.fireEvent(n4);
            this.lastWidgetFocusAdvice = this.env.getMenuModel(-1381955840).getAdvice();
        }
    }

    @Override
    public void itemLongSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
    }

    @Override
    public void itemFocused(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
        this.lc.log(1078071040, "%1#itemFocused - index=%2", (Object)LOGCLASS, (long)n2);
        this.handleVirtualButtonStatus(n2);
        if (n2 == this.focusedRow) {
            return;
        }
        this.focusedRow = n2;
        InfoListRow infoListRow = (InfoListRow)evoListRow;
        if (infoListRow.getTmcListElement().hasChild) {
            this.focusPreviewMapOnParentNode(infoListRow.getTmcListElement().getUID());
        } else {
            this.setPreviewTrafficInfoTmcEvent(infoListRow.getTmcListElement().getMessage());
        }
    }

    private void handleVirtualButtonStatus(int n) {
        if (n == 0) {
            this.env.getVirtualButtonModel(-694089984).setStatus(0);
        } else {
            this.env.getVirtualButtonModel(-694089984).setStatus(1);
        }
    }

    protected void checkSeparators(TmcListElement tmcListElement, TMCAbstractListRow tMCAbstractListRow) {
        if (tmcListElement == null) {
            this.lc.log(-1601830656, "%1#checkSeparators tmcListElement is null", (Object)LOGCLASS);
            return;
        }
        TmcMessage tmcMessage = tmcListElement.getMessage();
        if (tmcMessage != null && !tmcMessage.urgent.equals("X-URGENT") && this.lastMessageUrgentStatus.equals("X-URGENT")) {
            ((InfoListRow)tMCAbstractListRow).setSeparatorLine(2);
        } else if (this.lastMessageRouteState == 0 && (tmcListElement.hasChild || tmcMessage.getRouteRelevance() != 0)) {
            ((InfoListRow)tMCAbstractListRow).setSeparatorLine(2);
        } else if (this.lastMessageRouteState == 2 && (tmcListElement.hasChild || tmcMessage.getRouteRelevance() != 2)) {
            ((InfoListRow)tMCAbstractListRow).setSeparatorLine(2);
        }
        if (tmcMessage != null) {
            this.lastMessageRouteState = tmcMessage.getRouteRelevance();
            this.lastMessageUrgentStatus = tmcMessage.getUrgent();
        } else {
            this.lastMessageRouteState = 1;
        }
    }

    @Override
    protected void loadNextDetailsScreen() {
        this.lc.log(-2137614336, "%1#loadNextDetailsScreen()", (Object)LOGCLASS);
        CommandListManager commandListManager = this.appTmc.getCmdListManager();
        CommandList commandList = new CommandList(commandListManager);
        commandList.add(new InfoOverviewListManager$1(this, this.appTmc, this.lc, "InfoOverviewListManager#loadNextDetailsScreen"));
        commandList.setErrorCommand(new TMCDefaultErrorCommand(this.appTmc, this.lc));
        commandListManager.execute(commandList);
    }

    private CommandList requestNextTmcWindowCommandList(long l, int n) {
        long[] lArray = this.getSurroundingAnchorIds(l);
        TMCAbstractListRow tMCAbstractListRow = (TMCAbstractListRow)this.listModel.getRow(n + 1);
        if (tMCAbstractListRow != null && tMCAbstractListRow.getTmcListElement().hasChild) {
            this.setOpenedAnchorId(tMCAbstractListRow.getTmcListElement().uID);
            this.lastSelectedNodeId = tMCAbstractListRow.getTmcListElement().uID;
            this.lastFocusedMessage = tMCAbstractListRow.getTmcListElement().getMessage();
        }
        CommandListManager commandListManager = this.appTmc.getCmdListManager();
        CommandList commandList = new CommandList(commandListManager);
        commandList.add(this.getRequestWindowCommand(lArray, this.getOpenedAnchorId(), -3, TMCConst.WINDOW_REQUEST_SIZE));
        return commandList;
    }

    public void requestFirstWindowAndFocus() {
        CommandListManager commandListManager = this.appTmc.getCmdListManager();
        CommandList commandList = new CommandList(commandListManager);
        commandList.add(this.getRequestWindowCommand(TMCConst.INITIAL_WINDOW, this.getOpenedAnchorId(), -1, TMCConst.WINDOW_REQUEST_SIZE));
        commandList.add(new InfoOverviewListManager$2(this, this.appTmc, this.lc, "InfoOverviewListManager#requestFirstWindowAndFocus"));
        commandListManager.execute(commandList);
    }

    @Override
    public void setFocusedRowIndex(int n) {
        super.setFocusedRowIndex(n);
        if (n == -1) {
            return;
        }
        TmcListElement tmcListElement = ((TMCAbstractListRow)this.listModel.getRow(this.focusedRow)).getTmcListElement();
        if (tmcListElement.hasChild) {
            this.focusPreviewMapOnParentNode(tmcListElement.getUID());
        } else {
            this.setPreviewTrafficInfoTmcEvent(tmcListElement.getMessage());
        }
    }

    private void setStatusOfNextButton() {
        int n = this.listModel.getIndexForUniqueID(this.lastSelectedNodeId);
        if (n == -1 || n >= this.listModel.getLength() - 1) {
            this.lc.log(-2137614336, "InfoOverviewListManager#setStatusOfNextButton NEXT_BUTTON_GRAYED_OUT indexLastSelectedNode: %1, listModel.getLength(): %2", (long)n, (long)this.listModel.getLength());
            this.nextMessageButton.setStatus(0);
        } else {
            this.lc.log(-2137614336, "%1#setStatusOfNextButton NEXT_BUTTON_AVAILABLE", (Object)LOGCLASS);
            this.nextMessageButton.setStatus(1);
        }
    }

    private void setProviderAndTime(TmcMessage tmcMessage) {
        this.env.getLabelModel(-392100096).setText(tmcMessage.providerName.trim());
        this.env.getMetricsModel(-408877312).setMetric(new DateMetric(new Date(tmcMessage.timeStamp * 0), 6));
    }

    public void updateDetailsScreen() {
        int n = this.listModel.getIndexForUniqueID(this.lastSelectedNodeId);
        TMCAbstractListRow tMCAbstractListRow = (TMCAbstractListRow)this.listModel.getRow(n + 1);
        if (tMCAbstractListRow == null) {
            this.lc.log(-1601830656, "%1#updateDetailsScreen lastSelectedNodeId: %2 is not valid", (Object)LOGCLASS, this.lastSelectedNodeId);
            this.nextMessageButton.setStatus(0);
            return;
        }
        if (tMCAbstractListRow.getTmcListElement().hasChild) {
            tMCAbstractListRow = (TMCAbstractListRow)this.listModel.getRow(n + 2);
        }
        if (tMCAbstractListRow == null) {
            this.lc.log(-1601830656, "%1#updateDetailsScreen lastSelectedNodeId: %2 child node is not valid", (Object)LOGCLASS, this.lastSelectedNodeId);
            this.nextMessageButton.setStatus(0);
            return;
        }
        this.lastSelectedNodeId = tMCAbstractListRow.getTmcListElement().uID;
        this.lastFocusedMessage = tMCAbstractListRow.getTmcListElement().getMessage();
        this.setFocusedRowIndex(tMCAbstractListRow.getTmcListElement().positionInCompleteList - 1);
        EvoListRow[] evoListRowArray = (InfoDetailsRow[])this.rowBuilder.buildDetailsList(tMCAbstractListRow.getTmcListElement());
        BaseListModelApp baseListModelApp = this.listModelDetails.getCopy();
        baseListModelApp.removeAll();
        baseListModelApp.setLength(null == evoListRowArray ? 0 : evoListRowArray.length);
        baseListModelApp.setRows(-1, 0, evoListRowArray);
        this.listModelDetails.update(baseListModelApp);
        this.lc.log(1078071040, "%1#updateDetailsScreen lastSelectedNodeId: %2 just updated", (Object)LOGCLASS, this.lastSelectedNodeId);
        this.setStatusOfNextButton();
        this.setProviderAndTime(tMCAbstractListRow.getTmcListElement().getMessage());
        this.setPreviewTrafficInfoTmcEvent(tMCAbstractListRow.getTmcListElement().getMessage());
        this.env.getMenuModel(-1381955840).setFocusedItem(this.listModel.getID(), FocusAdvice.KEEP_POSITION, tMCAbstractListRow.getUniqueID());
    }

    @Override
    public void fillDetailScreen(TmcMessage tmcMessage) {
        EvoListRow[] evoListRowArray = (InfoDetailsRow[])this.rowBuilder.buildDetailsListMsg(tmcMessage);
        BaseListModelApp baseListModelApp = this.listModelDetails.getCopy();
        baseListModelApp.removeAll();
        baseListModelApp.setLength(null == evoListRowArray ? 0 : evoListRowArray.length);
        baseListModelApp.setRows(-1, 0, evoListRowArray);
        this.listModelDetails.update(baseListModelApp);
        this.setProviderAndTime(tmcMessage);
        this.lastFocusedMessage = tmcMessage;
    }

    @Override
    protected void anchorMessageVanished(int n, int n2) {
        this.lc.log(-2137614336, "%1#anchorMessageVanished usedAnchorID: %2", (Object)LOGCLASS, (long)n);
        TMCAbstractListRow tMCAbstractListRow = (TMCAbstractListRow)this.listModelDetails.getRow(0);
        if (tMCAbstractListRow == null) {
            return;
        }
        if (tMCAbstractListRow.getTmcListElement().getUID() == (long)n2) {
            this.lc.log(-2137614336, "%1#anchorMessageVanished oldAnchorId: %2, jump back in the main list", (Object)LOGCLASS, (long)n2);
            if (this.triggerLeaveDetailsScreenChoice.getValue() == 0) {
                this.triggerLeaveDetailsScreenChoice.setValue(1);
            } else {
                this.triggerLeaveDetailsScreenChoice.setValue(0);
            }
        }
    }

    protected int getFocusedRowIndex() {
        return this.focusedRow;
    }

    @Override
    protected void onTmcWindowResult(TmcListElement tmcListElement, TMCAbstractListRow tMCAbstractListRow) {
        this.checkSeparators(tmcListElement, tMCAbstractListRow);
    }

    @Override
    public MenuModelApp getMenuModel() {
        return this.env.getMenuModel(-1381955840);
    }

    @Override
    protected void onUpdateEventsTotal() {
        if (this.listModel.getLength() == 0) {
            this.env.getChoiceModel(-677312768).setValue(0);
            if (this.isTmcScreenShown()) {
                this.focusPreviewMapOnCCP();
            }
        } else {
            this.env.getChoiceModel(-677312768).setValue(1);
        }
        this.setStatusOfNextButton();
    }

    @Override
    protected void onTmcWindowChanged() {
        this.setStatusOfNextButton();
    }

    static /* synthetic */ long access$000(InfoOverviewListManager infoOverviewListManager) {
        return infoOverviewListManager.lastSelectedNodeId;
    }

    static /* synthetic */ TiledListModelApp access$100(InfoOverviewListManager infoOverviewListManager) {
        return infoOverviewListManager.listModel;
    }

    static /* synthetic */ String access$200() {
        return LOGCLASS;
    }

    static /* synthetic */ long access$300(InfoOverviewListManager infoOverviewListManager) {
        return infoOverviewListManager.lastSelectedNodeId;
    }

    static /* synthetic */ LogChannel access$400(InfoOverviewListManager infoOverviewListManager) {
        return infoOverviewListManager.lc;
    }

    static /* synthetic */ TiledListModelApp access$500(InfoOverviewListManager infoOverviewListManager) {
        return infoOverviewListManager.listModel;
    }

    static /* synthetic */ long access$600(InfoOverviewListManager infoOverviewListManager) {
        return infoOverviewListManager.lastSelectedNodeId;
    }

    static /* synthetic */ LogChannel access$700(InfoOverviewListManager infoOverviewListManager) {
        return infoOverviewListManager.lc;
    }

    static /* synthetic */ boolean access$800(InfoOverviewListManager infoOverviewListManager, int n) {
        return infoOverviewListManager.isNextNodeAvailable(n);
    }

    static /* synthetic */ TiledListModelApp access$900(InfoOverviewListManager infoOverviewListManager) {
        return infoOverviewListManager.listModel;
    }

    static /* synthetic */ long access$1000(InfoOverviewListManager infoOverviewListManager) {
        return infoOverviewListManager.lastSelectedNodeId;
    }

    static /* synthetic */ LogChannel access$1100(InfoOverviewListManager infoOverviewListManager) {
        return infoOverviewListManager.lc;
    }

    static /* synthetic */ ButtonModelApp access$1200(InfoOverviewListManager infoOverviewListManager) {
        return infoOverviewListManager.nextMessageButton;
    }

    static /* synthetic */ long access$1300(InfoOverviewListManager infoOverviewListManager) {
        return infoOverviewListManager.lastSelectedNodeId;
    }

    static /* synthetic */ LogChannel access$1400(InfoOverviewListManager infoOverviewListManager) {
        return infoOverviewListManager.lc;
    }

    static /* synthetic */ CommandList access$1500(InfoOverviewListManager infoOverviewListManager, long l, int n) {
        return infoOverviewListManager.requestNextTmcWindowCommandList(l, n);
    }

    static /* synthetic */ TiledListModelApp access$1600(InfoOverviewListManager infoOverviewListManager) {
        return infoOverviewListManager.listModel;
    }

    static /* synthetic */ TiledListModelApp access$1700(InfoOverviewListManager infoOverviewListManager) {
        return infoOverviewListManager.listModel;
    }

    static {
        LOGCLASS = "InfoOverviewListManager";
    }
}

