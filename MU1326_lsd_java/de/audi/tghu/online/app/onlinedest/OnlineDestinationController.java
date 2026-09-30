/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.onlinedest;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.interapp.ADBHMIAppService;
import de.audi.atip.interapp.NaviADBService;
import de.audi.atip.interapp.NaviMyAudiImport;
import de.audi.atip.interapp.NaviService;
import de.audi.atip.interapp.online.IOnlineDestinationService;
import de.audi.atip.interapp.online.IOnlineSDSMyAudiService;
import de.audi.atip.interapp.online.IOnlineSDSMyAudiServiceListener;
import de.audi.atip.log.LogChannel;
import de.audi.atip.phone.ITelService;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.CommandListManager;
import de.audi.tghu.online.app.onlinedest.OnlineDestinationHMIListener;
import de.audi.tghu.online.app.onlinedest.OnlineDestinationModelHandler;
import de.audi.tghu.online.app.onlinedest.OnlineDestinationSdsHandler;
import de.audi.tghu.online.app.onlinedest.OnlineDestinationSequence;
import de.audi.tghu.online.app.onlinedest.commands.OnlineDestinationCommandList;
import de.audi.tghu.online.app.onlinedest.commands.OnlineDestinationDefaultListener;
import de.audi.tghu.online.app.onlinedest.commands.OnlineDestinationListener;
import de.audi.tghu.online.app.onlinedest.util.OnlineDestinationAddressUtility;
import org.dsi.ifc.online.DSIDestinationImport;
import org.dsi.ifc.online.DSIDestinationImportListener;

public class OnlineDestinationController
implements IOnlineDestinationService {
    public static final int DEFAULT_POPUP_ID = -1;
    private LogChannel log;
    private OnlineDestinationModelHandler modelUpdater;
    private ADBHMIAppService adbService;
    private NaviADBService naviADBService;
    private NaviService naviService;
    private IFrameworkAccess framework;
    private ITelService telService;
    private CommandListManager cmdListMgr;
    private DSIDestinationImport dsi;
    private OnlineDestinationListener onlineDestListener;
    private OnlineDestinationSequence sequence;
    private IOnlineSDSMyAudiService sdsService;
    private IOnlineSDSMyAudiServiceListener sdsServiceListener;
    private NaviMyAudiImport naviMyAudiService;

    public OnlineDestinationController(LogChannel logChannel, IFrameworkAccess iFrameworkAccess) {
        this.framework = iFrameworkAccess;
        this.log = logChannel;
    }

    public void init() {
        this.cmdListMgr = new CommandListManager(this.getClass().getName(), this.framework, this.log, null, null);
        this.onlineDestListener = new OnlineDestinationListener(this.log, this.cmdListMgr, new OnlineDestinationDefaultListener(this.log, this));
        this.modelUpdater = new OnlineDestinationModelHandler(this.framework.getHMIService(), this.log, this);
        this.sequence = new OnlineDestinationSequence(this.log, this);
        new OnlineDestinationHMIListener(this.log, this.framework.getHMIService(), this.modelUpdater, this);
        OnlineDestinationAddressUtility.setLogChannel(this.log);
        this.sdsService = new OnlineDestinationSdsHandler(this.modelUpdater, this);
        this.cmdListMgr.start();
    }

    protected int getNewDistinationsAvailablePopupId() {
        return -1;
    }

    public CommandList createCommandList() {
        return new OnlineDestinationCommandList(this);
    }

    public DSIDestinationImportListener getDsiListener() {
        this.log.log(1000000, "OnlineDestinationController#getDsiListener()");
        return this.onlineDestListener;
    }

    public void setAdbService(ADBHMIAppService aDBHMIAppService) {
        this.log.log(1000000, "OnlineDestinationController#setAdbService()");
        this.adbService = aDBHMIAppService;
    }

    public void setNaviADBService(NaviADBService naviADBService) {
        this.log.log(1000000, "OnlineDestinationController#setNaviService()");
        this.naviADBService = naviADBService;
    }

    public OnlineDestinationModelHandler getModelHandler() {
        return this.modelUpdater;
    }

    public NaviADBService getNaviADBService() {
        return this.naviADBService;
    }

    public IFrameworkAccess getFramework() {
        return this.framework;
    }

    public void startDestinationImport() {
        if (this.naviMyAudiService != null) {
            this.naviMyAudiService.downloadStarted();
        }
        this.sequence.startDestinationImport(this.modelUpdater.getImportMode());
    }

    public void setTelephoneService(ITelService iTelService) {
        this.telService = iTelService;
    }

    public void enterOnlineDestinationHandling() {
        this.modelUpdater.setImportMode(1);
    }

    public CommandListManager getCmdListManager() {
        return this.cmdListMgr;
    }

    public DSIDestinationImport getDSI() {
        return this.dsi;
    }

    public void setDsiDestImport(Object object) {
        this.dsi = (DSIDestinationImport)object;
        this.framework.getHMIService().getChoiceModel(360).setValue(this.dsi == null ? 0 : 1);
    }

    public void setSdsServiceListener(IOnlineSDSMyAudiServiceListener iOnlineSDSMyAudiServiceListener) {
        this.sdsServiceListener = iOnlineSDSMyAudiServiceListener;
    }

    public IOnlineSDSMyAudiServiceListener getSdsServiceListener() {
        return this.sdsServiceListener;
    }

    public IOnlineSDSMyAudiService getSdsService() {
        return this.sdsService;
    }

    public void setNaviService(NaviService naviService) {
        this.naviService = naviService;
    }

    public void abortSearch() {
        this.sequence.abortSearch();
    }

    public void setNaviMyAduiService(NaviMyAudiImport naviMyAudiImport) {
        this.naviMyAudiService = naviMyAudiImport;
    }

    public NaviMyAudiImport getNaviMyAudiService() {
        return this.naviMyAudiService;
    }
}

