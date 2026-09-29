.version 50 0 
.class public super [179] 
.super [181] 
.field private static final [182] [183] 
.field private static [184] [185] 
.field private [186] [187] 

.method public [189] : [190] 
    .attribute [188] .code stack 7 locals 0 
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

.method private static synchronized [191] : [192] 
    .attribute [188] .code stack 2 locals 1 
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

.method public [193] : [194] 
    .attribute [188] .code stack 1 locals 0 
L0:     getstatic [8] 
L3:     areturn 
L4:     
    .end code 
.end method 

.method public [195] : [196] 
    .attribute [188] .code stack 4 locals 3 
        .catch [12] from L0 to L187 using L190 
L0:     iload_1 
L1:     tableswitch 9 
            L86 
            L64 
            L32 
            L128 
            default : L160 

L32:    aload_2 
L33:    invokeinterface [35] 0 
L38:    istore 4 
L40:    aload_2 
L41:    invokeinterface [36] 0 
L46:    astore 5 
L48:    aload_0 
L49:    getfield [22] 
L52:    iload 4 
L54:    aload 5 
L56:    invokeinterface [37] 0 
L61:    goto L187 
L64:    aload_2 
L65:    invokeinterface [35] 0 
L70:    istore 4 
L72:    aload_0 
L73:    getfield [22] 
L76:    iload 4 
L78:    invokeinterface [38] 0 
L83:    goto L187 
L86:    aload_2 
L87:    invokeinterface [35] 0 
L92:    istore 4 
L94:    aload_2 
L95:    invokeinterface [39] 0 
L100:   astore 5 
L102:   aload_2 
L103:   invokeinterface [35] 0 
L108:   istore 6 
L110:   aload_0 
L111:   getfield [22] 
L114:   iload 4 
L116:   aload 5 
L118:   iload 6 
L120:   invokeinterface [40] 0 
L125:   goto L187 
L128:   aload_2 
L129:   invokeinterface [39] 0 
L134:   astore 4 
L136:   aload_2 
L137:   invokeinterface [39] 0 
L142:   astore 5 
L144:   aload_0 
L145:   getfield [22] 
L148:   aload 4 
L150:   aload 5 
L152:   invokeinterface [41] 0 
L157:   goto L187 
L160:   new [42] 
L163:   dup 
L164:   new [43] 
L167:   dup 
L168:   invokespecial [31] 
L171:   ldc [11] 
L173:   invokevirtual [23] 
L176:   iload_1 
L177:   invokevirtual [24] 
L180:   invokevirtual [25] 
L183:   invokespecial [32] 
L186:   athrow 
L187:   goto L232 
L190:   astore 4 
L192:   new [42] 
L195:   dup 
L196:   new [43] 
L199:   dup 
L200:   invokespecial [31] 
L203:   ldc [13] 
L205:   invokevirtual [23] 
L208:   iload_1 
L209:   invokevirtual [24] 
L212:   ldc [14] 
L214:   invokevirtual [23] 
L217:   aload 4 
L219:   invokevirtual [26] 
L222:   invokevirtual [23] 
L225:   invokevirtual [25] 
L228:   invokespecial [32] 
L231:   athrow 
L232:   return 
L233:   nop 
L234:   nop 
L235:   nop 
L236:   
    .end code 
.end method 

