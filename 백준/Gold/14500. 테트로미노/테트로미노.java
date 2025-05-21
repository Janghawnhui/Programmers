import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] Copy_arr = new int[m][n];
        int[][] Copy_arr2 = new int[n][m];
        int[][] Copy_arr3 = new int[m][n];
        int[][] test = new int [n][m];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                test[i][j] = sc.nextInt();
            }
        }
        int max = 0; //가장 최적의 가로로 긴 1자 테트로미노
        //가로 1자 맥스 구하는 테트로미노
        for (int i = 0; i < test.length; i++) {
            for (int j = 0; j < test[i].length - 3; j++) {
                if (max < test[i][j] + test[i][j + 1] + test[i][j + 2] + test[i][j + 3]) {
                    max = test[i][j] + test[i][j + 1] + test[i][j + 2] + test[i][j + 3];
                }
            }
        }
        //첫번째 뒤집은거
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                Copy_arr[i][j] = test[j][m - i - 1];
            }
        }
//        세로 1자 구하는 맥스 테트르미노
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n - 3; j++) {
                if (max < Copy_arr[i][j] + Copy_arr[i][j + 1] + Copy_arr[i][j + 2] + Copy_arr[i][j + 3]) {
                    max = Copy_arr[i][j] + Copy_arr[i][j + 1] + Copy_arr[i][j + 2] + Copy_arr[i][j + 3];
                }
            }
        }

//네모 테트로미노
        for (int i = 0; i < test.length - 1; i++) {
            for (int j = 0; j < test[i].length - 1; j++) {
                if (max < test[i][j] + test[i + 1][j] + test[i][j + 1] + test[i + 1][j + 1]) {
                    max = test[i][j] + test[i + 1][j] + test[i][j + 1] + test[i + 1][j + 1];
                }
            }
        }
        //두번째 뒤집은거
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                Copy_arr2[i][j] = Copy_arr[j][n - i - 1];
            }
        }
