/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.dsi;

import de.audi.atip.interapp.displaymanager.Cropping;
import de.audi.tv.app.dsi.DSIHandler;
import de.audi.tv.app.dsi.DSIHandler$1;
import de.audi.tv.app.dsi.DSITV;
import org.dsi.ifc.tvtuner.ServiceInfo;

class DSIHandler$BlockedDSITVImpl
implements DSITV {
    private final /* synthetic */ DSIHandler this$0;

    private DSIHandler$BlockedDSITVImpl(DSIHandler dSIHandler) {
        this.this$0 = dSIHandler;
    }

    @Override
    public void setNormAreaSubList(int[] nArray) {
        DSIHandler.access$000(this.this$0).log(1078071040, "[DSIHandler.setNormAreaSubList] DSI is blocked");
    }

    @Override
    public void setNormArea(int n) {
        DSIHandler.access$000(this.this$0).log(1078071040, "[DSIHandler.setNormArea] DSI is blocked");
    }

    @Override
    public void setAudioChannel(int n) {
        DSIHandler.access$000(this.this$0).log(1078071040, "[DSIHandler.setAudioChannel] DSI is blocked");
    }

    @Override
    public void enableServiceLinking(boolean bl) {
        DSIHandler.access$000(this.this$0).log(1078071040, "[DSIHandler.enableServiceLinking] DSI is blocked");
    }

    @Override
    public void enableSubtitle(boolean bl) {
        DSIHandler.access$000(this.this$0).log(1078071040, "[DSIHandler.enableSubtitle] DSI is blocked");
    }

    @Override
    public void selectService(ServiceInfo serviceInfo, boolean bl) {
        DSIHandler.access$000(this.this$0).log(1078071040, "[DSIHandler.selectService] DSI is blocked");
    }

    @Override
    public void selectNextService(int n) {
        DSIHandler.access$000(this.this$0).log(1078071040, "[DSIHandler.selectNextService] DSI is blocked");
    }

    @Override
    public void changeService(ServiceInfo serviceInfo, boolean bl) {
        DSIHandler.access$000(this.this$0).log(10000, "[DSIHandler.BlockedDSITVImpl.changeService] this should not be invoked directly!");
    }

    @Override
    public void abortSeek() {
        DSIHandler.access$000(this.this$0).log(1078071040, "[DSIHandler.abortSeek] DSI is blocked");
    }

    @Override
    public void switchSource(int n, boolean bl) {
        DSIHandler.access$000(this.this$0).log(1078071040, "[DSIHandler.switchSource] DSI is blocked");
    }

    @Override
    public void setTerminalMode(int n, int n2) {
        DSIHandler.access$000(this.this$0).log(1078071040, "[DSIHandler.setTerminalMode] DSI is blocked");
    }

    @Override
    public void setTMTVKeyPanel(short s, short s2) {
        DSIHandler.access$000(this.this$0).log(1078071040, "[DSIHandler.setTMTVKeyPanel] DSI is blocked");
    }

    @Override
    public void incMoved(int n) {
        DSIHandler.access$000(this.this$0).log(1078071040, "[DSIHandler.incMoved] DSI is blocked");
    }

    @Override
    public void setAVNorm(int n) {
        DSIHandler.access$000(this.this$0).log(1078071040, "[DSIHandler.setAVNorm] DSI is blocked");
    }

    @Override
    public void setBrowserListSort(int n) {
        DSIHandler.access$000(this.this$0).log(1078071040, "[DSIHandler.setChannelSorting] DSI is blocked");
    }

    @Override
    public void setCropping(Cropping cropping, int n, int n2, int n3, int n4, int n5, int n6) {
        DSIHandler.access$000(this.this$0).log(1078071040, "[DSIHandler.setCropping] DSI is blocked");
    }

    @Override
    public void setBrightness(int n, int n2) {
        DSIHandler.access$000(this.this$0).log(1078071040, "[DSIHandler.setBrightness] DSI is blocked");
    }

    @Override
    public void setContrast(int n, int n2) {
        DSIHandler.access$000(this.this$0).log(1078071040, "[DSIHandler.setContrast] DSI is blocked");
    }

    @Override
    public void setColor(int n, int n2) {
        DSIHandler.access$000(this.this$0).log(1078071040, "[DSIHandler.setColor] DSI is blocked");
    }

    @Override
    public void setTint(int n, int n2) {
        DSIHandler.access$000(this.this$0).log(1078071040, "[DSIHandler.setTint] DSI is blocked");
    }

    @Override
    public void startComponent(int n) {
        DSIHandler.access$000(this.this$0).log(1078071040, "[DSIHandler.startComponent] DSI is blocked");
    }

    @Override
    public void startComponent(int n, int n2, int n3) {
        DSIHandler.access$000(this.this$0).log(1078071040, "[DSIHandler.startComponent] DSI is blocked");
    }

    @Override
    public void stopComponent(int n) {
        DSIHandler.access$000(this.this$0).log(1078071040, "[DSIHandler.stopComponent] DSI is blocked");
    }

    @Override
    public void stopComponent(int n, int n2, int n3) {
        DSIHandler.access$000(this.this$0).log(1078071040, "[DSIHandler.stopComponent] DSI is blocked");
    }

    /* synthetic */ DSIHandler$BlockedDSITVImpl(DSIHandler dSIHandler, DSIHandler$1 dSIHandler$1) {
        this(dSIHandler);
    }
}

