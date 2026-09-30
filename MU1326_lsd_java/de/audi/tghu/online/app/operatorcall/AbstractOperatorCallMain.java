/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.operatorcall;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.i18n.I18NTarget;
import de.audi.atip.i18n.Language;
import de.audi.atip.interapp.INaviFormattingService;
import de.audi.atip.interapp.NaviService;
import de.audi.atip.interapp.navigation.previewmap.IPreviewMap;
import de.audi.atip.interapp.online.IOperatorCallNaviService;
import de.audi.atip.interapp.online.IOperatorCallSDSService;
import de.audi.atip.interapp.online.IOperatorCallSDSServiceListener;
import de.audi.atip.interapp.online.OnlinePOICall;
import de.audi.atip.interapp.terminalmode.ITerminalModeUpdateListener;
import de.audi.atip.log.LogChannel;
import de.audi.atip.phone.ITelService;
import de.audi.tghu.command.Command;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.online.app.JokerKeyHandler;
import de.audi.tghu.online.app.Online;
import de.audi.tghu.online.app.OnlineEnv;
import de.audi.tghu.online.app.operatorcall.abstractclasses.AbstractCommand;
import de.audi.tghu.online.app.operatorcall.abstractclasses.AbstractOperatorCall;
import de.audi.tghu.online.app.operatorcall.commands.OperatorCallCommandList;
import de.audi.tghu.online.app.operatorcall.commands.OperatorCallCommandListManager;
import de.audi.tghu.online.app.operatorcall.handler.AbstractOperatorCallHandler;
import de.audi.tghu.online.app.operatorcall.handler.DSIHandler;
import de.audi.tghu.online.app.operatorcall.handler.NavigationHandler;
import de.audi.tghu.online.app.operatorcall.handler.OperatorCallFactorySettingController;
import de.audi.tghu.online.app.operatorcall.handler.SDSHandler;
import de.audi.tghu.online.app.operatorcall.handler.TelephoneHandler;
import de.audi.tghu.online.app.operatorcall.handler.TerminalModeHandler;
import de.audi.tghu.online.app.operatorcall.handler.TestHandler;
import de.audi.tghu.online.app.operatorcall.miniapps.GeneralMiniAppHandler;
import de.audi.tghu.online.app.operatorcall.truffle.IntelliDestOperatorCallDataProvider;
import de.audi.tghu.online.app.remotehmi.AbstractExternalServiceProvider;
import de.audi.tghu.online.app.remotehmi.RemoteHMIService;
import java.util.List;
import org.dsi.ifc.online.DSIOperatorCall;
import org.osgi.framework.BundleContext;

