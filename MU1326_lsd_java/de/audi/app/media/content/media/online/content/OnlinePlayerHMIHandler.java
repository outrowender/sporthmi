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
    private static final String LOGCLASS = "OnlinePlayerHMIHandler";
    private final ModelGroup trackDetailsModelGroup = new ModelGroup();
    private final ModelGroup playPositionModelGroup = new ModelGroup();

    public OnlinePlayerHMIHandler(IMediaTerminal iMediaTerminal) {
        super(iMediaTerminal);
    }

    public void init() {
        this.logger.main().log(1000000, "[%1.init]", (Object)LOGCLASS);
        RangeModelApp rangeModelApp = this.getRangeModel(200729);
        rangeModelApp.setLimits(0, 100, 1);
        rangeModelApp.setValue(0);
        this.trackDetailsModelGroup.add(this.getModel(200730));
        this.trackDetailsModelGroup.add(this.getModel(200727));
        this.trackDetailsModelGroup.add(this.getModel(200728));
        this.playPositionModelGroup.add(this.getModel(200731));
        this.playPositionModelGroup.add(this.getModel(200732));
        this.playPositionModelGroup.add(rangeModelApp);
    }

    public void deinit() {
        this.logger.main().log(1000000, "[%1.deinit]", (Object)LOGCLASS);
        this.clearTitleData();
        this.setPlayTime("-:-", "-:-", 0);
        this.setEntryPointID(0);
        this.setPlayTimeCapabilities(false, false);
        this.trackDetailsModelGroup.removeAll();
        this.playPositionModelGroup.removeAll();
    }

    protected void setTitleData(String string, String string2, String string3) {
        this.getLabelModel(200730).setText(string);
        this.getLabelModel(200728).setText(string3);
        this.getLabelModel(200727).setText(string2);
        this.trackDetailsModelGroup.flush();
    }

    protected void clearTitleData() {
        this.logger.hmi().log(1000000, "[%1.clearTitleData]", (Object)LOGCLASS);
        this.getLabelModel(200730).setText("");
        this.getLabelModel(200728).setText("");
        this.getLabelModel(200727).setText("");
        this.trackDetailsModelGroup.flush();
    }

    protected void setPlayTime(String string, String string2, int n) {
        this.getLabelModel(200731).setText(string);
        this.getLabelModel(200732).setText(string2);
        this.getRangeModel(200729).setValue(n);
        this.playPositionModelGroup.flush();
    }

    protected void setPlayTimeCapabilities(boolean bl, boolean bl2) {
        this.getChoiceModel(200244).setValue(bl ? 1 : 0);
        this.getChoiceModel(200237).setValue(bl2 ? 1 : 0);
    }

    protected void setEntryPointID(int n) {
        this.logger.main().log(100000000, "[%1.setEntryPointID] %2", (Object)LOGCLASS, (long)n);
        this.getChoiceModel(200983).setValue(n);
    }
}

