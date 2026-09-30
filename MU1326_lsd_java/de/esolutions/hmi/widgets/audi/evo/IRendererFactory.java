/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo;

import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;
import de.esolutions.hmi.widgets.audi.base.widgets.IRenderer;
import de.esolutions.hmi.widgets.audi.evo.InstructionTextContoller;
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

public interface IRendererFactory {
    public int getUppercaseFontHeight(IRenderer var1, int var2);

    public LabelRenderer createLabelRenderer(LabelController var1);

    public LabelRenderer createMultiLineLabelRenderer(LabelController var1, int var2);

    public IconRenderer createIconRenderer(IconController var1, int var2, int var3);

    public IconRenderer createIconRenderer(IconController var1);

    public CheckboxRenderer createCheckboxRenderer(CheckboxController var1);

    public RadioButtonRenderer createRadioButtonRenderer(RadioButtonController var1);

    public RotaryRenderer createRotaryRenderer(RotaryController var1);

    public CompositeRenderer createCompositeRenderer(AbstractWidgetController var1);

    public CursorRenderer createFocusCursorRenderer(CursorController var1);

    public CursorRenderer createSelectionCursorRenderer(CursorController var1);

    public ScrollbarRenderer createScrollbarRenderer(ScrollbarController var1);

    public GlassplateRenderer createGlassplateRenderer(GlassplateController var1);

    public ComboBoxRenderer createComboRenderer(ComboBoxController var1, IRenderer var2);

    public CompositeRenderer createMenuRenderer(MenuController var1);

    public ITimeDateSetttingsRenderer createInternalCursorWidgetRenderer(AbstractInternalCursorWidgetController var1, IRenderer var2, int[] var3);

    public FormfieldInputRenderer createFormfieldInputRenderer(FormfieldInputController var1, boolean var2, boolean var3);

    public ComboBoxBackgroundRenderer createComboBoxBackgroundRenderer(ComboBoxBackgroundController var1);

    public InstructionTextRenderer createInstructionTextRenderer(InstructionTextContoller var1);

    public IFingerTraceRenderer createFingerTraceRenderer(FingerTraceController var1);

    public IConversionWidgetRenderer createConversionLineRenderer(ConversionLineController var1, IRenderer var2);

    public ISpellerRenderer createSpellerRendererEuropeHigh(SpellerController var1, SpellerController var2);
}

