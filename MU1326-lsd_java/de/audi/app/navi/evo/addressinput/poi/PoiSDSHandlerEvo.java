/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.addressinput.poi;

import de.audi.app.navi.evo.addressinput.poi.PoiInputScreensSDSHandler;
import de.audi.app.navi.evo.addressinput.poi.PoiManager;
import de.audi.app.navi.evo.addressinput.poi.PoiSDSHandlerEvo$1;
import de.audi.app.navi.evo.addressinput.poi.PoiSDSHandlerEvo$2;
import de.audi.app.navi.evo.addressinput.poi.PoiSDSHandlerEvo$3;
import de.audi.app.navi.evo.addressinput.poi.PoiSDSHandlerEvo$4;
import de.audi.app.navi.evo.addressinput.poi.PoiSDSHandlerEvo$5;
import de.audi.app.navi.evo.addressinput.poi.PoiSDSHandlerEvo$6;
import de.audi.app.navi.evo.addressinput.poi.PoiSDSHandlerEvo$7;
import de.audi.app.navi.evo.addressinput.poi.PoiSDSHandlerEvo$8;
import de.audi.app.navi.evo.addressinput.poi.sds.SDSPoiScreensEvo;
import de.audi.app.navi.evo.sds.SUIListRowBuilder;
import de.audi.atip.hmi.model.list.BaseListModelApp;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.interapp.NaviService$POISDSListEntry;
import de.audi.atip.interapp.NaviServiceListener;
import de.audi.atip.interapp.SDSListEntry;
import de.audi.atip.log.LogChannel;
import de.audi.atip.metrics.Distance;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.IconHandler;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.addressinput.commands.LISPSelectListItemCommand;
import de.audi.tghu.navi.app.addressinput.poi.IPoiSDSHandler;
import de.audi.tghu.navi.app.addressinput.poi.commands.ClearPoiSubstringSearchStatusCommand;
import de.audi.tghu.navi.app.addressinput.poi.sds.IPickListModelAccess;
import de.audi.tghu.navi.app.addressinput.poi.searcharea.IPoiSearchAreaModelAccess;
import de.audi.tghu.navi.app.addressinput.poi.searcharea.PoiSearchArea;
import de.audi.tghu.navi.app.command.LIGetStateCommand;
import de.audi.tghu.navi.app.details.IDestinationHandler;
import de.audi.tghu.navi.app.details.IDetailsScreen;
import de.audi.tghu.navi.app.li.SpellerStack;
import de.audi.tghu.navi.app.li.sc.SpellerContext;
import de.audi.tghu.navi.app.routeguidance.IRouteManager;
import de.audi.tghu.navi.app.sds.NavSDSNaturalPoiConfiguration;
import de.audi.tghu.navi.app.sds.NotifySDSCommand;
import de.audi.tghu.navi.app.util.RouteUtil;
import de.audi.tghu.navi.app.util.Util;
import org.dsi.ifc.global.NavLocation;

