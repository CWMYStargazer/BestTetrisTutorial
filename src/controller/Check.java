package controller;

import blocks.Block;
import map.TetrisMap;

public class Check {
    /**
     * @param b 要检测碰撞的块，指执行移动/旋转后的新块
     * @param map 地图
     * 检测条件：移动方向碰到别的块
     * 触底条件：实际有块区域碰到别的块或碰到底边
     * */
    //旋转、移动的碰撞检测
    public static boolean collCheck(Block b, int[][] map){
        for(int row = 0; row <b.getBlockHeight(); row++){
            for(int line=0;line<b.getBlockLength();line++){
                //存储块的这个位置有块，且地图上的对应位置有块
                //map版从1开始编号，0为缓冲区
                if(b.getBlockForm()[b.blockSpin][row][line]>0&&map[row+b.getBlockPosY()+1][line]>0){
                    return true;
                }
            }
        }
        return false;
    }
    //触底的碰撞检测
    public static boolean groundCheck(Block b,int[][] map){
        //现在的块底在map里的y，map版从1开始编号
        int bottom=b.getBlockBott()+b.getBlockPosY()+1;
        //从有实际块的块底倒着查到块顶
        for(int row=bottom;row>b.getBlockPosY()+b.getBlockTop();row--) {
            for (int line = 0; line < b.getBlockLength(); line++) {
                //从触底这一行往上检测有没有重叠的，触版底为下一行超过高度标号
                if (map[line + 1][bottom] > 0 || map[line + 1][bottom] > TetrisMap.mapHeight) {
                    return true;
                }
            }
        }
        return false;
    }
}