////
        //세번째 뒤집은거
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                Copy_arr3[i][j] = Copy_arr2[j][m - i - 1];
            }
        }
        for (int i = 0; i < m - 2; i++) {
            for (int j = 0; j < n - 1; j++) {
                if (max < Copy_arr[i][j] + Copy_arr[i + 1][j] + Copy_arr[i + 2][j] + Copy_arr[i + 2][j + 1]) {
                    max = Copy_arr[i][j] + Copy_arr[i + 1][j] + Copy_arr[i + 2][j] + Copy_arr[i + 2][j + 1];
                } else if (max < Copy_arr3[i][j] + Copy_arr3[i + 1][j] + Copy_arr3[i + 2][j] + Copy_arr3[i + 2][j + 1]) {
                    max = Copy_arr3[i][j] + Copy_arr3[i + 1][j] + Copy_arr3[i + 2][j] + Copy_arr3[i + 2][j + 1];
                } else if (max < Copy_arr[i][j + 1] + Copy_arr[i + 1][j + 1] + Copy_arr[i + 2][j + 1] + Copy_arr[i + 2][j]) {
                    max = Copy_arr[i][j + 1] + Copy_arr[i + 1][j + 1] + Copy_arr[i + 2][j + 1] + Copy_arr[i + 2][j];
                } else if (max < Copy_arr3[i][j + 1] + Copy_arr3[i + 1][j + 1] + Copy_arr3[i + 2][j + 1] + Copy_arr3[i + 2][j]) {
                    max = Copy_arr3[i][j + 1] + Copy_arr3[i + 1][j + 1] + Copy_arr3[i + 2][j + 1] + Copy_arr3[i + 2][j];
                    //번개모양 테트로미노
                } else if (max < Copy_arr[i][j + 1] + Copy_arr[i + 1][j] + Copy_arr[i + 1][j + 1] + Copy_arr[i + 2][j]) {
                    max = Copy_arr[i][j + 1] + Copy_arr[i + 1][j] + Copy_arr[i + 1][j + 1] + Copy_arr[i + 2][j];
                } else if (max < Copy_arr3[i][j + 1] + Copy_arr3[i + 1][j] + Copy_arr3[i + 1][j + 1] + Copy_arr3[i + 2][j]) {
                    max = Copy_arr3[i][j + 1] + Copy_arr3[i + 1][j] + Copy_arr3[i + 1][j + 1] + Copy_arr3[i + 2][j];
                    //거꾸로 번개모양 테트로미노
                } else if (max < Copy_arr[i][j] + Copy_arr[i + 1][j] + Copy_arr[i + 1][j + 1] + Copy_arr[i + 2][j + 1]) {
                    max = Copy_arr[i][j] + Copy_arr[i + 1][j] + Copy_arr[i + 1][j + 1] + Copy_arr[i + 2][j + 1];
                } else if (max < Copy_arr3[i][j] + Copy_arr3[i + 1][j] + Copy_arr3[i + 1][j + 1] + Copy_arr3[i + 2][j + 1]) {
                    max = Copy_arr3[i][j] + Copy_arr3[i + 1][j] + Copy_arr3[i + 1][j + 1] + Copy_arr3[i + 2][j + 1];
                }
            }
        }
        for (int i = 0; i < test.length - 2; i++) {
            for (int j = 0; j < test[i].length - 1; j++) {
                //ㄴ 테트로미노
                if (max < test[i][j] + test[i + 1][j] + test[i + 2][j] + test[i + 2][j + 1]) {
                    max = test[i][j] + test[i + 1][j] + test[i + 2][j] + test[i + 2][j + 1];
                } else if (max < Copy_arr2[i][j] + Copy_arr2[i + 1][j] + Copy_arr2[i + 2][j] + Copy_arr2[i + 2][j + 1]) {
                    max = Copy_arr2[i][j] + Copy_arr2[i + 1][j] + Copy_arr2[i + 2][j] + Copy_arr2[i + 2][j + 1];
                }
                //거꾸로 ㄴ 테트로미노
                else if (max < test[i][j + 1] + test[i + 1][j + 1] + test[i + 2][j + 1] + test[i + 2][j]) {
                    max = test[i][j + 1] + test[i + 1][j + 1] + test[i + 2][j + 1] + test[i + 2][j];
                } else if (max < Copy_arr2[i][j + 1] + Copy_arr2[i + 1][j + 1] + Copy_arr2[i + 2][j + 1] + Copy_arr2[i + 2][j]) {
                    max = Copy_arr2[i][j + 1] + Copy_arr2[i + 1][j + 1] + Copy_arr2[i + 2][j + 1] + Copy_arr2[i + 2][j];
                } else if (max < test[i][j + 1] + test[i + 1][j] + test[i + 1][j + 1] + test[i + 2][j]) {
                    max = test[i][j + 1] + test[i + 1][j] + test[i + 1][j + 1] + test[i + 2][j];
                } else if (max < Copy_arr2[i][j + 1] + Copy_arr2[i + 1][j] + Copy_arr2[i + 1][j + 1] + Copy_arr2[i + 2][j]) {
                    max = Copy_arr2[i][j + 1] + Copy_arr2[i + 1][j] + Copy_arr2[i + 1][j + 1] + Copy_arr2[i + 2][j];
                } else if (max < test[i][j] + test[i + 1][j] + test[i + 1][j + 1] + test[i + 2][j + 1]) {
                    max = test[i][j] + test[i + 1][j] + test[i + 1][j + 1] + test[i + 2][j + 1];
                } else if (max < Copy_arr2[i][j] + Copy_arr2[i + 1][j] + Copy_arr2[i + 1][j + 1] + Copy_arr2[i + 2][j + 1]) {
                    max = Copy_arr2[i][j] + Copy_arr2[i + 1][j] + Copy_arr2[i + 1][j + 1] + Copy_arr2[i + 2][j + 1];
                }
            }
        }//for 끝나는 괄호

        for (int i = 0; i < m - 1; i++) {
            for (int j = 0; j < n - 2; j++) {
                if (max < Copy_arr[i][j] + Copy_arr[i][j + 1] + Copy_arr[i][j + 2] + Copy_arr[i + 1][j + 1]) {
                    max = Copy_arr[i][j] + Copy_arr[i][j + 1] + Copy_arr[i][j + 2] + Copy_arr[i + 1][j + 1];
                } else if (max < Copy_arr3[i][j] + Copy_arr3[i][j + 1] + Copy_arr3[i][j + 2] + Copy_arr3[i + 1][j + 1]) {
                    max = Copy_arr3[i][j] + Copy_arr3[i][j + 1] + Copy_arr3[i][j + 2] + Copy_arr3[i + 1][j + 1];
                    //ㅗ 테트로미노
                } else if (max < Copy_arr[i][j + 1] + Copy_arr[i + 1][j] + Copy_arr[i + 1][j + 1] + Copy_arr[i + 1][j + 2]) {
                    max = Copy_arr[i][j + 1] + Copy_arr[i + 1][j] + Copy_arr[i + 1][j + 1] + Copy_arr[i + 1][j + 2];
                } else if (max < Copy_arr3[i][j + 1] + Copy_arr3[i + 1][j] + Copy_arr3[i + 1][j + 1] + Copy_arr3[i + 1][j + 2]) {
                    max = Copy_arr3[i][j + 1] + Copy_arr3[i + 1][j] + Copy_arr3[i + 1][j + 1] + Copy_arr3[i + 1][j + 2];
                }
            }
        }
        for (int i = 0; i < test.length - 1; i++) {
            for (int j = 0; j < test[i].length - 2; j++) {
                //ㅜ 테트로미노
                if (max < test[i][j] + test[i][j + 1] + test[i][j + 2] + test[i + 1][j + 1]) {
                    max = test[i][j] + test[i][j + 1] + test[i][j + 2] + test[i + 1][j + 1];
                } else if (max < Copy_arr2[i][j] + Copy_arr2[i][j + 1] + Copy_arr2[i][j + 2] + Copy_arr2[i + 1][j + 1]) {
                    max = Copy_arr2[i][j] + Copy_arr2[i][j + 1] + Copy_arr2[i][j + 2] + Copy_arr2[i + 1][j + 1];
                } else if (max < test[i][j + 1] + test[i + 1][j] + test[i + 1][j + 1] + test[i + 1][j + 2]) {
                    max = test[i][j + 1] + test[i + 1][j] + test[i + 1][j + 1] + test[i + 1][j + 2];
                } else if (max < Copy_arr2[i][j + 1] + Copy_arr2[i + 1][j] + Copy_arr2[i + 1][j + 1] + Copy_arr2[i + 1][j + 2]) {
                    max = Copy_arr2[i][j + 1] + Copy_arr2[i + 1][j] + Copy_arr2[i + 1][j + 1] + Copy_arr2[i + 1][j + 2];
                }
            }
        }
        System.out.println(max);

    }
}