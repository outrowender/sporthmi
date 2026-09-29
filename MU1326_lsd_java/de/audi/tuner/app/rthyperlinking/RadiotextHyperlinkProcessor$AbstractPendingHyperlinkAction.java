/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.rthyperlinking;

import de.audi.tuner.app.TunerBasics;
import de.audi.tuner.app.TunerModels;
import de.audi.tuner.app.rthyperlinking.IPendingHyperlinkAction;
import de.audi.tuner.app.rthyperlinking.RadiotextHyperlinkProcessor;

public abstract class RadiotextHyperlinkProcessor$AbstractPendingHyperlinkAction
implements IPendingHyperlinkAction {
    public static final int ACTIONTYPE_NAV;
    public static final int ACTIONTYPE_PHONE;
    public static final int ACTIONTYPE_SMS;
    public static final int ACTIONTYPE_MAIL;
    private final RadiotextHyperlinkProcessor processor;
    protected final TunerModels models;
    protected final int actionType;
    protected final String hyperlinkContent;
    protected final TunerBasics basics;

    public RadiotextHyperlinkProcessor$AbstractPendingHyperlinkAction(RadiotextHyperlinkProcessor radiotextHyperlinkProcessor, TunerBasics tunerBasics, int n, String string) {
        this.processor = radiotextHyperlinkProcessor;
        this.models = tunerBasics.getModels();
        this.actionType = n;
        this.hyperlinkContent = string;
        this.basics = tunerBasics;
    }

    @Override
    public void prepare() {
        RadiotextHyperlinkProcessor.access$100(this.processor, this);
        this.models.getLabelModel(-1081540352).setText(this.hyperlinkContent);
        this.models.getChoiceModel(-1098317568).setValue(this.actionType);
    }
}

