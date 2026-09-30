/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.combi.bap.app.phone;

import de.audi.app.combi.bap.app.phone.AbstractAppConnectorPhone;
import de.audi.app.combi.bap.app.phone.CombiModulePhone;
import de.audi.app.combi.bap.app.phone2.CombiModulePhone2;
import de.audi.atip.interapp.combi.bap.phone.CombiBAPServiceMessaging;
import de.vw.mib.bap.generated.telephone.serializer.MobileServiceSupport_Status;
import de.vw.mib.bap.generated.telephone.serializer.SMSState_Status;
import de.vw.mib.bap.generated.telephone2.serializer.EmailState_Status;

public class AppConnectorMessaging
extends AbstractAppConnectorPhone
implements CombiBAPServiceMessaging {
    public AppConnectorMessaging(CombiModulePhone combiModulePhone) {
        super(combiModulePhone);
    }

    public void updateMobileServiceSupport(boolean bl, boolean bl2) {
        this.logChannel.log(1000000, "[AppConnectorMessaging#updateMobileServiceSupport] smsStateSupported=%1, emailStateSupported=%2", bl, bl2);
        MobileServiceSupport_Status mobileServiceSupport_Status = this.getMobileServiceSupportStatusCopy();
        mobileServiceSupport_Status.fctList.fctSmsstateSupported = bl && this.moduleFsg.getFunctionList().isFunctionSupported(55);
        this.sendPropertyStatus(16, mobileServiceSupport_Status);
        CombiModulePhone2 combiModulePhone2 = ((CombiModulePhone)this.moduleFsg).getPhone2Module();
        if (combiModulePhone2 != null) {
            de.vw.mib.bap.generated.telephone2.serializer.MobileServiceSupport_Status mobileServiceSupport_Status2 = this.getMobileServiceSupport2StatusCopy();
            mobileServiceSupport_Status2.fctList.fctEmailStateSupported = bl2 && combiModulePhone2.getFunctionList().isFunctionSupported(22);
            this.sendPhone2PropertyStatus(16, mobileServiceSupport_Status2);
        }
    }

    public void updateSMSState(boolean bl, int n, int n2) {
        this.logChannel.log(1000000, "[AppConnectorMessaging#updateSMSState] simReady=%3, storageState=%1, numberOfNewSMS=%2", (long)n, (long)n2, bl);
        SMSState_Status sMSState_Status = new SMSState_Status();
        sMSState_Status.simready = bl ? 1 : 0;
        sMSState_Status.storageState = n;
        sMSState_Status.numberOfNewSms = n2;
        this.sendPropertyStatus(55, sMSState_Status);
    }

    public void updateEmailState(int n, int n2) {
        this.logChannel.log(1000000, "[AppConnectorMessaging#updateEmailState] storageState=%1, numberOfNewEmail=%2", (long)n, (long)n2);
        EmailState_Status emailState_Status = new EmailState_Status();
        emailState_Status.storageState = n;
        emailState_Status.numberOfNewEmail = n2;
        this.sendPhone2PropertyStatus(22, emailState_Status);
    }
}

