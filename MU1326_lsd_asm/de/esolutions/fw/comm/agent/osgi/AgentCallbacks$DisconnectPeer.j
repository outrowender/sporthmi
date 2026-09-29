.version 50 0 
.class super [117] 
.super [119] 
.implements [121] 

.method private annotation [123] : [124] 
    .attribute [122] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [24] 
L4:     return 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [125] : [126] 
    .attribute [122] .code stack 6 locals 3 
        .catch [9] from L0 to L53 using L56 
L0:     new [28] 
L3:     dup 
L4:     aload_2 
L5:     ldc [3] 
L7:     invokespecial [25] 
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
L33:    new [29] 
L36:    dup 
L37:    iload 4 
L39:    invokespecial [26] 
L42:    invokevirtual [17] 
L45:    pop 
L46:    aload 5 
L48:    iload 4 
L50:    invokevirtual [18] 
L53:    goto L84 
L56:    astore_3 
L57:    invokestatic [6] 
L60:    iconst_4 
L61:    new [30] 
L64:    dup 
L65:    invokespecial [27] 
L68:    ldc [11] 
L70:    invokevirtual [19] 
L73:    aload_3 
L74:    invokevirtual [20] 
L77:    invokevirtual [21] 
L80:    invokevirtual [22] 
L83:    pop 
L84:    return 
L85:    nop 
L86:    nop 
L87:    nop 
L88:    
    .end code 
.end method 

.method synthetic [127] : [128] 
    .attribute [122] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [23] 
