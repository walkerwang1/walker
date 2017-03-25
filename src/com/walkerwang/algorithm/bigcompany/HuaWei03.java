package com.walkerwang.algorithm.bigcompany;

import java.util.Scanner;

public class HuaWei03 {

	public static final boolean UNDIRECTED_GRAPH = false;//无向图标志  
    public static final boolean DIRECTED_GRAPH = true;//有向图标志  
  
    public static final boolean ADJACENCY_MATRIX = true;//邻接矩阵实现  
    public static final boolean ADJACENCY_LIST = false;//邻接表实现  
  
    public static final int MAX_VALUE = Integer.MAX_VALUE;  
    private boolean graphType;  
    private boolean method;  
    private static int vertexSize;  
    private int matrixMaxVertex;  
  
    //存储所有顶点信息的一维数组  
    private Object[] vertexesArray;  
    //存储图中顶点之间关联关系的二维数组,及边的关系  
    private static int[][] edgesMatrix;  
  
    // 记录第i个节点是否被访问过  
    private boolean[] visited; 	
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNextLine()) {
			String op = in.nextLine();
			if (op.length() > 50) {
				return;
			}
		}
		
		int[][] data = {{}, {}, {}, {}, {}, {} };
	}
	
	   public static void shortestPath_FLOYD() {
	        int n = vertexSize;
	        int[][] D = new int[n][n];//保存从i到j的最小路径值
	        int[][] p = new int[n][n];//保存经过的中间节点
	        for (int i = 0; i < n; i++) {//初始化D，p
	            for (int j = 0; j < n; j++) {
	                if (edgesMatrix[i][j] < Integer.MAX_VALUE) {

	                    p[i][j] = j;
	                } else {
	                    p[i][j] = -1;
	                }
	                D[i][j] = edgesMatrix[i][j];
	            }
	        }

	        for (int x = 0; x < n; x++) {//进行Floyd算法，从0到n-1所有可能进行遍历
	            for (int i = 0; i < n; i++) {
	                for (int j = 0; j < n; j++) {
	                    if (D[i][j] > D[i][x] + D[x][j]) {
	                        D[i][j] = D[i][x] + D[x][j];
	                        p[i][j] = p[i][x];
	                    }
	                }
	            }
	        }
	        // 下面对获得的结果进行展示
	        for (int i = 0; i < n; i++) {
	            for (int j = 0; j < n; j++) {
	                System.out.print(" " + D[i][j]);
	            }
	            System.out.println();
	        }
	        System.out.println("++++++++++++++++++++++++++++++++++++");
	        for (int i = 0; i < n; i++) {
	            for (int j = 0; j < n; j++) {
	                System.out.print(" " + p[i][j]);
	            }
	            System.out.println();
	        }
	        System.out.println("+++++++++++++++++++++++++++++++++++");
	        for (int i = 0; i < n; i++) {
	            for (int j = 0; j < n; j++) {
	                System.out.println("输出i=" + i + "到j=" + j + "最短路径：");
	                int k = p[i][j];
	                if (k == -1) {
	                    System.out.println("没有最短路径");
	                } else {
	                    System.out.print(" " + k);
	                    while (k != j) {
	                        k = p[k][j];
	                        System.out.print(" " + k);
	                    }
//	                  System.out.println(" "+k);
	                    System.out.println();
	                }
	            }
	        }
	    }

}
