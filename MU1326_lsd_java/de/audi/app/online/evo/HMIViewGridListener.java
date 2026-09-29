/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.online.evo;

import de.audi.app.online.evo.AbstractHMIViewListenerEvo;
import de.audi.app.online.evo.Decorator;
import de.audi.app.online.evo.HMIViewGridListener$1;
import de.audi.app.online.evo.HMIViewGridListener$2;
import de.audi.app.online.evo.HMIViewGridListener$3;
import de.audi.app.online.evo.HMIViewGridListener$4;
import de.audi.app.online.evo.HMIViewGridListener$5;
import de.audi.app.online.evo.HMIViewGridListener$6;
import de.audi.app.online.evo.HMIViewGridListener$7;
import de.audi.app.online.evo.HMIViewGridListener$8;
import de.audi.app.online.evo.HMIViewGridListener$9;
import de.audi.app.online.evo.HMIViewGridListener$UpdateDecoratorTask;
import de.audi.app.online.evo.HMIViewGridScreenAccess;
import de.audi.app.online.evo.HMIViewNpsListener;
import de.audi.app.online.evo.RemoteHMIServiceEvo;
import de.audi.app.online.evo.SpellerHandler;
import de.audi.app.online.evo.remotehmi.drawers.RightDrawerHandler;
import de.audi.app.online.evo.search.OnlineSearchDataProvider;
import de.audi.atip.hmi.HMIService;
import de.audi.atip.hmi.model.ChoiceListener;
import de.audi.atip.hmi.model.ModelGroup;
import de.audi.atip.hmi.model.list.BaseListModelListener;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.hmi.model.menu.MenuModelListener;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.interapp.NaviOnlineService$RRDListener;
import de.audi.atip.interapp.PortalAuthenticationService$UpdateProfileInfoListener;
import de.audi.atip.interapp.online.IGridListRow;
import de.audi.atip.log.LogChannel;
import de.audi.remotehmi.HMIProperties;
import de.audi.remotehmi.IOsrUserCacheInformation;
import de.audi.remotehmi.RemoteHMIAction;
import de.audi.remotehmi.media.IMediaValues;
import de.audi.remotehmi.ui.mib2.grid.ICursor;
import de.audi.remotehmi.ui.mib2.grid.ICursorComponent;
import de.audi.remotehmi.ui.mib2.grid.IGrid;
import de.audi.remotehmi.ui.mib2.grid.IGridCell;
import de.audi.remotehmi.ui.mib2.grid.IGridFactory;
import de.audi.remotehmi.ui.mib2.grid.IGridList;
import de.audi.remotehmi.ui.mib2.grid.IInfiniteListListener;
import de.audi.remotehmi.ui.mib2.grid.ISpeller;
import de.audi.tghu.online.app.remotehmi.ContextManagerComponent;
import de.audi.tghu.online.app.remotehmi.EntryPoint;
import de.audi.tghu.online.app.remotehmi.GridHelper;
import de.audi.tghu.online.app.remotehmi.OnlineModelBankAccess;
import de.audi.tghu.online.app.remotehmi.RemoteHMIContext;
import de.audi.tghu.online.app.remotehmi.RemoteHMIService;
import de.audi.tghu.online.app.remotehmi.RrdCalculationHandler;
import de.audi.tghu.online.app.remotehmi.UpdateRrdTask;
import de.audi.tghu.online.app.remotehmi.onlinemedia.MediaValues;
import de.audi.tghu.online.app.remotehmi.search.ITruffleSearchHandler;
import de.audi.tghu.online.app.remotehmi.util.UtilOnline;
import java.util.List;
import org.dsi.ifc.online.OSRDevice;

