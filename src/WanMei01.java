
public class WanMei01 {
	static int X = 3;
	static int Y = 3;
	static int[][] baseData = new int[X][Y];
	public static void main(String[] args) {
		
		baseData = new int[][]{{-2,-3,3}, {-5,10,1}, {0,30,-5}};
		int result = addMax(0,0,baseData[0][0]);
		System.out.println(result);
	}
	
	/**
     * 
     * @param i 横向向右移动
     * @param j 纵向向下移动
     * @param sum 当前最优和
     * @return
     */
    private static int addMax(int i, int j,int sum) {
        if(i+1<X && j+1<Y){
            if(baseData[i+1][j] >= baseData[i][j+1]){
                //当前位置，右侧比下方的数大，则向右移步
                i++;
            }else{
                //当前位置，右侧比下方的数小，则向下移步
                j++;
            }
        }else if(i+1==X && j+1<Y){
            //到达最右侧
                j++;
        }else if(i+1<X && j+1==Y){
            //到达最下方
            i++;
        }else{
            //遍历完数组
            return sum;
        }
        sum+=baseData[i][j];
        return addMax(i, j, sum);
    }
}
