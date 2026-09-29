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
    .attribute [196] .code stack 4 locals 3 
        .catch [13] from L0 to L227 using L230 
L0:     iload_1 
L1:     lookupswitch 
            0 : L126 
            10 : L52 
            12 : L168 
            14 : L74 
            15 : L96 
            default : L200 

L52:    aload_2 
L53:    invokeinterface [37] 0 
L58:    istore 4 
L60:    aload_0 
L61:    getfield [24] 
L64:    iload 4 
L66:    invokeinterface [38] 0 
L71:    goto L227 
L74:    aload_2 
L75:    invokeinterface [37] 0 
L80:    istore 4 
L82:    aload_0 
L83:    getfield [24] 
L86:    iload 4 
L88:    invokeinterface [39] 0 
L93:    goto L227 
L96:    aload_2 
L97:    invokestatic [9] 
L100:   astore 4 
L102:   aload_2 
L103:   invokeinterface [37] 0 
L108:   istore 5 
L110:   aload_0 
L111:   getfield [24] 
L114:   aload 4 
L116:   iload 5 
L118:   invokeinterface [40] 0 
L123:   goto L227 
L126:   aload_2 
L127:   invokeinterface [37] 0 
L132:   istore 4 
L134:   aload_2 
L135:   invokeinterface [41] 0 
L140:   astore 5 
L142:   aload_2 
L143:   invokeinterface [37] 0 
L148:   istore 6 
L150:   aload_0 
L151:   getfield [24] 
L154:   iload 4 
L156:   aload 5 
L158:   iload 6 
L160:   invokeinterface [42] 0 
L165:   goto L227 
L168:   aload_2 
L169:   invokeinterface [41] 0 
L174:   astore 4 
L176:   aload_2 
L177:   invokeinterface [41] 0 
L182:   astore 5 
L184:   aload_0 
L185:   getfield [24] 
L188:   aload 4 
L190:   aload 5 
L192:   invokeinterface [43] 0 
L197:   goto L227 
L200:   new [44] 
L203:   dup 
L204:   new [45] 
L207:   dup 
L208:   invokespecial [33] 
L211:   ldc [12] 
L213:   invokevirtual [25] 
L216:   iload_1 
L217:   invokevirtual [26] 
L220:   invokevirtual [27] 
L223:   invokespecial [34] 
L226:   athrow 
L227:   goto L272 
L230:   astore 4 
L232:   new [44] 
L235:   dup 
L236:   new [45] 
L239:   dup 
L240:   invokespecial [33] 
L243:   ldc [14] 
L245:   invokevirtual [25] 
L248:   iload_1 
L249:   invokevirtual [26] 
L252:   ldc [15] 
L254:   invokevirtual [25] 
L257:   aload 4 
L259:   invokevirtual [28] 
L262:   invokevirtual [25] 
L265:   invokevirtual [27] 
L268:   invokespecial [34] 
L271:   athrow 
L272:   return 
L273:   nop 
L274:   nop 
L275:   nop 
L276:   
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
.const [47] = Utf8 '80b0cedf-8e37-5df0-9bdc-e342cb6313d5' 
.const [48] = Class [114] 
.const [49] = NameAndType [115] [116] 
.const [50] = Utf8 '32f55de8-52f0-5d6a-bd2b-055b8f821146' 
.const [51] = Utf8 'dsi.exlap.DSIExlap' 
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
.const [64] = Utf8 'STUB.dsi.exlap.DSIExlap' 
.const [65] = Class [126] 
.const [66] = NameAndType [127] [128] 
.const [67] = Utf8 de/esolutions/fw/comm/dsi/exlap/impl/DSIExlapReplyService 
.const [68] = Utf8 de/esolutions/fw/comm/core/AbstractReplyService 
.const [69] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [70] = Utf8 de/esolutions/fw/comm/dsi/exlap/DSIExlapReply 
.const [71] = Utf8 de/esolutions/fw/comm/dsi/exlap/impl/ServiceSerializer 
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
.const [114] = Utf8 de/esolutions/fw/comm/dsi/exlap/impl/DSIExlapReplyService 
.const [115] = Utf8 nextDynamicHandle 
.const [116] = Utf8 ()I 
.const [117] = Utf8 de/esolutions/fw/comm/dsi/exlap/impl/DSIExlapReplyService 
.const [118] = Utf8 dynamicHandle 
.const [119] = Utf8 I 
.const [120] = Utf8 de/esolutions/fw/comm/dsi/exlap/impl/DSIExlapReplyService 
.const [121] = Utf8 context 
.const [122] = Utf8 Lde/esolutions/fw/comm/core/CallContext; 
.const [123] = Utf8 de/esolutions/fw/comm/dsi/exlap/impl/ServiceSerializer 
.const [124] = Utf8 getOptionalServiceVarArray 
.const [125] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)[Lorg/dsi/ifc/exlap/Service; 
.const [126] = Utf8 de/esolutions/fw/comm/core/CallContext 
.const [127] = Utf8 getContext 
.const [128] = Utf8 (Ljava/lang/String;)Lde/esolutions/fw/comm/core/CallContext; 
.const [129] = Utf8 de/esolutions/fw/comm/dsi/exlap/impl/DSIExlapReplyService 
.const [130] = Utf8 p_DSIExlapReply 
.const [131] = Utf8 Lde/esolutions/fw/comm/dsi/exlap/DSIExlapReply; 
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
.const [150] = Utf8 de/esolutions/fw/comm/dsi/exlap/impl/DSIExlapReplyService 
.const [151] = Utf8 dynamicHandle 
.const [152] = Utf8 I 
.const [153] = Utf8 de/esolutions/fw/comm/dsi/exlap/impl/DSIExlapReplyService 
.const [154] = Utf8 context 
.const [155] = Utf8 Lde/esolutions/fw/comm/core/CallContext; 
.const [156] = Utf8 java/lang/StringBuffer 
.const [157] = Utf8 <init> 
.const [158] = Utf8 ()V 
.const [159] = Utf8 de/esolutions/fw/comm/core/method/MethodException 
.const [160] = Utf8 <init> 
.const [161] = Utf8 (Ljava/lang/String;)V 
.const [162] = Utf8 de/esolutions/fw/comm/dsi/exlap/impl/DSIExlapReplyService 
.const [163] = Utf8 p_DSIExlapReply 
.const [164] = Utf8 Lde/esolutions/fw/comm/dsi/exlap/DSIExlapReply; 
.const [165] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [166] = Utf8 getInt32 
.const [167] = Utf8 ()I 
.const [168] = Utf8 de/esolutions/fw/comm/dsi/exlap/DSIExlapReply 
.const [169] = Utf8 startResult 
.const [170] = Utf8 (I)V 
.const [171] = Utf8 de/esolutions/fw/comm/dsi/exlap/DSIExlapReply 
.const [172] = Utf8 stopResult 
.const [173] = Utf8 (I)V 
.const [174] = Utf8 de/esolutions/fw/comm/dsi/exlap/DSIExlapReply 
.const [175] = Utf8 updateAvailableServices 
.const [176] = Utf8 ([Lorg/dsi/ifc/exlap/Service;I)V 
.const [177] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [178] = Utf8 getOptionalString 
.const [179] = Utf8 ()Ljava/lang/String; 
.const [180] = Utf8 de/esolutions/fw/comm/dsi/exlap/DSIExlapReply 
.const [181] = Utf8 asyncException 
.const [182] = Utf8 (ILjava/lang/String;I)V 
.const [183] = Utf8 de/esolutions/fw/comm/dsi/exlap/DSIExlapReply 
.const [184] = Utf8 yyIndication 
.const [185] = Utf8 (Ljava/lang/String;Ljava/lang/String;)V 
.const [186] = Utf8 de/esolutions/fw/comm/dsi/exlap/impl/DSIExlapReplyService 
.const [187] = Class [186] 
.const [188] = Utf8 de/esolutions/fw/comm/core/AbstractReplyService 
.const [189] = Class [188] 
.const [190] = Utf8 context 
.const [191] = Utf8 Lde/esolutions/fw/comm/core/CallContext; 
.const [192] = Utf8 dynamicHandle 
.const [193] = Utf8 I 
.const [194] = Utf8 p_DSIExlapReply 
.const [195] = Utf8 Lde/esolutions/fw/comm/dsi/exlap/DSIExlapReply; 
.const [196] = Utf8 Code 
.const [197] = Utf8 <init> 
.const [198] = Utf8 (Lde/esolutions/fw/comm/dsi/exlap/DSIExlapReply;)V 
.const [199] = Utf8 nextDynamicHandle 
.const [200] = Utf8 ()I 
.const [201] = Utf8 getCallContext 
.const [202] = Utf8 ()Lde/esolutions/fw/comm/core/CallContext; 
.const [203] = Utf8 handleCallMethod 
.const [204] = Utf8 (SLde/esolutions/fw/util/serializer/IDeserializer;Lde/esolutions/fw/comm/core/IProxyFrontend;)V 
.const [205] = Utf8 <clinit> 
.const [206] = Utf8 ()V 
.end class 
