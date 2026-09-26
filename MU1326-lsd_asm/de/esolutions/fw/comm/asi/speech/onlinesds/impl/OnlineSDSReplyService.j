.version 50 0 
.class public super [183] 
.super [185] 
.field private static final [186] [187] 
.field private static [188] [189] 
.field private [190] [191] 

.method public [193] : [194] 
    .attribute [192] .code stack 7 locals 0 
L0:     aload_0 
L1:     new [37] 
L4:     dup 
L5:     ldc [3] 
L7:     invokestatic [4] 
L10:    ldc [5] 
L12:    ldc [6] 
L14:    invokespecial [31] 
L17:    invokespecial [32] 
L20:    aload_0 
L21:    aload_1 
L22:    putfield [38] 
L25:    return 
L26:    nop 
L27:    nop 
L28:    
    .end code 
.end method 

.method private static synchronized [195] : [196] 
    .attribute [192] .code stack 2 locals 1 
L0:     getstatic [7] 
L3:     iconst_1 
L4:     iadd 
L5:     dup 
L6:     putstatic [33] 
L9:     istore_0 
L10:    iload_0 
L11:    areturn 
L12:    
    .end code 
.end method 

.method public [197] : [198] 
    .attribute [192] .code stack 1 locals 0 
L0:     getstatic [8] 
L3:     areturn 
L4:     
    .end code 
.end method 

.method public [199] : [200] 
    .attribute [192] .code stack 4 locals 3 
        .catch [14] from L0 to L145 using L148 
L0:     iload_1 
L1:     lookupswitch 
            16 : L96 
            20 : L36 
            21 : L56 
            default : L118 

L36:    aload_2 
L37:    invokestatic [9] 
L40:    astore 4 
L42:    aload_0 
L43:    getfield [26] 
L46:    aload 4 
L48:    invokeinterface [39] 0 
L53:    goto L145 
L56:    aload_2 
L57:    invokeinterface [40] 0 
L62:    istore 4 
L64:    aload_2 
L65:    invokeinterface [41] 0 
L70:    istore 5 
L72:    aload_2 
L73:    invokestatic [10] 
L76:    astore 6 
L78:    aload_0 
L79:    getfield [26] 
L82:    iload 4 
L84:    iload 5 
L86:    aload 6 
L88:    invokeinterface [42] 0 
L93:    goto L145 
L96:    aload_2 
L97:    invokeinterface [40] 0 
L102:   istore 4 
L104:   aload_0 
L105:   getfield [26] 
L108:   iload 4 
L110:   invokeinterface [43] 0 
L115:   goto L145 
L118:   new [44] 
L121:   dup 
L122:   new [45] 
L125:   dup 
L126:   invokespecial [35] 
L129:   ldc [13] 
L131:   invokevirtual [27] 
L134:   iload_1 
L135:   invokevirtual [28] 
L138:   invokevirtual [29] 
L141:   invokespecial [36] 
L144:   athrow 
L145:   goto L190 
L148:   astore 4 
L150:   new [44] 
L153:   dup 
L154:   new [45] 
L157:   dup 
L158:   invokespecial [35] 
L161:   ldc [15] 
L163:   invokevirtual [27] 
L166:   iload_1 
L167:   invokevirtual [28] 
L170:   ldc [16] 
L172:   invokevirtual [27] 
L175:   aload 4 
L177:   invokevirtual [30] 
L180:   invokevirtual [27] 
L183:   invokevirtual [29] 
L186:   invokespecial [36] 
L189:   athrow 
L190:   return 
L191:   nop 
L192:   
    .end code 
.end method 

.method static [201] : [202] 
    .attribute [192] .code stack 1 locals 0 
