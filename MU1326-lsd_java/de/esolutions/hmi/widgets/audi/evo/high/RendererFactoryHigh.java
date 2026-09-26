/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.high;

import de.esolutions.hmi.widgets.audi.base.AbstractWidget;
import de.esolutions.hmi.widgets.audi.base.IWidgetLogChannel;
import de.esolutions.hmi.widgets.audi.base.WidgetConstants;
import de.esolutions.hmi.widgets.audi.base.eal.EALManager;
import de.esolutions.hmi.widgets.audi.base.eal.IWrappedFont;
import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;
import de.esolutions.hmi.widgets.audi.base.widgets.IRenderer;
import de.esolutions.hmi.widgets.audi.evo.IRendererFactory;
import de.esolutions.hmi.widgets.audi.evo.InstructionTextContoller;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.AbstractFingerTraceRendererHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.AbstractRendererHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.CheckboxRendererHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.ComboBoxBackgroundRendererHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.ComboBoxRendererHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.CompositeRendererHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.FingerTraceRendererHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.FocusCursorRendererHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.FormfieldInputRendererHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.GlassplateRendererHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.IconRendererHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.InstructionTextRendererHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.InternalCursorWidgetRendererHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.LabelRendererHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.MultiLineLabelRendererHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.RadioButtonRendererHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.RotaryPreviewRendererHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.ScrollbarRendererKanziHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.SelectionCursorRendererHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.SpellerRendererEuropeHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.asia.ConversionLineWidgetRenderer;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.asia.FingerTraceRendererFullScreenHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.menu.MenuRendererHigh;
import de.esolutions.hmi.widgets.audi.evo.widgets.AbstractInternalCursorWidgetController;
import de.esolutions.hmi.widgets.audi.evo.widgets.CheckboxController;
import de.esolutions.hmi.widgets.audi.evo.widgets.CheckboxRenderer;
import de.esolutions.hmi.widgets.audi.evo.widgets.ComboBoxBackgroundController;
import de.esolutions.hmi.widgets.audi.evo.widgets.ComboBoxBackgroundRenderer;
import de.esolutions.hmi.widgets.audi.evo.widgets.ComboBoxController;
import de.esolutions.hmi.widgets.audi.evo.widgets.ComboBoxRenderer;
import de.esolutions.hmi.widgets.audi.evo.widgets.CompositeRenderer;
import de.esolutions.hmi.widgets.audi.evo.widgets.CursorController;
import de.esolutions.hmi.widgets.audi.evo.widgets.CursorRenderer;
import de.esolutions.hmi.widgets.audi.evo.widgets.FingerTraceController;
import de.esolutions.hmi.widgets.audi.evo.widgets.FormfieldInputController;
import de.esolutions.hmi.widgets.audi.evo.widgets.FormfieldInputRenderer;
import de.esolutions.hmi.widgets.audi.evo.widgets.GlassplateController;
import de.esolutions.hmi.widgets.audi.evo.widgets.GlassplateRenderer;
import de.esolutions.hmi.widgets.audi.evo.widgets.IFingerTraceRenderer;
import de.esolutions.hmi.widgets.audi.evo.widgets.ISpellerRenderer;
import de.esolutions.hmi.widgets.audi.evo.widgets.ITimeDateSetttingsRenderer;
import de.esolutions.hmi.widgets.audi.evo.widgets.IconController;
import de.esolutions.hmi.widgets.audi.evo.widgets.IconRenderer;
import de.esolutions.hmi.widgets.audi.evo.widgets.InstructionTextRenderer;
import de.esolutions.hmi.widgets.audi.evo.widgets.LabelController;
import de.esolutions.hmi.widgets.audi.evo.widgets.LabelRenderer;
import de.esolutions.hmi.widgets.audi.evo.widgets.RadioButtonController;
import de.esolutions.hmi.widgets.audi.evo.widgets.RadioButtonRenderer;
import de.esolutions.hmi.widgets.audi.evo.widgets.RotaryController;
import de.esolutions.hmi.widgets.audi.evo.widgets.RotaryRenderer;
import de.esolutions.hmi.widgets.audi.evo.widgets.ScrollbarController;
import de.esolutions.hmi.widgets.audi.evo.widgets.ScrollbarRenderer;
import de.esolutions.hmi.widgets.audi.evo.widgets.SpellerController;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.ConversionLineController;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.IConversionWidgetRenderer;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuController;

