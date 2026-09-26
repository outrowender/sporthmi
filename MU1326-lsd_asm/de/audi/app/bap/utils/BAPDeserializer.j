.version 50 0 
.class public final super [138] 
.super [140] 
.field public static final [141] [142] 
.field public static final [143] [144] 
.field public static final [145] [146] 
.field public static final [147] [148] 
.field public static final [149] [150] 

.method public annotation [152] : [153] 
    .attribute [151] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [31] 
L4:     return 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public static [154] : [155] 
    .attribute [151] .code stack 7 locals 5 
L0:     iload_2 
L1:     invokestatic [2] 
L4:     astore 6 
L6:     iload_2 
L7:     iload_3 
L8:     invokestatic [3] 
L11:    astore 7 
L13:    aload_0 
L14:    ldc [4] 
L16:    ldc [5] 
L18:    aload 6 
L20:    aload 7 
L22:    invokevirtual [22] 
L25:    new [34] 
L28:    dup 
L29:    invokespecial [32] 
L32:    astore 8 
        .catch [12] from L34 to L181 using L184 
L34:    aload 4 
L36:    ifnull L165 
L39:    aload 5 
L41:    invokevirtual [23] 
L44:    istore 10 
L46:    iload 10 
L48:    ifne L94 
L51:    aload_0 
L52:    ldc [4] 
L54:    ldc [7] 
L56:    aload 4 
L58:    invokespecial [33] 
L61:    aload 5 
L63:    invokevirtual [24] 
L66:    iload 10 
L68:    i2l 
L69:    invokevirtual [25] 
L72:    aload 8 
L74:    aload 4 
L76:    aload 5 
L78:    invokevirtual [26] 
L81:    aload 4 
L83:    aload 5 
L85:    invokestatic [8] 
L88:    invokevirtual [27] 
L91:    goto L133 
L94:    iload 10 
L96:    iconst_1 
L97:    if_icmpne L133 
L100:   aload_0 
L101:   ldc [4] 
L103:   ldc [7] 
L105:   aload 4 
L107:   invokespecial [33] 
L110:   aload 5 
L112:   invokevirtual [24] 
L115:   iload 10 
L117:   i2l 
L118:   invokevirtual [25] 
L121:   aload 8 
L123:   aload 4 
L125:   aload 5 
L127:   invokevirtual [24] 
L130:   invokevirtual [28] 
L133:   aload_0 
L134:   ldc [4] 
L136:   ldc [9] 
L138:   aload 6 
L140:   aload 7 
L142:   invokevirtual [22] 
L145:   aload_1 
L146:   ldc [4] 
L148:   ldc [10] 
L150:   aload 4 
L152:   aload 6 
L154:   aload 7 
L156:   invokevirtual [29] 
L159:   iconst_0 
L160:   istore 9 
L162:   goto L181 
L165:   aload_0 
L166:   sipush 10000 
L169:   ldc [11] 
L171:   aload 6 
L173:   aload 7 
L175:   invokevirtual [22] 
L178:   iconst_1 
L179:   istore 9 
L181:   goto L202 
L184:   astore 10 
L186:   aload_0 
L187:   sipush 10000 
L190:   ldc [13] 
L192:   aload 6 
L194:   aload 7 
L196:   invokevirtual [22] 
L199:   iconst_2 
L200:   istore 9 
L202:   iload 9 
L204:   areturn 
L205:   nop 
L206:   nop 
L207:   nop 
L208:   
    .end code 
.end method 

.method private static [156] : [157] 
    .attribute [151] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokeinterface [35] 0 
L6:     ifeq L16 
L9:     aload_0 
L10:    invokeinterface [35] 0 
L15:    areturn 
L16:    aload_1 
L17:    invokevirtual [30] 
L20:    invokestatic [14] 
L23:    areturn 
L24:    
    .end code 
.end method 

.method private static [158] : [159] 
    .attribute [151] .code stack 1 locals 1 
L0:     iload_0 
L1:     tableswitch 0 
            L28 
            L34 
            L40 
            default : L46 

