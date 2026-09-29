.version 50 0 
.class public super [167] 
.super [169] 
.field private static final [170] [171] 
.field private static [172] [173] 
.field public static final [174] [175] 
.field public static final [176] [177] 
.field private [178] [179] 
.field private [180] [181] 

.method public [183] : [184] 
    .attribute [182] .code stack 3 locals 0 
L0:     aload_0 
L1:     fload_1 
L2:     iconst_0 
L3:     invokespecial [28] 
L6:     aload_0 
L7:     iconst_0 
L8:     putfield [31] 
L11:    aload_0 
L12:    aload_2 
L13:    putfield [32] 
L16:    return 
L17:    nop 
L18:    nop 
L19:    nop 
L20:    
    .end code 
.end method 

.method public [185] : [186] 
    .attribute [182] .code stack 2 locals 0 
L0:     aload_0 
L1:     iload_1 
L2:     putfield [31] 
L5:     return 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [187] : [188] 
    .attribute [182] .code stack 2 locals 0 
L0:     aload_0 
L1:     fload_1 
L2:     putfield [33] 
L5:     return 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public interface [189] : [190] 
    .attribute [182] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [17] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [191] : [192] 
    .attribute [182] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [17] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [193] : [194] 
    .attribute [182] .code stack 2 locals 1 
L0:     new [34] 
L3:     dup 
L4:     invokespecial [29] 
L7:     astore_1 
L8:     aload_1 
L9:     aload_0 
L10:    invokevirtual [18] 
L13:    invokevirtual [19] 
L16:    pop 
L17:    aload_1 
L18:    ldc [3] 
L20:    invokevirtual [19] 
L23:    pop 
L24:    aload_1 
L25:    aload_0 
L26:    getfield [16] 
L29:    invokevirtual [19] 
L32:    pop 
L33:    aload_0 
L34:    getfield [20] 
L37:    aload_1 
L38:    invokestatic [4] 
L41:    ifne L52 
L44:    aload_0 
L45:    aload_1 
L46:    invokevirtual [21] 
L49:    putfield [35] 
L52:    aload_0 
L53:    getfield [20] 
L56:    areturn 
L57:    nop 
L58:    nop 
L59:    nop 
L60:    
    .end code 
.end method 

.method public [195] : [196] 
    .attribute [182] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokevirtual [22] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [197] : [198] 
    .attribute [182] .code stack 2 locals 0 
L0:     aconst_null 
L1:     aload_0 
L2:     getfield [16] 
L5:     if_acmpeq L18 
L8:     aload_0 
L9:     getfield [16] 
L12:    invokevirtual [23] 
L15:    goto L20 
L18:    ldc [5] 
L20:    areturn 
L21:    nop 
L22:    nop 
L23:    nop 
L24:    
    .end code 
.end method 

.method public [199] : [200] 
    .attribute [182] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokevirtual [24] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [201] : [202] 
    .attribute [182] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokevirtual [25] 
L4:     ifeq L53 
L7:     aload_0 
L8:     getfield [15] 
L11:    lookupswitch 
            0 : L45 
            1 : L36 
            default : L45 

L36:    aload_0 
L37:    getfield [17] 
L40:    f2i 
L41:    invokestatic [6] 
L44:    areturn 
L45:    aload_0 
L46:    getfield [17] 
L49:    invokestatic [7] 
L52:    areturn 
L53:    aload_0 
L54:    invokevirtual [26] 
L57:    areturn 
L58:    nop 
L59:    nop 
L60:    
    .end code 
.end method 

.method public [203] : [204] 
    .attribute [182] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokevirtual [18] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [205] : [206] 
    .attribute [182] .code stack 1 locals 0 
L0:     getstatic [8] 
L3:     areturn 
L4:     
    .end code 
.end method 

.method public [207] : [208] 
    .attribute [182] .code stack 4 locals 0 
L0:     iconst_2 
L1:     anewarray [9] 
L4:     dup 
L5:     iconst_0 
L6:     aload_0 
L7:     invokevirtual [18] 
L10:    aastore 
L11:    dup 
L12:    iconst_1 
L13:    aload_0 
L14:    getfield [16] 
L17:    aastore 
L18:    areturn 
L19:    nop 
L20:    
    .end code 
.end method 

.method public [209] : [210] 
    .attribute [182] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokevirtual [27] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method static [211] : [212] 
    .attribute [182] .code stack 1 locals 0 
