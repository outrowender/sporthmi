/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.mib.swdiagnosis.phone.IPhoneDiagComponent
 */
package de.audi.app.phone.core.battery;

import de.audi.app.phone.core.battery.AbstractTelBatteryHandler;
import de.mib.swdiagnosis.phone.IPhoneDiagComponent;

public class AbstractTelBatteryHandler$TelBatteryDiag
implements IPhoneDiagComponent {
    private final /* synthetic */ AbstractTelBatteryHandler this$0;

    public AbstractTelBatteryHandler$TelBatteryDiag(AbstractTelBatteryHandler abstractTelBatteryHandler) {
        this.this$0 = abstractTelBatteryHandler;
    }

    public void cmdSetBatteryLevel(String string, String string2, int n, String string3) {
        this.this$0.handleBatteryChargeLevel(string, string2, n);
    }
}

