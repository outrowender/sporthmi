.version 50 0 
.class public super [129] 
.super [131] 
.field private final [132] [133] 

.method public [135] : [136] 
    .attribute [134] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [19] 
L4:     aload_0 
L5:     invokestatic [2] 
L8:     putfield [25] 
L11:    return 
L12:    
    .end code 
.end method 

.method public [137] : [138] 
    .attribute [134] .code stack 4 locals 2 
L0:     aload_0 
L1:     getfield [14] 
L4:     invokeinterface [26] 0 
L9:     newarray byte 
L11:    astore_1 
L12:    iconst_0 
L13:    istore_2 
L14:    iload_2 
L15:    aload_1 
L16:    arraylength 
L17:    if_icmpge L45 
L20:    aload_1 
L21:    iload_2 
L22:    aload_0 
L23:    getfield [14] 
L26:    iload_2 
L27:    invokeinterface [27] 0 
L32:    checkcast [3] 
L35:    invokevirtual [15] 
L38:    bastore 
L39:    iinc 2 1 
L42:    goto L14 
L45:    aload_1 
L46:    areturn 
L47:    nop 
L48:    
    .end code 
.end method 

.method public [139] : [140] 
    .attribute [134] .code stack 4 locals 0 
L0:     aload_0 
L1:     getfield [14] 
L4:     new [28] 
L7:     dup 
L8:     iload_1 
L9:     ifeq L16 
L12:    iconst_1 
L13:    goto L17 
L16:    iconst_0 
L17:    i2b 
L18:    invokespecial [20] 
L21:    invokeinterface [29] 0 
L26:    pop 
L27:    aload_0 
L28:    areturn 
L29:    nop 
L30:    nop 
L31:    nop 
L32:    
    .end code 
.end method 

.method public [141] : [142] 
    .attribute [134] .code stack 4 locals 0 
L0:     aload_0 
L1:     getfield [14] 
L4:     new [28] 
L7:     dup 
L8:     iload_1 
L9:     invokespecial [20] 
L12:    invokeinterface [29] 0 
L17:    pop 
L18:    aload_0 
L19:    areturn 
L20:    
    .end code 
.end method 

.method public [143] : [144] 
    .attribute [134] .code stack 5 locals 0 
L0:     aload_0 
L1:     getfield [14] 
L4:     new [28] 
L7:     dup 
L8:     iload_1 
L9:     bipush 24 
L11:    ishr 
L12:    i2b 
L13:    invokespecial [20] 
L16:    invokeinterface [29] 0 
L21:    pop 
L22:    aload_0 
L23:    getfield [14] 
L26:    new [28] 
L29:    dup 
L30:    iload_1 
L31:    bipush 16 
L33:    ishr 
L34:    i2b 
L35:    invokespecial [20] 
L38:    invokeinterface [29] 0 
L43:    pop 
L44:    aload_0 
L45:    getfield [14] 
L48:    new [28] 
L51:    dup 
L52:    iload_1 
L53:    bipush 8 
L55:    ishr 
L56:    i2b 
L57:    invokespecial [20] 
L60:    invokeinterface [29] 0 
L65:    pop 
L66:    aload_0 
L67:    getfield [14] 
L70:    new [28] 
L73:    dup 
L74:    iload_1 
L75:    i2b 
L76:    invokespecial [20] 
L79:    invokeinterface [29] 0 
L84:    pop 
L85:    aload_0 
L86:    areturn 
L87:    nop 
L88:    
    .end code 
.end method 

.method public [145] : [146] 
    .attribute [134] .code stack 4 locals 0 
L0:     aload_0 
L1:     lload_1 
L2:     bipush 32 
L4:     lshr 
L5:     l2i 
L6:     invokevirtual [16] 
L9:     pop 
L10:    aload_0 
L11:    lload_1 
L12:    l2i 
L13:    invokevirtual [16] 
L16:    pop 
L17:    aload_0 
L18:    areturn 
L19:    nop 
L20:    
    .end code 
.end method 

.method public final [147] : [148] 
    .attribute [134] .code stack 5 locals 0 
