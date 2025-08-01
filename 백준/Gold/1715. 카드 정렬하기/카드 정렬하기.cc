#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>

using namespace std;

struct cmp {
	bool operator() (int a, int b) {
		return a > b;
	}
};

int main()
{
	ios::sync_with_stdio(0);	cin.tie(0);	cout.tie(0);

	int n;	cin >> n;

	int answer = 0;
	priority_queue<int,vector<int>,cmp> pq;

	for (int i = 0; i < n; i++)
	{
		int num;	cin >> num;
		pq.push(num);
	}

	while(pq.size() > 1)
	{
		int sum = pq.top();
		pq.pop();
		sum += pq.top();
		pq.pop();
		pq.push(sum);
		answer += sum;
	}

	cout << answer;

	return 0;
}
