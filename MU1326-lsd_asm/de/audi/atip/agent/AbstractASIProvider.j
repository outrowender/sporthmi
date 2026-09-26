.version 50 0 
.class public super abstract [183] 
.super [185] 
.implements [187] 
.field private final [188] [189] 
.field private final [190] [191] 
.field private final [192] [193] 

.method public [195] : [196] 
    .attribute [194] .code stack 3 locals 0 
L0:     aload_0 
L1:     invokespecial [27] 
L4:     aload_0 
L5:     aload_1 
L6:     putfield [33] 
L9:     aload_0 
L10:    aload_2 
L11:    ifnull L18 
L14:    aload_2 
L15:    goto L21 
L18:    invokestatic [2] 
L21:    putfield [34] 
L24:    aload_0 
L25:    new [35] 
L28:    dup 
L29:    invokespecial [28] 
L32:    putfield [36] 
L35:    return 
L36:    
    .end code 
.end method 

.method public synchronized [197] : [198] 
    .attribute [194] .code stack 4 locals 0 
L0:     aload_0 
L1:     invokespecial [29] 
L4:     ldc [4] 
L6:     ldc [5] 
L8:     aload_1 
L9:     invokevirtual [23] 
L12:    pop 
L13:    aload_0 
L14:    getfield [22] 
L17:    aload_1 
L18:    invokeinterface [37] 0 
L23:    pop 
L24:    return 
L25:    nop 
L26:    nop 
L27:    nop 
L28:    
    .end code 
.end method 

.method public synchronized [199] : [200] 
    .attribute [194] .code stack 4 locals 0 
L0:     aload_0 
L1:     invokespecial [29] 
L4:     ldc [4] 
L6:     ldc [6] 
L8:     aload_1 
L9:     invokevirtual [23] 
L12:    pop 
L13:    aload_0 
L14:    getfield [22] 
L17:    aload_1 
L18:    invokeinterface [38] 0 
L23:    pop 
L24:    return 
L25:    nop 
L26:    nop 
L27:    nop 
L28:    
    .end code 
.end method 

.method protected final interface [201] : [202] 
    .attribute [194] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [21] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public final [203] : [204] 
    .attribute [194] .code stack 2 locals 0 
L0:     new [39] 
L3:     dup 
L4:     invokespecial [30] 
L7:     aload_0 
L8:     getfield [20] 
L11:    invokevirtual [24] 
L14:    ldc [8] 
L16:    invokevirtual [24] 
L19:    invokevirtual [25] 
L22:    areturn 
L23:    nop 
L24:    
    .end code 
.end method 

.method protected final synchronized [205] : [206] 
    .attribute [194] .code stack 3 locals 0 
L0:     new [35] 
L3:     dup 
L4:     aload_0 
L5:     getfield [22] 
L8:     invokespecial [31] 
L11:    areturn 
L12:    
    .end code 
.end method 

.method protected final [207] : [208] 
    .attribute [194] .code stack 6 locals 2 
L0:     aload_0 
L1:     invokespecial [32] 
L4:     invokeinterface [40] 0 
L9:     astore_2 
L10:    aload_2 
L11:    invokeinterface [41] 0 
L16:    ifeq L60 
        .catch [10] from L19 to L39 using L42 