L4:     return 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [31] 
.const [3] = String [32] 
.const [4] = Method [33] [34] 
.const [5] = Method [35] [36] 
.const [6] = Method [37] [38] 
.const [7] = String [39] 
.const [8] = Class [40] 
.const [9] = Class [41] 
.const [10] = Class [42] 
.const [11] = String [43] 
.const [12] = Class [44] 
.const [13] = Class [45] 
.const [14] = Class [46] 
.const [15] = Class [47] 
.const [16] = Class [48] 
.const [17] = Method [49] [50] 
.const [18] = Method [51] [52] 
.const [19] = Method [53] [54] 
.const [20] = Method [55] [56] 
.const [21] = Method [57] [58] 
.const [22] = Method [59] [60] 
.const [23] = Method [61] [62] 
.const [24] = Method [63] [64] 
.const [25] = Method [65] [66] 
.const [26] = Method [67] [68] 
.const [27] = Method [69] [70] 
.const [28] = Class [71] 
.const [29] = Class [72] 
.const [30] = Class [73] 
.const [31] = Utf8 java/lang/String 
.const [32] = Utf8 UTF-8 
.const [33] = Class [74] 
.const [34] = NameAndType [75] [76] 
.const [35] = Class [77] 
.const [36] = NameAndType [78] [79] 
.const [37] = Class [80] 
.const [38] = NameAndType [81] [82] 
.const [39] = Utf8 'Force disconnect to peer: %1' 
.const [40] = Utf8 java/lang/Short 
.const [41] = Utf8 java/lang/Exception 
.const [42] = Utf8 java/lang/StringBuffer 
.const [43] = Utf8 'Invalid DisconnectPeer call! Reason: %1 ' 
.const [44] = Utf8 de/esolutions/fw/comm/agent/osgi/AgentCallbacks$DisconnectPeer 
.const [45] = Utf8 java/lang/Object 
.const [46] = Utf8 de/esolutions/fw/comm/agent/Agent 
.const [47] = Utf8 de/esolutions/fw/comm/agent/osgi/AgentCallbacks 
.const [48] = Utf8 de/esolutions/fw/util/tracing/TraceChannel 
.const [49] = Class [83] 
.const [50] = NameAndType [84] [85] 
.const [51] = Class [86] 
.const [52] = NameAndType [87] [88] 
.const [53] = Class [89] 
.const [54] = NameAndType [90] [91] 
.const [55] = Class [92] 
.const [56] = NameAndType [93] [94] 
.const [57] = Class [95] 
.const [58] = NameAndType [96] [97] 
.const [59] = Class [98] 
.const [60] = NameAndType [99] [100] 
.const [61] = Class [101] 
.const [62] = NameAndType [102] [103] 
.const [63] = Class [104] 
.const [64] = NameAndType [105] [106] 
.const [65] = Class [107] 
.const [66] = NameAndType [108] [109] 
.const [67] = Class [110] 
.const [68] = NameAndType [111] [112] 
.const [69] = Class [113] 
.const [70] = NameAndType [114] [115] 
.const [71] = Utf8 java/lang/String 
.const [72] = Utf8 java/lang/Short 
.const [73] = Utf8 java/lang/StringBuffer 
.const [74] = Utf8 java/lang/Short 
.const [75] = Utf8 parseShort 
.const [76] = Utf8 (Ljava/lang/String;)S 
.const [77] = Utf8 de/esolutions/fw/comm/agent/Agent 
.const [78] = Utf8 getAgent 
.const [79] = Utf8 ()Lde/esolutions/fw/comm/agent/Agent; 
.const [80] = Utf8 de/esolutions/fw/comm/agent/osgi/AgentCallbacks 
.const [81] = Utf8 access$000 
.const [82] = Utf8 ()Lde/esolutions/fw/util/tracing/TraceChannel; 
.const [83] = Utf8 de/esolutions/fw/util/tracing/TraceChannel 
.const [84] = Utf8 log 
.const [85] = Utf8 (SLjava/lang/String;Ljava/lang/Object;)Z 
.const [86] = Utf8 de/esolutions/fw/comm/agent/Agent 
.const [87] = Utf8 forceDisconnect 
.const [88] = Utf8 (S)V 
.const [89] = Utf8 java/lang/StringBuffer 
.const [90] = Utf8 append 
.const [91] = Utf8 (Ljava/lang/String;)Ljava/lang/StringBuffer; 
.const [92] = Utf8 java/lang/StringBuffer 
.const [93] = Utf8 append 
.const [94] = Utf8 (Ljava/lang/Object;)Ljava/lang/StringBuffer; 
.const [95] = Utf8 java/lang/StringBuffer 
.const [96] = Utf8 toString 
.const [97] = Utf8 ()Ljava/lang/String; 
.const [98] = Utf8 de/esolutions/fw/util/tracing/TraceChannel 
.const [99] = Utf8 log 
.const [100] = Utf8 (SLjava/lang/String;)Z 
.const [101] = Utf8 de/esolutions/fw/comm/agent/osgi/AgentCallbacks$DisconnectPeer 
.const [102] = Utf8 <init> 
.const [103] = Utf8 ()V 
.const [104] = Utf8 java/lang/Object 
.const [105] = Utf8 <init> 
.const [106] = Utf8 ()V 
.const [107] = Utf8 java/lang/String 
.const [108] = Utf8 <init> 
.const [109] = Utf8 ([BLjava/lang/String;)V 
.const [110] = Utf8 java/lang/Short 
.const [111] = Utf8 <init> 
.const [112] = Utf8 (S)V 
.const [113] = Utf8 java/lang/StringBuffer 
.const [114] = Utf8 <init> 
.const [115] = Utf8 ()V 
.const [116] = Utf8 de/esolutions/fw/comm/agent/osgi/AgentCallbacks$DisconnectPeer 
.const [117] = Class [116] 
.const [118] = Utf8 java/lang/Object 
.const [119] = Class [118] 
.const [120] = Utf8 de/esolutions/fw/util/tracing/ITraceCallback 
.const [121] = Class [120] 
.const [122] = Utf8 Code 
.const [123] = Utf8 <init> 
.const [124] = Utf8 ()V 
.const [125] = Utf8 executeTraceCallback 
.const [126] = Utf8 (I[B)V 
.const [127] = Utf8 <init> 
.const [128] = Utf8 (Lde/esolutions/fw/comm/agent/osgi/AgentCallbacks$1;)V 
.end class 
