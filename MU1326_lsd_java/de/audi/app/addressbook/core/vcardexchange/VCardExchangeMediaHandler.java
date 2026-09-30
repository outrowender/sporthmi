/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.addressbook.core.vcardexchange;

import de.audi.app.addressbook.core.common.ADBUtils;
import de.audi.app.addressbook.core.vcardexchange.VCardExchangeADBHandler;
import de.audi.atip.hmi.IHMIServiceApp;
import de.audi.atip.interapp.media.IMediaServiceListener;
import de.audi.atip.interapp.media.MediaSlotInfo;
import de.audi.atip.log.LogChannel;
import java.util.List;
import java.util.Map;

public class VCardExchangeMediaHandler
implements IMediaServiceListener {
    private static final int SOURCE_STATE_UNAVAILABLE = 0;
    private static final int SOURCE_STATE_READ_ONLY = 1;
    private static final int SOURCE_STATE_READ_WRITE = 2;
    private static final Integer SOURCE_MEDIA_USB = new Integer(10);
    private static final Integer SOURCE_MEDIA_SD = new Integer(5);
    private static final int SD_DEVICE_1_SLOT = 0;
    private static final int SD_DEVICE_2_SLOT = 1;
    private static final int USB_DEVICE_1_SLOT = 0;
    private static final int USB_DEVICE_2_SLOT = 2;
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
        SourceInfo sourceInfo = this.getMediaState(map, SOURCE_MEDIA_SD, 0);
        int n = sourceInfo.getSourceState();
        this.mountPointSd1 = sourceInfo.getMountPoint();
        this.hmiService.getButtonModel(700474).setStatus(n >= 1 ? 1 : 0);
        this.hmiService.getButtonModel(700453).setStatus(n == 2 ? 1 : 0);
        return n;
    }

    private int updateRightSDCardDeviceState(Map map) {
        SourceInfo sourceInfo = this.getMediaState(map, SOURCE_MEDIA_SD, 1);
        int n = sourceInfo.getSourceState();
        this.mountPointSd2 = sourceInfo.getMountPoint();
        this.hmiService.getButtonModel(700475).setStatus(n >= 1 ? 1 : 0);
        this.hmiService.getButtonModel(700454).setStatus(n == 2 ? 1 : 0);
        return n;
    }

    private int updateUSB1DeviceState(Map map) {
        SourceInfo sourceInfo = this.getMediaState(map, SOURCE_MEDIA_USB, 0);
        int n = sourceInfo.getSourceState();
        this.mountPointUsb1 = sourceInfo.getMountPoint();
        this.hmiService.getButtonModel(700476).setStatus(n >= 1 ? 1 : 0);
        this.hmiService.getButtonModel(700455).setStatus(n == 2 ? 1 : 0);
        return n;
    }

    private int updateUSB2DeviceState(Map map) {
        SourceInfo sourceInfo = this.getMediaState(map, SOURCE_MEDIA_USB, 2);
        int n = sourceInfo.getSourceState();
        this.mountPointUsb2 = sourceInfo.getMountPoint();
        this.hmiService.getButtonModel(700522).setStatus(n >= 1 ? 1 : 0);
        this.hmiService.getButtonModel(700521).setStatus(n == 2 ? 1 : 0);
        return n;
    }

    private void processSourceListChange(Map map) {
        int n = this.updateLeftSDCardDeviceState(map);
        int n2 = this.updateRightSDCardDeviceState(map);
        int n3 = this.updateUSB1DeviceState(map);
        int n4 = this.updateUSB2DeviceState(map);
        if (this.log.isInfo()) {
            this.log.log(1000000, "VCardExchangeMediaHandler#processSourceListChange(): device states have been updated: sd1State: %1, sd2State: %2, usb1State: %3, usb2State: " + n4, (long)n, (long)n2, (long)n3);
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

    private SourceInfo getMediaState(Map map, Integer n, int n2) {
        if (map == null || map.get(n) == null || !(map.get(n) instanceof List)) {
            return new SourceInfo(0, "");
        }
        List list = (List)map.get(n);
        for (int i2 = 0; i2 < list.size(); ++i2) {
            MediaSlotInfo mediaSlotInfo = (MediaSlotInfo)list.get(i2);
            if (mediaSlotInfo.getSlotIdx() != n2) continue;
            if (mediaSlotInfo.isEmpty()) {
                return new SourceInfo(0, "");
            }
            if (mediaSlotInfo.getType() == 9 || mediaSlotInfo.getType() == 8 || mediaSlotInfo.getType() == 10 || ADBUtils.isEmpty(mediaSlotInfo.getMountPoint())) {
                return new SourceInfo(0, "");
            }
            if (mediaSlotInfo.isReadOnly()) {
                return new SourceInfo(1, mediaSlotInfo.getMountPoint());
            }
            return new SourceInfo(2, mediaSlotInfo.getMountPoint());
        }
        return new SourceInfo(0, "");
    }

    public void sourceListChanged(Map map) {
        this.log.log(10000000, "VCardExchangeMediaHandler#sourceListChanged(): sourceList: %1", (Object)map);
        this.processSourceListChange(map);
    }

    public int getTerminalID() {
        return 0;
    }

    public void sourceAvailable(int n, boolean bl) {
    }

    public void updateActiveSource(MediaSlotInfo mediaSlotInfo, boolean bl) {
    }

    public void sourceDeactivated() {
    }

    public void updatePlaybackState(int n) {
    }

    private static class SourceInfo {
        private int sourceState;
        private String mountPoint;

        public SourceInfo(int n, String string) {
            this.sourceState = n;
            this.mountPoint = string;
        }

        public int getSourceState() {
            return this.sourceState;
        }

        public String getMountPoint() {
            return this.mountPoint;
        }
    }
}

