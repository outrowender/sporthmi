.version 50 0 
.class public super [189] 
.super [191] 
.field private static final [192] [193] 
.field private static [194] [195] 
.field private [196] [197] 

.method public [199] : [200] 
    .attribute [198] .code stack 7 locals 0 
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

.method private static synchronized [201] : [202] 
    .attribute [198] .code stack 2 locals 1 
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

.method public [203] : [204] 
    .attribute [198] .code stack 1 locals 0 
L0:     getstatic [8] 
L3:     areturn 
L4:     
    .end code 
.end method 

.method public [205] : [206] 
    .attribute [198] .code stack 4 locals 3 
        .catch [14] from L0 to L167 using L170 
L0:     iload_1 
L1:     tableswitch 23 
            L108 
            L28 
            L68 
            default : L140 

L28:    aload_2 
L29:    invokeinterface [39] 0 
L34:    astore 4 
L36:    aload_2 
L37:    invokestatic [9] 
L40:    astore 5 
L42:    aload_2 
L43:    invokeinterface [40] 0 
L48:    istore 6 
L50:    aload_0 
L51:    getfield [26] 
L54:    aload 4 
L56:    aload 5 
L58:    iload 6 
L60:    invokeinterface [41] 0 
L65:    goto L167 
L68:    aload_2 
L69:    invokeinterface [39] 0 
L74:    astore 4 
L76:    aload_2 
L77:    invokestatic [10] 
L80:    astore 5 
L82:    aload_2 
L83:    invokeinterface [40] 0 
L88:    istore 6 
L90:    aload_0 
L91:    getfield [26] 
L94:    aload 4 
L96:    aload 5 
L98:    iload 6 
L100:   invokeinterface [42] 0 
L105:   goto L167 
L108:   aload_2 
L109:   invokeinterface [39] 0 
L114:   astore 4 
L116:   aload_2 
L117:   invokeinterface [43] 0 
L122:   istore 5 
L124:   aload_0 
L125:   getfield [26] 
L128:   aload 4 
L130:   iload 5 
L132:   invokeinterface [44] 0 
L137:   goto L167 
L140:   new [45] 
L143:   dup 
L144:   new [46] 
L147:   dup 
L148:   invokespecial [35] 
L151:   ldc [13] 
L153:   invokevirtual [27] 
L156:   iload_1 
L157:   invokevirtual [28] 
L160:   invokevirtual [29] 
L163:   invokespecial [36] 
L166:   athrow 
L167:   goto L212 
L170:   astore 4 
L172:   new [45] 
L175:   dup 
L176:   new [46] 
L179:   dup 
L180:   invokespecial [35] 
L183:   ldc [15] 
L185:   invokevirtual [27] 
L188:   iload_1 
L189:   invokevirtual [28] 
L192:   ldc [16] 
L194:   invokevirtual [27] 
L197:   aload 4 
L199:   invokevirtual [30] 
L202:   invokevirtual [27] 
L205:   invokevirtual [29] 
L208:   invokespecial [36] 
L211:   athrow 
L212:   return 
L213:   nop 
L214:   nop 
L215:   nop 
L216:   
    .end code 
.end method 

