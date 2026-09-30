/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.event;

import de.audi.atip.hmi.event.ATIPEvent;
import de.audi.atip.hmi.event.ATIPEventListener;
import de.audi.atip.hmi.model.PresetListRow;
import de.audi.atip.preset.DefinitionRequest;
import de.audi.atip.preset.ExecuteRequest;
import java.io.Serializable;

public class PresetResponseEvent
extends ATIPEvent {
    private static final int EVENT_ID = 19001;
    private ExecuteRequest executeRequest = null;
    private DefinitionRequest definitionRequestRequest = null;
    private int result = 0;
    private Serializable data = null;
    private PresetListRow preview = null;

    public PresetResponseEvent(ATIPEventListener aTIPEventListener, ExecuteRequest executeRequest, int n) {
        super(aTIPEventListener, 19001);
        this.executeRequest = executeRequest;
        this.result = n;
    }

    public PresetResponseEvent(ATIPEventListener aTIPEventListener, DefinitionRequest definitionRequest, int n, Serializable serializable, PresetListRow presetListRow) {
        super(aTIPEventListener, 19001);
        this.definitionRequestRequest = definitionRequest;
        this.result = n;
        this.data = serializable;
        this.preview = presetListRow;
    }

    public DefinitionRequest getDefinitionRequest() {
        return this.definitionRequestRequest;
    }

    public ExecuteRequest getExecuteRequest() {
        return this.executeRequest;
    }

    public int getResult() {
        return this.result;
    }

    public Serializable getData() {
        return this.data;
    }

    public PresetListRow getPreview() {
        return this.preview;
    }
}

