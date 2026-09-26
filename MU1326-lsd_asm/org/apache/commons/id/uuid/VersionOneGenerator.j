.version 50 0 
.class public final super [211] 
.super [213] 
.implements [215] 
.implements [217] 
.field private static final [218] [219] 
.field private static final [220] [221] 
.field private static final [222] [223] 
.field private static final [224] [225] 
.field private static final [226] [227] 
.field private [228] [229] 
.field private static [230] [231] 
.field static synthetic [232] [233] 
.field static synthetic [234] [235] 

.method private [237] : [238] 
    .attribute [236] .code stack 3 locals 0 
L0:     aload_0 
L1:     invokespecial [33] 
L4:     aload_0 
L5:     getstatic [5] 
L8:     ifnonnull L23 
L11:    ldc [6] 
L13:    invokestatic [7] 
L16:    dup 
L17:    putstatic [34] 
L20:    goto L26 
L23:    getstatic [5] 
L26:    getstatic [8] 
L29:    invokestatic [9] 
L32:    checkcast [10] 
L35:    putfield [41] 
L38:    return 
L39:    nop 
L40:    
    .end code 
.end method 

.method public static [239] : [240] 
    .attribute [236] .code stack 2 locals 0 
L0:     getstatic [11] 
L3:     ifnonnull L16 
L6:     new [42] 
L9:     dup 
L10:    invokespecial [37] 
L13:    putstatic [36] 
L16:    getstatic [11] 
L19:    areturn 
L20:    
    .end code 
.end method 

.method public [241] : [242] 
    .attribute [236] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokevirtual [27] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public synchronized [243] : [244] 
    .attribute [236] .code stack 5 locals 7 
L0:     bipush 16 
L2:     newarray byte 
L4:     astore_1 
L5:     lconst_0 
L6:     lstore_2 
L7:     iconst_0 
L8:     istore 4 
L10:    aload_0 
L11:    getfield [26] 
L14:    invokeinterface [43] 0 
L19:    astore 5 
L21:    lload_2 
L22:    lconst_1 
L23:    lcmp 
L24:    ifge L136 
        .catch [14] from L27 to L76 using L90 
        .catch [0] from L27 to L76 using L117 
L27:    aload_0 
L28:    getfield [26] 
L31:    aload 5 
L33:    invokeinterface [44] 0 
L38:    aload 5 
L40:    invokevirtual [28] 
L43:    lstore_2 
L44:    aload 5 
L46:    invokevirtual [29] 
L49:    istore 4 
L51:    aload 5 
L53:    invokevirtual [30] 
L56:    iconst_0 
L57:    aload_1 
L58:    bipush 10 
L60:    bipush 6 
L62:    invokestatic [13] 
L65:    aload_0 
L66:    getfield [26] 
L69:    aload 5 
L71:    invokeinterface [45] 0 
L76:    aload_0 
L77:    getfield [26] 
L80:    aload 5 
L82:    invokeinterface [45] 0 
L87:    goto L133 
        .catch [0] from L90 to L103 using L117 
L90:    astore 6 
L92:    aload_0 
L93:    getfield [26] 
L96:    invokeinterface [46] 0 
L101:   astore 5 
L103:   aload_0 
L104:   getfield [26] 
L107:   aload 5 
L109:   invokeinterface [45] 0 
L114:   goto L133 
        .catch [0] from L117 to L119 using L117 
