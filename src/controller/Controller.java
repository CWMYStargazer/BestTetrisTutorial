package controller;

import blocks.Block;
import map.TetrisMap;

public class Controller{
    //定义移动方向：左和右
    public enum moveDir{
        LEFT,RIGHT;
    }
    //定义旋转方向：左旋和右旋
    public enum spinDir{
        LEFT_SPIN,RIGHT_SPIN;
    }

    /**
     * @param b 正在下落的块
     * @param dir 移动方向
     * I块两侧有空白的情况特殊处理
     * 使用说明：
     * */
    private Block move(Block b, moveDir dir){
        Block newBlock= b;
        switch (dir){
            case LEFT:
                if(newBlock.getBlockType().equals("I")){
                    //I在最右往左移时
                    if(newBlock.blockSpin==5){
                        newBlock.blockSpin=1;
                        break;
                    }
                    //I在左3时
                    if(newBlock.blockSpin==1){
                        newBlock.blockSpin=3;
                        break;
                    }
                    //I在左2时
                    if(newBlock.blockSpin==3){
                        if(newBlock.getBlockPosX()-1<0){
                            newBlock.setBlockPos(0, newBlock.getBlockPosY());
                            newBlock.blockSpin=4;
                            break;
                        }
                    }
                }
                newBlock.setBlockPos((newBlock.getBlockPosX()-1>0? newBlock.getBlockPosX()-1: newBlock.getBlockPosX()), newBlock.getBlockPosY());
                break;
            case RIGHT:
                if(newBlock.getBlockType().equals("I")){
                    //I在最左往右移时
                    if(newBlock.blockSpin==4){
                        newBlock.blockSpin=3;
                        break;
                    }
                    //I在右3时
                    if(newBlock.blockSpin==3){
                        newBlock.blockSpin=1;
                        break;
                    }
                    //I在右2时
                    if(newBlock.blockSpin==1){
                        if(newBlock.getBlockPosX()+1>TetrisMap.mapWidth- newBlock.getBlockLength()){
                            newBlock.setBlockPos(TetrisMap.mapWidth-1- newBlock.getBlockLength(), newBlock.getBlockPosY());
                            newBlock.blockSpin=5;
                            break;
                        }
                    }
                }
                newBlock.setBlockPos((newBlock.getBlockPosX()+ newBlock.getBlockLength()+1<TetrisMap.mapWidth? newBlock.getBlockPosX()+1: newBlock.getBlockPosX()), newBlock.getBlockPosY());
                break;
            default:
        }
        //这里进行新块的碰撞检测，如果相撞则不返回新块
        return (Check.collCheck(newBlock,TetrisMap.map)?b:newBlock);
    }
    /**
     * @param b 正在下落的块
     * @param dir 旋转方向，左旋（逆时针）和右旋（顺时针）
     * I块在板边时做特殊踢墙处理
     * */
    private Block spin(Block b,spinDir dir){
        Block newBlock=b;
        switch (dir){
            case LEFT_SPIN:
                if(newBlock.getBlockType().equals("I")){
                    if(newBlock.blockSpin==4){
                        newBlock.blockSpin=0;
                        break;
                    }
                    if(newBlock.blockSpin==5){
                        newBlock.blockSpin=2;
                        break;
                    }
                }
                newBlock.blockSpin=newBlock.blockSpin-1>0?newBlock.blockSpin-1: newBlock.blockSpin-1+4;
                break;
            case RIGHT_SPIN:
                if(newBlock.getBlockType().equals("I")){
                    if(newBlock.blockSpin==4){
                        newBlock.blockSpin=2;
                        break;
                    }
                    if(newBlock.blockSpin==5){
                        newBlock.blockSpin=0;
                        break;
                    }
                }
                newBlock.blockSpin=newBlock.blockSpin+1<4?newBlock.blockSpin+1:newBlock.blockSpin+1-4;
                break;
            default:
        }
        return (Check.collCheck(newBlock,TetrisMap.map)?b:newBlock);
    }
}
