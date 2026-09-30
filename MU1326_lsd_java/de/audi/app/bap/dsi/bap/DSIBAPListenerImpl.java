/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bap.dsi.bap;

import de.audi.app.bap.AbstractBAPApplication;
import de.audi.app.bap.fw.AbstractBAPModule;
import de.audi.app.bap.fw.indication.IBAPIndicationListener;
import de.audi.app.bap.utils.AcknowledgeTypes;
import de.audi.app.bap.utils.DataTypes;
import de.audi.app.bap.utils.ErrorCodes;
import de.audi.app.bap.utils.FunctionIDs;
import de.audi.app.bap.utils.IndicationTypes;
import de.audi.app.bap.utils.LSGIDs;
import de.audi.atip.log.LogChannel;
import org.dsi.ifc.bap.DSIBAPListener;

public final class DSIBAPListenerImpl
implements DSIBAPListener {
    private final AbstractBAPApplication bapApplication;
    private final LogChannel dsiLogChannel;

    public DSIBAPListenerImpl(AbstractBAPApplication abstractBAPApplication) {
        this.bapApplication = abstractBAPApplication;
        this.dsiLogChannel = abstractBAPApplication.getLogger().getDSILog();
    }

    public void asyncException(int n, String string, int n2) {
        this.dsiLogChannel.log(100000000, "[DSIBAPListenerImpl#asyncException] errorCode: %1, errorMsg: %2, requestType: %3", (Object)string, (long)n, (long)n2);
    }

    public void acknowledge(int n, int n2, int n3) {
        AbstractBAPModule abstractBAPModule = this.bapApplication.getModule(n);
        if (abstractBAPModule != null) {
            this.dsiLogChannel.log(100000000, "[DSIBAPListenerImpl#acknowledge] lsgID: %1, fctID: %2, acknowledgeType: %3", (Object)LSGIDs.getDescription(n), (Object)FunctionIDs.getDescription(n, n2), (Object)AcknowledgeTypes.getDescription(n3));
            IBAPIndicationListener iBAPIndicationListener = abstractBAPModule.getIndicationListener();
            if (iBAPIndicationListener == null) {
                this.dsiLogChannel.log(10000, "[DSIBAPListenerImpl#acknowledge] acknowledge could not be processed. No indication handler available for lsgID=%1", (Object)LSGIDs.getDescription(n));
            } else {
                iBAPIndicationListener.processAcknowledge(n2, n3);
            }
        } else {
            this.dsiLogChannel.log(100000000, "[DSIBAPListenerImpl#acknowledge] lsgID=%1 not supported by application", (Object)LSGIDs.getDescription(n));
        }
    }

    public void bapStateStatus(int n, int n2) {
        AbstractBAPModule abstractBAPModule = this.bapApplication.getModule(n);
        if (abstractBAPModule != null) {
            this.dsiLogChannel.log(100000000, "[DSIBAPListenerImpl#bapStateStatus] lsgID: %1, status: %2", (Object)LSGIDs.getDescription(n), (long)n2);
            this.bapApplication.processBAPStateStatus(n, n2);
        } else {
            this.dsiLogChannel.log(100000000, "[DSIBAPListenerImpl#bapStateStatus] lsgID: %1, status: %2 not supported by application", (Object)LSGIDs.getDescription(n), (long)n2);
        }
    }

    public void indication(int n, int n2, int n3, int n4, int n5) {
        AbstractBAPModule abstractBAPModule = this.bapApplication.getModule(n);
        if (abstractBAPModule != null) {
            this.dsiLogChannel.log(100000000, "[DSIBAPListenerImpl#indication] lsgID: %1, fctID: %2", (Object)LSGIDs.getDescription(n), (Object)FunctionIDs.getDescription(n, n2));
            this.dsiLogChannel.log(100000000, "[DSIBAPListenerImpl#indication] dataType: %1, indicationType: %2", (Object)DataTypes.getDescription(n3), (Object)IndicationTypes.getDescription(n4));
            this.dsiLogChannel.log(100000000, "[DSIBAPListenerImpl#indication] data: %1", (long)n5);
            IBAPIndicationListener iBAPIndicationListener = abstractBAPModule.getIndicationListener();
            if (iBAPIndicationListener == null) {
                this.dsiLogChannel.log(10000, "[DSIBAPListenerImpl#indication] indication could not be processed. No indication handler available for lsgID=%1", (Object)LSGIDs.getDescription(n));
            } else {
                iBAPIndicationListener.processIndication(n2, n3, n4, n5);
            }
        } else {
            this.dsiLogChannel.log(100000000, "[DSIBAPListenerImpl#indication] lsgID=%1 not supported by application", (Object)LSGIDs.getDescription(n));
        }
    }

    public void indicationByteSequence(int n, int n2, int n3, byte[] byArray) {
        AbstractBAPModule abstractBAPModule = this.bapApplication.getModule(n);
        if (abstractBAPModule != null) {
            this.dsiLogChannel.log(100000000, "[DSIBAPListenerImpl#indicationByteSequence] lsgID: %1, fctID: %2", (Object)LSGIDs.getDescription(n), (Object)FunctionIDs.getDescription(n, n2));
            this.dsiLogChannel.log(100000000, "[DSIBAPListenerImpl#indicationByteSequence] indicationType: %1", (Object)IndicationTypes.getDescription(n3));
            this.dsiLogChannel.log(100000000, "[DSIBAPListenerImpl#indicationByteSequence] data: %1", (Object)byArray);
            IBAPIndicationListener iBAPIndicationListener = abstractBAPModule.getIndicationListener();
            if (iBAPIndicationListener == null) {
                this.dsiLogChannel.log(10000, "[DSIBAPListenerImpl#indicationByteSequence] indication could not be processed. No indication handler available for lsgID=%1", (Object)LSGIDs.getDescription(n));
            } else {
                iBAPIndicationListener.processIndicationByteSequence(n2, n3, byArray);
            }
        } else {
            this.dsiLogChannel.log(100000000, "[DSIBAPListenerImpl#indicationByteSequence] lsgID=%1 not supported by application", (Object)LSGIDs.getDescription(n));
        }
    }

    public void indicationError(int n, int n2, int n3) {
        AbstractBAPModule abstractBAPModule = this.bapApplication.getModule(n);
        if (abstractBAPModule != null) {
            this.dsiLogChannel.log(100000000, "[DSIBAPListenerImpl#indicationError] lsgID: %1, fctID: %2, errorCode: %3", (Object)LSGIDs.getDescription(n), (Object)FunctionIDs.getDescription(n, n2), (Object)ErrorCodes.getDescription(n, n3));
            IBAPIndicationListener iBAPIndicationListener = abstractBAPModule.getIndicationListener();
            if (iBAPIndicationListener == null) {
                this.dsiLogChannel.log(10000, "[DSIBAPListenerImpl#indicationError] indication could not be processed. No indication handler available for lsgID=%1", (Object)LSGIDs.getDescription(n));
            } else {
                iBAPIndicationListener.processIndicationError(n2, n3);
            }
        } else {
            this.dsiLogChannel.log(100000000, "[DSIBAPListenerImpl#indicationError] lsgID=%1 not supported by application", (Object)LSGIDs.getDescription(n));
        }
    }

    public void indicationVoid(int n, int n2, int n3) {
        AbstractBAPModule abstractBAPModule = this.bapApplication.getModule(n);
        if (abstractBAPModule != null) {
            this.dsiLogChannel.log(100000000, "[DSIBAPListenerImpl#indicationVoid] lsgID: %1, fctID: %2", (Object)LSGIDs.getDescription(n), (Object)FunctionIDs.getDescription(n, n2));
            this.dsiLogChannel.log(100000000, "[DSIBAPListenerImpl#indicationVoid] indicationType: %1", (Object)IndicationTypes.getDescription(n3));
            IBAPIndicationListener iBAPIndicationListener = abstractBAPModule.getIndicationListener();
            if (iBAPIndicationListener == null) {
                this.dsiLogChannel.log(10000, "[DSIBAPListenerImpl#indicationVoid] indication could not be processed. No indication handler available for lsgID=%1", (Object)LSGIDs.getDescription(n));
            } else {
                iBAPIndicationListener.processIndicationVoid(n2, n3);
            }
        } else {
            this.dsiLogChannel.log(100000000, "[DSIBAPListenerImpl#indicationVoid] lsgID=%1 not supported by application", (Object)LSGIDs.getDescription(n));
        }
    }
}

