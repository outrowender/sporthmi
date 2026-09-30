/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.remotehmi;

import de.audi.atip.interapp.NaviOnlineService;
import de.audi.atip.interapp.NaviService;
import de.audi.atip.interapp.media.IMediaDrawerContext;
import de.audi.atip.interapp.online.IRemoteHMIMediaOnlineServiceListener;
import de.audi.atip.interapp.online.OnlineApplicationOtherContext;
import de.audi.atip.interapp.online.OnlineServiceProvider;
import de.audi.atip.interapp.online.TransitionCallback;
import de.audi.atip.log.LogChannel;
import de.audi.remotehmi.RemoteHMIAction;
import de.audi.remotehmi.RemoteHMILocation;
import de.audi.remotehmi.ui.mib2.IExternalService;
import de.audi.tghu.online.app.operatorcall.AbstractOperatorCallMain;
import de.audi.tghu.online.app.remotehmi.AbstractCommandHandler;
import de.audi.tghu.online.app.remotehmi.AbstractRemoteHMIComponent;
import de.audi.tghu.online.app.remotehmi.ContextManagerComponent;
import de.audi.tghu.online.app.remotehmi.DiagnosisComponent;
import de.audi.tghu.online.app.remotehmi.EntryPoint;
import de.audi.tghu.online.app.remotehmi.MediaSubEntryPointsContainer;
import de.audi.tghu.online.app.remotehmi.RemoteHMIContext;
import de.audi.tghu.online.app.remotehmi.RemoteHMIService;
import de.audi.tghu.online.app.remotehmi.util.Counter;
import de.audi.tghu.online.app.remotehmi.util.OnlineApplicationOtherContextImpl;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.dsi.ifc.global.NavLocation;

