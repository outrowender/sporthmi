.version 50 0 
.class public super [231] 
.super [233] 
.field private static [234] [235] 
.field private [236] [237] 

.method public static synchronized [239] : [240] 
    .attribute [238] .code stack 2 locals 0 
L0:     getstatic [2] 
L3:     ifnonnull L16 
L6:     new [49] 
L9:     dup 
L10:    invokespecial [37] 
L13:    putstatic [36] 
L16:    getstatic [2] 
L19:    areturn 
L20:    
    .end code 
.end method 

.method private [241] : [242] 
    .attribute [238] .code stack 4 locals 0 
L0:     aload_0 
L1:     invokespecial [38] 
L4:     aload_0 
L5:     new [50] 
L8:     dup 
L9:     invokespecial [39] 
L12:    putfield [51] 
L15:    aload_0 
L16:    ldc [5] 
L18:    new [52] 
L21:    dup 
L22:    invokespecial [40] 
L25:    invokespecial [41] 
L28:    aload_0 
L29:    ldc [7] 
L31:    new [53] 
L34:    dup 
L35:    invokespecial [42] 
L38:    invokespecial [41] 
L41:    return 
L42:    nop 
L43:    nop 
L44:    
    .end code 
.end method 

.method private [243] : [244] 
    .attribute [238] .code stack 3 locals 0 
L0:     aload_0 
L1:     getfield [24] 
L4:     aload_1 
L5:     invokevirtual [25] 
L8:     aload_2 
L9:     invokevirtual [26] 
L12:    pop 
L13:    return 
L14:    nop 
L15:    nop 
L16:    
    .end code 
.end method 

.method private [245] : [246] 
    .attribute [238] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [24] 
L4:     aload_1 
L5:     invokevirtual [25] 
L8:     invokevirtual [27] 
L11:    checkcast [9] 
L14:    areturn 
L15:    nop 
L16:    
    .end code 
.end method 

.method public [247] : [248] 
    .attribute [238] .code stack 5 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     aload_2 
L3:     new [54] 
L6:     dup 
L7:     invokespecial [43] 
L10:    invokevirtual [28] 
L13:    return 
L14:    nop 
L15:    nop 
L16:    
    .end code 
.end method 

.method public [249] : [250] 
    .attribute [238] .code stack 5 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     aload_2 
L3:     new [54] 
L6:     dup 
L7:     invokespecial [43] 
L10:    invokevirtual [29] 
L13:    areturn 
L14:    nop 
L15:    nop 
L16:    
    .end code 
.end method 

.method public synchronized [251] : [252] 
    .attribute [238] .code stack 4 locals 5 
L0:     aload_1 
L1:     ldc [11] 
L3:     invokevirtual [30] 
L6:     istore 4 
L8:     iload 4 
L10:    iconst_m1 
L11:    if_icmpne L41 
L14:    new [55] 
L17:    dup 
L18:    new [56] 
L21:    dup 
L22:    invokespecial [44] 
L25:    ldc [14] 
L27:    invokevirtual [31] 
L30:    aload_1 
L31:    invokevirtual [31] 
L34:    invokevirtual [32] 
L37:    invokespecial [45] 
L40:    athrow 
L41:    aload_1 
L42:    iload 4 
L44:    iconst_1 
L45:    iadd 
L46:    invokevirtual [33] 
L49:    astore 5 
L51:    aload_0 
L52:    aload 5 
L54:    invokespecial [46] 
L57:    astore 6 
L59:    aload 6 
L61:    ifnonnull L91 
L64:    new [55] 
L67:    dup 
L68:    new [56] 
L71:    dup 
L72:    invokespecial [44] 
L75:    ldc [15] 
L77:    invokevirtual [31] 
L80:    aload_1 
L81:    invokevirtual [31] 
L84:    invokevirtual [32] 
L87:    invokespecial [45] 
L90:    athrow 
L91:    new [57] 
L94:    dup 
L95:    aload_1 
L96:    invokespecial [47] 
L99:    astore 7 
        .catch [0] from L101 to L112 using L120 
