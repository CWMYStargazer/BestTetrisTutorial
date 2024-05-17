package blocks;

public class LBlock extends Block{
    LBlock(){
        super(new int[4][3][3],"L",new int[]{4,0},new int[]{1,2,2,2},new int[]{0,0,1,0});
        blockForm[0]=new int[][]{{0,0,3},
                                 {3,3,3},
                                 {0,0,0}};
        blockForm[1]=new int[][]{{0,3,0},
                                 {0,3,0},
                                 {0,3,3}};
        blockForm[2]=new int[][]{{0,0,0},
                                 {3,3,3},
                                 {3,0,0}};
        blockForm[3]=new int[][]{{3,3,0},
                                 {0,3,0},
                                 {0,3,0}};
    }
}