.method static [197] : [198] 
    .attribute [188] .code stack 1 locals 0 
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
.const [2] = Class [44] 
.const [3] = String [45] 
.const [4] = Method [46] [47] 
.const [5] = String [48] 
.const [6] = String [49] 
.const [7] = Field [50] [51] 
.const [8] = Field [52] [53] 
.const [9] = Class [54] 
.const [10] = Class [55] 
.const [11] = String [56] 
.const [12] = Class [57] 
.const [13] = String [58] 
.const [14] = String [59] 
.const [15] = String [60] 
.const [16] = Method [61] [62] 
.const [17] = Class [63] 
.const [18] = Class [64] 
.const [19] = Class [65] 
.const [20] = Class [66] 
.const [21] = Class [67] 
.const [22] = Field [68] [69] 
.const [23] = Method [70] [71] 
.const [24] = Method [72] [73] 
.const [25] = Method [74] [75] 
.const [26] = Method [76] [77] 
.const [27] = Method [78] [79] 
.const [28] = Method [80] [81] 
.const [29] = Field [82] [83] 
.const [30] = Field [84] [85] 
.const [31] = Method [86] [87] 
.const [32] = Method [88] [89] 
.const [33] = Class [90] 
.const [34] = Field [91] [92] 
.const [35] = InterfaceMethod [93] [94] 
.const [36] = InterfaceMethod [95] [96] 
.const [37] = InterfaceMethod [97] [98] 
.const [38] = InterfaceMethod [99] [100] 
.const [39] = InterfaceMethod [101] [102] 
.const [40] = InterfaceMethod [103] [104] 
.const [41] = InterfaceMethod [105] [106] 
.const [42] = Class [107] 
.const [43] = Class [108] 
.const [44] = Utf8 de/esolutions/fw/comm/core/ServiceInstanceID 
.const [45] = Utf8 d52e8b7b-22d1-582c-a00a-2d5a5a40ce7c 
.const [46] = Class [109] 
.const [47] = NameAndType [110] [111] 
.const [48] = Utf8 '803e4a60-f8b0-5229-839b-b430e08ede41' 
.const [49] = Utf8 'dsi.organizer.DSIAdbSds' 
.const [50] = Class [112] 
.const [51] = NameAndType [113] [114] 
.const [52] = Class [115] 
.const [53] = NameAndType [116] [117] 
.const [54] = Utf8 de/esolutions/fw/comm/core/method/MethodException 
.const [55] = Utf8 java/lang/StringBuffer 
.const [56] = Utf8 'Invalid Method Id ' 
.const [57] = Utf8 de/esolutions/fw/util/serializer/exception/SerializerException 
.const [58] = Utf8 'Deserialization failed: method=' 
.const [59] = Utf8 ', error=' 
.const [60] = Utf8 'STUB.dsi.organizer.DSIAdbSds' 
.const [61] = Class [118] 
.const [62] = NameAndType [119] [120] 
.const [63] = Utf8 de/esolutions/fw/comm/dsi/organizer/impl/DSIAdbSdsReplyService 
.const [64] = Utf8 de/esolutions/fw/comm/core/AbstractReplyService 
.const [65] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [66] = Utf8 de/esolutions/fw/comm/dsi/organizer/DSIAdbSdsReply 
.const [67] = Utf8 de/esolutions/fw/comm/core/CallContext 
.const [68] = Class [121] 
.const [69] = NameAndType [122] [123] 
.const [70] = Class [124] 
.const [71] = NameAndType [125] [126] 
.const [72] = Class [127] 
.const [73] = NameAndType [128] [129] 
.const [74] = Class [130] 
.const [75] = NameAndType [131] [132] 
.const [76] = Class [133] 
.const [77] = NameAndType [134] [135] 
.const [78] = Class [136] 
.const [79] = NameAndType [137] [138] 
.const [80] = Class [139] 
.const [81] = NameAndType [140] [141] 
.const [82] = Class [142] 
.const [83] = NameAndType [143] [144] 
.const [84] = Class [145] 
.const [85] = NameAndType [146] [147] 
.const [86] = Class [148] 
.const [87] = NameAndType [149] [150] 
.const [88] = Class [151] 
.const [89] = NameAndType [152] [153] 
.const [90] = Utf8 de/esolutions/fw/comm/core/ServiceInstanceID 
.const [91] = Class [154] 
.const [92] = NameAndType [155] [156] 
.const [93] = Class [157] 
.const [94] = NameAndType [158] [159] 
.const [95] = Class [160] 
.const [96] = NameAndType [161] [162] 
.const [97] = Class [163] 
.const [98] = NameAndType [164] [165] 
.const [99] = Class [166] 
.const [100] = NameAndType [167] [168] 
.const [101] = Class [169] 
.const [102] = NameAndType [170] [171] 
.const [103] = Class [172] 
.const [104] = NameAndType [173] [174] 
.const [105] = Class [175] 
.const [106] = NameAndType [176] [177] 
.const [107] = Utf8 de/esolutions/fw/comm/core/method/MethodException 
.const [108] = Utf8 java/lang/StringBuffer 
.const [109] = Utf8 de/esolutions/fw/comm/dsi/organizer/impl/DSIAdbSdsReplyService 
.const [110] = Utf8 nextDynamicHandle 
.const [111] = Utf8 ()I 
.const [112] = Utf8 de/esolutions/fw/comm/dsi/organizer/impl/DSIAdbSdsReplyService 
.const [113] = Utf8 dynamicHandle 
.const [114] = Utf8 I 
.const [115] = Utf8 de/esolutions/fw/comm/dsi/organizer/impl/DSIAdbSdsReplyService 
.const [116] = Utf8 context 
.const [117] = Utf8 Lde/esolutions/fw/comm/core/CallContext; 
.const [118] = Utf8 de/esolutions/fw/comm/core/CallContext 
.const [119] = Utf8 getContext 
.const [120] = Utf8 (Ljava/lang/String;)Lde/esolutions/fw/comm/core/CallContext; 
.const [121] = Utf8 de/esolutions/fw/comm/dsi/organizer/impl/DSIAdbSdsReplyService 
.const [122] = Utf8 p_DSIAdbSdsReply 
.const [123] = Utf8 Lde/esolutions/fw/comm/dsi/organizer/DSIAdbSdsReply; 
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
.const [139] = Utf8 de/esolutions/fw/comm/core/AbstractReplyService 
.const [140] = Utf8 <init> 
.const [141] = Utf8 (Lde/esolutions/fw/comm/core/ServiceInstanceID;)V 
.const [142] = Utf8 de/esolutions/fw/comm/dsi/organizer/impl/DSIAdbSdsReplyService 
.const [143] = Utf8 dynamicHandle 
.const [144] = Utf8 I 
.const [145] = Utf8 de/esolutions/fw/comm/dsi/organizer/impl/DSIAdbSdsReplyService 
.const [146] = Utf8 context 
.const [147] = Utf8 Lde/esolutions/fw/comm/core/CallContext; 
.const [148] = Utf8 java/lang/StringBuffer 
.const [149] = Utf8 <init> 
.const [150] = Utf8 ()V 
.const [151] = Utf8 de/esolutions/fw/comm/core/method/MethodException 
.const [152] = Utf8 <init> 
.const [153] = Utf8 (Ljava/lang/String;)V 
.const [154] = Utf8 de/esolutions/fw/comm/dsi/organizer/impl/DSIAdbSdsReplyService 
.const [155] = Utf8 p_DSIAdbSdsReply 
.const [156] = Utf8 Lde/esolutions/fw/comm/dsi/organizer/DSIAdbSdsReply; 
.const [157] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [158] = Utf8 getInt32 
.const [159] = Utf8 ()I 
.const [160] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [161] = Utf8 getOptionalInt32VarArray 
.const [162] = Utf8 ()[I 
.const [163] = Utf8 de/esolutions/fw/comm/dsi/organizer/DSIAdbSdsReply 
.const [164] = Utf8 getAllVoiceTagsResult 
.const [165] = Utf8 (I[I)V 
.const [166] = Utf8 de/esolutions/fw/comm/dsi/organizer/DSIAdbSdsReply 
.const [167] = Utf8 deleteVoiceTagsResult 
.const [168] = Utf8 (I)V 
.const [169] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [170] = Utf8 getOptionalString 
.const [171] = Utf8 ()Ljava/lang/String; 
.const [172] = Utf8 de/esolutions/fw/comm/dsi/organizer/DSIAdbSdsReply 
.const [173] = Utf8 asyncException 
.const [174] = Utf8 (ILjava/lang/String;I)V 
.const [175] = Utf8 de/esolutions/fw/comm/dsi/organizer/DSIAdbSdsReply 
.const [176] = Utf8 yyIndication 
.const [177] = Utf8 (Ljava/lang/String;Ljava/lang/String;)V 
.const [178] = Utf8 de/esolutions/fw/comm/dsi/organizer/impl/DSIAdbSdsReplyService 
.const [179] = Class [178] 
.const [180] = Utf8 de/esolutions/fw/comm/core/AbstractReplyService 
.const [181] = Class [180] 
.const [182] = Utf8 context 
.const [183] = Utf8 Lde/esolutions/fw/comm/core/CallContext; 
.const [184] = Utf8 dynamicHandle 
.const [185] = Utf8 I 
.const [186] = Utf8 p_DSIAdbSdsReply 
.const [187] = Utf8 Lde/esolutions/fw/comm/dsi/organizer/DSIAdbSdsReply; 
.const [188] = Utf8 Code 
.const [189] = Utf8 <init> 
.const [190] = Utf8 (Lde/esolutions/fw/comm/dsi/organizer/DSIAdbSdsReply;)V 
.const [191] = Utf8 nextDynamicHandle 
.const [192] = Utf8 ()I 
.const [193] = Utf8 getCallContext 
.const [194] = Utf8 ()Lde/esolutions/fw/comm/core/CallContext; 
.const [195] = Utf8 handleCallMethod 
.const [196] = Utf8 (SLde/esolutions/fw/util/serializer/IDeserializer;Lde/esolutions/fw/comm/core/IProxyFrontend;)V 
.const [197] = Utf8 <clinit> 
.const [198] = Utf8 ()V 
.end class 
