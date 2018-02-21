package com.builder;

public class NVidiaAdapter implements DisplayAdapter {

    //required fields
    private final int bufferWidth;
    private final int bufferHeight;
    private final int bitDepth;

    //optional
    private final String chainBehavior;
    private final boolean disableOcclusion;

    public static class AdapterBuilder {
        //require values
        private final int bufferWidth;
        private final int bufferHeight;
        private final int bitDepth;

        public AdapterBuilder(int bufferWidth, int bufferHeight, int bitDepth){
            this.bufferWidth = bufferWidth;
            this.bufferHeight = bufferHeight;
            this.bitDepth = bitDepth;
        }

        public AdapterBuilder chainBehavior(String chainBehavior){
            this.chainBehavior = chainBehavior;
            return this;
        }

        public AdapterBuilder disableOcclusion(boolean disable){
            this.disableOcclusion = disable;
            return this;
        }

        public NVidiaAdapter build(){
            return new NVidiaAdapter(this);
        }
    }

    private NVidiaAdapter(AdapterBuilder builder){
        bufferWidth = builder.bufferWidth;
        bufferHeight = builder.bufferHeight;
        bitDepth = builder.bitDepth;
        disableOcclusion = builder.disableOcclusion;
        chainBehavior = builder.chainBehavior;
    }

    public int getBufferWidth(){
        return bufferWidth;
    }
}