L101:   aload 6 
L103:   aload 7 
L105:   aload_2 
L106:   aload_3 
L107:   invokeinterface [58] 0 
L112:   aload 7 
L114:   invokevirtual [34] 
L117:   goto L130 
        .catch [0] from L120 to L122 using L120 
        .catch [17] from L91 to L130 using L133 
L120:   astore 8 
L122:   aload 7 
L124:   invokevirtual [34] 
L127:   aload 8 
L129:   athrow 
L130:   goto L162 
L133:   astore 7 
L135:   new [55] 
L138:   dup 
L139:   new [56] 
L142:   dup 
L143:   invokespecial [44] 
L146:   ldc [18] 
L148:   invokevirtual [31] 
L151:   aload_1 
L152:   invokevirtual [31] 
L155:   invokevirtual [32] 
L158:   invokespecial [45] 
L161:   athrow 
L162:   return 
L163:   nop 
L164:   
    .end code 
.end method 

.method public synchronized [253] : [254] 
    .attribute [238] .code stack 4 locals 2 
L0:     aload_0 
L1:     aload_1 
L2:     invokespecial [46] 
L5:     astore 4 
L7:     aload 4 
L9:     ifnonnull L39 
L12:    new [55] 
L15:    dup 
L16:    new [56] 
L19:    dup 
L20:    invokespecial [44] 
L23:    ldc [19] 
L25:    invokevirtual [31] 
L28:    aload_1 
L29:    invokevirtual [31] 
L32:    invokevirtual [32] 
L35:    invokespecial [45] 
L38:    athrow 
L39:    new [59] 
L42:    dup 
L43:    invokespecial [48] 
L46:    astore 5 
L48:    aload 4 
L50:    aload 5 
L52:    aload_2 
L53:    aload_3 
L54:    invokeinterface [58] 0 
L59:    aload 5 
L61:    invokevirtual [35] 
L64:    areturn 
L65:    nop 
L66:    nop 
L67:    nop 
L68:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Field [60] [61] 
.const [3] = Class [62] 
.const [4] = Class [63] 
.const [5] = String [64] 
.const [6] = Class [65] 
.const [7] = String [66] 
.const [8] = Class [67] 
.const [9] = Class [68] 
.const [10] = Class [69] 
.const [11] = String [70] 
.const [12] = Class [71] 
.const [13] = Class [72] 
.const [14] = String [73] 
.const [15] = String [74] 
.const [16] = Class [75] 
.const [17] = Class [76] 
.const [18] = String [77] 
.const [19] = String [78] 
.const [20] = Class [79] 
.const [21] = Class [80] 
.const [22] = Class [81] 
.const [23] = Class [82] 
.const [24] = Field [83] [84] 
.const [25] = Method [85] [86] 
.const [26] = Method [87] [88] 
.const [27] = Method [89] [90] 
.const [28] = Method [91] [92] 
.const [29] = Method [93] [94] 
.const [30] = Method [95] [96] 
.const [31] = Method [97] [98] 
.const [32] = Method [99] [100] 
.const [33] = Method [101] [102] 
.const [34] = Method [103] [104] 
.const [35] = Method [105] [106] 
.const [36] = Field [107] [108] 
.const [37] = Method [109] [110] 
.const [38] = Method [111] [112] 
.const [39] = Method [113] [114] 
.const [40] = Method [115] [116] 
.const [41] = Method [117] [118] 
.const [42] = Method [119] [120] 
.const [43] = Method [121] [122] 
.const [44] = Method [123] [124] 
.const [45] = Method [125] [126] 
.const [46] = Method [127] [128] 
.const [47] = Method [129] [130] 
.const [48] = Method [131] [132] 
.const [49] = Class [133] 
.const [50] = Class [134] 
.const [51] = Field [135] [136] 
.const [52] = Class [137] 
.const [53] = Class [138] 
.const [54] = Class [139] 
.const [55] = Class [140] 
.const [56] = Class [141] 
.const [57] = Class [142] 
.const [58] = InterfaceMethod [143] [144] 
.const [59] = Class [145] 
.const [60] = Class [146] 
.const [61] = NameAndType [147] [148] 
.const [62] = Utf8 de/esolutions/fw/util/config/writer/ConfigWriterRegistry 
.const [63] = Utf8 java/util/HashMap 
.const [64] = Utf8 json 
.const [65] = Utf8 de/esolutions/fw/util/config/writer/JSONConfigWriter 
.const [66] = Utf8 bcf 
.const [67] = Utf8 de/esolutions/fw/util/config/bcf/BCFConfigWriter 
.const [68] = Utf8 de/esolutions/fw/util/config/writer/IConfigWriter 
.const [69] = Utf8 de/esolutions/fw/util/config/model/ConfigDictionary 
.const [70] = Utf8 '.' 
.const [71] = Utf8 de/esolutions/fw/util/config/writer/WriteConfigException 
.const [72] = Utf8 java/lang/StringBuffer 
.const [73] = Utf8 'No file extension given: ' 
.const [74] = Utf8 'No writer for file found: ' 
.const [75] = Utf8 java/io/FileOutputStream 
.const [76] = Utf8 java/io/IOException 
.const [77] = Utf8 "Can't open file: " 
.const [78] = Utf8 'No writer for extension found: ' 
.const [79] = Utf8 java/io/ByteArrayOutputStream 
.const [80] = Utf8 java/lang/Object 
.const [81] = Utf8 java/lang/String 
.const [82] = Utf8 java/io/OutputStream 
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
.const [93] = Class [164] 
.const [94] = NameAndType [165] [166] 
.const [95] = Class [167] 
.const [96] = NameAndType [168] [169] 
.const [97] = Class [170] 
.const [98] = NameAndType [171] [172] 
.const [99] = Class [173] 
.const [100] = NameAndType [174] [175] 
.const [101] = Class [176] 
.const [102] = NameAndType [177] [178] 
.const [103] = Class [179] 
.const [104] = NameAndType [180] [181] 
.const [105] = Class [182] 
.const [106] = NameAndType [183] [184] 
.const [107] = Class [185] 
.const [108] = NameAndType [186] [187] 
.const [109] = Class [188] 
.const [110] = NameAndType [189] [190] 
.const [111] = Class [191] 
.const [112] = NameAndType [192] [193] 
.const [113] = Class [194] 
.const [114] = NameAndType [195] [196] 
.const [115] = Class [197] 
.const [116] = NameAndType [198] [199] 
.const [117] = Class [200] 
.const [118] = NameAndType [201] [202] 
.const [119] = Class [203] 
.const [120] = NameAndType [204] [205] 
.const [121] = Class [206] 
.const [122] = NameAndType [207] [208] 
.const [123] = Class [209] 
.const [124] = NameAndType [210] [211] 
.const [125] = Class [212] 
.const [126] = NameAndType [213] [214] 
.const [127] = Class [215] 
.const [128] = NameAndType [216] [217] 
.const [129] = Class [218] 
.const [130] = NameAndType [219] [220] 
.const [131] = Class [221] 
.const [132] = NameAndType [222] [223] 
.const [133] = Utf8 de/esolutions/fw/util/config/writer/ConfigWriterRegistry 
.const [134] = Utf8 java/util/HashMap 
.const [135] = Class [224] 
.const [136] = NameAndType [225] [226] 
.const [137] = Utf8 de/esolutions/fw/util/config/writer/JSONConfigWriter 
.const [138] = Utf8 de/esolutions/fw/util/config/bcf/BCFConfigWriter 
.const [139] = Utf8 de/esolutions/fw/util/config/model/ConfigDictionary 
.const [140] = Utf8 de/esolutions/fw/util/config/writer/WriteConfigException 
.const [141] = Utf8 java/lang/StringBuffer 
.const [142] = Utf8 java/io/FileOutputStream 
.const [143] = Class [227] 
.const [144] = NameAndType [228] [229] 
.const [145] = Utf8 java/io/ByteArrayOutputStream 
.const [146] = Utf8 de/esolutions/fw/util/config/writer/ConfigWriterRegistry 
.const [147] = Utf8 registry 
.const [148] = Utf8 Lde/esolutions/fw/util/config/writer/ConfigWriterRegistry; 
.const [149] = Utf8 de/esolutions/fw/util/config/writer/ConfigWriterRegistry 
.const [150] = Utf8 writerMap 
.const [151] = Utf8 Ljava/util/HashMap; 
.const [152] = Utf8 java/lang/String 
.const [153] = Utf8 toLowerCase 
.const [154] = Utf8 ()Ljava/lang/String; 
.const [155] = Utf8 java/util/HashMap 
.const [156] = Utf8 put 
.const [157] = Utf8 (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object; 
.const [158] = Utf8 java/util/HashMap 
.const [159] = Utf8 get 
.const [160] = Utf8 (Ljava/lang/Object;)Ljava/lang/Object; 
.const [161] = Utf8 de/esolutions/fw/util/config/writer/ConfigWriterRegistry 
.const [162] = Utf8 writeToFile 
.const [163] = Utf8 (Ljava/lang/String;Lde/esolutions/fw/util/config/ConfigValue;Lde/esolutions/fw/util/config/model/ConfigDictionary;)V 
.const [164] = Utf8 de/esolutions/fw/util/config/writer/ConfigWriterRegistry 
.const [165] = Utf8 writeToMemory 
.const [166] = Utf8 (Ljava/lang/String;Lde/esolutions/fw/util/config/ConfigValue;Lde/esolutions/fw/util/config/model/ConfigDictionary;)[B 
.const [167] = Utf8 java/lang/String 
.const [168] = Utf8 lastIndexOf 
.const [169] = Utf8 (Ljava/lang/String;)I 
.const [170] = Utf8 java/lang/StringBuffer 
.const [171] = Utf8 append 
.const [172] = Utf8 (Ljava/lang/String;)Ljava/lang/StringBuffer; 
.const [173] = Utf8 java/lang/StringBuffer 
.const [174] = Utf8 toString 
.const [175] = Utf8 ()Ljava/lang/String; 
.const [176] = Utf8 java/lang/String 
.const [177] = Utf8 substring 
.const [178] = Utf8 (I)Ljava/lang/String; 
.const [179] = Utf8 java/io/OutputStream 
.const [180] = Utf8 close 
.const [181] = Utf8 ()V 
.const [182] = Utf8 java/io/ByteArrayOutputStream 
.const [183] = Utf8 toByteArray 
.const [184] = Utf8 ()[B 
.const [185] = Utf8 de/esolutions/fw/util/config/writer/ConfigWriterRegistry 
.const [186] = Utf8 registry 
.const [187] = Utf8 Lde/esolutions/fw/util/config/writer/ConfigWriterRegistry; 
.const [188] = Utf8 de/esolutions/fw/util/config/writer/ConfigWriterRegistry 
.const [189] = Utf8 <init> 
.const [190] = Utf8 ()V 
.const [191] = Utf8 java/lang/Object 
.const [192] = Utf8 <init> 
.const [193] = Utf8 ()V 
.const [194] = Utf8 java/util/HashMap 
.const [195] = Utf8 <init> 
.const [196] = Utf8 ()V 
.const [197] = Utf8 de/esolutions/fw/util/config/writer/JSONConfigWriter 
.const [198] = Utf8 <init> 
.const [199] = Utf8 ()V 
.const [200] = Utf8 de/esolutions/fw/util/config/writer/ConfigWriterRegistry 
.const [201] = Utf8 addWriter 
.const [202] = Utf8 (Ljava/lang/String;Lde/esolutions/fw/util/config/writer/IConfigWriter;)V 
.const [203] = Utf8 de/esolutions/fw/util/config/bcf/BCFConfigWriter 
.const [204] = Utf8 <init> 
.const [205] = Utf8 ()V 
.const [206] = Utf8 de/esolutions/fw/util/config/model/ConfigDictionary 
.const [207] = Utf8 <init> 
.const [208] = Utf8 ()V 
.const [209] = Utf8 java/lang/StringBuffer 
.const [210] = Utf8 <init> 
.const [211] = Utf8 ()V 
.const [212] = Utf8 de/esolutions/fw/util/config/writer/WriteConfigException 
.const [213] = Utf8 <init> 
.const [214] = Utf8 (Ljava/lang/String;)V 
.const [215] = Utf8 de/esolutions/fw/util/config/writer/ConfigWriterRegistry 
.const [216] = Utf8 queryWriter 
.const [217] = Utf8 (Ljava/lang/String;)Lde/esolutions/fw/util/config/writer/IConfigWriter; 
.const [218] = Utf8 java/io/FileOutputStream 
.const [219] = Utf8 <init> 
.const [220] = Utf8 (Ljava/lang/String;)V 
.const [221] = Utf8 java/io/ByteArrayOutputStream 
.const [222] = Utf8 <init> 
.const [223] = Utf8 ()V 
.const [224] = Utf8 de/esolutions/fw/util/config/writer/ConfigWriterRegistry 
.const [225] = Utf8 writerMap 
.const [226] = Utf8 Ljava/util/HashMap; 
.const [227] = Utf8 de/esolutions/fw/util/config/writer/IConfigWriter 
.const [228] = Utf8 writeToOutputStream 
.const [229] = Utf8 (Ljava/io/OutputStream;Lde/esolutions/fw/util/config/ConfigValue;Lde/esolutions/fw/util/config/model/ConfigDictionary;)V 
.const [230] = Utf8 de/esolutions/fw/util/config/writer/ConfigWriterRegistry 
.const [231] = Class [230] 
.const [232] = Utf8 java/lang/Object 
.const [233] = Class [232] 
.const [234] = Utf8 registry 
.const [235] = Utf8 Lde/esolutions/fw/util/config/writer/ConfigWriterRegistry; 
.const [236] = Utf8 writerMap 
.const [237] = Utf8 Ljava/util/HashMap; 
.const [238] = Utf8 Code 
.const [239] = Utf8 getInstance 
.const [240] = Utf8 ()Lde/esolutions/fw/util/config/writer/ConfigWriterRegistry; 
.const [241] = Utf8 <init> 
.const [242] = Utf8 ()V 
.const [243] = Utf8 addWriter 
.const [244] = Utf8 (Ljava/lang/String;Lde/esolutions/fw/util/config/writer/IConfigWriter;)V 
.const [245] = Utf8 queryWriter 
.const [246] = Utf8 (Ljava/lang/String;)Lde/esolutions/fw/util/config/writer/IConfigWriter; 
.const [247] = Utf8 writeToFile 
.const [248] = Utf8 (Ljava/lang/String;Lde/esolutions/fw/util/config/ConfigValue;)V 
.const [249] = Utf8 writeToMemory 
.const [250] = Utf8 (Ljava/lang/String;Lde/esolutions/fw/util/config/ConfigValue;)[B 
.const [251] = Utf8 writeToFile 
.const [252] = Utf8 (Ljava/lang/String;Lde/esolutions/fw/util/config/ConfigValue;Lde/esolutions/fw/util/config/model/ConfigDictionary;)V 
.const [253] = Utf8 writeToMemory 
.const [254] = Utf8 (Ljava/lang/String;Lde/esolutions/fw/util/config/ConfigValue;Lde/esolutions/fw/util/config/model/ConfigDictionary;)[B 
.end class 
