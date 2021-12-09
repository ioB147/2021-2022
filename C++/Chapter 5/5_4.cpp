#include <iostream>

using namespace std;

int main() {

    int n, s=0;

    cout <<"Input a positive integer n: "; cin >>n;

    for (int i=1; i<=n; i++) {
        s+=i*i;
    }
    cout <<"S= " <<s <<endl;

    return 0;
}