L117:   astore 7 
L119:   aload_0 
L120:   getfield [26] 
L123:   aload 5 
L125:   invokeinterface [45] 0 
L130:   aload 7 
L132:   athrow 
L133:   goto L21 
L136:   lload_2 
L137:   invokestatic [15] 
L140:   astore 6 
L142:   aload 6 
L144:   iconst_4 
L145:   aload_1 
L146:   iconst_0 
L147:   iconst_4 
L148:   invokestatic [13] 
L151:   aload 6 
L153:   iconst_2 
L154:   aload_1 
L155:   iconst_4 
L156:   iconst_2 
L157:   invokestatic [13] 
L160:   aload 6 
L162:   iconst_0 
L163:   aload_1 
L164:   bipush 6 
L166:   iconst_2 
L167:   invokestatic [13] 
L170:   aload_1 
L171:   bipush 6 
L173:   dup2 
L174:   baload 
L175:   bipush 16 
L177:   ior 
L178:   i2b 
L179:   bastore 
L180:   aload_1 
L181:   bipush 8 
L183:   iload 4 
L185:   sipush 16128 
L188:   iand 
L189:   bipush 8 
L191:   iushr 
L192:   i2b 
L193:   bastore 
L194:   aload_1 
L195:   bipush 8 
L197:   dup2 
L198:   baload 
L199:   sipush 128 
L202:   ior 
L203:   i2b 
L204:   bastore 
L205:   aload_1 
L206:   bipush 9 
L208:   iload 4 
L210:   sipush 255 
L213:   iand 
L214:   i2b 
L215:   bastore 
L216:   new [47] 
L219:   dup 
L220:   aload_1 
L221:   invokespecial [38] 
L224:   areturn 
L225:   nop 
L226:   nop 
L227:   nop 
L228:   
    .end code 
.end method 

.method static synthetic [245] : [246] 
    .attribute [236] .code stack 3 locals 1 
        .catch [3] from L0 to L4 using L5 
L0:     aload_0 
L1:     invokestatic [2] 
L4:     areturn 
L5:     astore_1 
L6:     new [40] 
L9:     dup 
L10:    aload_1 
L11:    invokevirtual [25] 
L14:    invokespecial [32] 
L17:    athrow 
L18:    nop 
L19:    nop 
L20:    
    .end code 
.end method 

.method static [247] : [248] 
    .attribute [236] .code stack 2 locals 0 