L28:    bipush 8 
L30:    istore_1 
L31:    goto L49 
L34:    bipush 16 
L36:    istore_1 
L37:    goto L49 
L40:    bipush 32 
L42:    istore_1 
L43:    goto L49 
L46:    bipush 32 
L48:    istore_1 
L49:    iload_1 
L50:    areturn 
L51:    nop 
L52:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Method [36] [37] 
.const [3] = Method [38] [39] 
.const [4] = Int 14808325 
.const [5] = String [40] 
.const [6] = Class [41] 
.const [7] = String [42] 
.const [8] = Method [43] [44] 
.const [9] = String [45] 
.const [10] = String [46] 
.const [11] = String [47] 
.const [12] = Class [48] 
.const [13] = String [49] 
.const [14] = Method [50] [51] 
.const [15] = Class [52] 
.const [16] = Class [53] 
.const [17] = Class [54] 
.const [18] = Class [55] 
.const [19] = Class [56] 
.const [20] = Class [57] 
.const [21] = Class [58] 
.const [22] = Method [59] [60] 
.const [23] = Method [61] [62] 
.const [24] = Method [63] [64] 
.const [25] = Method [65] [66] 
.const [26] = Method [67] [68] 
.const [27] = Method [69] [70] 
.const [28] = Method [71] [72] 
.const [29] = Method [73] [74] 
.const [30] = Method [75] [76] 
.const [31] = Method [77] [78] 
.const [32] = Method [79] [80] 
.const [33] = Method [81] [82] 
.const [34] = Class [83] 
.const [35] = InterfaceMethod [84] [85] 
.const [36] = Class [86] 
.const [37] = NameAndType [87] [88] 
.const [38] = Class [89] 
.const [39] = NameAndType [90] [91] 
.const [40] = Utf8 '[BAPDeserializer#deserializeData] start deserialization: lsgID=%1, fctID=%2' 
.const [41] = Utf8 de/vw/mib/bap/stream/BitStreamTransformer 
.const [42] = Utf8 '[BAPDeserializer#deserializeData] serializerClass=%1, dataParameterType=%3, data=%2' 
.const [43] = Class [92] 
.const [44] = NameAndType [93] [94] 
.const [45] = Utf8 '[BAPDeserializer#deserializeData] deserialization successful: lsgID=%1, fctID=%2' 
.const [46] = Utf8 '[BAPDeserializer#deserializeData] deserialization successful: lsgID=%2, fctID=%3, data=%1' 
.const [47] = Utf8 '[BAPDeserializer#deserializeData] serializer is null: lsgID=%1, fctID=%2' 
.const [48] = Utf8 java/nio/BufferUnderflowException 
.const [49] = Utf8 '[BAPDeserializer#deserializeData] wrong parameter format: lsgID=%1, fctID=%2' 
.const [50] = Class [95] 
.const [51] = NameAndType [96] [97] 
.const [52] = Utf8 de/audi/app/bap/utils/BAPDeserializer 
.const [53] = Utf8 java/lang/Object 
.const [54] = Utf8 de/audi/app/bap/utils/LSGIDs 
.const [55] = Utf8 de/audi/app/bap/utils/FunctionIDs 
.const [56] = Utf8 de/audi/atip/log/LogChannel 
.const [57] = Utf8 de/audi/app/bap/fw/indication/BAPIndicationData 
.const [58] = Utf8 de/vw/mib/bap/stream/BitStreamSerializer 
.const [59] = Class [98] 
.const [60] = NameAndType [99] [100] 
.const [61] = Class [101] 
.const [62] = NameAndType [102] [103] 
.const [63] = Class [104] 
.const [64] = NameAndType [105] [106] 
.const [65] = Class [107] 
.const [66] = NameAndType [108] [109] 
.const [67] = Class [110] 
.const [68] = NameAndType [111] [112] 
.const [69] = Class [113] 
.const [70] = NameAndType [114] [115] 
.const [71] = Class [116] 
.const [72] = NameAndType [117] [118] 
.const [73] = Class [119] 
.const [74] = NameAndType [120] [121] 
.const [75] = Class [122] 
.const [76] = NameAndType [123] [124] 
.const [77] = Class [125] 
.const [78] = NameAndType [126] [127] 
.const [79] = Class [128] 
.const [80] = NameAndType [129] [130] 
.const [81] = Class [131] 
.const [82] = NameAndType [132] [133] 
.const [83] = Utf8 de/vw/mib/bap/stream/BitStreamTransformer 
.const [84] = Class [134] 
.const [85] = NameAndType [135] [136] 
.const [86] = Utf8 de/audi/app/bap/utils/LSGIDs 
.const [87] = Utf8 getDescription 
.const [88] = Utf8 (I)Ljava/lang/String; 
.const [89] = Utf8 de/audi/app/bap/utils/FunctionIDs 
.const [90] = Utf8 getDescription 
.const [91] = Utf8 (II)Ljava/lang/String; 
.const [92] = Utf8 de/audi/app/bap/utils/BAPDeserializer 
.const [93] = Utf8 determineBitsize 
.const [94] = Utf8 (Lde/vw/mib/bap/stream/BitStreamSerializer;Lde/audi/app/bap/fw/indication/BAPIndicationData;)I 
.const [95] = Utf8 de/audi/app/bap/utils/BAPDeserializer 
.const [96] = Utf8 getBitstreamTransformerDatatype 
.const [97] = Utf8 (I)I 
.const [98] = Utf8 de/audi/atip/log/LogChannel 
.const [99] = Utf8 log 
.const [100] = Utf8 (ILjava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V 
.const [101] = Utf8 de/audi/app/bap/fw/indication/BAPIndicationData 
.const [102] = Utf8 getParameterType 
.const [103] = Utf8 ()I 
.const [104] = Utf8 de/audi/app/bap/fw/indication/BAPIndicationData 
.const [105] = Utf8 getDataByteArray 
.const [106] = Utf8 ()[B 
.const [107] = Utf8 de/audi/atip/log/LogChannel 
.const [108] = Utf8 log 
.const [109] = Utf8 (ILjava/lang/String;Ljava/lang/Object;Ljava/lang/Object;J)V 
.const [110] = Utf8 de/audi/app/bap/fw/indication/BAPIndicationData 
.const [111] = Utf8 getDataInt 
.const [112] = Utf8 ()I 
.const [113] = Utf8 de/vw/mib/bap/stream/BitStreamTransformer 
.const [114] = Utf8 fromInteger 
.const [115] = Utf8 (Lde/vw/mib/bap/stream/BitStreamSerializer;II)V 
.const [116] = Utf8 de/vw/mib/bap/stream/BitStreamTransformer 
.const [117] = Utf8 fromArray 
.const [118] = Utf8 (Lde/vw/mib/bap/stream/BitStreamSerializer;[B)V 
.const [119] = Utf8 de/audi/atip/log/LogChannel 
.const [120] = Utf8 log 
.const [121] = Utf8 (ILjava/lang/String;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V 
.const [122] = Utf8 de/audi/app/bap/fw/indication/BAPIndicationData 
.const [123] = Utf8 getDataType 
.const [124] = Utf8 ()I 
.const [125] = Utf8 java/lang/Object 
.const [126] = Utf8 <init> 
.const [127] = Utf8 ()V 
.const [128] = Utf8 de/vw/mib/bap/stream/BitStreamTransformer 
.const [129] = Utf8 <init> 
.const [130] = Utf8 ()V 
.const [131] = Utf8 java/lang/Object 
.const [132] = Utf8 getClass 
.const [133] = Utf8 ()Ljava/lang/Class; 
.const [134] = Utf8 de/vw/mib/bap/stream/BitStreamSerializer 
.const [135] = Utf8 bitSize 
.const [136] = Utf8 ()I 
.const [137] = Utf8 de/audi/app/bap/utils/BAPDeserializer 
.const [138] = Class [137] 
.const [139] = Utf8 java/lang/Object 
.const [140] = Class [139] 
.const [141] = Utf8 DESERIALIZATION_RESULT_SUCCESSFUL 
.const [142] = Utf8 I 
.const [143] = Utf8 DESERIALIZATION_RESULT_INVALID_SERIALIZER 
.const [144] = Utf8 I 
.const [145] = Utf8 DESERIALIZATION_RESULT_WRONG_PARAMETER_FORMAT 
.const [146] = Utf8 I 
.const [147] = Utf8 DESERIALIZATION_RESULT_INVALID_PARAMETERIZATION 
.const [148] = Utf8 I 
.const [149] = Utf8 DESERIALIZATION_RESULT_NO_DESERIALIZATION_REQUIRED 
.const [150] = Utf8 I 
.const [151] = Utf8 Code 
.const [152] = Utf8 <init> 
.const [153] = Utf8 ()V 
.const [154] = Utf8 deserializeData 
.const [155] = Utf8 (Lde/audi/atip/log/LogChannel;Lde/audi/atip/log/LogChannel;IILde/vw/mib/bap/stream/BitStreamSerializer;Lde/audi/app/bap/fw/indication/BAPIndicationData;)I 
.const [156] = Utf8 determineBitsize 
.const [157] = Utf8 (Lde/vw/mib/bap/stream/BitStreamSerializer;Lde/audi/app/bap/fw/indication/BAPIndicationData;)I 
.const [158] = Utf8 getBitstreamTransformerDatatype 
.const [159] = Utf8 (I)I 
.end class 
