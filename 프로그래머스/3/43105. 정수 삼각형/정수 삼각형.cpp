
#include <iostream>
#include <string>
#include <vector>

using namespace std;

int solution(vector<vector<int>> triangle) {
    int answer = 0;
    
    vector<vector<int>> dp(triangle.size(), vector<int>(triangle.size()));
    
    dp[0][0] = triangle[0][0];
    
    for(int i = 1; i < triangle.size(); i++)
    {
        for(int j = 0; j < triangle[i].size(); j++) 
        {
            dp[i][j] = max(triangle[i][j] + dp[i - 1][j], triangle[i][j] + dp[i - 1][j - 1]);
        }
    }
    
    for(int i = 0; i < triangle[triangle.size() - 1].size(); i++)
    {
        answer = max(answer , dp[triangle.size() - 1][i]);
    }
    
    return answer;
}