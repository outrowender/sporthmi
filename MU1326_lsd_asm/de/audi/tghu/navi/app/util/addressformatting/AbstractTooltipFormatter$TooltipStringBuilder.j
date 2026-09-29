.version 50 0 
.class public super [109] 
.super [111] 
.field private final [112] [113] 
.field private [114] [115] 
.field private [116] [117] 
.field private final synthetic [118] [119] 

.method public [121] : [122] 
    .attribute [120] .code stack 3 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     putfield [20] 
L5:     aload_0 
L6:     invokespecial [18] 
L9:     aload_0 
L10:    new [21] 
L13:    dup 
L14:    invokespecial [19] 
L17:    putfield [22] 
L20:    aload_0 
L21:    iconst_0 
L22:    putfield [23] 
L25:    aload_0 
L26:    iconst_0 
L27:    putfield [24] 
L30:    return 
L31:    nop 
L32:    
    .end code 
.end method 

.method public [123] : [124] 
    .attribute [120] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [10] 
L4:     invokevirtual [13] 
L7:     ifle L22 
L10:    aload_0 
L11:    iconst_1 
L12:    putfield [23] 
L15:    aload_0 
L16:    iconst_0 
L17:    putfield [24] 
L20:    iconst_1 
L21:    areturn 
L22:    iconst_0 
L23:    areturn 
L24:    
    .end code 
.end method 

.method public [125] : [126] 
    .attribute [120] .code stack 2 locals 0 
L0:     aload_1 
L1:     invokestatic [3] 
L4:     ifne L61 
L7:     aload_0 
L8:     getfield [11] 
L11:    ifeq L29 
L14:    aload_0 
L15:    getfield [10] 
L18:    bipush 10 
L20:    invokevirtual [14] 
L23:    pop 
L24:    aload_0 
L25:    iconst_0 
L26:    putfield [23] 
L29:    aload_0 
L30:    getfield [12] 
L33:    ifeq L45 
L36:    aload_0 
L37:    getfield [10] 
L40:    aload_2 
L41:    invokevirtual [15] 
L44:    pop 
L45:    aload_0 
L46:    getfield [10] 
L49:    aload_1 
L50:    invokevirtual [15] 
L53:    pop 
L54:    aload_0 
L55:    iconst_1 
L56:    putfield [24] 
L59:    iconst_1 
L60:    areturn 
L61:    iconst_0 
L62:    areturn 
L63:    nop 
L64:    
    .end code 
.end method 

.method public [127] : [128] 
    .attribute [120] .code stack 3 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     ldc [4] 
L4:     invokevirtual [16] 
L7:     areturn 
L8:     
    .end code 
.end method 

.method public [129] : [130] 
    .attribute [120] .code stack 3 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     ldc [5] 
L4:     invokevirtual [16] 
L7:     areturn 
L8:     
    .end code 
.end method 

.method public [131] : [132] 
    .attribute [120] .code stack 3 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     ldc [6] 
L4:     invokevirtual [16] 
L7:     areturn 
L8:     
    .end code 
.end method 

.method public [133] : [134] 
    .attribute [120] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [10] 
L4:     invokevirtual [13] 
L7:     ifne L12 
L10:    aconst_null 
L11:    areturn 
L12:    aload_0 
L13:    getfield [10] 
L16:    invokevirtual [17] 
L19:    areturn 
L20:    
    .end code 
.end method 

.method public [135] : [136] 
    .attribute [120] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [10] 
