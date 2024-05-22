package map;

import blocks.*;
import controller.*;

public final class TetrisMap {
    /**
     * 关于map：
     *      map[][0]为缓冲区，不出现在屏幕上，避免生成即死
     * */
    public int[][] map=new int[22][10];
    public static final int mapWidth=10;
    public static final int mapHeight=20;
    private int level;
    private double dropTime;
    private CreateBlock nexts;

    public TetrisMap(){
        setLevel(1);
        setDropTime();
        nexts=new CreateBlock();
    }

    public void setDropTime(){
        dropTime=Math.pow(0.8-((level-1)*0.007),(level-1));
    }
    public void setLevel(int level){
        this.level=level;
    }

    /**
     * 获取掉落块的信息，存入地图中
     * */
    public void setDropBlock(Block b){
        //调用触底检测函数
        //if(Check.groundCheck(b,map)){...}
            for(int y = b.getBlockPosY(); y <b.getBlockHeight()+b.getBlockPosY(); y++){
                for(int x = b.getBlockPosX(); x <b.getBlockLength()+b.getBlockPosX(); x++){
                    //当地图上对应位置为空格时进行存储，块形状为空时不影响
                    if(map[y][x]==0) {
                        map[y][x] = b.getBlockForm()[b.blockSpin][y - b.getBlockPosY()][x - b.getBlockPosX()];
                    }
                }
            }
    }
    public Block showDropBlock(){
        return nexts.getNextBlock();
    }
}