L0:     ldc [10] 
L2:     putstatic [30] 
L5:     return 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [36] 
.const [3] = String [37] 
.const [4] = Method [38] [39] 
.const [5] = String [40] 
.const [6] = Method [41] [42] 
.const [7] = Method [43] [44] 
.const [8] = Field [45] [46] 
.const [9] = Class [47] 
.const [10] = String [48] 
.const [11] = Class [49] 
.const [12] = Class [50] 
.const [13] = Class [51] 
.const [14] = Class [52] 
.const [15] = Field [53] [54] 
.const [16] = Field [55] [56] 
.const [17] = Field [57] [58] 
.const [18] = Method [59] [60] 
.const [19] = Method [61] [62] 
.const [20] = Field [63] [64] 
.const [21] = Method [65] [66] 
.const [22] = Method [67] [68] 
.const [23] = Method [69] [70] 
.const [24] = Method [71] [72] 
.const [25] = Method [73] [74] 
.const [26] = Method [75] [76] 
.const [27] = Method [77] [78] 
.const [28] = Method [79] [80] 
.const [29] = Method [81] [82] 
.const [30] = Field [83] [84] 
.const [31] = Field [85] [86] 
.const [32] = Field [87] [88] 
.const [33] = Field [89] [90] 
.const [34] = Class [91] 
.const [35] = Field [92] [93] 
.const [36] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [37] = Utf8 ' ' 
.const [38] = Class [94] 
.const [39] = NameAndType [95] [96] 
.const [40] = Utf8 '' 
.const [41] = Class [97] 
.const [42] = NameAndType [98] [99] 
.const [43] = Class [100] 
.const [44] = NameAndType [101] [102] 
.const [45] = Class [103] 
.const [46] = NameAndType [104] [105] 
.const [47] = Utf8 java/lang/String 
.const [48] = Utf8 '---' 
.const [49] = Utf8 de/audi/atip/interapp/cartrip/CustomUnitMetric 
.const [50] = Utf8 de/audi/atip/metrics/AbstractMetrics 
.const [51] = Utf8 java/lang/Integer 
.const [52] = Utf8 java/lang/Float 
.const [53] = Class [106] 
.const [54] = NameAndType [107] [108] 
.const [55] = Class [109] 
.const [56] = NameAndType [110] [111] 
.const [57] = Class [112] 
.const [58] = NameAndType [113] [114] 
.const [59] = Class [115] 
.const [60] = NameAndType [116] [117] 
.const [61] = Class [118] 
.const [62] = NameAndType [119] [120] 
.const [63] = Class [121] 
.const [64] = NameAndType [122] [123] 
.const [65] = Class [124] 
.const [66] = NameAndType [125] [126] 
.const [67] = Class [127] 
.const [68] = NameAndType [128] [129] 
.const [69] = Class [130] 
.const [70] = NameAndType [131] [132] 
.const [71] = Class [133] 
.const [72] = NameAndType [134] [135] 
.const [73] = Class [136] 
.const [74] = NameAndType [137] [138] 
.const [75] = Class [139] 
.const [76] = NameAndType [140] [141] 
.const [77] = Class [142] 
.const [78] = NameAndType [143] [144] 
.const [79] = Class [145] 
.const [80] = NameAndType [146] [147] 
.const [81] = Class [148] 
.const [82] = NameAndType [149] [150] 
.const [83] = Class [151] 
.const [84] = NameAndType [152] [153] 
.const [85] = Class [154] 
.const [86] = NameAndType [155] [156] 
.const [87] = Class [157] 
.const [88] = NameAndType [158] [159] 
.const [89] = Class [160] 
.const [90] = NameAndType [161] [162] 
.const [91] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [92] = Class [163] 
.const [93] = NameAndType [164] [165] 
.const [94] = Utf8 de/audi/atip/interapp/cartrip/CustomUnitMetric 
.const [95] = Utf8 contentEquals 
.const [96] = Utf8 (Ljava/lang/String;Lde/esolutions/fw/util/commons/Buffer;)Z 
.const [97] = Utf8 java/lang/Integer 
.const [98] = Utf8 toString 
.const [99] = Utf8 (I)Ljava/lang/String; 
.const [100] = Utf8 java/lang/Float 
.const [101] = Utf8 toString 
.const [102] = Utf8 (F)Ljava/lang/String; 
.const [103] = Utf8 de/audi/atip/interapp/cartrip/CustomUnitMetric 
.const [104] = Utf8 TEXT_INVALID 
.const [105] = Utf8 Ljava/lang/String; 
.const [106] = Utf8 de/audi/atip/interapp/cartrip/CustomUnitMetric 
.const [107] = Utf8 valueFormat 
.const [108] = Utf8 I 
.const [109] = Utf8 de/audi/atip/interapp/cartrip/CustomUnitMetric 
.const [110] = Utf8 unitString 
.const [111] = Utf8 Ljava/lang/String; 
.const [112] = Utf8 de/audi/atip/interapp/cartrip/CustomUnitMetric 
.const [113] = Utf8 value 
.const [114] = Utf8 F 
.const [115] = Utf8 de/audi/atip/interapp/cartrip/CustomUnitMetric 
.const [116] = Utf8 getFormattedValue 
.const [117] = Utf8 ()Ljava/lang/String; 
.const [118] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [119] = Utf8 append 
.const [120] = Utf8 (Ljava/lang/String;)Lde/esolutions/fw/util/commons/Buffer; 
.const [121] = Utf8 de/audi/atip/interapp/cartrip/CustomUnitMetric 
.const [122] = Utf8 lastFormat 
.const [123] = Utf8 Ljava/lang/String; 
.const [124] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [125] = Utf8 toString 
.const [126] = Utf8 ()Ljava/lang/String; 
.const [127] = Utf8 de/audi/atip/interapp/cartrip/CustomUnitMetric 
.const [128] = Utf8 format 
.const [129] = Utf8 ()Ljava/lang/String; 
.const [130] = Utf8 java/lang/String 
.const [131] = Utf8 trim 
.const [132] = Utf8 ()Ljava/lang/String; 
.const [133] = Utf8 de/audi/atip/interapp/cartrip/CustomUnitMetric 
.const [134] = Utf8 getFormattedMetricUnit 
.const [135] = Utf8 ()Ljava/lang/String; 
.const [136] = Utf8 de/audi/atip/interapp/cartrip/CustomUnitMetric 
.const [137] = Utf8 isMetricvalid 
.const [138] = Utf8 ()Z 
.const [139] = Utf8 de/audi/atip/interapp/cartrip/CustomUnitMetric 
.const [140] = Utf8 getInvalidText 
.const [141] = Utf8 ()Ljava/lang/String; 
.const [142] = Utf8 de/audi/atip/interapp/cartrip/CustomUnitMetric 
.const [143] = Utf8 getStringValueAndUnit 
.const [144] = Utf8 ()[Ljava/lang/String; 
.const [145] = Utf8 de/audi/atip/metrics/AbstractMetrics 
.const [146] = Utf8 <init> 
.const [147] = Utf8 (FI)V 
.const [148] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [149] = Utf8 <init> 
.const [150] = Utf8 ()V 
.const [151] = Utf8 de/audi/atip/interapp/cartrip/CustomUnitMetric 
.const [152] = Utf8 TEXT_INVALID 
.const [153] = Utf8 Ljava/lang/String; 
.const [154] = Utf8 de/audi/atip/interapp/cartrip/CustomUnitMetric 
.const [155] = Utf8 valueFormat 
.const [156] = Utf8 I 
.const [157] = Utf8 de/audi/atip/interapp/cartrip/CustomUnitMetric 
.const [158] = Utf8 unitString 
.const [159] = Utf8 Ljava/lang/String; 
.const [160] = Utf8 de/audi/atip/interapp/cartrip/CustomUnitMetric 
.const [161] = Utf8 value 
.const [162] = Utf8 F 
.const [163] = Utf8 de/audi/atip/interapp/cartrip/CustomUnitMetric 
.const [164] = Utf8 lastFormat 
.const [165] = Utf8 Ljava/lang/String; 
.const [166] = Utf8 de/audi/atip/interapp/cartrip/CustomUnitMetric 
.const [167] = Class [166] 
.const [168] = Utf8 de/audi/atip/metrics/AbstractMetrics 
.const [169] = Class [168] 
.const [170] = Utf8 SEPARATOR 
.const [171] = Utf8 Ljava/lang/String; 
.const [172] = Utf8 TEXT_INVALID 
.const [173] = Utf8 Ljava/lang/String; 
.const [174] = Utf8 VALUE_FORMAT_FLOAT 
.const [175] = Utf8 I 
.const [176] = Utf8 VALUE_FORMAT_INT 
.const [177] = Utf8 I 
.const [178] = Utf8 valueFormat 
.const [179] = Utf8 I 
.const [180] = Utf8 unitString 
.const [181] = Utf8 Ljava/lang/String; 
.const [182] = Utf8 Code 
.const [183] = Utf8 <init> 
.const [184] = Utf8 (FLjava/lang/String;)V 
.const [185] = Utf8 setValueFormat 
.const [186] = Utf8 (I)V 
.const [187] = Utf8 setValue 
.const [188] = Utf8 (F)V 
.const [189] = Utf8 getValue 
.const [190] = Utf8 ()F 
.const [191] = Utf8 getValue 
.const [192] = Utf8 (I)F 
.const [193] = Utf8 format 
.const [194] = Utf8 ()Ljava/lang/String; 
.const [195] = Utf8 format 
.const [196] = Utf8 (I)Ljava/lang/String; 
.const [197] = Utf8 getFormattedMetricUnit 
.const [198] = Utf8 ()Ljava/lang/String; 
.const [199] = Utf8 getFormattedUnit 
.const [200] = Utf8 (I)Ljava/lang/String; 
.const [201] = Utf8 getFormattedValue 
.const [202] = Utf8 ()Ljava/lang/String; 
.const [203] = Utf8 getFormattedValue 
.const [204] = Utf8 (I)Ljava/lang/String; 
.const [205] = Utf8 getInvalidText 
.const [206] = Utf8 ()Ljava/lang/String; 
.const [207] = Utf8 getStringValueAndUnit 
.const [208] = Utf8 ()[Ljava/lang/String; 
.const [209] = Utf8 getStringValueAndUnit 
.const [210] = Utf8 (I)[Ljava/lang/String; 
.const [211] = Utf8 <clinit> 
.const [212] = Utf8 ()V 
.end class 
