package blocks;

public class TBlock extends Block{
    TBlock(){
        super(new int[4][3][3],"T",new int[]{4,0},new int[]{1,2,2,2},new int[]{0,0,1,0});
        blockForm[0]=new int[][]{{0,7,0},
                                 {7,7,7},
                                 {0,0,0}};
        blockForm[1]=new int[][]{{0,7,0},
                                 {0,7,7},
                                 {0,7,0}};
        blockForm[2]=new int[][]{{0,0,0},
                                 {7,7,7},
                                 {0,7,0}};
        blockForm[3]=new int[][]{{0,7,0},
                                 {7,7,0},
                                 {0,7,0}};
    }
}
