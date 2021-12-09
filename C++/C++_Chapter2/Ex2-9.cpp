#include <iostream>

using namespace std;

int main() {
    int a,b;
    cout << "Input two angles of the triangle: ";
    cin >> a >> b;
    cout << "The third angle is: ";
    cout << 180 - a - b;
    return 0;
}