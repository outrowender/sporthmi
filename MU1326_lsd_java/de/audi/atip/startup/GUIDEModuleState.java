/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.startup;

import de.audi.atip.startup.AppStateManager;
import de.audi.atip.startup.ComponentState;
import de.audi.atip.startup.config.GuideModule;
import java.io.PrintStream;
import java.util.List;
import org.osgi.framework.Bundle;

public class GUIDEModuleState {
    public static final int MODULE_ID_UNDEFINED = -1;
    public static final int SM_STATUS_ERROR = -1;
    protected static final int SM_STATUS_DEFINED = 0;
    public static final int SM_STATUS_ACTIVATED = 1;
    protected static final int SM_STATUS_REGISTERED = 2;
    private final ComponentState componentState;
    private final Bundle smm;
    private final Bundle hmi;
    private final int moduleId;
    private int smState = 0;

    GUIDEModuleState(AppStateManager appStateManager, ComponentState componentState, GuideModule guideModule) {
        this.componentState = componentState;
        this.moduleId = guideModule.getModuleId();
        this.smm = appStateManager.getBundle(guideModule.getSMMBundle());
        this.hmi = appStateManager.getBundle(guideModule.getHMIBundle());
        this.setSMState(0);
    }

    GUIDEModuleState() {
        this.componentState = null;
        this.moduleId = -1;
        this.smm = null;
        this.hmi = null;
    }

    public ComponentState getComponentState() {
        return this.componentState;
    }

    private Bundle getBundleHMI() {
        return this.hmi;
    }

    private Bundle getBundleSMM() {
        return this.smm;
    }

    public void enqueueStartBundles(List list, boolean bl) {
        if (bl) {
            this.componentState.enqueueStartBundle(list, this.getBundleSMM(), bl);
            this.componentState.enqueueStartBundle(list, this.getBundleHMI(), bl);
        } else {
            this.componentState.enqueueStartBundle(list, this.getBundleHMI(), bl);
            this.componentState.enqueueStartBundle(list, this.getBundleSMM(), bl);
        }
    }

    public void enqueueStopBundles(List list, boolean bl) {
        if (bl) {
            this.componentState.enqueueStopBundle(list, this.getBundleHMI(), bl);
            this.componentState.enqueueStopBundle(list, this.getBundleSMM(), bl);
        } else {
            this.componentState.enqueueStopBundle(list, this.getBundleSMM(), bl);
            this.componentState.enqueueStopBundle(list, this.getBundleHMI(), bl);
        }
    }

    public int getModuleId() {
        return this.moduleId;
    }

    private int getSMState() {
        return this.smState;
    }

    public boolean isActive() {
        return this.smState >= 2;
    }

    public final void setSMState(int n) {
        if (n < 0 || n == 0 && n < this.smState || n > this.smState) {
            this.smState = n;
            if (this.componentState != null) {
                this.componentState.stateUpdate();
            }
        }
    }

    public void dump(PrintStream printStream) {
        printStream.print("  GUIDE module:");
        printStream.print("  ModuleId = ");
        printStream.print(this.getModuleId());
        if (this.getBundleSMM() != null) {
            printStream.print(" smm: ");
            printStream.print(this.getBundleSMM().getLocation());
        }
        if (this.getBundleHMI() != null) {
            printStream.print(" hmi: ");
            printStream.print(this.getBundleHMI().getLocation());
        }
        printStream.print(" smState = ");
        printStream.print(this.getSMState());
        printStream.println();
    }

    private void addBundleIfPresent(List list, Bundle bundle) {
        if (bundle != null) {
            list.add(bundle);
        }
    }

    public void appendBundles(List list) {
        this.addBundleIfPresent(list, this.getBundleHMI());
        this.addBundleIfPresent(list, this.getBundleSMM());
    }
}

