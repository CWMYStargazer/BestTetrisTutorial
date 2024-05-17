package blocks;

public abstract class Block {
    /**
     * blockTypeNum:I-1,J-2,L-3,O-4,S-5,Z-6,T-7,空格-0
     * @param blockForm 块的形状
     * @param blockType 块的名称
     * @param blockPos  块的位置
     * @param blockSpin 块的当前旋转状态，blockForm[blockSpin][blockTypeNum][BlockTypeNum]
     * @param blockBott 块的实际底部在存储形状中的位置，序号与块的形状序号匹配
     * @param blockTop  快的实际顶部在存储形状中的位置，序号与块的形状序号匹配
     * */
    //一个矩阵存储形状，第一个4标记旋转状态(0,90,180,270)
    //除了l块为4*4，其余均为3*3，解决边缘碰撞问题
    protected int[][][] blockForm;
    protected String blockType;
    protected int[] blockPos;
    public int blockSpin=0;
    protected int[] blockBott;
    protected int[] blockTop;

    protected Block(){}
    protected Block(int[][][] blockForm,String blockType,int[] blockPos,int[] blockBott,int[] blockTop){
        this.blockForm=blockForm;
        this.blockType=blockType;
        this.blockPos=blockPos;
        this.blockBott=blockBott;
        this.blockTop=blockTop;
    }

    public int getBlockPosX(){
        return blockPos[0];
    }
    public int getBlockPosY(){
        return blockPos[1];
    }
    public void setBlockPos(int posX,int posY){
        blockPos[0]=posX;
        blockPos[1]=posY;
    }
    public String getBlockType(){
        return blockType;
    }
    public int getBlockLength(){
        return blockForm.length;
    }
    public int getBlockHeight(){
        return blockForm[0].length;
    }
    public int[][][] getBlockForm(){
        return blockForm;
    }
    public int getBlockBott(){
        return blockBott[blockSpin];
    }
    public int getBlockTop(){
        return blockTop[blockSpin];
    }
}
