/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map;

import de.audi.tghu.navi.app.map.SatelliteMapsMediatorFSM2;
import de.audi.tghu.navi.app.map.SatelliteMapsMediatorFSM2$SatelliteMapState;

class SatelliteMapsMediatorFSM2$SatellitemapActiveState
extends SatelliteMapsMediatorFSM2$SatelliteMapState {
    boolean confirmed;
    private boolean waitForStandardMapStyleUpdateBeforeSwitchToSatMaps;
    private final /* synthetic */ SatelliteMapsMediatorFSM2 this$0;

    public SatelliteMapsMediatorFSM2$SatellitemapActiveState(SatelliteMapsMediatorFSM2 satelliteMapsMediatorFSM2, String string) {
        this.this$0 = satelliteMapsMediatorFSM2;
        super(satelliteMapsMediatorFSM2, string);
        this.confirmed = false;
        this.waitForStandardMapStyleUpdateBeforeSwitchToSatMaps = false;
    }

    @Override
    void enter() {
        SatelliteMapsMediatorFSM2.access$000(this.this$0).log(-2137614336, "SatellitemapActiveState#enter()");
        this.performConsistencyChecksForFastToggleAndSwitchToSatMap();
    }

    private void performConsistencyChecksForFastToggleAndSwitchToSatMap() {
        if (SatelliteMapsMediatorFSM2.access$900(this.this$0) == 1) {
            this.waitForStandardMapStyleUpdateBeforeSwitchToSatMaps = true;
            SatelliteMapsMediatorFSM2.access$000(this.this$0).log(-2137614336, "SatellitemapActiveState#enter() satellite was already confirmed - ensure consistency and wait for standard");
            SatelliteMapsMediatorFSM2.access$100(this.this$0, 0);
        } else {
            this.waitForStandardMapStyleUpdateBeforeSwitchToSatMaps = false;
            if (SatelliteMapsMediatorFSM2.access$1000(this.this$0) == 0) {
                SatelliteMapsMediatorFSM2.access$1100(this.this$0).showFunctionCurrentlyNotAvailableHelpTextWithTimeout();
            }
            SatelliteMapsMediatorFSM2.access$100(this.this$0, 1);
            this.this$0.setLogosAccordingToSetup();
            SatelliteMapsMediatorFSM2.access$200(this.this$0).getChoiceModel(958137856).setValue(0);
            SatelliteMapsMediatorFSM2.access$400(this.this$0, SatelliteMapsMediatorFSM2.access$300(this.this$0));
        }
    }

    @Override
    void activateSatellite() {
        SatelliteMapsMediatorFSM2.access$000(this.this$0).log(-2137614336, "SatellitemapActiveState#activateSatellite() confirmed %1", this.confirmed);
        if (this.waitForStandardMapStyleUpdateBeforeSwitchToSatMaps) {
            SatelliteMapsMediatorFSM2.access$000(this.this$0).log(-2137614336, "SatellitemapActiveState#activateSatellite() do not apply sat maps still wait for standard");
            return;
        }
        if (!this.confirmed) {
            if (SatelliteMapsMediatorFSM2.access$1000(this.this$0) == 0) {
                SatelliteMapsMediatorFSM2.access$1100(this.this$0).showFunctionCurrentlyNotAvailableHelpTextWithTimeout();
            }
            SatelliteMapsMediatorFSM2.access$000(this.this$0).log(-2137614336, "SatellitemapActiveState#activateSatellite() reapply settings as not yet confirmed");
            SatelliteMapsMediatorFSM2.access$100(this.this$0, 1);
            this.this$0.setLogosAccordingToSetup();
            SatelliteMapsMediatorFSM2.access$200(this.this$0).getChoiceModel(958137856).setValue(0);
            SatelliteMapsMediatorFSM2.access$400(this.this$0, SatelliteMapsMediatorFSM2.access$300(this.this$0));
        }
    }

    @Override
    void activateStandard() {
        SatelliteMapsMediatorFSM2.access$000(this.this$0).log(-2137614336, "SatellitemapActiveState#activateStandard()");
        SatelliteMapsMediatorFSM2.access$600(this.this$0, SatelliteMapsMediatorFSM2.access$1200(this.this$0));
    }

    @Override
    void activateTraffic() {
        SatelliteMapsMediatorFSM2.access$000(this.this$0).log(-2137614336, "StandardmapActiveState#activateSatellite()");
        SatelliteMapsMediatorFSM2.access$600(this.this$0, SatelliteMapsMediatorFSM2.access$700(this.this$0));
    }

    @Override
    void updateSatellite() {
        SatelliteMapsMediatorFSM2.access$000(this.this$0).log(-2137614336, "SatellitemapActiveState#updateSatellite()");
        this.confirmed = true;
        if (SatelliteMapsMediatorFSM2.access$1000(this.this$0) == 0) {
            int n = SatelliteMapsMediatorFSM2.access$1300(this.this$0).resolveTargetIcon(204);
            SatelliteMapsMediatorFSM2.access$000(this.this$0).log(-2137614336, "SatellitemapActiveState#updateSatellite() - resourceID for map main colored icon is : %1", (long)n);
            SatelliteMapsMediatorFSM2.access$1400(this.this$0, n);
            int n2 = SatelliteMapsMediatorFSM2.access$1300(this.this$0).resolveTargetIcon(206);
            SatelliteMapsMediatorFSM2.access$000(this.this$0).log(-2137614336, "SatellitemapActiveState#updateSatellite() - resourceID for map kombi colored icon is : %1", (long)n2);
            SatelliteMapsMediatorFSM2.access$1400(this.this$0, n2);
        }
        this.waitForStandardMapStyleUpdateBeforeSwitchToSatMaps = false;
        this.this$0.setLogosAccordingToSetup();
        SatelliteMapsMediatorFSM2.access$200(this.this$0).getChoiceModel(958137856).setValue(1);
        if (SatelliteMapsMediatorFSM2.access$1000(this.this$0) == 0) {
            SatelliteMapsMediatorFSM2.access$1100(this.this$0).redrawFunctionCurrentlyNotAvailableHelpTextWithTimeout();
        }
        SatelliteMapsMediatorFSM2.access$400(this.this$0, SatelliteMapsMediatorFSM2.access$300(this.this$0));
    }

    @Override
    void updateStandard() {
        SatelliteMapsMediatorFSM2.access$000(this.this$0).log(-2137614336, "SatellitemapActiveState#updateStandard()");
        SatelliteMapsMediatorFSM2.access$000(this.this$0).log(-2137614336, "SatellitemapActiveState#updateStandard() was sat maps confirmed %1 waitfor standard", this.confirmed, this.waitForStandardMapStyleUpdateBeforeSwitchToSatMaps);
        if (this.waitForStandardMapStyleUpdateBeforeSwitchToSatMaps) {
            SatelliteMapsMediatorFSM2.access$000(this.this$0).log(-1601830656, "SatellitemapActiveState#updateStandard()  - we had to wait wait for standard - arrived");
            this.waitForStandardMapStyleUpdateBeforeSwitchToSatMaps = false;
            if (SatelliteMapsMediatorFSM2.access$1000(this.this$0) == 0) {
                SatelliteMapsMediatorFSM2.access$1100(this.this$0).showFunctionCurrentlyNotAvailableHelpTextWithTimeout();
            }
            SatelliteMapsMediatorFSM2.access$100(this.this$0, 1);
            this.this$0.setLogosAccordingToSetup();
            SatelliteMapsMediatorFSM2.access$200(this.this$0).getChoiceModel(958137856).setValue(0);
            SatelliteMapsMediatorFSM2.access$400(this.this$0, false);
        }
        if (this.confirmed) {
            SatelliteMapsMediatorFSM2.access$000(this.this$0).log(-2137614336, "SatellitemapActiveState#updateStandard() sat maps was confirmed show Deactivatipon Popup");
            this.confirmed = false;
            this.this$0.setLogosAccordingToSetup();
            SatelliteMapsMediatorFSM2.access$200(this.this$0).getChoiceModel(958137856).setValue(0);
            if (SatelliteMapsMediatorFSM2.access$1000(this.this$0) == 0) {
                SatelliteMapsMediatorFSM2.access$1100(this.this$0).redrawFunctionCurrentlyNotAvailableHelpTextWithTimeout();
                SatelliteMapsMediatorFSM2.access$1100(this.this$0).showFunctionCurrentlyNotAvailableHelpText();
            }
        }
        SatelliteMapsMediatorFSM2.access$400(this.this$0, SatelliteMapsMediatorFSM2.access$300(this.this$0));
    }

    @Override
    public void setBlockingBit(boolean bl) {
        SatelliteMapsMediatorFSM2.access$000(this.this$0).log(-2137614336, "SatellitemapActiveState#setBlockingBit() blocked %1", bl);
        if (bl) {
            SatelliteMapsMediatorFSM2.access$600(this.this$0, SatelliteMapsMediatorFSM2.access$1500(this.this$0));
        }
    }

    @Override
    boolean isConfirmed() {
        return this.confirmed;
    }

    @Override
    void exit() {
        super.exit();
        if (SatelliteMapsMediatorFSM2.access$1000(this.this$0) == 0) {
            SatelliteMapsMediatorFSM2.access$1100(this.this$0).redrawFunctionCurrentlyNotAvailableHelpTextWithTimeout();
        }
        this.waitForStandardMapStyleUpdateBeforeSwitchToSatMaps = false;
        this.confirmed = false;
    }
}

