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
    default public int getUppercaseFontHeight(IRenderer iRenderer, int n) {
    }

    default public LabelRenderer createLabelRenderer(LabelController labelController) {
    }

    default public LabelRenderer createMultiLineLabelRenderer(LabelController labelController, int n) {
    }

    default public IconRenderer createIconRenderer(IconController iconController, int n, int n2) {
    }

    default public IconRenderer createIconRenderer(IconController iconController) {
    }

    default public CheckboxRenderer createCheckboxRenderer(CheckboxController checkboxController) {
    }

    default public RadioButtonRenderer createRadioButtonRenderer(RadioButtonController radioButtonController) {
    }

    default public RotaryRenderer createRotaryRenderer(RotaryController rotaryController) {
    }

    default public CompositeRenderer createCompositeRenderer(AbstractWidgetController abstractWidgetController) {
    }

    default public CursorRenderer createFocusCursorRenderer(CursorController cursorController) {
    }

    default public CursorRenderer createSelectionCursorRenderer(CursorController cursorController) {
    }

    default public ScrollbarRenderer createScrollbarRenderer(ScrollbarController scrollbarController) {
    }

    default public GlassplateRenderer createGlassplateRenderer(GlassplateController glassplateController) {
    }

    default public ComboBoxRenderer createComboRenderer(ComboBoxController comboBoxController, IRenderer iRenderer) {
    }

    default public CompositeRenderer createMenuRenderer(MenuController menuController) {
    }

    default public ITimeDateSetttingsRenderer createInternalCursorWidgetRenderer(AbstractInternalCursorWidgetController abstractInternalCursorWidgetController, IRenderer iRenderer, int[] nArray) {
    }

    default public FormfieldInputRenderer createFormfieldInputRenderer(FormfieldInputController formfieldInputController, boolean bl, boolean bl2) {
    }

    default public ComboBoxBackgroundRenderer createComboBoxBackgroundRenderer(ComboBoxBackgroundController comboBoxBackgroundController) {
    }

    default public InstructionTextRenderer createInstructionTextRenderer(InstructionTextContoller instructionTextContoller) {
    }

    default public IFingerTraceRenderer createFingerTraceRenderer(FingerTraceController fingerTraceController) {
    }

    default public IConversionWidgetRenderer createConversionLineRenderer(ConversionLineController conversionLineController, IRenderer iRenderer) {
    }

    default public ISpellerRenderer createSpellerRendererEuropeHigh(SpellerController spellerController, SpellerController spellerController2) {
    }
}

