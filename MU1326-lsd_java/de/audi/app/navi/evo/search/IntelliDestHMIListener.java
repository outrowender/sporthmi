/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.search;

import de.audi.app.navi.evo.poi.online.OnlineSearchControllerEvo;
import de.audi.app.navi.evo.search.ActiveDestinationsManager;
import de.audi.app.navi.evo.search.IntelliDestController;
import de.audi.app.navi.evo.search.IntelliDestGuiSearchHandler;
import de.audi.app.navi.evo.search.IntelliDestHMIListener$1;
import de.audi.app.navi.evo.search.IntelliDestHMIListener$MyButtonListener;
import de.audi.app.navi.evo.search.IntelliDestHMIListener$MyOptionModelListener;
import de.audi.atip.hmi.model.list.BaseListModelApp;
import de.audi.atip.hmi.model.menu.MenuModelApp;
import de.audi.atip.hmi.model.menu.MenuModelListener;
import de.audi.atip.hmi.modelaccess.SpellerModelApp;
import de.audi.atip.log.LogChannel;
import de.audi.atip.phone.ITelService;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.HomeAddressHandler;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.addressinput.poi.IPoiService;
import de.audi.tghu.navi.app.search.ICountrySelection;
import de.audi.tghu.navi.app.util.Util;
import de.esolutions.fw.util.commons.job.DispatcherBase;

