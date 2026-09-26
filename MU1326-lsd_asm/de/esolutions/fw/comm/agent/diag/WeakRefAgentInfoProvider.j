.version 50 0 
.class public super [133] 
.super [135] 
.implements [137] 
.field private [138] [139] 

.method public [141] : [142] 
    .attribute [140] .code stack 3 locals 0 
L0:     aload_0 
L1:     invokespecial [19] 
L4:     aload_0 
L5:     new [23] 
L8:     dup 
L9:     invokespecial [20] 
L12:    putfield [24] 
L15:    return 
L16:    
    .end code 
.end method 

.method public [143] : [144] 
    .attribute [140] .code stack 2 locals 4 
L0:     new [25] 
L3:     dup 
L4:     invokespecial [21] 
L7:     astore_1 
L8:     aload_0 
L9:     getfield [13] 
L12:    invokeinterface [26] 0 
L17:    astore_2 
L18:    aload_2 
L19:    invokeinterface [27] 0 
L24:    ifeq L75 
L27:    aload_2 
L28:    invokeinterface [28] 0 
L33:    checkcast [4] 
L36:    astore_3 
L37:    aload_3 
L38:    invokevirtual [14] 
L41:    checkcast [5] 
L44:    astore 4 
L46:    aconst_null 
L47:    aload 4 
L49:    if_acmpeq L66 
L52:    aload_1 
L53:    aload 4 
L55:    invokeinterface [30] 0 
L60:    invokevirtual [15] 
L63:    goto L72 
L66:    aload_2 
L67:    invokeinterface [31] 0 
L72:    goto L18 
L75:    aload_1 
L76:    areturn 
L77:    nop 
L78:    nop 
L79:    nop 
L80:    
    .end code 
.end method 

.method public [145] : [146] 
    .attribute [140] .code stack 2 locals 3 
L0:     aconst_null 
L1:     astore_1 
L2:     new [23] 
L5:     dup 
L6:     invokespecial [20] 
L9:     astore_2 
        .catch [8] from L10 to L50 using L53 
L10:    aload_0 
L11:    getfield [13] 
L14:    invokeinterface [26] 0 
L19:    astore_3 
L20:    aload_3 
L21:    invokeinterface [27] 0 
L26:    ifeq L32 
L29:    goto L20 
L32:    aload_2 
L33:    aload_2 
L34:    invokevirtual [16] 
L37:    anewarray [6] 
L40:    invokevirtual [17] 
L43:    checkcast [7] 
L46:    checkcast [7] 
L49:    astore_1 
L50:    goto L58 
L53:    astore_3 
L54:    aload_3 
L55:    invokevirtual [18] 
L58:    aload_1 
L59:    areturn 
L60:    
    .end code 
.end method 

.method public [147] : [148] 
    .attribute [140] .code stack 4 locals 0 
