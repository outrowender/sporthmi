/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo;

import de.esolutions.hmi.widgets.audi.evo.widgets.DateSettingsWidgetController;
import de.esolutions.hmi.widgets.audi.evo.widgets.TimeSettingsWidgetController;
import java.util.Calendar;

final class MenuItemBuilder$2
extends TimeSettingsWidgetController {
    private final /* synthetic */ DateSettingsWidgetController val$dateSettings;

    MenuItemBuilder$2(DateSettingsWidgetController dateSettingsWidgetController) {
        this.val$dateSettings = dateSettingsWidgetController;
    }

    public void calendarModified(Calendar calendar) {
        if (this.val$dateSettings.isDateInPast(calendar)) {
            calendar.add(5, 1);
        }
    }
}