L4:     invokevirtual [13] 
L7:     ifne L14 
L10:    iconst_1 
L11:    goto L15 
L14:    iconst_0 
L15:    areturn 
L16:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [25] 
.const [3] = Method [26] [27] 
.const [4] = String [28] 
.const [5] = String [29] 
.const [6] = String [30] 
.const [7] = Class [31] 
.const [8] = Class [32] 
.const [9] = Class [33] 
.const [10] = Field [34] [35] 
.const [11] = Field [36] [37] 
.const [12] = Field [38] [39] 
.const [13] = Method [40] [41] 
.const [14] = Method [42] [43] 
.const [15] = Method [44] [45] 
.const [16] = Method [46] [47] 
.const [17] = Method [48] [49] 
.const [18] = Method [50] [51] 
.const [19] = Method [52] [53] 
.const [20] = Field [54] [55] 
.const [21] = Class [56] 
.const [22] = Field [57] [58] 
.const [23] = Field [59] [60] 
.const [24] = Field [61] [62] 
.const [25] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [26] = Class [63] 
.const [27] = NameAndType [64] [65] 
.const [28] = Utf8 ', ' 
.const [29] = Utf8 ' ' 
.const [30] = Utf8 '' 
.const [31] = Utf8 de/audi/tghu/navi/app/util/addressformatting/AbstractTooltipFormatter$TooltipStringBuilder 
.const [32] = Utf8 java/lang/Object 
.const [33] = Utf8 de/audi/tghu/navi/app/util/Util 
.const [34] = Class [66] 
.const [35] = NameAndType [67] [68] 
.const [36] = Class [69] 
.const [37] = NameAndType [70] [71] 
.const [38] = Class [72] 
.const [39] = NameAndType [73] [74] 
.const [40] = Class [75] 
.const [41] = NameAndType [76] [77] 
.const [42] = Class [78] 
.const [43] = NameAndType [79] [80] 
.const [44] = Class [81] 
.const [45] = NameAndType [82] [83] 
.const [46] = Class [84] 
.const [47] = NameAndType [85] [86] 
.const [48] = Class [87] 
.const [49] = NameAndType [88] [89] 
.const [50] = Class [90] 
.const [51] = NameAndType [91] [92] 
.const [52] = Class [93] 
.const [53] = NameAndType [94] [95] 
.const [54] = Class [96] 
.const [55] = NameAndType [97] [98] 
.const [56] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [57] = Class [99] 
.const [58] = NameAndType [100] [101] 
.const [59] = Class [102] 
.const [60] = NameAndType [103] [104] 
.const [61] = Class [105] 
.const [62] = NameAndType [106] [107] 
.const [63] = Utf8 de/audi/tghu/navi/app/util/Util 
.const [64] = Utf8 isEmpty 
.const [65] = Utf8 (Ljava/lang/String;)Z 
.const [66] = Utf8 de/audi/tghu/navi/app/util/addressformatting/AbstractTooltipFormatter$TooltipStringBuilder 
.const [67] = Utf8 buffer 
.const [68] = Utf8 Lde/esolutions/fw/util/commons/Buffer; 
.const [69] = Utf8 de/audi/tghu/navi/app/util/addressformatting/AbstractTooltipFormatter$TooltipStringBuilder 
.const [70] = Utf8 lineBreakRequested 
.const [71] = Utf8 Z 
.const [72] = Utf8 de/audi/tghu/navi/app/util/addressformatting/AbstractTooltipFormatter$TooltipStringBuilder 
.const [73] = Utf8 separatorNeeded 
.const [74] = Utf8 Z 
.const [75] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [76] = Utf8 length 
.const [77] = Utf8 ()I 
.const [78] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [79] = Utf8 append 
.const [80] = Utf8 (C)Lde/esolutions/fw/util/commons/Buffer; 
.const [81] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [82] = Utf8 append 
.const [83] = Utf8 (Ljava/lang/String;)Lde/esolutions/fw/util/commons/Buffer; 
.const [84] = Utf8 de/audi/tghu/navi/app/util/addressformatting/AbstractTooltipFormatter$TooltipStringBuilder 
.const [85] = Utf8 addString 
.const [86] = Utf8 (Ljava/lang/String;Ljava/lang/String;)Z 
.const [87] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [88] = Utf8 toString 
.const [89] = Utf8 ()Ljava/lang/String; 
.const [90] = Utf8 java/lang/Object 
.const [91] = Utf8 <init> 
.const [92] = Utf8 ()V 
.const [93] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [94] = Utf8 <init> 
.const [95] = Utf8 ()V 
.const [96] = Utf8 de/audi/tghu/navi/app/util/addressformatting/AbstractTooltipFormatter$TooltipStringBuilder 
.const [97] = Utf8 this$0 
.const [98] = Utf8 Lde/audi/tghu/navi/app/util/addressformatting/AbstractTooltipFormatter; 
.const [99] = Utf8 de/audi/tghu/navi/app/util/addressformatting/AbstractTooltipFormatter$TooltipStringBuilder 
.const [100] = Utf8 buffer 
.const [101] = Utf8 Lde/esolutions/fw/util/commons/Buffer; 
.const [102] = Utf8 de/audi/tghu/navi/app/util/addressformatting/AbstractTooltipFormatter$TooltipStringBuilder 
.const [103] = Utf8 lineBreakRequested 
.const [104] = Utf8 Z 
.const [105] = Utf8 de/audi/tghu/navi/app/util/addressformatting/AbstractTooltipFormatter$TooltipStringBuilder 
.const [106] = Utf8 separatorNeeded 
.const [107] = Utf8 Z 
.const [108] = Utf8 de/audi/tghu/navi/app/util/addressformatting/AbstractTooltipFormatter$TooltipStringBuilder 
.const [109] = Class [108] 
.const [110] = Utf8 java/lang/Object 
.const [111] = Class [110] 
.const [112] = Utf8 buffer 
.const [113] = Utf8 Lde/esolutions/fw/util/commons/Buffer; 
.const [114] = Utf8 lineBreakRequested 
.const [115] = Utf8 Z 
.const [116] = Utf8 separatorNeeded 
.const [117] = Utf8 Z 
.const [118] = Utf8 this$0 
.const [119] = Utf8 Lde/audi/tghu/navi/app/util/addressformatting/AbstractTooltipFormatter; 
.const [120] = Utf8 Code 
.const [121] = Utf8 <init> 
.const [122] = Utf8 (Lde/audi/tghu/navi/app/util/addressformatting/AbstractTooltipFormatter;)V 
.const [123] = Utf8 addLineBreak 
.const [124] = Utf8 ()Z 
.const [125] = Utf8 addString 
.const [126] = Utf8 (Ljava/lang/String;Ljava/lang/String;)Z 
.const [127] = Utf8 addString 
.const [128] = Utf8 (Ljava/lang/String;)Z 
.const [129] = Utf8 addStringWithoutComma 
.const [130] = Utf8 (Ljava/lang/String;)Z 
.const [131] = Utf8 addStringWithoutSeparator 
.const [132] = Utf8 (Ljava/lang/String;)Z 
.const [133] = Utf8 toString 
.const [134] = Utf8 ()Ljava/lang/String; 
.const [135] = Utf8 isEmpty 
.const [136] = Utf8 ()Z 
.end class 
