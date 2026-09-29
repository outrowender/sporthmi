.version 50 0 
.class public super [167] 
.super [169] 
.field private static final [170] [171] 
.field private static [172] [173] 
.field private [174] [175] 

.method public [177] : [178] 
    .attribute [176] .code stack 7 locals 0 
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

.method private static synchronized [179] : [180] 
    .attribute [176] .code stack 2 locals 1 
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

.method public [181] : [182] 
    .attribute [176] .code stack 1 locals 0 
L0:     getstatic [8] 
L3:     areturn 
L4:     
    .end code 
.end method 

.method public [183] : [184] 
    .attribute [176] .code stack 6 locals 5 
        .catch [12] from L0 to L129 using L132 
L0:     iload_1 
L1:     lookupswitch 
            1 : L28 
            15 : L50 
            default : L102 

L28:    aload_2 
L29:    invokeinterface [35] 0 
L34:    lstore 4 
L36:    aload_0 
L37:    getfield [22] 
L40:    lload 4 
L42:    invokeinterface [36] 0 
L47:    goto L129 
L50:    aload_2 
L51:    invokeinterface [35] 0 
L56:    lstore 4 
L58:    aload_2 
L59:    invokeinterface [37] 0 
L64:    istore 6 
L66:    aload_2 
L67:    invokeinterface [37] 0 
L72:    istore 7 
L74:    aload_2 
L75:    invokeinterface [38] 0 
L80:    istore 8 
L82:    aload_0 
L83:    getfield [22] 
L86:    lload 4 
L88:    iload 6 
L90:    iload 7 
L92:    iload 8 
L94:    invokeinterface [39] 0 
L99:    goto L129 
L102:   new [40] 
L105:   dup 
L106:   new [41] 
L109:   dup 
L110:   invokespecial [31] 
L113:   ldc [11] 
L115:   invokevirtual [23] 
L118:   iload_1 
L119:   invokevirtual [24] 
L122:   invokevirtual [25] 
L125:   invokespecial [32] 
L128:   athrow 
L129:   goto L174 
L132:   astore 4 
L134:   new [40] 
L137:   dup 
L138:   new [41] 
L141:   dup 
L142:   invokespecial [31] 
L145:   ldc [13] 
L147:   invokevirtual [23] 
L150:   iload_1 
L151:   invokevirtual [24] 
L154:   ldc [14] 
L156:   invokevirtual [23] 
L159:   aload 4 
L161:   invokevirtual [26] 
L164:   invokevirtual [23] 
L167:   invokevirtual [25] 
L170:   invokespecial [32] 
L173:   athrow 
L174:   return 
L175:   nop 
L176:   
    .end code 
.end method 

