.version 50 0 
.class public super [57] 
.super [59] 

.method public annotation [61] : [62] 
    .attribute [60] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [12] 
L4:     return 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public static [63] : [64] 
    .attribute [60] .code stack 2 locals 0 
L0:     aload_0 
L1:     ifnonnull L9 
L4:     ldc [2] 
L6:     goto L13 
L9:     aload_0 
L10:    invokevirtual [7] 
L13:    astore_0 
L14:    aload_1 
L15:    ifnonnull L23 
L18:    ldc [2] 
L20:    goto L27 
L23:    aload_1 
L24:    invokevirtual [7] 
L27:    astore_1 
L28:    aload_0 
L29:    invokevirtual [8] 
L32:    ifne L37 
L35:    aload_1 
L36:    areturn 
L37:    aload_1 
L38:    invokevirtual [8] 
L41:    ifne L46 
L44:    aload_0 
L45:    areturn 
L46:    new [14] 
L49:    dup 
L50:    invokespecial [13] 
L53:    aload_0 
L54:    invokevirtual [9] 
L57:    ldc [4] 
L59:    invokevirtual [9] 
L62:    aload_1 
L63:    invokevirtual [9] 
L66:    invokevirtual [10] 
L69:    areturn 
L70:    nop 
L71:    nop 
L72:    
    .end code 
.end method 

.method public static [65] : [66] 
    .attribute [60] .code stack 2 locals 0 
L0:     aload_0 
L1:     ifnonnull L6 
L4:     iload_1 
L5:     areturn 
L6:     aload_0 
L7:     invokevirtual [11] 
L10:    iconst_5 
L11:    irem 
L12:    iconst_1 
L13:    iadd 
L14:    areturn 
L15:    nop 
L16:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = String [15] 
.const [3] = Class [16] 
.const [4] = String [17] 
.const [5] = Class [18] 
.const [6] = Class [19] 
.const [7] = Method [20] [21] 
.const [8] = Method [22] [23] 
.const [9] = Method [24] [25] 
.const [10] = Method [26] [27] 
.const [11] = Method [28] [29] 
.const [12] = Method [30] [31] 
.const [13] = Method [32] [33] 
.const [14] = Class [34] 
.const [15] = Utf8 '' 
.const [16] = Utf8 java/lang/StringBuffer 
.const [17] = Utf8 ' - ' 
.const [18] = Utf8 java/lang/Object 
.const [19] = Utf8 java/lang/String 
.const [20] = Class [35] 
.const [21] = NameAndType [36] [37] 
.const [22] = Class [38] 
.const [23] = NameAndType [39] [40] 
.const [24] = Class [41] 
.const [25] = NameAndType [42] [43] 
.const [26] = Class [44] 
.const [27] = NameAndType [45] [46] 
.const [28] = Class [47] 
.const [29] = NameAndType [48] [49] 
.const [30] = Class [50] 
.const [31] = NameAndType [51] [52] 
.const [32] = Class [53] 
.const [33] = NameAndType [54] [55] 
.const [34] = Utf8 java/lang/StringBuffer 
.const [35] = Utf8 java/lang/String 
.const [36] = Utf8 trim 
.const [37] = Utf8 ()Ljava/lang/String; 
.const [38] = Utf8 java/lang/String 
.const [39] = Utf8 length 
.const [40] = Utf8 ()I 
.const [41] = Utf8 java/lang/StringBuffer 
.const [42] = Utf8 append 
.const [43] = Utf8 (Ljava/lang/String;)Ljava/lang/StringBuffer; 
.const [44] = Utf8 java/lang/StringBuffer 
.const [45] = Utf8 toString 
.const [46] = Utf8 ()Ljava/lang/String; 
.const [47] = Utf8 java/lang/String 
.const [48] = Utf8 hashCode 
.const [49] = Utf8 ()I 
.const [50] = Utf8 java/lang/Object 
.const [51] = Utf8 <init> 
.const [52] = Utf8 ()V 
.const [53] = Utf8 java/lang/StringBuffer 
.const [54] = Utf8 <init> 
.const [55] = Utf8 ()V 
.const [56] = Utf8 de/audi/remotehmi/media/MediaUtilities 
.const [57] = Class [56] 
.const [58] = Utf8 java/lang/Object 
.const [59] = Class [58] 
.const [60] = Utf8 Code 
.const [61] = Utf8 <init> 
.const [62] = Utf8 ()V 
.const [63] = Utf8 concatenateArtistAndAlbum 
.const [64] = Utf8 (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String; 
.const [65] = Utf8 calculateIdFromAlbum 
.const [66] = Utf8 (Ljava/lang/String;I)I 
.end class 
