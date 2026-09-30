/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.poi.online;

import de.audi.atip.i18n.Language;
import de.audi.atip.interapp.INaviFormattingService;
import de.audi.atip.interapp.navigation.previewmap.IPreviewMap;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.navi.app.HomeAddressHandler;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.addressinput.poi.IPoiService;
import de.audi.tghu.navi.app.addressinput.poi.rrd.IRRDListProvider;
import de.audi.tghu.navi.app.addressinput.poi.rrd.IRRDListener;
import de.audi.tghu.navi.app.favorite.NaviFavoriteHandler;
import de.audi.tghu.navi.app.guidance.IVehicle;
import de.audi.tghu.navi.app.phone.ITelServiceController;
import de.audi.tghu.navi.app.poi.online.OnlineSDSSearchSequence;
import de.audi.tghu.navi.app.poi.online.OnlineSDSSearchSim;
import de.audi.tghu.navi.app.poi.online.OnlineSearchSequence;
import de.audi.tghu.navi.app.routeguidance.IRouteManager;
import org.dsi.ifc.online.DSIPoiOnlineSearch;
import org.dsi.ifc.online.DSIPoiOnlineSearchListener;

public abstract class OnlineSearchController {
    protected OnlineSearchSequence sequence;
    protected OnlineSDSSearchSequence sdsSequence;
    protected NavigationEnv env;
    protected final LogChannel logger;

    public OnlineSearchController(LogChannel logChannel) {
        this.logger = logChannel;
    }

    public void setDSIOnline(DSIPoiOnlineSearch dSIPoiOnlineSearch) {
        this.logger.log(10000000, "PoiOnlineSearchController#setDSIOnline()");
        if (Boolean.getBoolean("POIOnlineSim")) {
            this.logger.log(1000000, "OnlineSearchControllerEvo#setDSIOnline: Using simulation");
            dSIPoiOnlineSearch = new OnlineSDSSearchSim(this.logger, this, false);
        }
        this.sequence.getCommandListFactory().setDsiOnline(dSIPoiOnlineSearch);
        this.env.getChoiceModel(364).setValue(dSIPoiOnlineSearch == null ? 0 : 1);
        if (this.sdsSequence != null) {
            this.sdsSequence.setDSIPoiOnlineSearch(dSIPoiOnlineSearch);
        }
    }

    public DSIPoiOnlineSearchListener getDSIOnlineSearchListener() {
        this.logger.log(1000000, "PoiOnlineSearchController#getDSIOnlineSearchListener()");
        return this.sequence.getPoiListener();
    }

    public void setLanguage(Language language) {
        this.sequence.setLanguage(language);
    }

    public void resetSettings() {
    }

    public void resetMemorySettings() {
    }

    public OnlineSearchSequence getOnlineSearchSequence() {
        return this.sequence;
    }

    public abstract void init(IPreviewMap var1, IVehicle var2, ITelServiceController var3, IRouteManager var4, IRRDListener var5, NaviFavoriteHandler var6, IPoiService var7, HomeAddressHandler var8);

    public void loadState() {
    }

    public void onlineSearchExit() {
        this.logger.log(1000000, "OnlineSearchController#onlineSearchExit()");
        this.sequence.onlineSearchExit();
    }

    public abstract OnlineSDSSearchSequence getSDS();

    public void updateRgActive(boolean bl) {
    }

    public void onlinePOIMainEnter() {
        this.sequence.onlinePOIMainEnter();
    }

    public void onlinePOIMainExit() {
        this.sequence.onlinePOIMainExit();
    }

    public void testPoiOnlineSearch() {
    }

    public void triggerPoiOnlineSearchEnter() {
    }

    public void insertDummyValues() {
    }

    public void overrideCodingAndLicense() {
    }

    public IRRDListProvider getRRDListProvider() {
        return null;
    }

    public void enterDetailScreen() {
    }

    public void startLastSearchWordSearch() {
    }

    public OnlineSearchController setNaviFormattingService(INaviFormattingService iNaviFormattingService) {
        return null;
    }
}

