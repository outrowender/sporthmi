.version 50 0 
.class super [29] 
.super [31] 

.method annotation [33] : [34] 
    .attribute [32] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [6] 
L4:     return 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method static [35] : [36] 
    .attribute [32] .code stack 2 locals 0 
L0:     iload_0 
L1:     tableswitch 1 
            L71 
            L91 
            L91 
            L68 
            L77 
            L91 
            L80 
            L91 
            L91 
            L74 
            L74 
            L87 
            L83 
            default : L91 

L68:    bipush 17 
L70:    areturn 
L71:    bipush 23 
L73:    areturn 
L74:    bipush 24 
L76:    areturn 
L77:    bipush 25 
L79:    areturn 
L80:    bipush 26 
L82:    areturn 
L83:    sipush 10017 
L86:    areturn 
L87:    sipush 20017 
L90:    areturn 
L91:    new [8] 
L94:    dup 
L95:    invokespecial [7] 
L98:    athrow 
L99:    nop 
L100:   
    .end code 
.end method 

.method static [37] : [38] 
    .attribute [32] .code stack 2 locals 0 
L0:     iload_0 
L1:     lookupswitch 
            17 : L68 
            23 : L70 
            24 : L72 
            25 : L84 
            26 : L86 
            10017 : L89 
            20017 : L92 
            default : L95 

L68:    iconst_4 
L69:    areturn 
L70:    iconst_1 
L71:    areturn 
L72:    invokestatic [3] 
L75:    ifeq L81 
L78:    bipush 10 
L80:    areturn 
L81:    bipush 11 
L83:    areturn 
L84:    iconst_5 
L85:    areturn 
L86:    bipush 7 
L88:    areturn 
L89:    bipush 13 
L91:    areturn 
L92:    bipush 12 
L94:    areturn 
L95:    new [8] 
L98:    dup 
L99:    invokespecial [7] 
L102:   athrow 
L103:   nop 
L104:   
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [9] 
.const [3] = Method [10] [11] 
.const [4] = Class [12] 
.const [5] = Class [13] 
.const [6] = Method [14] [15] 
.const [7] = Method [16] [17] 
.const [8] = Class [18] 
.const [9] = Utf8 java/lang/IllegalArgumentException 
.const [10] = Class [19] 
.const [11] = NameAndType [20] [21] 
.const [12] = Utf8 java/lang/Object 
.const [13] = Utf8 de/audi/tuner/app/Utilities 
.const [14] = Class [22] 
.const [15] = NameAndType [23] [24] 
.const [16] = Class [25] 
.const [17] = NameAndType [26] [27] 
.const [18] = Utf8 java/lang/IllegalArgumentException 
.const [19] = Utf8 de/audi/tuner/app/Utilities 
.const [20] = Utf8 isJapan 
.const [21] = Utf8 ()Z 
.const [22] = Utf8 java/lang/Object 
.const [23] = Utf8 <init> 
.const [24] = Utf8 ()V 
.const [25] = Utf8 java/lang/IllegalArgumentException 
.const [26] = Utf8 <init> 
.const [27] = Utf8 ()V 
.const [28] = Utf8 de/audi/app/tuner/truffles/SearchUtil 
.const [29] = Class [28] 
.const [30] = Utf8 java/lang/Object 
.const [31] = Class [30] 
.const [32] = Utf8 Code 
.const [33] = Utf8 <init> 
.const [34] = Utf8 ()V 
.const [35] = Utf8 getSourceByBand 
.const [36] = Utf8 (I)I 
.const [37] = Utf8 getBandBySource 
.const [38] = Utf8 (I)I 
.end class 
