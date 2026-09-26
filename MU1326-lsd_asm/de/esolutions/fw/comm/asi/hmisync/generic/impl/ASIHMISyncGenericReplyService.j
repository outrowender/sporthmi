.version 50 0 
.class public super [187] 
.super [189] 
.field private static final [190] [191] 
.field private static [192] [193] 
.field private [194] [195] 

.method public [197] : [198] 
    .attribute [196] .code stack 7 locals 0 
L0:     aload_0 
L1:     new [35] 
L4:     dup 
L5:     ldc [3] 
L7:     invokestatic [4] 
L10:    ldc [5] 
L12:    ldc [6] 
L14:    invokespecial [29] 
L17:    invokespecial [30] 
L20:    aload_0 
L21:    aload_1 
L22:    putfield [36] 
L25:    return 
L26:    nop 
L27:    nop 
L28:    
    .end code 
.end method 

.method private static synchronized [199] : [200] 
    .attribute [196] .code stack 2 locals 1 
L0:     getstatic [7] 
L3:     iconst_1 
L4:     iadd 
L5:     dup 
L6:     putstatic [31] 
L9:     istore_0 
L10:    iload_0 
L11:    areturn 
L12:    
    .end code 
.end method 

.method public [201] : [202] 
    .attribute [196] .code stack 1 locals 0 
L0:     getstatic [8] 
L3:     areturn 
L4:     
    .end code 
.end method 

.method public [203] : [204] 
    .attribute [196] .code stack 4 locals 2 
        .catch [13] from L0 to L191 using L194 
L0:     iload_1 
L1:     tableswitch 3 
            L48 
            L164 
            L164 
            L164 
            L164 
            L68 
            L132 
            L100 
            default : L164 

L48:    aload_2 
L49:    invokestatic [9] 
L52:    astore 4 
L54:    aload_0 
L55:    getfield [24] 
L58:    aload 4 
L60:    invokeinterface [37] 0 
L65:    goto L191 
L68:    aload_2 
L69:    invokeinterface [38] 0 
L74:    astore 4 
L76:    aload_2 
L77:    invokeinterface [39] 0 
L82:    istore 5 
L84:    aload_0 
L85:    getfield [24] 
L88:    aload 4 
L90:    iload 5 
L92:    invokeinterface [40] 0 
L97:    goto L191 
L100:   aload_2 
L101:   invokeinterface [41] 0 
L106:   astore 4 
L108:   aload_2 
L109:   invokeinterface [39] 0 
L114:   istore 5 
L116:   aload_0 
L117:   getfield [24] 
L120:   aload 4 
L122:   iload 5 
L124:   invokeinterface [42] 0 
L129:   goto L191 
L132:   aload_2 
L133:   invokeinterface [41] 0 
L138:   astore 4 
L140:   aload_2 
L141:   invokeinterface [39] 0 
L146:   istore 5 
L148:   aload_0 
L149:   getfield [24] 
L152:   aload 4 
L154:   iload 5 
L156:   invokeinterface [43] 0 
L161:   goto L191 
L164:   new [44] 
L167:   dup 
L168:   new [45] 
L171:   dup 
L172:   invokespecial [33] 
L175:   ldc [12] 
L177:   invokevirtual [25] 
L180:   iload_1 
L181:   invokevirtual [26] 
L184:   invokevirtual [27] 
L187:   invokespecial [34] 
L190:   athrow 
L191:   goto L236 
L194:   astore 4 
L196:   new [44] 
L199:   dup 
L200:   new [45] 
L203:   dup 
L204:   invokespecial [33] 
L207:   ldc [14] 
L209:   invokevirtual [25] 
L212:   iload_1 
L213:   invokevirtual [26] 
L216:   ldc [15] 
L218:   invokevirtual [25] 
L221:   aload 4 
L223:   invokevirtual [28] 
L226:   invokevirtual [25] 
L229:   invokevirtual [27] 
L232:   invokespecial [34] 
L235:   athrow 
L236:   return 
L237:   nop 
L238:   nop 
L239:   nop 
L240:   
    .end code 
.end method 

