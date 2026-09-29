.version 50 0 
.class public super [59] 
.super [61] 
.implements [63] 
.field private [64] [65] 

.method public annotation [67] : [68] 
    .attribute [66] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [13] 
L4:     return 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [69] : [70] 
    .attribute [66] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     putfield [14] 
L5:     return 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [71] : [72] 
    .attribute [66] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokevirtual [11] 
L4:     return 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public interface [73] : [74] 
    .attribute [66] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [10] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [75] : [76] 
    .attribute [66] .code stack 4 locals 0 
L0:     aload_0 
L1:     getfield [10] 
L4:     ifnull L45 
L7:     getstatic [2] 
L10:    iconst_1 
L11:    ldc [3] 
L13:    aload_0 
L14:    getfield [10] 
L17:    invokevirtual [12] 
L20:    pop 
L21:    aload_0 
L22:    getfield [10] 
L25:    aload_0 
L26:    invokeinterface [15] 0 
L31:    getstatic [2] 
L34:    iconst_1 
L35:    ldc [4] 
L37:    aload_0 
L38:    getfield [10] 
L41:    invokevirtual [12] 
L44:    pop 
L45:    return 
L46:    nop 
L47:    nop 
L48:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Field [16] [17] 
.const [3] = String [18] 
.const [4] = String [19] 
.const [5] = Class [20] 
.const [6] = Class [21] 
.const [7] = Class [22] 
.const [8] = Class [23] 
.const [9] = Class [24] 
.const [10] = Field [25] [26] 
.const [11] = Method [27] [28] 
.const [12] = Method [29] [30] 
.const [13] = Method [31] [32] 
.const [14] = Field [33] [34] 
.const [15] = InterfaceMethod [35] [36] 
.const [16] = Class [37] 
.const [17] = NameAndType [38] [39] 
.const [18] = Utf8 ' + Trigger Callback %1' 
.const [19] = Utf8 ' - Trigger Callback %1' 
.const [20] = Utf8 de/esolutions/fw/comm/agent/notification/AbstractNotification 
.const [21] = Utf8 java/lang/Object 
.const [22] = Utf8 de/esolutions/fw/comm/agent/tracing/CommAgentTracing 
.const [23] = Utf8 de/esolutions/fw/util/tracing/TraceChannel 
.const [24] = Utf8 de/esolutions/fw/comm/agent/notification/INotificationCallback 
.const [25] = Class [40] 
.const [26] = NameAndType [41] [42] 
.const [27] = Class [43] 
.const [28] = NameAndType [44] [45] 
.const [29] = Class [46] 
.const [30] = NameAndType [47] [48] 
.const [31] = Class [49] 
.const [32] = NameAndType [50] [51] 
.const [33] = Class [52] 
.const [34] = NameAndType [53] [54] 
.const [35] = Class [55] 
.const [36] = NameAndType [56] [57] 
.const [37] = Utf8 de/esolutions/fw/comm/agent/tracing/CommAgentTracing 
.const [38] = Utf8 NOTIFICATION 
.const [39] = Utf8 Lde/esolutions/fw/util/tracing/TraceChannel; 
.const [40] = Utf8 de/esolutions/fw/comm/agent/notification/AbstractNotification 
.const [41] = Utf8 callback 
.const [42] = Utf8 Lde/esolutions/fw/comm/agent/notification/INotificationCallback; 
.const [43] = Utf8 de/esolutions/fw/comm/agent/notification/AbstractNotification 
.const [44] = Utf8 triggerCallback 
.const [45] = Utf8 ()V 
.const [46] = Utf8 de/esolutions/fw/util/tracing/TraceChannel 
.const [47] = Utf8 log 
.const [48] = Utf8 (SLjava/lang/String;Ljava/lang/Object;)Z 
.const [49] = Utf8 java/lang/Object 
.const [50] = Utf8 <init> 
.const [51] = Utf8 ()V 
.const [52] = Utf8 de/esolutions/fw/comm/agent/notification/AbstractNotification 
.const [53] = Utf8 callback 
.const [54] = Utf8 Lde/esolutions/fw/comm/agent/notification/INotificationCallback; 
.const [55] = Utf8 de/esolutions/fw/comm/agent/notification/INotificationCallback 
.const [56] = Utf8 doneNotification 
.const [57] = Utf8 (Lde/esolutions/fw/comm/agent/notification/INotification;)V 
.const [58] = Utf8 de/esolutions/fw/comm/agent/notification/AbstractNotification 
.const [59] = Class [58] 
.const [60] = Utf8 java/lang/Object 
.const [61] = Class [60] 
.const [62] = Utf8 de/esolutions/fw/comm/agent/notification/INotification 
.const [63] = Class [62] 
.const [64] = Utf8 callback 
.const [65] = Utf8 Lde/esolutions/fw/comm/agent/notification/INotificationCallback; 
.const [66] = Utf8 Code 
.const [67] = Utf8 <init> 
.const [68] = Utf8 ()V 
.const [69] = Utf8 setCallback 
.const [70] = Utf8 (Lde/esolutions/fw/comm/agent/notification/INotificationCallback;)V 
.const [71] = Utf8 performNotification 
.const [72] = Utf8 ()V 
.const [73] = Utf8 getCallback 
.const [74] = Utf8 ()Lde/esolutions/fw/comm/agent/notification/INotificationCallback; 
.const [75] = Utf8 triggerCallback 
.const [76] = Utf8 ()V 
.end class 
