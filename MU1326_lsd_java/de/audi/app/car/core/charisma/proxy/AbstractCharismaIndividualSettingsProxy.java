/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.core.charisma.proxy;

import de.audi.app.car.common.app.ICarApplication;
import de.audi.app.car.common.service.CarServiceProvider;
import de.audi.app.car.core.charisma.proxy.ICharismaIndividualSettingsClient;
import de.audi.app.car.core.charisma.proxy.ICharismaIndividualSettingsProxy;
import de.audi.atip.log.LogChannel;
import java.util.ArrayList;

public abstract class AbstractCharismaIndividualSettingsProxy
implements ICharismaIndividualSettingsProxy {
    private final LogChannel logChannel;
    private final CarServiceProvider serviceProvider;
    private final ArrayList clients = new ArrayList(1);
    private final Object mutex = new Object();
    static /* synthetic */ Class class$de$audi$app$car$core$charisma$proxy$ICharismaIndividualSettingsProxy;

    public AbstractCharismaIndividualSettingsProxy(ICarApplication iCarApplication, LogChannel logChannel) {
        this.logChannel = logChannel;
        this.serviceProvider = new CarServiceProvider((class$de$audi$app$car$core$charisma$proxy$ICharismaIndividualSettingsProxy == null ? (class$de$audi$app$car$core$charisma$proxy$ICharismaIndividualSettingsProxy = AbstractCharismaIndividualSettingsProxy.class$("de.audi.app.car.core.charisma.proxy.ICharismaIndividualSettingsProxy")) : class$de$audi$app$car$core$charisma$proxy$ICharismaIndividualSettingsProxy).getName(), this, null, iCarApplication.getBundleContext(), logChannel);
    }

    public void init() {
        this.serviceProvider.startService();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void deinit() {
        this.serviceProvider.stopService();
        Object object = this.mutex;
        synchronized (object) {
            this.clients.clear();
        }
    }

    @Override
    public boolean hasClients() {
        return 0 < this.clients.size();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void registerClient(ICharismaIndividualSettingsClient iCharismaIndividualSettingsClient) {
        if (this.logChannel.isInfo()) {
            this.logChannel.log(1078071040, "[CharismaIndividualSettingsProxy#registerClient] ...");
        }
        Object object = this.mutex;
        synchronized (object) {
            if (!this.clients.contains(iCharismaIndividualSettingsClient)) {
                this.clients.add(iCharismaIndividualSettingsClient);
            } else {
                this.logChannel.log(-1601830656, "[CharismaIndividualSettingsProxy#registerClient] Client already registered.");
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void unregisterClient(ICharismaIndividualSettingsClient iCharismaIndividualSettingsClient) {
        if (this.logChannel.isInfo()) {
            this.logChannel.log(1078071040, "[CharismaIndividualSettingsProxy#unregisterClient] ...");
        }
        Object object = this.mutex;
        synchronized (object) {
            this.clients.remove(iCharismaIndividualSettingsClient);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void invokeSaveIndividualSettingsRequest() {
        if (this.logChannel.isInfo()) {
            this.logChannel.log(1078071040, "[CharismaIndividualSettingsProxy#invokeSaveIndividualSettingsRequest] ...");
        }
        Object object = this.mutex;
        synchronized (object) {
            for (int i2 = 0; i2 < this.clients.size(); ++i2) {
                ICharismaIndividualSettingsClient iCharismaIndividualSettingsClient = (ICharismaIndividualSettingsClient)this.clients.get(i2);
                try {
                    iCharismaIndividualSettingsClient.notifySaveIndividualSettingsRequest();
                    continue;
                }
                catch (Exception exception) {
                    this.logChannel.log(1000, "[CharismaIndividualSettingsProxy#invokeSaveIndividualSettingsRequest] Exception occured within the client.");
                }
            }
        }
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

