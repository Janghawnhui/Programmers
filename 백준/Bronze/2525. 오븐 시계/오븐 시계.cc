#include <iostream>

using namespace std;

int main() {
	int Hour, Min, Timer;
	cin >> Hour >> Min >> Timer;
	Min += Timer;
	Hour += Min / 60;
	Min = Min % 60;

	Hour = Hour % 24;

	cout << Hour << " " << Min << endl;
	return 0;
}