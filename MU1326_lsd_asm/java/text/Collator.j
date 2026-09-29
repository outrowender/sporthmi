.version 50 0 
.class public super abstract [293] 
.super [295] 
.implements [297] 
.implements [299] 
.field static final [300] [301] 
.field static final [302] [303] 
.field static final [304] [305] 
.field public static final [306] [307] 
.field public static final [308] [309] 
.field public static final [310] [311] 
.field public static final [312] [313] 
.field public static final [314] [315] 
.field public static final [316] [317] 
.field public static final [318] [319] 
.field private static [320] [321] 
.field private static [322] [323] 
.field private [324] [325] 
.field private [326] [327] 

.method static [329] : [330] 
    .attribute [328] .code stack 3 locals 1 
L0:     new [60] 
L3:     dup 
L4:     invokespecial [50] 
L7:     putstatic [51] 
L10:    new [61] 
L13:    dup 
L14:    ldc [7] 
L16:    invokespecial [52] 
L19:    invokestatic [9] 
L22:    checkcast [10] 
L25:    astore_0 
L26:    aload_0 
L27:    ifnull L49 
        .catch [14] from L30 to L40 using L40 
L30:    aload_0 
L31:    invokestatic [12] 
L34:    putstatic [53] 
L37:    goto L54 
L40:    pop 
L41:    bipush 6 
L43:    putstatic [53] 
L46:    goto L54 
L49:    bipush 6 
L51:    putstatic [53] 
L54:    return 
L55:    nop 
L56:    
    .end code 
.end method 

.method protected [331] : [332] 
    .attribute [328] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [54] 
L4:     aload_0 
L5:     iconst_2 
L6:     putfield [62] 
L9:     aload_0 
L10:    iconst_1 
L11:    putfield [63] 
L14:    return 
L15:    nop 
L16:    
    .end code 
.end method 

.method public [333] : [334] 
    .attribute [328] .code stack 1 locals 0 
        .catch [15] from L0 to L5 using L5 
L0:     aload_0 
L1:     invokespecial [55] 
L4:     areturn 
L5:     pop 
L6:     aconst_null 
L7:     areturn 
L8:     
    .end code 
.end method 

.method public [335] : [336] 
    .attribute [328] .code stack 3 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     checkcast [10] 
L5:     aload_2 
L6:     checkcast [10] 
L9:     invokevirtual [36] 
L12:    areturn 
L13:    nop 
L14:    nop 
L15:    nop 
L16:    
    .end code 
.end method 

.method public abstract [337] : [338] 
    .attribute [328] .code stack 0 locals 0 
L0:     
    .end code 
.end method 

.method public [339] : [340] 
    .attribute [328] .code stack 2 locals 1 
L0:     aload_1 
L1:     instanceof [2] 
L4:     ifne L9 
L7:     iconst_0 
L8:     areturn 
L9:     aload_1 
L10:    checkcast [2] 
L13:    astore_2 
L14:    aload_0 
L15:    getfield [34] 
L18:    aload_2 
L19:    getfield [34] 
L22:    if_icmpne L38 
L25:    aload_0 
L26:    getfield [35] 
L29:    aload_2 
L30:    getfield [35] 
L33:    if_icmpne L38 
L36:    iconst_1 
L37:    areturn 
L38:    iconst_0 
L39:    areturn 
L40:    
    .end code 
.end method 

.method public [341] : [342] 
    .attribute [328] .code stack 3 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     aload_2 
L3:     invokevirtual [36] 
L6:     ifne L11 
L9:     iconst_1 
L10:    areturn 
L11:    iconst_0 
L12:    areturn 
L13:    nop 
L14:    nop 
L15:    nop 
L16:    
    .end code 
.end method 

.method public static [343] : [344] 
    .attribute [328] .code stack 1 locals 0 
L0:     invokestatic [17] 
L3:     areturn 
L4:     
    .end code 
.end method 

.method public abstract [345] : [346] 
    .attribute [328] .code stack 0 locals 0 
L0:     
    .end code 
.end method 

.method public interface [347] : [348] 
    .attribute [328] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [35] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public static [349] : [350] 
    .attribute [328] .code stack 1 locals 0 