public class PoiSDSHandlerEvo
implements IPoiSDSHandler {
    private static final int WC_POI_CATEGORY;
    private final NavigationEnv env;
    private final IconHandler iconHandler;
    private final ICommandListFactory commandListFactory;
    private final PoiSearchArea poiSearchArea;
    private final LogChannel logChannel;
    private final PoiInputScreensSDSHandler poiInputScreensSDSHandler;
    private final IDestinationHandler detailsHandler;
    private IRouteManager routeManager;
    private IPoiSearchAreaModelAccess modelAccess;
    private final IDetailsScreen detailsScreen;
    private final PoiManager poiManager;
    private final SpellerStack spellerStack;
    private final String CLASS_NAME = Util.getClassNameFromPackageName(super.getClass());

    public PoiSDSHandlerEvo(NavigationEnv navigationEnv, IconHandler iconHandler, ICommandListFactory iCommandListFactory, PoiSearchArea poiSearchArea, IDestinationHandler iDestinationHandler, IRouteManager iRouteManager, IPoiSearchAreaModelAccess iPoiSearchAreaModelAccess, PoiManager poiManager, SpellerStack spellerStack, IDetailsScreen iDetailsScreen) {
        this.env = navigationEnv;
        this.iconHandler = iconHandler;
        this.commandListFactory = iCommandListFactory;
        this.poiSearchArea = poiSearchArea;
        this.detailsHandler = iDestinationHandler;
        this.routeManager = iRouteManager;
        this.modelAccess = iPoiSearchAreaModelAccess;
        this.spellerStack = spellerStack;
        this.logChannel = navigationEnv.getSDSLogChannel();
        this.poiManager = poiManager;
        this.detailsScreen = iDetailsScreen;
        this.poiInputScreensSDSHandler = new PoiInputScreensSDSHandler(navigationEnv.getSDSLogChannel(), poiManager, iCommandListFactory);
    }

    @Override
    public SDSListEntry getPoiTopPoiListEntryDetails(int n) {
        this.logChannel.log(-2137614336, "%1#getPoiTopPoiListEntryDetails ( %2 )", (Object)this.CLASS_NAME, (long)n);
        return this.poiInputScreensSDSHandler.getPoiTopPoiListEntryDetails(n);
    }

    @Override
    public void startDestinationInput(NaviServiceListener naviServiceListener) {
        this.logChannel.log(-2137614336, "%1#startDestinationInput() --> SearchContext is %2", (Object)this.CLASS_NAME, (long)this.poiSearchArea.getSearchContext());
        this.poiInputScreensSDSHandler.startDestinationInput(naviServiceListener);
    }

    @Override
    public void startPoiSearchByName(NaviServiceListener naviServiceListener) {
        this.logChannel.log(-2137614336, "%1#startPoiSearchByName() --> SearchContext is %2", (Object)this.CLASS_NAME, (long)this.poiSearchArea.getSearchContext());
        this.poiInputScreensSDSHandler.startPoiSearchByName(naviServiceListener);
    }

    @Override
    public byte fillPOIPickList(SDSListEntry[] sDSListEntryArray) {
        if (sDSListEntryArray == null) {
            return 1;
        }
        IPickListModelAccess iPickListModelAccess = SDSPoiScreensEvo.getPickListScreenModelAccess(this.env);
        iPickListModelAccess.onStart();
        iPickListModelAccess.onUpdateResultList(sDSListEntryArray);
        return 0;
    }

    @Override
    public SDSListEntry getPOIPickListEntryDetails(int n) {
        this.logChannel.log(-2137614336, "%1#getPOIPickListEntryDetails( %2 )", (Object)this.CLASS_NAME, (long)n);
        BaseListModelApp baseListModelApp = this.env.getBaseListModel(SDSPoiScreensEvo.getPickListScreenListModel());
        EvoListRow evoListRow = baseListModelApp.getRow(n);
        String string = SDSPoiScreensEvo.getPoiPickListCategoryName(evoListRow);
        long l = SDSPoiScreensEvo.getPoiPickListCategoryId(evoListRow);
        this.logChannel.log(-2137614336, new StringBuffer().append(this.CLASS_NAME).append("#getResultListEntryDetails: name:(%1) id(%2)").toString(), (Object)string, (Object)Long.toString(l));
        return new SDSListEntry(string, l);
    }

    @Override
    public NaviService$POISDSListEntry getResultListEntryDetails(int n, int n2) {
        this.logChannel.log(-2137614336, new StringBuffer().append(this.CLASS_NAME).append("#getResultListEntryDetails ( %1, %2 )").toString(), (long)n, (long)n2);
        BaseListModelApp baseListModelApp = this.env.getBaseListModel(n2);
        EvoListRow evoListRow = baseListModelApp.getRow(n);
        return this.convertListRow2POISDSEntry(evoListRow);
    }

    private NaviService$POISDSListEntry convertListRow2POISDSEntry(EvoListRow evoListRow) {
        this.logChannel.log(-2137614336, "%1#convertListRow2POISDSEntry ( %2 )", (Object)this.CLASS_NAME, (Object)evoListRow);
        long l = evoListRow == null ? -1L : SUIListRowBuilder.getId(evoListRow);
        String string = SUIListRowBuilder.getName(evoListRow);
        Distance distance = SUIListRowBuilder.getDistance(evoListRow);
        this.logChannel.log(-2137614336, "%1#convertListRow2POISDSEntry: name:(%2) id(%3)", (Object)this.CLASS_NAME, (Object)string, l);
        return new NaviService$POISDSListEntry(string, l, distance);
    }

    private NaviService$POISDSListEntry[] convertToPOISDSListEntries(BaseListModelApp baseListModelApp) {
        this.logChannel.log(-2137614336, "%1#convertToPOISDSListEntries", (Object)this.CLASS_NAME);
        if (baseListModelApp == null) {
            return new NaviService$POISDSListEntry[0];
        }
        int n = baseListModelApp.getLength();
        NaviService$POISDSListEntry[] naviService$POISDSListEntryArray = new NaviService$POISDSListEntry[n];
        for (int i2 = 0; i2 < n; ++i2) {
            naviService$POISDSListEntryArray[i2] = this.convertListRow2POISDSEntry(baseListModelApp.getRow(i2));
        }
        this.logChannel.log(-2137614336, "%1#convertToPOISDSListEntries: %2 entries", (Object)this.CLASS_NAME, (long)naviService$POISDSListEntryArray.length);
        return naviService$POISDSListEntryArray;
    }

    @Override
    public void selectPOI(int n, NaviServiceListener naviServiceListener) {
        this.logChannel.log(-2137614336, "%1#selectPOI( %2 )", (Object)this.CLASS_NAME, (long)n);
        this.doSelectPOI(n, this.getPoiSelectOnSuccessCommand(naviServiceListener), this.getPoiSelectOnFailureCommand(naviServiceListener));
    }

    @Override
    public NaviService$POISDSListEntry getPOIEntryDetails(int n, byte by) {
        this.logChannel.log(-2137614336, new StringBuffer().append(this.CLASS_NAME).append("#getPOIEntryDetails ( %1, %2 )").toString(), (long)n, (long)by);
        switch (by) {
            case 0: {
                SDSListEntry sDSListEntry = this.getPoiTopPoiListEntryDetails(n);
                return sDSListEntry == null ? new NaviService$POISDSListEntry() : new NaviService$POISDSListEntry(sDSListEntry.getName(), sDSListEntry.getId());
            }
            case 1: {
                SDSListEntry sDSListEntry = this.getPOIPickListEntryDetails(n);
                return sDSListEntry == null ? new NaviService$POISDSListEntry() : new NaviService$POISDSListEntry(sDSListEntry.getName(), sDSListEntry.getId());
            }
            case 2: {
                return this.getResultListEntryDetails(n, SDSPoiScreensEvo.getPOIResultScreenListModel());
            }
            case 3: {
                return this.getResultListEntryDetails(n, SDSPoiScreensEvo.getNaviResultScreenListModel());
            }
        }
        return new NaviService$POISDSListEntry();
    }

    @Override
    public void selectPOIbyListIndex(int n, NaviServiceListener naviServiceListener) {
        this.logChannel.log(-2137614336, "%1#selectPOIbyListIndex: index:(%2)", (Object)this.CLASS_NAME, (long)n);
        BaseListModelApp baseListModelApp = this.env.getBaseListModel(SDSPoiScreensEvo.getPOIResultScreenListModel());
        EvoListRow evoListRow = baseListModelApp.getRow(n);
        long l = SUIListRowBuilder.getId(evoListRow);
        String string = SUIListRowBuilder.getName(evoListRow);
        this.logChannel.log(-2137614336, new StringBuffer().append(this.CLASS_NAME).append("#selectPOIbyListIndex: name:(%1) id(%2)").toString(), (Object)string, (Object)Long.toString(l));
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new LIGetStateCommand(this.spellerStack, new SpellerContext(111)));
        commandList.add(new LISPSelectListItemCommand(n));
        commandList.add(new PoiSDSHandlerEvo$1(this, "Update Detail Screen"));
        commandList.add(new PoiSDSHandlerEvo$2(this, naviServiceListener));
        commandList.setErrorCommand(new PoiSDSHandlerEvo$3(this, naviServiceListener));
        commandList.execute(new StringBuffer().append(this.CLASS_NAME).append("#selectPOIbyListIndex()").toString());
    }

    @Override
    public void selectTopPOI(int n, NaviServiceListener naviServiceListener) {
        this.logChannel.log(-2137614336, "%1#selectTopPOI( %2 )", (Object)this.CLASS_NAME, (long)n);
        this.doSelectTopPOI(n, this.getTopPoiSelectOnSuccessCommand(naviServiceListener), this.getTopPoiSelectOnFailureCommand(naviServiceListener));
    }

    private int translateSDSCategoryToNaviCategory(int n) {
        return new NavSDSNaturalPoiConfiguration().getTranslatedCategoryForNaturalPoi(n, this.env);
    }

    @Override
    public byte setPOISearchArea(byte by) {
        this.logChannel.log(-2137614336, "%1#setPOISearchArea( %2 )", (Object)this.CLASS_NAME, (long)by);
        byte by2 = 0;
        NavLocation navLocation = this.env.getContainer().getLiCurrentLD();
        switch (by) {
            case 1: {
                this.poiSearchArea.setSearchContext(0);
                break;
            }
            case 2: {
                navLocation = RouteUtil.getFinalDestination(this.routeManager.getRoute());
                if (navLocation != null) {
                    this.poiSearchArea.setSearchContext(2);
                    this.poiSearchArea.setLocation(navLocation);
                    this.startUpdateSearchLocationSequence(navLocation);
                    break;
                }
                this.logChannel.log(10000, "%1#setPOISearchArea() - final destination not set!", (Object)this.CLASS_NAME);
                by2 = 1;
                break;
            }
            case 3: {
                if (this.env.getContainer().isRgActive()) {
                    this.poiSearchArea.setSearchContext(1);
                    break;
                }
                this.logChannel.log(10000, "%1#setPOISearchArea() - no active route guidance!", (Object)this.CLASS_NAME);
                by2 = 1;
                break;
            }
            case 5: {
                this.poiSearchArea.setSearchContext(5);
                this.poiSearchArea.setLocation(navLocation);
                this.startUpdateSearchLocationSequence(navLocation);
                break;
            }
            case 4: {
                this.poiSearchArea.setSearchContext(4);
                this.poiSearchArea.setLocation(navLocation);
                this.startUpdateSearchLocationSequence(navLocation);
                break;
            }
            case 6: {
                navLocation = RouteUtil.getFirstDestination(this.routeManager.getRoute());
                this.poiSearchArea.setSearchContext(3);
                this.poiSearchArea.setLocation(navLocation);
                this.startUpdateSearchLocationSequence(navLocation);
                break;
            }
            default: {
                this.logChannel.log(10000, "%1#setPOISearchArea() - unknown area type %2 !", (Object)this.CLASS_NAME, (long)by);
                by2 = 1;
            }
        }
        if (by2 == 0) {
            int n = this.poiSearchArea.getSearchContext();
            this.modelAccess.onUpdateSearchArea(this.poiSearchArea);
            if (this.poiSearchArea.getSearchContext() != n) {
                by2 = 1;
            }
        }
        return by2;
    }

    @Override
    public void selectNaturalPoi(int n, NaviServiceListener naviServiceListener) {
        NotifySDSCommand notifySDSCommand = this.getTopPoiSelectOnSuccessCommand(naviServiceListener);
        NotifySDSCommand notifySDSCommand2 = this.getTopPoiSelectOnFailureCommand(naviServiceListener);
        if (!Util.isHURegionAsia() && n == 4) {
            this.doSelectPOI(19, notifySDSCommand, notifySDSCommand2);
        } else {
            this.doSelectTopPOI(n, notifySDSCommand, notifySDSCommand2);
        }
    }

    private void doSelectPOI(int n, NotifySDSCommand notifySDSCommand, NotifySDSCommand notifySDSCommand2) {
        this.logChannel.log(-2137614336, "%1#doSelectPOI( %2 )", (Object)this.CLASS_NAME, (long)n);
        CommandList commandList = this.commandListFactory.createCommandList();
        if (Util.isHURegionAsia()) {
            commandList.add(new ClearPoiSubstringSearchStatusCommand());
        }
        commandList.put("selected poi UID", new Integer(n));
        this.poiManager.handlePoiSelectionEvent(commandList, 1503);
        commandList.add(notifySDSCommand);
        commandList.setErrorCommand(notifySDSCommand2);
        commandList.execute(new StringBuffer().append(this.CLASS_NAME).append("#doSelectPOI()").toString());
    }

    private void doSelectTopPOI(int n, NotifySDSCommand notifySDSCommand, NotifySDSCommand notifySDSCommand2) {
        this.logChannel.log(-2137614336, "%1#doSelectTopPOI( %2 )", (Object)this.CLASS_NAME, (long)n);
        int n2 = this.translateSDSCategoryToNaviCategory(n);
        if (n2 == -1) {
            this.logChannel.log(-1601830656, "%1#doSelectTopPOI Category %2 is not supported", (Object)this.CLASS_NAME, (long)n);
            notifySDSCommand2.call();
            return;
        }
        CommandList commandList = this.commandListFactory.createCommandList();
        if (Util.isHURegionAsia()) {
            commandList.add(new ClearPoiSubstringSearchStatusCommand());
        }
        commandList.put("selected poi UID", new Integer(n2));
        this.poiManager.handlePoiSelectionEvent(commandList, 1502);
        commandList.add(notifySDSCommand);
        commandList.setErrorCommand(notifySDSCommand2);
        commandList.execute(new StringBuffer().append(this.CLASS_NAME).append("#doSelectTopPOI()").toString());
    }

    private NotifySDSCommand getPoiSelectOnSuccessCommand(NaviServiceListener naviServiceListener) {
        return new PoiSDSHandlerEvo$4(this, naviServiceListener, "Select POI Success Command");
    }

    private NotifySDSCommand getPoiSelectOnFailureCommand(NaviServiceListener naviServiceListener) {
        return new PoiSDSHandlerEvo$5(this, naviServiceListener, "Select POI Failure Command");
    }

    private NotifySDSCommand getTopPoiSelectOnSuccessCommand(NaviServiceListener naviServiceListener) {
        return new PoiSDSHandlerEvo$6(this, naviServiceListener, "Select TOP POI Success Command");
    }

    private NotifySDSCommand getTopPoiSelectOnFailureCommand(NaviServiceListener naviServiceListener) {
        return new PoiSDSHandlerEvo$7(this, naviServiceListener, "Select TOP POI Failure Command");
    }

    @Override
    public void triggerPOIReturn(NaviServiceListener naviServiceListener) {
        this.poiManager.destPOIHKReturn(0, 0);
    }

    private void startUpdateSearchLocationSequence(NavLocation navLocation) {
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new PoiSDSHandlerEvo$8(this, "Update search area with listeners", navLocation));
        commandList.execute(new StringBuffer().append(this.CLASS_NAME).append("#startUpdateSearchLocationSequence").toString());
    }

    @Override
    public NavLocation getPoiSearchAreaLocation() {
        return this.poiSearchArea.getLocation();
    }

    static /* synthetic */ IconHandler access$000(PoiSDSHandlerEvo poiSDSHandlerEvo) {
        return poiSDSHandlerEvo.iconHandler;
    }

    static /* synthetic */ IDestinationHandler access$100(PoiSDSHandlerEvo poiSDSHandlerEvo) {
        return poiSDSHandlerEvo.detailsHandler;
    }

    static /* synthetic */ IDetailsScreen access$200(PoiSDSHandlerEvo poiSDSHandlerEvo) {
        return poiSDSHandlerEvo.detailsScreen;
    }

    static /* synthetic */ NavigationEnv access$300(PoiSDSHandlerEvo poiSDSHandlerEvo) {
        return poiSDSHandlerEvo.env;
    }

    static /* synthetic */ NaviService$POISDSListEntry[] access$400(PoiSDSHandlerEvo poiSDSHandlerEvo, BaseListModelApp baseListModelApp) {
        return poiSDSHandlerEvo.convertToPOISDSListEntries(baseListModelApp);
    }
}

