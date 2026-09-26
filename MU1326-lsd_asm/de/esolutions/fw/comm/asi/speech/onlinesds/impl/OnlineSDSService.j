.version 50 0 
.class public super [179] 
.super [181] 
.field private static final [182] [183] 
.field private [184] [185] 

.method public [187] : [188] 
    .attribute [186] .code stack 7 locals 0 
L0:     aload_0 
L1:     new [34] 
L4:     dup 
L5:     ldc [3] 
L7:     iload_1 
L8:     ldc [4] 
L10:    ldc [5] 
L12:    invokespecial [28] 
L15:    invokespecial [29] 
L18:    aload_0 
L19:    aload_2 
L20:    putfield [35] 
L23:    return 
L24:    
    .end code 
.end method 

.method public [189] : [190] 
    .attribute [186] .code stack 2 locals 0 
L0:     new [36] 
L3:     dup 
L4:     invokespecial [30] 
L7:     areturn 
L8:     
    .end code 
.end method 

.method public [191] : [192] 
    .attribute [186] .code stack 1 locals 0 
L0:     getstatic [7] 
L3:     areturn 
L4:     
    .end code 
.end method 

.method public [193] : [194] 
    .attribute [186] .code stack 5 locals 3 
        .catch [12] from L0 to L203 using L206 
L0:     iload_1 
L1:     tableswitch 13 
            L44 
            L176 
            L176 
            L176 
            L140 
            L68 
            L94 
            default : L176 

L44:    aload_2 
L45:    invokestatic [8] 
L48:    astore 4 
L50:    aload_0 
L51:    getfield [23] 
L54:    aload 4 
L56:    aload_3 
L57:    checkcast [6] 
L60:    invokeinterface [37] 0 
L65:    goto L203 
L68:    aload_2 
L69:    invokeinterface [38] 0 
L74:    istore 4 
L76:    aload_0 
L77:    getfield [23] 
L80:    iload 4 
L82:    aload_3 
L83:    checkcast [6] 
L86:    invokeinterface [39] 0 
L91:    goto L203 
L94:    aload_2 
L95:    invokeinterface [40] 0 
L100:   istore 4 
L102:   aload_2 
L103:   invokeinterface [38] 0 
L108:   istore 5 
L110:   aload_2 
L111:   invokeinterface [41] 0 
L116:   astore 6 
L118:   aload_0 
L119:   getfield [23] 
L122:   iload 4 
L124:   iload 5 
L126:   aload 6 
L128:   aload_3 
L129:   checkcast [6] 
L132:   invokeinterface [42] 0 
L137:   goto L203 
L140:   aload_2 
L141:   invokeinterface [40] 0 
L146:   istore 4 
L148:   aload_2 
L149:   invokeinterface [38] 0 
L154:   istore 5 
L156:   aload_0 
L157:   getfield [23] 
L160:   iload 4 
L162:   iload 5 
L164:   aload_3 
L165:   checkcast [6] 
L168:   invokeinterface [43] 0 
L173:   goto L203 
L176:   new [44] 
L179:   dup 
L180:   new [45] 
L183:   dup 
L184:   invokespecial [32] 
L187:   ldc [11] 
L189:   invokevirtual [24] 
L192:   iload_1 
L193:   invokevirtual [25] 
L196:   invokevirtual [26] 
L199:   invokespecial [33] 
L202:   athrow 
L203:   goto L248 
L206:   astore 4 
L208:   new [44] 
L211:   dup 
L212:   new [45] 
L215:   dup 
L216:   invokespecial [32] 
L219:   ldc [13] 
L221:   invokevirtual [24] 
L224:   iload_1 
L225:   invokevirtual [25] 
L228:   ldc [14] 
L230:   invokevirtual [24] 
L233:   aload 4 
L235:   invokevirtual [27] 
L238:   invokevirtual [24] 
L241:   invokevirtual [26] 
L244:   invokespecial [33] 
L247:   athrow 
L248:   return 
L249:   nop 
L250:   nop 
L251:   nop 
L252:   
    .end code 
.end method 

.method static [195] : [196] 
    .attribute [186] .code stack 1 locals 0 
