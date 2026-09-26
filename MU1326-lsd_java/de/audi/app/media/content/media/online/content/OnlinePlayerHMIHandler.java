/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.content.media.online.content;

import de.audi.app.media.AbstractMediaTerminalComponent;
import de.audi.app.media.IMediaTerminal;
import de.audi.atip.hmi.model.ModelGroup;
import de.audi.atip.hmi.modelaccess.RangeModelApp;

public class OnlinePlayerHMIHandler
extends AbstractMediaTerminalComponent {
    private static final String LOGCLASS;
    private final ModelGroup trackDetailsModelGroup = new ModelGroup();
    private final ModelGroup playPositionModelGroup = new ModelGroup();

    public OnlinePlayerHMIHandler(IMediaTerminal iMediaTerminal) {
        super(iMediaTerminal);
    }

    public void init() {
        this.logger.main().log(1078071040, "[%1.init]", (Object)"OnlinePlayerHMIHandler");
        RangeModelApp rangeModelApp = this.getRangeModel(420479744);
        rangeModelApp.setLimits(0, 100, 1);
        rangeModelApp.setValue(0);
        this.trackDetailsModelGroup.add(this.getModel(437256960));
        this.trackDetailsModelGroup.add(this.getModel(386925312));
        this.trackDetailsModelGroup.add(this.getModel(403702528));
        this.playPositionModelGroup.add(this.getModel(454034176));
        this.playPositionModelGroup.add(this.getModel(470811392));
        this.playPositionModelGroup.add(rangeModelApp);
    }

    public void deinit() {
        this.logger.main().log(1078071040, "[%1.deinit]", (Object)"OnlinePlayerHMIHandler");
        this.clearTitleData();
        this.setPlayTime("-:-", "-:-", 0);
        this.setEntryPointID(0);
        this.setPlayTimeCapabilities(false, false);
        this.trackDetailsModelGroup.removeAll();
        this.playPositionModelGroup.removeAll();
    }

    protected void setTitleData(String string, String string2, String string3) {
        this.getLabelModel(437256960).setText(string);
        this.getLabelModel(403702528).setText(string3);
        this.getLabelModel(386925312).setText(string2);
        this.trackDetailsModelGroup.flush();
    }

    protected void clearTitleData() {
        this.logger.hmi().log(1078071040, "[%1.clearTitleData]", (Object)"OnlinePlayerHMIHandler");
        this.getLabelModel(437256960).setText("");
        this.getLabelModel(403702528).setText("");
        this.getLabelModel(386925312).setText("");
        this.trackDetailsModelGroup.flush();
    }

    protected void setPlayTime(String string, String string2, int n) {
        this.getLabelModel(454034176).setText(string);
        this.getLabelModel(470811392).setText(string2);
        this.getRangeModel(420479744).setValue(n);
        this.playPositionModelGroup.flush();
    }

    protected void setPlayTimeCapabilities(boolean bl, boolean bl2) {
        this.getChoiceModel(873333504).setValue(bl ? 1 : 0);
        this.getChoiceModel(755892992).setValue(bl2 ? 1 : 0);
    }

    protected void setEntryPointID(int n) {
        this.logger.main().log(14808325, "[%1.setEntryPointID] %2", (Object)"OnlinePlayerHMIHandler", (long)n);
        this.getChoiceModel(386990848).setValue(n);
    }
}

