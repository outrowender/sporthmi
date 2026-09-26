.version 50 0 
.class public final super [89] 
.super [91] 
.implements [93] 
.field public final [94] [95] 
.field public final [96] [97] 
.field public final [98] [99] 
.field public final [100] [101] 

.method public [103] : [104] 
    .attribute [102] .code stack 3 locals 0 
L0:     aload_0 
L1:     invokespecial [12] 
L4:     aload_0 
L5:     aload_1 
L6:     putfield [14] 
L9:     aload_0 
L10:    lload_2 
L11:    putfield [15] 
L14:    aload_0 
L15:    iload 4 
L17:    putfield [16] 
L20:    aload_0 
L21:    aconst_null 
L22:    putfield [17] 
L25:    return 
L26:    nop 
L27:    nop 
L28:    
    .end code 
.end method 

.method public [105] : [106] 
    .attribute [102] .code stack 3 locals 0 
L0:     aload_0 
L1:     invokespecial [12] 
L4:     aload_0 
L5:     aload_1 
L6:     putfield [14] 
L9:     aload_0 
L10:    ldc2_w [18] 
L13:    putfield [15] 
L16:    aload_0 
L17:    iconst_m1 
L18:    putfield [16] 
L21:    aload_0 
L22:    aload_2 
L23:    putfield [17] 
L26:    return 
L27:    nop 
L28:    
    .end code 
.end method 

.method public [107] : [108] 
    .attribute [102] .code stack 2 locals 0 
L0:     aload_1 
L1:     ifnonnull L6 
L4:     iconst_0 
L5:     areturn 
L6:     aload_1 
L7:     aload_0 
L8:     if_acmpne L13 
L11:    iconst_0 
L12:    areturn 
L13:    aload_0 
L14:    invokespecial [13] 
L17:    aload_1 
L18:    invokespecial [13] 
L21:    if_acmpeq L26 
L24:    iconst_0 
L25:    areturn 
L26:    aload_0 
L27:    getfield [5] 
L30:    aload_1 
L31:    checkcast [2] 
L34:    getfield [5] 
L37:    invokevirtual [9] 
L40:    areturn 
L41:    nop 
L42:    nop 
L43:    nop 
L44:    
    .end code 
.end method 

.method public [109] : [110] 
    .attribute [102] .code stack 6 locals 2 
L0:     iconst_1 
L1:     istore_2 
L2:     bipush 31 
L4:     iload_2 
L5:     imul 
L6:     aload_0 
L7:     getfield [6] 
L10:    aload_0 
L11:    getfield [6] 
L14:    bipush 32 
L16:    lushr 
L17:    lxor 
L18:    l2i 
L19:    iadd 
L20:    istore_2 
L21:    bipush 31 
L23:    iload_2 
L24:    imul 
L25:    aload_0 
L26:    getfield [5] 
L29:    ifnonnull L36 
L32:    iconst_0 
L33:    goto L43 
L36:    aload_0 
L37:    getfield [5] 
L40:    invokevirtual [10] 
L43:    iadd 
L44:    istore_2 
L45:    iload_2 
L46:    areturn 
L47:    nop 
L48:    
    .end code 
.end method 

.method public [111] : [112] 
    .attribute [102] .code stack 4 locals 1 