L0:     aload_0 
L1:     getfield [14] 
L4:     new [28] 
L7:     dup 
L8:     iload_1 
L9:     bipush 8 
L11:    ishr 
L12:    i2b 
L13:    invokespecial [20] 
L16:    invokeinterface [29] 0 
L21:    pop 
L22:    aload_0 
L23:    getfield [14] 
L26:    new [28] 
L29:    dup 
L30:    iload_1 
L31:    i2b 
L32:    invokespecial [20] 
L35:    invokeinterface [29] 0 
L40:    pop 
L41:    aload_0 
L42:    areturn 
L43:    nop 
L44:    
    .end code 
.end method 

.method public final [149] : [150] 
    .attribute [134] .code stack 4 locals 3 
L0:     aload_1 
L1:     invokevirtual [17] 
L4:     istore_2 
L5:     iload_2 
L6:     ldc [4] 
L8:     if_icmpgt L40 
L11:    aload_0 
L12:    aload_1 
L13:    invokespecial [21] 
L16:    dup2 
L17:    lstore_3 
L18:    ldc_w [1] 
L21:    lcmp 
L22:    ifgt L40 
L25:    aload_0 
L26:    lload_3 
L27:    l2i 
L28:    invokespecial [22] 
L31:    pop 
L32:    aload_0 
L33:    aload_1 
L34:    invokespecial [23] 
L37:    goto L53 
L40:    new [30] 
L43:    dup 
L44:    ldc [6] 
L46:    invokestatic [7] 
L49:    invokespecial [24] 
L52:    athrow 
L53:    aload_0 
L54:    areturn 
L55:    nop 
L56:    
    .end code 
.end method 

.method private [151] : [152] 
    .attribute [134] .code stack 2 locals 4 
L0:     iconst_0 
L1:     istore_2 
L2:     aload_1 
L3:     invokevirtual [17] 
L6:     istore_3 
L7:     iconst_0 
L8:     istore 4 
L10:    iload 4 
L12:    iload_3 
L13:    if_icmpge L65 
L16:    aload_1 
L17:    iload 4 
L19:    invokevirtual [18] 
L22:    istore 5 
L24:    iload 5 
L26:    ifle L42 
L29:    iload 5 
L31:    bipush 127 
L33:    if_icmpgt L42 
L36:    iinc 2 1 
L39:    goto L59 
L42:    iload 5 
L44:    sipush 2047 
L47:    if_icmpgt L56 
L50:    iinc 2 2 
L53:    goto L59 
L56:    iinc 2 3 
L59:    iinc 4 1 
L62:    goto L10 
L65:    iload_2 
L66:    i2l 
L67:    freturn 
L68:    
    .end code 
.end method 

.method private [153] : [154] 
    .attribute [134] .code stack 7 locals 2 
