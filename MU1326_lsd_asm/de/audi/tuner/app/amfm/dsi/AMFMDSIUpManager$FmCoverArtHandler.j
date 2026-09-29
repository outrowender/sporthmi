.version 50 0 
.class super [85] 
.super [87] 
.field private final [88] [89] 
.field private final synthetic [90] [91] 

.method public [93] : [94] 
    .attribute [92] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     putfield [17] 
L5:     aload_0 
L6:     aload_2 
L7:     invokespecial [14] 
L10:    aload_0 
L11:    aload_2 
L12:    invokevirtual [11] 
L15:    putfield [18] 
L18:    return 
L19:    nop 
L20:    
    .end code 
.end method 

.method public [95] : [96] 
    .attribute [92] .code stack 4 locals 1 
L0:     aload_0 
L1:     getfield [12] 
L4:     invokevirtual [13] 
L7:     istore 4 
L9:     iload 4 
L11:    iconst_1 
L12:    if_icmpeq L21 
L15:    iload 4 
L17:    iconst_4 
L18:    if_icmpne L28 
L21:    aload_0 
L22:    aload_1 
L23:    aload_2 
L24:    aload_3 
L25:    invokespecial [15] 
L28:    return 
L29:    nop 
L30:    nop 
L31:    nop 
L32:    
    .end code 
.end method 

.method public [97] : [98] 
    .attribute [92] .code stack 3 locals 2 
L0:     aload_0 
L1:     getfield [10] 
L4:     invokestatic [2] 
L7:     dup 
L8:     astore_3 
L9:     monitorenter 
        .catch [0] from L10 to L38 using L39 
L10:    aload_0 
L11:    iload_1 
L12:    aload_2 
L13:    invokespecial [16] 
L16:    ifeq L35 
L19:    aload_0 
L20:    getfield [10] 
L23:    iconst_1 
L24:    invokestatic [3] 
L27:    pop 
L28:    aload_0 
L29:    getfield [10] 
L32:    invokestatic [4] 
L35:    iconst_0 
L36:    aload_3 
L37:    monitorexit 
L38:    areturn 
        .catch [0] from L39 to L43 using L39 
