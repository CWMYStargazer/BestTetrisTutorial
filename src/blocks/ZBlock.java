package blocks;

public class ZBlock extends Block{
    public ZBlock(){
        super(new int[4][3][3],"Z",new int[]{4,0},new int[]{1,2,2,2},new int[]{0,0,1,0});
        blockForm[0]=new int[][]{{6,6,0},
                                 {0,6,6},
                                 {0,0,0}};
        blockForm[1]=new int[][]{{0,0,6},
                                 {0,6,6},
                                 {0,6,0}};
        blockForm[2]=new int[][]{{0,0,0},
                                 {6,6,0},
                                 {0,6,6}};
        blockForm[3]=new int[][]{{0,6,0},
                                 {6,6,0},
                                 {6,0,0}};
    }
}
