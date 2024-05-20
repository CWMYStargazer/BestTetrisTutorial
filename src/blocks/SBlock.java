package blocks;

public class SBlock extends Block{
    public SBlock(){
        super(new int[4][3][3],"S",new int[]{4,0},new int[]{1,2,2,2},new int[]{0,0,1,0});
        blockForm[0]=new int[][]{{0,5,5},
                                 {5,5,0},
                                 {0,0,0}};
        blockForm[1]=new int[][]{{0,5,0},
                                 {0,5,5},
                                 {0,0,5}};
        blockForm[2]=new int[][]{{0,0,0},
                                 {0,5,5},
                                 {5,5,0}};
        blockForm[3]=new int[][]{{5,0,0},
                                 {5,5,0},
                                 {0,5,0}};
    }
}