L0:     ldc [15] 
L2:     invokestatic [16] 
L5:     putstatic [31] 
L8:     return 
L9:     nop 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [46] 
.const [3] = String [47] 
.const [4] = String [48] 
.const [5] = String [49] 
.const [6] = Class [50] 
.const [7] = Field [51] [52] 
.const [8] = Method [53] [54] 
.const [9] = Class [55] 
.const [10] = Class [56] 
.const [11] = String [57] 
.const [12] = Class [58] 
.const [13] = String [59] 
.const [14] = String [60] 
.const [15] = String [61] 
.const [16] = Method [62] [63] 
.const [17] = Class [64] 
.const [18] = Class [65] 
.const [19] = Class [66] 
.const [20] = Class [67] 
.const [21] = Class [68] 
.const [22] = Class [69] 
.const [23] = Field [70] [71] 
.const [24] = Method [72] [73] 
.const [25] = Method [74] [75] 
.const [26] = Method [76] [77] 
.const [27] = Method [78] [79] 
.const [28] = Method [80] [81] 
.const [29] = Method [82] [83] 
.const [30] = Method [84] [85] 
.const [31] = Field [86] [87] 
.const [32] = Method [88] [89] 
.const [33] = Method [90] [91] 
.const [34] = Class [92] 
.const [35] = Field [93] [94] 
.const [36] = Class [95] 
.const [37] = InterfaceMethod [96] [97] 
.const [38] = InterfaceMethod [98] [99] 
.const [39] = InterfaceMethod [100] [101] 
.const [40] = InterfaceMethod [102] [103] 
.const [41] = InterfaceMethod [104] [105] 
.const [42] = InterfaceMethod [106] [107] 
.const [43] = InterfaceMethod [108] [109] 
.const [44] = Class [110] 
.const [45] = Class [111] 
.const [46] = Utf8 de/esolutions/fw/comm/core/ServiceInstanceID 
.const [47] = Utf8 '86a224ed-3f60-4694-8654-b506f378a69d' 
.const [48] = Utf8 '1bb96d8d-568e-522f-a197-4a596ff51e1f' 
.const [49] = Utf8 'asi.speech.onlinesds.OnlineSDS' 
.const [50] = Utf8 de/esolutions/fw/comm/asi/speech/onlinesds/impl/OnlineSDSReplyProxy 
.const [51] = Class [112] 
.const [52] = NameAndType [113] [114] 
.const [53] = Class [115] 
.const [54] = NameAndType [116] [117] 
.const [55] = Utf8 de/esolutions/fw/comm/core/method/MethodException 
.const [56] = Utf8 java/lang/StringBuffer 
.const [57] = Utf8 'Invalid Method Id ' 
.const [58] = Utf8 de/esolutions/fw/util/serializer/exception/SerializerException 
.const [59] = Utf8 'Deserialization failed: method=' 
.const [60] = Utf8 ', error=' 
.const [61] = Utf8 'STUB.asi.speech.onlinesds.OnlineSDS' 
.const [62] = Class [118] 
.const [63] = NameAndType [119] [120] 
.const [64] = Utf8 de/esolutions/fw/comm/asi/speech/onlinesds/impl/OnlineSDSService 
.const [65] = Utf8 de/esolutions/fw/comm/core/AbstractService 
.const [66] = Utf8 de/esolutions/fw/comm/asi/speech/onlinesds/impl/LanguageInfoSerializer 
.const [67] = Utf8 de/esolutions/fw/comm/asi/speech/onlinesds/OnlineSDSS 
.const [68] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [69] = Utf8 de/esolutions/fw/comm/core/CallContext 
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
.const [88] = Class [148] 
.const [89] = NameAndType [149] [150] 
.const [90] = Class [151] 
.const [91] = NameAndType [152] [153] 
.const [92] = Utf8 de/esolutions/fw/comm/core/ServiceInstanceID 
.const [93] = Class [154] 
.const [94] = NameAndType [155] [156] 
.const [95] = Utf8 de/esolutions/fw/comm/asi/speech/onlinesds/impl/OnlineSDSReplyProxy 
.const [96] = Class [157] 
.const [97] = NameAndType [158] [159] 
.const [98] = Class [160] 
.const [99] = NameAndType [161] [162] 
.const [100] = Class [163] 
.const [101] = NameAndType [164] [165] 
.const [102] = Class [166] 
.const [103] = NameAndType [167] [168] 
.const [104] = Class [169] 
.const [105] = NameAndType [170] [171] 
.const [106] = Class [172] 
.const [107] = NameAndType [173] [174] 
.const [108] = Class [175] 
.const [109] = NameAndType [176] [177] 
.const [110] = Utf8 de/esolutions/fw/comm/core/method/MethodException 
.const [111] = Utf8 java/lang/StringBuffer 
.const [112] = Utf8 de/esolutions/fw/comm/asi/speech/onlinesds/impl/OnlineSDSService 
.const [113] = Utf8 context 
.const [114] = Utf8 Lde/esolutions/fw/comm/core/CallContext; 
.const [115] = Utf8 de/esolutions/fw/comm/asi/speech/onlinesds/impl/LanguageInfoSerializer 
.const [116] = Utf8 getOptionalLanguageInfoVarArray 
.const [117] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)[Lde/esolutions/fw/comm/asi/speech/onlinesds/LanguageInfo; 
.const [118] = Utf8 de/esolutions/fw/comm/core/CallContext 
.const [119] = Utf8 getContext 
.const [120] = Utf8 (Ljava/lang/String;)Lde/esolutions/fw/comm/core/CallContext; 
.const [121] = Utf8 de/esolutions/fw/comm/asi/speech/onlinesds/impl/OnlineSDSService 
.const [122] = Utf8 p_OnlineSDS 
.const [123] = Utf8 Lde/esolutions/fw/comm/asi/speech/onlinesds/OnlineSDSS; 
.const [124] = Utf8 java/lang/StringBuffer 
.const [125] = Utf8 append 
.const [126] = Utf8 (Ljava/lang/String;)Ljava/lang/StringBuffer; 
.const [127] = Utf8 java/lang/StringBuffer 
.const [128] = Utf8 append 
.const [129] = Utf8 (I)Ljava/lang/StringBuffer; 
.const [130] = Utf8 java/lang/StringBuffer 
.const [131] = Utf8 toString 
.const [132] = Utf8 ()Ljava/lang/String; 
.const [133] = Utf8 de/esolutions/fw/util/serializer/exception/SerializerException 
.const [134] = Utf8 getMessage 
.const [135] = Utf8 ()Ljava/lang/String; 
.const [136] = Utf8 de/esolutions/fw/comm/core/ServiceInstanceID 
.const [137] = Utf8 <init> 
.const [138] = Utf8 (Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V 
.const [139] = Utf8 de/esolutions/fw/comm/core/AbstractService 
.const [140] = Utf8 <init> 
.const [141] = Utf8 (Lde/esolutions/fw/comm/core/ServiceInstanceID;)V 
.const [142] = Utf8 de/esolutions/fw/comm/asi/speech/onlinesds/impl/OnlineSDSReplyProxy 
.const [143] = Utf8 <init> 
.const [144] = Utf8 ()V 
.const [145] = Utf8 de/esolutions/fw/comm/asi/speech/onlinesds/impl/OnlineSDSService 
.const [146] = Utf8 context 
.const [147] = Utf8 Lde/esolutions/fw/comm/core/CallContext; 
.const [148] = Utf8 java/lang/StringBuffer 
.const [149] = Utf8 <init> 
.const [150] = Utf8 ()V 
.const [151] = Utf8 de/esolutions/fw/comm/core/method/MethodException 
.const [152] = Utf8 <init> 
.const [153] = Utf8 (Ljava/lang/String;)V 
.const [154] = Utf8 de/esolutions/fw/comm/asi/speech/onlinesds/impl/OnlineSDSService 
.const [155] = Utf8 p_OnlineSDS 
.const [156] = Utf8 Lde/esolutions/fw/comm/asi/speech/onlinesds/OnlineSDSS; 
.const [157] = Utf8 de/esolutions/fw/comm/asi/speech/onlinesds/OnlineSDSS 
.const [158] = Utf8 onlineCapabilities 
.const [159] = Utf8 ([Lde/esolutions/fw/comm/asi/speech/onlinesds/LanguageInfo;Lde/esolutions/fw/comm/asi/speech/onlinesds/OnlineSDSReply;)V 
.const [160] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [161] = Utf8 getEnum 
.const [162] = Utf8 ()I 
.const [163] = Utf8 de/esolutions/fw/comm/asi/speech/onlinesds/OnlineSDSS 
.const [164] = Utf8 responseSetLanguage 
.const [165] = Utf8 (ILde/esolutions/fw/comm/asi/speech/onlinesds/OnlineSDSReply;)V 
.const [166] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [167] = Utf8 getUInt16 
.const [168] = Utf8 ()I 
.const [169] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [170] = Utf8 getOptionalString 
.const [171] = Utf8 ()Ljava/lang/String; 
.const [172] = Utf8 de/esolutions/fw/comm/asi/speech/onlinesds/OnlineSDSS 
.const [173] = Utf8 sendOnlineResult 
.const [174] = Utf8 (IILjava/lang/String;Lde/esolutions/fw/comm/asi/speech/onlinesds/OnlineSDSReply;)V 
.const [175] = Utf8 de/esolutions/fw/comm/asi/speech/onlinesds/OnlineSDSS 
.const [176] = Utf8 responseCancel 
.const [177] = Utf8 (IILde/esolutions/fw/comm/asi/speech/onlinesds/OnlineSDSReply;)V 
.const [178] = Utf8 de/esolutions/fw/comm/asi/speech/onlinesds/impl/OnlineSDSService 
.const [179] = Class [178] 
.const [180] = Utf8 de/esolutions/fw/comm/core/AbstractService 
.const [181] = Class [180] 
.const [182] = Utf8 context 
.const [183] = Utf8 Lde/esolutions/fw/comm/core/CallContext; 
.const [184] = Utf8 p_OnlineSDS 
.const [185] = Utf8 Lde/esolutions/fw/comm/asi/speech/onlinesds/OnlineSDSS; 
.const [186] = Utf8 Code 
.const [187] = Utf8 <init> 
.const [188] = Utf8 (ILde/esolutions/fw/comm/asi/speech/onlinesds/OnlineSDSS;)V 
.const [189] = Utf8 createReplyProxy 
.const [190] = Utf8 ()Lde/esolutions/fw/comm/core/IProxyFrontend; 
.const [191] = Utf8 getCallContext 
.const [192] = Utf8 ()Lde/esolutions/fw/comm/core/CallContext; 
.const [193] = Utf8 handleCallMethod 
.const [194] = Utf8 (SLde/esolutions/fw/util/serializer/IDeserializer;Lde/esolutions/fw/comm/core/IProxyFrontend;)V 
.const [195] = Utf8 <clinit> 
.const [196] = Utf8 ()V 
.end class 