public class RendererFactoryHigh
implements IRendererFactory,
WidgetConstants {
    @Override
    public int getUppercaseFontHeight(IRenderer iRenderer, int n) {
        AbstractRendererHigh abstractRendererHigh = (AbstractRendererHigh)iRenderer;
        IWrappedFont[] iWrappedFontArray = abstractRendererHigh.getFonts();
        if (iWrappedFontArray == null) {
            iWrappedFontArray = abstractRendererHigh.getInheritedFonts();
        }
        if (0 <= n && n < iWrappedFontArray.length) {
            return EALManager.getFontHeightUppercase(iWrappedFontArray[n]);
        }
        return -1;
    }

    @Override
    public LabelRenderer createLabelRenderer(LabelController labelController) {
        return new LabelRendererHigh(labelController);
    }

    @Override
    public LabelRenderer createMultiLineLabelRenderer(LabelController labelController, int n) {
        MultiLineLabelRendererHigh multiLineLabelRendererHigh = new MultiLineLabelRendererHigh(labelController);
        multiLineLabelRendererHigh.setAutoWrap(n);
        return multiLineLabelRendererHigh;
    }

    @Override
    public IconRenderer createIconRenderer(IconController iconController) {
        IconRendererHigh iconRendererHigh = new IconRendererHigh(iconController);
        iconRendererHigh.setAlignment(2, 5);
        return iconRendererHigh;
    }

    @Override
    public IconRenderer createIconRenderer(IconController iconController, int n, int n2) {
        IconRendererHigh iconRendererHigh = new IconRendererHigh(iconController);
        iconRendererHigh.setAlignment(n, n2);
        return iconRendererHigh;
    }

    @Override
    public CheckboxRenderer createCheckboxRenderer(CheckboxController checkboxController) {
        return new CheckboxRendererHigh(checkboxController);
    }

    @Override
    public RadioButtonRenderer createRadioButtonRenderer(RadioButtonController radioButtonController) {
        return new RadioButtonRendererHigh(radioButtonController);
    }

    @Override
    public RotaryRenderer createRotaryRenderer(RotaryController rotaryController) {
        return new RotaryPreviewRendererHigh(rotaryController);
    }

    @Override
    public CompositeRenderer createCompositeRenderer(AbstractWidgetController abstractWidgetController) {
        return new CompositeRendererHigh(abstractWidgetController);
    }

    @Override
    public CompositeRenderer createMenuRenderer(MenuController menuController) {
        return new MenuRendererHigh(menuController);
    }

    @Override
    public CursorRenderer createFocusCursorRenderer(CursorController cursorController) {
        return new FocusCursorRendererHigh(cursorController);
    }

    @Override
    public CursorRenderer createSelectionCursorRenderer(CursorController cursorController) {
        return new SelectionCursorRendererHigh(cursorController);
    }

    @Override
    public ScrollbarRenderer createScrollbarRenderer(ScrollbarController scrollbarController) {
        return new ScrollbarRendererKanziHigh(scrollbarController);
    }

    @Override
    public GlassplateRenderer createGlassplateRenderer(GlassplateController glassplateController) {
        return new GlassplateRendererHigh(glassplateController);
    }

    @Override
    public ComboBoxRenderer createComboRenderer(ComboBoxController comboBoxController, IRenderer iRenderer) {
        ComboBoxRendererHigh comboBoxRendererHigh = new ComboBoxRendererHigh(comboBoxController);
        AbstractRendererHigh abstractRendererHigh = (AbstractRendererHigh)iRenderer;
        IWrappedFont[] iWrappedFontArray = abstractRendererHigh.getFonts();
        if (iWrappedFontArray != null && iWrappedFontArray.length > 1) {
            comboBoxRendererHigh.setFonts(new IWrappedFont[]{iWrappedFontArray[1]});
        }
        return comboBoxRendererHigh;
    }

    @Override
    public ITimeDateSetttingsRenderer createInternalCursorWidgetRenderer(AbstractInternalCursorWidgetController abstractInternalCursorWidgetController, IRenderer iRenderer, int[] nArray) {
        InternalCursorWidgetRendererHigh internalCursorWidgetRendererHigh = new InternalCursorWidgetRendererHigh(abstractInternalCursorWidgetController);
        RendererFactoryHigh.copyFonts((AbstractRendererHigh)iRenderer, internalCursorWidgetRendererHigh, nArray);
        return internalCursorWidgetRendererHigh;
    }

    @Override
    public FormfieldInputRenderer createFormfieldInputRenderer(FormfieldInputController formfieldInputController, boolean bl, boolean bl2) {
        FormfieldInputRendererHigh formfieldInputRendererHigh = new FormfieldInputRendererHigh(formfieldInputController);
        formfieldInputRendererHigh.setEnableDropShadowWidth(bl2);
        formfieldInputRendererHigh.setEnableYTranslation(bl);
        return formfieldInputRendererHigh;
    }

    @Override
    public ComboBoxBackgroundRenderer createComboBoxBackgroundRenderer(ComboBoxBackgroundController comboBoxBackgroundController) {
        return new ComboBoxBackgroundRendererHigh(comboBoxBackgroundController);
    }

    @Override
    public ISpellerRenderer createSpellerRendererEuropeHigh(SpellerController spellerController, SpellerController spellerController2) {
        SpellerRendererEuropeHigh spellerRendererEuropeHigh = new SpellerRendererEuropeHigh(spellerController);
        spellerRendererEuropeHigh.setFonts(((SpellerRendererEuropeHigh)spellerController2.getRenderer()).getFonts());
        return spellerRendererEuropeHigh;
    }

    private static void copyFonts(AbstractRendererHigh abstractRendererHigh, AbstractRendererHigh abstractRendererHigh2) {
        abstractRendererHigh2.setFonts(abstractRendererHigh.getFonts());
    }

    private static void copyFonts(AbstractRendererHigh abstractRendererHigh, AbstractRendererHigh abstractRendererHigh2, int[] nArray) {
        IWrappedFont[] iWrappedFontArray = abstractRendererHigh.getFonts();
        if (iWrappedFontArray == null || iWrappedFontArray.length == 0) {
            iWrappedFontArray = abstractRendererHigh.getInheritedFonts();
        }
        if (nArray != null) {
            IWrappedFont[] iWrappedFontArray2 = new IWrappedFont[nArray.length];
            for (int i2 = 0; i2 < nArray.length; ++i2) {
                int n = nArray[i2];
                if (0 > n || n >= iWrappedFontArray.length) {
                    IWidgetLogChannel.menuItemLogCh.log(10000, "RendererFactoryHigh#copyFonts Font with index %1 not found.", (long)n);
                    n = 0;
                }
                iWrappedFontArray2[i2] = iWrappedFontArray[n];
            }
            abstractRendererHigh2.setFonts(iWrappedFontArray2);
        } else {
            abstractRendererHigh2.setFonts(iWrappedFontArray);
        }
    }

    @Override
    public InstructionTextRenderer createInstructionTextRenderer(InstructionTextContoller instructionTextContoller) {
        return new InstructionTextRendererHigh(instructionTextContoller);
    }

    @Override
    public IFingerTraceRenderer createFingerTraceRenderer(FingerTraceController fingerTraceController) {
        AbstractFingerTraceRendererHigh abstractFingerTraceRendererHigh = AbstractWidget.isAsia() ? new FingerTraceRendererFullScreenHigh(fingerTraceController) : new FingerTraceRendererHigh(fingerTraceController);
        return abstractFingerTraceRendererHigh;
    }

    @Override
    public IConversionWidgetRenderer createConversionLineRenderer(ConversionLineController conversionLineController, IRenderer iRenderer) {
        if (AbstractWidget.isAsia()) {
            ConversionLineWidgetRenderer conversionLineWidgetRenderer = new ConversionLineWidgetRenderer(conversionLineController);
            if (iRenderer instanceof AbstractRendererHigh) {
                RendererFactoryHigh.copyFonts((AbstractRendererHigh)iRenderer, conversionLineWidgetRenderer);
            } else {
                IWidgetLogChannel.logChannel.log(10000, "RendererFactoryHigh#createConversionWidgetRenderer: Could not access fonts, given parent renderer was not of type AbstractRendererHigh.");
            }
            return conversionLineWidgetRenderer;
        }
        IWidgetLogChannel.logChannel.log(10000, "RendererFactoryHigh#createConversionWidgetRenderer: Method was called in non-Asian system. Returning null.");
        return null;
    }
}

