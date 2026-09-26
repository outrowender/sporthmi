/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.dsi;

import de.audi.atip.interapp.displaymanager.Cropping;
import de.audi.tv.app.dsi.DSIHandler;
import de.audi.tv.app.dsi.DSIHandler$1;
import de.audi.tv.app.dsi.DSITV;
import org.dsi.ifc.tvtuner.ServiceInfo;

class DSIHandler$DSITVImpl
implements DSITV {
    private final /* synthetic */ DSIHandler this$0;

    private DSIHandler$DSITVImpl(DSIHandler dSIHandler) {
        this.this$0 = dSIHandler;
    }

    @Override
    public void setNormAreaSubList(int[] nArray) {
        DSIHandler.access$900(this.this$0).setNormAreaSubList(nArray);
    }

    @Override
    public void setNormArea(int n) {
        DSIHandler.access$900(this.this$0).setNormArea(n);
    }

    @Override
    public void setAudioChannel(int n) {
        DSIHandler.access$900(this.this$0).setAudioChannel(n);
    }

    @Override
    public void enableServiceLinking(boolean bl) {
        DSIHandler.access$900(this.this$0).enableServiceLinking(bl);
    }

    @Override
    public void enableSubtitle(boolean bl) {
        DSIHandler.access$900(this.this$0).enableSubtitle(bl);
    }

    @Override
    public void selectService(ServiceInfo serviceInfo, boolean bl) {
        DSIHandler.access$900(this.this$0).selectService(serviceInfo.namePID, serviceInfo.servicePID, serviceInfo.sType);
    }

    @Override
    public void changeService(ServiceInfo serviceInfo, boolean bl) {
        DSIHandler.access$000(this.this$0).log(10000, "[DSIHandler.DSITVImpl.changeService] this should not be invoked directly!");
    }

    @Override
    public void selectNextService(int n) {
        DSIHandler.access$900(this.this$0).selectNextService(n, 2);
    }

    @Override
    public void abortSeek() {
        DSIHandler.access$900(this.this$0).abortSeek();
    }

    @Override
    public void switchSource(int n, boolean bl) {
        DSIHandler.access$900(this.this$0).switchSource(n);
    }

    @Override
    public void setTerminalMode(int n, int n2) {
        DSIHandler.access$900(this.this$0).setTerminalMode(n, n2);
    }

    @Override
    public void setTMTVKeyPanel(short s, short s2) {
        DSIHandler.access$900(this.this$0).setTMTVKeyPanel(s, s2);
    }

    @Override
    public void incMoved(int n) {
        DSIHandler.access$900(this.this$0).incMoved((byte)n);
    }

    @Override
    public void setAVNorm(int n) {
        DSIHandler.access$900(this.this$0).setAVNorm(n);
    }

    @Override
    public void setBrowserListSort(int n) {
        DSIHandler.access$900(this.this$0).setBrowserListSort(n);
    }

    @Override
    public void setCropping(Cropping cropping, int n, int n2, int n3, int n4, int n5, int n6) {
        DSIHandler.access$1000(this.this$0).setCropping(n, n2, n3, n4, n5, n6, cropping.tgtX, cropping.tgtY, cropping.tgtWidth, cropping.tgtHeight);
    }

    @Override
    public void setBrightness(int n, int n2) {
        DSIHandler.access$1000(this.this$0).setBrightness(n, n2);
    }

    @Override
    public void setContrast(int n, int n2) {
        DSIHandler.access$1000(this.this$0).setContrast(n, n2);
    }

    @Override
    public void setColor(int n, int n2) {
        DSIHandler.access$1000(this.this$0).setColor(n, n2);
    }

    @Override
    public void setTint(int n, int n2) {
        DSIHandler.access$1000(this.this$0).setTint(n, n2);
    }

    @Override
    public void startComponent(int n) {
        DSIHandler.access$1100(this.this$0).activateComponent(n);
    }

    @Override
    public void startComponent(int n, int n2, int n3) {
        this.startComponent(n);
    }

    @Override
    public void stopComponent(int n) {
        DSIHandler.access$1100(this.this$0).deactivateComponent(n);
    }

    @Override
    public void stopComponent(int n, int n2, int n3) {
        this.stopComponent(n);
    }

    /* synthetic */ DSIHandler$DSITVImpl(DSIHandler dSIHandler, DSIHandler$1 dSIHandler$1) {
        this(dSIHandler);
    }
}

