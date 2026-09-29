/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager;

import de.audi.app.sdsmanager.SDSModelAccess;
import de.audi.atip.hmi.model.AbstractModelBank;
import de.audi.atip.hmi.model.ButtonModel;
import de.audi.atip.hmi.model.HMIModel;
import de.audi.atip.hmi.modelaccess.ButtonModelApp;

public class SDSModelAccess$SDSModelBank
extends AbstractModelBank {
    public static final int PTT_BUTTON;
    public static final int PTT_LONG_BUTTON;
    public static final int PTT_DOUBLECLICK_BUTTON;
    static final int PTT_OFF_BUTTON;
    private ButtonModelApp pttButton;
    private ButtonModelApp pttLongButton;
    private ButtonModelApp pttDoubleClickButton;
    private ButtonModelApp pttOffButton;
    private final /* synthetic */ SDSModelAccess this$0;

    SDSModelAccess$SDSModelBank(SDSModelAccess sDSModelAccess) {
        this.this$0 = sDSModelAccess;
        super(14, 5, 4);
        this.pttButton = new ButtonModel(-1050929920);
        this.pttLongButton = new ButtonModel(-1034152704);
        this.pttDoubleClickButton = new ButtonModel(-1017375488);
        this.pttOffButton = new ButtonModel(-1000598272);
        this.pttButton.setButtonListener(SDSModelAccess.access$000(sDSModelAccess));
        this.pttLongButton.setButtonListener(SDSModelAccess.access$000(sDSModelAccess));
        this.pttDoubleClickButton.setButtonListener(SDSModelAccess.access$000(sDSModelAccess));
        this.pttOffButton.setButtonListener(SDSModelAccess.access$000(sDSModelAccess));
        this.models[1] = (HMIModel)((Object)this.pttButton);
        this.models[2] = (HMIModel)((Object)this.pttLongButton);
        this.models[3] = (HMIModel)((Object)this.pttDoubleClickButton);
        this.models[4] = (HMIModel)((Object)this.pttOffButton);
    }

    @Override
    protected void createModel(int n) {
        SDSModelAccess.access$100().log(-2137614336, "SDSModelAccess#createModel: modelIdx=%1", (long)n);
    }
}

