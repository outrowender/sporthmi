/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets.asia;

import de.audi.atip.util.StringUtilities;
import de.esolutions.hmi.widgets.audi.evo.widgets.ReusableInstanceCache$IReusable;
import de.esolutions.hmi.widgets.audi.evo.widgets.SpellerCharsetDefinition;
import de.esolutions.hmi.widgets.audi.evo.widgets.SpellerController;
import de.esolutions.hmi.widgets.audi.evo.widgets.SpellerController$AbstractExpandableItem$Char;
import de.esolutions.hmi.widgets.audi.evo.widgets.SpellerController$AbstractExpandableItem$CharSet;
import de.esolutions.hmi.widgets.audi.evo.widgets.SpellerController$ButtonItem;
import de.esolutions.hmi.widgets.audi.evo.widgets.SpellerController$ICharacterSpellerItem;
import de.esolutions.hmi.widgets.audi.evo.widgets.SpellerController$ISpellerBand;
import de.esolutions.hmi.widgets.audi.evo.widgets.SpellerController$ISpellerItem;
import de.esolutions.hmi.widgets.audi.evo.widgets.SpellerController$SingleCharItem;
import de.esolutions.hmi.widgets.audi.evo.widgets.SpellerController$SpellerButtonType;
import de.esolutions.hmi.widgets.audi.evo.widgets.SpellerController$ToggleCharsetButtonItem;
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
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.SpellerControllerAsia$ISpellerBandAsia;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.SpellerControllerAsia$SpellerBandImplAsia;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.SpellerControllerAsia$TouchPredictionLine;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.SpellerControllerAsia$TouchResultsLine;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.TouchControllerAsia;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.TouchControllerFocusState;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.converter.ICharacterConverter;
import java.util.Iterator;
import java.util.List;