.method static [207] : [208] 
    .attribute [198] .code stack 1 locals 0 
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
.const [2] = Class [47] 
.const [3] = String [48] 
.const [4] = Method [49] [50] 
.const [5] = String [51] 
.const [6] = String [52] 
.const [7] = Field [53] [54] 
.const [8] = Field [55] [56] 
.const [9] = Method [57] [58] 
.const [10] = Method [59] [60] 
.const [11] = Class [61] 
.const [12] = Class [62] 
.const [13] = String [63] 
.const [14] = Class [64] 
.const [15] = String [65] 
.const [16] = String [66] 
.const [17] = String [67] 
.const [18] = Method [68] [69] 
.const [19] = Class [70] 
.const [20] = Class [71] 
.const [21] = Class [72] 
.const [22] = Class [73] 
.const [23] = Class [74] 
.const [24] = Class [75] 
.const [25] = Class [76] 
.const [26] = Field [77] [78] 
.const [27] = Method [79] [80] 
.const [28] = Method [81] [82] 
.const [29] = Method [83] [84] 
.const [30] = Method [85] [86] 
.const [31] = Method [87] [88] 
.const [32] = Method [89] [90] 
.const [33] = Field [91] [92] 
.const [34] = Field [93] [94] 
.const [35] = Method [95] [96] 
.const [36] = Method [97] [98] 
.const [37] = Class [99] 
.const [38] = Field [100] [101] 
.const [39] = InterfaceMethod [102] [103] 
.const [40] = InterfaceMethod [104] [105] 
.const [41] = InterfaceMethod [106] [107] 
.const [42] = InterfaceMethod [108] [109] 
.const [43] = InterfaceMethod [110] [111] 
.const [44] = InterfaceMethod [112] [113] 
.const [45] = Class [114] 
.const [46] = Class [115] 
.const [47] = Utf8 de/esolutions/fw/comm/core/ServiceInstanceID 
.const [48] = Utf8 '4859e928-623e-4248-8210-d55453bef3a4' 
.const [49] = Class [116] 
.const [50] = NameAndType [117] [118] 
.const [51] = Utf8 b9a016f3-d0ec-5bf0-bc90-42549185f0a0 
.const [52] = Utf8 'asi.imageserver.ImageServer' 
.const [53] = Class [119] 
.const [54] = NameAndType [120] [121] 
.const [55] = Class [122] 
.const [56] = NameAndType [123] [124] 
.const [57] = Class [125] 
.const [58] = NameAndType [126] [127] 
.const [59] = Class [128] 
.const [60] = NameAndType [129] [130] 
.const [61] = Utf8 de/esolutions/fw/comm/core/method/MethodException 
.const [62] = Utf8 java/lang/StringBuffer 
.const [63] = Utf8 'Invalid Method Id ' 
.const [64] = Utf8 de/esolutions/fw/util/serializer/exception/SerializerException 
.const [65] = Utf8 'Deserialization failed: method=' 
.const [66] = Utf8 ', error=' 
.const [67] = Utf8 'STUB.asi.imageserver.ImageServer' 
.const [68] = Class [131] 
.const [69] = NameAndType [132] [133] 
.const [70] = Utf8 de/esolutions/fw/comm/asi/imageserver/impl/ImageServerReplyService 
.const [71] = Utf8 de/esolutions/fw/comm/core/AbstractReplyService 
.const [72] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [73] = Utf8 de/esolutions/fw/comm/asi/imageserver/impl/ImageSerializer 
.const [74] = Utf8 de/esolutions/fw/comm/asi/imageserver/ImageServerReply 
.const [75] = Utf8 de/esolutions/fw/comm/asi/imageserver/impl/ImageInfoSerializer 
.const [76] = Utf8 de/esolutions/fw/comm/core/CallContext 
.const [77] = Class [134] 
.const [78] = NameAndType [135] [136] 
.const [79] = Class [137] 
.const [80] = NameAndType [138] [139] 
.const [81] = Class [140] 
.const [82] = NameAndType [141] [142] 
.const [83] = Class [143] 
.const [84] = NameAndType [144] [145] 
.const [85] = Class [146] 
.const [86] = NameAndType [147] [148] 
.const [87] = Class [149] 
.const [88] = NameAndType [150] [151] 
.const [89] = Class [152] 
.const [90] = NameAndType [153] [154] 
.const [91] = Class [155] 
.const [92] = NameAndType [156] [157] 
.const [93] = Class [158] 
.const [94] = NameAndType [159] [160] 
.const [95] = Class [161] 
.const [96] = NameAndType [162] [163] 
.const [97] = Class [164] 
.const [98] = NameAndType [165] [166] 
.const [99] = Utf8 de/esolutions/fw/comm/core/ServiceInstanceID 
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
.const [110] = Class [182] 
.const [111] = NameAndType [183] [184] 
.const [112] = Class [185] 
.const [113] = NameAndType [186] [187] 
.const [114] = Utf8 de/esolutions/fw/comm/core/method/MethodException 
.const [115] = Utf8 java/lang/StringBuffer 
.const [116] = Utf8 de/esolutions/fw/comm/asi/imageserver/impl/ImageServerReplyService 
.const [117] = Utf8 nextDynamicHandle 
.const [118] = Utf8 ()I 
.const [119] = Utf8 de/esolutions/fw/comm/asi/imageserver/impl/ImageServerReplyService 
.const [120] = Utf8 dynamicHandle 
.const [121] = Utf8 I 
.const [122] = Utf8 de/esolutions/fw/comm/asi/imageserver/impl/ImageServerReplyService 
.const [123] = Utf8 context 
.const [124] = Utf8 Lde/esolutions/fw/comm/core/CallContext; 
.const [125] = Utf8 de/esolutions/fw/comm/asi/imageserver/impl/ImageSerializer 
.const [126] = Utf8 getOptionalImage 
.const [127] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)Lde/esolutions/fw/comm/asi/imageserver/Image; 
.const [128] = Utf8 de/esolutions/fw/comm/asi/imageserver/impl/ImageInfoSerializer 
.const [129] = Utf8 getOptionalImageInfo 
.const [130] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)Lde/esolutions/fw/comm/asi/imageserver/ImageInfo; 
.const [131] = Utf8 de/esolutions/fw/comm/core/CallContext 
.const [132] = Utf8 getContext 
.const [133] = Utf8 (Ljava/lang/String;)Lde/esolutions/fw/comm/core/CallContext; 
.const [134] = Utf8 de/esolutions/fw/comm/asi/imageserver/impl/ImageServerReplyService 
.const [135] = Utf8 p_ImageServerReply 
.const [136] = Utf8 Lde/esolutions/fw/comm/asi/imageserver/ImageServerReply; 
.const [137] = Utf8 java/lang/StringBuffer 
.const [138] = Utf8 append 
.const [139] = Utf8 (Ljava/lang/String;)Ljava/lang/StringBuffer; 
.const [140] = Utf8 java/lang/StringBuffer 
.const [141] = Utf8 append 
.const [142] = Utf8 (I)Ljava/lang/StringBuffer; 
.const [143] = Utf8 java/lang/StringBuffer 
.const [144] = Utf8 toString 
.const [145] = Utf8 ()Ljava/lang/String; 
.const [146] = Utf8 de/esolutions/fw/util/serializer/exception/SerializerException 
.const [147] = Utf8 getMessage 
.const [148] = Utf8 ()Ljava/lang/String; 
.const [149] = Utf8 de/esolutions/fw/comm/core/ServiceInstanceID 
.const [150] = Utf8 <init> 
.const [151] = Utf8 (Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V 
.const [152] = Utf8 de/esolutions/fw/comm/core/AbstractReplyService 
.const [153] = Utf8 <init> 
.const [154] = Utf8 (Lde/esolutions/fw/comm/core/ServiceInstanceID;)V 
.const [155] = Utf8 de/esolutions/fw/comm/asi/imageserver/impl/ImageServerReplyService 
.const [156] = Utf8 dynamicHandle 
.const [157] = Utf8 I 
.const [158] = Utf8 de/esolutions/fw/comm/asi/imageserver/impl/ImageServerReplyService 
.const [159] = Utf8 context 
.const [160] = Utf8 Lde/esolutions/fw/comm/core/CallContext; 
.const [161] = Utf8 java/lang/StringBuffer 
.const [162] = Utf8 <init> 
.const [163] = Utf8 ()V 
.const [164] = Utf8 de/esolutions/fw/comm/core/method/MethodException 
.const [165] = Utf8 <init> 
.const [166] = Utf8 (Ljava/lang/String;)V 
.const [167] = Utf8 de/esolutions/fw/comm/asi/imageserver/impl/ImageServerReplyService 
.const [168] = Utf8 p_ImageServerReply 
.const [169] = Utf8 Lde/esolutions/fw/comm/asi/imageserver/ImageServerReply; 
.const [170] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [171] = Utf8 getOptionalString 
.const [172] = Utf8 ()Ljava/lang/String; 
.const [173] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [174] = Utf8 getEnum 
.const [175] = Utf8 ()I 
.const [176] = Utf8 de/esolutions/fw/comm/asi/imageserver/ImageServerReply 
.const [177] = Utf8 responseImage 
.const [178] = Utf8 (Ljava/lang/String;Lde/esolutions/fw/comm/asi/imageserver/Image;I)V 
.const [179] = Utf8 de/esolutions/fw/comm/asi/imageserver/ImageServerReply 
.const [180] = Utf8 responseImageInformation 
.const [181] = Utf8 (Ljava/lang/String;Lde/esolutions/fw/comm/asi/imageserver/ImageInfo;I)V 
.const [182] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [183] = Utf8 getBool 
.const [184] = Utf8 ()Z 
.const [185] = Utf8 de/esolutions/fw/comm/asi/imageserver/ImageServerReply 
.const [186] = Utf8 updateASIVersion 
.const [187] = Utf8 (Ljava/lang/String;Z)V 
.const [188] = Utf8 de/esolutions/fw/comm/asi/imageserver/impl/ImageServerReplyService 
.const [189] = Class [188] 
.const [190] = Utf8 de/esolutions/fw/comm/core/AbstractReplyService 
.const [191] = Class [190] 
.const [192] = Utf8 context 
.const [193] = Utf8 Lde/esolutions/fw/comm/core/CallContext; 
.const [194] = Utf8 dynamicHandle 
.const [195] = Utf8 I 
.const [196] = Utf8 p_ImageServerReply 
.const [197] = Utf8 Lde/esolutions/fw/comm/asi/imageserver/ImageServerReply; 
.const [198] = Utf8 Code 
.const [199] = Utf8 <init> 
.const [200] = Utf8 (Lde/esolutions/fw/comm/asi/imageserver/ImageServerReply;)V 
.const [201] = Utf8 nextDynamicHandle 
.const [202] = Utf8 ()I 
.const [203] = Utf8 getCallContext 
.const [204] = Utf8 ()Lde/esolutions/fw/comm/core/CallContext; 
.const [205] = Utf8 handleCallMethod 
.const [206] = Utf8 (SLde/esolutions/fw/util/serializer/IDeserializer;Lde/esolutions/fw/comm/core/IProxyFrontend;)V 
.const [207] = Utf8 <clinit> 
.const [208] = Utf8 ()V 
.end class 
