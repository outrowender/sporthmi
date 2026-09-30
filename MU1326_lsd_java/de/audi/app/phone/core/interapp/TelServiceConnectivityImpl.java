/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.interapp;

import de.audi.app.phone.core.AbstractPhoneComponent;
import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.PhoneServiceProvider;
import de.audi.app.phone.core.dsi.TelDefaultDSIResponseListener;
import de.audi.app.phone.core.event.AbstractTelInterappEvent;
import de.audi.app.phone.core.interapp.TelServiceConnectivityListenerWrapper;
import de.audi.app.phone.core.state.IGlobalTelephoneStateListener;
import de.audi.app.phone.core.state.IGlobalTelephoneStateStruct;
import de.audi.atip.phone.ITelServiceConnectivity;
import de.audi.atip.phone.ITelServiceConnectivityListener;
import java.util.Hashtable;

public class TelServiceConnectivityImpl
extends AbstractPhoneComponent
implements ITelServiceConnectivity {
    private volatile PhoneServiceProvider telServiceConnectivityServiceProvider;
    private volatile int telPhoneModuleState = 6;
    private final int[] attributes = new int[]{262147, 262157, 65539, 196611, 131075};
    static /* synthetic */ Class class$de$audi$atip$phone$ITelServiceConnectivity;

    public TelServiceConnectivityImpl(ITelApplication iTelApplication) {
        super(iTelApplication, "App.Phone.Main");
    }

    public void init() {
        Hashtable hashtable = new Hashtable();
        hashtable.put("ApplicationName", "AppPhone");
        this.getApplication().getGlobalTelephoneStateManager().registerListenerForSpecificAttributeUpdate(this.attributes, (IGlobalTelephoneStateListener)this);
        this.telServiceConnectivityServiceProvider = new PhoneServiceProvider((class$de$audi$atip$phone$ITelServiceConnectivity == null ? (class$de$audi$atip$phone$ITelServiceConnectivity = TelServiceConnectivityImpl.class$("de.audi.atip.phone.ITelServiceConnectivity")) : class$de$audi$atip$phone$ITelServiceConnectivity).getName(), this, hashtable, this.getApplication().getBundleContext(), this.log);
        this.telServiceConnectivityServiceProvider.startService();
    }

    public void deinit() {
        if (this.telServiceConnectivityServiceProvider != null) {
            this.telServiceConnectivityServiceProvider.stopService();
            this.telServiceConnectivityServiceProvider = null;
        }
        this.getApplication().getGlobalTelephoneStateManager().removeListener(this);
    }

    public void updateGlobalTelephoneStateProperty(int n, IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct) {
        if (n == 262157 || n == 65539 || n == 196611 || n == 131075 || n == 262147) {
            int n2 = iGlobalTelephoneStateStruct.getPhoneModuleState();
            if (n2 == this.telPhoneModuleState) {
                return;
            }
            if (n2 == 2) {
                this.log.log(1000000, "[TelServiceConnectivityImpl#updateGlobalTelephoneStateProperty] telPhoneModuleState is ON .");
                this.getApplication().getFrameworkAccess().getMsgDistrib().sendMessage(208);
            } else if (n2 == 3) {
                this.log.log(1000000, "[TelServiceConnectivityImpl#updateGlobalTelephoneStateProperty] telPhoneModuleState is OFF.");
                this.getApplication().getFrameworkAccess().getMsgDistrib().sendMessage(209);
            } else if (n2 == 6 || n2 == 7 || n2 == 8 || n2 == 5) {
                this.log.log(1000000, "[TelServiceConnectivityImpl#updateGlobalTelephoneStateProperty] telPhoneModuleState is currently switching powerstate.");
                this.getApplication().getFrameworkAccess().getMsgDistrib().sendMessage(210);
            }
            this.telPhoneModuleState = n2;
        }
    }

    public void setNadMode(final int n, final ITelServiceConnectivityListener iTelServiceConnectivityListener) {
        this.getApplication().enqueueEvent(new AbstractTelInterappEvent("TelServiceConnectivityImpl#setNadMode"){

            public void run() {
                TelServiceConnectivityImpl.this.log.log(1000000, "[TelServiceConnectivityImpl#setNadMode] nadMode%2, listener=%1", (Object)iTelServiceConnectivityListener, (long)n);
                TelServiceConnectivityImpl.this.getApplication().getTelephoneDSIAccess().requestSetNadMode(n, 0, true, iTelServiceConnectivityListener != null ? new TelServiceConnectivityListenerWrapper(iTelServiceConnectivityListener) : null);
            }
        });
    }

    public void changePhoneModulePowerState(final boolean bl, final ITelServiceConnectivityListener iTelServiceConnectivityListener) {
        this.getApplication().enqueueEvent(new AbstractTelInterappEvent("TelServiceConnectivityImpl#changePhoneModulePowerState"){

            public void run() {
                TelServiceConnectivityImpl.this.log.log(1000000, "[TelServiceConnectivityImpl#changePhoneModulePowerState] stateOn=%1, listener=%2", (Object)String.valueOf(bl), (Object)iTelServiceConnectivityListener);
                int n = bl ? 1 : 0;
                TelServiceConnectivityImpl.this.getApplication().getTelephoneDSIAccess().requestTelPower(n, 0, true, iTelServiceConnectivityListener != null ? new TelServiceConnectivityListenerWrapper(iTelServiceConnectivityListener) : null);
            }
        });
    }

    public void togglePhones(final ITelServiceConnectivityListener iTelServiceConnectivityListener) {
        this.getApplication().enqueueEvent(new AbstractTelInterappEvent("TelServiceConnectivityImpl#togglePhones"){

            public void run() {
                TelServiceConnectivityImpl.this.log.log(1000000, "[TelServiceConnectivityImpl#togglePhones] listener=%1", (Object)iTelServiceConnectivityListener);
                TelServiceConnectivityImpl.this.getApplication().getTelephoneDSIAccess().togglePhones(0, true, new TelDefaultDSIResponseListener(){

                    public void responseChangeTopology(int n, int n2) {
                        if (iTelServiceConnectivityListener != null) {
                            iTelServiceConnectivityListener.responseTogglePhones(n);
                        }
                    }
                });
            }
        });
    }

    public void setNadRole(final int n, final ITelServiceConnectivityListener iTelServiceConnectivityListener) {
        this.getApplication().enqueueEvent(new AbstractTelInterappEvent("TelServiceConnectivityImpl#setNadRole"){

            public void run() {
                TelServiceConnectivityImpl.this.log.log(1000000, "[TelServiceConnectivityImpl#setNadRole] nadRole=%2, listener=%1", (Object)iTelServiceConnectivityListener, (long)n);
                TelServiceConnectivityImpl.this.getApplication().getTelephoneDSIAccess().requestSetNadRole(0, n, new TelDefaultDSIResponseListener(){

                    public void responseChangeTopology(int n, int n2) {
                        if (iTelServiceConnectivityListener != null) {
                            iTelServiceConnectivityListener.responseSetNadRole(n);
                        }
                    }
                });
            }
        });
    }

    public void requestCurrentNadModulePowerState() {
        this.log.log(10000000, "TelServiceConnectivityImpl#isNADModuleActivated: telPhoneModuleState is %1", (long)this.telPhoneModuleState);
        if (this.telPhoneModuleState == 2) {
            this.log.log(1000000, "[TelServiceConnectivityImpl#updateGlobalTelephoneStateProperty] telPhoneModuleState is ON .");
            this.getApplication().getFrameworkAccess().getMsgDistrib().sendMessage(208);
        } else if (this.telPhoneModuleState == 3) {
            this.log.log(1000000, "[TelServiceConnectivityImpl#updateGlobalTelephoneStateProperty] telPhoneModuleState is OFF.");
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
}

