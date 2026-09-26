/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.variant;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.hmi.IHMIServiceApp;
import de.audi.atip.hmi.model.list.BaseListModelApp;
import de.audi.atip.hmi.model.list.TiledListModelApp;
import de.audi.atip.hmi.model.menu.MenuModelApp;
import de.audi.atip.hmi.model.property.PropertyModelApp;
import de.audi.atip.hmi.modelaccess.BrowserModelApp;
import de.audi.atip.hmi.modelaccess.BufferedFolderListModelApp;
import de.audi.atip.hmi.modelaccess.ButtonModelApp;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.hmi.modelaccess.DataModelApp;
import de.audi.atip.hmi.modelaccess.DynamicListModelApp;
import de.audi.atip.hmi.modelaccess.FastScrollingModelApp;
import de.audi.atip.hmi.modelaccess.HMIModelApp;
import de.audi.atip.hmi.modelaccess.LabelModelApp;
import de.audi.atip.hmi.modelaccess.ListModelApp;
import de.audi.atip.hmi.modelaccess.MatchspellerModelApp;
import de.audi.atip.hmi.modelaccess.MetricsModelApp;
import de.audi.atip.hmi.modelaccess.OptionModelApp;
import de.audi.atip.hmi.modelaccess.RangeModelApp;
import de.audi.atip.hmi.modelaccess.ResourceLocatorModelApp;
import de.audi.atip.hmi.modelaccess.SlidingListModelApp;
import de.audi.atip.hmi.modelaccess.SpellerModelApp;
import de.audi.atip.hmi.modelaccess.TextfieldModelApp;
import de.audi.atip.hmi.modelaccess.TooltipModelApp;
import de.audi.atip.hmi.modelaccess.VirtualButtonModelApp;
import de.audi.atip.log.LogChannel;
import de.audi.atip.variant.IIDMapper;

public abstract class AbstractModelEnvironment {
    protected final IFrameworkAccess framework;
    private final IIDMapper textConstantsMapper;
    private final IIDMapper smEventConstantsMapper;

    public AbstractModelEnvironment(IFrameworkAccess iFrameworkAccess, IIDMapper iIDMapper, IIDMapper iIDMapper2) {
        this.textConstantsMapper = iIDMapper;
        this.framework = iFrameworkAccess;
        this.smEventConstantsMapper = iIDMapper2;
    }

    public abstract LogChannel getLogChannel() {
    }

    public final IFrameworkAccess getFramework() {
        return this.framework;
    }

    public final IHMIServiceApp getHMIService() {
        return this.framework.getHmiServiceApp();
    }

    public final LogChannel getLogChannel(String string) {
        return this.framework.getLogChannel(string);
    }

    public LabelModelApp getLabelModel(int n) {
        return this.getHMIService().getLabelModel(n);
    }

    public LabelModelApp getLabelModel(int n, int n2) {
        return this.getHMIService().getLabelModel(n, n2);
    }

    public ButtonModelApp getButtonModel(int n) {
        return this.getHMIService().getButtonModel(n);
    }

    public ButtonModelApp getButtonModel(int n, int n2) {
        return this.getHMIService().getButtonModel(n, n2);
    }

    public RangeModelApp getRangeModel(int n) {
        return this.getHMIService().getRangeModel(n);
    }

    public RangeModelApp getRangeModel(int n, int n2) {
        return this.getHMIService().getRangeModel(n, n2);
    }

    public ChoiceModelApp getChoiceModel(int n) {
        return this.getHMIService().getChoiceModel(n);
    }

    public ChoiceModelApp getChoiceModel(int n, int n2) {
        return this.getHMIService().getChoiceModel(n, n2);
    }

    public ListModelApp getListModel(int n) {
        return this.getHMIService().getListModel(n);
    }

    public TiledListModelApp getTiledListModel(int n) {
        return this.getHMIService().getTiledListModel(n);
    }

    public BaseListModelApp getBaseListModel(int n) {
        return this.getHMIService().getBaseListModel(n);
    }

    public ListModelApp getListModel(int n, int n2) {
        return this.getHMIService().getListModel(n, n2);
    }

    public SlidingListModelApp getSlidingListModel(int n) {
        return this.getHMIService().getSlidingListModel(n);
    }

    public SpellerModelApp getSpellerModel(int n) {
        return this.getHMIService().getSpellerModel(n);
    }

    public SpellerModelApp getSpellerModel(int n, int n2) {
        return this.getHMIService().getSpellerModel(n, n2);
    }

    public MatchspellerModelApp getMatchSpellerModel(int n) {
        return this.getHMIService().getMatchSpellerModel(n);
    }

