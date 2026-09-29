.version 50 0 
.class public super [118] 
.super [120] 
.field protected [121] [122] 
.field protected [123] [124] 

.method public [126] : [127] 
    .attribute [125] .code stack 3 locals 0 
L0:     aload_0 
L1:     invokespecial [17] 
L4:     aload_0 
L5:     aload_1 
L6:     putfield [19] 
L9:     aload_0 
L10:    new [20] 
L13:    dup 
L14:    invokespecial [18] 
L17:    putfield [21] 
L20:    return 
L21:    nop 
L22:    nop 
L23:    nop 
L24:    
    .end code 
.end method 

.method public [128] : [129] 
    .attribute [125] .code stack 2 locals 2 
L0:     aload_0 
L1:     getfield [12] 
L4:     dup 
L5:     astore_2 
L6:     monitorenter 
        .catch [0] from L7 to L20 using L23 
L7:     aload_0 
L8:     getfield [12] 
L11:    aload_1 
L12:    invokeinterface [22] 0 
L17:    pop 
L18:    aload_2 
L19:    monitorexit 
L20:    goto L28 
        .catch [0] from L23 to L26 using L23 
L23:    astore_3 
L24:    aload_2 
L25:    monitorexit 
L26:    aload_3 
L27:    athrow 
L28:    return 
L29:    nop 
L30:    nop 
L31:    nop 
L32:    
    .end code 
.end method 

.method public [130] : [131] 
    .attribute [125] .code stack 2 locals 2 
L0:     aload_0 
L1:     getfield [12] 
L4:     dup 
L5:     astore_2 
L6:     monitorenter 
        .catch [0] from L7 to L20 using L23 
L7:     aload_0 
L8:     getfield [12] 
L11:    aload_1 
L12:    invokeinterface [23] 0 
L17:    pop 
L18:    aload_2 
L19:    monitorexit 
L20:    goto L28 
        .catch [0] from L23 to L26 using L23 
L23:    astore_3 
L24:    aload_2 
L25:    monitorexit 
L26:    aload_3 
L27:    athrow 
L28:    return 
L29:    nop 
L30:    nop 
L31:    nop 
L32:    
    .end code 
.end method 

.method public [132] : [133] 
    .attribute [125] .code stack 2 locals 2 
L0:     aload_0 
L1:     getfield [12] 
L4:     dup 
L5:     astore_1 
L6:     monitorenter 
        .catch [0] from L7 to L26 using L27 
L7:     aload_0 
L8:     getfield [12] 
L11:    invokeinterface [24] 0 
L16:    ifne L23 
L19:    iconst_1 
L20:    goto L24 
L23:    iconst_0 
L24:    aload_1 
L25:    monitorexit 
L26:    areturn 
        .catch [0] from L27 to L30 using L27 
L27:    astore_2 
L28:    aload_1 
L29:    monitorexit 
L30:    aload_2 
L31:    athrow 
L32:    
    .end code 
.end method 

.method public [134] : [135] 
    .attribute [125] .code stack 5 locals 5 
L0:     aload_0 
L1:     getfield [12] 
L4:     dup 
L5:     astore_2 
L6:     monitorenter 
        .catch [0] from L7 to L84 using L85 
L7:     aload_0 
L8:     invokevirtual [13] 
L11:    istore_3 
L12:    aload_0 
L13:    getfield [11] 
L16:    ldc [3] 
L18:    ldc [4] 
L20:    iload_3 
L21:    aload_1 
L22:    invokevirtual [14] 
L25:    pop 
L26:    iload_3 
L27:    ifeq L81 
L30:    aload_0 
L31:    getfield [12] 
L34:    invokeinterface [25] 0 
L39:    astore 4 
L41:    aload 4 
L43:    invokeinterface [26] 0 
L48:    ifeq L81 
L51:    aload 4 
L53:    invokeinterface [27] 0 
L58:    checkcast [5] 
L61:    astore 5 
L63:    aload_0 
L64:    aload 5 
L66:    invokevirtual [15] 
L69:    ifeq L78 
L72:    aload 5 
L74:    aload_1 
L75:    invokevirtual [16] 
L78:    goto L41 
L81:    iload_3 
L82:    aload_2 
L83:    monitorexit 
L84:    areturn 
        .catch [0] from L85 to L89 using L85 
L85:    astore 6 
L87:    aload_2 
L88:    monitorexit 
L89:    aload 6 
L91:    athrow 
L92:    
    .end code 
.end method 

.method public [136] : [137] 
    .attribute [125] .code stack 1 locals 0 
L0:     iconst_1 
L1:     areturn 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method protected [138] : [139] 
    .attribute [125] .code stack 1 locals 0 
