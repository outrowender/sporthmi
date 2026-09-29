/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.evo.readout;

import de.audi.app.messaging.core.component.AbstractMessagingComponent;
import de.audi.app.messaging.core.osgi.IServiceRegistry;
import de.audi.app.messaging.core.osgi.MessagingBundleContext;
import de.audi.app.messaging.core.osgi.ServiceFilterBuilder;
import de.audi.app.messaging.core.readout.EppMarkup;
import de.audi.app.messaging.core.readout.IReadable;
import de.audi.app.messaging.core.readout.IReadableProvider;
import de.audi.app.messaging.core.readout.MessagingReadoutService$DialogState;
import de.audi.app.messaging.core.readout.Readable;
import de.audi.app.messaging.core.readout.SsmlMarkup;
import de.audi.app.messaging.core.readout.TemplateContainer;
import de.audi.app.messaging.core.readout.TemplateProcessor;
import de.audi.app.messaging.core.util.Logs;
import de.audi.app.messaging.core.util.Maps;
import de.audi.app.messaging.core.util.MessageContacts;
import de.audi.app.messaging.core.util.Messages;
import de.audi.app.messaging.core.util.Strings;
import de.audi.app.messaging.core.util.Times;
import de.audi.app.messaging.evo.readout.EvoReadableProvider$1;
import de.audi.app.messaging.evo.readout.EvoTemplateProperties;
import de.audi.app.messaging.evo.readout.EvoTemplateProperties$Bool;
import de.audi.app.messaging.evo.readout.EvoTemplateProperties$MessageStatus;
import de.audi.app.messaging.evo.readout.EvoTemplateProperties$MessageType;
import de.audi.atip.hmi.SDPromptTextAccess;
import de.esolutions.fw.util.commons.Buffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.dsi.ifc.messaging.MatchedAddress;
import org.dsi.ifc.messaging.MessageDetails;
import org.osgi.framework.Filter;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public final class EvoReadableProvider
extends AbstractMessagingComponent
implements IReadableProvider {
    private static final String VARIABLE_CONTACT;
    private static final String VARIABLE_DATE;
    private static final String VARIABLE_TIME;
    private static final String VARIABLE_SUBJECT;
    private volatile TemplateContainer regularTemplateContainer;
    private volatile TemplateContainer conciseTemplateContainer;
    private volatile TemplateContainer fallbackTemplateContainer;
    private volatile SDPromptTextAccess sdPromptTextAccess = null;
    static /* synthetic */ Class class$de$audi$atip$hmi$SDPromptTextAccess;

    public EvoReadableProvider(MessagingBundleContext messagingBundleContext) {
        super(messagingBundleContext, "App.Messaging.Main");
        this.setTemplateContainers();
    }

    @Override
    public void connect(IServiceRegistry iServiceRegistry) {
        try {
            super.connect(iServiceRegistry);
            iServiceRegistry.addTracker(this.createServiceTracker());
        }
        catch (Exception exception) {
            this.log.log(10000, "[EvoReadableProvider#connect] An error occurred: ", (Throwable)exception);
        }
    }

    private ServiceTracker createServiceTracker() {
        String string = ServiceFilterBuilder.createFilterString("objectClass", (class$de$audi$atip$hmi$SDPromptTextAccess == null ? (class$de$audi$atip$hmi$SDPromptTextAccess = EvoReadableProvider.class$("de.audi.atip.hmi.SDPromptTextAccess")) : class$de$audi$atip$hmi$SDPromptTextAccess).getName());
        Filter filter = this.bundleContext.createFilter(string);
        EvoReadableProvider$1 evoReadableProvider$1 = new EvoReadableProvider$1(this, this.log, this.bundleContext);
        return new ServiceTracker(this.bundleContext, filter, (ServiceTrackerCustomizer)evoReadableProvider$1);
    }

    private void setSdPromptAccess(SDPromptTextAccess sDPromptTextAccess) {
        this.log.log(-2137614336, "[EvoReadableProvider#setSdPromptAccess] sdPromptTextAccess = %1.", (Object)sDPromptTextAccess);
        this.sdPromptTextAccess = sDPromptTextAccess;
        this.setTemplateContainers();
    }

    @Override
    public IReadable getReadable() {
        Readable readable = null;
        try {
            MessageDetails messageDetails = this.msgApp.getSelectedMessage().getMessageDetails();
            if (messageDetails == null) {
                this.log.log(10000, "[EvoReadableProvider#getReadable] No message details available for readout.");
            } else if (!Messages.isSms(messageDetails) && !Messages.isEmail(messageDetails)) {
                this.log.log(10000, "[EvoReadableProvider#getReadable] Unsupported message type, messageDetails = %1.", (Object)messageDetails);
            } else {
                String string = this.getHeaderSpeakTask(messageDetails);
                String string2 = this.getBodySpeakTask(messageDetails);
                if (Strings.isNullOrEmpty(string) && Strings.isNullOrEmpty(string2)) {
                    this.log.log(10000, "[EvoReadableProvider#getReadable] Nothing to read: headerSpeakTask = %1, bodySpeakTask = %2", (Object)string, (Object)string2);
                } else {
                    if (string == null || string2 == null) {
                        this.log.log(-1601830656, "[EvoReadableProvider#getReadable] Text is null: headerSpeakTask = %1, bodySpeakTask = %2", (Object)string, (Object)string2);
                    }
                    ArrayList arrayList = new ArrayList(2);
                    if (!Strings.isNullOrEmpty(string)) {
                        arrayList.add(string);
                    }
                    if (!Strings.isNullOrEmpty(string2)) {
                        arrayList.add(string2);
                    }
                    if (this.log.isInfo()) {
                        this.log.log(1078071040, "[EvoReadableProvider#getReadable] headerSpeakTask = %1", (Object)String.valueOf(string));
                    }
                    readable = new Readable(arrayList);
                }
            }
        }
        catch (Exception exception) {
            Logs.logException(this.log, exception, "[EvoReadableProvider#getReadable]");
        }
        return readable;
    }

    private String getHeaderSpeakTask(MessageDetails messageDetails) {
        String string = null;
        String string2 = null;
        Map map = null;
        try {
            string2 = this.getHeaderTemplate(messageDetails);
            map = this.createReplacementMap(messageDetails);
            string = TemplateProcessor.replaceVariables(string2, map);
        }
        catch (Exception exception) {
            Logs.logException(this.log, exception, "[EvoReadableProvider#getHeaderSpeakTask]");
        }
        if (string == null) {
            this.log.log(10000, "[EvoReadableProvider#getHeaderSpeakTask] Header text is null, headerTemplate = %1, replacementMap = %2", (Object)String.valueOf(string2), (Object)Maps.toMultiLineString(map));
        }
        return string;
    }

    private String getBodySpeakTask(MessageDetails messageDetails) {
        String string = null;
        try {
            if (!Strings.isNullOrEmpty(messageDetails.getBody())) {
                string = Messages.isEmail(messageDetails) ? EppMarkup.getText(messageDetails, true) : SsmlMarkup.asSmsBody(messageDetails.getBody());
            }
        }
        catch (Exception exception) {
            Logs.logException(this.log, exception, "[EvoReadableProvider#getBodySpeakTask]");
        }
        if (string == null) {
            this.log.log(10000, "[EvoReadableProvider#getBodySpeakTask] Body text is null. ");
        }
        return string;
    }

    private Map createReplacementMap(MessageDetails messageDetails) {
        String string;
        String string2;
        Object object;
        HashMap hashMap = new HashMap(16);
        String string3 = "";
        if (MessageContacts.hasPrimaryContact(messageDetails)) {
            object = MessageContacts.getPrimaryContact(messageDetails);
            string2 = ((MatchedAddress)object).getName();
            string = ((MatchedAddress)object).getAddress();
            if (!Strings.isNullOrEmpty(string2)) {
                string3 = SsmlMarkup.asName(string2);
            } else if (!Strings.isNullOrEmpty(string)) {
                string3 = Messages.isSms(messageDetails) ? SsmlMarkup.asPhoneNumber(string) : string;
            }
        }
        object = SsmlMarkup.asDate(Times.formatDate(messageDetails.getDateTime()));
        string2 = SsmlMarkup.asTime(Times.formatTime(messageDetails.getDateTime()));
        string = SsmlMarkup.toTtsReadableText(messageDetails.getSubject());
        hashMap.put("$<0>", string3);
        hashMap.put("$<1>", object);
        hashMap.put("$<2>", string2);
        hashMap.put("$<3>", string);
        return hashMap;
    }

    private String getHeaderTemplate(MessageDetails messageDetails) {
        String string = null;
        EvoTemplateProperties evoTemplateProperties = new EvoTemplateProperties(EvoReadableProvider.getMessageType(messageDetails), EvoReadableProvider.getMessageStatus(messageDetails), EvoReadableProvider.getHasContact(messageDetails), EvoReadableProvider.getHasTimestamp(messageDetails), EvoReadableProvider.getHasSubject(messageDetails));
        MessagingReadoutService$DialogState messagingReadoutService$DialogState = this.msgApp.getMessagingReadoutService().getDialogState();
        if (messagingReadoutService$DialogState.isActive()) {
            this.log.log(1078071040, "[EvoReadableProvider#getHeaderTemplate] Using regular templates.");
            String string2 = this.regularTemplateContainer.getTemplate(evoTemplateProperties);
            if (string2 == null) {
                this.log.log(-1601830656, "[EvoReadableProvider#getHeaderTemplate] No template found, properties = %1, regularTemplateContainer = %2", (Object)evoTemplateProperties, (Object)this.regularTemplateContainer);
            } else {
                string = string2;
            }
        } else if (Messages.isEmail(messageDetails)) {
            this.log.log(1078071040, "[EvoReadableProvider#getHeaderTemplate] Using concise templates.");
            String string3 = this.conciseTemplateContainer.getTemplate(evoTemplateProperties);
            if (string3 == null) {
                this.log.log(-1601830656, "[EvoReadableProvider#getHeaderTemplate] No template found, properties = %1, conciseTemplateContainer = %2", (Object)evoTemplateProperties, (Object)this.regularTemplateContainer);
            } else {
                string = string3;
            }
        } else {
            this.log.log(1078071040, "[EvoReadableProvider#getHeaderTemplate] Not using a template, header readout is to be skipped.");
            string = "";
        }
        if (string == null) {
            this.log.log(-1601830656, "[EvoReadableProvider#getHeaderTemplate] No template found, using fallback templates.", (Object)evoTemplateProperties, (Object)this);
            string = this.fallbackTemplateContainer.getTemplate(evoTemplateProperties);
        }
        return string;
    }

    private static EvoTemplateProperties$MessageType getMessageType(MessageDetails messageDetails) {
        int n = messageDetails.getType();
        EvoTemplateProperties$MessageType evoTemplateProperties$MessageType = n == 1 ? EvoTemplateProperties$MessageType.SMS : EvoTemplateProperties$MessageType.EMAIL;
        return evoTemplateProperties$MessageType;
    }

    private static EvoTemplateProperties$MessageStatus getMessageStatus(MessageDetails messageDetails) {
        EvoTemplateProperties$MessageStatus evoTemplateProperties$MessageStatus;
        int n = messageDetails.getMessageStatus();
        switch (n) {
            case 6: 
            case 7: {
                evoTemplateProperties$MessageStatus = EvoTemplateProperties$MessageStatus.SENT;
                break;
            }
            case 2: {
                evoTemplateProperties$MessageStatus = EvoTemplateProperties$MessageStatus.DRAFT;
                break;
            }
            case 5: 
            case 8: {
                evoTemplateProperties$MessageStatus = EvoTemplateProperties$MessageStatus.OUTBOX;
                break;
            }
            default: {
                evoTemplateProperties$MessageStatus = EvoTemplateProperties$MessageStatus.RECEIVED;
            }
        }
        return evoTemplateProperties$MessageStatus;
    }

    private static EvoTemplateProperties$Bool getHasContact(MessageDetails messageDetails) {
        return MessageContacts.hasPrimaryContact(messageDetails) ? EvoTemplateProperties$Bool.TRUE : EvoTemplateProperties$Bool.FALSE;
    }

    private static EvoTemplateProperties$Bool getHasTimestamp(MessageDetails messageDetails) {
        boolean bl = Times.isTimeStampValid(messageDetails.getDateTime());
        return bl ? EvoTemplateProperties$Bool.TRUE : EvoTemplateProperties$Bool.FALSE;
    }

    private static EvoTemplateProperties$Bool getHasSubject(MessageDetails messageDetails) {
        boolean bl = !Strings.isNullOrEmpty(messageDetails.getSubject());
        return bl ? EvoTemplateProperties$Bool.TRUE : EvoTemplateProperties$Bool.FALSE;
    }

    private void setTemplateContainers() {
        SDPromptTextAccess sDPromptTextAccess = this.sdPromptTextAccess;
        this.setRegularTemplateContainer(sDPromptTextAccess);
        this.setConciseTemplateContainer(sDPromptTextAccess);
        this.setFallbackTemplateContainer(sDPromptTextAccess);
    }

    private void setRegularTemplateContainer(SDPromptTextAccess sDPromptTextAccess) {
        TemplateContainer templateContainer = new TemplateContainer();
        if (sDPromptTextAccess != null) {
            EvoTemplateProperties evoTemplateProperties = null;
            String string = null;
            evoTemplateProperties = new EvoTemplateProperties(EvoTemplateProperties$MessageType.SMS, EvoTemplateProperties$MessageStatus.RECEIVED, EvoTemplateProperties$Bool.TRUE, EvoTemplateProperties$Bool.TRUE, EvoTemplateProperties$Bool.IRRELEVANT);
            string = sDPromptTextAccess.getSDPromptText(3095);
            templateContainer.put(evoTemplateProperties, string);
            evoTemplateProperties = new EvoTemplateProperties(EvoTemplateProperties$MessageType.SMS, EvoTemplateProperties$MessageStatus.RECEIVED, EvoTemplateProperties$Bool.TRUE, EvoTemplateProperties$Bool.FALSE, EvoTemplateProperties$Bool.IRRELEVANT);
            string = sDPromptTextAccess.getSDPromptText(3096);
            templateContainer.put(evoTemplateProperties, string);
            evoTemplateProperties = new EvoTemplateProperties(EvoTemplateProperties$MessageType.SMS, EvoTemplateProperties$MessageStatus.SENT, EvoTemplateProperties$Bool.TRUE, EvoTemplateProperties$Bool.TRUE, EvoTemplateProperties$Bool.IRRELEVANT);
            string = sDPromptTextAccess.getSDPromptText(3099);
            templateContainer.put(evoTemplateProperties, string);
            evoTemplateProperties = new EvoTemplateProperties(EvoTemplateProperties$MessageType.SMS, EvoTemplateProperties$MessageStatus.SENT, EvoTemplateProperties$Bool.TRUE, EvoTemplateProperties$Bool.FALSE, EvoTemplateProperties$Bool.IRRELEVANT);
            string = sDPromptTextAccess.getSDPromptText(3100);
            templateContainer.put(evoTemplateProperties, string);
            evoTemplateProperties = new EvoTemplateProperties(EvoTemplateProperties$MessageType.SMS, EvoTemplateProperties$MessageStatus.DRAFT, EvoTemplateProperties$Bool.FALSE, EvoTemplateProperties$Bool.TRUE, EvoTemplateProperties$Bool.IRRELEVANT);
            string = sDPromptTextAccess.getSDPromptText(3103);
            templateContainer.put(evoTemplateProperties, string);
            evoTemplateProperties = new EvoTemplateProperties(EvoTemplateProperties$MessageType.SMS, EvoTemplateProperties$MessageStatus.DRAFT, EvoTemplateProperties$Bool.FALSE, EvoTemplateProperties$Bool.FALSE, EvoTemplateProperties$Bool.IRRELEVANT);
            string = sDPromptTextAccess.getSDPromptText(3104);
            templateContainer.put(evoTemplateProperties, string);
            evoTemplateProperties = new EvoTemplateProperties(EvoTemplateProperties$MessageType.SMS, EvoTemplateProperties$MessageStatus.OUTBOX, EvoTemplateProperties$Bool.TRUE, EvoTemplateProperties$Bool.TRUE, EvoTemplateProperties$Bool.IRRELEVANT);
            string = sDPromptTextAccess.getSDPromptText(3107);
            templateContainer.put(evoTemplateProperties, string);
            evoTemplateProperties = new EvoTemplateProperties(EvoTemplateProperties$MessageType.SMS, EvoTemplateProperties$MessageStatus.OUTBOX, EvoTemplateProperties$Bool.TRUE, EvoTemplateProperties$Bool.FALSE, EvoTemplateProperties$Bool.IRRELEVANT);
            string = sDPromptTextAccess.getSDPromptText(3108);
            templateContainer.put(evoTemplateProperties, string);
            evoTemplateProperties = new EvoTemplateProperties(EvoTemplateProperties$MessageType.EMAIL, EvoTemplateProperties$MessageStatus.RECEIVED, EvoTemplateProperties$Bool.TRUE, EvoTemplateProperties$Bool.TRUE, EvoTemplateProperties$Bool.TRUE);
            string = sDPromptTextAccess.getSDPromptText(3062);
            templateContainer.put(evoTemplateProperties, string);
            evoTemplateProperties = new EvoTemplateProperties(EvoTemplateProperties$MessageType.EMAIL, EvoTemplateProperties$MessageStatus.RECEIVED, EvoTemplateProperties$Bool.TRUE, EvoTemplateProperties$Bool.TRUE, EvoTemplateProperties$Bool.FALSE);
            string = sDPromptTextAccess.getSDPromptText(3065);
            templateContainer.put(evoTemplateProperties, string);
            evoTemplateProperties = new EvoTemplateProperties(EvoTemplateProperties$MessageType.EMAIL, EvoTemplateProperties$MessageStatus.RECEIVED, EvoTemplateProperties$Bool.TRUE, EvoTemplateProperties$Bool.FALSE, EvoTemplateProperties$Bool.TRUE);
            string = sDPromptTextAccess.getSDPromptText(3066);
            templateContainer.put(evoTemplateProperties, string);
            evoTemplateProperties = new EvoTemplateProperties(EvoTemplateProperties$MessageType.EMAIL, EvoTemplateProperties$MessageStatus.RECEIVED, EvoTemplateProperties$Bool.TRUE, EvoTemplateProperties$Bool.FALSE, EvoTemplateProperties$Bool.FALSE);
            string = sDPromptTextAccess.getSDPromptText(3069);
            templateContainer.put(evoTemplateProperties, string);
            evoTemplateProperties = new EvoTemplateProperties(EvoTemplateProperties$MessageType.EMAIL, EvoTemplateProperties$MessageStatus.SENT, EvoTemplateProperties$Bool.TRUE, EvoTemplateProperties$Bool.TRUE, EvoTemplateProperties$Bool.TRUE);
            string = sDPromptTextAccess.getSDPromptText(3070);
            templateContainer.put(evoTemplateProperties, string);
            evoTemplateProperties = new EvoTemplateProperties(EvoTemplateProperties$MessageType.EMAIL, EvoTemplateProperties$MessageStatus.SENT, EvoTemplateProperties$Bool.TRUE, EvoTemplateProperties$Bool.TRUE, EvoTemplateProperties$Bool.FALSE);
            string = sDPromptTextAccess.getSDPromptText(3073);
            templateContainer.put(evoTemplateProperties, string);
            evoTemplateProperties = new EvoTemplateProperties(EvoTemplateProperties$MessageType.EMAIL, EvoTemplateProperties$MessageStatus.SENT, EvoTemplateProperties$Bool.TRUE, EvoTemplateProperties$Bool.FALSE, EvoTemplateProperties$Bool.TRUE);
            string = sDPromptTextAccess.getSDPromptText(3074);
            templateContainer.put(evoTemplateProperties, string);
            evoTemplateProperties = new EvoTemplateProperties(EvoTemplateProperties$MessageType.EMAIL, EvoTemplateProperties$MessageStatus.SENT, EvoTemplateProperties$Bool.TRUE, EvoTemplateProperties$Bool.FALSE, EvoTemplateProperties$Bool.FALSE);
            string = sDPromptTextAccess.getSDPromptText(3077);
            templateContainer.put(evoTemplateProperties, string);
            evoTemplateProperties = new EvoTemplateProperties(EvoTemplateProperties$MessageType.EMAIL, EvoTemplateProperties$MessageStatus.DRAFT, EvoTemplateProperties$Bool.FALSE, EvoTemplateProperties$Bool.TRUE, EvoTemplateProperties$Bool.TRUE);
            string = sDPromptTextAccess.getSDPromptText(3079);
            templateContainer.put(evoTemplateProperties, string);
            evoTemplateProperties = new EvoTemplateProperties(EvoTemplateProperties$MessageType.EMAIL, EvoTemplateProperties$MessageStatus.DRAFT, EvoTemplateProperties$Bool.FALSE, EvoTemplateProperties$Bool.TRUE, EvoTemplateProperties$Bool.FALSE);
            string = sDPromptTextAccess.getSDPromptText(3080);
            templateContainer.put(evoTemplateProperties, string);
            evoTemplateProperties = new EvoTemplateProperties(EvoTemplateProperties$MessageType.EMAIL, EvoTemplateProperties$MessageStatus.DRAFT, EvoTemplateProperties$Bool.FALSE, EvoTemplateProperties$Bool.FALSE, EvoTemplateProperties$Bool.TRUE);
            string = sDPromptTextAccess.getSDPromptText(3082);
            templateContainer.put(evoTemplateProperties, string);
            evoTemplateProperties = new EvoTemplateProperties(EvoTemplateProperties$MessageType.EMAIL, EvoTemplateProperties$MessageStatus.DRAFT, EvoTemplateProperties$Bool.FALSE, EvoTemplateProperties$Bool.FALSE, EvoTemplateProperties$Bool.FALSE);
            string = sDPromptTextAccess.getSDPromptText(3085);
            templateContainer.put(evoTemplateProperties, string);
            evoTemplateProperties = new EvoTemplateProperties(EvoTemplateProperties$MessageType.EMAIL, EvoTemplateProperties$MessageStatus.OUTBOX, EvoTemplateProperties$Bool.TRUE, EvoTemplateProperties$Bool.TRUE, EvoTemplateProperties$Bool.TRUE);
            string = sDPromptTextAccess.getSDPromptText(3087);
            templateContainer.put(evoTemplateProperties, string);
            evoTemplateProperties = new EvoTemplateProperties(EvoTemplateProperties$MessageType.EMAIL, EvoTemplateProperties$MessageStatus.OUTBOX, EvoTemplateProperties$Bool.TRUE, EvoTemplateProperties$Bool.TRUE, EvoTemplateProperties$Bool.FALSE);
            string = sDPromptTextAccess.getSDPromptText(3088);
            templateContainer.put(evoTemplateProperties, string);
            evoTemplateProperties = new EvoTemplateProperties(EvoTemplateProperties$MessageType.EMAIL, EvoTemplateProperties$MessageStatus.OUTBOX, EvoTemplateProperties$Bool.TRUE, EvoTemplateProperties$Bool.FALSE, EvoTemplateProperties$Bool.TRUE);
            string = sDPromptTextAccess.getSDPromptText(3093);
            templateContainer.put(evoTemplateProperties, string);
            evoTemplateProperties = new EvoTemplateProperties(EvoTemplateProperties$MessageType.EMAIL, EvoTemplateProperties$MessageStatus.OUTBOX, EvoTemplateProperties$Bool.TRUE, EvoTemplateProperties$Bool.FALSE, EvoTemplateProperties$Bool.FALSE);
            string = sDPromptTextAccess.getSDPromptText(3093);
            templateContainer.put(evoTemplateProperties, string);
        }
        this.regularTemplateContainer = templateContainer;
    }

    private void setConciseTemplateContainer(SDPromptTextAccess sDPromptTextAccess) {
        TemplateContainer templateContainer = new TemplateContainer();
        if (sDPromptTextAccess != null) {
            EvoTemplateProperties evoTemplateProperties = null;
            String string = null;
            evoTemplateProperties = new EvoTemplateProperties(EvoTemplateProperties$MessageType.SMS, EvoTemplateProperties$MessageStatus.RECEIVED, EvoTemplateProperties$Bool.IRRELEVANT, EvoTemplateProperties$Bool.IRRELEVANT, EvoTemplateProperties$Bool.IRRELEVANT);
            string = sDPromptTextAccess.getSDPromptText(3096);
            templateContainer.put(evoTemplateProperties, string);
            evoTemplateProperties = new EvoTemplateProperties(EvoTemplateProperties$MessageType.SMS, EvoTemplateProperties$MessageStatus.SENT, EvoTemplateProperties$Bool.IRRELEVANT, EvoTemplateProperties$Bool.IRRELEVANT, EvoTemplateProperties$Bool.IRRELEVANT);
            string = sDPromptTextAccess.getSDPromptText(3100);
            templateContainer.put(evoTemplateProperties, string);
            evoTemplateProperties = new EvoTemplateProperties(EvoTemplateProperties$MessageType.SMS, EvoTemplateProperties$MessageStatus.DRAFT, EvoTemplateProperties$Bool.IRRELEVANT, EvoTemplateProperties$Bool.IRRELEVANT, EvoTemplateProperties$Bool.IRRELEVANT);
            string = sDPromptTextAccess.getSDPromptText(3104);
            templateContainer.put(evoTemplateProperties, string);
            evoTemplateProperties = new EvoTemplateProperties(EvoTemplateProperties$MessageType.SMS, EvoTemplateProperties$MessageStatus.OUTBOX, EvoTemplateProperties$Bool.IRRELEVANT, EvoTemplateProperties$Bool.IRRELEVANT, EvoTemplateProperties$Bool.IRRELEVANT);
            string = sDPromptTextAccess.getSDPromptText(3108);
            templateContainer.put(evoTemplateProperties, string);
            evoTemplateProperties = new EvoTemplateProperties(EvoTemplateProperties$MessageType.EMAIL, EvoTemplateProperties$MessageStatus.RECEIVED, EvoTemplateProperties$Bool.IRRELEVANT, EvoTemplateProperties$Bool.IRRELEVANT, EvoTemplateProperties$Bool.TRUE);
            string = sDPromptTextAccess.getSDPromptText(3066);
            templateContainer.put(evoTemplateProperties, string);
            evoTemplateProperties = new EvoTemplateProperties(EvoTemplateProperties$MessageType.EMAIL, EvoTemplateProperties$MessageStatus.RECEIVED, EvoTemplateProperties$Bool.IRRELEVANT, EvoTemplateProperties$Bool.IRRELEVANT, EvoTemplateProperties$Bool.FALSE);
            string = sDPromptTextAccess.getSDPromptText(3069);
            templateContainer.put(evoTemplateProperties, string);
            evoTemplateProperties = new EvoTemplateProperties(EvoTemplateProperties$MessageType.EMAIL, EvoTemplateProperties$MessageStatus.SENT, EvoTemplateProperties$Bool.IRRELEVANT, EvoTemplateProperties$Bool.IRRELEVANT, EvoTemplateProperties$Bool.TRUE);
            string = sDPromptTextAccess.getSDPromptText(3074);
            templateContainer.put(evoTemplateProperties, string);
            evoTemplateProperties = new EvoTemplateProperties(EvoTemplateProperties$MessageType.EMAIL, EvoTemplateProperties$MessageStatus.SENT, EvoTemplateProperties$Bool.IRRELEVANT, EvoTemplateProperties$Bool.IRRELEVANT, EvoTemplateProperties$Bool.FALSE);
            string = sDPromptTextAccess.getSDPromptText(3077);
            templateContainer.put(evoTemplateProperties, string);
            evoTemplateProperties = new EvoTemplateProperties(EvoTemplateProperties$MessageType.EMAIL, EvoTemplateProperties$MessageStatus.DRAFT, EvoTemplateProperties$Bool.IRRELEVANT, EvoTemplateProperties$Bool.IRRELEVANT, EvoTemplateProperties$Bool.TRUE);
            string = sDPromptTextAccess.getSDPromptText(3082);
            templateContainer.put(evoTemplateProperties, string);
            evoTemplateProperties = new EvoTemplateProperties(EvoTemplateProperties$MessageType.EMAIL, EvoTemplateProperties$MessageStatus.DRAFT, EvoTemplateProperties$Bool.IRRELEVANT, EvoTemplateProperties$Bool.IRRELEVANT, EvoTemplateProperties$Bool.FALSE);
            string = sDPromptTextAccess.getSDPromptText(3085);
            templateContainer.put(evoTemplateProperties, string);
            evoTemplateProperties = new EvoTemplateProperties(EvoTemplateProperties$MessageType.EMAIL, EvoTemplateProperties$MessageStatus.OUTBOX, EvoTemplateProperties$Bool.IRRELEVANT, EvoTemplateProperties$Bool.IRRELEVANT, EvoTemplateProperties$Bool.TRUE);
            string = sDPromptTextAccess.getSDPromptText(3093);
            templateContainer.put(evoTemplateProperties, string);
            evoTemplateProperties = new EvoTemplateProperties(EvoTemplateProperties$MessageType.EMAIL, EvoTemplateProperties$MessageStatus.OUTBOX, EvoTemplateProperties$Bool.IRRELEVANT, EvoTemplateProperties$Bool.IRRELEVANT, EvoTemplateProperties$Bool.FALSE);
            string = sDPromptTextAccess.getSDPromptText(3093);
            templateContainer.put(evoTemplateProperties, string);
        }
        this.conciseTemplateContainer = templateContainer;
    }

    private void setFallbackTemplateContainer(SDPromptTextAccess sDPromptTextAccess) {
        TemplateContainer templateContainer = new TemplateContainer();
        if (sDPromptTextAccess != null) {
            EvoTemplateProperties evoTemplateProperties = null;
            String string = null;
            evoTemplateProperties = new EvoTemplateProperties(EvoTemplateProperties$MessageType.SMS, EvoTemplateProperties$MessageStatus.IRRELEVANT, EvoTemplateProperties$Bool.IRRELEVANT, EvoTemplateProperties$Bool.IRRELEVANT, EvoTemplateProperties$Bool.IRRELEVANT);
            string = sDPromptTextAccess.getSDPromptText(3095);
            templateContainer.put(evoTemplateProperties, string);
            evoTemplateProperties = new EvoTemplateProperties(EvoTemplateProperties$MessageType.EMAIL, EvoTemplateProperties$MessageStatus.IRRELEVANT, EvoTemplateProperties$Bool.IRRELEVANT, EvoTemplateProperties$Bool.IRRELEVANT, EvoTemplateProperties$Bool.IRRELEVANT);
            string = sDPromptTextAccess.getSDPromptText(3062);
            templateContainer.put(evoTemplateProperties, string);
        }
        this.fallbackTemplateContainer = templateContainer;
    }

    public String toString() {
        Buffer buffer = new Buffer(4096);
        buffer.append("EvoReadableProvider {templateContainer = ");
        buffer.append(this.regularTemplateContainer);
        buffer.append(", conciseTemplateContainer = ");
        buffer.append(this.conciseTemplateContainer);
        buffer.append(", fallbackTemplateContainer = ");
        buffer.append(this.fallbackTemplateContainer);
        buffer.append('}');
        return buffer.toString();
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    static /* synthetic */ void access$000(EvoReadableProvider evoReadableProvider, SDPromptTextAccess sDPromptTextAccess) {
        evoReadableProvider.setSdPromptAccess(sDPromptTextAccess);
    }
}