public class IntelliDestHMIListener
implements MenuModelListener {
    private final String CLASS_NAME = Util.getClassNameFromPackageName(super.getClass());
    private final NavigationEnv env;
    private final LogChannel lc;
    private final IntelliDestGuiSearchHandler guiSearchHandler;
    private final OnlineSearchControllerEvo onlineController;
    private final ActiveDestinationsManager activeDestinationsManager;
    private final IntelliDestController searchController;
    private MenuModelApp menuModel;
    private final SpellerModelApp searchSpeller;
    private final BaseListModelApp intelliDestResultList;
    private final DispatcherBase dispatcher;
    private final ITelService telService;
    private final ICommandListFactory commandListFactory;
    private final HomeAddressHandler homeAddressHandler;
    private final ICountrySelection countrySelection;
    private IPoiService poiService;
    protected static final int SPELLER_OPENED;
    protected static final int SPELLER_CLOSED;

    public IntelliDestHMIListener(NavigationEnv navigationEnv, IntelliDestGuiSearchHandler intelliDestGuiSearchHandler, OnlineSearchControllerEvo onlineSearchControllerEvo, ActiveDestinationsManager activeDestinationsManager, IntelliDestController intelliDestController, DispatcherBase dispatcherBase, ITelService iTelService, ICommandListFactory iCommandListFactory, HomeAddressHandler homeAddressHandler, ICountrySelection iCountrySelection, IPoiService iPoiService) {
        this.env = navigationEnv;
        this.guiSearchHandler = intelliDestGuiSearchHandler;
        this.onlineController = onlineSearchControllerEvo;
        this.activeDestinationsManager = activeDestinationsManager;
        this.searchController = intelliDestController;
        this.dispatcher = dispatcherBase;
        this.homeAddressHandler = homeAddressHandler;
        this.countrySelection = iCountrySelection;
        this.poiService = iPoiService;
        this.lc = navigationEnv.getLogChannel("App.Navi.Search");
        this.searchSpeller = Util.isHURegionKR() ? navigationEnv.getSpellerModel(-886897152) : navigationEnv.getSpellerModel(-2094791168);
        this.intelliDestResultList = navigationEnv.getBaseListModel(-1541470720);
        this.telService = iTelService;
        this.commandListFactory = iCommandListFactory;
        this.initListener();
    }

    private final void initListener() {
        IntelliDestHMIListener$MyOptionModelListener intelliDestHMIListener$MyOptionModelListener = new IntelliDestHMIListener$MyOptionModelListener(this, null);
        this.env.getHMIService().getOptionModel(1948124672).setListener(intelliDestHMIListener$MyOptionModelListener, this.intelliDestResultList.getID());
        this.env.getHMIService().getOptionModel(1948124672).setListener(intelliDestHMIListener$MyOptionModelListener, 1595803136);
        this.env.getHMIService().getOptionModel(1948124672).setListener(intelliDestHMIListener$MyOptionModelListener, 0x200600);
        this.env.getHMIService().getOptionModel(-467728896).setListener(intelliDestHMIListener$MyOptionModelListener, this.intelliDestResultList.getID());
        this.env.getHMIService().getOptionModel(-467728896).setListener(intelliDestHMIListener$MyOptionModelListener, 1595803136);
        this.env.getHMIService().getOptionModel(1176634880).setListener(intelliDestHMIListener$MyOptionModelListener, this.intelliDestResultList.getID());
        this.env.getHMIService().getOptionModel(1176634880).setListener(intelliDestHMIListener$MyOptionModelListener, 1595803136);
        this.env.getHMIService().getOptionModel(1176503808).setListener(intelliDestHMIListener$MyOptionModelListener, this.intelliDestResultList.getID());
        this.env.getHMIService().getOptionModel(1176503808).setListener(intelliDestHMIListener$MyOptionModelListener, 1595803136);
        this.env.getHMIService().getOptionModel(1964901888).setListener(intelliDestHMIListener$MyOptionModelListener, this.intelliDestResultList.getID());
        this.env.getHMIService().getOptionModel(1964901888).setListener(intelliDestHMIListener$MyOptionModelListener, 1595803136);
        this.env.getHMIService().getOptionModel(-1826748928).setListener(intelliDestHMIListener$MyOptionModelListener, this.intelliDestResultList.getID());
        this.env.getHMIService().getOptionModel(-1826748928).setListener(intelliDestHMIListener$MyOptionModelListener, 1595803136);
        this.env.getHMIService().getOptionModel(1293944320).setListener(intelliDestHMIListener$MyOptionModelListener, this.intelliDestResultList.getID());
        this.env.getHMIService().getOptionModel(1293944320).setListener(intelliDestHMIListener$MyOptionModelListener, 1595803136);
        this.env.getHMIService().getOptionModel(-2061629952).setListener(intelliDestHMIListener$MyOptionModelListener, this.intelliDestResultList.getID());
        this.env.getHMIService().getOptionModel(-702544384).setListener(intelliDestHMIListener$MyOptionModelListener, this.intelliDestResultList.getID());
        this.env.getHMIService().getOptionModel(1830684160).setListener(intelliDestHMIListener$MyOptionModelListener, this.intelliDestResultList.getID());
        IntelliDestHMIListener$MyButtonListener intelliDestHMIListener$MyButtonListener = new IntelliDestHMIListener$MyButtonListener(this, null);
        this.env.getButtonModel(1210058240).setButtonListener(intelliDestHMIListener$MyButtonListener);
        this.env.getButtonModel(1226835456).setButtonListener(intelliDestHMIListener$MyButtonListener);
        this.env.getButtonModel(-2044852736).setButtonListener(intelliDestHMIListener$MyButtonListener);
        this.env.getButtonModel(1629357568).setButtonListener(intelliDestHMIListener$MyButtonListener);
        this.env.getButtonModel(-1423964672).setButtonListener(intelliDestHMIListener$MyButtonListener);
        this.env.getButtonModel(1528890880).setButtonListener(intelliDestHMIListener$MyButtonListener);
        this.menuModel = this.env.getMenuModel(1629423104);
        this.menuModel.setListener(this);
        this.env.getMenuModel(186713600).setListener(this);
        this.env.getMenuModel(203490816).setListener(this);
        this.env.getMenuModel(-534837760).setListener(this);
        this.env.getMenuModel(773981696).setListener(this);
        this.env.getMenuModel(220268032).setListener(this);
        this.env.getMenuModel(723650048).setListener(this);
    }

    public void deinit() {
        this.env.getHMIService().getOptionModel(1948124672).resetListener();
        this.env.getHMIService().getOptionModel(-467728896).resetListener();
        this.env.getHMIService().getOptionModel(1176634880).resetListener();
        this.env.getHMIService().getOptionModel(1176503808).resetListener();
        this.env.getHMIService().getOptionModel(1964901888).resetListener();
        this.env.getHMIService().getOptionModel(1293944320).resetListener();
        this.env.getHMIService().getOptionModel(-2061629952).resetListener();
        this.env.getHMIService().getOptionModel(-702544384).resetListener();
        this.env.getHMIService().getOptionModel(1830684160).resetListener();
        this.env.getButtonModel(1210058240).resetListener();
        this.env.getButtonModel(1226835456).resetListener();
        this.env.getButtonModel(-2044852736).resetListener();
        this.env.getButtonModel(1629357568).resetListener();
        this.env.getButtonModel(-1423964672).resetListener();
        this.env.getButtonModel(1528890880).resetListener();
        this.env.getMenuModel(1629423104).resetListener();
        this.env.getMenuModel(186713600).resetListener();
        this.env.getMenuModel(203490816).resetListener();
        this.env.getMenuModel(-534837760).resetListener();
        this.env.getMenuModel(773981696).resetListener();
        this.env.getMenuModel(220268032).resetListener();
        this.env.getMenuModel(723650048).resetListener();
    }

    @Override
    public void itemFocused(int n, int n2, long l, int n3) {
        this.lc.log(-2137614336, new StringBuffer().append(this.CLASS_NAME).append("#itemFocused menuItemID: %1 model: %2 terminal: %3").toString(), (long)n, (long)n2, (long)n3);
        this.dispatcher.execute(new IntelliDestHMIListener$1(this, n, l));
    }

    static /* synthetic */ String access$200(IntelliDestHMIListener intelliDestHMIListener) {
        return intelliDestHMIListener.CLASS_NAME;
    }

    static /* synthetic */ LogChannel access$300(IntelliDestHMIListener intelliDestHMIListener) {
        return intelliDestHMIListener.lc;
    }

    static /* synthetic */ BaseListModelApp access$400(IntelliDestHMIListener intelliDestHMIListener) {
        return intelliDestHMIListener.intelliDestResultList;
    }

    static /* synthetic */ IntelliDestGuiSearchHandler access$500(IntelliDestHMIListener intelliDestHMIListener) {
        return intelliDestHMIListener.guiSearchHandler;
    }

    static /* synthetic */ ActiveDestinationsManager access$600(IntelliDestHMIListener intelliDestHMIListener) {
        return intelliDestHMIListener.activeDestinationsManager;
    }

    static /* synthetic */ NavigationEnv access$700(IntelliDestHMIListener intelliDestHMIListener) {
        return intelliDestHMIListener.env;
    }

    static /* synthetic */ IPoiService access$800(IntelliDestHMIListener intelliDestHMIListener) {
        return intelliDestHMIListener.poiService;
    }

    static /* synthetic */ IntelliDestController access$900(IntelliDestHMIListener intelliDestHMIListener) {
        return intelliDestHMIListener.searchController;
    }

    static /* synthetic */ ICommandListFactory access$1000(IntelliDestHMIListener intelliDestHMIListener) {
        return intelliDestHMIListener.commandListFactory;
    }

    static /* synthetic */ ITelService access$1100(IntelliDestHMIListener intelliDestHMIListener) {
        return intelliDestHMIListener.telService;
    }

    static /* synthetic */ SpellerModelApp access$1200(IntelliDestHMIListener intelliDestHMIListener) {
        return intelliDestHMIListener.searchSpeller;
    }

    static /* synthetic */ OnlineSearchControllerEvo access$1300(IntelliDestHMIListener intelliDestHMIListener) {
        return intelliDestHMIListener.onlineController;
    }

    static /* synthetic */ MenuModelApp access$1400(IntelliDestHMIListener intelliDestHMIListener) {
        return intelliDestHMIListener.menuModel;
    }

    static /* synthetic */ ICountrySelection access$1500(IntelliDestHMIListener intelliDestHMIListener) {
        return intelliDestHMIListener.countrySelection;
    }

    static /* synthetic */ HomeAddressHandler access$1600(IntelliDestHMIListener intelliDestHMIListener) {
        return intelliDestHMIListener.homeAddressHandler;
    }
}

