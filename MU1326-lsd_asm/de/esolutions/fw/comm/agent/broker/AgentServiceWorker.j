.version 50 0 
.class public super [75] 
.super [77] 
.field private final [78] [79] 

.method public [81] : [82] 
    .attribute [80] .code stack 8 locals 0 
L0:     aload_0 
L1:     ldc [2] 
L3:     iload_2 
L4:     iload_3 
L5:     iload 4 
L7:     iload 5 
L9:     aload 6 
L11:    aload 7 
L13:    invokespecial [13] 
L16:    aload_0 
L17:    aload_1 
L18:    putfield [15] 
L21:    return 
L22:    nop 
L23:    nop 
L24:    
    .end code 
.end method 

.method public [83] : [84] 
    .attribute [80] .code stack 6 locals 0 
L0:     getstatic [3] 
L3:     iconst_0 
L4:     ldc [4] 
L6:     new [16] 
L9:     dup 
L10:    iload_2 
L11:    invokespecial [14] 
L14:    invokevirtual [12] 
L17:    pop 
L18:    iload_2 
L19:    ifne L34 
L22:    aload_0 
L23:    getfield [11] 
L26:    invokeinterface [17] 0 
L31:    goto L48 
L34:    iload_2 
L35:    iconst_1 
L36:    if_icmpne L48 
L39:    aload_0 
L40:    getfield [11] 
L43:    invokeinterface [18] 0 
L48:    return 
L49:    nop 
L50:    nop 
L51:    nop 
L52:    
    .end code 
.end method 

.method protected [85] : [86] 
    .attribute [80] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [11] 
L4:     invokeinterface [19] 0 
L9:     return 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = String [20] 
.const [3] = Field [21] [22] 
.const [4] = String [23] 
.const [5] = Class [24] 
.const [6] = Class [25] 
.const [7] = Class [26] 
.const [8] = Class [27] 
.const [9] = Class [28] 
.const [10] = Class [29] 
.const [11] = Field [30] [31] 
.const [12] = Method [32] [33] 
.const [13] = Method [34] [35] 
.const [14] = Method [36] [37] 
.const [15] = Field [38] [39] 
.const [16] = Class [40] 
.const [17] = InterfaceMethod [41] [42] 
.const [18] = InterfaceMethod [43] [44] 
.const [19] = InterfaceMethod [45] [46] 
.const [20] = Utf8 commSrvAgent 
.const [21] = Class [47] 
.const [22] = NameAndType [48] [49] 
.const [23] = Utf8 'AgentServiceWorker: stubCountChanged=%1' 
.const [24] = Utf8 java/lang/Integer 
.const [25] = Utf8 de/esolutions/fw/comm/agent/broker/AgentServiceWorker 
.const [26] = Utf8 de/esolutions/fw/comm/agent/service/ServiceQueueWorker 
.const [27] = Utf8 de/esolutions/fw/comm/agent/tracing/CommAgentTracing 
.const [28] = Utf8 de/esolutions/fw/util/tracing/TraceChannel 
.const [29] = Utf8 de/esolutions/fw/comm/agent/broker/IAgentServiceWorkerListener 
.const [30] = Class [50] 
.const [31] = NameAndType [51] [52] 
.const [32] = Class [53] 
.const [33] = NameAndType [54] [55] 
.const [34] = Class [56] 
.const [35] = NameAndType [57] [58] 
.const [36] = Class [59] 
.const [37] = NameAndType [60] [61] 
.const [38] = Class [62] 
.const [39] = NameAndType [63] [64] 
.const [40] = Utf8 java/lang/Integer 
.const [41] = Class [65] 
.const [42] = NameAndType [66] [67] 
.const [43] = Class [68] 
.const [44] = NameAndType [69] [70] 
.const [45] = Class [71] 
.const [46] = NameAndType [72] [73] 
.const [47] = Utf8 de/esolutions/fw/comm/agent/tracing/CommAgentTracing 
.const [48] = Utf8 BROKER 
.const [49] = Utf8 Lde/esolutions/fw/util/tracing/TraceChannel; 
.const [50] = Utf8 de/esolutions/fw/comm/agent/broker/AgentServiceWorker 
.const [51] = Utf8 listener 
.const [52] = Utf8 Lde/esolutions/fw/comm/agent/broker/IAgentServiceWorkerListener; 
.const [53] = Utf8 de/esolutions/fw/util/tracing/TraceChannel 
.const [54] = Utf8 log 
.const [55] = Utf8 (SLjava/lang/String;Ljava/lang/Object;)Z 
.const [56] = Utf8 de/esolutions/fw/comm/agent/service/ServiceQueueWorker 
.const [57] = Utf8 <init> 
.const [58] = Utf8 (Ljava/lang/String;IIZILde/esolutions/fw/util/commons/timeout/ITimeSource;Lde/esolutions/fw/util/commons/error/IRunnableWrapper;)V 
.const [59] = Utf8 java/lang/Integer 
.const [60] = Utf8 <init> 
.const [61] = Utf8 (I)V 
.const [62] = Utf8 de/esolutions/fw/comm/agent/broker/AgentServiceWorker 
.const [63] = Utf8 listener 
.const [64] = Utf8 Lde/esolutions/fw/comm/agent/broker/IAgentServiceWorkerListener; 
.const [65] = Utf8 de/esolutions/fw/comm/agent/broker/IAgentServiceWorkerListener 
.const [66] = Utf8 brokerDisconnectedFromAgentService 
.const [67] = Utf8 ()V 
.const [68] = Utf8 de/esolutions/fw/comm/agent/broker/IAgentServiceWorkerListener 
.const [69] = Utf8 brokerConnectedToAgentService 
.const [70] = Utf8 ()V 
.const [71] = Utf8 de/esolutions/fw/comm/agent/broker/IAgentServiceWorkerListener 
.const [72] = Utf8 brokerCallFailed 
.const [73] = Utf8 ()V 
.const [74] = Utf8 de/esolutions/fw/comm/agent/broker/AgentServiceWorker 
.const [75] = Class [74] 
.const [76] = Utf8 de/esolutions/fw/comm/agent/service/ServiceQueueWorker 
.const [77] = Class [76] 
.const [78] = Utf8 listener 
.const [79] = Utf8 Lde/esolutions/fw/comm/agent/broker/IAgentServiceWorkerListener; 
.const [80] = Utf8 Code 
.const [81] = Utf8 <init> 
.const [82] = Utf8 (Lde/esolutions/fw/comm/agent/broker/IAgentServiceWorkerListener;IIZILde/esolutions/fw/util/commons/timeout/ITimeSource;Lde/esolutions/fw/util/commons/error/IRunnableWrapper;)V 
.const [83] = Utf8 stubCountChanged 
.const [84] = Utf8 (Lde/esolutions/fw/comm/core/IService;I)V 
.const [85] = Utf8 methodExceptionHandler 
.const [86] = Utf8 (Lde/esolutions/fw/comm/core/method/MethodException;)V 
.end class 
