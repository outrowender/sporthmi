.version 50 0 
.class public final super [105] 
.super [107] 

.method public static [109] : [110] 
    .attribute [108] .code stack 2 locals 0 
L0:     aload_0 
L1:     ifnull L40 
L4:     aload_0 
L5:     getfield [14] 
L8:     iflt L40 
L11:    aload_0 
L12:    getfield [14] 
L15:    bipush 35 
L17:    if_icmpgt L40 
L20:    aload_0 
L21:    getfield [15] 
L24:    iflt L40 
L27:    aload_0 
L28:    getfield [15] 
L31:    bipush 89 
L33:    if_icmpgt L40 
L36:    iconst_1 
L37:    goto L41 
L40:    iconst_0 
L41:    areturn 
L42:    nop 
L43:    nop 
L44:    
    .end code 
.end method 

.method static [111] : [112] 
    .attribute [108] .code stack 4 locals 0 
L0:     aload_0 
L1:     invokestatic [2] 
L4:     ifeq L33 
L7:     aload_1 
L8:     invokestatic [2] 
L11:    ifeq L33 
L14:    iconst_2 
L15:    anewarray [3] 
L18:    dup 
L19:    iconst_0 
L20:    aload_0 
L21:    invokestatic [4] 
L24:    aastore 
L25:    dup 
L26:    iconst_1 
L27:    aload_1 
L28:    invokestatic [4] 
L31:    aastore 
L32:    areturn 
L33:    iconst_0 
L34:    anewarray [3] 
L37:    areturn 
L38:    nop 
L39:    nop 
L40:    
    .end code 
.end method 

.method static [113] : [114] 
    .attribute [108] .code stack 4 locals 1 
L0:     aload_0 
L1:     invokestatic [2] 
L4:     ifeq L71 
L7:     new [25] 
L10:    dup 
L11:    invokespecial [20] 
L14:    astore_1 
L15:    aload_1 
L16:    invokevirtual [16] 
L19:    aload_1 
L20:    bipush 11 
L22:    aload_0 
L23:    getfield [14] 
L26:    invokestatic [6] 
L29:    invokevirtual [17] 
L32:    aload_1 
L33:    bipush 12 
L35:    aload_0 
L36:    getfield [15] 
L39:    invokestatic [6] 
L42:    invokevirtual [17] 
L45:    aload_1 
L46:    bipush 13 
L48:    aload_0 
L49:    getfield [18] 
L52:    invokestatic [6] 
L55:    invokevirtual [17] 
L58:    new [24] 
L61:    dup 
L62:    aload_1 
L63:    invokevirtual [19] 
L66:    iconst_1 
L67:    invokespecial [21] 
L70:    areturn 
L71:    aconst_null 
L72:    areturn 
L73:    nop 
L74:    nop 
L75:    nop 
L76:    
    .end code 
.end method 

.method private [115] : [116] 
    .attribute [108] .code stack 3 locals 0 