L39:    astore 4 
L41:    aload_3 
L42:    monitorexit 
L43:    aload 4 
L45:    athrow 
L46:    nop 
L47:    nop 
L48:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Method [19] [20] 
.const [3] = Method [21] [22] 
.const [4] = Method [23] [24] 
.const [5] = Class [25] 
.const [6] = Class [26] 
.const [7] = Class [27] 
.const [8] = Class [28] 
.const [9] = Class [29] 
.const [10] = Field [30] [31] 
.const [11] = Method [32] [33] 
.const [12] = Field [34] [35] 
.const [13] = Method [36] [37] 
.const [14] = Method [38] [39] 
.const [15] = Method [40] [41] 
.const [16] = Method [42] [43] 
.const [17] = Field [44] [45] 
.const [18] = Field [46] [47] 
.const [19] = Class [48] 
.const [20] = NameAndType [49] [50] 
.const [21] = Class [51] 
.const [22] = NameAndType [52] [53] 
.const [23] = Class [54] 
.const [24] = NameAndType [55] [56] 
.const [25] = Utf8 de/audi/tuner/app/amfm/dsi/AMFMDSIUpManager$FmCoverArtHandler 
.const [26] = Utf8 de/audi/tuner/app/gracenote/CoverArtHandler 
.const [27] = Utf8 de/audi/tuner/app/TunerBasics 
.const [28] = Utf8 de/audi/tuner/app/TunerModels 
.const [29] = Utf8 de/audi/tuner/app/amfm/dsi/AMFMDSIUpManager 
.const [30] = Class [57] 
.const [31] = NameAndType [58] [59] 
.const [32] = Class [60] 
.const [33] = NameAndType [61] [62] 
.const [34] = Class [63] 
.const [35] = NameAndType [64] [65] 
.const [36] = Class [66] 
.const [37] = NameAndType [67] [68] 
.const [38] = Class [69] 
.const [39] = NameAndType [70] [71] 
.const [40] = Class [72] 
.const [41] = NameAndType [73] [74] 
.const [42] = Class [75] 
.const [43] = NameAndType [76] [77] 
.const [44] = Class [78] 
.const [45] = NameAndType [79] [80] 
.const [46] = Class [81] 
.const [47] = NameAndType [82] [83] 
.const [48] = Utf8 de/audi/tuner/app/amfm/dsi/AMFMDSIUpManager 
.const [49] = Utf8 access$200 
.const [50] = Utf8 (Lde/audi/tuner/app/amfm/dsi/AMFMDSIUpManager;)Ljava/lang/Object; 
.const [51] = Utf8 de/audi/tuner/app/amfm/dsi/AMFMDSIUpManager 
.const [52] = Utf8 access$1602 
.const [53] = Utf8 (Lde/audi/tuner/app/amfm/dsi/AMFMDSIUpManager;Z)Z 
.const [54] = Utf8 de/audi/tuner/app/amfm/dsi/AMFMDSIUpManager 
.const [55] = Utf8 access$1200 
.const [56] = Utf8 (Lde/audi/tuner/app/amfm/dsi/AMFMDSIUpManager;)V 
.const [57] = Utf8 de/audi/tuner/app/amfm/dsi/AMFMDSIUpManager$FmCoverArtHandler 
.const [58] = Utf8 this$0 
.const [59] = Utf8 Lde/audi/tuner/app/amfm/dsi/AMFMDSIUpManager; 
.const [60] = Utf8 de/audi/tuner/app/TunerBasics 
.const [61] = Utf8 getModels 
.const [62] = Utf8 ()Lde/audi/tuner/app/TunerModels; 
.const [63] = Utf8 de/audi/tuner/app/amfm/dsi/AMFMDSIUpManager$FmCoverArtHandler 
.const [64] = Utf8 models 
.const [65] = Utf8 Lde/audi/tuner/app/TunerModels; 
.const [66] = Utf8 de/audi/tuner/app/TunerModels 
.const [67] = Utf8 getActiveTuner 
.const [68] = Utf8 ()I 
.const [69] = Utf8 de/audi/tuner/app/gracenote/CoverArtHandler 
.const [70] = Utf8 <init> 
.const [71] = Utf8 (Lde/audi/tuner/app/TunerBasics;)V 
.const [72] = Utf8 de/audi/tuner/app/gracenote/CoverArtHandler 
.const [73] = Utf8 requestCoverArt 
.const [74] = Utf8 (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V 
.const [75] = Utf8 de/audi/tuner/app/gracenote/CoverArtHandler 
.const [76] = Utf8 setCoverArt 
.const [77] = Utf8 (ILorg/dsi/ifc/global/ResourceLocator;)Z 
.const [78] = Utf8 de/audi/tuner/app/amfm/dsi/AMFMDSIUpManager$FmCoverArtHandler 
.const [79] = Utf8 this$0 
.const [80] = Utf8 Lde/audi/tuner/app/amfm/dsi/AMFMDSIUpManager; 
.const [81] = Utf8 de/audi/tuner/app/amfm/dsi/AMFMDSIUpManager$FmCoverArtHandler 
.const [82] = Utf8 models 
.const [83] = Utf8 Lde/audi/tuner/app/TunerModels; 
.const [84] = Utf8 de/audi/tuner/app/amfm/dsi/AMFMDSIUpManager$FmCoverArtHandler 
.const [85] = Class [84] 
.const [86] = Utf8 de/audi/tuner/app/gracenote/CoverArtHandler 
.const [87] = Class [86] 
.const [88] = Utf8 models 
.const [89] = Utf8 Lde/audi/tuner/app/TunerModels; 
.const [90] = Utf8 this$0 
.const [91] = Utf8 Lde/audi/tuner/app/amfm/dsi/AMFMDSIUpManager; 
.const [92] = Utf8 Code 
.const [93] = Utf8 <init> 
.const [94] = Utf8 (Lde/audi/tuner/app/amfm/dsi/AMFMDSIUpManager;Lde/audi/tuner/app/TunerBasics;)V 
.const [95] = Utf8 requestCoverArt 
.const [96] = Utf8 (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V 
.const [97] = Utf8 setCoverArt 
.const [98] = Utf8 (ILorg/dsi/ifc/global/ResourceLocator;)Z 
.end class 
