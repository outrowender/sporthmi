/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.errormanagement;

import de.audi.app.phone.core.AbstractPhoneComponent;
import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.state.IGlobalTelephoneStateStruct;
import de.esolutions.fw.util.commons.error.DumpInfoProvider;
import java.io.PrintStream;

public class TelDumpInfoProvider
extends AbstractPhoneComponent
implements DumpInfoProvider {
    private volatile IGlobalTelephoneStateStruct telephoneState;

    public TelDumpInfoProvider(ITelApplication iTelApplication) {
        super(iTelApplication, "App.Phone.Main");
    }

    public void init() {
        this.getApplication().getGlobalTelephoneStateManager().registerListener(this);
        this.getApplication().getFrameworkAccess().getErrorMgr().registerDumpInfoProvider(this);
    }

    public void deinit() {
        this.getApplication().getFrameworkAccess().getErrorMgr().unregisterDumpInfoProvider(this);
        this.getApplication().getGlobalTelephoneStateManager().removeListener(this);
    }

    public void updateGlobalTelephoneStateProperty(int n, IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct) {
        this.telephoneState = iGlobalTelephoneStateStruct;
    }

    public void dump(PrintStream printStream, String string) {
        printStream.print(this.telephoneState);
    }

    public String getName() {
        return "TelephoneState";
    }
}

