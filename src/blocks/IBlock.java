package blocks;

public class IBlock extends Block{
    IBlock(){
        super(new int[6][4][4],"I",new int[]{2,0},new int[]{1,3,2,3,3,3},new int[]{1,0,2,0,0,0});
        blockForm[0]=new int[][]{{0,0,0,0},
                                 {1,1,1,1},
                                 {0,0,0,0},
                                 {0,0,0,0}};
        blockForm[1]=new int[][]{{0,0,1,0},
                                 {0,0,1,0},
                                 {0,0,1,0},
                                 {0,0,1,0}};
        blockForm[2]=new int[][]{{0,0,0,0},
                                 {0,0,0,0},
                                 {1,1,1,1},
                                 {0,0,0,0}};
        blockForm[3]=new int[][]{{0,1,0,0},
                                 {0,1,0,0},
                                 {0,1,0,0},
                                 {0,1,0,0}};
        //仅I块会出现的边缘状态
        blockForm[4]=new int[][]{{1,0,0,0},
                                 {1,0,0,0},
                                 {1,0,0,0},
                                 {1,0,0,0}};
        blockForm[5]=new int[][]{{0,0,0,1},
                                 {0,0,0,1},
                                 {0,0,0,1},
                                 {0,0,0,1}};
    }
}
