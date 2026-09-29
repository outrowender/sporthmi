.version 50 0 
.class super [69] 
.super [71] 
.implements [73] 
.field private final synthetic [74] [75] 

.method private [77] : [78] 
    .attribute [76] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     putfield [17] 
L5:     aload_0 
L6:     invokespecial [15] 
L9:     return 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [79] : [80] 
    .attribute [76] .code stack 4 locals 2 
L0:     sipush 256 
L3:     istore_3 
L4:     aload_2 
L5:     ifnull L31 
        .catch [5] from L8 to L26 using L29 
L8:     new [18] 
L11:    dup 
L12:    aload_2 
L13:    ldc [3] 
L15:    invokespecial [16] 
L18:    astore 4 
L20:    aload 4 
L22:    invokestatic [4] 
L25:    istore_3 
L26:    goto L31 
L29:    astore 4 
L31:    aload_0 
L32:    getfield [12] 
L35:    invokestatic [6] 
L38:    iload_3 
L39:    invokevirtual [13] 
L42:    return 
L43:    nop 
L44:    
    .end code 
.end method 

.method synthetic [81] : [82] 
    .attribute [76] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     invokespecial [14] 
L5:     return 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [19] 
.const [3] = String [20] 
.const [4] = Method [21] [22] 
.const [5] = Class [23] 
.const [6] = Method [24] [25] 
.const [7] = Class [26] 
.const [8] = Class [27] 
.const [9] = Class [28] 
.const [10] = Class [29] 
.const [11] = Class [30] 
.const [12] = Field [31] [32] 
.const [13] = Method [33] [34] 
.const [14] = Method [35] [36] 
.const [15] = Method [37] [38] 
.const [16] = Method [39] [40] 
.const [17] = Field [41] [42] 
.const [18] = Class [43] 
.const [19] = Utf8 java/lang/String 
.const [20] = Utf8 UTF-8 
.const [21] = Class [44] 
.const [22] = NameAndType [45] [46] 
.const [23] = Utf8 java/lang/Exception 
.const [24] = Class [47] 
.const [25] = NameAndType [48] [49] 
.const [26] = Utf8 de/esolutions/fw/comm/agent/osgi/AgentCallbacks$FloaterWasteCommand 
.const [27] = Utf8 java/lang/Object 
.const [28] = Utf8 java/lang/Integer 
.const [29] = Utf8 de/esolutions/fw/comm/agent/osgi/AgentCallbacks 
.const [30] = Utf8 de/esolutions/fw/util/commons/error/Floater 
.const [31] = Class [50] 
.const [32] = NameAndType [51] [52] 
.const [33] = Class [53] 
.const [34] = NameAndType [54] [55] 
.const [35] = Class [56] 
.const [36] = NameAndType [57] [58] 
.const [37] = Class [59] 
.const [38] = NameAndType [60] [61] 
.const [39] = Class [62] 
.const [40] = NameAndType [63] [64] 
.const [41] = Class [65] 
.const [42] = NameAndType [66] [67] 
.const [43] = Utf8 java/lang/String 
.const [44] = Utf8 java/lang/Integer 
.const [45] = Utf8 parseInt 
.const [46] = Utf8 (Ljava/lang/String;)I 
.const [47] = Utf8 de/esolutions/fw/comm/agent/osgi/AgentCallbacks 
.const [48] = Utf8 access$200 
.const [49] = Utf8 (Lde/esolutions/fw/comm/agent/osgi/AgentCallbacks;)Lde/esolutions/fw/util/commons/error/Floater; 
.const [50] = Utf8 de/esolutions/fw/comm/agent/osgi/AgentCallbacks$FloaterWasteCommand 
.const [51] = Utf8 this$0 
.const [52] = Utf8 Lde/esolutions/fw/comm/agent/osgi/AgentCallbacks; 
.const [53] = Utf8 de/esolutions/fw/util/commons/error/Floater 
.const [54] = Utf8 waste 
.const [55] = Utf8 (I)V 
.const [56] = Utf8 de/esolutions/fw/comm/agent/osgi/AgentCallbacks$FloaterWasteCommand 
.const [57] = Utf8 <init> 
.const [58] = Utf8 (Lde/esolutions/fw/comm/agent/osgi/AgentCallbacks;)V 
.const [59] = Utf8 java/lang/Object 
.const [60] = Utf8 <init> 
.const [61] = Utf8 ()V 
.const [62] = Utf8 java/lang/String 
.const [63] = Utf8 <init> 
.const [64] = Utf8 ([BLjava/lang/String;)V 
.const [65] = Utf8 de/esolutions/fw/comm/agent/osgi/AgentCallbacks$FloaterWasteCommand 
.const [66] = Utf8 this$0 
.const [67] = Utf8 Lde/esolutions/fw/comm/agent/osgi/AgentCallbacks; 
.const [68] = Utf8 de/esolutions/fw/comm/agent/osgi/AgentCallbacks$FloaterWasteCommand 
.const [69] = Class [68] 
.const [70] = Utf8 java/lang/Object 
.const [71] = Class [70] 
.const [72] = Utf8 de/esolutions/fw/util/tracing/ITraceCallback 
.const [73] = Class [72] 
.const [74] = Utf8 this$0 
.const [75] = Utf8 Lde/esolutions/fw/comm/agent/osgi/AgentCallbacks; 
.const [76] = Utf8 Code 
.const [77] = Utf8 <init> 
.const [78] = Utf8 (Lde/esolutions/fw/comm/agent/osgi/AgentCallbacks;)V 
.const [79] = Utf8 executeTraceCallback 
.const [80] = Utf8 (I[B)V 
.const [81] = Utf8 <init> 
.const [82] = Utf8 (Lde/esolutions/fw/comm/agent/osgi/AgentCallbacks;Lde/esolutions/fw/comm/agent/osgi/AgentCallbacks$1;)V 
.end class 
