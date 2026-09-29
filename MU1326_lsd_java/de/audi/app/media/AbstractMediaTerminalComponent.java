/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media;

import de.audi.app.media.IMediaTerminal;
import de.audi.app.media.logger.IMediaLogger;
import de.audi.atip.hmi.model.list.BaseListModelApp;
import de.audi.atip.hmi.model.list.TiledListModelApp;
import de.audi.atip.hmi.modelaccess.ButtonModelApp;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.hmi.modelaccess.DynamicListModelApp;
import de.audi.atip.hmi.modelaccess.FastScrollingModelApp;
import de.audi.atip.hmi.modelaccess.HMIModelApp;
import de.audi.atip.hmi.modelaccess.LabelModelApp;
import de.audi.atip.hmi.modelaccess.ListModelApp;
import de.audi.atip.hmi.modelaccess.OptionModelApp;
import de.audi.atip.hmi.modelaccess.RangeModelApp;
import de.audi.atip.hmi.modelaccess.ResourceLocatorModelApp;
import de.audi.atip.hmi.modelaccess.SpellerModelApp;
import de.audi.atip.hmi.modelaccess.TooltipModelApp;
import de.audi.atip.hmi.modelaccess.VirtualButtonModelApp;

public class AbstractMediaTerminalComponent {
    private final IMediaTerminal mediaTerminal;
    protected final IMediaLogger logger;

    public AbstractMediaTerminalComponent(IMediaTerminal iMediaTerminal) {
        this.mediaTerminal = iMediaTerminal;
        this.logger = this.mediaTerminal.getLogger();
    }

    public IMediaTerminal getTerminal() {
        return this.mediaTerminal;
    }

    public HMIModelApp getModel(int n) {
        return this.mediaTerminal.getFramework().getHmiServiceApp().getModelApp(this.mediaTerminal.getTerminalID(), n);
    }

    public HMIModelApp getModel(int n, int n2) {
        return this.mediaTerminal.getFramework().getHmiServiceApp().getModelApp(n, n2);
    }

    public ButtonModelApp getButtonModel(int n) {
        return (ButtonModelApp)this.getModel(n);
    }

    public ButtonModelApp getButtonModel(int n, int n2) {
        return (ButtonModelApp)this.getModel(n, n2);
    }

    public SpellerModelApp getSpellerModel(int n) {
        return (SpellerModelApp)this.getModel(n);
    }

    public ChoiceModelApp getChoiceModel(int n) {
        return (ChoiceModelApp)this.getModel(n);
    }

    public ListModelApp getListModel(int n) {
        return (ListModelApp)this.getModel(n);
    }

    public ListModelApp getListModel(int n, int n2) {
        return (ListModelApp)this.getModel(n, n2);
    }

    public DynamicListModelApp getDynamicListModel(int n) {
        return (DynamicListModelApp)this.getModel(n);
    }

    public LabelModelApp getLabelModel(int n) {
        return (LabelModelApp)this.getModel(n);
    }

    public LabelModelApp getLabelModel(int n, int n2) {
        return (LabelModelApp)this.getModel(n, n2);
    }

    public ResourceLocatorModelApp getResourceLocatorModel(int n) {
        return (ResourceLocatorModelApp)this.getModel(n);
    }

    public RangeModelApp getRangeModel(int n) {
        return (RangeModelApp)this.getModel(n);
    }

    public RangeModelApp getRangeModel(int n, int n2) {
        return (RangeModelApp)this.getModel(n, n2);
    }

    public FastScrollingModelApp getFastScrollingModel(int n) {
        return (FastScrollingModelApp)this.getModel(n);
    }

    public TooltipModelApp getTooltipModel(int n) {
        return (TooltipModelApp)this.getModel(n);
    }

    public VirtualButtonModelApp getVirtualButtonModelModel(int n) {
        return (VirtualButtonModelApp)this.getModel(n);
    }

    public HMIModelApp getSystemModel(int n) {
        return this.mediaTerminal.getFramework().getHmiServiceApp().getModelApp(this.mediaTerminal.getTerminalID(), n);
    }

    public TiledListModelApp getTiledListModel(int n) {
        return (TiledListModelApp)this.getModel(n);
    }

    public BaseListModelApp getBaseListModel(int n) {
        return (BaseListModelApp)this.getModel(n);
    }

    public OptionModelApp getOptionModel(int n) {
        return (OptionModelApp)this.getModel(n);
    }

    public String getText(int n) {
        return this.mediaTerminal.getFramework().getHmiServiceApp().getText(n);
    }
}

