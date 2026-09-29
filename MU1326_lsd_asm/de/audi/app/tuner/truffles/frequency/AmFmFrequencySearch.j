.version 50 0 
.class super [144] 
.super [146] 
.field private [147] [148] 
.field private [149] [150] 
.field private [151] [152] 
.field private final [153] [154] 

.method [156] : [157] 
    .attribute [155] .code stack 3 locals 0 
L0:     aload_0 
L1:     invokespecial [25] 
L4:     aload_0 
L5:     ldc2_w [33] 
L8:     putfield [28] 
L11:    aload_0 
L12:    ldc2_w [33] 
L15:    putfield [29] 
L18:    aload_0 
L19:    ldc2_w [33] 
L22:    putfield [30] 
L25:    aload_0 
L26:    aload_1 
L27:    putfield [31] 
L30:    return 
L31:    nop 
L32:    
    .end code 
.end method 

.method [158] : [159] 
    .attribute [155] .code stack 6 locals 5 
L0:     aload_1 
L1:     bipush 44 
L3:     bipush 46 
L5:     invokevirtual [18] 
L8:     invokevirtual [19] 
L11:    astore_3 
L12:    aconst_null 
L13:    astore 4 
L15:    lconst_0 
L16:    lstore 5 
        .catch [3] from L18 to L44 using L47 
L18:    iload_2 
L19:    iconst_1 
L20:    if_icmpne L37 
L23:    aload_3 
L24:    invokestatic [2] 
L27:    ldc2_w [35] 
L30:    dmul 
L31:    d2l 
L32:    lstore 5 
L34:    goto L44 
L37:    aload_3 
L38:    invokestatic [2] 
L41:    d2l 
L42:    lstore 5 
L44:    goto L63 
L47:    astore 7 
L49:    aload_0 
L50:    getfield [17] 
L53:    ldc [4] 
L55:    ldc [5] 
L57:    invokevirtual [20] 
L60:    pop 
L61:    aconst_null 
L62:    areturn 
L63:    aload_0 
L64:    lload 5 
L66:    invokespecial [26] 
L69:    ifeq L85 
L72:    new [32] 
L75:    dup 
L76:    aload_3 
L77:    iload_2 
L78:    lload 5 
L80:    invokespecial [27] 
L83:    astore 4 
L85:    aload_0 
L86:    getfield [17] 
L89:    ldc [4] 
L91:    ldc [7] 
L93:    aload 4 
L95:    iload_2 
L96:    i2l 
L97:    invokevirtual [21] 
L100:   pop 
L101:   aload 4 
L103:   areturn 
L104:   
    .end code 
.end method 

.method private [160] : [161] 
    .attribute [155] .code stack 4 locals 5 
L0:     aload_0 
L1:     dup 
L2:     astore_3 
L3:     monitorenter 
        .catch [0] from L4 to L114 using L115 
L4:     aload_0 
L5:     getfield [14] 
L8:     ldc2_w [33] 
L11:    lcmp 
L12:    ifle L41 
L15:    aload_0 
L16:    getfield [15] 
L19:    ldc2_w [33] 
L22:    lcmp 
L23:    ifle L41 
L26:    aload_0 
L27:    getfield [16] 
L30:    ldc2_w [33] 
L33:    lcmp 
L34:    ifle L41 
L37:    iconst_1 
L38:    goto L42 
L41:    iconst_0 
L42:    istore 4 
L44:    aload_0 
L45:    getfield [14] 
L48:    lload_1 
L49:    lcmp 
L50:    ifgt L66 
L53:    lload_1 
L54:    aload_0 
L55:    getfield [15] 
L58:    lcmp 
L59:    ifgt L66 
L62:    iconst_1 
L63:    goto L67 
L66:    iconst_0 
L67:    istore 5 
L69:    lload_1 
L70:    aload_0 
L71:    getfield [14] 
L74:    lsub 
L75:    aload_0 
L76:    getfield [16] 
L79:    lrem 
L80:    lconst_0 
L81:    lcmp 
L82:    ifne L89 
L85:    iconst_1 
L86:    goto L90 
L89:    iconst_0 
L90:    istore 6 
L92:    iload 4 
L94:    ifeq L111 
L97:    iload 5 
L99:    ifeq L111 
L102:   iload 6 
L104:   ifeq L111 
L107:   iconst_1 
L108:   goto L112 
L111:   iconst_0 
L112:   aload_3 
L113:   monitorexit 
L114:   areturn 
        .catch [0] from L115 to L119 using L115 