L0:     iconst_1 
L1:     areturn 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [28] 
.const [3] = Int -2137614336 
.const [4] = String [29] 
.const [5] = Class [30] 
.const [6] = Class [31] 
.const [7] = Class [32] 
.const [8] = Class [33] 
.const [9] = Class [34] 
.const [10] = Class [35] 
.const [11] = Field [36] [37] 
.const [12] = Field [38] [39] 
.const [13] = Method [40] [41] 
.const [14] = Method [42] [43] 
.const [15] = Method [44] [45] 
.const [16] = Method [46] [47] 
.const [17] = Method [48] [49] 
.const [18] = Method [50] [51] 
.const [19] = Field [52] [53] 
.const [20] = Class [54] 
.const [21] = Field [55] [56] 
.const [22] = InterfaceMethod [57] [58] 
.const [23] = InterfaceMethod [59] [60] 
.const [24] = InterfaceMethod [61] [62] 
.const [25] = InterfaceMethod [63] [64] 
.const [26] = InterfaceMethod [65] [66] 
.const [27] = InterfaceMethod [67] [68] 
.const [28] = Utf8 java/util/HashSet 
.const [29] = Utf8 'Monitor#stopMonitoredLists( %2 ) - active: %1' 
.const [30] = Utf8 de/audi/tghu/command/CommandList 
.const [31] = Utf8 de/audi/tghu/command/Monitor 
.const [32] = Utf8 java/lang/Object 
.const [33] = Utf8 java/util/Set 
.const [34] = Utf8 de/audi/atip/log/LogChannel 
.const [35] = Utf8 java/util/Iterator 
.const [36] = Class [69] 
.const [37] = NameAndType [70] [71] 
.const [38] = Class [72] 
.const [39] = NameAndType [73] [74] 
.const [40] = Class [75] 
.const [41] = NameAndType [76] [77] 
.const [42] = Class [78] 
.const [43] = NameAndType [79] [80] 
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
.const [54] = Utf8 java/util/HashSet 
.const [55] = Class [96] 
.const [56] = NameAndType [97] [98] 
.const [57] = Class [99] 
.const [58] = NameAndType [100] [101] 
.const [59] = Class [102] 
.const [60] = NameAndType [103] [104] 
.const [61] = Class [105] 
.const [62] = NameAndType [106] [107] 
.const [63] = Class [108] 
.const [64] = NameAndType [109] [110] 
.const [65] = Class [111] 
.const [66] = NameAndType [112] [113] 
.const [67] = Class [114] 
.const [68] = NameAndType [115] [116] 
.const [69] = Utf8 de/audi/tghu/command/Monitor 
.const [70] = Utf8 logChannel 
.const [71] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [72] = Utf8 de/audi/tghu/command/Monitor 
.const [73] = Utf8 monitoredCommandlists 
.const [74] = Utf8 Ljava/util/Set; 
.const [75] = Utf8 de/audi/tghu/command/Monitor 
.const [76] = Utf8 isActive 
.const [77] = Utf8 ()Z 
.const [78] = Utf8 de/audi/atip/log/LogChannel 
.const [79] = Utf8 log 
.const [80] = Utf8 (ILjava/lang/String;ZLjava/lang/Object;)Z 
.const [81] = Utf8 de/audi/tghu/command/Monitor 
.const [82] = Utf8 checkStop 
.const [83] = Utf8 (Lde/audi/tghu/command/CommandList;)Z 
.const [84] = Utf8 de/audi/tghu/command/CommandList 
.const [85] = Utf8 stop 
.const [86] = Utf8 (Ljava/lang/String;)V 
.const [87] = Utf8 java/lang/Object 
.const [88] = Utf8 <init> 
.const [89] = Utf8 ()V 
.const [90] = Utf8 java/util/HashSet 
.const [91] = Utf8 <init> 
.const [92] = Utf8 ()V 
.const [93] = Utf8 de/audi/tghu/command/Monitor 
.const [94] = Utf8 logChannel 
.const [95] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [96] = Utf8 de/audi/tghu/command/Monitor 
.const [97] = Utf8 monitoredCommandlists 
.const [98] = Utf8 Ljava/util/Set; 
.const [99] = Utf8 java/util/Set 
.const [100] = Utf8 add 
.const [101] = Utf8 (Ljava/lang/Object;)Z 
.const [102] = Utf8 java/util/Set 
.const [103] = Utf8 remove 
.const [104] = Utf8 (Ljava/lang/Object;)Z 
.const [105] = Utf8 java/util/Set 
.const [106] = Utf8 isEmpty 
.const [107] = Utf8 ()Z 
.const [108] = Utf8 java/util/Set 
.const [109] = Utf8 iterator 
.const [110] = Utf8 ()Ljava/util/Iterator; 
.const [111] = Utf8 java/util/Iterator 
.const [112] = Utf8 hasNext 
.const [113] = Utf8 ()Z 
.const [114] = Utf8 java/util/Iterator 
.const [115] = Utf8 next 
.const [116] = Utf8 ()Ljava/lang/Object; 
.const [117] = Utf8 de/audi/tghu/command/Monitor 
.const [118] = Class [117] 
.const [119] = Utf8 java/lang/Object 
.const [120] = Class [119] 
.const [121] = Utf8 monitoredCommandlists 
.const [122] = Utf8 Ljava/util/Set; 
.const [123] = Utf8 logChannel 
.const [124] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [125] = Utf8 Code 
.const [126] = Utf8 <init> 
.const [127] = Utf8 (Lde/audi/atip/log/LogChannel;)V 
.const [128] = Utf8 prologue 
.const [129] = Utf8 (Lde/audi/tghu/command/CommandList;)V 
.const [130] = Utf8 epilogue 
.const [131] = Utf8 (Lde/audi/tghu/command/CommandList;)V 
.const [132] = Utf8 isActive 
.const [133] = Utf8 ()Z 
.const [134] = Utf8 stopMonitoredLists 
.const [135] = Utf8 (Ljava/lang/String;)Z 
.const [136] = Utf8 processCommand 
.const [137] = Utf8 (Lde/audi/tghu/command/Command;)Z 
.const [138] = Utf8 checkStop 
.const [139] = Utf8 (Lde/audi/tghu/command/CommandList;)Z 
.end class 
