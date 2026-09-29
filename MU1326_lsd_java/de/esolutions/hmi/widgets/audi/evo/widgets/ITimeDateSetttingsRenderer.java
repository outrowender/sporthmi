/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets;

import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;
import de.esolutions.hmi.widgets.audi.evo.widgets.CompositeRenderer;

public interface ITimeDateSetttingsRenderer
extends CompositeRenderer {
    default public int getPreferredWidth() {
    }

    default public int getPreferredHeight() {
    }

    default public int getBaseline() {
    }

    default public AbstractWidgetController getFormfieldStub() {
    }

    default public int getTextWidth(String string) {
    }

    default public void setAutoConfig(boolean bl) {
    }

    default public void setBackgroundHeight(int n) {
    }

    default public void setBackgroundVerticalOffset(int n) {
    }

    default public void setTextVerticalOffset(int n) {
    }
}

