/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.connectivity;

import de.audi.app.bluetooth.evo.BluetoothApplication;
import de.audi.app.bluetooth.evo.IEvoBluetoothApplication;
import de.audi.app.connectivity.IEvoConnectivity;
import de.audi.app.connectivity.ap.ConnectivityActionProxyImpl;
import de.audi.app.connectivity.ap.ConnectivityHMIApplicationImpl;
import de.audi.app.connectivity.core.AbstractConnectivityActivator;
import de.audi.app.connectivity.manager.ConnectivityManager;
import de.audi.app.connectivity.manager.IConnectivityManager;
import de.audi.app.data.core.IDataApplication;
import de.audi.app.data.evo.DataApplication;
import de.audi.app.obex.ObexApplication;
import de.audi.app.obex.core.IObexApplication;
import de.audi.app.wlan.evo.IEvoWlanApplication;
import de.audi.app.wlan.evo.WlanApplication;
import java.util.Dictionary;
import java.util.Hashtable;
import org.osgi.framework.BundleContext;

public class Activator
extends AbstractConnectivityActivator
implements IEvoConnectivity {
    private static final int IS_SERVICE_DISCOVERY_ON;
    private ConnectivityManager coma;
    private IEvoBluetoothApplication bluetooth;
    private DataApplication data;
    private IEvoWlanApplication wlan;
    private IObexApplication obex;
    static /* synthetic */ Class class$de$audi$atip$statemachine$ActionProxy;
    static /* synthetic */ Class class$de$audi$atip$hmi$HMIApplication;

    @Override
    public void start(BundleContext bundleContext) {
        super.start(bundleContext);
        boolean bl = this.isOn(4526, 0);
        boolean bl2 = this.isOn(461);
        boolean bl3 = this.isOn(487);
        boolean bl4 = this.isOn(492);
        boolean bl5 = this.isOn(493);
        boolean bl6 = this.isOn(4442);
        boolean bl7 = this.isOn(463);
        if (bl2) {
            this.bluetooth = new BluetoothApplication(this.framework, bundleContext, this);
            this.bluetooth.init();
        }
        if (bl3) {
            this.data = new DataApplication(this.framework, bundleContext, this);
            this.data.init();
        }
        if (bl4) {
            this.wlan = new WlanApplication(this.framework, bundleContext, this);
            this.wlan.init();
        }
        if (bl2) {
            this.coma = new ConnectivityManager(this.framework, bundleContext, this, bl && (bl6 || bl7), bl3 && (bl6 || bl7), bl6, bl5);
            this.coma.init();
        }
        if (bl2) {
            this.obex = new ObexApplication(this.framework, bundleContext, this);
            this.obex.init();
        }
        ConnectivityActionProxyImpl connectivityActionProxyImpl = new ConnectivityActionProxyImpl(this.bluetooth, this.wlan, this.data, this.coma, this.framework.getHmiServiceApp());
        Hashtable hashtable = new Hashtable(1);
        hashtable.put("moduleID", new Integer(26));
        this.registerService((class$de$audi$atip$statemachine$ActionProxy == null ? (class$de$audi$atip$statemachine$ActionProxy = Activator.class$("de.audi.atip.statemachine.ActionProxy")) : class$de$audi$atip$statemachine$ActionProxy).getName(), (Object)connectivityActionProxyImpl, (Dictionary)hashtable);
        ConnectivityHMIApplicationImpl connectivityHMIApplicationImpl = new ConnectivityHMIApplicationImpl(this.data);
        this.registerService((class$de$audi$atip$hmi$HMIApplication == null ? (class$de$audi$atip$hmi$HMIApplication = Activator.class$("de.audi.atip.hmi.HMIApplication")) : class$de$audi$atip$hmi$HMIApplication).getName(), (Object)connectivityHMIApplicationImpl, null);
    }

    private boolean isOn(int n, int n2) {
        return this.framework.getSysConst(n) == n2;
    }

    private boolean isOn(int n) {
        return this.isOn(n, 1);
    }

    @Override
    public void stop(BundleContext bundleContext) {
        if (this.coma != null) {
            this.coma.deinit();
            this.coma = null;
        }
        if (this.bluetooth != null) {
            this.bluetooth.deinit();
            this.bluetooth = null;
        }
        if (this.data != null) {
            this.data.deinit();
            this.data = null;
        }
        if (this.wlan != null) {
            this.wlan.deinit();
            this.wlan = null;
        }
        if (this.obex != null) {
            this.obex.deinit();
            this.obex = null;
        }
        super.stop(bundleContext);
    }

    @Override
    public IEvoBluetoothApplication getBluetooth() {
        return this.bluetooth;
    }

    @Override
    public IConnectivityManager getConnectivityManager() {
        return this.coma;
    }

    @Override
    public IDataApplication getData() {
        return this.data;
    }

    @Override
    public IEvoWlanApplication getWlan() {
        return this.wlan;
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