L0:     getstatic [17] 
L3:     ifnonnull L18 
L6:     ldc [18] 
L8:     invokestatic [7] 
L11:    dup 
L12:    putstatic [39] 
L15:    goto L21 
L18:    getstatic [17] 
L21:    invokevirtual [31] 
L24:    putstatic [35] 
L27:    return 
L28:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Method [48] [49] 
.const [3] = Class [50] 
.const [4] = Class [51] 
.const [5] = Field [52] [53] 
.const [6] = String [54] 
.const [7] = Method [55] [56] 
.const [8] = Field [57] [58] 
.const [9] = Method [59] [60] 
.const [10] = Class [61] 
.const [11] = Field [62] [63] 
.const [12] = Class [64] 
.const [13] = Method [65] [66] 
.const [14] = Class [67] 
.const [15] = Method [68] [69] 
.const [16] = Class [70] 
.const [17] = Field [71] [72] 
.const [18] = String [73] 
.const [19] = Class [74] 
.const [20] = Class [75] 
.const [21] = Class [76] 
.const [22] = Class [77] 
.const [23] = Class [78] 
.const [24] = Class [79] 
.const [25] = Method [80] [81] 
.const [26] = Field [82] [83] 
.const [27] = Method [84] [85] 
.const [28] = Method [86] [87] 
.const [29] = Method [88] [89] 
.const [30] = Method [90] [91] 
.const [31] = Method [92] [93] 
.const [32] = Method [94] [95] 
.const [33] = Method [96] [97] 
.const [34] = Field [98] [99] 
.const [35] = Field [100] [101] 
.const [36] = Field [102] [103] 
.const [37] = Method [104] [105] 
.const [38] = Method [106] [107] 
.const [39] = Field [108] [109] 
.const [40] = Class [110] 
.const [41] = Field [111] [112] 
.const [42] = Class [113] 
.const [43] = InterfaceMethod [114] [115] 
.const [44] = InterfaceMethod [116] [117] 
.const [45] = InterfaceMethod [118] [119] 
.const [46] = InterfaceMethod [120] [121] 
.const [47] = Class [122] 
.const [48] = Class [123] 
.const [49] = NameAndType [124] [125] 
.const [50] = Utf8 java/lang/ClassNotFoundException 
.const [51] = Utf8 java/lang/NoClassDefFoundError 
.const [52] = Class [126] 
.const [53] = NameAndType [127] [128] 
.const [54] = Utf8 'org.apache.commons.id.uuid.NodeManager' 
.const [55] = Class [129] 
.const [56] = NameAndType [130] [131] 
.const [57] = Class [132] 
.const [58] = NameAndType [133] [134] 
.const [59] = Class [135] 
.const [60] = NameAndType [136] [137] 
.const [61] = Utf8 org/apache/commons/id/uuid/NodeManager 
.const [62] = Class [138] 
.const [63] = NameAndType [139] [140] 
.const [64] = Utf8 org/apache/commons/id/uuid/VersionOneGenerator 
.const [65] = Class [141] 
.const [66] = NameAndType [142] [143] 
.const [67] = Utf8 org/apache/commons/id/uuid/clock/OverClockedException 
.const [68] = Class [144] 
.const [69] = NameAndType [145] [146] 
.const [70] = Utf8 org/apache/commons/id/uuid/UUID 
.const [71] = Class [147] 
.const [72] = NameAndType [148] [149] 
.const [73] = Utf8 'org.apache.commons.id.uuid.NodeManagerImpl' 
.const [74] = Utf8 java/lang/Object 
.const [75] = Utf8 java/lang/Class 
.const [76] = Utf8 org/apache/commons/discovery/tools/DiscoverSingleton 
.const [77] = Utf8 org/apache/commons/id/uuid/state/Node 
.const [78] = Utf8 java/lang/System 
.const [79] = Utf8 org/apache/commons/id/uuid/Bytes 
.const [80] = Class [150] 
.const [81] = NameAndType [151] [152] 
.const [82] = Class [153] 
.const [83] = NameAndType [154] [155] 
.const [84] = Class [156] 
.const [85] = NameAndType [157] [158] 
.const [86] = Class [159] 
.const [87] = NameAndType [160] [161] 
.const [88] = Class [162] 
.const [89] = NameAndType [163] [164] 
.const [90] = Class [165] 
.const [91] = NameAndType [166] [167] 
.const [92] = Class [168] 
.const [93] = NameAndType [169] [170] 
.const [94] = Class [171] 
.const [95] = NameAndType [172] [173] 
.const [96] = Class [174] 
.const [97] = NameAndType [175] [176] 
.const [98] = Class [177] 
.const [99] = NameAndType [178] [179] 
.const [100] = Class [180] 
.const [101] = NameAndType [181] [182] 
.const [102] = Class [183] 
.const [103] = NameAndType [184] [185] 
.const [104] = Class [186] 
.const [105] = NameAndType [187] [188] 
.const [106] = Class [189] 
.const [107] = NameAndType [190] [191] 
.const [108] = Class [192] 
.const [109] = NameAndType [193] [194] 
.const [110] = Utf8 java/lang/NoClassDefFoundError 
.const [111] = Class [195] 
.const [112] = NameAndType [196] [197] 
.const [113] = Utf8 org/apache/commons/id/uuid/VersionOneGenerator 
.const [114] = Class [198] 
.const [115] = NameAndType [199] [200] 
.const [116] = Class [201] 
.const [117] = NameAndType [202] [203] 
.const [118] = Class [204] 
.const [119] = NameAndType [205] [206] 
.const [120] = Class [207] 
.const [121] = NameAndType [208] [209] 
.const [122] = Utf8 org/apache/commons/id/uuid/UUID 
.const [123] = Utf8 java/lang/Class 
.const [124] = Utf8 forName 
.const [125] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.const [126] = Utf8 org/apache/commons/id/uuid/VersionOneGenerator 
.const [127] = Utf8 class$org$apache$commons$id$uuid$NodeManager 
.const [128] = Utf8 Ljava/lang/Class; 
.const [129] = Utf8 org/apache/commons/id/uuid/VersionOneGenerator 
.const [130] = Utf8 class$ 
.const [131] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.const [132] = Utf8 org/apache/commons/id/uuid/VersionOneGenerator 
.const [133] = Utf8 DEFAULT_NODEMANAGER_IMPL 
.const [134] = Utf8 Ljava/lang/String; 
.const [135] = Utf8 org/apache/commons/discovery/tools/DiscoverSingleton 
.const [136] = Utf8 find 
.const [137] = Utf8 (Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Object; 
.const [138] = Utf8 org/apache/commons/id/uuid/VersionOneGenerator 
.const [139] = Utf8 generator 
.const [140] = Utf8 Lorg/apache/commons/id/uuid/VersionOneGenerator; 
.const [141] = Utf8 java/lang/System 
.const [142] = Utf8 arraycopy 
.const [143] = Utf8 (Ljava/lang/Object;ILjava/lang/Object;II)V 
.const [144] = Utf8 org/apache/commons/id/uuid/Bytes 
.const [145] = Utf8 toBytes 
.const [146] = Utf8 (J)[B 
.const [147] = Utf8 org/apache/commons/id/uuid/VersionOneGenerator 
.const [148] = Utf8 class$org$apache$commons$id$uuid$NodeManagerImpl 
.const [149] = Utf8 Ljava/lang/Class; 
.const [150] = Utf8 java/lang/ClassNotFoundException 
.const [151] = Utf8 getMessage 
.const [152] = Utf8 ()Ljava/lang/String; 
.const [153] = Utf8 org/apache/commons/id/uuid/VersionOneGenerator 
.const [154] = Utf8 manager 
.const [155] = Utf8 Lorg/apache/commons/id/uuid/NodeManager; 
.const [156] = Utf8 org/apache/commons/id/uuid/VersionOneGenerator 
.const [157] = Utf8 nextUUID 
.const [158] = Utf8 ()Lorg/apache/commons/id/uuid/UUID; 
.const [159] = Utf8 org/apache/commons/id/uuid/state/Node 
.const [160] = Utf8 getUUIDTime 
.const [161] = Utf8 ()J 
.const [162] = Utf8 org/apache/commons/id/uuid/state/Node 
.const [163] = Utf8 getClockSequence 
.const [164] = Utf8 ()S 
.const [165] = Utf8 org/apache/commons/id/uuid/state/Node 
.const [166] = Utf8 getNodeIdentifier 
.const [167] = Utf8 ()[B 
.const [168] = Utf8 java/lang/Class 
.const [169] = Utf8 getName 
.const [170] = Utf8 ()Ljava/lang/String; 
.const [171] = Utf8 java/lang/NoClassDefFoundError 
.const [172] = Utf8 <init> 
.const [173] = Utf8 (Ljava/lang/String;)V 
.const [174] = Utf8 java/lang/Object 
.const [175] = Utf8 <init> 
.const [176] = Utf8 ()V 
.const [177] = Utf8 org/apache/commons/id/uuid/VersionOneGenerator 
.const [178] = Utf8 class$org$apache$commons$id$uuid$NodeManager 
.const [179] = Utf8 Ljava/lang/Class; 
.const [180] = Utf8 org/apache/commons/id/uuid/VersionOneGenerator 
.const [181] = Utf8 DEFAULT_NODEMANAGER_IMPL 
.const [182] = Utf8 Ljava/lang/String; 
.const [183] = Utf8 org/apache/commons/id/uuid/VersionOneGenerator 
.const [184] = Utf8 generator 
.const [185] = Utf8 Lorg/apache/commons/id/uuid/VersionOneGenerator; 
.const [186] = Utf8 org/apache/commons/id/uuid/VersionOneGenerator 
.const [187] = Utf8 <init> 
.const [188] = Utf8 ()V 
.const [189] = Utf8 org/apache/commons/id/uuid/UUID 
.const [190] = Utf8 <init> 
.const [191] = Utf8 ([B)V 
.const [192] = Utf8 org/apache/commons/id/uuid/VersionOneGenerator 
.const [193] = Utf8 class$org$apache$commons$id$uuid$NodeManagerImpl 
.const [194] = Utf8 Ljava/lang/Class; 
.const [195] = Utf8 org/apache/commons/id/uuid/VersionOneGenerator 
.const [196] = Utf8 manager 
.const [197] = Utf8 Lorg/apache/commons/id/uuid/NodeManager; 
.const [198] = Utf8 org/apache/commons/id/uuid/NodeManager 
.const [199] = Utf8 currentNode 
.const [200] = Utf8 ()Lorg/apache/commons/id/uuid/state/Node; 
.const [201] = Utf8 org/apache/commons/id/uuid/NodeManager 
.const [202] = Utf8 lockNode 
.const [203] = Utf8 (Lorg/apache/commons/id/uuid/state/Node;)V 
.const [204] = Utf8 org/apache/commons/id/uuid/NodeManager 
.const [205] = Utf8 releaseNode 
.const [206] = Utf8 (Lorg/apache/commons/id/uuid/state/Node;)V 
.const [207] = Utf8 org/apache/commons/id/uuid/NodeManager 
.const [208] = Utf8 nextAvailableNode 
.const [209] = Utf8 ()Lorg/apache/commons/id/uuid/state/Node; 
.const [210] = Utf8 org/apache/commons/id/uuid/VersionOneGenerator 
.const [211] = Class [210] 
.const [212] = Utf8 java/lang/Object 
.const [213] = Class [212] 
.const [214] = Utf8 org/apache/commons/id/IdentifierGenerator 
.const [215] = Class [214] 
.const [216] = Utf8 org/apache/commons/id/uuid/Constants 
.const [217] = Class [216] 
.const [218] = Utf8 NODE_ID_BYTE_LENGTH 
.const [219] = Utf8 I 
.const [220] = Utf8 CLOCK_HI_VARIANT_BYTE8 
.const [221] = Utf8 I 
.const [222] = Utf8 CLOCK_LOW_BYTE9 
.const [223] = Utf8 I 
.const [224] = Utf8 NODE_ID_BYTE10 
.const [225] = Utf8 I 
.const [226] = Utf8 DEFAULT_NODEMANAGER_IMPL 
.const [227] = Utf8 Ljava/lang/String; 
.const [228] = Utf8 manager 
.const [229] = Utf8 Lorg/apache/commons/id/uuid/NodeManager; 
.const [230] = Utf8 generator 
.const [231] = Utf8 Lorg/apache/commons/id/uuid/VersionOneGenerator; 
.const [232] = Utf8 class$org$apache$commons$id$uuid$NodeManagerImpl 
.const [233] = Utf8 Ljava/lang/Class; 
.const [234] = Utf8 class$org$apache$commons$id$uuid$NodeManager 
.const [235] = Utf8 Ljava/lang/Class; 
.const [236] = Utf8 Code 
.const [237] = Utf8 <init> 
.const [238] = Utf8 ()V 
.const [239] = Utf8 getInstance 
.const [240] = Utf8 ()Lorg/apache/commons/id/uuid/VersionOneGenerator; 
.const [241] = Utf8 nextIdentifier 
.const [242] = Utf8 ()Ljava/lang/Object; 
.const [243] = Utf8 nextUUID 
.const [244] = Utf8 ()Lorg/apache/commons/id/uuid/UUID; 
.const [245] = Utf8 class$ 
.const [246] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.const [247] = Utf8 <clinit> 
.const [248] = Utf8 ()V 
.end class 
