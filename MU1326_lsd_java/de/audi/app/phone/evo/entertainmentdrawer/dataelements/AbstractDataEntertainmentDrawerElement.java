/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.evo.entertainmentdrawer.dataelements;

import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.state.IGlobalTelephoneStateStruct;
import de.audi.app.phone.evo.entertainmentdrawer.AbstractEntertainmentDrawerElement;
import de.audi.atip.hmi.model.ModelGroup;
import de.audi.atip.hmi.modelaccess.HMIModelApp;
import java.util.List;

public abstract class AbstractDataEntertainmentDrawerElement
extends AbstractEntertainmentDrawerElement {
    private final int modelGroupType;
    private IGlobalTelephoneStateStruct stateStruct;

    public AbstractDataEntertainmentDrawerElement(ITelApplication iTelApplication, int n) {
        super(iTelApplication);
        this.modelGroupType = n;
    }

    public ModelGroup updateInternalModelValues(ModelGroup modelGroup, IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct) {
        this.stateStruct = iGlobalTelephoneStateStruct;
        List list = this.getModels();
        for (int i2 = 0; i2 < list.size(); ++i2) {
            modelGroup.add((HMIModelApp)list.get(i2));
        }
        this.updateValues();
        return modelGroup;
    }

    public IGlobalTelephoneStateStruct getCurrentStateStruct() {
        return this.stateStruct;
    }

    public int getModelGroupType() {
        return this.modelGroupType;
    }

    public abstract List getModels();

    public abstract void updateValues();

    static final class CallType {
        public static final int CALLTYPE_SINGLE = -1;
        public static final int CALLTYPE_SINGLE_MAILBOX = 0;
        public static final int CALLTYPE_SINGLE_INFO = 1;
        public static final int CALLTYPE_SINGLE_BREAKDOWN = 2;
        public static final int CALLTYPE_SINGLE_EMERGENCY = 3;
        public static final int CALLTYPE_SINGLE_UNKNOWN = 4;
        public static final int CALLTYPE_CONFERENCE = 5;

        CallType() {
        }
    }

    static final class CallImageType {
        public static final int SINGLE = 0;
        public static final int CUSTOM_IMAGE = 1;
        public static final int CONFERENCE = 2;

        CallImageType() {
        }
    }
}

