/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.interapp;

import de.audi.app.phone.core.AbstractPhoneComponent;
import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.PhoneServiceProvider;
import de.audi.app.phone.core.interapp.TelServiceConnectivityImpl$1;
import de.audi.app.phone.core.interapp.TelServiceConnectivityImpl$2;
import de.audi.app.phone.core.interapp.TelServiceConnectivityImpl$3;
import de.audi.app.phone.core.interapp.TelServiceConnectivityImpl$4;
import de.audi.app.phone.core.state.IGlobalTelephoneStateListener;
import de.audi.app.phone.core.state.IGlobalTelephoneStateStruct;
import de.audi.atip.log.LogChannel;
import de.audi.atip.phone.ITelServiceConnectivity;
import de.audi.atip.phone.ITelServiceConnectivityListener;
import java.util.Hashtable;

public class TelServiceConnectivityImpl
extends AbstractPhoneComponent
implements ITelServiceConnectivity {
    private volatile PhoneServiceProvider telServiceConnectivityServiceProvider;
    private volatile int telPhoneModuleState = 6;
    private final int[] attributes = new int[]{0x3000400, 0xD000400, 0x3000100, 0x3000300, 0x3000200};
    static /* synthetic */ Class class$de$audi$atip$phone$ITelServiceConnectivity;

    public TelServiceConnectivityImpl(ITelApplication iTelApplication) {
        super(iTelApplication, "App.Phone.Main");
    }

    @Override
    public void init() {
        Hashtable hashtable = new Hashtable();
        hashtable.put("ApplicationName", "AppPhone");
        this.getApplication().getGlobalTelephoneStateManager().registerListenerForSpecificAttributeUpdate(this.attributes, (IGlobalTelephoneStateListener)this);
        this.telServiceConnectivityServiceProvider = new PhoneServiceProvider((class$de$audi$atip$phone$ITelServiceConnectivity == null ? (class$de$audi$atip$phone$ITelServiceConnectivity = TelServiceConnectivityImpl.class$("de.audi.atip.phone.ITelServiceConnectivity")) : class$de$audi$atip$phone$ITelServiceConnectivity).getName(), this, hashtable, this.getApplication().getBundleContext(), this.log);
        this.telServiceConnectivityServiceProvider.startService();
    }

    @Override
    public void deinit() {
        if (this.telServiceConnectivityServiceProvider != null) {
            this.telServiceConnectivityServiceProvider.stopService();
            this.telServiceConnectivityServiceProvider = null;
        }
        this.getApplication().getGlobalTelephoneStateManager().removeListener(this);
    }

    @Override
    public void updateGlobalTelephoneStateProperty(int n, IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct) {
        if (n == 0xD000400 || n == 0x3000100 || n == 0x3000300 || n == 0x3000200 || n == 0x3000400) {
            int n2 = iGlobalTelephoneStateStruct.getPhoneModuleState();
            if (n2 == this.telPhoneModuleState) {
                return;
            }
            if (n2 == 2) {
                this.log.log(1078071040, "[TelServiceConnectivityImpl#updateGlobalTelephoneStateProperty] telPhoneModuleState is ON .");
                this.getApplication().getFrameworkAccess().getMsgDistrib().sendMessage(208);
            } else if (n2 == 3) {
                this.log.log(1078071040, "[TelServiceConnectivityImpl#updateGlobalTelephoneStateProperty] telPhoneModuleState is OFF.");
                this.getApplication().getFrameworkAccess().getMsgDistrib().sendMessage(209);
            } else if (n2 == 6 || n2 == 7 || n2 == 8 || n2 == 5) {
                this.log.log(1078071040, "[TelServiceConnectivityImpl#updateGlobalTelephoneStateProperty] telPhoneModuleState is currently switching powerstate.");
                this.getApplication().getFrameworkAccess().getMsgDistrib().sendMessage(210);
            }
            this.telPhoneModuleState = n2;
        }
    }

    @Override
    public void setNadMode(int n, ITelServiceConnectivityListener iTelServiceConnectivityListener) {
        this.getApplication().enqueueEvent(new TelServiceConnectivityImpl$1(this, "TelServiceConnectivityImpl#setNadMode", iTelServiceConnectivityListener, n));
    }

    @Override
    public void changePhoneModulePowerState(boolean bl, ITelServiceConnectivityListener iTelServiceConnectivityListener) {
        this.getApplication().enqueueEvent(new TelServiceConnectivityImpl$2(this, "TelServiceConnectivityImpl#changePhoneModulePowerState", bl, iTelServiceConnectivityListener));
    }

    @Override
    public void togglePhones(ITelServiceConnectivityListener iTelServiceConnectivityListener) {
        this.getApplication().enqueueEvent(new TelServiceConnectivityImpl$3(this, "TelServiceConnectivityImpl#togglePhones", iTelServiceConnectivityListener));
    }

    @Override
    public void setNadRole(int n, ITelServiceConnectivityListener iTelServiceConnectivityListener) {
        this.getApplication().enqueueEvent(new TelServiceConnectivityImpl$4(this, "TelServiceConnectivityImpl#setNadRole", iTelServiceConnectivityListener, n));
    }

    @Override
    public void requestCurrentNadModulePowerState() {
        this.log.log(-2137614336, "TelServiceConnectivityImpl#isNADModuleActivated: telPhoneModuleState is %1", (long)this.telPhoneModuleState);
        if (this.telPhoneModuleState == 2) {
            this.log.log(1078071040, "[TelServiceConnectivityImpl#updateGlobalTelephoneStateProperty] telPhoneModuleState is ON .");
            this.getApplication().getFrameworkAccess().getMsgDistrib().sendMessage(208);
        } else if (this.telPhoneModuleState == 3) {
            this.log.log(1078071040, "[TelServiceConnectivityImpl#updateGlobalTelephoneStateProperty] telPhoneModuleState is OFF.");
            this.getApplication().getFrameworkAccess().getMsgDistrib().sendMessage(209);
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

    static /* synthetic */ LogChannel access$000(TelServiceConnectivityImpl telServiceConnectivityImpl) {
        return telServiceConnectivityImpl.log;
    }

    static /* synthetic */ ITelApplication access$100(TelServiceConnectivityImpl telServiceConnectivityImpl) {
        return telServiceConnectivityImpl.getApplication();
    }

    static /* synthetic */ LogChannel access$200(TelServiceConnectivityImpl telServiceConnectivityImpl) {
        return telServiceConnectivityImpl.log;
    }

    static /* synthetic */ ITelApplication access$300(TelServiceConnectivityImpl telServiceConnectivityImpl) {
        return telServiceConnectivityImpl.getApplication();
    }

    static /* synthetic */ LogChannel access$400(TelServiceConnectivityImpl telServiceConnectivityImpl) {
        return telServiceConnectivityImpl.log;
    }

    static /* synthetic */ ITelApplication access$600(TelServiceConnectivityImpl telServiceConnectivityImpl) {
        return telServiceConnectivityImpl.getApplication();
    }

    static /* synthetic */ LogChannel access$700(TelServiceConnectivityImpl telServiceConnectivityImpl) {
        return telServiceConnectivityImpl.log;
    }

    static /* synthetic */ ITelApplication access$900(TelServiceConnectivityImpl telServiceConnectivityImpl) {
        return telServiceConnectivityImpl.getApplication();
    }
}

