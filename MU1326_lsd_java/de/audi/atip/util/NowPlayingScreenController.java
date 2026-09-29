/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.util;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.log.LogChannel;
import de.audi.atip.storage.IStorageAccess;
import de.audi.atip.util.NowPlayingScreenController$ChoiceListener;
import org.osgi.util.tracker.ServiceTracker;

public class NowPlayingScreenController {
    private static int HMI_ENABLED = 1;
    private static int HMI_DISABLED = 0;
    private final IStorageAccess storage;
    private final ChoiceModelApp model;
    private final LogChannel logger;
    protected ServiceTracker tracker;

    public NowPlayingScreenController(IFrameworkAccess iFrameworkAccess, LogChannel logChannel) {
        this.model = iFrameworkAccess.getHmiServiceApp().getChoiceModel(180);
        this.storage = iFrameworkAccess.getStorageMgr();
        this.logger = logChannel;
    }

    public void init() {
        this.logger.log(1078071040, "[NowPlayingScreenController.init]");
        this.model.setChoiceListener(new NowPlayingScreenController$ChoiceListener(this, null));
        this.checkEvaluation();
    }

    private void checkEvaluation() {
        boolean bl = this.storage.getBoolean(1002, 220, false);
        this.logger.log(1078071040, "[NowPlayingScreenController.checkEvaluation] value from persistence: %1", bl);
        int n = bl ? HMI_ENABLED : HMI_DISABLED;
        this.model.setValue(n);
    }

    public void deinit() {
    }

    public void resetToFactorySettings() {
        this.logger.log(-2137614336, "[NowPlayingScreenController.resetToFactorySettings]");
        this.model.setValue(HMI_ENABLED);
        this.storage.setBoolean(1002, 220, true);
    }

    static /* synthetic */ LogChannel access$100(NowPlayingScreenController nowPlayingScreenController) {
        return nowPlayingScreenController.logger;
    }

    static /* synthetic */ ChoiceModelApp access$200(NowPlayingScreenController nowPlayingScreenController) {
        return nowPlayingScreenController.model;
    }

    static /* synthetic */ int access$300() {
        return HMI_ENABLED;
    }

    static /* synthetic */ IStorageAccess access$400(NowPlayingScreenController nowPlayingScreenController) {
        return nowPlayingScreenController.storage;
    }
}

