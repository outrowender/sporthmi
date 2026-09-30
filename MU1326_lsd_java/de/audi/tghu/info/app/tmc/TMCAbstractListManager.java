/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.info.app.tmc;

import de.audi.atip.hmi.model.list.BaseListModelApp;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.hmi.model.list.TiledListModelApp;
import de.audi.atip.hmi.model.list.TiledListModelListener;
import de.audi.atip.hmi.model.menu.MenuModelApp;
import de.audi.atip.hmi.model.menu.focus.WidgetFocusAdvice;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.Command;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.CommandListManager;
import de.audi.tghu.info.app.InfoEnv;
import de.audi.tghu.info.app.tmc.AppTMC;
import de.audi.tghu.info.app.tmc.TMCAbstractListRow;
import de.audi.tghu.info.app.tmc.TMCAbstractListRowBuilder;
import de.audi.tghu.info.app.tmc.TMCConst;
import de.audi.tghu.info.app.tmc.commands.RequestBoundingRectangleCommand;
import de.audi.tghu.info.app.tmc.commands.RequestMessageIdsForListElement;
import de.audi.tghu.info.app.tmc.commands.RequestWindowCommand;
import de.audi.tghu.info.app.tmc.commands.TMCCommand;
import de.audi.tghu.info.app.tmc.commands.TMCDefaultErrorCommand;
import java.util.ArrayList;
import org.dsi.ifc.global.NavRectangle;
import org.dsi.ifc.tmc.TmcListElement;
import org.dsi.ifc.tmc.TmcMessage;

