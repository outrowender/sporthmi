/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.bap.telephone2;

import de.audi.app.phone.core.AbstractPhoneComponent;
import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.PhoneServiceProvider;
import de.audi.app.phone.core.bap.telephone2.BAPPropertyTel2LockState;
import de.audi.app.phone.core.bap.telephone2.BAPPropertyTel2MobileServiceSupport;
import de.audi.app.phone.core.bap.telephone2.BAPPropertyTel2NetworkProvider;
import de.audi.app.phone.core.bap.telephone2.BAPPropertyTel2PhoneModuleState;
import de.audi.app.phone.core.bap.telephone2.BAPPropertyTel2RegisterState;
import de.audi.app.phone.core.bap.telephone2.BAPPropertyTel2SignalQuality;
import de.audi.atip.interapp.combi.bap.phone.CombiBAPServicePhone2Listener;
import de.audi.atip.job.JobLogger;
import de.esolutions.fw.util.commons.job.DispatcherBase;

public class TelBAPManagerTel2
extends AbstractPhoneComponent
implements CombiBAPServicePhone2Listener {
    private volatile PhoneServiceProvider phoneServiceProvider;
    private final DispatcherBase bapCombiDispatcher;
    static /* synthetic */ Class class$de$audi$atip$interapp$combi$bap$phone$CombiBAPServicePhone2Listener;

    public TelBAPManagerTel2(ITelApplication iTelApplication, String string) {
        super(iTelApplication, string);
        JobLogger jobLogger = new JobLogger(iTelApplication.getFrameworkAccess().getLogChannel("App.Phone.BAP.CL"));
        this.bapCombiDispatcher = iTelApplication.getFrameworkAccess().getDispatcherManager().createDispatcher("TEL_2_BAP_COMBI_DISPATCHER", jobLogger);
        this.addSubPhoneComponent(new BAPPropertyTel2MobileServiceSupport(iTelApplication, this.bapCombiDispatcher));
        this.addSubPhoneComponent(new BAPPropertyTel2RegisterState(iTelApplication, this.bapCombiDispatcher));
        this.addSubPhoneComponent(new BAPPropertyTel2LockState(iTelApplication, this.bapCombiDispatcher));
        this.addSubPhoneComponent(new BAPPropertyTel2SignalQuality(iTelApplication, this.bapCombiDispatcher));
        this.addSubPhoneComponent(new BAPPropertyTel2NetworkProvider(iTelApplication, this.bapCombiDispatcher));
        this.addSubPhoneComponent(new BAPPropertyTel2PhoneModuleState(iTelApplication, this.bapCombiDispatcher));
    }

    @Override
    public void init() {
        super.init();
        this.bapCombiDispatcher.start();
        this.phoneServiceProvider = new PhoneServiceProvider((class$de$audi$atip$interapp$combi$bap$phone$CombiBAPServicePhone2Listener == null ? (class$de$audi$atip$interapp$combi$bap$phone$CombiBAPServicePhone2Listener = TelBAPManagerTel2.class$("de.audi.atip.interapp.combi.bap.phone.CombiBAPServicePhone2Listener")) : class$de$audi$atip$interapp$combi$bap$phone$CombiBAPServicePhone2Listener).getName(), this, null, this.getApplication().getBundleContext(), this.log);
        this.phoneServiceProvider.startService();
    }

    @Override
    public void deinit() {
        super.deinit();
        if (this.phoneServiceProvider != null) {
            this.phoneServiceProvider.stopService();
            this.phoneServiceProvider = null;
        }
        this.bapCombiDispatcher.stop();
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

