.version 50 0 
.class public super [121] 
.super [123] 
.field private [124] [125] 
.field private [126] [127] 
.field private [128] [129] 
.field private [130] [131] 
.field private [132] [133] 

.method public [135] : [136] 
    .attribute [134] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [19] 
L4:     aload_0 
L5:     aload_1 
L6:     putfield [20] 
L9:     aload_0 
L10:    aload_1 
L11:    invokevirtual [9] 
L14:    putfield [21] 
L17:    return 
L18:    nop 
L19:    nop 
L20:    
    .end code 
.end method 

.method public [137] : [138] 
    .attribute [134] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [11] 
L4:     ifnull L20 
L7:     aload_0 
L8:     getfield [11] 
L11:    invokevirtual [12] 
L14:    aload_0 
L15:    getfield [13] 
L18:    iadd 
L19:    areturn 
L20:    aload_0 
L21:    getfield [14] 
L24:    areturn 
L25:    nop 
L26:    nop 
L27:    nop 
L28:    
    .end code 
.end method 

.method public interface [139] : [140] 
    .attribute [134] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [10] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [141] : [142] 
    .attribute [134] .code stack 2 locals 0 
L0:     aload_0 
L1:     iload_1 
L2:     putfield [24] 
L5:     return 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [143] : [144] 
    .attribute [134] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     putfield [22] 
L5:     aload_0 
L6:     iload_2 
L7:     putfield [23] 
L10:    return 
L11:    nop 
L12:    
    .end code 
.end method 

.method public interface [145] : [146] 
    .attribute [134] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [11] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public interface [147] : [148] 
    .attribute [134] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [13] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [149] : [150] 
    .attribute [134] .code stack 2 locals 2 
        .catch [3] from L0 to L11 using L14 
L0:     getstatic [2] 
L3:     aload_0 
L4:     getfield [8] 
L7:     invokevirtual [15] 
L10:    astore_1 
L11:    goto L23 
L14:    astore_2 
L15:    aload_0 
L16:    getfield [8] 
L19:    invokevirtual [16] 
L22:    astore_1 
L23:    aload_1 
L24:    areturn 
L25:    nop 
L26:    nop 
L27:    nop 
L28:    
    .end code 
.end method 

.method public [151] : [152] 
    .attribute [134] .code stack 2 locals 3 
