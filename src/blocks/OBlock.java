package blocks;

public class OBlock extends Block{
    OBlock(){
        super(new int[4][3][3],"O",new int[]{3,0},new int[]{1,2,2,1},new int[]{0,1,1,0});
        blockForm[0]=new int[][]{{0,4,4},
                                 {0,4,4},
                                 {0,0,0}};
        blockForm[1]=new int[][]{{0,0,0},
                                 {0,4,4},
                                 {0,4,4}};
        blockForm[2]=new int[][]{{0,0,0},
                                 {4,4,0},
                                 {4,4,0}};
        blockForm[3]=new int[][]{{4,4,0},
                                 {4,4,0},
                                 {0,0,0}};
    }
}
