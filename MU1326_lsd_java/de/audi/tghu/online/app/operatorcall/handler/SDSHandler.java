/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.operatorcall.handler;

import de.audi.atip.interapp.online.IOperatorCallSDSService;
import de.audi.atip.interapp.online.IOperatorCallSDSServiceListener;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.online.app.Online;
import de.audi.tghu.online.app.operatorcall.AbstractOperatorCallMain;
import de.audi.tghu.online.app.operatorcall.abstractclasses.AbstractModelHandler;
import de.audi.tghu.online.app.operatorcall.abstractclasses.AbstractOperatorCall;
import de.audi.tghu.online.app.operatorcall.data.AbstractOperatorCallDataContainer;
import de.audi.tghu.online.app.operatorcall.handler.TestHandler;
import org.dsi.ifc.online.OperatorCallResult;

public class SDSHandler
implements IOperatorCallSDSService {
    private AbstractOperatorCallMain distributor;
    private final LogChannel logChannel = Online.getInstance().getOperatorCallLogChannel();
    private IOperatorCallSDSServiceListener sdsListener;

    public SDSHandler(AbstractOperatorCallMain abstractOperatorCallMain) {
        this.distributor = abstractOperatorCallMain;
    }

    public void startCallcenterCallBySDS(int n, IOperatorCallSDSServiceListener iOperatorCallSDSServiceListener, boolean bl) {
        this.logChannel.log(1000000, "SDSHandler#startCallcenterCallBySDS: serviceType = %1", (long)n);
        this.sdsListener = iOperatorCallSDSServiceListener;
        if (!TestHandler.isSDSSimulation()) {
            this.distributor.enterService(n);
        }
        this.getModelHandler(n).startCallcenterCallBySDS(n, bl);
    }

    private AbstractModelHandler getModelHandler(int n) {
        return this.distributor.getOperatorCall(n).getModelHandler();
    }

    public void replyToSDS(int n) {
        if (this.sdsListener != null) {
            this.logChannel.log(1000000, "SDSHandler#replySDS: state = %1", (long)n);
            switch (n) {
                case 0: {
                    this.logChannel.log(10000000, "SDSHandler#replySDS: state = call_connected");
                    break;
                }
                case 1: {
                    this.logChannel.log(10000000, "SDSHandler#replySDS: state = connection_error");
                    break;
                }
                case 2: {
                    this.logChannel.log(100000, "SDSHandler#replySDS: state = license_error");
                    break;
                }
                case 3: {
                    this.logChannel.log(10000000, "SDSHandler#replySDS: state = old_data_found");
                    break;
                }
                case 4: {
                    this.logChannel.log(10000000, "SDSHandler#replySDS: state = private_call_active");
                    break;
                }
                case 5: {
                    this.logChannel.log(10000000, "SDSHandler#replySDS: state = connection_aborted");
                    break;
                }
                case 6: {
                    this.logChannel.log(10000000, "SDSHandler#replySDS: state = internal_error");
                    break;
                }
                case 7: {
                    this.logChannel.log(10000000, "SDSHandler#replySDS: state = server_error");
                    break;
                }
                case 8: {
                    this.logChannel.log(10000000, "SDSHandler#replySDS: state = service_not_ready");
                    break;
                }
                default: {
                    this.logChannel.log(100000, "SDSHandler#replySDS: no such state defined: %1", (long)n);
                }
            }
            this.sdsListener.startCallcenterCallBySDSResult(n);
            this.sdsListener = null;
        }
    }

    public int getNumberOfPoisOfHistoryCallForSDS(int n, int n2) {
        this.logChannel.log(1000000, "SDSHandler#getNumberofPoisOfHistoryCall: serviceType = %1, index = %2", (long)n, (long)n2);
        AbstractOperatorCallDataContainer abstractOperatorCallDataContainer = this.getData(n);
        abstractOperatorCallDataContainer.setCallIndexForSDS(n2);
        int n3 = abstractOperatorCallDataContainer.getNumberOfPois(n2);
        this.logChannel.log(10000000, "SDSHandler#getNumberofPoisOfHistoryCall: returning %1", (long)n3);
        AbstractOperatorCall abstractOperatorCall = this.distributor.getOperatorCall(n);
        abstractOperatorCall.getModelHandler().historyCallSelectedBySDS(n2);
        return n3;
    }

    public OperatorCallResult getPoiOfIndexForSDS(int n, int n2) {
        this.logChannel.log(1000000, "SDSHandler#getPoiOfIndexForSDS: called for serviceType = %1 and poiIndex = %2", (long)n, (long)n2);
        AbstractOperatorCallDataContainer abstractOperatorCallDataContainer = this.getData(n);
        OperatorCallResult operatorCallResult = abstractOperatorCallDataContainer.getPOIForSDS(n2);
        this.logChannel.log(1000000, "SDSHandler#getPoiOfIndexForSDS: returning POI: %1", (Object)operatorCallResult);
        return operatorCallResult;
    }

    private AbstractOperatorCallDataContainer getData(int n) {
        AbstractOperatorCall abstractOperatorCall = this.distributor.getOperatorCall(n);
        return abstractOperatorCall.getData();
    }
}

