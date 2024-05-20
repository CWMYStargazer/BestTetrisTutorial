package blocks;

public class JBlock extends Block{
    public JBlock(){
        super(new int[4][3][3],"J",new int[]{4,0},new int[]{1,2,2,2},new int[]{0,0,1,0});
        blockForm[0]=new int[][]{{2,0,0},
                                 {2,2,2},
                                 {0,0,0}};
        blockForm[1]=new int[][]{{0,2,2},
                                 {0,2,0},
                                 {0,2,0}};
        blockForm[2]=new int[][]{{0,0,0},
                                 {2,2,2},
                                 {0,0,2}};
        blockForm[3]=new int[][]{{0,2,0},
                                 {0,2,0},
                                 {2,2,0}};
    }
}
