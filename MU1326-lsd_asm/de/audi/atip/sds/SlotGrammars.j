.version 50 0 
.class public super [15] 
.super [17] 
.field public static final [18] [19] 
.field public static final [20] [21] 
.field public static final [22] [23] 
.field public static final [24] [25] 
.field public static final [26] [27] 

.method public annotation [29] : [30] 
    .attribute [28] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [7] 
L4:     return 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public static [31] : [32] 
    .attribute [28] .code stack 1 locals 0 
L0:     iload_0 
L1:     lookupswitch 
            200026 : L48 
            200028 : L44 
            200030 : L46 
            700000 : L50 
            default : L52 

L44:    iconst_0 
L45:    areturn 
L46:    iconst_1 
L47:    areturn 
L48:    iconst_2 
L49:    areturn 
L50:    iconst_3 
L51:    areturn 
L52:    iconst_m1 
L53:    areturn 
L54:    nop 
L55:    nop 
L56:    
    .end code 
.end method 

.method public static final [33] : [34] 
    .attribute [28] .code stack 4 locals 0 
L0:     iload_0 
L1:     tableswitch 0 
            L32 
            L41 
            L50 
            L59 
            default : L68 

L32:    iconst_1 
L33:    newarray int 
L35:    dup 
L36:    iconst_0 
L37:    ldc [2] 
L39:    iastore 
L40:    areturn 
L41:    iconst_1 
L42:    newarray int 
L44:    dup 
L45:    iconst_0 
L46:    ldc [3] 
L48:    iastore 
L49:    areturn 
L50:    iconst_1 
L51:    newarray int 
L53:    dup 
L54:    iconst_0 
L55:    ldc [4] 
L57:    iastore 
L58:    areturn 
L59:    iconst_1 
L60:    newarray int 
L62:    dup 
L63:    iconst_0 
L64:    ldc [5] 
L66:    iastore 
L67:    areturn 
L68:    iconst_0 
L69:    newarray int 
L71:    areturn 
L72:    
    .end code 
.end method 

.method public static final [35] : [36] 
    .attribute [28] .code stack 4 locals 0 
L0:     iconst_4 
L1:     newarray int 
L3:     dup 
L4:     iconst_0 
L5:     iconst_0 
L6:     iastore 
L7:     dup 
L8:     iconst_1 
L9:     iconst_1 
L10:    iastore 
L11:    dup 
L12:    iconst_2 
L13:    iconst_2 
L14:    iastore 
L15:    dup 
L16:    iconst_3 
L17:    iconst_3 
L18:    iastore 
L19:    areturn 
L20:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Int 1544356608 
.const [3] = Int 1577911040 
.const [4] = Int 1510802176 
.const [5] = Int 1622018560 
.const [6] = Class [8] 
.const [7] = Method [9] [10] 
.const [8] = Utf8 java/lang/Object 
.const [9] = Class [11] 
.const [10] = NameAndType [12] [13] 
.const [11] = Utf8 java/lang/Object 
.const [12] = Utf8 <init> 
.const [13] = Utf8 ()V 
.const [14] = Utf8 de/audi/atip/sds/SlotGrammars 
.const [15] = Class [14] 
.const [16] = Utf8 java/lang/Object 
.const [17] = Class [16] 
.const [18] = Utf8 SG_TYPE_NONE 
.const [19] = Utf8 I 
.const [20] = Utf8 SG_TYPE_TITLE 
.const [21] = Utf8 I 
.const [22] = Utf8 SG_TYPE_ALBUM 
.const [23] = Utf8 I 
.const [24] = Utf8 SG_TYPE_ARTIST 
.const [25] = Utf8 I 
.const [26] = Utf8 SG_TYPE_CONTACTCARD 
.const [27] = Utf8 I 
.const [28] = Utf8 Code 
.const [29] = Utf8 <init> 
.const [30] = Utf8 ()V 
.const [31] = Utf8 getSlotTypeForSlot 
.const [32] = Utf8 (I)I 
.const [33] = Utf8 getSlotsForType 
.const [34] = Utf8 (I)[I 
.const [35] = Utf8 getSlotTypes 
.const [36] = Utf8 ()[I 
.end class 
