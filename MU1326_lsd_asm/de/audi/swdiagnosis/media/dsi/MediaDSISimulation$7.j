.version 50 0 
.class super [55] 
.super [57] 
.implements [59] 
.field private final synthetic [60] [61] 

.method [63] : [64] 
    .attribute [62] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     putfield [12] 
L5:     aload_0 
L6:     invokespecial [11] 
L9:     return 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public enum [65] : [66] 
    .attribute [62] .code stack 0 locals 0 
L0:     return 
L1:     nop 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method public enum [67] : [68] 
    .attribute [62] .code stack 0 locals 0 
L0:     return 
L1:     nop 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method public [69] : [70] 
    .attribute [62] .code stack 2 locals 1 
L0:     aload_0 
L1:     getfield [10] 
L4:     invokestatic [2] 
L7:     aload_1 
L8:     invokeinterface [13] 0 
L13:    astore_2 
L14:    aload_2 
L15:    instanceof [3] 
L18:    ifeq L41 
L21:    aload_0 
L22:    getfield [10] 
L25:    aload_2 
L26:    checkcast [3] 
L29:    invokestatic [4] 
L32:    pop 
L33:    aload_0 
L34:    getfield [10] 
L37:    invokestatic [5] 
L40:    areturn 
L41:    aconst_null 
L42:    areturn 
L43:    nop 
L44:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Method [14] [15] 
.const [3] = Class [16] 
.const [4] = Method [17] [18] 
.const [5] = Method [19] [20] 
.const [6] = Class [21] 
.const [7] = Class [22] 
.const [8] = Class [23] 
.const [9] = Class [24] 
.const [10] = Field [25] [26] 
.const [11] = Method [27] [28] 
.const [12] = Field [29] [30] 
.const [13] = InterfaceMethod [31] [32] 
.const [14] = Class [33] 
.const [15] = NameAndType [34] [35] 
.const [16] = Utf8 org/dsi/ifc/media/DSIMediaRecorderListener 
.const [17] = Class [36] 
.const [18] = NameAndType [37] [38] 
.const [19] = Class [39] 
.const [20] = NameAndType [40] [41] 
.const [21] = Utf8 de/audi/swdiagnosis/media/dsi/MediaDSISimulation$7 
.const [22] = Utf8 java/lang/Object 
.const [23] = Utf8 de/audi/swdiagnosis/media/dsi/MediaDSISimulation 
.const [24] = Utf8 de/audi/app/media/osgi/IServiceManager 
.const [25] = Class [42] 
.const [26] = NameAndType [43] [44] 
.const [27] = Class [45] 
.const [28] = NameAndType [46] [47] 
.const [29] = Class [48] 
.const [30] = NameAndType [49] [50] 
.const [31] = Class [51] 
.const [32] = NameAndType [52] [53] 
.const [33] = Utf8 de/audi/swdiagnosis/media/dsi/MediaDSISimulation 
.const [34] = Utf8 access$000 
.const [35] = Utf8 (Lde/audi/swdiagnosis/media/dsi/MediaDSISimulation;)Lde/audi/app/media/osgi/IServiceManager; 
.const [36] = Utf8 de/audi/swdiagnosis/media/dsi/MediaDSISimulation 
.const [37] = Utf8 access$602 
.const [38] = Utf8 (Lde/audi/swdiagnosis/media/dsi/MediaDSISimulation;Lorg/dsi/ifc/media/DSIMediaRecorderListener;)Lorg/dsi/ifc/media/DSIMediaRecorderListener; 
.const [39] = Utf8 de/audi/swdiagnosis/media/dsi/MediaDSISimulation 
.const [40] = Utf8 access$600 
.const [41] = Utf8 (Lde/audi/swdiagnosis/media/dsi/MediaDSISimulation;)Lorg/dsi/ifc/media/DSIMediaRecorderListener; 
.const [42] = Utf8 de/audi/swdiagnosis/media/dsi/MediaDSISimulation$7 
.const [43] = Utf8 this$0 
.const [44] = Utf8 Lde/audi/swdiagnosis/media/dsi/MediaDSISimulation; 
.const [45] = Utf8 java/lang/Object 
.const [46] = Utf8 <init> 
.const [47] = Utf8 ()V 
.const [48] = Utf8 de/audi/swdiagnosis/media/dsi/MediaDSISimulation$7 
.const [49] = Utf8 this$0 
.const [50] = Utf8 Lde/audi/swdiagnosis/media/dsi/MediaDSISimulation; 
.const [51] = Utf8 de/audi/app/media/osgi/IServiceManager 
.const [52] = Utf8 getService 
.const [53] = Utf8 (Lorg/osgi/framework/ServiceReference;)Ljava/lang/Object; 
.const [54] = Utf8 de/audi/swdiagnosis/media/dsi/MediaDSISimulation$7 
.const [55] = Class [54] 
.const [56] = Utf8 java/lang/Object 
.const [57] = Class [56] 
.const [58] = Utf8 org/osgi/util/tracker/ServiceTrackerCustomizer 
.const [59] = Class [58] 
.const [60] = Utf8 this$0 
.const [61] = Utf8 Lde/audi/swdiagnosis/media/dsi/MediaDSISimulation; 
.const [62] = Utf8 Code 
.const [63] = Utf8 <init> 
.const [64] = Utf8 (Lde/audi/swdiagnosis/media/dsi/MediaDSISimulation;)V 
.const [65] = Utf8 removedService 
.const [66] = Utf8 (Lorg/osgi/framework/ServiceReference;Ljava/lang/Object;)V 
.const [67] = Utf8 modifiedService 
.const [68] = Utf8 (Lorg/osgi/framework/ServiceReference;Ljava/lang/Object;)V 
.const [69] = Utf8 addingService 
.const [70] = Utf8 (Lorg/osgi/framework/ServiceReference;)Ljava/lang/Object; 
.end class 
