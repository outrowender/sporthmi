.version 50 0 
.class public super [161] 
.super [163] 
.field private static final [164] [165] 
.field private static [166] [167] 
.field private [168] [169] 

.method public [171] : [172] 
    .attribute [170] .code stack 7 locals 0 
L0:     aload_0 
L1:     new [33] 
L4:     dup 
L5:     ldc [3] 
L7:     invokestatic [4] 
L10:    ldc [5] 
L12:    ldc [6] 
L14:    invokespecial [27] 
L17:    invokespecial [28] 
L20:    aload_0 
L21:    aload_1 
L22:    putfield [34] 
L25:    return 
L26:    nop 
L27:    nop 
L28:    
    .end code 
.end method 

.method private static synchronized [173] : [174] 
    .attribute [170] .code stack 2 locals 1 
L0:     getstatic [7] 
L3:     iconst_1 
L4:     iadd 
L5:     dup 
L6:     putstatic [29] 
L9:     istore_0 
L10:    iload_0 
L11:    areturn 
L12:    
    .end code 
.end method 

.method public [175] : [176] 
    .attribute [170] .code stack 1 locals 0 
L0:     getstatic [8] 
L3:     areturn 
L4:     
    .end code 
.end method 

.method public [177] : [178] 
    .attribute [170] .code stack 4 locals 3 
        .catch [12] from L0 to L109 using L112 
L0:     iload_1 
L1:     lookupswitch 
            0 : L28 
            4 : L50 
            default : L82 

L28:    aload_2 
L29:    invokeinterface [35] 0 
L34:    lstore 4 
L36:    aload_0 
L37:    getfield [22] 
L40:    lload 4 
L42:    invokeinterface [36] 0 
L47:    goto L109 
L50:    aload_2 
L51:    invokeinterface [35] 0 
L56:    lstore 4 
L58:    aload_2 
L59:    invokeinterface [37] 0 
L64:    istore 6 
L66:    aload_0 
L67:    getfield [22] 
L70:    lload 4 
L72:    iload 6 
L74:    invokeinterface [38] 0 
L79:    goto L109 
L82:    new [39] 
L85:    dup 
L86:    new [40] 
L89:    dup 
L90:    invokespecial [31] 
L93:    ldc [11] 
L95:    invokevirtual [23] 
L98:    iload_1 
L99:    invokevirtual [24] 
L102:   invokevirtual [25] 
L105:   invokespecial [32] 
L108:   athrow 
L109:   goto L154 
L112:   astore 4 
L114:   new [39] 
L117:   dup 
L118:   new [40] 
L121:   dup 
L122:   invokespecial [31] 
L125:   ldc [13] 
L127:   invokevirtual [23] 
L130:   iload_1 
L131:   invokevirtual [24] 
L134:   ldc [14] 
L136:   invokevirtual [23] 
L139:   aload 4 
L141:   invokevirtual [26] 
L144:   invokevirtual [23] 
L147:   invokevirtual [25] 
L150:   invokespecial [32] 
L153:   athrow 
L154:   return 
L155:   nop 
L156:   
    .end code 
.end method 

.method static [179] : [180] 
    .attribute [170] .code stack 1 locals 0 
