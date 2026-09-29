/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.dsi.media;

import de.audi.app.media.dsi.media.IMediaDeviceListener;
import de.audi.app.media.dsi.media.MediaDSIBaseListener;
import de.audi.app.media.logger.LogUtil;
import java.util.Iterator;
import org.dsi.ifc.media.DeviceInfo;

class MediaDSIBaseListener$3
implements Runnable {
    private final /* synthetic */ DeviceInfo[] val$deviceList;
    private final /* synthetic */ MediaDSIBaseListener this$0;

    MediaDSIBaseListener$3(MediaDSIBaseListener mediaDSIBaseListener, DeviceInfo[] deviceInfoArray) {
        this.this$0 = mediaDSIBaseListener;
        this.val$deviceList = deviceInfoArray;
    }

    @Override
    public void run() {
        if (this.val$deviceList == null) {
            MediaDSIBaseListener.access$500(this.this$0).log(-1601830656, "[%1.updateDeviceList] Device list is null. Ignore.", (Object)"MediaDSIBaseListener");
            return;
        }
        if (this.val$deviceList.length == 0) {
            MediaDSIBaseListener.access$600(this.this$0).log(-1601830656, "[%1.updateDeviceList] Device list contains no entries. Ignore.", (Object)"MediaDSIBaseListener");
            return;
        }
        if (MediaDSIBaseListener.access$700(this.this$0).isInfo()) {
            for (int i2 = 0; i2 < this.val$deviceList.length; ++i2) {
                MediaDSIBaseListener.access$800(this.this$0).log(1078071040, "[%1.updateDeviceList] DeviceInfo[%2] %3", (Object)"MediaDSIBaseListener", (Object)new Integer(i2), (Object)LogUtil.deviceInfoToStr(this.val$deviceList[i2]));
            }
        }
        Iterator iterator = MediaDSIBaseListener.access$900(this.this$0).iterator();
        while (iterator.hasNext()) {
            try {
                ((IMediaDeviceListener)iterator.next()).updateDeviceList(this.val$deviceList);
            }
            catch (Exception exception) {
                MediaDSIBaseListener.access$1000(this.this$0).log(-1601830656, "[%1.updateDeviceList] %2", (Object)"MediaDSIBaseListener", (Throwable)exception);
            }
        }
    }

    public String toString() {
        return "DSIMediaBase.updateDeviceList";
    }
}

