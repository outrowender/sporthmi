.version 50 0 
.class public final super [179] 
.super [181] 
.implements [183] 

.method public annotation [185] : [186] 
    .attribute [184] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [38] 
L4:     return 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [187] : [188] 
    .attribute [184] .code stack 4 locals 1 
L0:     aload_1 
L1:     invokestatic [2] 
L4:     ifne L19 
L7:     aload_0 
L8:     invokevirtual [24] 
L11:    astore_3 
L12:    aload_0 
L13:    aload_3 
L14:    aload_1 
L15:    iload_2 
L16:    invokespecial [39] 
L19:    return 
L20:    
    .end code 
.end method 

.method protected [189] : [190] 
    .attribute [184] .code stack 5 locals 3 
L0:     aload_0 
L1:     invokevirtual [25] 
L4:     ifeq L62 
L7:     aload_0 
L8:     invokevirtual [24] 
L11:    astore_1 
L12:    aload_1 
L13:    astore_2 
        .catch [4] from L14 to L19 using L22 
L14:    aload_1 
L15:    invokestatic [3] 
L18:    astore_2 
L19:    goto L35 
L22:    astore_3 
L23:    getstatic [5] 
L26:    sipush 10000 
L29:    ldc [6] 
L31:    invokevirtual [26] 
L34:    pop 
L35:    aload_0 
L36:    getfield [27] 
L39:    invokevirtual [28] 
L42:    aload_0 
L43:    getfield [27] 
L46:    aload_2 
L47:    invokevirtual [29] 
L50:    pop 
L51:    aload_0 
L52:    iconst_3 
L53:    iconst_0 
L54:    aload_1 
L55:    aload_0 
L56:    invokevirtual [24] 
L59:    invokevirtual [30] 
L62:    return 
L63:    nop 
L64:    
    .end code 
.end method 

.method private [191] : [192] 
    .attribute [184] .code stack 5 locals 2 
L0:     aconst_null 
L1:     astore 4 
        .catch [4] from L3 to L10 using L13 
L3:     aload_1 
L4:     aload_2 
L5:     invokestatic [7] 
L8:     astore 4 
L10:    goto L27 
L13:    astore 5 
L15:    getstatic [5] 
L18:    sipush 10000 
L21:    ldc [8] 
L23:    invokevirtual [26] 
L26:    pop 
L27:    aload 4 
L29:    ifnull L39 
L32:    aload 4 
L34:    arraylength 
L35:    iconst_2 
L36:    if_icmpeq L52 
L39:    getstatic [5] 
L42:    sipush 10000 
L45:    ldc [9] 
L47:    invokevirtual [26] 
L50:    pop 
L51:    return 
L52:    aload 4 
L54:    iconst_1 
L55:    aaload 
L56:    ldc [10] 
L58:    invokevirtual [31] 
L61:    ifeq L79 
L64:    getstatic [5] 
L67:    sipush 10000 
L70:    ldc [9] 
L72:    invokevirtual [26] 
L75:    pop 
L76:    goto L128 
L79:    aload_0 
L80:    getfield [27] 
L83:    invokevirtual [28] 
L86:    aload_0 
L87:    getfield [27] 
L90:    aload 4 
L92:    iconst_1 
L93:    aaload 
L94:    invokevirtual [29] 
L97:    pop 
L98:    aload_0 
L99:    iconst_3 
L100:   iload_3 
L101:   aload_1 
L102:   aload_0 
L103:   invokevirtual [24] 
L106:   invokevirtual [30] 
L109:   aload 4 
L111:   iconst_0 
L112:   aaload 
L113:   invokevirtual [32] 
L116:   ifle L128 
L119:   aload_0 
L120:   aload 4 
L122:   iconst_0 
L123:   aaload 
L124:   iload_3 
L125:   invokevirtual [33] 
L128:   return 
L129:   nop 
L130:   nop 
L131:   nop 
L132:   
    .end code 
.end method 

.method public static [193] : [194] 
    .attribute [184] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokestatic [11] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public static [195] : [196] 
    .attribute [184] .code stack 6 locals 2 
