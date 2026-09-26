.version 50 0 
.class super [66] 
.super [68] 
.field private [69] [70] 
.field private [71] [72] 
.field private final [73] [74] 

.method [76] : [77] 
    .attribute [75] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [14] 
L4:     aload_0 
L5:     iconst_0 
L6:     putfield [15] 
L9:     aload_0 
L10:    iconst_0 
L11:    putfield [16] 
L14:    aload_0 
L15:    aload_1 
L16:    putfield [17] 
L19:    return 
L20:    
    .end code 
.end method 

.method synchronized [78] : [79] 
    .attribute [75] .code stack 3 locals 0 
L0:     aload_0 
L1:     dup 
L2:     getfield [11] 
L5:     iconst_1 
L6:     iadd 
L7:     putfield [16] 
L10:    return 
L11:    nop 
L12:    
    .end code 
.end method 

.method synchronized [80] : [81] 
    .attribute [75] .code stack 3 locals 0 
L0:     aload_0 
L1:     dup 
L2:     getfield [11] 
L5:     iconst_1 
L6:     isub 
L7:     putfield [16] 
L10:    aload_0 
L11:    getfield [11] 
L14:    ifge L35 
L17:    aload_0 
L18:    iconst_0 
L19:    putfield [16] 
L22:    aload_0 
L23:    getfield [12] 
L26:    sipush 10000 
L29:    ldc [2] 
L31:    invokevirtual [13] 
L34:    pop 
L35:    aload_0 
L36:    getfield [11] 
L39:    aload_0 
L40:    getfield [10] 
L43:    if_icmpge L66 
L46:    aload_0 
L47:    aload_0 
L48:    getfield [11] 
L51:    putfield [15] 
L54:    aload_0 
L55:    getfield [12] 
L58:    ldc [3] 
L60:    ldc [4] 
L62:    invokevirtual [13] 
L65:    pop 
L66:    aload_0 
L67:    getfield [11] 
L70:    ifne L77 
L73:    iconst_1 
L74:    goto L78 
L77:    iconst_0 
L78:    areturn 
L79:    nop 
L80:    
    .end code 
.end method 

.method synchronized [82] : [83] 
    .attribute [75] .code stack 3 locals 0 
L0:     aload_0 
L1:     dup 
L2:     getfield [10] 
L5:     iconst_1 
L6:     iadd 
L7:     putfield [15] 
L10:    aload_0 
L11:    getfield [10] 
L14:    aload_0 
L15:    getfield [11] 
L18:    if_icmple L42 
L21:    aload_0 
L22:    aload_0 
L23:    getfield [11] 
L26:    putfield [15] 
L29:    aload_0 
L30:    getfield [12] 
L33:    sipush 10000 
L36:    ldc [5] 
L38:    invokevirtual [13] 
L41:    pop 
L42:    return 
L43:    nop 
L44:    
    .end code 
.end method 

.method synchronized [84] : [85] 
    .attribute [75] .code stack 3 locals 0 