L0:     invokestatic [18] 
L3:     invokestatic [19] 
L6:     areturn 
L7:     nop 
L8:     
    .end code 
.end method 

.method public static [351] : [352] 
    .attribute [328] .code stack 5 locals 5 
L0:     aload_0 
L1:     invokevirtual [37] 
L4:     astore_1 
L5:     getstatic [5] 
L8:     invokevirtual [38] 
L11:    iconst_1 
L12:    isub 
L13:    istore_2 
L14:    goto L53 
L17:    getstatic [5] 
L20:    iload_2 
L21:    invokevirtual [39] 
L24:    aload_1 
L25:    invokevirtual [40] 
L28:    ifeq L50 
L31:    getstatic [5] 
L34:    iload_2 
L35:    iconst_1 
L36:    isub 
L37:    invokevirtual [39] 
L40:    checkcast [2] 
L43:    invokevirtual [41] 
L46:    checkcast [2] 
L49:    areturn 
L50:    iinc 2 -2 
L53:    iload_2 
L54:    ifge L17 
L57:    aload_0 
L58:    invokestatic [21] 
L61:    checkcast [22] 
L64:    astore_2 
L65:    aload_2 
L66:    getstatic [24] 
L69:    invokevirtual [42] 
L72:    checkcast [10] 
L75:    astore_3 
L76:    iconst_1 
L77:    istore 4 
        .catch [33] from L79 to L101 using L101 
        .catch [32] from L76 to L192 using L192 
L79:    aload_2 
L80:    getstatic [25] 
L83:    invokevirtual [42] 
L86:    astore 5 
L88:    aload 5 
L90:    checkcast [11] 
L93:    invokevirtual [43] 
L96:    istore 4 
L98:    goto L102 
L101:   pop 
L102:   new [64] 
L105:   dup 
L106:   new [65] 
L109:   dup 
L110:   getstatic [29] 
L113:   invokestatic [30] 
L116:   invokespecial [56] 
L119:   aload_3 
L120:   invokevirtual [44] 
L123:   invokevirtual [45] 
L126:   iload 4 
L128:   invokespecial [57] 
L131:   astore 5 
L133:   aload 5 
L135:   iconst_0 
L136:   invokevirtual [46] 
L139:   getstatic [13] 
L142:   ifle L189 
L145:   getstatic [5] 
L148:   invokevirtual [38] 
L151:   getstatic [13] 
L154:   if_icmplt L171 
L157:   getstatic [5] 
L160:   iconst_0 
L161:   invokevirtual [47] 
L164:   getstatic [5] 
L167:   iconst_0 
L168:   invokevirtual [47] 
L171:   getstatic [5] 
L174:   aload 5 
L176:   invokevirtual [41] 
L179:   invokevirtual [48] 
L182:   getstatic [5] 
L185:   aload_1 
L186:   invokevirtual [48] 
L189:   aload 5 
L191:   areturn 
L192:   astore 4 
L194:   new [66] 
L197:   dup 
L198:   aload 4 
L200:   invokevirtual [49] 
L203:   invokespecial [58] 
L206:   athrow 
L207:   nop 
L208:   
    .end code 
.end method 

.method public interface [353] : [354] 
    .attribute [328] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [34] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public abstract [355] : [356] 
    .attribute [328] .code stack 0 locals 0 
L0:     
    .end code 
.end method 

.method public [357] : [358] 
    .attribute [328] .code stack 2 locals 0 
L0:     iload_1 
L1:     tableswitch 0 
            L28 
            L28 
            L28 
            default : L31 

L28:    goto L39 
L31:    new [66] 
L34:    dup 
L35:    invokespecial [59] 
L38:    athrow 
L39:    aload_0 
L40:    iload_1 
L41:    putfield [63] 
L44:    return 
L45:    nop 
L46:    nop 
L47:    nop 
L48:    
    .end code 
.end method 

.method public [359] : [360] 
    .attribute [328] .code stack 2 locals 0 
L0:     iload_1 
L1:     tableswitch 0 
            L32 
            L32 
            L32 
            L32 
            default : L35 

