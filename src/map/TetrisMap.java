package map;

public final class TetrisMap {
    /**
     * 关于map：
     *      map[][0]为缓冲区，不出现在屏幕上，避免生成即死
     * */
    public static final int[][] map=new int[10][22];
    public static final int mapWidth=10;
    public static final int mapHeight=20;
    private int level;
    private double dropTime;

    public void setDropTime(){
        this.dropTime=Math.pow(0.8-((level-1)*0.007),(level-1));
    }
    public void setLevel(int level){
        this.level=level;
    }
}