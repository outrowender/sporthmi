/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets;

import de.audi.atip.hmi.event.ModelUpdateEvent;
import de.audi.atip.hmi.model.IntegerListCell;
import de.audi.atip.hmi.model.MetricsListCell;
import de.audi.atip.hmi.model.TextListCell;
import de.audi.atip.hmi.model.TextListCellHighlightText;
import de.audi.atip.hmi.model.list.SelectedItem;
import de.audi.atip.hmi.model.list.TiledListModelGUI;
import de.audi.atip.hmi.modelaccess.ChoiceModelGUI;
import de.audi.atip.hmi.modelaccess.HMIModelGUI;
import de.audi.atip.hmi.modelaccess.LabelModelGUI;
import de.audi.atip.hmi.modelaccess.MetricsModelGUI;
import de.audi.atip.hmi.modelaccess.RangeModelGUI;
import de.audi.atip.hmi.modelaccess.SpellerModelGUI;
import de.audi.atip.hmi.modelaccess.TextfieldModelGUI;
import de.audi.atip.metrics.AbstractMetrics;
import de.audi.atip.metrics.DateMetric;
import de.audi.atip.util.Util;
import de.esolutions.hmi.widgets.audi.base.AbstractWidget;
import de.esolutions.hmi.widgets.audi.base.PreferredDynamicHeight;
import de.esolutions.hmi.widgets.audi.base.StringUtility;
import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;
import de.esolutions.hmi.widgets.audi.base.widgets.IRenderer;
import de.esolutions.hmi.widgets.audi.evo.MetricsFormatter;
import de.esolutions.hmi.widgets.audi.evo.widgets.BaselineWidget;
import de.esolutions.hmi.widgets.audi.evo.widgets.IEmptyableWidget;
import de.esolutions.hmi.widgets.audi.evo.widgets.IStatusbarChild;
import de.esolutions.hmi.widgets.audi.evo.widgets.ITextDescriptorController;
import de.esolutions.hmi.widgets.audi.evo.widgets.IViewSizeAnimatable;
import de.esolutions.hmi.widgets.audi.evo.widgets.LabelRenderer;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.list.ListItemWidget;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LabelController
extends AbstractWidgetController
implements ListItemWidget,
BaselineWidget,
IEmptyableWidget,
IStatusbarChild,
ITextDescriptorController,
PreferredDynamicHeight,
IViewSizeAnimatable {
    private static final int REPLACEMENT_RECURSION_LIMIT = 5;
    protected static final int MAX_LINES_DEFAULT = 50;
    private LabelRenderer renderer;
    private int[] textIds;
    private int[] replacementModelIds;
    private int[] replacementTextIds;
    private int modelColumn = -1;
    protected Object content;
    private int prefix = -1;
    private int[] textOrientationHints;
    protected String text;
    private int[] highlightArea;
    private List lineDescription;
    private int metricsFormat = -1;
    private int dateFormatMode = -1;
    private boolean showChoiceValue = false;
    public boolean textAreasAreSplit = false;
    private boolean recursiveReplacement = false;
    private int minLines = 0;
    private int maxLines = 50;
    private boolean ignoreModelUpdateEvents = false;
    private boolean useSmallStageText = false;
    private static Map specialReplacementCharacters = new HashMap();
    private boolean useSpecialReplacements = false;

    public IRenderer getRenderer() {
        return this.renderer;
    }

    public void setRenderer(LabelRenderer labelRenderer) {
        this.renderer = labelRenderer;
    }

    protected void initializeWidget() {
        super.initializeWidget();
        this.updateContent();
    }

    public int getX() {
        if (this.shiftUserHintText()) {
            return super.getX() - this.getUserHintLabelOffset();
        }
        return super.getX();
    }

    private int getUserHintLabelOffset() {
        return this.terminal != null ? (this.terminal.getLayout() != null ? this.terminal.getLayout().getUserHintLabelOffset() : 0) : 0;
    }

    private boolean shiftUserHintText() {
        return this.role == 0x1000000 && !this.isTouchpadKeypanelWithActiveStatus();
    }

    private boolean isTouchpadKeypanelWithActiveStatus() {
        if (this.terminal != null && this.terminal.getKbdService() != null) {
            return this.terminal.getKbdService().isTouchKeypanel();
        }
        return true;
    }

    public void setUserHintRole(int n) {
        this.role = n;
    }

    public void processModelUpdateEvent(ModelUpdateEvent modelUpdateEvent) {
        if (!this.ignoreModelUpdateEvents) {
            int n = modelUpdateEvent.getUpdateType();
            if (n == 1 || n == 22 || n == 14) {
                this.updateContent();
            }
            if (n == 2) {
                boolean bl = false;
                if (this.getModelStatus() == 1) {
                    bl = this.updateContent();
                }
                if (!bl) {
                    this.invalidateParentLayout();
                }
            }
        }
        super.processModelUpdateEvent(modelUpdateEvent);
    }

    public void processTextReplacementUpdateEvent() {
        this.updateContent();
    }

    public boolean updateContent() {
        String string = this.text;
        this.content = this.calculateContent();
        String string2 = this.formatContent(this.content);
        this.text = this.formatText(string2);
        if (!Util.equals(string, this.text)) {
            this.setCompositesDirty(true);
            this.invalidateParentLayout();
            return true;
        }
        return false;
    }

    protected String formatText(String string) {
        return this.getOrientaionHintedText(this.formatSpecialCharacters(string));
    }

    public void activateSpecialReplacements(boolean bl) {
        this.useSpecialReplacements = bl;
    }

    protected String formatSpecialCharacters(String string) {
        if (!this.useSpecialReplacements || string == null || string.length() != 1 || this.isLTR()) {
            return string;
        }
        String string2 = (String)specialReplacementCharacters.get(string);
        return string2 == null ? string : string2;
    }

    public String getOrientaionHintedText(String string) {
        if (string == null) {
            return null;
        }
        if (!LabelController.isArabia() || this.model instanceof TextListCellHighlightText && !StringUtility.shouldFixBracketsDirection(string)) {
            return string;
        }
        String string2 = StringUtility.getTextOrientationHintString(this.textOrientationHints != null ? this.textOrientationHints[0] : 0, this.isLTR());
        if (string2 == null) {
            return string;
        }
        return string2 + string;
    }

    protected Object calculateContent() {
        if (this.model == null) {
            return Util.createInteger(0);
        }
        if (this.model instanceof HMIModelGUI && ((HMIModelGUI)this.model).getStatus() == 3) {
            return null;
        }
        if (this.model instanceof LabelModelGUI) {
            return ((LabelModelGUI)this.model).getText();
        }
        if (this.model instanceof TextfieldModelGUI) {
            return ((TextfieldModelGUI)this.model).getText1();
        }
        if (this.model instanceof SpellerModelGUI) {
            return ((SpellerModelGUI)this.model).getText();
        }
        if (this.model instanceof RangeModelGUI) {
            return Integer.toString(((RangeModelGUI)this.model).getValue());
        }
        if (this.model instanceof MetricsModelGUI) {
            return ((MetricsModelGUI)this.model).getMetric();
        }
        if (this.model instanceof AbstractMetrics) {
            return this.model;
        }
        if (this.model instanceof ChoiceModelGUI) {
            return Util.createInteger(((ChoiceModelGUI)this.model).getValue());
        }
        if (this.model instanceof TiledListModelGUI) {
            TiledListModelGUI tiledListModelGUI = (TiledListModelGUI)this.model;
            SelectedItem selectedItem = tiledListModelGUI.getSelected();
            if (selectedItem != null) {
                return Util.createInteger(selectedItem.getIndex());
            }
            return Util.createInteger(0);
        }
        if (this.model instanceof IntegerListCell) {
            return new Integer(((IntegerListCell)this.model).getValue());
        }
        if (this.model instanceof TextListCellHighlightText) {
            TextListCellHighlightText textListCellHighlightText = (TextListCellHighlightText)this.model;
            this.highlightArea = textListCellHighlightText.getHighlightArea();
            return textListCellHighlightText.getText();
        }
        if (this.model instanceof TextListCell) {
            return ((TextListCell)this.model).getText();
        }
        if (this.model instanceof MetricsListCell) {
            return ((MetricsListCell)this.model).getMetrics();
        }
        if (this.model instanceof Integer) {
            return this.model;
        }
        if (this.model instanceof String) {
            return this.model;
        }
        logChannel.log(100000, "LabelController#calculateContent: Unknown model %2: %1", this.model, (long)this.modelID);
        return null;
    }

    protected String formatContent(Object object) {
        if (object == null || !this.isConnected()) {
            return null;
        }
        if (object instanceof String) {
            String string = (String)object;
            return this.processTextReplacement(string);
        }
        if (object instanceof Integer) {
            int n = (Integer)object;
            if (this.showChoiceValue) {
                return String.valueOf(n);
            }
            return this.getText(n);
        }
        if (object instanceof AbstractMetrics) {
            AbstractMetrics abstractMetrics = (AbstractMetrics)object;
            if (abstractMetrics instanceof DateMetric && this.dateFormatMode == 8) {
                abstractMetrics.format();
                int n = ((DateMetric)abstractMetrics).getDayOfWeek();
                int n2 = n == 1 ? 6 : n - 2;
                return this.getText(n2);
            }
            String string = MetricsFormatter.format(abstractMetrics, this.dateFormatMode, this.metricsFormat);
            if (this.renderer.isTextDescriptorSupported()) {
                long l = System.currentTimeMillis();
                this.lineDescription = MetricsFormatter.getLineDescriptor(this.prefix, abstractMetrics, this.dateFormatMode, this.metricsFormat, this.isLTR());
                long l2 = System.currentTimeMillis();
                textDescriptorLogCh.log(10000000, "LabelController#formatContent Creating TextDescriptor took %1 ms", l2 - l);
            }
            return string;
        }
        logChannel.log(100000, "LabelController#formatContent: Unknown content: %1", object);
        return null;
    }

    private String processTextReplacement(String string) {
        int[] nArray = this.getReplacementModelIds();
        if (nArray != null) {
            int[] nArray2 = this.textAreasAreSplit ? this.getReplacementTextIds() : this.getTextIds();
            StringUtility stringUtility = this.getInitContext().getStringUtility();
            int n = this.recursiveReplacement ? 5 : 1;
            String string2 = string;
            String string3 = null;
            for (int i2 = 0; i2 < n && (i2 <= 0 || string2 != string3 && !string2.equals(string3)); ++i2) {
                string3 = string2;
                string2 = stringUtility.processTextReplacement(string2, AbstractWidget.hmiService, nArray, nArray2, 0, this.textOrientationHints, this.isLTR());
            }
            return string2;
        }
        return string;
    }

    public Object getContent() {
        return this.content;
    }

    public int[] getTextIds() {
        return this.textIds;
    }

    public void setText(String string) {
        this.setModel(string);
        this.updateContent();
    }

    public void setLineDescription(List list) {
        this.lineDescription = list;
    }

    public void setTextIds(int[] nArray) {
        this.textIds = nArray;
    }

    public void setReplacementModelIds(int[] nArray) {
        this.replacementModelIds = nArray;
    }

    public int[] getReplacementModelIds() {
        return this.replacementModelIds;
    }

    public int getPreferredWidth() {
        if (this.renderer != null && this.isConnected()) {
            return this.renderer.getPreferredWidth();
        }
        return 0;
    }

    public int getPreferredHeight() {
        if (this.renderer != null && this.isConnected()) {
            return this.renderer.getPreferredHeight();
        }
        return 0;
    }

    public int getPreferredHeight(int n) {
        if (this.renderer instanceof PreferredDynamicHeight) {
            return ((PreferredDynamicHeight)((Object)this.renderer)).getPreferredHeight(n);
        }
        return this.getPreferredHeight();
    }

    public int[] getHighlightArea() {
        return this.highlightArea;
    }

    public void setModelColumn(int n) {
        this.modelColumn = n;
    }

    public int getModelColumn() {
        return this.modelColumn;
    }

    public void setEnabled(boolean bl) {
        if (this.isEnabled() != bl) {
            super.setEnabled(bl);
            this.setCompositesDirty(true);
        }
    }

    public String getDiagnosisText() {
        return this.text;
    }

    public String getRendererText() {
        return this.renderer != null ? this.renderer.getText() : this.getText();
    }

    public String getText() {
        return this.text;
    }

    private String getText(int n) {
        int[] nArray = this.getTextIds();
        if (nArray != null && n >= 0 && n < nArray.length) {
            int n2 = nArray[n];
            String string = "";
            if (this.getInitContext() != null && this.getInitContext().getScreenFactory() != null) {
                string = this.useSmallStageText ? this.getInitContext().getScreenFactory().getText(n2, 1) : (this.terminal != null && this.terminal.getViewSizeManager() != null ? this.getInitContext().getScreenFactory().getText(n2, this.terminal.getViewSizeManager().getCurrentViewSize()) : this.getInitContext().getScreenFactory().getText(n2));
            }
            return this.processTextReplacement(string);
        }
        return "";
    }

    public int getBaseline() {
        if (this.renderer != null) {
            return this.renderer.getBaseline();
        }
        return this.getHeight();
    }

    public boolean hasContent() {
        if (this.content == null || this.renderer == null) {
            return false;
        }
        return this.renderer.hasContent();
    }

    public int getMetricsFormat() {
        return this.metricsFormat;
    }

    public void setMetricsFormat(int n) {
        this.metricsFormat = n;
    }

    public int getDateFormatMode() {
        return this.dateFormatMode;
    }

    public void setDateFormatMode(int n) {
        this.dateFormatMode = n;
    }

    public int getModelValue() {
        if (this.model != null && this.model instanceof LabelModelGUI) {
            return ((LabelModelGUI)this.model).getLength();
        }
        if (this.model instanceof ChoiceModelGUI) {
            return ((ChoiceModelGUI)this.model).getValue();
        }
        return -1;
    }

    public int getModelStatus() {
        if (this.model != null && this.model instanceof HMIModelGUI) {
            return ((HMIModelGUI)this.model).getStatus();
        }
        return 0;
    }

    public int getModelMin() {
        return -1;
    }

    public int getModelMax() {
        return -1;
    }

    public List getLineDescription() {
        return this.lineDescription;
    }

    public void setShowChoiceValue(boolean bl) {
        this.showChoiceValue = bl;
    }

    public boolean isHeightDependentFromWidth() {
        return this.renderer instanceof PreferredDynamicHeight && ((PreferredDynamicHeight)((Object)this.renderer)).isHeightDependentFromWidth();
    }

    public int[] getReplacementTextIds() {
        return this.replacementTextIds;
    }

    public boolean isRecursiveReplacement() {
        return this.recursiveReplacement;
    }

    public void setRecursiveReplacement(boolean bl) {
        this.recursiveReplacement = bl;
    }

    public void setReplacementTextIds(int[] nArray) {
        this.replacementTextIds = nArray;
    }

    public void setPrefix(int n) {
        this.prefix = n;
    }

    public void setMaxLines(int n) {
        if (this.maxLines != n) {
            this.maxLines = n;
            this.updateContent();
            this.setCompositesDirty(true);
            this.invalidateParentLayout();
        }
    }

    public int getMaxLines() {
        return this.maxLines;
    }

    public void setMinLines(int n) {
        if (this.minLines != n) {
            this.minLines = n;
            this.setCompositesDirty(true);
            this.invalidateParentLayout();
        }
    }

    public int getMinLines() {
        return this.minLines;
    }

    public void setViewSizeAnimation(float f2, float[] fArray, float[] fArray2, boolean bl) {
        if (bl) {
            this.updateContent();
        }
    }

    public void setViewSizeAnimationFinished(float[] fArray, boolean bl) {
        if (bl) {
            this.updateContent();
        }
        this.invalidateParentLayout();
    }

    public void viewSizeTargetChanged(float[] fArray, float[] fArray2, boolean bl) {
    }

    public boolean isIgnoreModelUpdateEvents() {
        return this.ignoreModelUpdateEvents;
    }

    public void setIgnoreModelUpdateEvents(boolean bl) {
        this.ignoreModelUpdateEvents = bl;
    }

    public boolean hasBaseline() {
        return true;
    }

    public void setUseSmallStageText(boolean bl) {
        this.useSmallStageText = bl;
    }

    public boolean isUseSmallStageText() {
        return this.useSmallStageText;
    }

    public void viewSizeAnimationStarted(float f2, float[] fArray, float[] fArray2) {
    }

    public int[] getTextOrientationHints() {
        return this.textOrientationHints;
    }

    public void setTextOrientationHints(int[] nArray) {
        if (nArray != null && nArray.length > 0) {
            this.textOrientationHints = nArray;
        }
    }

    static {
        specialReplacementCharacters.put("[", "]");
        specialReplacementCharacters.put("]", "[");
        specialReplacementCharacters.put("(", ")");
        specialReplacementCharacters.put(")", "(");
        specialReplacementCharacters.put("{", "}");
        specialReplacementCharacters.put("}", "{");
    }
}

