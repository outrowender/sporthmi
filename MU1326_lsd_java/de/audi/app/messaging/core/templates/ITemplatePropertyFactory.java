/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.templates;

import de.audi.atip.hmi.model.PropertyListCell;
import org.dsi.ifc.messaging.Template;

public interface ITemplatePropertyFactory {
    public PropertyListCell create(Template var1);

    public static final class NullFactory
    implements ITemplatePropertyFactory {
        public PropertyListCell create(Template template) {
            return PropertyListCell.EMPTY_CELL;
        }
    }
}

