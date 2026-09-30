/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.addressbook;

import de.audi.app.addressbook.AbstractAddressBookActivator;
import de.audi.app.addressbook.core.main.AbstractAddressBookApplication;
import de.audi.app.addressbook.evo.main.AddressBookEvoActionProxyImpl;
import de.audi.app.addressbook.evo.main.AddressBookEvoApplication;
import de.audi.app.addressbook.evo.main.AddressBookEvoRemoteHMIServiceImpl;
import de.audi.app.addressbook.evo.main.preset.AddressBookEvoPresetHandler;
import de.audi.atip.base.IFrameworkAccess;
import java.util.Dictionary;
import org.osgi.framework.BundleContext;

public class AddressBookActivator
extends AbstractAddressBookActivator {
    static /* synthetic */ Class class$de$audi$atip$statemachine$ActionProxy;
    static /* synthetic */ Class class$de$audi$atip$interapp$ADBRemoteHMIService;
    static /* synthetic */ Class class$de$audi$atip$preset$IAppPresetDefinitionHandler;

    public void start(BundleContext bundleContext) {
        super.start(bundleContext);
        ((AddressBookEvoApplication)this.appAdr).init(bundleContext);
    }

    public void stop(BundleContext bundleContext) {
        ((AddressBookEvoApplication)this.appAdr).deinit(this.bundleContext);
        super.stop(bundleContext);
    }

    protected void registerServices() {
        super.registerServices();
        AddressBookEvoActionProxyImpl addressBookEvoActionProxyImpl = new AddressBookEvoActionProxyImpl(this.log, this.appAdr);
        this.registerService((class$de$audi$atip$statemachine$ActionProxy == null ? (class$de$audi$atip$statemachine$ActionProxy = AddressBookActivator.class$("de.audi.atip.statemachine.ActionProxy")) : class$de$audi$atip$statemachine$ActionProxy).getName(), (Object)addressBookEvoActionProxyImpl, (Dictionary)AddressBookActivator.createActionProxyServiceProperties(0));
        AddressBookEvoRemoteHMIServiceImpl addressBookEvoRemoteHMIServiceImpl = new AddressBookEvoRemoteHMIServiceImpl((AddressBookEvoApplication)this.appAdr);
        this.registerService((class$de$audi$atip$interapp$ADBRemoteHMIService == null ? (class$de$audi$atip$interapp$ADBRemoteHMIService = AddressBookActivator.class$("de.audi.atip.interapp.ADBRemoteHMIService")) : class$de$audi$atip$interapp$ADBRemoteHMIService).getName(), (Object)addressBookEvoRemoteHMIServiceImpl, (Dictionary)AddressBookActivator.createServiceProperties());
        AddressBookEvoPresetHandler addressBookEvoPresetHandler = new AddressBookEvoPresetHandler((AddressBookEvoApplication)this.appAdr, this.log);
        this.registerService((class$de$audi$atip$preset$IAppPresetDefinitionHandler == null ? (class$de$audi$atip$preset$IAppPresetDefinitionHandler = AddressBookActivator.class$("de.audi.atip.preset.IAppPresetDefinitionHandler")) : class$de$audi$atip$preset$IAppPresetDefinitionHandler).getName(), (Object)addressBookEvoPresetHandler, (Dictionary)AddressBookActivator.createServiceProperties());
    }

    protected AbstractAddressBookApplication createAddressBookApplication(IFrameworkAccess iFrameworkAccess) {
        return new AddressBookEvoApplication(iFrameworkAccess);
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

