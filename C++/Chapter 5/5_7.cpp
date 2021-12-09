#include <iostream>

using namespace std;

int main() {

    int n, s=0;

    cout <<"Input n= "; cin >>n;
    for (int i=0; i<=n; i+=2) {
        s+=i; 
    }
    cout <<"The result is " <<s;
    return 0;
}