L32:    goto L43 
L35:    new [66] 
L38:    dup 
L39:    invokespecial [59] 
L42:    athrow 
L43:    aload_0 
L44:    iload_1 
L45:    putfield [62] 
L48:    return 
L49:    nop 
L50:    nop 
L51:    nop 
L52:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [67] 
.const [3] = Class [68] 
.const [4] = Class [69] 
.const [5] = Field [70] [71] 
.const [6] = Class [72] 
.const [7] = String [73] 
.const [8] = Class [74] 
.const [9] = Method [75] [76] 
.const [10] = Class [77] 
.const [11] = Class [78] 
.const [12] = Method [79] [80] 
.const [13] = Field [81] [82] 
.const [14] = Class [83] 
.const [15] = Class [84] 
.const [16] = Class [85] 
.const [17] = Method [86] [87] 
.const [18] = Method [88] [89] 
.const [19] = Method [90] [91] 
.const [20] = Class [92] 
.const [21] = Method [93] [94] 
.const [22] = Class [95] 
.const [23] = Class [96] 
.const [24] = Field [97] [98] 
.const [25] = Field [99] [100] 
.const [26] = Class [101] 
.const [27] = Class [102] 
.const [28] = Class [103] 
.const [29] = Field [104] [105] 
.const [30] = Method [106] [107] 
.const [31] = Class [108] 
.const [32] = Class [109] 
.const [33] = Class [110] 
.const [34] = Field [111] [112] 
.const [35] = Field [113] [114] 
.const [36] = Method [115] [116] 
.const [37] = Method [117] [118] 
.const [38] = Method [119] [120] 
.const [39] = Method [121] [122] 
.const [40] = Method [123] [124] 
.const [41] = Method [125] [126] 
.const [42] = Method [127] [128] 
.const [43] = Method [129] [130] 
.const [44] = Method [131] [132] 
.const [45] = Method [133] [134] 
.const [46] = Method [135] [136] 
.const [47] = Method [137] [138] 
.const [48] = Method [139] [140] 
.const [49] = Method [141] [142] 
.const [50] = Method [143] [144] 
.const [51] = Field [145] [146] 
.const [52] = Method [147] [148] 
.const [53] = Field [149] [150] 
.const [54] = Method [151] [152] 
.const [55] = Method [153] [154] 
.const [56] = Method [155] [156] 
.const [57] = Method [157] [158] 
.const [58] = Method [159] [160] 
.const [59] = Method [161] [162] 
.const [60] = Class [163] 
.const [61] = Class [164] 
.const [62] = Field [165] [166] 
.const [63] = Field [167] [168] 
.const [64] = Class [169] 
.const [65] = Class [170] 
.const [66] = Class [171] 
.const [67] = Utf8 java/text/Collator 
.const [68] = Utf8 java/lang/Object 
.const [69] = Utf8 java/util/Vector 
.const [70] = Class [172] 
.const [71] = NameAndType [173] [174] 
.const [72] = Utf8 com/ibm/oti/util/PriviAction 
.const [73] = Utf8 'collator.cache' 
.const [74] = Utf8 java/security/AccessController 
.const [75] = Class [175] 
.const [76] = NameAndType [176] [177] 
.const [77] = Utf8 java/lang/String 
.const [78] = Utf8 java/lang/Integer 
.const [79] = Class [178] 
.const [80] = NameAndType [179] [180] 
.const [81] = Class [181] 
.const [82] = NameAndType [182] [183] 
.const [83] = Utf8 java/lang/NumberFormatException 
.const [84] = Utf8 java/lang/CloneNotSupportedException 
.const [85] = Utf8 java/util/Locale 
.const [86] = Class [184] 
.const [87] = NameAndType [185] [186] 
.const [88] = Class [187] 
.const [89] = NameAndType [188] [189] 
.const [90] = Class [190] 
.const [91] = NameAndType [191] [192] 
.const [92] = Utf8 java/text/Format 
.const [93] = Class [193] 
.const [94] = NameAndType [194] [195] 
.const [95] = Utf8 com/ibm/oti/util/ExtendedResourceBundle 
.const [96] = Utf8 com/ibm/oti/locale/Locale 
.const [97] = Class [196] 
.const [98] = NameAndType [197] [198] 
.const [99] = Class [199] 
.const [100] = NameAndType [200] [201] 
.const [101] = Utf8 java/text/RuleBasedCollator 
.const [102] = Utf8 java/lang/StringBuffer 
.const [103] = Utf8 java/text/CollationRules 
.const [104] = Class [202] 
.const [105] = NameAndType [203] [204] 
.const [106] = Class [205] 
.const [107] = NameAndType [206] [207] 
.const [108] = Utf8 java/lang/IllegalArgumentException 
.const [109] = Utf8 java/text/ParseException 
.const [110] = Utf8 java/util/MissingResourceException 
.const [111] = Class [208] 
.const [112] = NameAndType [209] [210] 
.const [113] = Class [211] 
.const [114] = NameAndType [212] [213] 
.const [115] = Class [214] 
.const [116] = NameAndType [215] [216] 
.const [117] = Class [217] 
.const [118] = NameAndType [218] [219] 
.const [119] = Class [220] 
.const [120] = NameAndType [221] [222] 
.const [121] = Class [223] 
.const [122] = NameAndType [224] [225] 
.const [123] = Class [226] 
.const [124] = NameAndType [227] [228] 
.const [125] = Class [229] 
.const [126] = NameAndType [230] [231] 
.const [127] = Class [232] 
.const [128] = NameAndType [233] [234] 
.const [129] = Class [235] 
.const [130] = NameAndType [236] [237] 
.const [131] = Class [238] 
.const [132] = NameAndType [239] [240] 
.const [133] = Class [241] 
.const [134] = NameAndType [242] [243] 
.const [135] = Class [244] 
.const [136] = NameAndType [245] [246] 
.const [137] = Class [247] 
.const [138] = NameAndType [248] [249] 
.const [139] = Class [250] 
.const [140] = NameAndType [251] [252] 
.const [141] = Class [253] 
.const [142] = NameAndType [254] [255] 
.const [143] = Class [256] 
.const [144] = NameAndType [257] [258] 
.const [145] = Class [259] 
.const [146] = NameAndType [260] [261] 
.const [147] = Class [262] 
.const [148] = NameAndType [263] [264] 
.const [149] = Class [265] 
.const [150] = NameAndType [266] [267] 
.const [151] = Class [268] 
.const [152] = NameAndType [269] [270] 
.const [153] = Class [271] 
.const [154] = NameAndType [272] [273] 
.const [155] = Class [274] 
.const [156] = NameAndType [275] [276] 
.const [157] = Class [277] 
.const [158] = NameAndType [278] [279] 
.const [159] = Class [280] 
.const [160] = NameAndType [281] [282] 
.const [161] = Class [283] 
.const [162] = NameAndType [284] [285] 
.const [163] = Utf8 java/util/Vector 
.const [164] = Utf8 com/ibm/oti/util/PriviAction 
.const [165] = Class [286] 
.const [166] = NameAndType [287] [288] 
.const [167] = Class [289] 
.const [168] = NameAndType [290] [291] 
.const [169] = Utf8 java/text/RuleBasedCollator 
.const [170] = Utf8 java/lang/StringBuffer 
.const [171] = Utf8 java/lang/IllegalArgumentException 
.const [172] = Utf8 java/text/Collator 
.const [173] = Utf8 cache 
.const [174] = Utf8 Ljava/util/Vector; 
.const [175] = Utf8 java/security/AccessController 
.const [176] = Utf8 doPrivileged 
.const [177] = Utf8 (Ljava/security/PrivilegedAction;)Ljava/lang/Object; 
.const [178] = Utf8 java/lang/Integer 
.const [179] = Utf8 parseInt 
.const [180] = Utf8 (Ljava/lang/String;)I 
.const [181] = Utf8 java/text/Collator 
.const [182] = Utf8 CACHE_SIZE 
.const [183] = Utf8 I 
.const [184] = Utf8 java/util/Locale 
.const [185] = Utf8 getAvailableLocales 
.const [186] = Utf8 ()[Ljava/util/Locale; 
.const [187] = Utf8 java/util/Locale 
.const [188] = Utf8 getDefault 
.const [189] = Utf8 ()Ljava/util/Locale; 
.const [190] = Utf8 java/text/Collator 
.const [191] = Utf8 getInstance 
.const [192] = Utf8 (Ljava/util/Locale;)Ljava/text/Collator; 
.const [193] = Utf8 java/text/Format 
.const [194] = Utf8 getCollationBundle 
.const [195] = Utf8 (Ljava/util/Locale;)Ljava/util/ResourceBundle; 
.const [196] = Utf8 com/ibm/oti/locale/Locale 
.const [197] = Utf8 COLLATION 
.const [198] = Utf8 Ljava/lang/Integer; 
.const [199] = Utf8 com/ibm/oti/locale/Locale 
.const [200] = Utf8 COLLATIONDECOMP 
.const [201] = Utf8 Ljava/lang/Integer; 
.const [202] = Utf8 java/text/CollationRules 
.const [203] = Utf8 DEFAULTRULES 
.const [204] = Utf8 Ljava/lang/String; 
.const [205] = Utf8 java/lang/String 
.const [206] = Utf8 valueOf 
.const [207] = Utf8 (Ljava/lang/Object;)Ljava/lang/String; 
.const [208] = Utf8 java/text/Collator 
.const [209] = Utf8 strength 
.const [210] = Utf8 I 
.const [211] = Utf8 java/text/Collator 
.const [212] = Utf8 decomposition 
.const [213] = Utf8 I 
.const [214] = Utf8 java/text/Collator 
.const [215] = Utf8 compare 
.const [216] = Utf8 (Ljava/lang/String;Ljava/lang/String;)I 
.const [217] = Utf8 java/util/Locale 
.const [218] = Utf8 toString 
.const [219] = Utf8 ()Ljava/lang/String; 
.const [220] = Utf8 java/util/Vector 
.const [221] = Utf8 size 
.const [222] = Utf8 ()I 
.const [223] = Utf8 java/util/Vector 
.const [224] = Utf8 elementAt 
.const [225] = Utf8 (I)Ljava/lang/Object; 
.const [226] = Utf8 java/lang/Object 
.const [227] = Utf8 equals 
.const [228] = Utf8 (Ljava/lang/Object;)Z 
.const [229] = Utf8 java/text/Collator 
.const [230] = Utf8 clone 
.const [231] = Utf8 ()Ljava/lang/Object; 
.const [232] = Utf8 com/ibm/oti/util/ExtendedResourceBundle 
.const [233] = Utf8 getObject 
.const [234] = Utf8 (Ljava/lang/Integer;)Ljava/lang/Object; 
.const [235] = Utf8 java/lang/Integer 
.const [236] = Utf8 intValue 
.const [237] = Utf8 ()I 
.const [238] = Utf8 java/lang/StringBuffer 
.const [239] = Utf8 append 
.const [240] = Utf8 (Ljava/lang/String;)Ljava/lang/StringBuffer; 
.const [241] = Utf8 java/lang/StringBuffer 
.const [242] = Utf8 toString 
.const [243] = Utf8 ()Ljava/lang/String; 
.const [244] = Utf8 java/text/Collator 
.const [245] = Utf8 setDecomposition 
.const [246] = Utf8 (I)V 
.const [247] = Utf8 java/util/Vector 
.const [248] = Utf8 removeElementAt 
.const [249] = Utf8 (I)V 
.const [250] = Utf8 java/util/Vector 
.const [251] = Utf8 addElement 
.const [252] = Utf8 (Ljava/lang/Object;)V 
.const [253] = Utf8 java/text/ParseException 
.const [254] = Utf8 getMessage 
.const [255] = Utf8 ()Ljava/lang/String; 
.const [256] = Utf8 java/util/Vector 
.const [257] = Utf8 <init> 
.const [258] = Utf8 ()V 
.const [259] = Utf8 java/text/Collator 
.const [260] = Utf8 cache 
.const [261] = Utf8 Ljava/util/Vector; 
.const [262] = Utf8 com/ibm/oti/util/PriviAction 
.const [263] = Utf8 <init> 
.const [264] = Utf8 (Ljava/lang/String;)V 
.const [265] = Utf8 java/text/Collator 
.const [266] = Utf8 CACHE_SIZE 
.const [267] = Utf8 I 
.const [268] = Utf8 java/lang/Object 
.const [269] = Utf8 <init> 
.const [270] = Utf8 ()V 
.const [271] = Utf8 java/lang/Object 
.const [272] = Utf8 clone 
.const [273] = Utf8 ()Ljava/lang/Object; 
.const [274] = Utf8 java/lang/StringBuffer 
.const [275] = Utf8 <init> 
.const [276] = Utf8 (Ljava/lang/String;)V 
.const [277] = Utf8 java/text/RuleBasedCollator 
.const [278] = Utf8 <init> 
.const [279] = Utf8 (Ljava/lang/String;I)V 
.const [280] = Utf8 java/lang/IllegalArgumentException 
.const [281] = Utf8 <init> 
.const [282] = Utf8 (Ljava/lang/String;)V 
.const [283] = Utf8 java/lang/IllegalArgumentException 
.const [284] = Utf8 <init> 
.const [285] = Utf8 ()V 
.const [286] = Utf8 java/text/Collator 
.const [287] = Utf8 strength 
.const [288] = Utf8 I 
.const [289] = Utf8 java/text/Collator 
.const [290] = Utf8 decomposition 
.const [291] = Utf8 I 
.const [292] = Utf8 java/text/Collator 
.const [293] = Class [292] 
.const [294] = Utf8 java/lang/Object 
.const [295] = Class [294] 
.const [296] = Utf8 java/util/Comparator 
.const [297] = Class [296] 
.const [298] = Utf8 java/lang/Cloneable 
.const [299] = Class [298] 
.const [300] = Utf8 EQUAL 
.const [301] = Utf8 I 
.const [302] = Utf8 GREATER 
.const [303] = Utf8 I 
.const [304] = Utf8 LESS 
.const [305] = Utf8 I 
.const [306] = Utf8 NO_DECOMPOSITION 
.const [307] = Utf8 I 
.const [308] = Utf8 CANONICAL_DECOMPOSITION 
.const [309] = Utf8 I 
.const [310] = Utf8 FULL_DECOMPOSITION 
.const [311] = Utf8 I 
.const [312] = Utf8 PRIMARY 
.const [313] = Utf8 I 
.const [314] = Utf8 SECONDARY 
.const [315] = Utf8 I 
.const [316] = Utf8 TERTIARY 
.const [317] = Utf8 I 
.const [318] = Utf8 IDENTICAL 
.const [319] = Utf8 I 
.const [320] = Utf8 CACHE_SIZE 
.const [321] = Utf8 I 
.const [322] = Utf8 cache 
.const [323] = Utf8 Ljava/util/Vector; 
.const [324] = Utf8 strength 
.const [325] = Utf8 I 
.const [326] = Utf8 decomposition 
.const [327] = Utf8 I 
.const [328] = Utf8 Code 
.const [329] = Utf8 <clinit> 
.const [330] = Utf8 ()V 
.const [331] = Utf8 <init> 
.const [332] = Utf8 ()V 
.const [333] = Utf8 clone 
.const [334] = Utf8 ()Ljava/lang/Object; 
.const [335] = Utf8 compare 
.const [336] = Utf8 (Ljava/lang/Object;Ljava/lang/Object;)I 
.const [337] = Utf8 compare 
.const [338] = Utf8 (Ljava/lang/String;Ljava/lang/String;)I 
.const [339] = Utf8 equals 
.const [340] = Utf8 (Ljava/lang/Object;)Z 
.const [341] = Utf8 equals 
.const [342] = Utf8 (Ljava/lang/String;Ljava/lang/String;)Z 
.const [343] = Utf8 getAvailableLocales 
.const [344] = Utf8 ()[Ljava/util/Locale; 
.const [345] = Utf8 getCollationKey 
.const [346] = Utf8 (Ljava/lang/String;)Ljava/text/CollationKey; 
.const [347] = Utf8 getDecomposition 
.const [348] = Utf8 ()I 
.const [349] = Utf8 getInstance 
.const [350] = Utf8 ()Ljava/text/Collator; 
.const [351] = Utf8 getInstance 
.const [352] = Utf8 (Ljava/util/Locale;)Ljava/text/Collator; 
.const [353] = Utf8 getStrength 
.const [354] = Utf8 ()I 
.const [355] = Utf8 hashCode 
.const [356] = Utf8 ()I 
.const [357] = Utf8 setDecomposition 
.const [358] = Utf8 (I)V 
.const [359] = Utf8 setStrength 
.const [360] = Utf8 (I)V 
.end class 
