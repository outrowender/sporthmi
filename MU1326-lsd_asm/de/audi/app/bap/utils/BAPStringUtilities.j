.version 50 0 
.class public final super [27] 
.super [29] 
.field private static final [30] [31] 

.method public annotation [33] : [34] 
    .attribute [32] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [7] 
L4:     return 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public static [35] : [36] 
    .attribute [32] .code stack 4 locals 1 
L0:     aload_0 
L1:     ifnonnull L7 
L4:     ldc [2] 
L6:     areturn 
        .catch [5] from L7 to L17 using L18 
L7:     new [9] 
L10:    dup 
L11:    aload_0 
L12:    ldc [4] 
L14:    invokespecial [8] 
L17:    areturn 
L18:    astore_1 
L19:    ldc [2] 
L21:    areturn 
L22:    nop 
L23:    nop 
L24:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = String [10] 
.const [3] = Class [11] 
.const [4] = String [12] 
.const [5] = Class [13] 
.const [6] = Class [14] 
.const [7] = Method [15] [16] 
.const [8] = Method [17] [18] 
.const [9] = Class [19] 
.const [10] = Utf8 '' 
.const [11] = Utf8 java/lang/String 
.const [12] = Utf8 ISO8859_1 
.const [13] = Utf8 java/io/UnsupportedEncodingException 
.const [14] = Utf8 java/lang/Object 
.const [15] = Class [20] 
.const [16] = NameAndType [21] [22] 
.const [17] = Class [23] 
.const [18] = NameAndType [24] [25] 
.const [19] = Utf8 java/lang/String 
.const [20] = Utf8 java/lang/Object 
.const [21] = Utf8 <init> 
.const [22] = Utf8 ()V 
.const [23] = Utf8 java/lang/String 
.const [24] = Utf8 <init> 
.const [25] = Utf8 ([BLjava/lang/String;)V 
.const [26] = Utf8 de/audi/app/bap/utils/BAPStringUtilities 
.const [27] = Class [26] 
.const [28] = Utf8 java/lang/Object 
.const [29] = Class [28] 
.const [30] = Utf8 RAW_ENCODING 
.const [31] = Utf8 Ljava/lang/String; 
.const [32] = Utf8 Code 
.const [33] = Utf8 <init> 
.const [34] = Utf8 ()V 
.const [35] = Utf8 convertToRawString 
.const [36] = Utf8 ([B)Ljava/lang/String; 
.end class 
