/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets.asia;

import de.audi.atip.hmi.HMIImageConstantsSystem;
import de.audi.atip.hmi.event.WheelButtonEvent;
import de.esolutions.fw.util.commons.Buffer;
import de.esolutions.hmi.widgets.audi.base.AbstractScreenWidget;
import de.esolutions.hmi.widgets.audi.base.AbstractWidget;
import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;
import de.esolutions.hmi.widgets.audi.evo.InstructionTextContoller;
import de.esolutions.hmi.widgets.audi.evo.widgets.IViewSizeAnimatable;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.AbstractConversionWidgetController;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.IConversionCandidateSelectionHandler;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.IConversionDataFetcherListener;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.IConversionWidgetRenderer;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.ITouchInputDataAsia;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.TouchControllerAsia;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.TouchControllerFocusState;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class ConversionLineController
extends AbstractConversionWidgetController
implements IConversionDataFetcherListener,
IViewSizeAnimatable {
    public static final int MAX_CAPACITY_CONVERSION_CANDIDATES = 36;
    public static final int MODE_DEFAULT = 0;
    public static final int MODE_HINT = 1;
    private int currentMode = 0;
    public static final float WIDTH_PER_CHARACTER = 24.0f;
    public static int offsetCell = -1;
    public static float characterCellWidth = 24.0f + (float)offsetCell;
    public static final AbstractConversionWidgetController.ICandidateItem OPEN_MATRIX_POPUP_BUTTON_ITEM = new ButtonItem(ConversionLineButtonType.MATRIX_BUTTON);
    public static final AbstractConversionWidgetController.ICandidateItem TRUFFLE_BUTTON_ITEM = new ButtonItem(ConversionLineButtonType.TRUFFLE_BUTTON);
    private IConversionCandidateSelectionHandler selectionHandler = null;
    private TouchControllerAsia touchController = null;
    private String unconvertedCharacters = "";
    private List conversionsList = Collections.EMPTY_LIST;
    private boolean touchControllerFocus;
    private String cacheUnconvertedCharacterWhenFocusLost = "";
    private String inputDescription = "";
    private InstructionTextContoller parentInstructionWidget;
    private IConversionWidgetRenderer renderer;
    protected final List enabledCandidates = new ArrayList();

    public ConversionLineController(TouchControllerAsia touchControllerAsia) {
        this.touchController = touchControllerAsia;
    }

    public void setRenderer(IConversionWidgetRenderer iConversionWidgetRenderer) {
        super.setRenderer(iConversionWidgetRenderer);
        this.renderer = iConversionWidgetRenderer;
    }

    protected void initializeWidget() {
        this.parentInstructionWidget = this.getParentInstructionTextWidget();
        if (offsetCell < 0) {
            offsetCell = this.terminal.getLayout().getDistance(227);
            characterCellWidth = 24.0f + (float)offsetCell;
        }
    }

    protected void handleCandidateSelect(AbstractConversionWidgetController.ICandidateItem iCandidateItem) {
        if (iCandidateItem == null || !iCandidateItem.isEnabled()) {
            ITouchInputDataAsia iTouchInputDataAsia = (ITouchInputDataAsia)this.touchController.getInputData();
            iTouchInputDataAsia.convertUnconvertedCharactersToRegularCharacters();
            return;
        }
        if (iCandidateItem == OPEN_MATRIX_POPUP_BUTTON_ITEM) {
            this.showMatrixPopup();
        } else if (iCandidateItem instanceof AbstractConversionWidgetController.MultiCharItem) {
            String string = ((AbstractConversionWidgetController.MultiCharItem)iCandidateItem).getChars();
            int n = iCandidateItem.getSourceIndex();
            this.selectionHandler.acceptConversionCandidateSelection(string, n);
            this.setMode(1);
        } else {
            tpLogChannelInternal.log(10000, "ConversionLineController.handleCandidateSelect: unknown candidate item type %1", (Object)iCandidateItem);
        }
    }

    protected void acceptFocusedItemAsSelection() {
        AbstractConversionWidgetController.ICandidateItem iCandidateItem = this.getCurrentFocus();
        this.handleCandidateSelect(iCandidateItem);
    }

    private void showMatrixPopup() {
        if (null != this.touchController) {
            this.touchController.showMatrixPopup();
        }
    }

    protected void createMultiCharItems(String string, List list) {
        if (this.isTruffleButtonUsed(string)) {
            this.candidates.add(TRUFFLE_BUTTON_ITEM);
            TRUFFLE_BUTTON_ITEM.setEnabled(false);
        }
        if (list != null) {
            AbstractConversionWidgetController.ICandidateItem iCandidateItem;
            int n;
            int n2 = this.getColumnAmount() - 2;
            for (n = 0; n < list.size() && n <= n2; ++n) {
                iCandidateItem = ConversionLineController.createMultiCharItem((String)list.get(n), n);
                this.candidates.add(iCandidateItem);
            }
            this.renderer.fillInLayoutData(this.candidates);
            for (n = this.candidates.size() - 1; n >= 0; --n) {
                iCandidateItem = (AbstractConversionWidgetController.ICandidateItem)this.candidates.get(n);
                if (iCandidateItem.getRowIndex() > 0) {
                    this.candidates.remove(n);
                    continue;
                }
                int n3 = iCandidateItem.getColumnIndex() + iCandidateItem.getColumnSpan() - 1;
                if (n3 != n2) continue;
                OPEN_MATRIX_POPUP_BUTTON_ITEM.setColumnIndex(n3 + 1);
                this.candidates.add(OPEN_MATRIX_POPUP_BUTTON_ITEM);
                break;
            }
        }
    }

    private boolean isTruffleButtonUsed(String string) {
        boolean bl = "".equals(string) && this.touchController.isWordPredictionAvailable() && this.touchController.isTruffleSearch();
        return bl;
    }

    public String getUnconvertedCharacters() {
        return this.unconvertedCharacters;
    }

    public void onConversionAvailableChange(String string, List list) {
        this.logOnConversionAvailableChange(string, list);
        if (list.isEmpty()) {
            ConversionLineController.releaseCacheUse(this.candidates);
            this.candidates.clear();
            if (this.touchControllerFocus) {
                this.touchController.setFocusState(TouchControllerFocusState.SPELLER_LINE_FOCUS);
            }
        }
        if (this.isUpdateForConversionLine()) {
            this.conversionsList = list;
            this.unconvertedCharacters = string;
            this.setDataChanged(true);
            if (!this.touchController.getConversionMatrixModel().isActivated()) {
                if (!list.isEmpty()) {
                    if (!this.isVisible()) {
                        this.setConversionLineVisible(true);
                    }
                    this.setMode(0);
                    if ((list.size() < 1 || !this.touchController.isTruffleActive() && list.size() <= 1) && this.touchControllerFocus) {
                        this.touchController.setFocusState(TouchControllerFocusState.SPELLER_LINE_FOCUS);
                    }
                } else {
                    this.touchController.updateInputDescriptionLineVisibility(false);
                }
            }
            this.refreshCandidates(string, list);
        }
    }

    private boolean isUpdateForConversionLine() {
        return this.touchController.getCurrentFocusState() != TouchControllerFocusState.TOUCH_PREDICTION_LINE_FOCUS;
    }

    public void onNextValidCharactersChange(String string, String string2, String string3) {
    }

    private void logOnConversionAvailableChange(String string, List list) {
        if (tpLogChannelInternal.isDebug()) {
            tpLogChannelInternal.log(10000000, "ConversionLineController#onConversionAvailableChange: this.unconvertedCharacters = [%4] unconvertedCharacters = [%3] hasTouchControllerFocus = %1, conversions.size = [%2]", (Object)String.valueOf(this.touchControllerFocus), (Object)String.valueOf(list.size()), (Object)string, (Object)this.unconvertedCharacters);
        }
    }

    protected final void setConversionLineVisible(boolean bl) {
        AbstractWidget abstractWidget;
        boolean bl2 = abstractWidget.isVisible();
        for (abstractWidget = this.getParent(); abstractWidget != null && bl2; abstractWidget = abstractWidget.getParent()) {
        }
        if (bl2 && bl != this.isVisible()) {
            this.setVisible(bl);
            this.setIsTitleVisible(!bl);
        } else {
            tpLogChannelInternal.log(100000000, "ConversionLineController#setConversionLineVisible predecesor is invisible but want to set the visibility %1 of the conversion line.", bl2);
        }
    }

    private void setIsTitleVisible(boolean bl) {
        if (this.initContext != null && this.initContext.getScreen() != null) {
            if (null == this.parentInstructionWidget) {
                ((AbstractScreenWidget)this.initContext.getScreen()).getTitleArea().getScreenAreaWidget().setOnScreen(bl);
            } else {
                AbstractWidgetController abstractWidgetController = this.parentInstructionWidget.getHintText();
                if (null != abstractWidgetController) {
                    abstractWidgetController.setOnScreen(bl);
                }
                if (null != (abstractWidgetController = this.parentInstructionWidget.getHintTextMenu())) {
                    abstractWidgetController.setOnScreen(bl);
                }
                if (null != (abstractWidgetController = this.parentInstructionWidget.getHintArea())) {
                    abstractWidgetController.setOnScreen(bl);
                }
            }
        } else {
            tpLogChannelInternal.log(10000000, "ConversionLineController#setIsTitleVisible: Initial context is 1%", this.initContext == null);
        }
    }

    private InstructionTextContoller getParentInstructionTextWidget() {
        AbstractWidget abstractWidget = this.getParent();
        for (int i2 = 0; i2 < 10; ++i2) {
            if (abstractWidget == null || abstractWidget instanceof AbstractScreenWidget) {
                return null;
            }
            if (abstractWidget instanceof InstructionTextContoller) {
                return (InstructionTextContoller)abstractWidget;
            }
            abstractWidget = abstractWidget.getParent();
        }
        return null;
    }

    public List getConversions() {
        return Collections.unmodifiableList(this.conversionsList);
    }

    public IConversionCandidateSelectionHandler getSelectionHandler() {
        return this.selectionHandler;
    }

    public void setConversionCandidateSelectionHandler(IConversionCandidateSelectionHandler iConversionCandidateSelectionHandler) {
        this.selectionHandler = iConversionCandidateSelectionHandler;
    }

    protected final void refreshCursor() {
        if (!this.unconvertedCharacters.equals(this.cacheUnconvertedCharacterWhenFocusLost)) {
            this.resetInitialItem(false);
        }
        this.setCompositesDirty(true);
    }

    protected final void setMode(int n) {
        if (this.currentMode == n) {
            return;
        }
        this.currentMode = n;
        if (n == 0) {
            this.setDataChanged(true);
        } else {
            this.clearCandidates();
        }
    }

    public int getMode() {
        return this.currentMode;
    }

    public String getModeStringRepresentation() {
        switch (this.currentMode) {
            case 0: {
                return "MODE_DEFAULT";
            }
            case 1: {
                return "MODE_HINT";
            }
        }
        return "";
    }

    public void showInputDescription(String string) {
        this.inputDescription = string;
        this.setMode(1);
        this.resetCachedUnconvertedCharacter();
        this.touchController.setConversionLineVisible(true);
        this.setCompositesDirty(true);
    }

    public String getInputDescription() {
        return this.inputDescription;
    }

    public void setHasTouchControllerFocus(boolean bl) {
        if (this.touchControllerFocus != bl) {
            this.touchControllerFocus = bl;
            this.setCompositesDirty(true);
        }
        if (!this.touchControllerFocus) {
            this.cacheUnconvertedCharacterWhenFocusLost = this.unconvertedCharacters;
        }
    }

    public boolean hasTouchControllerFocus() {
        return this.touchControllerFocus;
    }

    protected AbstractConversionWidgetController.ICandidateItem getFirstFocusableItem() {
        if (this.enabledCandidates.isEmpty()) {
            spellerLogChannel.log(100000, "[AbstractConversionWidgetController#resetInitialItem] Could not find a enabled item for the initial focus.");
            return null;
        }
        Iterator iterator = this.enabledCandidates.iterator();
        while (iterator.hasNext()) {
            AbstractConversionWidgetController.ICandidateItem iCandidateItem = (AbstractConversionWidgetController.ICandidateItem)iterator.next();
            if (!iCandidateItem.isEnabled()) continue;
            return iCandidateItem;
        }
        return (AbstractConversionWidgetController.ICandidateItem)this.enabledCandidates.get(0);
    }

    private void clearCandidates() {
        ConversionLineController.releaseCacheUse(this.candidates);
        this.candidates.clear();
        this.enabledCandidates.clear();
        this.setDataChanged(true);
        this.currentFocusedItem = null;
        this.setCompositesDirty(true);
    }

    private void refreshCandidates(String string, List list) {
        this.clearCandidates();
        if (this.terminal != null && this.getWidth() > 0 && (!list.isEmpty() || this.isTruffleButtonUsed(string))) {
            this.createMultiCharItems(string, list);
            this.refreshEnabledCandidates();
            this.resetInitialItem(this.touchController.getConversionMatrixModel().isActivated());
            this.setCompositesDirty(true);
        }
    }

    public void disconnecting() {
        super.disconnecting();
        this.resetCachedUnconvertedCharacter();
    }

    private void resetCachedUnconvertedCharacter() {
        this.unconvertedCharacters = "";
        this.cacheUnconvertedCharacterWhenFocusLost = "";
    }

    public void keyTurned(WheelButtonEvent wheelButtonEvent) {
        AbstractConversionWidgetController.ICandidateItem iCandidateItem;
        super.keyTurned(wheelButtonEvent);
        if (this.enabledCandidates.size() < 1) {
            return;
        }
        int n = wheelButtonEvent.getClickCount();
        if (n == 0) {
            wheelButtonEvent.consume(false);
            return;
        }
        if (wheelButtonEvent.getDirection() == 1) {
            n = -n;
        }
        if ((iCandidateItem = this.getTargetItem(n)).isEnabled()) {
            this.targetCursorItem = iCandidateItem;
            this.moveCursor(iCandidateItem, false);
        }
        wheelButtonEvent.consume();
    }

    protected void refreshEnabledCandidates() {
        this.enabledCandidates.clear();
        for (int i2 = 0; i2 <= this.candidates.size() - 1; ++i2) {
            AbstractConversionWidgetController.ICandidateItem iCandidateItem = (AbstractConversionWidgetController.ICandidateItem)this.candidates.get(i2);
            if (!iCandidateItem.isEnabled() && iCandidateItem != TRUFFLE_BUTTON_ITEM || iCandidateItem.getRowIndex() != 0) continue;
            this.enabledCandidates.add(iCandidateItem);
        }
    }

    private AbstractConversionWidgetController.ICandidateItem getTargetItem(int n) {
        int n2 = this.enabledCandidates.indexOf(this.currentFocusedItem);
        int n3 = n2 + n;
        if (n3 >= this.enabledCandidates.size()) {
            n3 = this.enabledCandidates.size() - 1;
        }
        if (n3 < 0) {
            n3 = 0;
        }
        if (n3 > this.getColumnAmount()) {
            n3 = this.getColumnAmount();
        }
        return (AbstractConversionWidgetController.ICandidateItem)this.enabledCandidates.get(n3);
    }

    private int getColumnAmount() {
        return this.terminal.getLayout().getIntegerConstant(113);
    }

    public boolean hasMatrixButton() {
        if (null == this.candidates || this.candidates.isEmpty()) {
            return false;
        }
        Iterator iterator = this.candidates.iterator();
        while (iterator.hasNext()) {
            if ((AbstractConversionWidgetController.AbstractCandidateItem)iterator.next() != OPEN_MATRIX_POPUP_BUTTON_ITEM) continue;
            return true;
        }
        return false;
    }

    public void setViewSizeAnimation(float f2, float[] fArray, float[] fArray2, boolean bl) {
        if (fArray2[0] == 0.0f && this.getMode() == 1) {
            this.setSizeChanged(true);
        }
    }

    public void setViewSizeAnimationFinished(float[] fArray, boolean bl) {
        if (fArray[0] == 0.0f && this.getMode() == 1) {
            this.setSizeChanged(true);
        }
    }

    public void viewSizeTargetChanged(float[] fArray, float[] fArray2, boolean bl) {
    }

    public void viewSizeAnimationStarted(float f2, float[] fArray, float[] fArray2) {
    }

    private boolean isCandidateOnlyTruffleButton() {
        return this.candidates.isEmpty() || this.candidates.size() == 1 && (AbstractConversionWidgetController.ICandidateItem)this.candidates.get(0) == TRUFFLE_BUTTON_ITEM;
    }

    public void onSuggestionChange(boolean bl) {
        if (this.isCandidateOnlyTruffleButton()) {
            this.showSingleTruffleButton();
            TRUFFLE_BUTTON_ITEM.setEnabled(bl);
        } else {
            AbstractConversionWidgetController.ICandidateItem iCandidateItem = (AbstractConversionWidgetController.ICandidateItem)this.getCandidateIterator().next();
            if (null != iCandidateItem && iCandidateItem == TRUFFLE_BUTTON_ITEM) {
                iCandidateItem.setEnabled(bl);
                this.setCompositesDirty(true);
            }
        }
        this.setCompositesDirty(true);
    }

    private void showSingleTruffleButton() {
        this.setMode(0);
        this.setConversionLineVisible(true);
        this.refreshCandidates("", Collections.EMPTY_LIST);
    }

    public boolean isSingleTruffleButtonShowed() {
        return this.candidates.size() == 1 && this.candidates.get(0) == TRUFFLE_BUTTON_ITEM && this.isVisible();
    }

    public final boolean operationAvailableFromConversionLine() {
        boolean bl = false;
        if (this.candidates.size() > 1) {
            bl = true;
        } else if (this.candidates.size() == 1) {
            bl = ((AbstractConversionWidgetController.ICandidateItem)this.candidates.get(0)).isEnabled();
        }
        return bl;
    }

    public static class ButtonItem
    extends AbstractConversionWidgetController.AbstractCandidateItem
    implements IButtonItem {
        private static final String TYPE_KEY = "ConversionLineController.ButtonItem";
        private final ConversionLineButtonType type;

        public ButtonItem(ConversionLineButtonType conversionLineButtonType) {
            this.type = conversionLineButtonType;
        }

        public ConversionLineButtonType getButtonType() {
            return this.type;
        }

        public String getTypeKey() {
            return TYPE_KEY;
        }

        public String toString() {
            return new Buffer("ButtonItem[").append(this.type.getName()).append(']').toString();
        }

        public int hashCode() {
            int n = super.hashCode();
            n = 31 * n + (this.type == null ? 0 : this.type.hashCode());
            return n;
        }

        public boolean equals(Object object) {
            if (this == object) {
                return true;
            }
            if (!super.equals(object)) {
                return false;
            }
            if (!(object instanceof ButtonItem)) {
                return false;
            }
            ButtonItem buttonItem = (ButtonItem)object;
            return !(this.type == null ? buttonItem.type != null : !this.type.equals(buttonItem.type));
        }
    }

    public static interface IButtonItem
    extends AbstractConversionWidgetController.ICandidateItem {
        public ConversionLineButtonType getButtonType();
    }

    public static class ConversionLineButtonType {
        public static final ConversionLineButtonType MATRIX_BUTTON = new ConversionLineButtonType("MATRIX BUTTON", "matrixButtonImageNode", HMIImageConstantsSystem.mib2_conversionline_matrix_button, HMIImageConstantsSystem.mib2_conversionline_matrix_button_big);
        public static final ConversionLineButtonType TRUFFLE_BUTTON = new ConversionLineButtonType("TRUFFLE BUTTON", "truffleButtonImageNode", HMIImageConstantsSystem.mib2_speller_button_truffles_enabled, HMIImageConstantsSystem.mib2_speller_button_truffles_enabled_big);
        public static final ConversionLineButtonType NULL = new ConversionLineButtonType("NULL", "NULL", -1, -1);
        private final String name;
        private final String imageNodeName;
        private final int bitmapId;
        private final int bitmapIdHighlighted;

        private ConversionLineButtonType(String string, String string2, int n, int n2) {
            this.name = string;
            this.imageNodeName = string2;
            this.bitmapId = n;
            this.bitmapIdHighlighted = n2;
        }

        public String getName() {
            return this.name;
        }

        public String getImageNodeName() {
            return this.imageNodeName;
        }

        public int getBitmapId() {
            return this.bitmapId;
        }

        public int getBitmapIdHighlighted() {
            return this.bitmapIdHighlighted;
        }

        public String toString() {
            return new Buffer("ConversionLineButtonType[").append(this.name).append("]").toString();
        }

        public int hashCode() {
            int n = 1;
            n = 31 * n + this.bitmapId;
            n = 31 * n + this.bitmapIdHighlighted;
            n = 31 * n + (this.imageNodeName == null ? 0 : this.imageNodeName.hashCode());
            n = 31 * n + (this.name == null ? 0 : this.name.hashCode());
            return n;
        }

        public boolean equals(Object object) {
            if (this == object) {
                return true;
            }
            if (object == null) {
                return false;
            }
            if (!(object instanceof ConversionLineButtonType)) {
                return false;
            }
            ConversionLineButtonType conversionLineButtonType = (ConversionLineButtonType)object;
            if (this.bitmapId != conversionLineButtonType.bitmapId) {
                return false;
            }
            if (this.bitmapIdHighlighted != conversionLineButtonType.bitmapIdHighlighted) {
                return false;
            }
            if (this.imageNodeName == null ? conversionLineButtonType.imageNodeName != null : !this.imageNodeName.equals(conversionLineButtonType.imageNodeName)) {
                return false;
            }
            return !(this.name == null ? conversionLineButtonType.name != null : !this.name.equals(conversionLineButtonType.name));
        }
    }
}

