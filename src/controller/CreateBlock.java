package controller;

import blocks.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class CreateBlock {
    /**
     * 用于生成下落块
     * @param nextBlock 按包生成块，一次性生成2个包，当第一包全部吐出后后包前置，生成下个包
     * @param nextBlockNum 下落块组块序下标
     * */
    private static ArrayList<Block> nextBlock=new ArrayList<>();
    private int nextBlockNum;

    public CreateBlock(){
        //初始化块序下标
        nextBlockNum=0;
        //循环创建两个包
        for(int i=0;i<2;i++){
            createBlockPack();
        }
    }

    /**
     * 获取一个块，当第一包块全部获取完，调用创建一个新的包
     * @return 下一个块
     * */
    public Block getNextBlock(){
        Block next=nextBlock.get(nextBlockNum);
        nextBlock.remove(nextBlockNum);
        nextBlockNum+=1;
        //第一包全部吐出，创建新的一个包
        if(nextBlockNum>=7){
            nextBlockNum=0;
            createBlockPack();
        }
        return next;
    }

    /**
     * 创建一包随机块
     * */
    private void createBlockPack(){
        //使用shuffle算法
        ArrayList<Integer> arr =new ArrayList<>();
        ArrayList<Integer> nextPack=new ArrayList<>();
        for(int i=1;i<8;i++){
            arr.add(i);
        }
        //随机生成块序存储到nextPack中
        while(!arr.isEmpty()){
            int index=new Random().nextInt(arr.size());
            int num= arr.get(index);
            nextPack.add(num);
            arr.remove(index);
        }
        //读块序，存块
        Iterator<Integer> s = nextPack.iterator();
        while (s.hasNext()) {
            int num = s.next();
            switch (num) {
                case 1:
                    nextBlock.add(new IBlock());
                    break;
                case 2:
                    nextBlock.add(new JBlock());
                    break;
                case 3:
                    nextBlock.add(new LBlock());
                    break;
                case 4:
                    nextBlock.add(new OBlock());
                    break;
                case 5:
                    nextBlock.add(new SBlock());
                    break;
                case 6:
                    nextBlock.add(new ZBlock());
                    break;
                case 7:
                    nextBlock.add(new TBlock());
                    break;
            }
        }
        nextPack.clear();
    }
}
