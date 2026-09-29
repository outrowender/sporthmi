/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.osr.license;

import de.audi.atip.hmi.model.list.BaseListModelListener;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.online.app.osr.license.LicenseCollectionService;
import de.audi.tghu.online.app.osr.license.LicenseModelManager;
import de.audi.tghu.online.app.remotehmi.RemoteHMIService;

public class LicenseHmiListener
implements BaseListModelListener {
    protected static final int DETAIL_TEASER_EXPIRED;
    protected static final int DETAIL_TEASER;
    protected static final int DETAIL_EXPIRED;
    protected static final int DETAIL_ACTIVE_NEXT;
    protected static final int DETAIL_ACTIVE;
    protected static final int DETAIL_LICENSE_ERROR;
    protected static final int DETAIL_NOT_LICENSED;
    protected static final int DETAIL_NOT_ACTVIATED;
    protected static final int DETAIL_OFFERED;
    protected LogChannel log;
    protected LicenseCollectionService controller;
    protected LicenseModelManager modelManager;
    protected RemoteHMIService remoteHMIService;

    public LicenseHmiListener(LogChannel logChannel, LicenseCollectionService licenseCollectionService, RemoteHMIService remoteHMIService) {
        this.log = logChannel;
        this.controller = licenseCollectionService;
        this.remoteHMIService = remoteHMIService;
        logChannel.log(-2137614336, "LicenseHMIListener#ctor: Called.");
    }

    public void setModelManager(LicenseModelManager licenseModelManager) {
        this.modelManager = licenseModelManager;
        this.init();
    }

    public void init() {
    }

    public void deinit() {
    }

    @Override
    public void itemReleased(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
    }

    @Override
    public void itemSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
    }

    @Override
    public void itemFocused(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
    }

    @Override
    public void itemLongSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
    }
}

