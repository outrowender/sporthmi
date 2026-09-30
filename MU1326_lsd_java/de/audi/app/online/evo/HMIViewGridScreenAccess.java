/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.online.evo;

import de.audi.app.online.evo.AbstractScreenAccess;
import de.audi.app.online.evo.Decorator;
import de.audi.atip.hmi.model.ModelGroup;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.hmi.modelaccess.LabelModelApp;
import de.audi.atip.hmi.modelaccess.ListModelApp;
import de.audi.atip.hmi.modelaccess.ResourceLocatorModelApp;
import de.audi.atip.log.LogChannel;
import de.audi.remotehmi.ui.mib2.grid.IGridList;
import de.audi.tghu.online.app.remotehmi.OnlineModelBankAccess;
import de.audi.tghu.online.app.remotehmi.RemoteHMIService;

public class HMIViewGridScreenAccess
extends AbstractScreenAccess {
    private static final int MODEL_SUBTITLE = 0;
    private static final int MODEL_BREAD_CRUMB = 1;
    private static final int MODEL_MAIN_LIST = 2;
    private static final int MODEL_MEDIA_CHOICE = 3;
    private static final int MODEL_DECORATOR_IMAGE = 4;
    private static final int MODEL_DECORATOR_LAYOUT = 5;
    private static final int MODEL_DECORATOR_DEBUG = 6;
    private static final int MODEL_UPDATING = 7;
    private static final int MODEL_SDS_LINE_NUMBER = 9;
    private static final int MODEL_COUNT = 10;
    private Decorator mainDecorator;
    private Decorator optionDecorator;
    private IGridList mainGridList;
    private IGridList optionGridList;
    private AbstractScreenAccess.ModelData[] models;
    private final ModelGroup modelGroup;
    private boolean modelGroupIsMain = true;

    public HMIViewGridScreenAccess(LogChannel logChannel, RemoteHMIService remoteHMIService, ModelGroup modelGroup, OnlineModelBankAccess onlineModelBankAccess, ChoiceModelApp choiceModelApp) {
        super(choiceModelApp, logChannel);
        this.modelGroup = modelGroup;
        this.models = new AbstractScreenAccess.ModelData[10];
        this.models[0] = new AbstractScreenAccess.ModelData(onlineModelBankAccess, "subtitle", 0, true, 2300170, 2300991);
        this.models[1] = new AbstractScreenAccess.ModelData(onlineModelBankAccess, "breadCrumb", 0, true, 2300764, 2300990);
        this.models[2] = new AbstractScreenAccess.ModelData(onlineModelBankAccess, "mainList", 1, true, 2300157, 2300993);
        this.models[3] = new AbstractScreenAccess.ModelData(onlineModelBankAccess, "mediaChoice", 3, false, 2300772, 2300997);
        this.models[4] = new AbstractScreenAccess.ModelData(onlineModelBankAccess, "decoratorImage", 2, true, 2300763, 2300999);
        this.models[5] = new AbstractScreenAccess.ModelData(onlineModelBankAccess, "decoratorLayout", 3, true, 2300765, 2300996);
        this.models[6] = new AbstractScreenAccess.ModelData(onlineModelBankAccess, "decoratorDebug", 0, true, 2300854);
        this.models[7] = new AbstractScreenAccess.ModelData(onlineModelBankAccess, "updatingIcon", 3, false, OnlineModelBankAccess.getUpdatingIconChoiceId());
        this.models[9] = new AbstractScreenAccess.ModelData(onlineModelBankAccess, "lineNumber", 3, false, 2301016);
        this.mainDecorator = new Decorator(logChannel, remoteHMIService, this.getDecoratorImageModel(true), this.getDecoratorLayoutModel(true), this.getDecoratorDebugModel(true));
        this.optionDecorator = new Decorator(logChannel, remoteHMIService, this.getDecoratorImageModel(false), this.getDecoratorLayoutModel(false), this.getDecoratorDebugModel(false));
        this.refreshModelGroup(modelGroup, this.models);
    }

    private ResourceLocatorModelApp getDecoratorImageModel(boolean bl) {
        return (ResourceLocatorModelApp)this.models[4].getModel(bl);
    }

    private ChoiceModelApp getDecoratorLayoutModel(boolean bl) {
        return (ChoiceModelApp)this.models[5].getModel(bl);
    }

    private LabelModelApp getDecoratorDebugModel(boolean bl) {
        return (LabelModelApp)this.models[6].getModel(bl);
    }

    public ListModelApp getMainListModel() {
        return (ListModelApp)this.models[2].getModel(this.isMainScreen());
    }

    public LabelModelApp getSubtitleModel() {
        return (LabelModelApp)this.models[0].getModel(this.isMainScreen());
    }

    public LabelModelApp getBreadCrumbModel() {
        return (LabelModelApp)this.models[1].getModel(this.isMainScreen());
    }

    public ChoiceModelApp getMediaListModel() {
        return (ChoiceModelApp)this.models[3].getModel(this.isMainScreen());
    }

    public ChoiceModelApp getUpdatingIconModel() {
        return (ChoiceModelApp)this.models[7].getModel(this.isMainScreen());
    }

    public ChoiceModelApp getSDSLineNumberModel() {
        return (ChoiceModelApp)this.models[9].getModel(this.isMainScreen());
    }

    public Decorator getDecorator() {
        return this.isMainScreen() ? this.mainDecorator : this.optionDecorator;
    }

    public void setGridList(IGridList iGridList) {
        if (this.isMainScreen()) {
            this.mainGridList = iGridList;
        } else {
            this.optionGridList = iGridList;
        }
    }

    public IGridList getGridList() {
        return this.isMainScreen() ? this.mainGridList : this.optionGridList;
    }

    public void updateLayoutConstants(int n, int n2, int n3) {
        if (this.mainDecorator != null) {
            this.mainDecorator.updateLayoutConstants(n, n2, n3);
        }
        if (this.optionDecorator != null) {
            this.optionDecorator.updateLayoutConstants(n, n2, n3);
        }
    }

    public boolean switchScreen(boolean bl) {
        boolean bl2 = super.switchScreen(bl);
        boolean bl3 = this.isMainScreen();
        if (bl3 != this.modelGroupIsMain) {
            this.refreshModelGroup(this.modelGroup, this.models);
        }
        this.modelGroupIsMain = bl3;
        return bl2;
    }
}

