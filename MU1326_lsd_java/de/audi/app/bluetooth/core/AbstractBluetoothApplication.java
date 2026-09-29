/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.mib.swdiagnosis.connectivity.ConnectivityDiag
 */
package de.audi.app.bluetooth.core;

import de.audi.app.bluetooth.core.BluetoothDSIListener;
import de.audi.app.bluetooth.core.IBluetoothApplication;
import de.audi.app.bluetooth.core.interapp.BluetoothA2LSService;
import de.audi.app.bluetooth.core.interapp.BluetoothService;
import de.audi.app.bluetooth.core.interapp.EcallBluetoothServiceImpl;
import de.audi.app.bluetooth.core.interapp.IMediaBluetoothStateProvider;
import de.audi.app.bluetooth.core.interapp.MediaBluetoothStateProvider;
import de.audi.app.connectivity.core.AbstractApplication;
import de.audi.app.connectivity.core.IConnectivity;
import de.audi.app.connectivity.core.common.IClampStateProvider;
import de.audi.app.connectivity.core.common.PhoneProxy;
import de.audi.atip.base.IFrameworkAccess;
import de.mib.swdiagnosis.connectivity.ConnectivityDiag;
import java.util.Dictionary;
import java.util.Hashtable;
import org.osgi.framework.BundleContext;

public abstract class AbstractBluetoothApplication
extends AbstractApplication
implements IBluetoothApplication {
    private final BluetoothDSIListener bluetoothDsiListener;
    private final IConnectivity connectivity;
    private final MediaBluetoothStateProvider mediaBluetoothStateProvider;
    static /* synthetic */ Class class$org$dsi$ifc$bluetooth$DSIBluetoothListener;
    static /* synthetic */ Class class$org$dsi$ifc$base$DSIListener;
    static /* synthetic */ Class class$org$dsi$ifc$bluetooth$DSIBluetooth;

    protected AbstractBluetoothApplication(IFrameworkAccess iFrameworkAccess, BundleContext bundleContext, IConnectivity iConnectivity) {
        super(iFrameworkAccess, bundleContext, "App.Bluetooth.Main", "App.Bluetooth.Commands", "AppBluetooth");
        this.log.log(-2137614336, "AbstractBluetoothApplication#AbstractBluetoothApplication(): BluetoothApplication created.");
        this.bluetoothDsiListener = new BluetoothDSIListener(this.commandListManager, this.log);
        this.connectivity = iConnectivity;
        this.mediaBluetoothStateProvider = new MediaBluetoothStateProvider(this);
        this.addComponent(this.mediaBluetoothStateProvider);
        this.addComponent(new BluetoothService(this));
        this.addComponent(new BluetoothA2LSService(this));
        this.addComponent(new EcallBluetoothServiceImpl(this));
    }

    @Override
    public IMediaBluetoothStateProvider getMediaBluetoothStateProvider() {
        return this.mediaBluetoothStateProvider;
    }

    @Override
    protected final void registerDSIListener() {
        Hashtable hashtable = new Hashtable();
        hashtable.put("DEVICE_NAME", (class$org$dsi$ifc$bluetooth$DSIBluetoothListener == null ? (class$org$dsi$ifc$bluetooth$DSIBluetoothListener = AbstractBluetoothApplication.class$("org.dsi.ifc.bluetooth.DSIBluetoothListener")) : class$org$dsi$ifc$bluetooth$DSIBluetoothListener).getName());
        hashtable.put("DEVICE_INSTANCE", new Integer(0));
        this.getBundleContext().registerService((class$org$dsi$ifc$base$DSIListener == null ? (class$org$dsi$ifc$base$DSIListener = AbstractBluetoothApplication.class$("org.dsi.ifc.base.DSIListener")) : class$org$dsi$ifc$base$DSIListener).getName(), (Object)this.bluetoothDsiListener, (Dictionary)hashtable);
    }

    @Override
    protected final void startDSI() {
        this.framework.startDSIService((class$org$dsi$ifc$bluetooth$DSIBluetooth == null ? (class$org$dsi$ifc$bluetooth$DSIBluetooth = AbstractBluetoothApplication.class$("org.dsi.ifc.bluetooth.DSIBluetooth")) : class$org$dsi$ifc$bluetooth$DSIBluetooth).getName(), 0);
    }

    @Override
    public ConnectivityDiag getDiag() {
        return this.connectivity.getDiagnosis();
    }

    @Override
    public PhoneProxy getPhone() {
        return this.connectivity.getPhone();
    }

    @Override
    public IClampStateProvider getClampStateProvider() {
        return this.connectivity.getClampStateProvider();
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

