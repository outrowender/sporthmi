/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.online;

import de.audi.atip.hmi.model.ButtonListener;
import de.audi.atip.hmi.model.ChoiceListener;
import de.audi.atip.hmi.modelaccess.ButtonModelApp;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.hmi.modelaccess.LabelModelApp;
import de.audi.atip.interapp.online.OnlineApplicationOtherContext;
import de.audi.atip.interapp.online.OnlineServiceProvider;
import de.audi.atip.log.LogChannel;
import de.audi.atip.timer.Timer;
import de.audi.atip.timer.TimerListener;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.map.IOnlineConnectionStateListener;
import de.audi.tghu.navi.app.util.Util;
import java.util.Iterator;
import java.util.List;
import org.dsi.ifc.global.NavLocation;

public class RemoteHMIAppsBaseListener
implements ButtonListener,
ChoiceListener,
IOnlineConnectionStateListener {
    protected static final boolean USE_DUMMY_LOCATION_IN_CASE_OF_NULL = true;
    protected static final int MAXIMUM_NUMBER_OF_APPLICATIONS = 15;
    private static final long REMOTE_HMI_MINI_APPS_LABEL_RESET_TIMEOUT = 10000L;
    protected static final double DUMMY_LATITUDE = 53.58549;
    protected static final double DUMMY_LONGITUDE = 6.67253;
    protected final NavigationEnv navigationEnv;
    protected final LogChannel logChannel;
    protected final int miniAppsModelId;
    protected final ChoiceModelApp miniAppsModel;
    protected OnlineServiceProvider onlineServiceProvider;
    private boolean online = false;

    public RemoteHMIAppsBaseListener(NavigationEnv navigationEnv) {
        this.navigationEnv = navigationEnv;
        this.logChannel = navigationEnv.getLogChannel("App.Navi.Online");
        this.miniAppsModelId = 401537;
        this.miniAppsModel = navigationEnv.getChoiceModel(this.miniAppsModelId);
        this.miniAppsModel.setChoiceListener(this);
        this.miniAppsModel.setStatus(3);
        ButtonModelApp buttonModelApp = navigationEnv.getButtonModel(3886);
        buttonModelApp.setButtonListener(this);
    }

    public void setMiniApps(List list, ModelEntry[] modelEntryArray) {
        this.logChannel.log(10000000, "RemoteHMIAppsBaseListener#setMiniApps: Called");
        if (list == null || modelEntryArray == null) {
            this.logChannel.log(100000, "RemoteHMIAppsBaseListener#setMiniApps: Either remoteHMIApps or rightDrawerEntries (ModelEntry array) is null");
            return;
        }
        int n = list.size();
        if (n > modelEntryArray.length) {
            this.logChannel.log(100000, "RemoteHMIAppsBaseListener#setMiniApps: Number of apps are greater than available right drawer entries slots. No. of remoteHMIApps '%1' and no. of available slots '%2'", (long)n, (long)modelEntryArray.length);
        }
        Iterator iterator = list.iterator();
        for (int i2 = 0; iterator.hasNext() && i2 < 15; ++i2) {
            OnlineApplicationOtherContext onlineApplicationOtherContext = (OnlineApplicationOtherContext)iterator.next();
            String string = onlineApplicationOtherContext.getAppName();
            String string2 = onlineApplicationOtherContext.getAppContext();
            LabelModelApp labelModelApp = this.navigationEnv.getLabelModel(modelEntryArray[i2].getLabelModel());
            labelModelApp.setText(string);
            modelEntryArray[i2].setApplicationContext(string2);
            this.logChannel.log(10000000, "RemoteHMIAppsBaseListener#setMiniApps: AppName = %1, AppContext = %2, AppIndex = %3", (Object)string, (Object)string2, (long)i2);
        }
    }

    public ModelEntry getSelectedModelEntry(int n, ModelEntry[] modelEntryArray) {
        int n2 = modelEntryArray.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            ModelEntry modelEntry = modelEntryArray[i2];
            int n3 = modelEntry.getNonLabelModel();
            if (n3 != n) continue;
            return modelEntry;
        }
        return null;
    }

    public OnlineServiceProvider getOnlineServiceProvider() {
        return this.onlineServiceProvider;
    }

    public void setOnlineServiceProvider(OnlineServiceProvider onlineServiceProvider) {
        this.onlineServiceProvider = onlineServiceProvider;
    }

    public void keyTyped(int n, int n2, int n3) {
        this.logChannel.log(10000000, "RemoteHMIAppsBaseListener#keyTyped: Called for model id '%1'", (long)n);
    }

    public void keyPressed(int n, int n2, int n3) {
        this.logChannel.log(10000000, "RemoteHMIAppsBaseListener#keyPressed: Called for model id '%1'", (long)n);
        if (n != this.miniAppsModelId) {
            this.logChannel.log(10000000, "RemoteHMIAppsBaseListener#keyPressed: other than IEvoSystemModelBank.NUMBER_OF_REMOTE_HMI_APPS_IN_NAVI_CHOICE called");
            return;
        }
        this.logChannel.log(10000000, "RemoteHMIAppsBaseListener#keyPressed: %1 apps available", (long)this.miniAppsModel.getValue());
        if (this.online) {
            if (this.miniAppsModel.getValue() == 0) {
                this.triggerAppListDownload();
            }
        } else {
            this.miniAppsModel.fireEvent(0);
        }
    }

    public void keyReleased(int n, int n2, int n3) {
    }

    public void keyLongTyped(int n, int n2, int n3) {
    }

    protected NavLocation createDummyNavLocation() {
        return Util.getLocationFromGeoPos(Util.degreeStringToWgs84(Double.toString(6.67253)), Util.degreeStringToWgs84(Double.toString(53.58549)));
    }

    public void itemSelected(int n, int n2, int n3, int n4) {
        this.logChannel.log(10000000, "RemoteHMIAppsBaseListener#itemSelected: Called for model id '%1'", (long)n);
    }

    public void itemFocused(int n, int n2, int n3, int n4) {
    }

    public void errorOccured() {
        this.logChannel.log(10000000, "RemoteHMIAppsBaseListener#errorOccured: Called");
        if (this.navigationEnv == null) {
            this.logChannel.log(100000, "RemoteHMIAppsBaseListener#errorOccured: navigationEnv is null (may be too early)");
            return;
        }
        this.configureModelsMiniApps(2, 51);
        Timer timer = this.createTimer(this.createErrorListener());
        timer.restart();
    }

    private Timer createTimer(TimerListener timerListener) {
        return new Timer("RemoteHMIAppsBaseListener_Label", 10000L, true, timerListener);
    }

    private TimerListener createErrorListener() {
        return new TimerListener(){

            public void fireTimer(Timer timer) {
                RemoteHMIAppsBaseListener.this.logChannel.log(10000000, "RemoteHMIAppsBaseListener#errorOccured#Timer#fireTimer: Called");
                if (RemoteHMIAppsBaseListener.this.miniAppsModel.getStatus() == 2) {
                    RemoteHMIAppsBaseListener.this.configureModelsMiniApps(3, 48);
                }
            }

            public void cancelTimer(Timer timer) {
            }
        };
    }

    public void triggerAppListDownload() {
        this.logChannel.log(10000000, "RemoteHMIAppsBaseListener#triggerAppListDownload: triggering download");
        if (this.onlineServiceProvider == null) {
            this.logChannel.log(10000000, "RemoteHMIAppsBaseListener#keyPressed: OnlineServiceProvider currently not available");
            this.errorOccured();
        } else {
            this.configureModelsMiniApps(0, 50);
            Timer timer = this.createTimer(this.createDownloadListener());
            timer.restart();
            this.onlineServiceProvider.downloadAppListForNavi();
        }
    }

    private TimerListener createDownloadListener() {
        return new TimerListener(){

            public void fireTimer(Timer timer) {
                RemoteHMIAppsBaseListener.this.logChannel.log(10000000, "RemoteHMIAppsBaseListener#createDownloadListener#Timer#fireTimer: Called");
                if (RemoteHMIAppsBaseListener.this.miniAppsModel.getStatus() == 0) {
                    RemoteHMIAppsBaseListener.this.configureModelsMiniApps(3, 48);
                }
            }

            public void cancelTimer(Timer timer) {
            }
        };
    }

    public synchronized void configureModelsMiniApps(int n, int n2) {
        this.logChannel.log(1000000, "RemoteHMIAppsBaseListener#configureModelsMiniApps: Called with status '%1' and label '%2'", (long)n, (long)n2);
        this.miniAppsModel.setStatus(n);
        String string = this.navigationEnv.getTranslatedText(n2, "");
        this.navigationEnv.getLabelModel(401026).setText(string);
        this.navigationEnv.getLabelModel(401041).setText(string);
    }

    public void connectivityChanged() {
        this.logChannel.log(1000000, "RemoteHMIAppsBaseListener#connectivityChanged: connectivity changed.");
        int n = this.online && this.miniAppsModel.getValue() > 0 ? 1 : 3;
        this.configureModelsMiniApps(n, 48);
    }

    public void updateOnlineConnectionState(boolean bl) {
        this.logChannel.log(1000000, "RemoteHMIAppsBaseListener#updateOnlineConnectionState: old: %1, new %2", this.online, bl);
        if (this.online != bl) {
            this.online = bl;
            this.connectivityChanged();
        }
    }

    public void resetAudiConnectOptionState() {
        if (this.miniAppsModel.getStatus() != 1) {
            this.configureModelsMiniApps(3, 48);
        }
    }

    public static class ModelEntry {
        private final int labelModel;
        private final int nonLabelModel;
        private String applicationContext;

        public ModelEntry(int n, int n2) {
            this.labelModel = n;
            this.nonLabelModel = n2;
            this.applicationContext = "";
        }

        public String getApplicationContext() {
            return this.applicationContext;
        }

        public void setApplicationContext(String string) {
            this.applicationContext = string;
        }

        public int getLabelModel() {
            return this.labelModel;
        }

        public int getNonLabelModel() {
            return this.nonLabelModel;
        }
    }
}

