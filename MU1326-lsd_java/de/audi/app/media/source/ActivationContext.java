/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.source;

import de.audi.app.media.source.IActivationContext;
import de.audi.app.media.source.ISourceSlot;
import de.esolutions.fw.util.commons.Buffer;
import java.util.HashMap;
import java.util.Map;

public class ActivationContext
implements IActivationContext {
    private ISourceSlot slot;
    private final Map parameterMap;

    public ActivationContext(ISourceSlot iSourceSlot) {
        this.slot = iSourceSlot;
        this.parameterMap = new HashMap();
    }

    public void updateSlot(ISourceSlot iSourceSlot) {
        this.slot = iSourceSlot;
    }

    @Override
    public ISourceSlot getSlot() {
        return this.slot.getSource().getSlot(this.slot);
    }

    @Override
    public Object getParameter(String string) {
        return this.parameterMap.get(string);
    }

    public void addParameter(String string, Object object) {
        this.parameterMap.put(string, object);
    }

    public String toString() {
        Buffer buffer = new Buffer(30);
        buffer.append(this.slot.getSource());
        buffer.append(this.slot.getIndex());
        buffer.append(",");
        buffer.append(this.parameterMap);
        return buffer.toString();
    }
}

