.version 50 0 
.class public super [49] 
.super [51] 
.field [52] [53] 
.field [54] [55] 
.field [56] [57] 

.method public [59] : [60] 
    .attribute [58] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [7] 
L4:     aload_0 
L5:     iconst_0 
L6:     putfield [8] 
L9:     aload_0 
L10:    iconst_0 
L11:    putfield [9] 
L14:    aload_0 
L15:    iconst_0 
L16:    putfield [10] 
L19:    return 
L20:    
    .end code 
.end method 

.method public interface [61] : [62] 
    .attribute [58] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [4] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public interface [63] : [64] 
    .attribute [58] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [5] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public interface [65] : [66] 
    .attribute [58] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [6] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [67] : [68] 
    .attribute [58] .code stack 2 locals 0 
L0:     aload_0 
L1:     iconst_0 
L2:     putfield [8] 
L5:     aload_0 
L6:     iconst_0 
L7:     putfield [9] 
L10:    aload_0 
L11:    iconst_0 
L12:    putfield [10] 
L15:    return 
L16:    
    .end code 
.end method 

.method public [69] : [70] 
    .attribute [58] .code stack 3 locals 0 
L0:     aload_0 
L1:     dup 
L2:     getfield [4] 
L5:     iload_1 
L6:     iadd 
L7:     putfield [8] 
L10:    aload_0 
L11:    dup 
L12:    getfield [5] 
L15:    iload_2 
L16:    iadd 
L17:    putfield [9] 
L20:    iload_3 
L21:    ifne L25 
L24:    return 
L25:    iload_3 
L26:    bipush 6 
L28:    if_icmpne L39 
L31:    aload_0 
L32:    getfield [6] 
L35:    ifeq L39 
L38:    return 
L39:    iload_3 
L40:    iconst_5 
L41:    if_icmpeq L50 
L44:    iload_3 
L45:    bipush 9 
L47:    if_icmpne L67 
L50:    aload_0 
L51:    getfield [6] 
L54:    ifeq L67 
L57:    aload_0 
L58:    getfield [6] 
L61:    bipush 6 
L63:    if_icmpeq L67 
L66:    return 
L67:    iload_3 
L68:    iconst_1 
L69:    if_icmpeq L77 
L72:    iload_3 
L73:    iconst_2 
L74:    if_icmpne L111 
L77:    aload_0 
L78:    getfield [6] 
L81:    ifeq L111 
L84:    aload_0 
L85:    getfield [6] 
L88:    bipush 6 
L90:    if_icmpeq L111 
L93:    aload_0 
L94:    getfield [6] 
L97:    iconst_5 
L98:    if_icmpeq L111 
L101:   aload_0 
L102:   getfield [6] 
L105:   bipush 9 
L107:   if_icmpeq L111 
L110:   return 
L111:   aload_0 
L112:   iload_3 
L113:   putfield [10] 
L116:   return 
L117:   nop 
L118:   nop 
L119:   nop 
L120:   
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [11] 
.const [3] = Class [12] 
.const [4] = Field [13] [14] 
.const [5] = Field [15] [16] 
.const [6] = Field [17] [18] 
.const [7] = Method [19] [20] 
.const [8] = Field [21] [22] 
.const [9] = Field [23] [24] 
.const [10] = Field [25] [26] 
.const [11] = Utf8 de/audi/app/addressbook/core/vcardexchange/VCardImportProgress 
.const [12] = Utf8 java/lang/Object 
.const [13] = Class [27] 
.const [14] = NameAndType [28] [29] 
.const [15] = Class [30] 
.const [16] = NameAndType [31] [32] 
.const [17] = Class [33] 
.const [18] = NameAndType [34] [35] 
.const [19] = Class [36] 
.const [20] = NameAndType [37] [38] 
.const [21] = Class [39] 
.const [22] = NameAndType [40] [41] 
.const [23] = Class [42] 
.const [24] = NameAndType [43] [44] 
.const [25] = Class [45] 
.const [26] = NameAndType [46] [47] 
.const [27] = Utf8 de/audi/app/addressbook/core/vcardexchange/VCardImportProgress 
.const [28] = Utf8 countSuccess 
.const [29] = Utf8 I 
.const [30] = Utf8 de/audi/app/addressbook/core/vcardexchange/VCardImportProgress 
.const [31] = Utf8 countFailure 
.const [32] = Utf8 I 
.const [33] = Utf8 de/audi/app/addressbook/core/vcardexchange/VCardImportProgress 
.const [34] = Utf8 errorReason 
.const [35] = Utf8 I 
.const [36] = Utf8 java/lang/Object 
.const [37] = Utf8 <init> 
.const [38] = Utf8 ()V 
.const [39] = Utf8 de/audi/app/addressbook/core/vcardexchange/VCardImportProgress 
.const [40] = Utf8 countSuccess 
.const [41] = Utf8 I 
.const [42] = Utf8 de/audi/app/addressbook/core/vcardexchange/VCardImportProgress 
.const [43] = Utf8 countFailure 
.const [44] = Utf8 I 
.const [45] = Utf8 de/audi/app/addressbook/core/vcardexchange/VCardImportProgress 
.const [46] = Utf8 errorReason 
.const [47] = Utf8 I 
.const [48] = Utf8 de/audi/app/addressbook/core/vcardexchange/VCardImportProgress 
.const [49] = Class [48] 
.const [50] = Utf8 java/lang/Object 
.const [51] = Class [50] 
.const [52] = Utf8 countSuccess 
.const [53] = Utf8 I 
.const [54] = Utf8 countFailure 
.const [55] = Utf8 I 
.const [56] = Utf8 errorReason 
.const [57] = Utf8 I 
.const [58] = Utf8 Code 
.const [59] = Utf8 <init> 
.const [60] = Utf8 ()V 
.const [61] = Utf8 getCountSuccess 
.const [62] = Utf8 ()I 
.const [63] = Utf8 getCountFailure 
.const [64] = Utf8 ()I 
.const [65] = Utf8 getErrorReason 
.const [66] = Utf8 ()I 
.const [67] = Utf8 reset 
.const [68] = Utf8 ()V 
.const [69] = Utf8 updateImportProgress 
.const [70] = Utf8 (III)V 
.end class 
