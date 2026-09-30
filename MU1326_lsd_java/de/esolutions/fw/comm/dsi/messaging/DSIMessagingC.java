/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.messaging;

import de.esolutions.fw.comm.core.method.MethodException;
import org.dsi.ifc.messaging.AttachmentInformation;
import org.dsi.ifc.messaging.RecipientList;

public interface DSIMessagingC {
    public void changeFolderRequest(int var1, int var2, int var3, int var4, int var5) throws MethodException;

    public void listEntriesRequest(int var1, int var2, int var3) throws MethodException;

    public void getPositionOfMessageRequest(String var1) throws MethodException;

    public void getPositionOfFolderRequest(int var1) throws MethodException;

    public void deleteMessageRequest(String[] var1, boolean var2) throws MethodException;

    public void sendMessageRequest(int var1, int var2, RecipientList var3, String var4, String var5, AttachmentInformation[] var6, int var7) throws MethodException;

    public void getMessageContentsRequest(int var1, String var2, int var3) throws MethodException;

    public void setMessageReadStatusRequest(String var1, boolean var2) throws MethodException;

    public void saveAsDraftRequest(String var1, int var2, RecipientList var3, String var4, String var5, int var6, AttachmentInformation[] var7) throws MethodException;

    public void extractInformationRequest(String var1) throws MethodException;

    public void changeTemplateRequest(int var1, String var2) throws MethodException;

    public void getTemplateRequest(int var1) throws MethodException;

    public void getTemplatesRequest() throws MethodException;

    public void deleteTemplateRequest(int[] var1) throws MethodException;

    public void deleteSimCardMessagesRequest(int var1, int var2) throws MethodException;

    public void decodeAttachmentRequest(AttachmentInformation var1) throws MethodException;

    public void setNotification(int[] var1) throws MethodException;

    public void setNotification(int var1) throws MethodException;

    public void setNotification() throws MethodException;

    public void clearNotification(int[] var1) throws MethodException;

    public void clearNotification(int var1) throws MethodException;

    public void clearNotification() throws MethodException;

    public void yySet(String var1, String var2) throws MethodException;
}

