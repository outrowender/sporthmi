/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bap.fw.indication;

import de.audi.app.bap.fw.AbstractBAPModule;
import de.audi.app.bap.fw.functiontypes.IBAPFunction;
import de.audi.app.bap.fw.indication.BAPIndicationData;
import de.audi.app.bap.fw.indication.IBAPIndicationListener;
import de.audi.app.bap.utils.BAPDeserializer;
import de.audi.app.bap.utils.FunctionIDs;
import de.audi.app.bap.utils.LSGIDs;
import de.audi.atip.log.LogChannel;
import de.vw.mib.bap.datatypes.BAPEntity;

public abstract class AbstractBAPIndicationHandler
implements IBAPIndicationListener {
    protected final AbstractBAPModule module;
    protected final int lsgID;
    protected final LogChannel logChannel;

    public AbstractBAPIndicationHandler(AbstractBAPModule abstractBAPModule, LogChannel logChannel) {
        this.module = abstractBAPModule;
        this.lsgID = abstractBAPModule.getLSGID();
        this.logChannel = logChannel;
    }

    public void processAcknowledge(int n, int n2) {
        if (n2 == 20) {
            this.module.getInitializationManager().notifyHMIStateAcknowledged();
        } else if (!this.module.getFunctionList().isInRange(n)) {
            this.logChannel.log(10000, "[AbstractBAPIndicationHandler#processAcknowledge] invalid fctID (lsgID=%1, fctID=%2), out of range -> ignore indication", (Object)LSGIDs.getDescription(this.lsgID), (Object)FunctionIDs.getDescription(this.lsgID, n));
            this.module.getRequestHandler().requestError(this.lsgID, n, 2);
        } else {
            IBAPFunction iBAPFunction = this.module.getBAPFunction(n);
            if (iBAPFunction == null) {
                this.module.getRequestHandler().requestError(this.lsgID, n, 1);
            } else if (!this.module.getFunctionList().isFunctionSupported(n)) {
                this.logChannel.log(100000, "[AbstractBAPIndicationHandler#processAcknowledge] function deactivated in FunctionList (lsgID=%1, fctID=%2) -> ignore acknowledge", (Object)iBAPFunction.getLSGIDDescription(), (Object)iBAPFunction.getFctIDDescription());
            } else {
                iBAPFunction.processAcknowledge(n2);
            }
        }
    }

    public void processIndication(int n, int n2, int n3, int n4) {
        BAPIndicationData bAPIndicationData = new BAPIndicationData(n2, n4);
        this.processIndication(n, n3, bAPIndicationData);
    }

    public void processIndicationByteSequence(int n, int n2, byte[] byArray) {
        BAPIndicationData bAPIndicationData = new BAPIndicationData(byArray);
        this.processIndication(n, n2, bAPIndicationData);
    }

    public void processIndicationVoid(int n, int n2) {
        this.processIndication(n, n2, null);
    }

    public void processIndicationError(int n, int n2) {
        if (!this.module.getFunctionList().isInRange(n)) {
            this.logChannel.log(10000, "[AbstractBAPIndicationHandler#processIndicationError] invalid fctID (lsgID=%1, fctID=%2), out of range -> ignore indication", (Object)LSGIDs.getDescription(this.lsgID), (Object)FunctionIDs.getDescription(this.lsgID, n));
        } else {
            IBAPFunction iBAPFunction = this.module.getBAPFunction(n);
            if (iBAPFunction == null) {
                this.logChannel.log(10000, "[AbstractBAPIndicationHandler#processIndicationError] function not available (lsgID=%1, fctID=%2) -> ignore indication", (long)this.lsgID, (long)n);
            } else if (!this.module.getFunctionList().isFunctionSupported(n)) {
                this.logChannel.log(10000, "[AbstractBAPIndicationHandler#processIndicationError] function deactivated in FunctionList (lsgID=%1, fctID=%2) -> ignore indication", (Object)iBAPFunction.getLSGIDDescription(), (Object)iBAPFunction.getFctIDDescription());
            } else {
                iBAPFunction.processIndicationError(n2);
                if (this.module.isErrorHandled(n2)) {
                    iBAPFunction.reset();
                }
            }
        }
    }

    private void processIndication(int n, int n2, BAPIndicationData bAPIndicationData) {
        if (!this.module.getFunctionList().isInRange(n)) {
            this.logChannel.log(10000, "[AbstractBAPIndicationHandler#processIndication] invalid fctID (lsgID=%1, fctID=%2), out of range -> ignore indication", (Object)LSGIDs.getDescription(this.lsgID), (Object)FunctionIDs.getDescription(this.lsgID, n));
            this.module.getRequestHandler().requestError(this.lsgID, n, 2);
        } else if (n2 == 13) {
            if (n == this.module.getFunctionList().getBAPConfigBAPFctID()) {
                BAPEntity bAPEntity = this.module.getBAPFunction(n).getIndicationSerializer(13);
                if (bAPEntity != null) {
                    if (bAPIndicationData != null) {
                        int n3 = BAPDeserializer.deserializeData(this.logChannel, this.logChannel, this.lsgID, n, bAPEntity, bAPIndicationData);
                        if (n3 == 0) {
                            this.module.getInitializationManager().bapReset(bAPEntity);
                        } else {
                            this.logChannel.log(10000, "[AbstractBAPIndicationHandler#processIndication] resetSerializer deserialization failed. result: %1", (long)n3);
                        }
                    } else {
                        this.logChannel.log(10000, "[AbstractBAPIndicationHandler#processIndication] reset indication with no data.");
                    }
                } else {
                    this.logChannel.log(10000, "[AbstractBAPIndicationHandler#processIndication] resetSerializer is null.");
                }
            } else {
                this.logChannel.log(10000, "[AbstractBAPIndicationHandler#processIndication] fctID not valid for Reset indication. fctID: %1", (long)n);
            }
        } else {
            IBAPFunction iBAPFunction = this.module.getBAPFunction(n);
            if (iBAPFunction == null) {
                this.logChannel.log(10000, "[AbstractBAPIndicationHandler#processIndication] function not available (lsgID=%1, fctID=%2) -> ignore indication", (long)this.lsgID, (long)n);
                this.module.getRequestHandler().requestError(this.lsgID, n, 1);
            } else if (!this.module.getFunctionList().isFunctionSupported(n)) {
                this.logChannel.log(10000, "[AbstractBAPIndicationHandler#processIndication] function deactivated in FunctionList (lsgID=%1, fctID=%2) -> ignore indication", (Object)iBAPFunction.getLSGIDDescription(), (Object)iBAPFunction.getFctIDDescription());
                this.module.getRequestHandler().requestError(this.lsgID, n, 0);
            } else {
                iBAPFunction.processIndication(n2, bAPIndicationData);
            }
        }
    }
}

