.version 50 0 
.class public super [207] 
.super [209] 
.field private static final [210] [211] 
.field private [212] [213] 

.method public [215] : [216] 
    .attribute [214] .code stack 7 locals 0 
L0:     aload_0 
L1:     new [32] 
L4:     dup 
L5:     ldc [3] 
L7:     iload_1 
L8:     ldc [4] 
L10:    ldc [5] 
L12:    invokespecial [26] 
L15:    invokespecial [27] 
L18:    aload_0 
L19:    aload_2 
L20:    putfield [33] 
L23:    return 
L24:    
    .end code 
.end method 

.method public [217] : [218] 
    .attribute [214] .code stack 2 locals 0 
L0:     new [34] 
L3:     dup 
L4:     invokespecial [28] 
L7:     areturn 
L8:     
    .end code 
.end method 

.method public [219] : [220] 
    .attribute [214] .code stack 1 locals 0 
L0:     getstatic [7] 
L3:     areturn 
L4:     
    .end code 
.end method 

.method public [221] : [222] 
    .attribute [214] .code stack 5 locals 3 
        .catch [11] from L0 to L291 using L294 
L0:     iload_1 
L1:     tableswitch 13 
            L56 
            L102 
            L264 
            L264 
            L196 
            L238 
            L212 
            L128 
            L170 
            L144 
            default : L264 

L56:    aload_2 
L57:    invokeinterface [35] 0 
L62:    astore 4 
L64:    aload_2 
L65:    invokeinterface [36] 0 
L70:    istore 5 
L72:    aload_2 
L73:    invokeinterface [37] 0 
L78:    istore 6 
L80:    aload_0 
L81:    getfield [21] 
L84:    aload 4 
L86:    iload 5 
L88:    iload 6 
L90:    aload_3 
L91:    checkcast [6] 
L94:    invokeinterface [38] 0 
L99:    goto L291 
L102:   aload_2 
L103:   invokeinterface [35] 0 
L108:   astore 4 
L110:   aload_0 
L111:   getfield [21] 
L114:   aload 4 
L116:   aload_3 
L117:   checkcast [6] 
L120:   invokeinterface [39] 0 
L125:   goto L291 
L128:   aload_0 
L129:   getfield [21] 
L132:   aload_3 
L133:   checkcast [6] 
L136:   invokeinterface [40] 0 
L141:   goto L291 
L144:   aload_2 
L145:   invokeinterface [41] 0 
L150:   lstore 4 
L152:   aload_0 
L153:   getfield [21] 
L156:   lload 4 
L158:   aload_3 
L159:   checkcast [6] 
L162:   invokeinterface [42] 0 
L167:   goto L291 
L170:   aload_2 
L171:   invokeinterface [43] 0 
L176:   astore 4 
L178:   aload_0 
L179:   getfield [21] 
L182:   aload 4 
L184:   aload_3 
L185:   checkcast [6] 
L188:   invokeinterface [44] 0 
L193:   goto L291 
L196:   aload_0 
L197:   getfield [21] 
L200:   aload_3 
L201:   checkcast [6] 
L204:   invokeinterface [45] 0 
L209:   goto L291 
L212:   aload_2 
L213:   invokeinterface [41] 0 
L218:   lstore 4 
L220:   aload_0 
L221:   getfield [21] 
L224:   lload 4 
L226:   aload_3 
L227:   checkcast [6] 
L230:   invokeinterface [46] 0 
L235:   goto L291 
L238:   aload_2 
L239:   invokeinterface [43] 0 
L244:   astore 4 
L246:   aload_0 
L247:   getfield [21] 
L250:   aload 4 
L252:   aload_3 
L253:   checkcast [6] 
L256:   invokeinterface [47] 0 
L261:   goto L291 
L264:   new [48] 
L267:   dup 
L268:   new [49] 
L271:   dup 
L272:   invokespecial [30] 
L275:   ldc [10] 
L277:   invokevirtual [22] 
L280:   iload_1 
L281:   invokevirtual [23] 
L284:   invokevirtual [24] 
L287:   invokespecial [31] 
L290:   athrow 
L291:   goto L336 
L294:   astore 4 
L296:   new [48] 
L299:   dup 
L300:   new [49] 
L303:   dup 
L304:   invokespecial [30] 
L307:   ldc [12] 
L309:   invokevirtual [22] 
L312:   iload_1 
L313:   invokevirtual [23] 
L316:   ldc [13] 
L318:   invokevirtual [22] 
L321:   aload 4 
L323:   invokevirtual [25] 
L326:   invokevirtual [22] 
L329:   invokevirtual [24] 
L332:   invokespecial [31] 
L335:   athrow 
L336:   return 
L337:   nop 
L338:   nop 
L339:   nop 
L340:   
    .end code 