public class HMIViewGridListener
extends AbstractHMIViewListenerEvo
implements MenuModelListener,
ChoiceListener,
PortalAuthenticationService$UpdateProfileInfoListener,
BaseListModelListener,
NaviOnlineService$RRDListener,
IInfiniteListListener {
    private static int LAZY_LOADING_RANGE = 1;
    private SpellerHandler spellerHandler;
    private RemoteHMIServiceEvo remoteHmiServiceEvo;
    private IGridFactory gridFactory;
    private HMIViewGridScreenAccess screenAccess;
    private RrdCalculationHandler rrdCalculationHandler;
    private final Long DECORATOR_DELAY = new Long(0);
    private final int HIDE_ENTERTAINMENT_DRAWER;
    private final int SHOW_ENTERTAINMENT_DRAWER;
    private final int HIDE_SOURCE_ICON_IN_TITEL;
    private final int SHOW_SOURCE_ICON_IN_TITEL;
    private final ContextManagerComponent contextManagerComponent;
    private static int renderCounter;
    private boolean isLockingEnabled = false;
    static /* synthetic */ Class class$de$audi$remotehmi$ui$mib2$grid$IGridList;
    static /* synthetic */ Class class$de$audi$remotehmi$ui$mib2$grid$ISpeller;

    public HMIViewGridListener(LogChannel logChannel, ModelGroup modelGroup, OnlineModelBankAccess onlineModelBankAccess, HMIService hMIService, RemoteHMIServiceEvo remoteHMIServiceEvo, HMIViewGridScreenAccess hMIViewGridScreenAccess) {
        super(logChannel, modelGroup, onlineModelBankAccess, hMIService, remoteHMIServiceEvo, hMIViewGridScreenAccess);
        this.HIDE_ENTERTAINMENT_DRAWER = 0;
        this.SHOW_ENTERTAINMENT_DRAWER = 1;
        this.HIDE_SOURCE_ICON_IN_TITEL = 0;
        this.SHOW_SOURCE_ICON_IN_TITEL = 1;
        if (logChannel == null || modelGroup == null || onlineModelBankAccess == null || remoteHMIServiceEvo == null || hMIService == null || hMIViewGridScreenAccess == null) {
            UtilOnline.validateArgumentNotNull(logChannel, "logChannel");
            UtilOnline.validateArgumentNotNull(modelGroup, "modelGroup");
            UtilOnline.validateArgumentNotNull(onlineModelBankAccess, "modelBank");
            UtilOnline.validateArgumentNotNull(remoteHMIServiceEvo, "remoteHmiServiceEvo");
            UtilOnline.validateArgumentNotNull(hMIService, "hmiService");
            UtilOnline.validateArgumentNotNull(hMIViewGridScreenAccess, "screenAccess");
        }
        this.remoteHmiServiceEvo = remoteHMIServiceEvo;
        this.screenAccess = hMIViewGridScreenAccess;
        this.contextManagerComponent = this.remoteHmiService.getContextManagerComponent();
        this.spellerHandler = new SpellerHandler(logChannel, onlineModelBankAccess, remoteHMIServiceEvo, this, modelGroup);
        this.rrdCalculationHandler = new RrdCalculationHandler(logChannel, remoteHMIServiceEvo);
    }

    public RrdCalculationHandler getRrdCalculationHandler() {
        return this.rrdCalculationHandler;
    }

    public void setTruffleComponent(ITruffleSearchHandler iTruffleSearchHandler) {
        this.spellerHandler.setTruffleComponent(iTruffleSearchHandler);
    }

    @Override
    public IGridList getCurrentGridList() {
        return this.screenAccess.getGridList();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void updateViewProperties(HMIProperties hMIProperties, boolean bl, RemoteHMIContext remoteHMIContext) {
        EntryPoint entryPoint;
        int n;
        Object object;
        int n2;
        int n3;
        int n4;
        boolean bl2;
        ISpeller iSpeller;
        boolean bl3;
        Object object2;
        int n5;
        int n6;
        boolean bl4;
        Object object3;
        String string = remoteHMIContext == null ? "NULL" : remoteHMIContext.getContextName();
        this.logChannel.log(1078071040, "HMIViewGridListener#updateViewProperties: isInitialList=%1 contextName=%2", bl, (Object)string);
        if (hMIProperties == null || remoteHMIContext == null) {
            UtilOnline.validateArgumentNotNull(hMIProperties, "props");
            UtilOnline.validateArgumentNotNull(remoteHMIContext, "context");
        }
        if (this.gridFactory == null) {
            this.gridFactory = this.remoteHmiServiceEvo.getGridFactory();
            UtilOnline.validateArgumentNotNull(this.gridFactory, "gridFactory");
        }
        if (!this.isDefaultCursorAvailable()) {
            this.setDefaultCursor(this.gridFactory.createCursor());
        }
        if (!((object3 = hMIProperties.get("gridList")) instanceof IGridList)) {
            UtilOnline.validateObject(object3, class$de$audi$remotehmi$ui$mib2$grid$IGridList == null ? (class$de$audi$remotehmi$ui$mib2$grid$IGridList = HMIViewGridListener.class$("de.audi.remotehmi.ui.mib2.grid.IGridList")) : class$de$audi$remotehmi$ui$mib2$grid$IGridList, "gridList", "props.get(Properties.PROP_GRID_LIST)");
        }
        IGridList iGridList = (IGridList)object3;
        this.handleScreenType(hMIProperties);
        IGridList iGridList2 = this.screenAccess.getGridList();
        int n7 = iGridList2 != null ? iGridList2.getIdRangeStart() : 0;
        this.logChannel.log(1078071040, "HMIViewGridListener#updateViewProperties: old grid list start range: %1", (long)n7);
        int n8 = iGridList.getIdRangeStart();
        boolean bl5 = bl4 = n8 != 0;
        if (bl4) {
            this.logChannel.log(1078071040, "HMIViewGridListener#updateViewProperties: new grid list was recycled. Its previous start range: %1", (long)n8);
        }
        boolean bl6 = (n6 = iGridList.getViewType()) == 2;
        this.logChannel.log(1078071040, "HMIViewGridListener#updateViewProperties: received %1 %2 list for %3 screen.", (Object)(bl6 ? "infinite" : "normal"), (Object)(bl ? "initial" : "update"), (Object)(this.screenAccess.isMainScreen() ? "main" : "option"));
        if (bl6 && !iGridList.getInfiniteListData().isConsistent(iGridList.size())) {
            n6 = 0;
            bl6 = false;
            iGridList.setViewType(n6);
            this.logChannel.log(1078071040, "HMIViewGridListener#updateViewProperties: because of faulty parameters, this infinite list was changed to a normal list!");
        }
        if (iGridList2 != null) {
            n5 = iGridList2.getViewType();
            this.logChannel.log(1078071040, "HMIViewGridListener#updateViewProperties: viewType='%1'", (Object)IGridList.viewTypeDescription[n6]);
            if (!bl && n5 != n6) {
                object2 = "HMIViewGridListener#updateViewProperties: list is changed from update to initial state, because new viewType='%1' and old viewType='%2' are different. Check screen-ID (the property 'id' of the '<hmi:viewGrid>' SCXML element.";
                this.logChannel.log(-1601830656, (String)object2, (Object)IGridList.viewTypeDescription[n6], (Object)IGridList.viewTypeDescription[n5]);
                bl = true;
            }
        }
        if (iGridList == iGridList2) {
            this.logChannel.log(1078071040, "HMIViewGridListener#updateViewProperties: old and new grid list are the same list!");
        }
        if (iGridList2 == null && !bl) {
            throw new IllegalStateException("An update is sent, but no initial list before!");
        }
        this.logChannel.log(1078071040, "HMIViewGridListener#updateViewProperties: previous render=%1, update=%2", (long)iGridList.getRenderId(), (long)iGridList.getUpdateCounter());
        if (bl4) {
            iGridList.getNextUpdateCounter();
        } else {
            iGridList.setRenderId(renderCounter);
            ++renderCounter;
        }
        n5 = iGridList.getUpdateMode();
        if (bl4) {
            object2 = iGridList;
            synchronized (object2) {
                if (bl) {
                    if (bl6) {
                        GridHelper.setNewIdRange(iGridList, rangeCounter, 5000, this.logChannel);
                    } else {
                        GridHelper.setNewIdRange(iGridList, rangeCounter, this.logChannel);
                    }
                    if (n5 != 5) {
                        this.logChannel.log(1078071040, "HMIViewGridListener#updateViewProperties: an initial recycled list was just rendered before, because update mode= %1. It is corrected to full update.", (Object)IGridList.updateDescription[n5]);
                        n5 = 5;
                        iGridList.setUpdateMode(n5);
                    }
                } else {
                    String string2 = new StringBuffer().append("A new recycled list was sent as update, but it should be either an initial list or a not recycled one! newIdRangeStart=").append(n8).append(" oldIdRangeStart=").append(n7).toString();
                    throw new IllegalStateException(string2);
                }
            }
        } else if (bl) {
            if (bl6) {
                GridHelper.setNewIdRange(iGridList, rangeCounter, 5000, this.logChannel);
            } else {
                GridHelper.setNewIdRange(iGridList, rangeCounter, this.logChannel);
            }
        } else if (bl6) {
            if (n5 == 5 && iGridList.equalsRoughly(iGridList2)) {
                GridHelper.setNewIdRange(iGridList, rangeCounter, 5000, this.logChannel);
            } else {
                if (n5 != 5) {
                    this.logChannel.log(-1601830656, "HMIViewGridListener#updateViewProperties: test case infinite grid list handling used for update mode= %1.", (Object)IGridList.updateDescription[n5]);
                }
                iGridList.copyIdRangeFrom(iGridList2);
            }
        } else if (n5 == 5 || n5 == 2) {
            this.logChannel.log(1078071040, "HMIViewGridListener#updateViewProperties: set new ID range %1.", (Object)rangeCounter);
            GridHelper.setNewIdRange(iGridList, rangeCounter, this.logChannel);
        } else {
            this.logChannel.log(-1601830656, "HMIViewGridListener#updateViewProperties: test case normal grid list handling used for update mode= %1.", (Object)IGridList.updateDescription[n5]);
            iGridList.copyIdRangeFrom(iGridList2);
        }
        this.logChannel.log(1078071040, "HMIViewGridListener#updateViewProperties: new grid list start range: %1, size= %2", (long)iGridList.getIdRangeStart(), (long)iGridList.getIdRangeSize());
        super.updateViewProperties(hMIProperties, bl, remoteHMIContext);
        object2 = hMIProperties.get("speller");
        if (object2 == null) {
            bl3 = false;
            iSpeller = this.gridFactory.createSpeller(1);
        } else if (object2 instanceof ISpeller) {
            bl3 = true;
            iSpeller = (ISpeller)object2;
        } else {
            UtilOnline.validateObject(object2, class$de$audi$remotehmi$ui$mib2$grid$ISpeller == null ? (class$de$audi$remotehmi$ui$mib2$grid$ISpeller = HMIViewGridListener.class$("de.audi.remotehmi.ui.mib2.grid.ISpeller")) : class$de$audi$remotehmi$ui$mib2$grid$ISpeller, "speller", "props.get(Properties.PROP_SPELLER)");
            return;
        }
        this.spellerHandler.updateViewProperties(iSpeller, iGridList, bl, bl4, bl3);
        boolean bl7 = bl2 = n6 == 1;
        if (bl2) {
            n4 = 1;
            n3 = 0;
            n2 = 1;
        } else {
            n4 = 0;
            n3 = 1;
            n2 = 0;
        }
        this.screenAccess.getMediaListModel().setValue(n4);
        this.modelBank.getChoiceModel(1478370048).setValue(n3);
        this.modelBank.getChoiceModel(1495147264).setValue(n2);
        HMIViewNpsListener hMIViewNpsListener = (HMIViewNpsListener)this.remoteHmiServiceEvo.getViewListener(15000);
        if (bl2 && bl) {
            this.setNowPlayingScreenMode(0);
            if (hMIViewNpsListener != null) {
                hMIViewNpsListener.resetLineLeadingIcons();
            }
        }
        this.setTitles(this.screenAccess.getSubtitleModel(), this.screenAccess.getBreadCrumbModel(), hMIProperties);
        ICursor iCursor = this.correctListState(iGridList, bl, remoteHMIContext, this.contextManagerComponent, this.gridFactory);
        iGridList.setCurrentCursor(iCursor);
        if (bl6) {
            iGridList.correctCursorOfInfiniteList();
            iCursor = iGridList.getCurrentCursor();
        }
        remoteHMIContext.setNewCursor(iCursor);
        this.logChannel.log(-2137614336, "AbstractHMIViewListener#getCorrectedCursor: (%1) using corrected cursor %2", (Object)remoteHMIContext.getContextName(), (Object)iCursor);
        ICursorComponent iCursorComponent = iCursor.getFocus();
        int n9 = iCursorComponent.getSubindex();
        int n10 = iCursorComponent.getIndex();
        if (n9 != -1) {
            object = (IGrid)iGridList.get(n10);
            object.setExpanded(true);
        }
        if (bl2) {
            object = hMIViewNpsListener == null ? new MediaValues() : hMIViewNpsListener.getMediaValues();
            iGridList.setMediaGridValues((IMediaValues)object);
        }
        object = iGridList;
        synchronized (object) {
            boolean bl8;
            if (bl || n5 == 5 || iGridList == iGridList2) {
                bl8 = false;
            } else {
                this.logChannel.log(-1601830656, "HMIViewGridListener#updateViewProperties: test case grid list handling used for non menu-structure update.");
                bl8 = true;
            }
            iGridList.setRendered(bl8);
            iGridList.setEventListening(true);
            this.logChannel.log(1078071040, "HMIViewGridListener#updateViewProperties: switching to new grid list = %1", iGridList.getLogObject(0));
            this.screenAccess.setGridList(iGridList);
        }
        object = this.screenAccess.getDecorator();
        ((Decorator)object).setLayout(hMIProperties, iGridList);
        ((Decorator)object).storeTypeAndDefault(hMIProperties, bl);
        if (bl) {
            ((Decorator)object).updateValues(null, iGridList.getReferencePoint(), bl2);
        }
        this.rrdCalculationHandler.setImmediateDistanceUpdate(true);
        this.rrdCalculationHandler.triggerRrdCalculation(iGridList);
        if (this.isLockingEnabled && !this.screenAccess.isMainScreen()) {
            this.updateGridListLocking();
        }
        iGridList.addSender("***HMIViewGridListener#updateViewProperties***");
        GridHelper.updateListModelTransaction(this.screenAccess.getMainListModel(), iGridList, this, n5, 1, this.logChannel);
        this.enableSDSLineNumbers(hMIProperties, this.screenAccess.getSDSLineNumberModel());
        if (remoteHMIContext.getContextName().equals("top_wizard")) {
            OnlineSearchDataProvider onlineSearchDataProvider = this.remoteHmiServiceEvo.getSearchComponent().getDataProvider();
            if (onlineSearchDataProvider != null) {
                onlineSearchDataProvider.updateSourceData(iGridList);
            } else {
                this.logChannel.log(10000, "HMIViewGridListener#updateViewProperties: no online search data provider.");
            }
        }
        int n11 = n = (entryPoint = this.contextManagerComponent.getCurrentEntryPoint()) == null ? -1 : entryPoint.getEntryPointId();
        if (n == 3 || n == 2) {
            this.contextManagerComponent.setLoadingTitleValue(0);
        }
    }

    private void processItemSelected(int n, int n2, IGridListRow iGridListRow) {
        HMIViewGridListener$1 hMIViewGridListener$1 = new HMIViewGridListener$1(this, n, n2, iGridListRow);
        this.remoteHmiService.execute(new HMIViewGridListener$2(this, "process-item-selected", hMIViewGridListener$1, n, n2, iGridListRow));
    }

    private void processItemSelectedImmediately(int n, int n2, IGridListRow iGridListRow) {
        IGrid iGrid;
        IGrid iGrid2;
        IGrid iGrid3;
        IGrid iGrid4;
        IGridList iGridList;
        int n3;
        IGrid iGrid5;
        IGridList iGridList2 = this.screenAccess.getGridList();
        if (!iGridList2.isEventListening()) {
            this.logChannel.log(1078071040, "HMIViewGridListener#processItemSelectedImmediately: all callbacks ignored, because context was destroyed: id=%1, subId=%2.", (long)n, (long)n2);
            return;
        }
        if (iGridListRow != null && iGridListRow.isArtificial()) {
            return;
        }
        boolean bl = iGridList2.getViewType() == 2;
        int n4 = n;
        int n5 = n2;
        if (bl) {
            n4 = n2;
            n5 = -1;
        } else {
            n4 = n;
            n5 = n2;
        }
        int n6 = iGridList2.getIndexWithinRange(n4);
        if (n6 == -1) {
            this.logChannel.log(1078071040, "HMIViewGridListener#processItemSelectedImmediately: callback from old list widget ignored: itemId=%1, subItemId=%2.", (long)n4, (long)n5);
            return;
        }
        if (bl) {
            if (iGridListRow == null) {
                this.logChannel.log(10000, "HMIViewGridListener#processItemSelectedImmediately: row is null in infinite list: itemId=%1, subItemId=%2.", (long)n4, (long)n5);
                return;
            }
            int n7 = iGridList2.getIndexWithinList(n6);
            iGrid5 = (IGrid)iGridListRow.getGridObject();
            n3 = iGridList2.findIndexOfFirstGridId(iGrid5.getId(), n7);
            if (n3 == -1) {
                this.createAndInvokeAction(300, iGrid5, null, true);
                return;
            }
        } else {
            n3 = n6;
        }
        if ((iGridList = (iGrid4 = (IGrid)iGridList2.get(n3)).getExpandedList()) == null || n5 == -1) {
            iGrid5 = null;
        } else {
            if (n5 < 0 || n5 >= iGridList.size()) {
                this.logChannel.log(10000, "HMIViewGridListener#processItemSelectedImmediately: subrow IndexOutOfBounds error. Callback ignored: subrow=%1 but expandedListSize=%2 of row=%3, ", (long)n5, (long)iGridList.size(), (long)n3);
                return;
            }
            iGrid5 = (IGrid)iGridList.get(n5);
        }
        if (iGridList != null && iGrid5 == null) {
            iGrid4.setExpanded(!iGrid4.isExpanded());
            this.updatePageHistory(iGrid4.getId(), n3, iGrid4.isExpanded());
            this.renderGridList(2, false, 1);
        }
        int n8 = iGrid5 == null ? -1 : n5;
        String string = iGrid5 == null ? "" : iGrid5.getId();
        iGridList2.setCurrentSelection(n3, n8, iGrid4.getId(), string);
        this.setNewCursor(iGridList2.getCurrentCursor());
        if (iGridList2.isSelectionEnabled()) {
            this.renderGridList(2, false, 1);
        }
        IGrid iGrid6 = iGrid3 = (iGrid2 = iGrid4.getDetail()) == null ? iGrid4 : iGrid2;
        if (iGrid5 == null) {
            IGridCell iGridCell = iGrid3.getFirstInputCell();
            if (iGridCell != null && iGridCell.getType() == 4) {
                IGridList iGridList3 = iGridCell.getListValue();
                iGrid = iGridList3.getGridOfModelRow(n5);
                if (iGrid == null) {
                    this.logChannel.log(10000, "HMIViewGridListener#processItemSelectedImmediately: selected subrow in drop down list not found: row=%1, subrow=%2.", (long)n3, (long)n5);
                    return;
                }
            } else {
                iGrid = null;
            }
        } else {
            IGrid iGrid7 = iGrid5.getDetail();
            iGrid = iGrid7 == null ? iGrid5 : iGrid7;
        }
        this.createAndInvokeAction(300, iGrid3, iGrid, false);
    }

    @Override
    public void keyPressed(int n, int n2, int n3) {
        this.logChannel.log(1078071040, "HMIViewGridListener#keyPressed: callback from menuItem button: modelID=%1, keyID=%2.", (long)n, (long)n2);
        this.processItemSelected(n, -1, null);
    }

    @Override
    public void itemSelected(int n, int n2, int n3, int n4) {
        this.logChannel.log(1078071040, "HMIViewGridListener#itemSelected: callback from dropDownList: modelID=%1, itemID=%2, col=%3.", (long)n, (long)n2, (long)n3);
        this.processItemSelected(n, n2, null);
    }

    @Override
    public void itemFocused(int n, int n2, int n3, int n4) {
        this.logChannel.log(1078071040, "HMIViewGridListener#itemFocused: callback from choiceListener ignored: modelID=%2, itemID=%1,  col=%3.", (long)n, (long)n2, (long)n3);
    }

    private void processItemFocused(int n, int n2, IGridListRow iGridListRow, boolean bl) {
        HMIViewGridListener$3 hMIViewGridListener$3 = new HMIViewGridListener$3(this, n, n2, iGridListRow);
        this.remoteHmiService.execute(new HMIViewGridListener$4(this, "process-item-focused", hMIViewGridListener$3, n, n2, iGridListRow, bl));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void processItemFocusedImmediately(int n, int n2, IGridListRow iGridListRow, boolean bl) {
        boolean bl2;
        IGrid iGrid;
        String string;
        int n3;
        String string2;
        IGrid iGrid2;
        int n4;
        IGrid iGrid3;
        boolean bl3;
        IGridList iGridList = this.screenAccess.getGridList();
        if (!iGridList.isEventListening()) {
            this.logChannel.log(1078071040, "HMIViewGridListener#processItemFocusedImmediately: all callbacks ignored, because context was destroyed: itemId=%1, subId=%2.", (long)n, (long)n2);
            return;
        }
        boolean bl4 = bl3 = iGridList.getViewType() == 2;
        if (bl3 && bl) {
            this.logChannel.log(1078071040, "HMIViewGridListener#processItemFocusedImmediately: callback from menu ignored: infiniteList");
            return;
        }
        int n5 = n;
        int n6 = n2;
        if (bl3) {
            n5 = n2;
            n6 = -1;
        } else {
            n5 = n;
            n6 = n2;
        }
        int n7 = iGridList.getIndexWithinRange(n5);
        if (n7 == -1 && n5 != -1 && rangeCounter.isInsideRangeBoundary(n5)) {
            this.logChannel.log(1078071040, "HMIViewGridListener#processItemFocusedImmediately: callback from old list widget ignored: itemId=%1, subItemId=%2.", (long)n5, (long)n6);
            return;
        }
        if (bl3) {
            int n8 = iGridList.getIndexWithinList(n7);
            iGrid3 = (IGrid)iGridListRow.getGridObject();
            n4 = iGridList.findIndexOfFirstGridId(iGrid3.getId(), n8);
        } else {
            n4 = n7;
        }
        if (n4 == -1) {
            iGrid2 = null;
            iGrid3 = null;
        } else {
            iGrid2 = (IGrid)iGridList.get(n4);
            this.logChannel.log(1078071040, "HMIViewGridListener#processItemFocusedImmediately focusedGridId='%1'", (Object)iGrid2.getId());
            IGridList iGridList2 = iGrid2.getExpandedList();
            if (iGridList2 == null || n6 == -1) {
                iGrid3 = null;
            } else if (n6 < 0 || n6 >= iGridList2.size()) {
                this.logChannel.log(10000, "HMIViewGridListener#processItemFocusedImmediately: subrow IndexOutOfBounds error. Subindex ignored: subrow=%1 but expandedListSize=%2 of row=%3, ", (long)n6, (long)iGridList2.size(), (long)n4);
                iGrid3 = null;
            } else {
                iGrid3 = (IGrid)iGridList2.get(n6);
            }
        }
        if (bl && iGrid2 != null && iGrid2.getExpandedList() != null) {
            this.logChannel.log(1078071040, "HMIViewGridListener#processItemFocusedImmediately: callback from menu ignored: expandable item");
            return;
        }
        if (iGridList.getViewType() == 1) {
            this.handleMediaGridList();
        }
        if (iGrid2 == null) {
            this.logChannel.log(1078071040, "HMIViewGridListener#processItemFocusedImmediately: focus for mainGridList is set to default because the focus is out of gridlist");
            string2 = "";
            n3 = -1;
            string = "";
        } else {
            string2 = iGrid2.getId();
            n3 = iGrid3 == null ? -1 : n6;
            string = iGrid3 == null ? "" : iGrid3.getId();
        }
        iGridList.setCurrentFocusWith(n4, n3, string2, string);
        this.setNewCursor(iGridList.getCurrentCursor());
        IGrid iGrid4 = iGrid2 == null ? null : (iGrid3 == null ? ((iGrid = iGrid2.getDetail()) == null ? iGrid2 : iGrid) : ((iGrid = iGrid3.getDetail()) == null ? iGrid3 : iGrid));
        boolean bl5 = bl2 = iGridListRow != null && iGridListRow.isArtificial();
        List list = iGrid4 == null ? (n5 == 1578836736 ? iGridList.getSpeller().getDrawerTypes() : null) : (bl2 ? null : iGrid4.getDrawerTypes());
        this.remoteHmiServiceEvo.execute(new HMIViewGridListener$UpdateDecoratorTask(this, this.remoteHmiService.getContext().getContextName(), "update-decorator", bl2 ? null : iGrid4, n4, null));
        this.logChannel.log(1078071040, "HMIViewGridListener#processItemFocusedImmediately: isArtificial = '%1', focusedGridId = '%2', drawerTypes = '%3'", bl2, (Object)(iGrid4 == null ? null : iGrid4.getId()), (Object)list);
        RightDrawerHandler rightDrawerHandler = this.remoteHmiServiceEvo.getRightDrawerHandler();
        boolean bl6 = rightDrawerHandler.updateRightDrawer(list, rangeCounter, iGrid4, iGridList);
        IGridList iGridList3 = iGridList;
        synchronized (iGridList3) {
            iGridList.setRightDrawerAvailable(bl6);
        }
        int n9 = iGridList.hasDetailGridsForNonExpandableEntries() ? 2 : 1;
        this.renderGridList(n9, false, 8);
        this.logChannel.log(1078071040, "HMIViewGridListener#processItemFocusedImmediately: updateMode '%1' and right drawer available '%2'", (Object)new Integer(n9), (Object)bl6);
    }

    private void handleMediaGridList() {
        this.logChannel.log(1078071040, "HMIViewGridListener#handleMediaGridList: called");
        HMIViewNpsListener hMIViewNpsListener = (HMIViewNpsListener)this.remoteHmiService.getViewListener(15000);
        if (hMIViewNpsListener != null) {
            this.logChannel.log(1078071040, "HMIViewGridListener#handleMediaGridList: updating nps listener");
            hMIViewNpsListener.setTitle(this.screenAccess.getSubtitleModel().getText());
        }
    }

    @Override
    public void itemFocused(int n, int n2, long l, int n3) {
        this.logChannel.log(1078071040, "HMIViewGridListener#itemFocused: callback from menu: menuItemID=%1, modelID=%2.", (long)n, (long)n2);
        this.processItemFocused(n, -1, null, true);
    }

    public void itemReleased(int n, int n2, int n3, int n4) {
    }

    @Override
    public void renderGridList(int n, int n2) {
        this.renderGridList(n, false, n2);
    }

    public void renderGridList(int n, boolean bl, int n2) {
        this.logChannel.log(-2137614336, "HMIViewGridListener#renderGridList: update: %1, decorator: %2, source: %3.", (Object)Integer.toString(n), (Object)Boolean.toString(bl), (Object)Integer.toString(n2));
        IGridList iGridList = this.screenAccess.getGridList();
        GridHelper.updateListModelTransaction(this.screenAccess.getMainListModel(), iGridList, this, n, n2, this.logChannel);
        if (bl) {
            int n3 = iGridList.getCurrentCursor().getFocus().getIndex();
            IGrid iGrid = n3 == -1 ? null : (IGrid)iGridList.get(n3);
            boolean bl2 = iGridList.getViewType() == 1;
            this.screenAccess.getDecorator().updateValues(iGrid, iGridList.getReferencePoint(), bl2);
        }
        this.remoteHmiService.flushModelGroup();
    }

    @Override
    public void onExit() {
        this.screenAccess.getDecorator().onExit();
        this.rrdCalculationHandler.exitRrd();
        this.enableSDSLineNumbers(null, this.screenAccess.getSDSLineNumberModel());
    }

    @Override
    public void keyPressedVirtualButton(int n, int n2, int n3) {
        this.logChannel.log(-2137614336, "HMIViewGridListener#keyPressedVirtualButton: keyID '%1' modelID '%2'", (long)n2, (long)n);
        if (n2 == 15) {
            ChoiceModelApp choiceModelApp = this.modelBank.getChoiceModel(-1172561152);
            if (choiceModelApp.getValue() == 1) {
                String string = "HMIViewGridListener#keyPressedVirtualButton: firing event because selection drawer should be opened instead of sending a back event to south side.";
                this.logChannel.log(1078071040, string);
                this.getVirtualButton().fireEvent(n3);
                return;
            }
            this.remoteHmiService.execute(new HMIViewGridListener$5(this, "key-pressed-virtual-button"));
        } else {
            this.logChannel.log(-2137614336, "HMIViewGridListener#keyPressedVirtualButton: key press has no effect!");
        }
    }

    @Override
    public void onApplicationExit(RemoteHMIContext remoteHMIContext) {
        IGridList iGridList;
        this.logChannel.log(1078071040, "HMIViewGridListener#onApplicationExit: %1", (Object)remoteHMIContext);
        RemoteHMIAction remoteHMIAction = new RemoteHMIAction(400);
        if (remoteHMIContext != null) {
            remoteHMIContext.setLastAction(remoteHMIAction);
            if (!"top_wizard".equals(remoteHMIContext.getContextName())) {
                remoteHMIContext.removeLastCursor();
                remoteHMIContext.removeLastPageHistory();
            }
        }
        if ((iGridList = this.screenAccess.getGridList()) != null) {
            iGridList.setEventListening(false);
        }
        this.rrdCalculationHandler.exitRrd();
        super.onApplicationExit(remoteHMIContext);
    }

    @Override
    public void itemReleased(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
    }

    @Override
    public void itemSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
        IGridListRow iGridListRow;
        this.logChannel.log(1078071040, "HMIViewGridListener#itemSelected: callback from ListController: model=%2, index=%3, row=%1.", (Object)evoListRow, (long)n, (long)n2);
        IGridListRow iGridListRow2 = iGridListRow = evoListRow instanceof IGridListRow ? (IGridListRow)((Object)evoListRow) : null;
        if (iGridListRow == null) {
            this.logChannel.log(-1601830656, "HMIViewGridListener#itemSelected: event from an unsupported sibling list of the main list received! Ignoring it.");
            return;
        }
        this.processItemSelected(n, (int)evoListRow.getUniqueID(), iGridListRow);
    }

    @Override
    public void itemLongSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
    }

    @Override
    public void itemFocused(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
        IGridListRow iGridListRow;
        this.logChannel.log(1078071040, "HMIViewGridListener#itemFocused: callback from ListController: model=%2, index=%3, row=%1.", (Object)evoListRow, (long)n, (long)n2);
        IGridListRow iGridListRow2 = iGridListRow = evoListRow instanceof IGridListRow ? (IGridListRow)((Object)evoListRow) : null;
        if (iGridListRow == null) {
            this.logChannel.log(-1601830656, "HMIViewGridListener#itemFocused: event from an unsupported sibling list of the main list received! Ignoring it.");
            return;
        }
        this.processItemFocused(n, (int)evoListRow.getUniqueID(), iGridListRow, false);
    }

    @Override
    public void requestItems(int n, int n2, String string, int n3, String string2, String string3, int n4, int n5) {
        this.remoteHmiServiceEvo.execute(new HMIViewGridListener$6(this, "infinite-list-request-items", n, n2, string2, string3, string, n3, n4, n5));
    }

    public void unrequestItems(int n, int n2, int n3, int n4) {
        this.logChannel.log(1078071040, "HMIViewGridListener#unrequestItems: callback from TiledListController: model=%1 startIndex=%2 length=%3", (long)n3, (long)n, (long)n2);
    }

    @Override
    public void updateRrdItems(List list) {
        this.logChannel.log(1078071040, "HMIViewGridListener#updateRrdItems: received list %1", (long)((Object)list).hashCode());
        this.remoteHmiServiceEvo.execute(new UpdateRrdTask(list, false, this, this.rrdCalculationHandler.isImmediateDistanceUpdate()));
        this.rrdCalculationHandler.setImmediateDistanceUpdate(false);
    }

    @Override
    public boolean isScreenTypeMain() {
        return this.screenAccess.isMainScreen();
    }

    @Override
    public void updateDeviceInfo(OSRDevice[] oSRDeviceArray) {
    }

    public void updateLayoutConstants(int n, int n2, int n3) {
        if (this.screenAccess != null) {
            this.logChannel.log(1078071040, "HMIViewGridListener#updateLayoutConstants: updating constants from GUIDE");
            this.screenAccess.updateLayoutConstants(n, n2, n3);
        } else {
            this.logChannel.log(10000, "HMIViewGridListener#updateLayoutConstants: no screen access!");
        }
    }

    @Override
    public boolean isModelGroupLockEnabled() {
        return true;
    }

    @Override
    public void updateProfileInfo(Object object) {
        if (!(object instanceof IOsrUserCacheInformation)) {
            return;
        }
        RightDrawerHandler rightDrawerHandler = this.remoteHmiServiceEvo.getRightDrawerHandler();
        rightDrawerHandler.updateProfileInfo(((IOsrUserCacheInformation)object).isAuthenticated(), rangeCounter);
    }

    public void setRrdEnabled(boolean bl) {
        this.logChannel.log(1078071040, "HMIViewGridListener#setRrdEnabled: setting RRD (Real Road Distance computation) enabled = %1", bl);
        this.rrdCalculationHandler.setRrdCalculationEnabled(bl);
        if (!bl) {
            this.rrdCalculationHandler.exitRrd();
        }
    }

    private void createAndInvokeAction(int n, IGrid iGrid, IGrid iGrid2, boolean bl) {
        Object object;
        int n2 = iGrid == null || bl ? -1 : iGrid.getXmlSourceRow();
        String string = iGrid == null ? "" : iGrid.getId();
        int n3 = iGrid2 == null ? -1 : iGrid2.getXmlSourceRow();
        String string2 = iGrid2 == null ? "" : iGrid2.getId();
        RemoteHMIAction remoteHMIAction = this.createAction(n, n2, string, n3, string2);
        Object object2 = object = iGrid2 == null ? null : iGrid2.getData();
        if (object == null) {
            Object object3 = object = iGrid == null ? null : iGrid.getData();
        }
        if (object != null) {
            remoteHMIAction.getParameters().put("actionData", object);
        }
        this.invokeAction(remoteHMIAction);
    }

    public void updateCommonDecorator(HMIProperties hMIProperties) {
        Decorator decorator = this.screenAccess.getDecorator();
        decorator.storeTypeAndDefault(hMIProperties, false);
    }

    public void spellerBandVisibilityCallback(boolean bl) {
        boolean bl2;
        this.logChannel.log(1078071040, "HMIViewGridListener#spellerBandVisibilityCallback: speller band isVisible=%1", bl);
        Decorator decorator = this.screenAccess.getDecorator();
        boolean bl3 = bl2 = bl ? decorator.hideMapDecorator() : decorator.revealMapDecorator();
        if (bl2) {
            this.remoteHmiService.flushModelGroup();
        }
    }

    @Override
    public void updateLockingState(boolean bl) {
        this.logChannel.log(1078071040, "HMIViewGridListener#updateLockingState: enabled '%1'", bl);
        this.isLockingEnabled = bl;
        if (this.screenAccess.isMainScreen()) {
            this.logChannel.log(1078071040, "HMIViewGridListener#updateLockingState: Screen is main screen, do nothing.");
            return;
        }
        if (this.screenAccess.getGridList() == null) {
            this.logChannel.log(1078071040, "HMIViewGridListener#updateLockingState: current gird list is null, do nothing.");
            return;
        }
        if (this.updateGridListLocking()) {
            this.logChannel.log(1078071040, "HMIViewGridListener#updateLockingState: GridList updated, trigger logging.");
            GridHelper.updateListModelTransaction(this.screenAccess.getMainListModel(), this.screenAccess.getGridList(), this, 3, 1, this.logChannel);
            this.renderGridList(1, false, 1);
        } else {
            this.logChannel.log(1078071040, "HMIViewGridListener#updateLockingState: GridList not changed.");
        }
    }

    private boolean updateGridListLocking() {
        HMIViewGridListener$7 hMIViewGridListener$7 = new HMIViewGridListener$7(this);
        HMIViewGridListener$8 hMIViewGridListener$8 = new HMIViewGridListener$8(this);
        boolean bl = this.isRightDrawerBlockingCoded(false);
        boolean bl2 = this.isRightDrawerBlockingCoded(true);
        boolean bl3 = !this.isLockingEnabled || !bl;
        boolean bl4 = !this.isLockingEnabled || !bl2;
        this.logChannel.log(-2137614336, "HMIViewGridListener#updateGridListLocking: enabledInfo: %1, enabledMedia: %2", (Object)Boolean.toString(bl3), (Object)Boolean.toString(bl4));
        HMIViewGridListener$9 hMIViewGridListener$9 = new HMIViewGridListener$9(this, bl4, bl3, hMIViewGridListener$8, hMIViewGridListener$7);
        int n = -1;
        if (this.screenAccess.getGridList() == null) {
            this.logChannel.log(1078071040, "HMIViewGridListener#updateGridListLocking: current gird list is null, do nothing.");
        } else {
            IGridList iGridList = this.screenAccess.getGridList();
            n = iGridList.forEachGrid(hMIViewGridListener$9, -129);
            this.screenAccess.setGridList(iGridList);
        }
        this.logChannel.log(1078071040, "HMIViewGridListener#updateGridListLocking: %1 grids modified.", (long)n);
        return n > 0;
    }

    private boolean isRightDrawerBlockingCoded(boolean bl) {
        ChoiceModelApp choiceModelApp = null;
        if (bl) {
            choiceModelApp = this.hmiService.getChoiceModel(5597);
            this.logChannel.log(-2137614336, "HMIViewGridListener#isRightDrawerBlockingCoded: Using media bit.");
        } else {
            choiceModelApp = this.hmiService.getChoiceModel(5601);
            this.logChannel.log(-2137614336, "HMIViewGridListener#isRightDrawerBlockingCoded: Using misc bit.");
        }
        boolean bl2 = false;
        if (choiceModelApp != null) {
            bl2 = choiceModelApp.getValue() == 1;
        } else {
            this.logChannel.log(10000, "HMIViewGridListener#isRightDrawerBlockingCoded: Drawer blocking bit model is null!");
        }
        this.logChannel.log(1078071040, "HMIViewGridListener#isRightDrawerBlockingCoded: blocking: %1", bl2);
        return bl2;
    }

    static /* synthetic */ LogChannel access$100(HMIViewGridListener hMIViewGridListener) {
        return hMIViewGridListener.logChannel;
    }

    static /* synthetic */ RemoteHMIServiceEvo access$200(HMIViewGridListener hMIViewGridListener) {
        return hMIViewGridListener.remoteHmiServiceEvo;
    }

    static /* synthetic */ HMIViewGridScreenAccess access$300(HMIViewGridListener hMIViewGridListener) {
        return hMIViewGridListener.screenAccess;
    }

    static /* synthetic */ RemoteHMIService access$400(HMIViewGridListener hMIViewGridListener) {
        return hMIViewGridListener.remoteHmiService;
    }

    static /* synthetic */ int access$500() {
        return LAZY_LOADING_RANGE;
    }

    static /* synthetic */ LogChannel access$600(HMIViewGridListener hMIViewGridListener) {
        return hMIViewGridListener.logChannel;
    }

    static /* synthetic */ Long access$700(HMIViewGridListener hMIViewGridListener) {
        return hMIViewGridListener.DECORATOR_DELAY;
    }

    static /* synthetic */ LogChannel access$800(HMIViewGridListener hMIViewGridListener) {
        return hMIViewGridListener.logChannel;
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    static /* synthetic */ void access$900(HMIViewGridListener hMIViewGridListener, int n, int n2, IGridListRow iGridListRow) {
        hMIViewGridListener.processItemSelectedImmediately(n, n2, iGridListRow);
    }

    static /* synthetic */ void access$1000(HMIViewGridListener hMIViewGridListener, int n, int n2, IGridListRow iGridListRow, boolean bl) {
        hMIViewGridListener.processItemFocusedImmediately(n, n2, iGridListRow, bl);
    }

    static /* synthetic */ LogChannel access$1200(HMIViewGridListener hMIViewGridListener) {
        return hMIViewGridListener.logChannel;
    }

    static /* synthetic */ LogChannel access$1300(HMIViewGridListener hMIViewGridListener) {
        return hMIViewGridListener.logChannel;
    }

    static /* synthetic */ String access$1400(HMIViewGridListener hMIViewGridListener) {
        return hMIViewGridListener.getReturnId();
    }

    static /* synthetic */ RemoteHMIAction access$1500(HMIViewGridListener hMIViewGridListener, int n, int n2, String string, String string2) {
        return hMIViewGridListener.createAction(n, n2, string, string2);
    }

    static /* synthetic */ void access$1600(HMIViewGridListener hMIViewGridListener, RemoteHMIAction remoteHMIAction) {
        hMIViewGridListener.invokeAction(remoteHMIAction);
    }

    static /* synthetic */ LogChannel access$1700(HMIViewGridListener hMIViewGridListener) {
        return hMIViewGridListener.logChannel;
    }

    static /* synthetic */ LogChannel access$1800(HMIViewGridListener hMIViewGridListener) {
        return hMIViewGridListener.logChannel;
    }

    static /* synthetic */ void access$1900(HMIViewGridListener hMIViewGridListener, RemoteHMIAction remoteHMIAction) {
        hMIViewGridListener.invokeAction(remoteHMIAction);
    }

    static /* synthetic */ LogChannel access$2000(HMIViewGridListener hMIViewGridListener) {
        return hMIViewGridListener.logChannel;
    }

    static /* synthetic */ LogChannel access$2100(HMIViewGridListener hMIViewGridListener) {
        return hMIViewGridListener.logChannel;
    }

    static /* synthetic */ LogChannel access$2200(HMIViewGridListener hMIViewGridListener) {
        return hMIViewGridListener.logChannel;
    }

    static /* synthetic */ LogChannel access$2300(HMIViewGridListener hMIViewGridListener) {
        return hMIViewGridListener.logChannel;
    }
}

