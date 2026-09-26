/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.combi.bap.app.navi;

import de.audi.app.bap.fw.functiontypes.AbstractBAPFunction;
import de.audi.app.bap.fw.functiontypes.BAPFunctionDataListener;
import de.audi.app.bap.fw.functiontypes.BAPFunctionMethodFSG;
import de.audi.app.bap.fw.functiontypes.BAPFunctionPropertyFSG;
import de.audi.app.bap.fw.indication.IAcknowledgeListener;
import de.audi.app.combi.bap.app.navi.CombiModuleNavi;
import de.vw.mib.bap.generated.navsd.serializer.RG_ActDeact_Result;
import de.vw.mib.bap.generated.navsd.serializer.RG_ActDeact_StartResult;
import java.util.ArrayList;
import java.util.List;

public final class BAPMethodRGActDeactWaitingForProperties
implements IAcknowledgeListener,
BAPFunctionDataListener {
    private static final int NO_RESULT_RECEIVED;
    private final CombiModuleNavi combiModuleNavi;
    private final BAPFunctionMethodFSG bapMethodRGActDeact;
    private final List propertiesToWaitFor = new ArrayList();
    private volatile int resultReceived = -1;
    private boolean waitingForFunctionSync;

    public BAPMethodRGActDeactWaitingForProperties(CombiModuleNavi combiModuleNavi, BAPFunctionMethodFSG bAPFunctionMethodFSG) {
        this.combiModuleNavi = combiModuleNavi;
        this.bapMethodRGActDeact = bAPFunctionMethodFSG;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void rgActDeactStartResultReceived(RG_ActDeact_StartResult rG_ActDeact_StartResult) {
        int[] nArray;
        this.combiModuleNavi.getLogChannel().log(-2137614336, "[BAPMethodRGActDeactWaitingForProperties#rgActDeactStartResultReceived]");
        this.resultReceived = -1;
        this.waitingForFunctionSync = true;
        this.clearPropertiesToWaitFor();
        switch (rG_ActDeact_StartResult.controlType) {
            case 0: {
                nArray = new int[]{23, 21, 22, 19, 17};
                break;
            }
            case 1: {
                nArray = new int[]{23, 18};
                break;
            }
            default: {
                nArray = new int[]{};
            }
        }
        for (int i2 = 0; i2 < nArray.length; ++i2) {
            if (this.combiModuleNavi.getFunctionList().isFunctionSupported(nArray[i2])) {
                List list = this.propertiesToWaitFor;
                synchronized (list) {
                    BAPFunctionPropertyFSG bAPFunctionPropertyFSG = this.combiModuleNavi.getBAPFunctionPropertyFSG(nArray[i2]);
                    this.propertiesToWaitFor.add(bAPFunctionPropertyFSG);
                    bAPFunctionPropertyFSG.addDataListener(this);
                    bAPFunctionPropertyFSG.addAcknowledgeListener(this);
                    continue;
                }
            }
            this.combiModuleNavi.getLogChannel().log(-2137614336, "[BAPMethodRGActDeactWaitingForProperties#rgActDeactStartResultReceived] fctID=%1 not supported -> ignore", (long)nArray[i2]);
        }
    }

    public void rgActDeactSyncFinished() {
        this.waitingForFunctionSync = false;
        if (this.isNoMorePropertiesToWaitFor()) {
            this.combiModuleNavi.getLogChannel().log(-2137614336, "[BAPMethodRGActDeactWaitingForProperties#rgActDeactSyncFinished] send result");
            RG_ActDeact_Result rG_ActDeact_Result = (RG_ActDeact_Result)this.combiModuleNavi.createResultSerializer(34);
            rG_ActDeact_Result.rg_ActDeact_Result = this.resultReceived;
            this.bapMethodRGActDeact.resultREQ(rG_ActDeact_Result);
        } else {
            this.combiModuleNavi.getLogChannel().log(-2137614336, "[BAPMethodRGActDeactWaitingForProperties#rgActDeactSyncFinished] sync finished, waiting for properties to be updated");
        }
    }

    public void rgActDeactResultReceived(int n) {
        this.combiModuleNavi.getLogChannel().log(-2137614336, "[BAPMethodRGActDeactWaitingForProperties#rgActDeactResultReceived] result=%1", (long)n);
        this.resultReceived = n;
        RG_ActDeact_Result rG_ActDeact_Result = (RG_ActDeact_Result)this.combiModuleNavi.createResultSerializer(34);
        rG_ActDeact_Result.rg_ActDeact_Result = n;
        this.bapMethodRGActDeact.setResultWaiting(n);
        if (n != 0) {
            rG_ActDeact_Result.rg_ActDeact_Result = n == 2 ? 0 : n;
            this.combiModuleNavi.getLogChannel().log(-2137614336, "[BAPMethodRGActDeactWaitingForProperties#rgActDeactResultReceived] send result immediately");
            this.clearPropertiesToWaitFor();
            this.waitingForFunctionSync = false;
            this.bapMethodRGActDeact.resultREQ(rG_ActDeact_Result);
        } else if (!this.waitingForFunctionSync && this.isNoMorePropertiesToWaitFor()) {
            this.combiModuleNavi.getLogChannel().log(-2137614336, "[BAPMethodRGActDeactWaitingForProperties#rgActDeactResultReceived] send result");
            this.bapMethodRGActDeact.resultREQ(rG_ActDeact_Result);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private boolean isNoMorePropertiesToWaitFor() {
        List list = this.propertiesToWaitFor;
        synchronized (list) {
            return this.propertiesToWaitFor.isEmpty();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void clearPropertiesToWaitFor() {
        List list = this.propertiesToWaitFor;
        synchronized (list) {
            for (int i2 = 0; i2 < this.propertiesToWaitFor.size(); ++i2) {
                AbstractBAPFunction abstractBAPFunction = (AbstractBAPFunction)this.propertiesToWaitFor.get(i2);
                abstractBAPFunction.removeDataListener(this);
                abstractBAPFunction.removeAcknowledgeListener(this);
            }
            this.propertiesToWaitFor.clear();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void updateReceived(int n) {
        BAPFunctionPropertyFSG bAPFunctionPropertyFSG = this.combiModuleNavi.getBAPFunctionPropertyFSG(n);
        this.combiModuleNavi.getLogChannel().log(-2137614336, "[BAPMethodRGActDeactWaitingForProperties#updateReceived] %1", (Object)bAPFunctionPropertyFSG.getFctIDDescription());
        List list = this.propertiesToWaitFor;
        synchronized (list) {
            if (this.propertiesToWaitFor.contains(bAPFunctionPropertyFSG)) {
                bAPFunctionPropertyFSG.removeDataListener(this);
                bAPFunctionPropertyFSG.removeAcknowledgeListener(this);
                this.propertiesToWaitFor.remove(bAPFunctionPropertyFSG);
                if (this.propertiesToWaitFor.isEmpty() && this.resultReceived != -1 && !this.waitingForFunctionSync) {
                    RG_ActDeact_Result rG_ActDeact_Result = (RG_ActDeact_Result)this.combiModuleNavi.createResultSerializer(34);
                    rG_ActDeact_Result.rg_ActDeact_Result = this.resultReceived;
                    this.bapMethodRGActDeact.resultREQ(rG_ActDeact_Result);
                }
            }
        }
    }

    @Override
    public void notifyDataValidChanged(int n, boolean bl) {
    }

    @Override
    public void notifyDataChanged(int n) {
    }

    @Override
    public void notifyDataUpdatedNoChange(int n) {
        this.updateReceived(n);
    }

    @Override
    public void processAcknowledge(int n, int n2) {
        this.updateReceived(n);
    }
}

