/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.addressbook.core.vcardexchange;

import de.audi.app.addressbook.core.common.ADBUtils;
import de.audi.app.addressbook.core.vcardexchange.VCardExchangeADBHandler;
import de.audi.app.addressbook.core.vcardexchange.VCardExchangeMediaHandler$SourceInfo;
import de.audi.atip.hmi.IHMIServiceApp;
import de.audi.atip.interapp.media.IMediaServiceListener;
import de.audi.atip.interapp.media.MediaSlotInfo;
import de.audi.atip.log.LogChannel;
import java.util.List;
import java.util.Map;

public class VCardExchangeMediaHandler
implements IMediaServiceListener {
    private static final int SOURCE_STATE_UNAVAILABLE;
    private static final int SOURCE_STATE_READ_ONLY;
    private static final int SOURCE_STATE_READ_WRITE;
    private static final Integer SOURCE_MEDIA_USB;
    private static final Integer SOURCE_MEDIA_SD;
    private static final int SD_DEVICE_1_SLOT;
    private static final int SD_DEVICE_2_SLOT;
    private static final int USB_DEVICE_1_SLOT;
    private static final int USB_DEVICE_2_SLOT;
    private VCardExchangeADBHandler vCardAdbHandler;
    private IHMIServiceApp hmiService;
    private LogChannel log;
    private String mountPointSd1 = "";
    private String mountPointSd2 = "";
    private String mountPointUsb1 = "";
    private String mountPointUsb2 = "";

    public VCardExchangeMediaHandler(VCardExchangeADBHandler vCardExchangeADBHandler, LogChannel logChannel) {
        this.vCardAdbHandler = vCardExchangeADBHandler;
        this.hmiService = vCardExchangeADBHandler.getHMIService();
        this.log = logChannel;
        this.processSourceListChange(null);
    }

    public String getMountPoint(int n) {
        switch (n) {
            case 1: {
                return this.mountPointSd1;
            }
            case 2: {
                return this.mountPointSd2;
            }
            case 3: {
                return this.mountPointUsb1;
            }
            case 4: {
                return this.mountPointUsb2;
            }
        }
        return "";
    }

    private int updateLeftSDCardDeviceState(Map map) {
        VCardExchangeMediaHandler$SourceInfo vCardExchangeMediaHandler$SourceInfo = this.getMediaState(map, SOURCE_MEDIA_SD, 0);
        int n = vCardExchangeMediaHandler$SourceInfo.getSourceState();
        this.mountPointSd1 = vCardExchangeMediaHandler$SourceInfo.getMountPoint();
        this.hmiService.getButtonModel(984615424).setStatus(n >= 1 ? 1 : 0);
        this.hmiService.getButtonModel(632293888).setStatus(n == 2 ? 1 : 0);
        return n;
    }

    private int updateRightSDCardDeviceState(Map map) {
        VCardExchangeMediaHandler$SourceInfo vCardExchangeMediaHandler$SourceInfo = this.getMediaState(map, SOURCE_MEDIA_SD, 1);
        int n = vCardExchangeMediaHandler$SourceInfo.getSourceState();
        this.mountPointSd2 = vCardExchangeMediaHandler$SourceInfo.getMountPoint();
        this.hmiService.getButtonModel(1001392640).setStatus(n >= 1 ? 1 : 0);
        this.hmiService.getButtonModel(649071104).setStatus(n == 2 ? 1 : 0);
        return n;
    }

    private int updateUSB1DeviceState(Map map) {
        VCardExchangeMediaHandler$SourceInfo vCardExchangeMediaHandler$SourceInfo = this.getMediaState(map, SOURCE_MEDIA_USB, 0);
        int n = vCardExchangeMediaHandler$SourceInfo.getSourceState();
        this.mountPointUsb1 = vCardExchangeMediaHandler$SourceInfo.getMountPoint();
        this.hmiService.getButtonModel(1018169856).setStatus(n >= 1 ? 1 : 0);
        this.hmiService.getButtonModel(665848320).setStatus(n == 2 ? 1 : 0);
        return n;
    }

    private int updateUSB2DeviceState(Map map) {
        VCardExchangeMediaHandler$SourceInfo vCardExchangeMediaHandler$SourceInfo = this.getMediaState(map, SOURCE_MEDIA_USB, 2);
        int n = vCardExchangeMediaHandler$SourceInfo.getSourceState();
        this.mountPointUsb2 = vCardExchangeMediaHandler$SourceInfo.getMountPoint();
        this.hmiService.getButtonModel(1789921792).setStatus(n >= 1 ? 1 : 0);
        this.hmiService.getButtonModel(1773144576).setStatus(n == 2 ? 1 : 0);
        return n;
    }

    private void processSourceListChange(Map map) {
        int n = this.updateLeftSDCardDeviceState(map);
        int n2 = this.updateRightSDCardDeviceState(map);
        int n3 = this.updateUSB1DeviceState(map);
        int n4 = this.updateUSB2DeviceState(map);
        if (this.log.isInfo()) {
            this.log.log(1078071040, new StringBuffer().append("VCardExchangeMediaHandler#processSourceListChange(): device states have been updated: sd1State: %1, sd2State: %2, usb1State: %3, usb2State: ").append(n4).toString(), (long)n, (long)n2, (long)n3);
        }
        if (this.shouldCancelImport(n, n2, n3, n4)) {
            this.vCardAdbHandler.cancelImport();
        } else if (this.shouldCancelExport(n, n2, n3, n4)) {
            this.vCardAdbHandler.cancelExport();
        }
    }

    private boolean shouldCancelImport(int n, int n2, int n3, int n4) {
        return this.vCardAdbHandler.getImportExportMode() == 1 && (this.vCardAdbHandler.getExchangeLocation() == 1 && n == 0 || this.vCardAdbHandler.getExchangeLocation() == 2 && n2 == 0 || this.vCardAdbHandler.getExchangeLocation() == 3 && n3 == 0 || this.vCardAdbHandler.getExchangeLocation() == 4 && n4 == 0);
    }

    private boolean shouldCancelExport(int n, int n2, int n3, int n4) {
        return this.vCardAdbHandler.getImportExportMode() == 2 && (this.vCardAdbHandler.getExchangeLocation() == 1 && n < 2 || this.vCardAdbHandler.getExchangeLocation() == 2 && n2 < 2 || this.vCardAdbHandler.getExchangeLocation() == 3 && n3 < 2 || this.vCardAdbHandler.getExchangeLocation() == 4 && n4 < 2);
    }

    private VCardExchangeMediaHandler$SourceInfo getMediaState(Map map, Integer n, int n2) {
        if (map == null || map.get(n) == null || !(map.get(n) instanceof List)) {
            return new VCardExchangeMediaHandler$SourceInfo(0, "");
        }
        List list = (List)map.get(n);
        for (int i2 = 0; i2 < list.size(); ++i2) {
            MediaSlotInfo mediaSlotInfo = (MediaSlotInfo)list.get(i2);
            if (mediaSlotInfo.getSlotIdx() != n2) continue;
            if (mediaSlotInfo.isEmpty()) {
                return new VCardExchangeMediaHandler$SourceInfo(0, "");
            }
            if (mediaSlotInfo.getType() == 9 || mediaSlotInfo.getType() == 8 || mediaSlotInfo.getType() == 10 || ADBUtils.isEmpty(mediaSlotInfo.getMountPoint())) {
                return new VCardExchangeMediaHandler$SourceInfo(0, "");
            }
            if (mediaSlotInfo.isReadOnly()) {
                return new VCardExchangeMediaHandler$SourceInfo(1, mediaSlotInfo.getMountPoint());
            }
            return new VCardExchangeMediaHandler$SourceInfo(2, mediaSlotInfo.getMountPoint());
        }
        return new VCardExchangeMediaHandler$SourceInfo(0, "");
    }

    @Override
    public void sourceListChanged(Map map) {
        this.log.log(-2137614336, "VCardExchangeMediaHandler#sourceListChanged(): sourceList: %1", (Object)map);
        this.processSourceListChange(map);
    }

    @Override
    public int getTerminalID() {
        return 0;
    }

    @Override
    public void sourceAvailable(int n, boolean bl) {
    }

    @Override
    public void updateActiveSource(MediaSlotInfo mediaSlotInfo, boolean bl) {
    }

    @Override
    public void sourceDeactivated() {
    }

    @Override
    public void updatePlaybackState(int n) {
    }

    static {
        SOURCE_MEDIA_USB = new Integer(10);
        SOURCE_MEDIA_SD = new Integer(5);
    }
}