L115:   astore 7 
L117:   aload_3 
L118:   monitorexit 
L119:   aload 7 
L121:   athrow 
L122:   nop 
L123:   nop 
L124:   
    .end code 
.end method 

.method public [162] : [163] 
    .attribute [155] .code stack 3 locals 3 
L0:     aload_1 
L1:     iconst_0 
L2:     aaload 
L3:     checkcast [8] 
L6:     astore_2 
L7:     aload_0 
L8:     dup 
L9:     astore_3 
L10:    monitorenter 
        .catch [0] from L11 to L37 using L40 
L11:    aload_0 
L12:    aload_2 
L13:    getfield [22] 
L16:    putfield [28] 
L19:    aload_0 
L20:    aload_2 
L21:    getfield [23] 
L24:    putfield [29] 
L27:    aload_0 
L28:    aload_2 
L29:    getfield [24] 
L32:    putfield [30] 
L35:    aload_3 
L36:    monitorexit 
L37:    goto L47 
        .catch [0] from L40 to L44 using L40 
L40:    astore 4 
L42:    aload_3 
L43:    monitorexit 
L44:    aload 4 
L46:    athrow 
L47:    return 
L48:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Method [37] [38] 
.const [3] = Class [39] 
.const [4] = Int -2137614336 
.const [5] = String [40] 
.const [6] = Class [41] 
.const [7] = String [42] 
.const [8] = Class [43] 
.const [9] = Class [44] 
.const [10] = Class [45] 
.const [11] = Class [46] 
.const [12] = Class [47] 
.const [13] = Class [48] 
.const [14] = Field [49] [50] 
.const [15] = Field [51] [52] 
.const [16] = Field [53] [54] 
.const [17] = Field [55] [56] 
.const [18] = Method [57] [58] 
.const [19] = Method [59] [60] 
.const [20] = Method [61] [62] 
.const [21] = Method [63] [64] 
.const [22] = Field [65] [66] 
.const [23] = Field [67] [68] 
.const [24] = Field [69] [70] 
.const [25] = Method [71] [72] 
.const [26] = Method [73] [74] 
.const [27] = Method [75] [76] 
.const [28] = Field [77] [78] 
.const [29] = Field [79] [80] 
.const [30] = Field [81] [82] 
.const [31] = Field [83] [84] 
.const [32] = Class [85] 
.const [33] = Long -1L 
.const [35] = Double +0x1F400000000000p-43 
.const [37] = Class [86] 
.const [38] = NameAndType [87] [88] 
.const [39] = Utf8 java/lang/NumberFormatException 
.const [40] = Utf8 '[AmFmFrequencySearch.getRowForFrequency] unable to parse frequency string to double.' 
.const [41] = Utf8 de/audi/app/tuner/truffles/RadioSearchListRow 
.const [42] = Utf8 '[AmFmFrequencySearch.getRowForFrequency] result for band %2 is row: %1' 
.const [43] = Utf8 org/dsi/ifc/radio/WavebandInfo 
.const [44] = Utf8 de/audi/app/tuner/truffles/frequency/AmFmFrequencySearch 
.const [45] = Utf8 java/lang/Object 
.const [46] = Utf8 java/lang/String 
.const [47] = Utf8 java/lang/Double 
.const [48] = Utf8 de/audi/atip/log/LogChannel 
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
.const [73] = Class [125] 
.const [74] = NameAndType [126] [127] 
.const [75] = Class [128] 
.const [76] = NameAndType [129] [130] 
.const [77] = Class [131] 
.const [78] = NameAndType [132] [133] 
.const [79] = Class [134] 
.const [80] = NameAndType [135] [136] 
.const [81] = Class [137] 
.const [82] = NameAndType [138] [139] 
.const [83] = Class [140] 
.const [84] = NameAndType [141] [142] 
.const [85] = Utf8 de/audi/app/tuner/truffles/RadioSearchListRow 
.const [86] = Utf8 java/lang/Double 
.const [87] = Utf8 parseDouble 
.const [88] = Utf8 (Ljava/lang/String;)D 
.const [89] = Utf8 de/audi/app/tuner/truffles/frequency/AmFmFrequencySearch 
.const [90] = Utf8 lowerLimit 
.const [91] = Utf8 J 
.const [92] = Utf8 de/audi/app/tuner/truffles/frequency/AmFmFrequencySearch 
.const [93] = Utf8 upperLimit 
.const [94] = Utf8 J 
.const [95] = Utf8 de/audi/app/tuner/truffles/frequency/AmFmFrequencySearch 
.const [96] = Utf8 stepWidth 
.const [97] = Utf8 J 
.const [98] = Utf8 de/audi/app/tuner/truffles/frequency/AmFmFrequencySearch 
.const [99] = Utf8 log 
.const [100] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [101] = Utf8 java/lang/String 
.const [102] = Utf8 replace 
.const [103] = Utf8 (CC)Ljava/lang/String; 
.const [104] = Utf8 java/lang/String 
.const [105] = Utf8 trim 
.const [106] = Utf8 ()Ljava/lang/String; 
.const [107] = Utf8 de/audi/atip/log/LogChannel 
.const [108] = Utf8 log 
.const [109] = Utf8 (ILjava/lang/String;)Z 
.const [110] = Utf8 de/audi/atip/log/LogChannel 
.const [111] = Utf8 log 
.const [112] = Utf8 (ILjava/lang/String;Ljava/lang/Object;J)Z 
.const [113] = Utf8 org/dsi/ifc/radio/WavebandInfo 
.const [114] = Utf8 lowerLimit 
.const [115] = Utf8 J 
.const [116] = Utf8 org/dsi/ifc/radio/WavebandInfo 
.const [117] = Utf8 upperLimit 
.const [118] = Utf8 J 
.const [119] = Utf8 org/dsi/ifc/radio/WavebandInfo 
.const [120] = Utf8 stepWidth 
.const [121] = Utf8 J 
.const [122] = Utf8 java/lang/Object 
.const [123] = Utf8 <init> 
.const [124] = Utf8 ()V 
.const [125] = Utf8 de/audi/app/tuner/truffles/frequency/AmFmFrequencySearch 
.const [126] = Utf8 frequencyIsCorrect 
.const [127] = Utf8 (J)Z 
.const [128] = Utf8 de/audi/app/tuner/truffles/RadioSearchListRow 
.const [129] = Utf8 <init> 
.const [130] = Utf8 (Ljava/lang/String;IJ)V 
.const [131] = Utf8 de/audi/app/tuner/truffles/frequency/AmFmFrequencySearch 
.const [132] = Utf8 lowerLimit 
.const [133] = Utf8 J 
.const [134] = Utf8 de/audi/app/tuner/truffles/frequency/AmFmFrequencySearch 
.const [135] = Utf8 upperLimit 
.const [136] = Utf8 J 
.const [137] = Utf8 de/audi/app/tuner/truffles/frequency/AmFmFrequencySearch 
.const [138] = Utf8 stepWidth 
.const [139] = Utf8 J 
.const [140] = Utf8 de/audi/app/tuner/truffles/frequency/AmFmFrequencySearch 
.const [141] = Utf8 log 
.const [142] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [143] = Utf8 de/audi/app/tuner/truffles/frequency/AmFmFrequencySearch 
.const [144] = Class [143] 
.const [145] = Utf8 java/lang/Object 
.const [146] = Class [145] 
.const [147] = Utf8 lowerLimit 
.const [148] = Utf8 J 
.const [149] = Utf8 upperLimit 
.const [150] = Utf8 J 
.const [151] = Utf8 stepWidth 
.const [152] = Utf8 J 
.const [153] = Utf8 log 
.const [154] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [155] = Utf8 Code 
.const [156] = Utf8 <init> 
.const [157] = Utf8 (Lde/audi/atip/log/LogChannel;)V 
.const [158] = Utf8 getRowForFrequency 
.const [159] = Utf8 (Ljava/lang/String;I)Lde/audi/app/tuner/truffles/RadioSearchListRow; 
.const [160] = Utf8 frequencyIsCorrect 
.const [161] = Utf8 (J)Z 
.const [162] = Utf8 updateBandInformation 
.const [163] = Utf8 ([Ljava/lang/Object;)V 
.end class 