L0:     iconst_2 
L1:     anewarray [12] 
L4:     astore_2 
L5:     new [41] 
L8:     dup 
L9:     invokespecial [40] 
L12:    aload_0 
L13:    invokevirtual [34] 
L16:    aload_1 
L17:    invokevirtual [34] 
L20:    invokevirtual [35] 
L23:    invokestatic [14] 
L26:    astore_3 
L27:    aload_2 
L28:    iconst_0 
L29:    aload_3 
L30:    iconst_0 
L31:    aload_3 
L32:    invokevirtual [32] 
L35:    iconst_1 
L36:    isub 
L37:    invokevirtual [36] 
L40:    aastore 
L41:    aload_2 
L42:    iconst_1 
L43:    aload_3 
L44:    aload_3 
L45:    invokevirtual [32] 
L48:    iconst_1 
L49:    isub 
L50:    invokevirtual [37] 
L53:    invokestatic [15] 
L56:    aastore 
L57:    aload_2 
L58:    areturn 
L59:    nop 
L60:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Method [42] [43] 
.const [3] = Method [44] [45] 
.const [4] = Class [46] 
.const [5] = Field [47] [48] 
.const [6] = String [49] 
.const [7] = Method [50] [51] 
.const [8] = String [52] 
.const [9] = String [53] 
.const [10] = String [54] 
.const [11] = Method [55] [56] 
.const [12] = Class [57] 
.const [13] = Class [58] 
.const [14] = Method [59] [60] 
.const [15] = Method [61] [62] 
.const [16] = Class [63] 
.const [17] = Class [64] 
.const [18] = Class [65] 
.const [19] = Class [66] 
.const [20] = Class [67] 
.const [21] = Class [68] 
.const [22] = Class [69] 
.const [23] = Class [70] 
.const [24] = Method [71] [72] 
.const [25] = Method [73] [74] 
.const [26] = Method [75] [76] 
.const [27] = Field [77] [78] 
.const [28] = Method [79] [80] 
.const [29] = Method [81] [82] 
.const [30] = Method [83] [84] 
.const [31] = Method [85] [86] 
.const [32] = Method [87] [88] 
.const [33] = Method [89] [90] 
.const [34] = Method [91] [92] 
.const [35] = Method [93] [94] 
.const [36] = Method [95] [96] 
.const [37] = Method [97] [98] 
.const [38] = Method [99] [100] 
.const [39] = Method [101] [102] 
.const [40] = Method [103] [104] 
.const [41] = Class [105] 
.const [42] = Class [106] 
.const [43] = NameAndType [107] [108] 
.const [44] = Class [109] 
.const [45] = NameAndType [110] [111] 
.const [46] = Utf8 de/awtce/krstr/KoreanStringConversion$KrstrException 
.const [47] = Class [112] 
.const [48] = NameAndType [113] [114] 
.const [49] = Utf8 'TouchInputDataAsiaKorean#deleteLastUnconvertedCharacter: KrstrException when convert.' 
.const [50] = Class [115] 
.const [51] = NameAndType [116] [117] 
.const [52] = Utf8 'TouchInputDataAsiaKorean#autoConversionForAppendUnconvertedChars: KrstrException when convert.' 
.const [53] = Utf8 'TouchInputDataAsiaKorean#autoConversionForAppendUnconvertedChars: Conversion from KRStrConv is incorrect.' 
.const [54] = Utf8 '' 
.const [55] = Class [118] 
.const [56] = NameAndType [119] [120] 
.const [57] = Utf8 java/lang/String 
.const [58] = Utf8 java/lang/StringBuffer 
.const [59] = Class [121] 
.const [60] = NameAndType [122] [123] 
.const [61] = Class [124] 
.const [62] = NameAndType [125] [126] 
.const [63] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/asia/TouchInputDataKorean 
.const [64] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/asia/TouchInputDataAsia 
.const [65] = Utf8 de/audi/atip/util/StringUtilities 
.const [66] = Utf8 de/awtce/krstr/KoreanStringConversion 
.const [67] = Utf8 de/esolutions/hmi/widgets/audi/base/IWidgetLogChannel 
.const [68] = Utf8 de/audi/atip/log/LogChannel 
.const [69] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [70] = Utf8 java/lang/Character 
.const [71] = Class [127] 
.const [72] = NameAndType [128] [129] 
.const [73] = Class [130] 
.const [74] = NameAndType [131] [132] 
.const [75] = Class [133] 
.const [76] = NameAndType [134] [135] 
.const [77] = Class [136] 
.const [78] = NameAndType [137] [138] 
.const [79] = Class [139] 
.const [80] = NameAndType [140] [141] 
.const [81] = Class [142] 
.const [82] = NameAndType [143] [144] 
.const [83] = Class [145] 
.const [84] = NameAndType [146] [147] 
.const [85] = Class [148] 
.const [86] = NameAndType [149] [150] 
.const [87] = Class [151] 
.const [88] = NameAndType [152] [153] 
.const [89] = Class [154] 
.const [90] = NameAndType [155] [156] 
.const [91] = Class [157] 
.const [92] = NameAndType [158] [159] 
.const [93] = Class [160] 
.const [94] = NameAndType [161] [162] 
.const [95] = Class [163] 
.const [96] = NameAndType [164] [165] 
.const [97] = Class [166] 
.const [98] = NameAndType [167] [168] 
.const [99] = Class [169] 
.const [100] = NameAndType [170] [171] 
.const [101] = Class [172] 
.const [102] = NameAndType [173] [174] 
.const [103] = Class [175] 
.const [104] = NameAndType [176] [177] 
.const [105] = Utf8 java/lang/StringBuffer 
.const [106] = Utf8 de/audi/atip/util/StringUtilities 
.const [107] = Utf8 isNullOrEmpty 
.const [108] = Utf8 (Ljava/lang/CharSequence;)Z 
.const [109] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/asia/TouchInputDataKorean 
.const [110] = Utf8 deletLastUnconverted 
.const [111] = Utf8 (Ljava/lang/String;)Ljava/lang/String; 
.const [112] = Utf8 de/esolutions/hmi/widgets/audi/base/IWidgetLogChannel 
.const [113] = Utf8 tpLogChannelInternal 
.const [114] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [115] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/asia/TouchInputDataKorean 
.const [116] = Utf8 getHangulConversion 
.const [117] = Utf8 (Ljava/lang/String;Ljava/lang/String;)[Ljava/lang/String; 
.const [118] = Utf8 de/awtce/krstr/KoreanStringConversion 
.const [119] = Utf8 delete_last_jamo 
.const [120] = Utf8 (Ljava/lang/String;)Ljava/lang/String; 
.const [121] = Utf8 de/awtce/krstr/KoreanStringConversion 
.const [122] = Utf8 jamo_to_hangul 
.const [123] = Utf8 (Ljava/lang/String;)Ljava/lang/String; 
.const [124] = Utf8 java/lang/Character 
.const [125] = Utf8 toString 
.const [126] = Utf8 (C)Ljava/lang/String; 
.const [127] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/asia/TouchInputDataKorean 
.const [128] = Utf8 getUnconvertedCharacters 
.const [129] = Utf8 ()Ljava/lang/String; 
.const [130] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/asia/TouchInputDataKorean 
.const [131] = Utf8 hasUnconvertedCharacters 
.const [132] = Utf8 ()Z 
.const [133] = Utf8 de/audi/atip/log/LogChannel 
.const [134] = Utf8 log 
.const [135] = Utf8 (ILjava/lang/String;)Z 
.const [136] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/asia/TouchInputDataKorean 
.const [137] = Utf8 currentlyUnconvertedCharacters 
.const [138] = Utf8 Lde/esolutions/fw/util/commons/Buffer; 
.const [139] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [140] = Utf8 clear 
.const [141] = Utf8 ()V 
.const [142] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [143] = Utf8 append 
.const [144] = Utf8 (Ljava/lang/String;)Lde/esolutions/fw/util/commons/Buffer; 
.const [145] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/asia/TouchInputDataKorean 
.const [146] = Utf8 notifyDataChange 
.const [147] = Utf8 (IZLjava/lang/String;Ljava/lang/String;)V 
.const [148] = Utf8 java/lang/String 
.const [149] = Utf8 equals 
.const [150] = Utf8 (Ljava/lang/Object;)Z 
.const [151] = Utf8 java/lang/String 
.const [152] = Utf8 length 
.const [153] = Utf8 ()I 
.const [154] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/asia/TouchInputDataKorean 
.const [155] = Utf8 appendRegularCharacters 
.const [156] = Utf8 (Ljava/lang/String;Z)V 
.const [157] = Utf8 java/lang/StringBuffer 
.const [158] = Utf8 append 
.const [159] = Utf8 (Ljava/lang/String;)Ljava/lang/StringBuffer; 
.const [160] = Utf8 java/lang/StringBuffer 
.const [161] = Utf8 toString 
.const [162] = Utf8 ()Ljava/lang/String; 
.const [163] = Utf8 java/lang/String 
.const [164] = Utf8 substring 
.const [165] = Utf8 (II)Ljava/lang/String; 
.const [166] = Utf8 java/lang/String 
.const [167] = Utf8 charAt 
.const [168] = Utf8 (I)C 
.const [169] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/asia/TouchInputDataAsia 
.const [170] = Utf8 <init> 
.const [171] = Utf8 ()V 
.const [172] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/asia/TouchInputDataKorean 
.const [173] = Utf8 autoConversionForAppendUnconvertedChars 
.const [174] = Utf8 (Ljava/lang/String;Ljava/lang/String;Z)V 
.const [175] = Utf8 java/lang/StringBuffer 
.const [176] = Utf8 <init> 
.const [177] = Utf8 ()V 
.const [178] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/asia/TouchInputDataKorean 
.const [179] = Class [178] 
.const [180] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/asia/TouchInputDataAsia 
.const [181] = Class [180] 
.const [182] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/asia/ITouchInputDataAsia 
.const [183] = Class [182] 
.const [184] = Utf8 Code 
.const [185] = Utf8 <init> 
.const [186] = Utf8 ()V 
.const [187] = Utf8 appendUnconvertedCharacters 
.const [188] = Utf8 (Ljava/lang/String;Z)V 
.const [189] = Utf8 deleteLastUnconvertedCharacter 
.const [190] = Utf8 ()V 
.const [191] = Utf8 autoConversionForAppendUnconvertedChars 
.const [192] = Utf8 (Ljava/lang/String;Ljava/lang/String;Z)V 
.const [193] = Utf8 deletLastUnconverted 
.const [194] = Utf8 (Ljava/lang/String;)Ljava/lang/String; 
.const [195] = Utf8 getHangulConversion 
.const [196] = Utf8 (Ljava/lang/String;Ljava/lang/String;)[Ljava/lang/String; 
.end class 
