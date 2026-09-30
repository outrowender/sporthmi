/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.cas;

import de.audi.atip.hmi.model.DefaultButtonListener;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.tv.app.base.TVEnv;
import de.audi.tv.app.base.TVEventDefaultListener;
import de.audi.tv.app.dsi.DSICallListener;
import de.audi.tv.app.dsi.DefaultTVListener;
import de.audi.tv.app.tm.KeyPanelHandler;
import org.dsi.ifc.tvtuner.ProgramInfo;
import org.dsi.ifc.tvtuner.ServiceInfo;

public class CasDisclaimer {
    private static final int HIDE_CAS_DISCLAIMER = 0;
    private static final int SHOW_CAS_DISCLAIMER = 1;
    public final DefaultTVListener tvListener = new TVListenerImpl();
    public final TVEventListener eventListener = new TVEventListener();
    public final DSICallListener callListener = new SelectionListener();
    private final TVEnv env;
    private final KeyPanelHandler keyPanelHandler;
    private volatile boolean isCasDisclaimerActive = false;
    private volatile boolean isAVActive = false;
    private volatile boolean isEnergySavingModeActive = false;
    private final ChoiceModelApp showCasDisclaimerChoice;

    public CasDisclaimer(TVEnv tVEnv, KeyPanelHandler keyPanelHandler) {
        this.env = tVEnv;
        this.keyPanelHandler = keyPanelHandler;
        tVEnv.getButtonModel(2600213).setButtonListener(new CasDisclaimerDismissButtonHandler());
        this.showCasDisclaimerChoice = tVEnv.getChoiceModel(2600081);
        this.showCasDisclaimerChoice.setValue(0);
        this.showCasDisclaimerChoice.forceUpdate(true);
    }

    private void show(boolean bl) {
        if (!this.isCasDisclaimerActive || bl) {
            this.env.lcDSI.log(1000000, "[CasDisclaimer.show] reshowOverride: %1", bl);
            this.env.properties.terminalMode.desiredTerminalMode.accept(new Integer(12));
            this.showCasDisclaimerChoice.setValue(1);
            this.isCasDisclaimerActive = true;
        }
    }

    private void hide() {
        if (this.isCasDisclaimerActive) {
            this.env.lcDSI.log(1000000, "[CasDisclaimer.hide]");
            this.showCasDisclaimerChoice.setValue(0);
            this.isCasDisclaimerActive = false;
        }
    }

    private class TVListenerImpl
    extends DefaultTVListener {
        private int currentCasStatus = -1;

        private TVListenerImpl() {
        }

        public void updateSelectedService(ProgramInfo programInfo) {
            int n = programInfo.casStatus;
            if (this.currentCasStatus != n) {
                ((CasDisclaimer)CasDisclaimer.this).env.lcDSI.log(1000000, "[CasDisclaimer.updateSelectedService] casStatus:0x%1", (long)n);
                if (n == 5) {
                    CasDisclaimer.this.show(false);
                } else {
                    CasDisclaimer.this.hide();
                }
                this.currentCasStatus = n;
            }
        }

        public void updateSelectedSource(int n) {
            ((CasDisclaimer)CasDisclaimer.this).env.lcDSI.log(1000000, "[CasDisclaimer.updateSelectedSource] selectedSource: %3, casDiscActive: %1, isAvActive %2", (Object)CasDisclaimer.this.isCasDisclaimerActive, (Object)CasDisclaimer.this.isAVActive, (long)n);
            if (!CasDisclaimer.this.isAVActive && CasDisclaimer.this.isCasDisclaimerActive) {
                CasDisclaimer.this.show(true);
            }
        }

        public void updateTerminalMode(int n, int n2) {
            ((CasDisclaimer)CasDisclaimer.this).env.lcDSI.log(1000000, "[CasDisclaimer.updateTerminalMode] tm: 0x%3, casDiscActive: %1, isAvActive %2, isEnergySavingModeActive %4", (Object)CasDisclaimer.this.isCasDisclaimerActive, (Object)CasDisclaimer.this.isAVActive, (Object)new Integer(n), (Object)CasDisclaimer.this.isEnergySavingModeActive);
            if (!CasDisclaimer.this.isEnergySavingModeActive && !CasDisclaimer.this.isAVActive && CasDisclaimer.this.isCasDisclaimerActive && n != 12) {
                CasDisclaimer.this.show(true);
            }
        }

        public void updateTunerState(int n) {
            if (n == 0 && CasDisclaimer.this.isCasDisclaimerActive) {
                CasDisclaimer.this.hide();
                this.currentCasStatus = -1;
            }
        }
    }

    private class TVEventListener
    extends TVEventDefaultListener {
        private TVEventListener() {
        }

        public void onAppActivated(int n) {
            ((CasDisclaimer)CasDisclaimer.this).env.lcDSI.log(1000000, "[CasDisclaimer.onAppActivated] casDiscActive: %1 isAvActive: %2 isEnergySavingModeActive: %3", CasDisclaimer.this.isCasDisclaimerActive, CasDisclaimer.this.isAVActive, CasDisclaimer.this.isEnergySavingModeActive);
            if (!CasDisclaimer.this.isEnergySavingModeActive && !CasDisclaimer.this.isAVActive && CasDisclaimer.this.isCasDisclaimerActive) {
                CasDisclaimer.this.show(true);
            }
        }

        public void onEsmEntered() {
            ((CasDisclaimer)CasDisclaimer.this).env.lcDSI.log(1000000, "[CasDisclaimer.onEsmEntered]");
            CasDisclaimer.this.isEnergySavingModeActive = true;
        }

        public void onEsmLeft() {
            ((CasDisclaimer)CasDisclaimer.this).env.lcDSI.log(1000000, "[CasDisclaimer.onEsmLeft] casDiscActive: %1 isAvActive: %2", CasDisclaimer.this.isCasDisclaimerActive, CasDisclaimer.this.isAVActive);
            CasDisclaimer.this.isEnergySavingModeActive = false;
            if (!CasDisclaimer.this.isAVActive && CasDisclaimer.this.isCasDisclaimerActive) {
                CasDisclaimer.this.show(true);
            }
        }
    }

    private class SelectionListener
    extends DSICallListener {
        private SelectionListener() {
        }

        public void selectService(ServiceInfo serviceInfo, boolean bl) {
            CasDisclaimer.this.env.getChoiceModel(2600082).setValue(0);
        }

        public void selectNextService(int n) {
            CasDisclaimer.this.env.getChoiceModel(2600082).setValue(0);
        }

        public void switchSource(int n, boolean bl) {
            CasDisclaimer.this.isAVActive = n == 1;
        }
    }

    private class CasDisclaimerDismissButtonHandler
    extends DefaultButtonListener {
        private CasDisclaimerDismissButtonHandler() {
        }

        public void keyReleased(int n, int n2, int n3) {
            CasDisclaimer.this.env.getButtonModel(n).fireEvent(n3);
            CasDisclaimer.this.keyPanelHandler.externalKeyPressed((short)3);
        }
    }
}

