/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.dsi.media;

import de.audi.app.media.dsi.IRequestParameter;
import de.audi.app.media.dsi.media.IMediaBrowserListListener;
import de.audi.app.media.dsi.media.IMediaBrowserListener;
import de.audi.app.media.dsi.media.IMediaBrowserStateListener;
import de.audi.app.media.dsi.media.MediaDSIBrowserListener;

class MediaDSIBrowserListener$16
implements Runnable {
    private final /* synthetic */ int val$errorCode;
    private final /* synthetic */ int val$requestType;
    private final /* synthetic */ String val$errorMsg;
    private final /* synthetic */ MediaDSIBrowserListener this$0;

    MediaDSIBrowserListener$16(MediaDSIBrowserListener mediaDSIBrowserListener, int n, int n2, String string) {
        this.this$0 = mediaDSIBrowserListener;
        this.val$errorCode = n;
        this.val$requestType = n2;
        this.val$errorMsg = string;
    }

    @Override
    public void run() {
        if (MediaDSIBrowserListener.access$5300(this.this$0).getCurrentLogThreshold() >= 1078071040) {
            MediaDSIBrowserListener.access$5400(this.this$0).log(1078071040, "[%1.asyncException] [%2] errorCode='%3',type='%4'.", (Object)"MediaDSIBrowserListener", (Object)String.valueOf(MediaDSIBrowserListener.access$000(this.this$0).getInstanceID()), (Object)String.valueOf(this.val$errorCode), (Object)String.valueOf(this.val$requestType));
            MediaDSIBrowserListener.access$5500(this.this$0).log(1078071040, "[%1.asyncException] [%3] msg='%2'.", (Object)"MediaDSIBrowserListener", (Object)this.val$errorMsg, (long)MediaDSIBrowserListener.access$000(this.this$0).getInstanceID());
        }
        switch (this.val$requestType) {
            case 1008: 
            case 2000: {
                IMediaBrowserListListener iMediaBrowserListListener;
                IRequestParameter iRequestParameter = MediaDSIBrowserListener.access$000(this.this$0).getRequestListHandler().dataResponded();
                if (iRequestParameter == null || (iMediaBrowserListListener = MediaDSIBrowserListener.access$000(this.this$0).getBrowserListListener(iRequestParameter.getClientID())) == null) break;
                iMediaBrowserListListener.errorListRequestAborted();
                break;
            }
            case 1009: 
            case 2002: {
                IMediaBrowserListListener iMediaBrowserListListener;
                IRequestParameter iRequestParameter = MediaDSIBrowserListener.access$000(this.this$0).getRequestPickListHandler().dataResponded();
                if (iRequestParameter == null || (iMediaBrowserListListener = MediaDSIBrowserListener.access$000(this.this$0).getBrowserListListener(iRequestParameter.getClientID())) == null) break;
                iMediaBrowserListListener.errorPickListRequestAborted();
                break;
            }
            case 1007: {
                IMediaBrowserStateListener iMediaBrowserStateListener = MediaDSIBrowserListener.access$000(this.this$0).getBrowserStateListener();
                if (iMediaBrowserStateListener == null) {
                    return;
                }
                iMediaBrowserStateListener.errorFolderChange();
                break;
            }
            case 1001: 
            case 1003: {
                IMediaBrowserStateListener iMediaBrowserStateListener = MediaDSIBrowserListener.access$000(this.this$0).getBrowserStateListener();
                if (iMediaBrowserStateListener == null) {
                    return;
                }
                iMediaBrowserStateListener.errorSelection();
                break;
            }
            case 1000: 
            case 1004: 
            case 1005: {
                IMediaBrowserStateListener iMediaBrowserStateListener = MediaDSIBrowserListener.access$000(this.this$0).getBrowserStateListener();
                if (iMediaBrowserStateListener == null) {
                    return;
                }
                iMediaBrowserStateListener.errorBrowseMode();
                break;
            }
            case 1006: {
                IMediaBrowserListener iMediaBrowserListener = MediaDSIBrowserListener.access$000(this.this$0).getBrowserListener();
                if (iMediaBrowserListener == null) {
                    return;
                }
                iMediaBrowserListener.asyncException(this.val$errorCode, this.val$errorMsg, this.val$requestType);
                break;
            }
        }
    }

    public String toString() {
        return new StringBuffer().append(MediaDSIBrowserListener.access$700(this.this$0)).append("asyncException").toString();
    }
}

