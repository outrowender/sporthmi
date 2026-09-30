/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.util;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.hmi.model.listener.DefaultChoiceListener;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.log.LogChannel;
import de.audi.atip.storage.IStorageAccess;
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
        this.logger.log(1000000, "[NowPlayingScreenController.init]");
        this.model.setChoiceListener(new ChoiceListener());
        this.checkEvaluation();
    }

    private void checkEvaluation() {
        boolean bl = this.storage.getBoolean(1002, 220, false);
        this.logger.log(1000000, "[NowPlayingScreenController.checkEvaluation] value from persistence: %1", bl);
        int n = bl ? HMI_ENABLED : HMI_DISABLED;
        this.model.setValue(n);
    }

    public void deinit() {
    }

    public void resetToFactorySettings() {
        this.logger.log(10000000, "[NowPlayingScreenController.resetToFactorySettings]");
        this.model.setValue(HMI_ENABLED);
        this.storage.setBoolean(1002, 220, true);
    }

    private class ChoiceListener
    extends DefaultChoiceListener {
        private ChoiceListener() {
        }

        public void itemSelected(int n, int n2, int n3, int n4) {
            NowPlayingScreenController.this.logger.log(10000000, "[NowPlayingScreenController.itemSelected] '%1'", (long)n2);
            NowPlayingScreenController.this.model.setValue(n2);
            boolean bl = n2 == HMI_ENABLED;
            NowPlayingScreenController.this.storage.setBoolean(1002, 220, bl);
        }
    }
}