public class SpellerControllerAsia
extends SpellerController
implements IConversionDataFetcherListener {
    private static final int STROKE_JOKER_INDEX_IN_SPELLERCHARSETASIA;
    private SpellerBandState currentSpellerState;
    private SpellerController$ISpellerBand defaultSpellerBand;
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

    @Override
    protected void initializeWidget() {
        if (this.getCurrentSpellerBand() == null) {
            List list = SpellerCharsetDefinition.initSpellerBand(this.spellerMode, -1);
            this.setCurrentSpellerBand(new SpellerControllerAsia$SpellerBandImplAsia(this, list, this.hasOKButton()), false);
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

    @Override
    protected void updateValidChars(String string, String string2, boolean bl) {
        this.originalValidChars = string;
        if (this.getSpellerMode() == 11 && SpellerControllerAsia.isJp()) {
            string = SpellerControllerAsia.updateValidCharsByVariance(string);
        }
        super.updateValidChars(string, string2, bl);
    }

    @Override
    protected void enableParentIfNeeded(SpellerController$SingleCharItem spellerController$SingleCharItem, boolean bl) {
        if (bl && spellerController$SingleCharItem.hasParent() && spellerController$SingleCharItem.getParent() instanceof SpellerController$AbstractExpandableItem$Char) {
            SpellerController$AbstractExpandableItem$Char spellerController$AbstractExpandableItem$Char = (SpellerController$AbstractExpandableItem$Char)spellerController$SingleCharItem.getParent();
            if (!spellerController$AbstractExpandableItem$Char.isClosed()) {
                this.disableGroupFatherCharacterAfterExpandIfNeed(spellerController$AbstractExpandableItem$Char);
            } else {
                spellerController$SingleCharItem.getParent().setEnabled(bl);
            }
        } else {
            spellerController$SingleCharItem.getParent().setEnabled(bl);
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
            if (!(this.getCurrentSpellerBand() instanceof SpellerControllerAsia$ISpellerBandAsia)) {
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

    protected void focusToCharSetToggleButtonIfPossible(SpellerController$SpellerButtonType spellerController$SpellerButtonType) {
        if (spellerController$SpellerButtonType.isCharsetToggleButton()) {
            List list = this.getCurrentSpellerBand().getSpellerItems();
            for (int i2 = 0; i2 < list.size(); ++i2) {
                SpellerController$ButtonItem spellerController$ButtonItem;
                if (!(list.get(i2) instanceof SpellerController$ButtonItem) || !((SpellerController$ISpellerItem)list.get(i2)).isEnabled() || !(spellerController$ButtonItem = (SpellerController$ButtonItem)list.get(i2)).getButtonType().isCharsetToggleButton()) continue;
                this.moveCursorToItem(spellerController$ButtonItem);
                break;
            }
        }
    }

    public void toggleTouchResultLineToSpeller(SpellerController$SpellerButtonType spellerController$SpellerButtonType) {
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

    @Override
    public void setSpellerBandLanguage(TouchCharSetAndTTSHandler touchCharSetAndTTSHandler) {
        super.setSpellerBandLanguage(touchCharSetAndTTSHandler);
        this.currentInputMethod = touchCharSetAndTTSHandler.getAsianInputMethodForInternalLanguage();
        this.setToneCaseToggleButtonStatus(false);
        this.touchCharSetAndTTSHandler = touchCharSetAndTTSHandler;
        this.getTouchResultLine().updateToggleButton(touchCharSetAndTTSHandler);
    }

    @Override
    protected SpellerController$ISpellerBand getSpellerBandForLanguage(TouchCharSetAndTTSHandler touchCharSetAndTTSHandler) {
        int n = touchCharSetAndTTSHandler.getInternalLanguage();
        int n2 = this.getSpellerMode();
        List list = SpellerCharsetDefinition.initSpellerBandAsia(n2, n);
        this.initializeListItems(n2, touchCharSetAndTTSHandler, list);
        SpellerControllerAsia$SpellerBandImplAsia spellerControllerAsia$SpellerBandImplAsia = new SpellerControllerAsia$SpellerBandImplAsia(this, list, this.hasOKButton());
        spellerControllerAsia$SpellerBandImplAsia.setSpellerBandInternalLanguage(n);
        return spellerControllerAsia$SpellerBandImplAsia;
    }

    private void initializeListItems(int n, TouchCharSetAndTTSHandler touchCharSetAndTTSHandler, List list) {
        SpellerControllerAsia.addToggleButtonIfNeeded(n, touchCharSetAndTTSHandler, list);
        if (touchCharSetAndTTSHandler.isTraditionalChineseSystemLanguage() && !this.isJokerStrokeEnabled(touchCharSetAndTTSHandler)) {
            SpellerControllerAsia.removeJokerForStrokeInputWithoutWordPrediction(list);
        }
    }

    private static void removeJokerForStrokeInputWithoutWordPrediction(List list) {
        SpellerController$ICharacterSpellerItem spellerController$ICharacterSpellerItem;
        if (spellerLogChannel.isDebug2()) {
            spellerLogChannel.log(-2137614336, "SpellerControllerAsia#disableJokerForStrokeInputWithoutWordPrediction: disable joker stroke!");
        }
        if ((spellerController$ICharacterSpellerItem = (SpellerController$ICharacterSpellerItem)list.get(6)).getChar(true).equals("*")) {
            list.remove(6);
        }
    }

    private static void addToggleButtonIfNeeded(int n, TouchCharSetAndTTSHandler touchCharSetAndTTSHandler, List list) {
        if (n == 0 || n == 10 || n == 11 && (touchCharSetAndTTSHandler.isTraditionalChineseSystemLanguage() || touchCharSetAndTTSHandler.isSystemLanguageKorean())) {
            SpellerController$ToggleCharsetButtonItem spellerController$ToggleCharsetButtonItem = SpellerController$ToggleCharsetButtonItem.createInstance(touchCharSetAndTTSHandler);
            list.add(0, spellerController$ToggleCharsetButtonItem);
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

    @Override
    public boolean isSmallBandCentered() {
        return false;
    }

    public void touchPadFilteredCharactersRecognized(String string) {
        this.getCurrentSpellerState().getBehavior().touchPadFilteredCharactersRecognized(string, this);
    }

    @Override
    protected void handlePressItem(SpellerController$ISpellerItem spellerController$ISpellerItem) {
        this.getCurrentSpellerState().getBehavior().handlePressItem(spellerController$ISpellerItem, this);
    }

    protected void callSuperHandlePressItem(SpellerController$ISpellerItem spellerController$ISpellerItem) {
        if (this.currentInputMethod == AsianInputMethod.HIRAGANA || this.currentInputMethod == AsianInputMethod.JAMO) {
            if (!spellerController$ISpellerItem.isEnabled()) {
                spellerLogChannel.log(-2137614336, "SpellerControllerAsia#callSuperHandlePressItem: ignore press event on disabled item: %1", (Object)spellerController$ISpellerItem);
                return;
            }
            if (spellerController$ISpellerItem instanceof SpellerController$AbstractExpandableItem$Char) {
                this.toggleOpeningExpandableItem((SpellerController$AbstractExpandableItem$Char)spellerController$ISpellerItem);
            } else if (spellerController$ISpellerItem instanceof SpellerController$AbstractExpandableItem$CharSet) {
                SpellerController$AbstractExpandableItem$Char spellerController$AbstractExpandableItem$Char = this.getLatestOpenExpandableCharItem();
                super.handlePressItem(spellerController$ISpellerItem);
                if (spellerController$AbstractExpandableItem$Char != null) {
                    this.enableGroupFatherCharacterAfterCloseIfNeed(spellerController$AbstractExpandableItem$Char);
                }
            } else {
                super.handlePressItem(spellerController$ISpellerItem);
            }
        } else {
            super.handlePressItem(spellerController$ISpellerItem);
        }
    }

    private void toggleOpeningExpandableItem(SpellerController$AbstractExpandableItem$Char spellerController$AbstractExpandableItem$Char) {
        boolean bl;
        spellerLogChannel.log(-2137614336, "SpellerControllerAsia#toggleOpeningExpandableItem: press expandable item: %1", (Object)spellerController$AbstractExpandableItem$Char);
        SpellerController$AbstractExpandableItem$Char spellerController$AbstractExpandableItem$Char2 = this.getLatestOpenExpandableCharItem();
        if (spellerController$AbstractExpandableItem$Char2 != null && !spellerController$AbstractExpandableItem$Char2.equals(spellerController$AbstractExpandableItem$Char)) {
            this.closeSpellerExandableItem(spellerController$AbstractExpandableItem$Char2);
            this.enableGroupFatherCharacterAfterCloseIfNeed(spellerController$AbstractExpandableItem$Char2);
        }
        if (bl = spellerController$AbstractExpandableItem$Char.isClosed()) {
            this.expandSpellerExpandableItem(spellerController$AbstractExpandableItem$Char);
            this.disableGroupFatherCharacterAfterExpandIfNeed(spellerController$AbstractExpandableItem$Char);
            SpellerControllerAsia$ISpellerBandAsia spellerControllerAsia$ISpellerBandAsia = (SpellerControllerAsia$ISpellerBandAsia)this.getCurrentSpellerBand();
            spellerControllerAsia$ISpellerBandAsia.adjustDeleteButton(spellerController$AbstractExpandableItem$Char, true);
        } else {
            super.handlePressItem(spellerController$AbstractExpandableItem$Char);
        }
    }

    private void disableGroupFatherCharacterAfterExpandIfNeed(SpellerController$AbstractExpandableItem$Char spellerController$AbstractExpandableItem$Char) {
        boolean bl = SpellerControllerAsia.isItemEnabledWithNVCFilter(spellerController$AbstractExpandableItem$Char, this.originalValidChars);
        spellerController$AbstractExpandableItem$Char.setEnabled(bl);
        this.setCompositesDirty(true);
    }

    private static boolean isItemEnabledWithNVCFilter(SpellerController$ICharacterSpellerItem spellerController$ICharacterSpellerItem, String string) {
        String string2 = spellerController$ICharacterSpellerItem.getChar(true);
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

    private void enableGroupFatherCharacterAfterCloseIfNeed(SpellerController$AbstractExpandableItem$Char spellerController$AbstractExpandableItem$Char) {
        boolean bl = SpellerControllerAsia.isItemEnabledWithNVCFilter(spellerController$AbstractExpandableItem$Char, this.originalValidChars);
        if (!bl) {
            SpellerController$ISpellerItem spellerController$ISpellerItem;
            Iterator iterator = spellerController$AbstractExpandableItem$Char.getSubBand().iterator();
            while (!(!iterator.hasNext() || (spellerController$ISpellerItem = (SpellerController$ISpellerItem)iterator.next()) instanceof SpellerController$ICharacterSpellerItem && (bl = SpellerControllerAsia.isItemEnabledWithNVCFilter((SpellerController$ICharacterSpellerItem)spellerController$ISpellerItem, this.originalValidChars)))) {
            }
        }
        spellerController$AbstractExpandableItem$Char.setEnabled(bl);
        this.setCompositesDirty(true);
    }

    private SpellerController$AbstractExpandableItem$Char getLatestOpenExpandableCharItem() {
        SpellerIterator spellerIterator = this.getSpellerIterator(true);
        while (spellerIterator.hasNext()) {
            SpellerController$ISpellerItem spellerController$ISpellerItem = (SpellerController$ISpellerItem)spellerIterator.next();
            if (!(spellerController$ISpellerItem instanceof SpellerController$AbstractExpandableItem$Char) || ((SpellerController$AbstractExpandableItem$Char)spellerController$ISpellerItem).isClosed()) continue;
            return (SpellerController$AbstractExpandableItem$Char)spellerController$ISpellerItem;
        }
        return null;
    }

    @Override
    protected void moveCursor(float f2, boolean bl) {
        super.moveCursor(f2, bl);
    }

    protected boolean isDefaultSpellerBand() {
        return this.getCurrentSpellerState().isUsingDefaultSpellerBand();
    }

    @Override
    public void closed() {
        super.closed();
        if (this.getCurrentSpellerState() != null) {
            this.getCurrentSpellerState().getBehavior().closed(this);
        }
    }

    protected SpellerController$ToggleCharsetButtonItem getCharsetToggleButton() {
        SpellerIterator spellerIterator = this.getSpellerIterator(true);
        while (spellerIterator.hasNext()) {
            SpellerController$ISpellerItem spellerController$ISpellerItem = (SpellerController$ISpellerItem)spellerIterator.next();
            if (!(spellerController$ISpellerItem instanceof SpellerController$ToggleCharsetButtonItem)) continue;
            return (SpellerController$ToggleCharsetButtonItem)spellerController$ISpellerItem;
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

    @Override
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
            this.touchResultsLine = new SpellerControllerAsia$TouchResultsLine(this);
            this.touchResultsLine.setSpaceItemEnabled(bl);
        }
        return this.touchResultsLine;
    }

    public ITouchPredictionLine getTouchPredictionLine() {
        if (this.touchPredictionLine == null) {
            this.touchPredictionLine = new SpellerControllerAsia$TouchPredictionLine(this, this.wordPredictionDataFetcher, this.isTruffleSearch());
        }
        return this.touchPredictionLine;
    }

    protected void setTouchResultLine(ITouchResultLine iTouchResultLine) {
        this.touchResultsLine = iTouchResultLine;
    }

    private static boolean isSpaceItemEnabledAtSpellerBand(SpellerController$ISpellerBand spellerController$ISpellerBand) {
        boolean bl = false;
        List list = spellerController$ISpellerBand.getSpellerItems();
        if (list != null && !list.isEmpty()) {
            for (int i2 = 0; i2 < list.size(); ++i2) {
                if (!(list.get(i2) instanceof SpellerController$SingleCharItem) || !((SpellerController$SingleCharItem)list.get(i2)).getChar(true).equals(" ")) continue;
                bl = ((SpellerController$SingleCharItem)list.get(i2)).isEnabled();
                break;
            }
        }
        return bl;
    }

    @Override
    protected void handleSingleCharItemPressed(SpellerController$SingleCharItem spellerController$SingleCharItem) {
    }

    protected void notifyCharacterPressed(String string, boolean bl, boolean bl2) {
        this.spellerListenerNotifier.characterPressed(string, bl, bl2);
    }

    @Override
    protected void notifyCharacterPressed(SpellerController$ICharacterSpellerItem spellerController$ICharacterSpellerItem, boolean bl, boolean bl2) {
        boolean bl3 = false;
        String string = "";
        bl3 = this.needJokerReplacement(spellerController$ICharacterSpellerItem);
        if (bl3) {
            String string2 = string = "*(-[[|]]Joker*:)";
            this.notifyCharacterPressed(string2, bl, bl2);
        } else {
            super.notifyCharacterPressed(spellerController$ICharacterSpellerItem, bl, bl2);
        }
    }

    private boolean needJokerReplacement(SpellerController$ICharacterSpellerItem spellerController$ICharacterSpellerItem) {
        boolean bl;
        boolean bl2 = bl = this.isJokerStrokeEnabled(this.touchCharSetAndTTSHandler) && spellerController$ICharacterSpellerItem.getChar(true).equalsIgnoreCase("*") && spellerController$ICharacterSpellerItem instanceof SpellerController$SingleCharItem;
        if (bl) {
            SpellerController$SingleCharItem spellerController$SingleCharItem = (SpellerController$SingleCharItem)spellerController$ICharacterSpellerItem;
            bl &= !spellerController$SingleCharItem.hasParent();
        }
        return bl;
    }

    public void setToneCaseToggleButtonStatus(boolean bl) {
        SpellerController$ISpellerItem spellerController$ISpellerItem = this.getJPToneCaseToggleButton();
        if (spellerController$ISpellerItem != null) {
            spellerController$ISpellerItem.setEnabled(bl);
            this.setCompositesDirty(true);
        }
    }

    protected SpellerController$ISpellerItem getJPToneCaseToggleButton() {
        if (this.getCurrentSpellerBand() != null) {
            List list = this.getCurrentSpellerBand().getSpellerItems();
            for (int i2 = 0; i2 < list.size(); ++i2) {
                SpellerController$ISpellerItem spellerController$ISpellerItem = (SpellerController$ISpellerItem)list.get(i2);
                if (!(spellerController$ISpellerItem instanceof SpellerController$ButtonItem) || SpellerController$SpellerButtonType.JP_TONE_LOWER_CASE_TOGGLE != ((SpellerController$ButtonItem)spellerController$ISpellerItem).getButtonType()) continue;
                return spellerController$ISpellerItem;
            }
        }
        return null;
    }

    @Override
    protected boolean releasePressedItem() {
        return super.releasePressedItem();
    }

    @Override
    protected boolean isSugguestionValidAtCurrentSpellerFocus(String string, String string2) {
        if (spellerLogChannel.isDebug()) {
            spellerLogChannel.log(-2137614336, "SpellerControllerAsia#isSugguestionValidAtCurrentSpellerFocus currentText='%1' / autoCompletion='%2' / valid=%3", (Object)string, (Object)string2, (Object)Boolean.toString(true));
        }
        return true;
    }

    @Override
    protected void handleCursorPositionForAutoCompletion(SpellerController$ISpellerItem spellerController$ISpellerItem) {
        if (null != spellerController$ISpellerItem && !(this.getCurrentSpellerBand() instanceof SpellerControllerAsia$TouchResultsLine)) {
            super.handleCursorPositionForAutoCompletion(spellerController$ISpellerItem);
        }
    }

    @Override
    public void onConversionAvailableChange(String string, List list) {
        if (this.getCurrentSpellerState() == SpellerBandState.TOUCH_PREDICTION_LINE) {
            this.getTouchPredictionLine().setResultItems(list);
        }
    }

    @Override
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

    static /* synthetic */ SpellerController$ISpellerItem access$000(SpellerControllerAsia spellerControllerAsia) {
        return spellerControllerAsia.targetCursorItem;
    }

    static /* synthetic */ SpellerController$ISpellerItem access$100(SpellerControllerAsia spellerControllerAsia) {
        return spellerControllerAsia.targetCursorItem;
    }

    static /* synthetic */ SpellerController$ISpellerItem access$200(SpellerControllerAsia spellerControllerAsia) {
        return spellerControllerAsia.targetCursorItem;
    }

    static /* synthetic */ SpellerController$ISpellerItem access$300(SpellerControllerAsia spellerControllerAsia) {
        return spellerControllerAsia.targetCursorItem;
    }

    static /* synthetic */ SpellerController$ISpellerItem access$400(SpellerControllerAsia spellerControllerAsia) {
        return spellerControllerAsia.targetCursorItem;
    }

    static /* synthetic */ TouchCharSetAndTTSHandler access$500(SpellerControllerAsia spellerControllerAsia) {
        return spellerControllerAsia.touchCharSetAndTTSHandler;
    }

    static /* synthetic */ void access$600(SpellerControllerAsia spellerControllerAsia, SpellerController$ISpellerBand spellerController$ISpellerBand) {
        spellerControllerAsia.changeSpellerBand(spellerController$ISpellerBand);
    }

    static /* synthetic */ void access$700(SpellerControllerAsia spellerControllerAsia, SpellerController$ISpellerBand spellerController$ISpellerBand) {
        spellerControllerAsia.changeSpellerBand(spellerController$ISpellerBand);
    }

    static /* synthetic */ void access$800(ReusableInstanceCache$IReusable reusableInstanceCache$IReusable) {
        SpellerControllerAsia.addToSpellerItemCache(reusableInstanceCache$IReusable);
    }

    static /* synthetic */ void access$900(List list) {
        SpellerControllerAsia.addToSpellerItemCache(list);
    }

    static /* synthetic */ void access$1000(SpellerControllerAsia spellerControllerAsia, SpellerController$ISpellerBand spellerController$ISpellerBand) {
        spellerControllerAsia.changeSpellerBand(spellerController$ISpellerBand);
    }
}