L0:     aload_0 
L1:     getfield [13] 
L4:     new [29] 
L7:     dup 
L8:     aload_1 
L9:     invokespecial [22] 
L12:    invokeinterface [32] 0 
L17:    pop 
L18:    return 
L19:    nop 
L20:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [33] 
.const [3] = Class [34] 
.const [4] = Class [35] 
.const [5] = Class [36] 
.const [6] = Class [37] 
.const [7] = Class [38] 
.const [8] = Class [39] 
.const [9] = Class [40] 
.const [10] = Class [41] 
.const [11] = Class [42] 
.const [12] = Class [43] 
.const [13] = Field [44] [45] 
.const [14] = Method [46] [47] 
.const [15] = Method [48] [49] 
.const [16] = Method [50] [51] 
.const [17] = Method [52] [53] 
.const [18] = Method [54] [55] 
.const [19] = Method [56] [57] 
.const [20] = Method [58] [59] 
.const [21] = Method [60] [61] 
.const [22] = Method [62] [63] 
.const [23] = Class [64] 
.const [24] = Field [65] [66] 
.const [25] = Class [67] 
.const [26] = InterfaceMethod [68] [69] 
.const [27] = InterfaceMethod [70] [71] 
.const [28] = InterfaceMethod [72] [73] 
.const [29] = Class [74] 
.const [30] = InterfaceMethod [75] [76] 
.const [31] = InterfaceMethod [77] [78] 
.const [32] = InterfaceMethod [79] [80] 
.const [33] = Utf8 java/util/ArrayList 
.const [34] = Utf8 de/esolutions/fw/comm/agent/diag/AgentInfoMap 
.const [35] = Utf8 java/lang/ref/WeakReference 
.const [36] = Utf8 de/esolutions/fw/comm/agent/IAgentInfoProvider 
.const [37] = Utf8 de/esolutions/fw/comm/agent/diag/IInfoBase 
.const [38] = Utf8 [Lde/esolutions/fw/comm/agent/diag/IInfoBase; 
.const [39] = Utf8 java/lang/Exception 
.const [40] = Utf8 de/esolutions/fw/comm/agent/diag/WeakRefAgentInfoProvider 
.const [41] = Utf8 java/lang/Object 
.const [42] = Utf8 java/util/List 
.const [43] = Utf8 java/util/Iterator 
.const [44] = Class [81] 
.const [45] = NameAndType [82] [83] 
.const [46] = Class [84] 
.const [47] = NameAndType [85] [86] 
.const [48] = Class [87] 
.const [49] = NameAndType [88] [89] 
.const [50] = Class [90] 
.const [51] = NameAndType [91] [92] 
.const [52] = Class [93] 
.const [53] = NameAndType [94] [95] 
.const [54] = Class [96] 
.const [55] = NameAndType [97] [98] 
.const [56] = Class [99] 
.const [57] = NameAndType [100] [101] 
.const [58] = Class [102] 
.const [59] = NameAndType [103] [104] 
.const [60] = Class [105] 
.const [61] = NameAndType [106] [107] 
.const [62] = Class [108] 
.const [63] = NameAndType [109] [110] 
.const [64] = Utf8 java/util/ArrayList 
.const [65] = Class [111] 
.const [66] = NameAndType [112] [113] 
.const [67] = Utf8 de/esolutions/fw/comm/agent/diag/AgentInfoMap 
.const [68] = Class [114] 
.const [69] = NameAndType [115] [116] 
.const [70] = Class [117] 
.const [71] = NameAndType [118] [119] 
.const [72] = Class [120] 
.const [73] = NameAndType [121] [122] 
.const [74] = Utf8 java/lang/ref/WeakReference 
.const [75] = Class [123] 
.const [76] = NameAndType [124] [125] 
.const [77] = Class [126] 
.const [78] = NameAndType [127] [128] 
.const [79] = Class [129] 
.const [80] = NameAndType [130] [131] 
.const [81] = Utf8 de/esolutions/fw/comm/agent/diag/WeakRefAgentInfoProvider 
.const [82] = Utf8 list 
.const [83] = Utf8 Ljava/util/List; 
.const [84] = Utf8 java/lang/ref/WeakReference 
.const [85] = Utf8 get 
.const [86] = Utf8 ()Ljava/lang/Object; 
.const [87] = Utf8 de/esolutions/fw/comm/agent/diag/AgentInfoMap 
.const [88] = Utf8 add 
.const [89] = Utf8 (Lde/esolutions/fw/comm/agent/diag/AgentInfoMap;)V 
.const [90] = Utf8 java/util/ArrayList 
.const [91] = Utf8 size 
.const [92] = Utf8 ()I 
.const [93] = Utf8 java/util/ArrayList 
.const [94] = Utf8 toArray 
.const [95] = Utf8 ([Ljava/lang/Object;)[Ljava/lang/Object; 
.const [96] = Utf8 java/lang/Exception 
.const [97] = Utf8 printStackTrace 
.const [98] = Utf8 ()V 
.const [99] = Utf8 java/lang/Object 
.const [100] = Utf8 <init> 
.const [101] = Utf8 ()V 
.const [102] = Utf8 java/util/ArrayList 
.const [103] = Utf8 <init> 
.const [104] = Utf8 ()V 
.const [105] = Utf8 de/esolutions/fw/comm/agent/diag/AgentInfoMap 
.const [106] = Utf8 <init> 
.const [107] = Utf8 ()V 
.const [108] = Utf8 java/lang/ref/WeakReference 
.const [109] = Utf8 <init> 
.const [110] = Utf8 (Ljava/lang/Object;)V 
.const [111] = Utf8 de/esolutions/fw/comm/agent/diag/WeakRefAgentInfoProvider 
.const [112] = Utf8 list 
.const [113] = Utf8 Ljava/util/List; 
.const [114] = Utf8 java/util/List 
.const [115] = Utf8 iterator 
.const [116] = Utf8 ()Ljava/util/Iterator; 
.const [117] = Utf8 java/util/Iterator 
.const [118] = Utf8 hasNext 
.const [119] = Utf8 ()Z 
.const [120] = Utf8 java/util/Iterator 
.const [121] = Utf8 next 
.const [122] = Utf8 ()Ljava/lang/Object; 
.const [123] = Utf8 de/esolutions/fw/comm/agent/IAgentInfoProvider 
.const [124] = Utf8 getAgentInfoMap 
.const [125] = Utf8 ()Lde/esolutions/fw/comm/agent/diag/AgentInfoMap; 
.const [126] = Utf8 java/util/Iterator 
.const [127] = Utf8 remove 
.const [128] = Utf8 ()V 
.const [129] = Utf8 java/util/List 
.const [130] = Utf8 add 
.const [131] = Utf8 (Ljava/lang/Object;)Z 
.const [132] = Utf8 de/esolutions/fw/comm/agent/diag/WeakRefAgentInfoProvider 
.const [133] = Class [132] 
.const [134] = Utf8 java/lang/Object 
.const [135] = Class [134] 
.const [136] = Utf8 de/esolutions/fw/comm/agent/IAgentInfoProvider 
.const [137] = Class [136] 
.const [138] = Utf8 list 
.const [139] = Utf8 Ljava/util/List; 
.const [140] = Utf8 Code 
.const [141] = Utf8 <init> 
.const [142] = Utf8 ()V 
.const [143] = Utf8 getAgentInfoMap 
.const [144] = Utf8 ()Lde/esolutions/fw/comm/agent/diag/AgentInfoMap; 
.const [145] = Utf8 getData 
.const [146] = Utf8 ()[Lde/esolutions/fw/comm/agent/diag/IInfoBase; 
.const [147] = Utf8 registerIAgentInfoProvider 
.const [148] = Utf8 (Lde/esolutions/fw/comm/agent/IAgentInfoProvider;)V 
.end class 
