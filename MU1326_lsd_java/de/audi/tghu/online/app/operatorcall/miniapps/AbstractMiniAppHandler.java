/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.operatorcall.miniapps;

import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.log.LogChannel;
import de.audi.atip.timer.Timer;
import de.audi.atip.util.StringUtilities;
import de.audi.remotehmi.RemoteHMILocation;
import de.audi.tghu.online.app.Online;
import de.audi.tghu.online.app.OnlineEnv;
import de.audi.tghu.online.app.operatorcall.abstractclasses.AbstractBaseModelHandler;
import de.audi.tghu.online.app.operatorcall.abstractclasses.AbstractOperatorCall;
import de.audi.tghu.online.app.operatorcall.miniapps.AbstractMiniAppHandler$1;
import de.audi.tghu.online.app.operatorcall.miniapps.AbstractMiniAppHandler$2;
import de.audi.tghu.online.app.operatorcall.miniapps.MiniApp;
import de.audi.tghu.online.app.remotehmi.AbstractExternalServiceProvider;
import de.esolutions.fw.util.commons.Buffer;
import java.util.HashMap;
import java.util.Map;

public abstract class AbstractMiniAppHandler {
    private static final long MINIAPP_TIMEOUT;
    protected int option01;
    protected int option02;
    protected int option03;
    protected int option04;
    protected int option05;
    protected int option06;
    protected int option07;
    protected int option08;
    protected int option09;
    protected int option10;
    protected int option11;
    protected int option12;
    protected int option13;
    protected int option14;
    protected int option15;
    protected int historyCallList;
    protected int resultList;
    protected final LogChannel logChannel = Online.getInstance().getOperatorCallLogChannel();
    protected Map miniAppMap = new HashMap();
    protected int arrayFilled = 0;
    protected int[] optionArray = new int[15];
    protected OnlineEnv env;
    protected AbstractBaseModelHandler modelHandler;
    protected AbstractOperatorCall listener;
    protected AbstractExternalServiceProvider osp = null;

    protected abstract void initializeOptionModels() {
    }

    protected abstract void initializeTargetListModels() {
    }

    protected abstract AbstractBaseModelHandler createModelHandler() {
    }

    public AbstractMiniAppHandler(OnlineEnv onlineEnv, AbstractOperatorCall abstractOperatorCall) {
        this.env = onlineEnv;
        this.listener = abstractOperatorCall;
        this.initializeOptionModels();
        this.initializeTargetListModels();
        this.addMiniApps();
        this.modelHandler = this.createModelHandler();
        this.registerMiniApps();
        this.configureModelsMiniApps(3, 0);
    }

    protected void addMiniApps() {
        this.addInitMiniAppToMap(this.option01);
        this.addInitMiniAppToMap(this.option02);
        this.addInitMiniAppToMap(this.option03);
        this.addInitMiniAppToMap(this.option04);
        this.addInitMiniAppToMap(this.option05);
        this.addInitMiniAppToMap(this.option06);
        this.addInitMiniAppToMap(this.option07);
        this.addInitMiniAppToMap(this.option08);
        this.addInitMiniAppToMap(this.option09);
        this.addInitMiniAppToMap(this.option10);
        this.addInitMiniAppToMap(this.option11);
        this.addInitMiniAppToMap(this.option12);
        this.addInitMiniAppToMap(this.option13);
        this.addInitMiniAppToMap(this.option14);
        this.addInitMiniAppToMap(this.option15);
    }

    protected void addInitMiniAppToMap(int n) {
        if (this.arrayFilled < 15) {
            this.miniAppMap.put(new Integer(n), new MiniApp(n, new int[]{this.historyCallList, this.resultList}));
            this.optionArray[this.arrayFilled] = n;
            ++this.arrayFilled;
        } else {
            this.logChannel.log(-1601830656, "AbstractMiniAppHandler#addInitMiniAppToMap: number of mini apps exceeded! optionId = %1 will not be added to the mini app list", (long)n);
        }
    }

    public MiniApp getMiniApp(int n) {
        Integer n2 = new Integer(n);
        return (MiniApp)this.miniAppMap.get(n2);
    }

    public int[] getOptionModelIDs() {
        return this.optionArray;
    }

    public void setNewMiniApp(int n, String string, String string2) {
        int n2 = this.optionArray[n];
        MiniApp miniApp = this.getMiniApp(n2);
        miniApp.setData(string, string2);
    }