.method static [185] : [186] 
    .attribute [176] .code stack 1 locals 0 
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
.const [2] = Class [42] 
.const [3] = String [43] 
.const [4] = Method [44] [45] 
.const [5] = String [46] 
.const [6] = String [47] 
.const [7] = Field [48] [49] 
.const [8] = Field [50] [51] 
.const [9] = Class [52] 
.const [10] = Class [53] 
.const [11] = String [54] 
.const [12] = Class [55] 
.const [13] = String [56] 
.const [14] = String [57] 
.const [15] = String [58] 
.const [16] = Method [59] [60] 
.const [17] = Class [61] 
.const [18] = Class [62] 
.const [19] = Class [63] 
.const [20] = Class [64] 
.const [21] = Class [65] 
.const [22] = Field [66] [67] 
.const [23] = Method [68] [69] 
.const [24] = Method [70] [71] 
.const [25] = Method [72] [73] 
.const [26] = Method [74] [75] 
.const [27] = Method [76] [77] 
.const [28] = Method [78] [79] 
.const [29] = Field [80] [81] 
.const [30] = Field [82] [83] 
.const [31] = Method [84] [85] 
.const [32] = Method [86] [87] 
.const [33] = Class [88] 
.const [34] = Field [89] [90] 
.const [35] = InterfaceMethod [91] [92] 
.const [36] = InterfaceMethod [93] [94] 
.const [37] = InterfaceMethod [95] [96] 
.const [38] = InterfaceMethod [97] [98] 
.const [39] = InterfaceMethod [99] [100] 
.const [40] = Class [101] 
.const [41] = Class [102] 
.const [42] = Utf8 de/esolutions/fw/comm/core/ServiceInstanceID 
.const [43] = Utf8 '900f45af-5513-436c-bd60-0747c447c61f' 
.const [44] = Class [103] 
.const [45] = NameAndType [104] [105] 
.const [46] = Utf8 e2f5022d-4f99-5bb8-b4a4-a30a4c93d62a 
.const [47] = Utf8 'asi.diagnosis.mmx2app.MMX2DisplayManagerDiagService' 
.const [48] = Class [106] 
.const [49] = NameAndType [107] [108] 
.const [50] = Class [109] 
.const [51] = NameAndType [110] [111] 
.const [52] = Utf8 de/esolutions/fw/comm/core/method/MethodException 
.const [53] = Utf8 java/lang/StringBuffer 
.const [54] = Utf8 'Invalid Method Id ' 
.const [55] = Utf8 de/esolutions/fw/util/serializer/exception/SerializerException 
.const [56] = Utf8 'Deserialization failed: method=' 
.const [57] = Utf8 ', error=' 
.const [58] = Utf8 'STUB.asi.diagnosis.mmx2app.MMX2DisplayManagerDiagService' 
.const [59] = Class [112] 
.const [60] = NameAndType [113] [114] 
.const [61] = Utf8 de/esolutions/fw/comm/asi/diagnosis/mmx2app/impl/MMX2DisplayManagerDiagServiceReplyService 
.const [62] = Utf8 de/esolutions/fw/comm/core/AbstractReplyService 
.const [63] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [64] = Utf8 de/esolutions/fw/comm/asi/diagnosis/mmx2app/MMX2DisplayManagerDiagServiceReply 
.const [65] = Utf8 de/esolutions/fw/comm/core/CallContext 
.const [66] = Class [115] 
.const [67] = NameAndType [116] [117] 
.const [68] = Class [118] 
.const [69] = NameAndType [119] [120] 
.const [70] = Class [121] 
.const [71] = NameAndType [122] [123] 
.const [72] = Class [124] 
.const [73] = NameAndType [125] [126] 
.const [74] = Class [127] 
.const [75] = NameAndType [128] [129] 
.const [76] = Class [130] 
.const [77] = NameAndType [131] [132] 
.const [78] = Class [133] 
.const [79] = NameAndType [134] [135] 
.const [80] = Class [136] 
.const [81] = NameAndType [137] [138] 
.const [82] = Class [139] 
.const [83] = NameAndType [140] [141] 
.const [84] = Class [142] 
.const [85] = NameAndType [143] [144] 
.const [86] = Class [145] 
.const [87] = NameAndType [146] [147] 
.const [88] = Utf8 de/esolutions/fw/comm/core/ServiceInstanceID 
.const [89] = Class [148] 
.const [90] = NameAndType [149] [150] 
.const [91] = Class [151] 
.const [92] = NameAndType [152] [153] 
.const [93] = Class [154] 
.const [94] = NameAndType [155] [156] 
.const [95] = Class [157] 
.const [96] = NameAndType [158] [159] 
.const [97] = Class [160] 
.const [98] = NameAndType [161] [162] 
.const [99] = Class [163] 
.const [100] = NameAndType [164] [165] 
.const [101] = Utf8 de/esolutions/fw/comm/core/method/MethodException 
.const [102] = Utf8 java/lang/StringBuffer 
.const [103] = Utf8 de/esolutions/fw/comm/asi/diagnosis/mmx2app/impl/MMX2DisplayManagerDiagServiceReplyService 
.const [104] = Utf8 nextDynamicHandle 
.const [105] = Utf8 ()I 
.const [106] = Utf8 de/esolutions/fw/comm/asi/diagnosis/mmx2app/impl/MMX2DisplayManagerDiagServiceReplyService 
.const [107] = Utf8 dynamicHandle 
.const [108] = Utf8 I 
.const [109] = Utf8 de/esolutions/fw/comm/asi/diagnosis/mmx2app/impl/MMX2DisplayManagerDiagServiceReplyService 
.const [110] = Utf8 context 
.const [111] = Utf8 Lde/esolutions/fw/comm/core/CallContext; 
.const [112] = Utf8 de/esolutions/fw/comm/core/CallContext 
.const [113] = Utf8 getContext 
.const [114] = Utf8 (Ljava/lang/String;)Lde/esolutions/fw/comm/core/CallContext; 
.const [115] = Utf8 de/esolutions/fw/comm/asi/diagnosis/mmx2app/impl/MMX2DisplayManagerDiagServiceReplyService 
.const [116] = Utf8 p_MMX2DisplayManagerDiagServiceReply 
.const [117] = Utf8 Lde/esolutions/fw/comm/asi/diagnosis/mmx2app/MMX2DisplayManagerDiagServiceReply; 
.const [118] = Utf8 java/lang/StringBuffer 
.const [119] = Utf8 append 
.const [120] = Utf8 (Ljava/lang/String;)Ljava/lang/StringBuffer; 
.const [121] = Utf8 java/lang/StringBuffer 
.const [122] = Utf8 append 
.const [123] = Utf8 (I)Ljava/lang/StringBuffer; 
.const [124] = Utf8 java/lang/StringBuffer 
.const [125] = Utf8 toString 
.const [126] = Utf8 ()Ljava/lang/String; 
.const [127] = Utf8 de/esolutions/fw/util/serializer/exception/SerializerException 
.const [128] = Utf8 getMessage 
.const [129] = Utf8 ()Ljava/lang/String; 
.const [130] = Utf8 de/esolutions/fw/comm/core/ServiceInstanceID 
.const [131] = Utf8 <init> 
.const [132] = Utf8 (Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V 
.const [133] = Utf8 de/esolutions/fw/comm/core/AbstractReplyService 
.const [134] = Utf8 <init> 
.const [135] = Utf8 (Lde/esolutions/fw/comm/core/ServiceInstanceID;)V 
.const [136] = Utf8 de/esolutions/fw/comm/asi/diagnosis/mmx2app/impl/MMX2DisplayManagerDiagServiceReplyService 
.const [137] = Utf8 dynamicHandle 
.const [138] = Utf8 I 
.const [139] = Utf8 de/esolutions/fw/comm/asi/diagnosis/mmx2app/impl/MMX2DisplayManagerDiagServiceReplyService 
.const [140] = Utf8 context 
.const [141] = Utf8 Lde/esolutions/fw/comm/core/CallContext; 
.const [142] = Utf8 java/lang/StringBuffer 
.const [143] = Utf8 <init> 
.const [144] = Utf8 ()V 
.const [145] = Utf8 de/esolutions/fw/comm/core/method/MethodException 
.const [146] = Utf8 <init> 
.const [147] = Utf8 (Ljava/lang/String;)V 
.const [148] = Utf8 de/esolutions/fw/comm/asi/diagnosis/mmx2app/impl/MMX2DisplayManagerDiagServiceReplyService 
.const [149] = Utf8 p_MMX2DisplayManagerDiagServiceReply 
.const [150] = Utf8 Lde/esolutions/fw/comm/asi/diagnosis/mmx2app/MMX2DisplayManagerDiagServiceReply; 
.const [151] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [152] = Utf8 getUInt32 
.const [153] = Utf8 ()J 
.const [154] = Utf8 de/esolutions/fw/comm/asi/diagnosis/mmx2app/MMX2DisplayManagerDiagServiceReply 
.const [155] = Utf8 requestVideoInputState 
.const [156] = Utf8 (J)V 
.const [157] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [158] = Utf8 getEnum 
.const [159] = Utf8 ()I 
.const [160] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [161] = Utf8 getUInt8 
.const [162] = Utf8 ()S 
.const [163] = Utf8 de/esolutions/fw/comm/asi/diagnosis/mmx2app/MMX2DisplayManagerDiagServiceReply 
.const [164] = Utf8 requestTrunkOfferFBAS 
.const [165] = Utf8 (JIIS)V 
.const [166] = Utf8 de/esolutions/fw/comm/asi/diagnosis/mmx2app/impl/MMX2DisplayManagerDiagServiceReplyService 
.const [167] = Class [166] 
.const [168] = Utf8 de/esolutions/fw/comm/core/AbstractReplyService 
.const [169] = Class [168] 
.const [170] = Utf8 context 
.const [171] = Utf8 Lde/esolutions/fw/comm/core/CallContext; 
.const [172] = Utf8 dynamicHandle 
.const [173] = Utf8 I 
.const [174] = Utf8 p_MMX2DisplayManagerDiagServiceReply 
.const [175] = Utf8 Lde/esolutions/fw/comm/asi/diagnosis/mmx2app/MMX2DisplayManagerDiagServiceReply; 
.const [176] = Utf8 Code 
.const [177] = Utf8 <init> 
.const [178] = Utf8 (Lde/esolutions/fw/comm/asi/diagnosis/mmx2app/MMX2DisplayManagerDiagServiceReply;)V 
.const [179] = Utf8 nextDynamicHandle 
.const [180] = Utf8 ()I 
.const [181] = Utf8 getCallContext 
.const [182] = Utf8 ()Lde/esolutions/fw/comm/core/CallContext; 
.const [183] = Utf8 handleCallMethod 
.const [184] = Utf8 (SLde/esolutions/fw/util/serializer/IDeserializer;Lde/esolutions/fw/comm/core/IProxyFrontend;)V 
.const [185] = Utf8 <clinit> 
.const [186] = Utf8 ()V 
.end class 
