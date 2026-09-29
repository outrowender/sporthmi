.version 50 0 
.class public super [155] 
.super [157] 
.field private static final [158] [159] 
.field private static [160] [161] 
.field private [162] [163] 

.method public [165] : [166] 
    .attribute [164] .code stack 7 locals 0 
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

.method private static synchronized [167] : [168] 
    .attribute [164] .code stack 2 locals 1 
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

.method public [169] : [170] 
    .attribute [164] .code stack 1 locals 0 
L0:     getstatic [8] 
L3:     areturn 
L4:     
    .end code 
.end method 

.method public [171] : [172] 
    .attribute [164] .code stack 4 locals 2 
        .catch [12] from L0 to L99 using L102 
L0:     iload_1 
L1:     lookupswitch 
            0 : L50 
            1 : L28 
            default : L72 

L28:    aload_2 
L29:    invokeinterface [35] 0 
L34:    lstore 4 
L36:    aload_0 
L37:    getfield [22] 
L40:    lload 4 
L42:    invokeinterface [36] 0 
L47:    goto L99 
L50:    aload_2 
L51:    invokeinterface [35] 0 
L56:    lstore 4 
L58:    aload_0 
L59:    getfield [22] 
L62:    lload 4 
L64:    invokeinterface [37] 0 
L69:    goto L99 
L72:    new [38] 
L75:    dup 
L76:    new [39] 
L79:    dup 
L80:    invokespecial [31] 
L83:    ldc [11] 
L85:    invokevirtual [23] 
L88:    iload_1 
L89:    invokevirtual [24] 
L92:    invokevirtual [25] 
L95:    invokespecial [32] 
L98:    athrow 
L99:    goto L144 
L102:   astore 4 
L104:   new [38] 
L107:   dup 
L108:   new [39] 
L111:   dup 
L112:   invokespecial [31] 
L115:   ldc [13] 
L117:   invokevirtual [23] 
L120:   iload_1 
L121:   invokevirtual [24] 
L124:   ldc [14] 
L126:   invokevirtual [23] 
L129:   aload 4 
L131:   invokevirtual [26] 
L134:   invokevirtual [23] 
L137:   invokevirtual [25] 
L140:   invokespecial [32] 
L143:   athrow 
L144:   return 
L145:   nop 
L146:   nop 
L147:   nop 
L148:   
    .end code 
.end method 

