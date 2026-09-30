/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.templates;

public interface ISaveTemplateControllerObserver {
    public void responseSaveTemplate(long var1, boolean var3);

    public static class EmptyImplementation
    implements ISaveTemplateControllerObserver {
        public void responseSaveTemplate(long l, boolean bl) {
        }
    }
}