    public synchronized void configureModelsMiniApps(int n, int n2) {
        this.logChannel.log(1078071040, "AbstractModelHandler#configureModelsMiniApps: Called with status '%1' and label '%2'", (long)n, (long)n2);
        ChoiceModelApp choiceModelApp = this.env.getChoiceModel(1847403264);
        int n3 = choiceModelApp.getStatus();
        if (n3 != 0 && n == 2) {
            this.logChannel.log(1078071040, "AbstractModelHandler#configureModelsMiniApps: current status is %1 and new status is %2 so doing nothing", (long)n3, (long)n);
            return;
        }
        this.modelHandler.setChoiceStatus(1847403264, "NUMBER_OF_REMOTE_HMI_APPS_IN_OPERATORCALL_CHOICE", n);
        String string = this.env.getTranslatedText(n2, "");
        this.modelHandler.setLabelText(-1541594368, "OPERATOR_CALL_RIGHT_DRAWER_AUDI_CONNECT_LABEL", string);
    }

    public void errorOccured() {
        this.logChannel.log(1078071040, "AbstractModelHandler#errorOccured: Called");
        this.configureModelsMiniApps(2, 2);
        Timer timer = new Timer("RemoteHMIAppsBaseListener_Label", 0, true, new AbstractMiniAppHandler$1(this));
        timer.restart();
    }

    protected void registerMiniApps() {
        if (this.optionArray != null) {
            for (int i2 = 0; i2 < this.optionArray.length; ++i2) {
                MiniApp miniApp = this.getMiniApp(this.optionArray[i2]);
                this.modelHandler.registerMiniApp(miniApp);
            }
        }
    }

    public void setOnlineServiceProvider(AbstractExternalServiceProvider abstractExternalServiceProvider) {
        this.osp = abstractExternalServiceProvider;
    }

    public void triggerMiniApp(RemoteHMILocation remoteHMILocation, int n) {
        this.logChannel.log(1078071040, "AbstractMiniAppHandler#triggerMiniApp called");
        if (this.osp == null) {
            this.logChannel.log(-1601830656, "AbstractMiniAppHandler#triggerMiniApp: onlineServiceProvider is null!");
            this.listener.getModelHandler().setCurrentState(13);
            this.listener.getModelHandler().showDefaultError(true, 2);
            return;
        }
        MiniApp miniApp = this.getMiniApp(n);
        this.logChannel.log(-2137614336, "AbstractMiniAppHandler#triggerMiniApp triggering to start the mini app (modelID = %1, name = %2, location = %3)", (Object)new Integer(n), (Object)miniApp.getName(), (Object)this.getLocationAsString(remoteHMILocation));
        String string = miniApp.getAppContext();
        this.osp.startOperatorApp(remoteHMILocation, string, new AbstractMiniAppHandler$2(this));
    }

    private String getLocationAsString(RemoteHMILocation remoteHMILocation) {
        Buffer buffer = new Buffer();
        buffer.append("latitude = ");
        buffer.append(String.valueOf(remoteHMILocation.getLatitude()));
        buffer.append(", longitude = ");
        buffer.append(String.valueOf(remoteHMILocation.getLongitude()));
        buffer.append(", country = \"");
        buffer.append(StringUtilities.getStringNotNull(remoteHMILocation.getCountry()));
        buffer.append("\", town = ");
        buffer.append(StringUtilities.getStringNotNull(remoteHMILocation.getTown()));
        buffer.append(", street = \"");
        buffer.append(StringUtilities.getStringNotNull(remoteHMILocation.getStreet()));
        buffer.append("\", houseNumber = ");
        buffer.append(StringUtilities.getStringNotNull(remoteHMILocation.getHouseNumber()));
        buffer.append("\"");
        return buffer.toString();
    }

    public void triggerAppListDownload() {
        this.logChannel.log(-2137614336, "AbstractMiniApphandler#triggerAppListDownload: triggering download");
        this.configureModelsMiniApps(0, 1);
        if (this.osp == null) {
            this.logChannel.log(-2137614336, "AbstractMiniApphandler#triggerAppListDownload: OnlineServiceProvider currently not available");
            this.errorOccured();
            return;
        }
        this.osp.downloadAppListForNavi();
    }
}