L0:     aload_0 
L1:     dup 
L2:     getfield [10] 
L5:     iconst_1 
L6:     isub 
L7:     putfield [15] 
L10:    aload_0 
L11:    getfield [10] 
L14:    ifge L35 
L17:    aload_0 
L18:    iconst_0 
L19:    putfield [15] 
L22:    aload_0 
L23:    getfield [12] 
L26:    sipush 10000 
L29:    ldc [6] 
L31:    invokevirtual [13] 
L34:    pop 
L35:    aload_0 
L36:    getfield [10] 
L39:    ifne L46 
L42:    iconst_1 
L43:    goto L47 
L46:    iconst_0 
L47:    areturn 
L48:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = String [18] 
.const [3] = Int -2137614336 
.const [4] = String [19] 
.const [5] = String [20] 
.const [6] = String [21] 
.const [7] = Class [22] 
.const [8] = Class [23] 
.const [9] = Class [24] 
.const [10] = Field [25] [26] 
.const [11] = Field [27] [28] 
.const [12] = Field [29] [30] 
.const [13] = Method [31] [32] 
.const [14] = Method [33] [34] 
.const [15] = Field [35] [36] 
.const [16] = Field [37] [38] 
.const [17] = Field [39] [40] 
.const [18] = Utf8 '[SDISOnOffLineHandler.unregisterStub] tried to unregister a SDIS stub when stub counter was 0!' 
.const [19] = Utf8 '[SDISOnOffLineHandler.unregisterStub] stub counter was lower then user counter. Assuming SDIS crash!' 
.const [20] = Utf8 '[SDISOnOffLineHandler.logonToTV] tried to register a TV user more then SDIS stubs are available. User counter set to registered stub count!' 
.const [21] = Utf8 '[SDISOnOffLineHandler.logoffFromTV] tried to unregister a TV user when user counter was 0!' 
.const [22] = Utf8 de/audi/tv/app/sdis/SDISOnOffLineHandler 
.const [23] = Utf8 java/lang/Object 
.const [24] = Utf8 de/audi/atip/log/LogChannel 
.const [25] = Class [41] 
.const [26] = NameAndType [42] [43] 
.const [27] = Class [44] 
.const [28] = NameAndType [45] [46] 
.const [29] = Class [47] 
.const [30] = NameAndType [48] [49] 
.const [31] = Class [50] 
.const [32] = NameAndType [51] [52] 
.const [33] = Class [53] 
.const [34] = NameAndType [54] [55] 
.const [35] = Class [56] 
.const [36] = NameAndType [57] [58] 
.const [37] = Class [59] 
.const [38] = NameAndType [60] [61] 
.const [39] = Class [62] 
.const [40] = NameAndType [63] [64] 
.const [41] = Utf8 de/audi/tv/app/sdis/SDISOnOffLineHandler 
.const [42] = Utf8 tvUserCounter 
.const [43] = Utf8 I 
.const [44] = Utf8 de/audi/tv/app/sdis/SDISOnOffLineHandler 
.const [45] = Utf8 stubCounter 
.const [46] = Utf8 I 
.const [47] = Utf8 de/audi/tv/app/sdis/SDISOnOffLineHandler 
.const [48] = Utf8 log 
.const [49] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [50] = Utf8 de/audi/atip/log/LogChannel 
.const [51] = Utf8 log 
.const [52] = Utf8 (ILjava/lang/String;)Z 
.const [53] = Utf8 java/lang/Object 
.const [54] = Utf8 <init> 
.const [55] = Utf8 ()V 
.const [56] = Utf8 de/audi/tv/app/sdis/SDISOnOffLineHandler 
.const [57] = Utf8 tvUserCounter 
.const [58] = Utf8 I 
.const [59] = Utf8 de/audi/tv/app/sdis/SDISOnOffLineHandler 
.const [60] = Utf8 stubCounter 
.const [61] = Utf8 I 
.const [62] = Utf8 de/audi/tv/app/sdis/SDISOnOffLineHandler 
.const [63] = Utf8 log 
.const [64] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [65] = Utf8 de/audi/tv/app/sdis/SDISOnOffLineHandler 
.const [66] = Class [65] 
.const [67] = Utf8 java/lang/Object 
.const [68] = Class [67] 
.const [69] = Utf8 tvUserCounter 
.const [70] = Utf8 I 
.const [71] = Utf8 stubCounter 
.const [72] = Utf8 I 
.const [73] = Utf8 log 
.const [74] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [75] = Utf8 Code 
.const [76] = Utf8 <init> 
.const [77] = Utf8 (Lde/audi/atip/log/LogChannel;)V 
.const [78] = Utf8 registerStub 
.const [79] = Utf8 ()V 
.const [80] = Utf8 unregisterStub 
.const [81] = Utf8 ()Z 
.const [82] = Utf8 logonToTV 
.const [83] = Utf8 ()V 
.const [84] = Utf8 logoffFromTV 
.const [85] = Utf8 ()Z 
.end class 
