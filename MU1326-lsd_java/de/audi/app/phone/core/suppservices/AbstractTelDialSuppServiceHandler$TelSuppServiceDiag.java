/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.mib.swdiagnosis.phone.IPhoneDiagComponent
 */
package de.audi.app.phone.core.suppservices;

import de.audi.app.phone.core.suppservices.AbstractTelDialSuppServiceHandler;
import de.audi.app.phone.core.suppservices.AbstractTelDialSuppServiceHandler$1;
import de.esolutions.fw.util.commons.Buffer;
import de.mib.swdiagnosis.phone.IPhoneDiagComponent;

class AbstractTelDialSuppServiceHandler$TelSuppServiceDiag
implements IPhoneDiagComponent {
    private static final String CALLFORWARD_QUERY;
    private static final String CALLFORWARD_DEACTIVATE_ALL;
    private static final String CALLFORWARD_DELETE_ALL;
    private static final String CALLWAITING_ACTIVATE;
    private static final String CALLWAITING_DEACTIVATE;
    private static final String CALLWAITING_QUERY;
    private static final String CLIR_QUERY;
    private static final String CLIR_SEND_OWN_NUMBER;
    private static final String CLIR_DO_NOT_SEND_OWN_NUMBER;
    private final /* synthetic */ AbstractTelDialSuppServiceHandler this$0;

    private AbstractTelDialSuppServiceHandler$TelSuppServiceDiag(AbstractTelDialSuppServiceHandler abstractTelDialSuppServiceHandler) {
        this.this$0 = abstractTelDialSuppServiceHandler;
    }

    private String getCFActivate(String string) {
        Buffer buffer = new Buffer();
        buffer.append("**21*");
        buffer.append(string);
        buffer.append("#");
        return buffer.toString();
    }

    public void cmdDialCLIRSendOwnNumber(String string) {
        AbstractTelDialSuppServiceHandler.access$100(this.this$0).getTelephoneDSIAccess().dialNumber(new StringBuffer().append("*31#").append(string).toString(), 0);
    }

    public void cmdDialCLIRDoNotSendOwnNumber(String string) {
        AbstractTelDialSuppServiceHandler.access$200(this.this$0).getTelephoneDSIAccess().dialNumber(new StringBuffer().append("#31#").append(string).toString(), 0);
    }

    public void cmdDialCallFowardQuery() {
        AbstractTelDialSuppServiceHandler.access$300(this.this$0).getTelephoneDSIAccess().dialNumber("*#21#", 0);
    }

    public void cmdDialCallForwardRegistration(String string) {
        AbstractTelDialSuppServiceHandler.access$400(this.this$0).getTelephoneDSIAccess().dialNumber(this.getCFActivate(string), 0);
    }

    public void cmdDialCallFowardDeactivate() {
        AbstractTelDialSuppServiceHandler.access$500(this.this$0).getTelephoneDSIAccess().dialNumber("#002#", 0);
    }

    public void cmdDialCallFowardDelete() {
        AbstractTelDialSuppServiceHandler.access$600(this.this$0).getTelephoneDSIAccess().dialNumber("##002#", 0);
    }

    public void cmdDialCallWaitingActivate() {
        AbstractTelDialSuppServiceHandler.access$700(this.this$0).getTelephoneDSIAccess().dialNumber("*43#", 0);
    }

    public void cmdDialCallWaitingDeactivate() {
        AbstractTelDialSuppServiceHandler.access$800(this.this$0).getTelephoneDSIAccess().dialNumber("#43#", 0);
    }

    public void cmdDialCallWaitingQuery() {
        AbstractTelDialSuppServiceHandler.access$900(this.this$0).getTelephoneDSIAccess().dialNumber("*#43#", 0);
    }

    public void cmdDialCLIRQuery() {
        AbstractTelDialSuppServiceHandler.access$1000(this.this$0).getTelephoneDSIAccess().dialNumber("*#31#", 0);
    }

    public void cmdDialCLIRSendOwnNumber() {
        AbstractTelDialSuppServiceHandler.access$1100(this.this$0).getTelephoneDSIAccess().dialNumber("#31#", 0);
    }

    public void cmdDialCLIRDoNotSendOwnNumber() {
        AbstractTelDialSuppServiceHandler.access$1200(this.this$0).getTelephoneDSIAccess().dialNumber("*31#", 0);
    }

    /* synthetic */ AbstractTelDialSuppServiceHandler$TelSuppServiceDiag(AbstractTelDialSuppServiceHandler abstractTelDialSuppServiceHandler, AbstractTelDialSuppServiceHandler$1 abstractTelDialSuppServiceHandler$1) {
        this(abstractTelDialSuppServiceHandler);
    }
}