public abstract class AbstractOperatorCallMain
implements I18NTarget {
    protected AbstractOperatorCallHandler operatorCallHandler;
    protected DSIHandler dsiHandler;
    protected NavigationHandler naviHandler;
    protected TelephoneHandler telHandler;
    protected final LogChannel logChannel = Online.getInstance().getOperatorCallLogChannel();
    protected OperatorCallCommandListManager cmdListManager;
    protected SDSHandler sdsHandler;
    protected GeneralMiniAppHandler miniAppHandler;
    private OperatorCallFactorySettingController factorySettings;
    protected JokerKeyHandler jokerKeyHandler;
    protected IntelliDestOperatorCallDataProvider intelliDestOperatorCallDataProvider;
    private TerminalModeHandler terminalModeHandler;
    protected OnlinePOICall onlineOperatorCallService;
    protected RemoteHMIService remoteHMIService;

    protected abstract AbstractOperatorCallHandler createOperatorCallHandler(IFrameworkAccess var1, RemoteHMIService var2);

    public AbstractOperatorCallMain(IFrameworkAccess iFrameworkAccess, RemoteHMIService remoteHMIService, OnlineEnv onlineEnv, BundleContext bundleContext, boolean bl, boolean bl2) {
        this.logChannel.log(1000000, "=======================OperatorCall=======================");
        this.dsiHandler = new DSIHandler(this);
        this.naviHandler = new NavigationHandler(iFrameworkAccess.getHMIService().getChoiceModel(4415), this);
        this.telHandler = new TelephoneHandler();
        this.cmdListManager = new OperatorCallCommandListManager("OperatorCall", iFrameworkAccess, this.dsiHandler, this.telHandler, "zh_CN");
        this.intelliDestOperatorCallDataProvider = new IntelliDestOperatorCallDataProvider(iFrameworkAccess, bundleContext, 15);
        this.intelliDestOperatorCallDataProvider.start();
        this.operatorCallHandler = this.createOperatorCallHandler(iFrameworkAccess, remoteHMIService);
        this.sdsHandler = new SDSHandler(this);
        this.factorySettings = new OperatorCallFactorySettingController(this.operatorCallHandler, bl, bl2);
        this.operatorCallHandler.getDataFromPersistence(bl, bl2);
        this.terminalModeHandler = new TerminalModeHandler(this, iFrameworkAccess.getHMIService());
    }

    public void setDSI(DSIOperatorCall dSIOperatorCall) {
        this.logChannel.log(1000000, "AbstractOperatorCallMain#setDSI called!");
        this.dsiHandler.setDSI(dSIOperatorCall);
        this.enableDisableOperatorCall();
    }

    private void enableDisableOperatorCall() {
        this.operatorCallHandler.enableServices(this.dsiHandler.isDSIAvailable(), this.naviHandler.isNaviServiceAvailable(), this.telHandler.isTelServiceAvailable(), this.terminalModeHandler.isTerminalModeActive());
    }

    public DSIHandler getDSIHandler() {
        return this.dsiHandler;
    }

    public NavigationHandler getNaviHandler() {
        return this.naviHandler;
    }

    public TelephoneHandler getTelHandler() {
        return this.telHandler;
    }

    public void setNaviService(NaviService naviService) {
        this.logChannel.log(1000000, "AbstractOperatorCallMain#setNaviService called!");
        this.naviHandler.setNaviService(naviService);
        this.enableDisableOperatorCall();
    }

    public void setTelService(ITelService iTelService) {
        this.logChannel.log(1000000, "AbstractOperatorCallMain#setTelService called!");
        this.telHandler.setTelService(iTelService);
        this.enableDisableOperatorCall();
    }

    public Object getDsiListener() {
        return this.dsiHandler;
    }

    public boolean isFetchingPois() {
        AbstractCommand abstractCommand;
        OperatorCallCommandList operatorCallCommandList = (OperatorCallCommandList)this.cmdListManager.getActiveCommandList();
        if (operatorCallCommandList != null && (abstractCommand = (AbstractCommand)operatorCallCommandList.getActiveCommand()) != null) {
            return "DownloadPOI".equalsIgnoreCase(abstractCommand.getName());
        }
        return false;
    }

    public boolean isCallRunning() {
        this.logChannel.log(1000000, "AbstractOperatorCallMain#isCallRunning: entered");
        if (this.cmdListManager != null) {
            CommandList commandList = this.cmdListManager.getActiveCommandList();
            if (commandList != null) {
                OperatorCallCommandList operatorCallCommandList = (OperatorCallCommandList)commandList;
                Command command = operatorCallCommandList.getActiveCommand();
                if (command != null) {
                    AbstractCommand abstractCommand = (AbstractCommand)command;
                    if ("DownloadNumber".equalsIgnoreCase(abstractCommand.getName()) || "Calling".equalsIgnoreCase(abstractCommand.getName())) {
                        this.logChannel.log(10000000, "AbstractOperatorCallMain#isCallRunning: return true.");
                        return true;
                    }
                } else {
                    this.logChannel.log(10000000, "AbstractOperatorCallMain#isCallRunning: no active command available.");
                }
            } else {
                this.logChannel.log(10000000, "AbstractOperatorCallMain#isCallRunning: no active commandList available.");
            }
        } else {
            this.logChannel.log(100000, "AbstractOperatorCallMain#isCallRunning: no cmdListManager available!");
        }
        this.logChannel.log(10000000, "AbstractOperatorCallMain#isCallRunning: return false.");
        return false;
    }

    public OperatorCallCommandListManager getCommandListManager() {
        return this.cmdListManager;
    }

    public void enterService(int n) {
        this.logChannel.log(1000000, "AbstractOperatorCallMain#enterService: serviceName = %1", (Object)this.operatorCallHandler.getServiceTypeName(n));
        this.operatorCallHandler.setCurrentServiceType(n);
        this.operatorCallHandler.setOption(false);
        this.naviHandler.setEnterMode(0);
    }

    public void enterServiceByOtherContext(int n) {
        this.logChannel.log(1000000, "AbstractOperatorCallMain#enterServiceByOtherContext: serviceName = %1", (Object)this.operatorCallHandler.getServiceTypeName(n));
        this.operatorCallHandler.setCurrentServiceType(n);
        this.operatorCallHandler.setOption(true);
    }

    public void leaveService(int n) {
        this.logChannel.log(1000000, "AbstractOperatorCallMain#leaveService(%1)", (Object)this.operatorCallHandler.getServiceTypeName(n));
        this.operatorCallHandler.setWelcomeScreen(n, true);
        this.operatorCallHandler.leaveJokerKeyMode(n);
        this.operatorCallHandler.deleteCurrentServiceType();
        this.operatorCallHandler.setOption(false);
    }

    public void log(int n, String string, int n2) {
        this.logChannel.log(n, string, (long)n2);
    }

    public void setDownloadPoisRunning(boolean bl) {
        this.logChannel.log(1000000, "AbstractOperatorCallMain#setDownloadPoisRunning: isDownloadRunning = %1", bl);
        this.operatorCallHandler.setDownloadPoisRunning(bl);
    }

    public void setLanguage(Language language) {
    }

    public SDSHandler getSdsHandler() {
        return this.sdsHandler;
    }

    public void testSDS(IOperatorCallSDSService iOperatorCallSDSService) {
        this.logChannel.log(1000000, "AbstractOperatorCallMain#testSDS!");
        TestHandler.setSDSHandler(iOperatorCallSDSService, new IOperatorCallSDSServiceListener(){

            public void startCallcenterCallBySDSResult(int n) {
                AbstractOperatorCallMain.this.logChannel.log(1000000, "AbstractOperatorCallMain#testSDS#startCallcenterCallBySDSResult: result = %1", (long)n);
            }
        });
    }

    public AbstractOperatorCall getOperatorCall(int n) {
        return this.operatorCallHandler.getOperatorCall(n);
    }

    public void setPreviewMapService(IPreviewMap iPreviewMap) {
        this.naviHandler.setPreviewMap(iPreviewMap);
    }

    public boolean isAnotherOperatorCallRunning(int n) {
        return this.operatorCallHandler.isAnotherOperatorCallRunning(n);
    }

    public void startOperatorCallByJokerKey(int n, int n2, int n3, int n4) {
        this.logChannel.log(1000000, "AbstractOperatorCallMain#startOperatorCallByJokerKey with serviceType = %1 started!", (long)n);
        this.operatorCallHandler.startOperatorCallByJokerKey(n, n2, n3, n4);
    }

    public void checksSuccessful(int n) {
        this.operatorCallHandler.checksSuccessful(n);
    }

    public void testNaviService(IOperatorCallNaviService iOperatorCallNaviService) {
        this.logChannel.log(1000000, "AbstractOperatorCallMain#testNaviService called");
        if (iOperatorCallNaviService == null) {
            this.logChannel.log(100000, "AbstractOperatorCallMain#testNaviService: service is null!");
        } else {
            this.logChannel.log(10000000, "AbstractOperatorCallMain#testNaviService: service is not null!");
        }
    }

    public void operatorCallCenterLeft() {
        this.logChannel.log(1000000, "AbstractOperatorCallMain#operatorCallCenterLeft called");
        this.operatorCallHandler.operatorCallCenterLeft();
    }

    public void operatorEndMsgLeft() {
        this.operatorCallHandler.operatorEndMsgLeft();
    }

    public void operatorUpdateDetailInfo() {
        this.operatorCallHandler.operatorUpdateDetailInfo();
    }

    public void updateMiniAppList(List list) {
    }

    public void errorOccured() {
        if (this.miniAppHandler != null) {
            this.miniAppHandler.errorOccured();
        }
    }

    public void setOnlineServiceProvider(AbstractExternalServiceProvider abstractExternalServiceProvider) {
    }

    public OperatorCallFactorySettingController getFactorySettingsController() {
        return this.factorySettings;
    }

    public void sendBAPSignal(int n) {
        if (this.jokerKeyHandler != null) {
            this.jokerKeyHandler.sendMessage(n);
        }
    }

    public void operatorCallCallActiveShown(int n) {
        this.logChannel.log(1000000, "AbstractOperatorCallMain#operatorCallCallActiveShown called");
        this.operatorCallHandler.getOperatorCall(n).callActiveShown();
    }

    public void resultListEntered(int n) {
        this.logChannel.log(1000000, "AbstractOperatorCallMain#resultListEntered called");
        this.operatorCallHandler.getOperatorCall(n).setResultListLastVisited(true);
    }

    public void resultListLeft(int n) {
        this.logChannel.log(1000000, "AbstractOperatorCallMain#resultListLeft called");
        this.operatorCallHandler.getOperatorCall(n).setResultListLastVisited(false);
    }

    public void setNaviFormattingService(INaviFormattingService iNaviFormattingService) {
        this.naviHandler.setNaviFormattingService(iNaviFormattingService);
        this.operatorCallHandler.getOperatorCall(1).refreshList();
    }

    public void terminalModeChanged() {
        boolean bl = this.terminalModeHandler.isTerminalModeActive();
        this.operatorCallHandler.setTerminalMode(bl);
        this.enableDisableOperatorCall();
        if (bl) {
            this.operatorCallHandler.abortConnectionBeforeTelConnectionEstablished();
        }
    }

    public ITerminalModeUpdateListener getTerminalModeUpdateListener() {
        return this.terminalModeHandler;
    }

    public boolean isTerminalModeChangedSupressed(boolean bl) {
        return false;
    }
}

