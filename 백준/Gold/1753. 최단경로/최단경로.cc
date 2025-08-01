#include <iostream>
#include <vector>
#include <algorithm>
#include <queue>

using namespace std;

struct edge {
	int u;
	int w;

	bool operator<(const edge& e) const {
		return  w > e.w;
	}
};

int main()
{
	int V, E; cin >> V >> E;
	int K;	cin >> K;

	vector<edge> graph[20001];
	vector<int> visted(20001, 987654321);

	priority_queue<edge> pq;

	for (int i = 0; i < E; i++)
	{
		int u, v, w;	cin >> u >> v >> w;

		graph[u].push_back({ v,w });
	}

	visted[K] = 0;
	pq.push({ K, 0 });

	while (!pq.empty()) {
		int curr = pq.top().u;
		int cost = pq.top().w;
		pq.pop();

		for (auto& next : graph[curr]) {
			if (visted[next.u] > cost + next.w) {
				visted[next.u] = cost + next.w;

				pq.push({ next.u, visted[next.u]});
			}
		}
	}

	for (int idx = 1; idx <= V; idx++)
	{
		if (visted[idx] == 987654321) cout << "INF\n";
		else cout << visted[idx] << "\n";
	}
}