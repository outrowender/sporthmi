/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.dsi.media;

import de.audi.app.media.AbstractDispatcherRunnable;
import de.audi.app.media.dsi.media.MediaDSIPlayerListener;
import de.audi.app.media.dsi.media.requests.RequestParameterList;
import de.esolutions.fw.util.commons.Buffer;

class MediaDSIPlayerListener$31
extends AbstractDispatcherRunnable {
    private final /* synthetic */ int val$errorCode;
    private final /* synthetic */ int val$requestType;
    private final /* synthetic */ String val$errorMsg;
    private final /* synthetic */ MediaDSIPlayerListener this$0;

    MediaDSIPlayerListener$31(MediaDSIPlayerListener mediaDSIPlayerListener, String string, int n, int n2, String string2) {
        this.this$0 = mediaDSIPlayerListener;
        this.val$errorCode = n;
        this.val$requestType = n2;
        this.val$errorMsg = string2;
        super(string);
    }

    @Override
    public void run() {
        Buffer buffer = new Buffer(20);
        buffer.append("errorCode='").append(this.val$errorCode).append("',requestType='").append(this.val$requestType).append("',msg='").append(this.val$errorMsg).append("'");
        MediaDSIPlayerListener.access$6700(this.this$0).log(-1601830656, "[%1.asyncException] [%2] %3", (Object)"MediaDSIPlayerListener", (Object)new Integer(MediaDSIPlayerListener.access$000(this.this$0).getInstanceID()), (Object)buffer);
        switch (this.val$requestType) {
            case 1019: {
                MediaDSIPlayerListener.access$6800(this.this$0).log(-1601830656, "[%1.asyncException] RT_REQUESTDETAILINFO.", (Object)"MediaDSIPlayerListener");
                MediaDSIPlayerListener.access$000(this.this$0).getRequestDetailInfoHandler().dataResponded();
                break;
            }
            case 1003: {
                MediaDSIPlayerListener.access$6900(this.this$0).log(-1601830656, "[%1.asyncException] RT_REQUESTCOVERART.", (Object)"MediaDSIPlayerListener");
                MediaDSIPlayerListener.access$000(this.this$0).getRequestCoverartURLHandler().dataResponded();
                break;
            }
            case 1012: {
                MediaDSIPlayerListener.access$7000(this.this$0).log(-1601830656, "[%1.asyncException] RT_SETACTIVEMEDIA.", (Object)"MediaDSIPlayerListener");
                if (this.val$errorCode == 8300) {
                    MediaDSIPlayerListener.access$7100(this.this$0).log(1078071040, "[%1.asyncException] Pruning detected.", (Object)"MediaDSIPlayerListener");
                    MediaDSIPlayerListener.access$000(this.this$0).sourceDeviceActivated(0L, 0L, 0, false);
                    break;
                }
                MediaDSIPlayerListener.access$000(this.this$0).sourceActivationFailed();
                break;
            }
            case 1013: {
                MediaDSIPlayerListener.access$7200(this.this$0).log(-1601830656, "[%1.asyncException] RT_REQUESTPLAYVIEW.", (Object)"MediaDSIPlayerListener");
                if (this.this$0.exceptionController.asyncException(this.val$errorCode, this.val$errorMsg, this.val$requestType)) break;
                RequestParameterList requestParameterList = (RequestParameterList)MediaDSIPlayerListener.access$000(this.this$0).getRequestListHandler().dataResponded();
                if (requestParameterList == null) {
                    return;
                }
                MediaDSIPlayerListener.access$7300(this.this$0).log(-1601830656, "[%1.asyncException] Running request was aborted.", (Object)"MediaDSIPlayerListener");
                MediaDSIPlayerListener.access$000(this.this$0).getPlayerListener().errorPlayViewListRequestAborted(requestParameterList.getClientID());
                break;
            }
            default: {
                MediaDSIPlayerListener.access$000(this.this$0).getPlayerListener().error(this.val$requestType);
            }
        }
    }
}

