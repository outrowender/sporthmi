/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.osr;

import de.audi.atip.interapp.online.IOnlineDataStateListener;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.online.app.osr.OnlineService;
import de.audi.tghu.online.app.osr.OnlineServiceRegistrationSubsystem;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map$Entry;
import org.dsi.ifc.online.OSRApplication;
import org.dsi.ifc.online.OSRNotifyProperties;

public class OnlineServiceRegistrationDataContainer
implements IOnlineDataStateListener {
    private final Map applicationContainer = new HashMap();
    private LogChannel logChannel;
    private final Object mutex = new Object();

    public OnlineServiceRegistrationDataContainer(OnlineServiceRegistrationSubsystem onlineServiceRegistrationSubsystem) {
        this.logChannel = onlineServiceRegistrationSubsystem.getLogChannel();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void addApplication(OnlineService onlineService) {
        Object object = this.mutex;
        synchronized (object) {
            this.applicationContainer.put(onlineService.getApplicationId(), onlineService);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public OnlineService getApplication(String string) {
        Object object = this.mutex;
        synchronized (object) {
            return (OnlineService)this.applicationContainer.get(string);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean containsApplication(String string) {
        Object object = this.mutex;
        synchronized (object) {
            return this.applicationContainer.containsKey(string);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public Collection getApplications() {
        Object object = this.mutex;
        synchronized (object) {
            return this.applicationContainer.values();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void addOrUpdateOnlineApplication(OSRApplication oSRApplication, OnlineServiceRegistrationSubsystem onlineServiceRegistrationSubsystem) {
        Object object = this.mutex;
        synchronized (object) {
            OnlineService onlineService = this.getApplication(oSRApplication.getId());
            if (onlineService != null) {
                this.logChannel.log(-2137614336, "[OnlineServiceRegistrationDataContainer#addOrUpdateOnlineApplication] update app id:%1", (Object)oSRApplication.getId());
                onlineService.setOnlineApplication(oSRApplication);
            } else {
                for (int i2 = 0; i2 < OnlineServiceRegistrationSubsystem.WHITE_FILTER.length; ++i2) {
                    if (oSRApplication.getId().equals(OnlineServiceRegistrationSubsystem.WHITE_FILTER[i2])) {
                        onlineService = new OnlineService(oSRApplication.getId(), onlineServiceRegistrationSubsystem);
                        onlineService.setOnlineApplication(oSRApplication);
                        this.logChannel.log(-2137614336, "[OnlineServiceRegistrationDataContainer#addOrUpdateOnlineApplication] create new app id:%1", (Object)oSRApplication.getId());
                        this.addApplication(onlineService);
                        continue;
                    }
                    this.logChannel.log(-2137614336, "[OnlineServiceRegistrationDataContainer#addOrUpdateOnlineApplication] filtered out! app id:%1", (Object)oSRApplication.getId());
                }
            }
        }
    }

    @Override
    public void updateRoamingSetting(boolean bl) {
        this.logChannel.log(1078071040, "[OnlineServiceRegistrationDataContainer#updateRoamingState] roaming active: %1", bl);
        Iterator iterator = this.getApplications().iterator();
        while (iterator.hasNext()) {
            this.setOnlineServiceRoamingState((OnlineService)iterator.next(), bl);
        }
    }

    private void setOnlineServiceRoamingState(OnlineService onlineService, boolean bl) {
        onlineService.updateRoamingState(bl);
    }

    public void sendApplicationStatus(OSRNotifyProperties[] oSRNotifyPropertiesArray) {
        this.logChannel.log(1078071040, "[OnlineServiceRegistrationDataContainer#sendApplicationStatus] %1 props", (long)oSRNotifyPropertiesArray.length);
        HashMap hashMap = this.sortPropertiesByAppID(oSRNotifyPropertiesArray);
        Iterator iterator = hashMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map$Entry map$Entry = (Map$Entry)iterator.next();
            String string = (String)map$Entry.getKey();
            Object object = map$Entry.getValue();
            if (object instanceof OSRNotifyProperties[] && string != null) {
                OnlineService onlineService = this.getApplication(string);
                if (onlineService != null) {
                    this.logChannel.log(1078071040, "[OnlineServiceRegistrationDataContainer#sendApplicationStatus] updateApplicationState for onlineApp %1 with props %2", (Object)string, object);
                    onlineService.updateApplicationState((OSRNotifyProperties[])object);
                    continue;
                }
                this.logChannel.log(1078071040, "[OnlineServiceRegistrationDataContainer#sendApplicationStatus] no suitable application found for app %1", (Object)string);
                continue;
            }
            this.logChannel.log(-1601830656, "[OnlineServiceRegistrationDataContainer#sendApplicationStatus] properties of wrong class %1", (Object)object.getClass().getName());
        }
    }

    private HashMap sortPropertiesByAppID(OSRNotifyProperties[] oSRNotifyPropertiesArray) {
        HashMap hashMap = new HashMap();
        for (int i2 = 0; i2 < oSRNotifyPropertiesArray.length; ++i2) {
            OSRNotifyProperties oSRNotifyProperties = oSRNotifyPropertiesArray[i2];
            String string = oSRNotifyProperties.getIdonlineapp();
            if (string == null || hashMap.containsKey(string)) continue;
            hashMap.put(string, this.getPropsForAppID(string, oSRNotifyPropertiesArray));
        }
        return hashMap;
    }

    private OSRNotifyProperties[] getPropsForAppID(String string, OSRNotifyProperties[] oSRNotifyPropertiesArray) {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < oSRNotifyPropertiesArray.length; ++i2) {
            OSRNotifyProperties oSRNotifyProperties = oSRNotifyPropertiesArray[i2];
            if (oSRNotifyProperties == null || oSRNotifyProperties.getIdonlineapp() == null || !oSRNotifyProperties.getIdonlineapp().equals(string)) continue;
            arrayList.add(oSRNotifyProperties);
        }
        OSRNotifyProperties[] oSRNotifyPropertiesArray2 = (OSRNotifyProperties[])arrayList.toArray(new OSRNotifyProperties[0]);
        return oSRNotifyPropertiesArray2;
    }
}

