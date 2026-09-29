.version 50 0 
.class public final super [51] 
.super [53] 
.field private final [54] [55] 

.method public static [57] : [58] 
    .attribute [56] .code stack 2 locals 0 
L0:     new [11] 
L3:     dup 
L4:     invokespecial [7] 
L7:     areturn 
L8:     
    .end code 
.end method 

.method public static [59] : [60] 
    .attribute [56] .code stack 3 locals 0 
L0:     aload_0 
L1:     ifnonnull L14 
L4:     new [12] 
L7:     dup 
L8:     ldc [4] 
L10:    invokespecial [8] 
L13:    athrow 
L14:    new [11] 
L17:    dup 
L18:    aload_0 
L19:    invokespecial [9] 
L22:    areturn 
L23:    nop 
L24:    
    .end code 
.end method 

.method private [61] : [62] 
    .attribute [56] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [10] 
L4:     aload_0 
L5:     aconst_null 
L6:     putfield [13] 
L9:     return 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method private [63] : [64] 
    .attribute [56] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [10] 
L4:     aload_0 
L5:     aload_1 
L6:     putfield [13] 
L9:     return 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [65] : [66] 
    .attribute [56] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [6] 
L4:     ifnull L11 
L7:     iconst_1 
L8:     goto L12 
L11:    iconst_0 
L12:    areturn 
L13:    nop 
L14:    nop 
L15:    nop 
L16:    
    .end code 
.end method 

.method public interface [67] : [68] 
    .attribute [56] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [6] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [14] 
.const [3] = Class [15] 
.const [4] = String [16] 
.const [5] = Class [17] 
.const [6] = Field [18] [19] 
.const [7] = Method [20] [21] 
.const [8] = Method [22] [23] 
.const [9] = Method [24] [25] 
.const [10] = Method [26] [27] 
.const [11] = Class [28] 
.const [12] = Class [29] 
.const [13] = Field [30] [31] 
.const [14] = Utf8 de/audi/app/bap/fw/functiontypes/OptionalSerializer 
.const [15] = Utf8 java/lang/IllegalArgumentException 
.const [16] = Utf8 'OptionalSerializer#withValue called with null !' 
.const [17] = Utf8 java/lang/Object 
.const [18] = Class [32] 
.const [19] = NameAndType [33] [34] 
.const [20] = Class [35] 
.const [21] = NameAndType [36] [37] 
.const [22] = Class [38] 
.const [23] = NameAndType [39] [40] 
.const [24] = Class [41] 
.const [25] = NameAndType [42] [43] 
.const [26] = Class [44] 
.const [27] = NameAndType [45] [46] 
.const [28] = Utf8 de/audi/app/bap/fw/functiontypes/OptionalSerializer 
.const [29] = Utf8 java/lang/IllegalArgumentException 
.const [30] = Class [47] 
.const [31] = NameAndType [48] [49] 
.const [32] = Utf8 de/audi/app/bap/fw/functiontypes/OptionalSerializer 
.const [33] = Utf8 value 
.const [34] = Utf8 Lde/vw/mib/bap/datatypes/BAPDataType; 
.const [35] = Utf8 de/audi/app/bap/fw/functiontypes/OptionalSerializer 
.const [36] = Utf8 <init> 
.const [37] = Utf8 ()V 
.const [38] = Utf8 java/lang/IllegalArgumentException 
.const [39] = Utf8 <init> 
.const [40] = Utf8 (Ljava/lang/String;)V 
.const [41] = Utf8 de/audi/app/bap/fw/functiontypes/OptionalSerializer 
.const [42] = Utf8 <init> 
.const [43] = Utf8 (Lde/vw/mib/bap/datatypes/BAPDataType;)V 
.const [44] = Utf8 java/lang/Object 
.const [45] = Utf8 <init> 
.const [46] = Utf8 ()V 
.const [47] = Utf8 de/audi/app/bap/fw/functiontypes/OptionalSerializer 
.const [48] = Utf8 value 
.const [49] = Utf8 Lde/vw/mib/bap/datatypes/BAPDataType; 
.const [50] = Utf8 de/audi/app/bap/fw/functiontypes/OptionalSerializer 
.const [51] = Class [50] 
.const [52] = Utf8 java/lang/Object 
.const [53] = Class [52] 
.const [54] = Utf8 value 
.const [55] = Utf8 Lde/vw/mib/bap/datatypes/BAPDataType; 
.const [56] = Utf8 Code 
.const [57] = Utf8 withoutValue 
.const [58] = Utf8 ()Lde/audi/app/bap/fw/functiontypes/OptionalSerializer; 
.const [59] = Utf8 withValue 
.const [60] = Utf8 (Lde/vw/mib/bap/datatypes/BAPDataType;)Lde/audi/app/bap/fw/functiontypes/OptionalSerializer; 
.const [61] = Utf8 <init> 
.const [62] = Utf8 ()V 
.const [63] = Utf8 <init> 
.const [64] = Utf8 (Lde/vw/mib/bap/datatypes/BAPDataType;)V 
.const [65] = Utf8 hasValue 
.const [66] = Utf8 ()Z 
.const [67] = Utf8 getValue 
.const [68] = Utf8 ()Lde/vw/mib/bap/datatypes/BAPDataType; 
.end class 
