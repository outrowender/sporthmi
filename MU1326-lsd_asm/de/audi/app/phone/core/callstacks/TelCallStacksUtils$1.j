.version 50 0 
.class final super [43] 
.super [45] 
.implements [47] 
.field private static final [48] [49] 
.field private static final [50] [51] 
.field private static final [52] [53] 
.field private static final [54] [55] 

.method annotation [57] : [58] 
    .attribute [56] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [10] 
L4:     return 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [59] : [60] 
    .attribute [56] .code stack 4 locals 7 
L0:     aload_1 
L1:     checkcast [2] 
L4:     astore_3 
L5:     aload_2 
L6:     checkcast [2] 
L9:     astore 4 
L11:    aload_0 
L12:    aload_3 
L13:    invokespecial [11] 
L16:    lstore 5 
L18:    aload_0 
L19:    aload 4 
L21:    invokespecial [11] 
L24:    lstore 7 
L26:    iconst_0 
L27:    istore 9 
L29:    lload 5 
L31:    lload 7 
L33:    lcmp 
L34:    ifne L43 
L37:    iconst_0 
L38:    istore 9 
L40:    goto L84 
L43:    lload 7 
L45:    lconst_0 
L46:    lcmp 
L47:    ifne L56 
L50:    iconst_m1 
L51:    istore 9 
L53:    goto L84 
L56:    lload 5 
L58:    lconst_0 
L59:    lcmp 
L60:    ifne L69 
L63:    iconst_1 
L64:    istore 9 
L66:    goto L84 
L69:    lload 5 
L71:    lload 7 
L73:    lcmp 
L74:    ifle L81 
L77:    iconst_m1 
L78:    goto L82 
L81:    iconst_1 
L82:    istore 9 
L84:    iload 9 
L86:    areturn 
L87:    nop 
L88:    
    .end code 
.end method 

.method private [61] : [62] 
    .attribute [56] .code stack 2 locals 0 
L0:     aload_1 
L1:     invokestatic [3] 
L4:     ifne L9 
L7:     lconst_0 
L8:     freturn 
L9:     aload_1 
L10:    invokestatic [4] 
L13:    invokevirtual [9] 
L16:    freturn 
L17:    nop 
L18:    nop 
L19:    nop 
L20:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [12] 
.const [3] = Method [13] [14] 
.const [4] = Method [15] [16] 
.const [5] = Class [17] 
.const [6] = Class [18] 
.const [7] = Class [19] 
.const [8] = Class [20] 
.const [9] = Method [21] [22] 
.const [10] = Method [23] [24] 
.const [11] = Method [25] [26] 
.const [12] = Utf8 org/dsi/ifc/telephoneng/CallStackEntry 
.const [13] = Class [27] 
.const [14] = NameAndType [28] [29] 
.const [15] = Class [30] 
.const [16] = NameAndType [31] [32] 
.const [17] = Utf8 de/audi/app/phone/core/callstacks/TelCallStacksUtils$1 
.const [18] = Utf8 java/lang/Object 
.const [19] = Utf8 de/audi/app/phone/core/callstacks/TelCallStacksUtils 
.const [20] = Utf8 java/util/Date 
.const [21] = Class [33] 
.const [22] = NameAndType [34] [35] 
.const [23] = Class [36] 
.const [24] = NameAndType [37] [38] 
.const [25] = Class [39] 
.const [26] = NameAndType [40] [41] 
.const [27] = Utf8 de/audi/app/phone/core/callstacks/TelCallStacksUtils 
.const [28] = Utf8 hasValidTimestamp 
.const [29] = Utf8 (Lorg/dsi/ifc/telephoneng/CallStackEntry;)Z 
.const [30] = Utf8 de/audi/app/phone/core/callstacks/TelCallStacksUtils 
.const [31] = Utf8 getDate 
.const [32] = Utf8 (Lorg/dsi/ifc/telephoneng/CallStackEntry;)Ljava/util/Date; 
.const [33] = Utf8 java/util/Date 
.const [34] = Utf8 getTime 
.const [35] = Utf8 ()J 
.const [36] = Utf8 java/lang/Object 
.const [37] = Utf8 <init> 
.const [38] = Utf8 ()V 
.const [39] = Utf8 de/audi/app/phone/core/callstacks/TelCallStacksUtils$1 
.const [40] = Utf8 getTimestamp 
.const [41] = Utf8 (Lorg/dsi/ifc/telephoneng/CallStackEntry;)J 
.const [42] = Utf8 de/audi/app/phone/core/callstacks/TelCallStacksUtils$1 
.const [43] = Class [42] 
.const [44] = Utf8 java/lang/Object 
.const [45] = Class [44] 
.const [46] = Utf8 java/util/Comparator 
.const [47] = Class [46] 
.const [48] = Utf8 NO_TIMESTAMP_AVAILABLE 
.const [49] = Utf8 I 
.const [50] = Utf8 SORT_GREATER 
.const [51] = Utf8 I 
.const [52] = Utf8 SORT_LESS 
.const [53] = Utf8 I 
.const [54] = Utf8 SORT_EQUAL 
.const [55] = Utf8 I 
.const [56] = Utf8 Code 
.const [57] = Utf8 <init> 
.const [58] = Utf8 ()V 
.const [59] = Utf8 compare 
.const [60] = Utf8 (Ljava/lang/Object;Ljava/lang/Object;)I 
.const [61] = Utf8 getTimestamp 
.const [62] = Utf8 (Lorg/dsi/ifc/telephoneng/CallStackEntry;)J 
.end class 
