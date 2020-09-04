package com.zhifei.array;

import java.io.File;
import java.io.FileWriter;

public class Xishu {
    public static void main(String[] args) throws Exception {
        //创建一个10行10列的二维数组
        int[][] chessArray = new int[10][10];
        chessArray[2][5] = 1;
        chessArray[5][3] = 2;
        chessArray[6][1] = 1;

        for (int[] row : chessArray) {
            for (int val : row) {
                System.out.print(val + "\t");
            }
            System.out.println();
        }
        System.out.println("------------------------------");
//        System.out.println(chessArray[0].length);

        //将二维数组转换成稀疏数组
        int sum = 0;//声明变量存储有效数据（非0元素）
        for (int i = 0; i < chessArray.length; i++) {
            for (int j = 0; j < chessArray[i].length; j++) {
                if(chessArray[i][j] != 0){
                    sum++;
                }
            }
        }

        //创建稀疏数组
        int[][] newArray = new int[sum+1][3];
        newArray[0][0] = chessArray.length;
        newArray[0][1] = chessArray[0].length;
        newArray[0][2] = sum;
        //遍历二维数组，将非0的元素放入到稀疏数组中
        int count = 0;
        for(int i = 0; i < chessArray.length;i++){
            for(int j = 0; j < chessArray[i].length;j++){
                if(chessArray[i][j] != 0) {
                    count++;
                    newArray[count][0] = i;
                    newArray[count][1] = j;
                    newArray[count][2] = chessArray[i][j];
                }
            }
        }

        FileWriter os = new FileWriter(new File("map.data"));

        for (int i = 0; i < newArray.length; i++) {
            for (int j = 0; j < newArray[i].length; j++) {
                os.write(newArray[i][j] + "\t");
                System.out.print(newArray[i][j]);
            }
            os.write("\r\n");
            os.flush();
        }



    }


}