L0:     ldc [15] 
L2:     invokestatic [16] 
L5:     putstatic [30] 
L8:     iconst_0 
L9:     putstatic [29] 
L12:    return 
L13:    nop 
L14:    nop 
L15:    nop 
L16:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [41] 
.const [3] = String [42] 
.const [4] = Method [43] [44] 
.const [5] = String [45] 
.const [6] = String [46] 
.const [7] = Field [47] [48] 
.const [8] = Field [49] [50] 
.const [9] = Class [51] 
.const [10] = Class [52] 
.const [11] = String [53] 
.const [12] = Class [54] 
.const [13] = String [55] 
.const [14] = String [56] 
.const [15] = String [57] 
.const [16] = Method [58] [59] 
.const [17] = Class [60] 
.const [18] = Class [61] 
.const [19] = Class [62] 
.const [20] = Class [63] 
.const [21] = Class [64] 
.const [22] = Field [65] [66] 
.const [23] = Method [67] [68] 
.const [24] = Method [69] [70] 
.const [25] = Method [71] [72] 
.const [26] = Method [73] [74] 
.const [27] = Method [75] [76] 
.const [28] = Method [77] [78] 
.const [29] = Field [79] [80] 
.const [30] = Field [81] [82] 
.const [31] = Method [83] [84] 
.const [32] = Method [85] [86] 
.const [33] = Class [87] 
.const [34] = Field [88] [89] 
.const [35] = InterfaceMethod [90] [91] 
.const [36] = InterfaceMethod [92] [93] 
.const [37] = InterfaceMethod [94] [95] 
.const [38] = InterfaceMethod [96] [97] 
.const [39] = Class [98] 
.const [40] = Class [99] 
.const [41] = Utf8 de/esolutions/fw/comm/core/ServiceInstanceID 
.const [42] = Utf8 '04ffae27-a8b4-4847-ae17-d9c692c6e219' 
.const [43] = Class [100] 
.const [44] = NameAndType [101] [102] 
.const [45] = Utf8 '70c9dba5-1723-5b89-8b9c-0e21ad580cf1' 
.const [46] = Utf8 'asi.diagnosis.mmx2app.MMX2OocDiagService' 
.const [47] = Class [103] 
.const [48] = NameAndType [104] [105] 
.const [49] = Class [106] 
.const [50] = NameAndType [107] [108] 
.const [51] = Utf8 de/esolutions/fw/comm/core/method/MethodException 
.const [52] = Utf8 java/lang/StringBuffer 
.const [53] = Utf8 'Invalid Method Id ' 
.const [54] = Utf8 de/esolutions/fw/util/serializer/exception/SerializerException 
.const [55] = Utf8 'Deserialization failed: method=' 
.const [56] = Utf8 ', error=' 
.const [57] = Utf8 'STUB.asi.diagnosis.mmx2app.MMX2OocDiagService' 
.const [58] = Class [109] 
.const [59] = NameAndType [110] [111] 
.const [60] = Utf8 de/esolutions/fw/comm/asi/diagnosis/mmx2app/impl/MMX2OocDiagServiceReplyService 
.const [61] = Utf8 de/esolutions/fw/comm/core/AbstractReplyService 
.const [62] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [63] = Utf8 de/esolutions/fw/comm/asi/diagnosis/mmx2app/MMX2OocDiagServiceReply 
.const [64] = Utf8 de/esolutions/fw/comm/core/CallContext 
.const [65] = Class [112] 
.const [66] = NameAndType [113] [114] 
.const [67] = Class [115] 
.const [68] = NameAndType [116] [117] 
.const [69] = Class [118] 
.const [70] = NameAndType [119] [120] 
.const [71] = Class [121] 
.const [72] = NameAndType [122] [123] 
.const [73] = Class [124] 
.const [74] = NameAndType [125] [126] 
.const [75] = Class [127] 
.const [76] = NameAndType [128] [129] 
.const [77] = Class [130] 
.const [78] = NameAndType [131] [132] 
.const [79] = Class [133] 
.const [80] = NameAndType [134] [135] 
.const [81] = Class [136] 
.const [82] = NameAndType [137] [138] 
.const [83] = Class [139] 
.const [84] = NameAndType [140] [141] 
.const [85] = Class [142] 
.const [86] = NameAndType [143] [144] 
.const [87] = Utf8 de/esolutions/fw/comm/core/ServiceInstanceID 
.const [88] = Class [145] 
.const [89] = NameAndType [146] [147] 
.const [90] = Class [148] 
.const [91] = NameAndType [149] [150] 
.const [92] = Class [151] 
.const [93] = NameAndType [152] [153] 
.const [94] = Class [154] 
.const [95] = NameAndType [155] [156] 
.const [96] = Class [157] 
.const [97] = NameAndType [158] [159] 
.const [98] = Utf8 de/esolutions/fw/comm/core/method/MethodException 
.const [99] = Utf8 java/lang/StringBuffer 
.const [100] = Utf8 de/esolutions/fw/comm/asi/diagnosis/mmx2app/impl/MMX2OocDiagServiceReplyService 
.const [101] = Utf8 nextDynamicHandle 
.const [102] = Utf8 ()I 
.const [103] = Utf8 de/esolutions/fw/comm/asi/diagnosis/mmx2app/impl/MMX2OocDiagServiceReplyService 
.const [104] = Utf8 dynamicHandle 
.const [105] = Utf8 I 
.const [106] = Utf8 de/esolutions/fw/comm/asi/diagnosis/mmx2app/impl/MMX2OocDiagServiceReplyService 
.const [107] = Utf8 context 
.const [108] = Utf8 Lde/esolutions/fw/comm/core/CallContext; 
.const [109] = Utf8 de/esolutions/fw/comm/core/CallContext 
.const [110] = Utf8 getContext 
.const [111] = Utf8 (Ljava/lang/String;)Lde/esolutions/fw/comm/core/CallContext; 
.const [112] = Utf8 de/esolutions/fw/comm/asi/diagnosis/mmx2app/impl/MMX2OocDiagServiceReplyService 
.const [113] = Utf8 p_MMX2OocDiagServiceReply 
.const [114] = Utf8 Lde/esolutions/fw/comm/asi/diagnosis/mmx2app/MMX2OocDiagServiceReply; 
.const [115] = Utf8 java/lang/StringBuffer 
.const [116] = Utf8 append 
.const [117] = Utf8 (Ljava/lang/String;)Ljava/lang/StringBuffer; 
.const [118] = Utf8 java/lang/StringBuffer 
.const [119] = Utf8 append 
.const [120] = Utf8 (I)Ljava/lang/StringBuffer; 
.const [121] = Utf8 java/lang/StringBuffer 
.const [122] = Utf8 toString 
.const [123] = Utf8 ()Ljava/lang/String; 
.const [124] = Utf8 de/esolutions/fw/util/serializer/exception/SerializerException 
.const [125] = Utf8 getMessage 
.const [126] = Utf8 ()Ljava/lang/String; 
.const [127] = Utf8 de/esolutions/fw/comm/core/ServiceInstanceID 
.const [128] = Utf8 <init> 
.const [129] = Utf8 (Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V 
.const [130] = Utf8 de/esolutions/fw/comm/core/AbstractReplyService 
.const [131] = Utf8 <init> 
.const [132] = Utf8 (Lde/esolutions/fw/comm/core/ServiceInstanceID;)V 
.const [133] = Utf8 de/esolutions/fw/comm/asi/diagnosis/mmx2app/impl/MMX2OocDiagServiceReplyService 
.const [134] = Utf8 dynamicHandle 
.const [135] = Utf8 I 
.const [136] = Utf8 de/esolutions/fw/comm/asi/diagnosis/mmx2app/impl/MMX2OocDiagServiceReplyService 
.const [137] = Utf8 context 
.const [138] = Utf8 Lde/esolutions/fw/comm/core/CallContext; 
.const [139] = Utf8 java/lang/StringBuffer 
.const [140] = Utf8 <init> 
.const [141] = Utf8 ()V 
.const [142] = Utf8 de/esolutions/fw/comm/core/method/MethodException 
.const [143] = Utf8 <init> 
.const [144] = Utf8 (Ljava/lang/String;)V 
.const [145] = Utf8 de/esolutions/fw/comm/asi/diagnosis/mmx2app/impl/MMX2OocDiagServiceReplyService 
.const [146] = Utf8 p_MMX2OocDiagServiceReply 
.const [147] = Utf8 Lde/esolutions/fw/comm/asi/diagnosis/mmx2app/MMX2OocDiagServiceReply; 
.const [148] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [149] = Utf8 getUInt32 
.const [150] = Utf8 ()J 
.const [151] = Utf8 de/esolutions/fw/comm/asi/diagnosis/mmx2app/MMX2OocDiagServiceReply 
.const [152] = Utf8 requestTemperatureMMX 
.const [153] = Utf8 (J)V 
.const [154] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [155] = Utf8 getEnum 
.const [156] = Utf8 ()I 
.const [157] = Utf8 de/esolutions/fw/comm/asi/diagnosis/mmx2app/MMX2OocDiagServiceReply 
.const [158] = Utf8 requestDeleteMemory 
.const [159] = Utf8 (JI)V 
.const [160] = Utf8 de/esolutions/fw/comm/asi/diagnosis/mmx2app/impl/MMX2OocDiagServiceReplyService 
.const [161] = Class [160] 
.const [162] = Utf8 de/esolutions/fw/comm/core/AbstractReplyService 
.const [163] = Class [162] 
.const [164] = Utf8 context 
.const [165] = Utf8 Lde/esolutions/fw/comm/core/CallContext; 
.const [166] = Utf8 dynamicHandle 
.const [167] = Utf8 I 
.const [168] = Utf8 p_MMX2OocDiagServiceReply 
.const [169] = Utf8 Lde/esolutions/fw/comm/asi/diagnosis/mmx2app/MMX2OocDiagServiceReply; 
.const [170] = Utf8 Code 
.const [171] = Utf8 <init> 
.const [172] = Utf8 (Lde/esolutions/fw/comm/asi/diagnosis/mmx2app/MMX2OocDiagServiceReply;)V 
.const [173] = Utf8 nextDynamicHandle 
.const [174] = Utf8 ()I 
.const [175] = Utf8 getCallContext 
.const [176] = Utf8 ()Lde/esolutions/fw/comm/core/CallContext; 
.const [177] = Utf8 handleCallMethod 
.const [178] = Utf8 (SLde/esolutions/fw/util/serializer/IDeserializer;Lde/esolutions/fw/comm/core/IProxyFrontend;)V 
.const [179] = Utf8 <clinit> 
.const [180] = Utf8 ()V 
.end class 
