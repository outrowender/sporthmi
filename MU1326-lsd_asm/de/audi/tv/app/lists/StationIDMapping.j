.version 50 0 
.class super [69] 
.super [71] 
.field final [72] [73] 
.field final [74] [75] 
.field final [76] [77] 
.field final [78] [79] 

.method [81] : [82] 
    .attribute [80] .code stack 3 locals 0 
L0:     aload_0 
L1:     invokespecial [10] 
L4:     aload_0 
L5:     lload_1 
L6:     putfield [11] 
L9:     aload_0 
L10:    iload_3 
L11:    putfield [12] 
L14:    aload_0 
L15:    iload 4 
L17:    putfield [13] 
L20:    aload_0 
L21:    lload 5 
L23:    putfield [14] 
L26:    return 
L27:    nop 
L28:    
    .end code 
.end method 

.method public [83] : [84] 
    .attribute [80] .code stack 4 locals 0 
L0:     aload_1 
L1:     instanceof [2] 
L4:     ifeq L56 
L7:     aload_0 
L8:     getfield [6] 
L11:    aload_1 
L12:    checkcast [2] 
L15:    getfield [6] 
L18:    lcmp 
L19:    ifne L54 
L22:    aload_0 
L23:    getfield [7] 
L26:    aload_1 
L27:    checkcast [2] 
L30:    getfield [7] 
L33:    if_icmpne L54 
L36:    aload_0 
L37:    getfield [8] 
L40:    aload_1 
L41:    checkcast [2] 
L44:    getfield [8] 
L47:    if_icmpne L54 
L50:    iconst_1 
L51:    goto L55 
L54:    iconst_0 
L55:    areturn 
L56:    iconst_0 
L57:    areturn 
L58:    nop 
L59:    nop 
L60:    
    .end code 
.end method 

.method [85] : [86] 
    .attribute [80] .code stack 4 locals 0 
L0:     aload_1 
L1:     ifnonnull L6 
L4:     iconst_0 
L5:     areturn 
L6:     aload_0 
L7:     getfield [6] 
L10:    aload_1 
L11:    getfield [6] 
L14:    lcmp 
L15:    ifne L22 
L18:    iconst_1 
L19:    goto L23 
L22:    iconst_0 
L23:    areturn 
L24:    
    .end code 
.end method 

.method public [87] : [88] 
    .attribute [80] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [9] 
L4:     invokestatic [3] 
L7:     areturn 
L8:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [15] 
.const [3] = Method [16] [17] 
.const [4] = Class [18] 
.const [5] = Class [19] 
.const [6] = Field [20] [21] 
.const [7] = Field [22] [23] 
.const [8] = Field [24] [25] 
.const [9] = Field [26] [27] 
.const [10] = Method [28] [29] 
.const [11] = Field [30] [31] 
.const [12] = Field [32] [33] 
.const [13] = Field [34] [35] 
.const [14] = Field [36] [37] 
.const [15] = Utf8 de/audi/tv/app/lists/StationIDMapping 
.const [16] = Class [38] 
.const [17] = NameAndType [39] [40] 
.const [18] = Utf8 java/lang/Object 
.const [19] = Utf8 de/audi/tv/app/lists/StationMapper 
.const [20] = Class [41] 
.const [21] = NameAndType [42] [43] 
.const [22] = Class [44] 
.const [23] = NameAndType [45] [46] 
.const [24] = Class [47] 
.const [25] = NameAndType [48] [49] 
.const [26] = Class [50] 
.const [27] = NameAndType [51] [52] 
.const [28] = Class [53] 
.const [29] = NameAndType [54] [55] 
.const [30] = Class [56] 
.const [31] = NameAndType [57] [58] 
.const [32] = Class [59] 
.const [33] = NameAndType [60] [61] 
.const [34] = Class [62] 
.const [35] = NameAndType [63] [64] 
.const [36] = Class [65] 
.const [37] = NameAndType [66] [67] 
.const [38] = Utf8 de/audi/tv/app/lists/StationMapper 
.const [39] = Utf8 getCombiID 
.const [40] = Utf8 (J)I 
.const [41] = Utf8 de/audi/tv/app/lists/StationIDMapping 
.const [42] = Utf8 namePID 
.const [43] = Utf8 J 
.const [44] = Utf8 de/audi/tv/app/lists/StationIDMapping 
.const [45] = Utf8 servicePID 
.const [46] = Utf8 I 
.const [47] = Utf8 de/audi/tv/app/lists/StationIDMapping 
.const [48] = Utf8 sType 
.const [49] = Utf8 I 
.const [50] = Utf8 de/audi/tv/app/lists/StationIDMapping 
.const [51] = Utf8 mappedID 
.const [52] = Utf8 J 
.const [53] = Utf8 java/lang/Object 
.const [54] = Utf8 <init> 
.const [55] = Utf8 ()V 
.const [56] = Utf8 de/audi/tv/app/lists/StationIDMapping 
.const [57] = Utf8 namePID 
.const [58] = Utf8 J 
.const [59] = Utf8 de/audi/tv/app/lists/StationIDMapping 
.const [60] = Utf8 servicePID 
.const [61] = Utf8 I 
.const [62] = Utf8 de/audi/tv/app/lists/StationIDMapping 
.const [63] = Utf8 sType 
.const [64] = Utf8 I 
.const [65] = Utf8 de/audi/tv/app/lists/StationIDMapping 
.const [66] = Utf8 mappedID 
.const [67] = Utf8 J 
.const [68] = Utf8 de/audi/tv/app/lists/StationIDMapping 
.const [69] = Class [68] 
.const [70] = Utf8 java/lang/Object 
.const [71] = Class [70] 
.const [72] = Utf8 namePID 
.const [73] = Utf8 J 
.const [74] = Utf8 servicePID 
.const [75] = Utf8 I 
.const [76] = Utf8 sType 
.const [77] = Utf8 I 
.const [78] = Utf8 mappedID 
.const [79] = Utf8 J 
.const [80] = Utf8 Code 
.const [81] = Utf8 <init> 
.const [82] = Utf8 (JIIJ)V 
.const [83] = Utf8 equals 
.const [84] = Utf8 (Ljava/lang/Object;)Z 
.const [85] = Utf8 equalsNamePID 
.const [86] = Utf8 (Lde/audi/tv/app/lists/StationIDMapping;)Z 
.const [87] = Utf8 hashCode 
.const [88] = Utf8 ()I 
.end class 