L0:     iconst_0 
L1:     istore_2 
L2:     iload_2 
L3:     aload_1 
L4:     invokevirtual [17] 
L7:     if_icmpge L203 
L10:    aload_1 
L11:    iload_2 
L12:    invokevirtual [18] 
L15:    istore_3 
L16:    iload_3 
L17:    ifle L48 
L20:    iload_3 
L21:    bipush 127 
L23:    if_icmpgt L48 
L26:    aload_0 
L27:    getfield [14] 
L30:    new [28] 
L33:    dup 
L34:    iload_3 
L35:    i2b 
L36:    invokespecial [20] 
L39:    invokeinterface [29] 0 
L44:    pop 
L45:    goto L197 
L48:    iload_3 
L49:    sipush 2047 
L52:    if_icmpgt L113 
L55:    aload_0 
L56:    getfield [14] 
L59:    new [28] 
L62:    dup 
L63:    sipush 192 
L66:    bipush 31 
L68:    iload_3 
L69:    bipush 6 
L71:    ishr 
L72:    iand 
L73:    ior 
L74:    i2b 
L75:    invokespecial [20] 
L78:    invokeinterface [29] 0 
L83:    pop 
L84:    aload_0 
L85:    getfield [14] 
L88:    new [28] 
L91:    dup 
L92:    sipush 128 
L95:    bipush 63 
L97:    iload_3 
L98:    iand 
L99:    ior 
L100:   i2b 
L101:   invokespecial [20] 
L104:   invokeinterface [29] 0 
L109:   pop 
L110:   goto L197 
L113:   aload_0 
L114:   getfield [14] 
L117:   new [28] 
L120:   dup 
L121:   sipush 224 
L124:   bipush 15 
L126:   iload_3 
L127:   bipush 12 
L129:   ishr 
L130:   iand 
L131:   ior 
L132:   i2b 
L133:   invokespecial [20] 
L136:   invokeinterface [29] 0 
L141:   pop 
L142:   aload_0 
L143:   getfield [14] 
L146:   new [28] 
L149:   dup 
L150:   sipush 128 
L153:   bipush 63 
L155:   iload_3 
L156:   bipush 6 
L158:   ishr 
L159:   iand 
L160:   ior 
L161:   i2b 
L162:   invokespecial [20] 
L165:   invokeinterface [29] 0 
L170:   pop 
L171:   aload_0 
L172:   getfield [14] 
L175:   new [28] 
L178:   dup 
L179:   sipush 128 
L182:   bipush 63 
L184:   iload_3 
L185:   iand 
L186:   ior 
L187:   i2b 
L188:   invokespecial [20] 
L191:   invokeinterface [29] 0 
L196:   pop 
L197:   iinc 2 1 
L200:   goto L2 
L203:   return 
L204:   
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Method [32] [33] 
.const [3] = Class [34] 
.const [4] = Int -65536 
.const [5] = Class [35] 
.const [6] = String [36] 
.const [7] = Method [37] [38] 
.const [8] = Class [39] 
.const [9] = Class [40] 
.const [10] = Class [41] 
.const [11] = Class [42] 
.const [12] = Class [43] 
.const [13] = Class [44] 
.const [14] = Field [45] [46] 
.const [15] = Method [47] [48] 
.const [16] = Method [49] [50] 
.const [17] = Method [51] [52] 
.const [18] = Method [53] [54] 
.const [19] = Method [55] [56] 
.const [20] = Method [57] [58] 
.const [21] = Method [59] [60] 
.const [22] = Method [61] [62] 
.const [23] = Method [63] [64] 
.const [24] = Method [65] [66] 
.const [25] = Field [67] [68] 
.const [26] = InterfaceMethod [69] [70] 
.const [27] = InterfaceMethod [71] [72] 
.const [28] = Class [73] 
.const [29] = InterfaceMethod [74] [75] 
.const [30] = Class [76] 
.const [31] = Int -65536 
.const [32] = Class [77] 
.const [33] = NameAndType [78] [79] 
.const [34] = Utf8 java/lang/Byte 
.const [35] = Utf8 java/io/UTFDataFormatException 
.const [36] = Utf8 K0068 
.const [37] = Class [80] 
.const [38] = NameAndType [81] [82] 
.const [39] = Utf8 de/audi/atip/utils/ByteArrayBuilder 
.const [40] = Utf8 java/lang/Object 
.const [41] = Utf8 de/audi/atip/utils/generics/Generics 
.const [42] = Utf8 de/audi/atip/utils/generics/GList 
.const [43] = Utf8 java/lang/String 
.const [44] = Utf8 com/ibm/oti/util/Msg 
.const [45] = Class [83] 
.const [46] = NameAndType [84] [85] 
.const [47] = Class [86] 
.const [48] = NameAndType [87] [88] 
.const [49] = Class [89] 
.const [50] = NameAndType [90] [91] 
.const [51] = Class [92] 
.const [52] = NameAndType [93] [94] 
.const [53] = Class [95] 
.const [54] = NameAndType [96] [97] 
.const [55] = Class [98] 
.const [56] = NameAndType [99] [100] 
.const [57] = Class [101] 
.const [58] = NameAndType [102] [103] 
.const [59] = Class [104] 
.const [60] = NameAndType [105] [106] 
.const [61] = Class [107] 
.const [62] = NameAndType [108] [109] 
.const [63] = Class [110] 
.const [64] = NameAndType [111] [112] 
.const [65] = Class [113] 
.const [66] = NameAndType [114] [115] 
.const [67] = Class [116] 
.const [68] = NameAndType [117] [118] 
.const [69] = Class [119] 
.const [70] = NameAndType [120] [121] 
.const [71] = Class [122] 
.const [72] = NameAndType [123] [124] 
.const [73] = Utf8 java/lang/Byte 
.const [74] = Class [125] 
.const [75] = NameAndType [126] [127] 
.const [76] = Utf8 java/io/UTFDataFormatException 
.const [77] = Utf8 de/audi/atip/utils/generics/Generics 
.const [78] = Utf8 newArrayList 
.const [79] = Utf8 ()Lde/audi/atip/utils/generics/GList; 
.const [80] = Utf8 com/ibm/oti/util/Msg 
.const [81] = Utf8 getString 
.const [82] = Utf8 (Ljava/lang/String;)Ljava/lang/String; 
.const [83] = Utf8 de/audi/atip/utils/ByteArrayBuilder 
.const [84] = Utf8 byteList 
.const [85] = Utf8 Lde/audi/atip/utils/generics/GList; 
.const [86] = Utf8 java/lang/Byte 
.const [87] = Utf8 byteValue 
.const [88] = Utf8 ()B 
.const [89] = Utf8 de/audi/atip/utils/ByteArrayBuilder 
.const [90] = Utf8 addInt 
.const [91] = Utf8 (I)Lde/audi/atip/utils/ByteArrayBuilder; 
.const [92] = Utf8 java/lang/String 
.const [93] = Utf8 length 
.const [94] = Utf8 ()I 
.const [95] = Utf8 java/lang/String 
.const [96] = Utf8 charAt 
.const [97] = Utf8 (I)C 
.const [98] = Utf8 java/lang/Object 
.const [99] = Utf8 <init> 
.const [100] = Utf8 ()V 
.const [101] = Utf8 java/lang/Byte 
.const [102] = Utf8 <init> 
.const [103] = Utf8 (B)V 
.const [104] = Utf8 de/audi/atip/utils/ByteArrayBuilder 
.const [105] = Utf8 countUTFBytes 
.const [106] = Utf8 (Ljava/lang/String;)J 
.const [107] = Utf8 de/audi/atip/utils/ByteArrayBuilder 
.const [108] = Utf8 addShort 
.const [109] = Utf8 (I)Lde/audi/atip/utils/ByteArrayBuilder; 
.const [110] = Utf8 de/audi/atip/utils/ByteArrayBuilder 
.const [111] = Utf8 addUTFBytes 
.const [112] = Utf8 (Ljava/lang/String;)V 
.const [113] = Utf8 java/io/UTFDataFormatException 
.const [114] = Utf8 <init> 
.const [115] = Utf8 (Ljava/lang/String;)V 
.const [116] = Utf8 de/audi/atip/utils/ByteArrayBuilder 
.const [117] = Utf8 byteList 
.const [118] = Utf8 Lde/audi/atip/utils/generics/GList; 
.const [119] = Utf8 de/audi/atip/utils/generics/GList 
.const [120] = Utf8 size 
.const [121] = Utf8 ()I 
.const [122] = Utf8 de/audi/atip/utils/generics/GList 
.const [123] = Utf8 get 
.const [124] = Utf8 (I)Ljava/lang/Object; 
.const [125] = Utf8 de/audi/atip/utils/generics/GList 
.const [126] = Utf8 add 
.const [127] = Utf8 (Ljava/lang/Object;)Z 
.const [128] = Utf8 de/audi/atip/utils/ByteArrayBuilder 
.const [129] = Class [128] 
.const [130] = Utf8 java/lang/Object 
.const [131] = Class [130] 
.const [132] = Utf8 byteList 
.const [133] = Utf8 Lde/audi/atip/utils/generics/GList; 
.const [134] = Utf8 Code 
.const [135] = Utf8 <init> 
.const [136] = Utf8 ()V 
.const [137] = Utf8 build 
.const [138] = Utf8 ()[B 
.const [139] = Utf8 addBoolean 
.const [140] = Utf8 (Z)Lde/audi/atip/utils/ByteArrayBuilder; 
.const [141] = Utf8 addByte 
.const [142] = Utf8 (B)Lde/audi/atip/utils/ByteArrayBuilder; 
.const [143] = Utf8 addInt 
.const [144] = Utf8 (I)Lde/audi/atip/utils/ByteArrayBuilder; 
.const [145] = Utf8 addLong 
.const [146] = Utf8 (J)Lde/audi/atip/utils/ByteArrayBuilder; 
.const [147] = Utf8 addShort 
.const [148] = Utf8 (I)Lde/audi/atip/utils/ByteArrayBuilder; 
.const [149] = Utf8 addUTF 
.const [150] = Utf8 (Ljava/lang/String;)Lde/audi/atip/utils/ByteArrayBuilder; 
.const [151] = Utf8 countUTFBytes 
.const [152] = Utf8 (Ljava/lang/String;)J 
.const [153] = Utf8 addUTFBytes 
.const [154] = Utf8 (Ljava/lang/String;)V 
.end class 