L0:     aload_1 
L1:     getfield [8] 
L4:     astore_2 
L5:     aload_2 
L6:     invokevirtual [9] 
L9:     istore_3 
L10:    iload_3 
L11:    aload_0 
L12:    getfield [10] 
L15:    if_icmple L20 
L18:    iconst_m1 
L19:    areturn 
L20:    iload_3 
L21:    aload_0 
L22:    getfield [10] 
L25:    if_icmpne L43 
L28:    aload_2 
L29:    aload_0 
L30:    getfield [8] 
L33:    invokevirtual [17] 
L36:    ifeq L41 
L39:    iconst_0 
L40:    areturn 
L41:    iconst_m1 
L42:    areturn 
L43:    aload_0 
L44:    getfield [10] 
L47:    iload_3 
L48:    isub 
L49:    istore 4 
L51:    aload_0 
L52:    getfield [8] 
L55:    iload 4 
L57:    invokevirtual [18] 
L60:    aload_2 
L61:    invokevirtual [17] 
L64:    ifeq L70 
L67:    iload 4 
L69:    areturn 
L70:    iconst_m1 
L71:    areturn 
L72:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Field [25] [26] 
.const [3] = Class [27] 
.const [4] = Class [28] 
.const [5] = Class [29] 
.const [6] = Class [30] 
.const [7] = Class [31] 
.const [8] = Field [32] [33] 
.const [9] = Method [34] [35] 
.const [10] = Field [36] [37] 
.const [11] = Field [38] [39] 
.const [12] = Method [40] [41] 
.const [13] = Field [42] [43] 
.const [14] = Field [44] [45] 
.const [15] = Method [46] [47] 
.const [16] = Method [48] [49] 
.const [17] = Method [50] [51] 
.const [18] = Method [52] [53] 
.const [19] = Method [54] [55] 
.const [20] = Field [56] [57] 
.const [21] = Field [58] [59] 
.const [22] = Field [60] [61] 
.const [23] = Field [62] [63] 
.const [24] = Field [64] [65] 
.const [25] = Class [66] 
.const [26] = NameAndType [67] [68] 
.const [27] = Utf8 java/io/UnsupportedEncodingException 
.const [28] = Utf8 de/esolutions/fw/util/config/bcf/BCFStringEntry 
.const [29] = Utf8 java/lang/Object 
.const [30] = Utf8 java/lang/String 
.const [31] = Utf8 de/esolutions/fw/util/commons/StringConverter 
.const [32] = Class [69] 
.const [33] = NameAndType [70] [71] 
.const [34] = Class [72] 
.const [35] = NameAndType [73] [74] 
.const [36] = Class [75] 
.const [37] = NameAndType [76] [77] 
.const [38] = Class [78] 
.const [39] = NameAndType [79] [80] 
.const [40] = Class [81] 
.const [41] = NameAndType [82] [83] 
.const [42] = Class [84] 
.const [43] = NameAndType [85] [86] 
.const [44] = Class [87] 
.const [45] = NameAndType [88] [89] 
.const [46] = Class [90] 
.const [47] = NameAndType [91] [92] 
.const [48] = Class [93] 
.const [49] = NameAndType [94] [95] 
.const [50] = Class [96] 
.const [51] = NameAndType [97] [98] 
.const [52] = Class [99] 
.const [53] = NameAndType [100] [101] 
.const [54] = Class [102] 
.const [55] = NameAndType [103] [104] 
.const [56] = Class [105] 
.const [57] = NameAndType [106] [107] 
.const [58] = Class [108] 
.const [59] = NameAndType [109] [110] 
.const [60] = Class [111] 
.const [61] = NameAndType [112] [113] 
.const [62] = Class [114] 
.const [63] = NameAndType [115] [116] 
.const [64] = Class [117] 
.const [65] = NameAndType [118] [119] 
.const [66] = Utf8 de/esolutions/fw/util/commons/StringConverter 
.const [67] = Utf8 UTF8 
.const [68] = Utf8 Lde/esolutions/fw/util/commons/StringConverter; 
.const [69] = Utf8 de/esolutions/fw/util/config/bcf/BCFStringEntry 
.const [70] = Utf8 entry 
.const [71] = Utf8 Ljava/lang/String; 
.const [72] = Utf8 java/lang/String 
.const [73] = Utf8 length 
.const [74] = Utf8 ()I 
.const [75] = Utf8 de/esolutions/fw/util/config/bcf/BCFStringEntry 
.const [76] = Utf8 len 
.const [77] = Utf8 I 
.const [78] = Utf8 de/esolutions/fw/util/config/bcf/BCFStringEntry 
.const [79] = Utf8 mergeWith 
.const [80] = Utf8 Lde/esolutions/fw/util/config/bcf/BCFStringEntry; 
.const [81] = Utf8 de/esolutions/fw/util/config/bcf/BCFStringEntry 
.const [82] = Utf8 getOffset 
.const [83] = Utf8 ()I 
.const [84] = Utf8 de/esolutions/fw/util/config/bcf/BCFStringEntry 
.const [85] = Utf8 mergeOffset 
.const [86] = Utf8 I 
.const [87] = Utf8 de/esolutions/fw/util/config/bcf/BCFStringEntry 
.const [88] = Utf8 baseOffset 
.const [89] = Utf8 I 
.const [90] = Utf8 de/esolutions/fw/util/commons/StringConverter 
.const [91] = Utf8 getBytes 
.const [92] = Utf8 (Ljava/lang/String;)[B 
.const [93] = Utf8 java/lang/String 
.const [94] = Utf8 getBytes 
.const [95] = Utf8 ()[B 
.const [96] = Utf8 java/lang/String 
.const [97] = Utf8 equals 
.const [98] = Utf8 (Ljava/lang/Object;)Z 
.const [99] = Utf8 java/lang/String 
.const [100] = Utf8 substring 
.const [101] = Utf8 (I)Ljava/lang/String; 
.const [102] = Utf8 java/lang/Object 
.const [103] = Utf8 <init> 
.const [104] = Utf8 ()V 
.const [105] = Utf8 de/esolutions/fw/util/config/bcf/BCFStringEntry 
.const [106] = Utf8 entry 
.const [107] = Utf8 Ljava/lang/String; 
.const [108] = Utf8 de/esolutions/fw/util/config/bcf/BCFStringEntry 
.const [109] = Utf8 len 
.const [110] = Utf8 I 
.const [111] = Utf8 de/esolutions/fw/util/config/bcf/BCFStringEntry 
.const [112] = Utf8 mergeWith 
.const [113] = Utf8 Lde/esolutions/fw/util/config/bcf/BCFStringEntry; 
.const [114] = Utf8 de/esolutions/fw/util/config/bcf/BCFStringEntry 
.const [115] = Utf8 mergeOffset 
.const [116] = Utf8 I 
.const [117] = Utf8 de/esolutions/fw/util/config/bcf/BCFStringEntry 
.const [118] = Utf8 baseOffset 
.const [119] = Utf8 I 
.const [120] = Utf8 de/esolutions/fw/util/config/bcf/BCFStringEntry 
.const [121] = Class [120] 
.const [122] = Utf8 java/lang/Object 
.const [123] = Class [122] 
.const [124] = Utf8 entry 
.const [125] = Utf8 Ljava/lang/String; 
.const [126] = Utf8 len 
.const [127] = Utf8 I 
.const [128] = Utf8 mergeWith 
.const [129] = Utf8 Lde/esolutions/fw/util/config/bcf/BCFStringEntry; 
.const [130] = Utf8 mergeOffset 
.const [131] = Utf8 I 
.const [132] = Utf8 baseOffset 
.const [133] = Utf8 I 
.const [134] = Utf8 Code 
.const [135] = Utf8 <init> 
.const [136] = Utf8 (Ljava/lang/String;)V 
.const [137] = Utf8 getOffset 
.const [138] = Utf8 ()I 
.const [139] = Utf8 getLength 
.const [140] = Utf8 ()I 
.const [141] = Utf8 setBaseOffset 
.const [142] = Utf8 (I)V 
.const [143] = Utf8 setMerge 
.const [144] = Utf8 (Lde/esolutions/fw/util/config/bcf/BCFStringEntry;I)V 
.const [145] = Utf8 getMergeWith 
.const [146] = Utf8 ()Lde/esolutions/fw/util/config/bcf/BCFStringEntry; 
.const [147] = Utf8 getMergeOffset 
.const [148] = Utf8 ()I 
.const [149] = Utf8 toBytes 
.const [150] = Utf8 ()[B 
.const [151] = Utf8 canMerge 
.const [152] = Utf8 (Lde/esolutions/fw/util/config/bcf/BCFStringEntry;)I 
.end class 