    public TooltipModelApp getTooltipModel(int n) {
        return this.getHMIService().getTooltipModel(n);
    }

    public TextfieldModelApp getTextfieldModel(int n) {
        return this.getHMIService().getTextfieldModel(n);
    }

    public DynamicListModelApp getDynamicListModel(int n) {
        return this.getHMIService().getDynamicListModel(n);
    }

    public DynamicListModelApp getDynamicListModel(int n, int n2) {
        return this.getHMIService().getDynamicListModel(n, n2);
    }

    public MetricsModelApp getMetricsModel(int n) {
        return this.getHMIService().getMetricsModel(n);
    }

    public ResourceLocatorModelApp getResourceLocatorModel(int n) {
        return this.getHMIService().getResourceLocatorModel(n);
    }

    public FastScrollingModelApp getFastScrollingModel(int n) {
        return this.getHMIService().getFastScrollingModel(n);
    }

    public VirtualButtonModelApp getVirtualButtonModel(int n) {
        return this.getHMIService().getVirtualButtonModel(n);
    }

    public BufferedFolderListModelApp getBufferedFolderListModel(int n) {
        return this.getHMIService().getBufferedFolderListModel(n);
    }

    public BufferedFolderListModelApp getBufferedFolderListModel(int n, int n2) {
        return this.getHMIService().getBufferedFolderListModel(n, n2);
    }

    public BrowserModelApp getBrowserModel(int n) {
        return this.getHMIService().getBrowserModel(n);
    }

    public DataModelApp getDataModel(int n) {
        return this.getHMIService().getDataModel(n);
    }

    public MenuModelApp getMenuModel(int n) {
        return this.getHMIService().getMenuModel(n);
    }

    public PropertyModelApp getPropertyModel(int n) {
        return this.getHMIService().getPropertyModel(n);
    }

    public OptionModelApp getOptionModel(int n) {
        return this.getHMIService().getOptionModel(n);
    }

    public final void fireModelEvent(int n, int n2) {
        this.getLogChannel().log(-2137614336, "AbstractModelEnvironment#fireModelEvent( %1 ) ", (long)n);
        HMIModelApp hMIModelApp = this.getHMIService().getModelApp(n);
        if (hMIModelApp != null) {
            hMIModelApp.fireEvent(n2);
        } else {
            this.getLogChannel().log(10000, "AbstractModelEnvironment#fireModelEvent() - model with id %1 could not be found! ", (long)n);
        }
    }

    public void fireTranslatedSMEvent(int n, int n2) {
        this.getLogChannel().log(-2137614336, "AbstractModelEnvironment#fireTranslatedSMEvent() - smID %1, eventID %2 ", (long)n, (long)n2);
        IHMIServiceApp iHMIServiceApp = this.getHMIService();
        if (iHMIServiceApp == null) {
            this.getLogChannel().log(10000, "AbstractModelEnvironment#fireTranslatedSMEvent() - failed to resolve HMIService!");
            return;
        }
        int n3 = this.smEventConstantsMapper.mapToVariant(n2);
        this.getLogChannel().log(-2137614336, "AbstractModelEnvironment#fireTranslatedSMEvent() - mapped id %1 to %2", (long)n2, (long)n3);
        if (n3 == -1) {
            this.getLogChannel().log(-1601830656, "AbstractModelEnvironment#fireTranslatedSMEvent() - eventID %1 is not variant-specific, use it directly!", (long)n2);
            n3 = n2;
        }
        iHMIServiceApp.fireSMEvent(n, n3);
    }

    public String getTranslatedText(int n) {
        return this.getTranslatedText(n, null);
    }

    public String getTranslatedText(int n, String string) {
        String string2;
        IHMIServiceApp iHMIServiceApp = this.getHMIService();
        if (iHMIServiceApp == null) {
            this.getLogChannel().log(10000, "AbstractModelEnvironment#getTranslatedText() - failed to resolve HMIService!");
            return string;
        }
        int n2 = this.textConstantsMapper.mapToVariant(n);
        if (n2 == -1) {
            this.getLogChannel().log(-1601830656, "AbstractModelEnvironment#getTranslatedText() - textID %1 is not variant-specific, use it directly!", (long)n);
            n2 = n;
        }
        if ((string2 = iHMIServiceApp.getText(n2)) == null) {
            this.getLogChannel().log(10000, "AbstractModelEnvironment#getTranslatedText() - ID %1 could not be resolved! ", (long)n2);
            string2 = string;
        }
        return string2;
    }
}

