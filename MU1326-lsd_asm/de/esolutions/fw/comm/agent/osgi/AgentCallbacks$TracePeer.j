.version 50 0 
.class super [83] 
.super [85] 
.implements [87] 

.method private annotation [89] : [90] 
    .attribute [88] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [19] 
L4:     return 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [91] : [92] 
    .attribute [88] .code stack 6 locals 3 
        .catch [9] from L0 to L53 using L56 
L0:     new [22] 
L3:     dup 
L4:     aload_2 
L5:     ldc [3] 
L7:     invokespecial [20] 
L10:    astore_3 
L11:    aload_3 
L12:    invokestatic [4] 
L15:    istore 4 
L17:    invokestatic [5] 
L20:    astore 5 
L22:    aload 5 
L24:    ifnull L53 
L27:    invokestatic [6] 
L30:    iconst_2 
L31:    ldc [7] 
L33:    new [23] 
L36:    dup 
L37:    iload 4 
L39:    invokespecial [21] 
L42:    invokevirtual [16] 
L45:    pop 
L46:    aload 5 
L48:    iload 4 
L50:    invokevirtual [17] 
L53:    goto L68 
L56:    astore_3 
L57:    invokestatic [6] 
L60:    iconst_4 
L61:    ldc [10] 
L63:    aload_3 
L64:    invokevirtual [16] 
L67:    pop 
L68:    return 
L69:    nop 
L70:    nop 
L71:    nop 
L72:    
    .end code 
.end method 

.method synthetic [93] : [94] 
    .attribute [88] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [18] 
L4:     return 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [24] 
.const [3] = String [25] 
.const [4] = Method [26] [27] 
.const [5] = Method [28] [29] 
.const [6] = Method [30] [31] 
.const [7] = String [32] 
.const [8] = Class [33] 
.const [9] = Class [34] 
.const [10] = String [35] 
.const [11] = Class [36] 
.const [12] = Class [37] 
.const [13] = Class [38] 
.const [14] = Class [39] 
.const [15] = Class [40] 
.const [16] = Method [41] [42] 
.const [17] = Method [43] [44] 
.const [18] = Method [45] [46] 
.const [19] = Method [47] [48] 
.const [20] = Method [49] [50] 
.const [21] = Method [51] [52] 
.const [22] = Class [53] 
.const [23] = Class [54] 
.const [24] = Utf8 java/lang/String 
.const [25] = Utf8 UTF-8 
.const [26] = Class [55] 
.const [27] = NameAndType [56] [57] 
.const [28] = Class [58] 
.const [29] = NameAndType [59] [60] 
.const [30] = Class [61] 
.const [31] = NameAndType [62] [63] 
.const [32] = Utf8 'Trace Peer: %1' 
.const [33] = Utf8 java/lang/Short 
.const [34] = Utf8 java/lang/Exception 
.const [35] = Utf8 'Invalid TracePeer call! Reason: %1 ' 
.const [36] = Utf8 de/esolutions/fw/comm/agent/osgi/AgentCallbacks$TracePeer 
.const [37] = Utf8 java/lang/Object 
.const [38] = Utf8 de/esolutions/fw/comm/agent/Agent 
.const [39] = Utf8 de/esolutions/fw/comm/agent/osgi/AgentCallbacks 
.const [40] = Utf8 de/esolutions/fw/util/tracing/TraceChannel 
.const [41] = Class [64] 
.const [42] = NameAndType [65] [66] 
.const [43] = Class [67] 
.const [44] = NameAndType [68] [69] 
.const [45] = Class [70] 
.const [46] = NameAndType [71] [72] 
.const [47] = Class [73] 
.const [48] = NameAndType [74] [75] 
.const [49] = Class [76] 
.const [50] = NameAndType [77] [78] 
.const [51] = Class [79] 
.const [52] = NameAndType [80] [81] 
.const [53] = Utf8 java/lang/String 
.const [54] = Utf8 java/lang/Short 
.const [55] = Utf8 java/lang/Short 
.const [56] = Utf8 parseShort 
.const [57] = Utf8 (Ljava/lang/String;)S 
.const [58] = Utf8 de/esolutions/fw/comm/agent/Agent 
.const [59] = Utf8 getAgent 
.const [60] = Utf8 ()Lde/esolutions/fw/comm/agent/Agent; 
.const [61] = Utf8 de/esolutions/fw/comm/agent/osgi/AgentCallbacks 
.const [62] = Utf8 access$000 
.const [63] = Utf8 ()Lde/esolutions/fw/util/tracing/TraceChannel; 
.const [64] = Utf8 de/esolutions/fw/util/tracing/TraceChannel 
.const [65] = Utf8 log 
.const [66] = Utf8 (SLjava/lang/String;Ljava/lang/Object;)Z 
.const [67] = Utf8 de/esolutions/fw/comm/agent/Agent 
.const [68] = Utf8 setTracePeer 
.const [69] = Utf8 (S)V 
.const [70] = Utf8 de/esolutions/fw/comm/agent/osgi/AgentCallbacks$TracePeer 
.const [71] = Utf8 <init> 
.const [72] = Utf8 ()V 
.const [73] = Utf8 java/lang/Object 
.const [74] = Utf8 <init> 
.const [75] = Utf8 ()V 
.const [76] = Utf8 java/lang/String 
.const [77] = Utf8 <init> 
.const [78] = Utf8 ([BLjava/lang/String;)V 
.const [79] = Utf8 java/lang/Short 
.const [80] = Utf8 <init> 
.const [81] = Utf8 (S)V 
.const [82] = Utf8 de/esolutions/fw/comm/agent/osgi/AgentCallbacks$TracePeer 
.const [83] = Class [82] 
.const [84] = Utf8 java/lang/Object 
.const [85] = Class [84] 
.const [86] = Utf8 de/esolutions/fw/util/tracing/ITraceCallback 
.const [87] = Class [86] 
.const [88] = Utf8 Code 
.const [89] = Utf8 <init> 
.const [90] = Utf8 ()V 
.const [91] = Utf8 executeTraceCallback 
.const [92] = Utf8 (I[B)V 
.const [93] = Utf8 <init> 
.const [94] = Utf8 (Lde/esolutions/fw/comm/agent/osgi/AgentCallbacks$1;)V 
.end class 