L0:     aload_0 
L1:     aload_1 
L2:     if_acmpne L7 
L5:     iconst_1 
L6:     areturn 
L7:     aload_1 
L8:     ifnonnull L13 
L11:    iconst_0 
L12:    areturn 
L13:    aload_0 
L14:    invokespecial [13] 
L17:    aload_1 
L18:    invokespecial [13] 
L21:    if_acmpeq L26 
L24:    iconst_0 
L25:    areturn 
L26:    aload_1 
L27:    checkcast [2] 
L30:    astore_2 
L31:    aload_0 
L32:    getfield [7] 
L35:    aload_2 
L36:    getfield [7] 
L39:    if_icmpeq L44 
L42:    iconst_0 
L43:    areturn 
L44:    aload_0 
L45:    getfield [6] 
L48:    aload_2 
L49:    getfield [6] 
L52:    lcmp 
L53:    ifeq L58 
L56:    iconst_0 
L57:    areturn 
L58:    aload_0 
L59:    getfield [8] 
L62:    aload_2 
L63:    getfield [8] 
L66:    if_acmpeq L71 
L69:    iconst_0 
L70:    areturn 
L71:    aload_0 
L72:    getfield [5] 
L75:    ifnonnull L87 
L78:    aload_2 
L79:    getfield [5] 
L82:    ifnull L103 
L85:    iconst_0 
L86:    areturn 
L87:    aload_0 
L88:    getfield [5] 
L91:    aload_2 
L92:    getfield [5] 
L95:    invokevirtual [11] 
L98:    ifne L103 
L101:   iconst_0 
L102:   areturn 
L103:   iconst_1 
L104:   areturn 
L105:   nop 
L106:   nop 
L107:   nop 
L108:   
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [20] 
.const [3] = Class [21] 
.const [4] = Class [22] 
.const [5] = Field [23] [24] 
.const [6] = Field [25] [26] 
.const [7] = Field [27] [28] 
.const [8] = Field [29] [30] 
.const [9] = Method [31] [32] 
.const [10] = Method [33] [34] 
.const [11] = Method [35] [36] 
.const [12] = Method [37] [38] 
.const [13] = Method [39] [40] 
.const [14] = Field [41] [42] 
.const [15] = Field [43] [44] 
.const [16] = Field [45] [46] 
.const [17] = Field [47] [48] 
.const [18] = Long -1L 
.const [20] = Utf8 de/audi/tghu/navi/app/memory/RouteListData 
.const [21] = Utf8 java/lang/Object 
.const [22] = Utf8 java/lang/String 
.const [23] = Class [49] 
.const [24] = NameAndType [50] [51] 
.const [25] = Class [52] 
.const [26] = NameAndType [53] [54] 
.const [27] = Class [55] 
.const [28] = NameAndType [56] [57] 
.const [29] = Class [58] 
.const [30] = NameAndType [59] [60] 
.const [31] = Class [61] 
.const [32] = NameAndType [62] [63] 
.const [33] = Class [64] 
.const [34] = NameAndType [65] [66] 
.const [35] = Class [67] 
.const [36] = NameAndType [68] [69] 
.const [37] = Class [70] 
.const [38] = NameAndType [71] [72] 
.const [39] = Class [73] 
.const [40] = NameAndType [74] [75] 
.const [41] = Class [76] 
.const [42] = NameAndType [77] [78] 
.const [43] = Class [79] 
.const [44] = NameAndType [80] [81] 
.const [45] = Class [82] 
.const [46] = NameAndType [83] [84] 
.const [47] = Class [85] 
.const [48] = NameAndType [86] [87] 
.const [49] = Utf8 de/audi/tghu/navi/app/memory/RouteListData 
.const [50] = Utf8 name 
.const [51] = Utf8 Ljava/lang/String; 
.const [52] = Utf8 de/audi/tghu/navi/app/memory/RouteListData 
.const [53] = Utf8 id 
.const [54] = Utf8 J 
.const [55] = Utf8 de/audi/tghu/navi/app/memory/RouteListData 
.const [56] = Utf8 memoryId 
.const [57] = Utf8 I 
.const [58] = Utf8 de/audi/tghu/navi/app/memory/RouteListData 
.const [59] = Utf8 segmentId 
.const [60] = Utf8 Lorg/dsi/ifc/global/NavSegmentID; 
.const [61] = Utf8 java/lang/String 
.const [62] = Utf8 compareTo 
.const [63] = Utf8 (Ljava/lang/String;)I 
.const [64] = Utf8 java/lang/String 
.const [65] = Utf8 hashCode 
.const [66] = Utf8 ()I 
.const [67] = Utf8 java/lang/String 
.const [68] = Utf8 equals 
.const [69] = Utf8 (Ljava/lang/Object;)Z 
.const [70] = Utf8 java/lang/Object 
.const [71] = Utf8 <init> 
.const [72] = Utf8 ()V 
.const [73] = Utf8 java/lang/Object 
.const [74] = Utf8 getClass 
.const [75] = Utf8 ()Ljava/lang/Class; 
.const [76] = Utf8 de/audi/tghu/navi/app/memory/RouteListData 
.const [77] = Utf8 name 
.const [78] = Utf8 Ljava/lang/String; 
.const [79] = Utf8 de/audi/tghu/navi/app/memory/RouteListData 
.const [80] = Utf8 id 
.const [81] = Utf8 J 
.const [82] = Utf8 de/audi/tghu/navi/app/memory/RouteListData 
.const [83] = Utf8 memoryId 
.const [84] = Utf8 I 
.const [85] = Utf8 de/audi/tghu/navi/app/memory/RouteListData 
.const [86] = Utf8 segmentId 
.const [87] = Utf8 Lorg/dsi/ifc/global/NavSegmentID; 
.const [88] = Utf8 de/audi/tghu/navi/app/memory/RouteListData 
.const [89] = Class [88] 
.const [90] = Utf8 java/lang/Object 
.const [91] = Class [90] 
.const [92] = Utf8 java/lang/Comparable 
.const [93] = Class [92] 
.const [94] = Utf8 name 
.const [95] = Utf8 Ljava/lang/String; 
.const [96] = Utf8 id 
.const [97] = Utf8 J 
.const [98] = Utf8 memoryId 
.const [99] = Utf8 I 
.const [100] = Utf8 segmentId 
.const [101] = Utf8 Lorg/dsi/ifc/global/NavSegmentID; 
.const [102] = Utf8 Code 
.const [103] = Utf8 <init> 
.const [104] = Utf8 (Ljava/lang/String;JI)V 
.const [105] = Utf8 <init> 
.const [106] = Utf8 (Ljava/lang/String;Lorg/dsi/ifc/global/NavSegmentID;)V 
.const [107] = Utf8 compareTo 
.const [108] = Utf8 (Ljava/lang/Object;)I 
.const [109] = Utf8 hashCode 
.const [110] = Utf8 ()I 
.const [111] = Utf8 equals 
.const [112] = Utf8 (Ljava/lang/Object;)Z 
.end class 