public abstract class TMCAbstractListManager
implements TiledListModelListener {
    public static final int DEFAULT_REQUEST_ID = -1;
    public static final int WINDOW_CHANGED_REQUEST_ID = -2;
    public static final int WINDOW_FOR_TMC_NEXT_BUTTON_ID = -3;
    protected final InfoEnv env;
    protected final AppTMC appTmc;
    protected final TMCAbstractListRowBuilder rowBuilder;
    protected TiledListModelApp listModel;
    protected BaseListModelApp listModelDetails;
    protected final ChoiceModelApp triggerLeaveDetailsScreenChoice;
    protected final ChoiceModelApp showInMapAvailableChoice;
    public static final int SHOW_IN_MAP_AVAILABLE = 1;
    public static final int SHOW_IN_MAP_NOT_AVAILABLE = 0;
    protected final LogChannel lc;
    protected int lastMessageRouteState = -1;
    protected String lastMessageUrgentStatus = "UNKNOWN";
    public static final int ENTERING_TMC_PREVIEWMAP_BUTTON = 500233;
    protected long openedAnchorId = -1L;
    protected volatile int focusedRow = -1;
    private boolean shouldShowOpenAnimation = false;
    protected long lastSelectedNodeId;
    protected TmcMessage lastFocusedMessage;
    protected WidgetFocusAdvice lastWidgetFocusAdvice;
    private boolean tmcScreenShown = false;
    private final BaseListModelApp trafficEventsOnRouteList;
    private static String LOGCLASS = "TMCAbstractListManager";

    public TMCAbstractListManager(InfoEnv infoEnv, AppTMC appTMC, TiledListModelApp tiledListModelApp, TMCAbstractListRowBuilder tMCAbstractListRowBuilder) {
        this.lc = infoEnv.getLogChannel();
        this.env = infoEnv;
        this.appTmc = appTMC;
        this.listModel = tiledListModelApp;
        this.rowBuilder = tMCAbstractListRowBuilder;
        this.triggerLeaveDetailsScreenChoice = infoEnv.getChoiceModel(500196);
        this.showInMapAvailableChoice = infoEnv.getChoiceModel(500206);
        this.listModel.setListener(this);
        this.trafficEventsOnRouteList = infoEnv.getBaseListModel(500225);
    }

    protected abstract void onTmcWindowResult(TmcListElement var1, TMCAbstractListRow var2);

    protected abstract void onUpdateEventsTotal();

    protected abstract void onTmcWindowChanged();

    protected abstract void anchorMessageVanished(int var1, int var2);

    protected abstract void loadNextDetailsScreen();

    public abstract void fillDetailScreen(TmcMessage var1);

    public void fillDetailScreen(TmcMessage tmcMessage, int n) {
        this.fillDetailScreen(tmcMessage);
    }

    public TiledListModelApp getListModel() {
        return this.listModel;
    }

    public void setFocusedRowIndex(int n) {
        this.focusedRow = n;
    }

    public MenuModelApp getMenuModel() {
        return null;
    }

    public CommandList tmcWindowResult(final TmcListElement[] tmcListElementArray, int n, final int n2, int n3, final BaseListModelApp baseListModelApp) {
        if (n != n3 && n2 != -3) {
            this.anchorMessageVanished(n, n3);
        }
        CommandListManager commandListManager = this.appTmc.getCmdListManager();
        CommandList commandList = new CommandList(commandListManager);
        commandList.add(new TMCCommand(this.appTmc, this.lc, "TMCAbstractListManager#tmcWindowResult"){

            public void execute() {
                TMCAbstractListManager.this.lc.log(10000000, "TMCAbstractListManager#tmcWindowResult - execute");
                EvoListRow[] evoListRowArray = new TMCAbstractListRow[tmcListElementArray.length];
                for (int i2 = 0; i2 < tmcListElementArray.length; ++i2) {
                    TMCAbstractListRow tMCAbstractListRow;
                    if (tmcListElementArray[i2].hasChild) {
                        tMCAbstractListRow = TMCAbstractListManager.this.rowBuilder.buildParentNodeListRow(tmcListElementArray[i2], TMCAbstractListManager.this.getOpenedAnchorId());
                        if (TMCAbstractListManager.this.shouldShowOpenAnimation && tmcListElementArray[i2].getUID() == TMCAbstractListManager.this.getOpenedAnchorId()) {
                            TMCAbstractListManager.this.showOpenAnimation(tmcListElementArray, i2);
                        }
                    } else {
                        tMCAbstractListRow = TMCAbstractListManager.this.rowBuilder.buildSimpleListRow(tmcListElementArray[i2]);
                    }
                    evoListRowArray[i2] = tMCAbstractListRow;
                    TMCAbstractListManager.this.onTmcWindowResult(tmcListElementArray[i2], (TMCAbstractListRow)evoListRowArray[i2]);
                }
                baseListModelApp.setRows(n2, tmcListElementArray[0].getPositionInCompleteList() - 1, evoListRowArray);
                TMCAbstractListManager.this.listModel.update(baseListModelApp);
                if (n2 == -3) {
                    TMCAbstractListManager.this.loadNextDetailsScreen();
                }
                if (n2 == -2) {
                    TMCAbstractListManager.this.onTmcWindowChanged();
                }
                this.getCommandList().commandFinished();
            }
        });
        return commandList;
    }

    public void resetAnchor() {
        this.openedAnchorId = -1L;
    }

    private void showOpenAnimation(TmcListElement[] tmcListElementArray, int n) {
        TMCAbstractListRow tMCAbstractListRow;
        ArrayList arrayList = new ArrayList();
        for (int i2 = n + 1; i2 < tmcListElementArray.length && (tMCAbstractListRow = this.rowBuilder.buildSimpleListRow(tmcListElementArray[i2])) != null && tMCAbstractListRow.getTmcListElement().parentID == this.getOpenedAnchorId(); ++i2) {
            arrayList.add(tMCAbstractListRow);
        }
        EvoListRow[] evoListRowArray = (TMCAbstractListRow[])arrayList.toArray(new TMCAbstractListRow[arrayList.size()]);
        this.listModel.insertAfterAndOpen(this.getOpenedAnchorId(), evoListRowArray);
        this.shouldShowOpenAnimation = false;
    }

    protected void parentNodeSelected(final TMCAbstractListRow tMCAbstractListRow) {
        CommandListManager commandListManager = this.appTmc.getCmdListManager();
        CommandList commandList = new CommandList(commandListManager);
        commandList.add(new TMCCommand(this.appTmc, this.lc, "TMCAbstractListManager#parentNodeSelected"){

            public void execute() {
                TMCAbstractListManager.this.lc.log(10000000, "TMCAbstractListManager#parentNodeSelected - execute");
                if (tMCAbstractListRow.getTmcListElement().getUID() == TMCAbstractListManager.this.getOpenedAnchorId()) {
                    TMCAbstractListManager.this.setOpenedAnchorId(-1L);
                    int n = TMCAbstractListManager.this.listModel.getLength();
                    TMCAbstractListManager.this.listModel.removeAndClose(tMCAbstractListRow.getTmcListElement().getUID(), tMCAbstractListRow.getTmcListElement().numberOfMessagesInNode);
                    TMCAbstractListManager.this.listModel.setLength(n);
                } else {
                    TMCAbstractListRow tMCAbstractListRow2;
                    if (TMCAbstractListManager.this.getOpenedAnchorId() != -1L && (tMCAbstractListRow2 = (TMCAbstractListRow)TMCAbstractListManager.this.listModel.getRowByUniqueID(TMCAbstractListManager.this.getOpenedAnchorId())) != null) {
                        int n = TMCAbstractListManager.this.listModel.getLength();
                        TMCAbstractListManager.this.listModel.removeAndClose(tMCAbstractListRow2.getTmcListElement().getUID(), tMCAbstractListRow2.getTmcListElement().numberOfMessagesInNode);
                        TMCAbstractListManager.this.listModel.setLength(n);
                    }
                    TMCAbstractListManager.this.setOpenedAnchorId(tMCAbstractListRow.getTmcListElement().getUID());
                    TMCAbstractListManager.this.shouldShowOpenAnimation = true;
                }
                long[] lArray = TMCAbstractListManager.this.getSurroundingAnchorIds(tMCAbstractListRow.getTmcListElement().getUID());
                this.getCommandList().commandFinishedWithPostCommand(TMCAbstractListManager.this.getRequestWindowCommand(lArray, TMCAbstractListManager.this.getOpenedAnchorId(), -1, TMCConst.WINDOW_REQUEST_SIZE));
            }
        });
        commandList.setErrorCommand(new TMCDefaultErrorCommand(this.appTmc, this.lc));
        commandListManager.execute(commandList);
    }

    protected boolean isNextNodeAvailable(int n) {
        TMCAbstractListRow tMCAbstractListRow = (TMCAbstractListRow)this.listModel.getRow(n + 1);
        if (tMCAbstractListRow == null) {
            if (this.lc.isDebug2()) {
                this.lc.log(100000000, "TMCAbstractListManager#isNextNodeAvailable nextRow == null");
            }
            return false;
        }
        if (tMCAbstractListRow.getTmcListElement().hasChild) {
            TMCAbstractListRow tMCAbstractListRow2 = (TMCAbstractListRow)this.listModel.getRow(n + 2);
            if (tMCAbstractListRow2 == null) {
                if (this.lc.isDebug2()) {
                    this.lc.log(100000000, "TMCAbstractListManager#isNextNodeAvailable childNode == null");
                }
                return false;
            }
            if (tMCAbstractListRow2.getTmcListElement().parentID != tMCAbstractListRow.getTmcListElement().uID) {
                if (this.lc.isDebug2()) {
                    this.lc.log(100000000, "TMCAbstractListManager#isNextNodeAvailable childNode.parentID != nextRow.uID");
                }
                return false;
            }
        }
        if (this.lc.isDebug2()) {
            this.lc.log(100000000, "TMCAbstractListManager#isNextNodeAvailable return true");
        }
        return true;
    }

    protected long getOpenedAnchorId() {
        return this.openedAnchorId;
    }

    protected final void setOpenedAnchorId(long l) {
        this.openedAnchorId = l;
    }

    public Command getRequestWindowCommand(long[] lArray, long l, int n, int n2) {
        if (this.appTmc.isDSITmcReady() && this.appTmc.isNavigationOperable()) {
            int[] nArray = this.castLongToIntArray(lArray);
            return new RequestWindowCommand(n2, nArray, (int)l, n, this.appTmc, this.lc, this);
        }
        this.lc.log(10000, "TMCAbstractListManager#requestWindow() - trying to request a window but DSITmc (%1) or Navigation (%2) is not ready - do nothing!", this.appTmc.isDSITmcReady(), this.appTmc.isNavigationOperable());
        return null;
    }

    protected void focusPreviewMapOnParentNode(long l) {
        this.lc.log(10000000, "TMCAbstractListManager#focusPreviewMapOnParentNode %1", l);
        if (this.appTmc.isDSITmcReady() && this.appTmc.isNavigationOperable()) {
            RequestMessageIdsForListElement requestMessageIdsForListElement = new RequestMessageIdsForListElement(this.appTmc, this.lc, l);
            RequestBoundingRectangleCommand requestBoundingRectangleCommand = new RequestBoundingRectangleCommand(this.appTmc, this.lc);
            TMCCommand tMCCommand = new TMCCommand(this.appTmc, this.lc, "TMCAbstractListManager#focusPreviewMapOnParentNode SHOW_IN_MAP_AVAILABLE"){

                public void execute() {
                    TMCAbstractListManager.this.showInMapAvailableChoice.setValue(1);
                    this.getCommandList().commandFinished();
                }
            };
            TMCCommand tMCCommand2 = new TMCCommand(this.appTmc, this.lc, "TMCAbstractListManager#focusPreviewMapOnParentNode focus previewmap"){

                public void execute() {
                    NavRectangle navRectangle = TMCAbstractListManager.this.appTmc.getResponseContainer().getRectangle();
                    TMCAbstractListManager.this.appTmc.getPreviewMap().setPreviewTrafficInfoTmcEvents(this.tmcApp.getResponseContainer().getChildrenTrafficEvents(), navRectangle, 13, null, null);
                    this.getCommandList().commandFinished();
                }
            };
            CommandListManager commandListManager = this.appTmc.getCmdListManager();
            CommandList commandList = new CommandList(commandListManager);
            commandList.add(requestMessageIdsForListElement);
            commandList.add(requestBoundingRectangleCommand);
            commandList.add(tMCCommand);
            commandList.add(tMCCommand2);
            commandListManager.execute(commandList);
        }
    }

    protected void setPreviewTrafficInfoTmcEvent(TmcMessage tmcMessage) {
        this.setPreviewTrafficInfoTmcEvent(tmcMessage, 13, true);
    }

    protected void setPreviewTrafficInfoTmcEvent(final TmcMessage tmcMessage, final int n, final boolean bl) {
        if (null == tmcMessage) {
            this.lc.log(100000, "TMCAbstractListManager#setPreviewTrafficInfoTmcEvent() - TmcMessage is null");
            return;
        }
        CommandListManager commandListManager = this.appTmc.getCmdListManager();
        CommandList commandList = new CommandList(commandListManager);
        if (!tmcMessage.isHasGeoPos()) {
            commandList.add(new TMCCommand(this.appTmc, this.lc, "TMCAbstractListManager#setPreviewTrafficInfoTmcEvent SHOW_IN_MAP_NOT_AVAILABLE"){

                public void execute() {
                    TMCAbstractListManager.this.showInMapAvailableChoice.setValue(0);
                    TMCAbstractListManager.this.handleShowInMapNotAvailable();
                    this.getCommandList().commandFinished();
                }
            });
        } else {
            commandList.add(new TMCCommand(this.appTmc, this.lc, "TMCAbstractListManager#setPreviewTrafficInfoTmcEvent SHOW_IN_MAP_AVAILABLE"){

                public void execute() {
                    TMCAbstractListManager.this.showInMapAvailableChoice.setValue(1);
                    TMCAbstractListManager.this.appTmc.getTMCHandler().getBoundingRectangle(new long[]{tmcMessage.getMessageID()});
                }

                public void getBoundingRectangleForTrafficMessagesResult(NavRectangle navRectangle) {
                    TMCAbstractListManager.this.appTmc.getResponseContainer().setRectangle(navRectangle);
                    this.getCommandList().commandFinished();
                }
            });
            commandList.add(new TMCCommand(this.appTmc, this.lc, "TMCAbstractListManager#setPreviewTrafficInfoTmcEvent focus previewmap"){

                public void execute() {
                    NavRectangle navRectangle = TMCAbstractListManager.this.appTmc.getResponseContainer().getRectangle();
                    if (!bl) {
                        TMCAbstractListManager.this.appTmc.getPreviewMap().setPreviewMapPositionRefreshAllowed(false);
                    }
                    TMCAbstractListManager.this.appTmc.getPreviewMap().setPreviewTrafficInfoTmcEvents(new long[]{tmcMessage.getMessageID()}, navRectangle, n, null, null);
                    if (!bl) {
                        TMCAbstractListManager.this.appTmc.getPreviewMap().setPreviewMapPositionRefreshAllowed(true);
                    }
                    this.getCommandList().commandFinished();
                }
            });
        }
        commandListManager.execute(commandList);
    }

    protected void handleShowInMapNotAvailable() {
        this.appTmc.getPreviewMap().hidePreviewMap();
    }

    protected void focusPreviewMapOnCCP() {
        CommandListManager commandListManager = this.appTmc.getCmdListManager();
        CommandList commandList = new CommandList(commandListManager);
        commandList.add(new TMCCommand(this.appTmc, this.lc, "TMCAbstractListManager#focusPreviewMapOnCCP"){

            public void execute() {
                TMCAbstractListManager.this.appTmc.getPreviewMap().setPreviewAreaAroundCCP(13);
                this.getCommandList().commandFinished();
            }
        });
        commandListManager.execute(commandList);
    }

    protected int[] castLongToIntArray(long[] lArray) {
        if (lArray == null) {
            return null;
        }
        int[] nArray = new int[lArray.length];
        for (int i2 = 0; i2 < lArray.length; ++i2) {
            nArray[i2] = (int)lArray[i2];
            if ((long)nArray[i2] == lArray[i2]) continue;
            this.lc.log(100000, "TMCAbstractListManager#castLongToIntArray() - cast warning: 'long' input (%1) does not equal 'int' result (%2)", (Object)lArray, (Object)nArray);
        }
        return nArray;
    }

    protected long[] getSurroundingAnchorIds(long l) {
        int n;
        ArrayList arrayList = new ArrayList(5);
        arrayList.add(new Long(l));
        if (l >= 0L) {
            TMCAbstractListRow tMCAbstractListRow;
            int n2;
            int n3 = 0;
            n = this.listModel.getIndexForUniqueID(l);
            for (n2 = n - 1; n2 >= 0; --n2) {
                tMCAbstractListRow = (TMCAbstractListRow)this.listModel.getRow(n2);
                if (n3 == 2 || tMCAbstractListRow == null) break;
                arrayList.add(new Long(tMCAbstractListRow.getUniqueID()));
                ++n3;
            }
            n3 = 0;
            for (n2 = n + 1; n2 < this.listModel.getLength(); ++n2) {
                tMCAbstractListRow = (TMCAbstractListRow)this.listModel.getRow(n2);
                if (n3 == 2 || tMCAbstractListRow == null) break;
                arrayList.add(new Long(tMCAbstractListRow.getUniqueID()));
                ++n3;
            }
        }
        long[] lArray = new long[arrayList.size()];
        for (n = 0; n < arrayList.size(); ++n) {
            lArray[n] = (Long)arrayList.get(n);
        }
        return lArray;
    }

    protected long findLastKnownAnchor(TMCAbstractListRow tMCAbstractListRow, int n) {
        TMCAbstractListRow tMCAbstractListRow2;
        int n2;
        if (tMCAbstractListRow != null) {
            return tMCAbstractListRow.getTmcListElement().getUID();
        }
        for (n2 = n; n2 >= 0; --n2) {
            tMCAbstractListRow2 = (TMCAbstractListRow)this.listModel.getRow(n2);
            if (tMCAbstractListRow2 == null) continue;
            return tMCAbstractListRow2.getTmcListElement().getUID();
        }
        for (n2 = n; n2 < this.listModel.getLength(); ++n2) {
            tMCAbstractListRow2 = (TMCAbstractListRow)this.listModel.getRow(n2);
            if (tMCAbstractListRow2 == null) continue;
            return tMCAbstractListRow2.getTmcListElement().getUID();
        }
        return -1L;
    }

    public void updateDistanceAndDirection(final int n) {
        CommandListManager commandListManager = this.appTmc.getCmdListManager();
        CommandList commandList = new CommandList(commandListManager);
        commandList.add(new TMCCommand(this.appTmc, this.lc, "TMCAbstractListManager#updateDistanceAndDirection"){

            public void execute() {
                TMCAbstractListManager.this.lc.log(10000000, "%1#updateDistanceAndDirection(distCarToFinalDest:%1) execute", (Object)LOGCLASS, (long)n);
                BaseListModelApp baseListModelApp = TMCAbstractListManager.this.listModel.getCopy();
                for (int i2 = 0; i2 < baseListModelApp.getLength(); ++i2) {
                    TMCAbstractListRow tMCAbstractListRow = (TMCAbstractListRow)baseListModelApp.getRow(i2);
                    if (tMCAbstractListRow == null || tMCAbstractListRow.getTmcListElement().hasChild) continue;
                    tMCAbstractListRow.updateDistanceAndDireciton(n, TMCAbstractListManager.this.rowBuilder.getDirectionArrow(tMCAbstractListRow.getTmcListElement().getMessage()), TMCAbstractListManager.this.rowBuilder.getAirDistance(tMCAbstractListRow.getTmcListElement().getMessage()));
                    baseListModelApp.setRow(i2, tMCAbstractListRow);
                }
                TMCAbstractListManager.this.listModel.update(baseListModelApp);
                baseListModelApp = TMCAbstractListManager.this.listModelDetails.getCopy();
                TMCAbstractListRow tMCAbstractListRow = null;
                for (int i3 = 0; i3 < baseListModelApp.getLength(); ++i3) {
                    TMCAbstractListRow tMCAbstractListRow2 = (TMCAbstractListRow)baseListModelApp.getRow(i3);
                    long l = (long)n - tMCAbstractListRow2.getTmcListElement().getMessage().distanceToEvent;
                    if (tMCAbstractListRow2.isLayoutOnRoute() && l < 0L) {
                        tMCAbstractListRow = tMCAbstractListRow2;
                        continue;
                    }
                    tMCAbstractListRow2.updateDistanceAndDireciton(n, TMCAbstractListManager.this.rowBuilder.getDirectionArrow(tMCAbstractListRow2.getTmcListElement().getMessage()), TMCAbstractListManager.this.rowBuilder.getAirDistance(tMCAbstractListRow2.getTmcListElement().getMessage()));
                    baseListModelApp.setRow(i3, tMCAbstractListRow2);
                }
                if (tMCAbstractListRow != null) {
                    baseListModelApp.remove(tMCAbstractListRow);
                }
                TMCAbstractListManager.this.listModelDetails.update(baseListModelApp);
                this.getCommandList().commandFinished();
            }
        });
        commandListManager.execute(commandList);
    }

    public void updateEventsTotal(final int n) {
        CommandListManager commandListManager = this.appTmc.getCmdListManager();
        CommandList commandList = new CommandList(commandListManager);
        commandList.add(new TMCCommand(this.appTmc, this.lc, "TMCAbstractListManager#updateEventsTotal"){

            public void execute() {
                TMCAbstractListManager.this.lc.log(10000000, "%1#setListLength(%2) execute", (Object)LOGCLASS, (long)n);
                TMCAbstractListManager.this.listModel.setLength(n);
                TMCAbstractListManager.this.onUpdateEventsTotal();
                this.getCommandList().commandFinished();
            }
        });
        commandListManager.execute(commandList);
    }

    public void tmcWindowChanged() {
        this.lc.log(10000000, "%1#tmcWindowChanged", (Object)LOGCLASS);
        TMCAbstractListRow tMCAbstractListRow = (TMCAbstractListRow)this.listModel.getRow(this.focusedRow);
        long l = -1L;
        if (tMCAbstractListRow != null) {
            l = tMCAbstractListRow.getTmcListElement().getUID();
        }
        CommandListManager commandListManager = this.appTmc.getCmdListManager();
        CommandList commandList = new CommandList(commandListManager);
        commandList.add(this.getRequestWindowCommand(this.getSurroundingAnchorIds(l), this.getOpenedAnchorId(), -2, TMCConst.WINDOW_REQUEST_SIZE));
        commandListManager.execute(commandList);
    }

    public void detailsScreenEntered() {
        if (this.lastFocusedMessage != null) {
            this.setPreviewTrafficInfoTmcEvent(this.lastFocusedMessage);
        }
    }

    public BaseListModelApp getEmptyListModelCopy() {
        BaseListModelApp baseListModelApp = this.listModel.getEmptyCopy();
        baseListModelApp.setLength(this.listModel.getLength());
        return baseListModelApp;
    }

    public WidgetFocusAdvice getLastWidgetFocusAdvice() {
        return this.lastWidgetFocusAdvice;
    }

    public TMCAbstractListRow getLastSelectedRow() {
        return (TMCAbstractListRow)this.listModel.getRowByUniqueID(this.lastSelectedNodeId);
    }

    public void requestItems(int n, int n2, int n3, int n4, int n5) {
        this.lc.log(10000000, "[TMCAbstractListManager#requestItems] - requestID = %1, startIndex = %2, length = %3", (long)n3, (long)n, (long)n2);
        long l = this.findLastKnownAnchor((TMCAbstractListRow)this.listModel.getRow(n), n);
        long[] lArray = this.getSurroundingAnchorIds(l);
        CommandListManager commandListManager = this.appTmc.getCmdListManager();
        CommandList commandList = new CommandList(commandListManager);
        commandList.add(this.getRequestWindowCommand(lArray, this.getOpenedAnchorId(), n3, n2));
        commandListManager.execute(commandList);
    }

    public void itemReleased(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
        if (this.lc.isDebug2()) {
            this.lc.log(100000000, "%1#itemReleased", (Object)LOGCLASS);
        }
    }

    public void itemSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
        if (this.lc.isDebug2()) {
            this.lc.log(100000000, "%1#itemSelected", (Object)LOGCLASS);
        }
    }

    public void itemFocused(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
        if (this.lc.isDebug2()) {
            this.lc.log(100000000, "%1#itemFocused", (Object)LOGCLASS);
        }
    }

    public void unrequestItems(int n, int n2, int n3, int n4) {
        if (this.lc.isDebug2()) {
            this.lc.log(100000000, "%1#unrequestItems", (Object)LOGCLASS);
        }
    }

    public int getLengthOfCurrentList() {
        return this.listModel.getLength();
    }

    public void setLengthOnRouteList(int n) {
    }

    public void updateTmcMessagesAhead(TmcMessage[] tmcMessageArray) {
        int n;
        int n2 = n = tmcMessageArray == null ? 0 : tmcMessageArray.length;
        if (n > 0) {
            BaseListModelApp baseListModelApp = this.trafficEventsOnRouteList.getEmptyCopy();
            baseListModelApp.removeAll();
            for (int i2 = 0; i2 < n; ++i2) {
                TMCAbstractListRow tMCAbstractListRow = this.rowBuilder.buildSimpleListRow(tmcMessageArray[i2]);
                baseListModelApp.append(tMCAbstractListRow);
            }
            this.trafficEventsOnRouteList.update(baseListModelApp);
        } else {
            this.trafficEventsOnRouteList.removeAll();
        }
    }

    public void setTmcScreenShown(boolean bl) {
        this.tmcScreenShown = bl;
    }

    public boolean isTmcScreenShown() {
        return this.tmcScreenShown;
    }
}