.method static [173] : [174] 
    .attribute [164] .code stack 1 locals 0 
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
.const [2] = Class [40] 
.const [3] = String [41] 
.const [4] = Method [42] [43] 
.const [5] = String [44] 
.const [6] = String [45] 
.const [7] = Field [46] [47] 
.const [8] = Field [48] [49] 
.const [9] = Class [50] 
.const [10] = Class [51] 
.const [11] = String [52] 
.const [12] = Class [53] 
.const [13] = String [54] 
.const [14] = String [55] 
.const [15] = String [56] 
.const [16] = Method [57] [58] 
.const [17] = Class [59] 
.const [18] = Class [60] 
.const [19] = Class [61] 
.const [20] = Class [62] 
.const [21] = Class [63] 
.const [22] = Field [64] [65] 
.const [23] = Method [66] [67] 
.const [24] = Method [68] [69] 
.const [25] = Method [70] [71] 
.const [26] = Method [72] [73] 
.const [27] = Method [74] [75] 
.const [28] = Method [76] [77] 
.const [29] = Field [78] [79] 
.const [30] = Field [80] [81] 
.const [31] = Method [82] [83] 
.const [32] = Method [84] [85] 
.const [33] = Class [86] 
.const [34] = Field [87] [88] 
.const [35] = InterfaceMethod [89] [90] 
.const [36] = InterfaceMethod [91] [92] 
.const [37] = InterfaceMethod [93] [94] 
.const [38] = Class [95] 
.const [39] = Class [96] 
.const [40] = Utf8 de/esolutions/fw/comm/core/ServiceInstanceID 
.const [41] = Utf8 '415815e1-22dc-44f2-8c3e-cc8470ffeaf7' 
.const [42] = Class [97] 
.const [43] = NameAndType [98] [99] 
.const [44] = Utf8 '612a308a-aae1-5fc9-a4d8-fa53e3ea8080' 
.const [45] = Utf8 'asi.diagnosis.mmx2app.MMX2OlsDiagService' 
.const [46] = Class [100] 
.const [47] = NameAndType [101] [102] 
.const [48] = Class [103] 
.const [49] = NameAndType [104] [105] 
.const [50] = Utf8 de/esolutions/fw/comm/core/method/MethodException 
.const [51] = Utf8 java/lang/StringBuffer 
.const [52] = Utf8 'Invalid Method Id ' 
.const [53] = Utf8 de/esolutions/fw/util/serializer/exception/SerializerException 
.const [54] = Utf8 'Deserialization failed: method=' 
.const [55] = Utf8 ', error=' 
.const [56] = Utf8 'STUB.asi.diagnosis.mmx2app.MMX2OlsDiagService' 
.const [57] = Class [106] 
.const [58] = NameAndType [107] [108] 
.const [59] = Utf8 de/esolutions/fw/comm/asi/diagnosis/mmx2app/impl/MMX2OlsDiagServiceReplyService 
.const [60] = Utf8 de/esolutions/fw/comm/core/AbstractReplyService 
.const [61] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [62] = Utf8 de/esolutions/fw/comm/asi/diagnosis/mmx2app/MMX2OlsDiagServiceReply 
.const [63] = Utf8 de/esolutions/fw/comm/core/CallContext 
.const [64] = Class [109] 
.const [65] = NameAndType [110] [111] 
.const [66] = Class [112] 
.const [67] = NameAndType [113] [114] 
.const [68] = Class [115] 
.const [69] = NameAndType [116] [117] 
.const [70] = Class [118] 
.const [71] = NameAndType [119] [120] 
.const [72] = Class [121] 
.const [73] = NameAndType [122] [123] 
.const [74] = Class [124] 
.const [75] = NameAndType [125] [126] 
.const [76] = Class [127] 
.const [77] = NameAndType [128] [129] 
.const [78] = Class [130] 
.const [79] = NameAndType [131] [132] 
.const [80] = Class [133] 
.const [81] = NameAndType [134] [135] 
.const [82] = Class [136] 
.const [83] = NameAndType [137] [138] 
.const [84] = Class [139] 
.const [85] = NameAndType [140] [141] 
.const [86] = Utf8 de/esolutions/fw/comm/core/ServiceInstanceID 
.const [87] = Class [142] 
.const [88] = NameAndType [143] [144] 
.const [89] = Class [145] 
.const [90] = NameAndType [146] [147] 
.const [91] = Class [148] 
.const [92] = NameAndType [149] [150] 
.const [93] = Class [151] 
.const [94] = NameAndType [152] [153] 
.const [95] = Utf8 de/esolutions/fw/comm/core/method/MethodException 
.const [96] = Utf8 java/lang/StringBuffer 
.const [97] = Utf8 de/esolutions/fw/comm/asi/diagnosis/mmx2app/impl/MMX2OlsDiagServiceReplyService 
.const [98] = Utf8 nextDynamicHandle 
.const [99] = Utf8 ()I 
.const [100] = Utf8 de/esolutions/fw/comm/asi/diagnosis/mmx2app/impl/MMX2OlsDiagServiceReplyService 
.const [101] = Utf8 dynamicHandle 
.const [102] = Utf8 I 
.const [103] = Utf8 de/esolutions/fw/comm/asi/diagnosis/mmx2app/impl/MMX2OlsDiagServiceReplyService 
.const [104] = Utf8 context 
.const [105] = Utf8 Lde/esolutions/fw/comm/core/CallContext; 
.const [106] = Utf8 de/esolutions/fw/comm/core/CallContext 
.const [107] = Utf8 getContext 
.const [108] = Utf8 (Ljava/lang/String;)Lde/esolutions/fw/comm/core/CallContext; 
.const [109] = Utf8 de/esolutions/fw/comm/asi/diagnosis/mmx2app/impl/MMX2OlsDiagServiceReplyService 
.const [110] = Utf8 p_MMX2OlsDiagServiceReply 
.const [111] = Utf8 Lde/esolutions/fw/comm/asi/diagnosis/mmx2app/MMX2OlsDiagServiceReply; 
.const [112] = Utf8 java/lang/StringBuffer 
.const [113] = Utf8 append 
.const [114] = Utf8 (Ljava/lang/String;)Ljava/lang/StringBuffer; 
.const [115] = Utf8 java/lang/StringBuffer 
.const [116] = Utf8 append 
.const [117] = Utf8 (I)Ljava/lang/StringBuffer; 
.const [118] = Utf8 java/lang/StringBuffer 
.const [119] = Utf8 toString 
.const [120] = Utf8 ()Ljava/lang/String; 
.const [121] = Utf8 de/esolutions/fw/util/serializer/exception/SerializerException 
.const [122] = Utf8 getMessage 
.const [123] = Utf8 ()Ljava/lang/String; 
.const [124] = Utf8 de/esolutions/fw/comm/core/ServiceInstanceID 
.const [125] = Utf8 <init> 
.const [126] = Utf8 (Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V 
.const [127] = Utf8 de/esolutions/fw/comm/core/AbstractReplyService 
.const [128] = Utf8 <init> 
.const [129] = Utf8 (Lde/esolutions/fw/comm/core/ServiceInstanceID;)V 
.const [130] = Utf8 de/esolutions/fw/comm/asi/diagnosis/mmx2app/impl/MMX2OlsDiagServiceReplyService 
.const [131] = Utf8 dynamicHandle 
.const [132] = Utf8 I 
.const [133] = Utf8 de/esolutions/fw/comm/asi/diagnosis/mmx2app/impl/MMX2OlsDiagServiceReplyService 
.const [134] = Utf8 context 
.const [135] = Utf8 Lde/esolutions/fw/comm/core/CallContext; 
.const [136] = Utf8 java/lang/StringBuffer 
.const [137] = Utf8 <init> 
.const [138] = Utf8 ()V 
.const [139] = Utf8 de/esolutions/fw/comm/core/method/MethodException 
.const [140] = Utf8 <init> 
.const [141] = Utf8 (Ljava/lang/String;)V 
.const [142] = Utf8 de/esolutions/fw/comm/asi/diagnosis/mmx2app/impl/MMX2OlsDiagServiceReplyService 
.const [143] = Utf8 p_MMX2OlsDiagServiceReply 
.const [144] = Utf8 Lde/esolutions/fw/comm/asi/diagnosis/mmx2app/MMX2OlsDiagServiceReply; 
.const [145] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [146] = Utf8 getUInt32 
.const [147] = Utf8 ()J 
.const [148] = Utf8 de/esolutions/fw/comm/asi/diagnosis/mmx2app/MMX2OlsDiagServiceReply 
.const [149] = Utf8 requestConnectionState 
.const [150] = Utf8 (J)V 
.const [151] = Utf8 de/esolutions/fw/comm/asi/diagnosis/mmx2app/MMX2OlsDiagServiceReply 
.const [152] = Utf8 requestActivationState 
.const [153] = Utf8 (J)V 
.const [154] = Utf8 de/esolutions/fw/comm/asi/diagnosis/mmx2app/impl/MMX2OlsDiagServiceReplyService 
.const [155] = Class [154] 
.const [156] = Utf8 de/esolutions/fw/comm/core/AbstractReplyService 
.const [157] = Class [156] 
.const [158] = Utf8 context 
.const [159] = Utf8 Lde/esolutions/fw/comm/core/CallContext; 
.const [160] = Utf8 dynamicHandle 
.const [161] = Utf8 I 
.const [162] = Utf8 p_MMX2OlsDiagServiceReply 
.const [163] = Utf8 Lde/esolutions/fw/comm/asi/diagnosis/mmx2app/MMX2OlsDiagServiceReply; 
.const [164] = Utf8 Code 
.const [165] = Utf8 <init> 
.const [166] = Utf8 (Lde/esolutions/fw/comm/asi/diagnosis/mmx2app/MMX2OlsDiagServiceReply;)V 
.const [167] = Utf8 nextDynamicHandle 
.const [168] = Utf8 ()I 
.const [169] = Utf8 getCallContext 
.const [170] = Utf8 ()Lde/esolutions/fw/comm/core/CallContext; 
.const [171] = Utf8 handleCallMethod 
.const [172] = Utf8 (SLde/esolutions/fw/util/serializer/IDeserializer;Lde/esolutions/fw/comm/core/IProxyFrontend;)V 
.const [173] = Utf8 <clinit> 
.const [174] = Utf8 ()V 
.end class 
