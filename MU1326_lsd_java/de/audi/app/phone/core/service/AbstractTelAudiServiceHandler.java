/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.service;

import de.audi.app.phone.core.AbstractPhoneComponent;
import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.service.AbstractTelAudiServiceHandler$AudiServiceDiag;
import de.audi.app.phone.core.state.IGlobalTelephoneStateStruct;
import de.audi.atip.hmi.model.ButtonListener;
import org.dsi.ifc.telephoneng.RegisterStateStruct;
import org.dsi.ifc.telephoneng.ServiceNumbers;

public abstract class AbstractTelAudiServiceHandler
extends AbstractPhoneComponent
implements ButtonListener {
    protected static final int NO_SERVICE_AVAILABLE;
    protected static final int INFO_NUMBERS_AVAILABLE;
    protected static final int BREAKDOWN_NUMBERS_AVAILABLE;
    protected static final int INFO_BREAKDOWN_NUMBERS_AVAILABLE;
    protected volatile ServiceNumbers serviceNumbers;
    private volatile boolean roaming;
    private volatile int serviceNumberAvailability;

    public AbstractTelAudiServiceHandler(ITelApplication iTelApplication) {
        super(iTelApplication, "App.Phone.Main");
    }

    @Override
    public void init() {
        this.getApplication().getGlobalTelephoneStateManager().registerListener(this);
        this.getApplication().addDiagnosisComponent(new AbstractTelAudiServiceHandler$AudiServiceDiag(this, null));
        this.getButtonModel(1368785920).setButtonListener(this);
        this.getButtonModel(1385563136).setButtonListener(this);
    }

    @Override
    public void deinit() {
        this.getApplication().getGlobalTelephoneStateManager().removeListener(this);
    }

    @Override
    public void updateGlobalTelephoneStateProperty(int n, IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct) {
        RegisterStateStruct registerStateStruct;
        if (n == 0xB000400) {
            this.setServiceNumbers(iGlobalTelephoneStateStruct.getServiceNumbers());
        } else if (n == 0x16000100 && (registerStateStruct = iGlobalTelephoneStateStruct.getRegisterState()) != null) {
            this.roaming = registerStateStruct.getTelRegisterState() == 2;
        }
    }

    private void setServiceNumbers(ServiceNumbers serviceNumbers) {
        boolean bl;
        this.log.log(-2137614336, "[AbstractTelAudiServiceHandler#setServiceNumbers] serviceNumbers=%1", (Object)serviceNumbers);
        this.serviceNumbers = serviceNumbers;
        boolean bl2 = this.isInfoNumberAvailable(serviceNumbers);
        boolean bl3 = this.isBreakdownNumberAvailable(serviceNumbers);
        boolean bl4 = bl = bl2 && bl3;
        if (bl) {
            this.log.log(1078071040, "[AbstractTelAudiServiceHandler#setServiceNumbers] both info and breakdown numbers available.");
            this.setServiceAvailability(3);
        } else if (bl2) {
            this.log.log(1078071040, "[AbstractTelAudiServiceHandler#setServiceNumbers] only info numbers available.");
            this.setServiceAvailability(1);
        } else if (bl3) {
            this.log.log(1078071040, "[AbstractTelAudiServiceHandler#setServiceNumbers] only breakdown numbers available.");
            this.setServiceAvailability(2);
        } else {
            this.log.log(1078071040, "[AbstractTelAudiServiceHandler#setServiceNumbers] no service numbers available.");
            this.setServiceAvailability(0);
        }
    }

    private boolean isInfoNumberAvailable(ServiceNumbers serviceNumbers) {
        if (serviceNumbers != null) {
            String string = serviceNumbers.getInfonumber();
            String string2 = serviceNumbers.getInfonumberRoaming();
            if (string != null && string.length() > 0 && string2 != null && string2.length() > 0) {
                return true;
            }
        }
        return false;
    }

    private boolean isBreakdownNumberAvailable(ServiceNumbers serviceNumbers) {
        if (serviceNumbers != null) {
            String string = serviceNumbers.getBreakdownNumber();
            String string2 = serviceNumbers.getBreakdownNumberRoaming();
            if (string != null && string.length() > 0 && string2 != null && string2.length() > 0) {
                return true;
            }
        }
        return false;
    }

    protected String getInfoNumber() {
        ServiceNumbers serviceNumbers = this.serviceNumbers;
        if (this.isInfoNumberAvailable(serviceNumbers)) {
            return this.roaming ? serviceNumbers.getInfonumberRoaming() : serviceNumbers.getInfonumber();
        }
        return null;
    }

    protected String getBreakdownNumber() {
        ServiceNumbers serviceNumbers = this.serviceNumbers;
        if (this.isBreakdownNumberAvailable(serviceNumbers)) {
            return this.roaming ? serviceNumbers.getBreakdownNumberRoaming() : serviceNumbers.getBreakdownNumber();
        }
        return null;
    }

    protected void setServiceAvailability(int n) {
        this.serviceNumberAvailability = n;
        this.updateServiceAvailability(n);
    }

    protected int getServiceNumberAvailability() {
        return this.serviceNumberAvailability;
    }

    protected void callInfoNumber(int n) {
        String string = this.getInfoNumber();
        if (string != null && string.length() > 0) {
            this.getApplication().getTelephoneDSIAccess().dialNumber(string, n);
        } else {
            this.log.log(-1601830656, "[AbstractTelAudiServiceHandler#callInfoNumber] no info number availble! NOP!");
        }
    }

    protected void callBreakdownNumber(int n) {
        String string = this.getBreakdownNumber();
        if (string != null && string.length() > 0) {
            this.getApplication().getTelephoneDSIAccess().dialNumber(string, n);
        } else {
            this.log.log(-1601830656, "[AbstractTelAudiServiceHandler#callInfoNumber] no breakdown number availble! NOP!");
        }
    }

    @Override
    public void keyPressed(int n, int n2, int n3) {
    }

    @Override
    public void keyReleased(int n, int n2, int n3) {
    }

    @Override
    public void keyTyped(int n, int n2, int n3) {
        if (this.log.isInfo()) {
            this.log.log(1078071040, "[AbstractTelAudiServiceHandler#keyTyped] modelID=%1, keyID=%2, terminalID=%3", (long)n, (long)n2, (long)n3);
        }
        if (n == 1368785920) {
            this.callInfoNumber(n3);
        } else if (n == 1385563136) {
            this.callBreakdownNumber(n3);
        }
    }

    @Override
    public void keyLongTyped(int n, int n2, int n3) {
    }

    protected abstract void updateServiceAvailability(int n) {
    }

    static /* synthetic */ void access$100(AbstractTelAudiServiceHandler abstractTelAudiServiceHandler, ServiceNumbers serviceNumbers) {
        abstractTelAudiServiceHandler.setServiceNumbers(serviceNumbers);
    }
}