L0:     ldc [17] 
L2:     invokestatic [18] 
L5:     putstatic [34] 
L8:     iconst_0 
L9:     putstatic [33] 
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
.const [10] = Method [58] [59] 
.const [11] = Class [60] 
.const [12] = Class [61] 
.const [13] = String [62] 
.const [14] = Class [63] 
.const [15] = String [64] 
.const [16] = String [65] 
.const [17] = String [66] 
.const [18] = Method [67] [68] 
.const [19] = Class [69] 
.const [20] = Class [70] 
.const [21] = Class [71] 
.const [22] = Class [72] 
.const [23] = Class [73] 
.const [24] = Class [74] 
.const [25] = Class [75] 
.const [26] = Field [76] [77] 
.const [27] = Method [78] [79] 
.const [28] = Method [80] [81] 
.const [29] = Method [82] [83] 
.const [30] = Method [84] [85] 
.const [31] = Method [86] [87] 
.const [32] = Method [88] [89] 
.const [33] = Field [90] [91] 
.const [34] = Field [92] [93] 
.const [35] = Method [94] [95] 
.const [36] = Method [96] [97] 
.const [37] = Class [98] 
.const [38] = Field [99] [100] 
.const [39] = InterfaceMethod [101] [102] 
.const [40] = InterfaceMethod [103] [104] 
.const [41] = InterfaceMethod [105] [106] 
.const [42] = InterfaceMethod [107] [108] 
.const [43] = InterfaceMethod [109] [110] 
.const [44] = Class [111] 
.const [45] = Class [112] 
.const [46] = Utf8 de/esolutions/fw/comm/core/ServiceInstanceID 
.const [47] = Utf8 '8a66769b-5812-4288-95b1-6ebd66230a2d' 
.const [48] = Class [113] 
.const [49] = NameAndType [114] [115] 
.const [50] = Utf8 '05e2991f-3978-5b4f-8580-84236c6e9c67' 
.const [51] = Utf8 'asi.speech.onlinesds.OnlineSDS' 
.const [52] = Class [116] 
.const [53] = NameAndType [117] [118] 
.const [54] = Class [119] 
.const [55] = NameAndType [120] [121] 
.const [56] = Class [122] 
.const [57] = NameAndType [123] [124] 
.const [58] = Class [125] 
.const [59] = NameAndType [126] [127] 
.const [60] = Utf8 de/esolutions/fw/comm/core/method/MethodException 
.const [61] = Utf8 java/lang/StringBuffer 
.const [62] = Utf8 'Invalid Method Id ' 
.const [63] = Utf8 de/esolutions/fw/util/serializer/exception/SerializerException 
.const [64] = Utf8 'Deserialization failed: method=' 
.const [65] = Utf8 ', error=' 
.const [66] = Utf8 'STUB.asi.speech.onlinesds.OnlineSDS' 
.const [67] = Class [128] 
.const [68] = NameAndType [129] [130] 
.const [69] = Utf8 de/esolutions/fw/comm/asi/speech/onlinesds/impl/OnlineSDSReplyService 
.const [70] = Utf8 de/esolutions/fw/comm/core/AbstractReplyService 
.const [71] = Utf8 de/esolutions/fw/comm/asi/speech/onlinesds/impl/LanguageInfoSerializer 
.const [72] = Utf8 de/esolutions/fw/comm/asi/speech/onlinesds/OnlineSDSReply 
.const [73] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [74] = Utf8 de/esolutions/fw/comm/asi/speech/onlinesds/impl/AudioDataSerializer 
.const [75] = Utf8 de/esolutions/fw/comm/core/CallContext 
.const [76] = Class [131] 
.const [77] = NameAndType [132] [133] 
.const [78] = Class [134] 
.const [79] = NameAndType [135] [136] 
.const [80] = Class [137] 
.const [81] = NameAndType [138] [139] 
.const [82] = Class [140] 
.const [83] = NameAndType [141] [142] 
.const [84] = Class [143] 
.const [85] = NameAndType [144] [145] 
.const [86] = Class [146] 
.const [87] = NameAndType [147] [148] 
.const [88] = Class [149] 
.const [89] = NameAndType [150] [151] 
.const [90] = Class [152] 
.const [91] = NameAndType [153] [154] 
.const [92] = Class [155] 
.const [93] = NameAndType [156] [157] 
.const [94] = Class [158] 
.const [95] = NameAndType [159] [160] 
.const [96] = Class [161] 
.const [97] = NameAndType [162] [163] 
.const [98] = Utf8 de/esolutions/fw/comm/core/ServiceInstanceID 
.const [99] = Class [164] 
.const [100] = NameAndType [165] [166] 
.const [101] = Class [167] 
.const [102] = NameAndType [168] [169] 
.const [103] = Class [170] 
.const [104] = NameAndType [171] [172] 
.const [105] = Class [173] 
.const [106] = NameAndType [174] [175] 
.const [107] = Class [176] 
.const [108] = NameAndType [177] [178] 
.const [109] = Class [179] 
.const [110] = NameAndType [180] [181] 
.const [111] = Utf8 de/esolutions/fw/comm/core/method/MethodException 
.const [112] = Utf8 java/lang/StringBuffer 
.const [113] = Utf8 de/esolutions/fw/comm/asi/speech/onlinesds/impl/OnlineSDSReplyService 
.const [114] = Utf8 nextDynamicHandle 
.const [115] = Utf8 ()I 
.const [116] = Utf8 de/esolutions/fw/comm/asi/speech/onlinesds/impl/OnlineSDSReplyService 
.const [117] = Utf8 dynamicHandle 
.const [118] = Utf8 I 
.const [119] = Utf8 de/esolutions/fw/comm/asi/speech/onlinesds/impl/OnlineSDSReplyService 
.const [120] = Utf8 context 
.const [121] = Utf8 Lde/esolutions/fw/comm/core/CallContext; 
.const [122] = Utf8 de/esolutions/fw/comm/asi/speech/onlinesds/impl/LanguageInfoSerializer 
.const [123] = Utf8 getOptionalLanguageInfo 
.const [124] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)Lde/esolutions/fw/comm/asi/speech/onlinesds/LanguageInfo; 
.const [125] = Utf8 de/esolutions/fw/comm/asi/speech/onlinesds/impl/AudioDataSerializer 
.const [126] = Utf8 getOptionalAudioData 
.const [127] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)Lde/esolutions/fw/comm/asi/speech/onlinesds/AudioData; 
.const [128] = Utf8 de/esolutions/fw/comm/core/CallContext 
.const [129] = Utf8 getContext 
.const [130] = Utf8 (Ljava/lang/String;)Lde/esolutions/fw/comm/core/CallContext; 
.const [131] = Utf8 de/esolutions/fw/comm/asi/speech/onlinesds/impl/OnlineSDSReplyService 
.const [132] = Utf8 p_OnlineSDSReply 
.const [133] = Utf8 Lde/esolutions/fw/comm/asi/speech/onlinesds/OnlineSDSReply; 
.const [134] = Utf8 java/lang/StringBuffer 
.const [135] = Utf8 append 
.const [136] = Utf8 (Ljava/lang/String;)Ljava/lang/StringBuffer; 
.const [137] = Utf8 java/lang/StringBuffer 
.const [138] = Utf8 append 
.const [139] = Utf8 (I)Ljava/lang/StringBuffer; 
.const [140] = Utf8 java/lang/StringBuffer 
.const [141] = Utf8 toString 
.const [142] = Utf8 ()Ljava/lang/String; 
.const [143] = Utf8 de/esolutions/fw/util/serializer/exception/SerializerException 
.const [144] = Utf8 getMessage 
.const [145] = Utf8 ()Ljava/lang/String; 
.const [146] = Utf8 de/esolutions/fw/comm/core/ServiceInstanceID 
.const [147] = Utf8 <init> 
.const [148] = Utf8 (Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V 
.const [149] = Utf8 de/esolutions/fw/comm/core/AbstractReplyService 
.const [150] = Utf8 <init> 
.const [151] = Utf8 (Lde/esolutions/fw/comm/core/ServiceInstanceID;)V 
.const [152] = Utf8 de/esolutions/fw/comm/asi/speech/onlinesds/impl/OnlineSDSReplyService 
.const [153] = Utf8 dynamicHandle 
.const [154] = Utf8 I 
.const [155] = Utf8 de/esolutions/fw/comm/asi/speech/onlinesds/impl/OnlineSDSReplyService 
.const [156] = Utf8 context 
.const [157] = Utf8 Lde/esolutions/fw/comm/core/CallContext; 
.const [158] = Utf8 java/lang/StringBuffer 
.const [159] = Utf8 <init> 
.const [160] = Utf8 ()V 
.const [161] = Utf8 de/esolutions/fw/comm/core/method/MethodException 
.const [162] = Utf8 <init> 
.const [163] = Utf8 (Ljava/lang/String;)V 
.const [164] = Utf8 de/esolutions/fw/comm/asi/speech/onlinesds/impl/OnlineSDSReplyService 
.const [165] = Utf8 p_OnlineSDSReply 
.const [166] = Utf8 Lde/esolutions/fw/comm/asi/speech/onlinesds/OnlineSDSReply; 
.const [167] = Utf8 de/esolutions/fw/comm/asi/speech/onlinesds/OnlineSDSReply 
.const [168] = Utf8 setLanguage 
.const [169] = Utf8 (Lde/esolutions/fw/comm/asi/speech/onlinesds/LanguageInfo;)V 
.const [170] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [171] = Utf8 getUInt16 
.const [172] = Utf8 ()I 
.const [173] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [174] = Utf8 getEnum 
.const [175] = Utf8 ()I 
.const [176] = Utf8 de/esolutions/fw/comm/asi/speech/onlinesds/OnlineSDSReply 
.const [177] = Utf8 speechDataUpdate 
.const [178] = Utf8 (IILde/esolutions/fw/comm/asi/speech/onlinesds/AudioData;)V 
.const [179] = Utf8 de/esolutions/fw/comm/asi/speech/onlinesds/OnlineSDSReply 
.const [180] = Utf8 cancel 
.const [181] = Utf8 (I)V 
.const [182] = Utf8 de/esolutions/fw/comm/asi/speech/onlinesds/impl/OnlineSDSReplyService 
.const [183] = Class [182] 
.const [184] = Utf8 de/esolutions/fw/comm/core/AbstractReplyService 
.const [185] = Class [184] 
.const [186] = Utf8 context 
.const [187] = Utf8 Lde/esolutions/fw/comm/core/CallContext; 
.const [188] = Utf8 dynamicHandle 
.const [189] = Utf8 I 
.const [190] = Utf8 p_OnlineSDSReply 
.const [191] = Utf8 Lde/esolutions/fw/comm/asi/speech/onlinesds/OnlineSDSReply; 
.const [192] = Utf8 Code 
.const [193] = Utf8 <init> 
.const [194] = Utf8 (Lde/esolutions/fw/comm/asi/speech/onlinesds/OnlineSDSReply;)V 
.const [195] = Utf8 nextDynamicHandle 
.const [196] = Utf8 ()I 
.const [197] = Utf8 getCallContext 
.const [198] = Utf8 ()Lde/esolutions/fw/comm/core/CallContext; 
.const [199] = Utf8 handleCallMethod 
.const [200] = Utf8 (SLde/esolutions/fw/util/serializer/IDeserializer;Lde/esolutions/fw/comm/core/IProxyFrontend;)V 
.const [201] = Utf8 <clinit> 
.const [202] = Utf8 ()V 
.end class 
