/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.guide;

import de.audi.app.messaging.core.component.AbstractMessagingComponent;
import de.audi.app.messaging.core.osgi.MessagingBundleContext;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.hmi.modelaccess.SpellerModelApp;

public final class ModelAccess
extends AbstractMessagingComponent {
    public static final int OPERATION_IN_PROGRESS;
    public static final int OPERATION_COMPLETED_OK;
    public static final int OPERATION_COMPLETED_NOK;
    public static final int OPERATION_FAILED;

    public ModelAccess(MessagingBundleContext messagingBundleContext) {
        super(messagingBundleContext, "App.Messaging.Main");
    }

    public void setWaitSyncChoice(int n, int n2) {
        boolean bl = true;
        String string = null;
        switch (n2) {
            case 0: {
                string = "WAITING";
                break;
            }
            case 1: {
                string = "OK";
                break;
            }
            case 2: {
                string = "ERROR";
                break;
            }
            default: {
                bl = false;
                this.log.log(10000, "[ModelAccess#setWaitSyncChoice] Invalid mediatorState = %1, bailing out.", (long)n2);
            }
        }
        if (bl) {
            this.log.log(-2137614336, "[ModelAccess#setWaitSyncChoice] choiceModelID = %1, setting WaitSyncMediator state: %2", (Object)Integer.toString(n), (Object)string);
            ChoiceModelApp choiceModelApp = this.framework.getHmiServiceApp().getChoiceModel(n);
            choiceModelApp.setStatus(n2);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void setOperationStateChoice(int n, int n2) {
        boolean bl = true;
        int n3 = 0;
        int n4 = 0;
        String string = null;
        switch (n2) {
            case 0: {
                n3 = 0;
                string = "OPERATION_IN_PROGRESS";
                break;
            }
            case 1: {
                n3 = 1;
                n4 = 0;
                string = "OPERATION_COMPLETED_OK";
                break;
            }
            case 2: {
                n3 = 1;
                n4 = -1;
                string = "OPERATION_COMPLETED_NOK";
                break;
            }
            case 3: {
                n3 = 2;
                string = "OPERATION_FAILED";
                break;
            }
            default: {
                bl = false;
                this.log.log(10000, "[ModelAccess#setOperationStateChoice] Invalid operationState = %1, bailing out.", (long)n2);
            }
        }
        if (bl) {
            this.log.log(-2137614336, "[ModelAccess#setOperationStateChoice] choiceModelID = %1, setting operationState = %2", (Object)Integer.toString(n), (Object)string);
            ChoiceModelApp choiceModelApp = this.framework.getHmiServiceApp().getChoiceModel(n);
            try {
                choiceModelApp.beginTransaction();
                choiceModelApp.setStatus(n3);
                choiceModelApp.setValue(n4);
            }
            catch (IllegalStateException illegalStateException) {
                this.log.log(10000, "[ModelAccess#setOperationStateChoice] Transaction failed: %1", (Throwable)illegalStateException);
            }
            finally {
                choiceModelApp.endTransaction();
            }
        }
    }

    public void setOperationStateChoiceUnbuffered(int n, int n2) {
        boolean bl = true;
        int n3 = 0;
        int n4 = 0;
        String string = null;
        switch (n2) {
            case 0: {
                n3 = 0;
                string = "OPERATION_IN_PROGRESS";
                break;
            }
            case 1: {
                n3 = 1;
                n4 = 0;
                string = "OPERATION_COMPLETED_OK";
                break;
            }
            case 2: {
                n3 = 1;
                n4 = -1;
                string = "OPERATION_COMPLETED_NOK";
                break;
            }
            case 3: {
                n3 = 2;
                string = "OPERATION_FAILED";
                break;
            }
            default: {
                bl = false;
                this.log.log(10000, "[ModelAccess#setOperationStateChoiceUnbuffered] Invalid operationState = %1, bailing out.", (long)n2);
            }
        }
        if (bl) {
            this.log.log(-2137614336, "[ModelAccess#setOperationStateChoiceUnbuffered] choiceModelID = %1, setting operationState = %2", (Object)Integer.toString(n), (Object)string);
            ChoiceModelApp choiceModelApp = this.framework.getHmiServiceApp().getChoiceModel(n);
            choiceModelApp.setStatus(n3);
            choiceModelApp.setValue(n4);
        }
    }

    public void initSpellerModel(int n, int n2, int n3) {
        SpellerModelApp spellerModelApp = this.framework.getHmiServiceApp().getSpellerModel(n);
        spellerModelApp.setMinLength(n2);
        spellerModelApp.setMaxLength(n3);
    }
}

