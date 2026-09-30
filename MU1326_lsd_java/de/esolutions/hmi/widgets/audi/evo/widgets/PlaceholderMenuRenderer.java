/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets;

import de.esolutions.hmi.widgets.audi.base.StringUtility;
import de.esolutions.hmi.widgets.audi.base.widgets.IRenderer;

public interface PlaceholderMenuRenderer
extends IRenderer {
    public void inOutPositionChanged();

    public StringUtility getStringUtility();
}