L19:    aload_1 
L20:    aload_2 
L21:    invokeinterface [42] 0 
L26:    checkcast [9] 
L29:    invokeinterface [43] 0 
L34:    invokeinterface [44] 0 
L39:    goto L10 
L42:    astore_3 
L43:    aload_0 
L44:    invokespecial [29] 
L47:    ldc [11] 
L49:    ldc [12] 
L51:    aload_0 
L52:    aload_1 
L53:    aload_3 
L54:    invokevirtual [26] 
L57:    goto L10 
L60:    return 
L61:    nop 
L62:    nop 
L63:    nop 
L64:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Method [45] [46] 
.const [3] = Class [47] 
.const [4] = Int -2137614336 
.const [5] = String [48] 
.const [6] = String [49] 
.const [7] = Class [50] 
.const [8] = String [51] 
.const [9] = Class [52] 
.const [10] = Class [53] 
.const [11] = Int -1601830656 
.const [12] = String [54] 
.const [13] = Class [55] 
.const [14] = Class [56] 
.const [15] = Class [57] 
.const [16] = Class [58] 
.const [17] = Class [59] 
.const [18] = Class [60] 
.const [19] = Class [61] 
.const [20] = Field [62] [63] 
.const [21] = Field [64] [65] 
.const [22] = Field [66] [67] 
.const [23] = Method [68] [69] 
.const [24] = Method [70] [71] 
.const [25] = Method [72] [73] 
.const [26] = Method [74] [75] 
.const [27] = Method [76] [77] 
.const [28] = Method [78] [79] 
.const [29] = Method [80] [81] 
.const [30] = Method [82] [83] 
.const [31] = Method [84] [85] 
.const [32] = Method [86] [87] 
.const [33] = Field [88] [89] 
.const [34] = Field [90] [91] 
.const [35] = Class [92] 
.const [36] = Field [93] [94] 
.const [37] = InterfaceMethod [95] [96] 
.const [38] = InterfaceMethod [97] [98] 
.const [39] = Class [99] 
.const [40] = InterfaceMethod [100] [101] 
.const [41] = InterfaceMethod [102] [103] 
.const [42] = InterfaceMethod [104] [105] 
.const [43] = InterfaceMethod [106] [107] 
.const [44] = InterfaceMethod [108] [109] 
.const [45] = Class [110] 
.const [46] = NameAndType [111] [112] 
.const [47] = Utf8 java/util/ArrayList 
.const [48] = Utf8 'attachStub(%1)' 
.const [49] = Utf8 'detachStub(%1)' 
.const [50] = Utf8 java/lang/StringBuffer 
.const [51] = Utf8 ASIProvider 
.const [52] = Utf8 de/esolutions/fw/comm/core/IStub 
.const [53] = Utf8 java/lang/Exception 
.const [54] = Utf8 '%1.broadcast() call %2 failed!' 
.const [55] = Utf8 de/audi/atip/agent/AbstractASIProvider 
.const [56] = Utf8 java/lang/Object 
.const [57] = Utf8 de/audi/atip/log/NullLogChannel 
.const [58] = Utf8 de/audi/atip/log/LogChannel 
.const [59] = Utf8 java/util/List 
.const [60] = Utf8 java/util/Iterator 
.const [61] = Utf8 de/audi/atip/agent/IASICall 
.const [62] = Class [113] 
.const [63] = NameAndType [114] [115] 
.const [64] = Class [116] 
.const [65] = NameAndType [117] [118] 
.const [66] = Class [119] 
.const [67] = NameAndType [120] [121] 
.const [68] = Class [122] 
.const [69] = NameAndType [123] [124] 
.const [70] = Class [125] 
.const [71] = NameAndType [126] [127] 
.const [72] = Class [128] 
.const [73] = NameAndType [129] [130] 
.const [74] = Class [131] 
.const [75] = NameAndType [132] [133] 
.const [76] = Class [134] 
.const [77] = NameAndType [135] [136] 
.const [78] = Class [137] 
.const [79] = NameAndType [138] [139] 
.const [80] = Class [140] 
.const [81] = NameAndType [141] [142] 
.const [82] = Class [143] 
.const [83] = NameAndType [144] [145] 
.const [84] = Class [146] 
.const [85] = NameAndType [147] [148] 
.const [86] = Class [149] 
.const [87] = NameAndType [150] [151] 
.const [88] = Class [152] 
.const [89] = NameAndType [153] [154] 
.const [90] = Class [155] 
.const [91] = NameAndType [156] [157] 
.const [92] = Utf8 java/util/ArrayList 
.const [93] = Class [158] 
.const [94] = NameAndType [159] [160] 
.const [95] = Class [161] 
.const [96] = NameAndType [162] [163] 
.const [97] = Class [164] 
.const [98] = NameAndType [165] [166] 
.const [99] = Utf8 java/lang/StringBuffer 
.const [100] = Class [167] 
.const [101] = NameAndType [168] [169] 
.const [102] = Class [170] 
.const [103] = NameAndType [171] [172] 
.const [104] = Class [173] 
.const [105] = NameAndType [174] [175] 
.const [106] = Class [176] 
.const [107] = NameAndType [177] [178] 
.const [108] = Class [179] 
.const [109] = NameAndType [180] [181] 
.const [110] = Utf8 de/audi/atip/log/NullLogChannel 
.const [111] = Utf8 getInstance 
.const [112] = Utf8 ()Lde/audi/atip/log/LogChannel; 
.const [113] = Utf8 de/audi/atip/agent/AbstractASIProvider 
.const [114] = Utf8 name 
.const [115] = Utf8 Ljava/lang/String; 
.const [116] = Utf8 de/audi/atip/agent/AbstractASIProvider 
.const [117] = Utf8 log 
.const [118] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [119] = Utf8 de/audi/atip/agent/AbstractASIProvider 
.const [120] = Utf8 stubs 
.const [121] = Utf8 Ljava/util/List; 
.const [122] = Utf8 de/audi/atip/log/LogChannel 
.const [123] = Utf8 log 
.const [124] = Utf8 (ILjava/lang/String;Ljava/lang/Object;)Z 
.const [125] = Utf8 java/lang/StringBuffer 
.const [126] = Utf8 append 
.const [127] = Utf8 (Ljava/lang/String;)Ljava/lang/StringBuffer; 
.const [128] = Utf8 java/lang/StringBuffer 
.const [129] = Utf8 toString 
.const [130] = Utf8 ()Ljava/lang/String; 
.const [131] = Utf8 de/audi/atip/log/LogChannel 
.const [132] = Utf8 log 
.const [133] = Utf8 (ILjava/lang/String;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V 
.const [134] = Utf8 java/lang/Object 
.const [135] = Utf8 <init> 
.const [136] = Utf8 ()V 
.const [137] = Utf8 java/util/ArrayList 
.const [138] = Utf8 <init> 
.const [139] = Utf8 ()V 
.const [140] = Utf8 de/audi/atip/agent/AbstractASIProvider 
.const [141] = Utf8 getLog 
.const [142] = Utf8 ()Lde/audi/atip/log/LogChannel; 
.const [143] = Utf8 java/lang/StringBuffer 
.const [144] = Utf8 <init> 
.const [145] = Utf8 ()V 
.const [146] = Utf8 java/util/ArrayList 
.const [147] = Utf8 <init> 
.const [148] = Utf8 (Ljava/util/Collection;)V 
.const [149] = Utf8 de/audi/atip/agent/AbstractASIProvider 
.const [150] = Utf8 getStubs 
.const [151] = Utf8 ()Ljava/util/List; 
.const [152] = Utf8 de/audi/atip/agent/AbstractASIProvider 
.const [153] = Utf8 name 
.const [154] = Utf8 Ljava/lang/String; 
.const [155] = Utf8 de/audi/atip/agent/AbstractASIProvider 
.const [156] = Utf8 log 
.const [157] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [158] = Utf8 de/audi/atip/agent/AbstractASIProvider 
.const [159] = Utf8 stubs 
.const [160] = Utf8 Ljava/util/List; 
.const [161] = Utf8 java/util/List 
.const [162] = Utf8 add 
.const [163] = Utf8 (Ljava/lang/Object;)Z 
.const [164] = Utf8 java/util/List 
.const [165] = Utf8 remove 
.const [166] = Utf8 (Ljava/lang/Object;)Z 
.const [167] = Utf8 java/util/List 
.const [168] = Utf8 iterator 
.const [169] = Utf8 ()Ljava/util/Iterator; 
.const [170] = Utf8 java/util/Iterator 
.const [171] = Utf8 hasNext 
.const [172] = Utf8 ()Z 
.const [173] = Utf8 java/util/Iterator 
.const [174] = Utf8 next 
.const [175] = Utf8 ()Ljava/lang/Object; 
.const [176] = Utf8 de/esolutions/fw/comm/core/IStub 
.const [177] = Utf8 getReplyProxyFrontend 
.const [178] = Utf8 ()Lde/esolutions/fw/comm/core/IProxyFrontend; 
.const [179] = Utf8 de/audi/atip/agent/IASICall 
.const [180] = Utf8 call 
.const [181] = Utf8 (Lde/esolutions/fw/comm/core/IProxyFrontend;)V 
.const [182] = Utf8 de/audi/atip/agent/AbstractASIProvider 
.const [183] = Class [182] 
.const [184] = Utf8 java/lang/Object 
.const [185] = Class [184] 
.const [186] = Utf8 de/audi/atip/agent/IASIProvider 
.const [187] = Class [186] 
.const [188] = Utf8 name 
.const [189] = Utf8 Ljava/lang/String; 
.const [190] = Utf8 log 
.const [191] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [192] = Utf8 stubs 
.const [193] = Utf8 Ljava/util/List; 
.const [194] = Utf8 Code 
.const [195] = Utf8 <init> 
.const [196] = Utf8 (Ljava/lang/String;Lde/audi/atip/log/LogChannel;)V 
.const [197] = Utf8 attachStub 
.const [198] = Utf8 (Lde/esolutions/fw/comm/core/IStub;)V 
.const [199] = Utf8 detachStub 
.const [200] = Utf8 (Lde/esolutions/fw/comm/core/IStub;)V 
.const [201] = Utf8 getLog 
.const [202] = Utf8 ()Lde/audi/atip/log/LogChannel; 
.const [203] = Utf8 toString 
.const [204] = Utf8 ()Ljava/lang/String; 
.const [205] = Utf8 getStubs 
.const [206] = Utf8 ()Ljava/util/List; 
.const [207] = Utf8 broadcast 
.const [208] = Utf8 (Lde/audi/atip/agent/IASICall;)V 
.end class 