.end method 

.method static [223] : [224] 
    .attribute [214] .code stack 1 locals 0 
L0:     ldc [14] 
L2:     invokestatic [15] 
L5:     putstatic [29] 
L8:     return 
L9:     nop 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [50] 
.const [3] = String [51] 
.const [4] = String [52] 
.const [5] = String [53] 
.const [6] = Class [54] 
.const [7] = Field [55] [56] 
.const [8] = Class [57] 
.const [9] = Class [58] 
.const [10] = String [59] 
.const [11] = Class [60] 
.const [12] = String [61] 
.const [13] = String [62] 
.const [14] = String [63] 
.const [15] = Method [64] [65] 
.const [16] = Class [66] 
.const [17] = Class [67] 
.const [18] = Class [68] 
.const [19] = Class [69] 
.const [20] = Class [70] 
.const [21] = Field [71] [72] 
.const [22] = Method [73] [74] 
.const [23] = Method [75] [76] 
.const [24] = Method [77] [78] 
.const [25] = Method [79] [80] 
.const [26] = Method [81] [82] 
.const [27] = Method [83] [84] 
.const [28] = Method [85] [86] 
.const [29] = Field [87] [88] 
.const [30] = Method [89] [90] 
.const [31] = Method [91] [92] 
.const [32] = Class [93] 
.const [33] = Field [94] [95] 
.const [34] = Class [96] 
.const [35] = InterfaceMethod [97] [98] 
.const [36] = InterfaceMethod [99] [100] 
.const [37] = InterfaceMethod [101] [102] 
.const [38] = InterfaceMethod [103] [104] 
.const [39] = InterfaceMethod [105] [106] 
.const [40] = InterfaceMethod [107] [108] 
.const [41] = InterfaceMethod [109] [110] 
.const [42] = InterfaceMethod [111] [112] 
.const [43] = InterfaceMethod [113] [114] 
.const [44] = InterfaceMethod [115] [116] 
.const [45] = InterfaceMethod [117] [118] 
.const [46] = InterfaceMethod [119] [120] 
.const [47] = InterfaceMethod [121] [122] 
.const [48] = Class [123] 
.const [49] = Class [124] 
.const [50] = Utf8 de/esolutions/fw/comm/core/ServiceInstanceID 
.const [51] = Utf8 '8d042df8-ec1b-43d0-a72b-371a030c1d6f' 
.const [52] = Utf8 '6043b5ea-f526-5902-8f8e-a258f712dd76' 
.const [53] = Utf8 'asi.imageserver.ImageServer' 
.const [54] = Utf8 de/esolutions/fw/comm/asi/imageserver/impl/ImageServerReplyProxy 
.const [55] = Class [125] 
.const [56] = NameAndType [126] [127] 
.const [57] = Utf8 de/esolutions/fw/comm/core/method/MethodException 
.const [58] = Utf8 java/lang/StringBuffer 
.const [59] = Utf8 'Invalid Method Id ' 
.const [60] = Utf8 de/esolutions/fw/util/serializer/exception/SerializerException 
.const [61] = Utf8 'Deserialization failed: method=' 
.const [62] = Utf8 ', error=' 
.const [63] = Utf8 'STUB.asi.imageserver.ImageServer' 
.const [64] = Class [128] 
.const [65] = NameAndType [129] [130] 
.const [66] = Utf8 de/esolutions/fw/comm/asi/imageserver/impl/ImageServerService 
.const [67] = Utf8 de/esolutions/fw/comm/core/AbstractService 
.const [68] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [69] = Utf8 de/esolutions/fw/comm/asi/imageserver/ImageServerS 
.const [70] = Utf8 de/esolutions/fw/comm/core/CallContext 
.const [71] = Class [131] 
.const [72] = NameAndType [132] [133] 
.const [73] = Class [134] 
.const [74] = NameAndType [135] [136] 
.const [75] = Class [137] 
.const [76] = NameAndType [138] [139] 
.const [77] = Class [140] 
.const [78] = NameAndType [141] [142] 
.const [79] = Class [143] 
.const [80] = NameAndType [144] [145] 
.const [81] = Class [146] 
.const [82] = NameAndType [147] [148] 
.const [83] = Class [149] 
.const [84] = NameAndType [150] [151] 
.const [85] = Class [152] 
.const [86] = NameAndType [153] [154] 
.const [87] = Class [155] 
.const [88] = NameAndType [156] [157] 
.const [89] = Class [158] 
.const [90] = NameAndType [159] [160] 
.const [91] = Class [161] 
.const [92] = NameAndType [162] [163] 
.const [93] = Utf8 de/esolutions/fw/comm/core/ServiceInstanceID 
.const [94] = Class [164] 
.const [95] = NameAndType [165] [166] 
.const [96] = Utf8 de/esolutions/fw/comm/asi/imageserver/impl/ImageServerReplyProxy 
.const [97] = Class [167] 
.const [98] = NameAndType [168] [169] 
.const [99] = Class [170] 
.const [100] = NameAndType [171] [172] 
.const [101] = Class [173] 
.const [102] = NameAndType [174] [175] 
.const [103] = Class [176] 
.const [104] = NameAndType [177] [178] 
.const [105] = Class [179] 
.const [106] = NameAndType [180] [181] 
.const [107] = Class [182] 
.const [108] = NameAndType [183] [184] 
.const [109] = Class [185] 
.const [110] = NameAndType [186] [187] 
.const [111] = Class [188] 
.const [112] = NameAndType [189] [190] 
.const [113] = Class [191] 
.const [114] = NameAndType [192] [193] 
.const [115] = Class [194] 
.const [116] = NameAndType [195] [196] 
.const [117] = Class [197] 
.const [118] = NameAndType [198] [199] 
.const [119] = Class [200] 
.const [120] = NameAndType [201] [202] 
.const [121] = Class [203] 
.const [122] = NameAndType [204] [205] 
.const [123] = Utf8 de/esolutions/fw/comm/core/method/MethodException 
.const [124] = Utf8 java/lang/StringBuffer 
.const [125] = Utf8 de/esolutions/fw/comm/asi/imageserver/impl/ImageServerService 
.const [126] = Utf8 context 
.const [127] = Utf8 Lde/esolutions/fw/comm/core/CallContext; 
.const [128] = Utf8 de/esolutions/fw/comm/core/CallContext 
.const [129] = Utf8 getContext 
.const [130] = Utf8 (Ljava/lang/String;)Lde/esolutions/fw/comm/core/CallContext; 
.const [131] = Utf8 de/esolutions/fw/comm/asi/imageserver/impl/ImageServerService 
.const [132] = Utf8 p_ImageServer 
.const [133] = Utf8 Lde/esolutions/fw/comm/asi/imageserver/ImageServerS; 
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
.const [149] = Utf8 de/esolutions/fw/comm/core/AbstractService 
.const [150] = Utf8 <init> 
.const [151] = Utf8 (Lde/esolutions/fw/comm/core/ServiceInstanceID;)V 
.const [152] = Utf8 de/esolutions/fw/comm/asi/imageserver/impl/ImageServerReplyProxy 
.const [153] = Utf8 <init> 
.const [154] = Utf8 ()V 
.const [155] = Utf8 de/esolutions/fw/comm/asi/imageserver/impl/ImageServerService 
.const [156] = Utf8 context 
.const [157] = Utf8 Lde/esolutions/fw/comm/core/CallContext; 
.const [158] = Utf8 java/lang/StringBuffer 
.const [159] = Utf8 <init> 
.const [160] = Utf8 ()V 
.const [161] = Utf8 de/esolutions/fw/comm/core/method/MethodException 
.const [162] = Utf8 <init> 
.const [163] = Utf8 (Ljava/lang/String;)V 
.const [164] = Utf8 de/esolutions/fw/comm/asi/imageserver/impl/ImageServerService 
.const [165] = Utf8 p_ImageServer 
.const [166] = Utf8 Lde/esolutions/fw/comm/asi/imageserver/ImageServerS; 
.const [167] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [168] = Utf8 getOptionalStringVarArray 
.const [169] = Utf8 ()[Ljava/lang/String; 
.const [170] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [171] = Utf8 getInt8 
.const [172] = Utf8 ()B 
.const [173] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [174] = Utf8 getBool 
.const [175] = Utf8 ()Z 
.const [176] = Utf8 de/esolutions/fw/comm/asi/imageserver/ImageServerS 
.const [177] = Utf8 requestImage 
.const [178] = Utf8 ([Ljava/lang/String;BZLde/esolutions/fw/comm/asi/imageserver/ImageServerReply;)V 
.const [179] = Utf8 de/esolutions/fw/comm/asi/imageserver/ImageServerS 
.const [180] = Utf8 requestImageInformation 
.const [181] = Utf8 ([Ljava/lang/String;Lde/esolutions/fw/comm/asi/imageserver/ImageServerReply;)V 
.const [182] = Utf8 de/esolutions/fw/comm/asi/imageserver/ImageServerS 
.const [183] = Utf8 setNotification 
.const [184] = Utf8 (Lde/esolutions/fw/comm/asi/imageserver/ImageServerReply;)V 
.const [185] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [186] = Utf8 getUInt32 
.const [187] = Utf8 ()J 
.const [188] = Utf8 de/esolutions/fw/comm/asi/imageserver/ImageServerS 
.const [189] = Utf8 setNotification 
.const [190] = Utf8 (JLde/esolutions/fw/comm/asi/imageserver/ImageServerReply;)V 
.const [191] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [192] = Utf8 getOptionalUInt32VarArray 
.const [193] = Utf8 ()[J 
.const [194] = Utf8 de/esolutions/fw/comm/asi/imageserver/ImageServerS 
.const [195] = Utf8 setNotification 
.const [196] = Utf8 ([JLde/esolutions/fw/comm/asi/imageserver/ImageServerReply;)V 
.const [197] = Utf8 de/esolutions/fw/comm/asi/imageserver/ImageServerS 
.const [198] = Utf8 clearNotification 
.const [199] = Utf8 (Lde/esolutions/fw/comm/asi/imageserver/ImageServerReply;)V 
.const [200] = Utf8 de/esolutions/fw/comm/asi/imageserver/ImageServerS 
.const [201] = Utf8 clearNotification 
.const [202] = Utf8 (JLde/esolutions/fw/comm/asi/imageserver/ImageServerReply;)V 
.const [203] = Utf8 de/esolutions/fw/comm/asi/imageserver/ImageServerS 
.const [204] = Utf8 clearNotification 
.const [205] = Utf8 ([JLde/esolutions/fw/comm/asi/imageserver/ImageServerReply;)V 
.const [206] = Utf8 de/esolutions/fw/comm/asi/imageserver/impl/ImageServerService 
.const [207] = Class [206] 
.const [208] = Utf8 de/esolutions/fw/comm/core/AbstractService 
.const [209] = Class [208] 
.const [210] = Utf8 context 
.const [211] = Utf8 Lde/esolutions/fw/comm/core/CallContext; 
.const [212] = Utf8 p_ImageServer 
.const [213] = Utf8 Lde/esolutions/fw/comm/asi/imageserver/ImageServerS; 
.const [214] = Utf8 Code 
.const [215] = Utf8 <init> 
.const [216] = Utf8 (ILde/esolutions/fw/comm/asi/imageserver/ImageServerS;)V 
.const [217] = Utf8 createReplyProxy 
.const [218] = Utf8 ()Lde/esolutions/fw/comm/core/IProxyFrontend; 
.const [219] = Utf8 getCallContext 
.const [220] = Utf8 ()Lde/esolutions/fw/comm/core/CallContext; 
.const [221] = Utf8 handleCallMethod 
.const [222] = Utf8 (SLde/esolutions/fw/util/serializer/IDeserializer;Lde/esolutions/fw/comm/core/IProxyFrontend;)V 
.const [223] = Utf8 <clinit> 
.const [224] = Utf8 ()V 
.end class 
