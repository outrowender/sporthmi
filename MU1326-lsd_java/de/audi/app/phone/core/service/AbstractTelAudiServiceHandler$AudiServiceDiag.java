/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.mib.swdiagnosis.phone.IPhoneDiagComponent
 */
package de.audi.app.phone.core.service;

import de.audi.app.phone.core.service.AbstractTelAudiServiceHandler;
import de.audi.app.phone.core.service.AbstractTelAudiServiceHandler$1;
import de.mib.swdiagnosis.phone.IPhoneDiagComponent;
import org.dsi.ifc.telephoneng.ServiceNumbers;

class AbstractTelAudiServiceHandler$AudiServiceDiag
implements IPhoneDiagComponent {
    private String infoNumberNational = "";
    private String infoNumberInternational = "";
    private String breakdownNumberNational = "";
    private String breakdownNumberInternational = "";
    private final /* synthetic */ AbstractTelAudiServiceHandler this$0;

    private AbstractTelAudiServiceHandler$AudiServiceDiag(AbstractTelAudiServiceHandler abstractTelAudiServiceHandler) {
        this.this$0 = abstractTelAudiServiceHandler;
    }

    public void cmdSetInfoNational(String string) {
        this.infoNumberNational = string;
    }

    public void cmdSetInfoInternational(String string) {
        this.infoNumberInternational = string;
    }

    public void cmdSetBreakdownNational(String string) {
        this.breakdownNumberNational = string;
    }

    public void cmdSetBreakdownInternational(String string) {
        this.breakdownNumberInternational = string;
    }

    public void cmdUpdateServiceNumbers() {
        AbstractTelAudiServiceHandler.access$100(this.this$0, new ServiceNumbers(this.infoNumberNational, this.infoNumberInternational, this.breakdownNumberNational, this.breakdownNumberInternational));
    }

    /* synthetic */ AbstractTelAudiServiceHandler$AudiServiceDiag(AbstractTelAudiServiceHandler abstractTelAudiServiceHandler, AbstractTelAudiServiceHandler$1 abstractTelAudiServiceHandler$1) {
        this(abstractTelAudiServiceHandler);
    }
}

