/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.mib.swdiagnosis.ecall.IEcallDiagnosisComponent
 */
package de.audi.app.ecall.core.car;

import de.audi.app.ecall.core.car.BreakdownCallCarPositionHandler;
import de.audi.app.ecall.core.car.BreakdownCallCarPositionHandler$1;
import de.mib.swdiagnosis.ecall.IEcallDiagnosisComponent;

class BreakdownCallCarPositionHandler$EcallCurrentPositionDiagnosisComponent
implements IEcallDiagnosisComponent {
    private final /* synthetic */ BreakdownCallCarPositionHandler this$0;

    private BreakdownCallCarPositionHandler$EcallCurrentPositionDiagnosisComponent(BreakdownCallCarPositionHandler breakdownCallCarPositionHandler) {
        this.this$0 = breakdownCallCarPositionHandler;
    }

    public void cmdUpdateGeoPosition(int n, int n2) {
        this.this$0.updateVehiclePosition(n, n2, true);
    }

    public void cmdSetStreetAndCityForCurrentPosition(String string, String string2) {
        this.this$0.updateVehiclePositionDescription(null, string2, null, string, null, true);
    }

    public void cmdSetCurrentPositionStr(String string) {
        BreakdownCallCarPositionHandler.access$100(this.this$0).setText(string);
    }

    /* synthetic */ BreakdownCallCarPositionHandler$EcallCurrentPositionDiagnosisComponent(BreakdownCallCarPositionHandler breakdownCallCarPositionHandler, BreakdownCallCarPositionHandler$1 breakdownCallCarPositionHandler$1) {
        this(breakdownCallCarPositionHandler);
    }
}

