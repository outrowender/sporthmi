/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bap.fw.request;

import de.audi.app.bap.AbstractBAPApplication;
import de.audi.app.bap.fw.AbstractBAPModule;
import de.audi.app.bap.fw.request.BAPRequestHandlerImpl$1;
import de.audi.app.bap.fw.request.BAPRequestHandlerImpl$2;
import de.audi.app.bap.fw.request.BAPRequestHandlerImpl$3;
import de.audi.app.bap.fw.request.DataTypeMapping;
import de.audi.app.bap.fw.request.IBAPRequestHandler;
import de.audi.app.bap.utils.ErrorCodes;
import de.audi.app.bap.utils.FunctionIDs;
import de.audi.app.bap.utils.LSGIDs;
import de.audi.app.bap.utils.RequestTypes;
import de.audi.atip.job.JobLogger;
import de.esolutions.fw.util.commons.job.DispatcherBase;
import de.vw.mib.bap.stream.BitStreamSerializer;
import de.vw.mib.bap.stream.BitStreamTransformer;

public class BAPRequestHandlerImpl
implements IBAPRequestHandler {
    private AbstractBAPApplication bapApplication;
    private BitStreamTransformer bitStreamTransformer;
    private DispatcherBase dispatcher = null;

    public BAPRequestHandlerImpl(AbstractBAPApplication abstractBAPApplication) {
        this.bapApplication = abstractBAPApplication;
        this.bitStreamTransformer = new BitStreamTransformer();
        StringBuffer stringBuffer = new StringBuffer("BAP_Request_");
        stringBuffer.append(abstractBAPApplication.getName());
        this.dispatcher = abstractBAPApplication.getFrameworkAccess().getDispatcherManager().createDispatcher(stringBuffer.toString(), new JobLogger(null));
        this.dispatcher.start();
    }

    @Override
    public boolean processRequest(int n, int n2, int n3, BitStreamSerializer bitStreamSerializer) {
        if (!this.isModuleReady(n)) {
            this.bapApplication.getLogger().getLog(n).log(-1601830656, "[BAPRequestHandlerImpl#processRequest] hmiState not ready -> don't send request (lsgID=%1, fctID=%2, requestType=%3)", (Object)LSGIDs.getDescription(n), (Object)FunctionIDs.getDescription(n, n2), (Object)RequestTypes.getDescription(n3));
            return false;
        }
        if (!this.bapApplication.getModule(n).getFunctionList().isInRange(n2)) {
            this.bapApplication.getLogger().getLog(n).log(10000, "[BAPRequestHandlerImpl#processRequest] invalid fctID (lsgID=%1, fctID=%2)", (Object)LSGIDs.getDescription(n), (Object)FunctionIDs.getDescription(n, n2));
            return false;
        }
        if (!this.bapApplication.getModule(n).getFunctionList().isFunctionSupported(n2)) {
            this.bapApplication.getLogger().getLog(n).log(-2137614336, "[BAPRequestHandlerImpl#processRequest] function deactivated in FunctionList (lsgID=%1, fctID=%2, requestType=%3)", (Object)LSGIDs.getDescription(n), (Object)FunctionIDs.getDescription(n, n2), (Object)RequestTypes.getDescription(n3));
            return false;
        }
        this.dispatcher.execute(this.createNewRequestJob(n, n2, n3, bitStreamSerializer));
        return true;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private Runnable createNewRequestJob(int n, int n2, int n3, BitStreamSerializer bitStreamSerializer) {
        Runnable runnable;
        if (bitStreamSerializer == null) {
            runnable = new BAPRequestHandlerImpl$1(this, n, n2, n3);
        } else {
            int n4 = DataTypeMapping.getRequestDataType(n, n2, n3);
            if (n4 == 3) {
                byte[] byArray;
                BitStreamTransformer bitStreamTransformer = this.bitStreamTransformer;
                synchronized (bitStreamTransformer) {
                    byArray = this.bitStreamTransformer.toByteArray(bitStreamSerializer);
                }
                runnable = new BAPRequestHandlerImpl$2(this, n, n2, n3, byArray);
            } else {
                int n5;
                BitStreamTransformer bitStreamTransformer = this.bitStreamTransformer;
                synchronized (bitStreamTransformer) {
                    n5 = this.bitStreamTransformer.toInteger(bitStreamSerializer, bitStreamSerializer.bitSize());
                }
                runnable = new BAPRequestHandlerImpl$3(this, n, n2, n4, n3, n5);
            }
        }
        return runnable;
    }

    @Override
    public void requestErrorCode(int n, int n2, int n3) {
        if (!this.isModuleReady(n)) {
            this.bapApplication.getLogger().getLog(n).log(-1601830656, "[BAPRequestHandlerImpl#requestErrorCode] hmiState not ready -> don't send error request (lsgID=%1, fctID=%2, errorCode=%3)", (Object)LSGIDs.getDescription(n), (Object)FunctionIDs.getDescription(n, n2), (Object)ErrorCodes.getDescription(n, n3));
            return;
        }
        if (!this.bapApplication.getModule(n).getFunctionList().isInRange(n2)) {
            this.bapApplication.getLogger().getLog(n).log(10000, "[BAPRequestHandlerImpl#requestErrorCode] invalid fctID (lsgID=%1, fctID=%2)", (Object)LSGIDs.getDescription(n), (Object)FunctionIDs.getDescription(n, n2));
            return;
        }
        this.bapApplication.getLogger().getLog(n).log(-2137614336, "[BAPRequestHandlerImpl#requestErrorCode] request error (lsgID=%1, fctID=%2, errorCode=%3)", (Object)LSGIDs.getDescription(n), (Object)FunctionIDs.getDescription(n, n2), (Object)ErrorCodes.getDescription(n, n3));
        this.bapApplication.getDSIBAPController().requestError(n, n2, n3);
    }

    @Override
    public void requestError(int n, int n2, int n3) {
        int[] nArray = this.bapApplication.getModule(n).getErrorMapping();
        if (n3 >= 0 && n3 < nArray.length) {
            this.requestErrorCode(n, n2, nArray[n3]);
        } else {
            this.bapApplication.getLogger().getLog(n).log(10000, "[BAPRequestHandlerImpl#requestError] invalid errorType: %1", (long)n3);
        }
    }

    private boolean isModuleReady(int n) {
        AbstractBAPModule abstractBAPModule = this.bapApplication.getModule(n);
        return abstractBAPModule != null && abstractBAPModule.getInitializationManager().getHMIState() != 0;
    }

    @Override
    public void destroy() {
        this.bapApplication = null;
        this.bitStreamTransformer = null;
        this.dispatcher.stop();
    }

    static /* synthetic */ AbstractBAPApplication access$000(BAPRequestHandlerImpl bAPRequestHandlerImpl) {
        return bAPRequestHandlerImpl.bapApplication;
    }
}

