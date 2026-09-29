.version 50 0 
.class super [47] 
.super [49] 
.field private [50] [51] 

.method public [53] : [54] 
    .attribute [52] .code stack 3 locals 0 
L0:     aload_0 
L1:     ldc [2] 
L3:     iload_2 
L4:     invokespecial [12] 
L7:     aload_0 
L8:     aload_1 
L9:     putfield [13] 
L12:    return 
L13:    nop 
L14:    nop 
L15:    nop 
L16:    
    .end code 
.end method 

.method protected [55] : [56] 
    .attribute [52] .code stack 4 locals 1 
L0:     aload_1 
L1:     checkcast [3] 
L4:     astore_2 
L5:     aload_0 
L6:     getfield [9] 
L9:     iconst_2 
L10:    ldc [4] 
L12:    aload_2 
L13:    invokevirtual [10] 
L16:    pop 
L17:    return 
L18:    nop 
L19:    nop 
L20:    
    .end code 
.end method 

.method public [57] : [58] 
    .attribute [52] .code stack 2 locals 1 
        .catch [5] from L0 to L6 using L9 
L0:     aload_0 
L1:     aload_1 
L2:     invokevirtual [11] 
L5:     pop 
L6:     goto L10 
L9:     astore_2 
L10:    return 
L11:    nop 
L12:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = String [14] 
.const [3] = Class [15] 
.const [4] = String [16] 
.const [5] = Class [17] 
.const [6] = Class [18] 
.const [7] = Class [19] 
.const [8] = Class [20] 
.const [9] = Field [21] [22] 
.const [10] = Method [23] [24] 
.const [11] = Method [25] [26] 
.const [12] = Method [27] [28] 
.const [13] = Field [29] [30] 
.const [14] = Utf8 fwTpDebug 
.const [15] = Utf8 de/esolutions/fw/util/tracing/transport/TransportDebugAdapter$Entry 
.const [16] = Utf8 '%1' 
.const [17] = Utf8 de/esolutions/fw/util/commons/queue/QueueShutdownException 
.const [18] = Utf8 de/esolutions/fw/util/tracing/transport/TransportDebugAdapter$MyQueueWorker 
.const [19] = Utf8 de/esolutions/fw/util/commons/queue/QueueWorker 
.const [20] = Utf8 de/esolutions/fw/util/tracing/TraceChannel 
.const [21] = Class [31] 
.const [22] = NameAndType [32] [33] 
.const [23] = Class [34] 
.const [24] = NameAndType [35] [36] 
.const [25] = Class [37] 
.const [26] = NameAndType [38] [39] 
.const [27] = Class [40] 
.const [28] = NameAndType [41] [42] 
.const [29] = Class [43] 
.const [30] = NameAndType [44] [45] 
.const [31] = Utf8 de/esolutions/fw/util/tracing/transport/TransportDebugAdapter$MyQueueWorker 
.const [32] = Utf8 channel 
.const [33] = Utf8 Lde/esolutions/fw/util/tracing/TraceChannel; 
.const [34] = Utf8 de/esolutions/fw/util/tracing/TraceChannel 
.const [35] = Utf8 log 
.const [36] = Utf8 (SLjava/lang/String;Ljava/lang/Object;)Z 
.const [37] = Utf8 de/esolutions/fw/util/tracing/transport/TransportDebugAdapter$MyQueueWorker 
.const [38] = Utf8 addToQueue 
.const [39] = Utf8 (Ljava/lang/Object;)Z 
.const [40] = Utf8 de/esolutions/fw/util/commons/queue/QueueWorker 
.const [41] = Utf8 <init> 
.const [42] = Utf8 (Ljava/lang/String;I)V 
.const [43] = Utf8 de/esolutions/fw/util/tracing/transport/TransportDebugAdapter$MyQueueWorker 
.const [44] = Utf8 channel 
.const [45] = Utf8 Lde/esolutions/fw/util/tracing/TraceChannel; 
.const [46] = Utf8 de/esolutions/fw/util/tracing/transport/TransportDebugAdapter$MyQueueWorker 
.const [47] = Class [46] 
.const [48] = Utf8 de/esolutions/fw/util/commons/queue/QueueWorker 
.const [49] = Class [48] 
.const [50] = Utf8 channel 
.const [51] = Utf8 Lde/esolutions/fw/util/tracing/TraceChannel; 
.const [52] = Utf8 Code 
.const [53] = Utf8 <init> 
.const [54] = Utf8 (Lde/esolutions/fw/util/tracing/TraceChannel;I)V 
.const [55] = Utf8 handleQueuedObject 
.const [56] = Utf8 (Ljava/lang/Object;)V 
.const [57] = Utf8 add 
.const [58] = Utf8 (Lde/esolutions/fw/util/tracing/transport/TransportDebugAdapter$Entry;)V 
.end class 