public abstract class AbstractExternalServiceProvider
extends AbstractRemoteHMIComponent
implements OnlineServiceProvider {
    public static final int ERROR = 1;
    public static final int SUCCESS = 0;
    protected static final String HOSTING_CONTEXT_MEDIA = "media";
    private List lastRemoteHMIAppsNavi;
    protected List lastRemoteHMIAppsMedia;
    private List mediaAppsTemplate;
    protected DiagnosisComponent diagnosisComponent;
    protected boolean sendAppsMedia;
    protected int lastUsedService = -1;
    protected int lastAppState = 0;
    protected String lastAppContext = "";
    private boolean deviceAppInfo = false;
    protected String[] connectedDevices = new String[1];

    public void init(LogChannel logChannel, RemoteHMIService remoteHMIService) {
        super.init(logChannel, remoteHMIService);
        if (remoteHMIService.getFrameworkAccess().isSimulator()) {
            this.connectedDevices[0] = "evilHack";
        }
        remoteHMIService.addCommandHandler(10000004, new AbstractCommandHandler("mini_apps-other-context"){

            public void indicateCommand(int n, Object object) {
                List list = (List)object;
                AbstractExternalServiceProvider.this.sendAppsUpdateToDestAndMap(list);
                AbstractExternalServiceProvider.this.sendAppsUpdateToOperatorCall(list);
            }
        });
        remoteHMIService.addCommandHandler(10000005, new AbstractCommandHandler("apps-other-context-media"){

            public void indicateCommand(int n, Object object) {
                List list = (List)object;
                AbstractExternalServiceProvider.this.sendAppsUpdateToMedia(list);
            }
        });
        remoteHMIService.addCommandHandler(10000007, new AbstractCommandHandler("media-application-icon-update"){

            public void indicateCommand(int n, Object object) {
                Object[] objectArray = (Object[])object;
                IExternalService iExternalService = (IExternalService)objectArray[0];
                Integer n2 = (Integer)objectArray[1];
                AbstractExternalServiceProvider.this.sendIconUpdateToMedia(iExternalService, n2);
            }
        });
        remoteHMIService.addCommandHandler(100000016, new AbstractCommandHandler("error-miniapps-download"){

            public void indicateCommand(int n, Object object) {
                AbstractExternalServiceProvider.this.sendMiniAppsDownloadError();
            }
        });
        this.diagnosisComponent = remoteHMIService.getDiagnosisComponent();
    }

    public void onEnter() {
        this.logChannel.log(1000000, "AbstractExternalServiceProvider#onEnter: called");
    }

    public final void sendSavedAppsUpdateToDestAndMap(NaviService naviService) {
        NaviOnlineService naviOnlineService;
        this.logChannel.log(10000000, "AbstractExternalServiceProvider#sendSavedAppsUpdateToDestAndMap: Called");
        if (this.lastRemoteHMIAppsNavi != null && (naviOnlineService = naviService.getNaviOnlineService()) != null) {
            int n = this.lastRemoteHMIAppsNavi.size();
            naviOnlineService.sendRemoteHMIAppsUpdateToNaviAndMap(this.lastRemoteHMIAppsNavi);
            this.lastRemoteHMIAppsNavi = null;
            this.logChannel.log(10000000, "AbstractExternalServiceProvider#sendSavedAppsUpdateToDestAndMap: Mini Applications list sent to Destination and Map. No. of Mini Apps are '%1'", (long)n);
        }
    }

    public final void sendSavedInfoToMedia(IRemoteHMIMediaOnlineServiceListener iRemoteHMIMediaOnlineServiceListener) {
        this.logChannel.log(1000000, "AbstractExternalServiceProvider#sendSavedAppsUpdateToMedia: Send applications to media as reference became available now");
        if (this.deviceAppInfo) {
            iRemoteHMIMediaOnlineServiceListener.updateDeviceAppState(this.connectedDevices.length != 0);
            this.deviceAppInfo = false;
            this.logChannel.log(10000000, "AbstractExternalServiceProvider#sendSavedAppsUpdateToMedia: sent deviceAppInfo to media");
        }
        if (this.sendAppsMedia && this.connectedDevices != null && this.connectedDevices.length != 0) {
            iRemoteHMIMediaOnlineServiceListener.updateLastActiveOnlineService(this.lastUsedService);
            this.sendAppsMedia = false;
        } else {
            this.lastRemoteHMIAppsMedia = new ArrayList(0);
        }
        iRemoteHMIMediaOnlineServiceListener.updateOnlineServices(this.lastRemoteHMIAppsMedia);
        int n = this.lastRemoteHMIAppsMedia != null ? this.lastRemoteHMIAppsMedia.size() : 0;
        IMediaDrawerContext iMediaDrawerContext = this.remoteHmiService.getMediaDrawerContext();
        if (n == 0 && iMediaDrawerContext != null) {
            iMediaDrawerContext.setDrawerElements(null, null);
        }
        this.logChannel.log(10000000, "AbstractExternalServiceProvider#sendSavedAppsUpdateToMedia: Apps sent to Media: '%1', Devices: '%2', lastUsedService: '%3'", (long)n, this.connectedDevices == null ? 0L : (long)this.connectedDevices.length, (long)this.lastUsedService);
    }

    public final void downloadAppListForNavi() {
        this.logChannel.log(10000000, "AbstractExternalServiceProvider#downloadAppListForNavi: Called");
        RemoteHMIAction remoteHMIAction = this.remoteHmiService.getAction(0x989689);
        this.remoteHmiService.invokeAction(remoteHMIAction);
    }

    protected final void sendAppsUpdateToOperatorCall(List list) {
        this.logChannel.log(1000000, "AbstractExternalServiceProvider#sendAppsUpdateToOperatorCall: Called");
        AbstractOperatorCallMain abstractOperatorCallMain = this.remoteHmiService.getOperatorCallController();
        if (abstractOperatorCallMain == null) {
            this.logChannel.log(1000000, "AbstractExternalServiceProvider#sendAppsUpdateToOperatorCall: OperatorCallImpl reference doesn't exist");
            return;
        }
        ArrayList arrayList = this.getOnlineApplicationsFromOnlineServices(list);
        int n = arrayList.size();
        abstractOperatorCallMain.updateMiniAppList(arrayList);
        this.logChannel.log(1000000, "AbstractExternalServiceProvider#sendAppsUpdateToOperatorCall: No. of Mini Apps are '%1' sent to operatorcall", (long)n);
    }

    protected final void sendAppsUpdateToDestAndMap(List list) {
        this.logChannel.log(10000000, "AbstractExternalServiceProvider#sendAppsUpdateToDestAndMap: Called");
        ArrayList arrayList = this.getOnlineApplicationsFromOnlineServices(list);
        int n = arrayList.size();
        NaviOnlineService naviOnlineService = this.remoteHmiService.getNaviComponent().getNaviOnlineService();
        if (naviOnlineService != null) {
            naviOnlineService.sendRemoteHMIAppsUpdateToNaviAndMap(arrayList);
            this.logChannel.log(10000000, "AbstractExternalServiceProvider#sendAppsUpdateToDestAndMap: Mini Applications list sent to Destination and Map. No. of Mini Apps are '%1'", (long)n);
        } else {
            this.lastRemoteHMIAppsNavi = arrayList;
            this.logChannel.log(10000000, "AbstractExternalServiceProvider#sendAppsUpdateToDestAndMap: Applications saved and will be sent when navi reference is obtained. No. of Mini Apps are '%1'", (long)n);
        }
    }

    protected void sendAppsUpdateToMedia(List list) {
        Object object;
        Object object2;
        this.logChannel.log(1000000, "AbstractExternalServiceProvider#sendAppsUpdateToMedia: called with size %1", (long)(list != null ? list.size() : -1));
        ArrayList arrayList = new ArrayList();
        String string = "";
        MediaSubEntryPointsContainer mediaSubEntryPointsContainer = new MediaSubEntryPointsContainer(this.logChannel);
        this.lastUsedService = -1;
        int n = list.size();
        for (int i2 = 0; i2 < n; ++i2) {
            Object object3 = list.get(i2);
            if (!(object3 instanceof IExternalService)) {
                this.logChannel.log(100000, "AbstractExternalServiceProvider#sendAppsUpdateToMedia: no IExternalservice: %1", object3);
                continue;
            }
            object2 = (IExternalService)object3;
            object = new OnlineApplicationOtherContextImpl((IExternalService)object2);
            arrayList.add(object);
            mediaSubEntryPointsContainer.putEntryPoint(object2.getEntryContext(), new EntryPoint(10 + Counter.getNext(), this.logChannel));
            if (object2.isEntryLastMode()) {
                string = ((OnlineApplicationOtherContextImpl)object).getAppName();
                this.logChannel.log(1000000, "AbstractExternalServiceProvider#sendAppsUpdateToMedia: app '%1' added and will be started as lastmode", (Object)string);
                continue;
            }
            this.logChannel.log(1000000, "AbstractExternalServiceProvider#sendAppsUpdateToMedia: app '%1' added", object);
        }
        if (list.size() > 0 && arrayList.size() == 0) {
            this.logChannel.log(10000, "AbstractExternalServiceProvider#sendAppsUpdateToMedia: invalid media apps update received!");
            return;
        }
        ArrayList arrayList2 = arrayList.size() == 0 ? arrayList : this.prepareMediaApps(arrayList);
        n = arrayList2.size();
        for (int i3 = 0; i3 < arrayList2.size(); ++i3) {
            object2 = (OnlineApplicationOtherContext)arrayList2.get(i3);
            if (object2 == null || string.equals("") || !string.equals(object2.getAppName())) continue;
            this.lastUsedService = i3;
            break;
        }
        this.logChannel.log(1000000, "AbstractExternalServiceProvider#sendAppsUpdateToMedia: sending prepared list with size %1, connected devices %2, last mode %3", (long)n, (long)this.connectedDevices.length, (long)this.lastUsedService);
        this.lastRemoteHMIAppsMedia = arrayList2;
        EntryPoint entryPoint = this.remoteHmiService.getContextManagerComponent().getEntryPointFromMap(4);
        this.makeEntryPointConsistent(mediaSubEntryPointsContainer, entryPoint);
        entryPoint.setSubEntryPointContainer(mediaSubEntryPointsContainer);
        object2 = this.remoteHmiService.getRemoteHMIMediaOnlineServiceListener();
        if (object2 == null) {
            this.sendAppsMedia = true;
            this.logChannel.log(1000000, "AbstractExternalServiceProvider#sendAppsUpdateToMedia: media reference currently not available so apps will be sent later");
            return;
        }
        if (n != 0) {
            object2.updateLastActiveOnlineService(this.lastUsedService);
        }
        object2.updateOnlineServices(arrayList2);
        object = this.remoteHmiService.getMediaDrawerContext();
        if (n == 0 && object != null) {
            object.setDrawerElements(null, null);
        }
        this.diagnosisComponent.update(arrayList2, 2);
    }

    private void makeEntryPointConsistent(MediaSubEntryPointsContainer mediaSubEntryPointsContainer, EntryPoint entryPoint) {
        EntryPoint entryPoint2;
        Object object;
        MediaSubEntryPointsContainer mediaSubEntryPointsContainer2 = entryPoint.getSubEntryPointContainer();
        if (mediaSubEntryPointsContainer2 == null) {
            this.logChannel.log(1000000, "AbstractExternalServiceProvider#makeEntryPointConsistent: oldContainer null so no consistency required");
            return;
        }
        EntryPoint entryPoint3 = mediaSubEntryPointsContainer2.getCurrentEntryPoint();
        if (entryPoint3 == null) {
            this.logChannel.log(1000000, "AbstractExternalServiceProvider#makeEntryPointConsistent: no current entry point was defined for old container");
            return;
        }
        RemoteHMIContext remoteHMIContext = entryPoint3.getCurrentContext();
        if (remoteHMIContext != null) {
            object = remoteHMIContext.getContextName();
            entryPoint2 = mediaSubEntryPointsContainer.getEntryPointByAppContext((String)object);
            if (entryPoint2 == null) {
                this.logChannel.log(100000, "AbstractExternalServiceProvider#makeEntryPointConsistent: contextName '%1' not present in new services list", object);
                return;
            }
            entryPoint2.setCurrentContext(remoteHMIContext);
            this.logChannel.log(1000000, "AbstractExternalServiceProvider#makeEntryPointConsistent: current entry point id is %1 and context name %2", (Object)new Integer(entryPoint2.getEntryPointId()), object);
        } else {
            object = entryPoint3.getNameOfContextToBeStarted();
            if (object == null) {
                this.logChannel.log(100000, "AbstractExternalServiceProvider#makeEntryPointConsistent: nameOfContextToBeStarted '%1' not attached to the entry point");
                return;
            }
            entryPoint2 = mediaSubEntryPointsContainer.getEntryPointByAppContext((String)object);
            if (entryPoint2 == null) {
                this.logChannel.log(100000, "AbstractExternalServiceProvider#makeEntryPointConsistent: nameOfContextToBeStarted '%1' not present in new services list", object);
                return;
            }
            entryPoint2.setNameOfContextToBeStarted((String)object);
            this.logChannel.log(1000000, "AbstractExternalServiceProvider#makeEntryPointConsistent: current entry point id is %1 and name of context to be started is '%2'", (Object)new Integer(entryPoint2.getEntryPointId()), object);
        }
        mediaSubEntryPointsContainer.setCurrentEntryPoint(entryPoint2);
        object = this.remoteHmiService.getContextManagerComponent();
        EntryPoint entryPoint4 = ((ContextManagerComponent)object).getCurrentEntryPoint();
        if (entryPoint4 != null && entryPoint4.getEntryPointId() == entryPoint3.getEntryPointId()) {
            ((ContextManagerComponent)object).setCurrentEntryPoint(entryPoint2);
        }
    }

    private void printPreparedList(List list) {
        if (list == null) {
            this.logChannel.log(10000000, "AbstractExternalServiceProvider#printPreparedList: preparedList is null");
            return;
        }
        int n = list.size();
        for (int i2 = 0; i2 < n; ++i2) {
            OnlineApplicationOtherContext onlineApplicationOtherContext = (OnlineApplicationOtherContext)list.get(i2);
            this.logChannel.log(10000000, "AbstractExternalServiceProvider#printPreparedList: application %1 is %2", (Object)new Integer(i2), (Object)(onlineApplicationOtherContext == null ? "NULL" : onlineApplicationOtherContext.getAppName()));
        }
    }

    protected final void sendIconUpdateToMedia(IExternalService iExternalService, Integer n) {
        if (iExternalService == null || n == null) {
            this.logChannel.log(10000, "AbstractExternalServiceProvider#sendIconUpdateToMedia: drawerEntryOtherContext or iconType is null! drawerEntryOtherContext= %1, iconType=%2", (Object)iExternalService, (Object)n);
            return;
        }
        this.logChannel.log(10000000, "AbstractExternalServiceProvider#sendIconUpdateToMedia: Icon update of type '%1' recieved for application name '%2'", (Object)n, (Object)iExternalService.getEntryName());
        List list = this.lastRemoteHMIAppsMedia;
        if (list == null) {
            this.logChannel.log(10000000, "AbstractExternalServiceProvider#sendIconUpdateToMedia: Applications list for media is null");
            return;
        }
        int n2 = n;
        boolean bl = false;
        Object object = list.iterator();
        while (object.hasNext()) {
            OnlineApplicationOtherContextImpl onlineApplicationOtherContextImpl = (OnlineApplicationOtherContextImpl)object.next();
            if (onlineApplicationOtherContextImpl == null || onlineApplicationOtherContextImpl.getAppContext() == null) {
                this.logChannel.log(10000, "AbstractExternalServiceProvider#sendIconUpdateToMedia: AppContext is null! onlineAppOtherContextImpl=%1", (Object)onlineApplicationOtherContextImpl);
                continue;
            }
            if (!onlineApplicationOtherContextImpl.getAppContext().equals(iExternalService.getEntryContext())) continue;
            switch (n2) {
                case 1: {
                    onlineApplicationOtherContextImpl.setSourceListIconActive(iExternalService.getIcon());
                    break;
                }
                case 2: {
                    onlineApplicationOtherContextImpl.setSourceListIconInactive(iExternalService.getInactiveIconLocalUrl());
                    break;
                }
                case 3: {
                    onlineApplicationOtherContextImpl.setSourceListIconReflection(iExternalService.getReflectionIcon());
                    break;
                }
                case 4: {
                    onlineApplicationOtherContextImpl.setCaptionIcon(iExternalService.getCaptionIconLocalUrl());
                    break;
                }
                case 5: {
                    onlineApplicationOtherContextImpl.setLoadingIcon(iExternalService.getLoadingIconLocalUrl());
                    break;
                }
                default: {
                    this.logChannel.log(10000000, "AbstractExternalServiceProvider#sendIconUpdateToMedia: Icon update of type '%1' recieved for application name '%2' is not valid", (Object)n, (Object)iExternalService.getEntryName());
                }
            }
            bl = true;
            break;
        }
        if (!bl) {
            this.logChannel.log(10000000, "AbstractExternalServiceProvider#sendIconUpdateToMedia: Application name '%1' not found in order to update the icon", (Object)iExternalService.getEntryName());
            return;
        }
        object = this.remoteHmiService.getRemoteHMIMediaOnlineServiceListener();
        if (object != null) {
            object.updateOnlineServices(list);
            this.logChannel.log(10000000, "AbstractExternalServiceProvider#sendIconUpdateToMedia: Applications list sent to Media because of Icon update for application '%1'", (Object)iExternalService);
        }
    }

    protected ArrayList prepareMediaApps(ArrayList arrayList) {
        this.logChannel.log(10000000, "AbstractExternalServiceProvider#prepareMediaApps: Length of apps = %1", (long)arrayList.size());
        ArrayList arrayList2 = null;
        if (this.mediaAppsTemplate == null) {
            this.logChannel.log(10000000, "AbstractExternalServiceProvider#prepareMediaApps: creating new template");
            this.mediaAppsTemplate = new ArrayList(arrayList);
            arrayList2 = new ArrayList(arrayList);
        } else {
            OnlineApplicationOtherContext onlineApplicationOtherContext;
            Iterator iterator;
            boolean bl;
            OnlineApplicationOtherContext onlineApplicationOtherContext2;
            ArrayList arrayList3 = new ArrayList(this.mediaAppsTemplate);
            Iterator iterator2 = arrayList.iterator();
            while (iterator2.hasNext()) {
                onlineApplicationOtherContext2 = (OnlineApplicationOtherContext)iterator2.next();
                bl = false;
                this.logChannel.log(10000000, "AbstractExternalServiceProvider#prepareMediaApps: prepare %1", (Object)onlineApplicationOtherContext2.getAppName());
                iterator = arrayList3.listIterator();
                while (iterator.hasNext()) {
                    onlineApplicationOtherContext = (OnlineApplicationOtherContext)iterator.next();
                    if (!onlineApplicationOtherContext.getAppContext().equals(onlineApplicationOtherContext2.getAppContext())) continue;
                    bl = true;
                    arrayList3.set(iterator.previousIndex(), onlineApplicationOtherContext2);
                    this.logChannel.log(10000000, "AbstractExternalServiceProvider#prepareMediaApps: update entry %1 (%2)", (Object)Integer.toString(iterator.previousIndex()), (Object)onlineApplicationOtherContext2.getAppName());
                    break;
                }
                if (bl) continue;
                this.logChannel.log(10000000, "AbstractExternalServiceProvider#prepareMediaApps: adding new app %1 (%2)", (Object)onlineApplicationOtherContext2.getAppName(), (Object)onlineApplicationOtherContext2.getAppContext());
                arrayList3.add(onlineApplicationOtherContext2);
            }
            this.mediaAppsTemplate = arrayList3;
            arrayList2 = new ArrayList(arrayList3);
            for (int i2 = 0; i2 < arrayList2.size(); ++i2) {
                onlineApplicationOtherContext2 = (OnlineApplicationOtherContext)arrayList2.get(i2);
                bl = false;
                iterator = arrayList.iterator();
                while (iterator.hasNext()) {
                    onlineApplicationOtherContext = (OnlineApplicationOtherContext)iterator.next();
                    if (!onlineApplicationOtherContext.getAppContext().equals(onlineApplicationOtherContext2.getAppContext())) continue;
                    this.logChannel.log(10000000, "AbstractExternalServiceProvider#prepareMediaApps: keep app %1 (%2)", (Object)onlineApplicationOtherContext.getAppName(), (Object)onlineApplicationOtherContext.getAppContext());
                    bl = true;
                    break;
                }
                if (bl) continue;
                this.logChannel.log(10000000, "AbstractExternalServiceProvider#prepareMediaApps: setting old entry %1 to null", arrayList2.get(i2));
                arrayList2.set(i2, null);
            }
        }
        return arrayList2;
    }

    private void sendMiniAppsDownloadError() {
        this.logChannel.log(10000000, "AbstractExternalServiceProvider#sendMiniAppsDownloadError: Called");
        NaviOnlineService naviOnlineService = this.remoteHmiService.getNaviComponent().getNaviOnlineService();
        if (naviOnlineService == null) {
            this.logChannel.log(10000000, "AbstractExternalServiceProvider#sendMiniAppsDownloadError: NaviOnlineService not available");
            return;
        }
        naviOnlineService.sendMiniAppsDownloadError();
    }

    public void updateDeviceAppInfo(String[] stringArray) {
        this.logChannel.log(1000000, "AbstractExternalServiceProvider#updateDeviceInfo: devices - %1", (long)stringArray.length);
        this.connectedDevices = stringArray;
        IRemoteHMIMediaOnlineServiceListener iRemoteHMIMediaOnlineServiceListener = this.remoteHmiService.getRemoteHMIMediaOnlineServiceListener();
        if (iRemoteHMIMediaOnlineServiceListener == null) {
            this.logChannel.log(10000000, "AbstractExternalServiceProvider#updateDeviceInfo: IRemoteHMIMediaOnlineServiceListener not available so save deviceinfo for later use");
            this.deviceAppInfo = true;
            return;
        }
        iRemoteHMIMediaOnlineServiceListener.updateDeviceAppState(this.connectedDevices.length != 0);
        this.diagnosisComponent.update(this.connectedDevices, 3);
    }

    public OnlineApplicationOtherContextImpl getOnlineMediaAppByContext(String string) {
        this.logChannel.log(1000000, "AbstractExternalServiceProvider#getOnlineMediaAppByContext: context name - %1", (Object)string);
        if (this.lastRemoteHMIAppsMedia == null || this.lastRemoteHMIAppsMedia.size() == 0) {
            this.logChannel.log(100000, "AbstractExternalServiceProvider#getOnlineMediaAppByContext: no record of OnlineMedia apps found.");
            return null;
        }
        Iterator iterator = this.lastRemoteHMIAppsMedia.iterator();
        while (iterator.hasNext()) {
            Object object = iterator.next();
            if (!(object instanceof OnlineApplicationOtherContextImpl)) {
                this.logChannel.log(10000000, "AbstractExternalServiceProvider#getOnlineMediaAppByContext: object %1 not instance of OnlineApplicationOtherContextImpl", object);
                continue;
            }
            OnlineApplicationOtherContextImpl onlineApplicationOtherContextImpl = (OnlineApplicationOtherContextImpl)object;
            String string2 = onlineApplicationOtherContextImpl.getAppContext();
            if (string2 == null || !string2.equals(string)) continue;
            return onlineApplicationOtherContextImpl;
        }
        return null;
    }

    protected ArrayList getOnlineApplicationsFromOnlineServices(List list) {
        ArrayList arrayList = new ArrayList(list.size());
        int n = list.size();
        for (int i2 = 0; i2 < n; ++i2) {
            Object object = list.get(i2);
            if (!(object instanceof IExternalService)) {
                this.logChannel.log(1000000, "AbstractExternalServiceProvider#getOnlineApplicationsFromOnlineServices: no IExternalservice: %1", object);
                continue;
            }
            IExternalService iExternalService = (IExternalService)object;
            arrayList.add(new OnlineApplicationOtherContextImpl(iExternalService));
        }
        return arrayList;
    }

    public abstract void startMediaApp(String var1, boolean var2);

    public abstract void stopMediaApp(String var1);

    public abstract void startDestinationApp(NavLocation var1, String var2, TransitionCallback var3);

    public abstract void startMapApp(NavLocation var1, String var2, TransitionCallback var3);

    public abstract void startOperatorApp(RemoteHMILocation var1, String var2, TransitionCallback var3);
}