.method static [205] : [206] 
    .attribute [196] .code stack 1 locals 0 
L0:     ldc [16] 
L2:     invokestatic [17] 
L5:     putstatic [32] 
L8:     iconst_0 
L9:     putstatic [31] 
L12:    return 
L13:    nop 
L14:    nop 
L15:    nop 
L16:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [46] 
.const [3] = String [47] 
.const [4] = Method [48] [49] 
.const [5] = String [50] 
.const [6] = String [51] 
.const [7] = Field [52] [53] 
.const [8] = Field [54] [55] 
.const [9] = Method [56] [57] 
.const [10] = Class [58] 
.const [11] = Class [59] 
.const [12] = String [60] 
.const [13] = Class [61] 
.const [14] = String [62] 
.const [15] = String [63] 
.const [16] = String [64] 
.const [17] = Method [65] [66] 
.const [18] = Class [67] 
.const [19] = Class [68] 
.const [20] = Class [69] 
.const [21] = Class [70] 
.const [22] = Class [71] 
.const [23] = Class [72] 
.const [24] = Field [73] [74] 
.const [25] = Method [75] [76] 
.const [26] = Method [77] [78] 
.const [27] = Method [79] [80] 
.const [28] = Method [81] [82] 
.const [29] = Method [83] [84] 
.const [30] = Method [85] [86] 
.const [31] = Field [87] [88] 
.const [32] = Field [89] [90] 
.const [33] = Method [91] [92] 
.const [34] = Method [93] [94] 
.const [35] = Class [95] 
.const [36] = Field [96] [97] 
.const [37] = InterfaceMethod [98] [99] 
.const [38] = InterfaceMethod [100] [101] 
.const [39] = InterfaceMethod [102] [103] 
.const [40] = InterfaceMethod [104] [105] 
.const [41] = InterfaceMethod [106] [107] 
.const [42] = InterfaceMethod [108] [109] 
.const [43] = InterfaceMethod [110] [111] 
.const [44] = Class [112] 
.const [45] = Class [113] 
.const [46] = Utf8 de/esolutions/fw/comm/core/ServiceInstanceID 
.const [47] = Utf8 '8194babf-6beb-418f-bd90-f74b3c21802b' 
.const [48] = Class [114] 
.const [49] = NameAndType [115] [116] 
.const [50] = Utf8 a72d3c71-2310-5bc0-8a73-f82f260b9d4e 
.const [51] = Utf8 'asi.hmisync.generic.ASIHMISyncGeneric' 
.const [52] = Class [117] 
.const [53] = NameAndType [118] [119] 
.const [54] = Class [120] 
.const [55] = NameAndType [121] [122] 
.const [56] = Class [123] 
.const [57] = NameAndType [124] [125] 
.const [58] = Utf8 de/esolutions/fw/comm/core/method/MethodException 
.const [59] = Utf8 java/lang/StringBuffer 
.const [60] = Utf8 'Invalid Method Id ' 
.const [61] = Utf8 de/esolutions/fw/util/serializer/exception/SerializerException 
.const [62] = Utf8 'Deserialization failed: method=' 
.const [63] = Utf8 ', error=' 
.const [64] = Utf8 'STUB.asi.hmisync.generic.ASIHMISyncGeneric' 
.const [65] = Class [126] 
.const [66] = NameAndType [127] [128] 
.const [67] = Utf8 de/esolutions/fw/comm/asi/hmisync/generic/impl/ASIHMISyncGenericReplyService 
.const [68] = Utf8 de/esolutions/fw/comm/core/AbstractReplyService 
.const [69] = Utf8 de/esolutions/fw/comm/asi/hmisync/generic/impl/GenericPacketSerializer 
.const [70] = Utf8 de/esolutions/fw/comm/asi/hmisync/generic/ASIHMISyncGenericReply 
.const [71] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [72] = Utf8 de/esolutions/fw/comm/core/CallContext 
.const [73] = Class [129] 
.const [74] = NameAndType [130] [131] 
.const [75] = Class [132] 
.const [76] = NameAndType [133] [134] 
.const [77] = Class [135] 
.const [78] = NameAndType [136] [137] 
.const [79] = Class [138] 
.const [80] = NameAndType [139] [140] 
.const [81] = Class [141] 
.const [82] = NameAndType [142] [143] 
.const [83] = Class [144] 
.const [84] = NameAndType [145] [146] 
.const [85] = Class [147] 
.const [86] = NameAndType [148] [149] 
.const [87] = Class [150] 
.const [88] = NameAndType [151] [152] 
.const [89] = Class [153] 
.const [90] = NameAndType [154] [155] 
.const [91] = Class [156] 
.const [92] = NameAndType [157] [158] 
.const [93] = Class [159] 
.const [94] = NameAndType [160] [161] 
.const [95] = Utf8 de/esolutions/fw/comm/core/ServiceInstanceID 
.const [96] = Class [162] 
.const [97] = NameAndType [163] [164] 
.const [98] = Class [165] 
.const [99] = NameAndType [166] [167] 
.const [100] = Class [168] 
.const [101] = NameAndType [169] [170] 
.const [102] = Class [171] 
.const [103] = NameAndType [172] [173] 
.const [104] = Class [174] 
.const [105] = NameAndType [175] [176] 
.const [106] = Class [177] 
.const [107] = NameAndType [178] [179] 
.const [108] = Class [180] 
.const [109] = NameAndType [181] [182] 
.const [110] = Class [183] 
.const [111] = NameAndType [184] [185] 
.const [112] = Utf8 de/esolutions/fw/comm/core/method/MethodException 
.const [113] = Utf8 java/lang/StringBuffer 
.const [114] = Utf8 de/esolutions/fw/comm/asi/hmisync/generic/impl/ASIHMISyncGenericReplyService 
.const [115] = Utf8 nextDynamicHandle 
.const [116] = Utf8 ()I 
.const [117] = Utf8 de/esolutions/fw/comm/asi/hmisync/generic/impl/ASIHMISyncGenericReplyService 
.const [118] = Utf8 dynamicHandle 
.const [119] = Utf8 I 
.const [120] = Utf8 de/esolutions/fw/comm/asi/hmisync/generic/impl/ASIHMISyncGenericReplyService 
.const [121] = Utf8 context 
.const [122] = Utf8 Lde/esolutions/fw/comm/core/CallContext; 
.const [123] = Utf8 de/esolutions/fw/comm/asi/hmisync/generic/impl/GenericPacketSerializer 
.const [124] = Utf8 getOptionalGenericPacket 
.const [125] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)Lde/esolutions/fw/comm/asi/hmisync/generic/GenericPacket; 
.const [126] = Utf8 de/esolutions/fw/comm/core/CallContext 
.const [127] = Utf8 getContext 
.const [128] = Utf8 (Ljava/lang/String;)Lde/esolutions/fw/comm/core/CallContext; 
.const [129] = Utf8 de/esolutions/fw/comm/asi/hmisync/generic/impl/ASIHMISyncGenericReplyService 
.const [130] = Utf8 p_ASIHMISyncGenericReply 
.const [131] = Utf8 Lde/esolutions/fw/comm/asi/hmisync/generic/ASIHMISyncGenericReply; 
.const [132] = Utf8 java/lang/StringBuffer 
.const [133] = Utf8 append 
.const [134] = Utf8 (Ljava/lang/String;)Ljava/lang/StringBuffer; 
.const [135] = Utf8 java/lang/StringBuffer 
.const [136] = Utf8 append 
.const [137] = Utf8 (I)Ljava/lang/StringBuffer; 
.const [138] = Utf8 java/lang/StringBuffer 
.const [139] = Utf8 toString 
.const [140] = Utf8 ()Ljava/lang/String; 
.const [141] = Utf8 de/esolutions/fw/util/serializer/exception/SerializerException 
.const [142] = Utf8 getMessage 
.const [143] = Utf8 ()Ljava/lang/String; 
.const [144] = Utf8 de/esolutions/fw/comm/core/ServiceInstanceID 
.const [145] = Utf8 <init> 
.const [146] = Utf8 (Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V 
.const [147] = Utf8 de/esolutions/fw/comm/core/AbstractReplyService 
.const [148] = Utf8 <init> 
.const [149] = Utf8 (Lde/esolutions/fw/comm/core/ServiceInstanceID;)V 
.const [150] = Utf8 de/esolutions/fw/comm/asi/hmisync/generic/impl/ASIHMISyncGenericReplyService 
.const [151] = Utf8 dynamicHandle 
.const [152] = Utf8 I 
.const [153] = Utf8 de/esolutions/fw/comm/asi/hmisync/generic/impl/ASIHMISyncGenericReplyService 
.const [154] = Utf8 context 
.const [155] = Utf8 Lde/esolutions/fw/comm/core/CallContext; 
.const [156] = Utf8 java/lang/StringBuffer 
.const [157] = Utf8 <init> 
.const [158] = Utf8 ()V 
.const [159] = Utf8 de/esolutions/fw/comm/core/method/MethodException 
.const [160] = Utf8 <init> 
.const [161] = Utf8 (Ljava/lang/String;)V 
.const [162] = Utf8 de/esolutions/fw/comm/asi/hmisync/generic/impl/ASIHMISyncGenericReplyService 
.const [163] = Utf8 p_ASIHMISyncGenericReply 
.const [164] = Utf8 Lde/esolutions/fw/comm/asi/hmisync/generic/ASIHMISyncGenericReply; 
.const [165] = Utf8 de/esolutions/fw/comm/asi/hmisync/generic/ASIHMISyncGenericReply 
.const [166] = Utf8 sendDataFromUnit 
.const [167] = Utf8 (Lde/esolutions/fw/comm/asi/hmisync/generic/GenericPacket;)V 
.const [168] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [169] = Utf8 getOptionalString 
.const [170] = Utf8 ()Ljava/lang/String; 
.const [171] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [172] = Utf8 getBool 
.const [173] = Utf8 ()Z 
.const [174] = Utf8 de/esolutions/fw/comm/asi/hmisync/generic/ASIHMISyncGenericReply 
.const [175] = Utf8 updateASIVersion 
.const [176] = Utf8 (Ljava/lang/String;Z)V 
.const [177] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [178] = Utf8 getOptionalInt16VarArray 
.const [179] = Utf8 ()[S 
.const [180] = Utf8 de/esolutions/fw/comm/asi/hmisync/generic/ASIHMISyncGenericReply 
.const [181] = Utf8 updateRequestIDs 
.const [182] = Utf8 ([SZ)V 
.const [183] = Utf8 de/esolutions/fw/comm/asi/hmisync/generic/ASIHMISyncGenericReply 
.const [184] = Utf8 updateReplyIDs 
.const [185] = Utf8 ([SZ)V 
.const [186] = Utf8 de/esolutions/fw/comm/asi/hmisync/generic/impl/ASIHMISyncGenericReplyService 
.const [187] = Class [186] 
.const [188] = Utf8 de/esolutions/fw/comm/core/AbstractReplyService 
.const [189] = Class [188] 
.const [190] = Utf8 context 
.const [191] = Utf8 Lde/esolutions/fw/comm/core/CallContext; 
.const [192] = Utf8 dynamicHandle 
.const [193] = Utf8 I 
.const [194] = Utf8 p_ASIHMISyncGenericReply 
.const [195] = Utf8 Lde/esolutions/fw/comm/asi/hmisync/generic/ASIHMISyncGenericReply; 
.const [196] = Utf8 Code 
.const [197] = Utf8 <init> 
.const [198] = Utf8 (Lde/esolutions/fw/comm/asi/hmisync/generic/ASIHMISyncGenericReply;)V 
.const [199] = Utf8 nextDynamicHandle 
.const [200] = Utf8 ()I 
.const [201] = Utf8 getCallContext 
.const [202] = Utf8 ()Lde/esolutions/fw/comm/core/CallContext; 
.const [203] = Utf8 handleCallMethod 
.const [204] = Utf8 (SLde/esolutions/fw/util/serializer/IDeserializer;Lde/esolutions/fw/comm/core/IProxyFrontend;)V 
.const [205] = Utf8 <clinit> 
.const [206] = Utf8 ()V 
.end class 
