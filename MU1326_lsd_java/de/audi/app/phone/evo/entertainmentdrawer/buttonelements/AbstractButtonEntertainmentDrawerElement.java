/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.evo.entertainmentdrawer.buttonelements;

import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.state.IGlobalTelephoneStateStruct;
import de.audi.app.phone.evo.entertainmentdrawer.AbstractEntertainmentDrawerElement;
import de.audi.atip.hmi.model.ModelGroup;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;

public abstract class AbstractButtonEntertainmentDrawerElement
extends AbstractEntertainmentDrawerElement {
    public static final int BUTTON_INVISIBLE = 0;
    public static final int BUTTON_DISABLED = 1;
    public static final int BUTTON_VISIBLE_ENABLED = 2;
    private final int modelGroupType;
    private IGlobalTelephoneStateStruct stateStruct;

    public AbstractButtonEntertainmentDrawerElement(ITelApplication iTelApplication, int n) {
        super(iTelApplication);
        this.modelGroupType = n;
    }

    public ModelGroup updateInternalModelValues(ModelGroup modelGroup, IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct) {
        this.stateStruct = iGlobalTelephoneStateStruct;
        ChoiceModelApp choiceModelApp = this.getConditionModel();
        modelGroup.add(choiceModelApp);
        choiceModelApp.setValue(this.getNewValue());
        return modelGroup;
    }

    public IGlobalTelephoneStateStruct getCurrentStateStruct() {
        return this.stateStruct;
    }

    public int getModelGroupType() {
        return this.modelGroupType;
    }

    public abstract ChoiceModelApp getConditionModel();

    public abstract int getNewValue();
}

