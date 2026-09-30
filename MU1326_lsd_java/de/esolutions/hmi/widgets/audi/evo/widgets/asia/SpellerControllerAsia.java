/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets.asia;

import de.audi.atip.util.StringUtilities;
import de.esolutions.fw.util.commons.Buffer;
import de.esolutions.hmi.widgets.audi.evo.widgets.ReusableInstanceCache;
import de.esolutions.hmi.widgets.audi.evo.widgets.SpellerCharsetDefinition;
import de.esolutions.hmi.widgets.audi.evo.widgets.SpellerController;
import de.esolutions.hmi.widgets.audi.evo.widgets.SpellerIterator;
import de.esolutions.hmi.widgets.audi.evo.widgets.TouchCharSetAndTTSHandler;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.AbstractToneAndCaseTogglingTable;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.AsianInputMethod;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.IConversionDataFetcherListener;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.ISpellerListenerAsia;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.ITouchPredictionLine;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.ITouchResultLine;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.IWordPredictionDataFetcher;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.SpellerBandState;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.TouchControllerAsia;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.TouchControllerFocusState;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.converter.ICharacterConverter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;

public class SpellerControllerAsia
extends SpellerController
implements IConversionDataFetcherListener {
    private static final int STROKE_JOKER_INDEX_IN_SPELLERCHARSETASIA = 6;
    private SpellerBandState currentSpellerState;
    private SpellerController.ISpellerBand defaultSpellerBand;
    private ITouchResultLine touchResultsLine;
    private AsianInputMethod currentInputMethod = AsianInputMethod.NO_CONVERSION;
    private boolean conversionLineFocused;
    private TouchCharSetAndTTSHandler touchCharSetAndTTSHandler;
    private String originalValidChars;
    private ITouchPredictionLine touchPredictionLine;
    private IWordPredictionDataFetcher wordPredictionDataFetcher = IWordPredictionDataFetcher.NULL;
    private boolean useTouchPredictionLine = false;
    private boolean showWordPredictionResultsForTouch = false;
    private boolean truffleSearch = false;

    protected void initializeWidget() {
        if (this.getCurrentSpellerBand() == null) {
            List list = SpellerCharsetDefinition.initSpellerBand(this.spellerMode, -1);
            this.setCurrentSpellerBand(new SpellerBandImplAsia(list, this.hasOKButton()), false);
        }
        super.initializeWidget();
        this.defaultSpellerBand = this.getCurrentSpellerBand();
        this.currentSpellerState = SpellerBandState.DEFAULT_SPELLER;
    }

    protected final void updateValidFollowUpCharacterItemsForFreeInputSpeller(String string) {
        if (this.getSpellerMode() == 11) {
            return;
        }
        this.updateValidChars(null);
        if (this.currentInputMethod == AsianInputMethod.STROKE && StringUtilities.isNullOrEmpty(string)) {
            this.updateValidChars(null);
        } else if (this.currentInputMethod == AsianInputMethod.ZHUYIN || this.currentInputMethod == AsianInputMethod.STROKE) {
            ICharacterConverter iCharacterConverter = this.currentInputMethod.getCharacterConverter();
            iCharacterConverter.setUnconvertedCharacters(string);
            String string2 = iCharacterConverter.getValidCharacters();
            String string3 = this.currentInputMethod == AsianInputMethod.ZHUYIN ? " " : null;
            this.updateValidChars(string2, string3);
        }
    }

    protected void updateValidChars(String string, String string2, boolean bl) {
        this.originalValidChars = string;
        if (this.getSpellerMode() == 11 && SpellerControllerAsia.isJp()) {
            string = SpellerControllerAsia.updateValidCharsByVariance(string);
        }
        super.updateValidChars(string, string2, bl);
    }

    protected void enableParentIfNeeded(SpellerController.SingleCharItem singleCharItem, boolean bl) {
        if (bl && singleCharItem.hasParent() && singleCharItem.getParent() instanceof SpellerController.AbstractExpandableItem.Char) {
            SpellerController.AbstractExpandableItem.Char char_ = (SpellerController.AbstractExpandableItem.Char)singleCharItem.getParent();
            if (!char_.isClosed()) {
                this.disableGroupFatherCharacterAfterExpandIfNeed(char_);
            } else {
                singleCharItem.getParent().setEnabled(bl);
            }
        } else {
            singleCharItem.getParent().setEnabled(bl);
        }
    }

    private static String updateValidCharsByVariance(String string) {
        return AbstractToneAndCaseTogglingTable.appendMainCharacterForVariance(string);
    }

    public final SpellerBandState getCurrentSpellerState() {
        return this.currentSpellerState;
    }

    private void switchSpellerBand(SpellerBandState spellerBandState, SpellerBandState spellerBandState2) {
        if (spellerBandState.isUsingSameSpellerBandAs(spellerBandState2)) {
            return;
        }
        if (spellerBandState2 == SpellerBandState.TOUCH_PREDICTION_LINE) {
            this.getTouchPredictionLine().clear();
        }
        if (spellerBandState.isUsingDefaultSpellerBand()) {
            if (!(this.getCurrentSpellerBand() instanceof ISpellerBandAsia)) {
                spellerLogChannel.log(10000, "SpellerControllerAsia#switchSpellerBand: Current speller band is incompitable with ISpellerBandAsia, can not switch speller band!");
            } else {
                this.defaultSpellerBand = this.getCurrentSpellerBand();
                if (spellerBandState2 == SpellerBandState.TOUCH_PREDICTION_LINE) {
                    this.changeSpellerBand(this.getTouchPredictionLine());
                } else {
                    this.changeSpellerBand(this.getTouchResultLine());
                }
                if (this.isParentTouchControllerAsiaAndSpellerNotClose()) {
                    ((TouchControllerAsia)this.parent).setFocusState(TouchControllerFocusState.TOUCH_RESULT_LINE_FOCUS);
                }
            }
        } else if (spellerBandState.isUsingTouchPredictionLine() && spellerBandState2.isUsingTouchResultLine()) {
            this.changeSpellerBand(this.getTouchResultLine());
            this.touchResultsLine.getDeleteButton().setEnabled(this.getTouchPredictionLine().getDeleteButton().isEnabled());
        } else if (spellerBandState.isUsingTouchResultLine() && spellerBandState2.isUsingTouchPredictionLine()) {
            this.changeSpellerBand(this.getTouchPredictionLine());
            this.touchPredictionLine.getDeleteButton().setEnabled(this.getTouchResultLine().getDeleteButton().isEnabled());
        } else {
            ITouchResultLine iTouchResultLine;
            this.changeSpellerBand(this.defaultSpellerBand);
            ITouchResultLine iTouchResultLine2 = iTouchResultLine = spellerBandState.isUsingTouchPredictionLine() ? this.getTouchPredictionLine() : this.getTouchResultLine();
            if (this.defaultSpellerBand.getDeleteButton() != null && iTouchResultLine.getDeleteButton() != null) {
                this.defaultSpellerBand.getDeleteButton().setEnabled(iTouchResultLine.getDeleteButton().isEnabled());
            }
            if (this.isParentTouchControllerAsiaAndSpellerNotClose()) {
                ((TouchControllerAsia)this.parent).setFocusState(TouchControllerFocusState.SPELLER_LINE_FOCUS);
                ((TouchControllerAsia)this.parent).propagateValidChars(true);
                ((TouchControllerAsia)this.parent).updateInputDescriptionLineVisibility(true);
            }
        }
        if (this.isParentTouchControllerAsiaAndSpellerNotClose() && !this.isWPEnabled()) {
            ((TouchControllerAsia)this.parent).clearSuggestion();
        }
    }

    protected void focusToCharSetToggleButtonIfPossible(SpellerController.SpellerButtonType spellerButtonType) {
        if (spellerButtonType.isCharsetToggleButton()) {
            List list = this.getCurrentSpellerBand().getSpellerItems();
            for (int i2 = 0; i2 < list.size(); ++i2) {
                SpellerController.ButtonItem buttonItem;
                if (!(list.get(i2) instanceof SpellerController.ButtonItem) || !((SpellerController.ISpellerItem)list.get(i2)).isEnabled() || !(buttonItem = (SpellerController.ButtonItem)list.get(i2)).getButtonType().isCharsetToggleButton()) continue;
                this.moveCursorToItem(buttonItem);
                break;
            }
        }
    }

    public void toggleTouchResultLineToSpeller(SpellerController.SpellerButtonType spellerButtonType) {
        int n;
        if (this.touchCharSetAndTTSHandler.isEnglishSystemLanguage()) {
            n = 0;
        } else if (this.touchCharSetAndTTSHandler.isSystemLanguageChineseSimplified()) {
            n = 3;
        } else if (this.touchCharSetAndTTSHandler.isSystemLanguageChineseHongkong()) {
            n = 4;
        } else if (this.touchCharSetAndTTSHandler.isSystemLanguageChineseTaiwan()) {
            n = 5;
        } else if (this.touchCharSetAndTTSHandler.isSystemLanguageJapanese()) {
            n = 6;
        } else if (this.touchCharSetAndTTSHandler.isSystemLanguageKorean()) {
            n = 7;
        } else {
            tpLogChannelInternal.log(10000, "SpellerControllerAsia#toggleTouchResultLineToSpeller: Unkown system language %1", (long)this.touchCharSetAndTTSHandler.getSystemLanguage());
            return;
        }
        if (this.isParentTouchControllerAsia() && this.touchCharSetAndTTSHandler.getCharSet() != n) {
            ((TouchControllerAsia)this.parent).switchToSpeller(n);
        } else {
            this.changeSpellerState(SpellerBandState.DEFAULT_SPELLER);
        }
    }

    private boolean isParentTouchControllerAsiaAndSpellerNotClose() {
        return this.isParentTouchControllerAsia() && !((TouchControllerAsia)this.parent).isSpellerClosed();
    }

    private boolean isParentTouchControllerAsia() {
        return this.parent instanceof TouchControllerAsia;
    }

    public void setSpellerBandLanguage(TouchCharSetAndTTSHandler touchCharSetAndTTSHandler) {
        super.setSpellerBandLanguage(touchCharSetAndTTSHandler);
        this.currentInputMethod = touchCharSetAndTTSHandler.getAsianInputMethodForInternalLanguage();
        this.setToneCaseToggleButtonStatus(false);
        this.touchCharSetAndTTSHandler = touchCharSetAndTTSHandler;
        this.getTouchResultLine().updateToggleButton(touchCharSetAndTTSHandler);
    }

    protected SpellerController.ISpellerBand getSpellerBandForLanguage(TouchCharSetAndTTSHandler touchCharSetAndTTSHandler) {
        int n = touchCharSetAndTTSHandler.getInternalLanguage();
        int n2 = this.getSpellerMode();
        List list = SpellerCharsetDefinition.initSpellerBandAsia(n2, n);
        this.initializeListItems(n2, touchCharSetAndTTSHandler, list);
        SpellerBandImplAsia spellerBandImplAsia = new SpellerBandImplAsia(list, this.hasOKButton());
        spellerBandImplAsia.setSpellerBandInternalLanguage(n);
        return spellerBandImplAsia;
    }

    private void initializeListItems(int n, TouchCharSetAndTTSHandler touchCharSetAndTTSHandler, List list) {
        SpellerControllerAsia.addToggleButtonIfNeeded(n, touchCharSetAndTTSHandler, list);
        if (touchCharSetAndTTSHandler.isTraditionalChineseSystemLanguage() && !this.isJokerStrokeEnabled(touchCharSetAndTTSHandler)) {
            SpellerControllerAsia.removeJokerForStrokeInputWithoutWordPrediction(list);
        }
    }

    private static void removeJokerForStrokeInputWithoutWordPrediction(List list) {
        SpellerController.ICharacterSpellerItem iCharacterSpellerItem;
        if (spellerLogChannel.isDebug2()) {
            spellerLogChannel.log(10000000, "SpellerControllerAsia#disableJokerForStrokeInputWithoutWordPrediction: disable joker stroke!");
        }
        if ((iCharacterSpellerItem = (SpellerController.ICharacterSpellerItem)list.get(6)).getChar(true).equals("*")) {
            list.remove(6);
        }
    }

    private static void addToggleButtonIfNeeded(int n, TouchCharSetAndTTSHandler touchCharSetAndTTSHandler, List list) {
        if (n == 0 || n == 10 || n == 11 && (touchCharSetAndTTSHandler.isTraditionalChineseSystemLanguage() || touchCharSetAndTTSHandler.isSystemLanguageKorean())) {
            SpellerController.ToggleCharsetButtonItem toggleCharsetButtonItem = SpellerController.ToggleCharsetButtonItem.createInstance(touchCharSetAndTTSHandler);
            list.add(0, toggleCharsetButtonItem);
        }
    }

    private boolean isJokerStrokeEnabled(TouchCharSetAndTTSHandler touchCharSetAndTTSHandler) {
        boolean bl = this.isWPEnabled();
        return touchCharSetAndTTSHandler.isTraditionalChineseSystemLanguage() && bl;
    }

    protected boolean isWPEnabled() {
        boolean bl = false;
        if (this.isParentTouchControllerAsia()) {
            bl = ((TouchControllerAsia)this.parent).shouldUseWordPrediction();
        }
        return bl;
    }

    public boolean isSmallBandCentered() {
        return false;
    }

    public void touchPadFilteredCharactersRecognized(String string) {
        this.getCurrentSpellerState().getBehavior().touchPadFilteredCharactersRecognized(string, this);
    }

    protected void handlePressItem(SpellerController.ISpellerItem iSpellerItem) {
        this.getCurrentSpellerState().getBehavior().handlePressItem(iSpellerItem, this);
    }

    protected void callSuperHandlePressItem(SpellerController.ISpellerItem iSpellerItem) {
        if (this.currentInputMethod == AsianInputMethod.HIRAGANA || this.currentInputMethod == AsianInputMethod.JAMO) {
            if (!iSpellerItem.isEnabled()) {
                spellerLogChannel.log(10000000, "SpellerControllerAsia#callSuperHandlePressItem: ignore press event on disabled item: %1", (Object)iSpellerItem);
                return;
            }
            if (iSpellerItem instanceof SpellerController.AbstractExpandableItem.Char) {
                this.toggleOpeningExpandableItem((SpellerController.AbstractExpandableItem.Char)iSpellerItem);
            } else if (iSpellerItem instanceof SpellerController.AbstractExpandableItem.CharSet) {
                SpellerController.AbstractExpandableItem.Char char_ = this.getLatestOpenExpandableCharItem();
                super.handlePressItem(iSpellerItem);
                if (char_ != null) {
                    this.enableGroupFatherCharacterAfterCloseIfNeed(char_);
                }
            } else {
                super.handlePressItem(iSpellerItem);
            }
        } else {
            super.handlePressItem(iSpellerItem);
        }
    }

    private void toggleOpeningExpandableItem(SpellerController.AbstractExpandableItem.Char char_) {
        boolean bl;
        spellerLogChannel.log(10000000, "SpellerControllerAsia#toggleOpeningExpandableItem: press expandable item: %1", (Object)char_);
        SpellerController.AbstractExpandableItem.Char char_2 = this.getLatestOpenExpandableCharItem();
        if (char_2 != null && !char_2.equals(char_)) {
            this.closeSpellerExandableItem(char_2);
            this.enableGroupFatherCharacterAfterCloseIfNeed(char_2);
        }
        if (bl = char_.isClosed()) {
            this.expandSpellerExpandableItem(char_);
            this.disableGroupFatherCharacterAfterExpandIfNeed(char_);
            ISpellerBandAsia iSpellerBandAsia = (ISpellerBandAsia)this.getCurrentSpellerBand();
            iSpellerBandAsia.adjustDeleteButton(char_, true);
        } else {
            super.handlePressItem(char_);
        }
    }

    private void disableGroupFatherCharacterAfterExpandIfNeed(SpellerController.AbstractExpandableItem.Char char_) {
        boolean bl = SpellerControllerAsia.isItemEnabledWithNVCFilter(char_, this.originalValidChars);
        char_.setEnabled(bl);
        this.setCompositesDirty(true);
    }

    private static boolean isItemEnabledWithNVCFilter(SpellerController.ICharacterSpellerItem iCharacterSpellerItem, String string) {
        String string2 = iCharacterSpellerItem.getChar(true);
        boolean bl = SpellerControllerAsia.isJp() ? AbstractToneAndCaseTogglingTable.isEnabledWithNVCFilter(string2, string) : SpellerControllerAsia.isInNvc(string2, string);
        return bl;
    }

    private static boolean isInNvc(String string, String string2) {
        if (StringUtilities.isNullOrEmpty(string)) {
            return false;
        }
        if (string2 == null) {
            return true;
        }
        return string2.indexOf(string) >= 0;
    }

    private void enableGroupFatherCharacterAfterCloseIfNeed(SpellerController.AbstractExpandableItem.Char char_) {
        boolean bl = SpellerControllerAsia.isItemEnabledWithNVCFilter(char_, this.originalValidChars);
        if (!bl) {
            SpellerController.ISpellerItem iSpellerItem;
            Iterator iterator = char_.getSubBand().iterator();
            while (!(!iterator.hasNext() || (iSpellerItem = (SpellerController.ISpellerItem)iterator.next()) instanceof SpellerController.ICharacterSpellerItem && (bl = SpellerControllerAsia.isItemEnabledWithNVCFilter((SpellerController.ICharacterSpellerItem)iSpellerItem, this.originalValidChars)))) {
            }
        }
        char_.setEnabled(bl);
        this.setCompositesDirty(true);
    }

    private SpellerController.AbstractExpandableItem.Char getLatestOpenExpandableCharItem() {
        SpellerIterator spellerIterator = this.getSpellerIterator(true);
        while (spellerIterator.hasNext()) {
            SpellerController.ISpellerItem iSpellerItem = (SpellerController.ISpellerItem)spellerIterator.next();
            if (!(iSpellerItem instanceof SpellerController.AbstractExpandableItem.Char) || ((SpellerController.AbstractExpandableItem.Char)iSpellerItem).isClosed()) continue;
            return (SpellerController.AbstractExpandableItem.Char)iSpellerItem;
        }
        return null;
    }

    protected void moveCursor(float f2, boolean bl) {
        super.moveCursor(f2, bl);
    }

    protected boolean isDefaultSpellerBand() {
        return this.getCurrentSpellerState().isUsingDefaultSpellerBand();
    }

    public void closed() {
        super.closed();
        if (this.getCurrentSpellerState() != null) {
            this.getCurrentSpellerState().getBehavior().closed(this);
        }
    }

    protected SpellerController.ToggleCharsetButtonItem getCharsetToggleButton() {
        SpellerIterator spellerIterator = this.getSpellerIterator(true);
        while (spellerIterator.hasNext()) {
            SpellerController.ISpellerItem iSpellerItem = (SpellerController.ISpellerItem)spellerIterator.next();
            if (!(iSpellerItem instanceof SpellerController.ToggleCharsetButtonItem)) continue;
            return (SpellerController.ToggleCharsetButtonItem)iSpellerItem;
        }
        return null;
    }

    public boolean hasPendingTouchResult() {
        return this.getCurrentSpellerState().getBehavior().hasPendingTouchResult();
    }

    public String getPendingTouchResult() {
        return this.getCurrentSpellerState().getBehavior().getPendingTouchResult(this);
    }

    public boolean isToggleButtonTargetOfCursor() {
        if (this.getCurrentSpellerState().isUsingDefaultSpellerBand()) {
            return false;
        }
        return this.getTouchResultLine().isToggleButton(this.getCurrentCursorTarget());
    }

    public void clearTouchResultsFromBand() {
        this.getTouchResultLine().deleteOldResultItemsIfPresent();
        if (this.shouldUseTouchPredictionLine()) {
            this.changeSpellerState(SpellerBandState.TOUCH_PREDICTION_LINE);
        } else {
            this.changeSpellerState(SpellerBandState.TOUCH_RESULT_LINE_SINGLE_OR_NO_RESULT);
        }
        this.refreshTouchResultLineIfCurrentlyActive();
    }

    protected void refreshTouchResultLineIfCurrentlyActive() {
        if (!this.getCurrentSpellerState().isUsingDefaultSpellerBand()) {
            this.changeSpellerBand(this.getTouchResultLine());
        }
    }

    public void setConversionLineFocused(boolean bl) {
        if (this.conversionLineFocused != bl) {
            this.conversionLineFocused = bl;
            this.setCompositesDirty(true);
        }
    }

    public boolean isConversionLineFocused() {
        return this.conversionLineFocused;
    }

    protected SpellerIterator getCurrentSpellerIterator() {
        return this.getSpellerIterator(null, false, true);
    }

    public final void changeSpellerState(SpellerBandState spellerBandState) {
        if (spellerBandState == null) {
            tpLogChannelInternal.log(10000, "SpellerControllerAsia#setSpellerState: state is null!");
            return;
        }
        if (!spellerBandState.equals(this.currentSpellerState)) {
            SpellerBandState spellerBandState2 = this.currentSpellerState;
            this.currentSpellerState = spellerBandState;
            this.switchSpellerBand(spellerBandState2, spellerBandState);
            this.notifySpellerBandChanged(this.currentSpellerState, spellerBandState2);
        }
    }

    private void notifySpellerBandChanged(SpellerBandState spellerBandState, SpellerBandState spellerBandState2) {
        Iterator iterator = this.getSpellerListeners().iterator();
        while (iterator.hasNext()) {
            ((ISpellerListenerAsia)iterator.next()).spellerBandStateChanged(spellerBandState, spellerBandState2);
        }
    }

    protected void notifyWordPredictionTouchInputOccurred(String string) {
        Iterator iterator = this.getSpellerListeners().iterator();
        while (iterator.hasNext()) {
            ((ISpellerListenerAsia)iterator.next()).touchWordPredictionContextUpdateNeeded(string);
        }
    }

    public ITouchResultLine getTouchResultLine() {
        if (this.getCurrentSpellerState() == SpellerBandState.TOUCH_PREDICTION_LINE) {
            return this.getTouchPredictionLine();
        }
        if (this.touchResultsLine == null) {
            boolean bl = SpellerControllerAsia.isSpaceItemEnabledAtSpellerBand(this.getCurrentSpellerBand());
            this.touchResultsLine = new TouchResultsLine(this);
            this.touchResultsLine.setSpaceItemEnabled(bl);
        }
        return this.touchResultsLine;
    }

    public ITouchPredictionLine getTouchPredictionLine() {
        if (this.touchPredictionLine == null) {
            this.touchPredictionLine = new TouchPredictionLine(this, this.wordPredictionDataFetcher, this.isTruffleSearch());
        }
        return this.touchPredictionLine;
    }

    protected void setTouchResultLine(ITouchResultLine iTouchResultLine) {
        this.touchResultsLine = iTouchResultLine;
    }

    private static boolean isSpaceItemEnabledAtSpellerBand(SpellerController.ISpellerBand iSpellerBand) {
        boolean bl = false;
        List list = iSpellerBand.getSpellerItems();
        if (list != null && !list.isEmpty()) {
            for (int i2 = 0; i2 < list.size(); ++i2) {
                if (!(list.get(i2) instanceof SpellerController.SingleCharItem) || !((SpellerController.SingleCharItem)list.get(i2)).getChar(true).equals(" ")) continue;
                bl = ((SpellerController.SingleCharItem)list.get(i2)).isEnabled();
                break;
            }
        }
        return bl;
    }

    protected void handleSingleCharItemPressed(SpellerController.SingleCharItem singleCharItem) {
    }

    protected void notifyCharacterPressed(String string, boolean bl, boolean bl2) {
        this.spellerListenerNotifier.characterPressed(string, bl, bl2);
    }

    protected void notifyCharacterPressed(SpellerController.ICharacterSpellerItem iCharacterSpellerItem, boolean bl, boolean bl2) {
        boolean bl3 = false;
        String string = "";
        bl3 = this.needJokerReplacement(iCharacterSpellerItem);
        if (bl3) {
            String string2 = string = "*(-[[|]]Joker*:)";
            this.notifyCharacterPressed(string2, bl, bl2);
        } else {
            super.notifyCharacterPressed(iCharacterSpellerItem, bl, bl2);
        }
    }

    private boolean needJokerReplacement(SpellerController.ICharacterSpellerItem iCharacterSpellerItem) {
        boolean bl;
        boolean bl2 = bl = this.isJokerStrokeEnabled(this.touchCharSetAndTTSHandler) && iCharacterSpellerItem.getChar(true).equalsIgnoreCase("*") && iCharacterSpellerItem instanceof SpellerController.SingleCharItem;
        if (bl) {
            SpellerController.SingleCharItem singleCharItem = (SpellerController.SingleCharItem)iCharacterSpellerItem;
            bl &= !singleCharItem.hasParent();
        }
        return bl;
    }

    public void setToneCaseToggleButtonStatus(boolean bl) {
        SpellerController.ISpellerItem iSpellerItem = this.getJPToneCaseToggleButton();
        if (iSpellerItem != null) {
            iSpellerItem.setEnabled(bl);
            this.setCompositesDirty(true);
        }
    }

    protected SpellerController.ISpellerItem getJPToneCaseToggleButton() {
        if (this.getCurrentSpellerBand() != null) {
            List list = this.getCurrentSpellerBand().getSpellerItems();
            for (int i2 = 0; i2 < list.size(); ++i2) {
                SpellerController.ISpellerItem iSpellerItem = (SpellerController.ISpellerItem)list.get(i2);
                if (!(iSpellerItem instanceof SpellerController.ButtonItem) || SpellerController.SpellerButtonType.JP_TONE_LOWER_CASE_TOGGLE != ((SpellerController.ButtonItem)iSpellerItem).getButtonType()) continue;
                return iSpellerItem;
            }
        }
        return null;
    }

    protected boolean releasePressedItem() {
        return super.releasePressedItem();
    }

    protected boolean isSugguestionValidAtCurrentSpellerFocus(String string, String string2) {
        if (spellerLogChannel.isDebug()) {
            spellerLogChannel.log(10000000, "SpellerControllerAsia#isSugguestionValidAtCurrentSpellerFocus currentText='%1' / autoCompletion='%2' / valid=%3", (Object)string, (Object)string2, (Object)Boolean.toString(true));
        }
        return true;
    }

    protected void handleCursorPositionForAutoCompletion(SpellerController.ISpellerItem iSpellerItem) {
        if (null != iSpellerItem && !(this.getCurrentSpellerBand() instanceof TouchResultsLine)) {
            super.handleCursorPositionForAutoCompletion(iSpellerItem);
        }
    }

    public void onConversionAvailableChange(String string, List list) {
        if (this.getCurrentSpellerState() == SpellerBandState.TOUCH_PREDICTION_LINE) {
            this.getTouchPredictionLine().setResultItems(list);
        }
    }

    public void onNextValidCharactersChange(String string, String string2, String string3) {
        this.updateValidChars(string2, string3);
    }

    public void setWordPredictionDataFetcher(IWordPredictionDataFetcher iWordPredictionDataFetcher) {
        this.wordPredictionDataFetcher = iWordPredictionDataFetcher;
    }

    protected boolean shouldUseTouchPredictionLine() {
        return this.useTouchPredictionLine;
    }

    protected boolean shouldShowWordPredictionResultsForTouch() {
        return this.showWordPredictionResultsForTouch;
    }

    protected void setShouldUseWordPredictionForTouch(boolean bl, boolean bl2) {
        this.useTouchPredictionLine = bl;
        this.showWordPredictionResultsForTouch = bl2;
    }

    public void setTouchPredictionLine(ITouchPredictionLine iTouchPredictionLine) {
        this.touchPredictionLine = iTouchPredictionLine;
    }

    private boolean isTruffleSearch() {
        return this.truffleSearch;
    }

    protected void setIsTruffleSearch(boolean bl) {
        this.truffleSearch = bl;
    }

    public void onSuggestionChange(boolean bl) {
        if (this.touchPredictionLine != null) {
            this.getTouchPredictionLine().onSuggestionChange(bl);
            this.setCompositesDirty(true);
        }
    }

    public static interface ISpellerBandAsia
    extends SpellerController.ISpellerBand {
        public void adjustDeleteButton(SpellerController.ISpellerItem var1, boolean var2);
    }

    public static class TouchResultsLine
    implements ITouchResultLine {
        protected static final int CLOSE_BUTTON_INDEX = 0;
        protected static final int TOGGLE_BUTTON_INDEX = 1;
        protected static final int SPACE_ITEM_INDEX = 2;
        protected static final int DELETE_BUTTON_INDEX = 3;
        private static final int DEFAULT_MAX_TOUCHRESULTS = 5;
        protected final int maxTouchResults;
        protected List items;
        private SpellerController.ISpellerItem currentFocusedItem;
        private boolean upperCase;
        private SpellerController.ISpellerItem spaceCharItem;
        protected final SpellerControllerAsia speller;

        protected TouchResultsLine(SpellerControllerAsia spellerControllerAsia, int n) {
            this.items = new ArrayList(this.getAmountOfStaticItems() + n);
            this.items.add(SpellerController.ButtonItem.createInstance(SpellerController.SpellerButtonType.CLOSE));
            this.items.add(SpellerController.ToggleToSpellerButtonItem.createInstance(spellerControllerAsia.touchCharSetAndTTSHandler));
            this.spaceCharItem = SpellerController.SingleCharItem.createInstance(" ", " ");
            this.items.add(this.spaceCharItem);
            this.items.add(SpellerController.ButtonItem.createInstance(SpellerController.SpellerButtonType.DELETE));
            this.upperCase = true;
            this.currentFocusedItem = (SpellerController.ISpellerItem)this.items.get(0);
            this.maxTouchResults = n;
            this.speller = spellerControllerAsia;
        }

        protected TouchResultsLine(SpellerControllerAsia spellerControllerAsia) {
            this(spellerControllerAsia, 5);
        }

        public boolean isResultItem(SpellerController.ISpellerItem iSpellerItem) {
            if (!this.items.contains(iSpellerItem)) {
                return false;
            }
            return iSpellerItem instanceof SpellerController.ICharacterSpellerItem && this.items.indexOf(iSpellerItem) > 3;
        }

        public void updateToggleButton(TouchCharSetAndTTSHandler touchCharSetAndTTSHandler) {
            SpellerController.ISpellerItem iSpellerItem = this.getToggleButton();
            if (iSpellerItem instanceof SpellerController.ToggleToSpellerButtonItem) {
                ((SpellerController.ToggleToSpellerButtonItem)iSpellerItem).setTouchCharSetAndTTSHandler(touchCharSetAndTTSHandler);
            }
        }

        public boolean isToggleButton(SpellerController.ISpellerItem iSpellerItem) {
            return this.items.get(1) == iSpellerItem;
        }

        public SpellerController.ISpellerItem getToggleButton() {
            return (SpellerController.ISpellerItem)this.items.get(1);
        }

        public SpellerController.ICharacterSpellerItem getSpaceItem() {
            return (SpellerController.ICharacterSpellerItem)this.items.get(2);
        }

        public List getSpellerItems() {
            return this.items;
        }

        public SpellerController.ISpellerItem getCurrentFocusedItem() {
            return this.currentFocusedItem;
        }

        public void setCurrentFocusedItem(SpellerController.ISpellerItem iSpellerItem) {
            this.currentFocusedItem = iSpellerItem;
        }

        public SpellerController.ISpellerItem getOkItem() {
            return null;
        }

        public SpellerController.ISpellerItem getCloseButton() {
            return (SpellerController.ISpellerItem)this.items.get(0);
        }

        public SpellerController.ISpellerItem getDeleteButton() {
            return (SpellerController.ISpellerItem)this.items.get(3);
        }

        public SpellerController.ISpellerItem getDeleteButtonNeighbor() {
            return this.hasResultItems() ? (SpellerController.ISpellerItem)this.items.get(4) : null;
        }

        public boolean isUpperCase() {
            return this.upperCase;
        }

        public void setIsUpperCase(boolean bl) {
            this.upperCase = bl;
        }

        public void setResultItems(List list) {
            this.deleteOldResultItemsIfPresent();
            if (list.size() > 1) {
                Iterator iterator = list.iterator();
                for (int i2 = 0; iterator.hasNext() && i2 < this.maxTouchResults; ++i2) {
                    String string = (String)iterator.next();
                    this.items.add(SpellerController.SingleCharItem.createInstance(string));
                }
            }
            this.speller.changeSpellerBand(this);
        }

        public void setResultItems(String string) {
            this.deleteOldResultItemsIfPresent();
            String string2 = TouchResultsLine.hasDuplicates(string) ? TouchResultsLine.removeDuplicateCharacters(string) : string;
            int n = string2.length();
            if (n > 1) {
                for (int i2 = 0; i2 < n && i2 < this.maxTouchResults; ++i2) {
                    String string3 = string2.substring(i2, i2 + 1);
                    this.items.add(SpellerController.SingleCharItem.createInstance(string3));
                }
            }
            this.speller.changeSpellerBand(this);
        }

        private static boolean hasDuplicates(String string) {
            if (StringUtilities.isNullOrEmpty(string) || string.length() == 1) {
                return false;
            }
            char[] cArray = string.toCharArray();
            for (int i2 = 0; i2 < cArray.length; ++i2) {
                char c2 = cArray[i2];
                for (int i3 = i2 + 1; i3 < cArray.length; ++i3) {
                    if (c2 != cArray[i3]) continue;
                    return true;
                }
            }
            return false;
        }

        protected static String removeDuplicateCharacters(String string) {
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            for (int i2 = 0; i2 < string.length(); ++i2) {
                linkedHashSet.add(new Character(string.charAt(i2)));
            }
            Buffer buffer = new Buffer();
            Iterator iterator = linkedHashSet.iterator();
            while (iterator.hasNext()) {
                buffer.append(iterator.next());
            }
            return buffer.toString();
        }

        protected final void setCurrentFocusedItem(int n) {
            this.setCurrentFocusedItem((SpellerController.ISpellerItem)this.items.get(n));
        }

        public void deleteOldResultItemsIfPresent() {
            if (this.hasResultItems()) {
                for (int i2 = this.items.size() - 1; i2 >= this.getAmountOfStaticItems(); --i2) {
                    ReusableInstanceCache.IReusable iReusable = (ReusableInstanceCache.IReusable)this.items.remove(i2);
                    SpellerControllerAsia.addToSpellerItemCache(iReusable);
                }
            }
        }

        public final boolean hasResultItems() {
            return this.items.size() > this.getAmountOfStaticItems();
        }

        protected int getAmountOfStaticItems() {
            return 4;
        }

        public void resetInitialItem(boolean bl) {
            if (this.hasResultItems()) {
                this.setCurrentFocusedItem(this.getAmountOfStaticItems());
            } else {
                this.setCurrentFocusedItem(3);
            }
        }

        public boolean hasMovingDeleteButton() {
            return false;
        }

        public void itemPressed(SpellerController.ISpellerItem iSpellerItem) {
        }

        public String getFirstResultOrEmptyString() {
            if (!this.hasResultItems()) {
                return "";
            }
            return ((SpellerController.SingleCharItem)this.items.get(this.getAmountOfStaticItems())).getChar(true);
        }

        public void autoCompletionAccepted() {
            this.setResultItems("");
        }

        public void setSpaceItemEnabled(boolean bl) {
            this.spaceCharItem.setEnabled(bl);
        }

        public void free(boolean bl) {
            if (bl) {
                SpellerControllerAsia.addToSpellerItemCache(this.items);
                this.items = Collections.EMPTY_LIST;
            }
        }

        public List getResultItems() {
            if (!this.hasResultItems()) {
                return Collections.EMPTY_LIST;
            }
            return this.items.subList(this.getAmountOfStaticItems(), this.items.size());
        }

        public SpellerController.ISpellerItem getLeftButton() {
            return null;
        }

        public SpellerController.ISpellerItem getRightButton() {
            return null;
        }
    }

    public class SpellerBandImplAsia
    extends SpellerController.SpellerBandImpl
    implements ISpellerBandAsia {
        private int spellerBandInternalLanguage;

        public SpellerBandImplAsia(List list, boolean bl) {
            super(list, bl);
        }

        protected SpellerBandImplAsia(List list, boolean bl, boolean bl2, boolean bl3) {
            super(list, bl, bl2, bl3);
        }

        public int getSpellerBandInternalLanguage() {
            return this.spellerBandInternalLanguage;
        }

        public void setSpellerBandInternalLanguage(int n) {
            this.spellerBandInternalLanguage = n;
        }

        public void itemPressed(SpellerController.ISpellerItem iSpellerItem) {
            if (SpellerControllerAsia.this.targetCursorItem == null || this.deletePosItem == SpellerControllerAsia.this.targetCursorItem) {
                return;
            }
            if (SpellerControllerAsia.this.targetCursorItem instanceof SpellerController.SingleCharItem) {
                SpellerController.SingleCharItem singleCharItem = (SpellerController.SingleCharItem)SpellerControllerAsia.this.targetCursorItem;
                if (singleCharItem.getParent() instanceof SpellerController.AbstractExpandableItem.Char) {
                    this.moveDeleteButton(SpellerControllerAsia.this.targetCursorItem, true);
                } else {
                    super.itemPressed(iSpellerItem);
                }
            } else {
                super.itemPressed(iSpellerItem);
            }
        }

        public void adjustDeleteButton(SpellerController.ISpellerItem iSpellerItem, boolean bl) {
            super.moveDeleteButton(iSpellerItem, bl);
        }
    }

    public static final class TouchPredictionLine
    extends TouchResultsLine
    implements ITouchPredictionLine {
        private final IWordPredictionDataFetcher wordPredictionDataFetcher;
        private boolean outdatedData = false;
        private boolean isTruffleSearchMode = false;
        private SpellerController.ButtonItem truffleButton = null;
        private int lastTimeFocusItem = 3;

        public TouchPredictionLine(SpellerControllerAsia spellerControllerAsia, IWordPredictionDataFetcher iWordPredictionDataFetcher, boolean bl) {
            this(spellerControllerAsia, iWordPredictionDataFetcher, 20, bl);
        }

        protected TouchPredictionLine(SpellerControllerAsia spellerControllerAsia, IWordPredictionDataFetcher iWordPredictionDataFetcher, int n, boolean bl) {
            super(spellerControllerAsia, n);
            this.isTruffleSearchMode = bl;
            if (bl) {
                this.truffleButton = SpellerController.ButtonItem.createInstance(SpellerController.SpellerButtonType.ASIA_ACCEPT_TRUFFLE_SUGGESTION);
                this.items.add(this.truffleButton);
                this.truffleButton.setEnabled(false);
            }
            this.wordPredictionDataFetcher = iWordPredictionDataFetcher == null ? IWordPredictionDataFetcher.NULL : iWordPredictionDataFetcher;
        }

        public void itemPressed(SpellerController.ISpellerItem iSpellerItem) {
            this.lastTimeFocusItem = this.items.indexOf(iSpellerItem);
            if (this.lastTimeFocusItem > 3 || this.lastTimeFocusItem < 2) {
                this.lastTimeFocusItem = 3;
            }
        }

        public void resetInitialItem(boolean bl) {
            if (this.hasResultItems()) {
                super.resetInitialItem(bl);
            } else {
                this.setCurrentFocusedItem(this.lastTimeFocusItem);
            }
        }

        public void updateWordPredictionContext(String string, String string2) {
            this.wordPredictionDataFetcher.updateWordPredictionContext(string, string2, 20);
        }

        public void setResultItems(List list) {
            this.deleteOldResultItemsIfPresent();
            if (!list.isEmpty()) {
                Iterator iterator = list.iterator();
                for (int i2 = 0; iterator.hasNext() && i2 < this.maxTouchResults; ++i2) {
                    String string = (String)iterator.next();
                    this.items.add(SpellerController.SingleCharItem.createInstance(string));
                }
            }
            this.speller.changeSpellerBand(this);
            this.setOutdatedData(false);
        }

        public void clear() {
            this.deleteOldResultItemsIfPresent();
        }

        public boolean isOutdatedData() {
            return this.outdatedData;
        }

        public void setOutdatedData(boolean bl) {
            this.outdatedData = bl;
        }

        protected int getAmountOfStaticItems() {
            int n = super.getAmountOfStaticItems();
            return this.isTruffleSearchMode ? n + 1 : n;
        }

        public void onSuggestionChange(boolean bl) {
            if (this.truffleButton != null) {
                this.truffleButton.setEnabled(bl);
            }
        }

        public SpellerController.ISpellerItem getTruffleButton() {
            return this.truffleButton;
        }

        public IWordPredictionDataFetcher getWordPredictionDataFetcher() {
            return this.wordPredictionDataFetcher;
        }
    }
}

