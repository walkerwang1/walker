package com.datastructure.graph.floyd;

import com.walkerwang.algorithm.bigcompany.safe360_01;

public class MatrixUDG {
	
	private int mEdgNum;	//边的数量
	private char[] mVexs;	//顶点集合
	private int[][] mMatrix;	//邻接矩阵
	private static final int INF = Integer.MAX_VALUE;	//最大值

	
	/*
	 * 创建图（用已提供的矩阵）
	 * 
	 * 参数说明：
	 * 		vexs：顶点数组
	 * 		matrix：矩阵（数据）
	 */
	public MatrixUDG(char[] vexs, int[][] matrix) {
		
		//初始化"顶点数"和"边树"
		int vlen = vexs.length;
		
		//初始化"顶点"
		mVexs = new char[vlen];
		for (int i = 0; i < mVexs.length; i++) 
			mVexs[i] = vexs[i];
		
		//初始化"边"
		mMatrix = new int[vlen][vlen];
		for(int i = 0; i < vlen; i++) {
			for(int j = 0; j < vlen; j++) 
				mMatrix[i][j] = matrix[i][j];
		}
		
		//统计"边"
		mEdgNum = 0;
		for(int i = 0; i < vlen; i++) 
			for (int j = i+1; j < vlen; j++) 
				if (mMatrix[i][j] != INF) 
					mEdgNum++;
	}
	
	/*
	 * 返回 ch 位置
	 */
	private int getPosition(char ch) {
		for (int i = 0; i < mVexs.length; i++) 
			if (mVexs[i] == ch) 
				return i;
		return -1;
	}
	
	/*
	 * 深度优先搜索遍历图的递归实现
	 */
	private void DFS() {
		boolean[] visited = new boolean[mVexs.length];
		
		//初始化所有顶点都没有被访问
		for (int i = 0; i < mVexs.length; i++) 
			visited[i] = false;
		
		System.out.printf("DFS:");
		for (int i = 0; i < mVexs.length; i++) {
			if (!visited[i]) {
				DFS(i, visited);
			}
		}
		System.out.printf("\n");
	}
	
	/*
	 * 深度优先搜索遍历图的递归实现
	 */
	private void DFS(int i, boolean[] visited) {
		
		visited[i] = true;
		System.out.printf("%c ", mVexs[i]);
		// 遍历该顶点的所有邻接顶点。若是没有访问过，则继续往下走
		for(int w = firstVertex(i); w >= 0; w = nextVertex(i, w)) {
			if (!visited[w]) {
				DFS(w, visited);
			}
		}
	}
	
	/*
	 * 返回顶点v的第一个邻接顶点的索引，失败则返回-1
	 */
	private int firstVertex(int v) {
		
		if (v < 0 || v > (mVexs.length -1 )) {
			return -1;
		}
		
		for (int i = 0; i < mVexs.length; i++) 
			if (mMatrix[v][i] != 0 && mMatrix[v][i] != INF) {
				return i;
			}
		return -1;
	}
	
	/*
	 * 反对顶点v相对于w的下一个邻接顶点的索引，失败则返回-1
	 */
	private int nextVertex(int v, int w) {
		
		if (v<0 || v>(mVexs.length-1) || w<0 || w>(mVexs.length-1))
            return -1;
		
		for (int i = w + 1; i < mVexs.length; i++) 
			if (mMatrix[v][i] != 0 && mMatrix[v][i] != INF) {
				return i;
			}
		return -1;
	}
	
	public static void main(String[] args) {
        char[] vexs = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        int matrix[][] = {
                 /*A*//*B*//*C*//*D*//*E*//*F*//*G*/
          /*A*/ {   0,  12, INF, INF, INF,  16,  14},
          /*B*/ {  12,   0,  10, INF, INF,   7, INF},
          /*C*/ { INF,  10,   0,   3,   5,   6, INF},
          /*D*/ { INF, INF,   3,   0,   4, INF, INF},
          /*E*/ { INF, INF,   5,   4,   0,   2,   8},
          /*F*/ {  16,   7,   6, INF,   2,   0,   9},
          /*G*/ {  14, INF, INF, INF,   8,   9,   0}};
        MatrixUDG pG;

        // 自定义"图"(输入矩阵队列)
        //pG = new MatrixUDG();
        // 采用已有的"图"
        pG = new MatrixUDG(vexs, matrix);

        //pG.print();   // 打印图
        pG.DFS();     // 深度优先遍历
        //pG.BFS();     // 广度优先遍历
        //pG.prim(0);   // prim算法生成最小生成树
        //pG.kruskal(); // Kruskal算法生成最小生成树

        int[] prev = new int[pG.mVexs.length];
        int[] dist = new int[pG.mVexs.length];
        // dijkstra算法获取"第4个顶点"到其它各个顶点的最短距离
        //pG.dijkstra(3, prev, dist);

//        int[][] path = new int[pG.mVexs.length][pG.mVexs.length];
//        int[][] floy = new int[pG.mVexs.length][pG.mVexs.length];
//        // floyd算法获取各个顶点之间的最短距离
//        pG.floyd(path, floy);
    }
}