L0:     aload_0 
L1:     invokespecial [22] 
L4:     new [26] 
L7:     dup 
L8:     ldc [8] 
L10:    invokespecial [23] 
L13:    athrow 
L14:    nop 
L15:    nop 
L16:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Method [27] [28] 
.const [3] = Class [29] 
.const [4] = Method [30] [31] 
.const [5] = Class [32] 
.const [6] = Method [33] [34] 
.const [7] = Class [35] 
.const [8] = String [36] 
.const [9] = Class [37] 
.const [10] = Class [38] 
.const [11] = Class [39] 
.const [12] = Class [40] 
.const [13] = Class [41] 
.const [14] = Field [42] [43] 
.const [15] = Field [44] [45] 
.const [16] = Method [46] [47] 
.const [17] = Method [48] [49] 
.const [18] = Field [50] [51] 
.const [19] = Method [52] [53] 
.const [20] = Method [54] [55] 
.const [21] = Method [56] [57] 
.const [22] = Method [58] [59] 
.const [23] = Method [60] [61] 
.const [24] = Class [62] 
.const [25] = Class [63] 
.const [26] = Class [64] 
.const [27] = Class [65] 
.const [28] = NameAndType [66] [67] 
.const [29] = Utf8 de/audi/atip/metrics/DateMetric 
.const [30] = Class [68] 
.const [31] = NameAndType [69] [70] 
.const [32] = Utf8 java/util/GregorianCalendar 
.const [33] = Class [71] 
.const [34] = NameAndType [72] [73] 
.const [35] = Utf8 java/lang/IllegalStateException 
.const [36] = Utf8 'This is a static helper class!' 
.const [37] = Utf8 de/audi/tv/app/BCDTime 
.const [38] = Utf8 java/lang/Object 
.const [39] = Utf8 org/dsi/ifc/tvtuner/Time 
.const [40] = Utf8 java/util/Calendar 
.const [41] = Utf8 de/audi/tv/app/TVUtil 
.const [42] = Class [74] 
.const [43] = NameAndType [75] [76] 
.const [44] = Class [77] 
.const [45] = NameAndType [78] [79] 
.const [46] = Class [80] 
.const [47] = NameAndType [81] [82] 
.const [48] = Class [83] 
.const [49] = NameAndType [84] [85] 
.const [50] = Class [86] 
.const [51] = NameAndType [87] [88] 
.const [52] = Class [89] 
.const [53] = NameAndType [90] [91] 
.const [54] = Class [92] 
.const [55] = NameAndType [93] [94] 
.const [56] = Class [95] 
.const [57] = NameAndType [96] [97] 
.const [58] = Class [98] 
.const [59] = NameAndType [99] [100] 
.const [60] = Class [101] 
.const [61] = NameAndType [102] [103] 
.const [62] = Utf8 de/audi/atip/metrics/DateMetric 
.const [63] = Utf8 java/util/GregorianCalendar 
.const [64] = Utf8 java/lang/IllegalStateException 
.const [65] = Utf8 de/audi/tv/app/BCDTime 
.const [66] = Utf8 isValid 
.const [67] = Utf8 (Lorg/dsi/ifc/tvtuner/Time;)Z 
.const [68] = Utf8 de/audi/tv/app/BCDTime 
.const [69] = Utf8 getDateMetric 
.const [70] = Utf8 (Lorg/dsi/ifc/tvtuner/Time;)Lde/audi/atip/metrics/DateMetric; 
.const [71] = Utf8 de/audi/tv/app/TVUtil 
.const [72] = Utf8 singleByteBCDToDual 
.const [73] = Utf8 (I)I 
.const [74] = Utf8 org/dsi/ifc/tvtuner/Time 
.const [75] = Utf8 hour 
.const [76] = Utf8 I 
.const [77] = Utf8 org/dsi/ifc/tvtuner/Time 
.const [78] = Utf8 minute 
.const [79] = Utf8 I 
.const [80] = Utf8 java/util/Calendar 
.const [81] = Utf8 clear 
.const [82] = Utf8 ()V 
.const [83] = Utf8 java/util/Calendar 
.const [84] = Utf8 set 
.const [85] = Utf8 (II)V 
.const [86] = Utf8 org/dsi/ifc/tvtuner/Time 
.const [87] = Utf8 second 
.const [88] = Utf8 I 
.const [89] = Utf8 java/util/Calendar 
.const [90] = Utf8 getTime 
.const [91] = Utf8 ()Ljava/util/Date; 
.const [92] = Utf8 java/util/GregorianCalendar 
.const [93] = Utf8 <init> 
.const [94] = Utf8 ()V 
.const [95] = Utf8 de/audi/atip/metrics/DateMetric 
.const [96] = Utf8 <init> 
.const [97] = Utf8 (Ljava/util/Date;I)V 
.const [98] = Utf8 java/lang/Object 
.const [99] = Utf8 <init> 
.const [100] = Utf8 ()V 
.const [101] = Utf8 java/lang/IllegalStateException 
.const [102] = Utf8 <init> 
.const [103] = Utf8 (Ljava/lang/String;)V 
.const [104] = Utf8 de/audi/tv/app/BCDTime 
.const [105] = Class [104] 
.const [106] = Utf8 java/lang/Object 
.const [107] = Class [106] 
.const [108] = Utf8 Code 
.const [109] = Utf8 isValid 
.const [110] = Utf8 (Lorg/dsi/ifc/tvtuner/Time;)Z 
.const [111] = Utf8 getDateMetrics 
.const [112] = Utf8 (Lorg/dsi/ifc/tvtuner/Time;Lorg/dsi/ifc/tvtuner/Time;)[Lde/audi/atip/metrics/DateMetric; 
.const [113] = Utf8 getDateMetric 
.const [114] = Utf8 (Lorg/dsi/ifc/tvtuner/Time;)Lde/audi/atip/metrics/DateMetric; 
.const [115] = Utf8 <init> 
.const [116] = Utf8 ()V 
.end class 
